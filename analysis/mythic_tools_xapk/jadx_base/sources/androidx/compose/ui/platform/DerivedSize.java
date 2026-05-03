package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidWindowInfo.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/DerivedSize;", "", "pxSize", "Landroidx/compose/ui/unit/IntSize;", "dpSize", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPxSize-YbymL2g", "()J", "J", "getDpSize-MYxV2XQ", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DerivedSize {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DerivedSize Zero = new DerivedSize(IntSize.INSTANCE.m9290getZeroYbymL2g(), DpSize.INSTANCE.m9222getZeroMYxV2XQ(), null);
    private final long dpSize;
    private final long pxSize;

    /* JADX INFO: compiled from: AndroidWindowInfo.android.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/DerivedSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/platform/DerivedSize;", "getZero", "()Landroidx/compose/ui/platform/DerivedSize;", "fromPxSize", "pxSize", "Landroidx/compose/ui/unit/IntSize;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "fromPxSize-viCIZxY", "(JLandroidx/compose/ui/unit/Density;)Landroidx/compose/ui/platform/DerivedSize;", "fromDpSize", "dpSize", "Landroidx/compose/ui/unit/DpSize;", "fromDpSize-itqla9I", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: fromDpSize-itqla9I, reason: not valid java name */
        public final DerivedSize m8243fromDpSizeitqla9I(long dpSize, Density density) {
            return new DerivedSize(IntSizeKt.m9296toIntSizeuvyYCjk(density.mo1625toSizeXkaWNTQ(dpSize)), dpSize, null);
        }

        /* JADX INFO: renamed from: fromPxSize-viCIZxY, reason: not valid java name */
        public final DerivedSize m8244fromPxSizeviCIZxY(long pxSize, Density density) {
            return new DerivedSize(pxSize, density.mo1622toDpSizekrfVVM(IntSizeKt.m9297toSizeozmzZPI(pxSize)), null);
        }

        public final DerivedSize getZero() {
            return DerivedSize.Zero;
        }
    }

    private DerivedSize(long j, long j2) {
        this.pxSize = j;
        this.dpSize = j2;
    }

    public /* synthetic */ DerivedSize(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DerivedSize)) {
            return false;
        }
        DerivedSize derivedSize = (DerivedSize) other;
        return IntSize.m9283equalsimpl0(this.pxSize, derivedSize.pxSize) && DpSize.m9209equalsimpl0(this.dpSize, derivedSize.dpSize);
    }

    /* JADX INFO: renamed from: getDpSize-MYxV2XQ, reason: not valid java name and from getter */
    public final long getDpSize() {
        return this.dpSize;
    }

    /* JADX INFO: renamed from: getPxSize-YbymL2g, reason: not valid java name and from getter */
    public final long getPxSize() {
        return this.pxSize;
    }

    public int hashCode() {
        return (IntSize.m9286hashCodeimpl(this.pxSize) * 31) + DpSize.m9214hashCodeimpl(this.dpSize);
    }
}
