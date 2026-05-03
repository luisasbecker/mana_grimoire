package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetCircleBinding implements ViewBinding {
    public final LinearLayoutCompat buttonsLayout;
    public final ImageView chevronDown;
    public final TextView connectingTextView;
    public final ConstraintLayout createButtonLayout;
    public final TextView createButtonText;
    public final TextView emptyStateText;
    public final LottieAnimationView loadingAnimationView;
    public final TextView membersLabel;
    public final RecyclerView membersRecyclerView;
    public final ConstraintLayout overlay;
    public final EditText playgroupDescription;
    public final EditText playgroupName;
    private final ConstraintLayout rootView;
    public final EditText searchEditText;
    public final TextView sheetTitle;
    public final TextView tabFriends;
    public final TextView tabPlaygroups;
    public final LinearLayoutCompat textLayout;
    public final LinearLayoutCompat titleLayout;

    private BottomSheetCircleBinding(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, LottieAnimationView lottieAnimationView, TextView textView4, RecyclerView recyclerView, ConstraintLayout constraintLayout3, EditText editText, EditText editText2, EditText editText3, TextView textView5, TextView textView6, TextView textView7, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3) {
        this.rootView = constraintLayout;
        this.buttonsLayout = linearLayoutCompat;
        this.chevronDown = imageView;
        this.connectingTextView = textView;
        this.createButtonLayout = constraintLayout2;
        this.createButtonText = textView2;
        this.emptyStateText = textView3;
        this.loadingAnimationView = lottieAnimationView;
        this.membersLabel = textView4;
        this.membersRecyclerView = recyclerView;
        this.overlay = constraintLayout3;
        this.playgroupDescription = editText;
        this.playgroupName = editText2;
        this.searchEditText = editText3;
        this.sheetTitle = textView5;
        this.tabFriends = textView6;
        this.tabPlaygroups = textView7;
        this.textLayout = linearLayoutCompat2;
        this.titleLayout = linearLayoutCompat3;
    }

    public static BottomSheetCircleBinding bind(View view) {
        int i = R.id.buttonsLayout;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
        if (linearLayoutCompat != null) {
            i = R.id.chevron_down;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.connectingTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.createButtonLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.createButtonText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.emptyStateText;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.loadingAnimationView;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                if (lottieAnimationView != null) {
                                    i = R.id.membersLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.membersRecyclerView;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R.id.overlay;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout2 != null) {
                                                i = R.id.playgroupDescription;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                if (editText != null) {
                                                    i = R.id.playgroupName;
                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText2 != null) {
                                                        i = R.id.searchEditText;
                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                        if (editText3 != null) {
                                                            i = R.id.sheetTitle;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.tabFriends;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.tabPlaygroups;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.textLayout;
                                                                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayoutCompat2 != null) {
                                                                            i = R.id.titleLayout;
                                                                            LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayoutCompat3 != null) {
                                                                                return new BottomSheetCircleBinding((ConstraintLayout) view, linearLayoutCompat, imageView, textView, constraintLayout, textView2, textView3, lottieAnimationView, textView4, recyclerView, constraintLayout2, editText, editText2, editText3, textView5, textView6, textView7, linearLayoutCompat2, linearLayoutCompat3);
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

    public static BottomSheetCircleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetCircleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_circle, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
