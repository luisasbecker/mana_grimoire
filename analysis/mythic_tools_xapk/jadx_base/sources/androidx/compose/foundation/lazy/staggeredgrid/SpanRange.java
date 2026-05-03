package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\u0088\u0001\u0002¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "", "packedValue", "", "constructor-impl", "(J)J", "lane", "", "span", "(II)J", "getPackedValue", "()J", "start", "getStart-impl", "(J)I", "end", "getEnd-impl", "size", "getSize-impl", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SpanRange {
    private final long packedValue;

    private /* synthetic */ SpanRange(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SpanRange m2271boximpl(long j) {
        return new SpanRange(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2272constructorimpl(int i, int i2) {
        return m2273constructorimpl((((long) (i2 + i)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m2273constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2274equalsimpl(long j, Object obj) {
        return (obj instanceof SpanRange) && j == ((SpanRange) obj).m2281unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2275equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m2276getEndimpl(long j) {
        return (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m2277getSizeimpl(long j) {
        return ((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & j)) - ((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m2278getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2279hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2280toStringimpl(long j) {
        return "SpanRange(packedValue=" + j + ')';
    }

    public boolean equals(Object other) {
        return m2274equalsimpl(this.packedValue, other);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m2279hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2280toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2281unboximpl() {
        return this.packedValue;
    }
}
