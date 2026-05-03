package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetInviteToPlaygroupBinding implements ViewBinding {
    public final ImageView chevronDown;
    public final TextView connectingTextView;
    public final RecyclerView friendsRecyclerView;
    public final LottieAnimationView loadingAnimationView;
    public final TextView noFriendsTextView;
    public final ConstraintLayout overlay;
    private final ConstraintLayout rootView;

    private BottomSheetInviteToPlaygroupBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.chevronDown = imageView;
        this.connectingTextView = textView;
        this.friendsRecyclerView = recyclerView;
        this.loadingAnimationView = lottieAnimationView;
        this.noFriendsTextView = textView2;
        this.overlay = constraintLayout2;
    }

    public static BottomSheetInviteToPlaygroupBinding bind(View view) {
        int i = R.id.chevron_down;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.connectingTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.friendsRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.loadingAnimationView;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                    if (lottieAnimationView != null) {
                        i = R.id.noFriendsTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.overlay;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                return new BottomSheetInviteToPlaygroupBinding((ConstraintLayout) view, imageView, textView, recyclerView, lottieAnimationView, textView2, constraintLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BottomSheetInviteToPlaygroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetInviteToPlaygroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_invite_to_playgroup, viewGroup, false);
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
