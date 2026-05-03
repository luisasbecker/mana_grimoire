package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChevronLayoutBinding implements ViewBinding {
    private final ImageView rootView;

    private ChevronLayoutBinding(ImageView imageView) {
        this.rootView = imageView;
    }

    public static ChevronLayoutBinding bind(View view) {
        if (view != null) {
            return new ChevronLayoutBinding((ImageView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ChevronLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ChevronLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.chevron_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }
}
