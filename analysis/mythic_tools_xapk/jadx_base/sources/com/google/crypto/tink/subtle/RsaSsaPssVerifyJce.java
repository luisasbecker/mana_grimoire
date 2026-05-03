package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i;
    }

    private void emsaPssVerify(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(bArr);
        int digestLength = engineFactory.getDigestLength();
        int length = bArr2.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        byte b = 1;
        if (bArr2[bArr2.length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i2 = (length - digestLength) - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, i2);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, bArrCopyOf.length, bArrCopyOf.length + digestLength);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            byte b2 = b;
            int i5 = i2;
            long j = (((long) length) * 8) - ((long) i);
            if (i3 < j) {
                if (((bArrCopyOf[i4 / 8] >> (7 - (i4 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i3 = i4 + 1;
                b = b2;
                i2 = i5;
            } else {
                byte[] bArrMgf1 = SubtleUtil.mgf1(bArrCopyOfRange, i5, this.mgf1Hash);
                int length2 = bArrMgf1.length;
                byte[] bArr3 = new byte[length2];
                for (int i6 = 0; i6 < length2; i6++) {
                    bArr3[i6] = (byte) (bArrMgf1[i6] ^ bArrCopyOf[i6]);
                }
                for (int i7 = 0; i7 <= j; i7++) {
                    int i8 = i7 / 8;
                    bArr3[i8] = (byte) ((~(b2 << (7 - (i7 % 8)))) & bArr3[i8]);
                }
                int i9 = 0;
                while (true) {
                    int i10 = this.saltLength;
                    if (i9 >= (r6 - i10) - 2) {
                        if (bArr3[(r6 - i10) - 2] != b2) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr3, length2 - i10, length2);
                        int i11 = digestLength + 8;
                        byte[] bArr4 = new byte[this.saltLength + i11];
                        System.arraycopy(bArrDigest, 0, bArr4, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr4, i11, bArrCopyOfRange2.length);
                        if (!Bytes.equal(engineFactory.digest(bArr4), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                    if (bArr3[i9] != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i9++;
                }
            }
        }
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        int iBitLength2 = (modulus.bitLength() + 6) / 8;
        if (iBitLength != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(bArr);
        if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        emsaPssVerify(bArr2, SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength2), modulus.bitLength() - 1);
    }
}
