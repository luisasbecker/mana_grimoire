package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ScreenshotItemBinding implements ViewBinding {
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final CachedImageView screenshotImage;

    private ScreenshotItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CachedImageView cachedImageView) {
        this.rootView = constraintLayout;
        this.rootLayout = constraintLayout2;
        this.screenshotImage = cachedImageView;
    }

    public static ScreenshotItemBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.screenshotImage;
        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
        if (cachedImageView != null) {
            return new ScreenshotItemBinding(constraintLayout, constraintLayout, cachedImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ScreenshotItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScreenshotItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.screenshot_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
