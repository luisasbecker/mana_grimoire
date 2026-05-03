package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentBrowseListBinding implements ViewBinding {
    public final ConstraintLayout addButtonLayout;
    public final TextView addFilterButton;
    public final LinearLayout addFilterLayout;
    public final TextView addFilterTextView;
    public final LinearLayout advancedSearchLayout;
    public final ImageView backImage;
    public final RecyclerView cardsRecyclerView;
    public final TextView clearTextView;
    public final ImageView collapseImageView;
    public final TextView connectingTextView;
    public final DeckCardsToolbarBinding deckCardsToolbarLayout;
    public final TextView deleteTextView;
    public final EditText filterEditText;
    public final TextView filterNumberTextView;
    public final ConstraintLayout filterSummaryLayout;
    public final TextView filterSummaryTextView;
    public final ConstraintLayout filtersContainerLayout;
    public final RecyclerView filtersRecyclerView;
    public final ImageView gridImage;
    public final LottieAnimationView loadingAnimationView;
    public final LinearLayout mainLayout;
    public final TextView menuTextView;
    public final TextView moveTextView;
    public final ImageView noPhotoIcon;
    public final TextView numCardsTextView;
    public final ConstraintLayout overlay;
    public final ImageView plusImageView;
    public final PrivacyToolbarBinding privacyToolbarLayout;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout rootLayout;
    private final RelativeLayout rootView;
    public final ConstraintLayout scanButtonLayout;
    public final ImageView scanImageView;
    public final LottieAnimationView scrollAnimationView;
    public final TextView selectAllTextView;
    public final TextView selectionCountTextView;
    public final LinearLayout selectionLayout;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final TextView titleTextView;
    public final View toolbarSeparator;
    public final LinearLayout topLayout;
    public final TextView userFirstName;
    public final LinearLayout userInfoLayout;
    public final LinearLayout userLayout;
    public final TextView userName;

    private FragmentBrowseListBinding(RelativeLayout relativeLayout, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, ImageView imageView, RecyclerView recyclerView, TextView textView3, ImageView imageView2, TextView textView4, DeckCardsToolbarBinding deckCardsToolbarBinding, TextView textView5, EditText editText, TextView textView6, ConstraintLayout constraintLayout2, TextView textView7, ConstraintLayout constraintLayout3, RecyclerView recyclerView2, ImageView imageView3, LottieAnimationView lottieAnimationView, LinearLayout linearLayout3, TextView textView8, TextView textView9, ImageView imageView4, TextView textView10, ConstraintLayout constraintLayout4, ImageView imageView5, PrivacyToolbarBinding privacyToolbarBinding, CachedImageView cachedImageView, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ImageView imageView6, LottieAnimationView lottieAnimationView2, TextView textView11, TextView textView12, LinearLayout linearLayout4, SwipeRefreshLayout swipeRefreshLayout, TextView textView13, View view, LinearLayout linearLayout5, TextView textView14, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView15) {
        this.rootView = relativeLayout;
        this.addButtonLayout = constraintLayout;
        this.addFilterButton = textView;
        this.addFilterLayout = linearLayout;
        this.addFilterTextView = textView2;
        this.advancedSearchLayout = linearLayout2;
        this.backImage = imageView;
        this.cardsRecyclerView = recyclerView;
        this.clearTextView = textView3;
        this.collapseImageView = imageView2;
        this.connectingTextView = textView4;
        this.deckCardsToolbarLayout = deckCardsToolbarBinding;
        this.deleteTextView = textView5;
        this.filterEditText = editText;
        this.filterNumberTextView = textView6;
        this.filterSummaryLayout = constraintLayout2;
        this.filterSummaryTextView = textView7;
        this.filtersContainerLayout = constraintLayout3;
        this.filtersRecyclerView = recyclerView2;
        this.gridImage = imageView3;
        this.loadingAnimationView = lottieAnimationView;
        this.mainLayout = linearLayout3;
        this.menuTextView = textView8;
        this.moveTextView = textView9;
        this.noPhotoIcon = imageView4;
        this.numCardsTextView = textView10;
        this.overlay = constraintLayout4;
        this.plusImageView = imageView5;
        this.privacyToolbarLayout = privacyToolbarBinding;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout5;
        this.rootLayout = constraintLayout6;
        this.scanButtonLayout = constraintLayout7;
        this.scanImageView = imageView6;
        this.scrollAnimationView = lottieAnimationView2;
        this.selectAllTextView = textView11;
        this.selectionCountTextView = textView12;
        this.selectionLayout = linearLayout4;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.titleTextView = textView13;
        this.toolbarSeparator = view;
        this.topLayout = linearLayout5;
        this.userFirstName = textView14;
        this.userInfoLayout = linearLayout6;
        this.userLayout = linearLayout7;
        this.userName = textView15;
    }

    public static FragmentBrowseListBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.addButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.addFilterButton;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.addFilterLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.addFilterTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.advancedSearchLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.backImage;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.cardsRecyclerView;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.clearTextView;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.collapseImageView;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            i = R.id.connectingTextView;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.deckCardsToolbarLayout))) != null) {
                                                DeckCardsToolbarBinding deckCardsToolbarBindingBind = DeckCardsToolbarBinding.bind(viewFindChildViewById);
                                                i = R.id.deleteTextView;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.filterEditText;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText != null) {
                                                        i = R.id.filterNumberTextView;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.filterSummaryLayout;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout2 != null) {
                                                                i = R.id.filterSummaryTextView;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.filtersContainerLayout;
                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout3 != null) {
                                                                        i = R.id.filtersRecyclerView;
                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                        if (recyclerView2 != null) {
                                                                            i = R.id.gridImage;
                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView3 != null) {
                                                                                i = R.id.loadingAnimationView;
                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                if (lottieAnimationView != null) {
                                                                                    i = R.id.mainLayout;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.menuTextView;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.moveTextView;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.no_photo_icon;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.numCardsTextView;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.overlay;
                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout4 != null) {
                                                                                                            i = R.id.plusImageView;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView5 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.privacyToolbarLayout))) != null) {
                                                                                                                PrivacyToolbarBinding privacyToolbarBindingBind = PrivacyToolbarBinding.bind(viewFindChildViewById2);
                                                                                                                i = R.id.profile_icon;
                                                                                                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (cachedImageView != null) {
                                                                                                                    i = R.id.profileLayout;
                                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout5 != null) {
                                                                                                                        i = R.id.rootLayout;
                                                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (constraintLayout6 != null) {
                                                                                                                            i = R.id.scanButtonLayout;
                                                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (constraintLayout7 != null) {
                                                                                                                                i = R.id.scanImageView;
                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (imageView6 != null) {
                                                                                                                                    i = R.id.scrollAnimationView;
                                                                                                                                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (lottieAnimationView2 != null) {
                                                                                                                                        i = R.id.selectAllTextView;
                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView11 != null) {
                                                                                                                                            i = R.id.selectionCountTextView;
                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView12 != null) {
                                                                                                                                                i = R.id.selectionLayout;
                                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                                    i = R.id.swipeRefreshLayout;
                                                                                                                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (swipeRefreshLayout != null) {
                                                                                                                                                        i = R.id.titleTextView;
                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView13 != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.toolbarSeparator))) != null) {
                                                                                                                                                            i = R.id.topLayout;
                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                i = R.id.userFirstName;
                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                    i = R.id.userInfoLayout;
                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                        i = R.id.user_layout;
                                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                                                            i = R.id.userName;
                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                return new FragmentBrowseListBinding((RelativeLayout) view, constraintLayout, textView, linearLayout, textView2, linearLayout2, imageView, recyclerView, textView3, imageView2, textView4, deckCardsToolbarBindingBind, textView5, editText, textView6, constraintLayout2, textView7, constraintLayout3, recyclerView2, imageView3, lottieAnimationView, linearLayout3, textView8, textView9, imageView4, textView10, constraintLayout4, imageView5, privacyToolbarBindingBind, cachedImageView, constraintLayout5, constraintLayout6, constraintLayout7, imageView6, lottieAnimationView2, textView11, textView12, linearLayout4, swipeRefreshLayout, textView13, viewFindChildViewById3, linearLayout5, textView14, linearLayout6, linearLayout7, textView15);
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

    public static FragmentBrowseListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBrowseListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_browse_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
