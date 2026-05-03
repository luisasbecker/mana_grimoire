package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardsLayout;", "", "<init>", "(Ljava/lang/String;I)V", "GRID_BY_2", "GRID_BY_3", "LIST", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardsLayout {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CardsLayout[] $VALUES;
    public static final CardsLayout GRID_BY_2 = new CardsLayout("GRID_BY_2", 0);
    public static final CardsLayout GRID_BY_3 = new CardsLayout("GRID_BY_3", 1);
    public static final CardsLayout LIST = new CardsLayout("LIST", 2);

    private static final /* synthetic */ CardsLayout[] $values() {
        return new CardsLayout[]{GRID_BY_2, GRID_BY_3, LIST};
    }

    static {
        CardsLayout[] cardsLayoutArr$values = $values();
        $VALUES = cardsLayoutArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cardsLayoutArr$values);
    }

    private CardsLayout(String str, int i) {
    }

    public static EnumEntries<CardsLayout> getEntries() {
        return $ENTRIES;
    }

    public static CardsLayout valueOf(String str) {
        return (CardsLayout) Enum.valueOf(CardsLayout.class, str);
    }

    public static CardsLayout[] values() {
        return (CardsLayout[]) $VALUES.clone();
    }
}
