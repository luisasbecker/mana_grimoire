package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetSigninBinding implements ViewBinding {
    public final ConstraintLayout appleButtonLayout;
    public final TextView appleText;
    public final ImageView chevronDown;
    public final ImageView closeEmailImage;
    public final ConstraintLayout closeEmailLayout;
    public final TextView connectingTextView;
    public final TextView connectingTextViewTitle;
    public final ConstraintLayout discordButtonLayout;
    public final TextView discordText;
    public final TextInputEditText emailEditText;
    public final TextView emailIcon;
    public final TextView emailIcon2;
    public final TextInputLayout emailInputLayout;
    public final ConstraintLayout emailSignInButton;
    public final TextView emailText;
    public final ConstraintLayout extraSignInButton;
    public final TextInputEditText firstnameEditText;
    public final TextInputLayout firstnameInputLayout;
    public final TextView forgottenPasswordText;
    public final ImageView googleIcon;
    public final ConstraintLayout googleSignInButton;
    public final TextView googleText;
    public final ConstraintLayout incentiveLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView loginButtonText;
    public final ImageView mtImage;
    public final TextView mtText;
    public final TextView orContinueLabel;
    public final ConstraintLayout overlay;
    public final TextInputEditText passwordEditText;
    public final TextInputLayout passwordInputLayout;
    public final ConstraintLayout resendEmailButton;
    private final FrameLayout rootView;
    public final TextView signInPromptText;
    public final TextView signInText;
    public final ConstraintLayout signInWithEmailButton;
    public final TextView signUpPromptText;
    public final ConstraintLayout twitchButtonLayout;
    public final TextView twitchText;

    private BottomSheetSigninBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, TextInputEditText textInputEditText, TextView textView5, TextView textView6, TextInputLayout textInputLayout, ConstraintLayout constraintLayout4, TextView textView7, ConstraintLayout constraintLayout5, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, TextView textView8, ImageView imageView3, ConstraintLayout constraintLayout6, TextView textView9, ConstraintLayout constraintLayout7, LottieAnimationView lottieAnimationView, TextView textView10, ImageView imageView4, TextView textView11, TextView textView12, ConstraintLayout constraintLayout8, TextInputEditText textInputEditText3, TextInputLayout textInputLayout3, ConstraintLayout constraintLayout9, TextView textView13, TextView textView14, ConstraintLayout constraintLayout10, TextView textView15, ConstraintLayout constraintLayout11, TextView textView16) {
        this.rootView = frameLayout;
        this.appleButtonLayout = constraintLayout;
        this.appleText = textView;
        this.chevronDown = imageView;
        this.closeEmailImage = imageView2;
        this.closeEmailLayout = constraintLayout2;
        this.connectingTextView = textView2;
        this.connectingTextViewTitle = textView3;
        this.discordButtonLayout = constraintLayout3;
        this.discordText = textView4;
        this.emailEditText = textInputEditText;
        this.emailIcon = textView5;
        this.emailIcon2 = textView6;
        this.emailInputLayout = textInputLayout;
        this.emailSignInButton = constraintLayout4;
        this.emailText = textView7;
        this.extraSignInButton = constraintLayout5;
        this.firstnameEditText = textInputEditText2;
        this.firstnameInputLayout = textInputLayout2;
        this.forgottenPasswordText = textView8;
        this.googleIcon = imageView3;
        this.googleSignInButton = constraintLayout6;
        this.googleText = textView9;
        this.incentiveLayout = constraintLayout7;
        this.loadingAnimationView = lottieAnimationView;
        this.loginButtonText = textView10;
        this.mtImage = imageView4;
        this.mtText = textView11;
        this.orContinueLabel = textView12;
        this.overlay = constraintLayout8;
        this.passwordEditText = textInputEditText3;
        this.passwordInputLayout = textInputLayout3;
        this.resendEmailButton = constraintLayout9;
        this.signInPromptText = textView13;
        this.signInText = textView14;
        this.signInWithEmailButton = constraintLayout10;
        this.signUpPromptText = textView15;
        this.twitchButtonLayout = constraintLayout11;
        this.twitchText = textView16;
    }

    public static BottomSheetSigninBinding bind(View view) {
        int i = R.id.appleButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.appleText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.chevron_down;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.closeEmailImage;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.closeEmailLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.connectingTextView;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.connectingTextViewTitle;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.discordButtonLayout;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.discordText;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.emailEditText;
                                            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                            if (textInputEditText != null) {
                                                i = R.id.email_icon;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.email_icon_2;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.emailInputLayout;
                                                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                        if (textInputLayout != null) {
                                                            i = R.id.email_sign_in_button;
                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout4 != null) {
                                                                i = R.id.email_text;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.extra_sign_in_button;
                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout5 != null) {
                                                                        i = R.id.firstnameEditText;
                                                                        TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                                                        if (textInputEditText2 != null) {
                                                                            i = R.id.firstnameInputLayout;
                                                                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (textInputLayout2 != null) {
                                                                                i = R.id.forgottenPasswordText;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.google_icon;
                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView3 != null) {
                                                                                        i = R.id.google_sign_in_button;
                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout6 != null) {
                                                                                            i = R.id.google_text;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.incentiveLayout;
                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (constraintLayout7 != null) {
                                                                                                    i = R.id.loadingAnimationView;
                                                                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (lottieAnimationView != null) {
                                                                                                        i = R.id.loginButtonText;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.mtImage;
                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView4 != null) {
                                                                                                                i = R.id.mtText;
                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView11 != null) {
                                                                                                                    i = R.id.orContinueLabel;
                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView12 != null) {
                                                                                                                        i = R.id.overlay;
                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                            i = R.id.passwordEditText;
                                                                                                                            TextInputEditText textInputEditText3 = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textInputEditText3 != null) {
                                                                                                                                i = R.id.passwordInputLayout;
                                                                                                                                TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textInputLayout3 != null) {
                                                                                                                                    i = R.id.resendEmailButton;
                                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout9 != null) {
                                                                                                                                        i = R.id.signInPromptText;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i = R.id.signInText;
                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView14 != null) {
                                                                                                                                                i = R.id.signInWithEmailButton;
                                                                                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (constraintLayout10 != null) {
                                                                                                                                                    i = R.id.signUpPromptText;
                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                        i = R.id.twitchButtonLayout;
                                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (constraintLayout11 != null) {
                                                                                                                                                            i = R.id.twitchText;
                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                return new BottomSheetSigninBinding((FrameLayout) view, constraintLayout, textView, imageView, imageView2, constraintLayout2, textView2, textView3, constraintLayout3, textView4, textInputEditText, textView5, textView6, textInputLayout, constraintLayout4, textView7, constraintLayout5, textInputEditText2, textInputLayout2, textView8, imageView3, constraintLayout6, textView9, constraintLayout7, lottieAnimationView, textView10, imageView4, textView11, textView12, constraintLayout8, textInputEditText3, textInputLayout3, constraintLayout9, textView13, textView14, constraintLayout10, textView15, constraintLayout11, textView16);
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

    public static BottomSheetSigninBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetSigninBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_signin, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
