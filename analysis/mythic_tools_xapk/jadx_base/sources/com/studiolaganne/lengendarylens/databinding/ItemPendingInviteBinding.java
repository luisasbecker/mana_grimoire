package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemPendingInviteBinding implements ViewBinding {
    public final TextView acceptButton;
    public final LinearLayout actionsRow;
    public final TextView cancelInviteButton;
    public final TextView inviteLabel;
    public final TextView otherPartyName;
    public final LinearLayout participantsContainer;
    public final TextView rejectButton;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView statusText;

    private ItemPendingInviteBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout3, TextView textView5, LinearLayout linearLayout4, TextView textView6) {
        this.rootView = linearLayout;
        this.acceptButton = textView;
        this.actionsRow = linearLayout2;
        this.cancelInviteButton = textView2;
        this.inviteLabel = textView3;
        this.otherPartyName = textView4;
        this.participantsContainer = linearLayout3;
        this.rejectButton = textView5;
        this.rootLayout = linearLayout4;
        this.statusText = textView6;
    }

    public static ItemPendingInviteBinding bind(View view) {
        int i = R.id.acceptButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.actionsRow;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.cancelInviteButton;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.inviteLabel;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.otherPartyName;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.participantsContainer;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.rejectButton;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) view;
                                    i = R.id.statusText;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        return new ItemPendingInviteBinding(linearLayout3, textView, linearLayout, textView2, textView3, textView4, linearLayout2, textView5, linearLayout3, textView6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemPendingInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPendingInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_pending_invite, viewGroup, false);
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
