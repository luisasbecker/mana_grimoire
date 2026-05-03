package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material.DrawerState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J$\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0087@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u001fJ\r\u0010'\u001a\u00020\u001cH\u0000¢\u0006\u0002\b(J\b\u0010/\u001a\u00020*H\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0012R\u001a\u0010#\u001a\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Landroidx/compose/material/DrawerState;", "", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "isOpen", "()Z", "isClosed", "currentValue", "getCurrentValue", "()Landroidx/compose/material/DrawerValue;", "isAnimationRunning", "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "animateTo", "targetValue", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Landroidx/compose/material/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTargetValue$annotations", "()V", "getTargetValue", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset$annotations", "getOffset", "()F", "requireOffset", "requireOffset$material", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "requireDensity", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawerState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState<DrawerValue> anchoredDraggableState;
    private Density density;

    /* JADX INFO: compiled from: Drawer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/DrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DrawerState;", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static final DrawerState Saver$lambda$1(Function1 function1, DrawerValue drawerValue) {
            return new DrawerState(drawerValue, function1);
        }

        public final Saver<DrawerState, DrawerValue> Saver(final Function1<? super DrawerValue, Boolean> confirmStateChange) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.DrawerState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ((DrawerState) obj2).getCurrentValue();
                }
            }, new Function1() { // from class: androidx.compose.material.DrawerState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DrawerState.Companion.Saver$lambda$1(confirmStateChange, (DrawerValue) obj);
                }
            });
        }
    }

    public DrawerState(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1) {
        this.anchoredDraggableState = new AnchoredDraggableState<>(drawerValue, new Function1() { // from class: androidx.compose.material.DrawerState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DrawerState drawerState = this.f$0;
                ((Float) obj).floatValue();
                return Float.valueOf(drawerState.requireDensity().mo1624toPx0680j_4(DrawerKt.DrawerPositionalThreshold));
            }
        }, new Function0() { // from class: androidx.compose.material.DrawerState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(this.f$0.requireDensity().mo1624toPx0680j_4(DrawerKt.DrawerVelocityThreshold));
            }
        }, DrawerKt.AnimationSpec, function1);
    }

    public /* synthetic */ DrawerState(DrawerValue drawerValue, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawerValue, (i & 2) != 0 ? new Function1() { // from class: androidx.compose.material.DrawerState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DrawerState._init_$lambda$0((DrawerValue) obj));
            }
        } : function1);
    }

    static final boolean _init_$lambda$0(DrawerValue drawerValue) {
        return true;
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the Drawer composable?").toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.")
    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, drawerValue, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Closed, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final AnchoredDraggableState<DrawerValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final DrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    /* JADX INFO: renamed from: getDensity$material, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final DrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        return getCurrentValue() == DrawerValue.Closed;
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    public final Object open(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Open, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material(Density density) {
        this.density = density;
    }

    public final Object snapTo(DrawerValue drawerValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, drawerValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }
}
