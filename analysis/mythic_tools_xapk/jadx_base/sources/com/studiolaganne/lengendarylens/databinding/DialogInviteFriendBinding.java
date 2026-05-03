package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogInviteFriendBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final TextView closeButton;
    public final TextView emptyStateText;
    public final RecyclerView friendsRecyclerView;
    public final MaterialButton inviteButton;
    private final LinearLayout rootView;
    public final EditText searchEditText;
    public final TextView titleTextView;

    private DialogInviteFriendBinding(LinearLayout linearLayout, MaterialButton materialButton, TextView textView, TextView textView2, RecyclerView recyclerView, MaterialButton materialButton2, EditText editText, TextView textView3) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.closeButton = textView;
        this.emptyStateText = textView2;
        this.friendsRecyclerView = recyclerView;
        this.inviteButton = materialButton2;
        this.searchEditText = editText;
        this.titleTextView = textView3;
    }

    public static DialogInviteFriendBinding bind(View view) {
        int i = R.id.cancelButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.closeButton;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.emptyStateText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.friendsRecyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.inviteButton;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton2 != null) {
                            i = R.id.searchEditText;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                i = R.id.titleTextView;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new DialogInviteFriendBinding((LinearLayout) view, materialButton, textView, textView2, recyclerView, materialButton2, editText, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogInviteFriendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogInviteFriendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_invite_friend, viewGroup, false);
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
