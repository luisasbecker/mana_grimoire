package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AddFriendItemBinding implements ViewBinding {
    public final TextView playerNameTextView;
    public final ConstraintLayout plusIcon;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private AddFriendItemBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.playerNameTextView = textView;
        this.plusIcon = constraintLayout2;
        this.rootLayout = constraintLayout3;
    }

    public static AddFriendItemBinding bind(View view) {
        int i = R.id.player_name_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.plusIcon;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                return new AddFriendItemBinding(constraintLayout2, textView, constraintLayout, constraintLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AddFriendItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AddFriendItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.add_friend_item, viewGroup, false);
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
