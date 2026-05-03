package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogDeckValuesBinding implements ViewBinding {
    public final LinearLayout deckValuesCard;
    public final TextView deckValuesDeckRow1;
    public final TextView deckValuesDeckRow2;
    public final TextView deckValuesDeckRow3;
    public final TextView deckValuesDeckRow4;
    public final TextView deckValuesDeckRow5;
    public final View deckValuesDivider0;
    public final View deckValuesDivider1;
    public final View deckValuesDivider2;
    public final TextView deckValuesHeaderDeck;
    public final TextView deckValuesHeaderSideboard;
    public final TextView deckValuesHeaderTotal;
    public final TextView deckValuesIconRow1;
    public final TextView deckValuesIconRow2;
    public final TextView deckValuesIconRow3;
    public final TextView deckValuesIconRow4;
    public final TextView deckValuesIconRow5;
    public final TextView deckValuesLabelRow1;
    public final TextView deckValuesLabelRow2;
    public final TextView deckValuesLabelRow3;
    public final TextView deckValuesLabelRow4;
    public final TextView deckValuesLabelRow5;
    public final View deckValuesOverlay;
    public final TextView deckValuesSideboardRow1;
    public final TextView deckValuesSideboardRow2;
    public final TextView deckValuesSideboardRow3;
    public final TextView deckValuesSideboardRow4;
    public final TextView deckValuesSideboardRow5;
    public final TextView deckValuesTotalRow1;
    public final TextView deckValuesTotalRow2;
    public final TextView deckValuesTotalRow3;
    public final TextView deckValuesTotalRow4;
    public final TextView deckValuesTotalRow5;
    public final ConstraintLayout deckValuesUpdateButton;
    public final TextView recalcTextView;
    private final FrameLayout rootView;
    public final TextView updateButtonText;

    private DialogDeckValuesBinding(FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, View view3, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, View view4, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, ConstraintLayout constraintLayout, TextView textView29, TextView textView30) {
        this.rootView = frameLayout;
        this.deckValuesCard = linearLayout;
        this.deckValuesDeckRow1 = textView;
        this.deckValuesDeckRow2 = textView2;
        this.deckValuesDeckRow3 = textView3;
        this.deckValuesDeckRow4 = textView4;
        this.deckValuesDeckRow5 = textView5;
        this.deckValuesDivider0 = view;
        this.deckValuesDivider1 = view2;
        this.deckValuesDivider2 = view3;
        this.deckValuesHeaderDeck = textView6;
        this.deckValuesHeaderSideboard = textView7;
        this.deckValuesHeaderTotal = textView8;
        this.deckValuesIconRow1 = textView9;
        this.deckValuesIconRow2 = textView10;
        this.deckValuesIconRow3 = textView11;
        this.deckValuesIconRow4 = textView12;
        this.deckValuesIconRow5 = textView13;
        this.deckValuesLabelRow1 = textView14;
        this.deckValuesLabelRow2 = textView15;
        this.deckValuesLabelRow3 = textView16;
        this.deckValuesLabelRow4 = textView17;
        this.deckValuesLabelRow5 = textView18;
        this.deckValuesOverlay = view4;
        this.deckValuesSideboardRow1 = textView19;
        this.deckValuesSideboardRow2 = textView20;
        this.deckValuesSideboardRow3 = textView21;
        this.deckValuesSideboardRow4 = textView22;
        this.deckValuesSideboardRow5 = textView23;
        this.deckValuesTotalRow1 = textView24;
        this.deckValuesTotalRow2 = textView25;
        this.deckValuesTotalRow3 = textView26;
        this.deckValuesTotalRow4 = textView27;
        this.deckValuesTotalRow5 = textView28;
        this.deckValuesUpdateButton = constraintLayout;
        this.recalcTextView = textView29;
        this.updateButtonText = textView30;
    }

    public static DialogDeckValuesBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        int i = R.id.deck_values_card;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.deck_values_deck_row1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.deck_values_deck_row2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.deck_values_deck_row3;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.deck_values_deck_row4;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.deck_values_deck_row5;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.deck_values_divider0))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.deck_values_divider1))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.deck_values_divider2))) != null) {
                                i = R.id.deck_values_header_deck;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.deck_values_header_sideboard;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.deck_values_header_total;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = R.id.deck_values_icon_row1;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = R.id.deck_values_icon_row2;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = R.id.deck_values_icon_row3;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        i = R.id.deck_values_icon_row4;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView12 != null) {
                                                            i = R.id.deck_values_icon_row5;
                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView13 != null) {
                                                                i = R.id.deck_values_label_row1;
                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView14 != null) {
                                                                    i = R.id.deck_values_label_row2;
                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView15 != null) {
                                                                        i = R.id.deck_values_label_row3;
                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView16 != null) {
                                                                            i = R.id.deck_values_label_row4;
                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView17 != null) {
                                                                                i = R.id.deck_values_label_row5;
                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView18 != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.deck_values_overlay))) != null) {
                                                                                    i = R.id.deck_values_sideboard_row1;
                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView19 != null) {
                                                                                        i = R.id.deck_values_sideboard_row2;
                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView20 != null) {
                                                                                            i = R.id.deck_values_sideboard_row3;
                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView21 != null) {
                                                                                                i = R.id.deck_values_sideboard_row4;
                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView22 != null) {
                                                                                                    i = R.id.deck_values_sideboard_row5;
                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView23 != null) {
                                                                                                        i = R.id.deck_values_total_row1;
                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView24 != null) {
                                                                                                            i = R.id.deck_values_total_row2;
                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView25 != null) {
                                                                                                                i = R.id.deck_values_total_row3;
                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView26 != null) {
                                                                                                                    i = R.id.deck_values_total_row4;
                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView27 != null) {
                                                                                                                        i = R.id.deck_values_total_row5;
                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView28 != null) {
                                                                                                                            i = R.id.deck_values_update_button;
                                                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (constraintLayout != null) {
                                                                                                                                i = R.id.recalcTextView;
                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView29 != null) {
                                                                                                                                    i = R.id.updateButtonText;
                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView30 != null) {
                                                                                                                                        return new DialogDeckValuesBinding((FrameLayout) view, linearLayout, textView, textView2, textView3, textView4, textView5, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, viewFindChildViewById4, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, constraintLayout, textView29, textView30);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogDeckValuesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDeckValuesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_deck_values, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
