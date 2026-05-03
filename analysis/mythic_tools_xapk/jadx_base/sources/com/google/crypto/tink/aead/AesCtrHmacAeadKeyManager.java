package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.mac.HmacKeyManager;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class AesCtrHmacAeadKeyManager extends KeyTypeManager<AesCtrHmacAeadKey> {
    AesCtrHmacAeadKeyManager() {
        super(AesCtrHmacAeadKey.class, new PrimitiveFactory<Aead, AesCtrHmacAeadKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Aead getPrimitive(AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
                return new EncryptThenAuthenticate((IndCpaCipher) new AesCtrKeyManager().getPrimitive(aesCtrHmacAeadKey.getAesCtrKey(), IndCpaCipher.class), (Mac) new HmacKeyManager().getPrimitive(aesCtrHmacAeadKey.getHmacKey(), Mac.class), aesCtrHmacAeadKey.getHmacKey().getParams().getTagSize());
            }
        });
    }

    public static final KeyTemplate aes128CtrHmacSha256Template() {
        return createKeyTemplate(16, 16, 32, 16, HashType.SHA256);
    }

    public static final KeyTemplate aes256CtrHmacSha256Template() {
        return createKeyTemplate(32, 16, 32, 32, HashType.SHA256);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<AesCtrHmacAeadKeyFormat> createKeyFormat(int i, int i2, int i3, int i4, HashType hashType, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(createKeyFormat(i, i2, i3, i4, hashType), outputPrefixType);
    }

    private static AesCtrHmacAeadKeyFormat createKeyFormat(int i, int i2, int i3, int i4, HashType hashType) {
        AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) AesCtrKeyFormat.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(i2).build()).setKeySize(i).build();
        return (AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat(aesCtrKeyFormat).setHmacKeyFormat((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(i4).build()).setKeySize(i3).build()).build();
    }

    private static KeyTemplate createKeyTemplate(int i, int i2, int i3, int i4, HashType hashType) {
        return KeyTemplate.create(new AesCtrHmacAeadKeyManager().getKeyType(), createKeyFormat(i, i2, i3, i4, hashType).toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCtrHmacAeadKeyManager(), z);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey>(AesCtrHmacAeadKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesCtrHmacAeadKey createKey(AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
                AesCtrKey aesCtrKey = (AesCtrKey) new AesCtrKeyManager().keyFactory().createKey(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat());
                return (AesCtrHmacAeadKey) AesCtrHmacAeadKey.newBuilder().setAesCtrKey(aesCtrKey).setHmacKey((HmacKey) new HmacKeyManager().keyFactory().createKey(aesCtrHmacAeadKeyFormat.getHmacKeyFormat())).setVersion(AesCtrHmacAeadKeyManager.this.getVersion()).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesCtrHmacAeadKeyFormat>> keyFormats() throws GeneralSecurityException {
                HashMap map = new HashMap();
                map.put("AES128_CTR_HMAC_SHA256", AesCtrHmacAeadKeyManager.createKeyFormat(16, 16, 32, 16, HashType.SHA256, KeyTemplate.OutputPrefixType.TINK));
                map.put("AES128_CTR_HMAC_SHA256_RAW", AesCtrHmacAeadKeyManager.createKeyFormat(16, 16, 32, 16, HashType.SHA256, KeyTemplate.OutputPrefixType.RAW));
                map.put("AES256_CTR_HMAC_SHA256", AesCtrHmacAeadKeyManager.createKeyFormat(32, 16, 32, 32, HashType.SHA256, KeyTemplate.OutputPrefixType.TINK));
                map.put("AES256_CTR_HMAC_SHA256_RAW", AesCtrHmacAeadKeyManager.createKeyFormat(32, 16, 32, 32, HashType.SHA256, KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesCtrHmacAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
                new AesCtrKeyManager().keyFactory().validateKeyFormat(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat());
                new HmacKeyManager().keyFactory().validateKeyFormat(aesCtrHmacAeadKeyFormat.getHmacKeyFormat());
                Validators.validateAesKeySize(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat().getKeySize());
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public AesCtrHmacAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrHmacAeadKey.getVersion(), getVersion());
        new AesCtrKeyManager().validateKey(aesCtrHmacAeadKey.getAesCtrKey());
        new HmacKeyManager().validateKey(aesCtrHmacAeadKey.getHmacKey());
    }
}
