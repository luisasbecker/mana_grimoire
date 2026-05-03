package androidx.compose.ui.graphics;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PathFillType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/PathFillType;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class PathFillType {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NonZero = m6615constructorimpl(0);
    private static final int EvenOdd = m6615constructorimpl(1);

    /* JADX INFO: compiled from: PathFillType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/PathFillType$Companion;", "", "<init>", "()V", "NonZero", "Landroidx/compose/ui/graphics/PathFillType;", "getNonZero-Rg-k1Os", "()I", "I", "EvenOdd", "getEvenOdd-Rg-k1Os", "ui-graphics"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getEvenOdd-Rg-k1Os, reason: not valid java name */
        public final int m6621getEvenOddRgk1Os() {
            return PathFillType.EvenOdd;
        }

        /* JADX INFO: renamed from: getNonZero-Rg-k1Os, reason: not valid java name */
        public final int m6622getNonZeroRgk1Os() {
            return PathFillType.NonZero;
        }
    }

    private /* synthetic */ PathFillType(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathFillType m6614boximpl(int i) {
        return new PathFillType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m6615constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6616equalsimpl(int i, Object obj) {
        return (obj instanceof PathFillType) && i == ((PathFillType) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6617equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6618hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6619toStringimpl(int i) {
        return m6617equalsimpl0(i, NonZero) ? "NonZero" : m6617equalsimpl0(i, EvenOdd) ? "EvenOdd" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object other) {
        return m6616equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m6618hashCodeimpl(this.value);
    }

    public String toString() {
        return m6619toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
