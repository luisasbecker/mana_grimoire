package androidx.camera.camera2.pipe;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraControls.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/Lock3ABehavior;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class Lock3ABehavior {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int IMMEDIATE = m512constructorimpl(1);
    private static final int AFTER_CURRENT_SCAN = m512constructorimpl(2);
    private static final int AFTER_NEW_SCAN = m512constructorimpl(3);

    /* JADX INFO: compiled from: CameraControls.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/Lock3ABehavior$Companion;", "", "<init>", "()V", "IMMEDIATE", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "getIMMEDIATE-hRqSH3k", "()I", "I", "AFTER_CURRENT_SCAN", "getAFTER_CURRENT_SCAN-hRqSH3k", "AFTER_NEW_SCAN", "getAFTER_NEW_SCAN-hRqSH3k", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getAFTER_CURRENT_SCAN-hRqSH3k, reason: not valid java name */
        public final int m518getAFTER_CURRENT_SCANhRqSH3k() {
            return Lock3ABehavior.AFTER_CURRENT_SCAN;
        }

        /* JADX INFO: renamed from: getAFTER_NEW_SCAN-hRqSH3k, reason: not valid java name */
        public final int m519getAFTER_NEW_SCANhRqSH3k() {
            return Lock3ABehavior.AFTER_NEW_SCAN;
        }

        /* JADX INFO: renamed from: getIMMEDIATE-hRqSH3k, reason: not valid java name */
        public final int m520getIMMEDIATEhRqSH3k() {
            return Lock3ABehavior.IMMEDIATE;
        }
    }

    private /* synthetic */ Lock3ABehavior(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Lock3ABehavior m511boximpl(int i) {
        return new Lock3ABehavior(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m512constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m513equalsimpl(int i, Object obj) {
        return (obj instanceof Lock3ABehavior) && i == ((Lock3ABehavior) obj).m517unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m514equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m515hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m516toStringimpl(int i) {
        return "Lock3ABehavior(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m513equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m515hashCodeimpl(this.value);
    }

    public String toString() {
        return m516toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m517unboximpl() {
        return this.value;
    }
}
