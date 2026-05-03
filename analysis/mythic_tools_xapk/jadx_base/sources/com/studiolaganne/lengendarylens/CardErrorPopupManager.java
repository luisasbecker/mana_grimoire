package com.studiolaganne.lengendarylens;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardErrorPopupManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0011J$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u0011H\u0002J \u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0006\u0010\"\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardErrorPopupManager;", "", "activity", "Lcom/studiolaganne/lengendarylens/DeckDetailsActivity;", "<init>", "(Lcom/studiolaganne/lengendarylens/DeckDetailsActivity;)V", "overlayView", "Landroid/view/View;", "errorPopupLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "errorText", "Landroid/widget/TextView;", "isShowing", "", "errorTranslator", "Lcom/studiolaganne/lengendarylens/DeckErrorTranslator;", "showCardErrorPopup", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "errors", "", "Lcom/studiolaganne/lengendarylens/MTListError;", "anchorView", "hideErrorPopup", "toggleCardErrorPopup", "createErrorPopup", "findCardError", "dpToPx", "", "dp", "context", "Landroid/content/Context;", "positionAndShowPopup", "cleanup", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardErrorPopupManager {
    public static final int $stable = 8;
    private final DeckDetailsActivity activity;
    private ConstraintLayout errorPopupLayout;
    private TextView errorText;
    private final DeckErrorTranslator errorTranslator;
    private boolean isShowing;
    private View overlayView;

    public CardErrorPopupManager(DeckDetailsActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.errorTranslator = new DeckErrorTranslator(activity);
    }

    private final void createErrorPopup() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.activity);
        ViewGroup viewGroup = (ViewGroup) this.activity.findViewById(android.R.id.content);
        View view = new View(this.activity);
        view.setBackgroundColor(ContextCompat.getColor(this.activity, android.R.color.black));
        view.setAlpha(0.3f);
        view.setVisibility(8);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardErrorPopupManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.hideErrorPopup();
            }
        });
        this.overlayView = view;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.card_error_popup, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        this.errorPopupLayout = constraintLayout;
        Intrinsics.checkNotNull(constraintLayout);
        this.errorText = (TextView) constraintLayout.findViewById(R.id.cardErrorText);
        ConstraintLayout constraintLayout2 = this.errorPopupLayout;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardErrorPopupManager$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.hideErrorPopup();
                }
            });
        }
        viewGroup.addView(this.overlayView);
        viewGroup.addView(this.errorPopupLayout);
    }

    private final int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private final MTListError findCardError(MTFullCard card, List<MTListError> errors) {
        Object next;
        Iterator<T> it = errors.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            List<String> problematic_cards = ((MTListError) next).getProblematic_cards();
            if (problematic_cards != null && CollectionsKt.contains(problematic_cards, card.getCardid())) {
                break;
            }
        }
        return (MTListError) next;
    }

    private final void positionAndShowPopup(View anchorView) {
        View view;
        ConstraintLayout constraintLayout = this.errorPopupLayout;
        if (constraintLayout == null || (view = this.overlayView) == null) {
            return;
        }
        constraintLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int[] iArr = new int[2];
        anchorView.getLocationOnScreen(iArr);
        int i = this.activity.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.activity.getResources().getDisplayMetrics().heightPixels;
        int measuredWidth = constraintLayout.getMeasuredWidth();
        int measuredHeight = constraintLayout.getMeasuredHeight();
        int iDpToPx = dpToPx(20, this.activity);
        int iMin = Math.min(measuredWidth, i - (iDpToPx * 2));
        int iMax = Math.max(iDpToPx, Math.min((iArr[1] - measuredHeight) - dpToPx(20, this.activity), (i2 - measuredHeight) - iDpToPx));
        constraintLayout.setX((i - iMin) / 2);
        constraintLayout.setY(iMax);
        constraintLayout.setLayoutParams(new FrameLayout.LayoutParams(iMin, measuredHeight));
        view.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        constraintLayout.setAlpha(0.0f);
        constraintLayout.setVisibility(0);
        view.setAlpha(0.0f);
        view.setVisibility(0);
        this.isShowing = true;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat2.setDuration(200L);
        objectAnimatorOfFloat.start();
        objectAnimatorOfFloat2.start();
    }

    public final void cleanup() {
        ViewGroup viewGroup = (ViewGroup) this.activity.findViewById(android.R.id.content);
        ConstraintLayout constraintLayout = this.errorPopupLayout;
        if (constraintLayout != null) {
            viewGroup.removeView(constraintLayout);
        }
        View view = this.overlayView;
        if (view != null) {
            viewGroup.removeView(view);
        }
        this.errorPopupLayout = null;
        this.overlayView = null;
        this.errorText = null;
        this.isShowing = false;
    }

    public final void hideErrorPopup() {
        ConstraintLayout constraintLayout;
        View view;
        if (!this.isShowing || (constraintLayout = this.errorPopupLayout) == null || (view = this.overlayView) == null) {
            return;
        }
        constraintLayout.setVisibility(8);
        view.setVisibility(8);
        this.isShowing = false;
    }

    public final void showCardErrorPopup(MTFullCard card, List<MTListError> errors, View anchorView) {
        MTListError mTListErrorFindCardError;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        if (errors.isEmpty() || (mTListErrorFindCardError = findCardError(card, errors)) == null) {
            return;
        }
        if (this.errorPopupLayout == null) {
            createErrorPopup();
        }
        String strTranslateErrorSmart = this.errorTranslator.translateErrorSmart(mTListErrorFindCardError);
        TextView textView = this.errorText;
        if (textView != null) {
            textView.setText(strTranslateErrorSmart);
        }
        positionAndShowPopup(anchorView);
    }

    public final void toggleCardErrorPopup(MTFullCard card, List<MTListError> errors, View anchorView) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        if (this.isShowing) {
            hideErrorPopup();
        } else {
            showCardErrorPopup(card, errors, anchorView);
        }
    }
}
