package kotlin.ranges;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ULongRange.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001dB\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0015\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\f\u001a\u00020\u00038VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006\u001e"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "isEmpty", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ULongRange EMPTY = new ULongRange(-1, 0, null);

    /* JADX INFO: compiled from: ULongRange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }

    private ULongRange(long j, long j2) {
        super(j, j2, 1L, null);
    }

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m12696getEndExclusivesVKNKU$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m12697containsVKZWuLQ(((ULong) comparable).getData());
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m12697containsVKZWuLQ(long value) {
        return Long.compareUnsigned(getFirst(), value) <= 0 && Long.compareUnsigned(value, getLast()) <= 0;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object other) {
        if (!(other instanceof ULongRange)) {
            return false;
        }
        if (isEmpty() && ((ULongRange) other).isEmpty()) {
            return true;
        }
        ULongRange uLongRange = (ULongRange) other;
        return getFirst() == uLongRange.getFirst() && getLast() == uLongRange.getLast();
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return ULong.m11613boximpl(m12698getEndExclusivesVKNKU());
    }

    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m12698getEndExclusivesVKNKU() {
        if (getLast() != -1) {
            return ULong.m11619constructorimpl(getLast() + ULong.m11619constructorimpl(1L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return ULong.m11613boximpl(m12699getEndInclusivesVKNKU());
    }

    /* JADX INFO: renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m12699getEndInclusivesVKNKU() {
        return getLast();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return ULong.m11613boximpl(m12700getStartsVKNKU());
    }

    /* JADX INFO: renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m12700getStartsVKNKU() {
        return getFirst();
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m11619constructorimpl(getFirst() ^ ULong.m11619constructorimpl(getFirst() >>> 32))) * 31) + ((int) ULong.m11619constructorimpl(getLast() ^ ULong.m11619constructorimpl(getLast() >>> 32)));
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Long.compareUnsigned(getFirst(), getLast()) > 0;
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ((Object) ULong.m11665toStringimpl(getFirst())) + ".." + ((Object) ULong.m11665toStringimpl(getLast()));
    }
}
