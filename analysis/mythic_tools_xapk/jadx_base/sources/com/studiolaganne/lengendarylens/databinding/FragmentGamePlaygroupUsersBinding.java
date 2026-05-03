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
public final class FragmentGamePlaygroupUsersBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final LinearLayout bottomLayout;
    public final ImageView defaultProfileImage;
    public final TextView formatName;
    public final ConstraintLayout iconBubbleLayout;
    public final ConstraintLayout nextButtonLayout;
    public final TextView nextButtonText;
    public final ImageView nextIcon;
    public final TextView pendingText;
    public final TextView playersLabel;
    public final RecyclerView playersRecyclerView;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupGameLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final TextView playgroupName;
    public final RecyclerView playgroupUsersRecyclerView;
    public final ConstraintLayout profileIcon;
    public final CachedImageView profileImage;
    public final TextView questionText;
    private final ConstraintLayout rootView;
    public final TextView uncheckLabel;
    public final TextView usersCount;
    public final ImageView usersIcon;

    private FragmentGamePlaygroupUsersBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, RecyclerView recyclerView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TextView textView5, RecyclerView recyclerView2, ConstraintLayout constraintLayout7, CachedImageView cachedImageView, TextView textView6, TextView textView7, TextView textView8, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bottomLayout = linearLayout2;
        this.defaultProfileImage = imageView;
        this.formatName = textView;
        this.iconBubbleLayout = constraintLayout2;
        this.nextButtonLayout = constraintLayout3;
        this.nextButtonText = textView2;
        this.nextIcon = imageView2;
        this.pendingText = textView3;
        this.playersLabel = textView4;
        this.playersRecyclerView = recyclerView;
        this.playgroundInfoLayout = constraintLayout4;
        this.playgroupGameLayout = constraintLayout5;
        this.playgroupInfoInnerLayout = constraintLayout6;
        this.playgroupName = textView5;
        this.playgroupUsersRecyclerView = recyclerView2;
        this.profileIcon = constraintLayout7;
        this.profileImage = cachedImageView;
        this.questionText = textView6;
        this.uncheckLabel = textView7;
        this.usersCount = textView8;
        this.usersIcon = imageView3;
    }

    public static FragmentGamePlaygroupUsersBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bottomLayout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.defaultProfileImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.formatName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.iconBubbleLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.nextButtonLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.nextButtonText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.nextIcon;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.pendingText;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.players_label;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.playersRecyclerView;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    i = R.id.playgroundInfoLayout;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.playgroupGameLayout;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.playgroupInfoInnerLayout;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.playgroupName;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.playgroupUsersRecyclerView;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView2 != null) {
                                                                        i = R.id.profileIcon;
                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout6 != null) {
                                                                            i = R.id.profileImage;
                                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (cachedImageView != null) {
                                                                                i = R.id.question_text;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.uncheck_label;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.usersCount;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.usersIcon;
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView3 != null) {
                                                                                                return new FragmentGamePlaygroupUsersBinding((ConstraintLayout) view, linearLayout, linearLayout2, imageView, textView, constraintLayout, constraintLayout2, textView2, imageView2, textView3, textView4, recyclerView, constraintLayout3, constraintLayout4, constraintLayout5, textView5, recyclerView2, constraintLayout6, cachedImageView, textView6, textView7, textView8, imageView3);
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

    public static FragmentGamePlaygroupUsersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGamePlaygroupUsersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_playgroup_users, viewGroup, false);
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
