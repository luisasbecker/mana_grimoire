package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentQrCodeScannerBinding implements ViewBinding {
    public final ImageView chevronDown;
    public final ConstraintLayout copyLayout;
    public final EditText friendCodeEditText;
    public final ConstraintLayout friendCodeTab;
    public final ImageView friendCodeTabIcon;
    public final TextView friendCodeTabText;
    public final ConstraintLayout friendCodeTextLayout;
    public final TextView friendCodeTextView;
    public final TextView friendHelpText;
    public final LinearLayout friendIconAndText;
    public final LinearLayout friendMainLayout;
    public final View friendTabSelectedView;
    public final TextView helpText;
    public final ImageView noPhotoIcon;
    public final TextView playerUsername;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout qrCodeButtonLayout;
    public final TextView qrCodeButtonText;
    public final ConstraintLayout qrCodeTab;
    public final ImageView qrCodeTabIcon;
    public final TextView qrCodeTabText;
    public final LinearLayout qrIconAndText;
    public final LinearLayout qrMainLayout;
    public final View qrTabSelectedView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout sendCodeButtonLayout;
    public final TextView sendCodeButtonText;
    public final LinearLayout separatorLayout;
    public final LinearLayout tabsLayout;
    public final TextView yourCodeTextViewHeader;
    public final ConstraintLayout yourFriendCodeTextLayout;

    private FragmentQrCodeScannerBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, EditText editText, ConstraintLayout constraintLayout3, ImageView imageView2, TextView textView, ConstraintLayout constraintLayout4, TextView textView2, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, View view, TextView textView4, ImageView imageView3, TextView textView5, CachedImageView cachedImageView, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TextView textView6, ConstraintLayout constraintLayout7, ImageView imageView4, TextView textView7, LinearLayout linearLayout3, LinearLayout linearLayout4, View view2, ConstraintLayout constraintLayout8, TextView textView8, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView9, ConstraintLayout constraintLayout9) {
        this.rootView = constraintLayout;
        this.chevronDown = imageView;
        this.copyLayout = constraintLayout2;
        this.friendCodeEditText = editText;
        this.friendCodeTab = constraintLayout3;
        this.friendCodeTabIcon = imageView2;
        this.friendCodeTabText = textView;
        this.friendCodeTextLayout = constraintLayout4;
        this.friendCodeTextView = textView2;
        this.friendHelpText = textView3;
        this.friendIconAndText = linearLayout;
        this.friendMainLayout = linearLayout2;
        this.friendTabSelectedView = view;
        this.helpText = textView4;
        this.noPhotoIcon = imageView3;
        this.playerUsername = textView5;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout5;
        this.qrCodeButtonLayout = constraintLayout6;
        this.qrCodeButtonText = textView6;
        this.qrCodeTab = constraintLayout7;
        this.qrCodeTabIcon = imageView4;
        this.qrCodeTabText = textView7;
        this.qrIconAndText = linearLayout3;
        this.qrMainLayout = linearLayout4;
        this.qrTabSelectedView = view2;
        this.sendCodeButtonLayout = constraintLayout8;
        this.sendCodeButtonText = textView8;
        this.separatorLayout = linearLayout5;
        this.tabsLayout = linearLayout6;
        this.yourCodeTextViewHeader = textView9;
        this.yourFriendCodeTextLayout = constraintLayout9;
    }

    public static FragmentQrCodeScannerBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.chevron_down;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.copyLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.friendCodeEditText;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.friendCodeTab;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.friendCodeTabIcon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.friendCodeTabText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.friendCodeTextLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.friendCodeTextView;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.friendHelpText;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.friendIconAndText;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = R.id.friendMainLayout;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.friendTabSelectedView))) != null) {
                                                    i = R.id.helpText;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.no_photo_icon;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.playerUsername;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.profile_icon;
                                                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                if (cachedImageView != null) {
                                                                    i = R.id.profileLayout;
                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout4 != null) {
                                                                        i = R.id.qrCodeButtonLayout;
                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout5 != null) {
                                                                            i = R.id.qrCodeButtonText;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.qrCodeTab;
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout6 != null) {
                                                                                    i = R.id.qrCodeTabIcon;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView4 != null) {
                                                                                        i = R.id.qrCodeTabText;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.qrIconAndText;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = R.id.qrMainLayout;
                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout4 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.qrTabSelectedView))) != null) {
                                                                                                    i = R.id.sendCodeButtonLayout;
                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout7 != null) {
                                                                                                        i = R.id.sendCodeButtonText;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.separatorLayout;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i = R.id.tabsLayout;
                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout6 != null) {
                                                                                                                    i = R.id.yourCodeTextViewHeader;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.yourFriendCodeTextLayout;
                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                            return new FragmentQrCodeScannerBinding((ConstraintLayout) view, imageView, constraintLayout, editText, constraintLayout2, imageView2, textView, constraintLayout3, textView2, textView3, linearLayout, linearLayout2, viewFindChildViewById, textView4, imageView3, textView5, cachedImageView, constraintLayout4, constraintLayout5, textView6, constraintLayout6, imageView4, textView7, linearLayout3, linearLayout4, viewFindChildViewById2, constraintLayout7, textView8, linearLayout5, linearLayout6, textView9, constraintLayout8);
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

    public static FragmentQrCodeScannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentQrCodeScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_qr_code_scanner, viewGroup, false);
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
