package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u008d\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00172\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010#\u001aO\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b+\u0010,\u001a?\u0010-\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000e2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0001\u0010.\u001a\u00020'H\u0003¢\u0006\u0002\u0010/\u001a#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108\u001a5\u00109\u001a\u000201*\u0002022\u0006\u0010:\u001a\u0002042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0001\u0010.\u001a\u00020'H\u0002¢\u0006\u0004\b;\u0010<\"\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020'0>X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010?\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010C\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010D\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010E\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u000e\u0010F\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G²\u0006\n\u0010*\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", FirebaseAnalytics.Param.CONTENT, "NavigationRail-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", Constants.ScionAnalytics.PARAM_LABEL, "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailTransition", "activeColor", "inactiveColor", "", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "NavigationRailItemSize", "F", "NavigationRailItemCompactSize", "NavigationRailPadding", "HeaderPadding", "ItemLabelBaselineBottomOffset", "ItemIconTopOffset", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float NavigationRailItemSize = Dp.m9114constructorimpl(72.0f);
    private static final float NavigationRailItemCompactSize = Dp.m9114constructorimpl(56.0f);
    private static final float NavigationRailPadding = Dp.m9114constructorimpl(8.0f);
    private static final float HeaderPadding = Dp.m9114constructorimpl(8.0f);
    private static final float ItemLabelBaselineBottomOffset = Dp.m9114constructorimpl(16.0f);
    private static final float ItemIconTopOffset = Dp.m9114constructorimpl(14.0f);
    private static final WindowInsets ZeroInsets = WindowInsetsKt.m2109WindowInsetsa9UjIt4$default(Dp.m9114constructorimpl(0.0f), 0.0f, 0.0f, 0.0f, 14, null);

    /* JADX WARN: Removed duplicated region for block: B:106:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c6  */
    /* JADX INFO: renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3086NavigationRailHsRjFd4(Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM2987getSurface0d7_KjU;
        long j3;
        float fM3084getElevationD9Ej5fM;
        int i4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        final float f2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        int i5;
        Modifier modifier4;
        long j6;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2116369751);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,header,content)173@7644L95:NavigationRail.kt#jmzs0o");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                jM2987getSurface0d7_KjU = j;
                int i8 = composerStartRestartGroup.changed(jM2987getSurface0d7_KjU) ? 32 : 16;
                i3 |= i8;
            } else {
                jM2987getSurface0d7_KjU = j;
            }
            i3 |= i8;
        } else {
            jM2987getSurface0d7_KjU = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j2;
                int i9 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                i3 |= i9;
            } else {
                j3 = j2;
            }
            i3 |= i9;
        } else {
            j3 = j2;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                fM3084getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM3084getElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function33 = function3;
                    i3 |= composerStartRestartGroup.changedInstance(function33) ? 16384 : 8192;
                }
                if ((196608 & i) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "167@7399L6,168@7441L32");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM3001contentColorForek8zF_U;
                        }
                        if (i10 != 0) {
                            fM3084getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m3084getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            function35 = null;
                            j6 = jM2987getSurface0d7_KjU;
                            f3 = fM3084getElevationD9Ej5fM;
                            i5 = -2116369751;
                            modifier4 = companion;
                        } else {
                            f3 = fM3084getElevationD9Ej5fM;
                            function35 = function33;
                            i5 = -2116369751;
                            modifier4 = companion;
                            j6 = jM2987getSurface0d7_KjU;
                        }
                        i6 = 6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        f3 = fM3084getElevationD9Ej5fM;
                        function35 = function33;
                        i6 = 6;
                        i5 = -2116369751;
                        modifier4 = modifier2;
                        j6 = jM2987getSurface0d7_KjU;
                    }
                    long j7 = j3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:172)");
                    }
                    int i11 = i3 << 3;
                    composer2 = composerStartRestartGroup;
                    m3087NavigationRailafqeVBk(ZeroInsets, modifier4, j6, j7, f3, function35, function32, composer2, i6 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (i11 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j4 = j6;
                    j5 = j7;
                    f2 = f3;
                    function34 = function35;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = jM2987getSurface0d7_KjU;
                    j5 = j3;
                    f2 = fM3084getElevationD9Ej5fM;
                    function34 = function33;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_HsRjFd4$lambda$0(modifier3, j4, j5, f2, function34, function32, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            function33 = function3;
            if ((196608 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM3084getElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        function33 = function3;
        if ((196608 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
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
    /* JADX INFO: renamed from: NavigationRail-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3087NavigationRailafqeVBk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        long jM2987getSurface0d7_KjU;
        long jM3001contentColorForek8zF_U;
        int i4;
        float f2;
        int i5;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final float f3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f4;
        long j5;
        int i6;
        Modifier modifier3;
        int i7;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-171916405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,header,content)114@5148L442,109@5003L587:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    jM2987getSurface0d7_KjU = j;
                    int i9 = composerStartRestartGroup.changed(jM2987getSurface0d7_KjU) ? 256 : 128;
                    i3 |= i9;
                } else {
                    jM2987getSurface0d7_KjU = j;
                }
                i3 |= i9;
            } else {
                jM2987getSurface0d7_KjU = j;
            }
            if ((i & 3072) != 0) {
                jM3001contentColorForek8zF_U = j2;
                i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(jM3001contentColorForek8zF_U)) ? 2048 : 1024;
            } else {
                jM3001contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    f2 = f;
                    i3 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        function33 = function3;
                        i3 |= composerStartRestartGroup.changedInstance(function33) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j3 = jM2987getSurface0d7_KjU;
                        j4 = jM3001contentColorForek8zF_U;
                        f3 = f2;
                        function34 = function33;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i2 & 4) != 0) {
                                jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            float fM3084getElevationD9Ej5fM = i4 != 0 ? NavigationRailDefaults.INSTANCE.m3084getElevationD9Ej5fM() : f2;
                            if (i5 != 0) {
                                function34 = null;
                                long j7 = jM3001contentColorForek8zF_U;
                                modifier3 = companion;
                                i7 = 1572864;
                                j6 = j7;
                                f4 = fM3084getElevationD9Ej5fM;
                                j5 = jM2987getSurface0d7_KjU;
                                i6 = -171916405;
                            } else {
                                f4 = fM3084getElevationD9Ej5fM;
                                j5 = jM2987getSurface0d7_KjU;
                                function34 = function33;
                                i6 = -171916405;
                                long j8 = jM3001contentColorForek8zF_U;
                                modifier3 = companion;
                                i7 = 1572864;
                                j6 = j8;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            f4 = f2;
                            function34 = function33;
                            i7 = 1572864;
                            i6 = -171916405;
                            j5 = jM2987getSurface0d7_KjU;
                            j6 = jM3001contentColorForek8zF_U;
                            modifier3 = modifier;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m3172SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function34, function32, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, i7 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = j5;
                        j4 = j6;
                        f3 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function34, function32, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function33 = function3;
                if ((i & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f2 = f;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            function33 = function3;
            if ((i & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        function33 = function3;
        if ((i & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    /* JADX INFO: renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3088NavigationRailItem0S3VyRs(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        final boolean z5;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MutableInteractionSource mutableInteractionSource3;
        long jM2983getPrimary0d7_KjU;
        int i11;
        long jM6324copywmQWz5c$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(83562179);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)227@10507L773:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i12 = i2 & 8;
        if (i12 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        function23 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else {
                        if ((1572864 & i) == 0) {
                            z5 = z3;
                            i3 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                        i7 = i2 & 128;
                        if (i7 == 0) {
                            if ((i & 12582912) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                            }
                            if ((i & 100663296) != 0) {
                                i9 = i3 | (((i2 & 256) == 0 && composerStartRestartGroup.changed(j)) ? 67108864 : 33554432);
                            } else {
                                i9 = i3;
                            }
                            if ((i & 805306368) != 0) {
                                i9 |= ((i2 & 512) == 0 && composerStartRestartGroup.changed(j2)) ? 536870912 : 268435456;
                            }
                            i10 = i9;
                            if (composerStartRestartGroup.shouldExecute((i10 & 306783379) == 306783378, i10 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                z6 = z4;
                                function24 = function23;
                                j3 = j;
                                j4 = j2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                                ComposableLambda composableLambdaRememberComposableLambda = null;
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i12 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z4 = true;
                                    }
                                    if (i5 != 0) {
                                        function23 = null;
                                    }
                                    if (i6 != 0) {
                                        z5 = true;
                                    }
                                    mutableInteractionSource3 = i8 != 0 ? null : mutableInteractionSource;
                                    if ((i2 & 256) != 0) {
                                        jM2983getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2983getPrimary0d7_KjU();
                                        i11 = i10 & (-234881025);
                                    } else {
                                        jM2983getPrimary0d7_KjU = j;
                                        i11 = i10;
                                    }
                                    if ((i2 & 512) != 0) {
                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(((Color) objConsume).m6335unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                        i11 &= -1879048193;
                                    } else {
                                        jM6324copywmQWz5c$default = j2;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    int i13 = (i2 & 256) != 0 ? i10 & (-234881025) : i10;
                                    if ((i2 & 512) != 0) {
                                        i13 &= -1879048193;
                                    }
                                    jM2983getPrimary0d7_KjU = j;
                                    jM6324copywmQWz5c$default = j2;
                                    i11 = i13;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(83562179, i11, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                                }
                                if (function23 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function23, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                final ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                boolean z7 = z4;
                                Modifier modifierM2083size3ABfNKs = SizeKt.m2083size3ABfNKs(SelectableKt.m2307selectableO2vRcR0(modifier2, z, mutableInteractionSource4, RippleKt.m3125rippleH2RKhps$default(false, 0.0f, jM2983getPrimary0d7_KjU, 2, null), z7, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2083size3ABfNKs);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                                int i14 = i11 >> 24;
                                m3089NavigationRailTransitionKlgxPg(jM2983getPrimary0d7_KjU, jM6324copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 3072 | ((i11 << 6) & 896));
                                composer2 = composerStartRestartGroup;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource2 = mutableInteractionSource4;
                                function24 = function23;
                                z6 = z7;
                                j4 = jM6324copywmQWz5c$default;
                                j3 = jM2983getPrimary0d7_KjU;
                            }
                            final Modifier modifier3 = modifier2;
                            final boolean z8 = z5;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z6, function24, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 12582912;
                        i8 = i7;
                        if ((i & 100663296) != 0) {
                        }
                        if ((i & 805306368) != 0) {
                        }
                        i10 = i9;
                        if (composerStartRestartGroup.shouldExecute((i10 & 306783379) == 306783378, i10 & 1)) {
                        }
                        final Modifier modifier32 = modifier2;
                        final boolean z82 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z5 = z3;
                    i7 = i2 & 128;
                    if (i7 == 0) {
                    }
                    i8 = i7;
                    if ((i & 100663296) != 0) {
                    }
                    if ((i & 805306368) != 0) {
                    }
                    i10 = i9;
                    if (composerStartRestartGroup.shouldExecute((i10 & 306783379) == 306783378, i10 & 1)) {
                    }
                    final Modifier modifier322 = modifier2;
                    final boolean z822 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function23 = function22;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                z5 = z3;
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i & 100663296) != 0) {
                }
                if ((i & 805306368) != 0) {
                }
                i10 = i9;
                if (composerStartRestartGroup.shouldExecute((i10 & 306783379) == 306783378, i10 & 1)) {
                }
                final Modifier modifier3222 = modifier2;
                final boolean z8222 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function23 = function22;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            z5 = z3;
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i & 100663296) != 0) {
            }
            if ((i & 805306368) != 0) {
            }
            i10 = i9;
            if (composerStartRestartGroup.shouldExecute((i10 & 306783379) == 306783378, i10 & 1)) {
            }
            final Modifier modifier32222 = modifier2;
            final boolean z82222 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z4 = z2;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function23 = function22;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        z5 = z3;
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i & 100663296) != 0) {
        }
        if ((i & 805306368) != 0) {
        }
        i10 = i9;
        if (composerStartRestartGroup.shouldExecute((i10 & 306783379) == 306783378, i10 & 1)) {
        }
        final Modifier modifier322222 = modifier2;
        final boolean z822222 = z5;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1276874318);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItemBaselineLayout)N(icon,label,iconPositionAnimationProgress)323@13918L928,318@13720L1126:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1276874318, i2, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:317)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1284440530, "CC(remember):NavigationRail.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 896) == 256);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeableMo7769measureBRTryo0;
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            Measurable measurable = list.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                                Placeable placeableMo7769measureBRTryo02 = measurable.mo7769measureBRTryo0(j);
                                if (function22 != null) {
                                    int size2 = list2.size();
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        Measurable measurable2 = list.get(i4);
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), Constants.ScionAnalytics.PARAM_LABEL)) {
                                            placeableMo7769measureBRTryo0 = measurable2.mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                        }
                                    }
                                    ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                    throw new KotlinNothingValueException();
                                }
                                placeableMo7769measureBRTryo0 = null;
                                if (function22 == null) {
                                    return NavigationRailKt.m3092placeIcon3p2s80s(measureScope, placeableMo7769measureBRTryo02, j);
                                }
                                Intrinsics.checkNotNull(placeableMo7769measureBRTryo0);
                                return NavigationRailKt.m3093placeLabelAndIconDIyivk0(measureScope, placeableMo7769measureBRTryo0, placeableMo7769measureBRTryo02, j, f);
                            }
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1177287557, "C319@13737L41:NavigationRail.kt#jmzs0o");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -491319352, "C319@13770L6:NavigationRail.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-1177221249);
                ComposerKt.sourceInformation(composerStartRestartGroup, "321@13820L80");
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, Constants.ScionAnalytics.PARAM_LABEL), f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlpha);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1391280638, "C321@13891L7:NavigationRail.kt#jmzs0o");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1190921017);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItemBaselineLayout$lambda$2(function2, function22, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationRailItemBaselineLayout$lambda$2(Function2 function2, Function2 function22, float f, int i, Composer composer, int i2) {
        NavigationRailItemBaselineLayout(function2, function22, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem_0S3VyRs$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C215@9773L10,216@9843L40:NavigationRail.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-674640273, i, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:215)");
            }
            TextKt.ProvideTextStyle(TextStyle.m8569copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8992getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem_0S3VyRs$lambda$1$0(boolean z, Function2 function2, Function2 function22, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(progress)244@11084L180:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i |= composer.changed(f) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(317431928, i, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:242)");
            }
            if (z) {
                f = 1.0f;
            }
            NavigationRailItemBaselineLayout(function2, function22, f, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit NavigationRailItem_0S3VyRs$lambda$2(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3088NavigationRailItem0S3VyRs(z, function0, function2, modifier, z2, function22, z3, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    private static final void m3089NavigationRailTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(140356545);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)287@12657L139,297@13010L42,294@12871L181:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(140356545, i2, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:285)");
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            long jM6376lerpjxsXWHM = ColorKt.m6376lerpjxsXWHM(j2, j, NavigationRailTransition_Klgx_Pg$lambda$0(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(Color.m6324copywmQWz5c$default(jM6376lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(jM6376lerpjxsXWHM)))}, ComposableLambdaKt.rememberComposableLambda(1330097921, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailTransition_Klgx_Pg$lambda$1(function3, stateAnimateFloatAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailTransition_Klgx_Pg$lambda$2(j, j2, z, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float NavigationRailTransition_Klgx_Pg$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit NavigationRailTransition_Klgx_Pg$lambda$1(Function3 function3, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C298@13020L26:NavigationRail.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1330097921, i, -1, "androidx.compose.material.NavigationRailTransition.<anonymous> (NavigationRail.kt:298)");
            }
            function3.invoke(Float.valueOf(NavigationRailTransition_Klgx_Pg$lambda$0(state)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit NavigationRailTransition_Klgx_Pg$lambda$2(long j, long j2, boolean z, Function3 function3, int i, Composer composer, int i2) {
        m3089NavigationRailTransitionKlgxPg(j, j2, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationRail_HsRjFd4$lambda$0(Modifier modifier, long j, long j2, float f, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        m3086NavigationRailHsRjFd4(modifier, j, j2, f, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit NavigationRail_afqeVBk$lambda$0(WindowInsets windowInsets, Function3 function3, Function3 function32, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5158L426:NavigationRail.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(366031815, i, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:115)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m2039paddingVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), 0.0f, NavigationRailPadding, 1, null));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSelectableGroup);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1703433687, "C126@5565L9:NavigationRail.kt#jmzs0o");
            if (function3 != null) {
                composer.startReplaceGroup(-1703415150);
                ComposerKt.sourceInformation(composer, "123@5475L8,124@5500L38");
                function3.invoke(columnScopeInstance, composer, 6);
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, HeaderPadding), composer, 6);
            } else {
                composer.startReplaceGroup(-1708832431);
            }
            composer.endReplaceGroup();
            function32.invoke(columnScopeInstance, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit NavigationRail_afqeVBk$lambda$1(WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        m3087NavigationRailafqeVBk(windowInsets, modifier, j, j2, f, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m3092placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        final int iMax = Math.max(0, (Constraints.m9067getMaxWidthimpl(j) - placeable.getWidth()) / 2);
        final int iMax2 = Math.max(0, (Constraints.m9066getMaxHeightimpl(j) - placeable.getHeight()) / 2);
        return MeasureScope.layout$default(measureScope, Constraints.m9067getMaxWidthimpl(j), Constraints.m9066getMaxHeightimpl(j), null, new Function1() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeIcon_3p2s80s$lambda$0(placeable, iMax, iMax2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeIcon_3p2s80s$lambda$0(Placeable placeable, int i, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m3093placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        final int iM9066getMaxHeightimpl = (Constraints.m9066getMaxHeightimpl(j) - placeable.get(AlignmentLineKt.getLastBaseline())) - measureScope.mo1618roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        final int iM9067getMaxWidthimpl = (Constraints.m9067getMaxWidthimpl(j) - placeable.getWidth()) / 2;
        final int i = measureScope.mo1618roundToPx0680j_4(ItemIconTopOffset);
        int iM9066getMaxHeightimpl2 = (Constraints.m9066getMaxHeightimpl(j) - placeable2.getHeight()) / 2;
        final int iM9067getMaxWidthimpl2 = (Constraints.m9067getMaxWidthimpl(j) - placeable2.getWidth()) / 2;
        final int iRoundToInt = MathKt.roundToInt((iM9066getMaxHeightimpl2 - i) * (1.0f - f));
        return MeasureScope.layout$default(measureScope, Constraints.m9067getMaxWidthimpl(j), Constraints.m9066getMaxHeightimpl(j), null, new Function1() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeLabelAndIcon_DIyivk0$lambda$0(f, placeable, iM9067getMaxWidthimpl, iM9066getMaxHeightimpl, iRoundToInt, placeable2, iM9067getMaxWidthimpl2, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeLabelAndIcon_DIyivk0$lambda$0(float f, Placeable placeable, int i, int i2, int i3, Placeable placeable2, int i4, int i5, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        if (f == 0.0f) {
            placementScope2 = placementScope;
        } else {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2 + i3, 0.0f, 4, null);
            placementScope2 = placementScope;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, i4, i5 + i3, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
