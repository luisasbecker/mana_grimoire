package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.vanniktech.ui.ColorKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/PrintViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "printClickListener", "Lcom/studiolaganne/lengendarylens/OnPrintClickListener;", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "currentMTCardId", "", "currentFace", "", "itemView", "Landroid/view/View;", "<init>", "(Lcom/studiolaganne/lengendarylens/OnPrintClickListener;Ljava/util/List;Ljava/lang/String;ILandroid/view/View;)V", "imageView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "setImage", "Landroid/widget/ImageView;", "setLabel", "Landroid/widget/TextView;", "cardNumberLabel", "priceLabel", "isFoilImage", "bind", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "Lcom/studiolaganne/lengendarylens/Card;", "onRecycled", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrintViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView cardNumberLabel;
    private List<CardSet> cardSets;
    private final int currentFace;
    private final String currentMTCardId;
    private final LoadingImageView imageView;
    private final ImageView isFoilImage;
    private final TextView priceLabel;
    private final OnPrintClickListener printClickListener;
    private final ImageView setImage;
    private final TextView setLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrintViewHolder(OnPrintClickListener printClickListener, List<CardSet> cardSets, String str, int i, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(printClickListener, "printClickListener");
        Intrinsics.checkNotNullParameter(cardSets, "cardSets");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.printClickListener = printClickListener;
        this.cardSets = cardSets;
        this.currentMTCardId = str;
        this.currentFace = i;
        View viewFindViewById = itemView.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.imageView = (LoadingImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.setImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.setImage = (ImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.setLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.setLabel = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.cardNumberLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.cardNumberLabel = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.priceLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.priceLabel = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.is_foil_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.isFoilImage = (ImageView) viewFindViewById6;
    }

    static final Unit bind$lambda$0(PrintViewHolder printViewHolder, MTFullCard mTFullCard) {
        printViewHolder.printClickListener.onMTPrintClick(mTFullCard);
        return Unit.INSTANCE;
    }

    public final void bind(Card card) {
        String normal;
        ImageUris image_uris;
        String normal2;
        Intrinsics.checkNotNullParameter(card, "card");
        this.imageView.setAutoLoad(false);
        LoadingImageView loadingImageView = this.imageView;
        String lowerCase = card.getSet().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        loadingImageView.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        this.imageView.reset();
        TextView textView = this.cardNumberLabel;
        String collector_number = card.getCollector_number();
        if (collector_number == null) {
            collector_number = "---";
        }
        textView.setText(ColorKt.HEX_PREFIX + collector_number);
        String set = card.getSet();
        List<CardSet> list = this.cardSets;
        CardSet cardSet = null;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((CardSet) next).getCode(), set)) {
                    obj = next;
                    break;
                }
            }
            cardSet = (CardSet) obj;
        }
        if (cardSet != null) {
            set = cardSet.getName();
        }
        this.setLabel.setText(set);
        int identifier = this.itemView.getContext().getResources().getIdentifier("set_" + card.getSet(), "drawable", this.setImage.getContext().getPackageName());
        if (identifier != 0) {
            this.setImage.setImageResource(identifier);
        }
        this.priceLabel.setVisibility(8);
        this.isFoilImage.setVisibility(8);
        Prices prices = card.getPrices();
        if (prices != null) {
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            String preferredCurrency = new PreferencesManager(context).getPreferredCurrency();
            if (Intrinsics.areEqual(preferredCurrency, "USD")) {
                if (card.getNonfoil() != null ? !r2.booleanValue() : false) {
                    this.isFoilImage.setVisibility(0);
                    String usd_foil = prices.getUsd_foil();
                    if (usd_foil != null) {
                        this.priceLabel.setVisibility(0);
                        this.priceLabel.setText("$ " + usd_foil);
                    }
                } else {
                    String usd = prices.getUsd();
                    if (usd != null) {
                        this.priceLabel.setVisibility(0);
                        this.priceLabel.setText("$ " + usd);
                    }
                }
            } else if (Intrinsics.areEqual(preferredCurrency, "EUR")) {
                if (card.getNonfoil() != null ? !r2.booleanValue() : false) {
                    this.isFoilImage.setVisibility(0);
                    String eur_foil = prices.getEur_foil();
                    if (eur_foil != null) {
                        this.priceLabel.setVisibility(0);
                        this.priceLabel.setText("€ " + eur_foil);
                    }
                } else {
                    String eur = prices.getEur();
                    if (eur != null) {
                        this.priceLabel.setVisibility(0);
                        this.priceLabel.setText("€ " + eur);
                    }
                }
            }
        }
        ImageUris image_uris2 = card.getImage_uris();
        if (image_uris2 != null) {
            normal = image_uris2.getNormal();
        } else {
            List<CardFace> card_faces = card.getCard_faces();
            String str = "";
            if (card_faces != null && (image_uris = card_faces.get(this.currentFace).getImage_uris()) != null && (normal2 = image_uris.getNormal()) != null) {
                str = normal2;
            }
            normal = str;
        }
        this.imageView.loadImage(normal);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b2 A[PHI: r10
      0x01b2: PHI (r10v5 java.lang.String) = (r10v4 java.lang.String), (r10v6 java.lang.String), (r10v7 java.lang.String) binds: [B:71:0x01cf, B:59:0x01a9, B:61:0x01af] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(final MTFullCard card) {
        String lowerCase;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        Intrinsics.checkNotNullParameter(card, "card");
        this.imageView.setAutoLoad(false);
        LoadingImageView loadingImageView = this.imageView;
        String set_code = card.getSet_code();
        Object obj = null;
        if (set_code != null) {
            lowerCase = set_code.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        loadingImageView.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        this.imageView.reset();
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.PrintViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrintViewHolder.bind$lambda$0(this.f$0, card);
            }
        });
        TextView textView = this.cardNumberLabel;
        String collector_number = card.getCollector_number();
        if (collector_number == null) {
            collector_number = "---";
        }
        textView.setText(ColorKt.HEX_PREFIX + collector_number);
        String set_code2 = card.getSet_code();
        String str = "";
        if (set_code2 == null) {
            set_code2 = "";
        }
        Iterator<T> it = this.cardSets.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((CardSet) next).getCode(), set_code2)) {
                obj = next;
                break;
            }
        }
        CardSet cardSet = (CardSet) obj;
        if (cardSet != null) {
            set_code2 = cardSet.getName();
        }
        this.setLabel.setText(set_code2);
        String str2 = this.currentMTCardId;
        if (str2 != null) {
            if (Intrinsics.areEqual(card.getCardid(), str2)) {
                this.itemView.setBackgroundResource(R.drawable.rounded_corners_print_view_selected);
            } else {
                this.itemView.setBackgroundResource(R.drawable.rounded_corners_print_view);
            }
        }
        Resources resources = this.itemView.getContext().getResources();
        String set_code3 = card.getSet_code();
        if (set_code3 == null) {
            set_code3 = "dci";
        }
        int identifier = resources.getIdentifier("set_" + set_code3, "drawable", this.setImage.getContext().getPackageName());
        if (identifier != 0) {
            this.setImage.setImageResource(identifier);
        }
        this.isFoilImage.setVisibility(8);
        String finish = card.getFinish();
        if (finish != null) {
            String lowerCase2 = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!Intrinsics.areEqual(lowerCase2, "foil")) {
                String lowerCase3 = finish.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase3, "etched")) {
                    this.isFoilImage.setVisibility(0);
                } else {
                    this.isFoilImage.setVisibility(8);
                }
            }
        } else {
            List<String> finishes = card.getFinishes();
            if (finishes != null && finishes.size() == 1 && (finishes.contains("foil") || finishes.contains("etched"))) {
                this.isFoilImage.setVisibility(0);
            }
        }
        this.priceLabel.setVisibility(8);
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        String preferredCurrency = preferencesManager.getPreferredCurrency();
        double cardPrice = GameUtils.INSTANCE.getInstance().getCardPrice(card, preferencesManager.getPreferredMarket());
        this.priceLabel.setText(GameUtils.INSTANCE.getInstance().formatPrice(cardPrice, preferredCurrency));
        this.priceLabel.setVisibility(0);
        if (cardPrice == AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.priceLabel.setText("---");
            this.priceLabel.setVisibility(0);
        }
        List<MTImageURIs> images = card.getImages();
        if (images == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null) {
            List<MTImageURIs> en_images = card.getEn_images();
            if (en_images != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) != null) {
                String png = mTImageURIs.getPng();
                if (png == null) {
                    gatherer = mTImageURIs.getGatherer();
                    if (gatherer != null) {
                        str = gatherer;
                    }
                } else {
                    str = png;
                }
            }
        } else {
            gatherer = mTImageURIs2.getPng();
            if (gatherer != null || (gatherer = mTImageURIs2.getGatherer()) != null) {
            }
        }
        this.imageView.loadImage(str);
    }

    public final void onRecycled() {
        this.imageView.reset();
    }
}
