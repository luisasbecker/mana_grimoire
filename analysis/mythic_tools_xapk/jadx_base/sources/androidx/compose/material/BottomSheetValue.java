package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/BottomSheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Expanded", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BottomSheetValue[] $VALUES;
    public static final BottomSheetValue Collapsed = new BottomSheetValue("Collapsed", 0);
    public static final BottomSheetValue Expanded = new BottomSheetValue("Expanded", 1);

    private static final /* synthetic */ BottomSheetValue[] $values() {
        return new BottomSheetValue[]{Collapsed, Expanded};
    }

    static {
        BottomSheetValue[] bottomSheetValueArr$values = $values();
        $VALUES = bottomSheetValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bottomSheetValueArr$values);
    }

    private BottomSheetValue(String str, int i) {
    }

    public static EnumEntries<BottomSheetValue> getEntries() {
        return $ENTRIES;
    }

    public static BottomSheetValue valueOf(String str) {
        return (BottomSheetValue) Enum.valueOf(BottomSheetValue.class, str);
    }

    public static BottomSheetValue[] values() {
        return (BottomSheetValue[]) $VALUES.clone();
    }
}
