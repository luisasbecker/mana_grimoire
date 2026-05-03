package androidx.compose.foundation.text;

import android.R;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContextMenuIcons.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/ContextMenuIcons;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ContextMenuIcons {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: compiled from: ContextMenuIcons.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/ContextMenuIcons$Companion;", "", "<init>", "()V", "ActionModeCutDrawable", "Landroidx/compose/foundation/text/ContextMenuIcons;", "getActionModeCutDrawable-3I4p1mQ", "()I", "ActionModeCopyDrawable", "getActionModeCopyDrawable-3I4p1mQ", "ActionModePasteDrawable", "getActionModePasteDrawable-3I4p1mQ", "ActionModeSelectAllDrawable", "getActionModeSelectAllDrawable-3I4p1mQ", "ID_NULL", "getID_NULL-3I4p1mQ", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getActionModeCopyDrawable-3I4p1mQ, reason: not valid java name */
        public final int m2393getActionModeCopyDrawable3I4p1mQ() {
            return ContextMenuIcons.m2387constructorimpl(R.attr.actionModeCopyDrawable);
        }

        /* JADX INFO: renamed from: getActionModeCutDrawable-3I4p1mQ, reason: not valid java name */
        public final int m2394getActionModeCutDrawable3I4p1mQ() {
            return ContextMenuIcons.m2387constructorimpl(R.attr.actionModeCutDrawable);
        }

        /* JADX INFO: renamed from: getActionModePasteDrawable-3I4p1mQ, reason: not valid java name */
        public final int m2395getActionModePasteDrawable3I4p1mQ() {
            return ContextMenuIcons.m2387constructorimpl(R.attr.actionModePasteDrawable);
        }

        /* JADX INFO: renamed from: getActionModeSelectAllDrawable-3I4p1mQ, reason: not valid java name */
        public final int m2396getActionModeSelectAllDrawable3I4p1mQ() {
            return ContextMenuIcons.m2387constructorimpl(R.attr.actionModeSelectAllDrawable);
        }

        /* JADX INFO: renamed from: getID_NULL-3I4p1mQ, reason: not valid java name */
        public final int m2397getID_NULL3I4p1mQ() {
            return ContextMenuIcons.m2387constructorimpl(0);
        }
    }

    private /* synthetic */ ContextMenuIcons(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ContextMenuIcons m2386boximpl(int i) {
        return new ContextMenuIcons(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2387constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2388equalsimpl(int i, Object obj) {
        return (obj instanceof ContextMenuIcons) && i == ((ContextMenuIcons) obj).m2392unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2389equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2390hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2391toStringimpl(int i) {
        return "ContextMenuIcons(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m2388equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m2390hashCodeimpl(this.value);
    }

    public String toString() {
        return m2391toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2392unboximpl() {
        return this.value;
    }
}
