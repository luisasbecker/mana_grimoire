package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/BackdropValue;", "", "<init>", "(Ljava/lang/String;I)V", "Concealed", "Revealed", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackdropValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackdropValue[] $VALUES;
    public static final BackdropValue Concealed = new BackdropValue("Concealed", 0);
    public static final BackdropValue Revealed = new BackdropValue("Revealed", 1);

    private static final /* synthetic */ BackdropValue[] $values() {
        return new BackdropValue[]{Concealed, Revealed};
    }

    static {
        BackdropValue[] backdropValueArr$values = $values();
        $VALUES = backdropValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(backdropValueArr$values);
    }

    private BackdropValue(String str, int i) {
    }

    public static EnumEntries<BackdropValue> getEntries() {
        return $ENTRIES;
    }

    public static BackdropValue valueOf(String str) {
        return (BackdropValue) Enum.valueOf(BackdropValue.class, str);
    }

    public static BackdropValue[] values() {
        return (BackdropValue[]) $VALUES.clone();
    }
}
