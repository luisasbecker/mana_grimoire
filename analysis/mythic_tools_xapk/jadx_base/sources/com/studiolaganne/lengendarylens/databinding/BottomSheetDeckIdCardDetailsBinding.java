package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetDeckIdCardDetailsBinding implements ViewBinding {
    public final ImageView chevronDown;
    public final FrameLayout detailFragmentContainer;
    private final LinearLayout rootView;
    public final DeckIdCardArcGaugeView sheetGaugeGlobal;
    public final DeckIdCardArcGaugeView sheetGaugeHealth;
    public final DeckIdCardArcGaugeView sheetGaugeMana;
    public final DeckIdCardArcGaugeView sheetGaugePower;
    public final LinearLayout sheetGaugeRow;
    public final TextView tapHelp;

    private BottomSheetDeckIdCardDetailsBinding(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, DeckIdCardArcGaugeView deckIdCardArcGaugeView, DeckIdCardArcGaugeView deckIdCardArcGaugeView2, DeckIdCardArcGaugeView deckIdCardArcGaugeView3, DeckIdCardArcGaugeView deckIdCardArcGaugeView4, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.chevronDown = imageView;
        this.detailFragmentContainer = frameLayout;
        this.sheetGaugeGlobal = deckIdCardArcGaugeView;
        this.sheetGaugeHealth = deckIdCardArcGaugeView2;
        this.sheetGaugeMana = deckIdCardArcGaugeView3;
        this.sheetGaugePower = deckIdCardArcGaugeView4;
        this.sheetGaugeRow = linearLayout2;
        this.tapHelp = textView;
    }

    public static BottomSheetDeckIdCardDetailsBinding bind(View view) {
        int i = R.id.chevron_down;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.detailFragmentContainer;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.sheetGaugeGlobal;
                DeckIdCardArcGaugeView deckIdCardArcGaugeView = (DeckIdCardArcGaugeView) ViewBindings.findChildViewById(view, i);
                if (deckIdCardArcGaugeView != null) {
                    i = R.id.sheetGaugeHealth;
                    DeckIdCardArcGaugeView deckIdCardArcGaugeView2 = (DeckIdCardArcGaugeView) ViewBindings.findChildViewById(view, i);
                    if (deckIdCardArcGaugeView2 != null) {
                        i = R.id.sheetGaugeMana;
                        DeckIdCardArcGaugeView deckIdCardArcGaugeView3 = (DeckIdCardArcGaugeView) ViewBindings.findChildViewById(view, i);
                        if (deckIdCardArcGaugeView3 != null) {
                            i = R.id.sheetGaugePower;
                            DeckIdCardArcGaugeView deckIdCardArcGaugeView4 = (DeckIdCardArcGaugeView) ViewBindings.findChildViewById(view, i);
                            if (deckIdCardArcGaugeView4 != null) {
                                i = R.id.sheetGaugeRow;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.tapHelp;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        return new BottomSheetDeckIdCardDetailsBinding((LinearLayout) view, imageView, frameLayout, deckIdCardArcGaugeView, deckIdCardArcGaugeView2, deckIdCardArcGaugeView3, deckIdCardArcGaugeView4, linearLayout, textView);
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

    public static BottomSheetDeckIdCardDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetDeckIdCardDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_deck_id_card_details, viewGroup, false);
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
