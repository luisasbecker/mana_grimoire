package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.NonInteractiveRecyclerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class GameEventItemBinding implements ViewBinding {
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final TextView line1Text;
    public final TextView line2Text;
    public final LinearLayout mainEventLayout;
    public final LinearLayout mainLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final LinearLayout separatorLayout;
    public final View separatorLine;
    public final View separatorSpacer;
    public final TextView separatorTextEnd;
    public final TextView separatorTextStart;
    public final TextView timeLabel;
    public final ImageView typeIcon;
    public final LinearLayout userLayout;
    public final NonInteractiveRecyclerView usersRecyclerView;
    public final TextView valueLabel;

    private GameEventItemBinding(LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, View view, View view2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView2, LinearLayout linearLayout6, NonInteractiveRecyclerView nonInteractiveRecyclerView, TextView textView6) {
        this.rootView = linearLayout;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout;
        this.line1Text = textView;
        this.line2Text = textView2;
        this.mainEventLayout = linearLayout2;
        this.mainLayout = linearLayout3;
        this.rootLayout = linearLayout4;
        this.separatorLayout = linearLayout5;
        this.separatorLine = view;
        this.separatorSpacer = view2;
        this.separatorTextEnd = textView3;
        this.separatorTextStart = textView4;
        this.timeLabel = textView5;
        this.typeIcon = imageView2;
        this.userLayout = linearLayout6;
        this.usersRecyclerView = nonInteractiveRecyclerView;
        this.valueLabel = textView6;
    }

    public static GameEventItemBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.dotsImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.dotsLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.line1Text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.line2Text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.main_event_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view;
                            i = R.id.root_layout;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = R.id.separator_layout;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separatorLine))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separatorSpacer))) != null) {
                                    i = R.id.separatorTextEnd;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.separatorTextStart;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.timeLabel;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.typeIcon;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView2 != null) {
                                                    i = R.id.user_layout;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.usersRecyclerView;
                                                        NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                        if (nonInteractiveRecyclerView != null) {
                                                            i = R.id.valueLabel;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                return new GameEventItemBinding(linearLayout2, imageView, constraintLayout, textView, textView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, viewFindChildViewById, viewFindChildViewById2, textView3, textView4, textView5, imageView2, linearLayout5, nonInteractiveRecyclerView, textView6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static GameEventItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GameEventItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.game_event_item, viewGroup, false);
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
