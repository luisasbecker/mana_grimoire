package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomSpinnerItemPrintsBinding implements ViewBinding {
    private final TextView rootView;

    private CustomSpinnerItemPrintsBinding(TextView textView) {
        this.rootView = textView;
    }

    public static CustomSpinnerItemPrintsBinding bind(View view) {
        if (view != null) {
            return new CustomSpinnerItemPrintsBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static CustomSpinnerItemPrintsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CustomSpinnerItemPrintsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.custom_spinner_item_prints, viewGroup, false);
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
