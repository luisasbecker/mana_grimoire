package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001aÕ\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0004\b*\u0010+\u001a\u008d\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0003¢\u0006\u0004\b2\u00103\u001a³\u0001\u00104\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0003¢\u0006\u0004\b6\u00107\u001a3\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010B\u001aS\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\bE\u0010F\u001aC\u0010G\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010I\u001a\u0091\u0001\u0010J\u001a\u000209*\u00020:2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010 \u001a\u00020K2\u0006\u0010?\u001a\u00020@2\u0006\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0002¢\u0006\u0004\bL\u0010M\u001a@\u0010N\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00032\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010P\u001a\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u0002010R2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010S\u001a\u001d\u0010T\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010U\u001a-\u0010V\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0005H\u0003¢\u0006\u0004\bW\u0010X\"\u000e\u0010Y\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010^\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010_¨\u0006`²\u0006\n\u0010a\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010a\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u00105\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"NavigationItem", "", "selected", "", "onClick", "Lkotlin/Function0;", NavigationItemKt.IconLayoutIdTag, "Landroidx/compose/runtime/Composable;", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorWidth", "Landroidx/compose/ui/unit/Dp;", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "colors", "Landroidx/compose/material3/NavigationItemColors;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "label", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NavigationItem-8Df7sds", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItem", "topIconIndicatorWidth", "topIconLabelTextStyle", "startIconLabelTextStyle", "topIconIndicatorHorizontalPadding", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "noLabelIndicatorPadding", "itemHorizontalPadding", "AnimatedNavigationItem-DQd_Gtc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;FFFFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "NavigationItemLayout", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "indicatorAnimationProgress", "", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;FFFFFLandroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItemLayout", "iconPositionProgress", "AnimatedNavigationItemLayout-he0WsC4", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;FFFFFFFFLandroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "labelPlaceable", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeAnimatedLabelAndIcon", "", "placeAnimatedLabelAndIcon-2QYhCQ8", "(Landroidx/compose/ui/layout/MeasureScope;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;IJFFFFFFF)Landroidx/compose/ui/layout/MeasureResult;", "StyledLabel", FirebaseAnalytics.Param.CONTENT, "(ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/NavigationItemColors;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animateIndicatorProgressAsState", "Landroidx/compose/runtime/State;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "IndicatorRipple", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "Indicator", "Indicator-3J-VO9M", "(JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "IndicatorVerticalOffset", "F", "material3", "itemWidth", "textStyle"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationItemKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m9114constructorimpl(12.0f);
    private static final String LabelLayoutIdTag = "label";

    /* JADX INFO: renamed from: AnimatedNavigationItem-DQd_Gtc, reason: not valid java name */
    public static final void m3887AnimatedNavigationItemDQd_Gtc(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Shape shape, final float f, final TextStyle textStyle, final TextStyle textStyle2, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final float f9, final NavigationItemColors navigationItemColors, final Modifier modifier, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        Composer composer2;
        boolean z3;
        String str;
        boolean z4;
        Composer composer3;
        ComposableLambda composableLambda;
        MappedInteractionSource mappedInteractionSource;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1114086313);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedNavigationItem)N(selected,onClick,icon,indicatorShape,topIconIndicatorWidth:c#ui.unit.Dp,topIconLabelTextStyle,startIconLabelTextStyle,topIconIndicatorHorizontalPadding:c#ui.unit.Dp,topIconIndicatorVerticalPadding:c#ui.unit.Dp,topIconIndicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconIndicatorHorizontalPadding:c#ui.unit.Dp,startIconIndicatorVerticalPadding:c#ui.unit.Dp,noLabelIndicatorPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,itemHorizontalPadding:c#ui.unit.Dp,colors,modifier,enabled,label,iconPosition:c#material3.NavigationItemIconPosition,interactionSource)345@14658L94,349@14775L33,362@15198L7,363@15272L7,365@15322L24,351@14814L3783:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(textStyle2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i5 |= composerStartRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i6 = i3 | (composerStartRestartGroup.changed(f5) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(f6) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(f7) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(f8) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(f9) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i6 |= composerStartRestartGroup.changed(navigationItemColors) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= composerStartRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i6 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
        }
        int i8 = i6;
        if ((i4 & 6) == 0) {
            i7 = i4 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
        } else {
            i7 = i4;
        }
        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (306783379 & i8) == 306783378 && (i7 & 3) == 2) ? false : true, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1114086313, i5, i8, "androidx.compose.material3.AnimatedNavigationItem (NavigationItem.kt:343)");
            }
            final long jM3876iconColorWaAFU9c = navigationItemColors.m3876iconColorWaAFU9c(z, z2);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(851124593, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$AnimatedNavigationItem$styledIcon$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i9) {
                    ComposerKt.sourceInformation(composer4, "C346@14668L78:NavigationItem.kt#uh7d8r");
                    if (!composer4.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(851124593, i9, -1, "androidx.compose.material3.AnimatedNavigationItem.<anonymous> (NavigationItem.kt:346)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(jM3876iconColorWaAFU9c)), function2, composer4, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1190056456, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i9 = i5;
            Modifier modifierM2307selectableO2vRcR0 = SelectableKt.m2307selectableO2vRcR0(modifier, z, mutableInteractionSource, null, z2, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function0);
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM9128unboximpl = ((Dp) objConsume).m9128unboximpl();
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(modifierM2307selectableO2vRcR0, fM9128unboximpl, ((Dp) objConsume2).m9128unboximpl());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1190038961, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$15$lambda$14(mutableIntState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM2067defaultMinSizeVpY3zN4, (Function1) objRememberedValue2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 679531148, "C370@15561L41,375@15890L7,372@15651L261,378@15939L200,422@17712L54,425@17875L42,418@17458L1133:NavigationItem.kt#uh7d8r");
            final boolean zM3881equalsimpl0 = NavigationItemIconPosition.m3881equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg());
            final State<Float> stateAnimateIndicatorProgressAsState = animateIndicatorProgressAsState(z, composerStartRestartGroup, i9 & 14);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(zM3881equalsimpl0 ? 0.0f : 1.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -532256231, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$18$lambda$17(zM3881equalsimpl0, textStyle, textStyle2, stateAnimateFloatAsState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final State state = (State) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(680212713);
                ComposerKt.sourceInformation(composerStartRestartGroup, "386@16242L296");
                z3 = zM3881equalsimpl0;
                composer3 = composerStartRestartGroup;
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                z4 = false;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(22475789, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$AnimatedNavigationItem$2$styledLabel$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i10) {
                        ComposerKt.sourceInformation(composer4, "C387@16264L256:NavigationItem.kt#uh7d8r");
                        if (!composer4.shouldExecute((i10 & 3) != 2, i10 & 1)) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(22475789, i10, -1, "androidx.compose.material3.AnimatedNavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:387)");
                        }
                        NavigationItemKt.StyledLabel(z, NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(state), navigationItemColors, z2, function22, composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda2;
            } else {
                z3 = zM3881equalsimpl0;
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                z4 = false;
                composer3 = composerStartRestartGroup;
                composer3.startReplaceGroup(680534989);
                composer3.endReplaceGroup();
                composableLambda = null;
            }
            if (z3) {
                composer3.startReplaceGroup(680694081);
                ComposerKt.sourceInformation(composer3, "405@17000L7,413@17302L136");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str);
                Object objConsume3 = composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((AnimatedNavigationItem_DQd_Gtc$lambda$12(mutableIntState) - r0.mo1618roundToPx0680j_4(f)) / 2.0f)) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(((Density) objConsume3).mo1624toPx0680j_4(IndicatorVerticalOffset)))));
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -532212679, "CC(remember):NavigationItem.kt#9igjgp");
                if ((i7 & 14) == 4) {
                    z4 = true;
                }
                boolean zChanged = z4 | composer3.changed(jM6072constructorimpl);
                Object objRememberedValue4 = composer3.rememberedValue();
                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource, jM6072constructorimpl, null);
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                mappedInteractionSource = (MappedInteractionSource) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(681416753);
                composer3.endReplaceGroup();
                mappedInteractionSource = null;
            }
            InteractionSource interactionSource = mappedInteractionSource != null ? mappedInteractionSource : mutableInteractionSource;
            long selectedIndicatorColor = navigationItemColors.getSelectedIndicatorColor();
            ComposerKt.sourceInformationMarkerStart(composer3, -532199641, "CC(remember):NavigationItem.kt#9igjgp");
            boolean zChanged2 = composer3.changed(stateAnimateIndicatorProgressAsState);
            Object objRememberedValue5 = composer3.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(RangesKt.coerceAtLeast(((Number) stateAnimateIndicatorProgressAsState.getValue()).floatValue(), 0.0f));
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            }
            Function0 function02 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -532194437, "CC(remember):NavigationItem.kt#9igjgp");
            boolean zChanged3 = composer3.changed(stateAnimateFloatAsState);
            Object objRememberedValue6 = composer3.rememberedValue();
            if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(RangesKt.coerceAtLeast(NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(stateAnimateFloatAsState), 0.0f));
                    }
                };
                composer3.updateRememberedValue(objRememberedValue6);
            }
            Function0 function03 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            int i10 = i9 << 3;
            int i11 = ((i9 >> 3) & 896) | 24576 | ((i8 >> 12) & 458752) | (234881024 & i10) | (i10 & 1879048192);
            int i12 = i8 << 3;
            int i13 = ((i9 >> 27) & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (i12 & 458752);
            Composer composer4 = composer3;
            m3888AnimatedNavigationItemLayouthe0WsC4(interactionSource, selectedIndicatorColor, shape, function02, composableLambdaRememberComposableLambda, i, function03, composableLambda, f2, f3, f4, f5, f6, f7, f8, f9, composer4, i11, i13);
            composer2 = composer4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$27(z, function0, function2, shape, f, textStyle, textStyle2, f2, f3, f4, f5, f6, f7, f8, f9, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: AnimatedNavigationItemLayout-he0WsC4, reason: not valid java name */
    private static final void m3888AnimatedNavigationItemLayouthe0WsC4(final InteractionSource interactionSource, final long j, final Shape shape, final Function0<Float> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final int i, final Function0<Float> function02, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Float> function03;
        int i5;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(94433406);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedNavigationItemLayout)N(interactionSource,indicatorColor:c#ui.graphics.Color,indicatorShape,indicatorAnimationProgress,icon,iconPosition:c#material3.NavigationItemIconPosition,iconPositionProgress,label,topIconIndicatorHorizontalPadding:c#ui.unit.Dp,topIconIndicatorVerticalPadding:c#ui.unit.Dp,topIconIndicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconIndicatorHorizontalPadding:c#ui.unit.Dp,startIconIndicatorVerticalPadding:c#ui.unit.Dp,noLabelIndicatorPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,itemHorizontalPadding:c#ui.unit.Dp)509@21184L2129:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            function03 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function03) ? 2048 : 1024;
        } else {
            function03 = function0;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 = 196608;
            i4 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
        } else {
            i5 = 196608;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i6 = i3 | (composerStartRestartGroup.changed(f3) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(f4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(f5) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(f6) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(f7) ? 16384 : 8192;
        }
        if ((i3 & i5) == 0) {
            i6 |= composerStartRestartGroup.changed(f8) ? 131072 : 65536;
        }
        int i7 = i6;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (74899 & i7) == 74898) ? false : true, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(94433406, i4, i7, "androidx.compose.material3.AnimatedNavigationItemLayout (NavigationItem.kt:508)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            Object animatedMeasurePolicy = function22 != null ? new AnimatedMeasurePolicy(i, function02, function03, f, f2, f3, f4, f5, f7, f8, null) : new TopIconOrIconOnlyMeasurePolicy(false, function0, f6, f6, Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(0.0f), null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
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
            Updater.m5603setimpl(composerM5595constructorimpl, animatedMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -988347483, "C513@21311L50,516@21564L69,518@21647L50:NavigationItem.kt#uh7d8r");
            int i8 = i4 >> 3;
            IndicatorRipple(interactionSource, shape, composerStartRestartGroup, (i4 & 14) | (i8 & 112));
            int i9 = i4;
            m3889Indicator3JVO9M(j, shape, function0, composerStartRestartGroup, i8 & 1022);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1416456196, "C518@21689L6:NavigationItem.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 12) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-987944825);
                ComposerKt.sourceInformation(composerStartRestartGroup, "521@21748L52");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 157288374, "C521@21791L7:NavigationItem.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-987864101);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.AnimatedNavigationItemLayout_he0WsC4$lambda$35(interactionSource, j, shape, function0, function2, i, function02, function22, f, f2, f3, f4, f5, f6, f7, f8, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AnimatedNavigationItemLayout_he0WsC4$lambda$35(InteractionSource interactionSource, long j, Shape shape, Function0 function0, Function2 function2, int i, Function0 function02, Function2 function22, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2, int i3, Composer composer, int i4) {
        m3888AnimatedNavigationItemLayouthe0WsC4(interactionSource, j, shape, function0, function2, i, function02, function22, f, f2, f3, f4, f5, f6, f7, f8, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    private static final int AnimatedNavigationItem_DQd_Gtc$lambda$12(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$15$lambda$14(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.setIntValue((int) (intSize.m9289unboximpl() >> 32));
        return Unit.INSTANCE;
    }

    private static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$18$lambda$17(boolean z, TextStyle textStyle, TextStyle textStyle2, State state) {
        return (!z || AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(state) >= 0.5f) ? textStyle2 : textStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(State<TextStyle> state) {
        return state.getValue();
    }

    static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$27(boolean z, Function0 function0, Function2 function2, Shape shape, float f, TextStyle textStyle, TextStyle textStyle2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, NavigationItemColors navigationItemColors, Modifier modifier, boolean z2, Function2 function22, int i, MutableInteractionSource mutableInteractionSource, int i2, int i3, int i4, Composer composer, int i5) {
        m3887AnimatedNavigationItemDQd_Gtc(z, function0, function2, shape, f, textStyle, textStyle2, f2, f3, f4, f5, f6, f7, f8, f9, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Indicator-3J-VO9M, reason: not valid java name */
    private static final void m3889Indicator3JVO9M(final long j, final Shape shape, final Function0<Float> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-273382589);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(indicatorColor:c#ui.graphics.Color,indicatorShape,indicatorAnimationProgress)1117@46816L40,1115@46736L198:NavigationItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273382589, i2, -1, "androidx.compose.material3.Indicator (NavigationItem.kt:1114)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -727655829, "CC(remember):NavigationItem.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationItemKt.Indicator_3J_VO9M$lambda$44$lambda$43(function0, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(BackgroundKt.m1482backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) objRememberedValue), j, shape), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.Indicator_3J_VO9M$lambda$45(j, shape, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void IndicatorRipple(final InteractionSource interactionSource, final Shape shape, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-629069867);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IndicatorRipple)N(interactionSource,indicatorShape)1102@46439L151:NavigationItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-629069867, i2, -1, "androidx.compose.material3.IndicatorRipple (NavigationItem.kt:1101)");
            }
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorRippleLayoutIdTag), shape), interactionSource, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.IndicatorRipple$lambda$42(interactionSource, shape, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit IndicatorRipple$lambda$42(InteractionSource interactionSource, Shape shape, int i, Composer composer, int i2) {
        IndicatorRipple(interactionSource, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Indicator_3J_VO9M$lambda$44$lambda$43(Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    static final Unit Indicator_3J_VO9M$lambda$45(long j, Shape shape, Function0 function0, int i, Composer composer, int i2) {
        m3889Indicator3JVO9M(j, shape, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NavigationItem-8Df7sds, reason: not valid java name */
    public static final void m3890NavigationItem8Df7sds(boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Shape shape, final float f, final float f2, final float f3, final float f4, final float f5, final float f6, final NavigationItemColors navigationItemColors, final Modifier modifier, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        int i5;
        Composer composer2;
        int i6;
        int i7;
        ComposableLambda composableLambda;
        MappedInteractionSource mappedInteractionSource;
        final boolean z3 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(2075155418);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationItem)N(selected,onClick,icon,labelTextStyle,indicatorShape,indicatorWidth:c#ui.unit.Dp,indicatorHorizontalPadding:c#ui.unit.Dp,indicatorVerticalPadding:c#ui.unit.Dp,indicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,topIconItemVerticalPadding:c#ui.unit.Dp,colors,modifier,enabled,label,iconPosition:c#material3.NavigationItemIconPosition,interactionSource)247@10748L94,257@11065L33,270@11488L7,271@11562L7,273@11612L24,259@11104L2381:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            function02 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(f5) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(f6) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(navigationItemColors) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        int i8 = i5;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (599187 & i8) == 599186) ? false : true, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2075155418, i4, i8, "androidx.compose.material3.NavigationItem (NavigationItem.kt:245)");
            }
            final long jM3876iconColorWaAFU9c = navigationItemColors.m3876iconColorWaAFU9c(z3, z2);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1119868672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "C248@10758L78:NavigationItem.kt#uh7d8r");
                    if (!composer3.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1119868672, i9, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:248)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(jM3876iconColorWaAFU9c)), function2, composer3, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            if (function22 == null) {
                composerStartRestartGroup.startReplaceGroup(-803302356);
                composerStartRestartGroup.endReplaceGroup();
                i6 = i8;
                i7 = i4;
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-803266737);
                ComposerKt.sourceInformation(composerStartRestartGroup, "254@10967L65");
                i6 = i8;
                i7 = i4;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1062206119, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledLabel$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        ComposerKt.sourceInformation(composer3, "C254@10969L61:NavigationItem.kt#uh7d8r");
                        if (!composer3.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1062206119, i9, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:254)");
                        }
                        NavigationItemKt.StyledLabel(z3, textStyle, navigationItemColors, z2, function22, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda2;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1359565019, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            z3 = z;
            Modifier modifierM2307selectableO2vRcR0 = SelectableKt.m2307selectableO2vRcR0(modifier, z3, mutableInteractionSource, null, z2, Role.m8320boximpl(Role.INSTANCE.m8334getTabo7Vup1c()), function02);
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM9128unboximpl = ((Dp) objConsume).m9128unboximpl();
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(modifierM2307selectableO2vRcR0, fM9128unboximpl, ((Dp) objConsume2).m9128unboximpl());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1359582514, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationItemKt.NavigationItem_8Df7sds$lambda$4$lambda$3(mutableIntState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM2067defaultMinSizeVpY3zN4, (Function1) objRememberedValue2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 484584471, "C277@11772L41,304@13049L54,297@12698L781:NavigationItem.kt#uh7d8r");
            final State<Float> stateAnimateIndicatorProgressAsState = animateIndicatorProgressAsState(z3, composerStartRestartGroup, i7 & 14);
            if (NavigationItemIconPosition.m3881equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg())) {
                composerStartRestartGroup.startReplaceGroup(484755993);
                ComposerKt.sourceInformation(composerStartRestartGroup, "284@12247L7,292@12542L136");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((NavigationItem_8Df7sds$lambda$1(mutableIntState) - r2.mo1618roundToPx0680j_4(f)) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(((Density) objConsume3).mo1624toPx0680j_4(IndicatorVerticalOffset))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1092722808, "CC(remember):NavigationItem.kt#9igjgp");
                boolean zChanged = ((i6 & 3670016) == 1048576) | composerStartRestartGroup.changed(jM6072constructorimpl);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new MappedInteractionSource(mutableInteractionSource, jM6072constructorimpl, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mappedInteractionSource = (MappedInteractionSource) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(485471938);
                composerStartRestartGroup.endReplaceGroup();
                mappedInteractionSource = null;
            }
            MutableInteractionSource mutableInteractionSource2 = mappedInteractionSource != null ? mappedInteractionSource : mutableInteractionSource;
            long selectedIndicatorColor = navigationItemColors.getSelectedIndicatorColor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1092706666, "CC(remember):NavigationItem.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateIndicatorProgressAsState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(RangesKt.coerceAtLeast(((Number) stateAnimateIndicatorProgressAsState.getValue()).floatValue(), 0.0f));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i9 = i7 << 3;
            composer2 = composerStartRestartGroup;
            m3891NavigationItemLayoutKmRXDg(mutableInteractionSource2, selectedIndicatorColor, shape, composableLambdaRememberComposableLambda, i, composableLambda, (Function0) objRememberedValue4, f2, f3, f4, f5, f6, composer2, ((i7 >> 6) & 896) | 3072 | ((i6 >> 3) & 57344) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192), ((i7 >> 27) & 14) | ((i6 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.NavigationItem_8Df7sds$lambda$10(z3, function0, function2, textStyle, shape, f, f2, f3, f4, f5, f6, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: NavigationItemLayout-KmRX-Dg, reason: not valid java name */
    private static final void m3891NavigationItemLayoutKmRXDg(final InteractionSource interactionSource, final long j, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, final int i, final Function2<? super Composer, ? super Integer, Unit> function22, final Function0<Float> function0, final float f, final float f2, final float f3, final float f4, final float f5, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Float> function02;
        int i5;
        TopIconOrIconOnlyMeasurePolicy topIconOrIconOnlyMeasurePolicy;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473868071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationItemLayout)N(interactionSource,indicatorColor:c#ui.graphics.Color,indicatorShape,icon,iconPosition:c#material3.NavigationItemIconPosition,label,indicatorAnimationProgress,indicatorHorizontalPadding:c#ui.unit.Dp,indicatorVerticalPadding:c#ui.unit.Dp,indicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,topIconItemVerticalPadding:c#ui.unit.Dp)454@19104L1389:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            function02 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        if ((12582912 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(f4) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(f5) ? 32 : 16;
        }
        int i6 = i5;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i6 & 19) == 18) ? false : true, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473868071, i4, i6, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:453)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            if (function22 == null || NavigationItemIconPosition.m3881equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg())) {
                topIconOrIconOnlyMeasurePolicy = new TopIconOrIconOnlyMeasurePolicy(function22 != null, function0, f, f2, f3, f5, null);
            } else {
                topIconOrIconOnlyMeasurePolicy = new StartIconMeasurePolicy(function02, f, f2, f4, null);
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
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
            Updater.m5603setimpl(composerM5595constructorimpl, topIconOrIconOnlyMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087603364, "C458@19231L50,461@19484L69,463@19567L50:NavigationItem.kt#uh7d8r");
            int i7 = i4 >> 3;
            IndicatorRipple(interactionSource, shape, composerStartRestartGroup, (i4 & 14) | (i7 & 112));
            int i8 = i4;
            m3889Indicator3JVO9M(j, shape, function0, composerStartRestartGroup, ((i4 >> 12) & 896) | (i7 & 126));
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 652632167, "C463@19609L6:NavigationItem.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-2087200706);
                ComposerKt.sourceInformation(composerStartRestartGroup, "466@19668L52");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2123117109, "C466@19711L7:NavigationItem.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2087119982);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.NavigationItemLayout_KmRX_Dg$lambda$31(interactionSource, j, shape, function2, i, function22, function0, f, f2, f3, f4, f5, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationItemLayout_KmRX_Dg$lambda$31(InteractionSource interactionSource, long j, Shape shape, Function2 function2, int i, Function2 function22, Function0 function0, float f, float f2, float f3, float f4, float f5, int i2, int i3, Composer composer, int i4) {
        m3891NavigationItemLayoutKmRXDg(interactionSource, j, shape, function2, i, function22, function0, f, f2, f3, f4, f5, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    private static final int NavigationItem_8Df7sds$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    static final Unit NavigationItem_8Df7sds$lambda$10(boolean z, Function0 function0, Function2 function2, TextStyle textStyle, Shape shape, float f, float f2, float f3, float f4, float f5, float f6, NavigationItemColors navigationItemColors, Modifier modifier, boolean z2, Function2 function22, int i, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m3890NavigationItem8Df7sds(z, function0, function2, textStyle, shape, f, f2, f3, f4, f5, f6, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    static final Unit NavigationItem_8Df7sds$lambda$4$lambda$3(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.setIntValue((int) (intSize.m9289unboximpl() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StyledLabel(final boolean z, TextStyle textStyle, final NavigationItemColors navigationItemColors, final boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        TextStyle textStyle2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2136267443);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StyledLabel)N(selected,labelTextStyle,colors,enabled,content)1085@45893L132:NavigationItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(navigationItemColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2136267443, i2, -1, "androidx.compose.material3.StyledLabel (NavigationItem.kt:1083)");
            }
            textStyle2 = textStyle;
            ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(navigationItemColors.m3877textColorWaAFU9c(z, z2), textStyle2, function2, composerStartRestartGroup, (i2 & 112) | ((i2 >> 6) & 896));
            function22 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            textStyle2 = textStyle;
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextStyle textStyle3 = textStyle2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.StyledLabel$lambda$41(z, textStyle3, navigationItemColors, z2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit StyledLabel$lambda$41(boolean z, TextStyle textStyle, NavigationItemColors navigationItemColors, boolean z2, Function2 function2, int i, Composer composer, int i2) {
        StyledLabel(z, textStyle, navigationItemColors, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final State<Float> animateIndicatorProgressAsState(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1105658511, "C(animateIndicatorProgressAsState)N(selected)1097@46316L7,1094@46110L220:NavigationItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1105658511, i, -1, "androidx.compose.material3.animateIndicatorProgressAsState (NavigationItem.kt:1094)");
        }
        State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), 0.0f, null, null, composer, 0, 28);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateFloatAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeAnimatedLabelAndIcon-2QYhCQ8, reason: not valid java name */
    public static final MeasureResult m3896placeAnimatedLabelAndIcon2QYhCQ8(MeasureScope measureScope, int i, Function0<Float> function0, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, int i2, long j, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        final float fFloatValue = function0.invoke().floatValue();
        boolean zM3881equalsimpl0 = NavigationItemIconPosition.m3881equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg());
        float f8 = f7 * 2.0f;
        float fM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), i2 + measureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(f8)))) + ((ConstraintsKt.m9084constrainWidthK40F9xA(j, placeable3.getWidth() + measureScope.mo1618roundToPx0680j_4(f7)) - r8) * fFloatValue);
        int iLerp = MathHelpersKt.lerp(ConstraintsKt.m9083constrainHeightK40F9xA(j, MathKt.roundToInt(placeable3.getHeight() + measureScope.mo1624toPx0680j_4(f) + placeable.getHeight())), ConstraintsKt.m9083constrainHeightK40F9xA(j, placeable3.getHeight()), fFloatValue);
        final int i3 = measureScope.mo1618roundToPx0680j_4(f7);
        int iLerp2 = (fFloatValue == 0.0f || fFloatValue == 1.0f) ? MathHelpersKt.lerp(MathKt.roundToInt((fM9084constrainWidthK40F9xA - placeable4.getWidth()) / 2.0f), MathKt.roundToInt(((i3 + fM9084constrainWidthK40F9xA) - placeable4.getWidth()) / 2.0f), fFloatValue) : measureScope.mo1618roundToPx0680j_4(f7);
        int i4 = measureScope.mo1618roundToPx0680j_4(f3) + i3;
        int i5 = measureScope.mo1618roundToPx0680j_4(f4) + i3;
        int i6 = measureScope.mo1618roundToPx0680j_4(f2);
        int i7 = measureScope.mo1618roundToPx0680j_4(f5);
        final int iLerp3 = MathHelpersKt.lerp(i4, i5, fFloatValue);
        final int iLerp4 = MathHelpersKt.lerp(i6, i7, fFloatValue);
        int width = ((placeable2.getWidth() + measureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(Dp.m9114constructorimpl(f3 * 2.0f) + Dp.m9114constructorimpl(f8)))) - placeable.getWidth()) / 2;
        int height = placeable2.getHeight() + iLerp4 + measureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(f + f));
        float width2 = ((placeable2.getWidth() + iLerp3) + measureScope.mo1618roundToPx0680j_4(f6)) - ((!zM3881equalsimpl0 || fFloatValue <= 0.0f) ? measureScope.mo1618roundToPx0680j_4(f7) * (1.0f - fFloatValue) : 0.0f);
        int height2 = (iLerp - placeable.getHeight()) / 2;
        final Object objValueOf = fFloatValue < 0.5f ? Integer.valueOf(width) : Float.valueOf(width2 * fFloatValue);
        final int i8 = fFloatValue < 0.5f ? height : height2;
        final int i9 = iLerp2;
        return MeasureScope.layout$default(measureScope, MathKt.roundToInt(fM9084constrainWidthK40F9xA), iLerp, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(placeable4, i9, placeable2, iLerp3, iLerp4, placeable, objValueOf, i8, placeable3, i3, fFloatValue, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable placeable3, Object obj, int i4, Placeable placeable4, int i5, final float f, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, i, 0, 0.0f, (Function1) null, 12, (Object) null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable2, i2, i3, 0.0f, (Function1) null, 12, (Object) null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable3, ((Number) obj).intValue(), i4, 0.0f, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return NavigationItemKt.placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(f, (GraphicsLayerScope) obj2);
            }
        }, 4, (Object) null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable4, i5, 0, 0.0f, (Function1) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(float f, GraphicsLayerScope graphicsLayerScope) {
        float f2 = f - 0.5f;
        graphicsLayerScope.setAlpha(4.0f * f2 * f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3897placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, placeable2.getWidth());
        int iM9083constrainHeightK40F9xA = ConstraintsKt.m9083constrainHeightK40F9xA(j, placeable2.getHeight());
        final int width = (iM9084constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final int height = (iM9083constrainHeightK40F9xA - placeable3.getHeight()) / 2;
        final int width2 = (iM9084constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height2 = (iM9083constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width3 = (iM9084constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height3 = (iM9083constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM9084constrainWidthK40F9xA, iM9083constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeIcon_X9ElhV4$lambda$36(placeable3, width, height, placeable, width2, height2, placeable2, width3, height3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeIcon_X9ElhV4$lambda$36(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndStartIcon-nru01g4, reason: not valid java name */
    public static final MeasureResult m3898placeLabelAndStartIconnru01g4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, float f) {
        int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, placeable3.getWidth());
        int iM9083constrainHeightK40F9xA = ConstraintsKt.m9083constrainHeightK40F9xA(j, placeable3.getHeight());
        final int width = (iM9084constrainWidthK40F9xA - placeable4.getWidth()) / 2;
        final int height = (iM9083constrainHeightK40F9xA - placeable4.getHeight()) / 2;
        final int height2 = (iM9083constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        final int height3 = (iM9083constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (iM9084constrainWidthK40F9xA - ((placeable2.getWidth() + measureScope.mo1618roundToPx0680j_4(f)) + placeable.getWidth())) / 2;
        final int width3 = placeable2.getWidth() + width2 + measureScope.mo1618roundToPx0680j_4(f);
        final int width4 = (iM9084constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final int height4 = (iM9083constrainHeightK40F9xA - placeable3.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM9084constrainWidthK40F9xA, iM9083constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeLabelAndStartIcon_nru01g4$lambda$38(placeable4, width, height, placeable, width3, height3, placeable2, width2, height2, placeable3, width4, height4, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeLabelAndStartIcon_nru01g4$lambda$38(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable placeable4, int i7, int i8, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i7, i8, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndTopIcon-qoqLrGI, reason: not valid java name */
    public static final MeasureResult m3899placeLabelAndTopIconqoqLrGI(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, float f, float f2, float f3) {
        int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), placeable3.getWidth()));
        int iM9083constrainHeightK40F9xA = ConstraintsKt.m9083constrainHeightK40F9xA(j, MathKt.roundToInt(placeable3.getHeight() + measureScope.mo1624toPx0680j_4(f) + placeable.getHeight() + (measureScope.mo1624toPx0680j_4(f3) * 2.0f)));
        final int i = measureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(f3 + f2));
        final int width = (iM9084constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width2 = (iM9084constrainWidthK40F9xA - placeable4.getWidth()) / 2;
        final int i2 = i - measureScope.mo1618roundToPx0680j_4(f2);
        final int width3 = (iM9084constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = i + placeable2.getHeight() + measureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(f + f2));
        final int width4 = (iM9084constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        return MeasureScope.layout$default(measureScope, iM9084constrainWidthK40F9xA, iM9083constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeLabelAndTopIcon_qoqLrGI$lambda$37(placeable4, width2, i2, placeable, width3, height, placeable2, width, i, placeable3, width4, i2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit placeLabelAndTopIcon_qoqLrGI$lambda$37(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable placeable4, int i7, int i8, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i7, i8, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
