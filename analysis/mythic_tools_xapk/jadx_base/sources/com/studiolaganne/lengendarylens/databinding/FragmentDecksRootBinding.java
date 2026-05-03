package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentDecksRootBinding implements ViewBinding {
    public final ConstraintLayout activeFilterLayout;
    public final TextView activeFilterText;
    public final ConstraintLayout addButtonLayout;
    public final LinearLayout archivedDecksLayout;
    public final ImageView arrowIcon;
    public final ImageView arrowIcon2;
    public final ImageView clearFilterButton;
    public final ImageView closeFilterIcon;
    public final TextView connectingTextView;
    public final RecyclerView decksRecyclerView;
    public final EditText filterEditText;
    public final FrameLayout filterEditTextLayout;
    public final ImageView filterIcon;
    public final ConstraintLayout filterLayout;
    public final LinearLayout filterSortLayout;
    public final TextView filterText;
    public final View layoutSpacer2;
    public final LinearLayout leftLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView noDecksText;
    public final ConstraintLayout overlay;
    public final ImageView plusImageView;
    public final LinearLayout rightLayout;
    private final ConstraintLayout rootView;
    public final ImageView sortIcon;
    public final ConstraintLayout sortLayout;
    public final TextView sortText;
    public final TextView sortValueText;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final TextView viewArchivedDecksTextView;

    private FragmentDecksRootBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, RecyclerView recyclerView, EditText editText, FrameLayout frameLayout, ImageView imageView5, ConstraintLayout constraintLayout4, LinearLayout linearLayout2, TextView textView3, View view, LinearLayout linearLayout3, LottieAnimationView lottieAnimationView, TextView textView4, ConstraintLayout constraintLayout5, ImageView imageView6, LinearLayout linearLayout4, ImageView imageView7, ConstraintLayout constraintLayout6, TextView textView5, TextView textView6, SwipeRefreshLayout swipeRefreshLayout, TextView textView7) {
        this.rootView = constraintLayout;
        this.activeFilterLayout = constraintLayout2;
        this.activeFilterText = textView;
        this.addButtonLayout = constraintLayout3;
        this.archivedDecksLayout = linearLayout;
        this.arrowIcon = imageView;
        this.arrowIcon2 = imageView2;
        this.clearFilterButton = imageView3;
        this.closeFilterIcon = imageView4;
        this.connectingTextView = textView2;
        this.decksRecyclerView = recyclerView;
        this.filterEditText = editText;
        this.filterEditTextLayout = frameLayout;
        this.filterIcon = imageView5;
        this.filterLayout = constraintLayout4;
        this.filterSortLayout = linearLayout2;
        this.filterText = textView3;
        this.layoutSpacer2 = view;
        this.leftLayout = linearLayout3;
        this.loadingAnimationView = lottieAnimationView;
        this.noDecksText = textView4;
        this.overlay = constraintLayout5;
        this.plusImageView = imageView6;
        this.rightLayout = linearLayout4;
        this.sortIcon = imageView7;
        this.sortLayout = constraintLayout6;
        this.sortText = textView5;
        this.sortValueText = textView6;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.viewArchivedDecksTextView = textView7;
    }

    public static FragmentDecksRootBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.activeFilterLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.activeFilterText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.addButtonLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.archivedDecksLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.arrowIcon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.arrowIcon2;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
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
                                                    i = R.id.filterEditTextLayout;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                    if (frameLayout != null) {
                                                        i = R.id.filterIcon;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView5 != null) {
                                                            i = R.id.filterLayout;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.filterSortLayout;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.filterText;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.layoutSpacer2))) != null) {
                                                                        i = R.id.leftLayout;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.loadingAnimationView;
                                                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                            if (lottieAnimationView != null) {
                                                                                i = R.id.noDecksText;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.overlay;
                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout4 != null) {
                                                                                        i = R.id.plusImageView;
                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView6 != null) {
                                                                                            i = R.id.rightLayout;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout4 != null) {
                                                                                                i = R.id.sortIcon;
                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView7 != null) {
                                                                                                    i = R.id.sortLayout;
                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout5 != null) {
                                                                                                        i = R.id.sortText;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.sortValueText;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.swipeRefreshLayout;
                                                                                                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (swipeRefreshLayout != null) {
                                                                                                                    i = R.id.viewArchivedDecksTextView;
                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView7 != null) {
                                                                                                                        return new FragmentDecksRootBinding((ConstraintLayout) view, constraintLayout, textView, constraintLayout2, linearLayout, imageView, imageView2, imageView3, imageView4, textView2, recyclerView, editText, frameLayout, imageView5, constraintLayout3, linearLayout2, textView3, viewFindChildViewById, linearLayout3, lottieAnimationView, textView4, constraintLayout4, imageView6, linearLayout4, imageView7, constraintLayout5, textView5, textView6, swipeRefreshLayout, textView7);
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

    public static FragmentDecksRootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDecksRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_decks_root, viewGroup, false);
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
