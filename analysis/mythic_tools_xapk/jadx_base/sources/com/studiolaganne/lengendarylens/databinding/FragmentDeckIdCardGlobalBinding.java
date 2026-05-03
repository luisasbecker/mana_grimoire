package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentDeckIdCardGlobalBinding implements ViewBinding {
    public final LinearLayout autoTagsBarLayout;
    public final LinearLayout autoTagsSection;
    public final LinearLayout globalContentLayout;
    public final TextView helpTextView;
    public final LinearLayout infoSection;
    public final FlexboxLayout insightsFlexboxLayout;
    public final LinearLayout insightsSection;
    private final ScrollView rootView;
    public final FlexboxLayout themesFlexboxLayout;
    public final LinearLayout themesSection;

    private FragmentDeckIdCardGlobalBinding(ScrollView scrollView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, LinearLayout linearLayout4, FlexboxLayout flexboxLayout, LinearLayout linearLayout5, FlexboxLayout flexboxLayout2, LinearLayout linearLayout6) {
        this.rootView = scrollView;
        this.autoTagsBarLayout = linearLayout;
        this.autoTagsSection = linearLayout2;
        this.globalContentLayout = linearLayout3;
        this.helpTextView = textView;
        this.infoSection = linearLayout4;
        this.insightsFlexboxLayout = flexboxLayout;
        this.insightsSection = linearLayout5;
        this.themesFlexboxLayout = flexboxLayout2;
        this.themesSection = linearLayout6;
    }

    public static FragmentDeckIdCardGlobalBinding bind(View view) {
        int i = R.id.autoTagsBarLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.autoTagsSection;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.globalContentLayout;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.helpTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.infoSection;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout4 != null) {
                            i = R.id.insightsFlexboxLayout;
                            FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                            if (flexboxLayout != null) {
                                i = R.id.insightsSection;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout5 != null) {
                                    i = R.id.themesFlexboxLayout;
                                    FlexboxLayout flexboxLayout2 = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                    if (flexboxLayout2 != null) {
                                        i = R.id.themesSection;
                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout6 != null) {
                                            return new FragmentDeckIdCardGlobalBinding((ScrollView) view, linearLayout, linearLayout2, linearLayout3, textView, linearLayout4, flexboxLayout, linearLayout5, flexboxLayout2, linearLayout6);
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

    public static FragmentDeckIdCardGlobalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeckIdCardGlobalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_deck_id_card_global, viewGroup, false);
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
