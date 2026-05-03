package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: NewRecentListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewRecentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "clickListener", "Lcom/studiolaganne/lengendarylens/NewRecentCardClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/NewRecentCardClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewRecentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_RANDOM_CARD = 0;
    private static final int VIEW_TYPE_SIMPLE_CARD = 1;
    private final List<MTFullCard> cards;
    private final NewRecentCardClickListener clickListener;
    public static final int $stable = 8;

    public NewRecentListAdapter(List<MTFullCard> cards, NewRecentCardClickListener clickListener) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.cards = cards;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(NewRandomCardViewHolder newRandomCardViewHolder, final NewRecentListAdapter newRecentListAdapter) {
        View view = newRandomCardViewHolder.itemView;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.NewRecentListAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NewRecentListAdapter.onBindViewHolder$lambda$0$0(this.f$0);
                }
            }, 100L);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(NewRecentListAdapter newRecentListAdapter) {
        newRecentListAdapter.clickListener.onRandomCardClickNew();
    }

    static final Unit onBindViewHolder$lambda$1(NewSimpleCardViewHolder newSimpleCardViewHolder, final NewRecentListAdapter newRecentListAdapter, final MTFullCard mTFullCard) {
        View view = newSimpleCardViewHolder.itemView;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.NewRecentListAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    NewRecentListAdapter.onBindViewHolder$lambda$1$0(this.f$0, mTFullCard);
                }
            }, 100L);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$0(NewRecentListAdapter newRecentListAdapter, MTFullCard mTFullCard) {
        newRecentListAdapter.clickListener.onRecentCardClickNew(mTFullCard);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MTImageURIs mTImageURIs;
        String png;
        MTImageURIs mTImageURIs2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            final NewRandomCardViewHolder newRandomCardViewHolder = (NewRandomCardViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(newRandomCardViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.NewRecentListAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NewRecentListAdapter.onBindViewHolder$lambda$0(newRandomCardViewHolder, this);
                }
            });
            return;
        }
        final MTFullCard mTFullCard = this.cards.get(position - 1);
        final NewSimpleCardViewHolder newSimpleCardViewHolder = (NewSimpleCardViewHolder) holder;
        ViewExtensionsKt.setOnClickWithFade(newSimpleCardViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.NewRecentListAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewRecentListAdapter.onBindViewHolder$lambda$1(newSimpleCardViewHolder, this, mTFullCard);
            }
        });
        newSimpleCardViewHolder.getCardImage().setAlpha(false);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context context = newSimpleCardViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String scryfallid = mTFullCard.getScryfallid();
        if (scryfallid == null) {
            scryfallid = "";
        }
        Integer face = mTFullCard.getFace();
        CardRecord cardLocal = companion.getCardLocal(context, scryfallid, face != null ? face.intValue() : 0);
        if (cardLocal != null) {
            LoadingImageView cardImage = newSimpleCardViewHolder.getCardImage();
            String lowerCase = cardLocal.getSet().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            cardImage.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        }
        newSimpleCardViewHolder.getCardImage().reset();
        newSimpleCardViewHolder.getCardImage().setAutoLoad(false);
        List<MTImageURIs> images = mTFullCard.getImages();
        if (images == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null) {
            List<MTImageURIs> en_images = mTFullCard.getEn_images();
            if (en_images == null || (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null) {
                png = "";
            } else {
                String png2 = mTImageURIs.getPng();
                if (png2 == null && (png2 = mTImageURIs.getGatherer()) == null) {
                    png2 = "";
                }
                png = png2;
            }
        } else {
            png = mTImageURIs2.getPng();
            if (png == null && (png = mTImageURIs2.getGatherer()) == null) {
            }
        }
        if (png.length() > 0) {
            newSimpleCardViewHolder.getCardImage().loadImage(png);
            return;
        }
        MTApi mtApi = MTApiKt.getMtApi();
        String lang = mTFullCard.getLang();
        if (lang == null) {
            lang = "en";
        }
        String str = lang;
        String set_code = mTFullCard.getSet_code();
        String str2 = set_code == null ? "" : set_code;
        String collector_number = mTFullCard.getCollector_number();
        MTApi.getCardWithParameters$default(mtApi, str, str2, collector_number == null ? "" : collector_number, null, 8, null).enqueue(new Callback<MTFullCardResponse>() { // from class: com.studiolaganne.lengendarylens.NewRecentListAdapter.onBindViewHolder.6
            @Override // retrofit2.Callback
            public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[PHI: r2
              0x0039: PHI (r2v6 java.lang.String) = (r2v5 java.lang.String), (r2v11 java.lang.String), (r2v12 java.lang.String) binds: [B:24:0x0055, B:12:0x0030, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // retrofit2.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
                MTImageURIs mTImageURIs3;
                String gatherer;
                MTImageURIs mTImageURIs4;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                MTFullCardResponse mTFullCardResponseBody = response.body();
                MTFullCard card = mTFullCardResponseBody != null ? mTFullCardResponseBody.getCard() : null;
                if (card != null) {
                    NewSimpleCardViewHolder newSimpleCardViewHolder2 = newSimpleCardViewHolder;
                    List<MTImageURIs> images2 = card.getImages();
                    String str3 = "";
                    if (images2 == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) == null) {
                        List<MTImageURIs> en_images2 = card.getEn_images();
                        if (en_images2 != null && (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null) {
                            String png3 = mTImageURIs3.getPng();
                            if (png3 == null) {
                                gatherer = mTImageURIs3.getGatherer();
                                if (gatherer != null) {
                                    str3 = gatherer;
                                }
                            } else {
                                str3 = png3;
                            }
                        }
                    } else {
                        gatherer = mTImageURIs4.getPng();
                        if (gatherer != null || (gatherer = mTImageURIs4.getGatherer()) != null) {
                        }
                    }
                    if (str3.length() > 0) {
                        newSimpleCardViewHolder2.getCardImage().loadImage(str3);
                    }
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_card, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new NewRandomCardViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_card, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new NewSimpleCardViewHolder(viewInflate2, this.clickListener);
    }
}
