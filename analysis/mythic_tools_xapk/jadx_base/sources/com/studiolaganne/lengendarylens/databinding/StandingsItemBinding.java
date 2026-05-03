package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class StandingsItemBinding implements ViewBinding {
    public final LinearLayout detailsLayout;
    public final TextView gwHeader;
    public final TextView gwValue;
    public final TextView ogwHeader;
    public final TextView ogwValue;
    public final TextView omwHeader;
    public final TextView omwValue;
    public final TextView playerNameLabel;
    public final TextView playerPointsLabel;
    public final TextView positionLabel;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView wldHeader;
    public final TextView wldValue;

    private StandingsItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, LinearLayout linearLayout3, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.detailsLayout = linearLayout2;
        this.gwHeader = textView;
        this.gwValue = textView2;
        this.ogwHeader = textView3;
        this.ogwValue = textView4;
        this.omwHeader = textView5;
        this.omwValue = textView6;
        this.playerNameLabel = textView7;
        this.playerPointsLabel = textView8;
        this.positionLabel = textView9;
        this.rootLayout = linearLayout3;
        this.wldHeader = textView10;
        this.wldValue = textView11;
    }

    public static StandingsItemBinding bind(View view) {
        int i = R.id.details_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.gw_header;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.gw_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.ogw_header;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.ogw_value;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.omw_header;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.omw_value;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.player_name_label;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.player_points_label;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = R.id.position_label;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                LinearLayout linearLayout2 = (LinearLayout) view;
                                                i = R.id.wld_header;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = R.id.wld_value;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        return new StandingsItemBinding(linearLayout2, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, linearLayout2, textView10, textView11);
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

    public static StandingsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StandingsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.standings_item, viewGroup, false);
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
