package androidx.compose.foundation.lazy.grid;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0003¢\u0006\u0002\u0010&\u001a*\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0002¨\u00060"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(Modifier modifier, LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, final boolean z2, FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        PaddingValues paddingValuesM2030PaddingValues0680j_4;
        int i5;
        boolean z4;
        FlingBehavior flingBehavior2;
        int i6;
        int i7;
        LazyGridState lazyGridState2;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Modifier modifier3;
        final FlingBehavior flingBehavior3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        char c;
        PaddingValues paddingValues3;
        int i8;
        FlingBehavior flingBehavior4;
        boolean z6;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        Composer composerStartRestartGroup = composer.startRestartGroup(708740370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyGrid)N(modifier,state,slots,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,verticalArrangement,horizontalArrangement,content)84@4015L50,86@4091L51,88@4169L24,89@4241L7,90@4310L7,93@4351L404,126@5421L302,121@5252L1117:LazyGrid.kt#7791vq");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= (i & 512) == 0 ? composerStartRestartGroup.changed(lazyGridSlotsProvider) : composerStartRestartGroup.changedInstance(lazyGridSlotsProvider) ? 256 : 128;
        }
        int i10 = i3 & 8;
        if (i10 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                paddingValuesM2030PaddingValues0680j_4 = paddingValues;
                i4 |= composerStartRestartGroup.changed(paddingValuesM2030PaddingValues0680j_4) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z;
                    i4 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    flingBehavior2 = flingBehavior;
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(flingBehavior2)) ? 1048576 : 524288;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if ((i & 12582912) == 0) {
                    i4 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                }
                if ((i & 100663296) == 0) {
                    i4 |= composerStartRestartGroup.changed(overscrollEffect) ? 67108864 : 33554432;
                }
                if ((i & 805306368) == 0) {
                    i4 |= composerStartRestartGroup.changed(vertical) ? 536870912 : 268435456;
                }
                if ((i2 & 6) == 0) {
                    i6 = i2 | (composerStartRestartGroup.changed(horizontal) ? 4 : 2);
                } else {
                    i6 = i2;
                }
                if ((i2 & 48) == 0) {
                    i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
                }
                i7 = i6;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i7 & 19) == 18) ? false : true, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "72@3483L15");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i10 != 0) {
                            paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
                        }
                        boolean z7 = i5 == 0 ? z4 : false;
                        if ((i3 & 64) != 0) {
                            paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                            flingBehavior4 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i8 = i4 & (-3670017);
                            c = 18;
                        } else {
                            c = 18;
                            paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                            i8 = i4;
                            flingBehavior4 = flingBehavior2;
                        }
                        z6 = z7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                        }
                        boolean z8 = z4;
                        c = 18;
                        z6 = z8;
                        paddingValues3 = paddingValuesM2030PaddingValues0680j_4;
                        companion = modifier2;
                        i8 = i4;
                        flingBehavior4 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(708740370, i8, i7, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:83)");
                    }
                    int i11 = (i8 >> 3) & 14;
                    Function0<LazyGridItemProvider> function0RememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, composerStartRestartGroup, (i7 & 112) | i11);
                    int i12 = i8 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z6, composerStartRestartGroup, (i12 & 112) | i11);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<GraphicsContext> localGraphicsContext = CompositionLocalsKt.getLocalGraphicsContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localGraphicsContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    GraphicsContext graphicsContext = (GraphicsContext) objConsume;
                    CompositionLocal<Boolean> localScrollCaptureInProgress = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localScrollCaptureInProgress);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier4 = companion;
                    int i13 = i8;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyRememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(function0RememberLazyGridItemProviderLambda, lazyGridState, lazyGridSlotsProvider, paddingValues3, z6, z2, horizontal, vertical, coroutineScope, graphicsContext, !((Boolean) objConsume2).booleanValue() ? StickyItemsPlacement.INSTANCE.getStickToTopPlacement() : null, composerStartRestartGroup, (524272 & i8) | ((i7 << 18) & 3670016) | ((i8 >> 6) & 29360128), 0);
                    PaddingValues paddingValues4 = paddingValues3;
                    boolean z9 = z6;
                    lazyGridState2 = lazyGridState;
                    Orientation orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
                    if (z3) {
                        composerStartRestartGroup.startReplaceGroup(27281635);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@4986L48");
                        companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState2, composerStartRestartGroup, i11), lazyGridState2.getBeyondBoundsInfo(), z9, orientation);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(27577840);
                        composerStartRestartGroup.endReplaceGroup();
                        companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                    }
                    FlingBehavior flingBehavior5 = flingBehavior4;
                    LazyLayoutKt.LazyLayout(function0RememberLazyGridItemProviderLambda, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyGridState2.getRemeasurementModifier()).then(lazyGridState2.getAwaitLayoutModifier()), function0RememberLazyGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyGridSemanticState, orientation, z3, z9, composerStartRestartGroup, (i12 & 57344) | (458752 & (i13 << 3))).then(companionLazyLayoutBeyondBoundsModifier).then(lazyGridState2.getItemAnimator$foundation().getModifier()), lazyGridState2, orientation, overscrollEffect, z3, z9, flingBehavior5, lazyGridState2.getInternalInteractionSource(), null, 128, null), lazyGridState2.getPrefetchState(), lazyLayoutMeasurePolicyRememberLazyGridMeasurePolicy, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z9;
                    flingBehavior3 = flingBehavior5;
                    paddingValues2 = paddingValues4;
                    modifier3 = modifier4;
                } else {
                    lazyGridState2 = lazyGridState;
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValuesM2030PaddingValues0680j_4;
                    z5 = z4;
                    modifier3 = modifier2;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final LazyGridState lazyGridState3 = lazyGridState2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LazyGridKt.LazyGrid$lambda$0(modifier3, lazyGridState3, lazyGridSlotsProvider, paddingValues2, z5, z2, flingBehavior3, z3, overscrollEffect, vertical, horizontal, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            z4 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i7 = i6;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i7 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        paddingValuesM2030PaddingValues0680j_4 = paddingValues;
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        z4 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i7 = i6;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i7 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit LazyGrid$lambda$0(Modifier modifier, LazyGridState lazyGridState, LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, OverscrollEffect overscrollEffect, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LazyGrid(modifier, lazyGridState, lazyGridSlotsProvider, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, vertical, horizontal, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(CacheWindowLogic cacheWindowLogic, Orientation orientation, List<LazyGridMeasuredItem> list, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                int iLineIndex = LazyGridItemInfoKt.lineIndex((LazyGridItemInfo) CollectionsKt.first((List) list), orientation);
                int iLineIndex2 = LazyGridItemInfoKt.lineIndex((LazyGridItemInfo) CollectionsKt.last((List) list), orientation);
                for (int prefetchWindowStartLine$foundation = cacheWindowLogic.getPrefetchWindowStartLine(); prefetchWindowStartLine$foundation < iLineIndex; prefetchWindowStartLine$foundation++) {
                    lazyGridMeasuredLineProvider.keepAround(prefetchWindowStartLine$foundation);
                }
                int i = iLineIndex2 + 1;
                int prefetchWindowEndLine$foundation = cacheWindowLogic.getPrefetchWindowEndLine();
                if (i <= prefetchWindowEndLine$foundation) {
                    while (true) {
                        lazyGridMeasuredLineProvider.keepAround(i);
                        if (i == prefetchWindowEndLine$foundation) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009c A[PHI: r3
      0x009c: PHI (r3v25 boolean) = (r3v23 boolean), (r3v26 boolean) binds: [B:44:0x009a, B:40:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyLayoutMeasurePolicy rememberLazyGridMeasurePolicy(Function0<? extends LazyGridItemProvider> function0, LazyGridState lazyGridState, LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Composer composer, int i, int i2) {
        boolean z3;
        boolean z4;
        boolean zChanged;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -1030995717, "C(rememberLazyGridMeasurePolicy)N(itemProviderLambda,state,slots,contentPadding,reverseLayout,isVertical,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsScrollBehavior)179@7590L12074:LazyGrid.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030995717, i, i2, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:179)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1350606789, "CC(remember):LazyGrid.kt#9igjgp");
        boolean z5 = ((((i & 112) ^ 48) > 32 && composer.changed(lazyGridState)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(lazyGridSlotsProvider)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(paddingValues)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(z)) || (i & 24576) == 16384);
        if (((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
            z3 = z2;
            if (composer.changed(z3)) {
                z4 = true;
            }
            zChanged = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
            lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
            if (!zChanged || lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(lazyGridState, z3, paddingValues, z, function0, lazyGridSlotsProvider, vertical, horizontal, coroutineScope, graphicsContext, stickyItemsPlacement);
                composer.updateRememberedValue(lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue);
            }
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy;
        }
        z3 = z2;
        if ((196608 & i) != 131072) {
            z4 = false;
        }
        zChanged = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
        lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
        if (!zChanged) {
            lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(lazyGridState, z3, paddingValues, z, function0, lazyGridSlotsProvider, vertical, horizontal, coroutineScope, graphicsContext, stickyItemsPlacement);
            composer.updateRememberedValue(lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue);
        }
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) lazyGridKt$rememberLazyGridMeasurePolicy$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy2;
    }
}
