package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: AndroidBlendMode.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\n*\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0002*\u00020\nH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidBlendMode_androidKt {

    /* JADX INFO: compiled from: AndroidBlendMode.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[android.graphics.BlendMode.values().length];
            try {
                iArr[android.graphics.BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[android.graphics.BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[android.graphics.BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[android.graphics.BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[android.graphics.BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[android.graphics.BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[android.graphics.BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[android.graphics.BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[android.graphics.BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[android.graphics.BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[android.graphics.BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[android.graphics.BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[android.graphics.BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[android.graphics.BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[android.graphics.BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[android.graphics.BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[android.graphics.BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m6171isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6265getSrcOver0nO6VwU()) || m6173toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m6172toAndroidBlendModes9anfk8(int i) {
        return BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6238getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6261getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6244getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6265getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6248getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6263getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6246getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6264getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6247getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6262getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6245getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6266getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6257getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6254getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6259getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6256getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6242getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6252getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6241getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6240getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6250getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6260getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6243getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6249getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6255getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6251getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6258getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6239getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6253getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(android.graphics.BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.INSTANCE.m6238getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m6261getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m6244getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m6265getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m6248getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m6263getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m6246getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m6264getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m6247getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m6262getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m6245getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m6266getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m6257getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m6254getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m6259getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m6256getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m6242getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m6252getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m6241getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m6240getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m6250getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m6260getSoftlight0nO6VwU();
            case 23:
                return BlendMode.INSTANCE.m6243getDifference0nO6VwU();
            case 24:
                return BlendMode.INSTANCE.m6249getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m6255getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m6251getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m6258getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m6239getColor0nO6VwU();
            case 29:
                return BlendMode.INSTANCE.m6253getLuminosity0nO6VwU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m6173toPorterDuffModes9anfk8(int i) {
        return BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6238getClear0nO6VwU()) ? PorterDuff.Mode.CLEAR : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6261getSrc0nO6VwU()) ? PorterDuff.Mode.SRC : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6244getDst0nO6VwU()) ? PorterDuff.Mode.DST : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6265getSrcOver0nO6VwU()) ? PorterDuff.Mode.SRC_OVER : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6248getDstOver0nO6VwU()) ? PorterDuff.Mode.DST_OVER : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6263getSrcIn0nO6VwU()) ? PorterDuff.Mode.SRC_IN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6246getDstIn0nO6VwU()) ? PorterDuff.Mode.DST_IN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6264getSrcOut0nO6VwU()) ? PorterDuff.Mode.SRC_OUT : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6247getDstOut0nO6VwU()) ? PorterDuff.Mode.DST_OUT : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6262getSrcAtop0nO6VwU()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6245getDstAtop0nO6VwU()) ? PorterDuff.Mode.DST_ATOP : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6266getXor0nO6VwU()) ? PorterDuff.Mode.XOR : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6257getPlus0nO6VwU()) ? PorterDuff.Mode.ADD : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6259getScreen0nO6VwU()) ? PorterDuff.Mode.SCREEN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6256getOverlay0nO6VwU()) ? PorterDuff.Mode.OVERLAY : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6242getDarken0nO6VwU()) ? PorterDuff.Mode.DARKEN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6252getLighten0nO6VwU()) ? PorterDuff.Mode.LIGHTEN : BlendMode.m6234equalsimpl0(i, BlendMode.INSTANCE.m6254getModulate0nO6VwU()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
