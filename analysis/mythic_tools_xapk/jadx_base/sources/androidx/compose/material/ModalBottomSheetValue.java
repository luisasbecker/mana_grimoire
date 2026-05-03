package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material/ModalBottomSheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Hidden", "Expanded", "HalfExpanded", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ModalBottomSheetValue[] $VALUES;
    public static final ModalBottomSheetValue Hidden = new ModalBottomSheetValue("Hidden", 0);
    public static final ModalBottomSheetValue Expanded = new ModalBottomSheetValue("Expanded", 1);
    public static final ModalBottomSheetValue HalfExpanded = new ModalBottomSheetValue("HalfExpanded", 2);

    private static final /* synthetic */ ModalBottomSheetValue[] $values() {
        return new ModalBottomSheetValue[]{Hidden, Expanded, HalfExpanded};
    }

    static {
        ModalBottomSheetValue[] modalBottomSheetValueArr$values = $values();
        $VALUES = modalBottomSheetValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(modalBottomSheetValueArr$values);
    }

    private ModalBottomSheetValue(String str, int i) {
    }

    public static EnumEntries<ModalBottomSheetValue> getEntries() {
        return $ENTRIES;
    }

    public static ModalBottomSheetValue valueOf(String str) {
        return (ModalBottomSheetValue) Enum.valueOf(ModalBottomSheetValue.class, str);
    }

    public static ModalBottomSheetValue[] values() {
        return (ModalBottomSheetValue[]) $VALUES.clone();
    }
}
