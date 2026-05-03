package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: SchemeListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/SchemeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cards", "", "", "clickListener", "Lcom/studiolaganne/lengendarylens/SchemeClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/SchemeClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SchemeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_SCHEME_CARD = 1;
    private final List<String> cards;
    private final SchemeClickListener clickListener;
    public static final int $stable = 8;

    public SchemeListAdapter(List<String> cards, SchemeClickListener clickListener) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.cards = cards;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(SchemeViewHolder schemeViewHolder, final SchemeListAdapter schemeListAdapter, final String str) {
        schemeViewHolder.itemView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SchemeListAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SchemeListAdapter.onBindViewHolder$lambda$0$0(this.f$0, str);
            }
        }, 100L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(SchemeListAdapter schemeListAdapter, String str) {
        schemeListAdapter.clickListener.onSchemeClick(str);
    }

    static final Unit onBindViewHolder$lambda$1(SchemeViewHolder schemeViewHolder, final SchemeListAdapter schemeListAdapter, final String str) {
        schemeViewHolder.itemView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SchemeListAdapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SchemeListAdapter.onBindViewHolder$lambda$1$0(this.f$0, str);
            }
        }, 100L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$0(SchemeListAdapter schemeListAdapter, String str) {
        schemeListAdapter.clickListener.onDeleteSchemeClick(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final String str = this.cards.get(position);
        final SchemeViewHolder schemeViewHolder = (SchemeViewHolder) holder;
        ViewExtensionsKt.setOnClickWithFade(schemeViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SchemeListAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SchemeListAdapter.onBindViewHolder$lambda$0(schemeViewHolder, this, str);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(schemeViewHolder.getCloseLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SchemeListAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SchemeListAdapter.onBindViewHolder$lambda$1(schemeViewHolder, this, str);
            }
        });
        schemeViewHolder.getCardImage().reset();
        schemeViewHolder.getCardImage().setAutoLoad(false);
        CardImageCache cardImageCache = CardImageCache.INSTANCE;
        Context context = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String imageUrl = cardImageCache.getImageUrl(context, str, 0);
        if (imageUrl != null) {
            schemeViewHolder.getCardImage().loadImage(imageUrl);
        } else {
            MTApiKt.getMtApi().getCardByScryfallId(str).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.SchemeListAdapter$onBindViewHolder$4$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        MTCardResponse mTCardResponseBody = response.body();
                        MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                        String imageUrl2 = card != null ? card.getImageUrl(0) : null;
                        String str2 = imageUrl2;
                        if (str2 == null || str2.length() == 0) {
                            return;
                        }
                        CardImageCache cardImageCache2 = CardImageCache.INSTANCE;
                        Context context2 = holder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        cardImageCache2.saveImageUrl(context2, str, imageUrl2, 0);
                        schemeViewHolder.getCardImage().loadImage(imageUrl2);
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.scheme_card, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new SchemeViewHolder(viewInflate, this.clickListener);
    }
}
