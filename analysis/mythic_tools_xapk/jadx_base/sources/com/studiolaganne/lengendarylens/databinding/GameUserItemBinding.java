package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class GameUserItemBinding implements ViewBinding {
    public final LinearLayout nameLayout;
    public final ImageView noPhotoIcon;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final CheckBox selectedCheckBox;
    public final TextView userFirstName;
    public final LinearLayout userLayout;
    public final TextView userName;
    public final TextView youBox;

    private GameUserItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, CachedImageView cachedImageView, ConstraintLayout constraintLayout, LinearLayout linearLayout3, CheckBox checkBox, TextView textView, LinearLayout linearLayout4, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.nameLayout = linearLayout2;
        this.noPhotoIcon = imageView;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout;
        this.rootLayout = linearLayout3;
        this.selectedCheckBox = checkBox;
        this.userFirstName = textView;
        this.userLayout = linearLayout4;
        this.userName = textView2;
        this.youBox = textView3;
    }

    public static GameUserItemBinding bind(View view) {
        int i = R.id.name_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.no_photo_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.profile_icon;
                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                if (cachedImageView != null) {
                    i = R.id.profileLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view;
                        i = R.id.selectedCheckBox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                        if (checkBox != null) {
                            i = R.id.userFirstName;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.user_layout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.userName;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.youBox;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            return new GameUserItemBinding(linearLayout2, linearLayout, imageView, cachedImageView, constraintLayout, linearLayout2, checkBox, textView, linearLayout3, textView2, textView3);
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

    public static GameUserItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GameUserItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.game_user_item, viewGroup, false);
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
