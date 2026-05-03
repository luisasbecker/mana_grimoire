package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/* JADX INFO: compiled from: ScryFallApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H'¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScryfallApi;", "", "getCardById", "Lretrofit2/Call;", "Lcom/studiolaganne/lengendarylens/Card;", "cardId", "", "getCardRulings", "Lcom/studiolaganne/lengendarylens/Rules;", "url", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ScryfallApi {
    @GET("cards/{cardId}")
    Call<Card> getCardById(@Path("cardId") String cardId);

    @GET
    Call<Rules> getCardRulings(@Url String url);
}
