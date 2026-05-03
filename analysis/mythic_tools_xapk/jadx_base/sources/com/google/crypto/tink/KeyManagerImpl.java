package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {
    private final KeyTypeManager<KeyProtoT> keyTypeManager;
    private final Class<PrimitiveT> primitiveClass;

    private static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory;

        KeyFactoryHelper(KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) {
            this.keyFactory = keyFactory;
        }

        private KeyProtoT validateCreate(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException {
            this.keyFactory.validateKeyFormat(keyformatprotot);
            return (KeyProtoT) this.keyFactory.createKey(keyformatprotot);
        }

        KeyProtoT castValidateCreate(MessageLite messageLite) throws GeneralSecurityException {
            return (KeyProtoT) validateCreate((MessageLite) KeyManagerImpl.castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyFactory.getKeyFormatClass().getName(), this.keyFactory.getKeyFormatClass()));
        }

        KeyProtoT parseValidateCreate(ByteString byteString) throws InvalidProtocolBufferException, GeneralSecurityException {
            return (KeyProtoT) validateCreate(this.keyFactory.parseKeyFormat(byteString));
        }
    }

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager, Class<PrimitiveT> cls) {
        if (!keyTypeManager.supportedPrimitives().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", keyTypeManager.toString(), cls.getName()));
        }
        this.keyTypeManager = keyTypeManager;
        this.primitiveClass = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <CastedT> CastedT castOrThrowSecurityException(Object obj, String str, Class<CastedT> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    private KeyFactoryHelper<?, KeyProtoT> keyFactoryHelper() {
        return new KeyFactoryHelper<>(this.keyTypeManager.keyFactory());
    }

    private PrimitiveT validateKeyAndGetPrimitive(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.primitiveClass)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.keyTypeManager.validateKey(keyprotot);
        return (PrimitiveT) this.keyTypeManager.getPrimitive(keyprotot, this.primitiveClass);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final boolean doesSupport(String str) {
        return str.equals(getKeyType());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String getKeyType() {
        return this.keyTypeManager.getKeyType();
    }

    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return validateKeyAndGetPrimitive(this.keyTypeManager.parseKey(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.getKeyClass().getName(), e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        return validateKeyAndGetPrimitive((MessageLite) castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyTypeManager.getKeyClass().getName(), this.keyTypeManager.getKeyClass()));
    }

    @Override // com.google.crypto.tink.KeyManager
    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.primitiveClass;
    }

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        return this.keyTypeManager.getVersion();
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return keyFactoryHelper().parseValidateCreate(byteString);
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.keyFactory().getKeyFormatClass().getName(), e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        return keyFactoryHelper().castValidateCreate(messageLite);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl(getKeyType()).setValue(keyFactoryHelper().parseValidateCreate(byteString).toByteString()).setKeyMaterialType(this.keyTypeManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
