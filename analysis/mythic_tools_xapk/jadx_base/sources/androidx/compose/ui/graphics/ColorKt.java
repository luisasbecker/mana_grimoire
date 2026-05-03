package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00112\b\b\u0001\u0010\t\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00112\b\b\u0003\u0010\u000b\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a1\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0082\b\u001a\u0013\u0010&\u001a\u00020'*\u00020\u0006H\u0003¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010*\u001a\u00020\b*\u00020\u0006H\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\u0011*\u00020\u0006H\u0007¢\u0006\u0004\b.\u0010/\u001a\"\u00109\u001a\u00020\u0006*\u00020\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0086\b¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u00100\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u001f\u00106\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00103\u001a\u0004\b8\u00105¨\u0006>"}, d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "Color", "Landroidx/compose/ui/graphics/Color;", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "color", "", "(I)J", "", "(J)J", "(IIII)J", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "toArgb", "toArgb-8_81llA", "(J)I", "isSpecified", "", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    /* JADX WARN: Removed duplicated region for block: B:108:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        float minValue;
        float maxValue;
        int i4;
        int i5;
        int i6;
        int i7;
        float minValue2;
        float maxValue2;
        int i8;
        int i9;
        int i10;
        if (colorSpace.getIsSrgb()) {
            float f5 = f4 < 0.0f ? 0.0f : f4;
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
            int i11 = ((int) ((f5 * 255.0f) + 0.5f)) << 24;
            float f6 = f < 0.0f ? 0.0f : f;
            if (f6 > 1.0f) {
                f6 = 1.0f;
            }
            int i12 = i11 | (((int) ((f6 * 255.0f) + 0.5f)) << 16);
            float f7 = f2 < 0.0f ? 0.0f : f2;
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            int i13 = i12 | (((int) ((f7 * 255.0f) + 0.5f)) << 8);
            return Color.m6321constructorimpl(ULong.m11619constructorimpl(ULong.m11619constructorimpl(i13 | ((int) ((((f3 >= 0.0f ? f3 : 0.0f) <= 1.0f ? r5 : 1.0f) * 255.0f) + 0.5f))) << 32));
        }
        if (!(colorSpace.getComponentCount() == 3)) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id$ui_graphics = colorSpace.getId();
        if (!(id$ui_graphics != -1)) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        float minValue3 = colorSpace.getMinValue(0);
        float maxValue3 = colorSpace.getMaxValue(0);
        if (f >= minValue3) {
            minValue3 = f;
        }
        if (minValue3 <= maxValue3) {
            maxValue3 = minValue3;
        }
        int iFloatToRawIntBits = Float.floatToRawIntBits(maxValue3);
        int i14 = iFloatToRawIntBits >>> 31;
        int i15 = (iFloatToRawIntBits >>> 23) & 255;
        int i16 = iFloatToRawIntBits & 8388607;
        if (i15 == 255) {
            i2 = i16 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i15 - 112;
            if (i >= 31) {
                i2 = 0;
                i = 49;
            } else if (i > 0) {
                int i17 = i16 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i3 = (((i << 10) | i17) + 1) | (i14 << 15);
                    short s = (short) i3;
                    minValue = colorSpace.getMinValue(1);
                    maxValue = colorSpace.getMaxValue(1);
                    if (f2 >= minValue) {
                        minValue = f2;
                    }
                    if (minValue <= maxValue) {
                        maxValue = minValue;
                    }
                    int iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue);
                    int i18 = iFloatToRawIntBits2 >>> 31;
                    i4 = (iFloatToRawIntBits2 >>> 23) & 255;
                    int i19 = iFloatToRawIntBits2 & 8388607;
                    if (i4 != 255) {
                        i6 = i19 != 0 ? 512 : 0;
                        i5 = 31;
                    } else {
                        i5 = i4 - 112;
                        if (i5 >= 31) {
                            i6 = 0;
                            i5 = 49;
                        } else if (i5 > 0) {
                            int i20 = i19 >> 13;
                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                i7 = (((i5 << 10) | i20) + 1) | (i18 << 15);
                                short s2 = (short) i7;
                                minValue2 = colorSpace.getMinValue(2);
                                maxValue2 = colorSpace.getMaxValue(2);
                                if (f3 >= minValue2) {
                                    minValue2 = f3;
                                }
                                if (minValue2 <= maxValue2) {
                                    maxValue2 = minValue2;
                                }
                                int iFloatToRawIntBits3 = Float.floatToRawIntBits(maxValue2);
                                int i21 = iFloatToRawIntBits3 >>> 31;
                                i8 = (iFloatToRawIntBits3 >>> 23) & 255;
                                int i22 = 8388607 & iFloatToRawIntBits3;
                                if (i8 == 255) {
                                    i9 = i22 != 0 ? 512 : 0;
                                    i = 31;
                                } else {
                                    int i23 = i8 - 112;
                                    if (i23 >= 31) {
                                        i9 = 0;
                                        i = 49;
                                    } else if (i23 > 0) {
                                        int i24 = i22 >> 13;
                                        if ((iFloatToRawIntBits3 & 4096) != 0) {
                                            i10 = (((i23 << 10) | i24) + 1) | (i21 << 15);
                                            short s3 = (short) i10;
                                            float f8 = f4 >= 0.0f ? f4 : 0.0f;
                                            return Color.m6321constructorimpl(ULong.m11619constructorimpl((((long) id$ui_graphics) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s3)) << 16) | ((((long) ((int) (((f8 <= 1.0f ? f8 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                                        }
                                        i9 = i24;
                                        i = i23;
                                    } else if (i23 >= -10) {
                                        int i25 = (i22 | 8388608) >> (1 - i23);
                                        if ((i25 & 4096) != 0) {
                                            i25 += 8192;
                                        }
                                        i9 = i25 >> 13;
                                    } else {
                                        i9 = 0;
                                    }
                                }
                                i10 = i9 | (i21 << 15) | (i << 10);
                                short s32 = (short) i10;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m6321constructorimpl(ULong.m11619constructorimpl((((long) id$ui_graphics) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s32)) << 16) | ((((long) ((int) (((f8 <= 1.0f ? f8 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            i6 = i20;
                        } else if (i5 >= -10) {
                            int i26 = (i19 | 8388608) >> (1 - i5);
                            if ((i26 & 4096) != 0) {
                                i26 += 8192;
                            }
                            i6 = i26 >> 13;
                            i5 = 0;
                        } else {
                            i6 = 0;
                            i5 = 0;
                        }
                    }
                    i7 = i6 | (i18 << 15) | (i5 << 10);
                    short s22 = (short) i7;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                    }
                    if (minValue2 <= maxValue2) {
                    }
                    int iFloatToRawIntBits32 = Float.floatToRawIntBits(maxValue2);
                    int i212 = iFloatToRawIntBits32 >>> 31;
                    i8 = (iFloatToRawIntBits32 >>> 23) & 255;
                    int i222 = 8388607 & iFloatToRawIntBits32;
                    if (i8 == 255) {
                    }
                    i10 = i9 | (i212 << 15) | (i << 10);
                    short s322 = (short) i10;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m6321constructorimpl(ULong.m11619constructorimpl((((long) id$ui_graphics) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s22) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s322)) << 16) | ((((long) ((int) (((f8 <= 1.0f ? f8 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                i2 = i17;
            } else if (i >= -10) {
                int i27 = (i16 | 8388608) >> (1 - i);
                if ((i27 & 4096) != 0) {
                    i27 += 8192;
                }
                i2 = i27 >> 13;
                i = 0;
            } else {
                i2 = 0;
                i = 0;
            }
        }
        i3 = i2 | (i14 << 15) | (i << 10);
        short s4 = (short) i3;
        minValue = colorSpace.getMinValue(1);
        maxValue = colorSpace.getMaxValue(1);
        if (f2 >= minValue) {
        }
        if (minValue <= maxValue) {
        }
        int iFloatToRawIntBits22 = Float.floatToRawIntBits(maxValue);
        int i182 = iFloatToRawIntBits22 >>> 31;
        i4 = (iFloatToRawIntBits22 >>> 23) & 255;
        int i192 = iFloatToRawIntBits22 & 8388607;
        if (i4 != 255) {
        }
        i7 = i6 | (i182 << 15) | (i5 << 10);
        short s222 = (short) i7;
        minValue2 = colorSpace.getMinValue(2);
        maxValue2 = colorSpace.getMaxValue(2);
        if (f3 >= minValue2) {
        }
        if (minValue2 <= maxValue2) {
        }
        int iFloatToRawIntBits322 = Float.floatToRawIntBits(maxValue2);
        int i2122 = iFloatToRawIntBits322 >>> 31;
        i8 = (iFloatToRawIntBits322 >>> 23) & 255;
        int i2222 = 8388607 & iFloatToRawIntBits322;
        if (i8 == 255) {
        }
        i10 = i9 | (i2122 << 15) | (i << 10);
        short s3222 = (short) i10;
        if (f4 >= 0.0f) {
        }
        return Color.m6321constructorimpl(ULong.m11619constructorimpl((((long) id$ui_graphics) & 63) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s222) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s3222)) << 16) | ((((long) ((int) (((f8 <= 1.0f ? f8 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
    }

    public static final long Color(int i) {
        return Color.m6321constructorimpl(ULong.m11619constructorimpl(ULong.m11619constructorimpl(i) << 32));
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    public static final long Color(long j) {
        return Color.m6321constructorimpl(ULong.m11619constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long UncheckedColor(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (colorSpace.getIsSrgb()) {
            return Color.m6321constructorimpl(ULong.m11619constructorimpl(ULong.m11619constructorimpl((((((int) ((f4 * 255.0f) + 0.5f)) << 24) | (((int) ((f * 255.0f) + 0.5f)) << 16)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f3) + 0.5f))) << 32));
        }
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i10 = iFloatToRawIntBits >>> 31;
        int i11 = (iFloatToRawIntBits >>> 23) & 255;
        int i12 = iFloatToRawIntBits & 8388607;
        int i13 = 49;
        int i14 = 0;
        if (i11 == 255) {
            i2 = i12 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i11 - 112;
            if (i >= 31) {
                i = 49;
                i2 = 0;
            } else if (i > 0) {
                int i15 = i12 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i3 = (((i << 10) | i15) + 1) | (i10 << 15);
                    short s = (short) i3;
                    int iFloatToRawIntBits2 = Float.floatToRawIntBits(f2);
                    int i16 = iFloatToRawIntBits2 >>> 31;
                    i4 = (iFloatToRawIntBits2 >>> 23) & 255;
                    int i17 = iFloatToRawIntBits2 & 8388607;
                    if (i4 != 255) {
                        i6 = i17 != 0 ? 512 : 0;
                        i5 = 31;
                    } else {
                        i5 = i4 - 112;
                        if (i5 >= 31) {
                            i5 = 49;
                            i6 = 0;
                        } else if (i5 > 0) {
                            int i18 = i17 >> 13;
                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                i7 = (((i5 << 10) | i18) + 1) | (i16 << 15);
                                short s2 = (short) i7;
                                int iFloatToRawIntBits3 = Float.floatToRawIntBits(f3);
                                int i19 = iFloatToRawIntBits3 >>> 31;
                                i8 = (iFloatToRawIntBits3 >>> 23) & 255;
                                int i20 = 8388607 & iFloatToRawIntBits3;
                                if (i8 != 255) {
                                    int i21 = i8 - 112;
                                    if (i21 < 31) {
                                        if (i21 > 0) {
                                            i14 = i20 >> 13;
                                            if ((iFloatToRawIntBits3 & 4096) != 0) {
                                                i9 = (((i21 << 10) | i14) + 1) | (i19 << 15);
                                            } else {
                                                i13 = i21;
                                            }
                                        } else if (i21 >= -10) {
                                            int i22 = (i20 | 8388608) >> (1 - i21);
                                            if ((i22 & 4096) != 0) {
                                                i22 += 8192;
                                            }
                                            i13 = 0;
                                            i14 = i22 >> 13;
                                        } else {
                                            i13 = 0;
                                        }
                                    }
                                    return Color.m6321constructorimpl(ULong.m11619constructorimpl(((((long) ((short) i9)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId()) & 63)));
                                }
                                i14 = i20 == 0 ? 0 : 512;
                                i13 = 31;
                                i9 = (i19 << 15) | (i13 << 10) | i14;
                                return Color.m6321constructorimpl(ULong.m11619constructorimpl(((((long) ((short) i9)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId()) & 63)));
                            }
                            i6 = i18;
                        } else if (i5 >= -10) {
                            int i23 = (i17 | 8388608) >> (1 - i5);
                            if ((i23 & 4096) != 0) {
                                i23 += 8192;
                            }
                            i6 = i23 >> 13;
                            i5 = 0;
                        } else {
                            i6 = 0;
                            i5 = 0;
                        }
                    }
                    i7 = i6 | (i16 << 15) | (i5 << 10);
                    short s22 = (short) i7;
                    int iFloatToRawIntBits32 = Float.floatToRawIntBits(f3);
                    int i192 = iFloatToRawIntBits32 >>> 31;
                    i8 = (iFloatToRawIntBits32 >>> 23) & 255;
                    int i202 = 8388607 & iFloatToRawIntBits32;
                    if (i8 != 255) {
                    }
                    i9 = (i192 << 15) | (i13 << 10) | i14;
                    return Color.m6321constructorimpl(ULong.m11619constructorimpl(((((long) ((short) i9)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s22) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId()) & 63)));
                }
                i2 = i15;
            } else if (i >= -10) {
                int i24 = (i12 | 8388608) >> (1 - i);
                if ((i24 & 4096) != 0) {
                    i24 += 8192;
                }
                i2 = i24 >> 13;
                i = 0;
            } else {
                i2 = 0;
                i = 0;
            }
        }
        i3 = i2 | (i10 << 15) | (i << 10);
        short s3 = (short) i3;
        int iFloatToRawIntBits22 = Float.floatToRawIntBits(f2);
        int i162 = iFloatToRawIntBits22 >>> 31;
        i4 = (iFloatToRawIntBits22 >>> 23) & 255;
        int i172 = iFloatToRawIntBits22 & 8388607;
        if (i4 != 255) {
        }
        i7 = i6 | (i162 << 15) | (i5 << 10);
        short s222 = (short) i7;
        int iFloatToRawIntBits322 = Float.floatToRawIntBits(f3);
        int i1922 = iFloatToRawIntBits322 >>> 31;
        i8 = (iFloatToRawIntBits322 >>> 23) & 255;
        int i2022 = 8388607 & iFloatToRawIntBits322;
        if (i8 != 255) {
        }
        i9 = (i1922 << 15) | (i13 << 10) | i14;
        return Color.m6321constructorimpl(ULong.m11619constructorimpl(((((long) ((short) i9)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s222) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId()) & 63)));
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f2, f3, f4, colorSpace);
    }

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m6370compositeOverOWjLjI(long j, long j2) {
        long jM6322convertvNxB06k = Color.m6322convertvNxB06k(j, Color.m6329getColorSpaceimpl(j2));
        float fM6327getAlphaimpl = Color.m6327getAlphaimpl(j2);
        float fM6327getAlphaimpl2 = Color.m6327getAlphaimpl(jM6322convertvNxB06k);
        float f = 1.0f - fM6327getAlphaimpl2;
        float f2 = (fM6327getAlphaimpl * f) + fM6327getAlphaimpl2;
        return UncheckedColor(f2 == 0.0f ? 0.0f : ((Color.m6331getRedimpl(jM6322convertvNxB06k) * fM6327getAlphaimpl2) + ((Color.m6331getRedimpl(j2) * fM6327getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m6330getGreenimpl(jM6322convertvNxB06k) * fM6327getAlphaimpl2) + ((Color.m6330getGreenimpl(j2) * fM6327getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m6328getBlueimpl(jM6322convertvNxB06k) * fM6327getAlphaimpl2) + ((Color.m6328getBlueimpl(j2) * fM6327getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m6329getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m6371getComponents8_81llA(long j) {
        return new float[]{Color.m6331getRedimpl(j), Color.m6330getGreenimpl(j), Color.m6328getBlueimpl(j), Color.m6327getAlphaimpl(j)};
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m6372isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m6373isSpecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m6374isUnspecified8_81llA(long j) {
        return j == 16;
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m6375isUnspecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m6376lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM6322convertvNxB06k = Color.m6322convertvNxB06k(j, oklab);
        long jM6322convertvNxB06k2 = Color.m6322convertvNxB06k(j2, oklab);
        float fM6327getAlphaimpl = Color.m6327getAlphaimpl(jM6322convertvNxB06k);
        float fM6331getRedimpl = Color.m6331getRedimpl(jM6322convertvNxB06k);
        float fM6330getGreenimpl = Color.m6330getGreenimpl(jM6322convertvNxB06k);
        float fM6328getBlueimpl = Color.m6328getBlueimpl(jM6322convertvNxB06k);
        float fM6327getAlphaimpl2 = Color.m6327getAlphaimpl(jM6322convertvNxB06k2);
        float fM6331getRedimpl2 = Color.m6331getRedimpl(jM6322convertvNxB06k2);
        float fM6330getGreenimpl2 = Color.m6330getGreenimpl(jM6322convertvNxB06k2);
        float fM6328getBlueimpl2 = Color.m6328getBlueimpl(jM6322convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m6322convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM6331getRedimpl, fM6331getRedimpl2, f), MathHelpersKt.lerp(fM6330getGreenimpl, fM6330getGreenimpl2, f), MathHelpersKt.lerp(fM6328getBlueimpl, fM6328getBlueimpl2, f), MathHelpersKt.lerp(fM6327getAlphaimpl, fM6327getAlphaimpl2, f), oklab), Color.m6329getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m6377luminance8_81llA(long j) {
        ColorSpace colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j);
        if (!ColorModel.m6755equalsimpl0(colorSpaceM6329getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m6762getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m6758toStringimpl(colorSpaceM6329getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(colorSpaceM6329getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics = ((Rgb) colorSpaceM6329getColorSpaceimpl).getEotfFunc();
        float fInvoke = (float) ((eotfFunc$ui_graphics.invoke(Color.m6331getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics.invoke(Color.m6330getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics.invoke(Color.m6328getBlueimpl(j)) * 0.0722d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m6378takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m6335unboximpl();
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m6379toArgb8_81llA(long j) {
        return (int) ULong.m11619constructorimpl(Color.m6322convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }
}
