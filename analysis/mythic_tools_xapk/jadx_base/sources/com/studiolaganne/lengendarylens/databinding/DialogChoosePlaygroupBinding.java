package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogChoosePlaygroupBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final TextView dialogTitle;
    public final TextView noPlaygroupsText;
    public final TextView noPlaygroupsText2;
    public final RecyclerView playgroupsRecyclerView;
    private final LinearLayout rootView;

    private DialogChoosePlaygroupBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.cancelButtonLayout = constraintLayout;
        this.cancelText = textView;
        this.dialogTitle = textView2;
        this.noPlaygroupsText = textView3;
        this.noPlaygroupsText2 = textView4;
        this.playgroupsRecyclerView = recyclerView;
    }

    public static DialogChoosePlaygroupBinding bind(View view) {
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.no_playgroups_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.no_playgroups_text_2;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.playgroupsRecyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                return new DialogChoosePlaygroupBinding((LinearLayout) view, constraintLayout, textView, textView2, textView3, textView4, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogChoosePlaygroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChoosePlaygroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_choose_playgroup, viewGroup, false);
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
