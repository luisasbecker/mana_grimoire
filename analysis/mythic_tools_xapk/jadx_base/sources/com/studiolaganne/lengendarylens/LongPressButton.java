package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LongPressButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/LongPressButton;", "Lcom/google/android/material/button/MaterialButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customClickListener", "Lkotlin/Function0;", "", "incrementRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "increaseOnLongPress", "", "setCustomClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startIncrementRunnable", "stopIncrementRunnable", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LongPressButton extends MaterialButton {
    private static final long LONG_PRESS_INITIAL_DELAY = 250;
    private static final long LONG_PRESS_REPEAT_DELAY = 80;
    private Function0<Unit> customClickListener;
    private Handler handler;
    private boolean increaseOnLongPress;
    private Runnable incrementRunnable;
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongPressButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongPressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongPressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.LongPressButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LongPressButton._init_$lambda$0(this.f$0, view, motionEvent);
            }
        });
    }

    public /* synthetic */ LongPressButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    static final boolean _init_$lambda$0(LongPressButton longPressButton, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            longPressButton.startIncrementRunnable();
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        longPressButton.stopIncrementRunnable();
        return false;
    }

    private final void startIncrementRunnable() {
        Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.LongPressButton$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LongPressButton.startIncrementRunnable$lambda$0(this.f$0);
            }
        };
        this.incrementRunnable = runnable;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 250L);
    }

    static final void startIncrementRunnable$lambda$0(LongPressButton longPressButton) {
        Runnable runnable;
        if (longPressButton.isAttachedToWindow()) {
            longPressButton.increaseOnLongPress = true;
            Function0<Unit> function0 = longPressButton.customClickListener;
            if (function0 != null) {
                function0.invoke();
            }
            Handler handler = longPressButton.handler;
            if (handler == null || (runnable = longPressButton.incrementRunnable) == null) {
                return;
            }
            handler.postDelayed(runnable, LONG_PRESS_REPEAT_DELAY);
        }
    }

    private final void stopIncrementRunnable() {
        Function0<Unit> function0;
        Runnable runnable = this.incrementRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            if (!this.increaseOnLongPress && (function0 = this.customClickListener) != null) {
                function0.invoke();
            }
            this.increaseOnLongPress = false;
            this.incrementRunnable = null;
        }
    }

    public final void setCustomClickListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.customClickListener = listener;
    }
}
