package androidx.constraintlayout.compose;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.core.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0088\u0001\b\u0092\u0001\u00020\t¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/DebugFlags;", "", "showBounds", "", "showPaths", "showKeyPositions", "constructor-impl", "(ZZZ)I", "flags", "", "(I)I", "getShowBounds-impl", "(I)Z", "getShowKeyPositions-impl", "getShowPaths-impl", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class DebugFlags {
    private static final int BOUNDS_FLAG = 1;
    private static final int KEY_POSITIONS_FLAG = 4;
    private static final int PATHS_FLAG = 2;
    private final int flags;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m9457constructorimpl(0);
    private static final int All = m9457constructorimpl(-1);

    /* JADX INFO: compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/constraintlayout/compose/DebugFlags$Companion;", "", "()V", BaseEvent.ALL_INTEGRATIONS_KEY, "Landroidx/constraintlayout/compose/DebugFlags;", "getAll-bfy_xzQ", "()I", "I", "BOUNDS_FLAG", "", "KEY_POSITIONS_FLAG", "None", "getNone-bfy_xzQ", "PATHS_FLAG", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getAll-bfy_xzQ, reason: not valid java name */
        public final int m9468getAllbfy_xzQ() {
            return DebugFlags.All;
        }

        /* JADX INFO: renamed from: getNone-bfy_xzQ, reason: not valid java name */
        public final int m9469getNonebfy_xzQ() {
            return DebugFlags.None;
        }
    }

    private /* synthetic */ DebugFlags(int i) {
        this.flags = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DebugFlags m9456boximpl(int i) {
        return new DebugFlags(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m9457constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m9458constructorimpl(boolean z, boolean z2, boolean z3) {
        return m9457constructorimpl((z ? 1 : 0) | (z2 ? 2 : 0) | (z3 ? 4 : 0));
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ int m9459constructorimpl$default(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return m9458constructorimpl(z, z2, z3);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9460equalsimpl(int i, Object obj) {
        return (obj instanceof DebugFlags) && i == ((DebugFlags) obj).getFlags();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9461equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: getShowBounds-impl, reason: not valid java name */
    public static final boolean m9462getShowBoundsimpl(int i) {
        return (i & 1) > 0;
    }

    /* JADX INFO: renamed from: getShowKeyPositions-impl, reason: not valid java name */
    public static final boolean m9463getShowKeyPositionsimpl(int i) {
        return (i & 4) > 0;
    }

    /* JADX INFO: renamed from: getShowPaths-impl, reason: not valid java name */
    public static final boolean m9464getShowPathsimpl(int i) {
        return (i & 2) > 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9465hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9466toStringimpl(int i) {
        return "DebugFlags(showBounds = " + m9462getShowBoundsimpl(i) + ", showPaths = " + m9464getShowPathsimpl(i) + ", showKeyPositions = " + m9463getShowKeyPositionsimpl(i) + ')';
    }

    public boolean equals(Object obj) {
        return m9460equalsimpl(this.flags, obj);
    }

    public int hashCode() {
        return m9465hashCodeimpl(this.flags);
    }

    public String toString() {
        return m9466toStringimpl(this.flags);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getFlags() {
        return this.flags;
    }
}
