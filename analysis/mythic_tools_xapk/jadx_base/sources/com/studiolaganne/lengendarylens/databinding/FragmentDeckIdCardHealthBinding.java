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
public final class FragmentDeckIdCardHealthBinding implements ViewBinding {
    public final LinearLayout healthContentLayout;
    private final ScrollView rootView;

    private FragmentDeckIdCardHealthBinding(ScrollView scrollView, LinearLayout linearLayout) {
        this.rootView = scrollView;
        this.healthContentLayout = linearLayout;
    }

    public static FragmentDeckIdCardHealthBinding bind(View view) {
        int i = R.id.healthContentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new FragmentDeckIdCardHealthBinding((ScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentDeckIdCardHealthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeckIdCardHealthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_deck_id_card_health, viewGroup, false);
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
