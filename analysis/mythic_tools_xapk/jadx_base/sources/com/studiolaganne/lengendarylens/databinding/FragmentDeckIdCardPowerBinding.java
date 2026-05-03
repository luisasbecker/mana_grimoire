package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentDeckIdCardPowerBinding implements ViewBinding {
    public final LinearLayout powerContentLayout;
    private final ScrollView rootView;

    private FragmentDeckIdCardPowerBinding(ScrollView scrollView, LinearLayout linearLayout) {
        this.rootView = scrollView;
        this.powerContentLayout = linearLayout;
    }

    public static FragmentDeckIdCardPowerBinding bind(View view) {
        int i = R.id.powerContentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new FragmentDeckIdCardPowerBinding((ScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentDeckIdCardPowerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeckIdCardPowerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_deck_id_card_power, viewGroup, false);
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
