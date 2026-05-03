package androidx.compose.ui.unit;

import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntSize.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "width", "", "getWidth$annotations", "()V", "getWidth-impl", "(J)I", "height", "getHeight$annotations", "getHeight-impl", "component1", "component1-impl", "component2", "component2-impl", "times", "other", "times-YEO4UFw", "(JI)J", "div", "div-YEO4UFw", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class IntSize {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m9280constructorimpl(0);
    private final long packedValue;

    /* JADX INFO: compiled from: IntSize.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/IntSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m9290getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m9277boximpl(long j) {
        return new IntSize(j);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m9278component1impl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m9279component2impl(long j) {
        return (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m9280constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: div-YEO4UFw, reason: not valid java name */
    public static final long m9281divYEO4UFw(long j, int i) {
        return m9280constructorimpl((((long) (((int) (j >> 32)) / i)) << 32) | (((long) (((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / i)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9282equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m9289unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9283equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final int m9284getHeightimpl(long j) {
        return (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final int m9285getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9286hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: times-YEO4UFw, reason: not valid java name */
    public static final long m9287timesYEO4UFw(long j, int i) {
        return m9280constructorimpl((((long) (((int) (j >> 32)) * i)) << 32) | (((long) (((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) * i)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9288toStringimpl(long j) {
        return ((int) (j >> 32)) + " x " + ((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    public boolean equals(Object other) {
        return m9282equalsimpl(this.packedValue, other);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m9286hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m9288toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m9289unboximpl() {
        return this.packedValue;
    }
}
