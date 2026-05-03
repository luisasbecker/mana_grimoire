package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventPairingsBinding implements ViewBinding {
    public final TextView autoStartLabel;
    public final TextView clockLabel;
    public final ConstraintLayout clockLayout;
    public final TextView header;
    public final RecyclerView pairingsRecyclerView;
    public final ImageView playButton;
    public final ImageView playerIcon;
    public final ConstraintLayout playersLayout;
    private final LinearLayout rootView;
    public final ConstraintLayout standingsLayout;
    public final MaterialButton submitButton;
    public final ImageView trophy;

    private FragmentEventPairingsBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, MaterialButton materialButton, ImageView imageView3) {
        this.rootView = linearLayout;
        this.autoStartLabel = textView;
        this.clockLabel = textView2;
        this.clockLayout = constraintLayout;
        this.header = textView3;
        this.pairingsRecyclerView = recyclerView;
        this.playButton = imageView;
        this.playerIcon = imageView2;
        this.playersLayout = constraintLayout2;
        this.standingsLayout = constraintLayout3;
        this.submitButton = materialButton;
        this.trophy = imageView3;
    }

    public static FragmentEventPairingsBinding bind(View view) {
        int i = R.id.auto_start_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.clock_label;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.clock_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.header;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.pairings_recycler_view;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.play_button;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.player_icon);
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.players_layout);
                                i = R.id.standings_layout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.submit_button;
                                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                    if (materialButton != null) {
                                        i = R.id.trophy;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            return new FragmentEventPairingsBinding((LinearLayout) view, textView, textView2, constraintLayout, textView3, recyclerView, imageView, imageView2, constraintLayout2, constraintLayout3, materialButton, imageView3);
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

    public static FragmentEventPairingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventPairingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_event_pairings, viewGroup, false);
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
