package androidx.compose.material3;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/TimePickerSelectionMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TimePickerSelectionMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Hour = m4352constructorimpl(0);
    private static final int Minute = m4352constructorimpl(1);
    private final int value;

    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/TimePickerSelectionMode$Companion;", "", "<init>", "()V", "Hour", "Landroidx/compose/material3/TimePickerSelectionMode;", "getHour-yecRtBI", "()I", "I", "Minute", "getMinute-yecRtBI", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getHour-yecRtBI, reason: not valid java name */
        public final int m4358getHouryecRtBI() {
            return TimePickerSelectionMode.Hour;
        }

        /* JADX INFO: renamed from: getMinute-yecRtBI, reason: not valid java name */
        public final int m4359getMinuteyecRtBI() {
            return TimePickerSelectionMode.Minute;
        }
    }

    private /* synthetic */ TimePickerSelectionMode(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TimePickerSelectionMode m4351boximpl(int i) {
        return new TimePickerSelectionMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m4352constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4353equalsimpl(int i, Object obj) {
        return (obj instanceof TimePickerSelectionMode) && i == ((TimePickerSelectionMode) obj).m4357unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4354equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4355hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4356toStringimpl(int i) {
        return m4354equalsimpl0(i, Hour) ? "Hour" : m4354equalsimpl0(i, Minute) ? "Minute" : "";
    }

    public boolean equals(Object other) {
        return m4353equalsimpl(this.value, other);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m4355hashCodeimpl(this.value);
    }

    public String toString() {
        return m4356toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4357unboximpl() {
        return this.value;
    }
}
