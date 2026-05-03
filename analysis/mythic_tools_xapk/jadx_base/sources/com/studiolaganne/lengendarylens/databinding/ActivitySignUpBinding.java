package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySignUpBinding implements ViewBinding {
    public final ConstraintLayout appleButtonLayout;
    public final TextView appleText;
    public final View bottomSpacer;
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
    public final ImageView googleIcon;
    public final ConstraintLayout googleSignInButton;
    public final TextView googleText;
    public final ConstraintLayout headerLayout;
    public final FrameLayout incentivesLayout;
    public final ImageView line1Image;
    public final LinearLayout line1Layout;
    public final TextView line1Text;
    public final ImageView line2Image;
    public final LinearLayout line2Layout;
    public final TextView line2Text;
    public final ImageView line3Image;
    public final LinearLayout line3Layout;
    public final TextView line3Text;
    public final ImageView line4Image;
    public final LinearLayout line4Layout;
    public final TextView line4Text;
    public final ImageView line5Image;
    public final LinearLayout line5Layout;
    public final TextView line5Text;
    public final LinearLayout listLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView loginButtonText;
    public final ImageView mtLogo;
    public final TextView mtTitle;
    public final TextView orContinueLabel;
    public final ConstraintLayout overlay;
    public final TextInputEditText passwordEditText;
    public final TextInputLayout passwordInputLayout;
    public final ConstraintLayout resendEmailButton;
    private final ConstraintLayout rootView;
    public final TextView signInText;
    public final ConstraintLayout signInWithEmailButton;
    public final TextView signingUpTextView;
    public final TextView skipLabel;
    public final TextView title;
    public final View topSpacer;
    public final ConstraintLayout twitchButtonLayout;
    public final TextView twitchText;

    private ActivitySignUpBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, View view, ImageView imageView, ConstraintLayout constraintLayout3, TextView textView2, TextView textView3, ConstraintLayout constraintLayout4, TextView textView4, TextInputEditText textInputEditText, TextView textView5, TextView textView6, TextInputLayout textInputLayout, ConstraintLayout constraintLayout5, TextView textView7, ConstraintLayout constraintLayout6, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, ImageView imageView2, ConstraintLayout constraintLayout7, TextView textView8, ConstraintLayout constraintLayout8, FrameLayout frameLayout, ImageView imageView3, LinearLayout linearLayout, TextView textView9, ImageView imageView4, LinearLayout linearLayout2, TextView textView10, ImageView imageView5, LinearLayout linearLayout3, TextView textView11, ImageView imageView6, LinearLayout linearLayout4, TextView textView12, ImageView imageView7, LinearLayout linearLayout5, TextView textView13, LinearLayout linearLayout6, LottieAnimationView lottieAnimationView, TextView textView14, ImageView imageView8, TextView textView15, TextView textView16, ConstraintLayout constraintLayout9, TextInputEditText textInputEditText3, TextInputLayout textInputLayout3, ConstraintLayout constraintLayout10, TextView textView17, ConstraintLayout constraintLayout11, TextView textView18, TextView textView19, TextView textView20, View view2, ConstraintLayout constraintLayout12, TextView textView21) {
        this.rootView = constraintLayout;
        this.appleButtonLayout = constraintLayout2;
        this.appleText = textView;
        this.bottomSpacer = view;
        this.closeEmailImage = imageView;
        this.closeEmailLayout = constraintLayout3;
        this.connectingTextView = textView2;
        this.connectingTextViewTitle = textView3;
        this.discordButtonLayout = constraintLayout4;
        this.discordText = textView4;
        this.emailEditText = textInputEditText;
        this.emailIcon = textView5;
        this.emailIcon2 = textView6;
        this.emailInputLayout = textInputLayout;
        this.emailSignInButton = constraintLayout5;
        this.emailText = textView7;
        this.extraSignInButton = constraintLayout6;
        this.firstnameEditText = textInputEditText2;
        this.firstnameInputLayout = textInputLayout2;
        this.googleIcon = imageView2;
        this.googleSignInButton = constraintLayout7;
        this.googleText = textView8;
        this.headerLayout = constraintLayout8;
        this.incentivesLayout = frameLayout;
        this.line1Image = imageView3;
        this.line1Layout = linearLayout;
        this.line1Text = textView9;
        this.line2Image = imageView4;
        this.line2Layout = linearLayout2;
        this.line2Text = textView10;
        this.line3Image = imageView5;
        this.line3Layout = linearLayout3;
        this.line3Text = textView11;
        this.line4Image = imageView6;
        this.line4Layout = linearLayout4;
        this.line4Text = textView12;
        this.line5Image = imageView7;
        this.line5Layout = linearLayout5;
        this.line5Text = textView13;
        this.listLayout = linearLayout6;
        this.loadingAnimationView = lottieAnimationView;
        this.loginButtonText = textView14;
        this.mtLogo = imageView8;
        this.mtTitle = textView15;
        this.orContinueLabel = textView16;
        this.overlay = constraintLayout9;
        this.passwordEditText = textInputEditText3;
        this.passwordInputLayout = textInputLayout3;
        this.resendEmailButton = constraintLayout10;
        this.signInText = textView17;
        this.signInWithEmailButton = constraintLayout11;
        this.signingUpTextView = textView18;
        this.skipLabel = textView19;
        this.title = textView20;
        this.topSpacer = view2;
        this.twitchButtonLayout = constraintLayout12;
        this.twitchText = textView21;
    }

    public static ActivitySignUpBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.appleButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.appleText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bottomSpacer))) != null) {
                i = R.id.closeEmailImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
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
                                                                            i = R.id.google_icon;
                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView2 != null) {
                                                                                i = R.id.google_sign_in_button;
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout6 != null) {
                                                                                    i = R.id.google_text;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.headerLayout;
                                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout7 != null) {
                                                                                            i = R.id.incentivesLayout;
                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (frameLayout != null) {
                                                                                                i = R.id.line1Image;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.line1Layout;
                                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout != null) {
                                                                                                        i = R.id.line1Text;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.line2Image;
                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView4 != null) {
                                                                                                                i = R.id.line2Layout;
                                                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout2 != null) {
                                                                                                                    i = R.id.line2Text;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.line3Image;
                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (imageView5 != null) {
                                                                                                                            i = R.id.line3Layout;
                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                i = R.id.line3Text;
                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = R.id.line4Image;
                                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (imageView6 != null) {
                                                                                                                                        i = R.id.line4Layout;
                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                            i = R.id.line4Text;
                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView12 != null) {
                                                                                                                                                i = R.id.line5Image;
                                                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (imageView7 != null) {
                                                                                                                                                    i = R.id.line5Layout;
                                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                                        i = R.id.line5Text;
                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                            i = R.id.listLayout;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i = R.id.loadingAnimationView;
                                                                                                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (lottieAnimationView != null) {
                                                                                                                                                                    i = R.id.loginButtonText;
                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                        i = R.id.mtLogo;
                                                                                                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (imageView8 != null) {
                                                                                                                                                                            i = R.id.mtTitle;
                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                i = R.id.orContinueLabel;
                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView16 != null) {
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
                                                                                                                                                                                                    i = R.id.signInText;
                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                        i = R.id.signInWithEmailButton;
                                                                                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                                                                                            i = R.id.signingUpTextView;
                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                i = R.id.skipLabel;
                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                    i = R.id.title;
                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView20 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.topSpacer))) != null) {
                                                                                                                                                                                                                        i = R.id.twitchButtonLayout;
                                                                                                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (constraintLayout11 != null) {
                                                                                                                                                                                                                            i = R.id.twitchText;
                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                return new ActivitySignUpBinding((ConstraintLayout) view, constraintLayout, textView, viewFindChildViewById, imageView, constraintLayout2, textView2, textView3, constraintLayout3, textView4, textInputEditText, textView5, textView6, textInputLayout, constraintLayout4, textView7, constraintLayout5, textInputEditText2, textInputLayout2, imageView2, constraintLayout6, textView8, constraintLayout7, frameLayout, imageView3, linearLayout, textView9, imageView4, linearLayout2, textView10, imageView5, linearLayout3, textView11, imageView6, linearLayout4, textView12, imageView7, linearLayout5, textView13, linearLayout6, lottieAnimationView, textView14, imageView8, textView15, textView16, constraintLayout8, textInputEditText3, textInputLayout3, constraintLayout9, textView17, constraintLayout10, textView18, textView19, textView20, viewFindChildViewById2, constraintLayout11, textView21);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySignUpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySignUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_sign_up, viewGroup, false);
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
