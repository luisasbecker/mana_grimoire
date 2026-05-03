package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.studiolaganne.lengendarylens.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogSmartDeckConvertBinding implements ViewBinding {
    private final ScrollView rootView;
    public final TextView smartDeckBody;
    public final TextView smartDeckCancelBtn;
    public final ImageView smartDeckClose;
    public final TextView smartDeckConvertBtn;
    public final WormDotsIndicator smartDeckDots;
    public final ViewPager2 smartDeckPager;
    public final TextView smartDeckSlideSubtitle;
    public final TextView smartDeckSlideTitle;
    public final TextView smartDeckTitle;
    public final TextView smartDeckWarning;

    private DialogSmartDeckConvertBinding(ScrollView scrollView, TextView textView, TextView textView2, ImageView imageView, TextView textView3, WormDotsIndicator wormDotsIndicator, ViewPager2 viewPager2, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = scrollView;
        this.smartDeckBody = textView;
        this.smartDeckCancelBtn = textView2;
        this.smartDeckClose = imageView;
        this.smartDeckConvertBtn = textView3;
        this.smartDeckDots = wormDotsIndicator;
        this.smartDeckPager = viewPager2;
        this.smartDeckSlideSubtitle = textView4;
        this.smartDeckSlideTitle = textView5;
        this.smartDeckTitle = textView6;
        this.smartDeckWarning = textView7;
    }

    public static DialogSmartDeckConvertBinding bind(View view) {
        int i = R.id.smart_deck_body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.smart_deck_cancel_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.smart_deck_close;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.smart_deck_convert_btn;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.smart_deck_dots;
                        WormDotsIndicator wormDotsIndicator = (WormDotsIndicator) ViewBindings.findChildViewById(view, i);
                        if (wormDotsIndicator != null) {
                            i = R.id.smart_deck_pager;
                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                            if (viewPager2 != null) {
                                i = R.id.smart_deck_slide_subtitle;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.smart_deck_slide_title;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.smart_deck_title;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.smart_deck_warning;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                return new DialogSmartDeckConvertBinding((ScrollView) view, textView, textView2, imageView, textView3, wormDotsIndicator, viewPager2, textView4, textView5, textView6, textView7);
                                            }
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

    public static DialogSmartDeckConvertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSmartDeckConvertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_smart_deck_convert, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }
}
