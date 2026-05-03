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
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/FlashMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class FlashMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int OFF;
    private static final int SINGLE;
    private static final int TORCH;
    private static final List<FlashMode> values;
    private final int value;

    /* JADX INFO: compiled from: CameraControls.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\b\u0012R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/FlashMode$Companion;", "", "<init>", "()V", "OFF", "Landroidx/camera/camera2/pipe/FlashMode;", "getOFF-Le5xUZU", "()I", "I", "SINGLE", "getSINGLE-Le5xUZU", "TORCH", "getTORCH-Le5xUZU", "values", "", "fromIntOrNull", "value", "", "fromIntOrNull-2-3f5tw", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: fromIntOrNull-2-3f5tw, reason: not valid java name */
        public final FlashMode m440fromIntOrNull23f5tw(int value) {
            Object next;
            Iterator it = FlashMode.values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((FlashMode) next).m439unboximpl() == value) {
                    break;
                }
            }
            return (FlashMode) next;
        }

        /* JADX INFO: renamed from: getOFF-Le5xUZU, reason: not valid java name */
        public final int m441getOFFLe5xUZU() {
            return FlashMode.OFF;
        }

        /* JADX INFO: renamed from: getSINGLE-Le5xUZU, reason: not valid java name */
        public final int m442getSINGLELe5xUZU() {
            return FlashMode.SINGLE;
        }

        /* JADX INFO: renamed from: getTORCH-Le5xUZU, reason: not valid java name */
        public final int m443getTORCHLe5xUZU() {
            return FlashMode.TORCH;
        }
    }

    static {
        int iM433constructorimpl = m433constructorimpl(0);
        OFF = iM433constructorimpl;
        int iM433constructorimpl2 = m433constructorimpl(1);
        SINGLE = iM433constructorimpl2;
        int iM433constructorimpl3 = m433constructorimpl(2);
        TORCH = iM433constructorimpl3;
        values = CollectionsKt.listOf((Object[]) new FlashMode[]{m432boximpl(iM433constructorimpl), m432boximpl(iM433constructorimpl2), m432boximpl(iM433constructorimpl3)});
    }

    private /* synthetic */ FlashMode(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FlashMode m432boximpl(int i) {
        return new FlashMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m433constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m434equalsimpl(int i, Object obj) {
        return (obj instanceof FlashMode) && i == ((FlashMode) obj).m439unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m435equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @JvmStatic
    /* JADX INFO: renamed from: fromIntOrNull-2-3f5tw, reason: not valid java name */
    public static final FlashMode m436fromIntOrNull23f5tw(int i) {
        return INSTANCE.m440fromIntOrNull23f5tw(i);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m437hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m438toStringimpl(int i) {
        return "FlashMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m434equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m437hashCodeimpl(this.value);
    }

    public String toString() {
        return m438toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m439unboximpl() {
        return this.value;
    }
}
