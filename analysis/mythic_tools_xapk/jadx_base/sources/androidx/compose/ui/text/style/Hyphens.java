package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Hyphens.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Hyphens {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m8878constructorimpl(1);
    private static final int Auto = m8878constructorimpl(2);
    private static final int Unspecified = m8878constructorimpl(0);

    /* JADX INFO: compiled from: Hyphens.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/Hyphens;", "getNone-vmbZdU8", "()I", "I", "Auto", "getAuto-vmbZdU8", "Unspecified", "getUnspecified-vmbZdU8", "valueOf", "value", "", "valueOf-kPa1_AA", "(I)I", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getAuto-vmbZdU8, reason: not valid java name */
        public final int m8884getAutovmbZdU8() {
            return Hyphens.Auto;
        }

        /* JADX INFO: renamed from: getNone-vmbZdU8, reason: not valid java name */
        public final int m8885getNonevmbZdU8() {
            return Hyphens.None;
        }

        /* JADX INFO: renamed from: getUnspecified-vmbZdU8, reason: not valid java name */
        public final int m8886getUnspecifiedvmbZdU8() {
            return Hyphens.Unspecified;
        }

        /* JADX INFO: renamed from: valueOf-kPa1_AA, reason: not valid java name */
        public final int m8887valueOfkPa1_AA(int value) {
            boolean z = false;
            if (value >= 0 && value < 3) {
                z = true;
            }
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + value + " is not recognized by Hyphens.");
            }
            return Hyphens.m8878constructorimpl(value);
        }
    }

    private /* synthetic */ Hyphens(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Hyphens m8877boximpl(int i) {
        return new Hyphens(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m8878constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8879equalsimpl(int i, Object obj) {
        return (obj instanceof Hyphens) && i == ((Hyphens) obj).m8883unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8880equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8881hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8882toStringimpl(int i) {
        return m8880equalsimpl0(i, None) ? "Hyphens.None" : m8880equalsimpl0(i, Auto) ? "Hyphens.Auto" : m8880equalsimpl0(i, Unspecified) ? "Hyphens.Unspecified" : "Invalid";
    }

    public boolean equals(Object other) {
        return m8879equalsimpl(this.value, other);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m8881hashCodeimpl(this.value);
    }

    public String toString() {
        return m8882toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m8883unboximpl() {
        return this.value;
    }
}
