package com.studiolaganne.lengendarylens;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCoreSynergyBadge;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "THEME", "ROLE", "DECK_FIT", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCoreSynergyBadge {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MTCoreSynergyBadge[] $VALUES;
    private final String key;
    public static final MTCoreSynergyBadge THEME = new MTCoreSynergyBadge("THEME", 0, "theme");
    public static final MTCoreSynergyBadge ROLE = new MTCoreSynergyBadge("ROLE", 1, "role");
    public static final MTCoreSynergyBadge DECK_FIT = new MTCoreSynergyBadge("DECK_FIT", 2, "deck_fit");

    private static final /* synthetic */ MTCoreSynergyBadge[] $values() {
        return new MTCoreSynergyBadge[]{THEME, ROLE, DECK_FIT};
    }

    static {
        MTCoreSynergyBadge[] mTCoreSynergyBadgeArr$values = $values();
        $VALUES = mTCoreSynergyBadgeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mTCoreSynergyBadgeArr$values);
    }

    private MTCoreSynergyBadge(String str, int i, String str2) {
        this.key = str2;
    }

    public static EnumEntries<MTCoreSynergyBadge> getEntries() {
        return $ENTRIES;
    }

    public static MTCoreSynergyBadge valueOf(String str) {
        return (MTCoreSynergyBadge) Enum.valueOf(MTCoreSynergyBadge.class, str);
    }

    public static MTCoreSynergyBadge[] values() {
        return (MTCoreSynergyBadge[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }
}
