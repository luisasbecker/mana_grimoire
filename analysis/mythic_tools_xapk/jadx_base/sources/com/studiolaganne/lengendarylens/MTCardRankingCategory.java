package com.studiolaganne.lengendarylens;

import com.caverock.androidsvg.SVGParser;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", Rule.ALL, "PROTECTED_STAPLES", "CORE_SYNERGY", "SUPPORTING_PIECES", "OUTLIERS", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCardRankingCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MTCardRankingCategory[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String key;
    public static final MTCardRankingCategory ALL = new MTCardRankingCategory(Rule.ALL, 0, SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL);
    public static final MTCardRankingCategory PROTECTED_STAPLES = new MTCardRankingCategory("PROTECTED_STAPLES", 1, "protected_staples");
    public static final MTCardRankingCategory CORE_SYNERGY = new MTCardRankingCategory("CORE_SYNERGY", 2, "core_synergy");
    public static final MTCardRankingCategory SUPPORTING_PIECES = new MTCardRankingCategory("SUPPORTING_PIECES", 3, "supporting_pieces");
    public static final MTCardRankingCategory OUTLIERS = new MTCardRankingCategory("OUTLIERS", 4, "outliers");

    /* JADX INFO: compiled from: MTCardRankingsModels.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingCategory$Companion;", "", "<init>", "()V", "fromKey", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", SubscriberAttributeKt.JSON_NAME_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MTCardRankingCategory fromKey(String key) {
            MTCardRankingCategory mTCardRankingCategory;
            MTCardRankingCategory[] mTCardRankingCategoryArrValues = MTCardRankingCategory.values();
            int length = mTCardRankingCategoryArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    mTCardRankingCategory = null;
                    break;
                }
                mTCardRankingCategory = mTCardRankingCategoryArrValues[i];
                if (Intrinsics.areEqual(mTCardRankingCategory.getKey(), key)) {
                    break;
                }
                i++;
            }
            return mTCardRankingCategory == null ? MTCardRankingCategory.ALL : mTCardRankingCategory;
        }
    }

    private static final /* synthetic */ MTCardRankingCategory[] $values() {
        return new MTCardRankingCategory[]{ALL, PROTECTED_STAPLES, CORE_SYNERGY, SUPPORTING_PIECES, OUTLIERS};
    }

    static {
        MTCardRankingCategory[] mTCardRankingCategoryArr$values = $values();
        $VALUES = mTCardRankingCategoryArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mTCardRankingCategoryArr$values);
        INSTANCE = new Companion(null);
    }

    private MTCardRankingCategory(String str, int i, String str2) {
        this.key = str2;
    }

    public static EnumEntries<MTCardRankingCategory> getEntries() {
        return $ENTRIES;
    }

    public static MTCardRankingCategory valueOf(String str) {
        return (MTCardRankingCategory) Enum.valueOf(MTCardRankingCategory.class, str);
    }

    public static MTCardRankingCategory[] values() {
        return (MTCardRankingCategory[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }
}
