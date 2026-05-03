package com.studiolaganne.lengendarylens;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewGameFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u001a\u001e\u0010\b\u001a\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"fadeOutTogether", "", "", "Landroid/view/View;", TypedValues.TransitionType.S_DURATION, "", "onComplete", "Lkotlin/Function0;", "fadeInAndSlideDown", "delay", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NewGameFragmentKt {
    public static final void fadeInAndSlideDown(View view, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
    }

    public static /* synthetic */ void fadeInAndSlideDown$default(View view, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 250;
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        fadeInAndSlideDown(view, j, j2);
    }

    public static final void fadeOutTogether(final List<? extends View> list, long j, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((View) it.next()).animate().alpha(0.0f).setDuration(j).start();
            }
            ((View) CollectionsKt.first((List) list)).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.NewGameFragmentKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NewGameFragmentKt.fadeOutTogether$lambda$1(list, function0);
                }
            }, j);
        }
    }

    public static /* synthetic */ void fadeOutTogether$default(List list, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 250;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        fadeOutTogether(list, j, function0);
    }

    static final void fadeOutTogether$lambda$1(List list, Function0 function0) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            view.setVisibility(8);
            view.setAlpha(1.0f);
        }
        if (function0 != null) {
            function0.invoke();
        }
    }
}
