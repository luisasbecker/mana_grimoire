package com.vanniktech.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidRecyclerViewExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a2\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0010"}, d2 = {"scrollToTop", "", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToBottom", "firstVisibleItemPosition", "", "itemCount", "scrollBefore", "scrollNext", "smoothScrollTo", "position", "scrollDuration", "onTargetFound", "Lkotlin/Function1;", "Landroid/view/View;", "allowNestedVerticalScrolling", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidRecyclerViewExtensionsKt {
    public static final void allowNestedVerticalScrolling(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: com.vanniktech.ui.AndroidRecyclerViewExtensionsKt.allowNestedVerticalScrolling.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                Intrinsics.checkNotNullParameter(e, "e");
                if (e.getAction() != 2) {
                    return false;
                }
                rv.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                Intrinsics.checkNotNullParameter(e, "e");
            }
        });
    }

    private static final int firstVisibleItemPosition(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof FlexboxLayoutManager) {
            return ((FlexboxLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        throw new IllegalStateException(("Unsupported Layout Manager " + layoutManager).toString());
    }

    private static final int itemCount(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public static final void scrollBefore(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        smoothScrollTo$default(recyclerView, Math.max(0, firstVisibleItemPosition(recyclerView) - 1), 0, null, 6, null);
    }

    public static final void scrollNext(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        smoothScrollTo$default(recyclerView, Math.min(itemCount(recyclerView), firstVisibleItemPosition(recyclerView) + 1), 0, null, 6, null);
    }

    public static final void scrollToBottom(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        smoothScrollTo$default(recyclerView, Math.max(0, itemCount(recyclerView) - 1), 0, null, 6, null);
    }

    public static final void scrollToTop(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        smoothScrollTo$default(recyclerView, 0, 0, null, 6, null);
    }

    public static final void smoothScrollTo(final RecyclerView recyclerView, int i, final int i2, final Function1<? super View, Unit> onTargetFound) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(onTargetFound, "onTargetFound");
        final Context context = recyclerView.getContext();
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: com.vanniktech.ui.AndroidRecyclerViewExtensionsKt$smoothScrollTo$smoothScroller$1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return i2 / recyclerView.computeVerticalScrollRange();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int getVerticalSnapPreference() {
                return -1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(action, "action");
                super.onTargetFound(targetView, state, action);
                onTargetFound.invoke(targetView);
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(linearSmoothScroller);
        }
    }

    public static /* synthetic */ void smoothScrollTo$default(RecyclerView recyclerView, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 300;
        }
        if ((i3 & 4) != 0) {
            function1 = new Function1() { // from class: com.vanniktech.ui.AndroidRecyclerViewExtensionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AndroidRecyclerViewExtensionsKt.smoothScrollTo$lambda$0((View) obj2);
                }
            };
        }
        smoothScrollTo(recyclerView, i, i2, function1);
    }

    static final Unit smoothScrollTo$lambda$0(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
