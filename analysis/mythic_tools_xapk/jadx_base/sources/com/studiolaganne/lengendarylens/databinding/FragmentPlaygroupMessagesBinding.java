package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentPlaygroupMessagesBinding implements ViewBinding {
    public final ImageFilterView cardsIcon;
    public final ImageFilterView emojiIcon;
    public final EditText messageInput;
    public final LinearLayout messageInputLayout;
    public final LinearLayout messagesInnerLayout;
    public final RecyclerView messagesRecyclerView;
    private final LinearLayout rootView;
    public final ConstraintLayout sendButtonLayout;
    public final ConstraintLayout sendHintLayout;
    public final ImageView sendIcon;
    public final TextView sendingHint;
    public final SwipeRefreshLayout swipeRefreshLayout;

    private FragmentPlaygroupMessagesBinding(LinearLayout linearLayout, ImageFilterView imageFilterView, ImageFilterView imageFilterView2, EditText editText, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, SwipeRefreshLayout swipeRefreshLayout) {
        this.rootView = linearLayout;
        this.cardsIcon = imageFilterView;
        this.emojiIcon = imageFilterView2;
        this.messageInput = editText;
        this.messageInputLayout = linearLayout2;
        this.messagesInnerLayout = linearLayout3;
        this.messagesRecyclerView = recyclerView;
        this.sendButtonLayout = constraintLayout;
        this.sendHintLayout = constraintLayout2;
        this.sendIcon = imageView;
        this.sendingHint = textView;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    public static FragmentPlaygroupMessagesBinding bind(View view) {
        int i = R.id.cardsIcon;
        ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, i);
        if (imageFilterView != null) {
            i = R.id.emojiIcon;
            ImageFilterView imageFilterView2 = (ImageFilterView) ViewBindings.findChildViewById(view, i);
            if (imageFilterView2 != null) {
                i = R.id.messageInput;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.messageInputLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.messagesInnerLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.messagesRecyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.sendButtonLayout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.sendHintLayout;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.sendIcon;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.sendingHint;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.swipe_refresh_layout;
                                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                if (swipeRefreshLayout != null) {
                                                    return new FragmentPlaygroupMessagesBinding((LinearLayout) view, imageFilterView, imageFilterView2, editText, linearLayout, linearLayout2, recyclerView, constraintLayout, constraintLayout2, imageView, textView, swipeRefreshLayout);
                                                }
                                            }
                                        }
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

    public static FragmentPlaygroupMessagesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPlaygroupMessagesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_playgroup_messages, viewGroup, false);
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
