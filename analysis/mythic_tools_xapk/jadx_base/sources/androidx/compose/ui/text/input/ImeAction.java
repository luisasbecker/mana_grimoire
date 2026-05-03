package androidx.compose.ui.text.input;

import androidx.webkit.Profile;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImeAction.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/input/ImeAction;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ImeAction {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m8728constructorimpl(-1);
    private static final int Default = m8728constructorimpl(1);
    private static final int None = m8728constructorimpl(0);
    private static final int Go = m8728constructorimpl(2);
    private static final int Search = m8728constructorimpl(3);
    private static final int Send = m8728constructorimpl(4);
    private static final int Previous = m8728constructorimpl(5);
    private static final int Next = m8728constructorimpl(6);
    private static final int Done = m8728constructorimpl(7);

    /* JADX INFO: compiled from: ImeAction.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/input/ImeAction$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/text/input/ImeAction;", "getUnspecified-eUduSuo$annotations", "getUnspecified-eUduSuo", "()I", "I", Profile.DEFAULT_PROFILE_NAME, "getDefault-eUduSuo$annotations", "getDefault-eUduSuo", "None", "getNone-eUduSuo$annotations", "getNone-eUduSuo", "Go", "getGo-eUduSuo$annotations", "getGo-eUduSuo", "Search", "getSearch-eUduSuo$annotations", "getSearch-eUduSuo", "Send", "getSend-eUduSuo$annotations", "getSend-eUduSuo", "Previous", "getPrevious-eUduSuo$annotations", "getPrevious-eUduSuo", "Next", "getNext-eUduSuo$annotations", "getNext-eUduSuo", "Done", "getDone-eUduSuo$annotations", "getDone-eUduSuo", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDefault-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8734getDefaulteUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getDone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8735getDoneeUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getGo-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8736getGoeUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getNext-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8737getNexteUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getNone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8738getNoneeUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getPrevious-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8739getPreviouseUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getSearch-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8740getSearcheUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getSend-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8741getSendeUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m8742getUnspecifiedeUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m8743getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* JADX INFO: renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m8744getDoneeUduSuo() {
            return ImeAction.Done;
        }

        /* JADX INFO: renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m8745getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* JADX INFO: renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m8746getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* JADX INFO: renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m8747getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* JADX INFO: renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m8748getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* JADX INFO: renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m8749getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* JADX INFO: renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m8750getSendeUduSuo() {
            return ImeAction.Send;
        }

        /* JADX INFO: renamed from: getUnspecified-eUduSuo, reason: not valid java name */
        public final int m8751getUnspecifiedeUduSuo() {
            return ImeAction.Unspecified;
        }
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m8727boximpl(int i) {
        return new ImeAction(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m8728constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8729equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8730equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8731hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8732toStringimpl(int i) {
        return m8730equalsimpl0(i, Unspecified) ? "Unspecified" : m8730equalsimpl0(i, None) ? "None" : m8730equalsimpl0(i, Default) ? Profile.DEFAULT_PROFILE_NAME : m8730equalsimpl0(i, Go) ? "Go" : m8730equalsimpl0(i, Search) ? "Search" : m8730equalsimpl0(i, Send) ? "Send" : m8730equalsimpl0(i, Previous) ? "Previous" : m8730equalsimpl0(i, Next) ? "Next" : m8730equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    public boolean equals(Object other) {
        return m8729equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m8731hashCodeimpl(this.value);
    }

    public String toString() {
        return m8732toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
