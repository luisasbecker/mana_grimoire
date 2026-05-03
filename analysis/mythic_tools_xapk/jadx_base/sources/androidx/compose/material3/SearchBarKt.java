package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.compose.material3.internal.PredictiveBackState;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.MotionTokens;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\\\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001ar\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0099\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0084\u0001\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020$2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b*\u0010+\u001a\u008e\u0001\u0010,\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b-\u0010.\u001a7\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u0002012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u000204032\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0007¢\u0006\u0002\u00106\u001a\u0090\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bC\u0010D\u001a\u0086\u0002\u0010,\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bE\u0010F\u001aÄ\u0001\u0010K\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0001¢\u0006\u0004\bV\u0010W\u001a \u0001\u0010X\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010Y\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010Z\u001ap\u0010[\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\b\\\u0010]\u001a\u0080\u0001\u0010^\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\ba\u0010b\u001a\u000e\u0010c\u001a\u000204*\u0004\u0018\u00010dH\u0002\u001a#\u0010j\u001a\u00020\u00012\u0006\u0010A\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010m\u001a-\u0010n\u001a\u0002042\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010o\u001a\u0002042\u0006\u0010O\u001a\u000204H\u0002¢\u0006\u0002\u0010p\u001aG\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010v\u001a\u00020w2\u0006\u0010o\u001a\u0002042\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\by\u0010z\u001aW\u0010{\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u000e\u0010Q\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010|\u001a\u00020r2\u0006\u0010}\u001a\u00020r2\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\b~\u0010\u007f\"\u001e\u0010G\u001a\u00020(*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bH\u0010I\u001a\u0004\bG\u0010J\"\u001e\u0010e\u001a\u00020f*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bg\u0010I\u001a\u0004\bh\u0010i\"\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u0082\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0083\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0085\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u001a\u0010\u0089\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u001a\u0010\u008c\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u0087\u0001\"\u000f\u0010\u008e\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u008f\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0090\u0001\u0010\u0087\u0001\"\u0012\u0010\u0091\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u001a\u0010\u0092\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0093\u0001\u0010\u0087\u0001\"\u0012\u0010\u0094\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0095\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0096\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0097\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0098\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0099\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009a\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009b\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u009e\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001²\u0006\u000b\u0010«\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\u000b\u0010¬\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\f\u0010\u00ad\u0001\u001a\u00030®\u0001X\u008a\u0084\u0002"}, d2 = {"SearchBar", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/SearchBarState;", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "SearchBar-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/runtime/Composer;II)V", "TopSearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "scrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "TopSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/SearchBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "ExpandedFullScreenSearchBar", "collapsedShape", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/DialogProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ExpandedFullScreenSearchBar-_UtchM0", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ExpandedDockedSearchBar", "Landroidx/compose/ui/window/PopupProperties;", "ExpandedDockedSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expanded", "", "onExpandedChange", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DockedSearchBar", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSearchBarState", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpecForCollapse", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarState;", SearchIntents.EXTRA_QUERY, "", "onQueryChange", "onSearch", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isExpanded", "isExpanded$annotations", "(Landroidx/compose/material3/SearchBarState;)V", "(Landroidx/compose/material3/SearchBarState;)Z", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DockedSearchBarLayout", "DockedSearchBarLayout-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FullScreenSearchBarLayout", "predictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "FullScreenSearchBarLayout-EQC0FA8", "(Landroidx/compose/material3/SearchBarState;Landroidx/compose/material3/internal/PredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "transform", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "collapsedBounds", "Landroidx/compose/ui/unit/IntRect;", "getCollapsedBounds$annotations", "getCollapsedBounds", "(Landroidx/compose/material3/SearchBarState;)Landroidx/compose/ui/unit/IntRect;", "DetectClickFromInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "onClick", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "(Landroidx/activity/BackEventCompat;FF)F", "calculatePredictiveBackOffsetX", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "LayoutIdInputField", "LayoutIdSurface", "LayoutIdSearchContent", "SearchBarAsTopBarPadding", "getSearchBarAsTopBarPadding", "()F", "F", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "DockedExpandedTableMinHeight", "getDockedExpandedTableMinHeight", "DockedExpandedTableMaxHeightScreenRatio", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarMaxWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "SearchBarIconOffsetX", "SearchBarPredictiveBackMinScale", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "AnimationEnterDurationMillis", "AnimationExitDurationMillis", "AnimationDelayMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationExitEasing", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationExitFloatSpec", "AnimationPredictiveBackExitFloatSpec", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitSizeSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "material3", "useFullScreenShape", "showContent", "backEvent", "Landroidx/compose/material3/internal/BackEventProgress;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final TextFieldColors UnspecifiedTextFieldColors = new TextFieldColors(Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), new TextSelectionColors(Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), null), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU(), null);
    private static final float SearchBarAsTopBarPadding = Dp.m9114constructorimpl(8.0f);
    private static final float SearchBarCornerRadius = Dp.m9114constructorimpl(SearchBarDefaults.INSTANCE.m3990getInputFieldHeightD9Ej5fM() / 2.0f);
    private static final float DockedExpandedTableMinHeight = Dp.m9114constructorimpl(240.0f);
    private static final float SearchBarMinWidth = Dp.m9114constructorimpl(360.0f);
    private static final float SearchBarMaxWidth = Dp.m9114constructorimpl(720.0f);
    private static final float SearchBarVerticalPadding = Dp.m9114constructorimpl(8.0f);
    private static final float SearchBarIconOffsetX = Dp.m9114constructorimpl(4.0f);
    private static final float SearchBarPredictiveBackMinMargin = Dp.m9114constructorimpl(8.0f);
    private static final float SearchBarPredictiveBackMaxOffsetY = Dp.m9114constructorimpl(24.0f);

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tweenSpecTween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tweenSpecTween;
        TweenSpec tweenSpecTween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tweenSpecTween2;
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, cubicBezierEasing, 2, null);
        TweenSpec tweenSpecTween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tweenSpecTween3;
        TweenSpec tweenSpecTween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tweenSpecTween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tweenSpecTween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tweenSpecTween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tweenSpecTween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tweenSpecTween4, null, false, null, 14, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DetectClickFromInteractionSource(final InteractionSource interactionSource, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-652650823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DetectClickFromInteractionSource)N(interactionSource,onClick)2593@119695L148,2593@119661L182:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652650823, i2, -1, "androidx.compose.material3.DetectClickFromInteractionSource (SearchBar.kt:2592)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -132210195, "CC(remember):SearchBar.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            SearchBarKt$DetectClickFromInteractionSource$1$1 searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue = new SearchBarKt$DetectClickFromInteractionSource$1$1(interactionSource, function0, null);
                composerStartRestartGroup.updateRememberedValue(searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.DetectClickFromInteractionSource$lambda$73(interactionSource, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DetectClickFromInteractionSource$lambda$73(InteractionSource interactionSource, Function0 function0, int i, Composer composer, int i2) {
        DetectClickFromInteractionSource(interactionSource, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /* JADX INFO: renamed from: DockedSearchBar-EQC0FA8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3997DockedSearchBarEQC0FA8(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        int i4;
        float f3;
        int i5;
        float fM3991getShadowElevationD9Ej5fM;
        int i6;
        Composer composer2;
        final SearchBarColors searchBarColors2;
        final Modifier modifier3;
        final float f4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape dockedShape;
        int i7;
        int i8;
        Composer composer3;
        int i9;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        final SearchBarColors searchBarColors3;
        float f6;
        float f7;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2008777812);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DockedSearchBar)N(inputField,expanded,onExpandedChange,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)661@31616L38,665@31811L696,658@31522L985,686@32545L27,686@32513L59:SearchBar.kt#uh7d8r");
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
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    int i12 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(searchBarColors)) ? 131072 : 65536;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    f3 = f;
                    i3 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                    fM3991getShadowElevationD9Ej5fM = f2;
                } else {
                    fM3991getShadowElevationD9Ej5fM = f2;
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(fM3991getShadowElevationD9Ej5fM) ? 8388608 : 4194304;
                    }
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "652@31274L11,653@31335L8");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                            i7 = i6 & (-57345);
                        } else {
                            dockedShape = shape2;
                            i7 = i6;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = 0;
                            i8 = i5;
                            searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                            composer3 = composerStartRestartGroup;
                            i7 &= -458753;
                        } else {
                            i8 = i5;
                            composer3 = composerStartRestartGroup;
                            i9 = 0;
                            searchBarColorsM3987colorsKlgxPg = searchBarColors;
                        }
                        int i13 = i7;
                        float fM3992getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                        if (i8 != 0) {
                            fM3991getShadowElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM();
                        }
                        SearchBarColors searchBarColors4 = searchBarColorsM3987colorsKlgxPg;
                        shape2 = dockedShape;
                        searchBarColors3 = searchBarColors4;
                        f6 = fM3992getTonalElevationD9Ej5fM;
                        f7 = fM3991getShadowElevationD9Ej5fM;
                        i10 = i13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                        }
                        searchBarColors3 = searchBarColors;
                        f7 = fM3991getShadowElevationD9Ej5fM;
                        f6 = f3;
                        i10 = i6;
                        composer3 = composerStartRestartGroup;
                        i9 = 0;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2008777812, i10, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:657)");
                    }
                    long jM3984getContainerColor0d7_KjU = searchBarColors3.m3984getContainerColor0d7_KjU();
                    int i14 = i10;
                    long jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(searchBarColors3.m3984getContainerColor0d7_KjU(), composer3, i9);
                    SearchBarColors searchBarColors5 = searchBarColors3;
                    int i15 = i14 >> 6;
                    Composer composer4 = composer3;
                    Shape shape3 = shape2;
                    SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.m2088width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth), shape3, jM3984getContainerColor0d7_KjU, jM3479contentColorForek8zF_U, f6, f7, null, ComposableLambdaKt.rememberComposableLambda(401953073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i16) {
                            ComposerKt.sourceInformation(composer5, "C666@31821L680:SearchBar.kt#uh7d8r");
                            if (!composer5.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(401953073, i16, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:666)");
                            }
                            Function2<Composer, Integer, Unit> function22 = function2;
                            boolean z2 = z;
                            final SearchBarColors searchBarColors6 = searchBarColors3;
                            final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, 0);
                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, companion);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                composer5.createNode(constructor);
                            } else {
                                composer5.useNode();
                            }
                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer5);
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer5, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer5, -439279917, "C667@31842L12,673@32030L461,669@31868L623:SearchBar.kt#uh7d8r");
                            function22.invoke(composer5, 0);
                            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z2, (Modifier) null, SearchBarKt.DockedEnterTransition, SearchBarKt.DockedExitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(-1224554113, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$1$1$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, Integer num) {
                                    invoke(animatedVisibilityScope, composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, int i17) {
                                    ComposerKt.sourceInformation(composer6, "C674@32076L26,678@32301L176:SearchBar.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1224554113, i17, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:674)");
                                    }
                                    float fM9114constructorimpl = Dp.m9114constructorimpl(SearchBar_androidKt.getWindowContainerHeight(composer6, 0) * 0.6666667f);
                                    Modifier modifierM2070heightInVpY3zN4 = SizeKt.m2070heightInVpY3zN4(Modifier.INSTANCE, ((Dp) RangesKt.coerceAtMost(Dp.m9112boximpl(SearchBarKt.getDockedExpandedTableMinHeight()), Dp.m9112boximpl(fM9114constructorimpl))).m9128unboximpl(), fM9114constructorimpl);
                                    SearchBarColors searchBarColors7 = searchBarColors6;
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    ComposerKt.sourceInformationMarkerStart(composer6, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer6, 0);
                                    ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer6.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer6, modifierM2070heightInVpY3zN4);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer6.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer6.startReusableNode();
                                    if (composer6.getInserting()) {
                                        composer6.createNode(constructor2);
                                    } else {
                                        composer6.useNode();
                                    }
                                    Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer6);
                                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer6, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer6, -1564650142, "C679@32383L46,680@32450L9:SearchBar.kt#uh7d8r");
                                    DividerKt.m3615HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.m3985getDividerColor0d7_KjU(), composer6, 0, 3);
                                    function33.invoke(columnScopeInstance2, composer6, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                    composer6.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer5, 54), composer5, 1600518, 18);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer4, ((i14 >> 9) & 112) | 12582912 | (57344 & i15) | (i15 & 458752), 64);
                    shape2 = shape3;
                    composer2 = composer4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1995113209, "CC(remember):SearchBar.kt#9igjgp");
                    boolean z2 = (i14 & 896) == 256;
                    Object objRememberedValue = composer2.rememberedValue();
                    if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchBarKt.DockedSearchBar_EQC0FA8$lambda$24$lambda$23(function1);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BackHandler_androidKt.BackHandler(z, (Function0) objRememberedValue, composer2, (i14 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    searchBarColors2 = searchBarColors5;
                    modifier3 = modifier2;
                    f5 = f6;
                    f4 = f7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    searchBarColors2 = searchBarColors;
                    modifier3 = modifier2;
                    f4 = fM3991getShadowElevationD9Ej5fM;
                    f5 = f;
                }
                final Shape shape4 = shape2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchBarKt.DockedSearchBar_EQC0FA8$lambda$25(function2, z, function1, modifier3, shape4, searchBarColors2, f5, f4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 1572864;
            f3 = f;
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i6 & 1)) {
            }
            final Shape shape42 = shape2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) == 0) {
        }
        i4 = i2 & 64;
        if (i4 != 0) {
        }
        f3 = f;
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i6 & 1)) {
        }
        final Shape shape422 = shape2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "DockedSearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3998DockedSearchBareWTbjVg(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1<? super String, Unit> function14;
        int i5;
        final Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        final float f3;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i19;
        Shape dockedShape;
        boolean z5;
        Composer composer3;
        int i20;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        int i21;
        float fM3992getTonalElevationD9Ej5fM;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        SearchBarColors searchBarColors3;
        float f5;
        Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1929583712);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DockedSearchBar)N(query,onQueryChange,onSearch,active,onActiveChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,interactionSource,content)2048@96829L591,2047@96791L894:SearchBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function14 = function1;
        } else {
            function14 = function1;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function14) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function13) ? 16384 : 8192;
                    }
                    i5 = i3 & 32;
                    if (i5 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        modifier2 = modifier;
                    } else {
                        modifier2 = modifier;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                        }
                    }
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                        z3 = z2;
                    } else {
                        z3 = z2;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
                        }
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        function24 = function2;
                    } else {
                        function24 = function2;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        function25 = function22;
                    } else {
                        function25 = function22;
                        if ((i & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function25) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else {
                        if ((i & 805306368) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i11 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(shape)) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i11 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(searchBarColors)) ? 32 : 16;
                        }
                        int i22 = i11;
                        i12 = i3 & 4096;
                        if (i12 != 0) {
                            i13 = i22 | 384;
                        } else {
                            int i23 = i22;
                            if ((i2 & 384) == 0) {
                                i23 |= composerStartRestartGroup.changed(f) ? 256 : 128;
                            }
                            i13 = i23;
                        }
                        i14 = i3 & 8192;
                        if (i14 != 0) {
                            i15 = i13 | 3072;
                        } else {
                            int i24 = i13;
                            if ((i2 & 3072) == 0) {
                                i15 = i24 | (composerStartRestartGroup.changed(f2) ? 2048 : 1024);
                            } else {
                                i15 = i24;
                            }
                        }
                        i16 = i3 & 16384;
                        if (i16 != 0) {
                            i17 = i15 | 24576;
                        } else {
                            i17 = i15;
                            if ((i2 & 24576) == 0) {
                                i17 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                            }
                            if ((i3 & 32768) != 0) {
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i18 = i16;
                                    i17 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "2040@96486L11,2041@96547L8");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z7 = i6 != 0 ? true : z3;
                                        Function2<? super Composer, ? super Integer, Unit> function212 = i7 != 0 ? null : function24;
                                        if (i8 != 0) {
                                            function25 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function213 = i10 != 0 ? null : function23;
                                        if ((i3 & 1024) != 0) {
                                            i19 = i17 & (-15);
                                            dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                                        } else {
                                            i19 = i17;
                                            dockedShape = shape;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i20 = i4;
                                            composer3 = composerStartRestartGroup;
                                            z5 = true;
                                            searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composer3, 3072, 7);
                                            i21 = i19 & (-113);
                                        } else {
                                            z5 = true;
                                            composer3 = composerStartRestartGroup;
                                            i20 = i4;
                                            searchBarColorsM3987colorsKlgxPg = searchBarColors;
                                            i21 = i19;
                                        }
                                        fM3992getTonalElevationD9Ej5fM = i12 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                                        float fM3991getShadowElevationD9Ej5fM = i14 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                                        if (i18 != 0) {
                                            function29 = function25;
                                            searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                                            f5 = fM3991getShadowElevationD9Ej5fM;
                                            shape3 = dockedShape;
                                            mutableInteractionSource3 = null;
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            function29 = function25;
                                            searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                                            f5 = fM3991getShadowElevationD9Ej5fM;
                                            shape3 = dockedShape;
                                        }
                                        function210 = function213;
                                        modifier3 = companion;
                                        function211 = function212;
                                        z6 = z7;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 1024) != 0) {
                                            i17 &= -15;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i17 &= -113;
                                        }
                                        function210 = function23;
                                        searchBarColors3 = searchBarColors;
                                        f5 = f2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        function29 = function25;
                                        z5 = true;
                                        modifier3 = modifier2;
                                        z6 = z3;
                                        function211 = function24;
                                        composer3 = composerStartRestartGroup;
                                        i21 = i17;
                                        shape3 = shape;
                                        fM3992getTonalElevationD9Ej5fM = f;
                                        i20 = i4;
                                    }
                                    composer3.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1929583712, i20, i21, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:2047)");
                                    }
                                    final Function1<? super String, Unit> function15 = function14;
                                    final SearchBarColors searchBarColors4 = searchBarColors3;
                                    int i25 = i20 >> 6;
                                    int i26 = i21 << 12;
                                    Composer composer4 = composer3;
                                    float f6 = fM3992getTonalElevationD9Ej5fM;
                                    m3997DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-1275782414, z5, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i27) {
                                            ComposerKt.sourceInformation(composer5, "C2049@96861L549:SearchBar.kt#uh7d8r");
                                            if (!composer5.shouldExecute((i27 & 3) != 2, i27 & 1)) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1275782414, i27, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:2049)");
                                            }
                                            SearchBarDefaults.INSTANCE.InputField(str, function15, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, function211, function29, function210, searchBarColors4.getInputFieldColors(), mutableInteractionSource3, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 384, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), z, function13, modifier3, shape3, searchBarColors3, f6, f5, function3, composer4, (i25 & 7168) | (i25 & 112) | 6 | (i25 & 896) | (57344 & i26) | (458752 & i26) | (3670016 & i26) | (i26 & 29360128) | ((i21 << 9) & 234881024), 0);
                                    SearchBarColors searchBarColors5 = searchBarColors3;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    f3 = f5;
                                    composer2 = composer4;
                                    searchBarColors2 = searchBarColors5;
                                    z4 = z6;
                                    function26 = function29;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    shape2 = shape3;
                                    f4 = f6;
                                    function27 = function211;
                                    function28 = function210;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    shape2 = shape;
                                    searchBarColors2 = searchBarColors;
                                    f3 = f2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    function26 = function25;
                                    z4 = z3;
                                    function27 = function24;
                                    composer2 = composerStartRestartGroup;
                                    function28 = function23;
                                    f4 = f;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return SearchBarKt.DockedSearchBar_eWTbjVg$lambda$29(str, function1, function12, z, function13, modifier2, z4, function27, function26, function28, shape2, searchBarColors2, f4, f3, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i17 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            i18 = i16;
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        if ((i3 & 32768) != 0) {
                        }
                        i18 = i16;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i10 = i9;
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    int i222 = i11;
                    i12 = i3 & 4096;
                    if (i12 != 0) {
                    }
                    i14 = i3 & 8192;
                    if (i14 != 0) {
                    }
                    i16 = i3 & 16384;
                    if (i16 != 0) {
                    }
                    if ((i3 & 32768) != 0) {
                    }
                    i18 = i16;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i5 = i3 & 32;
                if (i5 == 0) {
                }
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i2222 = i11;
                i12 = i3 & 4096;
                if (i12 != 0) {
                }
                i14 = i3 & 8192;
                if (i14 != 0) {
                }
                i16 = i3 & 16384;
                if (i16 != 0) {
                }
                if ((i3 & 32768) != 0) {
                }
                i18 = i16;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 == 0) {
            }
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i22222 = i11;
            i12 = i3 & 4096;
            if (i12 != 0) {
            }
            i14 = i3 & 8192;
            if (i14 != 0) {
            }
            i16 = i3 & 16384;
            if (i16 != 0) {
            }
            if ((i3 & 32768) != 0) {
            }
            i18 = i16;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i222222 = i11;
        i12 = i3 & 4096;
        if (i12 != 0) {
        }
        i14 = i3 & 8192;
        if (i14 != 0) {
        }
        i16 = i3 & 16384;
        if (i16 != 0) {
        }
        if ((i3 & 32768) != 0) {
        }
        i18 = i16;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i17 & 74899) == 74898) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DockedSearchBarLayout-nbWgWpA, reason: not valid java name */
    public static final void m3999DockedSearchBarLayoutnbWgWpA(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Shape shape, final SearchBarColors searchBarColors, final float f, final float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Modifier modifier2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1402423467);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DockedSearchBarLayout)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)2324@107586L24,2325@107655L47,2325@107615L87,2330@107802L38,2334@107974L2233,2327@107708L2499:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            modifier2 = modifier;
            i2 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(searchBarColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1402423467, i2, -1, "androidx.compose.material3.DockedSearchBarLayout (SearchBar.kt:2323)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zIsExpanded = isExpanded(searchBarState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -890765926, "CC(remember):SearchBar.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchBarKt.DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(coroutineScope, searchBarState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandler_androidKt.BackHandler(zIsExpanded, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 0);
            int i3 = i2 >> 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4145SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(modifier2), shape, searchBarColors.m3984getContainerColor0d7_KjU(), ColorSchemeKt.m3479contentColorForek8zF_U(searchBarColors.m3984getContainerColor0d7_KjU(), composerStartRestartGroup, 0), f, f2, null, ComposableLambdaKt.rememberComposableLambda(-956905210, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C2335@108012L26,2343@108320L195,2350@108545L1656,2339@108213L1988:SearchBar.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-956905210, i4, -1, "androidx.compose.material3.DockedSearchBarLayout.<anonymous> (SearchBar.kt:2335)");
                    }
                    float fM9114constructorimpl = Dp.m9114constructorimpl(SearchBar_androidKt.getWindowContainerHeight(composer3, 0) * 0.6666667f);
                    float fM9128unboximpl = ((Dp) RangesKt.coerceAtMost(Dp.m9112boximpl(SearchBarKt.getDockedExpandedTableMinHeight()), Dp.m9112boximpl(fM9114constructorimpl))).m9128unboximpl();
                    final SearchBarColors searchBarColors2 = searchBarColors;
                    final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, ComposableLambdaKt.rememberComposableLambda(-1776541672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i5) {
                            ComposerKt.sourceInformation(composer4, "C2344@108346L147:SearchBar.kt#uh7d8r");
                            if (!composer4.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1776541672, i5, -1, "androidx.compose.material3.DockedSearchBarLayout.<anonymous>.<anonymous> (SearchBar.kt:2344)");
                            }
                            SearchBarColors searchBarColors3 = searchBarColors2;
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, companion);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer4);
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, 1313930401, "C2345@108383L46,2346@108458L9:SearchBar.kt#uh7d8r");
                            DividerKt.m3615HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors3.m3985getDividerColor0d7_KjU(), composer4, 0, 3);
                            function33.invoke(columnScopeInstance, composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54)});
                    ComposerKt.sourceInformationMarkerStart(composer3, -462885538, "CC(remember):SearchBar.kt#9igjgp");
                    boolean zChanged = composer3.changed(searchBarState) | composer3.changed(fM9114constructorimpl) | composer3.changed(fM9128unboximpl);
                    SearchBarState searchBarState2 = searchBarState;
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (MultiContentMeasurePolicy) new SearchBarKt$DockedSearchBarLayout$2$2$1(searchBarState2, fM9114constructorimpl, fM9128unboximpl);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composer3, -290764973, "CC(remember):Layout.kt#9igjgp");
                    boolean zChanged2 = composer3.changed(multiContentMeasurePolicy);
                    Object objRememberedValue4 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, ((i2 >> 6) & 112) | 12582912 | (57344 & i3) | (i3 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.DockedSearchBarLayout_nbWgWpA$lambda$52(searchBarState, function2, modifier3, shape, searchBarColors, f, f2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$DockedSearchBarLayout$1$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBarLayout_nbWgWpA$lambda$52(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function3 function3, int i, Composer composer, int i2) {
        m3999DockedSearchBarLayoutnbWgWpA(searchBarState, function2, modifier, shape, searchBarColors, f, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBar_EQC0FA8$lambda$24$lambda$23(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBar_EQC0FA8$lambda$25(Function2 function2, boolean z, Function1 function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3997DockedSearchBarEQC0FA8(function2, z, function1, modifier, shape, searchBarColors, f, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBar_eWTbjVg$lambda$29(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3998DockedSearchBareWTbjVg(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, shape, searchBarColors, f, f2, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f6  */
    /* JADX INFO: renamed from: ExpandedDockedSearchBar-qKj4JfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4000ExpandedDockedSearchBarqKj4JfE(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Shape dockedShape;
        SearchBarColors searchBarColors2;
        int i4;
        float f3;
        int i5;
        int i6;
        PopupProperties popupProperties2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        final PopupProperties popupProperties3;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape2;
        final SearchBarColors searchBarColors3;
        final float f4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composer3;
        boolean z;
        int i7;
        final SearchBarColors searchBarColorsM3987colorsKlgxPg;
        final PopupProperties popupProperties4;
        boolean z2;
        final Shape shape3;
        final float f6;
        int i8;
        final Modifier modifier4;
        final float f7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1121062437);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpandedDockedSearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,properties,content)439@21817L380,450@22215L24,454@22329L47,456@22417L1212,452@22245L1384:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    dockedShape = shape;
                    int i10 = composerStartRestartGroup.changed(dockedShape) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    dockedShape = shape;
                }
                i3 |= i10;
            } else {
                dockedShape = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    searchBarColors2 = searchBarColors;
                    int i11 = composerStartRestartGroup.changed(searchBarColors2) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    searchBarColors2 = searchBarColors;
                }
                i3 |= i11;
            } else {
                searchBarColors2 = searchBarColors;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i) == 0) {
                    f3 = f;
                    i3 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        i3 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else {
                        if ((12582912 & i) == 0) {
                            popupProperties2 = popupProperties;
                            i3 |= composerStartRestartGroup.changed(popupProperties2) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) == 0) {
                            if ((i & 100663296) == 0) {
                                function32 = function3;
                                i3 |= composerStartRestartGroup.changedInstance(function32) ? 67108864 : 33554432;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                popupProperties3 = popupProperties;
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier2;
                                shape2 = dockedShape;
                                searchBarColors3 = searchBarColors2;
                                f4 = f;
                                f5 = f2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "429@21409L11,430@21470L8");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i9 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        dockedShape = SearchBarDefaults.INSTANCE.getDockedShape(composerStartRestartGroup, 6);
                                    }
                                    if ((i2 & 16) != 0) {
                                        z = true;
                                        i7 = i6;
                                        searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                                        composer3 = composerStartRestartGroup;
                                        i3 = (-57345) & i3;
                                    } else {
                                        composer3 = composerStartRestartGroup;
                                        z = true;
                                        i7 = i6;
                                        searchBarColorsM3987colorsKlgxPg = searchBarColors2;
                                    }
                                    float fM3992getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                                    float fM3991getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                                    if (i7 != 0) {
                                        z2 = z;
                                        shape3 = dockedShape;
                                        f6 = fM3991getShadowElevationD9Ej5fM;
                                        popupProperties4 = new PopupProperties(true, false, false, false, 6, (DefaultConstructorMarker) null);
                                    } else {
                                        popupProperties4 = popupProperties;
                                        z2 = z;
                                        shape3 = dockedShape;
                                        f6 = fM3991getShadowElevationD9Ej5fM;
                                    }
                                    i8 = i3;
                                    modifier4 = modifier2;
                                    f7 = fM3992getTonalElevationD9Ej5fM;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    SearchBarColors searchBarColors4 = searchBarColors2;
                                    i8 = i3;
                                    modifier4 = modifier2;
                                    f7 = f3;
                                    composer3 = composerStartRestartGroup;
                                    searchBarColorsM3987colorsKlgxPg = searchBarColors4;
                                    shape3 = dockedShape;
                                    z2 = true;
                                    popupProperties4 = popupProperties2;
                                    f6 = f2;
                                }
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1121062437, i8, -1, "androidx.compose.material3.ExpandedDockedSearchBar (SearchBar.kt:435)");
                                }
                                if (!isExpanded(searchBarState)) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        final Modifier modifier5 = modifier4;
                                        function22 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda23
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return SearchBarKt.ExpandedDockedSearchBar_qKj4JfE$lambda$10(searchBarState, function2, modifier5, shape3, searchBarColorsM3987colorsKlgxPg, f7, f6, popupProperties4, function33, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        };
                                        scopeUpdateScopeEndRestartGroup.updateScope(function22);
                                        return;
                                    }
                                    return;
                                }
                                PopupProperties popupProperties5 = popupProperties4;
                                ComposerKt.sourceInformationMarkerStart(composer3, 695809367, "CC(remember):SearchBar.kt#9igjgp");
                                int i12 = i8 & 14;
                                boolean z3 = i12 == 4 ? z2 : false;
                                Object objRememberedValue = composer3.rememberedValue();
                                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new PopupPositionProvider() { // from class: androidx.compose.material3.SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1
                                        @Override // androidx.compose.ui.window.PopupPositionProvider
                                        /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
                                        public long mo1592calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
                                            return SearchBarKt.getCollapsedBounds(searchBarState).m9271getTopLeftnOccac();
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 searchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 = (SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 searchBarKt$ExpandedDockedSearchBar$positionProvider$1$12 = searchBarKt$ExpandedDockedSearchBar$positionProvider$1$1;
                                ComposerKt.sourceInformationMarkerStart(composer3, 695825418, "CC(remember):SearchBar.kt#9igjgp");
                                boolean zChangedInstance = composer3.changedInstance(coroutineScope) | (i12 == 4 ? z2 : false);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda24
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return SearchBarKt.ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(coroutineScope, searchBarState);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                final Shape shape4 = shape3;
                                final SearchBarColors searchBarColors5 = searchBarColorsM3987colorsKlgxPg;
                                final float f8 = f7;
                                final float f9 = f6;
                                Modifier modifier6 = modifier4;
                                Composer composer4 = composer3;
                                AndroidPopup_androidKt.Popup(searchBarKt$ExpandedDockedSearchBar$positionProvider$1$12, (Function0) objRememberedValue3, popupProperties5, ComposableLambdaKt.rememberComposableLambda(-363177991, z2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedDockedSearchBar$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i13) {
                                        ComposerKt.sourceInformation(composer5, "C457@22448L29,461@22562L231,459@22487L529,479@23166L33,479@23145L54,483@23432L7,484@23482L141,484@23448L175:SearchBar.kt#uh7d8r");
                                        if (!composer5.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-363177991, i13, -1, "androidx.compose.material3.ExpandedDockedSearchBar.<anonymous> (SearchBar.kt:457)");
                                        }
                                        ComposerKt.sourceInformationMarkerStart(composer5, -1121697354, "CC(remember):SearchBar.kt#9igjgp");
                                        Object objRememberedValue4 = composer5.rememberedValue();
                                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue4 = new FocusRequester();
                                            composer5.updateRememberedValue(objRememberedValue4);
                                        }
                                        final FocusRequester focusRequester = (FocusRequester) objRememberedValue4;
                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                        SearchBarState searchBarState2 = searchBarState;
                                        final Function2<Composer, Integer, Unit> function23 = function2;
                                        SearchBarKt.m3999DockedSearchBarLayoutnbWgWpA(searchBarState2, ComposableLambdaKt.rememberComposableLambda(2123999554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedDockedSearchBar$3.1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer6, int i14) {
                                                ComposerKt.sourceInformation(composer6, "C462@22580L199:SearchBar.kt#uh7d8r");
                                                if (!composer6.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2123999554, i14, -1, "androidx.compose.material3.ExpandedDockedSearchBar.<anonymous>.<anonymous> (SearchBar.kt:462)");
                                                }
                                                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
                                                Function2<Composer, Integer, Unit> function24 = function23;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer6, modifierFocusRequester);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                if (!(composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer6.startReusableNode();
                                                if (composer6.getInserting()) {
                                                    composer6.createNode(constructor);
                                                } else {
                                                    composer6.useNode();
                                                }
                                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer6);
                                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer6, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 1558467823, "C466@22749L12:SearchBar.kt#uh7d8r");
                                                function24.invoke(composer6, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                composer6.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer5, 54), modifier4, shape4, searchBarColors5, f8, f9, function3, composer5, 48);
                                        Unit unit = Unit.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer5, -1121674374, "CC(remember):SearchBar.kt#9igjgp");
                                        Object objRememberedValue5 = composer5.rememberedValue();
                                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue5 = (Function2) new SearchBarKt$ExpandedDockedSearchBar$3$2$1(focusRequester, null);
                                            composer5.updateRememberedValue(objRememberedValue5);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer5, 6);
                                        ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer5.consume(localSoftwareKeyboardController);
                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
                                        SearchBarValue targetValue = searchBarState.getTargetValue();
                                        ComposerKt.sourceInformationMarkerStart(composer5, -1121664154, "CC(remember):SearchBar.kt#9igjgp");
                                        boolean zChanged = composer5.changed(searchBarState) | composer5.changed(softwareKeyboardController);
                                        SearchBarState searchBarState3 = searchBarState;
                                        Object objRememberedValue6 = composer5.rememberedValue();
                                        if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue6 = (Function2) new SearchBarKt$ExpandedDockedSearchBar$3$3$1(searchBarState3, softwareKeyboardController, null);
                                            composer5.updateRememberedValue(objRememberedValue6);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                        EffectsKt.LaunchedEffect(targetValue, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composer5, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer4, ((i8 >> 15) & 896) | 3072, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier6;
                                composer2 = composer4;
                                shape2 = shape4;
                                searchBarColors3 = searchBarColors5;
                                popupProperties3 = popupProperties5;
                                f4 = f8;
                                f5 = f9;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                function22 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda25
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SearchBarKt.ExpandedDockedSearchBar_qKj4JfE$lambda$14(searchBarState, function2, modifier3, shape2, searchBarColors3, f4, f5, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                scopeUpdateScopeEndRestartGroup.updateScope(function22);
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        function32 = function3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    popupProperties2 = popupProperties;
                    if ((i2 & 256) == 0) {
                    }
                    function32 = function3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                popupProperties2 = popupProperties;
                if ((i2 & 256) == 0) {
                }
                function32 = function3;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f3 = f;
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 256) == 0) {
            }
            function32 = function3;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 256) == 0) {
        }
        function32 = function3;
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$10(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4000ExpandedDockedSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f, f2, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$ExpandedDockedSearchBar$2$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$14(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4000ExpandedDockedSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f, f2, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /* JADX INFO: renamed from: ExpandedFullScreenSearchBar-_UtchM0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4001ExpandedFullScreenSearchBar_UtchM0(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, DialogProperties dialogProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Shape shape2;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        int i4;
        float f3;
        int i5;
        float f4;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function24;
        int i6;
        final float f5;
        final DialogProperties dialogProperties2;
        final Modifier modifier3;
        final Shape shape3;
        final SearchBarColors searchBarColors2;
        Composer composer2;
        final float f6;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function25;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape inputFieldShape;
        boolean z;
        Composer composer3;
        SearchBarKt$ExpandedFullScreenSearchBar$1 searchBarKt$ExpandedFullScreenSearchBar$1;
        final DialogProperties dialogProperties3;
        final float f7;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function27;
        final SearchBarColors searchBarColors3;
        final Shape shape4;
        int i7;
        final Modifier modifier4;
        final float f8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-909632031);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpandedFullScreenSearchBar)N(state,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,properties,content)356@17952L24,359@18032L56,361@18129L1354,358@17982L1501:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    int i9 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                    int i10 = composerStartRestartGroup.changed(searchBarColorsM3987colorsKlgxPg) ? 16384 : 8192;
                    i3 |= i10;
                } else {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                }
                i3 |= i10;
            } else {
                searchBarColorsM3987colorsKlgxPg = searchBarColors;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    f3 = f;
                    i3 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        f4 = f2;
                        i3 |= composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                    }
                    if ((12582912 & i) != 0) {
                        if ((i2 & 128) == 0) {
                            function24 = function22;
                            int i11 = composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                            i3 |= i11;
                        } else {
                            function24 = function22;
                        }
                        i3 |= i11;
                    } else {
                        function24 = function22;
                    }
                    i6 = i2 & 256;
                    if (i6 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= composerStartRestartGroup.changed(dialogProperties) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((i & 805306368) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "346@17492L15,347@17557L8");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                                } else {
                                    inputFieldShape = shape2;
                                }
                                int i12 = i3;
                                if ((i2 & 16) != 0) {
                                    z = true;
                                    composer3 = composerStartRestartGroup;
                                    i12 &= -57345;
                                    searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                                } else {
                                    z = true;
                                    composer3 = composerStartRestartGroup;
                                }
                                float fM3992getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                                float fM3991getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                                if ((i2 & 128) != 0) {
                                    searchBarKt$ExpandedFullScreenSearchBar$1 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$1
                                        public final WindowInsets invoke(Composer composer4, int i13) {
                                            composer4.startReplaceGroup(-2028768625);
                                            ComposerKt.sourceInformation(composer4, "C350@17758L22:SearchBar.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2028768625, i13, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar.<anonymous> (SearchBar.kt:350)");
                                            }
                                            WindowInsets fullScreenWindowInsets = SearchBarDefaults.INSTANCE.getFullScreenWindowInsets(composer4, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer4.endReplaceGroup();
                                            return fullScreenWindowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer4, Integer num) {
                                            return invoke(composer4, num.intValue());
                                        }
                                    };
                                    i12 &= -29360129;
                                } else {
                                    searchBarKt$ExpandedFullScreenSearchBar$1 = function22;
                                }
                                dialogProperties3 = i6 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
                                f7 = fM3991getShadowElevationD9Ej5fM;
                                function27 = searchBarKt$ExpandedFullScreenSearchBar$1;
                                searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                                shape4 = inputFieldShape;
                                i7 = i12;
                                modifier4 = companion;
                                f8 = fM3992getTonalElevationD9Ej5fM;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                i7 = i3;
                                z = true;
                                modifier4 = modifier2;
                                shape4 = shape2;
                                searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                                f8 = f3;
                                function27 = function24;
                                composer3 = composerStartRestartGroup;
                                f7 = f4;
                                dialogProperties3 = dialogProperties;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-909632031, i7, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar (SearchBar.kt:353)");
                            }
                            if (!isExpanded(searchBarState)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function23;
                                    function26 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return SearchBarKt.ExpandedFullScreenSearchBar__UtchM0$lambda$6(searchBarState, function28, modifier4, shape4, searchBarColors3, f8, f7, function27, dialogProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    };
                                    scopeUpdateScopeEndRestartGroup.updateScope(function26);
                                    return;
                                }
                                return;
                            }
                            DialogProperties dialogProperties4 = dialogProperties3;
                            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerStart(composer3, 2016970937, "CC(remember):SearchBar.kt#9igjgp");
                            boolean zChangedInstance = composer3.changedInstance(coroutineScope) | ((i7 & 14) == 4 ? z : false);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return SearchBarKt.ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(coroutineScope, searchBarState);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            final Modifier modifier5 = modifier4;
                            final Shape shape5 = shape4;
                            final SearchBarColors searchBarColors4 = searchBarColors3;
                            final float f9 = f8;
                            final float f10 = f7;
                            final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function29 = function27;
                            Composer composer4 = composer3;
                            BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog((Function0) objRememberedValue2, null, dialogProperties4, false, false, ComposableLambdaKt.rememberComposableLambda(625093617, z, new Function3<PredictiveBackState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$4
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(PredictiveBackState predictiveBackState, Composer composer5, Integer num) {
                                    invoke(predictiveBackState, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(PredictiveBackState predictiveBackState, Composer composer5, int i13) {
                                    int i14;
                                    ComposerKt.sourceInformation(composer5, "CN(predictiveBackState)362@18183L29,366@18355L231,379@18814L14,363@18221L649,385@19020L33,385@18999L54,389@19286L7,390@19336L141,390@19302L175:SearchBar.kt#uh7d8r");
                                    if ((i13 & 6) == 0) {
                                        i14 = i13 | ((i13 & 8) == 0 ? composer5.changed(predictiveBackState) : composer5.changedInstance(predictiveBackState) ? 4 : 2);
                                    } else {
                                        i14 = i13;
                                    }
                                    if (!composer5.shouldExecute((i14 & 19) != 18, i14 & 1)) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(625093617, i14, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar.<anonymous> (SearchBar.kt:362)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer5, -580453746, "CC(remember):SearchBar.kt#9igjgp");
                                    Object objRememberedValue3 = composer5.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new FocusRequester();
                                        composer5.updateRememberedValue(objRememberedValue3);
                                    }
                                    final FocusRequester focusRequester = (FocusRequester) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    int i15 = i14;
                                    SearchBarState searchBarState2 = searchBarState;
                                    final Function2<Composer, Integer, Unit> function210 = function2;
                                    SearchBarKt.m4002FullScreenSearchBarLayoutEQC0FA8(searchBarState2, predictiveBackState, ComposableLambdaKt.rememberComposableLambda(-2142632188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$4.1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i16) {
                                            ComposerKt.sourceInformation(composer6, "C367@18373L199:SearchBar.kt#uh7d8r");
                                            if (!composer6.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2142632188, i16, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar.<anonymous>.<anonymous> (SearchBar.kt:367)");
                                            }
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
                                            Function2<Composer, Integer, Unit> function211 = function210;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer6, modifierFocusRequester);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer6.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor);
                                            } else {
                                                composer6.useNode();
                                            }
                                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer6);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer6, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 1606432749, "C371@18542L12:SearchBar.kt#uh7d8r");
                                            function211.invoke(composer6, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            composer6.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer5, 54), modifier5, shape5, searchBarColors4, f9, f10, function29.invoke(composer5, 0), function3, composer5, ((i15 << 3) & 112) | 384);
                                    Unit unit = Unit.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, -580426958, "CC(remember):SearchBar.kt#9igjgp");
                                    Object objRememberedValue4 = composer5.rememberedValue();
                                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = (Function2) new SearchBarKt$ExpandedFullScreenSearchBar$4$2$1(focusRequester, null);
                                        composer5.updateRememberedValue(objRememberedValue4);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composer5, 6);
                                    ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume = composer5.consume(localSoftwareKeyboardController);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
                                    SearchBarValue targetValue = searchBarState.getTargetValue();
                                    ComposerKt.sourceInformationMarkerStart(composer5, -580416738, "CC(remember):SearchBar.kt#9igjgp");
                                    boolean zChanged = composer5.changed(searchBarState) | composer5.changed(softwareKeyboardController);
                                    SearchBarState searchBarState3 = searchBarState;
                                    Object objRememberedValue5 = composer5.rememberedValue();
                                    if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = (Function2) new SearchBarKt$ExpandedFullScreenSearchBar$4$3$1(searchBarState3, softwareKeyboardController, null);
                                        composer5.updateRememberedValue(objRememberedValue5);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    EffectsKt.LaunchedEffect(targetValue, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer5, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer4, ((i7 >> 18) & 896) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            dialogProperties2 = dialogProperties4;
                            composer2 = composer4;
                            searchBarColors2 = searchBarColors4;
                            f6 = f9;
                            f5 = f10;
                            function25 = function29;
                            shape3 = shape5;
                            modifier3 = modifier5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            f5 = f2;
                            dialogProperties2 = dialogProperties;
                            modifier3 = modifier2;
                            shape3 = shape2;
                            searchBarColors2 = searchBarColorsM3987colorsKlgxPg;
                            composer2 = composerStartRestartGroup;
                            f6 = f;
                            function25 = function22;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            function26 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SearchBarKt.ExpandedFullScreenSearchBar__UtchM0$lambda$9(searchBarState, function2, modifier3, shape3, searchBarColors2, f6, f5, function25, dialogProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            scopeUpdateScopeEndRestartGroup.updateScope(function26);
                            return;
                        }
                        return;
                    }
                    i3 |= 805306368;
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                f4 = f2;
                if ((12582912 & i) != 0) {
                }
                i6 = i2 & 256;
                if (i6 == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            f3 = f;
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            f4 = f2;
            if ((12582912 & i) != 0) {
            }
            i6 = i2 & 256;
            if (i6 == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        f4 = f2;
        if ((12582912 & i) != 0) {
        }
        i6 = i2 & 256;
        if (i6 == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$6(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function2 function22, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4001ExpandedFullScreenSearchBar_UtchM0(searchBarState, function2, modifier, shape, searchBarColors, f, f2, function22, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$ExpandedFullScreenSearchBar$3$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$9(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function2 function22, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4001ExpandedFullScreenSearchBar_UtchM0(searchBarState, function2, modifier, shape, searchBarColors, f, f2, function22, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: FullScreenSearchBarLayout-EQC0FA8, reason: not valid java name */
    public static final void m4002FullScreenSearchBarLayoutEQC0FA8(final SearchBarState searchBarState, final PredictiveBackState predictiveBackState, final Function2<? super Composer, ? super Integer, Unit> function2, final Modifier modifier, final Shape shape, final SearchBarColors searchBarColors, final float f, final float f2, final WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        State state;
        final MutableState mutableState;
        int i3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-740838201);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FullScreenSearchBarLayout)N(state,predictiveBackState,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2399@110650L57,2401@110747L64,2410@111159L64,2419@111546L7,2420@111598L15,2422@111646L1042,2447@112954L34,2453@113205L120,2484@114348L4812,2450@113110L6050:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(predictiveBackState) : composerStartRestartGroup.changedInstance(predictiveBackState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(searchBarColors) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740838201, i2, -1, "androidx.compose.material3.FullScreenSearchBarLayout (SearchBar.kt:2398)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019074080, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return predictiveBackState.getValue();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            State state2 = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019077191, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackEventProgress backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(state2);
            if (backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55 instanceof BackEventProgress.InProgress) {
                if (mutableState2.getValue() == null) {
                    mutableState2.setValue(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55);
                }
            } else if (Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55, BackEventProgress.NotRunning.INSTANCE)) {
                mutableState2.setValue(null);
            } else if (!Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55, BackEventProgress.Completed.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019090375, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                state = state2;
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                state = state2;
            }
            MutableState mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackEventProgress backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(state);
            if (backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552 instanceof BackEventProgress.InProgress) {
                mutableState3.setValue(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552);
            } else if (Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552, BackEventProgress.NotRunning.INSTANCE)) {
                mutableState3.setValue(null);
            } else if (!Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552, BackEventProgress.Completed.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            int i5 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            final Shape fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019106937, "CC(remember):SearchBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(fullScreenShape);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState3;
                i3 = i5;
                i4 = 1;
                GenericShape genericShape = new GenericShape(new Function3() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(shape, fullScreenShape, density, searchBarState, mutableState, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(genericShape);
                objRememberedValue4 = genericShape;
            } else {
                mutableState = mutableState3;
                i3 = i5;
                i4 = 1;
            }
            GenericShape genericShape2 = (GenericShape) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019147785, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new MutableWindowInsets(null, i4, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            WindowInsets windowInsetsM2110onlybOOhFvg = WindowInsetsKt.m2110onlybOOhFvg(mutableWindowInsets.getInsets(), WindowInsetsSides.m2122plusgK_yJZ4(WindowInsetsSides.INSTANCE.m2132getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m2130getBottomJoeWqyM()));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019155903, "CC(remember):SearchBar.kt#9igjgp");
            int i6 = (i3 & 234881024) == 67108864 ? i4 : 0;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (i6 != 0 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(mutableWindowInsets, windowInsets, (WindowInsets) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier, (Function1) objRememberedValue6), windowInsets);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019197171, "CC(remember):SearchBar.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState) | ((i3 & 14) == 4) | composerStartRestartGroup.changed(mutableState2);
            SearchBarKt$FullScreenSearchBarLayout$2$1 searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue = new SearchBarKt$FullScreenSearchBarLayout$2$1(mutableState, searchBarState, mutableWindowInsets, mutableState2);
                composerStartRestartGroup.updateRememberedValue(searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierConsumeWindowInsets);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1312429125, "C2461@113581L17,2458@113410L297,2471@113910L38,2467@113721L372,2478@114193L17,2477@114107L223:SearchBar.kt#uh7d8r");
            Modifier modifierPadding = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdInputField), WindowInsetsKt.asPaddingValues(WindowInsetsKt.m2110onlybOOhFvg(windowInsetsM2110onlybOOhFvg, WindowInsetsSides.INSTANCE.m2132getHorizontalJoeWqyM()), composerStartRestartGroup, 0));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 714795213, "C2464@113681L12:SearchBar.kt#uh7d8r");
            int i7 = i3 >> 6;
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i7 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SurfaceKt.m4145SurfaceT9BRK9s(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSurface), genericShape2, searchBarColors.m3984getContainerColor0d7_KjU(), ColorSchemeKt.m3479contentColorForek8zF_U(searchBarColors.m3984getContainerColor0d7_KjU(), composerStartRestartGroup, 0), f, f2, null, ComposableSingletons$SearchBarKt.INSTANCE.m3521getLambda$1146652811$material3(), composerStartRestartGroup, (57344 & i7) | 12582918 | (i7 & 458752), 64);
            composer2 = composerStartRestartGroup;
            Modifier modifierPadding2 = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSearchContent), WindowInsetsKt.asPaddingValues(windowInsetsM2110onlybOOhFvg, composer2, 0));
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierPadding2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1748770687, "C2480@114244L46,2481@114307L9:SearchBar.kt#uh7d8r");
            DividerKt.m3615HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors.m3985getDividerColor0d7_KjU(), composer2, 0, 3);
            function3.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i3 >> 24) & 112)));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$70(searchBarState, predictiveBackState, function2, modifier, shape, searchBarColors, f, f2, windowInsets, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$55(State<? extends BackEventProgress> state) {
        return state.getValue();
    }

    static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(Shape shape, Shape shape2, Density density, SearchBarState searchBarState, MutableState mutableState, Path path, Size size, LayoutDirection layoutDirection) {
        if (shape == RoundedCornerShapeKt.getCircleShape() && shape2 == RectangleShapeKt.getRectangleShape()) {
            float fMo1624toPx0680j_4 = density.mo1624toPx0680j_4(Dp.m9114constructorimpl(SearchBarCornerRadius * Math.max(1.0f - searchBarState.getProgress(), transform((BackEventProgress.InProgress) mutableState.getValue()))));
            if (fMo1624toPx0680j_4 < 0.001d) {
                Path.addRect$default(path, androidx.compose.ui.geometry.SizeKt.m6170toRectuvyYCjk(size.m6154unboximpl()), null, 2, null);
            } else {
                Path.addRoundRect$default(path, RoundRectKt.m6135RoundRectsniSvfs(androidx.compose.ui.geometry.SizeKt.m6170toRectuvyYCjk(size.m6154unboximpl()), CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(fMo1624toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo1624toPx0680j_4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
            }
        } else {
            if (searchBarState.getProgress() >= 0.5f) {
                shape = shape2;
            }
            OutlineKt.addOutline(path, shape.mo1539createOutlinePq9zytI(size.m6154unboximpl(), layoutDirection, density));
        }
        return Unit.INSTANCE;
    }

    static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$70(SearchBarState searchBarState, PredictiveBackState predictiveBackState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, Function3 function3, int i, Composer composer, int i2) {
        m4002FullScreenSearchBarLayoutEQC0FA8(searchBarState, predictiveBackState, function2, modifier, shape, searchBarColors, f, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "SearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    windowInsets = windowInsets,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4003SearchBarWuY5d9Q(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        String str2;
        int i4;
        int i5;
        final Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        final float f3;
        final WindowInsets windowInsets2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape inputFieldShape;
        Composer composer3;
        int i18;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        float fM3992getTonalElevationD9Ej5fM;
        WindowInsets windowInsets3;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final SearchBarColors searchBarColors3;
        float f5;
        WindowInsets windowInsets4;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        Shape shape3;
        Modifier modifier3;
        final boolean z5;
        int i19;
        Composer composerStartRestartGroup = composer.startRestartGroup(1506988286);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBar)N(query,onQueryChange,onSearch,active,onActiveChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,interactionSource,content)1968@93682L591,1967@93650L925:SearchBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                int i20 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function13) ? 16384 : 8192;
                    }
                    i5 = i3 & 32;
                    if (i5 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        modifier2 = modifier;
                    } else {
                        modifier2 = modifier;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                        }
                    }
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                        z3 = z2;
                    } else {
                        z3 = z2;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
                        }
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        function24 = function2;
                    } else {
                        function24 = function2;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        function25 = function22;
                    } else {
                        function25 = function22;
                        if ((i & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function25) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else {
                        if ((i & 805306368) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i11 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(shape)) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i11 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(searchBarColors)) ? 32 : 16;
                        }
                        int i21 = i11;
                        i12 = i3 & 4096;
                        if (i12 != 0) {
                            i13 = i21 | 384;
                        } else {
                            int i22 = i21;
                            if ((i2 & 384) == 0) {
                                i22 |= composerStartRestartGroup.changed(f) ? 256 : 128;
                            }
                            i13 = i22;
                        }
                        i14 = i3 & 8192;
                        if (i14 != 0) {
                            i15 = i13 | 3072;
                        } else {
                            i15 = i13;
                            if ((i2 & 3072) == 0) {
                                i15 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
                            }
                            if ((i2 & 24576) == 0) {
                                if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(windowInsets)) {
                                    i20 = 16384;
                                }
                                i15 |= i20;
                            }
                            i16 = i3 & 32768;
                            if (i16 != 0) {
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i17 = i14;
                                    i15 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
                                }
                                if ((i3 & 65536) != 0) {
                                    i15 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i15 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "1959@93276L15,1960@93341L8,1963@93522L12");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z6 = i6 != 0 ? true : z3;
                                        Function2<? super Composer, ? super Integer, Unit> function212 = i7 != 0 ? null : function24;
                                        if (i8 != 0) {
                                            function25 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function213 = i10 != 0 ? null : function23;
                                        if ((i3 & 1024) != 0) {
                                            i15 &= -15;
                                            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                                        } else {
                                            inputFieldShape = shape;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i18 = i4;
                                            composer3 = composerStartRestartGroup;
                                            searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composer3, 3072, 7);
                                            i15 &= -113;
                                        } else {
                                            composer3 = composerStartRestartGroup;
                                            i18 = i4;
                                            searchBarColorsM3987colorsKlgxPg = searchBarColors;
                                        }
                                        fM3992getTonalElevationD9Ej5fM = i12 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                                        float fM3991getShadowElevationD9Ej5fM = i17 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                                        if ((i3 & 16384) != 0) {
                                            windowInsets3 = SearchBarDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            i15 &= -57345;
                                        } else {
                                            windowInsets3 = windowInsets;
                                        }
                                        if (i16 != 0) {
                                            function29 = function25;
                                            searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                                            f5 = fM3991getShadowElevationD9Ej5fM;
                                            windowInsets4 = windowInsets3;
                                            mutableInteractionSource3 = null;
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            function29 = function25;
                                            searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                                            f5 = fM3991getShadowElevationD9Ej5fM;
                                            windowInsets4 = windowInsets3;
                                        }
                                        function210 = function212;
                                        function211 = function213;
                                        shape3 = inputFieldShape;
                                        modifier3 = companion;
                                        z5 = z6;
                                        i19 = i15;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 1024) != 0) {
                                            i15 &= -15;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i15 &= -113;
                                        }
                                        if ((i3 & 16384) != 0) {
                                            i15 &= -57345;
                                        }
                                        function211 = function23;
                                        searchBarColors3 = searchBarColors;
                                        fM3992getTonalElevationD9Ej5fM = f;
                                        f5 = f2;
                                        windowInsets4 = windowInsets;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        function29 = function25;
                                        modifier3 = modifier2;
                                        z5 = z3;
                                        function210 = function24;
                                        composer3 = composerStartRestartGroup;
                                        i19 = i15;
                                        shape3 = shape;
                                        i18 = i4;
                                    }
                                    composer3.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1506988286, i18, i19, "androidx.compose.material3.SearchBar (SearchBar.kt:1967)");
                                    }
                                    final String str3 = str2;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1597173218, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$SearchBar$6
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i23) {
                                            ComposerKt.sourceInformation(composer4, "C1969@93714L549:SearchBar.kt#uh7d8r");
                                            if (!composer4.shouldExecute((i23 & 3) != 2, i23 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1597173218, i23, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.kt:1969)");
                                            }
                                            SearchBarDefaults.INSTANCE.InputField(str3, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z5, function210, function29, function211, searchBarColors3.getInputFieldColors(), mutableInteractionSource3, composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 384, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54);
                                    int i23 = i18 >> 6;
                                    int i24 = 6 | (i23 & 112) | (i23 & 896) | (i23 & 7168);
                                    int i25 = i19 << 12;
                                    SearchBarColors searchBarColors4 = searchBarColors3;
                                    Composer composer4 = composer3;
                                    float f6 = fM3992getTonalElevationD9Ej5fM;
                                    m4004SearchBarY92LkZI(composableLambdaRememberComposableLambda, z, function13, modifier3, shape3, searchBarColors4, f6, f5, windowInsets4, function3, composer4, i24 | (57344 & i25) | (458752 & i25) | (3670016 & i25) | (29360128 & i25) | (i25 & 234881024) | ((i19 << 9) & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    f3 = f6;
                                    windowInsets2 = windowInsets4;
                                    composer2 = composer4;
                                    searchBarColors2 = searchBarColors4;
                                    z4 = z5;
                                    function26 = function29;
                                    function28 = function211;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    f4 = f5;
                                    shape2 = shape3;
                                    function27 = function210;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    shape2 = shape;
                                    searchBarColors2 = searchBarColors;
                                    f3 = f;
                                    windowInsets2 = windowInsets;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    function26 = function25;
                                    z4 = z3;
                                    function27 = function24;
                                    composer2 = composerStartRestartGroup;
                                    function28 = function23;
                                    f4 = f2;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return SearchBarKt.SearchBar_WuY5d9Q$lambda$28(str, function1, function12, z, function13, modifier2, z4, function27, function26, function28, shape2, searchBarColors2, f3, f4, windowInsets2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            i17 = i14;
                            if ((i3 & 65536) != 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        i16 = i3 & 32768;
                        if (i16 != 0) {
                        }
                        i17 = i14;
                        if ((i3 & 65536) != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i10 = i9;
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    int i212 = i11;
                    i12 = i3 & 4096;
                    if (i12 != 0) {
                    }
                    i14 = i3 & 8192;
                    if (i14 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    i16 = i3 & 32768;
                    if (i16 != 0) {
                    }
                    i17 = i14;
                    if ((i3 & 65536) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i5 = i3 & 32;
                if (i5 == 0) {
                }
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i2122 = i11;
                i12 = i3 & 4096;
                if (i12 != 0) {
                }
                i14 = i3 & 8192;
                if (i14 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                i16 = i3 & 32768;
                if (i16 != 0) {
                }
                i17 = i14;
                if ((i3 & 65536) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            int i202 = 8192;
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 == 0) {
            }
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i21222 = i11;
            i12 = i3 & 4096;
            if (i12 != 0) {
            }
            i14 = i3 & 8192;
            if (i14 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i16 = i3 & 32768;
            if (i16 != 0) {
            }
            i17 = i14;
            if ((i3 & 65536) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 8) == 0) {
        }
        int i2022 = 8192;
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i212222 = i11;
        i12 = i3 & 4096;
        if (i12 != 0) {
        }
        i14 = i3 & 8192;
        if (i14 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i16 = i3 & 32768;
        if (i16 != 0) {
        }
        i17 = i14;
        if ((i3 & 65536) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i15 & 599187) == 599186) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* JADX INFO: renamed from: SearchBar-Y92LkZI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4004SearchBarY92LkZI(final Function2<? super Composer, ? super Integer, Unit> function2, boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        Shape shape2;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        int i4;
        float f3;
        int i5;
        WindowInsets windowInsets2;
        final boolean z2;
        Composer composer2;
        final float f4;
        final float f5;
        final WindowInsets windowInsets3;
        final Modifier modifier3;
        final Shape shape3;
        final SearchBarColors searchBarColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape inputFieldShape;
        Composer composer3;
        float f6;
        WindowInsets windowInsets4;
        float f7;
        SearchBarColors searchBarColors3;
        Shape shape4;
        int i6;
        Boolean bool;
        Shape shape5;
        String str;
        Composer composer4;
        int i7;
        MutableFloatState mutableFloatState;
        Animatable animatable;
        Composer composerStartRestartGroup = composer.startRestartGroup(1451547856);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBar)N(inputField,expanded,onExpandedChange,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)545@26468L24,546@26521L64,547@26614L43,548@26683L51,549@26762L51,551@26844L638,551@26819L663,567@27507L27,568@27581L1149,568@27539L1191,596@28736L458:SearchBar.kt#uh7d8r");
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
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
            }
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    int i9 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                    int i10 = composerStartRestartGroup.changed(searchBarColorsM3987colorsKlgxPg) ? 131072 : 65536;
                    i3 |= i10;
                } else {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                }
                i3 |= i10;
            } else {
                searchBarColorsM3987colorsKlgxPg = searchBarColors;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else {
                if ((1572864 & i) == 0) {
                    f3 = f;
                    i3 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i & 100663296) == 0) {
                    if ((i2 & 256) == 0) {
                        windowInsets2 = windowInsets;
                        int i11 = composerStartRestartGroup.changed(windowInsets2) ? 67108864 : 33554432;
                        i3 |= i11;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i11;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 512) == 0) {
                    if ((i & 805306368) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        z2 = z;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f4 = f;
                        f5 = f2;
                        windowInsets3 = windowInsets2;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        searchBarColors2 = searchBarColorsM3987colorsKlgxPg;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "538@26130L15,539@26195L8,542@26376L12");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 16) != 0) {
                                inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                inputFieldShape = shape2;
                            }
                            if ((i2 & 32) != 0) {
                                composer3 = composerStartRestartGroup;
                                i3 &= -458753;
                                searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                            } else {
                                composer3 = composerStartRestartGroup;
                            }
                            float fM3992getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                            float fM3991getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                            if ((i2 & 256) != 0) {
                                windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                i3 &= -234881025;
                            }
                            f6 = fM3992getTonalElevationD9Ej5fM;
                            windowInsets4 = windowInsets2;
                            f7 = fM3991getShadowElevationD9Ej5fM;
                            searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                            shape4 = inputFieldShape;
                            i6 = i3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            f7 = f2;
                            windowInsets4 = windowInsets2;
                            shape4 = shape2;
                            searchBarColors3 = searchBarColorsM3987colorsKlgxPg;
                            f6 = f3;
                            composer3 = composerStartRestartGroup;
                            i6 = i3;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1451547856, i6, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:544)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                        Object objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926861680, "CC(remember):SearchBar.kt#9igjgp");
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        Animatable animatable2 = (Animatable) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926858725, "CC(remember):SearchBar.kt#9igjgp");
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926856509, "CC(remember):SearchBar.kt#9igjgp");
                        Object objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        MutableState mutableState = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926853981, "CC(remember):SearchBar.kt#9igjgp");
                        Object objRememberedValue5 = composer3.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        MutableState mutableState2 = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Boolean boolValueOf = Boolean.valueOf(z);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926850770, "CC(remember):SearchBar.kt#9igjgp");
                        boolean zChangedInstance = composer3.changedInstance(animatable2) | ((i6 & 112) == 32);
                        SearchBarKt$SearchBar$3$1 searchBarKt$SearchBar$3$1RememberedValue = composer3.rememberedValue();
                        if (zChangedInstance || searchBarKt$SearchBar$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            bool = boolValueOf;
                            shape5 = shape4;
                            str = "CC(remember):SearchBar.kt#9igjgp";
                            z2 = z;
                            searchBarKt$SearchBar$3$1RememberedValue = new SearchBarKt$SearchBar$3$1(animatable2, z2, mutableFloatState2, mutableState, mutableState2, null);
                            composer3.updateRememberedValue(searchBarKt$SearchBar$3$1RememberedValue);
                        } else {
                            bool = boolValueOf;
                            shape5 = shape4;
                            str = "CC(remember):SearchBar.kt#9igjgp";
                            z2 = z;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i12 = (i6 >> 3) & 14;
                        EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchBarKt$SearchBar$3$1RememberedValue, composer3, i12);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926830165, str);
                        Object objRememberedValue6 = composer3.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new MutatorMutex();
                            composer3.updateRememberedValue(objRememberedValue6);
                        }
                        MutatorMutex mutatorMutex = (MutatorMutex) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926826675, str);
                        boolean zChangedInstance2 = composer3.changedInstance(animatable2) | ((i6 & 896) == 256) | composer3.changedInstance(coroutineScope);
                        SearchBarKt$SearchBar$4$1 searchBarKt$SearchBar$4$1RememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || searchBarKt$SearchBar$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            composer4 = composer3;
                            i7 = i6;
                            mutableFloatState = mutableFloatState2;
                            animatable = animatable2;
                            searchBarKt$SearchBar$4$1RememberedValue = new SearchBarKt$SearchBar$4$1(mutatorMutex, mutableFloatState2, animatable2, function12, coroutineScope, mutableState, mutableState2, null);
                            composer4.updateRememberedValue(searchBarKt$SearchBar$4$1RememberedValue);
                        } else {
                            Composer composer5 = composer3;
                            animatable = animatable2;
                            composer4 = composer5;
                            int i13 = i6;
                            mutableFloatState = mutableFloatState2;
                            i7 = i13;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        BackHandler_androidKt.PredictiveBackHandler(z2, (Function2) searchBarKt$SearchBar$4$1RememberedValue, composer4, i12, 0);
                        int i14 = i7 << 6;
                        SearchBarColors searchBarColors4 = searchBarColors3;
                        float f8 = f7;
                        composer2 = composer4;
                        Modifier modifier4 = modifier2;
                        float f9 = f6;
                        Shape shape6 = shape5;
                        m4006SearchBarImplj1jLAyQ(animatable, mutableFloatState, mutableState, mutableState2, modifier4, function2, shape6, searchBarColors4, f9, f8, windowInsets4, function3, composer2, Animatable.$stable | 3504 | ((i7 << 3) & 57344) | ((i7 << 15) & 458752) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), (i7 >> 24) & 126, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        shape3 = shape6;
                        searchBarColors2 = searchBarColors4;
                        f4 = f9;
                        f5 = f8;
                        windowInsets3 = windowInsets4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchBarKt.SearchBar_Y92LkZI$lambda$22(function2, z2, function1, modifier3, shape3, searchBarColors2, f4, f5, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 805306368;
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f3 = f;
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX INFO: renamed from: SearchBar-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4005SearchBarnbWgWpA(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i4;
        Modifier modifier2;
        Shape inputFieldShape;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        int i5;
        float f3;
        int i6;
        float f4;
        final Modifier modifier3;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        int i8;
        SearchBarColors searchBarColors3;
        Shape shape3;
        float f7;
        float fM3991getShadowElevationD9Ej5fM;
        Composer composerStartRestartGroup = composer.startRestartGroup(1234122643);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp)234@11650L30,237@11767L38,233@11592L334:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function22 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
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
                        inputFieldShape = shape;
                        int i9 = composerStartRestartGroup.changed(inputFieldShape) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        inputFieldShape = shape;
                    }
                    i3 |= i9;
                } else {
                    inputFieldShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        searchBarColorsM3987colorsKlgxPg = searchBarColors;
                        int i10 = composerStartRestartGroup.changed(searchBarColorsM3987colorsKlgxPg) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        searchBarColorsM3987colorsKlgxPg = searchBarColors;
                    }
                    i3 |= i10;
                } else {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        f3 = f;
                        i3 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 != 0) {
                        if ((1572864 & i) == 0) {
                            f4 = f2;
                            i3 |= composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "228@11389L15,229@11454L8");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i7 = 0;
                                    searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                                    i3 &= -57345;
                                } else {
                                    i7 = 0;
                                }
                                float fM3992getTonalElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                                if (i6 != 0) {
                                    SearchBarColors searchBarColors4 = searchBarColorsM3987colorsKlgxPg;
                                    i8 = i3;
                                    searchBarColors3 = searchBarColors4;
                                    float f8 = fM3992getTonalElevationD9Ej5fM;
                                    shape3 = inputFieldShape;
                                    f7 = f8;
                                    fM3991getShadowElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM();
                                } else {
                                    SearchBarColors searchBarColors5 = searchBarColorsM3987colorsKlgxPg;
                                    i8 = i3;
                                    searchBarColors3 = searchBarColors5;
                                    float f9 = fM3992getTonalElevationD9Ej5fM;
                                    shape3 = inputFieldShape;
                                    f7 = f9;
                                    fM3991getShadowElevationD9Ej5fM = f2;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                SearchBarColors searchBarColors6 = searchBarColorsM3987colorsKlgxPg;
                                i8 = i3;
                                searchBarColors3 = searchBarColors6;
                                float f10 = f3;
                                shape3 = inputFieldShape;
                                f7 = f10;
                                fM3991getShadowElevationD9Ej5fM = f4;
                                i7 = 0;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1234122643, i8, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:232)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 580903377, "CC(remember):SearchBar.kt#9igjgp");
                            int i11 = (i8 & 14) == 4 ? 1 : i7;
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (i11 != 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SearchBarKt.SearchBar_nbWgWpA$lambda$1$lambda$0(searchBarState, (LayoutCoordinates) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) objRememberedValue);
                            long jM3984getContainerColor0d7_KjU = searchBarColors3.m3984getContainerColor0d7_KjU();
                            long jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(searchBarColors3.m3984getContainerColor0d7_KjU(), composerStartRestartGroup, i7);
                            int i12 = i8 >> 3;
                            float f11 = f7;
                            SurfaceKt.m4145SurfaceT9BRK9s(modifierOnGloballyPositioned, shape3, jM3984getContainerColor0d7_KjU, jM3479contentColorForek8zF_U, f11, fM3991getShadowElevationD9Ej5fM, null, function22, composerStartRestartGroup, ((i8 >> 6) & 112) | (i12 & 57344) | (i12 & 458752) | ((i8 << 18) & 29360128), 64);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            searchBarColors2 = searchBarColors3;
                            modifier3 = modifier2;
                            shape2 = shape3;
                            f6 = fM3991getShadowElevationD9Ej5fM;
                            f5 = f11;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            shape2 = inputFieldShape;
                            searchBarColors2 = searchBarColorsM3987colorsKlgxPg;
                            f5 = f;
                            f6 = f2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SearchBarKt.SearchBar_nbWgWpA$lambda$2(searchBarState, function2, modifier3, shape2, searchBarColors2, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    f4 = f2;
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                f3 = f;
                i6 = i2 & 64;
                if (i6 != 0) {
                }
                f4 = f2;
                if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f3 = f;
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            f4 = f2;
            if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function22 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f3 = f;
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        f4 = f2;
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* JADX INFO: renamed from: SearchBarImpl-j1jLAyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4006SearchBarImplj1jLAyQ(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        MutableState<BackEventCompat> mutableState3;
        int i5;
        Modifier modifier2;
        SearchBarColors searchBarColors2;
        int i6;
        int i7;
        int i8;
        int i9;
        WindowInsets windowInsets2;
        int i10;
        final Shape shape2;
        final float f3;
        final WindowInsets windowInsets3;
        Composer composer2;
        final Modifier modifier3;
        final float f4;
        final SearchBarColors searchBarColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape inputFieldShape;
        Modifier modifier4;
        int i11;
        SearchBarColors searchBarColorsM3987colorsKlgxPg;
        int i12;
        WindowInsets windowInsets4;
        int i13;
        final float f5;
        int i14;
        final SearchBarColors searchBarColors4;
        final float f6;
        Shape shape3;
        Modifier modifier5;
        Modifier modifier6;
        ComposableLambda composableLambdaRememberComposableLambda;
        Composer composerStartRestartGroup = composer.startRestartGroup(501752896);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBarImpl)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,inputField,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2094@98568L7,2096@98628L15,2097@98695L15,2098@98741L101,2102@98875L666,2118@99580L333,2129@99938L99,2142@100370L362:SearchBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableFloatState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
            mutableState3 = mutableState;
        } else {
            mutableState3 = mutableState;
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(mutableState3) ? 256 : 128;
            }
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                i4 |= composerStartRestartGroup.changed(mutableState2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                }
                if ((i3 & 32) != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        searchBarColors2 = searchBarColors;
                        int i15 = composerStartRestartGroup.changed(searchBarColors2) ? 8388608 : 4194304;
                        i4 |= i15;
                    } else {
                        searchBarColors2 = searchBarColors;
                    }
                    i4 |= i15;
                } else {
                    searchBarColors2 = searchBarColors;
                }
                i6 = i3 & 256;
                if (i6 != 0) {
                    i4 |= 100663296;
                } else {
                    if ((i & 100663296) == 0) {
                        i7 = i6;
                        i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 512;
                    if (i8 != 0) {
                        if ((i & 805306368) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(f2) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                windowInsets2 = windowInsets;
                                int i16 = composerStartRestartGroup.changed(windowInsets2) ? 4 : 2;
                                i10 = i2 | i16;
                            } else {
                                windowInsets2 = windowInsets;
                            }
                            i10 = i2 | i16;
                        } else {
                            windowInsets2 = windowInsets;
                            i10 = i2;
                        }
                        if ((i3 & 2048) != 0) {
                            i10 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i10 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
                        }
                        if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i10 & 19) == 18) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "2087@98224L15,2088@98289L8,2091@98470L12");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                                } else {
                                    inputFieldShape = shape;
                                }
                                int i17 = i4;
                                if ((i3 & 128) != 0) {
                                    modifier4 = companion;
                                    i11 = 6;
                                    searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                                    i12 = i17 & (-29360129);
                                } else {
                                    modifier4 = companion;
                                    i11 = 6;
                                    searchBarColorsM3987colorsKlgxPg = searchBarColors2;
                                    i12 = i17;
                                }
                                float fM3992getTonalElevationD9Ej5fM = i7 != 0 ? SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM() : f;
                                float fM3991getShadowElevationD9Ej5fM = i9 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                                if ((i3 & 1024) != 0) {
                                    i13 = i12;
                                    windowInsets4 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, i11);
                                    i14 = i10 & (-15);
                                    searchBarColors4 = searchBarColorsM3987colorsKlgxPg;
                                    f5 = fM3991getShadowElevationD9Ej5fM;
                                    shape3 = inputFieldShape;
                                    f6 = fM3992getTonalElevationD9Ej5fM;
                                } else {
                                    windowInsets4 = windowInsets;
                                    i13 = i12;
                                    f5 = fM3991getShadowElevationD9Ej5fM;
                                    i14 = i10;
                                    searchBarColors4 = searchBarColorsM3987colorsKlgxPg;
                                    f6 = fM3992getTonalElevationD9Ej5fM;
                                    shape3 = inputFieldShape;
                                }
                                modifier5 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 1024) != 0) {
                                    i10 &= -15;
                                }
                                f6 = f;
                                i13 = i4;
                                searchBarColors4 = searchBarColors2;
                                modifier5 = modifier2;
                                i14 = i10;
                                shape3 = shape;
                                windowInsets4 = windowInsets2;
                                f5 = f2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                modifier6 = modifier5;
                                ComposerKt.traceEventStart(501752896, i13, i14, "androidx.compose.material3.SearchBarImpl (SearchBar.kt:2093)");
                            } else {
                                modifier6 = modifier5;
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            WindowInsets windowInsets5 = windowInsets4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Density density = (Density) objConsume;
                            Shape inputFieldShape2 = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                            int i18 = i14;
                            Shape fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1148225381, "CC(remember):SearchBar.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(animatable));
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            State state = (State) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean zSearchBarImpl_j1jLAyQ$lambda$32 = SearchBarImpl_j1jLAyQ$lambda$32(state);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1148230234, "CC(remember):SearchBar.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(zSearchBarImpl_j1jLAyQ$lambda$32) | ((((3670016 & i13) ^ 1572864) > 1048576 && composerStartRestartGroup.changed(shape3)) || (i13 & 1572864) == 1048576);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                GenericShape genericShape = Intrinsics.areEqual(shape3, inputFieldShape2) ? new GenericShape(new Function3() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(density, animatable, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                                    }
                                }) : SearchBarImpl_j1jLAyQ$lambda$32(state) ? fullScreenShape : shape3;
                                composerStartRestartGroup.updateRememberedValue(genericShape);
                                objRememberedValue2 = genericShape;
                            }
                            final Shape shape4 = (Shape) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1304392981, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$SearchBarImpl$surface$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i19) {
                                    ComposerKt.sourceInformation(composer3, "C2122@99720L38,2119@99594L309:SearchBar.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i19 & 3) != 2, i19 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1304392981, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.kt:2119)");
                                    }
                                    SurfaceKt.m4145SurfaceT9BRK9s(null, shape4, searchBarColors4.m3984getContainerColor0d7_KjU(), ColorSchemeKt.m3479contentColorForek8zF_U(searchBarColors4.m3984getContainerColor0d7_KjU(), composer3, 0), f6, f5, null, ComposableSingletons$SearchBarKt.INSTANCE.getLambda$1165377840$material3(), composer3, 12582912, 65);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1148263683, "CC(remember):SearchBar.kt#9igjgp");
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda20
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(animatable));
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (SearchBarImpl_j1jLAyQ$lambda$38((State) objRememberedValue3)) {
                                composerStartRestartGroup.startReplaceGroup(1236615731);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "2134@100129L215");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1831594093, true, new SearchBarKt$SearchBarImpl$wrappedContent$1(animatable, searchBarColors4, function3), composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1236851485);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            }
                            int i19 = Animatable.$stable | 12582912 | (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | ((i18 << 15) & 458752) | ((i13 << 3) & 3670016);
                            Shape shape5 = shape3;
                            SearchBarColors searchBarColors5 = searchBarColors4;
                            float f7 = f5;
                            MutableState<BackEventCompat> mutableState4 = mutableState3;
                            ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                            float f8 = f6;
                            Modifier modifier7 = modifier6;
                            SearchBarLayout(animatable, mutableFloatState, mutableState4, mutableState2, modifier7, windowInsets5, function2, composableLambdaRememberComposableLambda2, composableLambda, composerStartRestartGroup, i19);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            searchBarColors3 = searchBarColors5;
                            f3 = f8;
                            f4 = f7;
                            shape2 = shape5;
                            windowInsets3 = windowInsets5;
                            modifier3 = modifier7;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            shape2 = shape;
                            f3 = f;
                            windowInsets3 = windowInsets;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            f4 = f2;
                            searchBarColors3 = searchBarColors2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda21
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$39(animatable, mutableFloatState, mutableState, mutableState2, modifier3, function2, shape2, searchBarColors3, f3, f4, windowInsets3, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i9 = i8;
                    if ((i2 & 6) == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i10 & 19) == 18) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i7 = i6;
                i8 = i3 & 512;
                if (i8 != 0) {
                }
                i9 = i8;
                if ((i2 & 6) == 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i10 & 19) == 18) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            if ((i3 & 32) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i6 = i3 & 256;
            if (i6 != 0) {
            }
            i7 = i6;
            i8 = i3 & 512;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i2 & 6) == 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i10 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        if ((i3 & 32) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i6 = i3 & 256;
        if (i6 != 0) {
        }
        i7 = i6;
        i8 = i3 & 512;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i2 & 6) == 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i10 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final boolean SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(Animatable animatable) {
        return ((Number) animatable.getValue()).floatValue() == 1.0f;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$32(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static final Unit SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(Density density, Animatable animatable, Path path, Size size, LayoutDirection layoutDirection) {
        float fMo1624toPx0680j_4 = density.mo1624toPx0680j_4(Dp.m9114constructorimpl(SearchBarCornerRadius * (1.0f - ((Number) animatable.getValue()).floatValue())));
        Path.addRoundRect$default(path, RoundRectKt.m6135RoundRectsniSvfs(androidx.compose.ui.geometry.SizeKt.m6170toRectuvyYCjk(size.m6154unboximpl()), CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(fMo1624toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo1624toPx0680j_4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
        return Unit.INSTANCE;
    }

    static final boolean SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(Animatable animatable) {
        return ((Number) animatable.getValue()).floatValue() > 0.0f;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$38(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static final Unit SearchBarImpl_j1jLAyQ$lambda$39(Animatable animatable, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Modifier modifier, Function2 function2, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m4006SearchBarImplj1jLAyQ(animatable, mutableFloatState, mutableState, mutableState2, modifier, function2, shape, searchBarColors, f, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    private static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, final Modifier modifier, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i) {
        int i2;
        MutableState<BackEventCompat> mutableState3;
        MutableState<BackEventCompat> mutableState4;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1217602934);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBarLayout)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,windowInsets,inputField,surface,content)2171@101429L34,2176@101591L120,2191@102227L5012,2172@101468L5771:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableFloatState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            mutableState3 = mutableState;
            i2 |= composerStartRestartGroup.changed(mutableState3) ? 256 : 128;
        } else {
            mutableState3 = mutableState;
        }
        if ((i & 3072) == 0) {
            mutableState4 = mutableState2;
            i2 |= composerStartRestartGroup.changed(mutableState4) ? 2048 : 1024;
        } else {
            mutableState4 = mutableState2;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217602934, i2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.kt:2167)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885337272, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MutableWindowInsets(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierZIndex = ZIndexModifierKt.zIndex(modifier, 1.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885342542, "CC(remember):SearchBar.kt#9igjgp");
            boolean z = (458752 & i2) == 131072;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchBarKt.SearchBarLayout$lambda$42$lambda$41(mutableWindowInsets, windowInsets, (WindowInsets) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex, (Function1) objRememberedValue2), windowInsets);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885367786, "CC(remember):SearchBar.kt#9igjgp");
            boolean z2 = ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(animatable))) | ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            SearchBarKt$SearchBarLayout$2$1 searchBarKt$SearchBarLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || searchBarKt$SearchBarLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                MutableState<BackEventCompat> mutableState5 = mutableState3;
                i3 = i2;
                searchBarKt$SearchBarLayout$2$1RememberedValue = new SearchBarKt$SearchBarLayout$2$1(animatable, mutableWindowInsets, mutableState4, mutableFloatState, mutableState5);
                composerStartRestartGroup.updateRememberedValue(searchBarKt$SearchBarLayout$2$1RememberedValue);
            } else {
                i3 = i2;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) searchBarKt$SearchBarLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierConsumeWindowInsets);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2058590599, "C2181@101796L85,2182@101894L119:SearchBar.kt#uh7d8r");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSurface);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 329239585, "C2181@101870L9:SearchBar.kt#uh7d8r");
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdInputField);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397275701, "C2183@101987L12:SearchBar.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function23 == null) {
                composerStartRestartGroup.startReplaceGroup(2058820276);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2058820277);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*2186@102068L127");
                Modifier modifierLayoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSearchContent);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1819747385, "C2187@102168L9:SearchBar.kt#uh7d8r");
                function23.invoke(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.SearchBarLayout$lambda$49(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SearchBarLayout$lambda$42$lambda$41(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    static final Unit SearchBarLayout$lambda$49(Animatable animatable, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Modifier modifier, WindowInsets windowInsets, Function2 function2, Function2 function22, Function2 function23, int i, Composer composer, int i2) {
        SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_WuY5d9Q$lambda$28(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m4003SearchBarWuY5d9Q(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, shape, searchBarColors, f, f2, windowInsets, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_Y92LkZI$lambda$22(Function2 function2, boolean z, Function1 function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4004SearchBarY92LkZI(function2, z, function1, modifier, shape, searchBarColors, f, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_nbWgWpA$lambda$1$lambda$0(SearchBarState searchBarState, LayoutCoordinates layoutCoordinates) {
        searchBarState.setCollapsedCoords(layoutCoordinates);
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_nbWgWpA$lambda$2(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, int i, int i2, Composer composer, int i3) {
        m4005SearchBarnbWgWpA(searchBarState, function2, modifier, shape, searchBarColors, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX INFO: renamed from: TopSearchBar-qKj4JfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4007TopSearchBarqKj4JfE(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, SearchBarScrollBehavior searchBarScrollBehavior, Composer composer, final int i, final int i2) {
        SearchBarState searchBarState2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Shape inputFieldShape;
        final SearchBarColors searchBarColorsM3987colorsKlgxPg;
        int i4;
        float fM3992getTonalElevationD9Ej5fM;
        int i5;
        float f3;
        final WindowInsets windowInsets2;
        int i6;
        final Modifier modifier2;
        final SearchBarScrollBehavior searchBarScrollBehavior2;
        Composer composer2;
        final float f4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        int i7;
        int i8;
        WindowInsets windowInsets3;
        float f6;
        SearchBarColors searchBarColors2;
        float f7;
        Shape shape2;
        int i9;
        boolean z;
        int i10;
        Modifier modifier4;
        SearchBarScrollBehavior searchBarScrollBehavior3;
        Modifier.Companion companionSearchBarScrollBehavior;
        Composer composerStartRestartGroup = composer.startRestartGroup(782822734);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopSearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,scrollBehavior)293@14798L586:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            searchBarState2 = searchBarState;
        } else {
            searchBarState2 = searchBarState;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(searchBarState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function22 = function2;
        } else {
            function22 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
            }
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    inputFieldShape = shape;
                    int i12 = composerStartRestartGroup.changed(inputFieldShape) ? 2048 : 1024;
                    i3 |= i12;
                } else {
                    inputFieldShape = shape;
                }
                i3 |= i12;
            } else {
                inputFieldShape = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                    int i13 = composerStartRestartGroup.changed(searchBarColorsM3987colorsKlgxPg) ? 16384 : 8192;
                    i3 |= i13;
                } else {
                    searchBarColorsM3987colorsKlgxPg = searchBarColors;
                }
                i3 |= i13;
            } else {
                searchBarColorsM3987colorsKlgxPg = searchBarColors;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM3992getTonalElevationD9Ej5fM = f;
            } else {
                fM3992getTonalElevationD9Ej5fM = f;
                if ((196608 & i) == 0) {
                    i3 |= composerStartRestartGroup.changed(fM3992getTonalElevationD9Ej5fM) ? 131072 : 65536;
                }
            }
            i5 = i2 & 64;
            if (i5 != 0) {
                if ((1572864 & i) == 0) {
                    f3 = f2;
                    i3 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                }
                if ((12582912 & i) == 0) {
                    if ((i2 & 128) == 0) {
                        windowInsets2 = windowInsets;
                        int i14 = composerStartRestartGroup.changed(windowInsets2) ? 8388608 : 4194304;
                        i3 |= i14;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i14;
                } else {
                    windowInsets2 = windowInsets;
                }
                i6 = i2 & 256;
                if (i6 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= composerStartRestartGroup.changed(searchBarScrollBehavior) ? 67108864 : 33554432;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "286@14477L15,287@14542L8,290@14723L12");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i11 != 0 ? Modifier.INSTANCE : modifier;
                        if ((i2 & 8) != 0) {
                            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        int i15 = i3;
                        Shape shape3 = inputFieldShape;
                        if ((i2 & 16) != 0) {
                            i8 = i6;
                            modifier3 = companion;
                            i7 = 6;
                            i15 &= -57345;
                            searchBarColorsM3987colorsKlgxPg = SearchBarDefaults.INSTANCE.m3987colorsKlgxPg(0L, 0L, null, composerStartRestartGroup, 3072, 7);
                        } else {
                            modifier3 = companion;
                            i7 = 6;
                            i8 = i6;
                        }
                        if (i4 != 0) {
                            fM3992getTonalElevationD9Ej5fM = SearchBarDefaults.INSTANCE.m3992getTonalElevationD9Ej5fM();
                        }
                        float fM3991getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m3991getShadowElevationD9Ej5fM() : f2;
                        if ((i2 & 128) != 0) {
                            windowInsets3 = SearchBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, i7);
                            i15 &= -29360129;
                        } else {
                            windowInsets3 = windowInsets;
                        }
                        windowInsets2 = windowInsets3;
                        f6 = fM3991getShadowElevationD9Ej5fM;
                        searchBarColors2 = searchBarColorsM3987colorsKlgxPg;
                        f7 = fM3992getTonalElevationD9Ej5fM;
                        shape2 = shape3;
                        i9 = i15;
                        if (i8 != 0) {
                            searchBarScrollBehavior3 = null;
                            z = false;
                            i10 = 782822734;
                            modifier4 = modifier3;
                        } else {
                            z = false;
                            i10 = 782822734;
                            modifier4 = modifier3;
                            searchBarScrollBehavior3 = searchBarScrollBehavior;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                        }
                        modifier4 = modifier;
                        i9 = i3;
                        searchBarColors2 = searchBarColorsM3987colorsKlgxPg;
                        f6 = f3;
                        f7 = fM3992getTonalElevationD9Ej5fM;
                        z = false;
                        searchBarScrollBehavior3 = searchBarScrollBehavior;
                        shape2 = inputFieldShape;
                        i10 = 782822734;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.TopSearchBar (SearchBar.kt:292)");
                    }
                    if (searchBarScrollBehavior3 == null || (companionSearchBarScrollBehavior = searchBarScrollBehavior3.searchBarScrollBehavior(Modifier.INSTANCE)) == null) {
                        companionSearchBarScrollBehavior = Modifier.INSTANCE;
                    }
                    m4005SearchBarnbWgWpA(searchBarState2, function22, SizeKt.wrapContentWidth$default(SizeKt.fillMaxWidth$default(PaddingKt.m2037padding3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(modifier4.then(companionSearchBarScrollBehavior), windowInsets2), SearchBarAsTopBarPadding), 0.0f, 1, null), null, z, 3, null), shape2, searchBarColors2, f7, f6, composerStartRestartGroup, i9 & 4193406, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    searchBarScrollBehavior2 = searchBarScrollBehavior3;
                    composer2 = composerStartRestartGroup;
                    inputFieldShape = shape2;
                    searchBarColorsM3987colorsKlgxPg = searchBarColors2;
                    f4 = f7;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    searchBarScrollBehavior2 = searchBarScrollBehavior;
                    composer2 = composerStartRestartGroup;
                    f4 = fM3992getTonalElevationD9Ej5fM;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchBarKt.TopSearchBar_qKj4JfE$lambda$5(searchBarState, function2, modifier2, inputFieldShape, searchBarColorsM3987colorsKlgxPg, f4, f5, windowInsets2, searchBarScrollBehavior2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 1572864;
            f3 = f2;
            if ((12582912 & i) == 0) {
            }
            i6 = i2 & 256;
            if (i6 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        f3 = f2;
        if ((12582912 & i) == 0) {
        }
        i6 = i2 & 256;
        if (i6 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit TopSearchBar_qKj4JfE$lambda$5(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, SearchBarScrollBehavior searchBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m4007TopSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f, f2, windowInsets, searchBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackMultiplier(BackEventCompat backEventCompat, float f, float f2) {
        if (backEventCompat == null) {
            return 0.0f;
        }
        if (Float.isNaN(f2)) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        return f / f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculatePredictiveBackOffsetX-rOvwMX4, reason: not valid java name */
    public static final int m4012calculatePredictiveBackOffsetXrOvwMX4(long j, int i, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f, float f2) {
        if (backEventCompat == null || f2 == 0.0f) {
            return 0;
        }
        return MathKt.roundToInt(((Constraints.m9067getMaxWidthimpl(j) * SearchBarPredictiveBackMaxOffsetXRatio) - i) * (1.0f - f) * f2 * (backEventCompat.getSwipeEdge() == 0 ? 1 : -1) * (layoutDirection != LayoutDirection.Ltr ? -1 : 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculatePredictiveBackOffsetY-dzo92Q0, reason: not valid java name */
    public static final int m4013calculatePredictiveBackOffsetYdzo92Q0(long j, int i, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i2, int i3, float f) {
        if (backEventCompat2 == null || backEventCompat == null || f == 0.0f) {
            return 0;
        }
        int iMin = Math.min(Math.max(0, ((Constraints.m9066getMaxHeightimpl(j) - i2) / 2) - i), i3);
        float touchY = backEventCompat.getTouchY() - backEventCompat2.getTouchY();
        float fAbs = Math.abs(touchY) / Constraints.m9066getMaxHeightimpl(j);
        return MathKt.roundToInt(MathHelpersKt.lerp(0, iMin, fAbs) * f * Math.signum(touchY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect getCollapsedBounds(SearchBarState searchBarState) {
        IntRect intRectM9275IntRectVbeCjmY;
        LayoutCoordinates collapsedCoords = searchBarState.getCollapsedCoords();
        return (collapsedCoords == null || (intRectM9275IntRectVbeCjmY = IntRectKt.m9275IntRectVbeCjmY(IntOffsetKt.m9259roundk4lQ0M(LayoutCoordinatesKt.positionInWindow(collapsedCoords)), collapsedCoords.mo7777getSizeYbymL2g())) == null) ? IntRect.INSTANCE.getZero() : intRectM9275IntRectVbeCjmY;
    }

    private static /* synthetic */ void getCollapsedBounds$annotations(SearchBarState searchBarState) {
    }

    public static final float getDockedExpandedTableMinHeight() {
        return DockedExpandedTableMinHeight;
    }

    public static final float getSearchBarAsTopBarPadding() {
        return SearchBarAsTopBarPadding;
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isExpanded(SearchBarState searchBarState) {
        return searchBarState.getCurrentValue() == SearchBarValue.Expanded;
    }

    private static /* synthetic */ void isExpanded$annotations(SearchBarState searchBarState) {
    }

    public static final SearchBarState rememberSearchBarState(final SearchBarValue searchBarValue, final AnimationSpec<Float> animationSpec, final AnimationSpec<Float> animationSpec2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -546016819, "C(rememberSearchBarState)N(initialValue,animationSpecForExpand,animationSpecForCollapse)817@37213L7,818@37312L7,829@37663L208,820@37352L519:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            searchBarValue = SearchBarValue.Collapsed;
        }
        if ((i2 & 2) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowSpatial, composer, 6);
        }
        if ((i2 & 4) != 0) {
            animationSpec2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-546016819, i, -1, "androidx.compose.material3.rememberSearchBarState (SearchBar.kt:819)");
        }
        Object[] objArr = {searchBarValue, animationSpec, animationSpec2};
        Saver<SearchBarState, ?> Saver = SearchBarState.INSTANCE.Saver(animationSpec, animationSpec2);
        ComposerKt.sourceInformationMarkerStart(composer, -736131555, "CC(remember):SearchBar.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(searchBarValue.ordinal())) || (i & 6) == 4) | composer.changedInstance(animationSpec) | composer.changedInstance(animationSpec2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchBarKt.rememberSearchBarState$lambda$27$lambda$26(searchBarValue, animationSpec, animationSpec2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchBarState searchBarState = (SearchBarState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarState;
    }

    static final SearchBarState rememberSearchBarState$lambda$27$lambda$26(SearchBarValue searchBarValue, AnimationSpec animationSpec, AnimationSpec animationSpec2) {
        return new SearchBarState(searchBarValue, (AnimationSpec<Float>) animationSpec, (AnimationSpec<Float>) animationSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float transform(BackEventProgress.InProgress inProgress) {
        if (inProgress == null) {
            return 0.0f;
        }
        return PredictiveBack.INSTANCE.transform$material3(inProgress.getProgress());
    }
}
