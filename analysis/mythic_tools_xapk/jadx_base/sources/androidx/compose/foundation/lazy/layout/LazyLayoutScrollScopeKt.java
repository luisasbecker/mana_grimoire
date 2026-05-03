package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyLayoutScrollScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a2\u0010\u0010\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"TargetDistance", "Landroidx/compose/ui/unit/Dp;", "F", "BoundDistance", "MinimumDistance", "DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "isItemVisible", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", FirebaseAnalytics.Param.INDEX, "", "animateScrollToItem", "scrollOffset", "numOfItemsForTeleport", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutScrollScopeKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m9114constructorimpl(2500.0f);
    private static final float BoundDistance = Dp.m9114constructorimpl(1500.0f);
    private static final float MinimumDistance = Dp.m9114constructorimpl(50.0f);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutScrollScope.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt", f = "LazyLayoutScrollScope.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {177, 264}, m = "animateScrollToItem", n = {"$this$animateScrollToItem", "loop", "anim", "loops", FirebaseAnalytics.Param.INDEX, "scrollOffset", "numOfItemsForTeleport", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$animateScrollToItem", FirebaseAnalytics.Param.INDEX, "scrollOffset"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "F$0", "F$1", "F$2", "I$3", "L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyLayoutScrollScopeKt.animateScrollToItem(null, 0, 0, 0, null, this);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:(1:(2:39|40))|(1:(17:50|53|(1:55)(1:56)|57|(1:59)(1:60)|61|62|119|63|64|111|65|66|113|67|(8:70|18|125|71|72|115|35|(4:37|39|40|(0)(4:42|123|43|(1:46))))|102)(1:51))(0)|52|53|(0)(0)|57|(0)(0)|61|62|119|63|64|111|65|66|113|67|(0)|102) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01da, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01db, code lost:
    
        r21 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb A[Catch: ItemFoundInScroll -> 0x01e8, TryCatch #4 {ItemFoundInScroll -> 0x01e8, blocks: (B:35:0x00e7, B:37:0x00eb, B:39:0x00f1, B:53:0x0120, B:57:0x015c, B:61:0x0164), top: B:115:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024c  */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Type inference failed for: r8v16, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x01b4 -> B:18:0x0073). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateScrollToItem(LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2, int i3, Density density, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        float f;
        final LazyLayoutScrollScope lazyLayoutScrollScope2;
        int i4;
        int i5;
        int i6;
        float fMo1624toPx0680j_4;
        float fMo1624toPx0680j_42;
        float fMo1624toPx0680j_43;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        final int i7;
        final int i8;
        final float f2;
        final Ref.IntRef intRef;
        float f3;
        AnonymousClass1 anonymousClass12;
        float f4;
        int i9;
        int i10;
        LazyLayoutScrollScope lazyLayoutScrollScope3;
        AnimationState animationStateCopy$default;
        Float fBoxFloat;
        int i11;
        Function1 function1;
        LazyLayoutScrollScope lazyLayoutScrollScope4;
        int i12;
        int i13;
        AnonymousClass1 anonymousClass13;
        int iCalculateDistanceTo$default;
        float fMax;
        final float f5;
        AnimationState animationState;
        Float fBoxFloat2;
        boolean z;
        Function1 function12;
        final LazyLayoutScrollScope lazyLayoutScrollScope5;
        final int i14;
        int i15;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = anonymousClass1.label;
        int i17 = 0;
        int i18 = 1;
        if (i16 == 0) {
            f = 0.0f;
            ResultKt.throwOnFailure(obj);
            if (!(((float) i) >= 0.0f)) {
                InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
            }
            try {
                fMo1624toPx0680j_4 = density.mo1624toPx0680j_4(TargetDistance);
                fMo1624toPx0680j_42 = density.mo1624toPx0680j_4(BoundDistance);
                fMo1624toPx0680j_43 = density.mo1624toPx0680j_4(MinimumDistance);
                booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                objectRef = new Ref.ObjectRef();
                objectRef.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
            } catch (ItemFoundInScroll e) {
                e = e;
                lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                i4 = 0;
            }
            if (isItemVisible(lazyLayoutScrollScope, i)) {
                lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                i4 = 0;
                try {
                    throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope2, i, 0, 2, null), (AnimationState) objectRef.element);
                } catch (ItemFoundInScroll e2) {
                    e = e2;
                    i5 = i2;
                    i6 = i;
                    animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final float itemOffset = e.getItemOffset() + i5;
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    fBoxFloat = Boxing.boxFloat(itemOffset);
                    if (((Number) animationStateCopy$default.getVelocity()).floatValue() == f) {
                    }
                    function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset, floatRef, lazyLayoutScrollScope2, (AnimationScope) obj2);
                        }
                    };
                    anonymousClass1.L$0 = lazyLayoutScrollScope2;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.I$1 = i5;
                    anonymousClass1.label = 2;
                    if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            }
            try {
                int i19 = i > lazyLayoutScrollScope.getFirstVisibleItemIndex() ? 1 : 0;
                Ref.IntRef intRef2 = new Ref.IntRef();
                intRef2.element = 1;
                i7 = i2;
                i8 = i3;
                f2 = fMo1624toPx0680j_42;
                intRef = intRef2;
                f3 = fMo1624toPx0680j_4;
                anonymousClass12 = anonymousClass1;
                f4 = fMo1624toPx0680j_43;
                i9 = i;
                i10 = i19;
                lazyLayoutScrollScope3 = lazyLayoutScrollScope;
                if (booleanRef.element) {
                }
            } catch (ItemFoundInScroll e3) {
                e = e3;
                lazyLayoutScrollScope2 = lazyLayoutScrollScope;
                i5 = i2;
                i6 = i;
                i4 = 0;
                animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                final float itemOffset2 = e.getItemOffset() + i5;
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                fBoxFloat = Boxing.boxFloat(itemOffset2);
                if (((Number) animationStateCopy$default.getVelocity()).floatValue() == f) {
                }
                function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset2, floatRef2, lazyLayoutScrollScope2, (AnimationScope) obj2);
                    }
                };
                anonymousClass1.L$0 = lazyLayoutScrollScope2;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.L$3 = null;
                anonymousClass1.I$0 = i6;
                anonymousClass1.I$1 = i5;
                anonymousClass1.label = 2;
                if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i16 != 1) {
            if (i16 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i12 = anonymousClass1.I$1;
            i13 = anonymousClass1.I$0;
            lazyLayoutScrollScope4 = (LazyLayoutScrollScope) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            lazyLayoutScrollScope4.snapToItem(i13, i12);
            return Unit.INSTANCE;
        }
        i10 = anonymousClass1.I$3;
        float f6 = anonymousClass1.F$2;
        float f7 = anonymousClass1.F$1;
        f3 = anonymousClass1.F$0;
        int i20 = anonymousClass1.I$2;
        int i21 = anonymousClass1.I$1;
        i6 = anonymousClass1.I$0;
        Ref.IntRef intRef3 = (Ref.IntRef) anonymousClass1.L$3;
        f = 0.0f;
        Ref.ObjectRef objectRef2 = (Ref.ObjectRef) anonymousClass1.L$2;
        Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) anonymousClass1.L$1;
        LazyLayoutScrollScope lazyLayoutScrollScope6 = (LazyLayoutScrollScope) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            objectRef = objectRef2;
            booleanRef = booleanRef2;
            f2 = f7;
            i15 = i20;
            i7 = i21;
            anonymousClass12 = anonymousClass1;
            f4 = f6;
            lazyLayoutScrollScope3 = lazyLayoutScrollScope6;
            i9 = i6;
        } catch (ItemFoundInScroll e4) {
            e = e4;
            lazyLayoutScrollScope2 = lazyLayoutScrollScope6;
            i4 = 0;
            i5 = i21;
            animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            final float itemOffset22 = e.getItemOffset() + i5;
            final Ref.FloatRef floatRef22 = new Ref.FloatRef();
            fBoxFloat = Boxing.boxFloat(itemOffset22);
            if (((Number) animationStateCopy$default.getVelocity()).floatValue() == f) {
            }
            function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset22, floatRef22, lazyLayoutScrollScope2, (AnimationScope) obj2);
                }
            };
            anonymousClass1.L$0 = lazyLayoutScrollScope2;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.I$0 = i6;
            anonymousClass1.I$1 = i5;
            anonymousClass1.label = 2;
            if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
            }
        }
        try {
            try {
                intRef3.element++;
            } catch (ItemFoundInScroll e5) {
                e = e5;
                i6 = i9;
                anonymousClass13 = anonymousClass12;
                i5 = i7;
                lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
            }
            i8 = i15;
            intRef = intRef3;
            i17 = 0;
            i18 = 1;
        } catch (ItemFoundInScroll e6) {
            e = e6;
            i6 = i9;
            anonymousClass1 = anonymousClass12;
            i5 = i7;
            i4 = 0;
            lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
            animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            final float itemOffset222 = e.getItemOffset() + i5;
            final Ref.FloatRef floatRef222 = new Ref.FloatRef();
            fBoxFloat = Boxing.boxFloat(itemOffset222);
            if (((Number) animationStateCopy$default.getVelocity()).floatValue() == f) {
            }
            function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset222, floatRef222, lazyLayoutScrollScope2, (AnimationScope) obj2);
                }
            };
            anonymousClass1.L$0 = lazyLayoutScrollScope2;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.I$0 = i6;
            anonymousClass1.I$1 = i5;
            anonymousClass1.label = 2;
            if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (booleanRef.element && lazyLayoutScrollScope3.getItemCount() > 0) {
            try {
                try {
                    iCalculateDistanceTo$default = LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope3, i9, i17, 2, null) + i7;
                } catch (ItemFoundInScroll e7) {
                    e = e7;
                    anonymousClass13 = anonymousClass12;
                    lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
                    i6 = i14;
                    i5 = i7;
                }
            } catch (ItemFoundInScroll e8) {
                e = e8;
                anonymousClass1 = anonymousClass13;
                i4 = 0;
                animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                final float itemOffset2222 = e.getItemOffset() + i5;
                final Ref.FloatRef floatRef2222 = new Ref.FloatRef();
                fBoxFloat = Boxing.boxFloat(itemOffset2222);
                if (((Number) animationStateCopy$default.getVelocity()).floatValue() == f) {
                }
                function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset2222, floatRef2222, lazyLayoutScrollScope2, (AnimationScope) obj2);
                    }
                };
                anonymousClass1.L$0 = lazyLayoutScrollScope2;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.L$3 = null;
                anonymousClass1.I$0 = i6;
                anonymousClass1.I$1 = i5;
                anonymousClass1.label = 2;
                if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (Math.abs(iCalculateDistanceTo$default) < f3) {
                if (i10 != 0) {
                    f5 = f3;
                    objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                    animationState = (AnimationState) objectRef.element;
                    fBoxFloat2 = Boxing.boxFloat(f5);
                    z = (((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() != f ? i18 : i17) ^ i18;
                    final boolean z2 = i10 == 0 ? i18 : i17;
                    lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
                    i14 = i9;
                    final Ref.BooleanRef booleanRef3 = booleanRef;
                    final Ref.ObjectRef objectRef3 = objectRef;
                    function12 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$5(lazyLayoutScrollScope5, i14, f5, floatRef3, booleanRef3, z2, f2, intRef, i8, i7, objectRef3, (AnimationScope) obj2);
                        }
                    };
                    lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
                    i6 = i14;
                    float f8 = f2;
                    intRef3 = intRef;
                    i15 = i8;
                    i5 = i7;
                    anonymousClass12.L$0 = lazyLayoutScrollScope2;
                    anonymousClass12.L$1 = booleanRef3;
                    anonymousClass12.L$2 = objectRef3;
                    anonymousClass12.L$3 = intRef3;
                    anonymousClass12.I$0 = i6;
                    anonymousClass12.I$1 = i5;
                    anonymousClass12.I$2 = i15;
                    anonymousClass12.F$0 = f3;
                    anonymousClass12.F$1 = f8;
                    anonymousClass12.F$2 = f4;
                    anonymousClass12.I$3 = i10;
                    anonymousClass12.label = 1;
                    anonymousClass13 = anonymousClass12;
                    if (SuspendAnimationKt.animateTo$default(animationState, fBoxFloat2, null, z, function12, anonymousClass13, 2, null) != coroutine_suspended) {
                        objectRef = objectRef3;
                        booleanRef = booleanRef3;
                        lazyLayoutScrollScope3 = lazyLayoutScrollScope2;
                        anonymousClass12 = anonymousClass13;
                        f2 = f8;
                        i7 = i5;
                        i9 = i6;
                        intRef3.element++;
                        i8 = i15;
                        intRef = intRef3;
                        i17 = 0;
                        i18 = 1;
                        if (booleanRef.element) {
                            iCalculateDistanceTo$default = LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope3, i9, i17, 2, null) + i7;
                            if (Math.abs(iCalculateDistanceTo$default) < f3) {
                                try {
                                    fMax = Math.max(Math.abs(iCalculateDistanceTo$default), f4);
                                    if (i10 == 0) {
                                        fMax = -fMax;
                                    }
                                } catch (ItemFoundInScroll e9) {
                                    e = e9;
                                    i6 = i9;
                                    anonymousClass1 = anonymousClass12;
                                    i4 = i17;
                                    i5 = i7;
                                    lazyLayoutScrollScope2 = lazyLayoutScrollScope3;
                                    animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                    final float itemOffset22222 = e.getItemOffset() + i5;
                                    final Ref.FloatRef floatRef22222 = new Ref.FloatRef();
                                    fBoxFloat = Boxing.boxFloat(itemOffset22222);
                                    if (((Number) animationStateCopy$default.getVelocity()).floatValue() == f) {
                                    }
                                    function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset22222, floatRef22222, lazyLayoutScrollScope2, (AnimationScope) obj2);
                                        }
                                    };
                                    anonymousClass1.L$0 = lazyLayoutScrollScope2;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.I$0 = i6;
                                    anonymousClass1.I$1 = i5;
                                    anonymousClass1.label = 2;
                                    if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
                                    }
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                fMax = -f3;
            }
            f5 = fMax;
            objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            final Ref.FloatRef floatRef32 = new Ref.FloatRef();
            animationState = (AnimationState) objectRef.element;
            fBoxFloat2 = Boxing.boxFloat(f5);
            z = (((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() != f ? i18 : i17) ^ i18;
            if (i10 == 0) {
            }
            lazyLayoutScrollScope5 = lazyLayoutScrollScope3;
            i14 = i9;
            final Ref.BooleanRef booleanRef32 = booleanRef;
            final Ref.ObjectRef objectRef32 = objectRef;
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$5(lazyLayoutScrollScope5, i14, f5, floatRef32, booleanRef32, z2, f2, intRef, i8, i7, objectRef32, (AnimationScope) obj2);
                }
            };
            lazyLayoutScrollScope2 = lazyLayoutScrollScope5;
            i6 = i14;
            float f82 = f2;
            intRef3 = intRef;
            i15 = i8;
            i5 = i7;
            anonymousClass12.L$0 = lazyLayoutScrollScope2;
            anonymousClass12.L$1 = booleanRef32;
            anonymousClass12.L$2 = objectRef32;
            anonymousClass12.L$3 = intRef3;
            anonymousClass12.I$0 = i6;
            anonymousClass12.I$1 = i5;
            anonymousClass12.I$2 = i15;
            anonymousClass12.F$0 = f3;
            anonymousClass12.F$1 = f82;
            anonymousClass12.F$2 = f4;
            anonymousClass12.I$3 = i10;
            anonymousClass12.label = 1;
            anonymousClass13 = anonymousClass12;
            if (SuspendAnimationKt.animateTo$default(animationState, fBoxFloat2, null, z, function12, anonymousClass13, 2, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
        animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        final float itemOffset222222 = e.getItemOffset() + i5;
        final Ref.FloatRef floatRef222222 = new Ref.FloatRef();
        fBoxFloat = Boxing.boxFloat(itemOffset222222);
        i11 = ((Number) animationStateCopy$default.getVelocity()).floatValue() == f ? 1 : i4;
        function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(itemOffset222222, floatRef222222, lazyLayoutScrollScope2, (AnimationScope) obj2);
            }
        };
        anonymousClass1.L$0 = lazyLayoutScrollScope2;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.I$0 = i6;
        anonymousClass1.I$1 = i5;
        anonymousClass1.label = 2;
        if (SuspendAnimationKt.animateTo$default(animationStateCopy$default, fBoxFloat, null, i11 ^ 1, function1, anonymousClass1, 2, null) != coroutine_suspended) {
            lazyLayoutScrollScope4 = lazyLayoutScrollScope2;
            i12 = i5;
            i13 = i6;
            lazyLayoutScrollScope4.snapToItem(i13, i12);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    private static final boolean animateScrollToItem$isOvershot(boolean z, LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutScrollScope.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() > i2;
        }
        if (lazyLayoutScrollScope.getFirstVisibleItemIndex() < i) {
            return true;
        }
        return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() < i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit animateScrollToItem$lambda$5(LazyLayoutScrollScope lazyLayoutScrollScope, int i, float f, Ref.FloatRef floatRef, Ref.BooleanRef booleanRef, boolean z, float f2, Ref.IntRef intRef, int i2, int i3, Ref.ObjectRef objectRef, AnimationScope animationScope) {
        if (!isItemVisible(lazyLayoutScrollScope, i)) {
            float fCoerceAtMost = (f > 0.0f ? RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), f) : RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), f)) - floatRef.element;
            float fScrollBy = lazyLayoutScrollScope.scrollBy(fCoerceAtMost);
            if (!isItemVisible(lazyLayoutScrollScope, i) && !animateScrollToItem$isOvershot(z, lazyLayoutScrollScope, i, i3)) {
                if (fCoerceAtMost != fScrollBy) {
                    animationScope.cancelAnimation();
                    booleanRef.element = false;
                    return Unit.INSTANCE;
                }
                floatRef.element += fCoerceAtMost;
                if (z) {
                    if (((Number) animationScope.getValue()).floatValue() > f2) {
                        animationScope.cancelAnimation();
                    }
                } else if (((Number) animationScope.getValue()).floatValue() < (-f2)) {
                    animationScope.cancelAnimation();
                }
                if (z) {
                    if (intRef.element >= 2 && i - lazyLayoutScrollScope.getLastVisibleItemIndex() > i2) {
                        lazyLayoutScrollScope.snapToItem(i - i2, 0);
                    }
                } else if (intRef.element >= 2 && lazyLayoutScrollScope.getFirstVisibleItemIndex() - i > i2) {
                    lazyLayoutScrollScope.snapToItem(i2 + i, 0);
                }
            }
        }
        if (!animateScrollToItem$isOvershot(z, lazyLayoutScrollScope, i, i3)) {
            if (isItemVisible(lazyLayoutScrollScope, i)) {
                throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope, i, 0, 2, null), (AnimationState) objectRef.element);
            }
            return Unit.INSTANCE;
        }
        lazyLayoutScrollScope.snapToItem(i, i3);
        booleanRef.element = false;
        animationScope.cancelAnimation();
        return Unit.INSTANCE;
    }

    static final Unit animateScrollToItem$lambda$7(float f, Ref.FloatRef floatRef, LazyLayoutScrollScope lazyLayoutScrollScope, AnimationScope animationScope) {
        float fCoerceAtLeast = 0.0f;
        if (f > 0.0f) {
            fCoerceAtLeast = RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), f);
        } else if (f < 0.0f) {
            fCoerceAtLeast = RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), f);
        }
        float f2 = fCoerceAtLeast - floatRef.element;
        if (f2 != lazyLayoutScrollScope.scrollBy(f2) || fCoerceAtLeast != ((Number) animationScope.getValue()).floatValue()) {
            animationScope.cancelAnimation();
        }
        floatRef.element += f2;
        return Unit.INSTANCE;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope lazyLayoutScrollScope, int i) {
        return i <= lazyLayoutScrollScope.getLastVisibleItemIndex() && lazyLayoutScrollScope.getFirstVisibleItemIndex() <= i;
    }
}
