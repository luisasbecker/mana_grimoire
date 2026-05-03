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
public final class FragmentPlaygroupUsersBinding implements ViewBinding {
    public final ConstraintLayout inviteButtonLayout;
    public final TextView inviteButtonText;
    public final RecyclerView membersRecyclerView;
    private final LinearLayout rootView;

    private FragmentPlaygroupUsersBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.inviteButtonLayout = constraintLayout;
        this.inviteButtonText = textView;
        this.membersRecyclerView = recyclerView;
    }

    public static FragmentPlaygroupUsersBinding bind(View view) {
        int i = R.id.inviteButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.inviteButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.membersRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    return new FragmentPlaygroupUsersBinding((LinearLayout) view, constraintLayout, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentPlaygroupUsersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPlaygroupUsersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_playgroup_users, viewGroup, false);
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
