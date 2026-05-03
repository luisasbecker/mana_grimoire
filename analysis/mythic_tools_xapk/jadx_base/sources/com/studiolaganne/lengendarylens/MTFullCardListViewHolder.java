package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.media3.muxer.WebmConstants;
import androidx.recyclerview.widget.RecyclerView;
import com.vanniktech.ui.ColorKt;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MTFullCardListViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010M\u001a\u00020I2\u0006\u0010N\u001a\u00020IH\u0002J&\u0010O\u001a\u00020P2\u0006\u0010H\u001a\u00020I2\u0006\u0010F\u001a\u00020G2\u0006\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020EJ\u0010\u0010S\u001a\u00020P2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010T\u001a\u00020P2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020IH\u0002J\u0006\u0010W\u001a\u00020PR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFullCardListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardClickListener", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "longPressListener", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "selectionListener", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "itemView", "Landroid/view/View;", "addToDeckListener", "Lcom/studiolaganne/lengendarylens/OnCardAddToDeckListener;", "addedCardIds", "", "", "<init>", "(Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;Landroid/view/View;Lcom/studiolaganne/lengendarylens/OnCardAddToDeckListener;Ljava/util/Set;)V", "rootLayout", "Landroid/widget/LinearLayout;", "titleLabel", "Landroid/widget/TextView;", "typeLabel", "manaCostLabel", "oracleLabel", "bottomLabel", "bottomLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "powerToughnessText", "imageView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "setImage", "Landroid/widget/ImageView;", "setLabel", "cardNumberLabel", "priceLabel", "foilEffectImage", "isFoilImage", "alteredTextView", "signedTextView", "misprintTextView", "proxyTextView", "conditionTextView", "cornerView", "qtyTextView", "flagContainer", "flagImage", "extrasLayout", "selectionControlsLayout", "selectedAmountText", "minusQtyLayout", "plusQtyLayout", "collectionLayout", "containerLabel", "deckLayout", "deckNameLabel", "mythicAvailableLayout", "mythicAvailableLabel", "mythicInDeckLayout", "mythicInDeckLabel", "horizontalLayout", "newRibbonLabel", "recommendationInfoLayout", "similarityLabel", "confidenceBadge", "deckCountLabel", "recommendationActionsLayout", "addToDeckButton", "dotsMenuButton", "offline", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "listId", "", "apiCall", "Lretrofit2/Call;", "Lcom/studiolaganne/lengendarylens/MTFullCardResponse;", "dpToPx", "dp", "bind", "", "position", "selectionMode", "bindMythicCollectionStatus", "bindRecommendation", "formatDeckCount", "count", "onRecycled", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTFullCardListViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView addToDeckButton;
    private final OnCardAddToDeckListener addToDeckListener;
    private final Set<String> addedCardIds;
    private final TextView alteredTextView;
    private Call<MTFullCardResponse> apiCall;
    private TextView bottomLabel;
    private ConstraintLayout bottomLayout;
    private MTFullCard card;
    private final OnMTFullCardClickListener cardClickListener;
    private final TextView cardNumberLabel;
    private final LinearLayout collectionLayout;
    private final TextView conditionTextView;
    private final TextView confidenceBadge;
    private final TextView containerLabel;
    private final View cornerView;
    private final TextView deckCountLabel;
    private final LinearLayout deckLayout;
    private final TextView deckNameLabel;
    private final ImageView dotsMenuButton;
    private final LinearLayout extrasLayout;
    private final View flagContainer;
    private final ImageView flagImage;
    private final ImageView foilEffectImage;
    private final LinearLayout horizontalLayout;
    private final LoadingImageView imageView;
    private final ImageView isFoilImage;
    private int listId;
    private final OnCardLongPressListener longPressListener;
    private final TextView manaCostLabel;
    private final ConstraintLayout minusQtyLayout;
    private final TextView misprintTextView;
    private final TextView mythicAvailableLabel;
    private final LinearLayout mythicAvailableLayout;
    private final TextView mythicInDeckLabel;
    private final LinearLayout mythicInDeckLayout;
    private final TextView newRibbonLabel;
    private boolean offline;
    private TextView oracleLabel;
    private final ConstraintLayout plusQtyLayout;
    private TextView powerToughnessText;
    private final TextView priceLabel;
    private final TextView proxyTextView;
    private final TextView qtyTextView;
    private final LinearLayout recommendationActionsLayout;
    private final LinearLayout recommendationInfoLayout;
    private final LinearLayout rootLayout;
    private final TextView selectedAmountText;
    private final ConstraintLayout selectionControlsLayout;
    private final OnCardSelectionListener selectionListener;
    private final ImageView setImage;
    private final TextView setLabel;
    private final TextView signedTextView;
    private final TextView similarityLabel;
    private final TextView titleLabel;
    private final TextView typeLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MTFullCardListViewHolder(OnMTFullCardClickListener cardClickListener, OnCardLongPressListener longPressListener, OnCardSelectionListener selectionListener, View itemView, OnCardAddToDeckListener onCardAddToDeckListener, Set<String> set) {
        super(itemView);
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        Intrinsics.checkNotNullParameter(longPressListener, "longPressListener");
        Intrinsics.checkNotNullParameter(selectionListener, "selectionListener");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.cardClickListener = cardClickListener;
        this.longPressListener = longPressListener;
        this.selectionListener = selectionListener;
        this.addToDeckListener = onCardAddToDeckListener;
        this.addedCardIds = set;
        View viewFindViewById = itemView.findViewById(R.id.rootLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.titleLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.titleLabel = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.typeLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.typeLabel = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.manaCostLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.manaCostLabel = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.oracleTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.oracleLabel = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.bottomText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.bottomLabel = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.bottomLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.bottomLayout = (ConstraintLayout) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.powerToughnessTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.powerToughnessText = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.imageView = (LoadingImageView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.setImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.setImage = (ImageView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.setLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.setLabel = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.cardNumberLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.cardNumberLabel = (TextView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.priceLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.priceLabel = (TextView) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.foilEffectImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.foilEffectImage = (ImageView) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.is_foil_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.isFoilImage = (ImageView) viewFindViewById15;
        View viewFindViewById16 = itemView.findViewById(R.id.alteredTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.alteredTextView = (TextView) viewFindViewById16;
        View viewFindViewById17 = itemView.findViewById(R.id.signedTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.signedTextView = (TextView) viewFindViewById17;
        View viewFindViewById18 = itemView.findViewById(R.id.missprintTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.misprintTextView = (TextView) viewFindViewById18;
        View viewFindViewById19 = itemView.findViewById(R.id.proxyTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.proxyTextView = (TextView) viewFindViewById19;
        View viewFindViewById20 = itemView.findViewById(R.id.conditionTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.conditionTextView = (TextView) viewFindViewById20;
        View viewFindViewById21 = itemView.findViewById(R.id.cornerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.cornerView = viewFindViewById21;
        View viewFindViewById22 = itemView.findViewById(R.id.qtyTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.qtyTextView = (TextView) viewFindViewById22;
        View viewFindViewById23 = itemView.findViewById(R.id.flag_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.flagContainer = viewFindViewById23;
        View viewFindViewById24 = itemView.findViewById(R.id.flag_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        this.flagImage = (ImageView) viewFindViewById24;
        View viewFindViewById25 = itemView.findViewById(R.id.extrasLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
        this.extrasLayout = (LinearLayout) viewFindViewById25;
        View viewFindViewById26 = itemView.findViewById(R.id.selectionControlsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
        this.selectionControlsLayout = (ConstraintLayout) viewFindViewById26;
        View viewFindViewById27 = itemView.findViewById(R.id.selectedAmountText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
        this.selectedAmountText = (TextView) viewFindViewById27;
        View viewFindViewById28 = itemView.findViewById(R.id.minusQtyLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
        this.minusQtyLayout = (ConstraintLayout) viewFindViewById28;
        View viewFindViewById29 = itemView.findViewById(R.id.plusQtyLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
        this.plusQtyLayout = (ConstraintLayout) viewFindViewById29;
        View viewFindViewById30 = itemView.findViewById(R.id.collectionLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById30, "findViewById(...)");
        this.collectionLayout = (LinearLayout) viewFindViewById30;
        View viewFindViewById31 = itemView.findViewById(R.id.containerLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById31, "findViewById(...)");
        this.containerLabel = (TextView) viewFindViewById31;
        View viewFindViewById32 = itemView.findViewById(R.id.deckLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById32, "findViewById(...)");
        this.deckLayout = (LinearLayout) viewFindViewById32;
        View viewFindViewById33 = itemView.findViewById(R.id.deckNameLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById33, "findViewById(...)");
        this.deckNameLabel = (TextView) viewFindViewById33;
        View viewFindViewById34 = itemView.findViewById(R.id.mythicAvailableLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById34, "findViewById(...)");
        this.mythicAvailableLayout = (LinearLayout) viewFindViewById34;
        View viewFindViewById35 = itemView.findViewById(R.id.mythicAvailableLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById35, "findViewById(...)");
        this.mythicAvailableLabel = (TextView) viewFindViewById35;
        View viewFindViewById36 = itemView.findViewById(R.id.mythicInDeckLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById36, "findViewById(...)");
        this.mythicInDeckLayout = (LinearLayout) viewFindViewById36;
        View viewFindViewById37 = itemView.findViewById(R.id.mythicInDeckLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById37, "findViewById(...)");
        this.mythicInDeckLabel = (TextView) viewFindViewById37;
        View viewFindViewById38 = itemView.findViewById(R.id.horizontalLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById38, "findViewById(...)");
        this.horizontalLayout = (LinearLayout) viewFindViewById38;
        View viewFindViewById39 = itemView.findViewById(R.id.newRibbonLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById39, "findViewById(...)");
        this.newRibbonLabel = (TextView) viewFindViewById39;
        View viewFindViewById40 = itemView.findViewById(R.id.recommendationInfoLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById40, "findViewById(...)");
        this.recommendationInfoLayout = (LinearLayout) viewFindViewById40;
        View viewFindViewById41 = itemView.findViewById(R.id.similarityLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById41, "findViewById(...)");
        this.similarityLabel = (TextView) viewFindViewById41;
        View viewFindViewById42 = itemView.findViewById(R.id.confidenceBadge);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById42, "findViewById(...)");
        this.confidenceBadge = (TextView) viewFindViewById42;
        View viewFindViewById43 = itemView.findViewById(R.id.deckCountLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById43, "findViewById(...)");
        this.deckCountLabel = (TextView) viewFindViewById43;
        View viewFindViewById44 = itemView.findViewById(R.id.recommendationActionsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById44, "findViewById(...)");
        this.recommendationActionsLayout = (LinearLayout) viewFindViewById44;
        View viewFindViewById45 = itemView.findViewById(R.id.addToDeckButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById45, "findViewById(...)");
        this.addToDeckButton = (TextView) viewFindViewById45;
        View viewFindViewById46 = itemView.findViewById(R.id.dotsMenuButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById46, "findViewById(...)");
        this.dotsMenuButton = (ImageView) viewFindViewById46;
        this.listId = -1;
    }

    public /* synthetic */ MTFullCardListViewHolder(OnMTFullCardClickListener onMTFullCardClickListener, OnCardLongPressListener onCardLongPressListener, OnCardSelectionListener onCardSelectionListener, View view, OnCardAddToDeckListener onCardAddToDeckListener, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onMTFullCardClickListener, onCardLongPressListener, onCardSelectionListener, view, (i & 16) != 0 ? null : onCardAddToDeckListener, (i & 32) != 0 ? null : set);
    }

    static final boolean bind$lambda$19(MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard, int i, View view) {
        mTFullCardListViewHolder.longPressListener.onCardLongPress(mTFullCard, i);
        return true;
    }

    static final Unit bind$lambda$20(boolean z, MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard, int i) {
        if (z) {
            mTFullCardListViewHolder.selectionListener.onCardSelectionToggle(mTFullCard, i);
        } else {
            mTFullCardListViewHolder.cardClickListener.onMTFullCardClick(mTFullCard, i);
        }
        return Unit.INSTANCE;
    }

    static final Unit bind$lambda$21(int i, int i2, MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard, int i3) {
        ((BrowseListFragment) mTFullCardListViewHolder.selectionListener).onQuantityChange(mTFullCard, i3, Math.min(i + 1, i2));
        return Unit.INSTANCE;
    }

    static final Unit bind$lambda$22(int i, MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard, int i2) {
        ((BrowseListFragment) mTFullCardListViewHolder.selectionListener).onQuantityChange(mTFullCard, i2, Math.max(i - 1, 0));
        return Unit.INSTANCE;
    }

    private final void bindMythicCollectionStatus(MTFullCard card) {
        String list_name;
        String deck_name;
        this.mythicAvailableLayout.setVisibility(8);
        this.mythicInDeckLayout.setVisibility(8);
        MTCardCollectionStatus collection = card.getCollection();
        if (collection == null) {
            MTRecommendationData recommendation = card.getRecommendation();
            collection = recommendation != null ? recommendation.getCollection() : null;
            if (collection == null) {
                return;
            }
        }
        if (Intrinsics.areEqual((Object) collection.getIn_use(), (Object) true) && (deck_name = collection.getDeck_name()) != null && !StringsKt.isBlank(deck_name)) {
            this.mythicInDeckLabel.setText(collection.getDeck_name());
            this.mythicInDeckLayout.setVisibility(0);
            this.imageView.setImageColorDimmed(true);
            return;
        }
        String list_name2 = collection.getList_name();
        if (list_name2 == null || StringsKt.isBlank(list_name2)) {
            return;
        }
        if (Intrinsics.areEqual(collection.getList_name(), "bulk")) {
            list_name = this.itemView.getContext().getString(R.string.list_bulk);
        } else {
            list_name = collection.getList_name();
            Intrinsics.checkNotNull(list_name);
        }
        Intrinsics.checkNotNull(list_name);
        this.mythicAvailableLabel.setText(list_name);
        this.mythicAvailableLayout.setVisibility(0);
    }

    private final void bindRecommendation(final MTFullCard card) {
        Set<String> set;
        MTRecommendationData recommendation = card.getRecommendation();
        if (this.addToDeckListener == null) {
            this.itemView.setAlpha(1.0f);
            this.horizontalLayout.setVisibility(0);
            this.recommendationInfoLayout.setVisibility(8);
            this.recommendationActionsLayout.setVisibility(8);
            this.newRibbonLabel.setVisibility(8);
            return;
        }
        boolean z = (card.getOracleid() == null || (set = this.addedCardIds) == null || !CollectionsKt.contains(set, card.getOracleid())) ? false : true;
        this.itemView.setAlpha(z ? 0.35f : 1.0f);
        this.horizontalLayout.setVisibility(8);
        this.recommendationActionsLayout.setVisibility(0);
        LinearLayout linearLayout = this.recommendationInfoLayout;
        if (recommendation != null) {
            linearLayout.setVisibility(0);
            int similarity = (int) recommendation.getSimilarity();
            TextView textView = this.similarityLabel;
            if (similarity > 0) {
                textView.setVisibility(0);
                this.similarityLabel.setText(this.itemView.getContext().getString(R.string.mythic_similarity, Integer.valueOf(similarity)));
            } else {
                textView.setVisibility(8);
            }
            if (recommendation.getConfidence() >= 3) {
                this.confidenceBadge.setVisibility(0);
                this.confidenceBadge.setText(this.itemView.getContext().getString(R.string.mythic_confidence_strong));
                this.confidenceBadge.setTextColor(Color.parseColor("#2DB570"));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(dpToPx(4));
                gradientDrawable.setStroke(1, Color.argb(51, 45, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 112));
                gradientDrawable.setColor(Color.argb(21, 45, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 112));
                this.confidenceBadge.setBackground(gradientDrawable);
            } else {
                int confidence = recommendation.getConfidence();
                TextView textView2 = this.confidenceBadge;
                if (confidence >= 2) {
                    textView2.setVisibility(0);
                    this.confidenceBadge.setText(this.itemView.getContext().getString(R.string.mythic_confidence_good));
                    this.confidenceBadge.setTextColor(Color.parseColor("#ED9A57"));
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(dpToPx(4));
                    gradientDrawable2.setStroke(1, Color.argb(51, 237, 154, 87));
                    gradientDrawable2.setColor(Color.argb(21, 237, 154, 87));
                    this.confidenceBadge.setBackground(gradientDrawable2);
                } else {
                    textView2.setVisibility(8);
                }
            }
            int deck_count = recommendation.getDeck_count();
            TextView textView3 = this.deckCountLabel;
            if (deck_count > 0) {
                textView3.setVisibility(0);
                this.deckCountLabel.setText(this.itemView.getContext().getString(R.string.mythic_decks, formatDeckCount(recommendation.getDeck_count())));
            } else {
                textView3.setVisibility(8);
            }
            this.newRibbonLabel.setVisibility(Intrinsics.areEqual((Object) recommendation.getRecent(), (Object) true) ? 0 : 8);
        } else {
            linearLayout.setVisibility(8);
            this.newRibbonLabel.setVisibility(8);
        }
        this.addToDeckButton.setEnabled(!z);
        this.dotsMenuButton.setEnabled(!z);
        TextView textView4 = this.addToDeckButton;
        if (z) {
            textView4.setOnClickListener(null);
            this.dotsMenuButton.setOnClickListener(null);
        } else {
            ViewExtensionsKt.setOnClickWithFade(textView4, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MTFullCardListViewHolder.bindRecommendation$lambda$2(this.f$0, card);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(this.dotsMenuButton, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MTFullCardListViewHolder.bindRecommendation$lambda$3(this.f$0, card);
                }
            });
        }
    }

    static final Unit bindRecommendation$lambda$2(MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard) {
        mTFullCardListViewHolder.addToDeckListener.onAddToDeck(mTFullCard, "main");
        return Unit.INSTANCE;
    }

    static final Unit bindRecommendation$lambda$3(final MTFullCardListViewHolder mTFullCardListViewHolder, final MTFullCard mTFullCard) {
        Context context = mTFullCardListViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.mythic_add_to_maybeboard, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTFullCardListViewHolder.bindRecommendation$lambda$3$0(this.f$0, mTFullCard);
            }
        }, 30, (Object) null), R.string.mythic_add_to_sideboard, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTFullCardListViewHolder.bindRecommendation$lambda$3$1(this.f$0, mTFullCard);
            }
        }, 30, (Object) null).show(mTFullCardListViewHolder.dotsMenuButton);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRecommendation$lambda$3$0(MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard) {
        mTFullCardListViewHolder.addToDeckListener.onAddToDeck(mTFullCard, "maybeboard");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRecommendation$lambda$3$1(MTFullCardListViewHolder mTFullCardListViewHolder, MTFullCard mTFullCard) {
        mTFullCardListViewHolder.addToDeckListener.onAddToDeck(mTFullCard, "sideboard");
        return Unit.INSTANCE;
    }

    private final int dpToPx(int dp) {
        return (int) (dp * this.itemView.getResources().getDisplayMetrics().density);
    }

    private final String formatDeckCount(int count) {
        if (count < 1000) {
            return String.valueOf(count);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.1fK", Arrays.copyOf(new Object[]{Double.valueOf(((double) count) / 1000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(int listId, final MTFullCard card, final int position, final boolean selectionMode) {
        String lowerCase;
        boolean z;
        T t;
        String lowerCase2;
        boolean z2;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String gatherer2;
        MTImageURIs mTImageURIs3;
        String normal;
        MTImageURIs mTImageURIs4;
        String normal2;
        String list_name;
        Integer list_type;
        String list_name2;
        Intrinsics.checkNotNullParameter(card, "card");
        Call<MTFullCardResponse> call = this.apiCall;
        if (call != null) {
            call.cancel();
            Unit unit = Unit.INSTANCE;
        }
        this.apiCall = null;
        this.listId = listId;
        this.card = card;
        TextView textView = this.titleLabel;
        String printed_name = card.getPrinted_name();
        if (printed_name == null) {
            printed_name = card.getName();
        }
        textView.setText(printed_name);
        this.typeLabel.setText(card.getType_line());
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SymbolToImage symbolToImage = new SymbolToImage(context);
        String mana_cost = card.getMana_cost();
        String strReplace$default = mana_cost != null ? StringsKt.replace$default(mana_cost, "}{", "} {", false, 4, (Object) null) : null;
        int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_smaller);
        int dimensionPixelSize2 = this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller);
        if (strReplace$default == null) {
            strReplace$default = "{0}";
        }
        this.manaCostLabel.setText(symbolToImage.stringToAttributedStringWithSymbols(strReplace$default, dimensionPixelSize, new CharacterStyle[0]));
        String oracle_text = card.getOracle_text();
        this.oracleLabel.setText(symbolToImage.stringToAttributedStringWithSymbols(symbolToImage.removeDuplicateParentheses(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(oracle_text == null ? "" : oracle_text, "\n", "\n\n", false, 4, (Object) null), "[[", "", false, 4, (Object) null), "]]", "", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null)), dimensionPixelSize2, new ForegroundColorSpan(-3355444)));
        this.imageView.setAutoLoad(false);
        LoadingImageView loadingImageView = this.imageView;
        String set_code = card.getSet_code();
        if (set_code != null) {
            lowerCase = set_code.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        loadingImageView.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        this.imageView.reset();
        this.collectionLayout.setVisibility(8);
        this.deckLayout.setVisibility(8);
        if (listId == -1 && (list_type = card.getList_type()) != null) {
            int iIntValue = list_type.intValue();
            if ((iIntValue == 1 || iIntValue == 2) && (list_name2 = card.getList_name()) != null) {
                this.collectionLayout.setVisibility(0);
                if (Intrinsics.areEqual(list_name2, "bulk")) {
                    list_name2 = this.itemView.getContext().getString(R.string.list_bulk);
                    Intrinsics.checkNotNullExpressionValue(list_name2, "getString(...)");
                }
                this.containerLabel.setText(list_name2);
                Unit unit2 = Unit.INSTANCE;
                Unit unit3 = Unit.INSTANCE;
            }
            Unit unit4 = Unit.INSTANCE;
            Unit unit5 = Unit.INSTANCE;
        }
        Integer list_type2 = card.getList_type();
        if (list_type2 != null) {
            int iIntValue2 = list_type2.intValue();
            if ((iIntValue2 == 3 || iIntValue2 == 4 || iIntValue2 == 5) && (list_name = card.getList_name()) != null) {
                this.deckLayout.setVisibility(0);
                this.deckNameLabel.setText(list_name);
                Unit unit6 = Unit.INSTANCE;
                Unit unit7 = Unit.INSTANCE;
                z = true;
            } else {
                z = false;
            }
            Unit unit8 = Unit.INSTANCE;
            Unit unit9 = Unit.INSTANCE;
        } else {
            z = false;
        }
        LoadingImageView loadingImageView2 = this.imageView;
        if (z) {
            loadingImageView2.setImageColorDimmed(true);
        } else {
            loadingImageView2.setImageColorDimmed(false);
        }
        this.qtyTextView.setVisibility(8);
        this.cornerView.setVisibility(8);
        Integer quantity = card.getQuantity();
        if (quantity != null) {
            int iIntValue3 = quantity.intValue();
            if (iIntValue3 > 1) {
                this.cornerView.setVisibility(0);
                this.qtyTextView.setVisibility(0);
                this.qtyTextView.setText(String.valueOf(iIntValue3));
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        TextView textView2 = this.cardNumberLabel;
        String collector_number = card.getCollector_number();
        if (collector_number == null) {
            collector_number = "---";
        }
        textView2.setText(ColorKt.HEX_PREFIX + collector_number);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String set_code2 = card.getSet_code();
        if (set_code2 != null) {
            String upperCase = set_code2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            t = upperCase;
            if (upperCase == null) {
                t = "...";
            }
        }
        objectRef.element = t;
        this.setLabel.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.setLabel.setText((CharSequence) objectRef.element);
            }
        });
        Resources resources = this.itemView.getContext().getResources();
        String set_code3 = card.getSet_code();
        if (set_code3 == null) {
            set_code3 = "dpa";
        }
        int identifier = resources.getIdentifier("set_" + set_code3, "drawable", this.setImage.getContext().getPackageName());
        ImageView imageView = this.setImage;
        if (identifier != 0) {
            imageView.setImageResource(identifier);
        } else {
            imageView.setVisibility(8);
        }
        String rarity = card.getRarity();
        if (rarity != null) {
            lowerCase2 = rarity.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (lowerCase2 == null) {
                lowerCase2 = "common";
            }
        }
        switch (lowerCase2.hashCode()) {
            case -1354814997:
                if (!lowerCase2.equals("common")) {
                    this.setImage.clearColorFilter();
                    Unit unit12 = Unit.INSTANCE;
                } else {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.almost_white));
                    Unit unit13 = Unit.INSTANCE;
                }
                break;
            case -1059084742:
                if (lowerCase2.equals("mythic")) {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.mythic));
                    Unit unit14 = Unit.INSTANCE;
                    break;
                }
                break;
            case -468311612:
                if (lowerCase2.equals("uncommon")) {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.uncommon));
                    Unit unit15 = Unit.INSTANCE;
                    break;
                }
                break;
            case 3493026:
                if (lowerCase2.equals("rare")) {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.rare));
                    Unit unit16 = Unit.INSTANCE;
                    break;
                }
                break;
        }
        String lang = card.getLang();
        boolean z3 = lang.length() > 0;
        View view = this.flagContainer;
        if (z3) {
            view.setVisibility(0);
            Resources resources2 = this.itemView.getContext().getResources();
            String lowerCase3 = lang.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            int identifier2 = resources2.getIdentifier("flag_" + lowerCase3, "drawable", this.flagImage.getContext().getPackageName());
            if (identifier2 == 0) {
                identifier2 = this.itemView.getContext().getResources().getIdentifier("flag_default", "drawable", this.flagImage.getContext().getPackageName());
            }
            this.flagImage.setImageResource(identifier2);
        } else {
            view.setVisibility(8);
        }
        this.extrasLayout.setVisibility(8);
        Boolean altered = card.getAltered();
        if (altered != null) {
            boolean zBooleanValue = altered.booleanValue();
            TextView textView3 = this.alteredTextView;
            if (zBooleanValue) {
                textView3.setVisibility(0);
                z2 = true;
            } else {
                textView3.setVisibility(8);
                z2 = false;
            }
            Unit unit17 = Unit.INSTANCE;
            Unit unit18 = Unit.INSTANCE;
        } else {
            z2 = false;
        }
        Boolean signed = card.getSigned();
        if (signed != null) {
            boolean zBooleanValue2 = signed.booleanValue();
            TextView textView4 = this.signedTextView;
            if (zBooleanValue2) {
                textView4.setVisibility(0);
                z2 = true;
            } else {
                textView4.setVisibility(8);
            }
            Unit unit19 = Unit.INSTANCE;
            Unit unit20 = Unit.INSTANCE;
        }
        Boolean missprint = card.getMissprint();
        if (missprint != null) {
            boolean zBooleanValue3 = missprint.booleanValue();
            TextView textView5 = this.misprintTextView;
            if (zBooleanValue3) {
                textView5.setVisibility(0);
                z2 = true;
            } else {
                textView5.setVisibility(8);
            }
            Unit unit21 = Unit.INSTANCE;
            Unit unit22 = Unit.INSTANCE;
        }
        Boolean proxy = card.getProxy();
        if (proxy != null) {
            boolean zBooleanValue4 = proxy.booleanValue();
            TextView textView6 = this.proxyTextView;
            if (zBooleanValue4) {
                textView6.setText("\uf0c5");
                this.proxyTextView.setVisibility(0);
                z2 = true;
            } else {
                textView6.setVisibility(8);
            }
            Unit unit23 = Unit.INSTANCE;
            Unit unit24 = Unit.INSTANCE;
        }
        String condition = card.getCondition();
        if (condition != null) {
            if (!(condition.length() > 0) || listId == 1) {
                this.conditionTextView.setVisibility(8);
            } else {
                this.conditionTextView.setVisibility(0);
                TextView textView7 = this.conditionTextView;
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context context2 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                String upperCase2 = condition.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                textView7.setTextColor(companion.colorForCardCondition(context2, upperCase2));
                z2 = true;
            }
            Unit unit25 = Unit.INSTANCE;
            Unit unit26 = Unit.INSTANCE;
        }
        this.foilEffectImage.setVisibility(8);
        String finish = card.getFinish();
        if (finish != null) {
            String lowerCase4 = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (!Intrinsics.areEqual(lowerCase4, "foil")) {
                String lowerCase5 = finish.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase5, "etched")) {
                    this.isFoilImage.setVisibility(0);
                    this.foilEffectImage.setVisibility(0);
                    z2 = true;
                } else {
                    this.isFoilImage.setVisibility(8);
                    this.foilEffectImage.setVisibility(8);
                }
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
            }
        } else {
            List<String> finishes = card.getFinishes();
            if (finishes != null) {
                if (finishes.size() == 1 && (finishes.contains("foil") || finishes.contains("etched"))) {
                    this.isFoilImage.setVisibility(0);
                    this.foilEffectImage.setVisibility(0);
                }
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            }
        }
        if (z2) {
            this.extrasLayout.setVisibility(0);
        }
        Context context3 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context3);
        this.priceLabel.setText(GameUtils.INSTANCE.getInstance().formatPrice(GameUtils.INSTANCE.getInstance().getCardPrice(card, preferencesManager.getPreferredMarket()), preferencesManager.getPreferredCurrency()));
        List<MTImageURIs> images = card.getImages();
        if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (normal2 = mTImageURIs4.getNormal()) == null) {
            List<MTImageURIs> images2 = card.getImages();
            if (images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer = mTImageURIs.getGatherer()) != null) {
                this.imageView.loadImage(gatherer);
                Unit unit31 = Unit.INSTANCE;
                Unit unit32 = Unit.INSTANCE;
            }
        } else {
            this.imageView.loadImage(normal2);
            Unit unit33 = Unit.INSTANCE;
            Unit unit34 = Unit.INSTANCE;
        }
        List<MTImageURIs> images3 = card.getImages();
        if (images3 == null || images3.isEmpty()) {
            List<MTImageURIs> en_images = card.getEn_images();
            if (en_images == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null || (normal = mTImageURIs3.getNormal()) == null) {
                List<MTImageURIs> en_images2 = card.getEn_images();
                if (en_images2 == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) == null || (gatherer2 = mTImageURIs2.getGatherer()) == null) {
                    NetworkHelper networkHelper = NetworkHelper.INSTANCE;
                    Context context4 = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                    if (networkHelper.isNetworkAvailable(context4) && card.getSet_code() != null && card.getCollector_number() != null) {
                        List<MTImageURIs> images4 = card.getImages();
                        if (images4 == null || images4.isEmpty()) {
                            List<MTImageURIs> en_images3 = card.getEn_images();
                            if (en_images3 == null || en_images3.isEmpty()) {
                                MTApi mtApi = MTApiKt.getMtApi();
                                String lang2 = card.getLang();
                                if (lang2 == null) {
                                    lang2 = "en";
                                }
                                String set_code4 = card.getSet_code();
                                if (set_code4 == null) {
                                    set_code4 = "";
                                }
                                String collector_number2 = card.getCollector_number();
                                String str = collector_number2 != null ? collector_number2 : "";
                                MTUser currentUser = preferencesManager.getCurrentUser();
                                Call<MTFullCardResponse> cardWithParameters = mtApi.getCardWithParameters(lang2, set_code4, str, currentUser != null ? Integer.valueOf(currentUser.getId()) : null);
                                this.apiCall = cardWithParameters;
                                if (cardWithParameters != null) {
                                    cardWithParameters.enqueue(new Callback<MTFullCardResponse>() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$bind$15$2$1
                                        @Override // retrofit2.Callback
                                        public void onFailure(Call<MTFullCardResponse> call2, Throwable t2) {
                                            Intrinsics.checkNotNullParameter(call2, "call");
                                            Intrinsics.checkNotNullParameter(t2, "t");
                                        }

                                        @Override // retrofit2.Callback
                                        public void onResponse(Call<MTFullCardResponse> call2, Response<MTFullCardResponse> response) {
                                            MTImageURIs mTImageURIs5;
                                            String gatherer3;
                                            MTImageURIs mTImageURIs6;
                                            String normal3;
                                            MTImageURIs mTImageURIs7;
                                            String gatherer4;
                                            MTImageURIs mTImageURIs8;
                                            String normal4;
                                            Intrinsics.checkNotNullParameter(call2, "call");
                                            Intrinsics.checkNotNullParameter(response, "response");
                                            if (response.isSuccessful()) {
                                                MTFullCardResponse mTFullCardResponseBody = response.body();
                                                MTFullCard card2 = mTFullCardResponseBody != null ? mTFullCardResponseBody.getCard() : null;
                                                if (card2 != null) {
                                                    MTFullCard mTFullCard = card;
                                                    MTFullCardListViewHolder mTFullCardListViewHolder = this;
                                                    mTFullCard.setImages(card2.getImages());
                                                    mTFullCard.setEn_images(card2.getEn_images());
                                                    mTFullCard.setFinish(card2.getFinish());
                                                    mTFullCard.setFinishes(card2.getFinishes());
                                                    Double current_value_usd = card2.getCurrent_value_usd();
                                                    if (current_value_usd != null) {
                                                        mTFullCard.setCurrent_value_usd(Double.valueOf(current_value_usd.doubleValue()));
                                                    }
                                                    Double current_value_eur = card2.getCurrent_value_eur();
                                                    if (current_value_eur != null) {
                                                        mTFullCard.setCurrent_value_eur(Double.valueOf(current_value_eur.doubleValue()));
                                                    }
                                                    Double current_value_usd_foil = card2.getCurrent_value_usd_foil();
                                                    if (current_value_usd_foil != null) {
                                                        mTFullCard.setCurrent_value_usd_foil(Double.valueOf(current_value_usd_foil.doubleValue()));
                                                    }
                                                    Double current_value_eur_foil = card2.getCurrent_value_eur_foil();
                                                    if (current_value_eur_foil != null) {
                                                        mTFullCard.setCurrent_value_eur_foil(Double.valueOf(current_value_eur_foil.doubleValue()));
                                                    }
                                                    Double current_value_usd_etched = card2.getCurrent_value_usd_etched();
                                                    if (current_value_usd_etched != null) {
                                                        mTFullCard.setCurrent_value_usd_etched(Double.valueOf(current_value_usd_etched.doubleValue()));
                                                    }
                                                    Double current_value_eur_etched = card2.getCurrent_value_eur_etched();
                                                    if (current_value_eur_etched != null) {
                                                        mTFullCard.setCurrent_value_eur_etched(Double.valueOf(current_value_eur_etched.doubleValue()));
                                                    }
                                                    MTCardMarketplaceValues values = card2.getValues();
                                                    if (values != null) {
                                                        mTFullCard.setValues(values);
                                                    }
                                                    Context context5 = mTFullCardListViewHolder.itemView.getContext();
                                                    Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                                                    PreferencesManager preferencesManager2 = new PreferencesManager(context5);
                                                    mTFullCardListViewHolder.priceLabel.setText(GameUtils.INSTANCE.getInstance().formatPrice(GameUtils.INSTANCE.getInstance().getCardPrice(mTFullCard, preferencesManager2.getPreferredMarket()), preferencesManager2.getPreferredCurrency()));
                                                    List<MTImageURIs> images5 = card2.getImages();
                                                    if (images5 != null && (mTImageURIs8 = (MTImageURIs) CollectionsKt.firstOrNull((List) images5)) != null && (normal4 = mTImageURIs8.getNormal()) != null) {
                                                        mTFullCardListViewHolder.imageView.loadImage(normal4);
                                                        return;
                                                    }
                                                    List<MTImageURIs> images6 = card2.getImages();
                                                    if (images6 != null && (mTImageURIs7 = (MTImageURIs) CollectionsKt.firstOrNull((List) images6)) != null && (gatherer4 = mTImageURIs7.getGatherer()) != null) {
                                                        mTFullCardListViewHolder.imageView.loadImage(gatherer4);
                                                        return;
                                                    }
                                                    List<MTImageURIs> en_images4 = card2.getEn_images();
                                                    if (en_images4 != null && (mTImageURIs6 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images4)) != null && (normal3 = mTImageURIs6.getNormal()) != null) {
                                                        mTFullCardListViewHolder.imageView.loadImage(normal3);
                                                        return;
                                                    }
                                                    List<MTImageURIs> en_images5 = card2.getEn_images();
                                                    if (en_images5 == null || (mTImageURIs5 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images5)) == null || (gatherer3 = mTImageURIs5.getGatherer()) == null) {
                                                        return;
                                                    }
                                                    mTFullCardListViewHolder.imageView.loadImage(gatherer3);
                                                }
                                            }
                                        }
                                    });
                                    Unit unit35 = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    Unit unit36 = Unit.INSTANCE;
                } else {
                    this.imageView.loadImage(gatherer2);
                    Unit unit37 = Unit.INSTANCE;
                }
                Unit unit38 = Unit.INSTANCE;
            } else {
                this.imageView.loadImage(normal);
                Unit unit39 = Unit.INSTANCE;
            }
        }
        String loyalty = card.getLoyalty();
        if (loyalty != null) {
            this.bottomLayout.setVisibility(0);
            this.bottomLabel.setVisibility(0);
            this.bottomLabel.setText(this.itemView.getResources().getString(R.string.loyalty));
            this.powerToughnessText.setText(String.valueOf(loyalty));
            Unit unit40 = Unit.INSTANCE;
            Unit unit41 = Unit.INSTANCE;
        }
        String defense = card.getDefense();
        if (defense != null) {
            this.bottomLayout.setVisibility(0);
            this.bottomLabel.setVisibility(0);
            this.bottomLabel.setText(this.itemView.getResources().getString(R.string.defense));
            this.powerToughnessText.setText(String.valueOf(defense));
            Unit unit42 = Unit.INSTANCE;
            Unit unit43 = Unit.INSTANCE;
        }
        String power = card.getPower();
        if (power != null) {
            this.bottomLayout.setVisibility(0);
            this.bottomLabel.setVisibility(8);
            String toughness = card.getToughness();
            if (toughness != null) {
                String str2 = power;
                if (str2.length() > 0) {
                    if (toughness.length() > 0) {
                        this.powerToughnessText.setText(power + " / " + toughness);
                    }
                    Unit unit44 = Unit.INSTANCE;
                } else {
                    if (str2.length() > 0) {
                        this.powerToughnessText.setText(String.valueOf(power));
                    } else {
                        this.bottomLayout.setVisibility(8);
                        this.bottomLabel.setVisibility(8);
                    }
                    Unit unit442 = Unit.INSTANCE;
                }
            } else {
                this.powerToughnessText.setText(card.getPower());
                Unit unit45 = Unit.INSTANCE;
            }
            Unit unit46 = Unit.INSTANCE;
        } else {
            this.bottomLayout.setVisibility(8);
            this.bottomLabel.setVisibility(8);
            Unit unit47 = Unit.INSTANCE;
        }
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return MTFullCardListViewHolder.bind$lambda$19(this.f$0, card, position, view2);
            }
        });
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MTFullCardListViewHolder.bind$lambda$20(selectionMode, this, card, position);
            }
        });
        ConstraintLayout constraintLayout = this.selectionControlsLayout;
        if (selectionMode) {
            constraintLayout.setVisibility(0);
            card.getCardid();
            OnCardSelectionListener onCardSelectionListener = this.selectionListener;
            BrowseListFragment browseListFragment = onCardSelectionListener instanceof BrowseListFragment ? (BrowseListFragment) onCardSelectionListener : null;
            boolean zIsCardSelected = browseListFragment != null ? browseListFragment.isCardSelected(position) : false;
            OnCardSelectionListener onCardSelectionListener2 = this.selectionListener;
            BrowseListFragment browseListFragment2 = onCardSelectionListener2 instanceof BrowseListFragment ? (BrowseListFragment) onCardSelectionListener2 : null;
            final int selectedQuantity = browseListFragment2 != null ? browseListFragment2.getSelectedQuantity(position) : 0;
            Integer quantity2 = card.getQuantity();
            final int iIntValue4 = quantity2 != null ? quantity2.intValue() : 1;
            LinearLayout linearLayout = this.rootLayout;
            if (zIsCardSelected) {
                linearLayout.setBackgroundResource(R.drawable.rounded_corners_print_view_selected);
            } else {
                linearLayout.setBackgroundResource(R.drawable.rounded_corners_print_view);
            }
            TextView textView8 = this.selectedAmountText;
            if (zIsCardSelected) {
                textView8.setVisibility(0);
                this.selectedAmountText.setText(String.valueOf(selectedQuantity));
                ConstraintLayout constraintLayout2 = this.plusQtyLayout;
                if (iIntValue4 > 1) {
                    constraintLayout2.setVisibility(0);
                    this.minusQtyLayout.setVisibility(0);
                    ViewExtensionsKt.setOnClickWithFade(this.plusQtyLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MTFullCardListViewHolder.bind$lambda$21(selectedQuantity, iIntValue4, this, card, position);
                        }
                    });
                    ViewExtensionsKt.setOnClickWithFade(this.minusQtyLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.MTFullCardListViewHolder$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MTFullCardListViewHolder.bind$lambda$22(selectedQuantity, this, card, position);
                        }
                    });
                } else {
                    constraintLayout2.setVisibility(8);
                    this.minusQtyLayout.setVisibility(8);
                }
            } else {
                textView8.setVisibility(8);
                this.plusQtyLayout.setVisibility(8);
                this.minusQtyLayout.setVisibility(8);
            }
        } else {
            constraintLayout.setVisibility(8);
            this.rootLayout.setBackgroundResource(R.drawable.rounded_corners_print_view);
        }
        bindMythicCollectionStatus(card);
        bindRecommendation(card);
    }

    public final void onRecycled() {
        Call<MTFullCardResponse> call = this.apiCall;
        if (call != null) {
            call.cancel();
        }
        this.apiCall = null;
        this.imageView.reset();
        this.itemView.setAlpha(1.0f);
    }
}
