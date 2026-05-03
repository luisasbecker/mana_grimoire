package androidx.camera.camera2.pipe.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: Timestamps.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u000e\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/core/TimestampNs;", "", "value", "", "constructor-impl", "(J)J", "getValue", "()J", "minus", "Landroidx/camera/camera2/pipe/core/DurationNs;", "other", "minus-pEw-518", "(JJ)J", "plus", "plus-rKz7-cU", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class TimestampNs {
    private final long value;

    private /* synthetic */ TimestampNs(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TimestampNs m881boximpl(long j) {
        return new TimestampNs(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m882constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m883equalsimpl(long j, Object obj) {
        return (obj instanceof TimestampNs) && j == ((TimestampNs) obj).m889unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m884equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m885hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: minus-pEw-518, reason: not valid java name */
    public static final long m886minuspEw518(long j, long j2) {
        return DurationNs.m870constructorimpl(j - j2);
    }

    /* JADX INFO: renamed from: plus-rKz7-cU, reason: not valid java name */
    public static final long m887plusrKz7cU(long j, long j2) {
        return m882constructorimpl(j + j2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m888toStringimpl(long j) {
        return "TimestampNs(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m883equalsimpl(this.value, obj);
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        return m885hashCodeimpl(this.value);
    }

    public String toString() {
        return m888toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m889unboximpl() {
        return this.value;
    }
}
