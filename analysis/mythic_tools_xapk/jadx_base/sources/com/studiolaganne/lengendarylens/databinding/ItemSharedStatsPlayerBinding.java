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
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemSharedStatsPlayerBinding implements ViewBinding {
    public final TextView drawsValue;
    public final TextView firstname;
    public final TextView gamesCount;
    public final TextView lossesValue;
    public final ImageView noPhotoIcon;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    private final LinearLayout rootView;
    public final TextView username;
    public final TextView winrate;
    public final TextView winsValue;

    private ItemSharedStatsPlayerBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, CachedImageView cachedImageView, ConstraintLayout constraintLayout, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.drawsValue = textView;
        this.firstname = textView2;
        this.gamesCount = textView3;
        this.lossesValue = textView4;
        this.noPhotoIcon = imageView;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout;
        this.username = textView5;
        this.winrate = textView6;
        this.winsValue = textView7;
    }

    public static ItemSharedStatsPlayerBinding bind(View view) {
        int i = R.id.drawsValue;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.firstname;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.gamesCount;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.lossesValue;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.noPhotoIcon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.profileIcon;
                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                            if (cachedImageView != null) {
                                i = R.id.profileLayout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.username;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.winrate;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.winsValue;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                return new ItemSharedStatsPlayerBinding((LinearLayout) view, textView, textView2, textView3, textView4, imageView, cachedImageView, constraintLayout, textView5, textView6, textView7);
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

    public static ItemSharedStatsPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSharedStatsPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_shared_stats_player, viewGroup, false);
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
