package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u001al\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0012\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0016\u001av\u0010\u0017\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b#\u0010$\u001ax\u0010\u0017\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b&\u0010'\u001a\u009a\u0001\u0010(\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b.\u0010/\u001a\u009c\u0001\u0010(\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001a&\u00108\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a\u001c\u00109\u001a\u00020\f*\u00020\f2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eH\u0001\u001a\u001a\u0010<\u001a\u00020\f*\u00020\f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0>H\u0000\u001a \u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0000\u001aT\u0010F\u001a\u00020\f*\u00020\f2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0019\u0010N\u001a\u0015\u0012\u0004\u0012\u00020O\u0012\u0006\u0012\u0004\u0018\u00010P0\u0005¢\u0006\u0002\b\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\bQ\u0010R\"\u0016\u0010S\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bT\u0010U\"\u0016\u0010W\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bX\u0010U\"\u0016\u0010Y\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bZ\u0010U\"\u0010\u0010[\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0010\u0010\\\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0014\u0010]\u001a\u00020^X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`\"\u0016\u0010a\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bb\u0010U\"\u0016\u0010c\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bd\u0010U\"\u0010\u0010e\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0010\u0010f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0016\u0010g\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bh\u0010U\"\u0016\u0010i\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bj\u0010U¨\u0006k²\u0006\n\u0010l\u001a\u00020@X\u008a\u0084\u0002²\u0006\n\u0010m\u001a\u00020@X\u008a\u0084\u0002"}, d2 = {"TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onDismissRequest", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "hasAction", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PlainTooltip", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "shadowElevation", "PlainTooltip-m9Er-Xc", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "caretShape", "PlainTooltip-gv3ox5I", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", Constants.GP_IAP_TITLE, NativeProtocol.WEB_DIALOG_ACTION, "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-ZuUcA3Q", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "RichTooltip-EkvW5A0", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "rememberTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "TooltipState", "textVerticalPadding", "subheadExists", "actionExists", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "caretX", "", "tooltipWidth", "screenWidthPx", "", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "layoutCaret", "transformationMatrix", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/Matrix;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "windowContainerSize", "Landroidx/compose/ui/unit/IntSize;", "getAnchorLayoutCoordinates", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCaret-J5j9r9c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Landroidx/compose/ui/window/PopupPositionProvider;)Landroidx/compose/ui/Modifier;", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "()F", "F", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "PlainTooltipVerticalPadding", "PlainTooltipHorizontalPadding", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "HeightFromSubheadToTextFirstLine", "TextBottomPadding", "ActionLabelMinHeight", "getActionLabelMinHeight", "ActionLabelBottomPadding", "getActionLabelBottomPadding", "material3", "scale", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight;
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine;
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float TextBottomPadding;
    private static final float SpacingBetweenTooltipAndAnchor = Dp.m9114constructorimpl(4.0f);
    private static final float TooltipMinHeight = Dp.m9114constructorimpl(24.0f);
    private static final float TooltipMinWidth = Dp.m9114constructorimpl(40.0f);

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(4.0f);
        PlainTooltipVerticalPadding = fM9114constructorimpl;
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(8.0f);
        PlainTooltipHorizontalPadding = fM9114constructorimpl2;
        PlainTooltipContentPadding = PaddingKt.m2031PaddingValuesYgX7TsA(fM9114constructorimpl2, fM9114constructorimpl);
        RichTooltipHorizontalPadding = Dp.m9114constructorimpl(16.0f);
        HeightToSubheadFirstLine = Dp.m9114constructorimpl(28.0f);
        HeightFromSubheadToTextFirstLine = Dp.m9114constructorimpl(24.0f);
        TextBottomPadding = Dp.m9114constructorimpl(16.0f);
        ActionLabelMinHeight = Dp.m9114constructorimpl(36.0f);
        ActionLabelBottomPadding = Dp.m9114constructorimpl(8.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    /* JADX INFO: renamed from: PlainTooltip-gv3ox5I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4470PlainTooltipgv3ox5I(final TooltipScope tooltipScope, Modifier modifier, Shape shape, float f, Shape shape2, long j, long j2, float f2, float f3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Shape shape3;
        int i5;
        float fM4463getPlainTooltipMaxWidthD9Ej5fM;
        Shape plainTooltipContainerShape;
        final long plainTooltipContentColor;
        int i6;
        int i7;
        int i8;
        Composer composer2;
        final float f4;
        final Modifier modifier3;
        final Shape shape4;
        final float f5;
        final long j3;
        final Shape shape5;
        final float f6;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long plainTooltipContainerColor;
        float fM9114constructorimpl;
        int i9;
        int i10;
        long j5;
        float f7;
        final float f8;
        Modifier modifier4;
        Shape shape6;
        final TooltipScope tooltipScope2;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-343758958);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlainTooltip)N(modifier,caretShape,maxWidth:c#ui.unit.Dp,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)461@19351L596,455@19154L793:Tooltip.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    shape3 = shape;
                    i3 |= composerStartRestartGroup.changed(shape3) ? 256 : 128;
                }
                i5 = i2 & 4;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        fM4463getPlainTooltipMaxWidthD9Ej5fM = f;
                        i3 |= composerStartRestartGroup.changed(fM4463getPlainTooltipMaxWidthD9Ej5fM) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 8) == 0) {
                            plainTooltipContainerShape = shape2;
                            int i12 = composerStartRestartGroup.changed(plainTooltipContainerShape) ? 16384 : 8192;
                            i3 |= i12;
                        } else {
                            plainTooltipContainerShape = shape2;
                        }
                        i3 |= i12;
                    } else {
                        plainTooltipContainerShape = shape2;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        plainTooltipContentColor = j;
                        i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(plainTooltipContentColor)) ? 131072 : 65536;
                    } else {
                        plainTooltipContentColor = j;
                    }
                    if ((i & 1572864) == 0) {
                        i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(j2)) ? 1048576 : 524288;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                    }
                    if ((i2 & 256) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                    }
                    i8 = i3;
                    if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i8 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f4 = f3;
                        modifier3 = modifier2;
                        shape4 = shape3;
                        f5 = f2;
                        j3 = plainTooltipContentColor;
                        shape5 = plainTooltipContainerShape;
                        f6 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                        j4 = j2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "424@18046L26,425@18116L24,426@18186L26");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                shape3 = null;
                            }
                            if (i5 != 0) {
                                fM4463getPlainTooltipMaxWidthD9Ej5fM = TooltipDefaults.INSTANCE.m4463getPlainTooltipMaxWidthD9Ej5fM();
                            }
                            if ((i2 & 8) != 0) {
                                plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                                i8 &= -57345;
                            }
                            if ((i2 & 16) != 0) {
                                plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                                i8 &= -458753;
                            }
                            if ((i2 & 32) != 0) {
                                plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                                i8 &= -3670017;
                            } else {
                                plainTooltipContainerColor = j2;
                            }
                            float fM9114constructorimpl2 = i6 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                            fM9114constructorimpl = i7 != 0 ? Dp.m9114constructorimpl(0.0f) : f3;
                            i9 = 12582912;
                            i10 = i8;
                            j5 = plainTooltipContainerColor;
                            f7 = fM9114constructorimpl2;
                            f8 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i8 &= -57345;
                            }
                            if ((i2 & 16) != 0) {
                                i8 &= -458753;
                            }
                            if ((i2 & 32) != 0) {
                                i8 &= -3670017;
                            }
                            j5 = j2;
                            fM9114constructorimpl = f3;
                            f8 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                            i9 = 12582912;
                            i10 = i8;
                            f7 = f2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i13 = i9;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-343758958, i10, -1, "androidx.compose.material3.PlainTooltip (Tooltip.kt:430)");
                        }
                        if (shape3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1720477287);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "434@18445L37,435@18518L7,436@18576L7,442@18790L24,447@18947L118");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 360143287, "CC(remember):Tooltip.kt#9igjgp");
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Matrix.m6567boximpl(Matrix.m6569constructorimpl$default(null, 1, null)), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            MutableState mutableState = (MutableState) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localWindowInfo);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jMo8274getContainerSizeYbymL2g = ((WindowInfo) objConsume2).mo8274getContainerSizeYbymL2g();
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 360154314, "CC(remember):Tooltip.kt#9igjgp");
                            if ((i10 & 14) != 4) {
                                if ((i10 & 8) != 0) {
                                    tooltipScope2 = tooltipScope;
                                    if (composerStartRestartGroup.changedInstance(tooltipScope2)) {
                                    }
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return tooltipScope2.obtainAnchorBounds((MeasureScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier modifierThen = m4474layoutCaretJ5j9r9c(companion, mutableState, density, jMo8274getContainerSizeYbymL2g, (Function1) objRememberedValue, tooltipScope2.obtainPositionProvider()).then(modifier2);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 360159432, "CC(remember):Tooltip.kt#9igjgp");
                                    z2 = ((((57344 & i10) ^ 24576) <= 16384 && composerStartRestartGroup.changed(plainTooltipContainerShape)) || (i10 & 24576) == 16384) | ((i10 & 896) == 256);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new TooltipCaretShape(mutableState, plainTooltipContainerShape, shape3);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endReplaceGroup();
                                    modifier4 = modifierThen;
                                    shape6 = (TooltipCaretShape) objRememberedValue2;
                                } else {
                                    tooltipScope2 = tooltipScope;
                                }
                                z = false;
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return tooltipScope2.obtainAnchorBounds((MeasureScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier modifierThen2 = m4474layoutCaretJ5j9r9c(companion, mutableState, density, jMo8274getContainerSizeYbymL2g, (Function1) objRememberedValue, tooltipScope2.obtainPositionProvider()).then(modifier2);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 360159432, "CC(remember):Tooltip.kt#9igjgp");
                                    if (((57344 & i10) ^ 24576) <= 16384) {
                                        z2 = ((((57344 & i10) ^ 24576) <= 16384 && composerStartRestartGroup.changed(plainTooltipContainerShape)) || (i10 & 24576) == 16384) | ((i10 & 896) == 256);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (z2) {
                                            objRememberedValue2 = new TooltipCaretShape(mutableState, plainTooltipContainerShape, shape3);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            composerStartRestartGroup.endReplaceGroup();
                                            modifier4 = modifierThen2;
                                            shape6 = (TooltipCaretShape) objRememberedValue2;
                                        }
                                    } else {
                                        z2 = ((((57344 & i10) ^ 24576) <= 16384 && composerStartRestartGroup.changed(plainTooltipContainerShape)) || (i10 & 24576) == 16384) | ((i10 & 896) == 256);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (z2) {
                                        }
                                    }
                                }
                            } else {
                                tooltipScope2 = tooltipScope;
                            }
                            z = true;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z) {
                            }
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1719831991);
                            composerStartRestartGroup.endReplaceGroup();
                            modifier4 = modifier2;
                            shape6 = plainTooltipContainerShape;
                        }
                        float f9 = f8;
                        int i14 = i10 >> 9;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4145SurfaceT9BRK9s(modifier4, shape6, j5, 0L, f7, fM9114constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(-1573998995, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$PlainTooltip$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                ComposerKt.sourceInformation(composer3, "C462@19361L580:Tooltip.kt#uh7d8r");
                                if (!composer3.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1573998995, i15, -1, "androidx.compose.material3.PlainTooltip.<anonymous> (Tooltip.kt:462)");
                                }
                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m2087sizeInqDBjuR0$default(Modifier.INSTANCE, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), f8, 0.0f, 8, null), TooltipKt.getPlainTooltipContentPadding());
                                long j6 = plainTooltipContentColor;
                                Function2<Composer, Integer, Unit> function22 = function2;
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierPadding);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -959381731, "C471@19730L5,473@19749L182:Tooltip.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j6)), TextKt.getLocalTextStyle().provides(TypographyKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6))}, function22, composer3, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i10 >> 12) & 896) | i13 | (57344 & i14) | (i14 & 458752), 72);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        shape4 = shape3;
                        f5 = f7;
                        f4 = fM9114constructorimpl;
                        j3 = plainTooltipContentColor;
                        shape5 = plainTooltipContainerShape;
                        j4 = j5;
                        f6 = f9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TooltipKt.PlainTooltip_gv3ox5I$lambda$11(tooltipScope, modifier3, shape4, f6, shape5, j3, j4, f5, f4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                fM4463getPlainTooltipMaxWidthD9Ej5fM = f;
                if ((i & 24576) != 0) {
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                i8 = i3;
                if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i8 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            shape3 = shape;
            i5 = i2 & 4;
            if (i5 == 0) {
            }
            fM4463getPlainTooltipMaxWidthD9Ej5fM = f;
            if ((i & 24576) != 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i8 = i3;
            if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i8 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 == 0) {
        }
        shape3 = shape;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        fM4463getPlainTooltipMaxWidthD9Ej5fM = f;
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i8 = i3;
        if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i8 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0125 A[PHI: r19
      0x0125: PHI (r19v8 int) = (r19v4 int), (r19v6 int), (r19v7 int) binds: [B:102:0x0123, B:109:0x0137, B:108:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: PlainTooltip-m9Er-Xc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4471PlainTooltipm9ErXc(final TooltipScope tooltipScope, Modifier modifier, long j, float f, Shape shape, long j2, long j3, float f2, float f3, final Function2 function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j4;
        int i4;
        float f4;
        Shape shape2;
        long j5;
        int i5;
        int i6;
        final float f5;
        int i7;
        int i8;
        int i9;
        final Modifier modifier3;
        final long j6;
        final float f6;
        final Shape shape3;
        Composer composer2;
        final long j7;
        final long j8;
        final float f7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM9221getUnspecifiedMYxV2XQ;
        float fM4463getPlainTooltipMaxWidthD9Ej5fM;
        Shape plainTooltipContainerShape;
        long plainTooltipContentColor;
        long plainTooltipContainerColor;
        long j9;
        Shape shape4;
        long j10;
        int i10;
        float fM9114constructorimpl;
        float f8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1881241092);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlainTooltip)N(modifier,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)389@16632L229:Tooltip.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 2) == 0) {
                    j4 = j;
                    int i12 = composerStartRestartGroup.changed(j4) ? 256 : 128;
                    i3 |= i12;
                } else {
                    j4 = j;
                }
                i3 |= i12;
            } else {
                j4 = j;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    f4 = f;
                    i3 |= composerStartRestartGroup.changed(f4) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i13 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    j5 = j2;
                    i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j5)) ? 131072 : 65536;
                } else {
                    j5 = j2;
                }
                if ((1572864 & i) == 0) {
                    i5 = i3 | (((i2 & 32) == 0 && composerStartRestartGroup.changed(j3)) ? 1048576 : 524288);
                } else {
                    i5 = i3;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i5 |= 12582912;
                    f5 = f2;
                } else {
                    f5 = f2;
                    if ((i & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(f5) ? 8388608 : 4194304;
                    }
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                    if ((i & 100663296) == 0) {
                        i8 = i7;
                        i5 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                    }
                    int i14 = 805306368;
                    if ((i2 & 256) != 0) {
                        i5 |= i14;
                    } else if ((i & 805306368) == 0) {
                        i14 = composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                        i5 |= i14;
                    }
                    i9 = i5;
                    if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        j6 = j4;
                        f6 = f4;
                        shape3 = shape2;
                        composer2 = composerStartRestartGroup;
                        j7 = j5;
                        j8 = j3;
                        f7 = f3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "382@16356L26,383@16426L24,384@16496L26");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                jM9221getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
                                i9 &= -897;
                            } else {
                                jM9221getUnspecifiedMYxV2XQ = j4;
                            }
                            fM4463getPlainTooltipMaxWidthD9Ej5fM = i4 != 0 ? TooltipDefaults.INSTANCE.m4463getPlainTooltipMaxWidthD9Ej5fM() : f4;
                            if ((i2 & 8) != 0) {
                                plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                                i9 &= -57345;
                            } else {
                                plainTooltipContainerShape = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            } else {
                                plainTooltipContentColor = j5;
                            }
                            if ((i2 & 32) != 0) {
                                plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                plainTooltipContainerColor = j3;
                            }
                            float fM9114constructorimpl2 = i6 != 0 ? Dp.m9114constructorimpl(0.0f) : f5;
                            if (i8 != 0) {
                                f5 = fM9114constructorimpl2;
                                i10 = i9;
                                fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                                j9 = jM9221getUnspecifiedMYxV2XQ;
                                shape4 = plainTooltipContainerShape;
                                j10 = plainTooltipContainerColor;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    f8 = fM9114constructorimpl;
                                } else {
                                    f8 = fM9114constructorimpl;
                                    ComposerKt.traceEventStart(-1881241092, i10, -1, "androidx.compose.material3.PlainTooltip (Tooltip.kt:389)");
                                }
                                int i15 = 2147482750 & i10;
                                long j11 = j9;
                                float f9 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                                long j12 = plainTooltipContentColor;
                                float f10 = f5;
                                float f11 = f8;
                                m4470PlainTooltipgv3ox5I(tooltipScope, companion, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j9), f9, shape4, j12, j10, f10, f11, function2, composerStartRestartGroup, i15, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                f5 = f10;
                                composer2 = composerStartRestartGroup;
                                f7 = f11;
                                j8 = j10;
                                j7 = j12;
                                f6 = f9;
                                shape3 = shape4;
                                j6 = j11;
                            } else {
                                f5 = fM9114constructorimpl2;
                                j9 = jM9221getUnspecifiedMYxV2XQ;
                                shape4 = plainTooltipContainerShape;
                                j10 = plainTooltipContainerColor;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i9 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i9 &= -57345;
                            }
                            if ((i2 & 16) != 0) {
                                i9 &= -458753;
                            }
                            if ((i2 & 32) != 0) {
                                i9 &= -3670017;
                            }
                            companion = modifier2;
                            j9 = j4;
                            fM4463getPlainTooltipMaxWidthD9Ej5fM = f4;
                            shape4 = shape2;
                            plainTooltipContentColor = j5;
                            j10 = j3;
                        }
                        i10 = i9;
                        fM9114constructorimpl = f3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i152 = 2147482750 & i10;
                        long j112 = j9;
                        float f92 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                        long j122 = plainTooltipContentColor;
                        float f102 = f5;
                        float f112 = f8;
                        m4470PlainTooltipgv3ox5I(tooltipScope, companion, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j9), f92, shape4, j122, j10, f102, f112, function2, composerStartRestartGroup, i152, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = companion;
                        f5 = f102;
                        composer2 = composerStartRestartGroup;
                        f7 = f112;
                        j8 = j10;
                        j7 = j122;
                        f6 = f92;
                        shape3 = shape4;
                        j6 = j112;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TooltipKt.PlainTooltip_m9Er_Xc$lambda$6(tooltipScope, modifier3, j6, f6, shape3, j7, j8, f5, f7, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 100663296;
                i8 = i7;
                int i142 = 805306368;
                if ((i2 & 256) != 0) {
                }
                i9 = i5;
                if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f4 = f;
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i7;
            int i1422 = 805306368;
            if ((i2 & 256) != 0) {
            }
            i9 = i5;
            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f4 = f;
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i7;
        int i14222 = 805306368;
        if ((i2 & 256) != 0) {
        }
        i9 = i5;
        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit PlainTooltip_gv3ox5I$lambda$11(TooltipScope tooltipScope, Modifier modifier, Shape shape, float f, Shape shape2, long j, long j2, float f2, float f3, Function2 function2, int i, int i2, Composer composer, int i3) {
        m4470PlainTooltipgv3ox5I(tooltipScope, modifier, shape, f, shape2, j, j2, f2, f3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit PlainTooltip_m9Er_Xc$lambda$6(TooltipScope tooltipScope, Modifier modifier, long j, float f, Shape shape, long j2, long j3, float f2, float f3, Function2 function2, int i, int i2, Composer composer, int i3) {
        m4471PlainTooltipm9ErXc(tooltipScope, modifier, j, f, shape, j2, j3, f2, f3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX INFO: renamed from: RichTooltip-EkvW5A0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4472RichTooltipEkvW5A0(final TooltipScope tooltipScope, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, float f, Shape shape2, RichTooltipColors richTooltipColors, float f2, float f3, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Composer composer2;
        final Shape shape3;
        final float f4;
        final RichTooltipColors richTooltipColors2;
        final float f5;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape4;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape5;
        float fM4464getRichTooltipMaxWidthD9Ej5fM;
        Shape richTooltipContainerShape;
        final RichTooltipColors richTooltipColors3;
        float fM5290getContainerElevationD9Ej5fM;
        float f7;
        int i15;
        int i16;
        float f8;
        Modifier modifier4;
        Shape shape6;
        Composer composerStartRestartGroup = composer.startRestartGroup(236290785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RichTooltip)N(modifier,title,action,caretShape,maxWidth:c#ui.unit.Dp,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)578@23684L1598,567@23319L1963:Tooltip.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i17 = i3 & 1;
        if (i17 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 2;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function24 = function2;
                    i4 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
                }
                i6 = i3 & 4;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    }
                    i7 = i3 & 8;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            i4 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
                        }
                        i8 = i3 & 16;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
                        }
                        if ((i & 1572864) == 0) {
                            i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(shape2)) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(richTooltipColors)) ? 8388608 : 4194304;
                        }
                        i9 = i3 & 128;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else {
                            if ((i & 100663296) == 0) {
                                i10 = i9;
                                i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                            }
                            i11 = i3 & 256;
                            if (i11 != 0) {
                                if ((i & 805306368) == 0) {
                                    i12 = i11;
                                    i4 |= composerStartRestartGroup.changed(f3) ? 536870912 : 268435456;
                                }
                                if ((i3 & 512) != 0) {
                                    i13 = i2 | 6;
                                } else if ((i2 & 6) == 0) {
                                    i13 = i2 | (composerStartRestartGroup.changedInstance(function23) ? 4 : 2);
                                } else {
                                    i13 = i2;
                                }
                                i14 = i4;
                                if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "537@22236L25,538@22311L19");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        companion = i17 != 0 ? Modifier.INSTANCE : modifier2;
                                        if (i5 != 0) {
                                            function24 = null;
                                        }
                                        if (i6 != 0) {
                                            function25 = null;
                                        }
                                        shape5 = i7 != 0 ? null : shape;
                                        fM4464getRichTooltipMaxWidthD9Ej5fM = i8 != 0 ? TooltipDefaults.INSTANCE.m4464getRichTooltipMaxWidthD9Ej5fM() : f;
                                        if ((i3 & 32) != 0) {
                                            richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                            i14 &= -3670017;
                                        } else {
                                            richTooltipContainerShape = shape2;
                                        }
                                        if ((i3 & 64) != 0) {
                                            richTooltipColors3 = TooltipDefaults.INSTANCE.richTooltipColors(composerStartRestartGroup, 6);
                                            i14 &= -29360129;
                                        } else {
                                            richTooltipColors3 = richTooltipColors;
                                        }
                                        float fM4947getLevel0D9Ej5fM = i10 != 0 ? ElevationTokens.INSTANCE.m4947getLevel0D9Ej5fM() : f2;
                                        if (i12 != 0) {
                                            f7 = fM4947getLevel0D9Ej5fM;
                                            fM5290getContainerElevationD9Ej5fM = RichTooltipTokens.INSTANCE.m5290getContainerElevationD9Ej5fM();
                                        } else {
                                            fM5290getContainerElevationD9Ej5fM = f3;
                                            f7 = fM4947getLevel0D9Ej5fM;
                                        }
                                        i15 = i14;
                                        i16 = 2;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        int i18 = (i3 & 32) != 0 ? i14 & (-3670017) : i14;
                                        if ((i3 & 64) != 0) {
                                            i18 &= -29360129;
                                        }
                                        shape5 = shape;
                                        richTooltipContainerShape = shape2;
                                        richTooltipColors3 = richTooltipColors;
                                        f7 = f2;
                                        fM5290getContainerElevationD9Ej5fM = f3;
                                        i15 = i18;
                                        companion = modifier2;
                                        i16 = 2;
                                        fM4464getRichTooltipMaxWidthD9Ej5fM = f;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(236290785, i15, i13, "androidx.compose.material3.RichTooltip (Tooltip.kt:542)");
                                    }
                                    if (shape5 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-111951894);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "546@22610L37,547@22683L7,548@22741L7,554@22955L24,559@23112L118");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557800122, "CC(remember):Tooltip.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            f8 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Matrix.m6567boximpl(Matrix.m6569constructorimpl$default(null, 1, null)), null, i16, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            f8 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                        }
                                        MutableState mutableState = (MutableState) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composerStartRestartGroup.consume(localWindowInfo);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        long jMo8274getContainerSizeYbymL2g = ((WindowInfo) objConsume2).mo8274getContainerSizeYbymL2g();
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557789095, "CC(remember):Tooltip.kt#9igjgp");
                                        boolean z = (i15 & 14) == 4 || ((i15 & 8) != 0 && composerStartRestartGroup.changedInstance(tooltipScope));
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return tooltipScope.obtainAnchorBounds((MeasureScope) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        Modifier modifierThen = m4474layoutCaretJ5j9r9c(companion2, mutableState, density, jMo8274getContainerSizeYbymL2g, (Function1) objRememberedValue2, tooltipScope.obtainPositionProvider()).then(companion);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557783977, "CC(remember):Tooltip.kt#9igjgp");
                                        boolean z2 = ((((3670016 & i15) ^ 1572864) > 1048576 && composerStartRestartGroup.changed(richTooltipContainerShape)) || (i15 & 1572864) == 1048576) | ((57344 & i15) == 16384);
                                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue3 = new TooltipCaretShape(mutableState, richTooltipContainerShape, shape5);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        modifier4 = modifierThen;
                                        shape6 = (TooltipCaretShape) objRememberedValue3;
                                    } else {
                                        f8 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                        composerStartRestartGroup.startReplaceGroup(-111306598);
                                        composerStartRestartGroup.endReplaceGroup();
                                        modifier4 = companion;
                                        shape6 = richTooltipContainerShape;
                                    }
                                    float f9 = f8;
                                    int i19 = i15 >> 12;
                                    composer2 = composerStartRestartGroup;
                                    SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.m2087sizeInqDBjuR0$default(modifier4, TooltipMinWidth, TooltipMinHeight, f8, 0.0f, 8, null), shape6, richTooltipColors3.getContainerColor(), 0L, f7, fM5290getContainerElevationD9Ej5fM, null, ComposableLambdaKt.rememberComposableLambda(-1249811482, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i20) {
                                            Function2<Composer, Integer, Unit> function27;
                                            RichTooltipColors richTooltipColors4;
                                            ComposerKt.sourceInformation(composer3, "C579@23759L5,580@23826L5,581@23903L5,583@23918L1358:Tooltip.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1249811482, i20, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:579)");
                                            }
                                            TextStyle value = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                                            TextStyle value2 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSubheadFont(), composer3, 6);
                                            TextStyle value3 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                                            Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                                            Function2<Composer, Integer, Unit> function28 = function24;
                                            Function2<Composer, Integer, Unit> function29 = function25;
                                            RichTooltipColors richTooltipColors5 = richTooltipColors3;
                                            Function2<Composer, Integer, Unit> function210 = function23;
                                            ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2039paddingVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 112071776, "C593@24412L320:Tooltip.kt#uh7d8r");
                                            if (function28 == null) {
                                                composer3.startReplaceGroup(112051624);
                                                composer3.endReplaceGroup();
                                                function27 = function29;
                                                richTooltipColors4 = richTooltipColors5;
                                            } else {
                                                composer3.startReplaceGroup(112051625);
                                                ComposerKt.sourceInformation(composer3, "*585@24040L345");
                                                function27 = function29;
                                                richTooltipColors4 = richTooltipColors5;
                                                Modifier modifierM1882paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m1882paddingFromBaselineVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1882paddingFromBaselineVpY3zN4$default);
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 1350098263, "C586@24139L228:Tooltip.kt#uh7d8r");
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(richTooltipColors4.getTitleContentColor())), TextKt.getLocalTextStyle().provides(value2)}, function28, composer3, ProvidedValue.$stable);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Unit unit = Unit.INSTANCE;
                                                composer3.endReplaceGroup();
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            Modifier modifierTextVerticalPadding = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function28 != null, function27 != null);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierTextVerticalPadding);
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer3);
                                            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 97538765, "C594@24506L212:Tooltip.kt#uh7d8r");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(richTooltipColors4.getContentColor())), TextKt.getLocalTextStyle().provides(value3)}, function210, composer3, ProvidedValue.$stable);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            if (function27 == null) {
                                                composer3.startReplaceGroup(112784836);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(112784837);
                                                ComposerKt.sourceInformation(composer3, "*601@24775L477");
                                                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.m2074requiredHeightInVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierM2041paddingqDBjuR0$default);
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor4);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer3);
                                                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, -424550181, "C606@25001L233:Tooltip.kt#uh7d8r");
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(richTooltipColors4.getActionContentColor())), TextKt.getLocalTextStyle().provides(value)}, function27, composer3, ProvidedValue.$stable);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Unit unit3 = Unit.INSTANCE;
                                                composer3.endReplaceGroup();
                                                Unit unit4 = Unit.INSTANCE;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composer2, (57344 & i19) | 12582912 | (i19 & 458752), 72);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = companion;
                                    shape3 = shape5;
                                    f4 = f9;
                                    shape4 = richTooltipContainerShape;
                                    function26 = function24;
                                    richTooltipColors2 = richTooltipColors3;
                                    f6 = f7;
                                    f5 = fM5290getContainerElevationD9Ej5fM;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    shape3 = shape;
                                    f4 = f;
                                    richTooltipColors2 = richTooltipColors;
                                    f5 = f3;
                                    modifier3 = modifier2;
                                    function26 = function24;
                                    shape4 = shape2;
                                    f6 = f2;
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TooltipKt.RichTooltip_EkvW5A0$lambda$17(tooltipScope, modifier3, function26, function27, shape3, f4, shape4, richTooltipColors2, f6, f5, function23, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 805306368;
                            i12 = i11;
                            if ((i3 & 512) != 0) {
                            }
                            i14 = i4;
                            if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
                            }
                            final Function2 function272 = function25;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i10 = i9;
                        i11 = i3 & 256;
                        if (i11 != 0) {
                        }
                        i12 = i11;
                        if ((i3 & 512) != 0) {
                        }
                        i14 = i4;
                        if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
                        }
                        final Function2 function2722 = function25;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i8 = i3 & 16;
                    if (i8 != 0) {
                    }
                    if ((i & 1572864) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i9 = i3 & 128;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3 & 256;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    if ((i3 & 512) != 0) {
                    }
                    i14 = i4;
                    if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
                    }
                    final Function2 function27222 = function25;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function25 = function22;
                i7 = i3 & 8;
                if (i7 == 0) {
                }
                i8 = i3 & 16;
                if (i8 != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3 & 256;
                if (i11 != 0) {
                }
                i12 = i11;
                if ((i3 & 512) != 0) {
                }
                i14 = i4;
                if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
                }
                final Function2 function272222 = function25;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function24 = function2;
            i6 = i3 & 4;
            if (i6 != 0) {
            }
            function25 = function22;
            i7 = i3 & 8;
            if (i7 == 0) {
            }
            i8 = i3 & 16;
            if (i8 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 128;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 256;
            if (i11 != 0) {
            }
            i12 = i11;
            if ((i3 & 512) != 0) {
            }
            i14 = i4;
            if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
            }
            final Function2 function2722222 = function25;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 2;
        if (i5 == 0) {
        }
        function24 = function2;
        i6 = i3 & 4;
        if (i6 != 0) {
        }
        function25 = function22;
        i7 = i3 & 8;
        if (i7 == 0) {
        }
        i8 = i3 & 16;
        if (i8 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 128;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 256;
        if (i11 != 0) {
        }
        i12 = i11;
        if ((i3 & 512) != 0) {
        }
        i14 = i4;
        if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i14 & 1)) {
        }
        final Function2 function27222222 = function25;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: RichTooltip-ZuUcA3Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4473RichTooltipZuUcA3Q(final TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, long j, float f, Shape shape, RichTooltipColors richTooltipColors, float f2, float f3, final Function2 function23, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2 function24;
        int i6;
        Function2 function25;
        long j2;
        int i7;
        float fM4464getRichTooltipMaxWidthD9Ej5fM;
        RichTooltipColors richTooltipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        final Shape shape2;
        final float f4;
        final Modifier modifier3;
        final Function2 function26;
        Composer composer2;
        final float f5;
        final float f6;
        final RichTooltipColors richTooltipColors3;
        final Function2 function27;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM9221getUnspecifiedMYxV2XQ;
        Shape richTooltipContainerShape;
        int i13;
        Function2 function28;
        float f7;
        float fM5290getContainerElevationD9Ej5fM;
        float f8;
        RichTooltipColors richTooltipColors4;
        long j4;
        Function2 function29;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2125725529);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RichTooltip)N(modifier,title,action,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)497@20615L226:Tooltip.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i3 & 1;
        if (i14 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 2;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function24 = function2;
                    i4 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
                }
                i6 = i3 & 4;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i3 & 8) == 0) {
                            j2 = j;
                            int i15 = composerStartRestartGroup.changed(j2) ? 16384 : 8192;
                            i4 |= i15;
                        } else {
                            j2 = j;
                        }
                        i4 |= i15;
                    } else {
                        j2 = j;
                    }
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        fM4464getRichTooltipMaxWidthD9Ej5fM = f;
                    } else {
                        fM4464getRichTooltipMaxWidthD9Ej5fM = f;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(fM4464getRichTooltipMaxWidthD9Ej5fM) ? 131072 : 65536;
                        }
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        richTooltipColors2 = richTooltipColors;
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(richTooltipColors2)) ? 8388608 : 4194304;
                    } else {
                        richTooltipColors2 = richTooltipColors;
                    }
                    i8 = i3 & 128;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                        }
                        i10 = i3 & 256;
                        if (i10 == 0) {
                            if ((i & 805306368) == 0) {
                                i11 = i10;
                                i4 |= composerStartRestartGroup.changed(f3) ? 536870912 : 268435456;
                            }
                            if ((i3 & 512) == 0) {
                                i12 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i12 = i2 | (composerStartRestartGroup.changedInstance(function23) ? 4 : 2);
                            } else {
                                i12 = i2;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                shape2 = shape;
                                f4 = f2;
                                modifier3 = modifier2;
                                function26 = function24;
                                composer2 = composerStartRestartGroup;
                                f5 = f3;
                                f6 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                richTooltipColors3 = richTooltipColors2;
                                function27 = function25;
                                j3 = j2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "491@20364L25,492@20439L19");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i14 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (i5 != 0) {
                                        function24 = null;
                                    }
                                    Function2 function210 = i6 == 0 ? function25 : null;
                                    if ((i3 & 8) != 0) {
                                        jM9221getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
                                        i4 &= -57345;
                                    } else {
                                        jM9221getUnspecifiedMYxV2XQ = j2;
                                    }
                                    if (i7 != 0) {
                                        fM4464getRichTooltipMaxWidthD9Ej5fM = TooltipDefaults.INSTANCE.m4464getRichTooltipMaxWidthD9Ej5fM();
                                    }
                                    if ((i3 & 32) != 0) {
                                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                        i4 &= -3670017;
                                    } else {
                                        richTooltipContainerShape = shape;
                                    }
                                    if ((i3 & 64) != 0) {
                                        richTooltipColors2 = TooltipDefaults.INSTANCE.richTooltipColors(composerStartRestartGroup, 6);
                                        i4 = (-29360129) & i4;
                                    }
                                    float fM4947getLevel0D9Ej5fM = i9 != 0 ? ElevationTokens.INSTANCE.m4947getLevel0D9Ej5fM() : f2;
                                    if (i11 != 0) {
                                        long j5 = jM9221getUnspecifiedMYxV2XQ;
                                        f8 = fM4947getLevel0D9Ej5fM;
                                        richTooltipColors4 = richTooltipColors2;
                                        function29 = function24;
                                        fM5290getContainerElevationD9Ej5fM = RichTooltipTokens.INSTANCE.m5290getContainerElevationD9Ej5fM();
                                        i13 = i4;
                                        function28 = function210;
                                        f7 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                        j4 = j5;
                                    } else {
                                        i13 = i4;
                                        function28 = function210;
                                        f7 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                        Function2 function211 = function24;
                                        fM5290getContainerElevationD9Ej5fM = f3;
                                        long j6 = jM9221getUnspecifiedMYxV2XQ;
                                        f8 = fM4947getLevel0D9Ej5fM;
                                        richTooltipColors4 = richTooltipColors2;
                                        j4 = j6;
                                        function29 = function211;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 8) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i3 & 32) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -29360129;
                                    }
                                    Function2 function212 = function25;
                                    i13 = i4;
                                    function28 = function212;
                                    richTooltipContainerShape = shape;
                                    f8 = f2;
                                    f7 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                    companion = modifier2;
                                    function29 = function24;
                                    fM5290getContainerElevationD9Ej5fM = f3;
                                    richTooltipColors4 = richTooltipColors2;
                                    j4 = j2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2125725529, i13, i12, "androidx.compose.material3.RichTooltip (Tooltip.kt:497)");
                                }
                                long j7 = j4;
                                float f9 = f7;
                                Shape shape3 = richTooltipContainerShape;
                                m4472RichTooltipEkvW5A0(tooltipScope, companion, function29, function28, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j4), f9, shape3, richTooltipColors4, f8, fM5290getContainerElevationD9Ej5fM, function23, composerStartRestartGroup, i13 & 2147426302, i12 & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function27 = function28;
                                f4 = f8;
                                composer2 = composerStartRestartGroup;
                                function26 = function29;
                                shape2 = shape3;
                                f5 = fM5290getContainerElevationD9Ej5fM;
                                modifier3 = companion;
                                richTooltipColors3 = richTooltipColors4;
                                f6 = f9;
                                j3 = j7;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TooltipKt.RichTooltip_ZuUcA3Q$lambda$12(tooltipScope, modifier3, function26, function27, j3, f6, shape2, richTooltipColors3, f4, f5, function23, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        i11 = i10;
                        if ((i3 & 512) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    i10 = i3 & 256;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if ((i3 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function25 = function22;
                if ((i & 24576) != 0) {
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i8 = i3 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i3 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function24 = function2;
            i6 = i3 & 4;
            if (i6 != 0) {
            }
            function25 = function22;
            if ((i & 24576) != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i8 = i3 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i3 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 2;
        if (i5 == 0) {
        }
        function24 = function2;
        i6 = i3 & 4;
        if (i6 != 0) {
        }
        function25 = function22;
        if ((i & 24576) != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i8 = i3 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i3 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit RichTooltip_EkvW5A0$lambda$17(TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, Shape shape, float f, Shape shape2, RichTooltipColors richTooltipColors, float f2, float f3, Function2 function23, int i, int i2, int i3, Composer composer, int i4) {
        m4472RichTooltipEkvW5A0(tooltipScope, modifier, function2, function22, shape, f, shape2, richTooltipColors, f2, f3, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit RichTooltip_ZuUcA3Q$lambda$12(TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, long j, float f, Shape shape, RichTooltipColors richTooltipColors, float f2, float f3, Function2 function23, int i, int i2, int i3, Composer composer, int i4) {
        m4473RichTooltipZuUcA3Q(tooltipScope, modifier, function2, function22, j, f, shape, richTooltipColors, f2, f3, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TooltipBox API that contains hasAction param.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TooltipBox(final PopupPositionProvider popupPositionProvider, final Function3 function3, final TooltipState tooltipState, Modifier modifier, Function0 function0, boolean z, boolean z2, final Function2 function2, Composer composer, final int i, final int i2) {
        PopupPositionProvider popupPositionProvider2;
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        Function2 function22;
        final Function0 function02;
        final Modifier modifier3;
        final boolean z5;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2055306788);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipBox)N(positionProvider,tooltip,state,modifier,onDismissRequest,focusable,enableUserInput,content)209@9135L302:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            popupPositionProvider2 = popupPositionProvider;
        } else if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i3 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        z3 = z;
                        i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else {
                        if ((1572864 & i) == 0) {
                            z4 = z2;
                            i3 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
                        }
                        if ((i2 & 128) == 0) {
                            if ((i & 12582912) == 0) {
                                function22 = function2;
                                i3 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                            }
                            if (composerStartRestartGroup.shouldExecute((4785299 & i3) == 4785298, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function02 = function0;
                                modifier3 = modifier2;
                                z5 = z3;
                                z6 = z4;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                Function0 function03 = (i2 & 16) != 0 ? null : function0;
                                boolean z7 = i5 != 0 ? true : z3;
                                Modifier modifier4 = modifier2;
                                boolean z8 = i6 != 0 ? true : z4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2055306788, i3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:208)");
                                }
                                TooltipBox(popupPositionProvider2, function3, tooltipState, modifier4, null, z7, z8, false, function22, composerStartRestartGroup, (i3 & 14) | 12607488 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z6 = z8;
                                z5 = z7;
                                function02 = function03;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TooltipKt.TooltipBox$lambda$1(popupPositionProvider, function3, tooltipState, modifier3, function02, z5, z6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 12582912;
                        function22 = function2;
                        if (composerStartRestartGroup.shouldExecute((4785299 & i3) == 4785298, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z4 = z2;
                    if ((i2 & 128) == 0) {
                    }
                    function22 = function2;
                    if (composerStartRestartGroup.shouldExecute((4785299 & i3) == 4785298, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                z4 = z2;
                if ((i2 & 128) == 0) {
                }
                function22 = function2;
                if (composerStartRestartGroup.shouldExecute((4785299 & i3) == 4785298, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            z3 = z;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            z4 = z2;
            if ((i2 & 128) == 0) {
            }
            function22 = function2;
            if (composerStartRestartGroup.shouldExecute((4785299 & i3) == 4785298, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z3 = z;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        z4 = z2;
        if ((i2 & 128) == 0) {
        }
        function22 = function2;
        if (composerStartRestartGroup.shouldExecute((4785299 & i3) == 4785298, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TooltipBox(final PopupPositionProvider popupPositionProvider, final Function3<? super TooltipScope, ? super Composer, ? super Integer, Unit> function3, final TooltipState tooltipState, Modifier modifier, Function0<Unit> function0, boolean z, boolean z2, boolean z3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function0<Unit> function02;
        int i5;
        boolean z4;
        int i6;
        int i7;
        int i8;
        final boolean z5;
        final Modifier modifier3;
        final Function0<Unit> function03;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-293753984);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipBox)N(positionProvider,tooltip,state,modifier,onDismissRequest,focusable,enableUserInput,hasAction,content)311@13450L64,312@13572L33,313@13622L71,315@13744L103,321@13933L64,319@13853L387:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 256 : 128;
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
                    function02 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        z4 = z;
                        i3 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                        if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function02 = null;
                            }
                            boolean z8 = i5 != 0 ? false : z4;
                            Modifier modifier5 = modifier2;
                            boolean z9 = i6 != 0 ? true : z2;
                            boolean z10 = i8 != 0 ? false : z3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-293753984, i3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:309)");
                            }
                            final Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) tooltipState.getTransition(), "tooltip transition", composerStartRestartGroup, MutableTransitionState.$stable | 48, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1170281089, "CC(remember):Tooltip.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                modifier4 = modifier5;
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                modifier4 = modifier5;
                            }
                            final MutableState mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1170282727, "CC(remember):Tooltip.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return TooltipKt.TooltipBox$lambda$4$lambda$3(mutableState);
                                    }
                                }, popupPositionProvider);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            final TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i10 = (i3 & 14) | 100663344 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3);
                            Function0<Unit> function04 = function02;
                            Modifier modifier6 = modifier4;
                            BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-527401546, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt.TooltipBox.3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i11) {
                                    ComposerKt.sourceInformation(composer2, "C321@13935L60:Tooltip.kt#uh7d8r");
                                    if (!composer2.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-527401546, i11, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:321)");
                                    }
                                    Modifier modifierAnimateTooltip = TooltipKt.animateTooltip(Modifier.INSTANCE, transitionUpdateTransition);
                                    Function3<TooltipScope, Composer, Integer, Unit> function32 = function3;
                                    TooltipScopeImpl tooltipScopeImpl2 = tooltipScopeImpl;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierAnimateTooltip);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 1084289368, "C321@13984L9:Tooltip.kt#uh7d8r");
                                    function32.invoke(tooltipScopeImpl2, composer2, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), tooltipState, modifier6, function04, z8, z9, z10, ComposableLambdaKt.rememberComposableLambda(-23901870, true, new TooltipKt$TooltipBox$wrappedContent$1(mutableState, function2), composerStartRestartGroup, 54), composerStartRestartGroup, i10, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z10;
                            z5 = z9;
                            z6 = z8;
                            function03 = function04;
                            modifier3 = modifier6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z5 = z2;
                            modifier3 = modifier2;
                            function03 = function02;
                            z6 = z4;
                            z7 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TooltipKt.TooltipBox$lambda$5(popupPositionProvider, function3, tooltipState, modifier3, function03, z6, z5, z7, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    i8 = i7;
                    if ((i2 & 256) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z4 = z;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                if ((i2 & 256) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function02 = function0;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            z4 = z;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i2 & 256) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function02 = function0;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z4 = z;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i2 & 256) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f4  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TooltipBox API that contains onDismissRequest and hasAction params.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TooltipBox(final PopupPositionProvider popupPositionProvider, final Function3 function3, final TooltipState tooltipState, Modifier modifier, boolean z, boolean z2, final Function2 function2, Composer composer, final int i, final int i2) {
        PopupPositionProvider popupPositionProvider2;
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        Function2 function22;
        final Modifier modifier3;
        final boolean z5;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-375963176);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipBox)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)118@5365L302:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            popupPositionProvider2 = popupPositionProvider;
        } else if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i3 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            z4 = z2;
                            i3 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                        }
                        if ((i2 & 64) == 0) {
                            if ((i & 1572864) == 0) {
                                function22 = function2;
                                i3 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z5 = z3;
                                z6 = z4;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                z5 = i5 != 0 ? true : z3;
                                Modifier modifier4 = modifier2;
                                z6 = i6 != 0 ? true : z4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-375963176, i3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:118)");
                                }
                                int i7 = i3 << 3;
                                TooltipBox(popupPositionProvider2, function3, tooltipState, modifier4, null, z5, z6, false, function22, composerStartRestartGroup, (i3 & 14) | 12607488 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i7) | (i7 & 3670016) | ((i3 << 6) & 234881024), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TooltipKt.TooltipBox$lambda$0(popupPositionProvider, function3, tooltipState, modifier3, z5, z6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 1572864;
                        function22 = function2;
                        if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z4 = z2;
                    if ((i2 & 64) == 0) {
                    }
                    function22 = function2;
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                z4 = z2;
                if ((i2 & 64) == 0) {
                }
                function22 = function2;
                if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            z4 = z2;
            if ((i2 & 64) == 0) {
            }
            function22 = function2;
            if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        z4 = z2;
        if ((i2 & 64) == 0) {
        }
        function22 = function2;
        if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit TooltipBox$lambda$0(PopupPositionProvider popupPositionProvider, Function3 function3, TooltipState tooltipState, Modifier modifier, boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        TooltipBox(popupPositionProvider, function3, tooltipState, modifier, z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TooltipBox$lambda$1(PopupPositionProvider popupPositionProvider, Function3 function3, TooltipState tooltipState, Modifier modifier, Function0 function0, boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        TooltipBox(popupPositionProvider, function3, tooltipState, modifier, function0, z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final LayoutCoordinates TooltipBox$lambda$4$lambda$3(MutableState mutableState) {
        return (LayoutCoordinates) mutableState.getValue();
    }

    static final Unit TooltipBox$lambda$5(PopupPositionProvider popupPositionProvider, Function3 function3, TooltipState tooltipState, Modifier modifier, Function0 function0, boolean z, boolean z2, boolean z3, Function2 function2, int i, int i2, Composer composer, int i3) {
        TooltipBox(popupPositionProvider, function3, tooltipState, modifier, function0, z, z2, z3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final TooltipState TooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(z, z2, mutatorMutex);
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final Modifier animateTooltip(Modifier modifier, final Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("animateTooltip");
                inspectorInfo.getProperties().set("transition", transition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TooltipKt.animateTooltip.2
            private static final float invoke$lambda$1(State<Float> state) {
                return state.getValue().floatValue();
            }

            private static final float invoke$lambda$3(State<Float> state) {
                return state.getValue().floatValue();
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-1498516085);
                ComposerKt.sourceInformation(composer, "C1268@51666L14,1269@51753L14,1271@51812L197,1279@52055L193:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498516085, i, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:1268)");
                }
                final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6);
                final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
                Transition<Boolean> transition2 = transition;
                Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i2) {
                        composer2.startReplaceGroup(386845748);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(386845748, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:1272)");
                        }
                        FiniteAnimationSpec<Float> finiteAnimationSpec = finiteAnimationSpecValue;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return finiteAnimationSpec;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                boolean zBooleanValue = transition2.getCurrentState().booleanValue();
                composer.startReplaceGroup(-1553362193);
                ComposerKt.sourceInformation(composer, "CN(it):Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:1275)");
                }
                float f = zBooleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf = Float.valueOf(f);
                boolean zBooleanValue2 = transition2.getTargetState().booleanValue();
                composer.startReplaceGroup(-1553362193);
                ComposerKt.sourceInformation(composer, "CN(it):Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:1275)");
                }
                float f2 = zBooleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, fValueOf, Float.valueOf(f2), function3.invoke(transition2.getSegment(), composer, 0), vectorConverter, "tooltip transition: scaling", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Transition<Boolean> transition3 = transition;
                Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function32 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i2) {
                        composer2.startReplaceGroup(-281714272);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-281714272, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:1280)");
                        }
                        FiniteAnimationSpec<Float> finiteAnimationSpec = finiteAnimationSpecValue2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return finiteAnimationSpec;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                boolean zBooleanValue3 = transition3.getCurrentState().booleanValue();
                composer.startReplaceGroup(2073045083);
                ComposerKt.sourceInformation(composer, "CN(it):Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:1283)");
                }
                float f3 = zBooleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf2 = Float.valueOf(f3);
                boolean zBooleanValue4 = transition3.getTargetState().booleanValue();
                composer.startReplaceGroup(2073045083);
                ComposerKt.sourceInformation(composer, "CN(it):Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:1283)");
                }
                float f4 = zBooleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition3, fValueOf2, Float.valueOf(f4), function32.invoke(transition3.getSegment(), composer, 0), vectorConverter2, "tooltip transition: alpha", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierM6487graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m6487graphicsLayerAp8cVGQ(modifier2, (131064 & 1) != 0 ? 1.0f : invoke$lambda$1(stateCreateTransitionAnimation), (131064 & 2) != 0 ? 1.0f : invoke$lambda$1(stateCreateTransitionAnimation), (131064 & 4) == 0 ? invoke$lambda$3(stateCreateTransitionAnimation2) : 1.0f, (131064 & 8) != 0 ? 0.0f : 0.0f, (131064 & 16) != 0 ? 0.0f : 0.0f, (131064 & 32) != 0 ? 0.0f : 0.0f, (131064 & 64) != 0 ? 0.0f : 0.0f, (131064 & 128) != 0 ? 0.0f : 0.0f, (131064 & 256) == 0 ? 0.0f : 0.0f, (131064 & 512) != 0 ? 8.0f : 0.0f, (131064 & 1024) != 0 ? TransformOrigin.INSTANCE.m6738getCenterSzJe1aQ() : 0L, (131064 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131064 & 4096) != 0 ? false : false, (131064 & 8192) != 0 ? null : null, (131064 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 131064) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131064 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6414getAutoNrFUSI() : 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM6487graphicsLayerAp8cVGQ;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }
        });
    }

    public static final float caretX(float f, int i, Rect rect) {
        float fMin;
        float left = rect.getLeft();
        float right = rect.getRight();
        float f2 = (left + right) / 2.0f;
        float f3 = i;
        if (f >= f3) {
            return f2;
        }
        float f4 = f / 2.0f;
        if (f2 - f4 < 0.0f) {
            fMin = Math.max(f - f3, -left);
        } else {
            if (f2 + f4 <= f3) {
                return f4;
            }
            fMin = Math.min(f - right, 0.0f);
        }
        return f2 + fMin;
    }

    public static final float getActionLabelBottomPadding() {
        return ActionLabelBottomPadding;
    }

    public static final float getActionLabelMinHeight() {
        return ActionLabelMinHeight;
    }

    public static final float getHeightToSubheadFirstLine() {
        return HeightToSubheadFirstLine;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    /* JADX INFO: renamed from: layoutCaret-J5j9r9c, reason: not valid java name */
    private static final Modifier m4474layoutCaretJ5j9r9c(Modifier modifier, final MutableState<Matrix> mutableState, final Density density, final long j, final Function1<? super MeasureScope, ? extends LayoutCoordinates> function1, final PopupPositionProvider popupPositionProvider) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TooltipKt.layoutCaret_J5j9r9c$lambda$22(j, function1, density, popupPositionProvider, mutableState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x015b, code lost:
    
        r7 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf A[PHI: r24 r25
      0x00cf: PHI (r24v2 float) = (r24v1 float), (r24v4 float), (r24v4 float), (r24v4 float) binds: [B:30:0x00cd, B:26:0x00bd, B:23:0x00b5, B:18:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r25v1 char) = (r25v0 char), (r25v3 char), (r25v3 char), (r25v3 char) binds: [B:30:0x00cd, B:26:0x00bd, B:23:0x00b5, B:18:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final MeasureResult layoutCaret_J5j9r9c$lambda$22(long j, Function1 function1, Density density, PopupPositionProvider popupPositionProvider, MutableState mutableState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        char c;
        float f;
        long jM6072constructorimpl;
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        int width = placeableMo7769measureBRTryo0.getWidth();
        int height = placeableMo7769measureBRTryo0.getHeight();
        int i = (int) (j >> 32);
        int i2 = (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        float f2 = width;
        float f3 = height;
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function1.invoke(measureScope);
        if (layoutCoordinates != null) {
            int iMo1618roundToPx0680j_4 = density.mo1618roundToPx0680j_4(SpacingBetweenTooltipAndAnchor);
            Rect rectBoundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates, true);
            float top = rectBoundsInWindow.getTop();
            float bottom = rectBoundsInWindow.getBottom();
            float right = rectBoundsInWindow.getRight();
            float left = rectBoundsInWindow.getLeft();
            boolean z = popupPositionProvider instanceof TooltipPositionProviderImpl;
            if (z) {
                f = 0.0f;
                int type = ((TooltipPositionProviderImpl) popupPositionProvider).getType();
                c = ' ';
                if (TooltipAnchorPosition.m4450equalsimpl0(type, TooltipAnchorPosition.INSTANCE.m4457getLeftlOKsHw4()) || TooltipAnchorPosition.m4450equalsimpl0(type, TooltipAnchorPosition.INSTANCE.m4458getRightlOKsHw4()) || TooltipAnchorPosition.m4450equalsimpl0(type, TooltipAnchorPosition.INSTANCE.m4459getStartlOKsHw4()) || TooltipAnchorPosition.m4450equalsimpl0(type, TooltipAnchorPosition.INSTANCE.m4456getEndlOKsHw4())) {
                    f3 /= 2.0f;
                } else if (!TooltipAnchorPosition.m4450equalsimpl0(type, TooltipAnchorPosition.INSTANCE.m4454getAbovelOKsHw4()) ? !(!TooltipAnchorPosition.m4450equalsimpl0(type, TooltipAnchorPosition.INSTANCE.m4455getBelowlOKsHw4()) ? (top - f3) - iMo1618roundToPx0680j_4 >= 0.0f : bottom + f3 + iMo1618roundToPx0680j_4 > i2) : (top - f3) - iMo1618roundToPx0680j_4 < 0.0f) {
                    f3 = f;
                }
                if (z) {
                    jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(caretX(f2, i, rectBoundsInWindow))) << c) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                } else {
                    int type2 = ((TooltipPositionProviderImpl) popupPositionProvider).getType();
                    if (TooltipAnchorPosition.m4450equalsimpl0(type2, TooltipAnchorPosition.INSTANCE.m4457getLeftlOKsHw4())) {
                        jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((left - ((float) iMo1618roundToPx0680j_4)) - f2 < f ? f : f2)) << c) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    } else if (TooltipAnchorPosition.m4450equalsimpl0(type2, TooltipAnchorPosition.INSTANCE.m4458getRightlOKsHw4())) {
                        jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((right + ((float) iMo1618roundToPx0680j_4)) + f2 > ((float) i) ? f2 : f)) << c) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    } else if (TooltipAnchorPosition.m4450equalsimpl0(type2, TooltipAnchorPosition.INSTANCE.m4459getStartlOKsHw4())) {
                        float f4 = measureScope.getLayoutDirection() == LayoutDirection.Ltr ? f : f;
                        jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f4)) << c) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    } else if (TooltipAnchorPosition.m4450equalsimpl0(type2, TooltipAnchorPosition.INSTANCE.m4456getEndlOKsHw4())) {
                        jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((measureScope.getLayoutDirection() != LayoutDirection.Ltr ? (left - ((float) iMo1618roundToPx0680j_4)) - f2 >= f : (right + ((float) iMo1618roundToPx0680j_4)) + f2 > ((float) i)) ? f2 : f)) << c) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    } else {
                        jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(caretX(f2, i, rectBoundsInWindow))) << c) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    }
                }
                float[] fArrM6569constructorimpl$default = Matrix.m6569constructorimpl$default(null, 1, null);
                Matrix.m6591translateimpl$default(fArrM6569constructorimpl$default, Float.intBitsToFloat((int) (jM6072constructorimpl >> c)), Float.intBitsToFloat((int) (jM6072constructorimpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, 4, null);
                if (!z) {
                    int type3 = ((TooltipPositionProviderImpl) popupPositionProvider).getType();
                    if (TooltipAnchorPosition.m4450equalsimpl0(type3, TooltipAnchorPosition.INSTANCE.m4457getLeftlOKsHw4())) {
                        if ((left - iMo1618roundToPx0680j_4) - f2 < f) {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, 90.0f);
                        } else {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, -90.0f);
                        }
                    } else if (TooltipAnchorPosition.m4450equalsimpl0(type3, TooltipAnchorPosition.INSTANCE.m4458getRightlOKsHw4())) {
                        if (right + iMo1618roundToPx0680j_4 + f2 > i) {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, -90.0f);
                        } else {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, 90.0f);
                        }
                    } else if (TooltipAnchorPosition.m4450equalsimpl0(type3, TooltipAnchorPosition.INSTANCE.m4459getStartlOKsHw4())) {
                        if (measureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                            if ((left - iMo1618roundToPx0680j_4) - f2 < f) {
                                Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, 90.0f);
                            } else {
                                Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, -90.0f);
                            }
                        } else if (right + iMo1618roundToPx0680j_4 + f2 > i) {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, -90.0f);
                        } else {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, 90.0f);
                        }
                    } else if (TooltipAnchorPosition.m4450equalsimpl0(type3, TooltipAnchorPosition.INSTANCE.m4456getEndlOKsHw4())) {
                        if (measureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                            if (right + iMo1618roundToPx0680j_4 + f2 > i) {
                                Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, -90.0f);
                            } else {
                                Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, 90.0f);
                            }
                        } else if ((left - iMo1618roundToPx0680j_4) - f2 < f) {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, 90.0f);
                        } else {
                            Matrix.m6583rotateZimpl(fArrM6569constructorimpl$default, -90.0f);
                        }
                    } else if (f3 == f) {
                        Matrix.m6581rotateXimpl(fArrM6569constructorimpl$default, 180.0f);
                    }
                } else if (f3 == f) {
                    Matrix.m6581rotateXimpl(fArrM6569constructorimpl$default, 180.0f);
                }
                mutableState.setValue(Matrix.m6567boximpl(fArrM6569constructorimpl$default));
            } else {
                c = ' ';
                f = 0.0f;
                if ((top - f3) - iMo1618roundToPx0680j_4 < 0.0f) {
                }
                if (z) {
                }
                float[] fArrM6569constructorimpl$default2 = Matrix.m6569constructorimpl$default(null, 1, null);
                Matrix.m6591translateimpl$default(fArrM6569constructorimpl$default2, Float.intBitsToFloat((int) (jM6072constructorimpl >> c)), Float.intBitsToFloat((int) (jM6072constructorimpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, 4, null);
                if (!z) {
                }
                mutableState.setValue(Matrix.m6567boximpl(fArrM6569constructorimpl$default2));
            }
        }
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TooltipKt.layoutCaret_J5j9r9c$lambda$22$lambda$21(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit layoutCaret_J5j9r9c$lambda$22$lambda$21(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final TooltipState rememberTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1413230530, "C(rememberTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)962@39859L211:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, i, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:962)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -904866095, "CC(remember):Tooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(mutatorMutex)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new TooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(objRememberedValue);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipStateImpl;
    }

    public static final Modifier textVerticalPadding(Modifier modifier, boolean z, boolean z2) {
        return (z || z2) ? PaddingKt.m2041paddingqDBjuR0$default(AlignmentLineKt.m1882paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null) : PaddingKt.m2039paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, null);
    }
}
