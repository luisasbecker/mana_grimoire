package com.studiolaganne.lengendarylens;

import com.facebook.appevents.internal.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: CardLanguageAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;", "", "onCardLanguageClick", "", "newScId", "", "oracleId", Constants.GP_IAP_TITLE, "language", "typeLine", "oracle", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CardLanguageClickListener {
    void onCardLanguageClick(String newScId, String oracleId, String title, String language, String typeLine, String oracle);
}
