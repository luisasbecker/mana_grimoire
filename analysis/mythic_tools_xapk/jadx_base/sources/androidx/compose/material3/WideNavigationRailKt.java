package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.WideNavigationRailKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001am\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u0017\u001a\u009d\u0001\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b \u0010!\u001a\u0089\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\b\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u0010/\u001aÖ\u0001\u00100\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0006\u00106\u001a\u00020721\u00108\u001a-\b\u0001\u0012\u0013\u0012\u001104¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u001d2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\bC\u0010D\u001a\u001c\u0010E\u001a\u000204*\u00020F2\u0006\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020\u0015H\u0002\u001a\u0014\u0010I\u001a\u000204*\u00020F2\u0006\u0010G\u001a\u000204H\u0002\u001a=\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\u001c\u0010M\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>0N2\u0006\u0010O\u001a\u00020\u0015H\u0003¢\u0006\u0004\bP\u0010Q\"\u0016\u0010R\u001a\u00020\u001dX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T\"\u0010\u0010V\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010W\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010X\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Y\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Z\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010[\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010\\\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010]\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010^\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010_\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010`\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010a\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u000e\u0010b\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020dX\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020g0fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i\"\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020k0fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010i¨\u0006m²\u0006\n\u0010n\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010r\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010s\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010u\u001a\u000204X\u008a\u0084\u0002²\u0006\n\u0010v\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"WideNavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/WideNavigationRailState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", WideNavigationRailKt.HeaderLayoutIdTag, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WideNavigationRailLayout", "isModal", "", "expanded", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ModalWideNavigationRail", "hideOnCollapse", "collapsedShape", "expandedShape", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRail-k3FuEkE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem", "selected", "onClick", "icon", Constants.ScionAnalytics.PARAM_LABEL, "railExpanded", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "WideNavigationRailItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ModalWideNavigationRailContent", "isStandaloneModal", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "settleToDismiss", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "railState", "Landroidx/compose/material3/ModalWideNavigationRailState;", "openModalRailMaxWidth", "gesturesEnabled", "ModalWideNavigationRailContent-pU6N4AM", "(ZZLandroidx/compose/animation/core/Animatable;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ModalWideNavigationRailState;Landroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "swipeEdgeMatchesRail", "calculatePredictiveBackScaleY", "Scrim", "color", "Landroidx/compose/ui/graphics/Color;", "onDismissRequest", "Lkotlin/Function1;", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "WNRItemNoLabelIndicatorPadding", "getWNRItemNoLabelIndicatorPadding", "()F", "F", "ItemHorizontalPadding", "WNRVerticalPadding", "WNRHeaderPadding", "CollapsedRailWidth", "ExpandedRailMinWidth", "ExpandedRailMaxWidth", "TopIconItemMinHeight", "ItemTopIconIndicatorVerticalPadding", "ItemTopIconIndicatorHorizontalPadding", "ItemStartIconIndicatorVerticalPadding", "PredictiveBackMaxScaleXDistance", "PredictiveBackMaxScaleYDistance", "PredictiveBackPivotFractionY", "HeaderLayoutIdTag", "", "LocalWideNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/WideNavigationRailOverride;", "getLocalWideNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalModalWideNavigationRailOverride", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "getLocalModalWideNavigationRailOverride", "material3", "currentWidth", "", "actualMaxExpandedWidth", "minWidth", "widthFullRange", "itemVerticalSpacedBy", "itemMinHeight", "alpha", "dismiss"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt {
    private static final String HeaderLayoutIdTag = "header";
    private static final float PredictiveBackPivotFractionY = 0.5f;
    private static final float WNRItemNoLabelIndicatorPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemHorizontalPadding = Dp.m9114constructorimpl(20.0f);
    private static final float WNRVerticalPadding = NavigationRailCollapsedTokens.INSTANCE.m5151getTopSpaceD9Ej5fM();
    private static final float WNRHeaderPadding = NavigationRailBaselineItemTokens.INSTANCE.m5145getHeaderSpaceMinimumD9Ej5fM();
    private static final float CollapsedRailWidth = NavigationRailCollapsedTokens.INSTANCE.m5148getContainerWidthD9Ej5fM();
    private static final float ExpandedRailMinWidth = NavigationRailExpandedTokens.INSTANCE.m5154getContainerWidthMinimumD9Ej5fM();
    private static final float ExpandedRailMaxWidth = NavigationRailExpandedTokens.INSTANCE.m5153getContainerWidthMaximumD9Ej5fM();
    private static final float TopIconItemMinHeight = NavigationRailBaselineItemTokens.INSTANCE.m5143getContainerHeightD9Ej5fM();
    private static final float ItemTopIconIndicatorVerticalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5162getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemTopIconIndicatorHorizontalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemStartIconIndicatorVerticalPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(NavigationRailHorizontalItemTokens.INSTANCE.m5157getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5146getIconSizeD9Ej5fM()) / 2.0f);
    private static final float PredictiveBackMaxScaleXDistance = Dp.m9114constructorimpl(24.0f);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m9114constructorimpl(48.0f);
    private static final ProvidableCompositionLocal<WideNavigationRailOverride> LocalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultWideNavigationRailOverride.INSTANCE;
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> LocalModalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultModalWideNavigationRailOverride.INSTANCE;
        }
    }, 1, null);

    /* JADX INFO: renamed from: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: WideNavigationRail.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
        final /* synthetic */ Arrangement.Vertical $arrangement;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ MutableIntState $currentWidth$delegate;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Function2<Composer, Integer, Unit> $header;
        final /* synthetic */ State<Dp> $itemMinHeight$delegate;
        final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
        final /* synthetic */ State<Dp> $minWidth$delegate;
        final /* synthetic */ float $minimumA11ySize;
        final /* synthetic */ State<Dp> $widthFullRange$delegate;
        final /* synthetic */ WindowInsets $windowInsets;

        /* JADX INFO: renamed from: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WideNavigationRail.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/material3/WideNavigationRailKt$WideNavigationRailLayout$1$2", "Landroidx/compose/ui/layout/MeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass2 implements MeasurePolicy {
            final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
            final /* synthetic */ Arrangement.Vertical $arrangement;
            final /* synthetic */ MutableIntState $currentWidth$delegate;
            final /* synthetic */ boolean $expanded;
            final /* synthetic */ Function2<Composer, Integer, Unit> $header;
            final /* synthetic */ State<Dp> $itemMinHeight$delegate;
            final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
            final /* synthetic */ State<Dp> $minWidth$delegate;
            final /* synthetic */ float $minimumA11ySize;
            final /* synthetic */ State<Dp> $widthFullRange$delegate;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function2<? super Composer, ? super Integer, Unit> function2, boolean z, State<Dp> state, float f, State<Dp> state2, State<Dp> state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State<Dp> state4) {
                this.$header = function2;
                this.$expanded = z;
                this.$minWidth$delegate = state;
                this.$minimumA11ySize = f;
                this.$itemMinHeight$delegate = state2;
                this.$widthFullRange$delegate = state3;
                this.$actualMaxExpandedWidth$delegate = mutableIntState;
                this.$currentWidth$delegate = mutableIntState2;
                this.$arrangement = vertical;
                this.$itemVerticalSpacedBy$delegate = state4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            static final Unit measure_3p2s80s$lambda$6(int i, MeasureScope measureScope, Ref.ObjectRef objectRef, List list, Arrangement.Vertical vertical, State state, Placeable.PlacementScope placementScope) {
                int height;
                int i2 = i - measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WNRVerticalPadding);
                if (objectRef.element == 0 || ((Placeable) objectRef.element).getHeight() <= 0) {
                    height = 0;
                } else {
                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) objectRef.element, 0, 0, 0.0f, 4, null);
                    height = ((Placeable) objectRef.element).getHeight() + measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WNRHeaderPadding);
                }
                if (list != null) {
                    if (!Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                        i2 -= height;
                    }
                    int[] iArr = new int[list.size()];
                    List list2 = list;
                    int size = list2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        iArr[i3] = ((Placeable) list.get(i3)).getHeight();
                        if (i3 < list.size() - 1) {
                            iArr[i3] = iArr[i3] + measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$10(state));
                        }
                    }
                    int[] iArr2 = new int[list.size()];
                    vertical.arrange(measureScope, i2, iArr, iArr2);
                    if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                        height = 0;
                    }
                    int size2 = list2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i4), 0, iArr2[i4] + height, 0.0f, 4, null);
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v8, types: [T, androidx.compose.ui.layout.Placeable] */
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo1260measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
                int iM9069getMinWidthimpl;
                int height;
                int i;
                int i2;
                int i3;
                int i4;
                int iCoerceIn;
                int i5;
                List<? extends Measurable> listSubList = list;
                int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(j);
                int size = listSubList.size();
                int iM9069getMinWidthimpl2 = Constraints.m9069getMinWidthimpl(j);
                if (Constraints.m9069getMinWidthimpl(j) == 0) {
                    iM9069getMinWidthimpl2 = RangesKt.coerceAtMost(measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.ExpandedRailMinWidth), Constraints.m9067getMaxWidthimpl(j));
                    iM9069getMinWidthimpl = RangesKt.coerceAtMost(measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$8(this.$minWidth$delegate)), Constraints.m9067getMaxWidthimpl(j));
                } else {
                    iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(j);
                }
                if (size < 1) {
                    return MeasureScope.layout$default(measureScope, iM9069getMinWidthimpl, iM9066getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
                long jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                if (this.$header != null) {
                    int size2 = listSubList.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        Measurable measurable = listSubList.get(i6);
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), WideNavigationRailKt.HeaderLayoutIdTag)) {
                            objectRef.element = measurable.mo7769measureBRTryo0(jM9057copyZbe2FdA$default);
                            if (size > 1) {
                                listSubList = listSubList.subList(1, size);
                            }
                            size--;
                            height = ((Placeable) objectRef.element).getHeight();
                        }
                    }
                    ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                    throw new KotlinNothingValueException();
                }
                height = 0;
                final ArrayList arrayList = size > 0 ? new ArrayList() : null;
                int iM9067getMaxWidthimpl = this.$expanded ? Constraints.m9067getMaxWidthimpl(jM9057copyZbe2FdA$default) : iM9069getMinWidthimpl;
                if (arrayList != null) {
                    float f = this.$minimumA11ySize;
                    boolean z = this.$expanded;
                    State<Dp> state = this.$itemMinHeight$delegate;
                    int i7 = height;
                    ArrayList arrayList2 = new ArrayList(listSubList.size());
                    int size3 = listSubList.size();
                    i3 = iM9066getMaxHeightimpl;
                    int i8 = 0;
                    i4 = 0;
                    int height2 = i7;
                    while (i8 < size3) {
                        Measurable measurable2 = listSubList.get(i8);
                        List<? extends Measurable> list2 = listSubList;
                        ArrayList arrayList3 = arrayList2;
                        int i9 = size3;
                        int i10 = -height2;
                        boolean z2 = z;
                        State<Dp> state2 = state;
                        int i11 = i8;
                        float f2 = f;
                        ArrayList arrayList4 = arrayList2;
                        int i12 = iM9069getMinWidthimpl2;
                        int i13 = iM9069getMinWidthimpl;
                        Placeable placeableMo7769measureBRTryo0 = measurable2.mo7769measureBRTryo0(ConstraintsKt.m9082constrainN9IONVI(ConstraintsKt.m9087offsetNN6EwU$default(jM9057copyZbe2FdA$default, 0, i10, 1, null), Constraints.INSTANCE.m9076fitPrioritizingWidthZbe2FdA(measureScope.mo1618roundToPx0680j_4(f), iM9067getMaxWidthimpl, measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$11(state2)), Constraints.m9066getMaxHeightimpl(jM9057copyZbe2FdA$default))));
                        int measuredWidth = placeableMo7769measureBRTryo0.getMeasuredWidth();
                        if (z2 && i4 < measuredWidth) {
                            i4 = measuredWidth + measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.ItemHorizontalPadding);
                        }
                        height2 = placeableMo7769measureBRTryo0.getHeight();
                        arrayList3.add(Boolean.valueOf(arrayList.add(placeableMo7769measureBRTryo0)));
                        i8 = i11 + 1;
                        listSubList = list2;
                        z = z2;
                        f = f2;
                        arrayList2 = arrayList4;
                        size3 = i9;
                        state = state2;
                        iM9069getMinWidthimpl2 = i12;
                        iM9069getMinWidthimpl = i13;
                    }
                    i = iM9069getMinWidthimpl2;
                    i2 = iM9069getMinWidthimpl;
                } else {
                    i = iM9069getMinWidthimpl2;
                    i2 = iM9069getMinWidthimpl;
                    i3 = iM9066getMaxHeightimpl;
                    i4 = 0;
                }
                if (this.$expanded) {
                    Placeable placeable = (Placeable) objectRef.element;
                    int iMax = Math.max(i4, placeable != null ? placeable.getWidth() : 0);
                    iCoerceIn = i2;
                    if (iMax > iCoerceIn && iMax > (i5 = i)) {
                        iCoerceIn = RangesKt.coerceAtMost(measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$9(this.$widthFullRange$delegate)), RangesKt.coerceAtMost(Math.max(iMax, i5), Constraints.m9067getMaxWidthimpl(j)));
                        WideNavigationRailKt.WideNavigationRailLayout$lambda$7(this.$actualMaxExpandedWidth$delegate, iCoerceIn);
                    }
                } else {
                    iCoerceIn = i2;
                    if (WideNavigationRailKt.WideNavigationRailLayout$lambda$6(this.$actualMaxExpandedWidth$delegate) > 0) {
                        iCoerceIn = RangesKt.coerceIn(measureScope.mo1618roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$9(this.$widthFullRange$delegate)), iCoerceIn, RangesKt.coerceAtLeast(WideNavigationRailKt.WideNavigationRailLayout$lambda$3(this.$currentWidth$delegate), iCoerceIn));
                    }
                }
                int i14 = iCoerceIn;
                WideNavigationRailKt.WideNavigationRailLayout$lambda$4(this.$currentWidth$delegate, i14);
                final Arrangement.Vertical vertical = this.$arrangement;
                final State<Dp> state3 = this.$itemVerticalSpacedBy$delegate;
                final int i15 = i3;
                return MeasureScope.layout$default(measureScope, i14, i15, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.AnonymousClass1.AnonymousClass2.measure_3p2s80s$lambda$6(i15, measureScope, objectRef, arrayList, vertical, state3, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, State<Dp> state, float f, State<Dp> state2, State<Dp> state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State<Dp> state4, Function2<? super Composer, ? super Integer, Unit> function22) {
            this.$windowInsets = windowInsets;
            this.$header = function2;
            this.$expanded = z;
            this.$minWidth$delegate = state;
            this.$minimumA11ySize = f;
            this.$itemMinHeight$delegate = state2;
            this.$widthFullRange$delegate = state3;
            this.$actualMaxExpandedWidth$delegate = mutableIntState;
            this.$currentWidth$delegate = mutableIntState2;
            this.$arrangement = vertical;
            this.$itemVerticalSpacedBy$delegate = state4;
            this.$content = function22;
        }

        static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C265@11877L27,258@11568L8803:WideNavigationRail.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1489314345, i, -1, "androidx.compose.material3.WideNavigationRailLayout.<anonymous> (WideNavigationRail.kt:258)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m2041paddingqDBjuR0$default(SizeKt.m2090widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), this.$windowInsets), 0.0f, WideNavigationRailKt.ExpandedRailMaxWidth, 1, null), 0.0f, WideNavigationRailKt.WNRVerticalPadding, 0.0f, 0.0f, 13, null));
            ComposerKt.sourceInformationMarkerStart(composer, -1006965742, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.AnonymousClass1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierSelectableGroup, false, (Function1) objRememberedValue, 1, null);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$header, this.$expanded, this.$minWidth$delegate, this.$minimumA11ySize, this.$itemMinHeight$delegate, this.$widthFullRange$delegate, this.$actualMaxExpandedWidth$delegate, this.$currentWidth$delegate, this.$arrangement, this.$itemVerticalSpacedBy$delegate);
            Function2<Composer, Integer, Unit> function2 = this.$header;
            Function2<Composer, Integer, Unit> function22 = this.$content;
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, anonymousClass2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1714873591, "C270@12077L9:WideNavigationRail.kt#uh7d8r");
            if (function2 != null) {
                composer.startReplaceGroup(1714892004);
                ComposerKt.sourceInformation(composer, "268@11988L54");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, WideNavigationRailKt.HeaderLayoutIdTag);
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 310577628, "C268@12032L8:WideNavigationRail.kt#uh7d8r");
                function2.invoke(composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1714982338);
                composer.endReplaceGroup();
            }
            function22.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX INFO: renamed from: ModalWideNavigationRail-k3FuEkE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4527ModalWideNavigationRailk3FuEkE(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape3;
        Shape shape4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        final WindowInsets windowInsets2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Modifier modifier3;
        final float f3;
        final boolean z3;
        final Shape shape5;
        final Shape shape6;
        final WideNavigationRailState wideNavigationRailState2;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Arrangement.Vertical vertical2;
        final ModalWideNavigationRailProperties modalWideNavigationRailProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState;
        Shape modalCollapsedShape;
        Shape modalExpandedShape;
        WideNavigationRailColors wideNavigationRailColorsColors;
        WindowInsets windowInsets3;
        Arrangement.Vertical arrangement;
        ModalWideNavigationRailProperties modalExpandedProperties;
        Modifier modifier4;
        Shape shape7;
        WideNavigationRailState wideNavigationRailState3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        float f4;
        WindowInsets windowInsets4;
        Arrangement.Vertical vertical3;
        boolean z4;
        Shape shape8;
        WideNavigationRailColors wideNavigationRailColors3;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-38559147);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRail)N(modifier,state,hideOnCollapse,collapsedShape,expandedShape,colors,header,expandedHeaderTopPadding:c#ui.unit.Dp,windowInsets,arrangement,expandedProperties,content)493@24484L7,*493@24501L25:WideNavigationRail.kt#uh7d8r");
        int i12 = i3 & 1;
        if (i12 != 0) {
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
            if ((i3 & 2) != 0) {
                i11 = 16;
                i4 |= i11;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailState)) {
                    i11 = 32;
                }
                i4 |= i11;
            }
        }
        int i13 = i3 & 4;
        if (i13 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    shape3 = shape;
                    int i14 = composerStartRestartGroup.changed(shape3) ? 2048 : 1024;
                    i4 |= i14;
                } else {
                    shape3 = shape;
                }
                i4 |= i14;
            } else {
                shape3 = shape;
            }
            if ((i & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    shape4 = shape2;
                    int i15 = composerStartRestartGroup.changed(shape4) ? 16384 : 8192;
                    i4 |= i15;
                } else {
                    shape4 = shape2;
                }
                i4 |= i15;
            } else {
                shape4 = shape2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(wideNavigationRailColors)) ? 131072 : 65536;
            }
            i5 = i3 & 64;
            if (i5 == 0) {
                i4 |= 1572864;
                function23 = function2;
            } else {
                function23 = function2;
                if ((i & 1572864) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                }
            }
            i6 = i3 & 128;
            if (i6 == 0) {
                i4 |= 12582912;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 12582912) == 0) {
                    i4 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
            }
            if ((i & 100663296) == 0) {
                i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(windowInsets)) ? 67108864 : 33554432;
            }
            if ((i & 805306368) == 0) {
                i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(vertical)) ? 536870912 : 268435456;
            }
            i7 = i3 & 1024;
            if (i7 == 0) {
                i9 = i2 | 6;
                i8 = i7;
            } else if ((i2 & 6) == 0) {
                i8 = i7;
                i9 = i2 | (composerStartRestartGroup.changed(modalWideNavigationRailProperties) ? 4 : 2);
            } else {
                i8 = i7;
                i9 = i2;
            }
            if ((i3 & 2048) == 0) {
                i9 |= 48;
            } else if ((i2 & 48) == 0) {
                i9 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
            }
            i10 = i9;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                windowInsets2 = windowInsets;
                composer2 = composerStartRestartGroup;
                function24 = function23;
                modifier3 = modifier2;
                f3 = f2;
                z3 = z2;
                shape5 = shape3;
                shape6 = shape4;
                wideNavigationRailState2 = wideNavigationRailState;
                wideNavigationRailColors2 = wideNavigationRailColors;
                vertical2 = vertical;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "465@23180L33,467@23307L19,468@23382L18,469@23468L8,472@23625L12");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i13 != 0) {
                        z2 = false;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        modalCollapsedShape = shape3;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape4;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors;
                    }
                    if (i5 != 0) {
                        function23 = null;
                    }
                    float fM9114constructorimpl = i6 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i8 != 0) {
                        modifier4 = companion;
                        shape7 = modalCollapsedShape;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        function25 = function23;
                        f4 = fM9114constructorimpl;
                        windowInsets4 = windowInsets3;
                        vertical3 = arrangement;
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                        modifier4 = companion;
                        shape7 = modalCollapsedShape;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        function25 = function23;
                        f4 = fM9114constructorimpl;
                        windowInsets4 = windowInsets3;
                        vertical3 = arrangement;
                    }
                    z4 = z2;
                    shape8 = modalExpandedShape;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 256) != 0) {
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    wideNavigationRailState3 = wideNavigationRailState;
                    wideNavigationRailColors3 = wideNavigationRailColors;
                    windowInsets4 = windowInsets;
                    vertical3 = vertical;
                    modalExpandedProperties = modalWideNavigationRailProperties;
                    function25 = function23;
                    modifier4 = modifier2;
                    f4 = f2;
                    z4 = z2;
                    shape7 = shape3;
                    shape8 = shape4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-38559147, i4, i10, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:477)");
                }
                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope = new ModalWideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, z4, shape7, shape8, wideNavigationRailColors3, function25, f4, windowInsets4, vertical3, modalExpandedProperties, function22, null);
                ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal = LocalModalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((ModalWideNavigationRailOverride) objConsume).ModalWideNavigationRail(modalWideNavigationRailOverrideScope, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                wideNavigationRailState2 = wideNavigationRailState3;
                z3 = z4;
                shape5 = shape7;
                shape6 = shape8;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function24 = function25;
                f3 = f4;
                windowInsets2 = windowInsets4;
                vertical2 = vertical3;
                modalWideNavigationRailProperties2 = modalExpandedProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRail_k3FuEkE$lambda$14(modifier3, wideNavigationRailState2, z3, shape5, shape6, wideNavigationRailColors2, function24, f3, windowInsets2, vertical2, modalWideNavigationRailProperties2, function22, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 384;
        z2 = z;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i5 = i3 & 64;
        if (i5 == 0) {
        }
        i6 = i3 & 128;
        if (i6 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i7 = i3 & 1024;
        if (i7 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i10 = i9;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ModalWideNavigationRailContent-pU6N4AM, reason: not valid java name */
    public static final void m4528ModalWideNavigationRailContentpU6N4AM(final boolean z, final boolean z2, final Animatable<Float, AnimationVector1D> animatable, final RailPredictiveBackState railPredictiveBackState, final Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> function2, final Modifier modifier, final ModalWideNavigationRailState modalWideNavigationRailState, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, final WindowInsets windowInsets, final boolean z3, final Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        WideNavigationRailColors wideNavigationRailColors2;
        int i4;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1593438005);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRailContent)N(expanded,isStandaloneModal,predictiveBackProgress,predictiveBackState,settleToDismiss,modifier,railState,colors,shape,openModalRailMaxWidth:c#ui.unit.Dp,header,windowInsets,gesturesEnabled,arrangement,content)989@47315L7,990@47370L55,1000@47710L29,1001@47771L904,1020@48768L649,1041@49760L23,1043@49810L1311,992@47431L3690:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(railPredictiveBackState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(modalWideNavigationRailState) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i3 |= composerStartRestartGroup.changed(wideNavigationRailColors2) ? 8388608 : 4194304;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function22) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(windowInsets) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(vertical) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        int i5 = i4;
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 9363) == 9362) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1593438005, i3, i5, "androidx.compose.material3.ModalWideNavigationRailContent (WideNavigationRail.kt:988)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z4 = objConsume == LayoutDirection.Rtl;
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_wide_navigation_rail_pane_title), composerStartRestartGroup, 0);
            long modalContainerColor = wideNavigationRailColors2.getModalContainerColor();
            long modalContentColor = wideNavigationRailColors2.getModalContentColor();
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m2090widthInVpY3zN4$default(modifier, 0.0f, f, 1, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2009435560, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(strM4676getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierFillMaxHeight$default, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2009438387, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 896) == 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(animatable))) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState) | ((i3 & 7168) == 2048) | composerStartRestartGroup.changed(z4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(animatable, modalWideNavigationRailState, railPredictiveBackState, z4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierSemantics$default, (Function1) objRememberedValue2);
            AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState$material3 = modalWideNavigationRailState.getAnchoredDraggableState$material3();
            Orientation orientation = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2009470036, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged2 = ((i3 & 112) == 32) | composerStartRestartGroup.changed(z4) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(z2, z4, modalWideNavigationRailState, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(modifierGraphicsLayer, anchoredDraggableState$material3, orientation, (Function2) objRememberedValue3);
            DraggableState draggableState = modalWideNavigationRailState.getAnchoredDraggableState$material3().getDraggableState();
            Orientation orientation2 = Orientation.Horizontal;
            boolean zIsAnimationRunning = modalWideNavigationRailState.getAnchoredDraggableState$material3().isAnimationRunning();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2009501154, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(function2);
            WideNavigationRailKt$ModalWideNavigationRailContent$4$1 wideNavigationRailKt$ModalWideNavigationRailContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || wideNavigationRailKt$ModalWideNavigationRailContent$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                wideNavigationRailKt$ModalWideNavigationRailContent$4$1RememberedValue = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(function2, null);
                composerStartRestartGroup.updateRememberedValue(wideNavigationRailKt$ModalWideNavigationRailContent$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4145SurfaceT9BRK9s(DraggableKt.draggable$default(modifierDraggableAnchors, draggableState, orientation2, z3, null, zIsAnimationRunning, null, (Function3) wideNavigationRailKt$ModalWideNavigationRailContent$4$1RememberedValue, false, 168, null), shape, modalContainerColor, modalContentColor, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1043835354, true, new WideNavigationRailKt$ModalWideNavigationRailContent$5(animatable, railPredictiveBackState, z4, z, wideNavigationRailColors2, shape, function22, windowInsets, vertical, function23), composer2, 54), composer2, ((i3 >> 21) & 112) | 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$25(z, z2, animatable, railPredictiveBackState, function2, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function22, windowInsets, z3, vertical, function23, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(Animatable animatable, ModalWideNavigationRailState modalWideNavigationRailState, RailPredictiveBackState railPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (fFloatValue <= 0.0f) {
            return Unit.INSTANCE;
        }
        float currentOffset = modalWideNavigationRailState.getCurrentOffset();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (!Float.isNaN(currentOffset) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue, railPredictiveBackState.getSwipeEdgeMatchesRail()));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        }
        return Unit.INSTANCE;
    }

    static final Pair ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(boolean z, boolean z2, ModalWideNavigationRailState modalWideNavigationRailState, IntSize intSize, Constraints constraints) {
        final float fM9289unboximpl = (int) (intSize.m9289unboximpl() >> 32);
        final float f = 0.0f;
        if (!z) {
            fM9289unboximpl = 0.0f;
        } else if (!z2) {
            fM9289unboximpl = -fM9289unboximpl;
        }
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(fM9289unboximpl, f, (DraggableAnchorsConfig) obj);
            }
        }), modalWideNavigationRailState.getTargetValue());
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(WideNavigationRailValue.Collapsed, f);
        draggableAnchorsConfig.at(WideNavigationRailValue.Expanded, f2);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$25(boolean z, boolean z2, Animatable animatable, RailPredictiveBackState railPredictiveBackState, Function2 function2, Modifier modifier, ModalWideNavigationRailState modalWideNavigationRailState, WideNavigationRailColors wideNavigationRailColors, Shape shape, float f, Function2 function22, WindowInsets windowInsets, boolean z3, Arrangement.Vertical vertical, Function2 function23, int i, int i2, Composer composer, int i3) {
        m4528ModalWideNavigationRailContentpU6N4AM(z, z2, animatable, railPredictiveBackState, function2, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function22, windowInsets, z3, vertical, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail_k3FuEkE$lambda$14(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2 function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, Function2 function22, int i, int i2, int i3, Composer composer, int i4) {
        m4527ModalWideNavigationRailk3FuEkE(modifier, wideNavigationRailState, z, shape, shape2, wideNavigationRailColors, function2, f, windowInsets, vertical, modalWideNavigationRailProperties, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m4529Scrim3JVO9M(final long j, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(144695261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible):WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144695261, i2, -1, "androidx.compose.material3.Scrim (WideNavigationRail.kt:1102)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-1530482291);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1108@52256L7,1105@52025L253,1110@52302L34,1111@52366L28,1125@52948L79,1125@52894L133,1129@53061L35,1129@53037L59");
                int i3 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613206495, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Strings.Companion companion = Strings.INSTANCE;
                final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_wide_navigation_rail_close_rail), composerStartRestartGroup, 0);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1530047423);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1114@52509L40,1115@52606L219");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613213125, "CC(remember):WideNavigationRail.kt#9igjgp");
                    WideNavigationRailKt$Scrim$dismissModalRail$1$1 wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue = new WideNavigationRailKt$Scrim$dismissModalRail$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function1, (PointerInputEventHandler) wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613216408, "CC(remember):WideNavigationRail.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return WideNavigationRailKt.Scrim_3J_VO9M$lambda$33$lambda$32(strM4676getString2EP1pXo, mutableState, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1529667363);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613227212, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChanged2 = ((i3 & 14) == 4) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WideNavigationRailKt.Scrim_3J_VO9M$lambda$35$lambda$34(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                Boolean boolValueOf = Boolean.valueOf(Scrim_3J_VO9M$lambda$28(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613230784, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(function1);
                WideNavigationRailKt$Scrim$2$1 wideNavigationRailKt$Scrim$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || wideNavigationRailKt$Scrim$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    wideNavigationRailKt$Scrim$2$1RememberedValue = new WideNavigationRailKt$Scrim$2$1(function1, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(wideNavigationRailKt$Scrim$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) wideNavigationRailKt$Scrim$2$1RememberedValue, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1529413659);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.Scrim_3J_VO9M$lambda$37(j, function1, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float Scrim_3J_VO9M$lambda$26(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_3J_VO9M$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Scrim_3J_VO9M$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit Scrim_3J_VO9M$lambda$33$lambda$32(String str, final MutableState mutableState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(WideNavigationRailKt.Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(mutableState));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    static final boolean Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(MutableState mutableState) {
        Scrim_3J_VO9M$lambda$29(mutableState, true);
        return true;
    }

    static final Unit Scrim_3J_VO9M$lambda$35$lambda$34(long j, State state, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_3J_VO9M$lambda$26(state), 0.0f, 1.0f), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_3J_VO9M$lambda$37(long j, Function1 function1, boolean z, int i, Composer composer, int i2) {
        m4529Scrim3JVO9M(j, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WideNavigationRail(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        WideNavigationRailColors wideNavigationRailColorsColors;
        Function2<? super Composer, ? super Integer, Unit> function23;
        WindowInsets windowInsets2;
        Arrangement.Vertical vertical2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final WindowInsets windowInsets3;
        final Arrangement.Vertical vertical3;
        final WideNavigationRailState wideNavigationRailState2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState;
        WideNavigationRailState wideNavigationRailState3;
        Arrangement.Vertical arrangement;
        Shape shape4;
        WideNavigationRailColors wideNavigationRailColors3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        WindowInsets windowInsets4;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(164193188);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRail)N(modifier,state,shape,colors,header,windowInsets,arrangement,content)170@8485L7,*181@8852L20:WideNavigationRail.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
            if ((i2 & 2) != 0) {
                i4 = 16;
                i3 |= i4;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailState)) {
                    i4 = 32;
                }
                i3 |= i4;
            }
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                int i6 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                i3 |= i6;
            } else {
                shape2 = shape;
            }
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                wideNavigationRailColorsColors = wideNavigationRailColors;
                int i7 = composerStartRestartGroup.changed(wideNavigationRailColorsColors) ? 2048 : 1024;
                i3 |= i7;
            } else {
                wideNavigationRailColorsColors = wideNavigationRailColors;
            }
            i3 |= i7;
        } else {
            wideNavigationRailColorsColors = wideNavigationRailColors;
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                function23 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    int i9 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                    i3 |= i9;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    vertical2 = vertical;
                    int i10 = composerStartRestartGroup.changed(vertical2) ? 1048576 : 524288;
                    i3 |= i10;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i10;
            } else {
                vertical2 = vertical;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    function24 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                }
                if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "162@8039L33,163@8120L5,164@8193L8,166@8309L12");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                            i3 &= -113;
                        } else {
                            wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i8 != 0) {
                            function23 = null;
                        }
                        if ((i2 & 32) != 0) {
                            windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                            arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                            shape4 = shape2;
                            wideNavigationRailColors3 = wideNavigationRailColorsColors;
                            function26 = function23;
                            windowInsets4 = windowInsets2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:169)");
                            }
                            ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal = LocalWideNavigationRailOverride;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifier4 = companion;
                            ((WideNavigationRailOverride) objConsume).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function26, windowInsets4, arrangement, function24), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier4;
                            wideNavigationRailState2 = wideNavigationRailState3;
                            shape3 = shape4;
                            wideNavigationRailColors2 = wideNavigationRailColors3;
                            function25 = function26;
                            windowInsets3 = windowInsets4;
                            vertical3 = arrangement;
                        } else {
                            wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        wideNavigationRailState3 = wideNavigationRailState;
                        companion = modifier2;
                    }
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function26 = function23;
                    windowInsets4 = windowInsets2;
                    arrangement = vertical2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal2 = LocalWideNavigationRailOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier42 = companion;
                    ((WideNavigationRailOverride) objConsume2).WideNavigationRail(new WideNavigationRailOverrideScope(modifier42, wideNavigationRailState3, shape4, wideNavigationRailColors3, function26, windowInsets4, arrangement, function24), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier42;
                    wideNavigationRailState2 = wideNavigationRailState3;
                    shape3 = shape4;
                    wideNavigationRailColors2 = wideNavigationRailColors3;
                    function25 = function26;
                    windowInsets3 = windowInsets4;
                    vertical3 = arrangement;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    wideNavigationRailColors2 = wideNavigationRailColorsColors;
                    function25 = function23;
                    windowInsets3 = windowInsets2;
                    vertical3 = vertical2;
                    wideNavigationRailState2 = wideNavigationRailState;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function25, windowInsets3, vertical3, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 12582912;
            function24 = function22;
            if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function23 = function2;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        function24 = function22;
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit WideNavigationRail$lambda$1(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function22, int i, int i2, Composer composer, int i3) {
        WideNavigationRail(modifier, wideNavigationRailState, shape, wideNavigationRailColors, function2, windowInsets, vertical, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0108  */
    /* JADX INFO: renamed from: WideNavigationRailItem-pli-t6k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4530WideNavigationRailItemplit6k(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        boolean z4;
        int i4;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z5;
        int iM4526iconPositionFors8pcRp0;
        NavigationItemColors navigationItemColorsColors;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final boolean z6;
        final int i10;
        final NavigationItemColors navigationItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1894733304);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,railExpanded,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)696@33504L5,698@33677L5,699@33767L5,692@33324L1318:WideNavigationRail.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            z4 = z;
        } else {
            z4 = z;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(z4) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                function23 = function2;
                i4 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    function24 = function22;
                    i4 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                }
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        modifier2 = modifier;
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                    }
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                    } else {
                        if ((1572864 & i2) == 0) {
                            z5 = z3;
                            i4 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                iM4526iconPositionFors8pcRp0 = i;
                                int i13 = composerStartRestartGroup.changed(iM4526iconPositionFors8pcRp0) ? 8388608 : 4194304;
                                i4 |= i13;
                            } else {
                                iM4526iconPositionFors8pcRp0 = i;
                            }
                            i4 |= i13;
                        } else {
                            iM4526iconPositionFors8pcRp0 = i;
                        }
                        if ((100663296 & i2) == 0) {
                            if ((i3 & 256) == 0) {
                                navigationItemColorsColors = navigationItemColors;
                                int i14 = composerStartRestartGroup.changed(navigationItemColorsColors) ? 67108864 : 33554432;
                                i4 |= i14;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            i4 |= i14;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        i7 = i3 & 512;
                        if (i7 == 0) {
                            if ((i2 & 805306368) == 0) {
                                i8 = i7;
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                            }
                            i9 = i4;
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i9 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier3 = modifier2;
                                z6 = z5;
                                i10 = iM4526iconPositionFors8pcRp0;
                                navigationItemColors2 = navigationItemColorsColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "686@33127L8");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i6 != 0) {
                                        z5 = true;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i11 = i9 & (-29360129);
                                        iM4526iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4526iconPositionFors8pcRp0(z2);
                                    } else {
                                        i11 = i9;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i11 &= -234881025;
                                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    }
                                    i12 = i11;
                                    if (i8 != 0) {
                                        mutableInteractionSource3 = null;
                                    }
                                    Modifier modifier4 = modifier2;
                                    boolean z7 = z5;
                                    int i15 = iM4526iconPositionFors8pcRp0;
                                    NavigationItemColors navigationItemColors3 = navigationItemColorsColors;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:688)");
                                    }
                                    if (mutableInteractionSource3 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-1539072909);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "690@33279L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227447151, "CC(remember):WideNavigationRail.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(227446500);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    int i16 = i12 << 3;
                                    composer2 = composerStartRestartGroup;
                                    NavigationItemKt.m3887AnimatedNavigationItemDQd_Gtc(z4, function02, function23, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5164getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5158getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5160getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors3, modifier4, z7, function24, i15, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i16) | (i16 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    navigationItemColors2 = navigationItemColors3;
                                    modifier3 = modifier4;
                                    z6 = z7;
                                    i10 = i15;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    i12 = (i3 & 128) != 0 ? i9 & (-29360129) : i9;
                                    if ((i3 & 256) != 0) {
                                        i12 &= -234881025;
                                    }
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                Modifier modifier42 = modifier2;
                                boolean z72 = z5;
                                int i152 = iM4526iconPositionFors8pcRp0;
                                NavigationItemColors navigationItemColors32 = navigationItemColorsColors;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (mutableInteractionSource3 != null) {
                                }
                                int i162 = i12 << 3;
                                composer2 = composerStartRestartGroup;
                                NavigationItemKt.m3887AnimatedNavigationItemDQd_Gtc(z4, function02, function23, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5163getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5164getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5158getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5160getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors32, modifier42, z72, function24, i152, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i162) | (i162 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                mutableInteractionSource2 = mutableInteractionSource3;
                                navigationItemColors2 = navigationItemColors32;
                                modifier3 = modifier42;
                                z6 = z72;
                                i10 = i152;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$16(z, function0, function2, function22, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        i8 = i7;
                        i9 = i4;
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i9 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z5 = z3;
                    if ((12582912 & i2) == 0) {
                    }
                    if ((100663296 & i2) == 0) {
                    }
                    i7 = i3 & 512;
                    if (i7 == 0) {
                    }
                    i8 = i7;
                    i9 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                z5 = z3;
                if ((12582912 & i2) == 0) {
                }
                if ((100663296 & i2) == 0) {
                }
                i7 = i3 & 512;
                if (i7 == 0) {
                }
                i8 = i7;
                i9 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function24 = function22;
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            z5 = z3;
            if ((12582912 & i2) == 0) {
            }
            if ((100663296 & i2) == 0) {
            }
            i7 = i3 & 512;
            if (i7 == 0) {
            }
            i8 = i7;
            i9 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function23 = function2;
        if ((i3 & 8) == 0) {
        }
        function24 = function22;
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        z5 = z3;
        if ((12582912 & i2) == 0) {
        }
        if ((100663296 & i2) == 0) {
        }
        i7 = i3 & 512;
        if (i7 == 0) {
        }
        i8 = i7;
        i9 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit WideNavigationRailItem_pli_t6k$lambda$16(boolean z, Function0 function0, Function2 function2, Function2 function22, boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m4530WideNavigationRailItemplit6k(z, function0, function2, function22, z2, modifier, z3, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WideNavigationRailLayout(final Modifier modifier, final boolean z, final boolean z2, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, final Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        WideNavigationRailColors wideNavigationRailColors2;
        float fM9128unboximpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1004308036);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailLayout)N(modifier,isModal,expanded,colors,shape,header,windowInsets,arrangement,content)219@9930L33,220@9998L33,222@10107L7,229@10373L11,230@10448L11,232@10488L195,237@10718L195,242@10954L170,247@11158L154,257@11558L8819,252@11318L9059:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i2 |= composerStartRestartGroup.changed(wideNavigationRailColors2) ? 2048 : 1024;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changed(vertical) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1004308036, i2, -1, "androidx.compose.material3.WideNavigationRailLayout (WideNavigationRail.kt:218)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227630237, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227632413, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (Dp.m9119equalsimpl0(((Dp) objConsume).m9128unboximpl(), Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM())) {
                composerStartRestartGroup.startReplaceGroup(-597966102);
                composerStartRestartGroup.endReplaceGroup();
                fM9128unboximpl = Dp.m9114constructorimpl(0.0f);
            } else {
                composerStartRestartGroup.startReplaceGroup(-597931134);
                ComposerKt.sourceInformation(composerStartRestartGroup, "225@10219L7");
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM9128unboximpl = ((Dp) objConsume2).m9128unboximpl();
                composerStartRestartGroup.endReplaceGroup();
            }
            float f = fM9128unboximpl;
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            State<Dp> stateM1380animateDpAsStateAjpBEmI = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z2 ? CollapsedRailWidth : ExpandedRailMinWidth, !z ? finiteAnimationSpecValue : finiteAnimationSpecValue2, null, null, composerStartRestartGroup, 0, 12);
            float f2 = !z2 ? CollapsedRailWidth : ExpandedRailMaxWidth;
            if (!z) {
                finiteAnimationSpecValue2 = finiteAnimationSpecValue;
            }
            State<Dp> stateM1380animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(f2, finiteAnimationSpecValue2, null, null, composerStartRestartGroup, 0, 12);
            FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue;
            State<Dp> stateM1380animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z2 ? NavigationRailCollapsedTokens.INSTANCE.m5149getItemVerticalSpaceD9Ej5fM() : Dp.m9114constructorimpl(0.0f), finiteAnimationSpec, null, null, composerStartRestartGroup, 0, 12);
            int i3 = i2;
            SurfaceKt.m4145SurfaceT9BRK9s(modifier, shape, !z ? wideNavigationRailColors2.getContainerColor() : wideNavigationRailColors2.getModalContainerColor(), !z ? wideNavigationRailColors2.getContentColor() : wideNavigationRailColors2.getModalContentColor(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1489314345, true, new AnonymousClass1(windowInsets, function2, z2, stateM1380animateDpAsStateAjpBEmI, f, AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z2 ? TopIconItemMinHeight : f, finiteAnimationSpec, null, null, composerStartRestartGroup, 0, 12), stateM1380animateDpAsStateAjpBEmI2, mutableIntState2, mutableIntState, vertical, stateM1380animateDpAsStateAjpBEmI3, function22), composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | ((i3 >> 9) & 112), 112);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailLayout$lambda$12(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$10(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$11(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    static final Unit WideNavigationRailLayout$lambda$12(Modifier modifier, boolean z, boolean z2, WideNavigationRailColors wideNavigationRailColors, Shape shape, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function22, int i, Composer composer, int i2) {
        WideNavigationRailLayout(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WideNavigationRailLayout$lambda$4(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$6(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WideNavigationRailLayout$lambda$7(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$8(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$9(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f, boolean z) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return (((z ? 1.0f : -1.0f) * MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo1624toPx0680j_4(PredictiveBackMaxScaleXDistance), fIntBitsToFloat), f)) / fIntBitsToFloat) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo1624toPx0680j_4(PredictiveBackMaxScaleYDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    public static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> getLocalModalWideNavigationRailOverride() {
        return LocalModalWideNavigationRailOverride;
    }

    public static final ProvidableCompositionLocal<WideNavigationRailOverride> getLocalWideNavigationRailOverride() {
        return LocalWideNavigationRailOverride;
    }

    public static final float getWNRItemNoLabelIndicatorPadding() {
        return WNRItemNoLabelIndicatorPadding;
    }
}
