package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PopupSuggestionsBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ListView suggestionsList;

    private PopupSuggestionsBinding(LinearLayout linearLayout, ListView listView) {
        this.rootView = linearLayout;
        this.suggestionsList = listView;
    }

    public static PopupSuggestionsBinding bind(View view) {
        int i = R.id.suggestions_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            return new PopupSuggestionsBinding((LinearLayout) view, listView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PopupSuggestionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupSuggestionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_suggestions, viewGroup, false);
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
