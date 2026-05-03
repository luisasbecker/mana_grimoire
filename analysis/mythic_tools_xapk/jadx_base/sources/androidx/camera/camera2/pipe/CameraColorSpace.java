package androidx.camera.camera2.pipe;

import android.graphics.ColorSpace;
import android.os.Build;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraColorSpace.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/CameraColorSpace;", "", "colorSpaceName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getColorSpaceName", "()Ljava/lang/String;", "toColorSpaceNamed", "Landroid/graphics/ColorSpace$Named;", "toColorSpaceNamed-impl", "(Ljava/lang/String;)Landroid/graphics/ColorSpace$Named;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class CameraColorSpace {
    private final String colorSpaceName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String UNKNOWN = m224constructorimpl("UNKNOWN");
    private static final String SRGB = m224constructorimpl("SRGB");
    private static final String LINEAR_SRGB = m224constructorimpl("LINEAR_SRGB");
    private static final String EXTENDED_SRGB = m224constructorimpl("EXTENDED_SRGB");
    private static final String LINEAR_EXTENDED_SRGB = m224constructorimpl("LINEAR_EXTENDED_SRGB");
    private static final String BT709 = m224constructorimpl("BT709");
    private static final String BT2020 = m224constructorimpl("BT2020");
    private static final String DCI_P3 = m224constructorimpl("DCI_P3");
    private static final String DISPLAY_P3 = m224constructorimpl("DISPLAY_P3");
    private static final String NTSC_1953 = m224constructorimpl("NTSC_1953");
    private static final String SMPTE_C = m224constructorimpl("SMPTE_C");
    private static final String ADOBE_RGB = m224constructorimpl("ADOBE_RGB");
    private static final String PRO_PHOTO_RGB = m224constructorimpl("PRO_PHOTO_RGB");
    private static final String ACES = m224constructorimpl("ACES");
    private static final String ACESCG = m224constructorimpl("ACESCG");
    private static final String CIE_XYZ = m224constructorimpl("CIE_XYZ");
    private static final String CIE_LAB = m224constructorimpl("CIE_LAB");
    private static final String BT2020_HLG = m224constructorimpl("BT2020_HLG");
    private static final String BT2020_PQ = m224constructorimpl("BT2020_PQ");

    /* JADX INFO: compiled from: CameraColorSpace.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020/H\u0007¢\u0006\u0004\b0\u00101R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0013\u0010%\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b&\u0010\u0007R\u0013\u0010'\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b,\u0010\u0007¨\u00062"}, d2 = {"Landroidx/camera/camera2/pipe/CameraColorSpace$Companion;", "", "<init>", "()V", "UNKNOWN", "Landroidx/camera/camera2/pipe/CameraColorSpace;", "getUNKNOWN-sh9K6P8", "()Ljava/lang/String;", "Ljava/lang/String;", "SRGB", "getSRGB-sh9K6P8", "LINEAR_SRGB", "getLINEAR_SRGB-sh9K6P8", "EXTENDED_SRGB", "getEXTENDED_SRGB-sh9K6P8", "LINEAR_EXTENDED_SRGB", "getLINEAR_EXTENDED_SRGB-sh9K6P8", "BT709", "getBT709-sh9K6P8", "BT2020", "getBT2020-sh9K6P8", "DCI_P3", "getDCI_P3-sh9K6P8", "DISPLAY_P3", "getDISPLAY_P3-sh9K6P8", "NTSC_1953", "getNTSC_1953-sh9K6P8", "SMPTE_C", "getSMPTE_C-sh9K6P8", "ADOBE_RGB", "getADOBE_RGB-sh9K6P8", "PRO_PHOTO_RGB", "getPRO_PHOTO_RGB-sh9K6P8", "ACES", "getACES-sh9K6P8", "ACESCG", "getACESCG-sh9K6P8", "CIE_XYZ", "getCIE_XYZ-sh9K6P8", "CIE_LAB", "getCIE_LAB-sh9K6P8", "BT2020_HLG", "getBT2020_HLG-sh9K6P8", "BT2020_PQ", "getBT2020_PQ-sh9K6P8", "fromColorSpaceNamed", "colorSpaceNamed", "Landroid/graphics/ColorSpace$Named;", "fromColorSpaceNamed-5GKeQC8", "(Landroid/graphics/ColorSpace$Named;)Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: CameraColorSpace.kt */
        @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ColorSpace.Named.values().length];
                try {
                    iArr[ColorSpace.Named.SRGB.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ColorSpace.Named.LINEAR_SRGB.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ColorSpace.Named.EXTENDED_SRGB.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ColorSpace.Named.BT709.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ColorSpace.Named.BT2020.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ColorSpace.Named.DCI_P3.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ColorSpace.Named.DISPLAY_P3.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ColorSpace.Named.NTSC_1953.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ColorSpace.Named.SMPTE_C.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ColorSpace.Named.ADOBE_RGB.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[ColorSpace.Named.PRO_PHOTO_RGB.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[ColorSpace.Named.ACES.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[ColorSpace.Named.ACESCG.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[ColorSpace.Named.CIE_XYZ.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[ColorSpace.Named.CIE_LAB.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[ColorSpace.Named.BT2020_HLG.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[ColorSpace.Named.BT2020_PQ.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: fromColorSpaceNamed-5GKeQC8, reason: not valid java name */
        public final String m232fromColorSpaceNamed5GKeQC8(ColorSpace.Named colorSpaceNamed) {
            Intrinsics.checkNotNullParameter(colorSpaceNamed, "colorSpaceNamed");
            switch (WhenMappings.$EnumSwitchMapping$0[colorSpaceNamed.ordinal()]) {
                case 1:
                    return m250getSRGBsh9K6P8();
                case 2:
                    return m246getLINEAR_SRGBsh9K6P8();
                case 3:
                    return m244getEXTENDED_SRGBsh9K6P8();
                case 4:
                    return m245getLINEAR_EXTENDED_SRGBsh9K6P8();
                case 5:
                    return m239getBT709sh9K6P8();
                case 6:
                    return m236getBT2020sh9K6P8();
                case 7:
                    return m242getDCI_P3sh9K6P8();
                case 8:
                    return m243getDISPLAY_P3sh9K6P8();
                case 9:
                    return m247getNTSC_1953sh9K6P8();
                case 10:
                    return m249getSMPTE_Csh9K6P8();
                case 11:
                    return m235getADOBE_RGBsh9K6P8();
                case 12:
                    return m248getPRO_PHOTO_RGBsh9K6P8();
                case 13:
                    return m233getACESsh9K6P8();
                case 14:
                    return m234getACESCGsh9K6P8();
                case 15:
                    return m241getCIE_XYZsh9K6P8();
                case 16:
                    return m240getCIE_LABsh9K6P8();
                default:
                    if (Build.VERSION.SDK_INT < 34) {
                        return null;
                    }
                    int i = WhenMappings.$EnumSwitchMapping$0[colorSpaceNamed.ordinal()];
                    if (i == 17) {
                        return m237getBT2020_HLGsh9K6P8();
                    }
                    if (i != 18) {
                        return null;
                    }
                    return m238getBT2020_PQsh9K6P8();
            }
        }

        /* JADX INFO: renamed from: getACES-sh9K6P8, reason: not valid java name */
        public final String m233getACESsh9K6P8() {
            return CameraColorSpace.ACES;
        }

        /* JADX INFO: renamed from: getACESCG-sh9K6P8, reason: not valid java name */
        public final String m234getACESCGsh9K6P8() {
            return CameraColorSpace.ACESCG;
        }

        /* JADX INFO: renamed from: getADOBE_RGB-sh9K6P8, reason: not valid java name */
        public final String m235getADOBE_RGBsh9K6P8() {
            return CameraColorSpace.ADOBE_RGB;
        }

        /* JADX INFO: renamed from: getBT2020-sh9K6P8, reason: not valid java name */
        public final String m236getBT2020sh9K6P8() {
            return CameraColorSpace.BT2020;
        }

        /* JADX INFO: renamed from: getBT2020_HLG-sh9K6P8, reason: not valid java name */
        public final String m237getBT2020_HLGsh9K6P8() {
            return CameraColorSpace.BT2020_HLG;
        }

        /* JADX INFO: renamed from: getBT2020_PQ-sh9K6P8, reason: not valid java name */
        public final String m238getBT2020_PQsh9K6P8() {
            return CameraColorSpace.BT2020_PQ;
        }

        /* JADX INFO: renamed from: getBT709-sh9K6P8, reason: not valid java name */
        public final String m239getBT709sh9K6P8() {
            return CameraColorSpace.BT709;
        }

        /* JADX INFO: renamed from: getCIE_LAB-sh9K6P8, reason: not valid java name */
        public final String m240getCIE_LABsh9K6P8() {
            return CameraColorSpace.CIE_LAB;
        }

        /* JADX INFO: renamed from: getCIE_XYZ-sh9K6P8, reason: not valid java name */
        public final String m241getCIE_XYZsh9K6P8() {
            return CameraColorSpace.CIE_XYZ;
        }

        /* JADX INFO: renamed from: getDCI_P3-sh9K6P8, reason: not valid java name */
        public final String m242getDCI_P3sh9K6P8() {
            return CameraColorSpace.DCI_P3;
        }

        /* JADX INFO: renamed from: getDISPLAY_P3-sh9K6P8, reason: not valid java name */
        public final String m243getDISPLAY_P3sh9K6P8() {
            return CameraColorSpace.DISPLAY_P3;
        }

        /* JADX INFO: renamed from: getEXTENDED_SRGB-sh9K6P8, reason: not valid java name */
        public final String m244getEXTENDED_SRGBsh9K6P8() {
            return CameraColorSpace.EXTENDED_SRGB;
        }

        /* JADX INFO: renamed from: getLINEAR_EXTENDED_SRGB-sh9K6P8, reason: not valid java name */
        public final String m245getLINEAR_EXTENDED_SRGBsh9K6P8() {
            return CameraColorSpace.LINEAR_EXTENDED_SRGB;
        }

        /* JADX INFO: renamed from: getLINEAR_SRGB-sh9K6P8, reason: not valid java name */
        public final String m246getLINEAR_SRGBsh9K6P8() {
            return CameraColorSpace.LINEAR_SRGB;
        }

        /* JADX INFO: renamed from: getNTSC_1953-sh9K6P8, reason: not valid java name */
        public final String m247getNTSC_1953sh9K6P8() {
            return CameraColorSpace.NTSC_1953;
        }

        /* JADX INFO: renamed from: getPRO_PHOTO_RGB-sh9K6P8, reason: not valid java name */
        public final String m248getPRO_PHOTO_RGBsh9K6P8() {
            return CameraColorSpace.PRO_PHOTO_RGB;
        }

        /* JADX INFO: renamed from: getSMPTE_C-sh9K6P8, reason: not valid java name */
        public final String m249getSMPTE_Csh9K6P8() {
            return CameraColorSpace.SMPTE_C;
        }

        /* JADX INFO: renamed from: getSRGB-sh9K6P8, reason: not valid java name */
        public final String m250getSRGBsh9K6P8() {
            return CameraColorSpace.SRGB;
        }

        /* JADX INFO: renamed from: getUNKNOWN-sh9K6P8, reason: not valid java name */
        public final String m251getUNKNOWNsh9K6P8() {
            return CameraColorSpace.UNKNOWN;
        }
    }

    private /* synthetic */ CameraColorSpace(String str) {
        this.colorSpaceName = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CameraColorSpace m223boximpl(String str) {
        return new CameraColorSpace(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static String m224constructorimpl(String str) {
        return str;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m225equalsimpl(String str, Object obj) {
        return (obj instanceof CameraColorSpace) && Intrinsics.areEqual(str, ((CameraColorSpace) obj).m231unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m226equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: fromColorSpaceNamed-5GKeQC8, reason: not valid java name */
    public static final String m227fromColorSpaceNamed5GKeQC8(ColorSpace.Named named) {
        return INSTANCE.m232fromColorSpaceNamed5GKeQC8(named);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m228hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toColorSpaceNamed-impl, reason: not valid java name */
    public static final ColorSpace.Named m229toColorSpaceNamedimpl(String str) {
        if (m226equalsimpl0(str, UNKNOWN)) {
            return null;
        }
        if (m226equalsimpl0(str, SRGB)) {
            return ColorSpace.Named.SRGB;
        }
        if (m226equalsimpl0(str, LINEAR_SRGB)) {
            return ColorSpace.Named.LINEAR_SRGB;
        }
        if (m226equalsimpl0(str, EXTENDED_SRGB)) {
            return ColorSpace.Named.EXTENDED_SRGB;
        }
        if (m226equalsimpl0(str, LINEAR_EXTENDED_SRGB)) {
            return ColorSpace.Named.LINEAR_EXTENDED_SRGB;
        }
        if (m226equalsimpl0(str, BT709)) {
            return ColorSpace.Named.BT709;
        }
        if (m226equalsimpl0(str, BT2020)) {
            return ColorSpace.Named.BT2020;
        }
        if (m226equalsimpl0(str, DCI_P3)) {
            return ColorSpace.Named.DCI_P3;
        }
        if (m226equalsimpl0(str, DISPLAY_P3)) {
            return ColorSpace.Named.DISPLAY_P3;
        }
        if (m226equalsimpl0(str, NTSC_1953)) {
            return ColorSpace.Named.NTSC_1953;
        }
        if (m226equalsimpl0(str, SMPTE_C)) {
            return ColorSpace.Named.SMPTE_C;
        }
        if (m226equalsimpl0(str, ADOBE_RGB)) {
            return ColorSpace.Named.ADOBE_RGB;
        }
        if (m226equalsimpl0(str, PRO_PHOTO_RGB)) {
            return ColorSpace.Named.PRO_PHOTO_RGB;
        }
        if (m226equalsimpl0(str, ACES)) {
            return ColorSpace.Named.ACES;
        }
        if (m226equalsimpl0(str, ACESCG)) {
            return ColorSpace.Named.ACESCG;
        }
        if (m226equalsimpl0(str, CIE_XYZ)) {
            return ColorSpace.Named.CIE_XYZ;
        }
        if (m226equalsimpl0(str, CIE_LAB)) {
            return ColorSpace.Named.CIE_LAB;
        }
        if (Build.VERSION.SDK_INT < 34) {
            return null;
        }
        if (m226equalsimpl0(str, BT2020_HLG)) {
            return ColorSpace.Named.BT2020_HLG;
        }
        if (m226equalsimpl0(str, BT2020_PQ)) {
            return ColorSpace.Named.BT2020_PQ;
        }
        return null;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m230toStringimpl(String str) {
        return "CameraColorSpace(colorSpaceName=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m225equalsimpl(this.colorSpaceName, obj);
    }

    public final String getColorSpaceName() {
        return this.colorSpaceName;
    }

    public int hashCode() {
        return m228hashCodeimpl(this.colorSpaceName);
    }

    public String toString() {
        return m230toStringimpl(this.colorSpaceName);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m231unboximpl() {
        return this.colorSpaceName;
    }
}
