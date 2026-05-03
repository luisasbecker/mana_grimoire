package com.studiolaganne.lengendarylens;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckErrorPopupManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\u0014\u0010\u0017\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0012H\u0002J\u0006\u0010\"\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckErrorPopupManager;", "", "activity", "Lcom/studiolaganne/lengendarylens/DeckDetailsActivity;", "anchorView", "Landroid/view/View;", "<init>", "(Lcom/studiolaganne/lengendarylens/DeckDetailsActivity;Landroid/view/View;)V", "overlayView", "errorPopupLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "errorMessagesContainer", "Landroid/widget/LinearLayout;", "isShowing", "", "errorTranslator", "Lcom/studiolaganne/lengendarylens/DeckErrorTranslator;", "showErrorPopup", "", "errors", "", "Lcom/studiolaganne/lengendarylens/MTListError;", "hideErrorPopup", "toggleErrorPopup", "createErrorPopup", "addErrorMessage", "error", "createErrorItemView", "dpToPx", "", "dp", "context", "Landroid/content/Context;", "positionAndShowPopup", "cleanup", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckErrorPopupManager {
    public static final int $stable = 8;
    private final DeckDetailsActivity activity;
    private final View anchorView;
    private LinearLayout errorMessagesContainer;
    private ConstraintLayout errorPopupLayout;
    private final DeckErrorTranslator errorTranslator;
    private boolean isShowing;
    private View overlayView;

    public DeckErrorPopupManager(DeckDetailsActivity activity, View anchorView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        this.activity = activity;
        this.anchorView = anchorView;
        this.errorTranslator = new DeckErrorTranslator(activity);
    }

    private final void addErrorMessage(MTListError error) {
        View viewCreateErrorItemView = createErrorItemView(error);
        LinearLayout linearLayout = this.errorMessagesContainer;
        if (linearLayout != null) {
            linearLayout.addView(viewCreateErrorItemView);
        }
    }

    private final View createErrorItemView(MTListError error) {
        View viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.deck_error_item, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.errorBulletPoint);
        TextView textView = (TextView) viewInflate.findViewById(R.id.errorText);
        imageView.setColorFilter(ContextCompat.getColor(this.activity, R.color.error_red));
        textView.setText(this.errorTranslator.translateErrorSmart(error));
        textView.setTextColor(ContextCompat.getColor(this.activity, R.color.error_popup_text));
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    private final void createErrorPopup() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.activity);
        ViewGroup viewGroup = (ViewGroup) this.activity.findViewById(android.R.id.content);
        View view = new View(this.activity);
        view.setBackgroundColor(ContextCompat.getColor(this.activity, android.R.color.black));
        view.setAlpha(0.3f);
        view.setVisibility(8);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckErrorPopupManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.hideErrorPopup();
            }
        });
        this.overlayView = view;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.deck_error_popup, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        this.errorPopupLayout = constraintLayout;
        Intrinsics.checkNotNull(constraintLayout);
        this.errorMessagesContainer = (LinearLayout) constraintLayout.findViewById(R.id.errorMessagesContainer);
        ConstraintLayout constraintLayout2 = this.errorPopupLayout;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckErrorPopupManager$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.hideErrorPopup();
                }
            });
        }
        viewGroup.addView(this.overlayView);
        viewGroup.addView(this.errorPopupLayout);
    }

    private final void positionAndShowPopup() {
        View view;
        ConstraintLayout constraintLayout = this.errorPopupLayout;
        if (constraintLayout == null || (view = this.overlayView) == null) {
            return;
        }
        constraintLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int[] iArr = new int[2];
        this.anchorView.getLocationOnScreen(iArr);
        int i = this.activity.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.activity.getResources().getDisplayMetrics().heightPixels;
        int measuredWidth = constraintLayout.getMeasuredWidth();
        int measuredHeight = constraintLayout.getMeasuredHeight() + dpToPx(20, this.activity);
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
        this.errorMessagesContainer = null;
        this.isShowing = false;
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
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

    public final void showErrorPopup(List<MTListError> errors) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        if (errors.isEmpty()) {
            return;
        }
        if (this.errorPopupLayout == null) {
            createErrorPopup();
        }
        LinearLayout linearLayout = this.errorMessagesContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        Iterator<T> it = errors.iterator();
        while (it.hasNext()) {
            addErrorMessage((MTListError) it.next());
        }
        positionAndShowPopup();
    }

    public final void toggleErrorPopup(List<MTListError> errors) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        if (this.isShowing) {
            hideErrorPopup();
        } else {
            showErrorPopup(errors);
        }
    }
}
