package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u000723\b\u0002\u0010\t\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a¦\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u001923\b\u0002\u0010\t\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d\"\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowMinimumTabWidth", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m9114constructorimpl(90.0f);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:126:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3202ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long primarySurface;
        long jM3001contentColorForek8zF_U;
        int i5;
        float f2;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final float f3;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM3198getScrollableTabRowPaddingD9Ej5fM;
        Modifier modifier3;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        Function2<? super Composer, ? super Integer, Unit> function2M3012getLambda$222041980$material;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1291546575);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRow)N(selectedTabIndex,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)237@11975L2929,237@11892L3012:TabRow.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    primarySurface = j;
                    int i9 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i4 |= i9;
                } else {
                    primarySurface = j;
                }
                i4 |= i9;
            } else {
                primarySurface = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    jM3001contentColorForek8zF_U = j2;
                    int i10 = composerStartRestartGroup.changed(jM3001contentColorForek8zF_U) ? 2048 : 1024;
                    i4 |= i10;
                } else {
                    jM3001contentColorForek8zF_U = j2;
                }
                i4 |= i10;
            } else {
                jM3001contentColorForek8zF_U = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    f2 = f;
                    i4 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 == 0) {
                    if ((196608 & i2) == 0) {
                        function32 = function3;
                        i4 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i2 & 12582912) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j3 = primarySurface;
                        j4 = jM3001contentColorForek8zF_U;
                        f3 = f2;
                        function33 = function32;
                        function23 = function2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            fM3198getScrollableTabRowPaddingD9Ej5fM = i5 != 0 ? TabRowDefaults.INSTANCE.m3198getScrollableTabRowPaddingD9Ej5fM() : f2;
                            ComposableLambda composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54) : function32;
                            if (i7 != 0) {
                                function2M3012getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m3012getLambda$222041980$material();
                                Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = composableLambdaRememberComposableLambda;
                                modifier3 = companion;
                                function34 = function35;
                            } else {
                                Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = composableLambdaRememberComposableLambda;
                                modifier3 = companion;
                                function34 = function36;
                                function2M3012getLambda$222041980$material = function2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            function2M3012getLambda$222041980$material = function2;
                            fM3198getScrollableTabRowPaddingD9Ej5fM = f2;
                            function34 = function32;
                            modifier3 = modifier;
                        }
                        long j5 = primarySurface;
                        long j6 = jM3001contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                        }
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function34;
                        final float f4 = fM3198getScrollableTabRowPaddingD9Ej5fM;
                        final Function2<? super Composer, ? super Integer, Unit> function24 = function2M3012getLambda$222041980$material;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m3172SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f4, function22, function24, function37, i, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function33 = function37;
                        function23 = function24;
                        f3 = fM3198getScrollableTabRowPaddingD9Ej5fM;
                        modifier2 = modifier3;
                        j3 = j5;
                        j4 = j6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function33, function23, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function32 = function3;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f2 = f;
            i6 = i3 & 32;
            if (i6 == 0) {
            }
            function32 = function3;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 32;
        if (i6 == 0) {
        }
        function32 = function3;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ScrollableTabRow_sKfQg0A$lambda$0(int i, List list, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(tabPositions)232@11660L70:TabRow.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-233732148, i2, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:232)");
        }
        TabRowDefaults.INSTANCE.m3195Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, (TabPosition) list.get(i)), 0.0f, 0L, composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ScrollableTabRow_sKfQg0A$lambda$1(final float f, final Function2 function2, final Function2 function22, final Function3 function3, final int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C238@12003L21,239@12054L24,241@12123L147,250@12521L2377,244@12279L2619:TabRow.kt#jmzs0o");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1575164555, i2, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:238)");
            }
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1904644280, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(scrollStateRememberScrollState) | composer.changed(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null)));
            ComposerKt.sourceInformationMarkerStart(composer, -1904629314, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged2 = composer.changed(f) | composer.changed(function2) | composer.changed(function22) | composer.changed(function3) | composer.changedInstance(scrollableTabData) | composer.changed(i);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1$1$0(f, function2, function22, scrollableTabData, i, function3, (SubcomposeMeasureScope) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) objRememberedValue3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ScrollableTabRow_sKfQg0A$lambda$1$1$0(float f, Function2 function2, final Function2 function22, final ScrollableTabData scrollableTabData, final int i, final Function3 function3, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        int i2 = subcomposeMeasureScope.mo1618roundToPx0680j_4(ScrollableTabRowMinimumTabWidth);
        final int i3 = subcomposeMeasureScope.mo1618roundToPx0680j_4(f);
        long jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(constraints.getValue(), i2, 0, 0, 0, 14, null);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size = listSubcompose.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(listSubcompose.get(i4).mo7769measureBRTryo0(jM9057copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i3 * 2;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        int size2 = arrayList2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = (Placeable) arrayList2.get(i5);
            intRef.element += placeable.getWidth();
            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
        }
        return MeasureScope.layout$default(subcomposeMeasureScope, intRef.element, intRef2.element, null, new Function1() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1$1$0$2(i3, arrayList2, subcomposeMeasureScope, function22, scrollableTabData, i, constraints, intRef, intRef2, function3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$1$1$0$2(int i, List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, ScrollableTabData scrollableTabData, int i2, Constraints constraints, Ref.IntRef intRef, Ref.IntRef intRef2, final Function3 function3, Placeable.PlacementScope placementScope) {
        final ArrayList arrayList = new ArrayList();
        int size = list.size();
        int width = i;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = (Placeable) list.get(i3);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, 0, 0.0f, 4, null);
            arrayList.add(new TabPosition(subcomposeMeasureScope.mo1621toDpu2uoSUM(width), subcomposeMeasureScope.mo1621toDpu2uoSUM(placeable.getWidth()), null));
            width += placeable.getWidth();
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeableMo7769measureBRTryo0 = listSubcompose.get(i4).mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(constraints.getValue(), intRef.element, intRef.element, 0, 0, 8, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo7769measureBRTryo0, 0, intRef2.element - placeableMo7769measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-43203918, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1$1$0$2$2(function3, arrayList, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i5).mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(intRef.element, intRef2.element)), 0, 0, 0.0f, 4, null);
        }
        scrollableTabData.onLaidOut(subcomposeMeasureScope, i, arrayList, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$1$1$0$2$2(Function3 function3, List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C292@14431L23:TabRow.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43203918, i, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:292)");
            }
            function3.invoke(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ScrollableTabRow_sKfQg0A$lambda$2(int i, Modifier modifier, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m3202ScrollableTabRowsKfQg0A(i, modifier, j, j2, f, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3203TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long primarySurface;
        long jM3001contentColorForek8zF_U;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final ComposableLambda composableLambdaRememberComposableLambda;
        int i7;
        final Function2<? super Composer, ? super Integer, Unit> function2M3011getLambda$1216856915$material;
        long j5;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(113221600);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRow)N(selectedTabIndex,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)150@7336L1392,146@7204L1524:TabRow.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    primarySurface = j;
                    int i11 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i4 |= i11;
                } else {
                    primarySurface = j;
                }
                i4 |= i11;
            } else {
                primarySurface = j;
            }
            if ((i2 & 3072) != 0) {
                jM3001contentColorForek8zF_U = j2;
                i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(jM3001contentColorForek8zF_U)) ? 2048 : 1024;
            } else {
                jM3001contentColorForek8zF_U = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    function32 = function3;
                    i4 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 == 0) {
                    if ((196608 & i2) == 0) {
                        function23 = function2;
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 599187) == 599186, i4 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j3 = primarySurface;
                        j4 = jM3001contentColorForek8zF_U;
                        function33 = function32;
                        function24 = function23;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i10 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            composableLambdaRememberComposableLambda = i5 != 0 ? ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54) : function32;
                            if (i6 != 0) {
                                long j6 = primarySurface;
                                i7 = i4;
                                function2M3011getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m3011getLambda$1216856915$material();
                                j5 = j6;
                                i8 = 1572864;
                            }
                            long j7 = jM3001contentColorForek8zF_U;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                i9 = i8;
                            } else {
                                i9 = i8;
                                ComposerKt.traceEventStart(113221600, i7, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                            }
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m3172SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j7, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$1(function22, function2M3011getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i7 & 896) | i9 | (i7 & 7168), 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = companion;
                            function33 = composableLambdaRememberComposableLambda;
                            j4 = j7;
                            function24 = function2M3011getLambda$1216856915$material;
                            j3 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            companion = modifier;
                            composableLambdaRememberComposableLambda = function32;
                        }
                        j5 = primarySurface;
                        i8 = 1572864;
                        i7 = i4;
                        function2M3011getLambda$1216856915$material = function23;
                        long j72 = jM3001contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m3172SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j72, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$1(function22, function2M3011getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i7 & 896) | i9 | (i7 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = companion;
                        function33 = composableLambdaRememberComposableLambda;
                        j4 = j72;
                        function24 = function2M3011getLambda$1216856915$material;
                        j3 = j5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function33, function24, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function23 = function2;
                if ((i2 & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 599187) == 599186, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 == 0) {
            }
            function23 = function2;
            if ((i2 & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 599187) == 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 == 0) {
        }
        function23 = function2;
        if ((i2 & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 599187) == 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit TabRow_pAZo6Ak$lambda$0(int i, List list, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(tabPositions)141@6972L70:TabRow.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896966245, i2, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:141)");
        }
        TabRowDefaults.INSTANCE.m3195Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, (TabPosition) list.get(i)), 0.0f, 0L, composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TabRow_pAZo6Ak$lambda$1(final Function2 function2, final Function2 function22, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@7388L1334,151@7346L1376:TabRow.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-638448612, i, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:151)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 631210194, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(function2) | composer.changed(function22) | composer.changed(function3);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1$0$0(function2, function22, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) objRememberedValue, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TabRow_pAZo6Ak$lambda$1$0$0(Function2 function2, final Function2 function22, final Function3 function3, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        int i;
        Object obj;
        final int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(constraints.getValue());
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        int size = listSubcompose.size();
        int i2 = iM9067getMaxWidthimpl / size;
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size2 = listSubcompose.size();
        int i3 = 0;
        while (i3 < size2) {
            int i4 = i2;
            arrayList.add(listSubcompose.get(i3).mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(constraints.getValue(), i4, i4, 0, 0, 12, null)));
            i3++;
            i2 = i4;
            listSubcompose = listSubcompose;
        }
        final int i5 = i2;
        final ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            obj = null;
            i = 0;
        } else {
            i = 0;
            obj = arrayList2.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = arrayList2.get(i6);
                    int height2 = ((Placeable) obj2).getHeight();
                    if (height < height2) {
                        obj = obj2;
                        height = height2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int height3 = placeable != null ? placeable.getHeight() : i;
        ArrayList arrayList3 = new ArrayList(size);
        for (int i7 = i; i7 < size; i7++) {
            arrayList3.add(new TabPosition(Dp.m9114constructorimpl(subcomposeMeasureScope.mo1621toDpu2uoSUM(i5) * i7), subcomposeMeasureScope.mo1621toDpu2uoSUM(i5), null));
        }
        final ArrayList arrayList4 = arrayList3;
        final int i8 = height3;
        return MeasureScope.layout$default(subcomposeMeasureScope, iM9067getMaxWidthimpl, i8, null, new Function1() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return TabRowKt.TabRow_pAZo6Ak$lambda$1$0$0$3(arrayList2, subcomposeMeasureScope, function22, i5, constraints, i8, function3, arrayList4, iM9067getMaxWidthimpl, (Placeable.PlacementScope) obj3);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$1$0$0$3(List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, int i, Constraints constraints, int i2, final Function3 function3, final List list2, int i3, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i4), i4 * i, 0, 0.0f, 4, null);
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeableMo7769measureBRTryo0 = listSubcompose.get(i5).mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 11, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo7769measureBRTryo0, 0, i2 - placeableMo7769measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-220665376, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TabRowKt.TabRow_pAZo6Ak$lambda$1$0$0$3$2(function3, list2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i6 = 0; i6 < size3; i6++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i6).mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(i3, i2)), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$1$0$0$3$2(Function3 function3, List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C176@8515L23:TabRow.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-220665376, i, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:176)");
            }
            function3.invoke(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TabRow_pAZo6Ak$lambda$2(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m3203TabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }
}
