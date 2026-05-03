package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#JG\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0001¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010+J3\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010,J\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010;J\u009d\u0001\u0010<\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002052\b\b\u0002\u00109\u001a\u000205H\u0001¢\u0006\u0004\b=\u0010>J\u009d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0003¢\u0006\u0004\bB\u0010CJ3\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010FJ\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u0010GJ\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010HJ\u008d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0003¢\u0006\u0004\bI\u0010JJï\u0001\u0010K\u001a\u00020\u0019*\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020O2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u0002052\u0006\u0010S\u001a\u0002052\u0006\u0010T\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00109\u001a\u0002052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u0010U\u001a\u00020\u001f2\b\b\u0002\u0010@\u001a\u00020\u001f2\b\b\u0002\u0010V\u001a\u00020W2\b\b\u0002\u0010A\u001a\u00020\u001fH\u0002¢\u0006\u0004\bX\u0010YJC\u0010Z\u001a\u00020\u0019*\u00020/2\u0006\u0010V\u001a\u00020W2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020OH\u0002¢\u0006\u0004\ba\u0010bJ)\u0010-\u001a\u00020\u0019*\u00020/2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u0002052\u0006\u0010^\u001a\u00020\b¢\u0006\u0004\bc\u0010dR\u0018\u0010\u0014\u001a\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010e\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010gR\u0013\u0010i\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010gR\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SliderColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "defaultSliderColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "Thumb-HwbPF3A$material3", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "trackCornerSize", "Track-mnvyFg4$material3", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "CenteredTrack", "CenteredTrack-7LSsfP0$material3", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFFLandroidx/compose/runtime/Composer;II)V", "TrackImpl", "enableCornerShrinking", "isCentered", "TrackImpl-VvwgllI", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFZZLandroidx/compose/runtime/Composer;II)V", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "TrackImpl-xlyIBlM", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;I)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "startThumbWidth", "startThumbHeight", "endThumbWidth", "endThumbHeight", "isRangeSlider", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "drawTrack-GVD57ws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/foundation/gestures/Orientation;Z)V", "drawTrackPath", TypedValues.CycleType.S_WAVE_OFFSET, "size", "Landroidx/compose/ui/geometry/Size;", "color", "startCornerRadius", "endCornerRadius", "drawTrackPath-zXTsYAs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/foundation/gestures/Orientation;JJJFF)V", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "()F", "F", "TickSize", "getTickSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    private static final float TrackStopIndicatorSize = SliderTokens.INSTANCE.m5318getStopIndicatorSizeD9Ej5fM();
    private static final float TickSize = SliderTokens.INSTANCE.m5318getStopIndicatorSizeD9Ej5fM();
    private static final Path trackPath = AndroidPath_androidKt.Path();

    private SliderDefaults() {
    }

    static final Unit CenteredTrack_7LSsfP0$lambda$23$lambda$22(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4100drawStopIndicatorx3O1jOs(drawScope, offset.m6090unboximpl(), TrackStopIndicatorSize, jM4086trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    static final Unit CenteredTrack_7LSsfP0$lambda$25(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4092CenteredTrack7LSsfP0$material3(sliderState, modifier, z, sliderColors, function2, function3, f, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Thumb_9LiSoMs$lambda$3(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4093Thumb9LiSoMs(mutableInteractionSource, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Thumb_HwbPF3A$lambda$6(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4094ThumbHwbPF3A$material3(mutableInteractionSource, sliderState, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$11$lambda$10(long j, SliderPositions sliderPositions, long j2, long j3, long j4, DrawScope drawScope) {
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long jM6072constructorimpl2 = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) << 32));
        long j5 = jM6072constructorimpl;
        long j6 = z ? jM6072constructorimpl2 : j5;
        if (!z) {
            j5 = jM6072constructorimpl2;
        }
        float f = drawScope.mo1624toPx0680j_4(TickSize);
        float f2 = drawScope.mo1624toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j, j6, j5, f2, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        int i = (int) (j6 >> 32);
        int i2 = (int) (j5 >> 32);
        long j7 = j6;
        long j8 = j5;
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j2, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getStart().floatValue()))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getEndInclusive().floatValue()))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), f2, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        float[] tickFractions = sliderPositions.getTickFractions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i3 = 0; i3 < length; i3++) {
            float f3 = tickFractions[i3];
            Boolean boolValueOf = Boolean.valueOf(f3 > sliderPositions.getActiveRange().getEndInclusive().floatValue() || f3 < sliderPositions.getActiveRange().getStart().floatValue());
            Object obj = linkedHashMap.get(boolValueOf);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(boolValueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f3));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                arrayList.add(Offset.m6069boximpl(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (OffsetKt.m6103lerpWko1d7g(j7, j8, ((Number) list.get(i4)).floatValue()) >> 32)))) << 32))));
                i4++;
                zBooleanValue = zBooleanValue;
                list = list;
            }
            long j9 = j7;
            j8 = j8;
            DrawScope.m6890drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m6645getPointsr_lszbg(), zBooleanValue ? j3 : j4, f, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            j7 = j9;
        }
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$12(SliderDefaults sliderDefaults, SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderPositions, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$13(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$33(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(rangeSliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x025f  */
    /* JADX INFO: renamed from: TrackImpl-VvwgllI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m4087TrackImplVvwgllI(final SliderState sliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f2, final float f3, final boolean z2, final boolean z3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        int i5;
        Modifier modifierM2069height3ABfNKs;
        long j;
        Modifier modifierThen;
        final long j2;
        boolean zChangedInstance;
        Object objRememberedValue;
        Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(133396521);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrackImpl)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,enableCornerShrinking,isCentered)1601@71313L957,1622@72299L1481,1592@70900L2880:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(133396521, i3, i4, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1587)");
            }
            final long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, false);
            final long jM4086trackColorWaAFU9c$material32 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
            final long jM4085tickColorWaAFU9c$material3 = sliderColors.m4085tickColorWaAFU9c$material3(z, false);
            int i6 = i4;
            long jM4085tickColorWaAFU9c$material32 = sliderColors.m4085tickColorWaAFU9c$material3(z, true);
            if (sliderState.getOrientation() == Orientation.Vertical) {
                i5 = i3;
                modifierM2069height3ABfNKs = SizeKt.fillMaxHeight$default(SizeKt.m2088width3ABfNKs(modifier, SliderKt.getTrackHeight()), 0.0f, 1, null);
                if (sliderState.getReverseVerticalDirection()) {
                    modifierM2069height3ABfNKs = ScaleKt.scale(modifierM2069height3ABfNKs, 1.0f, -1.0f);
                }
            } else {
                i5 = i3;
                modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -654921594, "CC(remember):Slider.kt#9igjgp");
            int i7 = i5 & 112;
            boolean zChangedInstance2 = (i7 == 32) | composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                j = jM4085tickColorWaAFU9c$material32;
            } else {
                j = jM4085tickColorWaAFU9c$material32;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierThen = modifierM2069height3ABfNKs.then(LayoutModifierKt.layout(companion, (Function3) objRememberedValue2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -654889518, "CC(remember):Slider.kt#9igjgp");
                j2 = j;
                zChangedInstance = (i7 != 32) | composerStartRestartGroup.changedInstance(sliderState) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material32) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(j2) | ((i5 & 29360128) != 8388608) | ((i5 & 234881024) != 67108864) | ((i5 & 458752) != 131072) | ((i5 & 3670016) != 1048576) | ((i5 & 1879048192) != 536870912) | ((i6 & 14) != 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    modifier2 = modifierThen;
                    Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SliderDefaults.TrackImpl_VvwgllI$lambda$31$lambda$30(f, sliderState, jM4086trackColorWaAFU9c$material3, jM4086trackColorWaAFU9c$material32, jM4085tickColorWaAFU9c$material3, j2, f2, f3, function2, function3, z2, z3, (DrawScope) obj);
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    composer2.updateRememberedValue(function1);
                    objRememberedValue = function1;
                } else {
                    modifier2 = modifierThen;
                    composer2 = composerStartRestartGroup;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifier2, (Function1) objRememberedValue, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SliderDefaults.TrackImpl_VvwgllI$lambda$29$lambda$28(f, sliderState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifierThen = modifierM2069height3ABfNKs.then(LayoutModifierKt.layout(companion, (Function3) objRememberedValue2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -654889518, "CC(remember):Slider.kt#9igjgp");
            j2 = j;
            zChangedInstance = (i7 != 32) | composerStartRestartGroup.changedInstance(sliderState) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material32) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(j2) | ((i5 & 29360128) != 8388608) | ((i5 & 234881024) != 67108864) | ((i5 & 458752) != 131072) | ((i5 & 3670016) != 1048576) | ((i5 & 1879048192) != 536870912) | ((i6 & 14) != 4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                modifier2 = modifierThen;
                Function1 function12 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_VvwgllI$lambda$31$lambda$30(f, sliderState, jM4086trackColorWaAFU9c$material3, jM4086trackColorWaAFU9c$material32, jM4085tickColorWaAFU9c$material3, j2, f2, f3, function2, function3, z2, z3, (DrawScope) obj);
                    }
                };
                composer2 = composerStartRestartGroup;
                composer2.updateRememberedValue(function12);
                objRememberedValue = function12;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifier2, (Function1) objRememberedValue, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_VvwgllI$lambda$32(this.f$0, sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: TrackImpl-xlyIBlM, reason: not valid java name */
    private final void m4088TrackImplxlyIBlM(final RangeSliderState rangeSliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f2, final float f3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1719396904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrackImpl)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1817@80714L449,1828@81174L1310,1816@80643L1841:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1719396904, i2, -1, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1811)");
            }
            final long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, false);
            int i3 = i2;
            final long jM4086trackColorWaAFU9c$material32 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
            final long jM4085tickColorWaAFU9c$material3 = sliderColors.m4085tickColorWaAFU9c$material3(z, false);
            final long jM4085tickColorWaAFU9c$material32 = sliderColors.m4085tickColorWaAFU9c$material3(z, true);
            Modifier modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1222010201, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$44$lambda$43((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout = LayoutModifierKt.layout(modifierM2069height3ABfNKs, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1222025782, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(rangeSliderState) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material32) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material32) | ((i3 & 29360128) == 8388608) | ((i3 & 234881024) == 67108864) | ((i3 & 458752) == 131072) | ((i3 & 3670016) == 1048576);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                modifier2 = modifierLayout;
                composer2 = composerStartRestartGroup;
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$46$lambda$45(f, rangeSliderState, jM4086trackColorWaAFU9c$material3, jM4086trackColorWaAFU9c$material32, jM4085tickColorWaAFU9c$material3, jM4085tickColorWaAFU9c$material32, f2, f3, function2, function3, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            } else {
                modifier2 = modifierLayout;
                composer2 = composerStartRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifier2, (Function1) objRememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_xlyIBlM$lambda$47(this.f$0, rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final MeasureResult TrackImpl_VvwgllI$lambda$29$lambda$28(float f, SliderState sliderState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return measureScope.layout(placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(Dp.m9119equalsimpl0(f, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM()) ? sliderState.getOrientation() == Orientation.Vertical ? placeableMo7769measureBRTryo0.getWidth() / 2 : placeableMo7769measureBRTryo0.getHeight() / 2 : measureScope.mo1618roundToPx0680j_4(f)))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        });
    }

    static final Unit TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_VvwgllI$lambda$31$lambda$30(float f, SliderState sliderState, long j, long j2, long j3, long j4, float f2, float f3, Function2 function2, Function3 function3, boolean z, boolean z2, DrawScope drawScope) {
        float fIntBitsToFloat;
        if (Dp.m9119equalsimpl0(f, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM())) {
            fIntBitsToFloat = (sliderState.getOrientation() == Orientation.Vertical ? Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) : Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) / 2.0f;
        } else {
            fIntBitsToFloat = drawScope.mo1624toPx0680j_4(f);
        }
        INSTANCE.m4089drawTrackGVD57ws(drawScope, sliderState.getTickFractions(), 0.0f, sliderState.getCoercedValueAsFraction(), j, j2, j3, j4, drawScope.mo1621toDpu2uoSUM(0), drawScope.mo1621toDpu2uoSUM(0), drawScope.mo1621toDpu2uoSUM(sliderState.getThumbWidth$material3()), drawScope.mo1621toDpu2uoSUM(sliderState.getThumbHeight$material3()), f2, f3, drawScope.mo1620toDpu2uoSUM(fIntBitsToFloat), function2, function3, false, z, sliderState.getOrientation(), z2);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_VvwgllI$lambda$32(SliderDefaults sliderDefaults, SliderState sliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4087TrackImplVvwgllI(sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    static final MeasureResult TrackImpl_xlyIBlM$lambda$44$lambda$43(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return measureScope.layout(placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(placeableMo7769measureBRTryo0.getHeight() / 2))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        });
    }

    static final Unit TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_xlyIBlM$lambda$46$lambda$45(float f, RangeSliderState rangeSliderState, long j, long j2, long j3, long j4, float f2, float f3, Function2 function2, Function3 function3, DrawScope drawScope) {
        m4090drawTrackGVD57ws$default(INSTANCE, drawScope, rangeSliderState.getTickFractions(), rangeSliderState.getCoercedActiveRangeStartAsFraction$material3(), rangeSliderState.getCoercedActiveRangeEndAsFraction$material3(), j, j2, j3, j4, drawScope.mo1620toDpu2uoSUM(rangeSliderState.getStartThumbWidth$material3()), drawScope.mo1620toDpu2uoSUM(rangeSliderState.getStartThumbHeight$material3()), drawScope.mo1620toDpu2uoSUM(rangeSliderState.getEndThumbWidth$material3()), drawScope.mo1620toDpu2uoSUM(rangeSliderState.getEndThumbHeight$material3()), f2, f3, drawScope.mo1620toDpu2uoSUM(Dp.m9119equalsimpl0(f, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM()) ? Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / 2.0f : drawScope.mo1624toPx0680j_4(f)), function2, function3, true, false, null, false, 917504, null);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_xlyIBlM$lambda$47(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, Composer composer, int i2) {
        sliderDefaults.m4088TrackImplxlyIBlM(rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$15$lambda$14(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4100drawStopIndicatorx3O1jOs(drawScope, offset.m6090unboximpl(), TrackStopIndicatorSize, jM4086trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$17(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4096Track4EFweAY(sliderState, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$35$lambda$34(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4100drawStopIndicatorx3O1jOs(drawScope, offset.m6090unboximpl(), TrackStopIndicatorSize, jM4086trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$37(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4095Track4EFweAY(rangeSliderState, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$19$lambda$18(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4100drawStopIndicatorx3O1jOs(drawScope, offset.m6090unboximpl(), TrackStopIndicatorSize, jM4086trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$21(SliderDefaults sliderDefaults, SliderState sliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4098TrackmnvyFg4$material3(sliderState, f, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$39$lambda$38(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4086trackColorWaAFU9c$material3 = sliderColors.m4086trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4100drawStopIndicatorx3O1jOs(drawScope, offset.m6090unboximpl(), TrackStopIndicatorSize, jM4086trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$41(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4097TrackmnvyFg4$material3(rangeSliderState, f, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011c  */
    /* JADX INFO: renamed from: drawTrack-GVD57ws, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m4089drawTrackGVD57ws(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, boolean z, boolean z2, Orientation orientation, boolean z3) {
        float f10;
        float f11;
        boolean z4;
        long jM6072constructorimpl;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        ClosedFloatingPointRange<Float> closedFloatingPointRange;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        long jM6072constructorimpl2;
        float f20;
        float f21;
        float f22;
        boolean z5 = orientation == Orientation.Vertical;
        boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        boolean z7 = z6 && !z5;
        float f23 = drawScope.mo1624toPx0680j_4(f9);
        long jMo6899getSizeNHjbRc = drawScope.mo6899getSizeNHjbRc();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (z5 ? jMo6899getSizeNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE : jMo6899getSizeNHjbRc >> 32));
        boolean z8 = Intrinsics.areEqual(f, ArraysKt.firstOrNull(fArr)) || Intrinsics.areEqual(f, ArraysKt.lastOrNull(fArr));
        float f24 = ((fArr.length == 0) || (Intrinsics.areEqual(f2, ArraysKt.firstOrNull(fArr)) || Intrinsics.areEqual(f2, ArraysKt.lastOrNull(fArr)))) ? 0.0f + ((fIntBitsToFloat - 0.0f) * f2) : (((fIntBitsToFloat - 0.0f) - (f23 * 2.0f)) * f2) + 0.0f + f23;
        float f25 = ((fArr.length == 0) || z8) ? 0.0f + ((fIntBitsToFloat - 0.0f) * f) : (((fIntBitsToFloat - 0.0f) - (f23 * 2.0f)) * f) + 0.0f + f23;
        float f26 = drawScope.mo1624toPx0680j_4(f8);
        if (Dp.m9113compareTo0680j_4(f7, Dp.m9114constructorimpl(0.0f)) > 0) {
            if (z5) {
                f20 = (drawScope.mo1624toPx0680j_4(f4) / 2.0f) + drawScope.mo1624toPx0680j_4(f7);
                f21 = drawScope.mo1624toPx0680j_4(f6) / 2.0f;
                f22 = drawScope.mo1624toPx0680j_4(f7);
            } else {
                f20 = (drawScope.mo1624toPx0680j_4(f3) / 2.0f) + drawScope.mo1624toPx0680j_4(f7);
                f21 = drawScope.mo1624toPx0680j_4(f5) / 2.0f;
                f22 = drawScope.mo1624toPx0680j_4(f7);
            }
            f10 = f20;
            f11 = f21 + f22;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        long jMo6898getCenterF1C5BW0 = drawScope.mo6898getCenterF1C5BW0();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (z5 ? jMo6898getCenterF1C5BW0 & MuxerUtil.UNSIGNED_INT_MAX_VALUE : jMo6898getCenterF1C5BW0 >> 32));
        float f27 = f10 + 0.0f;
        if (z2) {
            if (!(fArr.length == 0)) {
            }
        } else {
            f27 += f23;
        }
        float fMin = z3 ? Math.min(f24, fIntBitsToFloat2) : f25;
        if ((z3 || z) && fMin > f27) {
            float f28 = z7 ? f26 : f23;
            float f29 = z7 ? f23 : f26;
            float f30 = fMin - f10;
            if (z7) {
                z4 = true;
                jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - f30)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            } else {
                z4 = true;
                jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            }
            f12 = fIntBitsToFloat2;
            f13 = f24;
            m4091drawTrackPathzXTsYAs(drawScope, orientation, jM6072constructorimpl, z5 ? Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f30 - 0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) << 32)) : Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(f30 - 0.0f)) << 32)), j, f28, f29);
            long jM6072constructorimpl3 = z5 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f23 + 0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : z6 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - 0.0f) - f23)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f23 + 0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            if (function2 != null) {
                function2.invoke(drawScope, Offset.m6069boximpl(jM6072constructorimpl3));
                Unit unit = Unit.INSTANCE;
            }
        } else {
            f12 = fIntBitsToFloat2;
            f13 = f24;
            z4 = true;
        }
        float f31 = fIntBitsToFloat - f11;
        if (z2) {
            if (!(fArr.length == 0 ? z4 : false)) {
            }
        } else {
            f31 -= f23;
        }
        float fMax = z3 ? Math.max(f13, f12) : f13;
        if (fMax < f31) {
            float f32 = fMax + f11;
            float f33 = fIntBitsToFloat - f32;
            m4091drawTrackPathzXTsYAs(drawScope, orientation, z5 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f32)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : z6 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f32)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), z5 ? Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f33)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : (!z6 || z) ? Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f33)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - f32)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), j, z7 ? f23 : f26, z7 ? f26 : f23);
            long jM6072constructorimpl4 = z5 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - f23)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : z6 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f23)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - f23)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            if (function2 != null) {
                function2.invoke(drawScope, Offset.m6069boximpl(jM6072constructorimpl4));
                Unit unit2 = Unit.INSTANCE;
            }
        }
        if (z3) {
            f14 = fMin + (fMin < f12 ? f10 : 0.0f);
        } else {
            f14 = z ? f25 + f10 : 0.0f;
        }
        if (z3) {
            f15 = fMax - (fMax > f12 ? f11 : 0.0f);
        } else {
            f15 = f13 - f11;
        }
        float f34 = (z7 || z3 || z) ? f26 : f23;
        float f35 = (!z7 || z3 || z) ? f26 : f23;
        float f36 = (!z7 || z3 || z) ? f15 - f14 : f15;
        if (z2) {
            if (fArr.length == 0 ? z4 : false) {
                f16 = 0.0f;
            }
        } else {
            f16 = f34;
        }
        if (f36 > f16) {
            f17 = f13;
            f18 = f14;
            f19 = f15;
            m4091drawTrackPathzXTsYAs(drawScope, orientation, z5 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f14)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : z6 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - f15)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f14)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), z5 ? Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f36)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : (!z6 || z3 || z) ? Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f36)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f15)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), j2, f34, f35);
        } else {
            f17 = f13;
            f18 = f14;
            f19 = f15;
        }
        float f37 = 0.0f + f23;
        float f38 = fIntBitsToFloat - f23;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(f18, f19);
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo2 = RangesKt.rangeTo(f12 - f11, f12 + f11);
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo3 = RangesKt.rangeTo(f25 - f10, f25 + f10);
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo4 = RangesKt.rangeTo(f17 - f11, f17 + f11);
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            float f39 = fArr[i2];
            int i3 = i + 1;
            if (function2 == null || (((!z3 && !z) || i != 0) && i != fArr.length - 1)) {
                float fLerp = MathHelpersKt.lerp(f37, f38, f39);
                if ((z3 && closedFloatingPointRangeRangeTo2.contains(Float.valueOf(fLerp))) || ((z && closedFloatingPointRangeRangeTo3.contains(Float.valueOf(fLerp))) || closedFloatingPointRangeRangeTo4.contains(Float.valueOf(fLerp)))) {
                    closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
                } else {
                    if (z5) {
                        closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
                        jM6072constructorimpl2 = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(fLerp)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    } else {
                        closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
                        jM6072constructorimpl2 = z6 ? Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - fLerp)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    }
                    function3.invoke(drawScope, Offset.m6069boximpl(jM6072constructorimpl2), Color.m6315boximpl(closedFloatingPointRangeRangeTo.contains(Float.valueOf(fLerp)) ? j4 : j3));
                }
            }
            i2++;
            closedFloatingPointRangeRangeTo2 = closedFloatingPointRange;
            closedFloatingPointRangeRangeTo3 = closedFloatingPointRange2;
            i = i3;
        }
    }

    /* JADX INFO: renamed from: drawTrack-GVD57ws$default, reason: not valid java name */
    static /* synthetic */ void m4090drawTrackGVD57ws$default(SliderDefaults sliderDefaults, DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Function2 function2, Function3 function3, boolean z, boolean z2, Orientation orientation, boolean z3, int i, Object obj) {
        sliderDefaults.m4089drawTrackGVD57ws(drawScope, fArr, f, f2, j, j2, j3, j4, f3, f4, f5, f6, f7, f8, f9, function2, function3, z, (i & 131072) != 0 ? false : z2, (i & 262144) != 0 ? Orientation.Horizontal : orientation, (i & 524288) != 0 ? false : z3);
    }

    /* JADX INFO: renamed from: drawTrackPath-zXTsYAs, reason: not valid java name */
    private final void m4091drawTrackPathzXTsYAs(DrawScope drawScope, Orientation orientation, long j, long j2, long j3, float f, float f2) {
        RoundRect roundRectM6132RoundRectZAM2FJo;
        long jM6034constructorimpl = CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long jM6034constructorimpl2 = CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (orientation == Orientation.Vertical) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            roundRectM6132RoundRectZAM2FJo = RoundRectKt.m6132RoundRectZAM2FJo(RectKt.m6120Recttz77jQw(j, Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32))), jM6034constructorimpl, jM6034constructorimpl, jM6034constructorimpl2, jM6034constructorimpl2);
        } else {
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
            roundRectM6132RoundRectZAM2FJo = RoundRectKt.m6132RoundRectZAM2FJo(RectKt.m6120Recttz77jQw(j, Size.m6140constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32))), jM6034constructorimpl, jM6034constructorimpl2, jM6034constructorimpl2, jM6034constructorimpl);
        }
        Path path = trackPath;
        Path.addRoundRect$default(path, roundRectM6132RoundRectZAM2FJo, null, 2, null);
        DrawScope.m6889drawPathLG529CI$default(drawScope, path, j3, 0.0f, null, null, 0, 60, null);
        path.rewind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX INFO: renamed from: CenteredTrack-7LSsfP0$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4092CenteredTrack7LSsfP0$material3(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function22;
        int i5;
        int i6;
        final float f4;
        int i7;
        int i8;
        int i9;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier3;
        final boolean z3;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function23;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        int i10;
        float fM9134getUnspecifiedD9Ej5fM;
        Composer composerStartRestartGroup = composer.startRestartGroup(1199441071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CenteredTrack)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,trackCornerSize:c#ui.unit.Dp)1558@69596L466:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
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
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i12 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i12;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i12;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        function22 = function2;
                        int i13 = composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        function22 = function2;
                    }
                    i3 |= i13;
                } else {
                    function22 = function2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f4 = f;
                } else {
                    f4 = f;
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                    }
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                    if ((i & 100663296) == 0) {
                        i9 = i8;
                        i3 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= composerStartRestartGroup.changed(this) ? 536870912 : 268435456;
                    }
                    if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function32 = function3;
                        modifier3 = modifier2;
                        z3 = z2;
                        sliderColors3 = sliderColors2;
                        function23 = function22;
                        f5 = f2;
                        f6 = f3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1543@68991L8,1544@69060L199,1551@69315L107");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                                i3 &= -7169;
                                sliderColors2 = sliderColorsColors;
                            }
                            if ((i2 & 16) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611643510, "CC(remember):Slider.kt#9igjgp");
                                boolean z4 = ((((i3 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return SliderDefaults.CenteredTrack_7LSsfP0$lambda$23$lambda$22(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function22 = (Function2) objRememberedValue;
                                i3 = (-57345) & i3;
                            }
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611651578, "CC(remember):Slider.kt#9igjgp");
                                SliderDefaults$CenteredTrack$2$1 sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                            m4103invokewPWG1Vc(drawScope, offset.m6090unboximpl(), color.m6335unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                        public final void m4103invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                            SliderDefaults.INSTANCE.m4100drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4101getTickSizeD9Ej5fM(), j2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                                }
                                function33 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function33 = function3;
                            }
                            if (i6 != 0) {
                                f4 = SliderKt.ThumbTrackGapSize;
                            }
                            float f7 = i7 != 0 ? SliderKt.TrackInsideCornerSize : f2;
                            if (i9 != 0) {
                                function32 = function33;
                                i10 = i3;
                                z3 = z2;
                                f5 = f7;
                                fM9134getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM();
                                sliderColors3 = sliderColors2;
                            } else {
                                function32 = function33;
                                i10 = i3;
                                z3 = z2;
                                sliderColors3 = sliderColors2;
                                f5 = f7;
                                fM9134getUnspecifiedD9Ej5fM = f3;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            function32 = function3;
                            fM9134getUnspecifiedD9Ej5fM = f3;
                            i10 = i3;
                            z3 = z2;
                            sliderColors3 = sliderColors2;
                            f5 = f2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1199441071, i10, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1557)");
                        }
                        int i14 = i10 << 3;
                        modifier3 = modifier2;
                        function23 = function22;
                        m4087TrackImplVvwgllI(sliderState, fM9134getUnspecifiedD9Ej5fM, modifier3, z3, sliderColors3, function23, function32, f4, f5, true, true, composerStartRestartGroup, (i10 & 14) | 805306368 | ((i10 >> 21) & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (i14 & 234881024), ((i10 >> 24) & 112) | 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f6 = fM9134getUnspecifiedD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.CenteredTrack_7LSsfP0$lambda$25(this.f$0, sliderState, modifier3, z3, sliderColors3, function23, function32, f4, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 100663296;
                i9 = i8;
                if ((i2 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i3) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0135  */
    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4093Thumb9LiSoMs(final MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        long j2;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j4;
        Object objRememberedValue;
        SnapshotStateList snapshotStateList;
        boolean z3;
        SliderDefaults$Thumb$1$1 sliderDefaults$Thumb$1$1RememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Thumb)N(interactionSource,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1213@54450L46,1214@54539L658,1214@54505L692,1237@55596L5,1233@55392L220:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
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
                    sliderColors2 = sliderColors;
                    int i7 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i7;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        j2 = j;
                        i3 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= composerStartRestartGroup.changed(this) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1209@54333L8");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                                i3 &= -897;
                                sliderColors2 = sliderColorsColors;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i5 != 0) {
                                j4 = SliderKt.ThumbSize;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1212)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 216292781, "CC(remember):Slider.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            snapshotStateList = (SnapshotStateList) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 216296241, "CC(remember):Slider.kt#9igjgp");
                            int i8 = i3 & 14;
                            z3 = i8 == 4;
                            sliderDefaults$Thumb$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3 || sliderDefaults$Thumb$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Thumb$1$1RememberedValue = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Thumb$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) sliderDefaults$Thumb$1$1RememberedValue, composerStartRestartGroup, i8);
                            SpacerKt.Spacer(BackgroundKt.m1482backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m2084size6HolHcs(modifier2, snapshotStateList.isEmpty() ? DpSize.m9205copyDwJknco$default(j4, Dp.m9114constructorimpl(DpSize.m9212getWidthD9Ej5fM(j4) / 2.0f), 0.0f, 2, null) : j4), mutableInteractionSource, false, 2, null), sliderColors2.m4084thumbColorvNxB06k$material3(z2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), composerStartRestartGroup, 6)), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                        }
                        j4 = j2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 216292781, "CC(remember):Slider.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        snapshotStateList = (SnapshotStateList) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 216296241, "CC(remember):Slider.kt#9igjgp");
                        int i82 = i3 & 14;
                        if (i82 == 4) {
                        }
                        sliderDefaults$Thumb$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            sliderDefaults$Thumb$1$1RememberedValue = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Thumb$1$1RememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) sliderDefaults$Thumb$1$1RememberedValue, composerStartRestartGroup, i82);
                            SpacerKt.Spacer(BackgroundKt.m1482backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m2084size6HolHcs(modifier2, snapshotStateList.isEmpty() ? DpSize.m9205copyDwJknco$default(j4, Dp.m9114constructorimpl(DpSize.m9212getWidthD9Ej5fM(j4) / 2.0f), 0.0f, 2, null) : j4), mutableInteractionSource, false, 2, null), sliderColors2.m4084thumbColorvNxB06k$material3(z2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), composerStartRestartGroup, 6)), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j3 = j4;
                        }
                    }
                    final SliderColors sliderColors3 = sliderColors2;
                    final boolean z4 = z2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Thumb_9LiSoMs$lambda$3(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                j2 = j;
                if ((i2 & 32) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
                }
                final SliderColors sliderColors32 = sliderColors2;
                final boolean z42 = z2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            j2 = j;
            if ((i2 & 32) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
            }
            final SliderColors sliderColors322 = sliderColors2;
            final boolean z422 = z2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        j2 = j;
        if ((i2 & 32) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
        }
        final SliderColors sliderColors3222 = sliderColors2;
        final boolean z4222 = z2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e6  */
    /* JADX INFO: renamed from: Thumb-HwbPF3A$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4094ThumbHwbPF3A$material3(final MutableInteractionSource mutableInteractionSource, final SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i5;
        boolean z2;
        int i6;
        long j2;
        final long j3;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColorsColors;
        long j4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-889714565);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Thumb)N(interactionSource,sliderState,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1266@56862L46,1267@56951L658,1267@56917L692,1294@58180L5,1290@57976L220:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(sliderState) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i7 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i7;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        j2 = j;
                    } else {
                        j2 = j;
                        if ((196608 & i) == 0) {
                            i3 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
                        }
                    }
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(this) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j2;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1262@56745L8");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 8) != 0) {
                                sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -7169;
                            } else {
                                sliderColorsColors = sliderColors2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                j2 = SliderKt.ThumbSize;
                            }
                            j4 = j2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            j4 = j2;
                            companion = modifier2;
                            sliderColorsColors = sliderColors2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1265)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -317193687, "CC(remember):Slider.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateListOf();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -317190227, "CC(remember):Slider.kt#9igjgp");
                        int i8 = i3 & 14;
                        boolean z3 = i8 == 4;
                        SliderDefaults$Thumb$3$1 sliderDefaults$Thumb$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z3 || sliderDefaults$Thumb$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Thumb$3$1RememberedValue = new SliderDefaults$Thumb$3$1(mutableInteractionSource, snapshotStateList, null);
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Thumb$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) sliderDefaults$Thumb$3$1RememberedValue, composerStartRestartGroup, i8);
                        SpacerKt.Spacer(BackgroundKt.m1482backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m2084size6HolHcs(companion, !snapshotStateList.isEmpty() ? sliderState.getOrientation() == Orientation.Vertical ? DpSize.m9205copyDwJknco$default(j4, 0.0f, Dp.m9114constructorimpl(DpSize.m9210getHeightD9Ej5fM(j4) / 2.0f), 1, null) : DpSize.m9205copyDwJknco$default(j4, Dp.m9114constructorimpl(DpSize.m9212getWidthD9Ej5fM(j4) / 2.0f), 0.0f, 2, null) : j4), mutableInteractionSource, false, 2, null), sliderColorsColors.m4084thumbColorvNxB06k$material3(z2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), composerStartRestartGroup, 6)), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        sliderColors3 = sliderColorsColors;
                        j3 = j4;
                    }
                    final boolean z4 = z2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Thumb_HwbPF3A$lambda$6(this.f$0, mutableInteractionSource, sliderState, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                z2 = z;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                final boolean z42 = z2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            z2 = z;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
            }
            final boolean z422 = z2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
        }
        final boolean z4222 = z2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void Track(final RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColorsColors;
        int i5;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1617869097);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(rangeSliderState,modifier,colors,enabled)1689@75190L219:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
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
                    sliderColors2 = sliderColors;
                    int i7 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i7;
            } else {
                sliderColors2 = sliderColors;
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
                    i3 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1686@75131L8");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                        } else {
                            sliderColorsColors = sliderColors2;
                        }
                        i5 = i3;
                        if (i4 != 0) {
                            z4 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1617869097, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1688)");
                        }
                        Modifier modifier4 = companion;
                        sliderColors3 = sliderColorsColors;
                        m4095Track4EFweAY(rangeSliderState, modifier4, z4, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                        sliderColorsColors = sliderColors2;
                        i5 = i3;
                    }
                    z4 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier modifier42 = companion;
                    sliderColors3 = sliderColorsColors;
                    m4095Track4EFweAY(rangeSliderState, modifier42, z4, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z3 = z4;
                    modifier3 = modifier42;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z3 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track$lambda$33(this.f$0, rangeSliderState, modifier3, sliderColors3, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017b  */
    @Deprecated(message = "Use version that supports slider state")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        final SliderPositions sliderPositions2;
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i5;
        SliderColors sliderColors4;
        boolean z4;
        final long jM4086trackColorWaAFU9c$material3;
        final long jM4086trackColorWaAFU9c$material32;
        final long jM4085tickColorWaAFU9c$material3;
        final long jM4085tickColorWaAFU9c$material32;
        boolean zChanged;
        Object objRememberedValue;
        boolean z5;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderPositions,modifier,colors,enabled)1323@59516L1838,1323@59464L1890:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderPositions2 = sliderPositions;
        } else {
            sliderPositions2 = sliderPositions;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(sliderPositions2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i8 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i8;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i8;
            } else {
                sliderColors2 = sliderColors;
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
                    i3 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1316@59111L8");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors;
                        }
                        SliderColors sliderColors5 = sliderColors2;
                        i5 = i3;
                        sliderColors4 = sliderColors5;
                        if (i4 != 0) {
                            z4 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1546713545, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1318)");
                        }
                        int i9 = i5;
                        jM4086trackColorWaAFU9c$material3 = sliderColors4.m4086trackColorWaAFU9c$material3(z4, false);
                        jM4086trackColorWaAFU9c$material32 = sliderColors4.m4086trackColorWaAFU9c$material3(z4, true);
                        jM4085tickColorWaAFU9c$material3 = sliderColors4.m4085tickColorWaAFU9c$material3(z4, false);
                        jM4085tickColorWaAFU9c$material32 = sliderColors4.m4085tickColorWaAFU9c$material3(z4, true);
                        SliderColors sliderColors6 = sliderColors4;
                        modifier3 = companion;
                        Modifier modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333010299, "CC(remember):Slider.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material3) | ((i9 & 14) != 4) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material32) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z5 = z4;
                            i6 = 0;
                            Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SliderDefaults.Track$lambda$11$lambda$10(jM4086trackColorWaAFU9c$material3, sliderPositions2, jM4086trackColorWaAFU9c$material32, jM4085tickColorWaAFU9c$material3, jM4085tickColorWaAFU9c$material32, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1);
                            objRememberedValue = function1;
                        } else {
                            z5 = z4;
                            i6 = 0;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2069height3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, i6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sliderColors3 = sliderColors6;
                        z3 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        SliderColors sliderColors7 = sliderColors2;
                        i5 = i3;
                        sliderColors4 = sliderColors7;
                        companion = modifier2;
                    }
                    z4 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i92 = i5;
                    jM4086trackColorWaAFU9c$material3 = sliderColors4.m4086trackColorWaAFU9c$material3(z4, false);
                    jM4086trackColorWaAFU9c$material32 = sliderColors4.m4086trackColorWaAFU9c$material3(z4, true);
                    jM4085tickColorWaAFU9c$material3 = sliderColors4.m4085tickColorWaAFU9c$material3(z4, false);
                    jM4085tickColorWaAFU9c$material32 = sliderColors4.m4085tickColorWaAFU9c$material3(z4, true);
                    SliderColors sliderColors62 = sliderColors4;
                    modifier3 = companion;
                    Modifier modifierM2069height3ABfNKs2 = SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333010299, "CC(remember):Slider.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material3) | ((i92 & 14) != 4) | composerStartRestartGroup.changed(jM4086trackColorWaAFU9c$material32) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4085tickColorWaAFU9c$material32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        z5 = z4;
                        i6 = 0;
                        Function1 function12 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SliderDefaults.Track$lambda$11$lambda$10(jM4086trackColorWaAFU9c$material3, sliderPositions2, jM4086trackColorWaAFU9c$material32, jM4085tickColorWaAFU9c$material3, jM4085tickColorWaAFU9c$material32, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function12);
                        objRememberedValue = function12;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2069height3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, i6);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        sliderColors3 = sliderColors62;
                        z3 = z5;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z3 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track$lambda$12(this.f$0, sliderPositions, modifier3, sliderColors3, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(sliderState, modifier, enabled, colors, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void Track(final SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColorsColors;
        int i5;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(593554206);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderState,modifier,colors,enabled)1401@62715L214:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
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
                    sliderColors2 = sliderColors;
                    int i7 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i7;
            } else {
                sliderColors2 = sliderColors;
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
                    i3 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1398@62656L8");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                        } else {
                            sliderColorsColors = sliderColors2;
                        }
                        i5 = i3;
                        if (i4 != 0) {
                            z4 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(593554206, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1400)");
                        }
                        Modifier modifier4 = companion;
                        sliderColors3 = sliderColorsColors;
                        m4096Track4EFweAY(sliderState, modifier4, z4, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                        sliderColorsColors = sliderColors2;
                        i5 = i3;
                    }
                    z4 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier modifier42 = companion;
                    sliderColors3 = sliderColorsColors;
                    m4096Track4EFweAY(sliderState, modifier42, z4, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i5 & 14) | 14155776 | (i5 & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168) | ((i5 << 12) & 234881024), 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z3 = z4;
                    modifier3 = modifier42;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z3 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track$lambda$13(this.f$0, sliderState, modifier3, sliderColors3, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4095Track4EFweAY(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function22;
        int i5;
        int i6;
        float f3;
        int i7;
        final Modifier modifier3;
        final boolean z3;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function23;
        final float f4;
        final float f5;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-541824132);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(rangeSliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1735@77205L402:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i10 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        function22 = function2;
                        int i11 = composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        function22 = function2;
                    }
                    i3 |= i11;
                } else {
                    function22 = function2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f3 = f;
                } else {
                    f3 = f;
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                    }
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= composerStartRestartGroup.changed(this) ? 67108864 : 33554432;
                }
                if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1721@76646L8,1722@76715L199,1729@76970L107");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors;
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001938653, "CC(remember):Slider.kt#9igjgp");
                            boolean z4 = ((((i3 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_4EFweAY$lambda$35$lambda$34(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function22 = (Function2) objRememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i5 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001930585, "CC(remember):Slider.kt#9igjgp");
                            SliderDefaults$Track$12$1 sliderDefaults$Track$12$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$12$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$12$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$12$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4104invokewPWG1Vc(drawScope, offset.m6090unboximpl(), color.m6335unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4104invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4100drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4101getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$12$1RememberedValue);
                            }
                            function33 = (Function3) sliderDefaults$Track$12$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function33 = function3;
                        }
                        if (i6 != 0) {
                            f3 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i7 != 0) {
                            z3 = z2;
                            function23 = function22;
                            f5 = f3;
                            function32 = function33;
                            i8 = i3;
                            modifier3 = modifier2;
                            sliderColors3 = sliderColors2;
                            f4 = SliderKt.TrackInsideCornerSize;
                        } else {
                            z3 = z2;
                            function23 = function22;
                            f5 = f3;
                            function32 = function33;
                            i8 = i3;
                            modifier3 = modifier2;
                            sliderColors3 = sliderColors2;
                            f4 = f2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i8 = i3;
                        modifier3 = modifier2;
                        z3 = z2;
                        sliderColors3 = sliderColors2;
                        function23 = function22;
                        f4 = f2;
                        f5 = f3;
                        function32 = function3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-541824132, i8, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1734)");
                    }
                    int i12 = (i8 & 14) | 48;
                    int i13 = i8 << 3;
                    m4088TrackImplxlyIBlM(rangeSliderState, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), modifier3, z3, sliderColors3, function23, function32, f5, f4, composerStartRestartGroup, i12 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z3 = z2;
                    sliderColors3 = sliderColors2;
                    function23 = function22;
                    f4 = f2;
                    f5 = f3;
                    function32 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_4EFweAY$lambda$37(this.f$0, rangeSliderState, modifier3, z3, sliderColors3, function23, function32, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4096Track4EFweAY(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function22;
        int i5;
        int i6;
        final float f3;
        int i7;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier3;
        final boolean z3;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function23;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(49984771);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1447@64678L467:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i10 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        function22 = function2;
                        int i11 = composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        function22 = function2;
                    }
                    i3 |= i11;
                } else {
                    function22 = function2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    f3 = f;
                } else {
                    f3 = f;
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                    }
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= composerStartRestartGroup.changed(this) ? 67108864 : 33554432;
                }
                if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1433@64119L8,1434@64188L199,1441@64443L107");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors;
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790733290, "CC(remember):Slider.kt#9igjgp");
                            boolean z4 = ((((i3 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_4EFweAY$lambda$15$lambda$14(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function22 = (Function2) objRememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i5 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790741358, "CC(remember):Slider.kt#9igjgp");
                            SliderDefaults$Track$5$1 sliderDefaults$Track$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$5$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4106invokewPWG1Vc(drawScope, offset.m6090unboximpl(), color.m6335unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4106invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4100drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4101getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$5$1RememberedValue);
                            }
                            function33 = (Function3) sliderDefaults$Track$5$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function33 = function3;
                        }
                        if (i6 != 0) {
                            f3 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i7 != 0) {
                            function32 = function33;
                            i8 = i3;
                            z3 = z2;
                            sliderColors3 = sliderColors2;
                            f4 = SliderKt.TrackInsideCornerSize;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(49984771, i8, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1446)");
                            }
                            int i12 = i8 << 3;
                            modifier3 = modifier2;
                            function23 = function22;
                            m4087TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), modifier3, z3, sliderColors3, function23, function32, f3, f4, false, false, composerStartRestartGroup, (i8 & 14) | 805306416 | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), ((i8 >> 21) & 112) | 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            function32 = function33;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        function32 = function3;
                    }
                    i8 = i3;
                    z3 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = i8 << 3;
                    modifier3 = modifier2;
                    function23 = function22;
                    m4087TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), modifier3, z3, sliderColors3, function23, function32, f3, f4, false, false, composerStartRestartGroup, (i8 & 14) | 805306416 | (i122 & 896) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (i122 & 234881024), ((i8 >> 21) & 112) | 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function32 = function3;
                    modifier3 = modifier2;
                    z3 = z2;
                    sliderColors3 = sliderColors2;
                    function23 = function22;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_4EFweAY$lambda$17(this.f$0, sliderState, modifier3, z3, sliderColors3, function23, function32, f3, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX INFO: renamed from: Track-mnvyFg4$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4097TrackmnvyFg4$material3(final RangeSliderState rangeSliderState, final float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        final boolean z2;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function22;
        int i6;
        int i7;
        float f4;
        int i8;
        int i9;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier3;
        final boolean z3;
        Composer composer2;
        final SliderColors sliderColors3;
        final float f5;
        final Function2<? super DrawScope, ? super Offset, Unit> function23;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function34;
        int i10;
        Modifier modifier4;
        boolean z4;
        SliderColors sliderColors4;
        float f7;
        Function2<? super DrawScope, ? super Offset, Unit> function24;
        float f8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1952945688);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1786@79501L403:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
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
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            sliderColors2 = sliderColors;
                            int i11 = composerStartRestartGroup.changed(sliderColors2) ? 16384 : 8192;
                            i3 |= i11;
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i3 |= i11;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            function22 = function2;
                            int i12 = composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            function22 = function2;
                        }
                        i3 |= i12;
                    } else {
                        function22 = function2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 12582912;
                        f4 = f2;
                    } else {
                        f4 = f2;
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i3 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= composerStartRestartGroup.changed(this) ? 536870912 : 268435456;
                        }
                        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1772@78942L8,1773@79011L199,1780@79266L107");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                                    i3 &= -57345;
                                    sliderColors2 = sliderColorsColors;
                                }
                                if ((i2 & 32) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119891585, "CC(remember):Slider.kt#9igjgp");
                                    boolean z5 = ((((57344 & i3) ^ 24576) > 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda18
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return SliderDefaults.Track_mnvyFg4$lambda$39$lambda$38(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function22 = (Function2) objRememberedValue;
                                    i3 = (-458753) & i3;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119883517, "CC(remember):Slider.kt#9igjgp");
                                    SliderDefaults$Track$15$1 sliderDefaults$Track$15$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (sliderDefaults$Track$15$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        sliderDefaults$Track$15$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$15$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                                m4105invokewPWG1Vc(drawScope, offset.m6090unboximpl(), color.m6335unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                            public final void m4105invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                                SliderDefaults.INSTANCE.m4100drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4101getTickSizeD9Ej5fM(), j2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$15$1RememberedValue);
                                    }
                                    function33 = (Function3) sliderDefaults$Track$15$1RememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function33 = function3;
                                }
                                if (i7 != 0) {
                                    f4 = SliderKt.ThumbTrackGapSize;
                                }
                                if (i9 != 0) {
                                    function34 = function33;
                                    i10 = i3;
                                    modifier4 = modifier2;
                                    z4 = z2;
                                    sliderColors4 = sliderColors2;
                                    f7 = f4;
                                    function24 = function22;
                                    f8 = SliderKt.TrackInsideCornerSize;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1952945688, i10, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1785)");
                                    }
                                    m4088TrackImplxlyIBlM(rangeSliderState, f, modifier4, z4, sliderColors4, function24, function34, f7, f8, composerStartRestartGroup, i10 & 2147483646);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = composerStartRestartGroup;
                                    f6 = f8;
                                    f5 = f7;
                                    function32 = function34;
                                    function23 = function24;
                                    sliderColors3 = sliderColors4;
                                    z3 = z4;
                                    modifier3 = modifier4;
                                } else {
                                    function34 = function33;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function34 = function3;
                            }
                            i10 = i3;
                            modifier4 = modifier2;
                            z4 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function24 = function22;
                            f8 = f3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            m4088TrackImplxlyIBlM(rangeSliderState, f, modifier4, z4, sliderColors4, function24, function34, f7, f8, composerStartRestartGroup, i10 & 2147483646);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            f6 = f8;
                            f5 = f7;
                            function32 = function34;
                            function23 = function24;
                            sliderColors3 = sliderColors4;
                            z3 = z4;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function32 = function3;
                            modifier3 = modifier2;
                            z3 = z2;
                            composer2 = composerStartRestartGroup;
                            sliderColors3 = sliderColors2;
                            f5 = f4;
                            function23 = function22;
                            f6 = f3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$41(this.f$0, rangeSliderState, f, modifier3, z3, sliderColors3, function23, function32, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 100663296;
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX INFO: renamed from: Track-mnvyFg4$material3, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4098TrackmnvyFg4$material3(final SliderState sliderState, final float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f2, float f3, Composer composer, final int i, final int i2) {
        SliderState sliderState2;
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        final boolean z2;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function22;
        int i6;
        int i7;
        float f4;
        int i8;
        int i9;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32;
        final Modifier modifier3;
        final boolean z3;
        final SliderColors sliderColors3;
        final float f5;
        final Function2<? super DrawScope, ? super Offset, Unit> function23;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function33;
        float f7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1691224881);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1503@67150L467:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderState2 = sliderState;
        } else if ((i & 6) == 0) {
            sliderState2 = sliderState;
            i3 = (composerStartRestartGroup.changedInstance(sliderState2) ? 4 : 2) | i;
        } else {
            sliderState2 = sliderState;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
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
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            sliderColors2 = sliderColors;
                            int i10 = composerStartRestartGroup.changed(sliderColors2) ? 16384 : 8192;
                            i3 |= i10;
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i3 |= i10;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            function22 = function2;
                            int i11 = composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                            i3 |= i11;
                        } else {
                            function22 = function2;
                        }
                        i3 |= i11;
                    } else {
                        function22 = function2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 12582912;
                        f4 = f2;
                    } else {
                        f4 = f2;
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i3 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= composerStartRestartGroup.changed(this) ? 536870912 : 268435456;
                        }
                        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1489@66591L8,1490@66660L199,1497@66915L107");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                                    i3 &= -57345;
                                    sliderColors2 = sliderColorsColors;
                                }
                                if ((i2 & 32) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769483032, "CC(remember):Slider.kt#9igjgp");
                                    boolean z4 = ((((57344 & i3) ^ 24576) > 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return SliderDefaults.Track_mnvyFg4$lambda$19$lambda$18(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function22 = (Function2) objRememberedValue;
                                    i3 = (-458753) & i3;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769491100, "CC(remember):Slider.kt#9igjgp");
                                    SliderDefaults$Track$8$1 sliderDefaults$Track$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (sliderDefaults$Track$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        sliderDefaults$Track$8$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$8$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                                m4107invokewPWG1Vc(drawScope, offset.m6090unboximpl(), color.m6335unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                            public final void m4107invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                                SliderDefaults.INSTANCE.m4100drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4101getTickSizeD9Ej5fM(), j2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$8$1RememberedValue);
                                    }
                                    function33 = (Function3) sliderDefaults$Track$8$1RememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function33 = function3;
                                }
                                if (i7 != 0) {
                                    f4 = SliderKt.ThumbTrackGapSize;
                                }
                                if (i9 != 0) {
                                    f7 = SliderKt.TrackInsideCornerSize;
                                }
                                int i12 = i3;
                                boolean z5 = z2;
                                SliderColors sliderColors4 = sliderColors2;
                                float f8 = f4;
                                Function2<? super DrawScope, ? super Offset, Unit> function24 = function22;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1502)");
                                }
                                int i13 = (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12);
                                int i14 = ((i12 >> 24) & 112) | 6;
                                Modifier modifier4 = modifier2;
                                Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function34 = function33;
                                m4087TrackImplVvwgllI(sliderState2, f, modifier4, z5, sliderColors4, function24, function34, f8, f7, true, false, composerStartRestartGroup, i13, i14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f6 = f7;
                                f5 = f8;
                                function32 = function34;
                                function23 = function24;
                                sliderColors3 = sliderColors4;
                                z3 = z5;
                                modifier3 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function33 = function3;
                            }
                            f7 = f3;
                            int i122 = i3;
                            boolean z52 = z2;
                            SliderColors sliderColors42 = sliderColors2;
                            float f82 = f4;
                            Function2<? super DrawScope, ? super Offset, Unit> function242 = function22;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = (i122 & 14) | 805306368 | (i122 & 112) | (i122 & 896) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (234881024 & i122);
                            int i142 = ((i122 >> 24) & 112) | 6;
                            Modifier modifier42 = modifier2;
                            Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function342 = function33;
                            m4087TrackImplVvwgllI(sliderState2, f, modifier42, z52, sliderColors42, function242, function342, f82, f7, true, false, composerStartRestartGroup, i132, i142);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f6 = f7;
                            f5 = f82;
                            function32 = function342;
                            function23 = function242;
                            sliderColors3 = sliderColors42;
                            z3 = z52;
                            modifier3 = modifier42;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function32 = function3;
                            modifier3 = modifier2;
                            z3 = z2;
                            sliderColors3 = sliderColors2;
                            f5 = f4;
                            function23 = function22;
                            f6 = f3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$21(this.f$0, sliderState, f, modifier3, z3, sliderColors3, function23, function32, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 100663296;
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public final SliderColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1376295968, "C(colors)1107@48675L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1107)");
        }
        SliderColors defaultSliderColors$material3 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSliderColors$material3;
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m4099colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        long j11;
        ComposerKt.sourceInformationMarkerStart(composer, 885588574, "C(colors)N(thumbColor:c#ui.graphics.Color,activeTrackColor:c#ui.graphics.Color,activeTickColor:c#ui.graphics.Color,inactiveTrackColor:c#ui.graphics.Color,inactiveTickColor:c#ui.graphics.Color,disabledThumbColor:c#ui.graphics.Color,disabledActiveTrackColor:c#ui.graphics.Color,disabledActiveTickColor:c#ui.graphics.Color,disabledInactiveTrackColor:c#ui.graphics.Color,disabledInactiveTickColor:c#ui.graphics.Color)1149@50999L11:Slider.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        long jM6361getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j6;
        long jM6361getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j7;
        long jM6361getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j8;
        long jM6361getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j9;
        long jM6361getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            j11 = jM6361getUnspecified0d7_KjU;
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1149)");
        } else {
            j11 = jM6361getUnspecified0d7_KjU;
        }
        SliderColors sliderColorsM4073copyK518z4 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4073copyK518z4(j11, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, jM6361getUnspecified0d7_KjU6, jM6361getUnspecified0d7_KjU7, jM6361getUnspecified0d7_KjU8, jM6361getUnspecified0d7_KjU9, jM6361getUnspecified0d7_KjU10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sliderColorsM4073copyK518z4;
    }

    /* JADX INFO: renamed from: drawStopIndicator-x3O1jOs, reason: not valid java name */
    public final void m4100drawStopIndicatorx3O1jOs(DrawScope drawScope, long j, float f, long j2) {
        DrawScope.m6880drawCircleVaOC9Bg$default(drawScope, j2, drawScope.mo1624toPx0680j_4(f) / 2.0f, j, 0.0f, null, null, 0, 120, null);
    }

    public final SliderColors getDefaultSliderColors$material3(ColorScheme colorScheme) {
        SliderColors defaultSliderColorsCached = colorScheme.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached != null) {
            return defaultSliderColorsCached;
        }
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultSliderColorsCached$material3(sliderColors);
        return sliderColors;
    }

    /* JADX INFO: renamed from: getTickSize-D9Ej5fM, reason: not valid java name */
    public final float m4101getTickSizeD9Ej5fM() {
        return TickSize;
    }

    /* JADX INFO: renamed from: getTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m4102getTrackStopIndicatorSizeD9Ej5fM() {
        return TrackStopIndicatorSize;
    }
}
