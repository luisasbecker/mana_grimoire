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
public final class FragmentDeckIdCardManaBinding implements ViewBinding {
    public final LinearLayout manaContentLayout;
    private final ScrollView rootView;

    private FragmentDeckIdCardManaBinding(ScrollView scrollView, LinearLayout linearLayout) {
        this.rootView = scrollView;
        this.manaContentLayout = linearLayout;
    }

    public static FragmentDeckIdCardManaBinding bind(View view) {
        int i = R.id.manaContentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new FragmentDeckIdCardManaBinding((ScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentDeckIdCardManaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeckIdCardManaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_deck_id_card_mana, viewGroup, false);
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
