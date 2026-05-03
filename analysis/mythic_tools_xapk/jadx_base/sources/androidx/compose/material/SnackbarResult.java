package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/SnackbarResult;", "", "<init>", "(Ljava/lang/String;I)V", "Dismissed", "ActionPerformed", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SnackbarResult[] $VALUES;
    public static final SnackbarResult Dismissed = new SnackbarResult("Dismissed", 0);
    public static final SnackbarResult ActionPerformed = new SnackbarResult("ActionPerformed", 1);

    private static final /* synthetic */ SnackbarResult[] $values() {
        return new SnackbarResult[]{Dismissed, ActionPerformed};
    }

    static {
        SnackbarResult[] snackbarResultArr$values = $values();
        $VALUES = snackbarResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(snackbarResultArr$values);
    }

    private SnackbarResult(String str, int i) {
    }

    public static EnumEntries<SnackbarResult> getEntries() {
        return $ENTRIES;
    }

    public static SnackbarResult valueOf(String str) {
        return (SnackbarResult) Enum.valueOf(SnackbarResult.class, str);
    }

    public static SnackbarResult[] values() {
        return (SnackbarResult[]) $VALUES.clone();
    }
}
