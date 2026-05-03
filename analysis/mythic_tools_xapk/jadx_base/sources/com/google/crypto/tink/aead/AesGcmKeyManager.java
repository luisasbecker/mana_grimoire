package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class AesGcmKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.AesGcmKey> {
    AesGcmKeyManager() {
        super(com.google.crypto.tink.proto.AesGcmKey.class, new PrimitiveFactory<Aead, com.google.crypto.tink.proto.AesGcmKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesGcmKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Aead getPrimitive(com.google.crypto.tink.proto.AesGcmKey aesGcmKey) throws GeneralSecurityException {
                return new AesGcmJce(aesGcmKey.getKeyValue().toByteArray());
            }
        });
    }

    public static final KeyTemplate aes128GcmTemplate() {
        return createKeyTemplate(16, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate aes256GcmTemplate() {
        return createKeyTemplate(32, KeyTemplate.OutputPrefixType.TINK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<AesGcmKeyFormat> createKeyFormat(int i, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>((AesGcmKeyFormat) AesGcmKeyFormat.newBuilder().setKeySize(i).build(), outputPrefixType);
    }

    private static KeyTemplate createKeyTemplate(int i, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new AesGcmKeyManager().getKeyType(), ((AesGcmKeyFormat) AesGcmKeyFormat.newBuilder().setKeySize(i).build()).toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate rawAes128GcmTemplate() {
        return createKeyTemplate(16, KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate rawAes256GcmTemplate() {
        return createKeyTemplate(32, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesGcmKeyManager(), z);
        AesGcmProtoSerialization.register();
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<AesGcmKeyFormat, com.google.crypto.tink.proto.AesGcmKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesGcmKeyFormat, com.google.crypto.tink.proto.AesGcmKey>(AesGcmKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesGcmKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.AesGcmKey createKey(AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
                return (com.google.crypto.tink.proto.AesGcmKey) com.google.crypto.tink.proto.AesGcmKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesGcmKeyFormat.getKeySize()))).setVersion(AesGcmKeyManager.this.getVersion()).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.AesGcmKey deriveKey(AesGcmKeyFormat aesGcmKeyFormat, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(aesGcmKeyFormat.getVersion(), AesGcmKeyManager.this.getVersion());
                byte[] bArr = new byte[aesGcmKeyFormat.getKeySize()];
                try {
                    readFully(inputStream, bArr);
                    return (com.google.crypto.tink.proto.AesGcmKey) com.google.crypto.tink.proto.AesGcmKey.newBuilder().setKeyValue(ByteString.copyFrom(bArr)).setVersion(AesGcmKeyManager.this.getVersion()).build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesGcmKeyFormat>> keyFormats() throws GeneralSecurityException {
                HashMap map = new HashMap();
                map.put("AES128_GCM", AesGcmKeyManager.createKeyFormat(16, KeyTemplate.OutputPrefixType.TINK));
                map.put("AES128_GCM_RAW", AesGcmKeyManager.createKeyFormat(16, KeyTemplate.OutputPrefixType.RAW));
                map.put("AES256_GCM", AesGcmKeyManager.createKeyFormat(32, KeyTemplate.OutputPrefixType.TINK));
                map.put("AES256_GCM_RAW", AesGcmKeyManager.createKeyFormat(32, KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesGcmKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
                Validators.validateAesKeySize(aesGcmKeyFormat.getKeySize());
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public com.google.crypto.tink.proto.AesGcmKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return com.google.crypto.tink.proto.AesGcmKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(com.google.crypto.tink.proto.AesGcmKey aesGcmKey) throws GeneralSecurityException {
        Validators.validateVersion(aesGcmKey.getVersion(), getVersion());
        Validators.validateAesKeySize(aesGcmKey.getKeyValue().size());
    }
}
