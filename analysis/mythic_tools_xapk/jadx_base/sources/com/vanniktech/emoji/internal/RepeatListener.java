package com.vanniktech.emoji.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepeatListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vanniktech/emoji/internal/RepeatListener;", "Landroid/view/View$OnTouchListener;", "initialInterval", "", "normalInterval", "clickListener", "Landroid/view/View$OnClickListener;", "<init>", "(JJLandroid/view/View$OnClickListener;)V", "handler", "Landroid/os/Handler;", "downView", "Landroid/view/View;", "handlerRunnable", "Ljava/lang/Runnable;", "onTouch", "", ViewHierarchyConstants.VIEW_KEY, "motionEvent", "Landroid/view/MotionEvent;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RepeatListener implements View.OnTouchListener {
    private final View.OnClickListener clickListener;
    private View downView;
    private final Handler handler;
    private final Runnable handlerRunnable;
    private final long initialInterval;
    private final long normalInterval;

    public RepeatListener(long j, long j2, View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.initialInterval = j;
        this.normalInterval = j2;
        this.clickListener = clickListener;
        this.handler = new Handler(Looper.getMainLooper());
        this.handlerRunnable = new Runnable() { // from class: com.vanniktech.emoji.internal.RepeatListener$handlerRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.downView != null) {
                    this.this$0.handler.removeCallbacksAndMessages(this.this$0.downView);
                    this.this$0.handler.postAtTime(this, this.this$0.downView, SystemClock.uptimeMillis() + this.this$0.normalInterval);
                    this.this$0.clickListener.onClick(this.this$0.downView);
                }
            }
        };
        if (j < 0 || j2 < 0) {
            throw new IllegalArgumentException("negative interval".toString());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.handler.removeCallbacks(this.handlerRunnable);
            this.handler.postAtTime(this.handlerRunnable, this.downView, SystemClock.uptimeMillis() + this.initialInterval);
            this.downView = view;
            if (view != null) {
                view.setPressed(true);
            }
            this.clickListener.onClick(view);
            return true;
        }
        if (action != 1 && action != 3 && action != 4) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(this.downView);
        View view2 = this.downView;
        if (view2 != null) {
            view2.setPressed(false);
        }
        this.downView = null;
        return true;
    }
}
