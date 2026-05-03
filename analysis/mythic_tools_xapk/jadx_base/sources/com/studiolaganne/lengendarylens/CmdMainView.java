package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CmdMainView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0007J\u0010\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/CmdMainView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/studiolaganne/lengendarylens/CmdMainViewCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/CmdMainViewCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/CmdMainViewCallback;)V", "backgroundImage", "Landroid/widget/ImageView;", "overlay", "Landroid/view/View;", "internalRotation", "innerLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "closeLayout", "Landroid/widget/LinearLayout;", "closeImage", "cmdImage", "ownCmdLayout", "ownCmdText", "Landroid/widget/TextView;", "disabled", "", "disableInput", "", "dpToPx", "dp", "updateOwnCmdDamage", "damage", "setRotation", Key.ROTATION, "setState", "playmatImage", "Landroid/graphics/drawable/Drawable;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CmdMainView extends CardView {
    public static final int $stable = 8;
    private ImageView backgroundImage;
    private CmdMainViewCallback callback;
    private ImageView closeImage;
    private LinearLayout closeLayout;
    private ImageView cmdImage;
    private boolean disabled;
    private ConstraintLayout innerLayout;
    private int internalRotation;
    private View overlay;
    private ConstraintLayout ownCmdLayout;
    private TextView ownCmdText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CmdMainView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CmdMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CmdMainView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.internalRotation = 0;
        CardView.inflate(context, R.layout.cmd_damage_main_view, this);
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        View viewFindViewById = findViewById(R.id.commander_damage_main_inner_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.innerLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.closeLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.closeLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.closeImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById3;
        this.closeImage = imageView;
        imageView.setRotation(45.0f);
        View viewFindViewById4 = findViewById(R.id.card_background_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.backgroundImage = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.overlay = viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.cmdIconImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.cmdImage = (ImageView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.ownCmdLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.ownCmdLayout = (ConstraintLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.ownCmdDamageTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.ownCmdText = (TextView) viewFindViewById8;
        ViewExtensionsKt.setOnClickWithFade(this.closeLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CmdMainView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CmdMainView._init_$lambda$0(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.ownCmdLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CmdMainView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CmdMainView._init_$lambda$1(this.f$0);
            }
        });
    }

    public /* synthetic */ CmdMainView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    static final Unit _init_$lambda$0(CmdMainView cmdMainView) {
        if (cmdMainView.disabled) {
            return Unit.INSTANCE;
        }
        CmdMainViewCallback cmdMainViewCallback = cmdMainView.callback;
        if (cmdMainViewCallback != null) {
            cmdMainViewCallback.cmdMainViewClosed();
        }
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$1(CmdMainView cmdMainView) {
        if (cmdMainView.disabled) {
            return Unit.INSTANCE;
        }
        CmdMainViewCallback cmdMainViewCallback = cmdMainView.callback;
        if (cmdMainViewCallback != null) {
            cmdMainViewCallback.cmdMainViewOwnCmdTapped();
        }
        return Unit.INSTANCE;
    }

    public final void disableInput() {
        this.disabled = true;
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public final CmdMainViewCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(CmdMainViewCallback cmdMainViewCallback) {
        this.callback = cmdMainViewCallback;
    }

    public final void setRotation(int rotation) {
        this.internalRotation = rotation;
        this.innerLayout.setRotation(rotation);
        this.cmdImage.setRotation(this.internalRotation);
        this.ownCmdLayout.setRotation(this.internalRotation);
        int i = this.internalRotation;
        if (i == 90) {
            ViewGroup.LayoutParams layoutParams = this.cmdImage.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            layoutParams2.leftMargin = -dpToPx(20, context);
            layoutParams2.bottomMargin = 0;
            layoutParams2.rightMargin = 0;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            layoutParams2.topMargin = -dpToPx(40, context2);
            layoutParams2.removeRule(12);
            layoutParams2.addRule(10);
            this.cmdImage.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.ownCmdLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.removeRule(21);
            layoutParams4.addRule(20);
            this.ownCmdLayout.setLayoutParams(layoutParams4);
        } else if (i == 180) {
            ViewGroup.LayoutParams layoutParams5 = this.cmdImage.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.leftMargin = 0;
            layoutParams6.bottomMargin = 0;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            layoutParams6.rightMargin = -dpToPx(40, context3);
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            layoutParams6.topMargin = -dpToPx(20, context4);
            layoutParams6.removeRule(9);
            layoutParams6.removeRule(12);
            layoutParams6.addRule(11);
            layoutParams6.addRule(10);
            this.cmdImage.setLayoutParams(layoutParams6);
            ViewGroup.LayoutParams layoutParams7 = this.ownCmdLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
            layoutParams8.removeRule(21);
            layoutParams8.addRule(20);
            layoutParams8.removeRule(12);
            layoutParams8.addRule(10);
            this.ownCmdLayout.setLayoutParams(layoutParams8);
        } else if (i == 270) {
            ViewGroup.LayoutParams layoutParams9 = this.cmdImage.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
            layoutParams10.leftMargin = 0;
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            layoutParams10.bottomMargin = -dpToPx(40, context5);
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            layoutParams10.rightMargin = -dpToPx(20, context6);
            layoutParams10.topMargin = 0;
            layoutParams10.removeRule(9);
            layoutParams10.addRule(11);
            this.cmdImage.setLayoutParams(layoutParams10);
            ViewGroup.LayoutParams layoutParams11 = this.ownCmdLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
            layoutParams12.removeRule(12);
            layoutParams12.addRule(10);
            this.ownCmdLayout.setLayoutParams(layoutParams12);
        }
        requestLayout();
    }

    public final void setState(Drawable playmatImage) {
        ImageView imageView = this.backgroundImage;
        if (playmatImage == null) {
            imageView.setVisibility(8);
            this.overlay.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            this.overlay.setVisibility(0);
            this.backgroundImage.setImageDrawable(playmatImage);
        }
    }

    public final void updateOwnCmdDamage(int damage) {
        this.ownCmdText.setText(String.valueOf(damage));
    }
}
