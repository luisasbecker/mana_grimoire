package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleBottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\rJ8\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u001cR+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tRA\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e2\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "", "()V", "<set-?>", "", "backgroundBlur", "getBackgroundBlur", "()Z", "setBackgroundBlur", "(Z)V", "backgroundBlur$delegate", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.CONTENT, "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "onDismiss", "visible", "getVisible", "setVisible", "visible$delegate", "hide", "show", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleSheetState {
    public static final int $stable = 0;
    private Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: backgroundBlur$delegate, reason: from kotlin metadata */
    private final MutableState backgroundBlur = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$SimpleBottomSheetScaffoldKt.INSTANCE.m10621getLambda1$revenuecatui_defaultsBc8Release(), null, 2, null);

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final MutableState visible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    private final void setBackgroundBlur(boolean z) {
        this.backgroundBlur.setValue(Boolean.valueOf(z));
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content.setValue(function2);
    }

    private final void setVisible(boolean z) {
        this.visible.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(SimpleSheetState simpleSheetState, boolean z, Function2 function2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        simpleSheetState.show(z, function2, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ boolean getBackgroundBlur() {
        return ((Boolean) this.backgroundBlur.getValue()).booleanValue();
    }

    public final /* synthetic */ Function2 getContent() {
        return (Function2) this.content.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final void hide() {
        setBackgroundBlur(false);
        setVisible(false);
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        this.onDismiss = null;
    }

    public final void show(boolean backgroundBlur, Function2<? super Composer, ? super Integer, Unit> content, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(content, "content");
        setBackgroundBlur(backgroundBlur);
        setContent(content);
        this.onDismiss = onDismiss;
        setVisible(true);
    }
}
