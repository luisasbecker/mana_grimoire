package androidx.compose.foundation.lazy;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
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

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u0085\u0001\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0003¢\u0006\u0002\u0010*\u001a\"\u0010+\u001a\u00020\u0001*\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u000201H\u0002¨\u00062"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;ILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:115:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        PaddingValues paddingValues2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        LazyListState lazyListState2;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal4;
        final int i12;
        final Alignment.Vertical vertical4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iDefaultLazyListBeyondBoundsItemCount;
        Alignment.Horizontal horizontal5;
        Arrangement.Vertical vertical5;
        Alignment.Vertical vertical6;
        int i13;
        int i14;
        Arrangement.Horizontal horizontal6;
        Object objRememberedValue;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        Composer composerStartRestartGroup = composer.startRestartGroup(924924659);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyList)N(modifier,state,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,beyondBoundsItemCount,horizontalAlignment,verticalArrangement,verticalAlignment,horizontalArrangement,content)86@4189L50,88@4265L48,89@4339L24,90@4411L7,91@4480L7,94@4521L484,133@5809L302,128@5640L1117:LazyList.kt#428nma");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            paddingValues2 = paddingValues;
            i5 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            if ((i4 & 256) == 0) {
                i6 = i;
                int i15 = composerStartRestartGroup.changed(i6) ? 67108864 : 33554432;
                i5 |= i15;
            } else {
                i6 = i;
            }
            i5 |= i15;
        } else {
            i6 = i;
        }
        int i16 = i4 & 512;
        if (i16 != 0) {
            i5 |= 805306368;
        } else if ((i2 & 805306368) == 0) {
            i5 |= composerStartRestartGroup.changed(horizontal) ? 536870912 : 268435456;
        }
        int i17 = i4 & 1024;
        if (i17 != 0) {
            i8 = i3 | 6;
            i7 = i17;
        } else if ((i3 & 6) == 0) {
            i7 = i17;
            i8 = i3 | (composerStartRestartGroup.changed(vertical) ? 4 : 2);
        } else {
            i7 = i17;
            i8 = i3;
        }
        int i18 = i4 & 2048;
        if (i18 != 0) {
            i8 |= 48;
            i9 = i18;
        } else if ((i3 & 48) == 0) {
            i9 = i18;
            i8 |= composerStartRestartGroup.changed(vertical2) ? 32 : 16;
        } else {
            i9 = i18;
        }
        int i19 = i8;
        int i20 = i4 & 4096;
        if (i20 == 0) {
            i10 = i19;
            if ((i3 & 384) == 0) {
                i10 |= composerStartRestartGroup.changed(horizontal2) ? 256 : 128;
            }
            if ((i3 & 3072) == 0) {
                i10 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
            }
            i11 = i10;
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
                lazyListState2 = lazyListState;
                composerStartRestartGroup.skipToGroupEnd();
                horizontal3 = horizontal;
                vertical3 = vertical;
                horizontal4 = horizontal2;
                i12 = i6;
                vertical4 = vertical2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "74@3486L38");
                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i4 & 256) != 0) {
                        iDefaultLazyListBeyondBoundsItemCount = LazyList_androidKt.defaultLazyListBeyondBoundsItemCount(composerStartRestartGroup, 0);
                        i5 &= -234881025;
                    } else {
                        iDefaultLazyListBeyondBoundsItemCount = i6;
                    }
                    horizontal5 = i16 != 0 ? null : horizontal;
                    vertical5 = i7 != 0 ? null : vertical;
                    vertical6 = i9 != 0 ? null : vertical2;
                    i13 = iDefaultLazyListBeyondBoundsItemCount;
                    i14 = i5;
                    if (i20 != 0) {
                        horizontal6 = null;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(924924659, i14, i11, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:85)");
                    }
                    int i21 = (i14 >> 3) & 14;
                    Function0<LazyListItemProvider> function0RememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, composerStartRestartGroup, i21 | ((i11 >> 6) & 112));
                    int i22 = i14 >> 9;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i21 | (i22 & 112));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
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
                    StickyItemsPlacement stickToTopPlacement = ((Boolean) objConsume2).booleanValue() ? null : StickyItemsPlacement.INSTANCE.getStickToTopPlacement();
                    int i23 = i11 << 18;
                    int i24 = (65520 & i14) | (i22 & 458752) | (3670016 & i22) | (29360128 & i23) | (i23 & 234881024) | ((i11 << 27) & 1879048192);
                    int i25 = i14;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyRememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(function0RememberLazyListItemProviderLambda, lazyListState, paddingValues2, z, z2, i13, horizontal5, vertical6, horizontal6, vertical5, coroutineScope, graphicsContext, stickToTopPlacement, composerStartRestartGroup, i24, 0);
                    lazyListState2 = lazyListState;
                    Alignment.Horizontal horizontal7 = horizontal5;
                    Alignment.Vertical vertical7 = vertical6;
                    Arrangement.Horizontal horizontal8 = horizontal6;
                    Arrangement.Vertical vertical8 = vertical5;
                    int i26 = i13;
                    Orientation orientation = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                    if (z3) {
                        composerStartRestartGroup.startReplaceGroup(-2076718545);
                        composerStartRestartGroup.endReplaceGroup();
                        companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2077147368);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "116@5256L166");
                        companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState2, i26, composerStartRestartGroup, i21 | ((i25 >> 21) & 112)), lazyListState2.getBeyondBoundsInfo(), z, orientation);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    LazyLayoutKt.LazyLayout(function0RememberLazyListItemProviderLambda, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState2.getRemeasurementModifier()).then(lazyListState2.getAwaitLayoutModifier()), function0RememberLazyListItemProviderLambda, lazyLayoutSemanticStateRememberLazyListSemanticState, orientation, z3, z, composerStartRestartGroup, ((i25 >> 6) & 57344) | ((i25 << 6) & 458752)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyListState2.getItemAnimator$foundation().getModifier()), lazyListState2, orientation, overscrollEffect, z3, z, flingBehavior, lazyListState2.getInternalInteractionSource(), null, 128, null), lazyListState2.getPrefetchState(), lazyLayoutMeasurePolicyRememberLazyListMeasurePolicy, composerStartRestartGroup, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i12 = i26;
                    horizontal3 = horizontal7;
                    vertical4 = vertical7;
                    horizontal4 = horizontal8;
                    vertical3 = vertical8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i4 & 256) != 0) {
                        i5 &= -234881025;
                    }
                    horizontal5 = horizontal;
                    vertical5 = vertical;
                    vertical6 = vertical2;
                    i14 = i5;
                    i13 = i6;
                }
                horizontal6 = horizontal2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i212 = (i14 >> 3) & 14;
                Function0<LazyListItemProvider> function0RememberLazyListItemProviderLambda2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, composerStartRestartGroup, i212 | ((i11 >> 6) & 112));
                int i222 = i14 >> 9;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState2 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i212 | (i222 & 112));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<GraphicsContext> localGraphicsContext2 = CompositionLocalsKt.getLocalGraphicsContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localGraphicsContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                GraphicsContext graphicsContext2 = (GraphicsContext) objConsume3;
                CompositionLocal<Boolean> localScrollCaptureInProgress2 = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume22 = composerStartRestartGroup.consume(localScrollCaptureInProgress2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (((Boolean) objConsume22).booleanValue()) {
                }
                int i232 = i11 << 18;
                int i242 = (65520 & i14) | (i222 & 458752) | (3670016 & i222) | (29360128 & i232) | (i232 & 234881024) | ((i11 << 27) & 1879048192);
                int i252 = i14;
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyRememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(function0RememberLazyListItemProviderLambda2, lazyListState, paddingValues2, z, z2, i13, horizontal5, vertical6, horizontal6, vertical5, coroutineScope2, graphicsContext2, stickToTopPlacement, composerStartRestartGroup, i242, 0);
                lazyListState2 = lazyListState;
                Alignment.Horizontal horizontal72 = horizontal5;
                Alignment.Vertical vertical72 = vertical6;
                Arrangement.Horizontal horizontal82 = horizontal6;
                Arrangement.Vertical vertical82 = vertical5;
                int i262 = i13;
                Orientation orientation2 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                if (z3) {
                }
                LazyLayoutKt.LazyLayout(function0RememberLazyListItemProviderLambda2, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState2.getRemeasurementModifier()).then(lazyListState2.getAwaitLayoutModifier()), function0RememberLazyListItemProviderLambda2, lazyLayoutSemanticStateRememberLazyListSemanticState2, orientation2, z3, z, composerStartRestartGroup, ((i252 >> 6) & 57344) | ((i252 << 6) & 458752)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyListState2.getItemAnimator$foundation().getModifier()), lazyListState2, orientation2, overscrollEffect, z3, z, flingBehavior, lazyListState2.getInternalInteractionSource(), null, 128, null), lazyListState2.getPrefetchState(), lazyLayoutMeasurePolicyRememberLazyListMeasurePolicy2, composerStartRestartGroup, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                i12 = i262;
                horizontal3 = horizontal72;
                vertical4 = vertical72;
                horizontal4 = horizontal82;
                vertical3 = vertical82;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final LazyListState lazyListState3 = lazyListState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyListKt.LazyList$lambda$0(modifier, lazyListState3, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i12, horizontal3, vertical3, vertical4, horizontal4, function1, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i10 = i19 | 384;
        if ((i3 & 3072) == 0) {
        }
        i11 = i10;
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit LazyList$lambda$0(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, Function1 function1, int i2, int i3, int i4, Composer composer, int i5) {
        LazyList(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i, horizontal, vertical, vertical2, horizontal2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(CacheWindowLogic cacheWindowLogic, List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                int index = ((LazyListMeasuredItem) CollectionsKt.first((List) list)).getIndex();
                int index2 = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex();
                for (int prefetchWindowStartLine = cacheWindowLogic.getPrefetchWindowStartLine(); prefetchWindowStartLine < index; prefetchWindowStartLine++) {
                    lazyListMeasuredItemProvider.keepAround(prefetchWindowStartLine);
                }
                int i = index2 + 1;
                int prefetchWindowEndLine = cacheWindowLogic.getPrefetchWindowEndLine();
                if (i <= prefetchWindowEndLine) {
                    while (true) {
                        lazyListMeasuredItemProvider.keepAround(i);
                        if (i == prefetchWindowEndLine) {
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081 A[PHI: r4
      0x0081: PHI (r4v19 boolean) = (r4v17 boolean), (r4v20 boolean) binds: [B:36:0x007f, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7 A[PHI: r9
      0x00b7: PHI (r9v17 androidx.compose.ui.Alignment$Horizontal) = (r9v14 androidx.compose.ui.Alignment$Horizontal), (r9v18 androidx.compose.ui.Alignment$Horizontal) binds: [B:54:0x00b5, B:50:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d3 A[PHI: r12
      0x00d3: PHI (r12v13 androidx.compose.ui.Alignment$Vertical) = (r12v10 androidx.compose.ui.Alignment$Vertical), (r12v14 androidx.compose.ui.Alignment$Vertical) binds: [B:64:0x00d1, B:60:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef A[PHI: r13
      0x00ef: PHI (r13v13 androidx.compose.foundation.layout.Arrangement$Horizontal) = 
      (r13v10 androidx.compose.foundation.layout.Arrangement$Horizontal)
      (r13v14 androidx.compose.foundation.layout.Arrangement$Horizontal)
     binds: [B:74:0x00ed, B:70:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010b A[PHI: r5
      0x010b: PHI (r5v9 androidx.compose.foundation.layout.Arrangement$Vertical) = 
      (r5v7 androidx.compose.foundation.layout.Arrangement$Vertical)
      (r5v10 androidx.compose.foundation.layout.Arrangement$Vertical)
     binds: [B:84:0x0109, B:80:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012b A[PHI: r6
      0x012b: PHI (r6v7 androidx.compose.foundation.lazy.layout.StickyItemsPlacement) = 
      (r6v5 androidx.compose.foundation.lazy.layout.StickyItemsPlacement)
      (r6v8 androidx.compose.foundation.lazy.layout.StickyItemsPlacement)
     binds: [B:94:0x0129, B:90:0x0122] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy(Function0<? extends LazyListItemProvider> function0, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Composer composer, int i2, int i3) {
        boolean z3;
        boolean z4;
        Alignment.Horizontal horizontal3;
        boolean z5;
        Alignment.Vertical vertical3;
        boolean z6;
        Arrangement.Horizontal horizontal4;
        boolean z7;
        Arrangement.Vertical vertical4;
        boolean z8;
        StickyItemsPlacement stickyItemsPlacement2;
        boolean z9;
        boolean z10;
        LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 406165748, "C(rememberLazyListMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,isVertical,beyondBoundsItemCount,horizontalAlignment,verticalAlignment,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsPlacement)187@8024L9764:LazyList.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(406165748, i2, i3, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -516691432, "CC(remember):LazyList.kt#9igjgp");
        boolean z11 = ((((i2 & 112) ^ 48) > 32 && composer.changed(lazyListState)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i2 & 3072) == 2048);
        if (((57344 & i2) ^ 24576) > 16384) {
            z3 = z2;
            if (composer.changed(z3)) {
                z4 = true;
            }
            boolean z12 = z11 | z4 | ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 && composer.changed(i)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
            if (((3670016 & i2) ^ 1572864) <= 1048576) {
                horizontal3 = horizontal;
                if (composer.changed(horizontal3)) {
                    z5 = true;
                }
                boolean z13 = z12 | z5;
                if (((29360128 & i2) ^ 12582912) > 8388608) {
                    vertical3 = vertical;
                    if (composer.changed(vertical3)) {
                        z6 = true;
                    }
                    boolean z14 = z13 | z6;
                    if (((234881024 & i2) ^ 100663296) <= 67108864) {
                        horizontal4 = horizontal2;
                        if (composer.changed(horizontal4)) {
                            z7 = true;
                        }
                        boolean z15 = z14 | z7;
                        if (((1879048192 & i2) ^ 805306368) > 536870912) {
                            vertical4 = vertical2;
                            if (composer.changed(vertical4)) {
                                z8 = true;
                            }
                            boolean zChanged = z8 | z15 | composer.changed(graphicsContext);
                            if (((i3 & 896) ^ 384) <= 256) {
                                stickyItemsPlacement2 = stickyItemsPlacement;
                                if (composer.changed(stickyItemsPlacement2)) {
                                    z9 = true;
                                }
                                z10 = zChanged | z9;
                                lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                                if (z10 || lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, vertical4, horizontal4, i, coroutineScope, graphicsContext, stickyItemsPlacement2, horizontal3, vertical3);
                                    composer.updateRememberedValue(lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue);
                                }
                                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                return lazyLayoutMeasurePolicy;
                            }
                            stickyItemsPlacement2 = stickyItemsPlacement;
                            if ((i3 & 384) == 256) {
                                z9 = false;
                            }
                            z10 = zChanged | z9;
                            lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                            if (z10) {
                                lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, vertical4, horizontal4, i, coroutineScope, graphicsContext, stickyItemsPlacement2, horizontal3, vertical3);
                                composer.updateRememberedValue(lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue);
                            }
                            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            return lazyLayoutMeasurePolicy2;
                        }
                        vertical4 = vertical2;
                        if ((i2 & 805306368) != 536870912) {
                            z8 = false;
                        }
                        boolean zChanged2 = z8 | z15 | composer.changed(graphicsContext);
                        if (((i3 & 896) ^ 384) <= 256) {
                        }
                        if ((i3 & 384) == 256) {
                        }
                        z10 = zChanged2 | z9;
                        lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                        if (z10) {
                        }
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return lazyLayoutMeasurePolicy22;
                    }
                    horizontal4 = horizontal2;
                    if ((100663296 & i2) == 67108864) {
                        z7 = false;
                    }
                    boolean z152 = z14 | z7;
                    if (((1879048192 & i2) ^ 805306368) > 536870912) {
                    }
                    if ((i2 & 805306368) != 536870912) {
                    }
                    boolean zChanged22 = z8 | z152 | composer.changed(graphicsContext);
                    if (((i3 & 896) ^ 384) <= 256) {
                    }
                    if ((i3 & 384) == 256) {
                    }
                    z10 = zChanged22 | z9;
                    lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                    if (z10) {
                    }
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222 = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return lazyLayoutMeasurePolicy222;
                }
                vertical3 = vertical;
                if ((12582912 & i2) != 8388608) {
                    z6 = false;
                }
                boolean z142 = z13 | z6;
                if (((234881024 & i2) ^ 100663296) <= 67108864) {
                }
                if ((100663296 & i2) == 67108864) {
                }
                boolean z1522 = z142 | z7;
                if (((1879048192 & i2) ^ 805306368) > 536870912) {
                }
                if ((i2 & 805306368) != 536870912) {
                }
                boolean zChanged222 = z8 | z1522 | composer.changed(graphicsContext);
                if (((i3 & 896) ^ 384) <= 256) {
                }
                if ((i3 & 384) == 256) {
                }
                z10 = zChanged222 | z9;
                lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
                if (z10) {
                }
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2222 = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return lazyLayoutMeasurePolicy2222;
            }
            horizontal3 = horizontal;
            if ((1572864 & i2) == 1048576) {
                z5 = false;
            }
            boolean z132 = z12 | z5;
            if (((29360128 & i2) ^ 12582912) > 8388608) {
            }
            if ((12582912 & i2) != 8388608) {
            }
            boolean z1422 = z132 | z6;
            if (((234881024 & i2) ^ 100663296) <= 67108864) {
            }
            if ((100663296 & i2) == 67108864) {
            }
            boolean z15222 = z1422 | z7;
            if (((1879048192 & i2) ^ 805306368) > 536870912) {
            }
            if ((i2 & 805306368) != 536870912) {
            }
            boolean zChanged2222 = z8 | z15222 | composer.changed(graphicsContext);
            if (((i3 & 896) ^ 384) <= 256) {
            }
            if ((i3 & 384) == 256) {
            }
            z10 = zChanged2222 | z9;
            lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
            if (z10) {
            }
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22222 = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy22222;
        }
        z3 = z2;
        if ((i2 & 24576) != 16384) {
            z4 = false;
        }
        boolean z122 = z11 | z4 | ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 && composer.changed(i)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
        if (((3670016 & i2) ^ 1572864) <= 1048576) {
        }
        if ((1572864 & i2) == 1048576) {
        }
        boolean z1322 = z122 | z5;
        if (((29360128 & i2) ^ 12582912) > 8388608) {
        }
        if ((12582912 & i2) != 8388608) {
        }
        boolean z14222 = z1322 | z6;
        if (((234881024 & i2) ^ 100663296) <= 67108864) {
        }
        if ((100663296 & i2) == 67108864) {
        }
        boolean z152222 = z14222 | z7;
        if (((1879048192 & i2) ^ 805306368) > 536870912) {
        }
        if ((i2 & 805306368) != 536870912) {
        }
        boolean zChanged22222 = z8 | z152222 | composer.changed(graphicsContext);
        if (((i3 & 896) ^ 384) <= 256) {
        }
        if ((i3 & 384) == 256) {
        }
        z10 = zChanged22222 | z9;
        lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue = composer.rememberedValue();
        if (z10) {
        }
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222222 = (LazyLayoutMeasurePolicy) lazyListKt$rememberLazyListMeasurePolicy$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy222222;
    }
}
