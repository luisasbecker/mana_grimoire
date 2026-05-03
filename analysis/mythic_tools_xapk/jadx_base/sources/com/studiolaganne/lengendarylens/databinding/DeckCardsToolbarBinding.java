package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CollectionStatusView;
import com.studiolaganne.lengendarylens.MarketplaceSelectorView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckCardsToolbarBinding implements ViewBinding {
    public final LinearLayout deckCardsToolbarLayout;
    public final TextView displayModeToggle;
    public final TextView filterIcon;
    public final TextView groupByButton;
    private final LinearLayout rootView;
    public final TextView sortByButton;
    public final CollectionStatusView toolbarCollectionStatusView;
    public final LinearLayout toolbarMarketplaceSelectorContainer;
    public final MarketplaceSelectorView toolbarMarketplaceSelectorView;
    public final TextView toolbarPricesLabel;
    public final TextView toolbarSettingsIcon;

    private DeckCardsToolbarBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, CollectionStatusView collectionStatusView, LinearLayout linearLayout3, MarketplaceSelectorView marketplaceSelectorView, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.deckCardsToolbarLayout = linearLayout2;
        this.displayModeToggle = textView;
        this.filterIcon = textView2;
        this.groupByButton = textView3;
        this.sortByButton = textView4;
        this.toolbarCollectionStatusView = collectionStatusView;
        this.toolbarMarketplaceSelectorContainer = linearLayout3;
        this.toolbarMarketplaceSelectorView = marketplaceSelectorView;
        this.toolbarPricesLabel = textView5;
        this.toolbarSettingsIcon = textView6;
    }

    public static DeckCardsToolbarBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.displayModeToggle;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.filterIcon;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.groupByButton;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.sortByButton;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.toolbarCollectionStatusView;
                        CollectionStatusView collectionStatusView = (CollectionStatusView) ViewBindings.findChildViewById(view, i);
                        if (collectionStatusView != null) {
                            i = R.id.toolbarMarketplaceSelectorContainer;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.toolbarMarketplaceSelectorView;
                                MarketplaceSelectorView marketplaceSelectorView = (MarketplaceSelectorView) ViewBindings.findChildViewById(view, i);
                                if (marketplaceSelectorView != null) {
                                    i = R.id.toolbarPricesLabel;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.toolbarSettingsIcon;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            return new DeckCardsToolbarBinding(linearLayout, linearLayout, textView, textView2, textView3, textView4, collectionStatusView, linearLayout2, marketplaceSelectorView, textView5, textView6);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckCardsToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckCardsToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_cards_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
