package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomScrollView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "startX", "", "startY", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomScrollView extends ScrollView {
    public static final int $stable = 8;
    private float startX;
    private float startY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomScrollView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomScrollView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.startX = ev.getX();
            this.startY = ev.getY();
        } else if (action == 2 && Math.abs(ev.getX() - this.startX) > Math.abs(ev.getY() - this.startY)) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
