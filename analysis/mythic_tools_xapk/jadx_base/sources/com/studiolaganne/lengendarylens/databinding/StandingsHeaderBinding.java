package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class StandingsHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;

    private StandingsHeaderBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static StandingsHeaderBinding bind(View view) {
        if (view != null) {
            return new StandingsHeaderBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static StandingsHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StandingsHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.standings_header, viewGroup, false);
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
