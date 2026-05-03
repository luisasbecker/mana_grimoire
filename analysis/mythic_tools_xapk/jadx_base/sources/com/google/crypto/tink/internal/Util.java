package com.google.crypto.tink.internal;

import com.bumptech.glide.load.Key;
import com.google.crypto.tink.util.Bytes;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Util {
    public static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);

    private Util() {
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        if (isAndroid()) {
            return BuildDispatchedCode.getApiLevel();
        }
        return null;
    }

    public static boolean isAndroid() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    public static int randKeyId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & 127) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i;
    }

    private static final byte toByteFromPrintableAscii(char c) {
        if (c < '!' || c > '~') {
            throw new TinkBugException("Not a printable ASCII character: " + c);
        }
        return (byte) c;
    }

    public static final Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = toByteFromPrintableAscii(str.charAt(i));
        }
        return Bytes.copyFrom(bArr);
    }
}
