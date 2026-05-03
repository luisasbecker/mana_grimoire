package androidx.camera.camera2.pipe;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraControls.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0005J\u0011\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/AfMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "isOn", "", "isOn-impl", "(I)Z", "isContinuous", "isContinuous-impl", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class AfMode {
    private static final int AUTO;
    private static final int CONTINUOUS_PICTURE;
    private static final int CONTINUOUS_VIDEO;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EDOF;
    private static final int MACRO;
    private static final int OFF;
    private static final List<AfMode> values;
    private final int value;

    /* JADX INFO: compiled from: CameraControls.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b\u001aR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/AfMode$Companion;", "", "<init>", "()V", "OFF", "Landroidx/camera/camera2/pipe/AfMode;", "getOFF-vHZNRtE", "()I", "I", "AUTO", "getAUTO-vHZNRtE", "MACRO", "getMACRO-vHZNRtE", "CONTINUOUS_VIDEO", "getCONTINUOUS_VIDEO-vHZNRtE", "CONTINUOUS_PICTURE", "getCONTINUOUS_PICTURE-vHZNRtE", "EDOF", "getEDOF-vHZNRtE", "values", "", "getValues", "()Ljava/util/List;", "fromIntOrNull", "value", "", "fromIntOrNull-MKXwA8g", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: fromIntOrNull-MKXwA8g, reason: not valid java name */
        public final AfMode m160fromIntOrNullMKXwA8g(int value) {
            Object next;
            Iterator<T> it = getValues().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((AfMode) next).m159unboximpl() == value) {
                    break;
                }
            }
            return (AfMode) next;
        }

        /* JADX INFO: renamed from: getAUTO-vHZNRtE, reason: not valid java name */
        public final int m161getAUTOvHZNRtE() {
            return AfMode.AUTO;
        }

        /* JADX INFO: renamed from: getCONTINUOUS_PICTURE-vHZNRtE, reason: not valid java name */
        public final int m162getCONTINUOUS_PICTUREvHZNRtE() {
            return AfMode.CONTINUOUS_PICTURE;
        }

        /* JADX INFO: renamed from: getCONTINUOUS_VIDEO-vHZNRtE, reason: not valid java name */
        public final int m163getCONTINUOUS_VIDEOvHZNRtE() {
            return AfMode.CONTINUOUS_VIDEO;
        }

        /* JADX INFO: renamed from: getEDOF-vHZNRtE, reason: not valid java name */
        public final int m164getEDOFvHZNRtE() {
            return AfMode.EDOF;
        }

        /* JADX INFO: renamed from: getMACRO-vHZNRtE, reason: not valid java name */
        public final int m165getMACROvHZNRtE() {
            return AfMode.MACRO;
        }

        /* JADX INFO: renamed from: getOFF-vHZNRtE, reason: not valid java name */
        public final int m166getOFFvHZNRtE() {
            return AfMode.OFF;
        }

        public final List<AfMode> getValues() {
            return AfMode.values;
        }
    }

    static {
        int iM151constructorimpl = m151constructorimpl(0);
        OFF = iM151constructorimpl;
        int iM151constructorimpl2 = m151constructorimpl(1);
        AUTO = iM151constructorimpl2;
        int iM151constructorimpl3 = m151constructorimpl(2);
        MACRO = iM151constructorimpl3;
        int iM151constructorimpl4 = m151constructorimpl(3);
        CONTINUOUS_VIDEO = iM151constructorimpl4;
        int iM151constructorimpl5 = m151constructorimpl(4);
        CONTINUOUS_PICTURE = iM151constructorimpl5;
        int iM151constructorimpl6 = m151constructorimpl(5);
        EDOF = iM151constructorimpl6;
        values = CollectionsKt.listOf((Object[]) new AfMode[]{m150boximpl(iM151constructorimpl), m150boximpl(iM151constructorimpl2), m150boximpl(iM151constructorimpl3), m150boximpl(iM151constructorimpl4), m150boximpl(iM151constructorimpl5), m150boximpl(iM151constructorimpl6)});
    }

    private /* synthetic */ AfMode(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AfMode m150boximpl(int i) {
        return new AfMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m151constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m152equalsimpl(int i, Object obj) {
        return (obj instanceof AfMode) && i == ((AfMode) obj).m159unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m153equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @JvmStatic
    /* JADX INFO: renamed from: fromIntOrNull-MKXwA8g, reason: not valid java name */
    public static final AfMode m154fromIntOrNullMKXwA8g(int i) {
        return INSTANCE.m160fromIntOrNullMKXwA8g(i);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m155hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isContinuous-impl, reason: not valid java name */
    public static final boolean m156isContinuousimpl(int i) {
        return i == 3 || i == 4;
    }

    /* JADX INFO: renamed from: isOn-impl, reason: not valid java name */
    public static final boolean m157isOnimpl(int i) {
        return i != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m158toStringimpl(int i) {
        return "AfMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m152equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m155hashCodeimpl(this.value);
    }

    public String toString() {
        return m158toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m159unboximpl() {
        return this.value;
    }
}
