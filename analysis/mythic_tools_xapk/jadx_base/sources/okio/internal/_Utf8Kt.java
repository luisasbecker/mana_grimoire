package okio.internal;

import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        char cCharAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = str.charAt(i2);
            if (Intrinsics.compare((int) cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i3 = i2;
                while (i2 < length2) {
                    char cCharAt3 = str.charAt(i2);
                    if (Intrinsics.compare((int) cCharAt3, 128) < 0) {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) cCharAt3;
                        i2++;
                        while (true) {
                            i3 = i4;
                            if (i2 >= length2 || Intrinsics.compare((int) str.charAt(i2), 128) >= 0) {
                                break;
                            }
                            i4 = i3 + 1;
                            bArr[i3] = (byte) str.charAt(i2);
                            i2++;
                        }
                    } else {
                        if (Intrinsics.compare((int) cCharAt3, 2048) < 0) {
                            bArr[i3] = (byte) ((cCharAt3 >> 6) | 192);
                            i3 += 2;
                            bArr[i3 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || cCharAt3 >= 57344) {
                            bArr[i3] = (byte) ((cCharAt3 >> '\f') | WebmConstants.MkvEbmlElement.VIDEO);
                            bArr[i3 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i3 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) cCharAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (cCharAt = str.charAt(i)) || cCharAt >= 57344) {
                            bArr[i3] = Utf8.REPLACEMENT_BYTE;
                            i2++;
                            i3++;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i)) - 56613888;
                            bArr[i3] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i3 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i3 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i3 += 4;
                            bArr[i3 + 3] = (byte) ((iCharAt & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i2] = (byte) cCharAt2;
            i2++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0068 A[PHI: r6
      0x0068: PHI (r6v12 int) = (r6v8 int), (r6v9 int), (r6v15 int), (r6v23 int), (r6v26 int), (r6v39 int), (r6v39 int) binds: [B:29:0x0060, B:28:0x0059, B:55:0x00c9, B:40:0x008f, B:91:0x0166, B:66:0x00f2, B:68:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6 = i;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i6 < 0 || i2 > bArr.length || i6 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i6 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i6];
        int i7 = 0;
        while (i6 < i2) {
            byte b2 = bArr[i6];
            if (b2 >= 0) {
                int i8 = i7 + 1;
                cArr[i7] = (char) b2;
                i6++;
                while (true) {
                    i7 = i8;
                    if (i6 >= i2 || (b = bArr[i6]) < 0) {
                        break;
                    }
                    i6++;
                    i8 = i7 + 1;
                    cArr[i7] = (char) b;
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i9 = i6 + 1;
                    if (i2 <= i9) {
                        i3 = i7 + 1;
                        cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                    } else {
                        byte b3 = bArr[i9];
                        if ((b3 & 192) == 128) {
                            int i10 = (b2 << 6) ^ (b3 ^ 3968);
                            if (i10 < 128) {
                                i3 = i7 + 1;
                                cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit = Unit.INSTANCE;
                            } else {
                                int i11 = i7 + 1;
                                cArr[i7] = (char) i10;
                                Unit unit2 = Unit.INSTANCE;
                                i3 = i11;
                            }
                            i7 = i3;
                            i4 = 2;
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                        }
                    }
                    Unit unit3 = Unit.INSTANCE;
                    i7 = i3;
                    i4 = 1;
                } else if ((b2 >> 4) == -2) {
                    int i12 = i6 + 2;
                    if (i2 <= i12) {
                        i3 = i7 + 1;
                        cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit4 = Unit.INSTANCE;
                        int i13 = i6 + 1;
                        if (i2 <= i13 || (bArr[i13] & 192) != 128) {
                            i7 = i3;
                            i4 = 1;
                        } else {
                            i7 = i3;
                            i4 = 2;
                        }
                    } else {
                        byte b4 = bArr[i6 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i12];
                            if ((b5 & 192) == 128) {
                                int i14 = (b2 << Ascii.FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                if (i14 < 2048) {
                                    i3 = i7 + 1;
                                    cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                } else if (55296 > i14 || i14 >= 57344) {
                                    int i15 = i7 + 1;
                                    cArr[i7] = (char) i14;
                                    Unit unit5 = Unit.INSTANCE;
                                    i3 = i15;
                                    i7 = i3;
                                    i4 = 3;
                                } else {
                                    i3 = i7 + 1;
                                    cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                }
                                Unit unit6 = Unit.INSTANCE;
                                i7 = i3;
                                i4 = 3;
                            } else {
                                i3 = i7 + 1;
                                cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit7 = Unit.INSTANCE;
                                i7 = i3;
                                i4 = 2;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit8 = Unit.INSTANCE;
                            i7 = i3;
                            i4 = 1;
                        }
                    }
                } else if ((b2 >> 3) == -2) {
                    int i16 = i6 + 3;
                    if (i2 <= i16) {
                        i3 = i7 + 1;
                        cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit9 = Unit.INSTANCE;
                        int i17 = i6 + 1;
                        if (i2 > i17 && (bArr[i17] & 192) == 128) {
                            int i18 = i6 + 2;
                            if (i2 > i18 && (bArr[i18] & 192) == 128) {
                                i7 = i3;
                                i4 = 3;
                            }
                        }
                        i7 = i3;
                        i4 = 1;
                    } else {
                        byte b6 = bArr[i6 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i6 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i16];
                                if ((b8 & 192) == 128) {
                                    int i19 = (b2 << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF));
                                    if (i19 > 1114111) {
                                        i5 = i7 + 1;
                                        cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if ((55296 > i19 || i19 >= 57344) && i19 >= 65536 && i19 != 65533) {
                                        cArr[i7] = (char) ((i19 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        cArr[i7 + 1] = (char) ((i19 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                        i5 = i7 + 2;
                                    } else {
                                        i5 = i7 + 1;
                                        cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                    }
                                    Unit unit10 = Unit.INSTANCE;
                                    i4 = 4;
                                    i7 = i5;
                                } else {
                                    i3 = i7 + 1;
                                    cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit11 = Unit.INSTANCE;
                                    i7 = i3;
                                    i4 = 3;
                                }
                            } else {
                                i3 = i7 + 1;
                                cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit12 = Unit.INSTANCE;
                                i7 = i3;
                                i4 = 2;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit13 = Unit.INSTANCE;
                            i7 = i3;
                            i4 = 1;
                        }
                    }
                } else {
                    cArr[i7] = Utf8.REPLACEMENT_CHARACTER;
                    i6++;
                    i7++;
                }
                i6 += i4;
            }
        }
        return StringsKt.concatToString(cArr, 0, i7);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
