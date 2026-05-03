package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.muxer.MuxerUtil;
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
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NavigationBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001a\u007f\u0010 \u001a\u00020\u00012\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000e2\u0006\u0010\u001a\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0016H\u0003¢\u0006\u0002\u0010&\u001a5\u0010'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101\u001aM\u00102\u001a\u00020(*\u00020)2\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u00104\u001a\u00020$H\u0002¢\u0006\u0004\b5\u00106\"\u000e\u00107\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010<\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010>\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\b?\u0010@\"\u0016\u0010A\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bB\u0010@\"\u0010\u0010C\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010D\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bE\u0010@\"\u0010\u0010F\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010G\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bH\u0010@\"\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M¨\u0006N²\u0006\n\u0010O\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010P\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020RX\u008a\u008e\u0002"}, d2 = {"NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationBarKt.IconLayoutIdTag, "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, NavigationBarKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationBarHeight", "F", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "IndicatorVerticalOffset", "NavigationBarItemToIconMinimumPadding", "getNavigationBarItemToIconMinimumPadding", "LocalNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationBarOverride;", "getLocalNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor", "itemWidth", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m5129getTallContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m9114constructorimpl(8.0f);
    private static final float NavigationBarIndicatorToLabelPadding = Dp.m9114constructorimpl(4.0f);
    private static final float IndicatorHorizontalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5131getActiveIndicatorWidthD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5133getIconSizeD9Ej5fM()) / 2.0f);
    private static final float IndicatorVerticalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5130getActiveIndicatorHeightD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5133getIconSizeD9Ej5fM()) / 2.0f);
    private static final float IndicatorVerticalOffset = Dp.m9114constructorimpl(12.0f);
    private static final float NavigationBarItemToIconMinimumPadding = Dp.m9114constructorimpl(44.0f);
    private static final ProvidableCompositionLocal<NavigationBarOverride> LocalNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultNavigationBarOverride.INSTANCE;
        }
    }, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:108:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /* JADX INFO: renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3850NavigationBarHsRjFd4(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM3478contentColorFor4WTKRHQ;
        float fM3835getElevationD9Ej5fM;
        WindowInsets windowInsets2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier3;
        final long j3;
        final long j4;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        WindowInsets windowInsets4;
        long j5;
        long j6;
        float f3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1054099326);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,windowInsets,content)119@5618L7,*128@5952L15:NavigationBar.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
                containerColor = j;
                int i5 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i3 |= i5;
            } else {
                containerColor = j;
            }
            i3 |= i5;
        } else {
            containerColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM3478contentColorFor4WTKRHQ = j2;
                int i6 = composerStartRestartGroup.changed(jM3478contentColorFor4WTKRHQ) ? 256 : 128;
                i3 |= i6;
            } else {
                jM3478contentColorFor4WTKRHQ = j2;
            }
            i3 |= i6;
        } else {
            jM3478contentColorFor4WTKRHQ = j2;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                fM3835getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM3835getElevationD9Ej5fM) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    int i8 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                    i3 |= i8;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 32) != 0) {
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    function32 = function3;
                    i3 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@5304L14,114@5360L11,116@5518L12");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM3478contentColorFor4WTKRHQ = ColorSchemeKt.m3478contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                            i3 &= -897;
                        }
                        if (i7 != 0) {
                            fM3835getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m3835getElevationD9Ej5fM();
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            modifier3 = companion;
                            windowInsets4 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            j5 = containerColor;
                            j6 = jM3478contentColorFor4WTKRHQ;
                            f3 = fM3835getElevationD9Ej5fM;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1054099326, i3, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:118)");
                            }
                            ProvidableCompositionLocal<NavigationBarOverride> providableCompositionLocal = LocalNavigationBarOverride;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ((NavigationBarOverride) objConsume).NavigationBar(new NavigationBarOverrideScope(modifier3, j5, j6, f3, windowInsets4, function32, null), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j5;
                            j4 = j6;
                            f2 = f3;
                            windowInsets3 = windowInsets4;
                        } else {
                            modifier3 = companion;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        modifier3 = modifier2;
                    }
                    j5 = containerColor;
                    j6 = jM3478contentColorFor4WTKRHQ;
                    f3 = fM3835getElevationD9Ej5fM;
                    windowInsets4 = windowInsets2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<NavigationBarOverride> providableCompositionLocal2 = LocalNavigationBarOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((NavigationBarOverride) objConsume2).NavigationBar(new NavigationBarOverrideScope(modifier3, j5, j6, f3, windowInsets4, function32, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j3 = j5;
                    j4 = j6;
                    f2 = f3;
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = containerColor;
                    j4 = jM3478contentColorFor4WTKRHQ;
                    f2 = fM3835getElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBar_HsRjFd4$lambda$1(modifier4, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function32 = function3;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM3835getElevationD9Ej5fM = f;
        if ((i & 24576) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBarItem(final RowScope rowScope, final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        final Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        boolean z5;
        char c;
        int i7;
        int i8;
        int i9;
        final NavigationBarItemColors navigationBarItemColors2;
        Composer composer2;
        final boolean z6;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        NavigationBarItemColors navigationBarItemColorsColors;
        int i10;
        NavigationBarItemColors navigationBarItemColors3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z8;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i11;
        boolean z9;
        MutableInteractionSource mutableInteractionSource4;
        NavigationBarItemColors navigationBarItemColors4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        ComposableLambda composableLambda;
        Composer composerStartRestartGroup = composer.startRestartGroup(974293026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBarItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,colors,interactionSource)209@9556L14,211@9612L618,241@10880L33,255@11322L24,243@10919L3178:NavigationBar.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 2) != 0) {
            i3 |= 384;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i12 = i2 & 8;
        if (i12 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i) == 0) {
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        function23 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 12582912) == 0) {
                            c = ' ';
                            i3 |= composerStartRestartGroup.changed(z5) ? 8388608 : 4194304;
                        }
                        if ((i & 100663296) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(navigationBarItemColors)) ? 67108864 : 33554432;
                        }
                        i7 = i2 & 256;
                        if (i7 == 0) {
                            if ((i & 805306368) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                            }
                            i9 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i9 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                navigationBarItemColors2 = navigationBarItemColors;
                                composer2 = composerStartRestartGroup;
                                z6 = z4;
                                z7 = z5;
                                function24 = function23;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "203@9226L8");
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
                                    if ((i2 & 128) != 0) {
                                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i10 = i9 & (-234881025);
                                    } else {
                                        navigationBarItemColorsColors = navigationBarItemColors;
                                        i10 = i9;
                                    }
                                    if (i8 != 0) {
                                        mutableInteractionSource3 = null;
                                        z8 = z5;
                                        navigationBarItemColors3 = navigationBarItemColorsColors;
                                    } else {
                                        navigationBarItemColors3 = navigationBarItemColorsColors;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        z8 = z5;
                                    }
                                    modifier3 = modifier2;
                                    function25 = function23;
                                    i11 = i10;
                                    z9 = z4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        z9 = z4;
                                        z8 = z5;
                                        modifier3 = modifier2;
                                        function25 = function23;
                                        i11 = i9 & (-234881025);
                                        navigationBarItemColors3 = navigationBarItemColors;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        z9 = z4;
                                        z8 = z5;
                                        navigationBarItemColors3 = navigationBarItemColors;
                                        modifier3 = modifier2;
                                        function25 = function23;
                                        i11 = i9;
                                    }
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(974293026, i11, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:205)");
                                }
                                if (mutableInteractionSource3 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-224963495);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "207@9378L39");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7256887, "CC(remember):NavigationBar.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-7257538);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                                Modifier modifier4 = modifier3;
                                boolean z10 = z8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new NavigationBarKt$NavigationBarItem$styledIcon$1(navigationBarItemColors3, z, z9, finiteAnimationSpecValue, function25, z8, function2), composerStartRestartGroup, 54);
                                if (function25 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-224036658);
                                    composerStartRestartGroup.endReplaceGroup();
                                    navigationBarItemColors4 = navigationBarItemColors3;
                                    function26 = function25;
                                    composableLambda = null;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-224036657);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*226@10326L521");
                                    final NavigationBarItemColors navigationBarItemColors5 = navigationBarItemColors3;
                                    final boolean z11 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                    navigationBarItemColors4 = navigationBarItemColors5;
                                    function26 = function27;
                                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
                                        private static final long invoke$lambda$0(State<Color> state) {
                                            return state.getValue().m6335unboximpl();
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i13) {
                                            ComposerKt.sourceInformation(composer3, "C227@10390L5,229@10449L198,233@10664L169:NavigationBar.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(802208206, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:227)");
                                            }
                                            ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(navigationBarItemColors5.m3847textColorWaAFU9c$material3(z, z11), finiteAnimationSpecValue, null, null, composer3, 0, 12)), TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composer3, 6), function27, composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54);
                                    composerStartRestartGroup.endReplaceGroup();
                                    composableLambda = composableLambdaRememberComposableLambda2;
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7208829, "CC(remember):NavigationBar.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                boolean z12 = z9;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.m2068defaultMinSizeVpY3zN4$default(SelectableKt.m2307selectableO2vRcR0(modifier4, z, mutableInteractionSource5, null, z12, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function02), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7194694, "CC(remember):NavigationBar.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NavigationBarKt.NavigationBarItem$lambda$8$lambda$7(mutableIntState, (IntSize) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default, (Function1) objRememberedValue3);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, true);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565191211, "C263@11734L7,260@11504L252,269@12046L7,266@11819L249,275@12351L7,281@12645L128,288@12988L273,296@13310L404,313@13979L32,314@14049L31,307@13724L367:NavigationBar.kt#uh7d8r");
                                NavigationBarItemColors navigationBarItemColors6 = navigationBarItemColors4;
                                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                                final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((NavigationBarItem$lambda$5(mutableIntState) - r2.mo1618roundToPx0680j_4(NavigationBarVerticalItemTokens.INSTANCE.m5131getActiveIndicatorWidthD9Ej5fM())) / 2.0f)) << c) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(((Density) objConsume).mo1624toPx0680j_4(IndicatorVerticalOffset)))));
                                Unit unit = Unit.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196471708, "CC(remember):NavigationBar.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(jM6072constructorimpl);
                                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, jM6072constructorimpl, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i13) {
                                        ComposerKt.sourceInformation(composer3, "C291@13152L5,289@13006L241:NavigationBar.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2082182507, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:289)");
                                        }
                                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composer3, 6)), mappedInteractionSource, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54);
                                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new NavigationBarKt$NavigationBarItem$2$indicator$1(stateAnimateFloatAsState, navigationBarItemColors6), composerStartRestartGroup, 54);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196514300, "CC(remember):NavigationBar.kt#9igjgp");
                                boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Float.valueOf(((Number) stateAnimateFloatAsState.getValue()).floatValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                Function0 function03 = (Function0) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516539, "CC(remember):NavigationBar.kt#9igjgp");
                                boolean zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Float.valueOf(((Number) stateAnimateFloatAsState2.getValue()).floatValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                NavigationBarItemLayout(composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda, composableLambda, z10, function03, (Function0) objRememberedValue6, composerStartRestartGroup, ((i11 >> 9) & 57344) | 438);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                navigationBarItemColors2 = navigationBarItemColors6;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                z6 = z12;
                                z7 = z10;
                                function24 = function26;
                                modifier2 = modifier4;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationBarKt.NavigationBarItem$lambda$16(rowScope, z, function0, function2, modifier2, z6, function24, z7, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        i8 = i7;
                        i9 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i9 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    c = ' ';
                    if ((i & 100663296) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                    }
                    i8 = i7;
                    i9 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function23 = function22;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                c = ' ';
                if ((i & 100663296) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                i9 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i9 & 1)) {
                }
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
            c = ' ';
            if ((i & 100663296) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            i9 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i9 & 1)) {
            }
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
        c = ' ';
        if ((i & 100663296) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        i9 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit NavigationBarItem$lambda$16(RowScope rowScope, boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationBarItem(rowScope, z, function0, function2, modifier, z2, function22, z3, navigationBarItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final int NavigationBarItem$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    static final Unit NavigationBarItem$lambda$8$lambda$7(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.setIntValue((int) (intSize.m9289unboximpl() >> 32));
        return Unit.INSTANCE;
    }

    private static final void NavigationBarItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, final Function0<Float> function02, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1019541078);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBarItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)572@25349L1844,554@24828L2365:NavigationBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1019541078, i2, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:553)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526403586, "CC(remember):NavigationBar.kt#9igjgp");
            int i3 = 57344 & i2;
            boolean z2 = ((3670016 & i2) == 1048576) | ((i2 & 7168) == 2048) | (i3 == 16384);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeableMo7769measureBRTryo0;
                        Measurable measurable;
                        MeasureScope measureScope2 = measureScope;
                        float fCoerceAtLeast = RangesKt.coerceAtLeast(function02.invoke().floatValue(), 0.0f);
                        long jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Measurable measurable2 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable placeableMo7769measureBRTryo02 = measurable2.mo7769measureBRTryo0(jM9057copyZbe2FdA$default);
                                int width = placeableMo7769measureBRTryo02.getWidth() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * 2.0f));
                                int iRoundToInt = MathKt.roundToInt(width * fCoerceAtLeast);
                                int height = placeableMo7769measureBRTryo02.getHeight() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * 2.0f));
                                int size2 = list2.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    Measurable measurable3 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable placeableMo7769measureBRTryo03 = measurable3.mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(width, height));
                                        int size3 = list2.size();
                                        int i6 = 0;
                                        while (true) {
                                            placeableMo7769measureBRTryo0 = null;
                                            if (i6 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i6);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i6++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable placeableMo7769measureBRTryo04 = measurable4 != null ? measurable4.mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(iRoundToInt, height)) : null;
                                        if (function24 != null) {
                                            int size4 = list2.size();
                                            for (int i7 = 0; i7 < size4; i7++) {
                                                Measurable measurable5 = list.get(i7);
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), Constants.ScionAnalytics.PARAM_LABEL)) {
                                                    placeableMo7769measureBRTryo0 = measurable5.mo7769measureBRTryo0(jM9057copyZbe2FdA$default);
                                                }
                                            }
                                            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                            throw new KotlinNothingValueException();
                                        }
                                        if (function24 == null) {
                                            return NavigationBarKt.m3853placeIconX9ElhV4(measureScope, placeableMo7769measureBRTryo02, placeableMo7769measureBRTryo03, placeableMo7769measureBRTryo04, j);
                                        }
                                        Intrinsics.checkNotNull(placeableMo7769measureBRTryo0);
                                        return NavigationBarKt.m3854placeLabelAndIconzUg2_y0(measureScope, placeableMo7769measureBRTryo0, placeableMo7769measureBRTryo02, placeableMo7769measureBRTryo03, placeableMo7769measureBRTryo04, j, z, fCoerceAtLeast);
                                    }
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i4++;
                            measureScope2 = measureScope;
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
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660603938, "C557@24911L17,558@24941L11,560@24966L50:NavigationBar.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IconLayoutIdTag);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1252746358, "C560@25008L6:NavigationBar.kt#uh7d8r");
            function23.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function24 != null) {
                composerStartRestartGroup.startReplaceGroup(-660471321);
                ComposerKt.sourceInformation(composerStartRestartGroup, "564@25142L109,563@25067L250");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1641265262, "CC(remember):NavigationBar.kt#9igjgp");
                boolean z3 = (i3 == 16384) | ((i4 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItemLayout$lambda$22$lambda$20$lambda$19(z, function0, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId2, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 874979034, "C568@25292L7:NavigationBar.kt#uh7d8r");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-660200319);
                composerStartRestartGroup.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBarItemLayout$lambda$23(function2, function22, function23, function24, z, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationBarItemLayout$lambda$22$lambda$20$lambda$19(boolean z, Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    static final Unit NavigationBarItemLayout$lambda$23(Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NavigationBarItemLayout(function2, function22, function23, function24, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationBar_HsRjFd4$lambda$1(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3850NavigationBarHsRjFd4(modifier, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    public static final ProvidableCompositionLocal<NavigationBarOverride> getLocalNavigationBarOverride() {
        return LocalNavigationBarOverride;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemToIconMinimumPadding() {
        return NavigationBarItemToIconMinimumPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3853placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int width = Constraints.m9067getMaxWidthimpl(j) == Integer.MAX_VALUE ? placeable.getWidth() + (measureScope.mo1618roundToPx0680j_4(NavigationBarItemToIconMinimumPadding) * 2) : Constraints.m9067getMaxWidthimpl(j);
        final int iM9083constrainHeightK40F9xA = ConstraintsKt.m9083constrainHeightK40F9xA(j, measureScope.mo1618roundToPx0680j_4(NavigationBarHeight));
        final int width2 = (width - placeable.getWidth()) / 2;
        final int height = (iM9083constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width3 = (width - placeable2.getWidth()) / 2;
        final int height2 = (iM9083constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, width, iM9083constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBarKt.placeIcon_X9ElhV4$lambda$25(placeable3, placeable, width2, height, placeable2, width3, height2, width, iM9083constrainHeightK40F9xA, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeIcon_X9ElhV4$lambda$25(Placeable placeable, Placeable placeable2, int i, int i2, Placeable placeable3, int i3, int i4, int i5, int i6, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i5 - placeable.getWidth()) / 2, (i6 - placeable.getHeight()) / 2, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m3854placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPadding;
        float f3 = height + measureScope.mo1624toPx0680j_4(f2);
        float f4 = NavigationBarIndicatorToLabelPadding;
        float f5 = f3 + measureScope.mo1624toPx0680j_4(f4) + placeable.getHeight();
        final float fCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m9068getMinHeightimpl(j) - f5) / 2.0f, measureScope.mo1624toPx0680j_4(f2));
        float f6 = f5 + (fCoerceAtLeast * 2.0f);
        final float height2 = ((z ? fCoerceAtLeast : (f6 - placeable2.getHeight()) / 2.0f) - fCoerceAtLeast) * (1.0f - f);
        final float height3 = placeable2.getHeight() + fCoerceAtLeast + measureScope.mo1624toPx0680j_4(f2) + measureScope.mo1624toPx0680j_4(f4);
        final int width = Constraints.m9067getMaxWidthimpl(j) == Integer.MAX_VALUE ? placeable2.getWidth() + (measureScope.mo1618roundToPx0680j_4(NavigationBarItemToIconMinimumPadding) * 2) : Constraints.m9067getMaxWidthimpl(j);
        final int width2 = (width - placeable.getWidth()) / 2;
        final int width3 = (width - placeable2.getWidth()) / 2;
        final int width4 = (width - placeable3.getWidth()) / 2;
        final float f7 = fCoerceAtLeast - measureScope.mo1624toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, width, MathKt.roundToInt(f6), null, new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBarKt.placeLabelAndIcon_zUg2_y0$lambda$27(placeable4, z, f, placeable, width2, height3, height2, placeable2, width3, fCoerceAtLeast, placeable3, width4, f7, width, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeLabelAndIcon_zUg2_y0$lambda$27(Placeable placeable, boolean z, float f, Placeable placeable2, int i, float f2, float f3, Placeable placeable3, int i2, float f4, Placeable placeable4, int i3, float f5, int i4, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i4 - placeable.getWidth()) / 2, MathKt.roundToInt((f4 - measureScope.mo1618roundToPx0680j_4(IndicatorVerticalPadding)) + f3), 0.0f, 4, null);
        }
        if (z || f != 0.0f) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, MathKt.roundToInt(f2 + f3), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i2, MathKt.roundToInt(f4 + f3), 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i3, MathKt.roundToInt(f5 + f3), 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
