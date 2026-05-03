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
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.ui.ColorKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CardContainerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/CardContainerItemHolder;", "clickListener", "Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "showDotsMenu", "", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/CardContainerClickListener;Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardContainerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_CONTAINER = 1;
    public static final int VIEW_TYPE_SEPARATOR = 2;
    private final CardContainerClickListener clickListener;
    private final List<CardContainerItemHolder> items;
    private final boolean showDotsMenu;
    public static final int $stable = 8;

    public CardContainerAdapter(List<CardContainerItemHolder> items, CardContainerClickListener clickListener, boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.items = items;
        this.clickListener = clickListener;
        this.showDotsMenu = z;
    }

    public /* synthetic */ CardContainerAdapter(List list, CardContainerClickListener cardContainerClickListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, cardContainerClickListener, (i & 4) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(CardContainerAdapter cardContainerAdapter, MTCardContainer mTCardContainer) {
        cardContainerAdapter.clickListener.onCardContainerClick(mTCardContainer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$1(CardContainerAdapter cardContainerAdapter, MTCardContainer mTCardContainer, RecyclerView.ViewHolder viewHolder) {
        cardContainerAdapter.clickListener.onCardContainerDotsClick(mTCardContainer, ((CardContainerViewHolder) viewHolder).getDotsLayout());
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

    /* JADX WARN: Removed duplicated region for block: B:145:0x0408  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String separator;
        boolean z;
        Call userListById$default;
        MTImageURIs mTImageURIs;
        MTImageURIs mTImageURIs2;
        String gatherer;
        MTImageURIs mTImageURIs3;
        String png;
        MTImageURIs image_uris;
        MTImageURIs image_uris2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CardContainerItemHolder cardContainerItemHolder = this.items.get(position);
        if (!(holder instanceof CardContainerViewHolder)) {
            if (!(holder instanceof CardContainerSeparatorViewHolder) || (separator = cardContainerItemHolder.getSeparator()) == null) {
                return;
            }
            ((CardContainerSeparatorViewHolder) holder).getSeparatorText().setText(separator);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        final MTCardContainer container = cardContainerItemHolder.getContainer();
        CardContainerViewHolder cardContainerViewHolder = (CardContainerViewHolder) holder;
        cardContainerViewHolder.getInnerLayout().setClipToOutline(true);
        if (container != null) {
            ViewExtensionsKt.setOnClickWithFade(cardContainerViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.CardContainerAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardContainerAdapter.onBindViewHolder$lambda$0$0(this.f$0, container);
                }
            });
            if (this.showDotsMenu) {
                cardContainerViewHolder.getDotsLayout().setVisibility(0);
                ViewExtensionsKt.setOnClickWithFade(cardContainerViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.CardContainerAdapter$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardContainerAdapter.onBindViewHolder$lambda$0$1(this.f$0, container, holder);
                    }
                });
            } else {
                cardContainerViewHolder.getDotsLayout().setVisibility(8);
            }
            cardContainerViewHolder.getOwnerLayout().setVisibility(8);
            MTPrivacyUser user = container.getUser();
            if (user != null) {
                Context context = holder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                MTUser currentUser = new PreferencesManager(context).getCurrentUser();
                if (currentUser != null) {
                    if (currentUser.getId() != user.getId()) {
                        cardContainerViewHolder.getOwnerLayout().setVisibility(0);
                        String picture = user.getPicture();
                        if (picture == null || picture.length() == 0) {
                            cardContainerViewHolder.getProfileIcon().setVisibility(8);
                            cardContainerViewHolder.getNoPhotoIcon().setVisibility(0);
                        } else {
                            cardContainerViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
                            cardContainerViewHolder.getProfileIcon().setClipToOutline(true);
                            cardContainerViewHolder.getProfileIcon().setVisibility(0);
                            cardContainerViewHolder.getNoPhotoIcon().setVisibility(8);
                            cardContainerViewHolder.getProfileIcon().setAutoLoad(false);
                            CachedImageView profileIcon = cardContainerViewHolder.getProfileIcon();
                            String picture2 = user.getPicture();
                            Intrinsics.checkNotNull(picture2);
                            profileIcon.loadImage(picture2);
                        }
                        cardContainerViewHolder.getUserName().setText("@" + user.getUsername());
                    }
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
            }
            String name = container.getName();
            if (container.getId() == 1) {
                name = holder.itemView.getResources().getString(R.string.list_recent_cards);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerViewHolder.getIconTextView().setText("\uf1da");
                z = true;
            } else {
                z = false;
            }
            if (container.getId() == 2) {
                name = holder.itemView.getResources().getString(R.string.list_wants);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerViewHolder.getIconTextView().setText("\uf291");
                z = true;
            }
            if (container.getId() == 3) {
                name = holder.itemView.getResources().getString(R.string.list_trade);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerViewHolder.getIconTextView().setText("\uf4c6");
                z = true;
            }
            if (container.getId() == 4) {
                name = holder.itemView.getResources().getString(R.string.list_bulk);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                cardContainerViewHolder.getIconTextView().setText("\uf466");
                z = true;
            }
            cardContainerViewHolder.getNameTextView().setText(name);
            cardContainerViewHolder.getIconTextView().setVisibility(!z ? 8 : 0);
            Integer count = container.getCount();
            if ((count != null ? count.intValue() : 0) > 1) {
                TextView numCardsLabel = cardContainerViewHolder.getNumCardsLabel();
                String string = holder.itemView.getResources().getString(R.string.cards_count);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                numCardsLabel.setText(StringsKt.replace$default(string, "{1}", String.valueOf(container.getCount()), false, 4, (Object) null));
            } else {
                Integer count2 = container.getCount();
                if ((count2 != null ? count2.intValue() : 0) == 1) {
                    TextView numCardsLabel2 = cardContainerViewHolder.getNumCardsLabel();
                    String string2 = holder.itemView.getResources().getString(R.string.one_card);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    numCardsLabel2.setText(StringsKt.replace$default(string2, "{1}", String.valueOf(container.getCount()), false, 4, (Object) null));
                } else {
                    cardContainerViewHolder.getNumCardsLabel().setText(holder.itemView.getResources().getString(R.string.no_cards_list));
                }
            }
            cardContainerViewHolder.getColorView().setVisibility(8);
            String color = container.getColor();
            String gatherer2 = null;
            if (color != null) {
                if (color.length() > 0) {
                    int color2 = Color.parseColor(ColorKt.HEX_PREFIX + color);
                    cardContainerViewHolder.getColorView().setVisibility(0);
                    Drawable background = cardContainerViewHolder.getColorView().getBackground();
                    GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                    if (gradientDrawable != null) {
                        gradientDrawable.setColor(color2);
                        Unit unit5 = Unit.INSTANCE;
                    }
                }
                Unit unit6 = Unit.INSTANCE;
                Unit unit7 = Unit.INSTANCE;
            }
            MTSimpleCard faceCard = container.getFaceCard();
            String png2 = (faceCard == null || (image_uris2 = faceCard.getImage_uris()) == null) ? null : image_uris2.getPng();
            if (png2 == null) {
                MTSimpleCard faceCard2 = container.getFaceCard();
                if (faceCard2 != null && (image_uris = faceCard2.getImage_uris()) != null) {
                    gatherer2 = image_uris.getGatherer();
                }
                png2 = gatherer2;
            }
            if (png2 != null) {
                cardContainerViewHolder.getDeckImage().setVisibility(0);
                cardContainerViewHolder.getDeckImage().setAutoLoad(false);
                cardContainerViewHolder.getDeckImage().setImageUrl(png2);
                cardContainerViewHolder.getDeckImage().loadSingleImage(png2);
                Unit unit8 = Unit.INSTANCE;
            } else {
                Integer count3 = container.getCount();
                if ((count3 != null ? count3.intValue() : 0) > 0) {
                    List<MTFullCard> cardsForContainer = CardContainerCache.INSTANCE.getCardsForContainer(container.getId());
                    if (cardsForContainer != null) {
                        if (cardsForContainer.isEmpty()) {
                            cardContainerViewHolder.getDeckImage().setVisibility(8);
                        } else {
                            MTFullCard mTFullCard = (MTFullCard) CollectionsKt.firstOrNull((List) cardsForContainer);
                            if (mTFullCard != null) {
                                List<MTImageURIs> images = mTFullCard.getImages();
                                if (images == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (png = mTImageURIs3.getPng()) == null) {
                                    List<MTImageURIs> images2 = mTFullCard.getImages();
                                    if (images2 == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) == null || (gatherer = mTImageURIs2.getGatherer()) == null) {
                                        List<MTImageURIs> en_images = mTFullCard.getEn_images();
                                        if (en_images == null || (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null) {
                                            cardContainerViewHolder.getDeckImage().setVisibility(8);
                                            Unit unit9 = Unit.INSTANCE;
                                        } else {
                                            String png3 = mTImageURIs.getPng();
                                            if (png3 == null && (png3 = mTImageURIs.getGatherer()) == null) {
                                                png3 = "";
                                            }
                                            if (png3.length() > 0) {
                                                cardContainerViewHolder.getDeckImage().setVisibility(0);
                                                cardContainerViewHolder.getDeckImage().setAutoLoad(false);
                                                cardContainerViewHolder.getDeckImage().setImageUrl(png3);
                                                cardContainerViewHolder.getDeckImage().loadSingleImage(png3);
                                            } else {
                                                cardContainerViewHolder.getDeckImage().setVisibility(8);
                                            }
                                            Unit unit10 = Unit.INSTANCE;
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                    } else {
                                        cardContainerViewHolder.getDeckImage().setVisibility(0);
                                        cardContainerViewHolder.getDeckImage().setAutoLoad(false);
                                        cardContainerViewHolder.getDeckImage().setImageUrl(gatherer);
                                        cardContainerViewHolder.getDeckImage().loadSingleImage(gatherer);
                                        Unit unit12 = Unit.INSTANCE;
                                    }
                                    Unit unit13 = Unit.INSTANCE;
                                } else {
                                    cardContainerViewHolder.getDeckImage().setVisibility(0);
                                    cardContainerViewHolder.getDeckImage().setAutoLoad(false);
                                    cardContainerViewHolder.getDeckImage().setImageUrl(png);
                                    cardContainerViewHolder.getDeckImage().loadSingleImage(png);
                                    Unit unit14 = Unit.INSTANCE;
                                }
                                Unit unit15 = Unit.INSTANCE;
                            } else {
                                cardContainerViewHolder.getDeckImage().setVisibility(8);
                                Unit unit16 = Unit.INSTANCE;
                            }
                        }
                        Unit unit17 = Unit.INSTANCE;
                    } else {
                        Context context2 = holder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        MTUser currentUser2 = new PreferencesManager(context2).getCurrentUser();
                        if (currentUser2 == null) {
                            cardContainerViewHolder.getDeckImage().setVisibility(8);
                            Unit unit18 = Unit.INSTANCE;
                        } else if (container.getOwner_userid() != null) {
                            Integer owner_userid = container.getOwner_userid();
                            final boolean z2 = owner_userid != null && owner_userid.intValue() == currentUser2.getId();
                            if (z2) {
                                userListById$default = MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser2.getId(), container.getId(), null, null, null, 20, null, null, null, null, null, null, null, 8156, null);
                            } else {
                                MTApi mtApi = MTApiKt.getMtApi();
                                int id = currentUser2.getId();
                                Integer owner_userid2 = container.getOwner_userid();
                                Intrinsics.checkNotNull(owner_userid2);
                                userListById$default = MTApi.getUserListById$default(mtApi, id, owner_userid2.intValue(), container.getId(), null, null, null, 20, null, null, null, null, null, null, null, 16312, null);
                            }
                            userListById$default.enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.CardContainerAdapter$onBindViewHolder$1$6$2$1$1
                                @Override // retrofit2.Callback
                                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(t, "t");
                                }

                                @Override // retrofit2.Callback
                                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                                    MTImageURIs mTImageURIs4;
                                    MTImageURIs mTImageURIs5;
                                    String gatherer3;
                                    MTImageURIs mTImageURIs6;
                                    String png4;
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    if (response.isSuccessful()) {
                                        MTCardListResponse mTCardListResponseBody = response.body();
                                        MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                                        if (list != null) {
                                            boolean z3 = z2;
                                            MTCardContainer mTCardContainer = container;
                                            RecyclerView.ViewHolder viewHolder = holder;
                                            if (z3) {
                                                CardContainerCache cardContainerCache = CardContainerCache.INSTANCE;
                                                List<MTFullCard> cards = list.getCards();
                                                if (cards == null) {
                                                    cards = CollectionsKt.emptyList();
                                                }
                                                cardContainerCache.set(cards, mTCardContainer.getId());
                                            }
                                            List<MTFullCard> cards2 = list.getCards();
                                            MTFullCard mTFullCard2 = cards2 != null ? (MTFullCard) CollectionsKt.firstOrNull((List) cards2) : null;
                                            if (mTFullCard2 == null) {
                                                ((CardContainerViewHolder) viewHolder).getDeckImage().setVisibility(8);
                                                return;
                                            }
                                            List<MTImageURIs> images3 = mTFullCard2.getImages();
                                            if (images3 != null && (mTImageURIs6 = (MTImageURIs) CollectionsKt.firstOrNull((List) images3)) != null && (png4 = mTImageURIs6.getPng()) != null) {
                                                CardContainerViewHolder cardContainerViewHolder2 = (CardContainerViewHolder) viewHolder;
                                                cardContainerViewHolder2.getDeckImage().setVisibility(0);
                                                cardContainerViewHolder2.getDeckImage().setAutoLoad(false);
                                                cardContainerViewHolder2.getDeckImage().setImageUrl(png4);
                                                cardContainerViewHolder2.getDeckImage().loadSingleImage(png4);
                                                return;
                                            }
                                            List<MTImageURIs> images4 = mTFullCard2.getImages();
                                            if (images4 != null && (mTImageURIs5 = (MTImageURIs) CollectionsKt.firstOrNull((List) images4)) != null && (gatherer3 = mTImageURIs5.getGatherer()) != null) {
                                                CardContainerViewHolder cardContainerViewHolder3 = (CardContainerViewHolder) viewHolder;
                                                cardContainerViewHolder3.getDeckImage().setVisibility(0);
                                                cardContainerViewHolder3.getDeckImage().setAutoLoad(false);
                                                cardContainerViewHolder3.getDeckImage().setImageUrl(gatherer3);
                                                cardContainerViewHolder3.getDeckImage().loadSingleImage(gatherer3);
                                                return;
                                            }
                                            List<MTImageURIs> en_images2 = mTFullCard2.getEn_images();
                                            if (en_images2 == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) == null) {
                                                ((CardContainerViewHolder) viewHolder).getDeckImage().setVisibility(8);
                                                return;
                                            }
                                            String png5 = mTImageURIs4.getPng();
                                            if (png5 == null && (png5 = mTImageURIs4.getGatherer()) == null) {
                                                png5 = "";
                                            }
                                            if (png5.length() <= 0) {
                                                ((CardContainerViewHolder) viewHolder).getDeckImage().setVisibility(8);
                                                return;
                                            }
                                            CardContainerViewHolder cardContainerViewHolder4 = (CardContainerViewHolder) viewHolder;
                                            cardContainerViewHolder4.getDeckImage().setVisibility(0);
                                            cardContainerViewHolder4.getDeckImage().setAutoLoad(false);
                                            cardContainerViewHolder4.getDeckImage().setImageUrl(png5);
                                            cardContainerViewHolder4.getDeckImage().loadSingleImage(png5);
                                        }
                                    }
                                }
                            });
                            Unit unit19 = Unit.INSTANCE;
                        }
                        Unit unit20 = Unit.INSTANCE;
                    }
                } else {
                    cardContainerViewHolder.getDeckImage().setVisibility(8);
                }
                Unit unit21 = Unit.INSTANCE;
            }
            cardContainerViewHolder.getPriceTextView().setText("--");
            cardContainerViewHolder.getDeltaTextView().setText("");
            Context context3 = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            String preferredCurrency = new PreferencesManager(context3).getPreferredCurrency();
            MTCardsValue containerValue = GameUtils.INSTANCE.getInstance().getContainerValue(container.getValues(), preferredCurrency);
            if (containerValue != null) {
                cardContainerViewHolder.getPriceTextView().setText(GameUtils.INSTANCE.getInstance().formatPrice(containerValue.getTotal_value(), preferredCurrency));
                MTPriceDelta delta = containerValue.getDelta();
                if (delta != null) {
                    cardContainerViewHolder.getDeltaTextView().setText(GameUtils.INSTANCE.getInstance().formatDelta(delta, preferredCurrency));
                    if (delta.getAmount() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        cardContainerViewHolder.getDeltaTextView().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winner_green));
                    } else if (delta.getAmount() < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        cardContainerViewHolder.getDeltaTextView().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.loser_red));
                    } else {
                        cardContainerViewHolder.getDeltaTextView().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.text_color));
                    }
                    Unit unit22 = Unit.INSTANCE;
                    Unit unit23 = Unit.INSTANCE;
                }
            }
            if (container.getId() == 1) {
                cardContainerViewHolder.getPriceTextView().setVisibility(8);
                cardContainerViewHolder.getDeltaTextView().setVisibility(8);
            } else {
                cardContainerViewHolder.getPriceTextView().setVisibility(0);
                cardContainerViewHolder.getDeltaTextView().setVisibility(0);
            }
            Unit unit24 = Unit.INSTANCE;
            Unit unit25 = Unit.INSTANCE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_container_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new CardContainerViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_container_separator_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new CardContainerSeparatorViewHolder(viewInflate2, this.clickListener);
    }
}
