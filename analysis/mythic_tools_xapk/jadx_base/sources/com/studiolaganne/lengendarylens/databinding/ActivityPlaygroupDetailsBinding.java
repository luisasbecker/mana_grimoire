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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityPlaygroupDetailsBinding implements ViewBinding {
    public final LinearLayout activeFilterLayout;
    public final TextView activeFilterTitle;
    public final LinearLayout activeTagLayout;
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final ImageView circleImage;
    public final ImageView clearFilterImage;
    public final ImageView closeSearchImageView;
    public final TextView connectingTextView;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final ImageView editProfilePictureImage;
    public final ConstraintLayout editProfilePictureLayout;
    public final ImageView filterImage;
    public final ConstraintLayout filterLayout;
    public final ImageView filterSummaryImage;
    public final ConstraintLayout filterSummaryLayout;
    public final TextView filterTitle;
    public final ConstraintLayout infoLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final LinearLayout masterFilterLayout;
    public final ImageView noPhotoIcon;
    public final TextView numFilterTextView;
    public final ConstraintLayout overlay;
    public final ImageView personImage;
    public final ConstraintLayout playerCountLayout;
    public final TextView playersText;
    public final TextView playgroupDescription;
    public final TextView playgroupName;
    public final TextView plusTextView;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ConstraintLayout searchEditLayout;
    public final ImageView searchImage;
    public final EditText searchNotesEditText;
    public final ConstraintLayout searchNotesLayout;
    public final View searchSpacer;
    public final TextView searchTitle;
    public final TabLayout tabs;
    public final ImageView tagImage;
    public final TextView tagName;
    public final ViewPager2 viewPager;

    private ActivityPlaygroupDetailsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, ImageView imageView5, ConstraintLayout constraintLayout3, ImageView imageView6, ConstraintLayout constraintLayout4, ImageView imageView7, ConstraintLayout constraintLayout5, ImageView imageView8, ConstraintLayout constraintLayout6, TextView textView3, ConstraintLayout constraintLayout7, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, LinearLayout linearLayout3, ImageView imageView9, TextView textView4, ConstraintLayout constraintLayout8, ImageView imageView10, ConstraintLayout constraintLayout9, TextView textView5, TextView textView6, TextView textView7, TextView textView8, CachedImageView cachedImageView, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, ConstraintLayout constraintLayout12, ImageView imageView11, EditText editText, ConstraintLayout constraintLayout13, View view, TextView textView9, TabLayout tabLayout, ImageView imageView12, TextView textView10, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.activeFilterLayout = linearLayout;
        this.activeFilterTitle = textView;
        this.activeTagLayout = linearLayout2;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.circleImage = imageView2;
        this.clearFilterImage = imageView3;
        this.closeSearchImageView = imageView4;
        this.connectingTextView = textView2;
        this.dotsImage = imageView5;
        this.dotsLayout = constraintLayout3;
        this.editProfilePictureImage = imageView6;
        this.editProfilePictureLayout = constraintLayout4;
        this.filterImage = imageView7;
        this.filterLayout = constraintLayout5;
        this.filterSummaryImage = imageView8;
        this.filterSummaryLayout = constraintLayout6;
        this.filterTitle = textView3;
        this.infoLayout = constraintLayout7;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.masterFilterLayout = linearLayout3;
        this.noPhotoIcon = imageView9;
        this.numFilterTextView = textView4;
        this.overlay = constraintLayout8;
        this.personImage = imageView10;
        this.playerCountLayout = constraintLayout9;
        this.playersText = textView5;
        this.playgroupDescription = textView6;
        this.playgroupName = textView7;
        this.plusTextView = textView8;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout10;
        this.rootLayout = constraintLayout11;
        this.searchEditLayout = constraintLayout12;
        this.searchImage = imageView11;
        this.searchNotesEditText = editText;
        this.searchNotesLayout = constraintLayout13;
        this.searchSpacer = view;
        this.searchTitle = textView9;
        this.tabs = tabLayout;
        this.tagImage = imageView12;
        this.tagName = textView10;
        this.viewPager = viewPager2;
    }

    public static ActivityPlaygroupDetailsBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.activeFilterLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.activeFilterTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.activeTagLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.backArrow;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.backLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.circleImage;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.clearFilterImage;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.closeSearchImageView;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R.id.connectingTextView;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.dotsImage;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.dotsLayout;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.editProfilePictureImage;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView6 != null) {
                                                        i = R.id.editProfilePictureLayout;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = R.id.filterImage;
                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView7 != null) {
                                                                i = R.id.filterLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.filterSummaryImage;
                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView8 != null) {
                                                                        i = R.id.filterSummaryLayout;
                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout5 != null) {
                                                                            i = R.id.filterTitle;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.infoLayout;
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout6 != null) {
                                                                                    i = R.id.linearLayout;
                                                                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayoutCompat != null) {
                                                                                        i = R.id.loadingAnimationView;
                                                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                        if (lottieAnimationView != null) {
                                                                                            i = R.id.masterFilterLayout;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = R.id.no_photo_icon;
                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView9 != null) {
                                                                                                    i = R.id.numFilterTextView;
                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.overlay;
                                                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout7 != null) {
                                                                                                            i = R.id.personImage;
                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView10 != null) {
                                                                                                                i = R.id.playerCountLayout;
                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (constraintLayout8 != null) {
                                                                                                                    i = R.id.playersText;
                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i = R.id.playgroupDescription;
                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i = R.id.playgroupName;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i = R.id.plusTextView;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.profile_icon;
                                                                                                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (cachedImageView != null) {
                                                                                                                                        i = R.id.profileLayout;
                                                                                                                                        ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout9 != null) {
                                                                                                                                            ConstraintLayout constraintLayout10 = (ConstraintLayout) view;
                                                                                                                                            i = R.id.searchEditLayout;
                                                                                                                                            ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (constraintLayout11 != null) {
                                                                                                                                                i = R.id.searchImage;
                                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (imageView11 != null) {
                                                                                                                                                    i = R.id.searchNotesEditText;
                                                                                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (editText != null) {
                                                                                                                                                        i = R.id.searchNotesLayout;
                                                                                                                                                        ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (constraintLayout12 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.searchSpacer))) != null) {
                                                                                                                                                            i = R.id.searchTitle;
                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                i = R.id.tabs;
                                                                                                                                                                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (tabLayout != null) {
                                                                                                                                                                    i = R.id.tagImage;
                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                        i = R.id.tagName;
                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                            i = R.id.view_pager;
                                                                                                                                                                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (viewPager2 != null) {
                                                                                                                                                                                return new ActivityPlaygroupDetailsBinding(constraintLayout10, linearLayout, textView, linearLayout2, imageView, constraintLayout, imageView2, imageView3, imageView4, textView2, imageView5, constraintLayout2, imageView6, constraintLayout3, imageView7, constraintLayout4, imageView8, constraintLayout5, textView3, constraintLayout6, linearLayoutCompat, lottieAnimationView, linearLayout3, imageView9, textView4, constraintLayout7, imageView10, constraintLayout8, textView5, textView6, textView7, textView8, cachedImageView, constraintLayout9, constraintLayout10, constraintLayout11, imageView11, editText, constraintLayout12, viewFindChildViewById, textView9, tabLayout, imageView12, textView10, viewPager2);
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

    public static ActivityPlaygroupDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPlaygroupDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_playgroup_details, viewGroup, false);
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
