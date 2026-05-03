package com.segment.analytics.kotlin.core.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: Base64Utils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ALPHABET", "", "encodeToBase64", "bytes", "", "str", "base64Val", "", "", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Base64Utils {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    private static final char base64Val(int i) {
        return ALPHABET.charAt(i);
    }

    public static final String encodeToBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return encodeToBase64(bytes);
    }

    public static final String encodeToBase64(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[3];
        int i = 0;
        while (i < bytes.length) {
            int length = bytes.length - i;
            if (length >= 3) {
                length = 3;
            }
            int i2 = 0;
            while (i2 < length) {
                bArr[i2] = bytes[i];
                i2++;
                i++;
            }
            if (length <= 2) {
                int i3 = 2;
                while (true) {
                    bArr[i3] = 0;
                    if (i3 == length) {
                        break;
                    }
                    i3--;
                }
            }
            int i4 = (bArr[2] & 255) | ((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8);
            int i5 = ((3 - length) * 8) / 6;
            if (i5 <= 3) {
                int i6 = 3;
                while (true) {
                    sb.append(base64Val((i4 >> (i6 * 6)) & 63));
                    if (i6 == i5) {
                        break;
                    }
                    i6--;
                }
            }
            for (int i7 = 0; i7 < i5; i7++) {
                sb.append("=");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
