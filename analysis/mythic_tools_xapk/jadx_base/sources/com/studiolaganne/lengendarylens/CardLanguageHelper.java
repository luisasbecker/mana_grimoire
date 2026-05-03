package com.studiolaganne.lengendarylens;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardLanguageHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJD\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardLanguageHelper;", "", "context", "Landroid/content/Context;", "dbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "dbHelpers", "", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "<init>", "(Landroid/content/Context;Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;)V", "getCardLanguageRows", "Lcom/studiolaganne/lengendarylens/CardLanguageRow;", "cardTitle", "", "cardLang", "oracleId", "scId", "setCode", "cardNumber", OptionalModuleUtils.FACE, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardLanguageHelper {
    public static final int $stable = 8;
    private final Context context;
    private final MTGDBHelper dbHelper;
    private final List<MTGDBHelperLocalized> dbHelpers;

    public CardLanguageHelper(Context context, MTGDBHelper dbHelper, List<MTGDBHelperLocalized> dbHelpers) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(dbHelpers, "dbHelpers");
        this.context = context;
        this.dbHelper = dbHelper;
        this.dbHelpers = dbHelpers;
    }

    public final List<CardLanguageRow> getCardLanguageRows(String cardTitle, String cardLang, String oracleId, String scId, String setCode, String cardNumber, int face) {
        String scryfall_id;
        CardRecord cardByOracleIdAndPrintData;
        CardRecord cardByOracleIdAndPrintData2;
        String cardTitle2 = cardTitle;
        Intrinsics.checkNotNullParameter(cardTitle2, "cardTitle");
        Intrinsics.checkNotNullParameter(cardLang, "cardLang");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(scId, "scId");
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        ArrayList arrayList = new ArrayList();
        if (Intrinsics.areEqual(cardLang, "en") || (cardByOracleIdAndPrintData2 = this.dbHelper.getCardByOracleIdAndPrintData(oracleId, setCode, cardNumber, face)) == null) {
            scryfall_id = scId;
        } else {
            cardTitle2 = cardByOracleIdAndPrintData2.getTitle();
            scryfall_id = cardByOracleIdAndPrintData2.getScryfall_id();
        }
        arrayList.add(new CardLanguageRow("en", cardTitle2, scryfall_id, "", "", null, 32, null));
        for (MTGDBHelperLocalized mTGDBHelperLocalized : this.dbHelpers) {
            if (mTGDBHelperLocalized.hasDBInAppContext() && mTGDBHelperLocalized.isValid() && (cardByOracleIdAndPrintData = mTGDBHelperLocalized.getCardByOracleIdAndPrintData(oracleId, setCode, cardNumber, face)) != null) {
                arrayList.add(new CardLanguageRow(mTGDBHelperLocalized.getLocale(), cardByOracleIdAndPrintData.getTitle(), cardByOracleIdAndPrintData.getScryfall_id(), cardByOracleIdAndPrintData.getOracle_id(), cardByOracleIdAndPrintData.getType_line(), cardByOracleIdAndPrintData.getOracle_text()));
            }
        }
        return arrayList;
    }
}
