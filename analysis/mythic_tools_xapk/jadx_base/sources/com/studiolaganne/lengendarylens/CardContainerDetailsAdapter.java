package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.ui.ColorKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CardContainerDetailsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001bB\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/studiolaganne/lengendarylens/SimpleMTFullCardClickListener;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/CardContainerDetailsItemHolder;", "clickListener", "Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;)V", "onMTFullCardClick", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardContainerDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SimpleMTFullCardClickListener {
    public static final int VIEW_TYPE_CONTAINER = 1;
    public static final int VIEW_TYPE_SEPARATOR = 2;
    private final CardContainerDetailsClickListener clickListener;
    private final List<CardContainerDetailsItemHolder> items;
    public static final int $stable = 8;

    public CardContainerDetailsAdapter(List<CardContainerDetailsItemHolder> items, CardContainerDetailsClickListener clickListener) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.items = items;
        this.clickListener = clickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(CardContainerDetailsAdapter cardContainerDetailsAdapter, MTCardContainer mTCardContainer) {
        cardContainerDetailsAdapter.clickListener.onCardContainerDetailsClick(mTCardContainer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$1(CardContainerDetailsAdapter cardContainerDetailsAdapter, MTCardContainer mTCardContainer) {
        cardContainerDetailsAdapter.clickListener.onCardContainerEditClick(mTCardContainer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$2(CardContainerDetailsAdapter cardContainerDetailsAdapter, MTCardContainer mTCardContainer) {
        cardContainerDetailsAdapter.clickListener.onCardContainerDeleteClick(mTCardContainer);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String separator;
        boolean z;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CardContainerDetailsItemHolder cardContainerDetailsItemHolder = this.items.get(position);
        if (!(holder instanceof CardContainerDetailsViewHolder)) {
            if (!(holder instanceof CardContainerDetailsSeparatorViewHolder) || (separator = cardContainerDetailsItemHolder.getSeparator()) == null) {
                return;
            }
            ((CardContainerDetailsSeparatorViewHolder) holder).getSeparatorText().setText(separator);
            return;
        }
        final MTCardContainer container = cardContainerDetailsItemHolder.getContainer();
        if (container != null) {
            CardContainerDetailsViewHolder cardContainerDetailsViewHolder = (CardContainerDetailsViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(cardContainerDetailsViewHolder.getViewListButtonLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.CardContainerDetailsAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardContainerDetailsAdapter.onBindViewHolder$lambda$0$0(this.f$0, container);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(cardContainerDetailsViewHolder.getEditActionTextView(), new Function0() { // from class: com.studiolaganne.lengendarylens.CardContainerDetailsAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardContainerDetailsAdapter.onBindViewHolder$lambda$0$1(this.f$0, container);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(cardContainerDetailsViewHolder.getDeleteActionTextView(), new Function0() { // from class: com.studiolaganne.lengendarylens.CardContainerDetailsAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardContainerDetailsAdapter.onBindViewHolder$lambda$0$2(this.f$0, container);
                }
            });
            String name = container.getName();
            if (container.getId() == 1) {
                name = holder.itemView.getResources().getString(R.string.list_recent_cards);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerDetailsViewHolder.getIconTextView().setText("\uf1da");
                z = true;
            } else {
                z = false;
            }
            if (container.getId() == 2) {
                name = holder.itemView.getResources().getString(R.string.list_wants);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerDetailsViewHolder.getIconTextView().setText("\uf291");
                z = true;
            }
            if (container.getId() == 3) {
                name = holder.itemView.getResources().getString(R.string.list_trade);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerDetailsViewHolder.getIconTextView().setText("\uf4c6");
                z = true;
            }
            if (container.getId() == 4) {
                name = holder.itemView.getResources().getString(R.string.list_bulk);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerDetailsViewHolder.getIconTextView().setText("\uf466");
                z = true;
            }
            if (z) {
                cardContainerDetailsViewHolder.getEditActionTextView().setVisibility(8);
                cardContainerDetailsViewHolder.getDeleteActionTextView().setText("\uf410");
                cardContainerDetailsViewHolder.getDeleteActionTextView().setVisibility(0);
            }
            cardContainerDetailsViewHolder.getNameTextView().setText(name);
            cardContainerDetailsViewHolder.getIconTextView().setVisibility(!z ? 8 : 0);
            Integer count = container.getCount();
            if ((count != null ? count.intValue() : 0) > 1) {
                TextView numCardsLabel = cardContainerDetailsViewHolder.getNumCardsLabel();
                String string = holder.itemView.getResources().getString(R.string.cards_count);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                numCardsLabel.setText(StringsKt.replace$default(string, "{1}", String.valueOf(container.getCount()), false, 4, (Object) null));
            } else {
                Integer count2 = container.getCount();
                if (count2 != null && count2.intValue() == 1) {
                    TextView numCardsLabel2 = cardContainerDetailsViewHolder.getNumCardsLabel();
                    String string2 = holder.itemView.getResources().getString(R.string.one_card);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    numCardsLabel2.setText(StringsKt.replace$default(string2, "{1}", String.valueOf(container.getCount().intValue()), false, 4, (Object) null));
                } else {
                    cardContainerDetailsViewHolder.getNumCardsLabel().setText(holder.itemView.getResources().getString(R.string.no_cards_list));
                }
            }
            cardContainerDetailsViewHolder.getColorView().setVisibility(8);
            String color = container.getColor();
            if (color != null) {
                if (color.length() > 0) {
                    int color2 = Color.parseColor(ColorKt.HEX_PREFIX + color);
                    cardContainerDetailsViewHolder.getColorView().setVisibility(0);
                    Drawable background = cardContainerDetailsViewHolder.getColorView().getBackground();
                    GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                    if (gradientDrawable != null) {
                        gradientDrawable.setColor(color2);
                    }
                }
            }
            cardContainerDetailsViewHolder.getNoCardsTextView().setVisibility(8);
            cardContainerDetailsViewHolder.getCardsRecyclerView().setVisibility(0);
            cardContainerDetailsViewHolder.getCardsRecyclerView().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
            List<MTFullCard> cardsForContainer = CardContainerCache.INSTANCE.getCardsForContainer(container.getId());
            if (cardsForContainer == null) {
                Context context = holder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                MTUser currentUser = new PreferencesManager(context).getCurrentUser();
                if (currentUser != null) {
                    MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser.getId(), container.getId(), null, null, null, 20, null, null, null, null, null, null, null, 8156, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.CardContainerDetailsAdapter$onBindViewHolder$1$6$1$1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            ((CardContainerDetailsViewHolder) holder).getNoCardsTextView().setVisibility(0);
                            ((CardContainerDetailsViewHolder) holder).getCardsRecyclerView().setVisibility(8);
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (response.isSuccessful()) {
                                MTCardListResponse mTCardListResponseBody = response.body();
                                MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                                if (list != null) {
                                    MTCardContainer mTCardContainer = container;
                                    RecyclerView.ViewHolder viewHolder = holder;
                                    CardContainerDetailsAdapter cardContainerDetailsAdapter = this;
                                    CardContainerCache cardContainerCache = CardContainerCache.INSTANCE;
                                    List<MTFullCard> cards = list.getCards();
                                    if (cards == null) {
                                        cards = CollectionsKt.emptyList();
                                    }
                                    cardContainerCache.set(cards, mTCardContainer.getId());
                                    List<MTFullCard> cards2 = list.getCards();
                                    if (cards2 == null) {
                                        CardContainerDetailsViewHolder cardContainerDetailsViewHolder2 = (CardContainerDetailsViewHolder) viewHolder;
                                        cardContainerDetailsViewHolder2.getNoCardsTextView().setVisibility(0);
                                        cardContainerDetailsViewHolder2.getCardsRecyclerView().setVisibility(8);
                                    } else {
                                        if (!cards2.isEmpty()) {
                                            ((CardContainerDetailsViewHolder) viewHolder).getCardsRecyclerView().setAdapter(new SimpleMTFullCardListAdapter(cards2, cardContainerDetailsAdapter, mTCardContainer));
                                            return;
                                        }
                                        CardContainerDetailsViewHolder cardContainerDetailsViewHolder3 = (CardContainerDetailsViewHolder) viewHolder;
                                        cardContainerDetailsViewHolder3.getNoCardsTextView().setVisibility(0);
                                        cardContainerDetailsViewHolder3.getCardsRecyclerView().setVisibility(8);
                                    }
                                }
                            }
                        }
                    });
                } else {
                    cardContainerDetailsViewHolder.getNoCardsTextView().setVisibility(0);
                    cardContainerDetailsViewHolder.getCardsRecyclerView().setVisibility(8);
                }
            } else if (cardsForContainer.isEmpty()) {
                cardContainerDetailsViewHolder.getNoCardsTextView().setVisibility(0);
                cardContainerDetailsViewHolder.getCardsRecyclerView().setVisibility(8);
            } else {
                cardContainerDetailsViewHolder.getCardsRecyclerView().setAdapter(new SimpleMTFullCardListAdapter(cardsForContainer, this, container));
            }
            cardContainerDetailsViewHolder.getPriceTextView().setText("--");
            cardContainerDetailsViewHolder.getDeltaTextView().setText("");
            Context context2 = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            String preferredCurrency = new PreferencesManager(context2).getPreferredCurrency();
            MTCardsValue containerValue = GameUtils.INSTANCE.getInstance().getContainerValue(container.getValues(), preferredCurrency);
            if (containerValue != null) {
                cardContainerDetailsViewHolder.getPriceTextView().setText(GameUtils.INSTANCE.getInstance().formatPrice(containerValue.getTotal_value(), preferredCurrency));
                MTPriceDelta delta = containerValue.getDelta();
                if (delta != null) {
                    cardContainerDetailsViewHolder.getDeltaTextView().setText(GameUtils.INSTANCE.getInstance().formatDelta(delta, preferredCurrency));
                    if (delta.getAmount() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        cardContainerDetailsViewHolder.getDeltaTextView().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winner_green));
                    } else if (delta.getAmount() < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        cardContainerDetailsViewHolder.getDeltaTextView().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.loser_red));
                    } else {
                        cardContainerDetailsViewHolder.getDeltaTextView().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.text_color));
                    }
                }
            }
            if (container.getId() == 1) {
                cardContainerDetailsViewHolder.getPriceTextView().setVisibility(8);
                cardContainerDetailsViewHolder.getDeltaTextView().setVisibility(8);
            } else {
                cardContainerDetailsViewHolder.getPriceTextView().setVisibility(0);
                cardContainerDetailsViewHolder.getDeltaTextView().setVisibility(0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_container_details_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new CardContainerDetailsViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_container_separator_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new CardContainerDetailsSeparatorViewHolder(viewInflate2, this.clickListener);
    }

    @Override // com.studiolaganne.lengendarylens.SimpleMTFullCardClickListener
    public void onMTFullCardClick(MTFullCard card, int position, MTCardContainer container) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (container != null) {
            this.clickListener.onCardContainerSingleCardClick(container, card, position);
        }
    }
}
