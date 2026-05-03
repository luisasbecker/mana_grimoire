package com.studiolaganne.lengendarylens;

import android.content.Context;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: DeckUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007JF\u0010\u0004\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\fj\u0002`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\fj\u0002`\u0010JN\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\fj\u0002`\u00142\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\fj\u0002`\u0015JF\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000f2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\fj\u0002`\u00142\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\fj\u0002`\u0015¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckUtils;", "", "<init>", "()V", "fetchDeckData", "Lcom/studiolaganne/lengendarylens/MTDeckData;", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "", "context", "Landroid/content/Context;", "successCallback", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/DataSuccessCallback;", "errorCallback", "", "Lcom/studiolaganne/lengendarylens/DataErrorCallback;", "fetchPlaymatURL", "side", "Lcom/studiolaganne/lengendarylens/MTPlaymatData;", "Lcom/studiolaganne/lengendarylens/PlaymatSuccessCallback;", "Lcom/studiolaganne/lengendarylens/PlaymatErrorCallback;", "playmatIdStr", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile DeckUtils instance;

    /* JADX INFO: compiled from: DeckUtils.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckUtils$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/DeckUtils;", "getInstance", "extractIdAndFace", "Lkotlin/Pair;", "", "", "identifier", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<String, Integer> extractIdAndFace(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            if (StringsKt.startsWith$default(identifier, "id:", false, 2, (Object) null)) {
                identifier = identifier.substring(3);
                Intrinsics.checkNotNullExpressionValue(identifier, "substring(...)");
            }
            String str = identifier;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                return TuplesKt.to(identifier, 0);
            }
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
            return TuplesKt.to(listSplit$default.get(0), Integer.valueOf(Integer.parseInt((String) listSplit$default.get(1))));
        }

        public final synchronized DeckUtils getInstance() {
            DeckUtils deckUtils;
            if (DeckUtils.instance == null) {
                DeckUtils.instance = new DeckUtils();
            }
            deckUtils = DeckUtils.instance;
            Intrinsics.checkNotNull(deckUtils);
            return deckUtils;
        }
    }

    public final MTDeckData fetchDeckData(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        ArrayList arrayList = new ArrayList();
        String colors = deck.getColors();
        boolean z = colors == null || colors.length() == 0;
        boolean z2 = !z;
        if (!z) {
            String colors2 = deck.getColors();
            Intrinsics.checkNotNull(colors2);
            char[] charArray = colors2.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            for (char c : charArray) {
                String strValueOf = String.valueOf(c);
                if (strValueOf.length() > 0 && !arrayList.contains(strValueOf)) {
                    arrayList.add(strValueOf);
                }
            }
        }
        String rightplaymat_image = deck.getRightplaymat_image();
        if (rightplaymat_image == null) {
            rightplaymat_image = "";
        }
        return new MTDeckData(rightplaymat_image, Intrinsics.areEqual(deck.getRightplaymat_image_type(), "art_crop"), z2, arrayList);
    }

    public final void fetchDeckData(Context context, MTDeck deck, Function1<? super MTDeckData, Unit> successCallback, Function1<? super String, Unit> errorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deck, "deck");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        successCallback.invoke(fetchDeckData(deck));
    }

    public final void fetchPlaymatURL(Context context, MTDeck deck, String side, Function1<? super MTPlaymatData, Unit> successCallback, Function1<? super String, Unit> errorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deck, "deck");
        Intrinsics.checkNotNullParameter(side, "side");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        String leftplaymat_image = Intrinsics.areEqual(side, ViewHierarchyConstants.DIMENSION_LEFT_KEY) ? deck.getLeftplaymat_image() : deck.getRightplaymat_image();
        String leftplaymat_image_type = Intrinsics.areEqual(side, ViewHierarchyConstants.DIMENSION_LEFT_KEY) ? deck.getLeftplaymat_image_type() : deck.getRightplaymat_image_type();
        String str = leftplaymat_image;
        if (str != null && str.length() != 0) {
            successCallback.invoke(new MTPlaymatData(leftplaymat_image, Intrinsics.areEqual(leftplaymat_image_type, "art_crop")));
            return;
        }
        String leftplaymat = Intrinsics.areEqual(side, ViewHierarchyConstants.DIMENSION_LEFT_KEY) ? deck.getLeftplaymat() : deck.getRightplaymat();
        String str2 = leftplaymat;
        if (str2 == null || str2.length() == 0) {
            errorCallback.invoke("No playmat ID");
        } else {
            fetchPlaymatURL(context, leftplaymat, successCallback, errorCallback);
        }
    }

    public final void fetchPlaymatURL(final Context context, String playmatIdStr, final Function1<? super MTPlaymatData, Unit> successCallback, final Function1<? super String, Unit> errorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playmatIdStr, "playmatIdStr");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        final MTPlaymatData mTPlaymatData = new MTPlaymatData("", false, 2, null);
        Pair<String, Integer> pairExtractIdAndFace = INSTANCE.extractIdAndFace(playmatIdStr);
        final String strComponent1 = pairExtractIdAndFace.component1();
        final int iIntValue = pairExtractIdAndFace.component2().intValue();
        String imageUrl = CardImageCache.INSTANCE.getImageUrl(context, strComponent1, iIntValue);
        String str = imageUrl;
        if (str == null || str.length() == 0) {
            MTApiKt.getMtApi().getCardByScryfallId(strComponent1).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.DeckUtils.fetchPlaymatURL.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    errorCallback.invoke("API call failed: " + t.getMessage());
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful()) {
                        errorCallback.invoke("Failed to fetch card details: " + response.message());
                        return;
                    }
                    MTCardResponse mTCardResponseBody = response.body();
                    MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                    String imageUrl2 = card != null ? card.getImageUrl(iIntValue) : null;
                    String str2 = imageUrl2;
                    if (str2 == null || str2.length() == 0) {
                        errorCallback.invoke("Image URL not found for card.");
                        return;
                    }
                    CardImageCache.INSTANCE.saveImageUrl(context, strComponent1, imageUrl2, iIntValue);
                    mTPlaymatData.setPlaymatImageURL(imageUrl2);
                    successCallback.invoke(mTPlaymatData);
                }
            });
        } else {
            mTPlaymatData.setPlaymatImageURL(imageUrl);
            successCallback.invoke(mTPlaymatData);
        }
    }
}
