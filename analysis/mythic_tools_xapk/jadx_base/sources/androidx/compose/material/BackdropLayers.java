package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/BackdropLayers;", "", "<init>", "(Ljava/lang/String;I)V", "Back", "Front", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BackdropLayers {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackdropLayers[] $VALUES;
    public static final BackdropLayers Back = new BackdropLayers("Back", 0);
    public static final BackdropLayers Front = new BackdropLayers("Front", 1);

    private static final /* synthetic */ BackdropLayers[] $values() {
        return new BackdropLayers[]{Back, Front};
    }

    static {
        BackdropLayers[] backdropLayersArr$values = $values();
        $VALUES = backdropLayersArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(backdropLayersArr$values);
    }

    private BackdropLayers(String str, int i) {
    }

    public static EnumEntries<BackdropLayers> getEntries() {
        return $ENTRIES;
    }

    public static BackdropLayers valueOf(String str) {
        return (BackdropLayers) Enum.valueOf(BackdropLayers.class, str);
    }

    public static BackdropLayers[] values() {
        return (BackdropLayers[]) $VALUES.clone();
    }
}
