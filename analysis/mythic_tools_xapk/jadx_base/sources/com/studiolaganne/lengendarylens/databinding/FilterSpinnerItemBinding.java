package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FilterSpinnerItemBinding implements ViewBinding {
    private final TextView rootView;

    private FilterSpinnerItemBinding(TextView textView) {
        this.rootView = textView;
    }

    public static FilterSpinnerItemBinding bind(View view) {
        if (view != null) {
            return new FilterSpinnerItemBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static FilterSpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FilterSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.filter_spinner_item, viewGroup, false);
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
