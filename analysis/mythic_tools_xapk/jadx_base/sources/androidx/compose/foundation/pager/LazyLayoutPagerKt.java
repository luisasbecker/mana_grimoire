package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$21\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001¢\u0006\u0004\b+\u0010,\u001a\u0081\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001a\u00020\u000521\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u00063"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutPagerKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    /* JADX INFO: renamed from: Pager-eLwUrMk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2286PagereLwUrMk(final Modifier modifier, final PagerState pagerState, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final TargetedFlingBehavior targetedFlingBehavior, final boolean z2, final OverscrollEffect overscrollEffect, int i, float f, final PageSize pageSize, NestedScrollConnection nestedScrollConnection, final Function1<? super Integer, ? extends Object> function1, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        PagerState pagerState2;
        NestedScrollConnection nestedScrollConnection2;
        Composer composer2;
        final int i10;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Object objRememberedValue;
        boolean z3;
        Object objRememberedValue2;
        boolean z4;
        Object objRememberedValue3;
        BringIntoViewSpec bringIntoViewSpec;
        boolean zChanged;
        Object objRememberedValue4;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        Composer composerStartRestartGroup = composer.startRestartGroup(-572816025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Pager)N(modifier,state,contentPadding,reverseLayout,orientation,flingBehavior,userScrollEnabled,overscrollEffect,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,pageNestedScrollConnection,key,horizontalAlignment,verticalAlignment,snapPosition,pageContent)109@5362L39,109@5277L124,113@5428L24,129@6071L19,116@5486L615,132@6127L70,135@6239L82,137@6381L7,139@6430L121,164@7268L301,159@7099L1450:LazyLayoutPager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(pagerState) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(orientation.ordinal()) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(targetedFlingBehavior) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
        }
        int i12 = i4 & 256;
        if (i12 == 0) {
            if ((i2 & 100663296) == 0) {
                i6 = 196608;
                i5 |= composerStartRestartGroup.changed(i) ? 67108864 : 33554432;
            }
            i7 = i4 & 512;
            if (i7 == 0) {
                i5 |= 805306368;
                f2 = f;
            } else {
                f2 = f;
                if ((i2 & 805306368) == 0) {
                    i5 |= composerStartRestartGroup.changed(f2) ? 536870912 : 268435456;
                }
            }
            if ((i3 & 6) != 0) {
                i8 = i3 | (composerStartRestartGroup.changed(pageSize) ? 4 : 2);
            } else {
                i8 = i3;
            }
            if ((i3 & 48) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(nestedScrollConnection) ? 32 : 16;
            }
            if ((i3 & 384) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
            }
            if ((i3 & 3072) == 0) {
                i8 |= composerStartRestartGroup.changed(horizontal) ? 2048 : 1024;
            }
            if ((i3 & 24576) == 0) {
                i8 |= composerStartRestartGroup.changed(vertical) ? 16384 : 8192;
            }
            if ((i3 & i6) == 0) {
                i8 |= composerStartRestartGroup.changed(snapPosition) ? 131072 : 65536;
            }
            if ((i3 & 1572864) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function4) ? 1048576 : 524288;
            }
            i9 = i8;
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i9) != 599186, i5 & 1)) {
                pagerState2 = pagerState;
                nestedScrollConnection2 = nestedScrollConnection;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i10 = i;
                f3 = f2;
            } else {
                int i13 = i12 != 0 ? 0 : i;
                float fM9114constructorimpl = i7 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-572816025, i5, i9, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:102)");
                }
                if (!(i13 >= 0)) {
                    InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + i13);
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720319826, "CC(remember):LazyLayoutPager.kt#9igjgp");
                int i14 = i5 & 112;
                boolean z5 = i14 == 32;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z5) {
                    i11 = i13;
                } else {
                    i11 = i13;
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i15 = i5 >> 3;
                    int i16 = i15 & 14;
                    int i17 = i9 >> 15;
                    int i18 = i5;
                    int i19 = i11;
                    Function0<PagerLazyLayoutItemProvider> function0RememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState, function4, function1, (Function0) objRememberedValue5, composerStartRestartGroup, i16 | (i17 & 112) | (i9 & 896));
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720297158, "CC(remember):LazyLayoutPager.kt#9igjgp");
                    z3 = i14 != 32;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(pagerState.getPageCount());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i20 = i18 >> 9;
                    int i21 = (i18 & 65520) | (i20 & 458752) | (i20 & 3670016) | ((i9 << 21) & 29360128);
                    int i22 = i9 << 15;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM2298rememberPagerMeasurePolicy8u0NR3k = PagerMeasurePolicyKt.m2298rememberPagerMeasurePolicy8u0NR3k(function0RememberPagerItemProviderLambda, pagerState, paddingValues, z, orientation, i19, fM9114constructorimpl, pageSize, horizontal, vertical, snapPosition, coroutineScope, (Function0) objRememberedValue2, composerStartRestartGroup, i21 | (i22 & 234881024) | (i22 & 1879048192), i17 & 14);
                    pagerState2 = pagerState;
                    float f4 = fM9114constructorimpl;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(pagerState2, orientation != Orientation.Vertical, composerStartRestartGroup, i16);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720291719, "CC(remember):LazyLayoutPager.kt#9igjgp");
                    z4 = (i14 != 32) | ((i18 & 458752) != 131072);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<BringIntoViewSpec> localBringIntoViewSpec = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localBringIntoViewSpec);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    bringIntoViewSpec = (BringIntoViewSpec) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720285568, "CC(remember):LazyLayoutPager.kt#9igjgp");
                    zChanged = (i14 != 32) | composerStartRestartGroup.changed(bringIntoViewSpec);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    PagerBringIntoViewSpec pagerBringIntoViewSpec = (PagerBringIntoViewSpec) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z2) {
                        composerStartRestartGroup.startReplaceGroup(-853392933);
                        composerStartRestartGroup.endReplaceGroup();
                        companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-853822717);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "147@6714L167");
                        companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState2, i19, composerStartRestartGroup, ((i18 >> 21) & 112) | i16), pagerState2.getBeyondBoundsInfo(), z, orientation);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierDragDirectionDetector = dragDirectionDetector(ScrollableAreaKt.scrollableArea(PagerKt.pagerSemantics(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState2.getRemeasurementModifier()).then(pagerState2.getAwaitLayoutModifier()), function0RememberPagerItemProviderLambda, lazyLayoutSemanticStateRememberPagerSemanticState, orientation, z2, z, composerStartRestartGroup, ((i18 << 6) & 458752) | (i15 & 7168) | ((i18 >> 6) & 57344)), pagerState2, orientation != Orientation.Vertical, coroutineScope, z2).then(companionLazyLayoutBeyondBoundsModifier), pagerState2, orientation, overscrollEffect, z2, z, pagerWrapperFlingBehavior, pagerState2.getInternalInteractionSource(), pagerBringIntoViewSpec), pagerState2);
                    nestedScrollConnection2 = nestedScrollConnection;
                    LazyLayoutKt.LazyLayout(function0RememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(modifierDragDirectionDetector, nestedScrollConnection2, null, 2, null), pagerState2.getPrefetchState(), lazyLayoutMeasurePolicyM2298rememberPagerMeasurePolicy8u0NR3k, composerStartRestartGroup, 0, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f3 = f4;
                    i10 = i19;
                }
                objRememberedValue5 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getPageCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i152 = i5 >> 3;
                int i162 = i152 & 14;
                int i172 = i9 >> 15;
                int i182 = i5;
                int i192 = i11;
                Function0<PagerLazyLayoutItemProvider> function0RememberPagerItemProviderLambda2 = rememberPagerItemProviderLambda(pagerState, function4, function1, (Function0) objRememberedValue5, composerStartRestartGroup, i162 | (i172 & 112) | (i9 & 896));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720297158, "CC(remember):LazyLayoutPager.kt#9igjgp");
                if (i14 != 32) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(pagerState.getPageCount());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i202 = i182 >> 9;
                    int i212 = (i182 & 65520) | (i202 & 458752) | (i202 & 3670016) | ((i9 << 21) & 29360128);
                    int i222 = i9 << 15;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM2298rememberPagerMeasurePolicy8u0NR3k2 = PagerMeasurePolicyKt.m2298rememberPagerMeasurePolicy8u0NR3k(function0RememberPagerItemProviderLambda2, pagerState, paddingValues, z, orientation, i192, fM9114constructorimpl, pageSize, horizontal, vertical, snapPosition, coroutineScope2, (Function0) objRememberedValue2, composerStartRestartGroup, i212 | (i222 & 234881024) | (i222 & 1879048192), i172 & 14);
                    pagerState2 = pagerState;
                    float f42 = fM9114constructorimpl;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberPagerSemanticState2 = PagerSemanticsKt.rememberPagerSemanticState(pagerState2, orientation != Orientation.Vertical, composerStartRestartGroup, i162);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720291719, "CC(remember):LazyLayoutPager.kt#9igjgp");
                    z4 = (i14 != 32) | ((i182 & 458752) != 131072);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z4) {
                        objRememberedValue3 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        PagerWrapperFlingBehavior pagerWrapperFlingBehavior2 = (PagerWrapperFlingBehavior) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<BringIntoViewSpec> localBringIntoViewSpec2 = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localBringIntoViewSpec2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        bringIntoViewSpec = (BringIntoViewSpec) objConsume2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720285568, "CC(remember):LazyLayoutPager.kt#9igjgp");
                        zChanged = (i14 != 32) | composerStartRestartGroup.changed(bringIntoViewSpec);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            PagerBringIntoViewSpec pagerBringIntoViewSpec2 = (PagerBringIntoViewSpec) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z2) {
                            }
                            Modifier modifierDragDirectionDetector2 = dragDirectionDetector(ScrollableAreaKt.scrollableArea(PagerKt.pagerSemantics(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState2.getRemeasurementModifier()).then(pagerState2.getAwaitLayoutModifier()), function0RememberPagerItemProviderLambda2, lazyLayoutSemanticStateRememberPagerSemanticState2, orientation, z2, z, composerStartRestartGroup, ((i182 << 6) & 458752) | (i152 & 7168) | ((i182 >> 6) & 57344)), pagerState2, orientation != Orientation.Vertical, coroutineScope2, z2).then(companionLazyLayoutBeyondBoundsModifier), pagerState2, orientation, overscrollEffect, z2, z, pagerWrapperFlingBehavior2, pagerState2.getInternalInteractionSource(), pagerBringIntoViewSpec2), pagerState2);
                            nestedScrollConnection2 = nestedScrollConnection;
                            LazyLayoutKt.LazyLayout(function0RememberPagerItemProviderLambda2, NestedScrollModifierKt.nestedScroll$default(modifierDragDirectionDetector2, nestedScrollConnection2, null, 2, null), pagerState2.getPrefetchState(), lazyLayoutMeasurePolicyM2298rememberPagerMeasurePolicy8u0NR3k2, composerStartRestartGroup, 0, 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f3 = f42;
                            i10 = i192;
                        }
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final NestedScrollConnection nestedScrollConnection3 = nestedScrollConnection2;
                final PagerState pagerState3 = pagerState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$5(modifier, pagerState3, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i10, f3, pageSize, nestedScrollConnection3, function1, horizontal, vertical, snapPosition, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i5 |= 100663296;
        i6 = 196608;
        i7 = i4 & 512;
        if (i7 == 0) {
        }
        if ((i3 & 6) != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        if ((i3 & 384) == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & i6) == 0) {
        }
        if ((i3 & 1572864) == 0) {
        }
        i9 = i8;
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i9) != 599186, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit Pager_eLwUrMk$lambda$5(Modifier modifier, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, TargetedFlingBehavior targetedFlingBehavior, boolean z2, OverscrollEffect overscrollEffect, int i, float f, PageSize pageSize, NestedScrollConnection nestedScrollConnection, Function1 function1, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m2286PagereLwUrMk(modifier, pagerState, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i, f, pageSize, nestedScrollConnection, function1, horizontal, vertical, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, final PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt.dragDirectionDetector.1

            /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: LazyLayoutPager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LazyLayoutPager.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", i = {0, 1, 1, 1}, l = {287, 291}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
                static final class C00361 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PagerState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00361(PagerState pagerState, Continuation<? super C00361> continuation) {
                        super(2, continuation);
                        this.$state = pagerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00361 c00361 = new C00361(this.$state, continuation);
                        c00361.L$0 = obj;
                        return c00361;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00361) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
                    
                        return r0;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006b -> B:18:0x006e). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        AwaitPointerEventScope awaitPointerEventScope;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        PointerInputChange pointerInputChange;
                        PointerInputChange pointerInputChange2;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope;
                            this.label = 1;
                            obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, this);
                        } else if (i == 1) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            pointerInputChange = (PointerInputChange) this.L$2;
                            pointerInputChange2 = (PointerInputChange) this.L$1;
                            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            PointerEvent pointerEvent = (PointerEvent) obj;
                            List<PointerInputChange> changes = pointerEvent.getChanges();
                            int size = changes.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    pointerInputChange = pointerEvent.getChanges().get(0);
                                    break;
                                }
                                if (!PointerEventKt.changedToUp(changes.get(i2))) {
                                    break;
                                }
                                i2++;
                            }
                            if (pointerInputChange == null) {
                                this.$state.m2305setUpDownDifferencek4lQ0M$foundation(Offset.m6084minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition()));
                                return Unit.INSTANCE;
                            }
                            this.L$0 = awaitPointerEventScope2;
                            this.L$1 = pointerInputChange2;
                            this.L$2 = pointerInputChange;
                            this.label = 2;
                            obj = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Initial, this);
                        }
                        this.$state.m2305setUpDownDifferencek4lQ0M$foundation(Offset.INSTANCE.m6096getZeroF1C5BW0());
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerInputChange = null;
                        pointerInputChange2 = (PointerInputChange) obj;
                        if (pointerInputChange == null) {
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00351(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super C00351> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00351(this.$this_pointerInput, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00361(this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00351(pointerInputScope, pagerState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }));
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1052364153, "C(rememberPagerItemProviderLambda)N(state,pageContent,key,pageCount)258@10763L33,259@10817L25,260@10854L742:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052364153, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:257)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 2004647903, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(stateRememberUpdatedState) | composer.changed(stateRememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$0(stateRememberUpdatedState, stateRememberUpdatedState2, function0);
                }
            });
            final State stateDerivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$1(stateDerivedStateOf, pagerState);
                }
            });
            objRememberedValue = (KProperty0) new PropertyReference0Impl(stateDerivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return kProperty0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$0$0(State state, State state2, Function0 function0) {
        return new PagerLayoutIntervalContent((Function4) state.getValue(), (Function1) state2.getValue(), ((Number) function0.invoke()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$0$1(State state, PagerState pagerState) {
        PagerLayoutIntervalContent pagerLayoutIntervalContent = (PagerLayoutIntervalContent) state.getValue();
        return new PagerLazyLayoutItemProvider(pagerState, pagerLayoutIntervalContent, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation(), pagerLayoutIntervalContent));
    }
}
