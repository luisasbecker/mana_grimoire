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
import com.studiolaganne.lengendarylens.LoadingImageViewDeck;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class GamePlayerResultItemBinding implements ViewBinding {
    public final LoadingImageViewDeck deckImage;
    public final TextView deckName;
    public final TextView editIconTextView;
    public final TextView firstnameTextView;
    public final LinearLayout leftContainer;
    public final LinearLayout leftLayout;
    public final LinearLayout mainLayout;
    public final ImageView noPhotoIconSummary;
    public final CachedImageView profileIconSummary;
    public final ConstraintLayout profileLayoutSummary;
    public final TextView resultTextView;
    public final ConstraintLayout rootLayout;
    public final ConstraintLayout rootLineLayout;
    private final ConstraintLayout rootView;
    public final View spacer;
    public final LinearLayout userLayout;
    public final TextView usernameTextView;

    private GamePlayerResultItemBinding(ConstraintLayout constraintLayout, LoadingImageViewDeck loadingImageViewDeck, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, CachedImageView cachedImageView, ConstraintLayout constraintLayout2, TextView textView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, View view, LinearLayout linearLayout4, TextView textView5) {
        this.rootView = constraintLayout;
        this.deckImage = loadingImageViewDeck;
        this.deckName = textView;
        this.editIconTextView = textView2;
        this.firstnameTextView = textView3;
        this.leftContainer = linearLayout;
        this.leftLayout = linearLayout2;
        this.mainLayout = linearLayout3;
        this.noPhotoIconSummary = imageView;
        this.profileIconSummary = cachedImageView;
        this.profileLayoutSummary = constraintLayout2;
        this.resultTextView = textView4;
        this.rootLayout = constraintLayout3;
        this.rootLineLayout = constraintLayout4;
        this.spacer = view;
        this.userLayout = linearLayout4;
        this.usernameTextView = textView5;
    }

    public static GamePlayerResultItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.deckImage;
        LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
        if (loadingImageViewDeck != null) {
            i = R.id.deckName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.editIconTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.firstnameTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.leftContainer;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.leftLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.mainLayout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.noPhotoIconSummary;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.profileIconSummary;
                                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                        if (cachedImageView != null) {
                                            i = R.id.profileLayoutSummary;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout != null) {
                                                i = R.id.resultTextView;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                                    i = R.id.rootLineLayout;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.spacer))) != null) {
                                                        i = R.id.userLayout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.usernameTextView;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                return new GamePlayerResultItemBinding(constraintLayout2, loadingImageViewDeck, textView, textView2, textView3, linearLayout, linearLayout2, linearLayout3, imageView, cachedImageView, constraintLayout, textView4, constraintLayout2, constraintLayout3, viewFindChildViewById, linearLayout4, textView5);
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

    public static GamePlayerResultItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GamePlayerResultItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.game_player_result_item, viewGroup, false);
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
