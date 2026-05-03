package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPrivateCrtKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPrivateCrtKey.getPublicExponent());
        this.privateKey = rSAPrivateCrtKey;
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
        this.sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i;
    }

    private byte[] emsaPssEncode(byte[] bArr, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(bArr);
        int digestLength = engineFactory.getDigestLength();
        int i2 = ((i - 1) / 8) + 1;
        int i3 = this.saltLength;
        if (i2 < digestLength + i3 + 2) {
            throw new GeneralSecurityException("encoding error");
        }
        byte[] bArrRandBytes = Random.randBytes(i3);
        int i4 = digestLength + 8;
        byte[] bArr2 = new byte[this.saltLength + i4];
        System.arraycopy(bArrDigest, 0, bArr2, 8, digestLength);
        System.arraycopy(bArrRandBytes, 0, bArr2, i4, bArrRandBytes.length);
        byte[] bArrDigest2 = engineFactory.digest(bArr2);
        int i5 = (i2 - digestLength) - 1;
        byte[] bArr3 = new byte[i5];
        int i6 = this.saltLength;
        bArr3[((i2 - i6) - digestLength) - 2] = 1;
        System.arraycopy(bArrRandBytes, 0, bArr3, ((i2 - i6) - digestLength) - 1, bArrRandBytes.length);
        byte[] bArrMgf1 = SubtleUtil.mgf1(bArrDigest2, i5, this.mgf1Hash);
        byte[] bArr4 = new byte[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            bArr4[i7] = (byte) (bArr3[i7] ^ bArrMgf1[i7]);
        }
        for (int i8 = 0; i8 < (((long) i2) * 8) - ((long) i); i8++) {
            int i9 = i8 / 8;
            bArr4[i9] = (byte) ((~(1 << (7 - (i8 % 8)))) & bArr4[i9]);
        }
        int i10 = digestLength + i5;
        byte[] bArr5 = new byte[i10 + 1];
        System.arraycopy(bArr4, 0, bArr5, 0, i5);
        System.arraycopy(bArrDigest2, 0, bArr5, i5, bArrDigest2.length);
        bArr5[i10] = -68;
        return bArr5;
    }

    private byte[] rsasp1(byte[] bArr) throws GeneralSecurityException {
        Cipher engineFactory = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        engineFactory.init(2, this.privateKey);
        byte[] bArrDoFinal = engineFactory.doFinal(bArr);
        Cipher engineFactory2 = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        engineFactory2.init(1, this.publicKey);
        if (new BigInteger(1, bArr).equals(new BigInteger(1, engineFactory2.doFinal(bArrDoFinal)))) {
            return bArrDoFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        return rsasp1(emsaPssEncode(bArr, this.publicKey.getModulus().bitLength() - 1));
    }
}
