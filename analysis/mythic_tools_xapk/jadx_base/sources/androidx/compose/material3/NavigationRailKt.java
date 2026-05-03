package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0081\u0001\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0015H\u0003¢\u0006\u0002\u0010%\u001a5\u0010&\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100\u001aM\u00101\u001a\u00020'*\u00020(2\u0006\u00102\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u00103\u001a\u00020#H\u0002¢\u0006\u0004\b4\u00105\"\u000e\u00106\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>\"\u0010\u0010@\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0016\u0010A\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bB\u0010>\"\u0016\u0010C\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bD\u0010>\"\u0016\u0010E\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bF\u0010>\"\u0010\u0010G\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010H\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010I\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N¨\u0006O²\u0006\n\u0010P\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", FirebaseAnalytics.Param.CONTENT, "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationRailKt.IconLayoutIdTag, "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationRailVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getNavigationRailVerticalPadding", "()F", "F", "NavigationRailHeaderPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailItemHeight", "getNavigationRailItemHeight", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPaddingWithLabel", "IndicatorVerticalPaddingNoLabel", "LocalNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationRailOverride;", "getLocalNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailVerticalPadding = Dp.m9114constructorimpl(4.0f);
    private static final float NavigationRailHeaderPadding = Dp.m9114constructorimpl(8.0f);
    private static final float NavigationRailItemWidth = NavigationRailCollapsedTokens.INSTANCE.m5150getNarrowContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding = Dp.m9114constructorimpl(4.0f);
    private static final float IndicatorHorizontalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final float IndicatorVerticalPaddingWithLabel = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5162getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final float IndicatorVerticalPaddingNoLabel = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final ProvidableCompositionLocal<NavigationRailOverride> LocalNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultNavigationRailOverride.INSTANCE;
        }
    }, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3914NavigationRailqi6gXK8(Modifier modifier, long j, long j2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM3479contentColorForek8zF_U;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        Modifier modifier3;
        final long j3;
        final long j4;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        WindowInsets windowInsets4;
        long j5;
        long j6;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        Composer composerStartRestartGroup = composer.startRestartGroup(331386280);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,header,windowInsets,content)127@5999L7,*136@6318L16:NavigationRail.kt#uh7d8r");
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
                jM3479contentColorForek8zF_U = j2;
                int i6 = composerStartRestartGroup.changed(jM3479contentColorForek8zF_U) ? 256 : 128;
                i3 |= i6;
            } else {
                jM3479contentColorForek8zF_U = j2;
            }
            i3 |= i6;
        } else {
            jM3479contentColorForek8zF_U = j2;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                function33 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function33) ? 2048 : 1024;
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
                    function34 = function32;
                    i3 |= composerStartRestartGroup.changedInstance(function34) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "121@5706L14,122@5748L31,124@5895L12");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i7 != 0) {
                            function33 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            modifier3 = companion;
                            windowInsets4 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            j5 = containerColor;
                            j6 = jM3479contentColorForek8zF_U;
                            function36 = function33;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(331386280, i3, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:126)");
                            }
                            ProvidableCompositionLocal<NavigationRailOverride> providableCompositionLocal = LocalNavigationRailOverride;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ((NavigationRailOverride) objConsume).NavigationRail(new NavigationRailOverrideScope(modifier3, j5, j6, function36, windowInsets4, function34, null), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j5;
                            j4 = j6;
                            function35 = function36;
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
                    j6 = jM3479contentColorForek8zF_U;
                    function36 = function33;
                    windowInsets4 = windowInsets2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<NavigationRailOverride> providableCompositionLocal2 = LocalNavigationRailOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((NavigationRailOverride) objConsume2).NavigationRail(new NavigationRailOverrideScope(modifier3, j5, j6, function36, windowInsets4, function34, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j3 = j5;
                    j4 = j6;
                    function35 = function36;
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = containerColor;
                    j4 = jM3479contentColorForek8zF_U;
                    function35 = function33;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_qi6gXK8$lambda$1(modifier4, j3, j4, function35, windowInsets3, function32, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function34 = function32;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function33 = function3;
        if ((i & 24576) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        function34 = function32;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationRailItem(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        boolean z5;
        char c;
        int i7;
        int i8;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z6;
        Composer composer2;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final NavigationRailItemColors navigationRailItemColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        NavigationRailItemColors navigationRailItemColorsColors;
        MutableInteractionSource mutableInteractionSource3;
        NavigationRailItemColors navigationRailItemColors3;
        boolean z8;
        boolean z9;
        Function2<? super Composer, ? super Integer, Unit> function26;
        MutableInteractionSource mutableInteractionSource4;
        NavigationRailItemColors navigationRailItemColors4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        ?? r7;
        ComposableLambda composableLambda;
        MutableInteractionSource mutableInteractionSource5;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final State<Float> stateAnimateFloatAsState;
        final State<Float> stateAnimateFloatAsState2;
        long jM6072constructorimpl;
        boolean zChanged;
        Object objRememberedValue;
        final Shape value;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1620317701);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,colors,interactionSource)213@9696L14,215@9752L618,245@11016L3249:NavigationRail.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
            }
        }
        int i9 = i2 & 8;
        if (i9 != 0) {
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
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 1572864) == 0) {
                            c = ' ';
                            i3 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(navigationRailItemColors)) ? 8388608 : 4194304;
                        }
                        i7 = i2 & 256;
                        if (i7 == 0) {
                            if ((i & 100663296) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                z6 = z4;
                                composer2 = composerStartRestartGroup;
                                z7 = z5;
                                function25 = function24;
                                navigationRailItemColors2 = navigationRailItemColors;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "207@9366L8");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i9 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z4 = true;
                                    }
                                    if (i5 != 0) {
                                        function24 = null;
                                    }
                                    if (i6 != 0) {
                                        z5 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        navigationRailItemColorsColors = navigationRailItemColors;
                                    }
                                    if (i8 != 0) {
                                        navigationRailItemColors3 = navigationRailItemColorsColors;
                                        z8 = z4;
                                        z9 = z5;
                                        function26 = function24;
                                        mutableInteractionSource3 = null;
                                        int i10 = i3;
                                        Modifier modifier3 = modifier2;
                                        composerStartRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1620317701, i10, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:209)");
                                        }
                                        if (mutableInteractionSource3 != null) {
                                            composerStartRestartGroup.startReplaceGroup(253288608);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "211@9518L39");
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947833250, "CC(remember):NavigationRail.kt#9igjgp");
                                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            composerStartRestartGroup.endReplaceGroup();
                                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue4;
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1947832599);
                                            composerStartRestartGroup.endReplaceGroup();
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                        }
                                        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                                        boolean z10 = z9;
                                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(206057749, true, new NavigationRailKt$NavigationRailItem$styledIcon$1(navigationRailItemColors3, z, z8, finiteAnimationSpecValue, function26, z9, function23), composerStartRestartGroup, 54);
                                        if (function26 != null) {
                                            composerStartRestartGroup.startReplaceGroup(254215848);
                                            composerStartRestartGroup.endReplaceGroup();
                                            navigationRailItemColors4 = navigationRailItemColors3;
                                            function27 = function26;
                                            r7 = 1;
                                            composableLambda = null;
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(254215849);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "*230@10466L534");
                                            final NavigationRailItemColors navigationRailItemColors5 = navigationRailItemColors3;
                                            final boolean z11 = z8;
                                            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                            navigationRailItemColors4 = navigationRailItemColors5;
                                            function27 = function28;
                                            r7 = 1;
                                            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
                                                private static final long invoke$lambda$0(State<Color> state) {
                                                    return state.getValue().m6335unboximpl();
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i11) {
                                                    ComposerKt.sourceInformation(composer3, "C231@10543L5,233@10602L198,237@10817L169:NavigationRail.kt#uh7d8r");
                                                    if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2056532825, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:231)");
                                                    }
                                                    ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(navigationRailItemColors5.m3911textColorWaAFU9c$material3(z, z11), finiteAnimationSpecValue, null, null, composer3, 0, 12)), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), function28, composer3, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composerStartRestartGroup, 54);
                                            composerStartRestartGroup.endReplaceGroup();
                                            composableLambda = composableLambdaRememberComposableLambda2;
                                        }
                                        boolean z12 = z8;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        Modifier modifierM2090widthInVpY3zN4$default = SizeKt.m2090widthInVpY3zN4$default(SizeKt.m2068defaultMinSizeVpY3zN4$default(SelectableKt.m2307selectableO2vRcR0(modifier3, z, mutableInteractionSource5, null, z12, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function02), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, r7);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2090widthInVpY3zN4$default);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composerStartRestartGroup.startReusableNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                            composerStartRestartGroup.useNode();
                                        } else {
                                            composerStartRestartGroup.createNode(constructor);
                                        }
                                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826939198, "C264@11812L7,261@11582L252,270@12124L7,267@11897L249,277@12430L7,283@12745L128,297@13310L237,305@13596L285,319@14147L32,320@14217L31,313@13891L368:NavigationRail.kt#uh7d8r");
                                        NavigationRailItemColors navigationRailItemColors6 = navigationRailItemColors4;
                                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                                        stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        Density density = (Density) objConsume;
                                        jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((density.mo1618roundToPx0680j_4(r3) - density.mo1618roundToPx0680j_4(NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM())) / 2.0f)) << c) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                                        Unit unit = Unit.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474539147, "CC(remember):NavigationRail.kt#9igjgp");
                                        zChanged = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(jM6072constructorimpl);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new MappedInteractionSource(mutableInteractionSource5, jM6072constructorimpl, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (function27 == null) {
                                            composerStartRestartGroup.startReplaceGroup(-1825624334);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "289@13007L5");
                                            value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-1825528978);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "291@13076L5");
                                            value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                        ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicatorRipple$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i11) {
                                                ComposerKt.sourceInformation(composer3, "C298@13328L205:NavigationRail.kt#uh7d8r");
                                                if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(455696046, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:298)");
                                                }
                                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), value), mappedInteractionSource, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                        ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new NavigationRailKt$NavigationRailItem$1$indicator$1(stateAnimateFloatAsState, navigationRailItemColors6, value), composerStartRestartGroup, 54);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474494379, "CC(remember):NavigationRail.kt#9igjgp");
                                        zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda1
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return Float.valueOf(((Number) stateAnimateFloatAsState.getValue()).floatValue());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        Function0 function03 = (Function0) objRememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474492140, "CC(remember):NavigationRail.kt#9igjgp");
                                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return Float.valueOf(((Number) stateAnimateFloatAsState2.getValue()).floatValue());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        NavigationRailItemLayout(composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda, composableLambda, z10, function03, (Function0) objRememberedValue3, composerStartRestartGroup, (57344 & (i10 >> 6)) | 438);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        navigationRailItemColors2 = navigationRailItemColors6;
                                        composer2 = composerStartRestartGroup;
                                        z7 = z10;
                                        z6 = z12;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        modifier2 = modifier3;
                                        function25 = function27;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        navigationRailItemColors3 = navigationRailItemColorsColors;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    navigationRailItemColors3 = navigationRailItemColors;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z8 = z4;
                                z9 = z5;
                                function26 = function24;
                                int i102 = i3;
                                Modifier modifier32 = modifier2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (mutableInteractionSource3 != null) {
                                }
                                final FiniteAnimationSpec<Color> finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                                boolean z102 = z9;
                                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new NavigationRailKt$NavigationRailItem$styledIcon$1(navigationRailItemColors3, z, z8, finiteAnimationSpecValue2, function26, z9, function23), composerStartRestartGroup, 54);
                                if (function26 != null) {
                                }
                                boolean z122 = z8;
                                mutableInteractionSource5 = mutableInteractionSource4;
                                Modifier modifierM2090widthInVpY3zN4$default2 = SizeKt.m2090widthInVpY3zN4$default(SizeKt.m2068defaultMinSizeVpY3zN4$default(SelectableKt.m2307selectableO2vRcR0(modifier32, z, mutableInteractionSource5, null, z122, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function02), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                                Alignment center2 = Alignment.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, r7);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2090widthInVpY3zN4$default2);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!composerM5595constructorimpl.getInserting()) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826939198, "C264@11812L7,261@11582L252,270@12124L7,267@11897L249,277@12430L7,283@12745L128,297@13310L237,305@13596L285,319@14147L32,320@14217L31,313@13891L368:NavigationRail.kt#uh7d8r");
                                    NavigationRailItemColors navigationRailItemColors62 = navigationRailItemColors4;
                                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Density density2 = (Density) objConsume2;
                                    jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((density2.mo1618roundToPx0680j_4(r3) - density2.mo1618roundToPx0680j_4(NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM())) / 2.0f)) << c) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                                    Unit unit2 = Unit.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474539147, "CC(remember):NavigationRail.kt#9igjgp");
                                    zChanged = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(jM6072constructorimpl);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged) {
                                        objRememberedValue = new MappedInteractionSource(mutableInteractionSource5, jM6072constructorimpl, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (function27 == null) {
                                        }
                                        ComposableLambda composableLambdaRememberComposableLambda32 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicatorRipple$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i11) {
                                                ComposerKt.sourceInformation(composer3, "C298@13328L205:NavigationRail.kt#uh7d8r");
                                                if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(455696046, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:298)");
                                                }
                                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), value), mappedInteractionSource2, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                        ComposableLambda composableLambdaRememberComposableLambda42 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new NavigationRailKt$NavigationRailItem$1$indicator$1(stateAnimateFloatAsState, navigationRailItemColors62, value), composerStartRestartGroup, 54);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474494379, "CC(remember):NavigationRail.kt#9igjgp");
                                        zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged2) {
                                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda1
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return Float.valueOf(((Number) stateAnimateFloatAsState.getValue()).floatValue());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            Function0 function032 = (Function0) objRememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474492140, "CC(remember):NavigationRail.kt#9igjgp");
                                            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (!zChanged3) {
                                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda2
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Float.valueOf(((Number) stateAnimateFloatAsState2.getValue()).floatValue());
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                NavigationRailItemLayout(composableLambdaRememberComposableLambda32, composableLambdaRememberComposableLambda42, composableLambdaRememberComposableLambda5, composableLambda, z102, function032, (Function0) objRememberedValue3, composerStartRestartGroup, (57344 & (i102 >> 6)) | 438);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                                navigationRailItemColors2 = navigationRailItemColors62;
                                                composer2 = composerStartRestartGroup;
                                                z7 = z102;
                                                z6 = z122;
                                                mutableInteractionSource2 = mutableInteractionSource3;
                                                modifier2 = modifier32;
                                                function25 = function27;
                                            }
                                        }
                                    }
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem$lambda$11(z, function0, function2, modifier2, z6, function25, z7, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        i8 = i7;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    c = ' ';
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                    }
                    i8 = i7;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                c = ' ';
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            c = ' ';
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
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
        function24 = function22;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        c = ' ';
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit NavigationRailItem$lambda$11(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationRailItem(z, function0, function2, modifier, z2, function22, z3, navigationRailItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, final Function0<Float> function02, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-759267492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)576@25709L2050,558@25188L2571:NavigationRail.kt#uh7d8r");
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
                ComposerKt.traceEventStart(-759267492, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:557)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 488409630, "CC(remember):NavigationRail.kt#9igjgp");
            int i3 = 57344 & i2;
            boolean z2 = ((3670016 & i2) == 1048576) | ((i2 & 7168) == 2048) | (i3 == 16384);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Measurable measurable;
                        Placeable placeableMo7769measureBRTryo0;
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
                                int width = placeableMo7769measureBRTryo02.getWidth() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * 2.0f));
                                int iRoundToInt = MathKt.roundToInt(width * fCoerceAtLeast);
                                int height = placeableMo7769measureBRTryo02.getHeight() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl((function24 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * 2.0f));
                                int size2 = list2.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    Measurable measurable3 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable placeableMo7769measureBRTryo03 = measurable3.mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(width, height));
                                        int size3 = list2.size();
                                        int i6 = 0;
                                        while (true) {
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
                                        placeableMo7769measureBRTryo0 = null;
                                        if (function24 == null) {
                                            return NavigationRailKt.m3917placeIconX9ElhV4(measureScope, placeableMo7769measureBRTryo02, placeableMo7769measureBRTryo03, placeableMo7769measureBRTryo04, j);
                                        }
                                        Intrinsics.checkNotNull(placeableMo7769measureBRTryo0);
                                        return NavigationRailKt.m3918placeLabelAndIconzUg2_y0(measureScope, placeableMo7769measureBRTryo0, placeableMo7769measureBRTryo02, placeableMo7769measureBRTryo03, placeableMo7769measureBRTryo04, j, z, fCoerceAtLeast);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 772983468, "C561@25271L17,562@25301L11,564@25326L50:NavigationRail.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1280363716, "C564@25368L6:NavigationRail.kt#uh7d8r");
            function23.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function24 != null) {
                composerStartRestartGroup.startReplaceGroup(773116085);
                ComposerKt.sourceInformation(composerStartRestartGroup, "568@25502L109,567@25427L250");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 579131360, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z3 = (i3 == 16384) | ((i4 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationRailKt.NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(z, function0, (GraphicsLayerScope) obj);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -995857944, "C572@25652L7:NavigationRail.kt#uh7d8r");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(773387087);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItemLayout$lambda$18(function2, function22, function23, function24, z, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(boolean z, Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    static final Unit NavigationRailItemLayout$lambda$18(Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NavigationRailItemLayout(function2, function22, function23, function24, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationRail_qi6gXK8$lambda$1(Modifier modifier, long j, long j2, Function3 function3, WindowInsets windowInsets, Function3 function32, int i, int i2, Composer composer, int i3) {
        m3914NavigationRailqi6gXK8(modifier, j, j2, function3, windowInsets, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<NavigationRailOverride> getLocalNavigationRailOverride() {
        return LocalNavigationRailOverride;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3917placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int iM9083constrainHeightK40F9xA = ConstraintsKt.m9083constrainHeightK40F9xA(j, measureScope.mo1618roundToPx0680j_4(NavigationRailItemHeight));
        final int width = (iM9084constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = (iM9083constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (iM9084constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height2 = (iM9083constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM9084constrainWidthK40F9xA, iM9083constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeIcon_X9ElhV4$lambda$20(placeable3, placeable, width, height, placeable2, width2, height2, iM9084constrainWidthK40F9xA, iM9083constrainHeightK40F9xA, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeIcon_X9ElhV4$lambda$20(Placeable placeable, Placeable placeable2, int i, int i2, Placeable placeable3, int i3, int i4, int i5, int i6, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i5 - placeable.getWidth()) / 2, (i6 - placeable.getHeight()) / 2, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m3918placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPaddingWithLabel;
        float f3 = height + measureScope.mo1624toPx0680j_4(f2);
        float f4 = NavigationRailItemVerticalPadding;
        float f5 = f3 + measureScope.mo1624toPx0680j_4(f4) + placeable.getHeight();
        final float fCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m9068getMinHeightimpl(j) - f5) / 2.0f, measureScope.mo1624toPx0680j_4(f2));
        float f6 = f5 + (fCoerceAtLeast * 2.0f);
        final float height2 = ((z ? fCoerceAtLeast : (f6 - placeable2.getHeight()) / 2.0f) - fCoerceAtLeast) * (1.0f - f);
        final float height3 = placeable2.getHeight() + fCoerceAtLeast + measureScope.mo1624toPx0680j_4(f2) + measureScope.mo1624toPx0680j_4(f4);
        final int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int width = (iM9084constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int width2 = (iM9084constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width3 = (iM9084constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final float f7 = fCoerceAtLeast - measureScope.mo1624toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, iM9084constrainWidthK40F9xA, MathKt.roundToInt(f6), null, new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeLabelAndIcon_zUg2_y0$lambda$22(placeable4, z, f, placeable, width, height3, height2, placeable2, width2, fCoerceAtLeast, placeable3, width3, f7, iM9084constrainWidthK40F9xA, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeLabelAndIcon_zUg2_y0$lambda$22(Placeable placeable, boolean z, float f, Placeable placeable2, int i, float f2, float f3, Placeable placeable3, int i2, float f4, Placeable placeable4, int i3, float f5, int i4, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i4 - placeable.getWidth()) / 2, MathKt.roundToInt((f4 - measureScope.mo1624toPx0680j_4(IndicatorVerticalPaddingWithLabel)) + f3), 0.0f, 4, null);
        }
        if (z || f != 0.0f) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, MathKt.roundToInt(f2 + f3), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i2, MathKt.roundToInt(f4 + f3), 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i3, MathKt.roundToInt(f5 + f3), 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
