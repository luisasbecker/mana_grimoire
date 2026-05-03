package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.Iterator;
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

/* JADX INFO: compiled from: ScannedCardViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000203J \u00104\u001a\u0002032\u0006\u0010$\u001a\u00020%2\u0006\u00105\u001a\u00020.2\b\b\u0002\u0010+\u001a\u00020*J\u0018\u00106\u001a\u0002032\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u00107\u001a\u0002032\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00108\u001a\u0002032\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010:\u001a\u0002032\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScannedCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardClickListener", "Lcom/studiolaganne/lengendarylens/OnScannedCardClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/studiolaganne/lengendarylens/OnScannedCardClickListener;Landroid/view/View;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "setImage", "Landroid/widget/ImageView;", "priceLabel", "Landroid/widget/TextView;", "foilEffectImage", "cornerView", "qtyTextView", "flagContainer", "flagImage", "closeLayout", "setImageLayout", "cardNumberTextView", "cardOverlayLayout", "cardImageContainer", "adjustmentsLayout", "foilSwitch", "Landroid/widget/Switch;", "qtyLayout", "Landroid/widget/LinearLayout;", "qtyLabel", "minusQtyLabel", "plusQtyLabel", "foilSwitchLayout", "collectionMatchLabel", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "collectionCall", "Lretrofit2/Call;", "Lcom/studiolaganne/lengendarylens/MTCardCollectionStatusResponse;", "offline", "", "isLastItem", "isUpdatingProgrammatically", "dpToPx", "", "dp", "context", "Landroid/content/Context;", "cleanup", "", "bind", "position", "setupAdjustmentControls", "setupFoilSwitch", "setupCollectionStatus", "displayCollectionLabel", "setupQuantityControls", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScannedCardViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ConstraintLayout adjustmentsLayout;
    private MTFullCard card;
    private final OnScannedCardClickListener cardClickListener;
    private final ConstraintLayout cardImageContainer;
    private final TextView cardNumberTextView;
    private final ConstraintLayout cardOverlayLayout;
    private final ConstraintLayout closeLayout;
    private Call<MTCardCollectionStatusResponse> collectionCall;
    private final TextView collectionMatchLabel;
    private final View cornerView;
    private final View flagContainer;
    private final ImageView flagImage;
    private final ImageView foilEffectImage;
    private final Switch foilSwitch;
    private final LinearLayout foilSwitchLayout;
    private final LoadingImageView imageView;
    private boolean isLastItem;
    private boolean isUpdatingProgrammatically;
    private final TextView minusQtyLabel;
    private boolean offline;
    private final TextView plusQtyLabel;
    private final TextView priceLabel;
    private final TextView qtyLabel;
    private final LinearLayout qtyLayout;
    private final TextView qtyTextView;
    private final ConstraintLayout rootLayout;
    private final ImageView setImage;
    private final ConstraintLayout setImageLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScannedCardViewHolder(OnScannedCardClickListener cardClickListener, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.cardClickListener = cardClickListener;
        View viewFindViewById = itemView.findViewById(R.id.rootLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.imageView = (LoadingImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.setImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.setImage = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.priceLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.priceLabel = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.foilEffectImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.foilEffectImage = (ImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.cornerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.cornerView = viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.qtyTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.qtyTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.flag_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.flagContainer = viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.flag_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.flagImage = (ImageView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.closeLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.closeLayout = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.setImageLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.setImageLayout = (ConstraintLayout) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.cardNumberTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.cardNumberTextView = (TextView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.cardOverlayLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.cardOverlayLayout = (ConstraintLayout) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.cardImageContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.cardImageContainer = (ConstraintLayout) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.adjustmentsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.adjustmentsLayout = (ConstraintLayout) viewFindViewById15;
        View viewFindViewById16 = itemView.findViewById(R.id.foilSwitch);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.foilSwitch = (Switch) viewFindViewById16;
        View viewFindViewById17 = itemView.findViewById(R.id.qtyLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.qtyLayout = (LinearLayout) viewFindViewById17;
        View viewFindViewById18 = itemView.findViewById(R.id.qtyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.qtyLabel = (TextView) viewFindViewById18;
        View viewFindViewById19 = itemView.findViewById(R.id.minusQtyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.minusQtyLabel = (TextView) viewFindViewById19;
        View viewFindViewById20 = itemView.findViewById(R.id.plusQtyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.plusQtyLabel = (TextView) viewFindViewById20;
        View viewFindViewById21 = itemView.findViewById(R.id.foilSwitchLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.foilSwitchLayout = (LinearLayout) viewFindViewById21;
        View viewFindViewById22 = itemView.findViewById(R.id.collectionMatchLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.collectionMatchLabel = (TextView) viewFindViewById22;
    }

    public static /* synthetic */ void bind$default(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        scannedCardViewHolder.bind(mTFullCard, i, z);
    }

    static final void bind$lambda$0(View view) {
    }

    static final Unit bind$lambda$1(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            scannedCardViewHolder.cardClickListener.onScannedCardClick(mTFullCard, bindingAdapterPosition);
        }
        return Unit.INSTANCE;
    }

    static final Unit bind$lambda$2(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            scannedCardViewHolder.cardClickListener.onScannedCardDeleteClick(mTFullCard, bindingAdapterPosition);
        }
        return Unit.INSTANCE;
    }

    static final Unit bind$lambda$3(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            scannedCardViewHolder.cardClickListener.onScannedCardEditClick(mTFullCard, bindingAdapterPosition);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayCollectionLabel(final MTFullCard card) {
        MTCardCollectionMatches matches;
        List<MTCollectionCardMatch> exact;
        MTCardCollectionStatus collection = card.getCollection();
        if (collection == null || (matches = collection.getMatches()) == null) {
            this.collectionMatchLabel.setVisibility(8);
            return;
        }
        boolean z = true;
        boolean z2 = Intrinsics.areEqual((Object) matches.getHas_exact(), (Object) true) || !((exact = matches.getExact()) == null || exact.isEmpty());
        List<MTCollectionCardMatch> all = matches.getAll();
        if (all != null && !all.isEmpty()) {
            z = false;
        }
        this.collectionMatchLabel.setVisibility(0);
        if (z2) {
            this.collectionMatchLabel.setText(this.itemView.getContext().getString(R.string.collection_match_exact));
            this.collectionMatchLabel.setBackgroundResource(R.drawable.match_exact_box);
        } else {
            TextView textView = this.collectionMatchLabel;
            if (z) {
                textView.setText(this.itemView.getContext().getString(R.string.collection_match_none));
                this.collectionMatchLabel.setBackgroundResource(R.drawable.match_none_box);
            } else {
                textView.setText(this.itemView.getContext().getString(R.string.collection_match_partial));
                this.collectionMatchLabel.setBackgroundResource(R.drawable.match_partial_box);
            }
        }
        this.collectionMatchLabel.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannedCardViewHolder.displayCollectionLabel$lambda$1(this.f$0, card, view);
            }
        });
    }

    static final void displayCollectionLabel$lambda$1(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard, View view) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            scannedCardViewHolder.cardClickListener.onScannedCardCollectionTapped(mTFullCard, bindingAdapterPosition);
        }
    }

    private final void setupAdjustmentControls(MTFullCard card, boolean isLastItem) {
        ConstraintLayout constraintLayout = this.adjustmentsLayout;
        if (isLastItem) {
            constraintLayout.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.cardImageContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            layoutParams2.setMarginEnd(dpToPx(64, context));
            this.cardImageContainer.setLayoutParams(layoutParams2);
            setupFoilSwitch(card);
            setupQuantityControls(card);
            setupCollectionStatus(card, true);
            return;
        }
        constraintLayout.setVisibility(8);
        this.collectionMatchLabel.setVisibility(8);
        Call<MTCardCollectionStatusResponse> call = this.collectionCall;
        if (call != null) {
            call.cancel();
        }
        this.collectionCall = null;
        ViewGroup.LayoutParams layoutParams3 = this.cardImageContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        Context context2 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        layoutParams4.setMarginEnd(dpToPx(16, context2));
        this.cardImageContainer.setLayoutParams(layoutParams4);
    }

    private final void setupCollectionStatus(final MTFullCard card, boolean isLastItem) {
        Call<MTCardCollectionStatusResponse> call = this.collectionCall;
        if (call != null) {
            call.cancel();
        }
        this.collectionCall = null;
        if (!isLastItem) {
            this.collectionMatchLabel.setVisibility(8);
            return;
        }
        final String cardid = card.getCardid();
        String str = cardid;
        if (str == null || str.length() == 0) {
            this.collectionMatchLabel.setVisibility(8);
            return;
        }
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MTUser currentUser = new PreferencesManager(context).getCurrentUser();
        Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
        if (numValueOf == null) {
            this.collectionMatchLabel.setVisibility(8);
            return;
        }
        MTCardCollectionStatus collection = card.getCollection();
        if ((collection != null ? collection.getMatches() : null) != null) {
            displayCollectionLabel(card);
            return;
        }
        this.collectionMatchLabel.setVisibility(8);
        Call<MTCardCollectionStatusResponse> cardCollectionStatus = MTApiKt.getMtApi().getCardCollectionStatus(cardid, numValueOf);
        this.collectionCall = cardCollectionStatus;
        cardCollectionStatus.enqueue(new Callback<MTCardCollectionStatusResponse>() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder.setupCollectionStatus.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardCollectionStatusResponse> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardCollectionStatusResponse> call2, Response<MTCardCollectionStatusResponse> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                MTFullCard mTFullCard = ScannedCardViewHolder.this.card;
                if (Intrinsics.areEqual(mTFullCard != null ? mTFullCard.getCardid() : null, cardid)) {
                    MTCardCollectionStatusResponse mTCardCollectionStatusResponseBody = response.body();
                    MTCardCollectionMatches collection2 = mTCardCollectionStatusResponseBody != null ? mTCardCollectionStatusResponseBody.getCollection() : null;
                    if (collection2 != null) {
                        card.setCollection(new MTCardCollectionStatus(null, false, null, collection2, null, null, null, null, null, null, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null));
                        ScannedCardViewHolder.this.displayCollectionLabel(card);
                    }
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupFoilSwitch(final MTFullCard card) {
        String lowerCase;
        ArrayList arrayListEmptyList;
        String finish = card.getFinish();
        if (finish != null) {
            lowerCase = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
                lowerCase = "nonfoil";
            }
        }
        List<String> finishes = card.getFinishes();
        if (finishes != null) {
            List<String> list = finishes;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                arrayList.add(lowerCase2);
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        if (card.getFinish() == null && arrayListEmptyList.size() == 1) {
            lowerCase = (String) CollectionsKt.first(arrayListEmptyList);
        }
        boolean zContains = arrayListEmptyList.contains("foil");
        boolean zContains2 = arrayListEmptyList.contains("etched");
        final boolean zContains3 = arrayListEmptyList.contains("nonfoil");
        final boolean z = zContains || zContains2;
        boolean z2 = arrayListEmptyList.isEmpty() || arrayListEmptyList.size() > 1;
        this.foilSwitch.setOnCheckedChangeListener(null);
        this.foilSwitch.setOnClickListener(null);
        this.foilSwitchLayout.setOnClickListener(null);
        this.foilSwitch.setChecked(Intrinsics.areEqual(lowerCase, "foil") || Intrinsics.areEqual(lowerCase, "etched"));
        this.foilSwitch.setEnabled(z2);
        Switch r0 = this.foilSwitch;
        if (z2) {
            r0.setClickable(true);
            this.foilSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    ScannedCardViewHolder.setupFoilSwitch$lambda$1(this.f$0, card, compoundButton, z3);
                }
            });
        } else {
            r0.setClickable(false);
            ViewExtensionsKt.setOnClickWithFade(this.foilSwitchLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScannedCardViewHolder.setupFoilSwitch$lambda$2(z, zContains3, this);
                }
            });
        }
    }

    static final void setupFoilSwitch$lambda$1(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard, CompoundButton compoundButton, boolean z) {
        int bindingAdapterPosition;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (scannedCardViewHolder.isUpdatingProgrammatically || (bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition()) == -1) {
            return;
        }
        scannedCardViewHolder.cardClickListener.onScannedCardFinishToggled(mTFullCard, bindingAdapterPosition);
    }

    static final Unit setupFoilSwitch$lambda$2(boolean z, boolean z2, ScannedCardViewHolder scannedCardViewHolder) {
        String string = (!z || z2) ? (z2 && z) ? scannedCardViewHolder.itemView.getContext().getString(R.string.card_only_nonfoil) : scannedCardViewHolder.itemView.getContext().getString(R.string.card_only_nonfoil) : scannedCardViewHolder.itemView.getContext().getString(R.string.card_only_foil);
        Intrinsics.checkNotNull(string);
        Toast.makeText(scannedCardViewHolder.itemView.getContext(), string, 0).show();
        return Unit.INSTANCE;
    }

    private final void setupQuantityControls(final MTFullCard card) {
        Integer quantity = card.getQuantity();
        final int iIntValue = quantity != null ? quantity.intValue() : 1;
        this.qtyLabel.setText(String.valueOf(iIntValue));
        this.qtyLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannedCardViewHolder.setupQuantityControls$lambda$0(this.f$0, iIntValue, card, view);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.minusQtyLabel, new Function0() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScannedCardViewHolder.setupQuantityControls$lambda$1(this.f$0, iIntValue, card);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.plusQtyLabel, new Function0() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScannedCardViewHolder.setupQuantityControls$lambda$2(this.f$0, card, iIntValue);
            }
        });
    }

    static final void setupQuantityControls$lambda$0(ScannedCardViewHolder scannedCardViewHolder, int i, MTFullCard mTFullCard, View view) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        Object tag = view.getTag();
        MotionEvent motionEvent = tag instanceof MotionEvent ? (MotionEvent) tag : null;
        int i2 = (motionEvent != null ? motionEvent.getX() : ((float) view.getWidth()) / 2.0f) < ((float) view.getWidth()) / 2.0f ? i > 1 ? i - 1 : i : i + 1;
        if (i2 != i) {
            scannedCardViewHolder.cardClickListener.onScannedCardQuantityChanged(mTFullCard, bindingAdapterPosition, i2);
        }
    }

    static final Unit setupQuantityControls$lambda$1(ScannedCardViewHolder scannedCardViewHolder, int i, MTFullCard mTFullCard) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1 && i > 1) {
            scannedCardViewHolder.cardClickListener.onScannedCardQuantityChanged(mTFullCard, bindingAdapterPosition, i - 1);
        }
        return Unit.INSTANCE;
    }

    static final Unit setupQuantityControls$lambda$2(ScannedCardViewHolder scannedCardViewHolder, MTFullCard mTFullCard, int i) {
        int bindingAdapterPosition = scannedCardViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            scannedCardViewHolder.cardClickListener.onScannedCardQuantityChanged(mTFullCard, bindingAdapterPosition, i + 1);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b8 A[PHI: r11
      0x02b8: PHI (r11v51 java.lang.String) = (r11v40 java.lang.String), (r11v43 java.lang.String), (r11v54 java.lang.String) binds: [B:89:0x02ce, B:96:0x02e4, B:80:0x02b5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(final MTFullCard card, int position, boolean isLastItem) {
        String lowerCase;
        String lowerCase2;
        MTImageURIs mTImageURIs;
        MTImageURIs mTImageURIs2;
        MTImageURIs mTImageURIs3;
        MTImageURIs mTImageURIs4;
        int iIntValue;
        Intrinsics.checkNotNullParameter(card, "card");
        this.offline = false;
        this.card = card;
        this.isLastItem = isLastItem;
        this.imageView.setAutoLoad(true);
        LoadingImageView loadingImageView = this.imageView;
        String set_code = card.getSet_code();
        final String gatherer = null;
        if (set_code != null) {
            lowerCase = set_code.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        loadingImageView.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        this.imageView.reset();
        this.adjustmentsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannedCardViewHolder.bind$lambda$0(view);
            }
        });
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScannedCardViewHolder.bind$lambda$1(this.f$0, card);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.closeLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScannedCardViewHolder.bind$lambda$2(this.f$0, card);
            }
        });
        ViewExtensionsKt.setOnClickWithBounce(this.cardOverlayLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScannedCardViewHolder.bind$lambda$3(this.f$0, card);
            }
        });
        setupAdjustmentControls(card, isLastItem);
        this.qtyTextView.setVisibility(8);
        this.cornerView.setVisibility(8);
        Integer quantity = card.getQuantity();
        if (quantity != null && (iIntValue = quantity.intValue()) > 1) {
            this.cornerView.setVisibility(0);
            this.qtyTextView.setVisibility(0);
            this.qtyTextView.setText(String.valueOf(iIntValue));
        }
        String set_code2 = card.getSet_code();
        if (set_code2 != null) {
            Intrinsics.checkNotNullExpressionValue(set_code2.toUpperCase(Locale.ROOT), "toUpperCase(...)");
        }
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
            imageView.setVisibility(4);
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
                } else {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.common_bright));
                }
                break;
            case -1059084742:
                if (lowerCase2.equals("mythic")) {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.mythic_bright));
                    break;
                }
                break;
            case -468311612:
                if (lowerCase2.equals("uncommon")) {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.uncommon_bright));
                    break;
                }
                break;
            case 3493026:
                if (lowerCase2.equals("rare")) {
                    this.setImage.setColorFilter(ContextCompat.getColor(this.itemView.getContext(), R.color.rare_bright));
                    break;
                }
                break;
        }
        this.cardNumberTextView.setVisibility(0);
        String collector_number = card.getCollector_number();
        if (collector_number == null || collector_number.length() == 0) {
            this.cardNumberTextView.setText("---");
        } else {
            this.cardNumberTextView.setText(ColorKt.HEX_PREFIX + card.getCollector_number());
        }
        String lang = card.getLang();
        int length = lang.length();
        View view = this.flagContainer;
        if (length > 0) {
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
        this.foilEffectImage.setVisibility(8);
        this.isUpdatingProgrammatically = true;
        this.foilSwitch.setChecked(false);
        String finish = card.getFinish();
        if (finish != null) {
            String lowerCase4 = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            boolean zAreEqual = Intrinsics.areEqual(lowerCase4, "foil");
            ImageView imageView2 = this.foilEffectImage;
            if (zAreEqual) {
                imageView2.setVisibility(0);
                this.foilSwitch.setChecked(true);
            } else {
                imageView2.setVisibility(8);
            }
        } else {
            List<String> finishes = card.getFinishes();
            if (finishes != null && finishes.size() == 1 && (finishes.contains("foil") || finishes.contains("etched"))) {
                this.foilEffectImage.setVisibility(0);
                this.foilSwitch.setChecked(true);
            }
        }
        this.isUpdatingProgrammatically = false;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        this.priceLabel.setText(GameUtils.INSTANCE.getInstance().formatPrice(GameUtils.INSTANCE.getInstance().getCardPrice(card, preferencesManager.getPreferredMarket()), preferencesManager.getPreferredCurrency()));
        List<MTImageURIs> images = card.getImages();
        if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (gatherer = mTImageURIs4.getPng()) == null) {
            List<MTImageURIs> images2 = card.getImages();
            String gatherer2 = (images2 == null || (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) == null) ? null : mTImageURIs3.getGatherer();
            if (gatherer2 != null) {
                gatherer = gatherer2;
            } else {
                List<MTImageURIs> en_images = card.getEn_images();
                gatherer2 = (en_images == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null) ? null : mTImageURIs2.getPng();
                if (gatherer2 == null) {
                    List<MTImageURIs> en_images2 = card.getEn_images();
                    if (en_images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null) {
                        gatherer = mTImageURIs.getGatherer();
                    }
                }
            }
        }
        String str = gatherer;
        if (str == null || str.length() == 0) {
            this.imageView.setImageResource(R.drawable.card_back_small_err);
            this.imageView.setAutoLoad(false);
            this.imageView.loadNetworkErr();
        } else {
            this.imageView.setImageUrl(gatherer);
            this.imageView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScannedCardViewHolder$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.imageView.loadImage(gatherer);
                }
            }, 20L);
        }
    }

    public final void cleanup() {
        this.card = null;
        Call<MTCardCollectionStatusResponse> call = this.collectionCall;
        if (call != null) {
            call.cancel();
        }
        this.collectionCall = null;
        this.collectionMatchLabel.setVisibility(8);
        this.imageView.reset();
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
