package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a]\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0016\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001a=\u0010\u0018\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0019\u001ai\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b%\u0010&\u001aq\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b'\u0010(\u001ai\u0010)\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b*\u0010&\u001aq\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b+\u0010(\u001ai\u0010,\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b-\u0010&\u001a{\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00101\u001a\u0002022\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0001¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a$\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010:\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010;\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0014\u0010<\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a\u0014\u0010>\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a.\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010@\u001a\u008e\u0001\u0010A\u001a\u00020\t2\u0011\u0010B\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\u0006\u0010C\u001a\u00020\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010G\u001a\u00020\u001c2\b\b\u0002\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0002\u0010L\u001a \u0010M\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H\u0002\u001a;\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002070\u000b2\u0006\u0010U\u001a\u00020\u0012H\u0003¢\u0006\u0004\bV\u0010W\"\u000e\u0010X\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010[\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0016\u0010\\\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b]\u0010^\"\u0016\u0010_\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b`\u0010^\"\u0016\u0010a\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bb\u0010^\"\u0014\u0010c\u001a\b\u0012\u0004\u0012\u0002070dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material3/DrawerState;", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "ModalNavigationDrawer", "", "drawerContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "scrimColor", "Landroidx/compose/ui/graphics/Color;", FirebaseAnalytics.Param.CONTENT, "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "drawerContentColor", "drawerTonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet", "DismissibleDrawerSheet-afqeVBk", "DismissibleDrawerSheet-Snr_uVM", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "drawerOffset", "Landroidx/compose/material3/internal/FloatProducer;", "DrawerSheet-cm3T3N0", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "horizontalScaleUp", "drawerWidth", "", "isRtl", "horizontalScaleDown", "predictiveBackDrawerContainer", "predictiveBackDrawerChild", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationDrawerItem", Constants.ScionAnalytics.PARAM_LABEL, "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", "a", "b", "pos", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "F", "MinimumDrawerWidth", "PredictiveBackDrawerMaxScaleXDistanceGrow", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "AnchoredDraggableDefaultAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3", "anchorsInitialized", "minValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = Dp.m9114constructorimpl(400.0f);
    private static final float MinimumDrawerWidth = Dp.m9114constructorimpl(240.0f);
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.m9114constructorimpl(12.0f);
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.m9114constructorimpl(24.0f);
    private static final float PredictiveBackDrawerMaxScaleYDistance = Dp.m9114constructorimpl(48.0f);
    private static final TweenSpec<Float> AnchoredDraggableDefaultAnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX WARN: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0107  */
    /* JADX INFO: renamed from: DismissibleDrawerSheet-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3859DismissibleDrawerSheetSnr_uVM(final DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        long standardContainerColor;
        long jM3479contentColorForek8zF_U;
        int i5;
        float fM3623getDismissibleDrawerElevationD9Ej5fM;
        final WindowInsets windowInsets2;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final float f2;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        WindowInsets windowInsets3;
        Composer composerStartRestartGroup = composer.startRestartGroup(496605370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DismissibleDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)731@31451L519,731@31410L560:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    rectangleShape = shape;
                    i3 |= composerStartRestartGroup.changed(rectangleShape) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        standardContainerColor = j;
                        int i8 = composerStartRestartGroup.changed(standardContainerColor) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        standardContainerColor = j;
                    }
                    i3 |= i8;
                } else {
                    standardContainerColor = j;
                }
                if ((i & 24576) == 0) {
                    jM3479contentColorForek8zF_U = j2;
                    i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM3479contentColorForek8zF_U)) ? 16384 : 8192;
                } else {
                    jM3479contentColorForek8zF_U = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        fM3623getDismissibleDrawerElevationD9Ej5fM = f;
                        i3 |= composerStartRestartGroup.changed(fM3623getDismissibleDrawerElevationD9Ej5fM) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(windowInsets)) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "725@31122L22,726@31178L37,728@31339L12");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i7 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 8) != 0) {
                                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                                    i3 &= -57345;
                                }
                                if (i5 != 0) {
                                    fM3623getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3623getDismissibleDrawerElevationD9Ej5fM();
                                }
                                if ((i2 & 64) != 0) {
                                    modifier3 = modifier2;
                                    shape2 = rectangleShape;
                                    j3 = standardContainerColor;
                                    f2 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                                    j4 = jM3479contentColorForek8zF_U;
                                    i6 = i3 & (-3670017);
                                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(496605370, i6, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:730)");
                                }
                                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new NavigationDrawerKt$DismissibleDrawerSheet$2(windowInsets3, modifier3, shape2, j3, j4, f2, drawerState, function3), composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                windowInsets2 = windowInsets3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                            }
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3479contentColorForek8zF_U;
                            i6 = i3;
                            windowInsets3 = windowInsets;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new NavigationDrawerKt$DismissibleDrawerSheet$2(windowInsets3, modifier3, shape2, j3, j4, f2, drawerState, function3), composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            windowInsets2 = windowInsets;
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3479contentColorForek8zF_U;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$46(drawerState, modifier3, shape2, j3, j4, f2, windowInsets2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                fM3623getDismissibleDrawerElevationD9Ej5fM = f;
                if ((i & 1572864) == 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            rectangleShape = shape;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            fM3623getDismissibleDrawerElevationD9Ej5fM = f;
            if ((i & 1572864) == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        rectangleShape = shape;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        fM3623getDismissibleDrawerElevationD9Ej5fM = f;
        if ((i & 1572864) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX INFO: renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3860DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape rectangleShape;
        long standardContainerColor;
        long jM3479contentColorForek8zF_U;
        int i4;
        float fM3623getDismissibleDrawerElevationD9Ej5fM;
        WindowInsets windowInsets2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j5;
        long j6;
        float f3;
        WindowInsets windowInsets4;
        Modifier modifier4;
        Shape shape3;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1496398234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DismissibleDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)687@29311L343:NavigationDrawer.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    standardContainerColor = j;
                    int i8 = composerStartRestartGroup.changed(standardContainerColor) ? 256 : 128;
                    i3 |= i8;
                } else {
                    standardContainerColor = j;
                }
                i3 |= i8;
            } else {
                standardContainerColor = j;
            }
            if ((i & 3072) != 0) {
                jM3479contentColorForek8zF_U = j2;
                i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(jM3479contentColorForek8zF_U)) ? 2048 : 1024;
            } else {
                jM3479contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    fM3623getDismissibleDrawerElevationD9Ej5fM = f;
                    i3 |= composerStartRestartGroup.changed(fM3623getDismissibleDrawerElevationD9Ej5fM) ? 16384 : 8192;
                }
                if ((196608 & i) == 0) {
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
                if ((i2 & 64) == 0) {
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        j4 = jM3479contentColorForek8zF_U;
                        f2 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "681@29023L22,682@29079L37,684@29240L12");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                fM3623getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3623getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shape3 = rectangleShape;
                                j5 = standardContainerColor;
                                j6 = jM3479contentColorForek8zF_U;
                                f3 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                                modifier4 = companion;
                                windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            } else {
                                j5 = standardContainerColor;
                                j6 = jM3479contentColorForek8zF_U;
                                f3 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                                windowInsets4 = windowInsets2;
                                modifier4 = companion;
                                shape3 = rectangleShape;
                            }
                            i5 = -1496398234;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            j5 = standardContainerColor;
                            j6 = jM3479contentColorForek8zF_U;
                            f3 = fM3623getDismissibleDrawerElevationD9Ej5fM;
                            windowInsets4 = windowInsets2;
                            i5 = -1496398234;
                            modifier4 = modifier2;
                            shape3 = rectangleShape;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:686)");
                        }
                        int i10 = i3 << 6;
                        composer2 = composerStartRestartGroup;
                        m3861DrawerSheetcm3T3N0(null, windowInsets4, modifier4, shape3, j5, j6, f3, null, function3, composer2, ((i3 >> 12) & 112) | 6 | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets3 = windowInsets4;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        f2 = f3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationDrawerKt.DismissibleDrawerSheet_afqeVBk$lambda$45(modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 1572864;
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM3623getDismissibleDrawerElevationD9Ej5fM = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        rectangleShape = shape;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        fM3623getDismissibleDrawerElevationD9Ej5fM = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$46(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3859DismissibleDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DismissibleDrawerSheet_afqeVBk$lambda$45(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3860DismissibleDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final DrawerState drawerStateRememberDrawerState;
        int i4;
        boolean z2;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        boolean z4;
        Object objRememberedValue;
        MutableState mutableState;
        final Density density;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        final FiniteAnimationSpec finiteAnimationSpecValue2;
        boolean zChanged;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final CoroutineScope coroutineScope;
        final String strM4676getString2EP1pXo;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z5;
        NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue;
        int currentCompositeKeyHash2;
        Composer composerM5595constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChanged2;
        Object objRememberedValue4;
        int currentCompositeKeyHash3;
        Composer composerM5595constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        int currentCompositeKeyHash4;
        Composer composerM5595constructorimpl4;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(1150092038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DismissibleNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,content)464@19353L34,465@19419L7,468@19586L7,469@19678L7,471@19702L155,471@19691L166,477@19875L24,478@19925L33,480@19997L7,481@20032L2189:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i6 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i3 |= i6;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i3 |= i6;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "460@19204L39");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            modifier3 = modifier2;
                            z4 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:463)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431863176, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume;
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431874465, "CC(remember):NavigationDrawer.kt#9igjgp");
                        int i7 = (i3 & 896) ^ 384;
                        zChanged = ((i7 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda21
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$30$lambda$29(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Strings.Companion companion = Strings.INSTANCE;
                        strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), objConsume2 != LayoutDirection.Rtl, Orientation.Horizontal, z4, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901227702, "C508@20959L1256,489@20282L1933:NavigationDrawer.kt#uh7d8r");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691618860, "CC(remember):NavigationDrawer.kt#9igjgp");
                        z5 = (i7 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256;
                        navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z5 || navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(drawerStateRememberDrawerState, mutableState);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor2);
                        }
                        composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778119236, "C492@20374L452,491@20330L570,506@20917L17:NavigationDrawer.kt#uh7d8r");
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850041, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(strM4676getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue4, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor3);
                        }
                        composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C504@20867L15:NavigationDrawer.kt#uh7d8r");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor4);
                        }
                        composerM5595constructorimpl4 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C506@20923L9:NavigationDrawer.kt#uh7d8r");
                        function23 = function22;
                        function23.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        z3 = z4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                    }
                    modifier3 = modifier2;
                    z4 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431863176, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume3;
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431874465, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i72 = (i3 & 896) ^ 384;
                    if (i72 <= 256) {
                        zChanged = ((i72 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda21
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$30$lambda$29(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            }
                            coroutineScope = (CoroutineScope) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Strings.Companion companion5 = Strings.INSTANCE;
                            strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume22 = composerStartRestartGroup.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), objConsume22 != LayoutDirection.Rtl, Orientation.Horizontal, z4, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default2);
                            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                            }
                            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM5595constructorimpl.getInserting()) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901227702, "C508@20959L1256,489@20282L1933:NavigationDrawer.kt#uh7d8r");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691618860, "CC(remember):NavigationDrawer.kt#9igjgp");
                                if (i72 <= 256) {
                                    navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z5) {
                                        navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(drawerStateRememberDrawerState, mutableState);
                                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue);
                                        MeasurePolicy measurePolicy2 = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        Modifier.Companion companion22 = Modifier.INSTANCE;
                                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap22 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion22);
                                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                        }
                                        composerStartRestartGroup.startReusableNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                        }
                                        composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (!composerM5595constructorimpl2.getInserting()) {
                                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778119236, "C492@20374L452,491@20330L570,506@20917L17:NavigationDrawer.kt#uh7d8r");
                                            Modifier.Companion companion32 = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850041, "CC(remember):NavigationDrawer.kt#9igjgp");
                                            if (i72 <= 256) {
                                                zChanged2 = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | ((i72 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged2) {
                                                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda23
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(strM4676getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(companion32, false, (Function1) objRememberedValue4, 1, null);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                    CompositionLocalMap currentCompositionLocalMap32 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier32 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default2);
                                                    Function0<ComposeUiNode> constructor32 = ComposeUiNode.INSTANCE.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                    }
                                                    composerStartRestartGroup.startReusableNode();
                                                    if (composerStartRestartGroup.getInserting()) {
                                                    }
                                                    composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                                                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (!composerM5595constructorimpl3.getInserting()) {
                                                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                        Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier32, ComposeUiNode.INSTANCE.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C504@20867L15:NavigationDrawer.kt#uh7d8r");
                                                        function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        composerStartRestartGroup.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                        Modifier.Companion companion42 = Modifier.INSTANCE;
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy32 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                        CompositionLocalMap currentCompositionLocalMap42 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier42 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion42);
                                                        Function0<ComposeUiNode> constructor42 = ComposeUiNode.INSTANCE.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                        }
                                                        composerStartRestartGroup.startReusableNode();
                                                        if (composerStartRestartGroup.getInserting()) {
                                                        }
                                                        composerM5595constructorimpl4 = Updater.m5595constructorimpl(composerStartRestartGroup);
                                                        Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy32, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap42, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (!composerM5595constructorimpl4.getInserting()) {
                                                            composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                            composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                            Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier42, ComposeUiNode.INSTANCE.getSetModifier());
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C506@20923L9:NavigationDrawer.kt#uh7d8r");
                                                            function23 = function22;
                                                            function23.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            composerStartRestartGroup.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            composerStartRestartGroup.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            composerStartRestartGroup.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                            modifier2 = modifier3;
                                                            z3 = z4;
                                                        }
                                                    }
                                                }
                                            } else {
                                                zChanged2 = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | ((i72 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged2) {
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    navigationDrawerKt$DismissibleNavigationDrawer$2$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z5) {
                                    }
                                }
                            }
                        }
                    } else {
                        zChanged = ((i72 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                        }
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z2;
                }
                final DrawerState drawerState2 = drawerStateRememberDrawerState;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$39(function2, modifier4, drawerState2, z3, function23, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            final DrawerState drawerState22 = drawerStateRememberDrawerState;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        final DrawerState drawerState222 = drawerStateRememberDrawerState;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DismissibleNavigationDrawer$lambda$27(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DismissibleNavigationDrawer$lambda$28(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        return Unit.INSTANCE;
    }

    static final Unit DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    static final boolean DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1(drawerState, null), 3, null);
        return true;
    }

    static final Unit DismissibleNavigationDrawer$lambda$39(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, Function2 function22, int i, int i2, Composer composer, int i3) {
        DismissibleNavigationDrawer(function2, modifier, drawerState, z, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DrawerPredictiveBackHandler(final DrawerState drawerState, final Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        DrawerPredictiveBackState drawerPredictiveBackState;
        int i3;
        String str;
        NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 navigationDrawerKt$DrawerPredictiveBackHandler$2$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-383087355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerPredictiveBackHandler)N(drawerState,content)942@40202L40,943@40259L24,944@40321L7,948@40483L7,954@40796L1297,954@40744L1349,986@42136L99,986@42099L136,992@42241L34:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i4 = i2;
        if (composerStartRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-383087355, i4, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.kt:941)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220245293, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new DrawerPredictiveBackState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DrawerPredictiveBackState drawerPredictiveBackState2 = (DrawerPredictiveBackState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z = objConsume == LayoutDirection.Rtl;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Ref.FloatRef floatRef3 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            floatRef.element = density.mo1624toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
            floatRef2.element = density.mo1624toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
            floatRef3.element = density.mo1624toPx0680j_4(PredictiveBackDrawerMaxScaleYDistance);
            boolean zIsOpen = drawerState.isOpen();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220265558, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i5 = i4 & 14;
            boolean zChanged = composerStartRestartGroup.changed(z) | composerStartRestartGroup.changed(floatRef.element) | composerStartRestartGroup.changed(floatRef2.element) | composerStartRestartGroup.changed(floatRef3.element) | composerStartRestartGroup.changedInstance(coroutineScope) | (i5 == 4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                drawerPredictiveBackState = drawerPredictiveBackState2;
                i3 = i5;
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, coroutineScope, drawerState, z, floatRef, floatRef2, floatRef3, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$2$1);
            } else {
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                drawerPredictiveBackState = drawerPredictiveBackState2;
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = objRememberedValue3;
                i3 = i5;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandler_androidKt.PredictiveBackHandler(zIsOpen, (Function2) navigationDrawerKt$DrawerPredictiveBackHandler$2$1, composerStartRestartGroup, 0, 0);
            Boolean boolValueOf = Boolean.valueOf(drawerState.isClosed());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220307240, str);
            boolean z2 = i3 == 4;
            NavigationDrawerKt$DrawerPredictiveBackHandler$3$1 navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue = new NavigationDrawerKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue, composerStartRestartGroup, 0);
            function3.invoke(drawerPredictiveBackState, composerStartRestartGroup, Integer.valueOf((i4 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DrawerPredictiveBackHandler$lambda$62(drawerState, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DrawerPredictiveBackHandler$lambda$62(DrawerState drawerState, Function3 function3, int i, Composer composer, int i2) {
        DrawerPredictiveBackHandler(drawerState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX INFO: renamed from: DrawerSheet-cm3T3N0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3861DrawerSheetcm3T3N0(final DrawerPredictiveBackState drawerPredictiveBackState, final WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, FloatProducer floatProducer, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        WindowInsets windowInsets2;
        int i4;
        Modifier modifier2;
        int i5;
        Shape rectangleShape;
        long standardContainerColor;
        long jM3479contentColorForek8zF_U;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f2;
        final FloatProducer floatProducer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        FloatProducer floatProducer3;
        float f3;
        long j5;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1560288494);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerSheet)N(drawerPredictiveBackState,windowInsets,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,drawerOffset,content)797@34436L7,800@34593L7,826@35796L867,807@34858L1805:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(drawerPredictiveBackState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                windowInsets2 = windowInsets;
                i3 |= composerStartRestartGroup.changed(windowInsets2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        rectangleShape = shape;
                        i3 |= composerStartRestartGroup.changed(rectangleShape) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            standardContainerColor = j;
                            int i11 = composerStartRestartGroup.changed(standardContainerColor) ? 16384 : 8192;
                            i3 |= i11;
                        } else {
                            standardContainerColor = j;
                        }
                        i3 |= i11;
                    } else {
                        standardContainerColor = j;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            jM3479contentColorForek8zF_U = j2;
                            int i12 = composerStartRestartGroup.changed(jM3479contentColorForek8zF_U) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            jM3479contentColorForek8zF_U = j2;
                        }
                        i3 |= i12;
                    } else {
                        jM3479contentColorForek8zF_U = j2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) != 0) {
                            i10 = 4194304;
                            i3 |= i10;
                        } else {
                            if ((16777216 & i) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer)) {
                                i10 = 8388608;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 100663296) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        }
                        i7 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "791@34129L22,792@34185L37,794@34330L20");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                                    i8 = i7 & (-57345);
                                } else {
                                    i8 = i7;
                                }
                                if ((i2 & 32) != 0) {
                                    jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                }
                                float fM3626getPermanentDrawerElevationD9Ej5fM = i6 != 0 ? DrawerDefaults.INSTANCE.m3626getPermanentDrawerElevationD9Ej5fM() : f;
                                if ((i2 & 128) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493671010, "CC(remember):NavigationDrawer.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                            @Override // androidx.compose.material3.internal.FloatProducer
                                            public final float invoke() {
                                                return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$51$lambda$50();
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    floatProducer3 = (FloatProducer) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i8 &= -29360129;
                                } else {
                                    floatProducer3 = floatProducer;
                                }
                                f3 = fM3626getPermanentDrawerElevationD9Ej5fM;
                                j5 = standardContainerColor;
                                i9 = 12582912;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i8 = (i2 & 16) != 0 ? i7 & (-57345) : i7;
                                if ((i2 & 32) != 0) {
                                    i8 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i8 &= -29360129;
                                }
                                f3 = f;
                                j5 = standardContainerColor;
                                i9 = 12582912;
                                floatProducer3 = floatProducer;
                            }
                            long j6 = jM3479contentColorForek8zF_U;
                            Shape shape3 = rectangleShape;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1560288494, i8, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:796)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM5136getContainerWidthD9Ej5fM = NavigationDrawerTokens.INSTANCE.m5136getContainerWidthD9Ej5fM();
                            final float fMo1624toPx0680j_4 = ((Density) objConsume).mo1624toPx0680j_4(fM5136getContainerWidthD9Ej5fM);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean z = objConsume2 == LayoutDirection.Rtl;
                            Modifier modifier4 = modifier2;
                            final FloatProducer floatProducer4 = floatProducer3;
                            final WindowInsets windowInsets3 = windowInsets2;
                            final boolean z2 = z;
                            int i13 = i8 >> 6;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m2087sizeInqDBjuR0$default(modifier4, MinimumDrawerWidth, 0.0f, fM5136getContainerWidthD9Ej5fM, 0.0f, 10, null), floatProducer3, fMo1624toPx0680j_4, z).then(drawerPredictiveBackState != null ? predictiveBackDrawerContainer(Modifier.INSTANCE, drawerPredictiveBackState, z) : Modifier.INSTANCE), 0.0f, 1, null), shape3, j5, j6, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i14) {
                                    ComposerKt.sourceInformation(composer3, "C831@36016L641:NavigationDrawer.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-315420087, i14, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:827)");
                                    }
                                    Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(NavigationDrawerKt.horizontalScaleDown(SizeKt.m2087sizeInqDBjuR0$default(Modifier.INSTANCE, NavigationDrawerKt.MinimumDrawerWidth, 0.0f, fM5136getContainerWidthD9Ej5fM, 0.0f, 10, null), floatProducer4, fMo1624toPx0680j_4, z2).then(drawerPredictiveBackState != null ? NavigationDrawerKt.predictiveBackDrawerChild(Modifier.INSTANCE, drawerPredictiveBackState, z2) : Modifier.INSTANCE), windowInsets3);
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierWindowInsetsPadding);
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
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composer2, (i13 & 112) | i9 | (i13 & 896) | (i13 & 7168) | (i13 & 57344), 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            floatProducer2 = floatProducer3;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = j6;
                            f2 = f3;
                            modifier3 = modifier4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            j4 = jM3479contentColorForek8zF_U;
                            f2 = f;
                            floatProducer2 = floatProducer;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$53(drawerPredictiveBackState, windowInsets, modifier3, shape2, j3, j4, f2, floatProducer2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 100663296;
                    i7 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                rectangleShape = shape;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i2 & 256) != 0) {
                }
                i7 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            rectangleShape = shape;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i2 & 256) != 0) {
            }
            i7 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        windowInsets2 = windowInsets;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        rectangleShape = shape;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i2 & 256) != 0) {
        }
        i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final float DrawerSheet_cm3T3N0$lambda$51$lambda$50() {
        return 0.0f;
    }

    static final Unit DrawerSheet_cm3T3N0$lambda$53(DrawerPredictiveBackState drawerPredictiveBackState, WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, FloatProducer floatProducer, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3861DrawerSheetcm3T3N0(drawerPredictiveBackState, windowInsets, modifier, shape, j, j2, f, floatProducer, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0108  */
    /* JADX INFO: renamed from: ModalDrawerSheet-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3862ModalDrawerSheetSnr_uVM(final DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        long modalContainerColor;
        long jM3479contentColorForek8zF_U;
        int i4;
        float fM3625getModalDrawerElevationD9Ej5fM;
        WindowInsets windowInsets2;
        final Modifier modifier3;
        final Shape shape3;
        final long j3;
        final long j4;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        WindowInsets windowInsets4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1620540727);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)642@27084L519,642@27043L560:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i7 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    shape2 = shape;
                }
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    modalContainerColor = j;
                    int i8 = composerStartRestartGroup.changed(modalContainerColor) ? 2048 : 1024;
                    i3 |= i8;
                } else {
                    modalContainerColor = j;
                }
                i3 |= i8;
            } else {
                modalContainerColor = j;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    jM3479contentColorForek8zF_U = j2;
                    int i9 = composerStartRestartGroup.changed(jM3479contentColorForek8zF_U) ? 16384 : 8192;
                    i3 |= i9;
                } else {
                    jM3479contentColorForek8zF_U = j2;
                }
                i3 |= i9;
            } else {
                jM3479contentColorForek8zF_U = j2;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i) == 0) {
                    fM3625getModalDrawerElevationD9Ej5fM = f;
                    i3 |= composerStartRestartGroup.changed(fM3625getModalDrawerElevationD9Ej5fM) ? 131072 : 65536;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        windowInsets2 = windowInsets;
                        int i10 = composerStartRestartGroup.changed(windowInsets2) ? 1048576 : 524288;
                        i3 |= i10;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i10;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 128) == 0) {
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3479contentColorForek8zF_U;
                        f2 = fM3625getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "635@26708L5,636@26764L19,637@26817L37,639@26972L12");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 8) != 0) {
                                modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                fM3625getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3625getModalDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 64) != 0) {
                                modifier3 = modifier2;
                                shape3 = shape2;
                                j3 = modalContainerColor;
                                j4 = jM3479contentColorForek8zF_U;
                                f2 = fM3625getModalDrawerElevationD9Ej5fM;
                                i5 = i3 & (-3670017);
                                windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1620540727, i5, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:641)");
                            }
                            DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new NavigationDrawerKt$ModalDrawerSheet$2(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function3), composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets3 = windowInsets4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                        }
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3479contentColorForek8zF_U;
                        f2 = fM3625getModalDrawerElevationD9Ej5fM;
                        i5 = i3;
                        windowInsets4 = windowInsets2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new NavigationDrawerKt$ModalDrawerSheet$2(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function3), composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        windowInsets3 = windowInsets4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$44(drawerState, modifier3, shape3, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 12582912;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM3625getModalDrawerElevationD9Ej5fM = f;
            if ((1572864 & i) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        fM3625getModalDrawerElevationD9Ej5fM = f;
        if ((1572864 & i) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX INFO: renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3863ModalDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long modalContainerColor;
        long j3;
        float fM3625getModalDrawerElevationD9Ej5fM;
        WindowInsets windowInsets2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final long j4;
        final long j5;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape4;
        long j6;
        float f3;
        WindowInsets windowInsets4;
        int i4;
        Modifier modifier4;
        int i5;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1922633461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)598@24971L343:NavigationDrawer.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
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
                shape2 = shape;
                int i7 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                modalContainerColor = j;
                int i8 = composerStartRestartGroup.changed(modalContainerColor) ? 256 : 128;
                i3 |= i8;
            } else {
                modalContainerColor = j;
            }
            i3 |= i8;
        } else {
            modalContainerColor = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j3 = j2;
                int i9 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                i3 |= i9;
            } else {
                j3 = j2;
            }
            i3 |= i9;
        } else {
            j3 = j2;
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                fM3625getModalDrawerElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM3625getModalDrawerElevationD9Ej5fM) ? 16384 : 8192;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    int i11 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                    i3 |= i11;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i11;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                if ((i & 1572864) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "591@24636L5,592@24692L19,593@24745L37,595@24900L12");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            long jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                            j3 = jM3479contentColorForek8zF_U;
                        }
                        if (i10 != 0) {
                            fM3625getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3625getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier4 = companion;
                            shape4 = shape2;
                            j6 = j3;
                            f3 = fM3625getModalDrawerElevationD9Ej5fM;
                            i5 = 6;
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            j7 = modalContainerColor;
                            i4 = 1922633461;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i4, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:597)");
                            }
                            int i12 = ((i3 >> 12) & 112) | i5;
                            int i13 = i3 << 6;
                            composer2 = composerStartRestartGroup;
                            m3861DrawerSheetcm3T3N0(null, windowInsets4, modifier4, shape4, j7, j6, f3, null, function3, composer2, i12 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (i13 & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets3 = windowInsets4;
                            modifier3 = modifier4;
                            shape3 = shape4;
                            j4 = j7;
                            j5 = j6;
                            f2 = f3;
                        } else {
                            shape4 = shape2;
                            j6 = j3;
                            f3 = fM3625getModalDrawerElevationD9Ej5fM;
                            windowInsets4 = windowInsets2;
                            i4 = 1922633461;
                            modifier4 = companion;
                            i5 = 6;
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
                        shape4 = shape2;
                        j6 = j3;
                        f3 = fM3625getModalDrawerElevationD9Ej5fM;
                        windowInsets4 = windowInsets2;
                        i5 = 6;
                        i4 = 1922633461;
                        modifier4 = modifier2;
                    }
                    j7 = modalContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = ((i3 >> 12) & 112) | i5;
                    int i132 = i3 << 6;
                    composer2 = composerStartRestartGroup;
                    m3861DrawerSheetcm3T3N0(null, windowInsets4, modifier4, shape4, j7, j6, f3, null, function3, composer2, i122 | (i132 & 896) | (i132 & 7168) | (57344 & i132) | (458752 & i132) | (3670016 & i132) | (i132 & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    windowInsets3 = windowInsets4;
                    modifier3 = modifier4;
                    shape3 = shape4;
                    j4 = j7;
                    j5 = j6;
                    f2 = f3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j4 = modalContainerColor;
                    j5 = j3;
                    f2 = fM3625getModalDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.ModalDrawerSheet_afqeVBk$lambda$43(modifier3, shape3, j4, j5, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 1572864;
            if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM3625getModalDrawerElevationD9Ej5fM = f;
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ModalDrawerSheet_Snr_uVM$lambda$44(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3862ModalDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ModalDrawerSheet_afqeVBk$lambda$43(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3863ModalDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c4  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3864ModalNavigationDrawerFHprtrg(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerStateRememberDrawerState;
        int i4;
        long j2;
        final boolean z2;
        final Modifier modifier3;
        final DrawerState drawerState2;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z3;
        long scrimColor;
        boolean z4;
        final DrawerState drawerState3;
        boolean z5;
        boolean zChanged;
        Object objRememberedValue;
        final DrawerState drawerState4;
        final boolean z6;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Composer composerM5595constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        boolean z7;
        Object objRememberedValue4;
        boolean zChanged3;
        Object objRememberedValue5;
        boolean zChanged4;
        NavigationDrawerKt$ModalNavigationDrawer$2$6$1 navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue;
        int currentCompositeKeyHash3;
        Composer composerM5595constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1907430816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,scrimColor:c#ui.graphics.Color,content)339@13901L24,340@13951L33,341@14016L7,342@14054L34,343@14109L45,348@14357L7,349@14451L7,350@14543L7,352@14567L229,352@14556L240,359@14835L7,360@14870L3155:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function23) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i6 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i3 |= i6;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i3 |= i6;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    j2 = j;
                    i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j2)) ? 16384 : 8192;
                } else {
                    j2 = j;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "334@13715L39,336@13832L10");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        z3 = i4 != 0 ? true : z;
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            scrimColor = j2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        companion = modifier2;
                        scrimColor = j2;
                        z3 = z;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1907430816, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:338)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Strings.Companion companion2 = Strings.INSTANCE;
                    final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Density density = (Density) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910036834, "CC(remember):NavigationDrawer.kt#9igjgp");
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        z4 = z3;
                        objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        z4 = z3;
                    }
                    MutableState mutableState = (MutableState) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910038605, "CC(remember):NavigationDrawer.kt#9igjgp");
                    boolean zChanged5 = composerStartRestartGroup.changed(density);
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged5 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    long j4 = scrimColor;
                    final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910053445, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i7 = (i3 & 896) ^ 384;
                    if (i7 <= 256 || !composerStartRestartGroup.changed(drawerStateRememberDrawerState)) {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = false;
                        }
                        zChanged = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            drawerState4 = drawerState3;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            drawerState4 = drawerState3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        z6 = z4;
                        Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), drawerState4.getAnchoredDraggableState$material3(), objConsume2 != LayoutDirection.Rtl, Orientation.Horizontal, z6, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        Modifier modifier4 = companion;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101870438, "C370@15180L17,373@15274L183,378@15482L70,371@15206L389,384@15704L601,396@16337L452,407@16801L1218,381@15604L2415:NavigationDrawer.kt#uh7d8r");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor2);
                        }
                        composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C370@15186L9:NavigationDrawer.kt#uh7d8r");
                        function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean zIsOpen = drawerState4.isOpen();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChangedInstance = ((i3 & 7168) != 2048) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(z6, drawerState4, coroutineScope);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function0 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            final float f = 0.0f;
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationDrawerKt.calculateFraction(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(mutableFloatState), f, drawerState4.requireOffset$material3()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        m3866ScrimBx497Mc(zIsOpen, function0, (Function0) objRememberedValue3, j4, composerStartRestartGroup, (i3 >> 3) & 7168);
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                        z7 = (i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z7 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(drawerState4, (Density) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOffset = OffsetKt.offset(companion4, (Function1) objRememberedValue4);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(strM4676getString2EP1pXo, drawerState4, coroutineScope, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierOffset, false, (Function1) objRememberedValue5, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546376, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256);
                        navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged4 || navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$6$1(drawerState4, mutableState, mutableFloatState, 0.0f);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i8 = i3 & 14;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int i9 = ((i8 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor3);
                        }
                        composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        function23 = function2;
                        function23.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 6) & 14));
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState2 = drawerState4;
                        j3 = j4;
                        modifier3 = modifier4;
                        z2 = z6;
                    } else {
                        drawerState3 = drawerStateRememberDrawerState;
                    }
                    z5 = true;
                    zChanged = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        drawerState4 = drawerState3;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume22 = composerStartRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        z6 = z4;
                        Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), drawerState4.getAnchoredDraggableState$material3(), objConsume22 != LayoutDirection.Rtl, Orientation.Horizontal, z6, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        Modifier modifier42 = companion;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default2);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting()) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101870438, "C370@15180L17,373@15274L183,378@15482L70,371@15206L389,384@15704L601,396@16337L452,407@16801L1218,381@15604L2415:NavigationDrawer.kt#uh7d8r");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion32 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap22 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion32);
                            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                            }
                            composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM5595constructorimpl2.getInserting()) {
                                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C370@15186L9:NavigationDrawer.kt#uh7d8r");
                                function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                boolean zIsOpen2 = drawerState4.isOpen();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                                if (i7 <= 256) {
                                    zChangedInstance = ((i3 & 7168) != 2048) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(z6, drawerState4, coroutineScope);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        Function0 function02 = (Function0) objRememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                                        if (i7 <= 256) {
                                            zChanged2 = composerStartRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (zChanged2) {
                                                final float f2 = 0.0f;
                                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Float.valueOf(NavigationDrawerKt.calculateFraction(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(mutableFloatState), f2, drawerState4.requireOffset$material3()));
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                m3866ScrimBx497Mc(zIsOpen2, function02, (Function0) objRememberedValue3, j4, composerStartRestartGroup, (i3 >> 3) & 7168);
                                                Modifier.Companion companion42 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                                                if (i7 <= 256) {
                                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                    if (z7) {
                                                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj) {
                                                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(drawerState4, (Density) obj);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        Modifier modifierOffset2 = OffsetKt.offset(companion42, (Function1) objRememberedValue4);
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                                                        if (i7 <= 256) {
                                                            zChanged3 = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                            if (zChanged3) {
                                                                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj) {
                                                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(strM4676getString2EP1pXo, drawerState4, coroutineScope, (SemanticsPropertyReceiver) obj);
                                                                    }
                                                                };
                                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierOffset2, false, (Function1) objRememberedValue5, 1, null);
                                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546376, "CC(remember):NavigationDrawer.kt#9igjgp");
                                                                if (i7 <= 256) {
                                                                    zChanged4 = composerStartRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256);
                                                                    navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                                    if (zChanged4) {
                                                                        navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$6$1(drawerState4, mutableState, mutableFloatState, 0.0f);
                                                                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue);
                                                                        MeasurePolicy measurePolicy2 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue;
                                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                        int i82 = i3 & 14;
                                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                                        CompositionLocalMap currentCompositionLocalMap32 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                                        Modifier modifierMaterializeModifier32 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default2);
                                                                        Function0<ComposeUiNode> constructor32 = ComposeUiNode.INSTANCE.getConstructor();
                                                                        int i92 = ((i82 << 6) & 896) | 6;
                                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                                        }
                                                                        composerStartRestartGroup.startReusableNode();
                                                                        if (composerStartRestartGroup.getInserting()) {
                                                                        }
                                                                        composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                                                                        Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                        Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                        if (!composerM5595constructorimpl3.getInserting()) {
                                                                            composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                                            composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                                            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier32, ComposeUiNode.INSTANCE.getSetModifier());
                                                                            function23 = function2;
                                                                            function23.invoke(composerStartRestartGroup, Integer.valueOf((i92 >> 6) & 14));
                                                                            composerStartRestartGroup.endNode();
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            composerStartRestartGroup.endNode();
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                            }
                                                                            drawerState2 = drawerState4;
                                                                            j3 = j4;
                                                                            modifier3 = modifier42;
                                                                            z2 = z6;
                                                                        }
                                                                    }
                                                                } else {
                                                                    zChanged4 = composerStartRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256);
                                                                    navigationDrawerKt$ModalNavigationDrawer$2$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                                    if (zChanged4) {
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            zChanged3 = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                            if (zChanged3) {
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                    if (z7) {
                                                    }
                                                }
                                            }
                                        } else {
                                            zChanged2 = composerStartRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (zChanged2) {
                                            }
                                        }
                                    }
                                } else {
                                    zChangedInstance = ((i3 & 7168) != 2048) | ((i7 <= 256 && composerStartRestartGroup.changed(drawerState4)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                    }
                                }
                            }
                        }
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z2 = z;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$25(function23, modifier3, drawerState2, z2, j3, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        drawerState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(boolean z, DrawerState drawerState, CoroutineScope coroutineScope) {
        if (z && drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1(drawerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final IntOffset ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState drawerState, Density density) {
        float currentOffset = drawerState.getCurrentOffset();
        return IntOffset.m9233boximpl(IntOffset.m9236constructorimpl(((long) (!Float.isNaN(currentOffset) ? MathKt.roundToInt(currentOffset) : drawerState.isOpen() ? 0 : -density.mo1618roundToPx0680j_4(DrawerDefaults.INSTANCE.m3624getMaximumDrawerWidthD9Ej5fM()))) << 32));
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    static final boolean ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1(drawerState, null), 3, null);
        return true;
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$25(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, long j, Function2 function22, int i, int i2, Composer composer, int i3) {
        m3864ModalNavigationDrawerFHprtrg(function2, modifier, drawerState, z, j, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        int i7;
        Composer composer2;
        final NavigationDrawerItemColors navigationDrawerItemColors2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Shape value;
        Modifier modifier4;
        boolean z2;
        boolean z3;
        NavigationDrawerItemColors navigationDrawerItemColorsM3858colorsoq7We08;
        MutableInteractionSource mutableInteractionSource3;
        NavigationDrawerItemColors navigationDrawerItemColors3;
        Modifier modifier5;
        ?? r2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-583709666);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationDrawerItem)N(label,selected,onClick,modifier,icon,badge,shape,colors,interactionSource)1083@46164L19,1087@46341L24,1089@46426L885,1078@46032L1279:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
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
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 != 0) {
                        if ((196608 & i) == 0) {
                            function25 = function23;
                            i3 |= composerStartRestartGroup.changedInstance(function25) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                shape2 = shape;
                                int i8 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                                i3 |= i8;
                            } else {
                                shape2 = shape;
                            }
                            i3 |= i8;
                        } else {
                            shape2 = shape;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 8388608 : 4194304;
                        }
                        i7 = i2 & 256;
                        if (i7 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1074@45880L5,1075@45957L8");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function29 = i5 != 0 ? null : function24;
                                function28 = i6 != 0 ? null : function25;
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                                } else {
                                    value = shape2;
                                }
                                int i9 = i3;
                                if ((i2 & 128) != 0) {
                                    modifier4 = companion;
                                    z3 = false;
                                    z2 = true;
                                    navigationDrawerItemColorsM3858colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3858colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i3 = i9 & (-29360129);
                                } else {
                                    modifier4 = companion;
                                    z2 = true;
                                    z3 = false;
                                    navigationDrawerItemColorsM3858colorsoq7We08 = navigationDrawerItemColors;
                                    i3 = i9;
                                }
                                mutableInteractionSource3 = i7 != 0 ? null : mutableInteractionSource;
                                navigationDrawerItemColors3 = navigationDrawerItemColorsM3858colorsoq7We08;
                                function24 = function29;
                                modifier5 = modifier4;
                                r2 = z2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                r2 = 1;
                                modifier5 = modifier2;
                                function28 = function25;
                                value = shape2;
                                z3 = false;
                                navigationDrawerItemColors3 = navigationDrawerItemColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1077)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745713, "CC(remember):NavigationDrawer.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NavigationDrawerKt.NavigationDrawerItem$lambda$64$lambda$63((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i10 = i3 >> 3;
                            final NavigationDrawerItemColors navigationDrawerItemColors4 = navigationDrawerItemColors3;
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function28;
                            Modifier modifier6 = modifier5;
                            Shape shape4 = value;
                            SurfaceKt.m4146Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m2071heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier5, z3, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5134getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i10 & 14) | ((i3 >> 18) & 112)).getValue().m6335unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    ComposerKt.sourceInformation(composer3, "C1090@46436L869:NavigationDrawer.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i11 & 3) != 2, i11 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1173018444, i11, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:1090)");
                                    }
                                    Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f), 0.0f, Dp.m9114constructorimpl(24.0f), 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function212 = function210;
                                    NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors4;
                                    boolean z4 = z;
                                    Function2<Composer, Integer, Unit> function213 = function211;
                                    Function2<Composer, Integer, Unit> function214 = function2;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2041paddingqDBjuR0$default);
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
                                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2013922645, "C1099@46835L203:NavigationDrawer.kt#uh7d8r");
                                    if (function212 != null) {
                                        composer3.startReplaceGroup(-2013920011);
                                        ComposerKt.sourceInformation(composer3, "1095@46642L19,1096@46684L78,1097@46779L29");
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(navigationDrawerItemColors5.iconColor(z4, composer3, 0).getValue().m6335unboximpl())), function212, composer3, ProvidedValue.$stable);
                                        SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composer3, 6);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(-2013707630);
                                        composer3.endReplaceGroup();
                                    }
                                    Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierWeight$default);
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
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1767721817, "C1100@46902L19,1101@46944L80:NavigationDrawer.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(navigationDrawerItemColors5.textColor(z4, composer3, 0).getValue().m6335unboximpl())), function214, composer3, ProvidedValue.$stable);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (function213 != null) {
                                        composer3.startReplaceGroup(-2013454639);
                                        ComposerKt.sourceInformation(composer3, "1104@47088L29,1105@47158L20,1106@47201L80");
                                        SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composer3, 6);
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(navigationDrawerItemColors5.badgeColor(z4, composer3, 0).getValue().m6335unboximpl())), function213, composer3, ProvidedValue.$stable);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(-2013238414);
                                        composer3.endReplaceGroup();
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
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape4;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            navigationDrawerItemColors2 = navigationDrawerItemColors4;
                            modifier3 = modifier6;
                            function26 = function210;
                            function27 = function28;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                            modifier3 = modifier2;
                            function26 = function24;
                            function27 = function25;
                            shape3 = shape2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationDrawerKt.NavigationDrawerItem$lambda$65(function2, z, function0, modifier3, function26, function27, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function25 = function23;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                function25 = function23;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            function25 = function23;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        function25 = function23;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit NavigationDrawerItem$lambda$64$lambda$63(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8334getTabo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit NavigationDrawerItem$lambda$65(Function2 function2, boolean z, Function0 function0, Modifier modifier, Function2 function22, Function2 function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationDrawerItem(function2, z, function0, modifier, function22, function23, shape, navigationDrawerItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX INFO: renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3865PermanentDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        long j3;
        long jM3479contentColorForek8zF_U;
        int i4;
        float f2;
        WindowInsets windowInsets2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape3;
        final long j4;
        final long j5;
        final float f3;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long standardContainerColor;
        float f4;
        long j6;
        WindowInsets windowInsets4;
        Shape shape4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1877158612);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermanentDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)772@33449L33,776@33617L30,773@33487L384:NavigationDrawer.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                shape2 = shape;
                i3 |= composerStartRestartGroup.changed(shape2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    int i8 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i3 |= i8;
                } else {
                    j3 = j;
                }
                i3 |= i8;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                jM3479contentColorForek8zF_U = j2;
                i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(jM3479contentColorForek8zF_U)) ? 2048 : 1024;
            } else {
                jM3479contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    f2 = f;
                    i3 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                }
                if ((196608 & i) == 0) {
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
                if ((i2 & 64) == 0) {
                    if ((i & 1572864) == 0) {
                        function32 = function3;
                        i3 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        shape3 = shape2;
                        j4 = j3;
                        j5 = jM3479contentColorForek8zF_U;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "766@33142L22,767@33198L37,769@33357L12");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i6 != 0 ? Modifier.INSTANCE : modifier;
                            Shape rectangleShape = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                            if ((i2 & 4) != 0) {
                                standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            } else {
                                standardContainerColor = j3;
                            }
                            if ((i2 & 8) != 0) {
                                jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            float fM3626getPermanentDrawerElevationD9Ej5fM = i4 != 0 ? DrawerDefaults.INSTANCE.m3626getPermanentDrawerElevationD9Ej5fM() : f2;
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shape4 = rectangleShape;
                                f4 = fM3626getPermanentDrawerElevationD9Ej5fM;
                                j6 = jM3479contentColorForek8zF_U;
                                i5 = 1877158612;
                                windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            } else {
                                f4 = fM3626getPermanentDrawerElevationD9Ej5fM;
                                j6 = jM3479contentColorForek8zF_U;
                                windowInsets4 = windowInsets2;
                                shape4 = rectangleShape;
                                i5 = 1877158612;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier;
                            j6 = jM3479contentColorForek8zF_U;
                            f4 = f2;
                            windowInsets4 = windowInsets2;
                            i5 = 1877158612;
                            shape4 = shape2;
                            standardContainerColor = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:771)");
                        }
                        Strings.Companion companion2 = Strings.INSTANCE;
                        final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 63182258, "CC(remember):NavigationDrawer.kt#9igjgp");
                        boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(strM4676getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i10 = i3 << 6;
                        composer2 = composerStartRestartGroup;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                        long j7 = standardContainerColor;
                        m3861DrawerSheetcm3T3N0(null, windowInsets4, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), shape4, j7, j6, f4, null, function33, composer2, ((i3 >> 12) & 112) | 6 | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        windowInsets3 = windowInsets4;
                        shape3 = shape4;
                        j4 = j7;
                        j5 = j6;
                        f3 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$49(modifier2, shape3, j4, j5, f3, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 1572864;
                function32 = function3;
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            function32 = function3;
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        shape2 = shape;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        function32 = function3;
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit PermanentDrawerSheet_afqeVBk$lambda$49(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3865PermanentDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(89297160);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermanentNavigationDrawer)N(drawerContent,modifier,content)562@23211L85:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(89297160, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:561)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -688649266, "C563@23249L15,564@23273L17:NavigationDrawer.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1964035624, "C564@23279L9:NavigationDrawer.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier3 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.PermanentNavigationDrawer$lambda$42(function2, modifier3, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit PermanentNavigationDrawer$lambda$42(Function2 function2, Modifier modifier, Function2 function22, int i, int i2, Composer composer, int i3) {
        PermanentNavigationDrawer(function2, modifier, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m3866ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(open,onClose,fraction,color:c#ui.graphics.Color)1285@54138L30,1300@54636L39,1300@54585L90:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1284)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.close_drawer), composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(598792893);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1288@54256L35,1289@54344L187");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404790366, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i3 = i2 & 112;
                boolean z2 = i3 == 32;
                NavigationDrawerKt$Scrim$dismissDrawer$1$1 navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (PointerInputEventHandler) navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404793334, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean zChanged = (i3 == 32) | composerStartRestartGroup.changed(strM4676getString2EP1pXo);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.Scrim_Bx497Mc$lambda$69$lambda$68(strM4676getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(599116967);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404802530, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean z3 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.Scrim_Bx497Mc$lambda$71$lambda$70(j, function02, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.Scrim_Bx497Mc$lambda$72(z, function0, function02, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Scrim_Bx497Mc$lambda$69$lambda$68(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NavigationDrawerKt.Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    static final boolean Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(Function0 function0) {
        function0.invoke();
        return true;
    }

    static final Unit Scrim_Bx497Mc$lambda$71$lambda$70(long j, Function0 function0, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, ((Number) function0.invoke()).floatValue(), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_Bx497Mc$lambda$72(boolean z, Function0 function0, Function0 function02, long j, int i, Composer composer, int i2) {
        m3866ScrimBx497Mc(z, function0, function02, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return ((drawerPredictiveBackState.getScaleXDistance() * (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() ? 1 : -1)) / fIntBitsToFloat) + 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (drawerPredictiveBackState.getScaleYDistance() / fIntBitsToFloat);
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier horizontalScaleDown(Modifier modifier, final FloatProducer floatProducer, final float f, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleDown$lambda$55(floatProducer, f, z, (GraphicsLayerScope) obj);
            }
        });
    }

    static final Unit horizontalScaleDown$lambda$55(FloatProducer floatProducer, float f, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fInvoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(fInvoke > 0.0f ? 1.0f / ((fInvoke / f) + 1.0f) : 1.0f);
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final Modifier horizontalScaleUp(Modifier modifier, final FloatProducer floatProducer, final float f, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleUp$lambda$54(floatProducer, f, z, (GraphicsLayerScope) obj);
            }
        });
    }

    static final Unit horizontalScaleUp$lambda$54(FloatProducer floatProducer, float f, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fInvoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(fInvoke > 0.0f ? (fInvoke / f) + 1.0f : 1.0f);
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier predictiveBackDrawerChild(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerChild$lambda$57(drawerPredictiveBackState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    static final Unit predictiveBackDrawerChild$lambda$57(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fCalculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState);
        graphicsLayerScope.setScaleX(fCalculatePredictiveBackScaleX == 0.0f ? 1.0f : calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState) / fCalculatePredictiveBackScaleX);
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerContainer$lambda$56(drawerPredictiveBackState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    static final Unit predictiveBackDrawerContainer$lambda$56(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        return Unit.INSTANCE;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2098699222, "C(rememberDrawerState)N(initialValue,confirmStateChange)304@12444L8,306@12546L61,306@12482L125:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1784672962, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavigationDrawerKt.rememberDrawerState$lambda$1$lambda$0((DrawerValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:305)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1784669645, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer.changed(drawerValue.ordinal())) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavigationDrawerKt.rememberDrawerState$lambda$3$lambda$2(drawerValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawerState;
    }

    static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue drawerValue) {
        return true;
    }

    static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue drawerValue, Function1 function1) {
        return new DrawerState(drawerValue, function1);
    }
}
