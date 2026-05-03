package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private static final String ASN_PREFIX_SHA256 = "3031300d060960864801650304020105000420";
    private static final String ASN_PREFIX_SHA384 = "3041300d060960864801650304020205000430";
    private static final String ASN_PREFIX_SHA512 = "3051300d060960864801650304020305000440";
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final Enums.HashType hash;
    private final RSAPublicKey publicKey;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RsaSsaPkcs1VerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA-PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.hash = hashType;
    }

    private byte[] emsaPkcs1(byte[] bArr, int i, Enums.HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.hash));
        engineFactory.update(bArr);
        byte[] bArrDigest = engineFactory.digest();
        byte[] asnPrefix = toAsnPrefix(hashType);
        if (i < asnPrefix.length + bArrDigest.length + 11) {
            throw new GeneralSecurityException("intended encoded message length too short");
        }
        byte[] bArr2 = new byte[i];
        bArr2[0] = 0;
        bArr2[1] = 1;
        int i2 = 2;
        int i3 = 0;
        while (i3 < (i - r9) - 3) {
            bArr2[i2] = -1;
            i3++;
            i2++;
        }
        int i4 = i2 + 1;
        bArr2[i2] = 0;
        System.arraycopy(asnPrefix, 0, bArr2, i4, asnPrefix.length);
        System.arraycopy(bArrDigest, 0, bArr2, i4 + asnPrefix.length, bArrDigest.length);
        return bArr2;
    }

    private byte[] toAsnPrefix(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return Hex.decode(ASN_PREFIX_SHA256);
        }
        if (i == 2) {
            return Hex.decode(ASN_PREFIX_SHA384);
        }
        if (i == 3) {
            return Hex.decode(ASN_PREFIX_SHA512);
        }
        throw new GeneralSecurityException("Unsupported hash " + hashType);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        if (iBitLength != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(bArr);
        if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        if (!Bytes.equal(SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength), emsaPkcs1(bArr2, iBitLength, this.hash))) {
            throw new GeneralSecurityException("invalid signature");
        }
    }
}
