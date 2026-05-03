package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventPlayersBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final TextView eventTypeTextView;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final TextView matchTypeTextView;
    public final MaterialButton nextButton;
    public final TextView pairingTypeTextView;
    public final TextView playersHeader;
    public final RecyclerView playersRecyclerView;
    private final View rootView;
    public final Guideline topGuideline;

    private FragmentEventPlayersBinding(View view, Guideline guideline, TextView textView, Guideline guideline2, Guideline guideline3, TextView textView2, MaterialButton materialButton, TextView textView3, TextView textView4, RecyclerView recyclerView, Guideline guideline4) {
        this.rootView = view;
        this.bottomGuideline = guideline;
        this.eventTypeTextView = textView;
        this.guidelineEnd = guideline2;
        this.guidelineStart = guideline3;
        this.matchTypeTextView = textView2;
        this.nextButton = materialButton;
        this.pairingTypeTextView = textView3;
        this.playersHeader = textView4;
        this.playersRecyclerView = recyclerView;
        this.topGuideline = guideline4;
    }

    public static FragmentEventPlayersBinding bind(View view) {
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.bottom_guideline);
        int i = R.id.event_type_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_end);
            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_start);
            i = R.id.match_type_text_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.next_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.pairing_type_text_view;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.players_header;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.players_recycler_view;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                return new FragmentEventPlayersBinding(view, guideline, textView, guideline2, guideline3, textView2, materialButton, textView3, textView4, recyclerView, (Guideline) ViewBindings.findChildViewById(view, R.id.top_guideline));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentEventPlayersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventPlayersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_event_players, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
