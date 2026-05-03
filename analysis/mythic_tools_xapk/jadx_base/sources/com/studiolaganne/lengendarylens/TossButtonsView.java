package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TossButtonsView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/TossButtonsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rerollButtonLayout", "doneButtonLayout", "setupViews", "", "setOnRerollClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setOnDoneClickListener", "setCustomRotation", "degrees", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TossButtonsView extends ConstraintLayout {
    public static final int $stable = 8;
    private ConstraintLayout doneButtonLayout;
    private ConstraintLayout rerollButtonLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TossButtonsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TossButtonsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TossButtonsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.inflate(context, R.layout.custom_toss_buttons_layout, this);
        setupViews();
    }

    public /* synthetic */ TossButtonsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    static final Unit setOnDoneClickListener$lambda$0(View.OnClickListener onClickListener, TossButtonsView tossButtonsView) {
        ConstraintLayout constraintLayout = tossButtonsView.doneButtonLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButtonLayout");
            constraintLayout = null;
        }
        onClickListener.onClick(constraintLayout);
        return Unit.INSTANCE;
    }

    static final Unit setOnRerollClickListener$lambda$0(View.OnClickListener onClickListener, TossButtonsView tossButtonsView) {
        ConstraintLayout constraintLayout = tossButtonsView.rerollButtonLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rerollButtonLayout");
            constraintLayout = null;
        }
        onClickListener.onClick(constraintLayout);
        return Unit.INSTANCE;
    }

    private final void setupViews() {
        View viewFindViewById = findViewById(R.id.rerollButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rerollButtonLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.doneButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.doneButtonLayout = (ConstraintLayout) viewFindViewById2;
    }

    public final void setCustomRotation(float degrees) {
        setRotation(degrees);
    }

    public final void setOnDoneClickListener(final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConstraintLayout constraintLayout = this.doneButtonLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButtonLayout");
            constraintLayout = null;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.TossButtonsView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TossButtonsView.setOnDoneClickListener$lambda$0(listener, this);
            }
        });
    }

    public final void setOnRerollClickListener(final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConstraintLayout constraintLayout = this.rerollButtonLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rerollButtonLayout");
            constraintLayout = null;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.TossButtonsView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TossButtonsView.setOnRerollClickListener$lambda$0(listener, this);
            }
        });
    }
}
