package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SliderKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aj\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00050\u00182\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f0\u0018H\u0002\u001a\u007f\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u001b\u001aK\u0010\u001c\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010!\u001ak\u0010\"\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010)\u001aC\u0010*\u001a\u00020\u0001*\u00020+2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0003¢\u0006\u0004\b/\u00100\u001aS\u00101\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00104\u001a.\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0002\u001a2\u00109\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0003\u0018\u00010:*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0004\bA\u0010B\u001a\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0002\u001a<\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0002\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001aS\u0010O\u001a\u00020\u00012\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00030S2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010T\u001a\\\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001aj\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u0010W\u001a\u00020X2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00050\u00182\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030S2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a.\u0010\\\u001a\u00020\u00012\u0006\u0010W\u001a\u00020X2\u0006\u00106\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010_\u001a\u0098\u0001\u0010`\u001a\u00020\u0007*\u00020\u00072\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00050\u00182\u001e\u0010c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010d0\u0018H\u0002\"\u0016\u0010e\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0010\u0010i\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010j\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010k\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0016\u0010l\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bm\u0010g\"\u0010\u0010n\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010o\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u000e\u0010p\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SliderColors;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "slideOnKeyEvents", "isRtl", "onValueChangeState", "Landroidx/compose/runtime/State;", "onValueChangeFinishedState", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "tickFractions", "", "width", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "startInteractionSource", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/Dp;", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "x", "calcFraction", "a", "b", "pos", "CorrectValueSideEffect", "scaleToOffset", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "sliderSemantics", "sliderTapModifier", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "rawOffset", "gestureEndAction", "pressOffset", "animateToTarget", TypedValues.AttributesType.S_TARGET, "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "rawOffsetEnd", "onDrag", "Lkotlin/Function2;", "ThumbRadius", "getThumbRadius", "()F", "F", "ThumbRippleRadius", "ThumbDefaultElevation", "ThumbPressedElevation", "TrackHeight", "getTrackHeight", "SliderHeight", "SliderMinWidth", "DefaultSliderConstraints", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbRadius = Dp.m9114constructorimpl(10.0f);
    private static final float ThumbRippleRadius = Dp.m9114constructorimpl(24.0f);
    private static final float ThumbDefaultElevation = Dp.m9114constructorimpl(1.0f);
    private static final float ThumbPressedElevation = Dp.m9114constructorimpl(6.0f);
    private static final float TrackHeight = Dp.m9114constructorimpl(4.0f);

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", i = {}, l = {1051}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f, float f2, float f3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
        }

        static final Unit invokeSuspend$lambda$0(DragScope dragScope, Ref.FloatRef floatRef, Animatable animatable) {
            dragScope.dragBy(((Number) animatable.getValue()).floatValue() - floatRef.element);
            floatRef.element = ((Number) animatable.getValue()).floatValue();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$current, this.$target, this.$velocity, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final DragScope dragScope = (DragScope) this.L$0;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = this.$current;
                this.label = 1;
                if (AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null).animateTo(Boxing.boxFloat(this.$target), SliderKt.SliderToTickAnimation, Boxing.boxFloat(this.$velocity), new Function1() { // from class: androidx.compose.material.SliderKt$animateToTarget$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.AnonymousClass2.invokeSuspend$lambda$0(dragScope, floatRef, (Animatable) obj2);
                    }
                }, this) == coroutine_suspended) {
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

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(48.0f);
        SliderHeight = fM9114constructorimpl;
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(144.0f);
        SliderMinWidth = fM9114constructorimpl2;
        DefaultSliderConstraints = SizeKt.m2071heightInVpY3zN4$default(SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, fM9114constructorimpl2, 0.0f, 2, null), 0.0f, fM9114constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }

    private static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float f, Composer composer, final int i) {
        int i2;
        float f2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-743965752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CorrectValueSideEffect)N(scaleToOffset,valueRange,trackRange,valueState,value)928@38204L300,928@38193L311:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            f2 = f;
            i2 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, i2, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:927)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1986508652, "CC(remember):Slider.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 14) == 4) | ((57344 & i2) == 16384) | ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i3 = 0;
                final float f3 = f2;
                Function0 function0 = new Function0() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SliderKt.CorrectValueSideEffect$lambda$0$0(closedFloatingPointRange, function1, f3, mutableState, closedFloatingPointRange2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function0);
                objRememberedValue = function0;
            } else {
                i3 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.CorrectValueSideEffect$lambda$1(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit CorrectValueSideEffect$lambda$0$0(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, float f, MutableState mutableState, ClosedFloatingPointRange closedFloatingPointRange2) {
        float fFloatValue = (((Number) closedFloatingPointRange.getEndInclusive()).floatValue() - ((Number) closedFloatingPointRange.getStart()).floatValue()) / 1000.0f;
        float fFloatValue2 = ((Number) function1.invoke(Float.valueOf(f))).floatValue();
        if (Math.abs(fFloatValue2 - ((Number) mutableState.getValue()).floatValue()) > fFloatValue && closedFloatingPointRange2.contains((Comparable) mutableState.getValue())) {
            mutableState.setValue(Float.valueOf(fFloatValue2));
        }
        return Unit.INSTANCE;
    }

    static final Unit CorrectValueSideEffect$lambda$1(Function1 function1, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2, MutableState mutableState, float f, int i, Composer composer, int i2) {
        CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i6;
        int i7;
        int i8;
        Function0<Unit> function02;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final Function0<Unit> function03;
        final int i9;
        final SliderColors sliderColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        boolean z4;
        Composer composer3;
        int i10;
        final SliderColors sliderColorsM3136colorsq0g_0yA;
        final int i11;
        final Function0<Unit> function04;
        final boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors)405@18059L39,406@18156L39,409@18277L35,410@18337L47,417@18596L5354,412@18390L5560:Slider.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i12 = i3 & 4;
        if (i12 != 0) {
            i4 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        int i13 = composerStartRestartGroup.changed(closedFloatingPointRange3) ? 16384 : 8192;
                        i4 |= i13;
                    } else {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                    }
                    i4 |= i13;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i6 = i3 & 32;
                if (i6 == 0) {
                    if ((196608 & i2) == 0) {
                        i7 = i;
                        i4 |= composerStartRestartGroup.changed(i7) ? 131072 : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        function02 = function0;
                    } else {
                        function02 = function0;
                        if ((i2 & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 12582912) == 0) {
                        i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 8388608 : 4194304;
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        closedFloatingPointRange4 = closedFloatingPointRange3;
                        function03 = function02;
                        i9 = i7;
                        sliderColors2 = sliderColors;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "403@17986L8");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                            }
                            int i14 = i6 != 0 ? 0 : i7;
                            Function0<Unit> function05 = i8 != 0 ? null : function02;
                            if ((i3 & 128) != 0) {
                                z4 = true;
                                i10 = 131072;
                                composer3 = composerStartRestartGroup;
                                i4 &= -29360129;
                                i11 = i14;
                                function04 = function05;
                                z5 = z2;
                                sliderColorsM3136colorsq0g_0yA = SliderDefaults.INSTANCE.m3136colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                            } else {
                                z4 = true;
                                composer3 = composerStartRestartGroup;
                                i10 = 131072;
                                sliderColorsM3136colorsq0g_0yA = sliderColors;
                                closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                                i11 = i14;
                                function04 = function05;
                                z5 = z2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            sliderColorsM3136colorsq0g_0yA = sliderColors;
                            z5 = z2;
                            z4 = true;
                            function04 = function02;
                            i11 = i7;
                            composer3 = composerStartRestartGroup;
                            i10 = 131072;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1556183027, i4, -1, "androidx.compose.material.RangeSlider (Slider.kt:404)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -843255532, "CC(remember):Slider.kt#9igjgp");
                        Object objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -843252428, "CC(remember):Slider.kt#9igjgp");
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        final MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (i11 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer3, (i4 >> 3) & 14);
                        ComposerKt.sourceInformationMarkerStart(composer3, -843246628, "CC(remember):Slider.kt#9igjgp");
                        boolean z6 = (458752 & i4) == i10 ? z4 : false;
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = stepsToTickFractions(i11);
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        final List list = (List) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                        float f = ThumbRadius;
                        Composer composer4 = composer3;
                        final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRange3;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m2079requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, Dp.m9114constructorimpl(4.0f * f), Dp.m9114constructorimpl(f * 2.0f), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.rememberComposableLambda(652589923, z4, new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SliderKt.RangeSlider$lambda$4(closedFloatingPointRange5, closedFloatingPointRange, list, function04, stateRememberUpdatedState, mutableInteractionSource, mutableInteractionSource2, z5, i11, sliderColorsM3136colorsq0g_0yA, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer4, 54), composer4, 3072, 6);
                        composer2 = composer4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        closedFloatingPointRange4 = closedFloatingPointRange5;
                        function03 = function04;
                        z3 = z5;
                        i9 = i11;
                        sliderColors2 = sliderColorsM3136colorsq0g_0yA;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderKt.RangeSlider$lambda$5(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i9, function03, sliderColors2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 == 0) {
            }
            i7 = i;
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 == 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 4793491) == 4793490, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit RangeSlider$lambda$4(ClosedFloatingPointRange closedFloatingPointRange, final ClosedFloatingPointRange closedFloatingPointRange2, final List list, final Function0 function0, final State state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i, SliderColors sliderColors, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i2) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i3;
        final Ref.FloatRef floatRef;
        Object obj;
        final Ref.FloatRef floatRef2;
        MutableFloatState mutableFloatState;
        MutableFloatState mutableFloatState2;
        final MutableFloatState mutableFloatState3;
        final MutableFloatState mutableFloatState4;
        Ref.FloatRef floatRef3;
        final State state2;
        final ClosedFloatingPointRange closedFloatingPointRange3 = closedFloatingPointRange;
        ComposerKt.sourceInformation(composer, "C418@18639L7,423@18800L7,434@19228L60,435@19316L67,438@19429L15,437@19393L165,445@19603L15,444@19567L170,452@19759L24,454@19867L1029,454@19827L1069,480@20978L985,480@20931L1032,525@23062L63,534@23393L65,540@23603L341:Slider.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i3 = i2 | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i3 = i2;
        }
        if (composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652589923, i3, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:418)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z2 = objConsume == LayoutDirection.Rtl;
            float fM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk());
            Ref.FloatRef floatRef4 = new Ref.FloatRef();
            Ref.FloatRef floatRef5 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume2;
            float f = ThumbRadius;
            floatRef4.element = fM9067getMaxWidthimpl - density.mo1624toPx0680j_4(f);
            floatRef5.element = density.mo1624toPx0680j_4(f);
            ComposerKt.sourceInformationMarkerStart(composer, 73711071, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange3, floatRef5, floatRef4, ((Number) closedFloatingPointRange2.getStart()).floatValue()));
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableFloatState mutableFloatState5 = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 73713894, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange3, floatRef5, floatRef4, ((Number) closedFloatingPointRange2.getEndInclusive()).floatValue()));
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableFloatState mutableFloatState6 = (MutableFloatState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 73717458, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composer.changed(closedFloatingPointRange3) | composer.changed(floatRef5.element) | composer.changed(floatRef4.element);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (KFunction) new SliderKt$RangeSlider$2$2$1(closedFloatingPointRange3, floatRef5, floatRef4);
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CorrectValueSideEffect((Function1) ((KFunction) objRememberedValue3), closedFloatingPointRange3, RangesKt.rangeTo(floatRef5.element, floatRef4.element), mutableFloatState5, ((Number) closedFloatingPointRange2.getStart()).floatValue(), composer, 3072);
            ComposerKt.sourceInformationMarkerStart(composer, 73723026, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composer.changed(closedFloatingPointRange3) | composer.changed(floatRef5.element) | composer.changed(floatRef4.element);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (KFunction) new SliderKt$RangeSlider$2$3$1(closedFloatingPointRange3, floatRef5, floatRef4);
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CorrectValueSideEffect((Function1) ((KFunction) objRememberedValue4), closedFloatingPointRange3, RangesKt.rangeTo(floatRef5.element, floatRef4.element), mutableFloatState6, ((Number) closedFloatingPointRange2.getEndInclusive()).floatValue(), composer, 3072);
            boolean z3 = z2;
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue5);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 73732488, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list) | composer.changed(floatRef5.element) | composer.changed(floatRef4.element) | composer.changed(function0) | composer.changedInstance(coroutineScope) | composer.changed(state) | composer.changed(closedFloatingPointRange3);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                floatRef = floatRef4;
                floatRef2 = floatRef5;
                obj = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.RangeSlider$lambda$4$5$0(mutableFloatState5, mutableFloatState6, list, floatRef2, floatRef, function0, coroutineScope, state, closedFloatingPointRange3, ((Boolean) obj2).booleanValue());
                    }
                };
                mutableFloatState = mutableFloatState6;
                mutableFloatState2 = mutableFloatState5;
                closedFloatingPointRange3 = closedFloatingPointRange3;
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue6;
                floatRef = floatRef4;
                floatRef2 = floatRef5;
                mutableFloatState2 = mutableFloatState5;
                mutableFloatState = mutableFloatState6;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function1) obj, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 73767996, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged3 = composer.changed(closedFloatingPointRange3) | composer.changed(floatRef2.element) | composer.changed(floatRef.element) | composer.changed(closedFloatingPointRange2) | composer.changed(state);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                final ClosedFloatingPointRange closedFloatingPointRange4 = closedFloatingPointRange3;
                mutableFloatState3 = mutableFloatState2;
                mutableFloatState4 = mutableFloatState;
                Object obj2 = new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return SliderKt.RangeSlider$lambda$4$6$0(mutableFloatState3, mutableFloatState4, closedFloatingPointRange2, floatRef2, floatRef, state, closedFloatingPointRange4, ((Boolean) obj3).booleanValue(), ((Float) obj4).floatValue());
                    }
                };
                floatRef3 = floatRef;
                state2 = state;
                composer.updateRememberedValue(obj2);
                objRememberedValue7 = obj2;
            } else {
                mutableFloatState3 = mutableFloatState2;
                mutableFloatState4 = mutableFloatState;
                floatRef3 = floatRef;
                state2 = state;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Ref.FloatRef floatRef6 = floatRef2;
            Modifier modifierRangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.INSTANCE, mutableInteractionSource, mutableInteractionSource2, mutableFloatState3, mutableFloatState4, z, z3, fM9067getMaxWidthimpl, closedFloatingPointRange, stateRememberUpdatedState, SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue7, composer, 0));
            final float fCoerceIn = RangesKt.coerceIn(((Number) closedFloatingPointRange2.getStart()).floatValue(), ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange2.getEndInclusive()).floatValue());
            final float fCoerceIn2 = RangesKt.coerceIn(((Number) closedFloatingPointRange2.getEndInclusive()).floatValue(), ((Number) closedFloatingPointRange2.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
            float fCalcFraction = calcFraction(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), fCoerceIn);
            float fCalcFraction2 = calcFraction(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), fCoerceIn2);
            float f2 = i;
            int iFloor = (int) Math.floor(f2 * fCalcFraction2);
            int iFloor2 = (int) Math.floor(f2 * (1.0f - fCalcFraction));
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 73833762, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged4 = composer.changed(state2) | composer.changed(fCoerceIn2);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SliderKt.RangeSlider$lambda$4$7$0(state2, fCoerceIn2, ((Float) obj3).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSliderSemantics = sliderSemantics(companion, fCoerceIn, z, (Function1) objRememberedValue8, function0, RangesKt.rangeTo(((Number) closedFloatingPointRange.getStart()).floatValue(), fCoerceIn2), iFloor);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 73844356, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged5 = composer.changed(state2) | composer.changed(fCoerceIn);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SliderKt.RangeSlider$lambda$4$8$0(state2, fCoerceIn, ((Float) obj3).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RangeSliderImpl(z, fCalcFraction, fCalcFraction2, list, sliderColors, floatRef3.element - floatRef6.element, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, sliderSemantics(companion2, fCoerceIn2, z, (Function1) objRememberedValue9, function0, RangesKt.rangeTo(fCoerceIn, ((Number) closedFloatingPointRange.getEndInclusive()).floatValue()), iFloor2), composer, 14155776, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$4$5$0(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, List list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Function0 function0, CoroutineScope coroutineScope, State state, ClosedFloatingPointRange closedFloatingPointRange, boolean z) {
        float floatValue = (z ? mutableFloatState : mutableFloatState2).getFloatValue();
        float fSnapValueToTick = snapValueToTick(floatValue, list, floatRef.element, floatRef2.element);
        if (floatValue != fSnapValueToTick) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SliderKt$RangeSlider$2$gestureEndAction$1$1$1(floatValue, fSnapValueToTick, function0, z, mutableFloatState, mutableFloatState2, state, floatRef, floatRef2, closedFloatingPointRange, null), 3, null);
            return Unit.INSTANCE;
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit RangeSlider$lambda$4$6$0(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State state, ClosedFloatingPointRange closedFloatingPointRange2, boolean z, float f) {
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        if (z) {
            mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + f);
            mutableFloatState2.setFloatValue(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange2, floatRef, floatRef2, ((Number) closedFloatingPointRange.getEndInclusive()).floatValue()));
            float floatValue = mutableFloatState2.getFloatValue();
            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(RangesKt.coerceIn(mutableFloatState.getFloatValue(), floatRef.element, floatValue), floatValue);
        } else {
            mutableFloatState2.setFloatValue(mutableFloatState2.getFloatValue() + f);
            mutableFloatState.setFloatValue(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange2, floatRef, floatRef2, ((Number) closedFloatingPointRange.getStart()).floatValue()));
            float floatValue2 = mutableFloatState.getFloatValue();
            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(floatValue2, RangesKt.coerceIn(mutableFloatState2.getFloatValue(), floatValue2, floatRef2.element));
        }
        ((Function1) state.getValue()).invoke(RangeSlider$lambda$4$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange2, closedFloatingPointRangeRangeTo));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$4$7$0(State state, float f, float f2) {
        ((Function1) state.getValue()).invoke(RangesKt.rangeTo(f2, f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$4$8$0(State state, float f, float f2) {
        ((Function1) state.getValue()).invoke(RangesKt.rangeTo(f, f2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSlider$lambda$4$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> RangeSlider$lambda$4$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return scale(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    static final Unit RangeSlider$lambda$5(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, int i, Function0 function0, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, i, function0, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final void RangeSliderImpl(final boolean z, final float f, final float f2, final List<Float> list, final SliderColors sliderColors, final float f3, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Modifier modifier, final Modifier modifier2, Modifier modifier3, Composer composer, final int i, final int i2) {
        int i3;
        List<Float> list2;
        SliderColors sliderColors2;
        int i4;
        final Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-278895713);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSliderImpl)N(enabled,positionFractionStart,positionFractionEnd,tickFractions,colors,width,startInteractionSource,endInteractionSource,modifier,startThumbSemantics,endThumbSemantics)726@30939L35,727@31007L33,728@31045L1529:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            list2 = list;
            i3 |= composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
        } else {
            list2 = list;
        }
        if ((i & 24576) == 0) {
            sliderColors2 = sliderColors;
            i3 |= composerStartRestartGroup.changed(sliderColors2) ? 16384 : 8192;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(modifier3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-278895713, i3, i4, "androidx.compose.material.RangeSliderImpl (Slider.kt:724)");
            }
            final String strM3171getString4foXLRw = Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3169getSliderRangeStartUdPEhr4(), composerStartRestartGroup, 6);
            final String strM3171getString4foXLRw2 = Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3168getSliderRangeEndUdPEhr4(), composerStartRestartGroup, 6);
            Modifier modifierThen = modifier.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2114792334, "C732@31205L7,741@31513L268,753@31860L84,752@31791L389,765@32258L82,764@32189L379:Slider.kt#jmzs0o");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            float fMo1624toPx0680j_4 = density.mo1624toPx0680j_4(TrackHeight);
            float f4 = ThumbRadius;
            float fMo1624toPx0680j_42 = density.mo1624toPx0680j_4(f4);
            float fMo1620toDpu2uoSUM = density.mo1620toDpu2uoSUM(f3);
            float fM9114constructorimpl = Dp.m9114constructorimpl(f4 * 2.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(fMo1620toDpu2uoSUM * f);
            float fM9114constructorimpl3 = Dp.m9114constructorimpl(fMo1620toDpu2uoSUM * f2);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), 0.0f, 1, null);
            int i5 = i3 >> 9;
            int i6 = i3 << 6;
            int i7 = i3;
            Track(modifierFillMaxSize$default, sliderColors2, z, f, f2, list2, fMo1624toPx0680j_42, fMo1624toPx0680j_4, composerStartRestartGroup, (i6 & 458752) | (i6 & 896) | (i5 & 112) | (i6 & 7168) | (i6 & 57344));
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1730810029, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM3171getString4foXLRw);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$0$1$0(strM3171getString4foXLRw, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i8 = i7 & 57344;
            int i9 = (i7 << 15) & 458752;
            m3145SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue), true, mutableInteractionSource).then(modifier2), fM9114constructorimpl2, mutableInteractionSource, sliderColors, z, fM9114constructorimpl, composerStartRestartGroup, (i5 & 7168) | 1572870 | i8 | i9);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1730822763, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM3171getString4foXLRw2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$0$2$0(strM3171getString4foXLRw2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifier4 = modifier3;
            m3145SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), true, mutableInteractionSource2).then(modifier4), fM9114constructorimpl3, mutableInteractionSource2, sliderColors, z, fM9114constructorimpl, composerStartRestartGroup, ((i7 >> 12) & 7168) | 1572870 | i8 | i9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modifier4 = modifier3;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.RangeSliderImpl$lambda$1(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$0$1$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$0$2$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$1(boolean z, float f, float f2, List list, SliderColors sliderColors, float f3, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i, int i2, Composer composer, int i3) {
        RangeSliderImpl(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final Function0<Unit> function02;
        final Modifier modifier3;
        final boolean z3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final int i11;
        final MutableInteractionSource mutableInteractionSource2;
        final SliderColors sliderColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function03;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        boolean z4;
        int i12;
        final SliderColors sliderColorsM3136colorsq0g_0yA;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1962335196);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Slider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,interactionSource,colors)168@8088L35,169@8161L43,170@8229L47,190@8882L7,194@9014L3201,172@8282L3933:Slider.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i13 = i3 & 4;
        if (i13 != 0) {
            i4 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                        int i14 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i4 |= i14;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i4 |= i14;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        i7 = i;
                        i4 |= composerStartRestartGroup.changed(i7) ? 131072 : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                    }
                    i9 = i3 & 128;
                    if (i9 != 0) {
                        if ((i2 & 12582912) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                        }
                        if ((i2 & 100663296) == 0) {
                            i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "163@7873L8");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                }
                                int i15 = i6 != 0 ? 0 : i7;
                                function03 = i8 != 0 ? null : function0;
                                mutableInteractionSource3 = i10 == 0 ? mutableInteractionSource : null;
                                if ((i3 & 256) != 0) {
                                    z4 = true;
                                    i12 = 131072;
                                    composer3 = composerStartRestartGroup;
                                    i4 &= -234881025;
                                    i7 = i15;
                                    z5 = z2;
                                    sliderColorsM3136colorsq0g_0yA = SliderDefaults.INSTANCE.m3136colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                } else {
                                    composer3 = composerStartRestartGroup;
                                    z4 = true;
                                    i12 = 131072;
                                    sliderColorsM3136colorsq0g_0yA = sliderColors;
                                    i7 = i15;
                                    z5 = z2;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                composer3 = composerStartRestartGroup;
                                z4 = true;
                                function03 = function0;
                                mutableInteractionSource3 = mutableInteractionSource;
                                sliderColorsM3136colorsq0g_0yA = sliderColors;
                                z5 = z2;
                                i12 = 131072;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1962335196, i4, -1, "androidx.compose.material.Slider (Slider.kt:164)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composer3.startReplaceGroup(-1127489737);
                                ComposerKt.sourceInformation(composer3, "166@7968L39");
                                ComposerKt.sourceInformationMarkerStart(composer3, -313465301, "CC(remember):Slider.kt#9igjgp");
                                Object objRememberedValue = composer3.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-313465952);
                                composer3.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            if (i7 < 0) {
                                throw new IllegalArgumentException("steps should be >= 0".toString());
                            }
                            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer3, (i4 >> 3) & 14);
                            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function03, composer3, (i4 >> 18) & 14);
                            ComposerKt.sourceInformationMarkerStart(composer3, -313456941, "CC(remember):Slider.kt#9igjgp");
                            boolean z6 = (458752 & i4) == i12 ? z4 : false;
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = stepsToTickFractions(i7);
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            final List list = (List) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                            float f2 = ThumbRadius;
                            final Function0<Unit> function04 = function03;
                            final boolean z7 = z5;
                            Modifier modifierFocusable = FocusableKt.focusable(sliderSemantics(SizeKt.m2079requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, Dp.m9114constructorimpl(f2 * 2.0f), Dp.m9114constructorimpl(f2 * 2.0f), 0.0f, 0.0f, 12, null), f, z7, function1, function04, closedFloatingPointRangeRangeTo, i7), z7, mutableInteractionSource4);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            boolean z8 = objConsume == LayoutDirection.Rtl ? z4 : false;
                            final ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                            int i16 = i7;
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            Composer composer4 = composer3;
                            BoxWithConstraintsKt.BoxWithConstraints(slideOnKeyEvents(modifierFocusable, z7, i16, closedFloatingPointRange3, f, z8, stateRememberUpdatedState, stateRememberUpdatedState2), null, false, ComposableLambdaKt.rememberComposableLambda(2085116814, z4, new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return SliderKt.Slider$lambda$3(closedFloatingPointRange3, f, list, function04, mutableInteractionSource5, z7, sliderColorsM3136colorsq0g_0yA, stateRememberUpdatedState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer4, 54), composer4, 3072, 6);
                            composer2 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier3 = modifier2;
                            closedFloatingPointRange2 = closedFloatingPointRange3;
                            function02 = function04;
                            z3 = z7;
                            sliderColors2 = sliderColorsM3136colorsq0g_0yA;
                            i11 = i16;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function02 = function0;
                            modifier3 = modifier2;
                            z3 = z2;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            i11 = i7;
                            mutableInteractionSource2 = mutableInteractionSource;
                            sliderColors2 = sliderColors;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderKt.Slider$lambda$4(f, function1, modifier3, z3, closedFloatingPointRange2, i11, function02, mutableInteractionSource2, sliderColors2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 12582912;
                    i10 = i9;
                    if ((i2 & 100663296) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i2 & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit Slider$lambda$3(final ClosedFloatingPointRange closedFloatingPointRange, float f, final List list, final Function0 function0, MutableInteractionSource mutableInteractionSource, boolean z, SliderColors sliderColors, final State state, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i2;
        MutableFloatState mutableFloatState;
        Ref.FloatRef floatRef;
        final SliderDraggableState sliderDraggableState;
        Ref.FloatRef floatRef2;
        ComposerKt.sourceInformation(composer, "C195@9057L7,200@9218L7,211@9632L24,212@9681L54,213@9762L36,216@9841L420,225@10294L15,225@10271L83,228@10437L633,228@10399L671,259@11645L55,266@11999L210:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085116814, i2, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:195)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z2 = objConsume == LayoutDirection.Rtl;
            float fM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk());
            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
            final Ref.FloatRef floatRef4 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume2;
            float f2 = ThumbRadius;
            floatRef3.element = Math.max(fM9067getMaxWidthimpl - density.mo1624toPx0680j_4(f2), 0.0f);
            floatRef4.element = Math.min(density.mo1624toPx0680j_4(f2), floatRef3.element);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952447580, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Slider$lambda$3$scaleToOffset(closedFloatingPointRange, floatRef4, floatRef3, f));
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952445006, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final MutableFloatState mutableFloatState3 = (MutableFloatState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952442094, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composer.changed(floatRef4.element) | composer.changed(floatRef3.element) | composer.changed(closedFloatingPointRange);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.Slider$lambda$3$3$0(mutableFloatState2, mutableFloatState3, floatRef4, floatRef3, state, closedFloatingPointRange, ((Float) obj).floatValue());
                    }
                };
                mutableFloatState = mutableFloatState3;
                floatRef = floatRef3;
                floatRef4 = floatRef4;
                Object sliderDraggableState2 = new SliderDraggableState(function1);
                composer.updateRememberedValue(sliderDraggableState2);
                objRememberedValue4 = sliderDraggableState2;
            } else {
                mutableFloatState = mutableFloatState3;
                floatRef = floatRef3;
            }
            SliderDraggableState sliderDraggableState3 = (SliderDraggableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952428003, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composer.changed(closedFloatingPointRange) | composer.changed(floatRef4.element) | composer.changed(floatRef.element);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (KFunction) new SliderKt$Slider$2$2$1(closedFloatingPointRange, floatRef4, floatRef);
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final Ref.FloatRef floatRef5 = floatRef4;
            CorrectValueSideEffect((Function1) ((KFunction) objRememberedValue5), closedFloatingPointRange, RangesKt.rangeTo(floatRef4.element, floatRef.element), mutableFloatState2, f, composer, 3072);
            ComposerKt.sourceInformationMarkerStart(composer, -1952422809, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list) | composer.changed(floatRef5.element) | composer.changed(floatRef.element) | composer.changedInstance(coroutineScope) | composer.changedInstance(sliderDraggableState3) | composer.changed(function0);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                final Ref.FloatRef floatRef6 = floatRef;
                sliderDraggableState = sliderDraggableState3;
                Object obj = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.Slider$lambda$3$5$0(mutableFloatState2, list, floatRef5, floatRef6, coroutineScope, sliderDraggableState, function0, ((Float) obj2).floatValue());
                    }
                };
                floatRef2 = floatRef6;
                composer.updateRememberedValue(obj);
                objRememberedValue6 = obj;
            } else {
                sliderDraggableState = sliderDraggableState3;
                floatRef2 = floatRef;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function1) objRememberedValue6, composer, 0);
            SliderDraggableState sliderDraggableState4 = sliderDraggableState;
            Modifier modifierSliderTapModifier = sliderTapModifier(Modifier.INSTANCE, sliderDraggableState4, mutableInteractionSource, fM9067getMaxWidthimpl, z2, mutableFloatState2, stateRememberUpdatedState, mutableFloatState, z);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = sliderDraggableState.isDragging();
            Modifier.Companion companion2 = companion;
            ComposerKt.sourceInformationMarkerStart(composer, -1952384731, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged3 = composer.changed(stateRememberUpdatedState);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = (Function3) new SliderKt$Slider$2$drag$1$1(stateRememberUpdatedState, null);
                composer.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SliderImpl(z, calcFraction(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue())), list, sliderColors, floatRef2.element - floatRef5.element, mutableInteractionSource, modifierSliderTapModifier.then(DraggableKt.draggable$default(companion2, sliderDraggableState4, orientation, z, mutableInteractionSource, zIsDragging, null, (Function3) objRememberedValue7, z2, 32, null)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$3$3$0(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State state, ClosedFloatingPointRange closedFloatingPointRange, float f) {
        mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + f + mutableFloatState2.getFloatValue());
        mutableFloatState2.setFloatValue(0.0f);
        ((Function1) state.getValue()).invoke(Float.valueOf(Slider$lambda$3$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.coerceIn(mutableFloatState.getFloatValue(), floatRef.element, floatRef2.element))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$3$5$0(MutableFloatState mutableFloatState, List list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, CoroutineScope coroutineScope, SliderDraggableState sliderDraggableState, Function0 function0, float f) {
        float floatValue = mutableFloatState.getFloatValue();
        float fSnapValueToTick = snapValueToTick(floatValue, list, floatRef.element, floatRef2.element);
        if (floatValue != fSnapValueToTick) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SliderKt$Slider$2$gestureEndAction$1$1$1(sliderDraggableState, floatValue, fSnapValueToTick, f, function0, null), 3, null);
        } else if (!sliderDraggableState.isDragging() && function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Slider$lambda$3$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
    }

    private static final float Slider$lambda$3$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f) {
        return scale(floatRef.element, floatRef2.element, f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    static final Unit Slider$lambda$4(float f, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange, int i, Function0 function0, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        Slider(f, function1, modifier, z, closedFloatingPointRange, i, function0, mutableInteractionSource, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final void SliderImpl(final boolean z, final float f, final List<Float> list, final SliderColors sliderColors, final float f2, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int i) {
        int i2;
        SliderColors sliderColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1679682785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderImpl)N(enabled,positionFraction,tickFractions,colors,width,interactionSource,modifier)684@29780L713:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            sliderColors2 = sliderColors;
            i2 |= composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        int i3 = i2;
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1679682785, i3, -1, "androidx.compose.material.SliderImpl (Slider.kt:683)");
            }
            Modifier modifierThen = modifier.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2014920892, "C688@29940L7,697@30185L217,707@30411L76:Slider.kt#jmzs0o");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            float fMo1624toPx0680j_4 = density.mo1624toPx0680j_4(TrackHeight);
            float f3 = ThumbRadius;
            float fMo1624toPx0680j_42 = density.mo1624toPx0680j_4(f3);
            float fMo1620toDpu2uoSUM = density.mo1620toDpu2uoSUM(f2);
            float fM9114constructorimpl = Dp.m9114constructorimpl(f3 * 2.0f);
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(fMo1620toDpu2uoSUM * f);
            int i4 = i3 >> 6;
            int i5 = i3 << 9;
            Track(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), sliderColors2, z, 0.0f, f, list, fMo1624toPx0680j_42, fMo1624toPx0680j_4, composerStartRestartGroup, (i5 & 458752) | (i4 & 112) | 3078 | ((i3 << 6) & 896) | (i5 & 57344));
            m3145SliderThumbPcYyNuk(boxScopeInstance, Modifier.INSTANCE, fM9114constructorimpl2, mutableInteractionSource, sliderColors, z, fM9114constructorimpl, composerStartRestartGroup, (i4 & 7168) | 1572918 | ((i3 << 3) & 57344) | ((i3 << 15) & 458752));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderImpl$lambda$1(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SliderImpl$lambda$1(boolean z, float f, List list, SliderColors sliderColors, float f2, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i, Composer composer, int i2) {
        SliderImpl(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to inline method: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX WARN: Not passed register '(r4v7 'fM9114constructorimpl' float)' in method call: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    private static final void m3145SliderThumbPcYyNuk(final BoxScope boxScope, final Modifier modifier, final float f, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z, final float f2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(428907178);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderThumb)N(modifier,offset:c#ui.unit.Dp,interactionSource,colors,enabled,thumbSize:c#ui.unit.Dp)788@32788L1539:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(428907178, i2, -1, "androidx.compose.material.SliderThumb (Slider.kt:787)");
            }
            Modifier modifierAlign = boxScope.align(PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, f, 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -264746013, "C789@32884L46,790@32973L658,790@32939L692,818@34272L19,809@33821L500:Slider.kt#jmzs0o");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2086750978, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2086747518, "CC(remember):Slider.kt#9igjgp");
            boolean z2 = (i2 & 7168) == 2048;
            SliderKt$SliderThumb$1$1$1 sliderKt$SliderThumb$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || sliderKt$SliderThumb$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$SliderThumb$1$1$1RememberedValue = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(sliderKt$SliderThumb$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 >> 9;
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) sliderKt$SliderThumb$1$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
            float fM9114constructorimpl = !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation;
            Modifier modifierHoverable$default = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m2085sizeVpY3zN4(modifier, f2, f2), mutableInteractionSource, RippleKt.m3125rippleH2RKhps$default(false, ThumbRippleRadius, 0L, 4, null)), mutableInteractionSource, false, 2, null);
            if (!z) {
                fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
            }
            SpacerKt.Spacer(BackgroundKt.m1482backgroundbw27NRU(ShadowKt.m5923shadows4CzXII$default(modifierHoverable$default, fM9114constructorimpl, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), sliderColors.thumbColor(z, composerStartRestartGroup, ((i2 >> 15) & 14) | (i3 & 112)).getValue().m6335unboximpl(), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderThumb_PcYyNuk$lambda$1(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SliderThumb_PcYyNuk$lambda$1(BoxScope boxScope, Modifier modifier, float f, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z, float f2, int i, Composer composer, int i2) {
        m3145SliderThumbPcYyNuk(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void Track(final Modifier modifier, final SliderColors sliderColors, final boolean z, final float f, final float f2, final List<Float> list, final float f3, final float f4, Composer composer, final int i) {
        int i2;
        float f5;
        float f6;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1833126050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(modifier,colors,enabled,positionFractionStart,positionFractionEnd,tickFractions,thumbPx,trackStrokeWidth)834@34621L35,835@34691L34,836@34761L34,837@34829L33,838@34884L1463,838@34867L1480:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            f5 = f2;
            i2 |= composerStartRestartGroup.changed(f5) ? 16384 : 8192;
        } else {
            f5 = f2;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            f6 = f3;
            i2 |= composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
        } else {
            f6 = f3;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 4793491) != 4793490, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833126050, i2, -1, "androidx.compose.material.Track (Slider.kt:833)");
            }
            int i4 = ((i2 >> 6) & 14) | 48 | ((i2 << 3) & 896);
            final State<Color> stateTrackColor = sliderColors.trackColor(z, false, composerStartRestartGroup, i4);
            final State<Color> stateTrackColor2 = sliderColors.trackColor(z, true, composerStartRestartGroup, i4);
            final State<Color> stateTickColor = sliderColors.tickColor(z, false, composerStartRestartGroup, i4);
            final State<Color> stateTickColor2 = sliderColors.tickColor(z, true, composerStartRestartGroup, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 697561209, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = ((29360128 & i2) == 8388608) | ((3670016 & i2) == 1048576) | composerStartRestartGroup.changed(stateTrackColor) | ((57344 & i2) == 16384) | ((i2 & 7168) == 2048) | composerStartRestartGroup.changed(stateTrackColor2) | composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(stateTickColor) | composerStartRestartGroup.changed(stateTickColor2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i3 = i2;
                final float f7 = f6;
                final float f8 = f5;
                Object obj = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.Track$lambda$0$0(f7, stateTrackColor, f4, f8, f, stateTrackColor2, list, stateTickColor, stateTickColor2, (DrawScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
                objRememberedValue = obj;
            } else {
                i3 = i2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SliderKt.Track$lambda$1(modifier, sliderColors, z, f, f2, list, f3, f4, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$0$0(float f, State state, float f2, float f3, float f4, State state2, List list, State state3, State state4, DrawScope drawScope) {
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long jMo6898getCenterF1C5BW0 = drawScope.mo6898getCenterF1C5BW0();
        long j = MuxerUtil.UNSIGNED_INT_MAX_VALUE;
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo6898getCenterF1C5BW0 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - f;
        long jM6072constructorimpl2 = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
        long j2 = z ? jM6072constructorimpl2 : jM6072constructorimpl;
        long j3 = z ? jM6072constructorimpl : jM6072constructorimpl2;
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, ((Color) state.getValue()).m6335unboximpl(), j2, j3, f2, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        long j4 = j3;
        int i = (int) (j2 >> 32);
        int i2 = (int) (j4 >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * f3);
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, ((Color) state2.getValue()).m6335unboximpl(), Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * f4))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32)), f2, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            float fFloatValue = ((Number) obj).floatValue();
            Boolean boolValueOf = Boolean.valueOf(fFloatValue > f3 || fFloatValue < f4);
            Object obj2 = linkedHashMap.get(boolValueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(boolValueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list2 = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list2.size());
            int size = list2.size();
            int i3 = 0;
            while (i3 < size) {
                ArrayList arrayList2 = arrayList;
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (OffsetKt.m6103lerpWko1d7g(j2, j4, ((Number) list2.get(i3)).floatValue()) >> 32));
                long j5 = j;
                arrayList.add(Offset.m6069boximpl(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & j5)))) & j5) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32))));
                i3++;
                arrayList = arrayList2;
                j = j5;
            }
            long j6 = j;
            DrawScope.m6890drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m6645getPointsr_lszbg(), ((Color) (zBooleanValue ? state3 : state4).getValue()).m6335unboximpl(), f2, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            j = j6;
        }
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$1(Modifier modifier, SliderColors sliderColors, boolean z, float f, float f2, List list, float f3, float f4, int i, Composer composer, int i2) {
        Track(modifier, sliderColors, z, f, f2, list, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f2, float f3, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(draggableState, null, new AnonymousClass2(f, f2, f3, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m3147awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
            }
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
        Object obj = sliderKt$awaitSlop$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = sliderKt$awaitSlop$12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Function2 function2 = new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SliderKt.awaitSlop_8vUncbI$lambda$0(floatRef2, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            };
            sliderKt$awaitSlop$12.L$0 = floatRef2;
            sliderKt$awaitSlop$12.label = 1;
            Object objM3017awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m3017awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
            if (objM3017awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objM3017awaitHorizontalPointerSlopOrCancellationgDDlDlE;
            floatRef = floatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) sliderKt$awaitSlop$12.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
            return TuplesKt.to(pointerInputChange, Boxing.boxFloat(floatRef.element));
        }
        return null;
    }

    static final Unit awaitSlop_8vUncbI$lambda$0(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
        pointerInputChange.consume();
        floatRef.element = f;
        return Unit.INSTANCE;
    }

    private static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        float f5 = f4 == 0.0f ? 0.0f : (f3 - f) / f4;
        float f6 = f5 >= 0.0f ? f5 : 0.0f;
        if (f6 > 1.0f) {
            return 1.0f;
        }
        return f6;
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final State<Float> state, final State<Float> state2, boolean z, final boolean z2, final float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, final State<? extends Function1<? super Boolean, Unit>> state3, final State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), closedFloatingPointRange}, new PointerInputEventHandler() { // from class: androidx.compose.material.SliderKt.rangeSliderPressDragModifier.1

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {1081}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {1082, 1093, 1115}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", NotificationCompat.CATEGORY_EVENT, "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"}, v = 1)
                static final class C00591 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ State<Float> $rawOffsetEnd;
                    final /* synthetic */ State<Float> $rawOffsetStart;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {1133}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Ref.BooleanRef $draggingStart;
                        final /* synthetic */ DragInteraction $finishInteraction;
                        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$rangeSliderLogic = rangeSliderLogic;
                            this.$draggingStart = booleanRef;
                            this.$finishInteraction = dragInteraction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
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

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C00591(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00591> continuation) {
                        super(2, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$rawOffsetStart = state;
                        this.$$this$coroutineScope = coroutineScope;
                        this.$gestureEndAction = state2;
                        this.$rawOffsetEnd = state3;
                        this.$onDrag = state4;
                    }

                    static final Unit invokeSuspend$lambda$1(State state, Ref.BooleanRef booleanRef, boolean z, PointerInputChange pointerInputChange) {
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32));
                        Function2 function2 = (Function2) state.getValue();
                        Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                        if (z) {
                            fIntBitsToFloat = -fIntBitsToFloat;
                        }
                        function2.invoke(boolValueOf, Float.valueOf(fIntBitsToFloat));
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00591 c00591 = new C00591(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                        c00591.L$0 = obj;
                        return c00591;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00591) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x018c  */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x0196 A[Catch: CancellationException -> 0x01a8, TryCatch #0 {CancellationException -> 0x01a8, blocks: (B:8:0x001e, B:55:0x018e, B:57:0x0196, B:58:0x019e), top: B:65:0x001e }] */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x019e A[Catch: CancellationException -> 0x01a8, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x01a8, blocks: (B:8:0x001e, B:55:0x018e, B:57:0x0196, B:58:0x019e), top: B:65:0x001e }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        Object objAwaitFirstDown$default;
                        AwaitPointerEventScope awaitPointerEventScope;
                        PointerInputChange pointerInputChange;
                        char c;
                        Object objM3147awaitSlop8vUncbI;
                        Ref.FloatRef floatRef;
                        DragInteraction.Start start;
                        final Ref.BooleanRef booleanRef;
                        Pair pair;
                        Ref.BooleanRef booleanRef2;
                        DragInteraction.Start start2;
                        Object objM1693horizontalDragjO51t88;
                        DragInteraction.Cancel cancel;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope2;
                            this.label = 1;
                            objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                            if (objAwaitFirstDown$default != coroutine_suspended) {
                                awaitPointerEventScope = awaitPointerEventScope2;
                            }
                            return coroutine_suspended;
                        }
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                booleanRef2 = (Ref.BooleanRef) this.L$1;
                                start2 = (DragInteraction.Start) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objM1693horizontalDragjO51t88 = obj;
                                    cancel = !((Boolean) objM1693horizontalDragjO51t88).booleanValue() ? new DragInteraction.Stop(start2) : new DragInteraction.Cancel(start2);
                                } catch (CancellationException unused) {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            booleanRef = (Ref.BooleanRef) this.L$4;
                            Ref.FloatRef floatRef2 = (Ref.FloatRef) this.L$3;
                            start = (DragInteraction.Start) this.L$2;
                            pointerInputChange = (PointerInputChange) this.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            c = ' ';
                            floatRef = floatRef2;
                            objM3147awaitSlop8vUncbI = obj;
                            pair = (Pair) objM3147awaitSlop8vUncbI;
                            if (pair != null) {
                                State<Float> state = this.$rawOffsetEnd;
                                State<Float> state2 = this.$rawOffsetStart;
                                boolean z = this.$isRtl;
                                float fM3020pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m3020pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
                                if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM3020pointerSlopE8SPZFQ && Math.abs(state2.getValue().floatValue() - floatRef.element) < fM3020pointerSlopE8SPZFQ) {
                                    float fFloatValue = ((Number) pair.getSecond()).floatValue();
                                    booleanRef.element = !z ? fFloatValue >= 0.0f : fFloatValue < 0.0f;
                                    floatRef.element += Float.intBitsToFloat((int) (PointerEventKt.positionChange((PointerInputChange) pair.getFirst()) >> c));
                                }
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            try {
                                long id = pointerInputChange.getId();
                                final State<Function2<Boolean, Float, Unit>> state3 = this.$onDrag;
                                final boolean z2 = this.$isRtl;
                                this.L$0 = start;
                                this.L$1 = booleanRef;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 3;
                                objM1693horizontalDragjO51t88 = DragGestureDetectorKt.m1693horizontalDragjO51t88(awaitPointerEventScope, id, new Function1() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return SliderKt.AnonymousClass1.C00581.C00591.invokeSuspend$lambda$1(state3, booleanRef, z2, (PointerInputChange) obj2);
                                    }
                                }, this);
                            } catch (CancellationException unused2) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                cancel = new DragInteraction.Cancel(start2);
                            }
                            if (objM1693horizontalDragjO51t88 != coroutine_suspended) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                if (!((Boolean) objM1693horizontalDragjO51t88).booleanValue()) {
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = awaitPointerEventScope3;
                        objAwaitFirstDown$default = obj;
                        pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                        DragInteraction.Start start3 = new DragInteraction.Start();
                        Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        floatRef3.element = this.$isRtl ? this.$maxPx - Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) : Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32));
                        int iCompareOffsets = this.$rangeSliderLogic.compareOffsets(floatRef3.element);
                        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                        booleanRef3.element = iCompareOffsets == 0 ? this.$rawOffsetStart.getValue().floatValue() > floatRef3.element : iCompareOffsets < 0;
                        c = ' ';
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerInputChange;
                        this.L$2 = start3;
                        this.L$3 = floatRef3;
                        this.L$4 = booleanRef3;
                        this.label = 2;
                        objM3147awaitSlop8vUncbI = SliderKt.m3147awaitSlop8vUncbI(awaitPointerEventScope, pointerInputChange.getId(), pointerInputChange.getType(), this);
                        if (objM3147awaitSlop8vUncbI != coroutine_suspended) {
                            floatRef = floatRef3;
                            start = start3;
                            booleanRef = booleanRef3;
                            pair = (Pair) objM3147awaitSlop8vUncbI;
                            if (pair != null) {
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            long id2 = pointerInputChange.getId();
                            final State state32 = this.$onDrag;
                            final boolean z22 = this.$isRtl;
                            this.L$0 = start;
                            this.L$1 = booleanRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 3;
                            objM1693horizontalDragjO51t88 = DragGestureDetectorKt.m1693horizontalDragjO51t88(awaitPointerEventScope, id2, new Function1() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return SliderKt.AnonymousClass1.C00581.C00591.invokeSuspend$lambda$1(state32, booleanRef, z22, (PointerInputChange) obj2);
                                }
                            }, this);
                            if (objM1693horizontalDragjO51t88 != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00581(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00581> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00581 c00581 = new C00581(this.$this_pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c00581.L$0 = obj;
                    return c00581;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00591(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00581(pointerInputScope, z2, f, new RangeSliderLogic(mutableInteractionSource, mutableInteractionSource2, state, state2, state4), state, state3, state2, state4, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    private static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    private static final ClosedFloatingPointRange<Float> scale(float f, float f2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f3, float f4) {
        return RangesKt.rangeTo(scale(f, f2, closedFloatingPointRange.getStart().floatValue(), f3, f4), scale(f, f2, closedFloatingPointRange.getEndInclusive().floatValue(), f3, f4));
    }

    private static final Modifier slideOnKeyEvents(Modifier modifier, final boolean z, final int i, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final float f, final boolean z2, final State<? extends Function1<? super Float, Unit>> state, final State<? extends Function0<Unit>> state2) {
        if (i >= 0) {
            return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material.SliderKt.slideOnKeyEvents.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3148invokeZmokQxo(keyEvent.m7470unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3148invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    boolean z3 = false;
                    if (!z) {
                        return false;
                    }
                    int iM7482getTypeZmokQxo = KeyEvent_androidKt.m7482getTypeZmokQxo(keyEvent);
                    if (KeyEventType.m7474equalsimpl0(iM7482getTypeZmokQxo, KeyEventType.INSTANCE.m7478getKeyDownCS__XNY())) {
                        float fAbs = Math.abs(closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue());
                        int i2 = i;
                        float f2 = fAbs / (i2 > 0 ? i2 + 1 : 100);
                        long jM7481getKeyZmokQxo = KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent);
                        if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7251getDirectionUpEK5gGoQ())) {
                            state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f + f2), closedFloatingPointRange));
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7246getDirectionDownEK5gGoQ())) {
                            state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f - f2), closedFloatingPointRange));
                        } else {
                            if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7250getDirectionRightEK5gGoQ())) {
                                state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f + ((z2 ? -1 : 1) * f2)), closedFloatingPointRange));
                            } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7249getDirectionLeftEK5gGoQ())) {
                                state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f - ((z2 ? -1 : 1) * f2)), closedFloatingPointRange));
                            } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7325getMoveHomeEK5gGoQ())) {
                                state.getValue().invoke(closedFloatingPointRange.getStart());
                            } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7324getMoveEndEK5gGoQ())) {
                                state.getValue().invoke(closedFloatingPointRange.getEndInclusive());
                            } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7362getPageUpEK5gGoQ())) {
                                state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f - (RangesKt.coerceIn(r2 / 10, 1, 10) * f2)), closedFloatingPointRange));
                            } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7361getPageDownEK5gGoQ())) {
                                state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f + (RangesKt.coerceIn(r2 / 10, 1, 10) * f2)), closedFloatingPointRange));
                            }
                        }
                        z3 = true;
                    } else if (KeyEventType.m7474equalsimpl0(iM7482getTypeZmokQxo, KeyEventType.INSTANCE.m7479getKeyUpCS__XNY())) {
                        long jM7481getKeyZmokQxo2 = KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent);
                        if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7251getDirectionUpEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7246getDirectionDownEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7250getDirectionRightEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7249getDirectionLeftEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7325getMoveHomeEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7324getMoveEndEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7362getPageUpEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7361getPageDownEK5gGoQ())) {
                            Function0<Unit> value = state2.getValue();
                            if (value != null) {
                                value.invoke();
                            }
                            z3 = true;
                        }
                    }
                    return Boolean.valueOf(z3);
                }
            });
        }
        throw new IllegalArgumentException("steps should be >= 0".toString());
    }

    private static final Modifier sliderSemantics(Modifier modifier, float f, final boolean z, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i) {
        final float fCoerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.sliderSemantics$lambda$0(z, closedFloatingPointRange, i, fCoerceIn, function1, function0, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null), f, closedFloatingPointRange, i);
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, Function1 function1, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        Function0 function02 = function0;
        if ((i2 & 16) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        ClosedFloatingPointRange closedFloatingPointRange2 = closedFloatingPointRange;
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return sliderSemantics(modifier, f, z, function1, function02, closedFloatingPointRange2, i);
    }

    static final Unit sliderSemantics$lambda$0(boolean z, final ClosedFloatingPointRange closedFloatingPointRange, final int i, final float f, final Function1 function1, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.sliderSemantics$lambda$0$0(closedFloatingPointRange, i, f, function1, function0, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean sliderSemantics$lambda$0$0(ClosedFloatingPointRange closedFloatingPointRange, int i, float f, Function1 function1, Function0 function0, float f2) {
        int i2;
        float fCoerceIn = RangesKt.coerceIn(f2, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (i > 0 && (i2 = i + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f3 = fAbs;
            int i3 = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i3 / i2);
                float f4 = fLerp - fCoerceIn;
                if (Math.abs(f4) <= fAbs) {
                    fAbs = Math.abs(f4);
                    f3 = fLerp;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
            fCoerceIn = f3;
        }
        if (fCoerceIn == f) {
            return false;
        }
        function1.invoke(Float.valueOf(fCoerceIn));
        if (function0 != null) {
            function0.invoke();
        }
        return true;
    }

    private static final Modifier sliderTapModifier(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final float f, final boolean z, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean z2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                inspectorInfo.setName("sliderTapModifier");
                inspectorInfo.getProperties().set("draggableState", draggableState);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("maxPx", Float.valueOf(f));
                inspectorInfo.getProperties().set("isRtl", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("rawOffset", state);
                inspectorInfo.getProperties().set("gestureEndAction", state2);
                inspectorInfo.getProperties().set("pressOffset", mutableState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SliderKt.sliderTapModifier$lambda$1(z2, draggableState, mutableInteractionSource, f, z, mutableState, state, state2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    static final Modifier sliderTapModifier$lambda$1(boolean z, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f, boolean z2, MutableState mutableState, State state, State state2, Modifier modifier, Composer composer, int i) {
        Modifier modifierPointerInput;
        composer.startReplaceGroup(1945228890);
        ComposerKt.sourceInformation(composer, "C:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1945228890, i, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:1000)");
        }
        if (z) {
            composer.startReplaceGroup(-1679801122);
            ComposerKt.sourceInformation(composer, "1001@40932L24,1002@41035L983");
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
            Object[] objArr = {draggableState, mutableInteractionSource, Float.valueOf(f), Boolean.valueOf(z2)};
            ComposerKt.sourceInformationMarkerStart(composer, 1054195633, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composer.changed(z2) | composer.changed(f) | composer.changed(mutableState) | composer.changed(state) | composer.changedInstance(coroutineScope) | composer.changedInstance(draggableState) | composer.changed(state2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (PointerInputEventHandler) new SliderKt$sliderTapModifier$2$1$1(z2, f, mutableState, state, coroutineScope, draggableState, state2);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, objArr, (PointerInputEventHandler) objRememberedValue2);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1678708124);
            composer.endReplaceGroup();
            modifierPointerInput = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierPointerInput;
    }

    private static final float snapValueToTick(float f, List<Float> list, float f2, float f3) {
        Float f4;
        if (list.isEmpty()) {
            f4 = null;
        } else {
            Float f5 = list.get(0);
            float fAbs = Math.abs(MathHelpersKt.lerp(f2, f3, f5.floatValue()) - f);
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Float f6 = list.get(i);
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f6.floatValue()) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f5 = f6;
                        fAbs = fAbs2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            f4 = f5;
        }
        Float f7 = f4;
        return f7 != null ? MathHelpersKt.lerp(f2, f3, f7.floatValue()) : f;
    }

    private static final List<Float> stepsToTickFractions(int i) {
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int i2 = i + 2;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(i3 / (i + 1)));
        }
        return arrayList;
    }
}
