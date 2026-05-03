package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogSharedStatsBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final LinearLayout sharedStatsCard;
    public final TextView sharedStatsDialogClose;
    public final TextView sharedStatsDialogDraws;
    public final TextView sharedStatsDialogHeader;
    public final TextView sharedStatsDialogLosses;
    public final TextView sharedStatsDialogNumGames;
    public final TextView sharedStatsDialogPlayerCount;
    public final TextView sharedStatsDialogTitle;
    public final TextView sharedStatsDialogWinrate;
    public final TextView sharedStatsDialogWins;
    public final View sharedStatsOverlay;
    public final RecyclerView sharedStatsPlayerList;

    private DialogSharedStatsBinding(FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.sharedStatsCard = linearLayout;
        this.sharedStatsDialogClose = textView;
        this.sharedStatsDialogDraws = textView2;
        this.sharedStatsDialogHeader = textView3;
        this.sharedStatsDialogLosses = textView4;
        this.sharedStatsDialogNumGames = textView5;
        this.sharedStatsDialogPlayerCount = textView6;
        this.sharedStatsDialogTitle = textView7;
        this.sharedStatsDialogWinrate = textView8;
        this.sharedStatsDialogWins = textView9;
        this.sharedStatsOverlay = view;
        this.sharedStatsPlayerList = recyclerView;
    }

    public static DialogSharedStatsBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.shared_stats_card;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.sharedStatsDialogClose;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.sharedStatsDialogDraws;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.sharedStatsDialogHeader;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.sharedStatsDialogLosses;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.sharedStatsDialogNumGames;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.sharedStatsDialogPlayerCount;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.sharedStatsDialogTitle;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.sharedStatsDialogWinrate;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = R.id.sharedStatsDialogWins;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.shared_stats_overlay))) != null) {
                                                i = R.id.sharedStatsPlayerList;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    return new DialogSharedStatsBinding((FrameLayout) view, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, viewFindChildViewById, recyclerView);
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

    public static DialogSharedStatsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSharedStatsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_shared_stats, viewGroup, false);
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
