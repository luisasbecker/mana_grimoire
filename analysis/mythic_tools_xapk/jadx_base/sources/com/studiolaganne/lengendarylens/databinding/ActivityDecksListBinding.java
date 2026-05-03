package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDecksListBinding implements ViewBinding {
    public final ConstraintLayout activeFilterLayout;
    public final TextView activeFilterText;
    public final ImageView arrowIcon;
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final ImageView clearFilterButton;
    public final ImageView closeFilterIcon;
    public final TextView connectingTextView;
    public final RecyclerView decksRecyclerView;
    public final EditText filterEditText;
    public final ImageView filterIcon;
    public final ConstraintLayout filterLayout;
    public final LinearLayout filterSortLayout;
    public final TextView filterText;
    public final ConstraintLayout infoLayout;
    public final LinearLayout leftLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView noDecksText;
    public final ConstraintLayout overlay;
    public final ImageView playgroupsImage;
    public final ConstraintLayout plusIcon;
    public final LinearLayout rightLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ImageView sortIcon;
    public final ConstraintLayout sortLayout;
    public final TextView sortText;
    public final TextView sortValueText;
    public final TabLayout tabLayout;
    public final TextView title;

    private ActivityDecksListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, ImageView imageView3, ImageView imageView4, TextView textView2, RecyclerView recyclerView, EditText editText, ImageView imageView5, ConstraintLayout constraintLayout4, LinearLayout linearLayout, TextView textView3, ConstraintLayout constraintLayout5, LinearLayout linearLayout2, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, TextView textView4, ConstraintLayout constraintLayout6, ImageView imageView6, ConstraintLayout constraintLayout7, LinearLayout linearLayout3, ConstraintLayout constraintLayout8, ImageView imageView7, ConstraintLayout constraintLayout9, TextView textView5, TextView textView6, TabLayout tabLayout, TextView textView7) {
        this.rootView = constraintLayout;
        this.activeFilterLayout = constraintLayout2;
        this.activeFilterText = textView;
        this.arrowIcon = imageView;
        this.backArrow = imageView2;
        this.backLayout = constraintLayout3;
        this.clearFilterButton = imageView3;
        this.closeFilterIcon = imageView4;
        this.connectingTextView = textView2;
        this.decksRecyclerView = recyclerView;
        this.filterEditText = editText;
        this.filterIcon = imageView5;
        this.filterLayout = constraintLayout4;
        this.filterSortLayout = linearLayout;
        this.filterText = textView3;
        this.infoLayout = constraintLayout5;
        this.leftLayout = linearLayout2;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.noDecksText = textView4;
        this.overlay = constraintLayout6;
        this.playgroupsImage = imageView6;
        this.plusIcon = constraintLayout7;
        this.rightLayout = linearLayout3;
        this.rootLayout = constraintLayout8;
        this.sortIcon = imageView7;
        this.sortLayout = constraintLayout9;
        this.sortText = textView5;
        this.sortValueText = textView6;
        this.tabLayout = tabLayout;
        this.title = textView7;
    }

    public static ActivityDecksListBinding bind(View view) {
        int i = R.id.activeFilterLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.activeFilterText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.arrowIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.backArrow;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.backLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.clearFilterButton;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.closeFilterIcon;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.connectingTextView;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.decksRecyclerView;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R.id.filterEditText;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText != null) {
                                                i = R.id.filterIcon;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = R.id.filterLayout;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.filterSortLayout;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.filterText;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.infoLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.leftLayout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.linearLayout;
                                                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayoutCompat != null) {
                                                                            i = R.id.loadingAnimationView;
                                                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                            if (lottieAnimationView != null) {
                                                                                i = R.id.noDecksText;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.overlay;
                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout5 != null) {
                                                                                        i = R.id.playgroupsImage;
                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView6 != null) {
                                                                                            i = R.id.plusIcon;
                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (constraintLayout6 != null) {
                                                                                                i = R.id.rightLayout;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout3 != null) {
                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) view;
                                                                                                    i = R.id.sortIcon;
                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView7 != null) {
                                                                                                        i = R.id.sortLayout;
                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout8 != null) {
                                                                                                            i = R.id.sortText;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView5 != null) {
                                                                                                                i = R.id.sortValueText;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.tabLayout;
                                                                                                                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (tabLayout != null) {
                                                                                                                        i = R.id.title;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView7 != null) {
                                                                                                                            return new ActivityDecksListBinding(constraintLayout7, constraintLayout, textView, imageView, imageView2, constraintLayout2, imageView3, imageView4, textView2, recyclerView, editText, imageView5, constraintLayout3, linearLayout, textView3, constraintLayout4, linearLayout2, linearLayoutCompat, lottieAnimationView, textView4, constraintLayout5, imageView6, constraintLayout6, linearLayout3, constraintLayout7, imageView7, constraintLayout8, textView5, textView6, tabLayout, textView7);
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

    public static ActivityDecksListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDecksListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_decks_list, viewGroup, false);
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
