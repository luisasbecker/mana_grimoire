package androidx.camera.camera2.pipe;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConfigQueryResult.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/ConfigQueryResult;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class ConfigQueryResult {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int UNKNOWN = m423constructorimpl(0);
    private static final int SUPPORTED = m423constructorimpl(1);
    private static final int UNSUPPORTED = m423constructorimpl(2);

    /* JADX INFO: compiled from: ConfigQueryResult.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/ConfigQueryResult$Companion;", "", "<init>", "()V", "UNKNOWN", "Landroidx/camera/camera2/pipe/ConfigQueryResult;", "getUNKNOWN-Xp6DSB4", "()I", "I", "SUPPORTED", "getSUPPORTED-Xp6DSB4", "UNSUPPORTED", "getUNSUPPORTED-Xp6DSB4", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getSUPPORTED-Xp6DSB4, reason: not valid java name */
        public final int m429getSUPPORTEDXp6DSB4() {
            return ConfigQueryResult.SUPPORTED;
        }

        /* JADX INFO: renamed from: getUNKNOWN-Xp6DSB4, reason: not valid java name */
        public final int m430getUNKNOWNXp6DSB4() {
            return ConfigQueryResult.UNKNOWN;
        }

        /* JADX INFO: renamed from: getUNSUPPORTED-Xp6DSB4, reason: not valid java name */
        public final int m431getUNSUPPORTEDXp6DSB4() {
            return ConfigQueryResult.UNSUPPORTED;
        }
    }

    private /* synthetic */ ConfigQueryResult(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ConfigQueryResult m422boximpl(int i) {
        return new ConfigQueryResult(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m423constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m424equalsimpl(int i, Object obj) {
        return (obj instanceof ConfigQueryResult) && i == ((ConfigQueryResult) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m425equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m426hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m427toStringimpl(int i) {
        return m425equalsimpl0(i, SUPPORTED) ? "SUPPORTED" : m425equalsimpl0(i, UNSUPPORTED) ? "UNSUPPORTED" : "UNKNOWN";
    }

    public boolean equals(Object obj) {
        return m424equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m426hashCodeimpl(this.value);
    }

    public String toString() {
        return m427toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
