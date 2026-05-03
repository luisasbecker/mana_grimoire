package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CollectionStatusView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckCardListItemBinding implements ViewBinding {
    public final TextView cardName;
    public final ImageView chevronImage;
    public final CollectionStatusView collectionStatusView;
    public final FrameLayout commanderColorIndicatorContainer;
    public final TextView commanderColorIndicatorIcon;
    public final ImageView commanderColorIndicatorMana;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final ImageView errorImage;
    public final TextView gameChangerIcon;
    public final LinearLayout leftLayout;
    public final TextView manaCost;
    public final TextView qty;
    private final ConstraintLayout rootView;
    public final TextView selectionCheckbox;
    public final ConstraintLayout statusOrChevronContainer;

    private DeckCardListItemBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, CollectionStatusView collectionStatusView, FrameLayout frameLayout, TextView textView2, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, ImageView imageView4, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.cardName = textView;
        this.chevronImage = imageView;
        this.collectionStatusView = collectionStatusView;
        this.commanderColorIndicatorContainer = frameLayout;
        this.commanderColorIndicatorIcon = textView2;
        this.commanderColorIndicatorMana = imageView2;
        this.dotsImage = imageView3;
        this.dotsLayout = constraintLayout2;
        this.errorImage = imageView4;
        this.gameChangerIcon = textView3;
        this.leftLayout = linearLayout;
        this.manaCost = textView4;
        this.qty = textView5;
        this.selectionCheckbox = textView6;
        this.statusOrChevronContainer = constraintLayout3;
    }

    public static DeckCardListItemBinding bind(View view) {
        int i = R.id.cardName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.chevronImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.collectionStatusView;
                CollectionStatusView collectionStatusView = (CollectionStatusView) ViewBindings.findChildViewById(view, i);
                if (collectionStatusView != null) {
                    i = R.id.commanderColorIndicatorContainer;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.commanderColorIndicatorIcon;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.commanderColorIndicatorMana;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.dotsImage;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.dotsLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        i = R.id.errorImage;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = R.id.gameChangerIcon;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.leftLayout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.manaCost;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.qty;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.selectionCheckbox;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.statusOrChevronContainer;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout2 != null) {
                                                                    return new DeckCardListItemBinding((ConstraintLayout) view, textView, imageView, collectionStatusView, frameLayout, textView2, imageView2, imageView3, constraintLayout, imageView4, textView3, linearLayout, textView4, textView5, textView6, constraintLayout2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckCardListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckCardListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_card_list_item, viewGroup, false);
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
