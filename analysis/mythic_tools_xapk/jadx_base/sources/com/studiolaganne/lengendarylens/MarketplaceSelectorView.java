package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MarketplaceSelectorView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MarketplaceSelectorView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marketplaceIcons", "", "", "marketplaceNames", "marketplaceCodes", "", "onMarketplaceChangedListener", "Lkotlin/Function1;", "", "setOnMarketplaceChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateIcon", "showMarketplaceSelectionDialog", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarketplaceSelectorView extends AppCompatImageView {
    public static final int $stable = 8;
    private final List<String> marketplaceCodes;
    private final Map<String, Integer> marketplaceIcons;
    private final Map<String, Integer> marketplaceNames;
    private Function1<? super String, Unit> onMarketplaceChangedListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarketplaceSelectorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarketplaceSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketplaceSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.marketplaceIcons = MapsKt.mapOf(TuplesKt.to("mythictools", Integer.valueOf(R.drawable.marketplace_mythictools)), TuplesKt.to("tcgplayer", Integer.valueOf(R.drawable.marketplace_tcgplayer)), TuplesKt.to("cardmarket", Integer.valueOf(R.drawable.marketplace_cardmarket)), TuplesKt.to("cardkingdom", Integer.valueOf(R.drawable.marketplace_cardkingdom)), TuplesKt.to("cardsphere", Integer.valueOf(R.drawable.marketplace_cardsphere)));
        this.marketplaceNames = MapsKt.mapOf(TuplesKt.to("mythictools", Integer.valueOf(R.string.marketplace_mythictools)), TuplesKt.to("tcgplayer", Integer.valueOf(R.string.marketplace_tcgplayer)), TuplesKt.to("cardmarket", Integer.valueOf(R.string.marketplace_cardmarket)), TuplesKt.to("cardkingdom", Integer.valueOf(R.string.marketplace_cardkingdom)), TuplesKt.to("cardsphere", Integer.valueOf(R.string.marketplace_cardsphere)));
        this.marketplaceCodes = CollectionsKt.listOf((Object[]) new String[]{"mythictools", "tcgplayer", "cardmarket", "cardkingdom", "cardsphere"});
        setContentDescription(context.getString(R.string.marketplace_icon_description));
        updateIcon();
    }

    public /* synthetic */ MarketplaceSelectorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    static final void showMarketplaceSelectionDialog$lambda$1(MarketplaceSelectorView marketplaceSelectorView, PreferencesManager preferencesManager, DialogInterface dialogInterface, int i) {
        String str = marketplaceSelectorView.marketplaceCodes.get(i);
        preferencesManager.setPreferredMarket(str);
        marketplaceSelectorView.updateIcon();
        Function1<? super String, Unit> function1 = marketplaceSelectorView.onMarketplaceChangedListener;
        if (function1 != null) {
            function1.invoke(str);
        }
        dialogInterface.dismiss();
    }

    public final void setOnMarketplaceChangedListener(Function1<? super String, Unit> listener) {
        this.onMarketplaceChangedListener = listener;
    }

    public final void showMarketplaceSelectionDialog() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(context);
        String preferredMarket = preferencesManager.getPreferredMarket();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.marketplaceCodes.indexOf(preferredMarket);
        if (intRef.element == -1) {
            intRef.element = 0;
        }
        List<String> list = this.marketplaceCodes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Context context2 = getContext();
            Integer num = this.marketplaceNames.get(str);
            arrayList.add(context2.getString(num != null ? num.intValue() : R.string.marketplace_mythictools));
        }
        final String[] strArr = (String[]) arrayList.toArray(new String[0]);
        final Context context3 = getContext();
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(strArr, this, intRef, context3) { // from class: com.studiolaganne.lengendarylens.MarketplaceSelectorView$showMarketplaceSelectionDialog$adapter$1
            final /* synthetic */ Ref.IntRef $checkedItem;
            final /* synthetic */ String[] $entries;
            final /* synthetic */ MarketplaceSelectorView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context3, android.R.layout.select_dialog_singlechoice, strArr);
                this.$entries = strArr;
                this.this$0 = this;
                this.$checkedItem = intRef;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.preference_marketplace_item, parent, false);
                }
                ImageView imageView = (ImageView) convertView.findViewById(R.id.marketplace_icon);
                TextView textView = (TextView) convertView.findViewById(R.id.marketplace_text);
                View viewFindViewById = convertView.findViewById(android.R.id.text1);
                textView.setText(this.$entries[position]);
                Integer num2 = (Integer) this.this$0.marketplaceIcons.get((String) this.this$0.marketplaceCodes.get(position));
                if (num2 != null) {
                    imageView.setImageResource(num2.intValue());
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                if (viewFindViewById != null) {
                    viewFindViewById.setSelected(position == this.$checkedItem.element);
                }
                Intrinsics.checkNotNull(convertView);
                return convertView;
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.preferred_market);
        builder.setSingleChoiceItems(arrayAdapter, intRef.element, new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MarketplaceSelectorView$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MarketplaceSelectorView.showMarketplaceSelectionDialog$lambda$1(this.f$0, preferencesManager, dialogInterface, i);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public final void updateIcon() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Integer num = this.marketplaceIcons.get(new PreferencesManager(context).getPreferredMarket());
        setImageResource(num != null ? num.intValue() : R.drawable.marketplace_mythictools);
    }
}
