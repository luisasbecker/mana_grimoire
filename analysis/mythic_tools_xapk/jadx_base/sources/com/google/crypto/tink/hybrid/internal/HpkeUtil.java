package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public final class HpkeUtil {
    public static final byte[] BASE_MODE = intToByteArray(1, 0);
    public static final byte[] X25519_HKDF_SHA256_KEM_ID = intToByteArray(2, 32);
    public static final byte[] P256_HKDF_SHA256_KEM_ID = intToByteArray(2, 16);
    public static final byte[] P384_HKDF_SHA384_KEM_ID = intToByteArray(2, 17);
    public static final byte[] P521_HKDF_SHA512_KEM_ID = intToByteArray(2, 18);
    public static final byte[] HKDF_SHA256_KDF_ID = intToByteArray(2, 1);
    public static final byte[] HKDF_SHA384_KDF_ID = intToByteArray(2, 2);
    public static final byte[] HKDF_SHA512_KDF_ID = intToByteArray(2, 3);
    public static final byte[] AES_128_GCM_AEAD_ID = intToByteArray(2, 1);
    public static final byte[] AES_256_GCM_AEAD_ID = intToByteArray(2, 2);
    public static final byte[] CHACHA20_POLY1305_AEAD_ID = intToByteArray(2, 3);
    public static final byte[] EMPTY_SALT = new byte[0];
    private static final byte[] KEM = "KEM".getBytes(Util.UTF_8);
    private static final byte[] HPKE = "HPKE".getBytes(Util.UTF_8);
    private static final byte[] HPKE_V1 = "HPKE-v1".getBytes(Util.UTF_8);

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.HpkeUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[com.google.crypto.tink.proto.HpkeKem.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private HpkeUtil() {
    }

    static byte[] hpkeSuiteId(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return Bytes.concat(HPKE, bArr, bArr2, bArr3);
    }

    public static byte[] intToByteArray(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    static byte[] kemSuiteId(byte[] bArr) throws GeneralSecurityException {
        return Bytes.concat(KEM, bArr);
    }

    static byte[] labelIkm(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return Bytes.concat(HPKE_V1, bArr2, str.getBytes(Util.UTF_8), bArr);
    }

    static byte[] labelInfo(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return Bytes.concat(intToByteArray(2, i), HPKE_V1, bArr2, str.getBytes(Util.UTF_8), bArr);
    }

    static EllipticCurves.CurveType nistHpkeKemToCurve(com.google.crypto.tink.proto.HpkeKem hpkeKem) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[hpkeKem.ordinal()];
        if (i == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    static void validateParams(HpkeParams hpkeParams) throws GeneralSecurityException {
        if (hpkeParams.getKem() == com.google.crypto.tink.proto.HpkeKem.KEM_UNKNOWN || hpkeParams.getKem() == com.google.crypto.tink.proto.HpkeKem.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KEM param: " + hpkeParams.getKem().name());
        }
        if (hpkeParams.getKdf() == com.google.crypto.tink.proto.HpkeKdf.KDF_UNKNOWN || hpkeParams.getKdf() == com.google.crypto.tink.proto.HpkeKdf.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KDF param: " + hpkeParams.getKdf().name());
        }
        if (hpkeParams.getAead() == com.google.crypto.tink.proto.HpkeAead.AEAD_UNKNOWN || hpkeParams.getAead() == com.google.crypto.tink.proto.HpkeAead.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid AEAD param: " + hpkeParams.getAead().name());
        }
    }
}
