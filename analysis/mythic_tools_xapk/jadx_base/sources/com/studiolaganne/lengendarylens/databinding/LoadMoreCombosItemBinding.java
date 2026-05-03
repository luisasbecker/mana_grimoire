package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LoadMoreCombosItemBinding implements ViewBinding {
    public final TextView loadMoreCombosText;
    private final TextView rootView;

    private LoadMoreCombosItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.loadMoreCombosText = textView2;
    }

    public static LoadMoreCombosItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new LoadMoreCombosItemBinding(textView, textView);
    }

    public static LoadMoreCombosItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LoadMoreCombosItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.load_more_combos_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }
}
