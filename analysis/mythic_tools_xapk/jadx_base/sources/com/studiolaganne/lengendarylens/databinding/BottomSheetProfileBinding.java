package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.MythicProfileBorderView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetProfileBinding implements ViewBinding {
    public final LinearLayout activeFilterLayout;
    public final TextView activeFilterTitle;
    public final LinearLayout activeTagLayout;
    public final ImageView chevronDown;
    public final GridLayout chipGrid;
    public final ImageView circleImage;
    public final ImageView clearFilterImage;
    public final ImageView closeSearchImageView;
    public final TextView connectingTextView;
    public final TextView createPlaygroupButtonText;
    public final ImageView editFirstnameImage;
    public final ImageView editProfilePictureImage;
    public final ConstraintLayout editProfilePictureLayout;
    public final ImageView editUsernameImage;
    public final ImageView filterImage;
    public final ConstraintLayout filterLayout;
    public final ImageView filterSummaryImage;
    public final ConstraintLayout filterSummaryLayout;
    public final TextView filterTitle;
    public final LinearLayout firstNameLayout;
    public final ConstraintLayout friendCodeButtonLayout;
    public final LinearLayout headerLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView logOutTextView;
    public final ImageView logoImage;
    public final LinearLayout masterFilterLayout;
    public final ImageView noPhotoIcon;
    public final TextView numFilterTextView;
    public final ConstraintLayout overlay;
    public final TextView playerEmail;
    public final TextView playerFirstName;
    public final TextView playerUsername;
    public final ImageView plusIcon;
    public final TextView plusTextView;
    public final PrivacyToolbarBinding privacyToolbarLayout;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final MythicProfileBorderView profileMythicBorder;
    public final FrameLayout profilePictureContainer;
    public final ConstraintLayout promoCodeButtonLayout;
    public final TextView promoCodeButtonText;
    public final CachedImageView qrCodeImage;
    public final FrameLayout qrFrameLayout;
    private final ConstraintLayout rootView;
    public final ConstraintLayout searchEditLayout;
    public final ImageView searchImage;
    public final EditText searchNotesEditText;
    public final ConstraintLayout searchNotesLayout;
    public final View searchSpacer;
    public final TextView searchTitle;
    public final View separator2;
    public final ImageView tagImage;
    public final TextView tagName;
    public final LinearLayoutCompat textLayout;
    public final LinearLayout userNameLayout;
    public final ViewPager2 viewPager;

    private BottomSheetProfileBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ImageView imageView, GridLayout gridLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, TextView textView3, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout2, ImageView imageView7, ImageView imageView8, ConstraintLayout constraintLayout3, ImageView imageView9, ConstraintLayout constraintLayout4, TextView textView4, LinearLayout linearLayout3, ConstraintLayout constraintLayout5, LinearLayout linearLayout4, LottieAnimationView lottieAnimationView, TextView textView5, ImageView imageView10, LinearLayout linearLayout5, ImageView imageView11, TextView textView6, ConstraintLayout constraintLayout6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView12, TextView textView10, PrivacyToolbarBinding privacyToolbarBinding, CachedImageView cachedImageView, ConstraintLayout constraintLayout7, MythicProfileBorderView mythicProfileBorderView, FrameLayout frameLayout, ConstraintLayout constraintLayout8, TextView textView11, CachedImageView cachedImageView2, FrameLayout frameLayout2, ConstraintLayout constraintLayout9, ImageView imageView13, EditText editText, ConstraintLayout constraintLayout10, View view, TextView textView12, View view2, ImageView imageView14, TextView textView13, LinearLayoutCompat linearLayoutCompat, LinearLayout linearLayout6, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.activeFilterLayout = linearLayout;
        this.activeFilterTitle = textView;
        this.activeTagLayout = linearLayout2;
        this.chevronDown = imageView;
        this.chipGrid = gridLayout;
        this.circleImage = imageView2;
        this.clearFilterImage = imageView3;
        this.closeSearchImageView = imageView4;
        this.connectingTextView = textView2;
        this.createPlaygroupButtonText = textView3;
        this.editFirstnameImage = imageView5;
        this.editProfilePictureImage = imageView6;
        this.editProfilePictureLayout = constraintLayout2;
        this.editUsernameImage = imageView7;
        this.filterImage = imageView8;
        this.filterLayout = constraintLayout3;
        this.filterSummaryImage = imageView9;
        this.filterSummaryLayout = constraintLayout4;
        this.filterTitle = textView4;
        this.firstNameLayout = linearLayout3;
        this.friendCodeButtonLayout = constraintLayout5;
        this.headerLayout = linearLayout4;
        this.loadingAnimationView = lottieAnimationView;
        this.logOutTextView = textView5;
        this.logoImage = imageView10;
        this.masterFilterLayout = linearLayout5;
        this.noPhotoIcon = imageView11;
        this.numFilterTextView = textView6;
        this.overlay = constraintLayout6;
        this.playerEmail = textView7;
        this.playerFirstName = textView8;
        this.playerUsername = textView9;
        this.plusIcon = imageView12;
        this.plusTextView = textView10;
        this.privacyToolbarLayout = privacyToolbarBinding;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout7;
        this.profileMythicBorder = mythicProfileBorderView;
        this.profilePictureContainer = frameLayout;
        this.promoCodeButtonLayout = constraintLayout8;
        this.promoCodeButtonText = textView11;
        this.qrCodeImage = cachedImageView2;
        this.qrFrameLayout = frameLayout2;
        this.searchEditLayout = constraintLayout9;
        this.searchImage = imageView13;
        this.searchNotesEditText = editText;
        this.searchNotesLayout = constraintLayout10;
        this.searchSpacer = view;
        this.searchTitle = textView12;
        this.separator2 = view2;
        this.tagImage = imageView14;
        this.tagName = textView13;
        this.textLayout = linearLayoutCompat;
        this.userNameLayout = linearLayout6;
        this.viewPager = viewPager2;
    }

    public static BottomSheetProfileBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.activeFilterLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.activeFilterTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.activeTagLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.chevron_down;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.chipGrid;
                        GridLayout gridLayout = (GridLayout) ViewBindings.findChildViewById(view, i);
                        if (gridLayout != null) {
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
                                            i = R.id.createPlaygroupButtonText;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.editFirstnameImage;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = R.id.editProfilePictureImage;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView6 != null) {
                                                        i = R.id.editProfilePictureLayout;
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout != null) {
                                                            i = R.id.editUsernameImage;
                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView7 != null) {
                                                                i = R.id.filterImage;
                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView8 != null) {
                                                                    i = R.id.filterLayout;
                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout2 != null) {
                                                                        i = R.id.filterSummaryImage;
                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView9 != null) {
                                                                            i = R.id.filterSummaryLayout;
                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout3 != null) {
                                                                                i = R.id.filterTitle;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.firstNameLayout;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.friendCodeButtonLayout;
                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout4 != null) {
                                                                                            i = R.id.headerLayout;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout4 != null) {
                                                                                                i = R.id.loadingAnimationView;
                                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                if (lottieAnimationView != null) {
                                                                                                    i = R.id.logOutTextView;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.logoImage;
                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView10 != null) {
                                                                                                            i = R.id.masterFilterLayout;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i = R.id.no_photo_icon;
                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (imageView11 != null) {
                                                                                                                    i = R.id.numFilterTextView;
                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView6 != null) {
                                                                                                                        i = R.id.overlay;
                                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (constraintLayout5 != null) {
                                                                                                                            i = R.id.playerEmail;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i = R.id.playerFirstName;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.playerUsername;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.plus_icon;
                                                                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (imageView12 != null) {
                                                                                                                                            i = R.id.plusTextView;
                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.privacyToolbarLayout))) != null) {
                                                                                                                                                PrivacyToolbarBinding privacyToolbarBindingBind = PrivacyToolbarBinding.bind(viewFindChildViewById);
                                                                                                                                                i = R.id.profile_icon;
                                                                                                                                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (cachedImageView != null) {
                                                                                                                                                    i = R.id.profileLayout;
                                                                                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (constraintLayout6 != null) {
                                                                                                                                                        i = R.id.profileMythicBorder;
                                                                                                                                                        MythicProfileBorderView mythicProfileBorderView = (MythicProfileBorderView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (mythicProfileBorderView != null) {
                                                                                                                                                            i = R.id.profilePictureContainer;
                                                                                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (frameLayout != null) {
                                                                                                                                                                i = R.id.promoCodeButtonLayout;
                                                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                                                    i = R.id.promoCodeButtonText;
                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                        i = R.id.qrCodeImage;
                                                                                                                                                                        CachedImageView cachedImageView2 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (cachedImageView2 != null) {
                                                                                                                                                                            i = R.id.qrFrameLayout;
                                                                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (frameLayout2 != null) {
                                                                                                                                                                                i = R.id.searchEditLayout;
                                                                                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (constraintLayout8 != null) {
                                                                                                                                                                                    i = R.id.searchImage;
                                                                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (imageView13 != null) {
                                                                                                                                                                                        i = R.id.searchNotesEditText;
                                                                                                                                                                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (editText != null) {
                                                                                                                                                                                            i = R.id.searchNotesLayout;
                                                                                                                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (constraintLayout9 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.searchSpacer))) != null) {
                                                                                                                                                                                                i = R.id.searchTitle;
                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (textView12 != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                                                                                                                                                    i = R.id.tagImage;
                                                                                                                                                                                                    ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (imageView14 != null) {
                                                                                                                                                                                                        i = R.id.tagName;
                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                            i = R.id.textLayout;
                                                                                                                                                                                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (linearLayoutCompat != null) {
                                                                                                                                                                                                                i = R.id.userNameLayout;
                                                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                                                    i = R.id.view_pager;
                                                                                                                                                                                                                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (viewPager2 != null) {
                                                                                                                                                                                                                        return new BottomSheetProfileBinding((ConstraintLayout) view, linearLayout, textView, linearLayout2, imageView, gridLayout, imageView2, imageView3, imageView4, textView2, textView3, imageView5, imageView6, constraintLayout, imageView7, imageView8, constraintLayout2, imageView9, constraintLayout3, textView4, linearLayout3, constraintLayout4, linearLayout4, lottieAnimationView, textView5, imageView10, linearLayout5, imageView11, textView6, constraintLayout5, textView7, textView8, textView9, imageView12, textView10, privacyToolbarBindingBind, cachedImageView, constraintLayout6, mythicProfileBorderView, frameLayout, constraintLayout7, textView11, cachedImageView2, frameLayout2, constraintLayout8, imageView13, editText, constraintLayout9, viewFindChildViewById2, textView12, viewFindChildViewById3, imageView14, textView13, linearLayoutCompat, linearLayout6, viewPager2);
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

    public static BottomSheetProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_profile, viewGroup, false);
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
