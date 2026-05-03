package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyStaggeredGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0126  */
    /* JADX INFO: renamed from: LazyStaggeredGrid-w41Enmo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2252LazyStaggeredGridw41Enmo(final LazyStaggeredGridState lazyStaggeredGridState, final Orientation orientation, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, final OverscrollEffect overscrollEffect, float f, float f2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        FlingBehavior flingBehavior2;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final float f3;
        final FlingBehavior flingBehavior3;
        Composer composer2;
        final boolean z4;
        final Modifier modifier3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        boolean z6;
        float fM9114constructorimpl;
        float fM9114constructorimpl2;
        Modifier modifier4;
        FlingBehavior flingBehavior4;
        PaddingValues paddingValues4;
        boolean z7;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1904835166);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyStaggeredGrid)N(state,orientation,slots,modifier,contentPadding,reverseLayout,flingBehavior,userScrollEnabled,overscrollEffect,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)63@2868L55,64@2949L24,65@3021L7,67@3061L311,79@3397L60,98@4044L302,93@3875L1116:LazyStaggeredGrid.kt#fzvcnm");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(lazyStaggeredGridState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(orientation.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= (i & 512) == 0 ? composerStartRestartGroup.changed(lazyGridStaggeredGridSlotsProvider) : composerStartRestartGroup.changedInstance(lazyGridStaggeredGridSlotsProvider) ? 256 : 128;
        }
        int i16 = i3 & 8;
        if (i16 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    paddingValues2 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    flingBehavior2 = flingBehavior;
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(flingBehavior2)) ? 1048576 : 524288;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    z3 = z2;
                } else {
                    z3 = z2;
                    if ((i & 12582912) == 0) {
                        i4 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                    }
                }
                if ((i & 100663296) == 0) {
                    i4 |= composerStartRestartGroup.changed(overscrollEffect) ? 67108864 : 33554432;
                }
                i8 = i3 & 512;
                if (i8 == 0) {
                    if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
                    }
                    i10 = i3 & 1024;
                    if (i10 == 0) {
                        i12 = i2 | 6;
                        i11 = i10;
                    } else if ((i2 & 6) == 0) {
                        i11 = i10;
                        i12 = i2 | (composerStartRestartGroup.changed(f2) ? 4 : 2);
                    } else {
                        i11 = i10;
                        i12 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i12 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
                    }
                    i13 = i12;
                    i14 = i4;
                    if (composerStartRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        f3 = f2;
                        flingBehavior3 = flingBehavior2;
                        composer2 = composerStartRestartGroup;
                        z4 = z3;
                        modifier3 = modifier2;
                        paddingValues3 = paddingValues2;
                        z5 = z;
                        f4 = f;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i16 != 0 ? Modifier.INSTANCE : modifier2;
                            PaddingValues paddingValuesM2030PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : paddingValues2;
                            boolean z8 = i6 == 0 ? z : false;
                            if ((i3 & 64) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i15 = i14 & (-3670017);
                            } else {
                                i15 = i14;
                            }
                            z6 = i7 == 0 ? z3 : true;
                            fM9114constructorimpl = i9 != 0 ? Dp.m9114constructorimpl(0.0f) : f;
                            fM9114constructorimpl2 = i11 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                            modifier4 = companion;
                            flingBehavior4 = flingBehavior2;
                            paddingValues4 = paddingValuesM2030PaddingValues0680j_4;
                            z7 = z8;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 64) != 0) {
                                fM9114constructorimpl = f;
                                fM9114constructorimpl2 = f2;
                                i15 = i14 & (-3670017);
                            } else {
                                fM9114constructorimpl = f;
                                fM9114constructorimpl2 = f2;
                                i15 = i14;
                            }
                            flingBehavior4 = flingBehavior2;
                            z6 = z3;
                            paddingValues4 = paddingValues2;
                            z7 = z;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1904835166, i15, i13, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                        }
                        int i17 = i15 & 14;
                        Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i13 & 112) | i17);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<GraphicsContext> localGraphicsContext = CompositionLocalsKt.getLocalGraphicsContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localGraphicsContext);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i18 = i15 >> 6;
                        int i19 = i15 >> 12;
                        int i20 = ((i15 << 18) & 234881024) | (i18 & 7168) | (i18 & 896) | i17 | ((i15 << 9) & 57344) | (i19 & 458752) | ((i13 << 18) & 3670016);
                        int i21 = i15;
                        boolean z9 = z7;
                        float f5 = fM9114constructorimpl;
                        float f6 = fM9114constructorimpl2;
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM2264rememberStaggeredGridMeasurePolicyqKj4JfE = LazyStaggeredGridMeasurePolicyKt.m2264rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda, paddingValues4, z9, orientation, f5, f6, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume, composerStartRestartGroup, i20);
                        PaddingValues paddingValues5 = paddingValues4;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z9, composerStartRestartGroup, (i19 & 112) | i17);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-1834596342);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                            companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i17), lazyStaggeredGridState.getBeyondBoundsInfo(), z9, orientation);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1834291488);
                            composerStartRestartGroup.endReplaceGroup();
                            companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                        }
                        boolean z10 = z6;
                        FlingBehavior flingBehavior5 = flingBehavior4;
                        LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState, orientation, z10, z9, composerStartRestartGroup, (i21 & 458752) | ((i21 << 6) & 7168) | ((i21 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z10, z9, flingBehavior5, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM2264rememberStaggeredGridMeasurePolicyqKj4JfE, composerStartRestartGroup, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        flingBehavior3 = flingBehavior5;
                        modifier3 = modifier4;
                        z4 = z6;
                        paddingValues3 = paddingValues5;
                        f4 = f5;
                        f3 = f6;
                        z5 = z9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z5, flingBehavior3, z4, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 805306368;
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                i13 = i12;
                i14 = i4;
                if (composerStartRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i13 = i12;
            i14 = i4;
            if (composerStartRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i13 = i12;
        i14 = i4;
        if (composerStartRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, float f, float f2, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m2252LazyStaggeredGridw41Enmo(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier, paddingValues, z, flingBehavior, z2, overscrollEffect, f, f2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }
}
