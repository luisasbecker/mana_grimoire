package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogBracketHelpBinding implements ViewBinding {
    public final MaterialButton closeButton;
    public final LinearLayout dialogRoot;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final TextView section1Bullet1;
    public final TextView section1Bullet2;
    public final TextView section1Bullet3;
    public final TextView section1Bullet4;
    public final ImageView section1Chevron;
    public final LinearLayout section1Content;
    public final TextView section1Expect;
    public final TextView section1Footer;
    public final LinearLayout section1Header;
    public final TextView section1Title;
    public final TextView section2Bullet1;
    public final TextView section2Bullet2;
    public final TextView section2Bullet3;
    public final TextView section2Bullet4;
    public final ImageView section2Chevron;
    public final LinearLayout section2Content;
    public final TextView section2Expect;
    public final TextView section2Footer;
    public final LinearLayout section2Header;
    public final TextView section2Title;
    public final TextView section3Bullet1;
    public final TextView section3Bullet2;
    public final TextView section3Bullet3;
    public final TextView section3Bullet4;
    public final ImageView section3Chevron;
    public final LinearLayout section3Content;
    public final TextView section3Expect;
    public final TextView section3Footer;
    public final LinearLayout section3Header;
    public final TextView section3Title;
    public final TextView section4Bullet1;
    public final TextView section4Bullet2;
    public final TextView section4Bullet3;
    public final TextView section4Bullet4;
    public final TextView section4Bullet5;
    public final ImageView section4Chevron;
    public final LinearLayout section4Content;
    public final TextView section4Expect;
    public final TextView section4Footer;
    public final LinearLayout section4Header;
    public final TextView section4Title;
    public final TextView section5Bullet1;
    public final TextView section5Bullet2;
    public final TextView section5Bullet3;
    public final ImageView section5Chevron;
    public final LinearLayout section5Content;
    public final TextView section5Expect;
    public final TextView section5Footer;
    public final LinearLayout section5Header;
    public final TextView section5Title;
    public final TextView title;

    private DialogBracketHelpBinding(LinearLayout linearLayout, MaterialButton materialButton, LinearLayout linearLayout2, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, LinearLayout linearLayout3, TextView textView5, TextView textView6, LinearLayout linearLayout4, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ImageView imageView2, LinearLayout linearLayout5, TextView textView12, TextView textView13, LinearLayout linearLayout6, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, ImageView imageView3, LinearLayout linearLayout7, TextView textView19, TextView textView20, LinearLayout linearLayout8, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, ImageView imageView4, LinearLayout linearLayout9, TextView textView27, TextView textView28, LinearLayout linearLayout10, TextView textView29, TextView textView30, TextView textView31, TextView textView32, ImageView imageView5, LinearLayout linearLayout11, TextView textView33, TextView textView34, LinearLayout linearLayout12, TextView textView35, TextView textView36) {
        this.rootView = linearLayout;
        this.closeButton = materialButton;
        this.dialogRoot = linearLayout2;
        this.scrollView = scrollView;
        this.section1Bullet1 = textView;
        this.section1Bullet2 = textView2;
        this.section1Bullet3 = textView3;
        this.section1Bullet4 = textView4;
        this.section1Chevron = imageView;
        this.section1Content = linearLayout3;
        this.section1Expect = textView5;
        this.section1Footer = textView6;
        this.section1Header = linearLayout4;
        this.section1Title = textView7;
        this.section2Bullet1 = textView8;
        this.section2Bullet2 = textView9;
        this.section2Bullet3 = textView10;
        this.section2Bullet4 = textView11;
        this.section2Chevron = imageView2;
        this.section2Content = linearLayout5;
        this.section2Expect = textView12;
        this.section2Footer = textView13;
        this.section2Header = linearLayout6;
        this.section2Title = textView14;
        this.section3Bullet1 = textView15;
        this.section3Bullet2 = textView16;
        this.section3Bullet3 = textView17;
        this.section3Bullet4 = textView18;
        this.section3Chevron = imageView3;
        this.section3Content = linearLayout7;
        this.section3Expect = textView19;
        this.section3Footer = textView20;
        this.section3Header = linearLayout8;
        this.section3Title = textView21;
        this.section4Bullet1 = textView22;
        this.section4Bullet2 = textView23;
        this.section4Bullet3 = textView24;
        this.section4Bullet4 = textView25;
        this.section4Bullet5 = textView26;
        this.section4Chevron = imageView4;
        this.section4Content = linearLayout9;
        this.section4Expect = textView27;
        this.section4Footer = textView28;
        this.section4Header = linearLayout10;
        this.section4Title = textView29;
        this.section5Bullet1 = textView30;
        this.section5Bullet2 = textView31;
        this.section5Bullet3 = textView32;
        this.section5Chevron = imageView5;
        this.section5Content = linearLayout11;
        this.section5Expect = textView33;
        this.section5Footer = textView34;
        this.section5Header = linearLayout12;
        this.section5Title = textView35;
        this.title = textView36;
    }

    public static DialogBracketHelpBinding bind(View view) {
        int i = R.id.close_button;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.scroll_view;
            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
            if (scrollView != null) {
                i = R.id.section1_bullet1;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.section1_bullet2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.section1_bullet3;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.section1_bullet4;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.section1_chevron;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.section1_content;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.section1_expect;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.section1_footer;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.section1_header;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.section1_title;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.section2_bullet1;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.section2_bullet2;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = R.id.section2_bullet3;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView10 != null) {
                                                                    i = R.id.section2_bullet4;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView11 != null) {
                                                                        i = R.id.section2_chevron;
                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView2 != null) {
                                                                            i = R.id.section2_content;
                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout4 != null) {
                                                                                i = R.id.section2_expect;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.section2_footer;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.section2_header;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.section2_title;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.section3_bullet1;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.section3_bullet2;
                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView16 != null) {
                                                                                                        i = R.id.section3_bullet3;
                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView17 != null) {
                                                                                                            i = R.id.section3_bullet4;
                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView18 != null) {
                                                                                                                i = R.id.section3_chevron;
                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (imageView3 != null) {
                                                                                                                    i = R.id.section3_content;
                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout6 != null) {
                                                                                                                        i = R.id.section3_expect;
                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView19 != null) {
                                                                                                                            i = R.id.section3_footer;
                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView20 != null) {
                                                                                                                                i = R.id.section3_header;
                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                    i = R.id.section3_title;
                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView21 != null) {
                                                                                                                                        i = R.id.section4_bullet1;
                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView22 != null) {
                                                                                                                                            i = R.id.section4_bullet2;
                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView23 != null) {
                                                                                                                                                i = R.id.section4_bullet3;
                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView24 != null) {
                                                                                                                                                    i = R.id.section4_bullet4;
                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                        i = R.id.section4_bullet5;
                                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView26 != null) {
                                                                                                                                                            i = R.id.section4_chevron;
                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                i = R.id.section4_content;
                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                    i = R.id.section4_expect;
                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                        i = R.id.section4_footer;
                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                            i = R.id.section4_header;
                                                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                                                i = R.id.section4_title;
                                                                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView29 != null) {
                                                                                                                                                                                    i = R.id.section5_bullet1;
                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                        i = R.id.section5_bullet2;
                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                            i = R.id.section5_bullet3;
                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                i = R.id.section5_chevron;
                                                                                                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (imageView5 != null) {
                                                                                                                                                                                                    i = R.id.section5_content;
                                                                                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                                                                                        i = R.id.section5_expect;
                                                                                                                                                                                                        TextView textView33 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView33 != null) {
                                                                                                                                                                                                            i = R.id.section5_footer;
                                                                                                                                                                                                            TextView textView34 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView34 != null) {
                                                                                                                                                                                                                i = R.id.section5_header;
                                                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                                                    i = R.id.section5_title;
                                                                                                                                                                                                                    TextView textView35 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView35 != null) {
                                                                                                                                                                                                                        i = R.id.title;
                                                                                                                                                                                                                        TextView textView36 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView36 != null) {
                                                                                                                                                                                                                            return new DialogBracketHelpBinding(linearLayout, materialButton, linearLayout, scrollView, textView, textView2, textView3, textView4, imageView, linearLayout2, textView5, textView6, linearLayout3, textView7, textView8, textView9, textView10, textView11, imageView2, linearLayout4, textView12, textView13, linearLayout5, textView14, textView15, textView16, textView17, textView18, imageView3, linearLayout6, textView19, textView20, linearLayout7, textView21, textView22, textView23, textView24, textView25, textView26, imageView4, linearLayout8, textView27, textView28, linearLayout9, textView29, textView30, textView31, textView32, imageView5, linearLayout10, textView33, textView34, linearLayout11, textView35, textView36);
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogBracketHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBracketHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_bracket_help, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
