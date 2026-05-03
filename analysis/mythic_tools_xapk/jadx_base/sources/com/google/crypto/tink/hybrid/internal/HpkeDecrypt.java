package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.proto.HpkePrivateKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
final class HpkeDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final int encapsulatedKeyLength;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final HpkeKemPrivateKey recipientPrivateKey;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.HpkeDecrypt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[com.google.crypto.tink.proto.HpkeKem.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[com.google.crypto.tink.proto.HpkeKem.DHKEM_X25519_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private HpkeDecrypt(HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, int i) {
        this.recipientPrivateKey = hpkeKemPrivateKey;
        this.kem = hpkeKem;
        this.kdf = hpkeKdf;
        this.aead = hpkeAead;
        this.encapsulatedKeyLength = i;
    }

    static HpkeDecrypt createHpkeDecrypt(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        if (!hpkePrivateKey.hasPublicKey()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        }
        if (!hpkePrivateKey.getPublicKey().hasParams()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        if (hpkePrivateKey.getPrivateKey().isEmpty()) {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
        HpkeParams params = hpkePrivateKey.getPublicKey().getParams();
        return new HpkeDecrypt(HpkeKemKeyFactory.createPrivate(hpkePrivateKey), HpkePrimitiveFactory.createKem(params), HpkePrimitiveFactory.createKdf(params), HpkePrimitiveFactory.createAead(params), encodingSizeInBytes(params.getKem()));
    }

    private static int encodingSizeInBytes(com.google.crypto.tink.proto.HpkeKem hpkeKem) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[hpkeKem.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 65;
        }
        if (i == 3) {
            return 97;
        }
        if (i == 4) {
            return Imgproc.COLOR_RGBA2YUV_YV12;
        }
        throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + hpkeKem.name());
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.encapsulatedKeyLength;
        if (length < i) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        return HpkeContext.createRecipientContext(bArrCopyOf, this.recipientPrivateKey, this.kem, this.kdf, this.aead, bArr3).open(Arrays.copyOfRange(bArr, this.encapsulatedKeyLength, bArr.length), EMPTY_ASSOCIATED_DATA);
    }
}
