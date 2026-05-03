package com.studiolaganne.lengendarylens;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardSetManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rR*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardSetsManager;", "", "<init>", "()V", "value", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "cardSets", "getCardSets", "()Ljava/util/List;", "frCardSets", "getFrCardSets", "loadCardSets", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardSetsManager {
    public static final CardSetsManager INSTANCE = new CardSetsManager();
    private static List<CardSet> cardSets = CollectionsKt.emptyList();
    private static List<CardSet> frCardSets = CollectionsKt.emptyList();
    public static final int $stable = 8;

    private CardSetsManager() {
    }

    public final List<CardSet> getCardSets() {
        return cardSets;
    }

    public final List<CardSet> getFrCardSets() {
        return frCardSets;
    }

    public final void loadCardSets() {
        try {
            Context contextApplicationContext = LegendaryLensApplication.INSTANCE.applicationContext();
            cardSets = SetsDBHelper.INSTANCE.getInstance(contextApplicationContext).getSets();
            PreferencesManager preferencesManager = new PreferencesManager(contextApplicationContext);
            if (!Intrinsics.areEqual(preferencesManager.getDeviceLanguage(), "fr") && !preferencesManager.isLanguageEnabled("fr")) {
                return;
            }
            frCardSets = SetsDBHelperLocalized.INSTANCE.getInstance(contextApplicationContext, "fr").getSets();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
