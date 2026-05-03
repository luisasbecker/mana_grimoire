package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NewFilterDialogBinding implements ViewBinding {
    public final RecyclerView filtersRecyclerView;
    private final ConstraintLayout rootView;

    private NewFilterDialogBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.filtersRecyclerView = recyclerView;
    }

    public static NewFilterDialogBinding bind(View view) {
        int i = R.id.filtersRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            return new NewFilterDialogBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NewFilterDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NewFilterDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.new_filter_dialog, viewGroup, false);
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
