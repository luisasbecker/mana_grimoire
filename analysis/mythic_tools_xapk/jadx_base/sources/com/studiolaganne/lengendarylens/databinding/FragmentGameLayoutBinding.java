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
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGameLayoutBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final LinearLayout bottomLayout;
    public final TextView cameraMode;
    public final ImageView defaultProfileImage;
    public final TextView formatName;
    public final ConstraintLayout iconBubbleLayout;
    public final ImageView imageView1;
    public final ImageView imageView2;
    public final ImageView imageView3;
    public final TextView pendingText;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupGameLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final TextView playgroupName;
    public final ConstraintLayout profileIcon;
    public final CachedImageView profileImage;
    public final TextView questionText;
    private final ConstraintLayout rootView;
    public final TextView usersCount;
    public final ImageView usersIcon;
    public final RecyclerView usersRecyclerView;

    private FragmentGameLayoutBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView4, ConstraintLayout constraintLayout6, CachedImageView cachedImageView, TextView textView5, TextView textView6, ImageView imageView5, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bottomLayout = linearLayout2;
        this.cameraMode = textView;
        this.defaultProfileImage = imageView;
        this.formatName = textView2;
        this.iconBubbleLayout = constraintLayout2;
        this.imageView1 = imageView2;
        this.imageView2 = imageView3;
        this.imageView3 = imageView4;
        this.pendingText = textView3;
        this.playgroundInfoLayout = constraintLayout3;
        this.playgroupGameLayout = constraintLayout4;
        this.playgroupInfoInnerLayout = constraintLayout5;
        this.playgroupName = textView4;
        this.profileIcon = constraintLayout6;
        this.profileImage = cachedImageView;
        this.questionText = textView5;
        this.usersCount = textView6;
        this.usersIcon = imageView5;
        this.usersRecyclerView = recyclerView;
    }

    public static FragmentGameLayoutBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bottomLayout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.cameraMode;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.defaultProfileImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.formatName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.iconBubbleLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.image_view_1;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.image_view_2;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.image_view_3;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = R.id.pendingText;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.playgroundInfoLayout;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.playgroupGameLayout;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.playgroupInfoInnerLayout;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.playgroupName;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.profileIcon;
                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout5 != null) {
                                                                    i = R.id.profileImage;
                                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (cachedImageView != null) {
                                                                        i = R.id.question_text;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.usersCount;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.usersIcon;
                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView5 != null) {
                                                                                    i = R.id.usersRecyclerView;
                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                    if (recyclerView != null) {
                                                                                        return new FragmentGameLayoutBinding((ConstraintLayout) view, linearLayout, linearLayout2, textView, imageView, textView2, constraintLayout, imageView2, imageView3, imageView4, textView3, constraintLayout2, constraintLayout3, constraintLayout4, textView4, constraintLayout5, cachedImageView, textView5, textView6, imageView5, recyclerView);
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

    public static FragmentGameLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGameLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_layout, viewGroup, false);
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
