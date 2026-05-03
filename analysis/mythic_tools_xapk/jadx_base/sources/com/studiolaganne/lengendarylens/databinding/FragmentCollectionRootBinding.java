package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class FragmentCollectionRootBinding implements ViewBinding {
    public final ConstraintLayout addButtonLayout;
    public final LinearLayout allCollectionLayout;
    public final ImageView arrowIcon2;
    public final TextView browseCollectionTextView;
    public final TextView cardsFooter;
    public final TextView cardsHeader;
    public final TextView cardsValue;
    public final RecyclerView collectionRecyclerView;
    public final TextView connectingTextView;
    public final TextView deltaValue;
    public final TextView helpTextView;
    public final ConstraintLayout importButtonLayout;
    public final View layoutSpacer2;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout overlay;
    public final ImageView plusImageView;
    public final TextView priceHeader;
    public final TextView priceValue;
    private final ConstraintLayout rootView;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final LinearLayout topLayout;

    private FragmentCollectionRootBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout3, View view, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout4, ImageView imageView2, TextView textView8, TextView textView9, SwipeRefreshLayout swipeRefreshLayout, LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.addButtonLayout = constraintLayout2;
        this.allCollectionLayout = linearLayout;
        this.arrowIcon2 = imageView;
        this.browseCollectionTextView = textView;
        this.cardsFooter = textView2;
        this.cardsHeader = textView3;
        this.cardsValue = textView4;
        this.collectionRecyclerView = recyclerView;
        this.connectingTextView = textView5;
        this.deltaValue = textView6;
        this.helpTextView = textView7;
        this.importButtonLayout = constraintLayout3;
        this.layoutSpacer2 = view;
        this.loadingAnimationView = lottieAnimationView;
        this.overlay = constraintLayout4;
        this.plusImageView = imageView2;
        this.priceHeader = textView8;
        this.priceValue = textView9;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.topLayout = linearLayout2;
    }

    public static FragmentCollectionRootBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.addButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.allCollectionLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.arrowIcon2;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.browseCollectionTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.cardsFooter;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.cardsHeader;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.cardsValue;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.collectionRecyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.connectingTextView;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.deltaValue;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.helpTextView;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.importButtonLayout;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.layoutSpacer2))) != null) {
                                                        i = R.id.loadingAnimationView;
                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                        if (lottieAnimationView != null) {
                                                            i = R.id.overlay;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.plusImageView;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView2 != null) {
                                                                    i = R.id.priceHeader;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.priceValue;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.swipeRefreshLayout;
                                                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (swipeRefreshLayout != null) {
                                                                                i = R.id.topLayout;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout2 != null) {
                                                                                    return new FragmentCollectionRootBinding((ConstraintLayout) view, constraintLayout, linearLayout, imageView, textView, textView2, textView3, textView4, recyclerView, textView5, textView6, textView7, constraintLayout2, viewFindChildViewById, lottieAnimationView, constraintLayout3, imageView2, textView8, textView9, swipeRefreshLayout, linearLayout2);
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

    public static FragmentCollectionRootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCollectionRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_collection_root, viewGroup, false);
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
