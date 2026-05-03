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
import androidx.preference.ListPreference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MarketplaceIconListPreference.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MarketplaceIconListPreference;", "Landroidx/preference/ListPreference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "marketplaceIcons", "", "", "", "onClick", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarketplaceIconListPreference extends ListPreference {
    public static final int $stable = 8;
    private final Map<String, Integer> marketplaceIcons;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketplaceIconListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.marketplaceIcons = MapsKt.mapOf(TuplesKt.to("mythictools", Integer.valueOf(R.drawable.marketplace_mythictools)), TuplesKt.to("tcgplayer", Integer.valueOf(R.drawable.marketplace_tcgplayer)), TuplesKt.to("cardmarket", Integer.valueOf(R.drawable.marketplace_cardmarket)), TuplesKt.to("cardkingdom", Integer.valueOf(R.drawable.marketplace_cardkingdom)), TuplesKt.to("cardsphere", Integer.valueOf(R.drawable.marketplace_cardsphere)));
    }

    static final void onClick$lambda$0(CharSequence[] charSequenceArr, MarketplaceIconListPreference marketplaceIconListPreference, DialogInterface dialogInterface, int i) {
        String string = charSequenceArr[i].toString();
        if (marketplaceIconListPreference.callChangeListener(string)) {
            marketplaceIconListPreference.setValue(string);
        }
        dialogInterface.dismiss();
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void onClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getTitle());
        final CharSequence[] entries = getEntries();
        final CharSequence[] entryValues = getEntryValues();
        String value = getValue();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if (value != null) {
            int length = entryValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (Intrinsics.areEqual(entryValues[i], value)) {
                    intRef.element = i;
                    break;
                }
                i++;
            }
        }
        final Context context = getContext();
        builder.setSingleChoiceItems(new ArrayAdapter<CharSequence>(entries, entryValues, this, intRef, context) { // from class: com.studiolaganne.lengendarylens.MarketplaceIconListPreference$onClick$adapter$1
            final /* synthetic */ Ref.IntRef $checkedItem;
            final /* synthetic */ CharSequence[] $entries;
            final /* synthetic */ CharSequence[] $entryValues;
            final /* synthetic */ MarketplaceIconListPreference this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context, android.R.layout.select_dialog_singlechoice, entries);
                this.$entries = entries;
                this.$entryValues = entryValues;
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
                Integer num = (Integer) this.this$0.marketplaceIcons.get(this.$entryValues[position].toString());
                if (num != null) {
                    imageView.setImageResource(num.intValue());
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
        }, intRef.element, new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MarketplaceIconListPreference$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MarketplaceIconListPreference.onClick$lambda$0(entryValues, this, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }
}
