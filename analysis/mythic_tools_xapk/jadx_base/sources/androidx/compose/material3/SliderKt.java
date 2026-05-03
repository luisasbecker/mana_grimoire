package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.DragGestureDetectorCopyKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
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
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010\u0019\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001b\u001a}\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001aä\u0001\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\b\b\u0003\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010&\u001a\u0098\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020$2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010'\u001a_\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010)\u001a`\u0010*\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002\u001a\u0080\u0001\u0010-\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001a(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0002\u001a2\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0003\u0018\u000106*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0082@¢\u0006\u0004\b=\u0010>\u001a\u0010\u0010?\u001a\u0002022\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002\u001a?\u0010@\u001a\u00020F2\u0006\u0010G\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010H\u001a\u00020F2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002¢\u0006\u0004\bI\u0010J\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001a\u001c\u0010O\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010Q\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010R\u001a\u00020S*\u00020\u0003H\u0002\u001a$\u0010T\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001a,\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001aC\u0010d\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010e\u001aM\u0010f\u001a\u00020$2\b\b\u0002\u0010g\u001a\u00020\u00032\b\b\u0002\u0010h\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010i\u001a\u001d\u0010j\u001a\u00020F2\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010m\u001a\u001b\u0010j\u001a\u00020F2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0001¢\u0006\u0002\u0010o\"\u0016\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010Y\"\u0016\u0010[\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b\\\u0010Y\"\u0010\u0010]\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010a\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010b\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010c\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u001e\u0010p\u001a\u00020\t*\u00020F8@X\u0081\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0014\u0010u\u001a\u00020vX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010x¨\u0006y"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "thumb", "Landroidx/compose/material3/SliderState;", "Landroidx/compose/runtime/Composable;", "track", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", ServerProtocol.DIALOG_PARAM_STATE, "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "VerticalSlider", "reverseDirection", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "startInteractionSource", "endInteractionSource", "startThumb", "Landroidx/compose/material3/RangeSliderState;", "endThumb", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "slideOnKeyEvents", "onValueChangeState", "onValueChangeFinishedState", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "Landroidx/compose/material3/SliderRange;", "isStart", "x", "scale-2geJ7wY", "(ZFFJFF)J", "calcFraction", "a", "b", "pos", "sliderSemantics", "rangeSliderStartThumbSemantics", "rangeSliderEndThumbSemantics", "formatForSemantics", "", "sliderTapModifier", "rangeSliderPressDragModifier", "TrackHeight", "Landroidx/compose/ui/unit/Dp;", "getTrackHeight", "()F", "F", "ThumbWidth", "getThumbWidth", "ThumbHeight", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "VerticalThumbSize", "ThumbTrackGapSize", "TrackInsideCornerSize", "rememberSliderState", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SliderState;", "rememberRangeSliderState", "activeRangeStart", "activeRangeEnd", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RangeSliderState;", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "isSpecified", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "CornerSizeAlignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "getCornerSizeAlignmentLine", "()Landroidx/compose/ui/layout/VerticalAlignmentLine;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SliderKt {
    private static final VerticalAlignmentLine CornerSizeAlignmentLine;
    private static final float ThumbHeight;
    private static final long ThumbSize;
    private static final float ThumbTrackGapSize;
    private static final float ThumbWidth;
    private static final float TrackHeight = SliderTokens.INSTANCE.m5316getInactiveTrackHeightD9Ej5fM();
    private static final float TrackInsideCornerSize;
    private static final long VerticalThumbSize;

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C04521 implements PointerInputEventHandler {
        final /* synthetic */ SliderState $state;

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00711 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            final /* synthetic */ SliderState $state;
            /* synthetic */ long J$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00711(SliderState sliderState, Continuation<? super C00711> continuation) {
                super(3, continuation);
                this.$state = sliderState;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                return m4115invoked4ec7I(pressGestureScope, offset.m6090unboximpl(), continuation);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m4115invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                C00711 c00711 = new C00711(this.$state, continuation);
                c00711.J$0 = j;
                return c00711.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$state.m4127onPressk4lQ0M$material3(this.J$0);
                return Unit.INSTANCE;
            }
        }

        C04521(SliderState sliderState) {
            this.$state = sliderState;
        }

        static final Unit invoke$lambda$0(SliderState sliderState, Offset offset) {
            sliderState.dispatchRawDelta(0.0f);
            sliderState.getGestureEndAction$material3().invoke();
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            C00711 c00711 = new C00711(this.$state, null);
            final SliderState sliderState = this.$state;
            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c00711, new Function1() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SliderKt.C04521.invoke$lambda$0(sliderState, (Offset) obj);
                }
            }, continuation, 3, null);
            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
        }
    }

    static {
        float fM5314getHandleWidthD9Ej5fM = SliderTokens.INSTANCE.m5314getHandleWidthD9Ej5fM();
        ThumbWidth = fM5314getHandleWidthD9Ej5fM;
        float fM5313getHandleHeightD9Ej5fM = SliderTokens.INSTANCE.m5313getHandleHeightD9Ej5fM();
        ThumbHeight = fM5313getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.m9136DpSizeYgX7TsA(fM5314getHandleWidthD9Ej5fM, fM5313getHandleHeightD9Ej5fM);
        VerticalThumbSize = DpKt.m9136DpSizeYgX7TsA(fM5313getHandleHeightD9Ej5fM, fM5314getHandleWidthD9Ej5fM);
        ThumbTrackGapSize = SliderTokens.INSTANCE.m5306getActiveHandleLeadingSpaceD9Ej5fM();
        TrackInsideCornerSize = Dp.m9114constructorimpl(2.0f);
        CornerSizeAlignmentLine = new VerticalAlignmentLine(SliderKt$CornerSizeAlignmentLine$1.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2) {
        RangeSliderState rangeSliderState2;
        int i3;
        int i4;
        final boolean z2;
        final SliderColors sliderColorsColors;
        int i5;
        MutableInteractionSource mutableInteractionSource3;
        int i6;
        final MutableInteractionSource mutableInteractionSource4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Modifier modifier2;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        final boolean z3;
        final SliderColors sliderColors2;
        final MutableInteractionSource mutableInteractionSource5;
        final MutableInteractionSource mutableInteractionSource6;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final MutableInteractionSource mutableInteractionSource7;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource8;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        Composer composerStartRestartGroup = composer.startRestartGroup(-781154979);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSlider)N(state,modifier,enabled,colors,startInteractionSource,endInteractionSource,startThumb,endThumb,track)729@33295L296:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            rangeSliderState2 = rangeSliderState;
        } else {
            rangeSliderState2 = rangeSliderState;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(rangeSliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
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
                        sliderColorsColors = sliderColors;
                        int i13 = composerStartRestartGroup.changed(sliderColorsColors) ? 2048 : 1024;
                        i3 |= i13;
                    } else {
                        sliderColorsColors = sliderColors;
                    }
                    i3 |= i13;
                } else {
                    sliderColorsColors = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource3 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource3) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            mutableInteractionSource4 = mutableInteractionSource2;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource4) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i3 |= 12582912;
                        } else {
                            if ((i & 12582912) == 0) {
                                i9 = i8;
                                i3 |= composerStartRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                            }
                            i10 = i2 & 256;
                            if (i10 != 0) {
                                if ((i & 100663296) == 0) {
                                    i11 = i10;
                                    i3 |= composerStartRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                                }
                                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "702@32359L8,703@32424L39,704@32518L39,705@32616L163,712@32836L161,719@33051L176");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                        if (i4 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 8) != 0) {
                                            i3 &= -7169;
                                            sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        }
                                        if (i5 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 929350180, "CC(remember):Slider.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            mutableInteractionSource7 = (MutableInteractionSource) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        } else {
                                            mutableInteractionSource7 = mutableInteractionSource3;
                                        }
                                        if (i6 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 929353188, "CC(remember):Slider.kt#9igjgp");
                                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                                        }
                                        ComposableLambda composableLambdaRememberComposableLambda = i7 != 0 ? ComposableLambdaKt.rememberComposableLambda(1597255314, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.14
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "CN(it)706@32641L132:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1597255314, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:706)");
                                                }
                                                SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource7, null, sliderColorsColors, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54) : function3;
                                        ComposableLambda composableLambdaRememberComposableLambda2 = i9 != 0 ? ComposableLambdaKt.rememberComposableLambda(1348023737, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.15
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "CN(it)713@32861L130:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1348023737, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:713)");
                                                }
                                                SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource4, null, sliderColorsColors, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54) : function32;
                                        if (i11 != 0) {
                                            modifier3 = companion;
                                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-453269015, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.16
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                    invoke(rangeSliderState3, composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                    ComposerKt.sourceInformation(composer3, "CN(rangeSliderState)720@33096L125:Slider.kt#uh7d8r");
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-453269015, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:720)");
                                                    }
                                                    SliderDefaults.INSTANCE.m4095Track4EFweAY(rangeSliderState3, (Modifier) null, z2, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i14 & 14) | 100663296, 242);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composerStartRestartGroup, 54);
                                        } else {
                                            function3RememberComposableLambda = function33;
                                            modifier3 = companion;
                                        }
                                        mutableInteractionSource8 = mutableInteractionSource7;
                                        function37 = composableLambdaRememberComposableLambda;
                                        function38 = composableLambdaRememberComposableLambda2;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i2 & 8) != 0) {
                                            i3 &= -7169;
                                        }
                                        modifier3 = modifier;
                                        function37 = function3;
                                        function38 = function32;
                                        function3RememberComposableLambda = function33;
                                        mutableInteractionSource8 = mutableInteractionSource3;
                                    }
                                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource4;
                                    boolean z4 = z2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-781154979, i3, -1, "androidx.compose.material3.RangeSlider (Slider.kt:726)");
                                    }
                                    if (rangeSliderState2.getSteps() < 0) {
                                        throw new IllegalArgumentException("steps should be >= 0".toString());
                                    }
                                    int i14 = i3 >> 3;
                                    composer2 = composerStartRestartGroup;
                                    RangeSliderImpl(modifier3, rangeSliderState2, z4, mutableInteractionSource8, mutableInteractionSource9, function37, function38, function3RememberComposableLambda, composer2, (i3 & 896) | (i14 & 14) | ((i3 << 3) & 112) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    sliderColors2 = sliderColorsColors;
                                    modifier2 = modifier3;
                                    z3 = z4;
                                    mutableInteractionSource5 = mutableInteractionSource8;
                                    mutableInteractionSource6 = mutableInteractionSource9;
                                    function35 = function37;
                                    function34 = function38;
                                    function36 = function3RememberComposableLambda;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    function34 = function32;
                                    z3 = z2;
                                    sliderColors2 = sliderColorsColors;
                                    mutableInteractionSource5 = mutableInteractionSource3;
                                    mutableInteractionSource6 = mutableInteractionSource4;
                                    function35 = function3;
                                    function36 = function33;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda22
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return SliderKt.RangeSlider$lambda$23(rangeSliderState, modifier2, z3, sliderColors2, mutableInteractionSource5, mutableInteractionSource6, function35, function34, function36, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= 100663296;
                            i11 = i10;
                            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i9 = i8;
                        i10 = i2 & 256;
                        if (i10 != 0) {
                        }
                        i11 = i10;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    mutableInteractionSource4 = mutableInteractionSource2;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 != 0) {
                    }
                    i11 = i10;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource3 = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                mutableInteractionSource4 = mutableInteractionSource2;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                }
                i11 = i10;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            mutableInteractionSource4 = mutableInteractionSource2;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
            }
            i11 = i10;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        mutableInteractionSource4 = mutableInteractionSource2;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 != 0) {
        }
        i11 = i10;
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i4;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function12;
        Modifier modifier2;
        int i5;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i6;
        int i7;
        int i8;
        Function0<Unit> function02;
        int i9;
        Composer composer2;
        final SliderColors sliderColors2;
        final Modifier modifier3;
        final boolean z3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final int i10;
        final Function0<Unit> function03;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        final SliderColors sliderColorsColors;
        final boolean z4;
        int i12;
        Function0<Unit> function04;
        int i13;
        Modifier modifier4;
        int i14;
        ClosedFloatingPointRange<Float> closedFloatingPointRange5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors)499@23112L39,500@23209L39,512@23627L187,519@23835L185,526@24038L200,502@23254L991:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            closedFloatingPointRange3 = closedFloatingPointRange;
        } else {
            closedFloatingPointRange3 = closedFloatingPointRange;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(closedFloatingPointRange3) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i15 = i3 & 4;
        if (i15 != 0) {
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
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        int i16 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i4 |= i16;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    i4 |= i16;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
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
                    if (i8 != 0) {
                        if ((1572864 & i2) == 0) {
                            function02 = function0;
                            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
                        }
                        if ((i2 & 12582912) == 0) {
                            i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 8388608 : 4194304;
                        }
                        i9 = i4;
                        if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "497@23039L8");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i15 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 16) != 0) {
                                    i11 = i9 & (-57345);
                                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                } else {
                                    i11 = i9;
                                }
                                if (i6 != 0) {
                                    i7 = 0;
                                }
                                if (i8 != 0) {
                                    function02 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    z4 = z2;
                                    i12 = i7;
                                    function04 = function02;
                                    modifier4 = companion;
                                    i14 = (-29360129) & i11;
                                    closedFloatingPointRange5 = closedFloatingPointRangeRangeTo;
                                    i13 = -743091416;
                                } else {
                                    sliderColorsColors = sliderColors;
                                    z4 = z2;
                                    i12 = i7;
                                    function04 = function02;
                                    i13 = -743091416;
                                    modifier4 = companion;
                                    i14 = i11;
                                    closedFloatingPointRange5 = closedFloatingPointRangeRangeTo;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i14 = (i3 & 16) != 0 ? i9 & (-57345) : i9;
                                if ((i3 & 128) != 0) {
                                    i14 &= -29360129;
                                }
                                z4 = z2;
                                i12 = i7;
                                function04 = function02;
                                i13 = -743091416;
                                modifier4 = modifier2;
                                closedFloatingPointRange5 = closedFloatingPointRangeRangeTo;
                                sliderColorsColors = sliderColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i13, i14, -1, "androidx.compose.material3.RangeSlider (Slider.kt:498)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1146263569, "CC(remember):Slider.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1146260465, "CC(remember):Slider.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            final MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            RangeSlider(closedFloatingPointRange3, function12, modifier4, z4, closedFloatingPointRange5, function04, null, mutableInteractionSource, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "CN(it)513@23656L148:Slider.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-811582901, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:513)");
                                    }
                                    SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource, null, sliderColorsColors, z4, 0L, composer3, 196614, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "CN(it)520@23864L146:Slider.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1832060001, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:520)");
                                    }
                                    SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource2, null, sliderColorsColors, z4, 0L, composer3, 196614, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.3
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "CN(rangeSliderState)527@24087L141:Slider.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(377064480, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:527)");
                                    }
                                    SliderDefaults.INSTANCE.m4095Track4EFweAY(rangeSliderState, (Modifier) null, z4, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i17 & 14) | 100663296, 242);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), i12, composer2, (i14 & 14) | 918552576 | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | ((i14 >> 3) & 458752), ((i14 >> 9) & 896) | 54, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors2 = sliderColorsColors;
                            modifier3 = modifier4;
                            z3 = z4;
                            closedFloatingPointRange4 = closedFloatingPointRange5;
                            function03 = function04;
                            i10 = i12;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            sliderColors2 = sliderColors;
                            modifier3 = modifier2;
                            z3 = z2;
                            closedFloatingPointRange4 = closedFloatingPointRangeRangeTo;
                            i10 = i7;
                            function03 = function02;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderKt.RangeSlider$lambda$13(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i10, function03, sliderColors2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    function02 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    i9 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 != 0) {
                }
                function02 = function0;
                if ((i2 & 12582912) == 0) {
                }
                i9 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
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
            if (i8 != 0) {
            }
            function02 = function0;
            if ((i2 & 12582912) == 0) {
            }
            i9 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
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
        if (i8 != 0) {
        }
        function02 = function0;
        if ((i2 & 12582912) == 0) {
        }
        i9 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, int i, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i7;
        Function0<Unit> function02;
        final SliderColors sliderColorsColors;
        int i8;
        MutableInteractionSource mutableInteractionSource3;
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
        int i19;
        final boolean z2;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        int i20;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final SliderColors sliderColors2;
        final Function0<Unit> function03;
        final MutableInteractionSource mutableInteractionSource4;
        final MutableInteractionSource mutableInteractionSource5;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource6;
        final MutableInteractionSource mutableInteractionSource7;
        Modifier modifier3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        boolean z4;
        ComposableLambda composableLambdaRememberComposableLambda;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        ComposableLambda composableLambdaRememberComposableLambda2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        ComposableLambda composableLambdaRememberComposableLambda3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function39;
        int i21;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function310;
        int i22;
        ClosedFloatingPointRange<Float> closedFloatingPointRange5;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function311;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function312;
        Composer composerStartRestartGroup = composer.startRestartGroup(1924256162);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,onValueChangeFinished,colors,startInteractionSource,endInteractionSource,startThumb,endThumb,track,steps)626@28935L238,637@29257L44,641@29394L292:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i23 = i4 & 4;
        if (i23 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        int i24 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i5 |= i24;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    i5 |= i24;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function02 = function0;
                } else {
                    function02 = function0;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function02) ? 131072 : 65536;
                    }
                }
                if ((i2 & 1572864) == 0) {
                    sliderColorsColors = sliderColors;
                    i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(sliderColorsColors)) ? 1048576 : 524288;
                } else {
                    sliderColorsColors = sliderColors;
                }
                i8 = i4 & 128;
                if (i8 != 0) {
                    i5 |= 12582912;
                    mutableInteractionSource3 = mutableInteractionSource;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    if ((i2 & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(mutableInteractionSource3) ? 8388608 : 4194304;
                    }
                }
                i9 = i4 & 256;
                if (i9 != 0) {
                    i5 |= 100663296;
                } else {
                    if ((i2 & 100663296) == 0) {
                        i10 = i9;
                        i5 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                    }
                    i11 = i4 & 512;
                    if (i11 == 0) {
                        i5 |= 805306368;
                    } else {
                        if ((i2 & 805306368) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        i13 = i4 & 1024;
                        if (i13 != 0) {
                            i15 = i3 | 6;
                            i14 = i13;
                        } else if ((i3 & 6) == 0) {
                            i14 = i13;
                            i15 = i3 | (composerStartRestartGroup.changedInstance(function32) ? 4 : 2);
                        } else {
                            i14 = i13;
                            i15 = i3;
                        }
                        i16 = i4 & 2048;
                        if (i16 != 0) {
                            i15 |= 48;
                            i17 = i16;
                        } else if ((i3 & 48) == 0) {
                            i17 = i16;
                            i15 |= composerStartRestartGroup.changedInstance(function33) ? 32 : 16;
                        } else {
                            i17 = i16;
                        }
                        i18 = i15;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                            if ((i3 & 384) == 0) {
                                i18 |= composerStartRestartGroup.changed(i) ? 256 : 128;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z2 = z;
                                function34 = function3;
                                i20 = i;
                                closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                                sliderColors2 = sliderColorsColors;
                                function03 = function02;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                mutableInteractionSource5 = mutableInteractionSource2;
                                function35 = function32;
                                function36 = function33;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "599@27997L8,600@28062L39,601@28156L39,602@28254L163,609@28474L161,616@28689L176");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i23 != 0 ? Modifier.INSTANCE : modifier2;
                                    z3 = i6 != 0 ? true : z;
                                    if ((i4 & 16) != 0) {
                                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                        i5 &= -57345;
                                    }
                                    if (i7 != 0) {
                                        function02 = null;
                                    }
                                    if ((i4 & 64) != 0) {
                                        sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i5 &= -3670017;
                                    }
                                    if (i8 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920718807, "CC(remember):Slider.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        mutableInteractionSource6 = (MutableInteractionSource) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        mutableInteractionSource6 = mutableInteractionSource3;
                                    }
                                    if (i10 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920715799, "CC(remember):Slider.kt#9igjgp");
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        mutableInteractionSource7 = (MutableInteractionSource) objRememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        mutableInteractionSource7 = mutableInteractionSource2;
                                    }
                                    if (i12 != 0) {
                                        modifier3 = companion;
                                        closedFloatingPointRange4 = closedFloatingPointRangeRangeTo;
                                        z4 = true;
                                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-743960051, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.7
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer2, Integer num) {
                                                invoke(rangeSliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(it)603@28279L132:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-743960051, i25, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:603)");
                                                }
                                                SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource6, null, sliderColorsColors, z3, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                    } else {
                                        modifier3 = companion;
                                        closedFloatingPointRange4 = closedFloatingPointRangeRangeTo;
                                        z4 = true;
                                        composableLambdaRememberComposableLambda = function3;
                                    }
                                    if (i14 != 0) {
                                        function37 = composableLambdaRememberComposableLambda;
                                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1306751174, z4, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.8
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer2, Integer num) {
                                                invoke(rangeSliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(it)610@28499L130:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1306751174, i25, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:610)");
                                                }
                                                SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource7, null, sliderColorsColors, z3, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                    } else {
                                        function37 = composableLambdaRememberComposableLambda;
                                        composableLambdaRememberComposableLambda2 = function32;
                                    }
                                    if (i17 != 0) {
                                        function38 = composableLambdaRememberComposableLambda2;
                                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1234185578, z4, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.9
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer2, Integer num) {
                                                invoke(rangeSliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(rangeSliderState)617@28734L125:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1234185578, i25, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:617)");
                                                }
                                                SliderDefaults.INSTANCE.m4095Track4EFweAY(rangeSliderState, (Modifier) null, z3, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer2, (i25 & 14) | 100663296, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                    } else {
                                        function38 = composableLambdaRememberComposableLambda2;
                                        composableLambdaRememberComposableLambda3 = function33;
                                    }
                                    modifier2 = modifier3;
                                    function39 = function37;
                                    if (i19 != 0) {
                                        function310 = composableLambdaRememberComposableLambda3;
                                        i22 = i5;
                                        i21 = 0;
                                    } else {
                                        i21 = i;
                                        function310 = composableLambdaRememberComposableLambda3;
                                        i22 = i5;
                                    }
                                    closedFloatingPointRange5 = closedFloatingPointRange4;
                                    function311 = function38;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 16) != 0) {
                                        i5 &= -57345;
                                    }
                                    if ((i4 & 64) != 0) {
                                        i5 &= -3670017;
                                    }
                                    z3 = z;
                                    function39 = function3;
                                    function310 = function33;
                                    i21 = i;
                                    closedFloatingPointRange5 = closedFloatingPointRangeRangeTo;
                                    i22 = i5;
                                    mutableInteractionSource6 = mutableInteractionSource3;
                                    mutableInteractionSource7 = mutableInteractionSource2;
                                    function311 = function32;
                                }
                                composerStartRestartGroup.endDefaults();
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function313 = function39;
                                if (ComposerKt.isTraceInProgress()) {
                                    function312 = function311;
                                    ComposerKt.traceEventStart(1924256162, i22, i18, "androidx.compose.material3.RangeSlider (Slider.kt:624)");
                                } else {
                                    function312 = function311;
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920690672, "CC(remember):Slider.kt#9igjgp");
                                int i25 = i18;
                                boolean z5 = ((((57344 & i22) ^ 24576) > 16384 && composerStartRestartGroup.changed(closedFloatingPointRange5)) || (i22 & 24576) == 16384) | ((i18 & 896) == 256);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    int i26 = i21;
                                    objRememberedValue3 = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i26, function02, closedFloatingPointRange5);
                                    i20 = i26;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    i20 = i21;
                                }
                                RangeSliderState rangeSliderState = (RangeSliderState) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                rangeSliderState.setOnValueChangeFinished(function02);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920680562, "CC(remember):Slider.kt#9igjgp");
                                boolean z6 = (i22 & 112) == 32;
                                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return SliderKt.RangeSlider$lambda$18$lambda$17(function1, (SliderRange) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                rangeSliderState.setOnValueChange$material3((Function1) objRememberedValue4);
                                rangeSliderState.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
                                rangeSliderState.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
                                int i27 = (i22 >> 3) & PointerIconCompat.TYPE_TEXT;
                                int i28 = i22 >> 9;
                                int i29 = i27 | (57344 & i28) | (458752 & i28) | (i28 & 3670016);
                                int i30 = i25 << 21;
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function314 = function310;
                                RangeSlider(rangeSliderState, modifier2, z3, null, mutableInteractionSource6, mutableInteractionSource7, function313, function312, function314, composerStartRestartGroup, i29 | (29360128 & i30) | (i30 & 234881024), 8);
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function315 = function312;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                function34 = function313;
                                z2 = z3;
                                mutableInteractionSource4 = mutableInteractionSource8;
                                sliderColors2 = sliderColorsColors;
                                mutableInteractionSource5 = mutableInteractionSource7;
                                function36 = function314;
                                function03 = function02;
                                function35 = function315;
                                closedFloatingPointRange3 = closedFloatingPointRange5;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final Modifier modifier4 = modifier2;
                                final int i31 = i20;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderKt.RangeSlider$lambda$19(closedFloatingPointRange, function1, modifier4, z2, closedFloatingPointRange3, function03, sliderColors2, mutableInteractionSource4, mutableInteractionSource5, function34, function35, function36, i31, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i18 |= 384;
                        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 1024;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 2048;
                    if (i16 != 0) {
                    }
                    i18 = i15;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i10 = i9;
                i11 = i4 & 512;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 1024;
                if (i13 != 0) {
                }
                i16 = i4 & 2048;
                if (i16 != 0) {
                }
                i18 = i15;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            if ((i2 & 24576) == 0) {
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i8 = i4 & 128;
            if (i8 != 0) {
            }
            i9 = i4 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 512;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 1024;
            if (i13 != 0) {
            }
            i16 = i4 & 2048;
            if (i16 != 0) {
            }
            i18 = i15;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i8 = i4 & 128;
        if (i8 != 0) {
        }
        i9 = i4 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 512;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 1024;
        if (i13 != 0) {
        }
        i16 = i4 & 2048;
        if (i16 != 0) {
        }
        i18 = i15;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit RangeSlider$lambda$13(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, int i, Function0 function0, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, i, function0, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit RangeSlider$lambda$18$lambda$17(Function1 function1, SliderRange sliderRange) {
        function1.invoke(RangesKt.rangeTo(SliderRange.m4121getStartimpl(sliderRange.m4124unboximpl()), SliderRange.m4120getEndInclusiveimpl(sliderRange.m4124unboximpl())));
        return Unit.INSTANCE;
    }

    static final Unit RangeSlider$lambda$19(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, int i2, int i3, int i4, Composer composer, int i5) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, function0, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit RangeSlider$lambda$23(RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, int i2, Composer composer, int i3) {
        RangeSlider(rangeSliderState, modifier, z, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35 = function33;
        Composer composerStartRestartGroup = composer.startRestartGroup(-287468326);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSliderImpl)N(modifier,state,enabled,startInteractionSource,endInteractionSource,startThumb,endThumb,track)971@42967L7,981@43221L35,982@43289L33,1025@45118L3284,984@43328L5074:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(rangeSliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function35) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-287468326, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:970)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            rangeSliderState.setRtl$material3(objConsume == LayoutDirection.Rtl);
            Modifier modifierRangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.INSTANCE, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z);
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.range_start), composerStartRestartGroup, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String strM4676getString2EP1pXo2 = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.range_end), composerStartRestartGroup, 0);
            Modifier modifierThen = SizeKt.m2079requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null).then(modifierRangeSliderPressDragModifier);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1379067122, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(rangeSliderState);
            SliderKt$RangeSliderImpl$2$1 sliderKt$RangeSliderImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || sliderKt$RangeSliderImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$RangeSliderImpl$2$1RememberedValue = new SliderKt$RangeSliderImpl$2$1(rangeSliderState);
                composerStartRestartGroup.updateRememberedValue(sliderKt$RangeSliderImpl$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) sliderKt$RangeSliderImpl$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1046432705, "C990@43545L171,995@43849L100,986@43358L723,1006@44279L167,1011@44577L98,1002@44094L709,1018@44816L79:Slider.kt#uh7d8r");
            Modifier modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905911374, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$34$lambda$33(rangeSliderState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierRangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default, (Function1) objRememberedValue), rangeSliderState, z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905921031, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$36$lambda$35(strM4676getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusable = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierRangeSliderStartThumbSemantics, true, (Function1) objRememberedValue2), z, mutableInteractionSource);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusable);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 239610549, "C1000@44050L17:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function3.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierWrapContentWidth$default2 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905934858, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$39$lambda$38(rangeSliderState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierRangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default2, (Function1) objRememberedValue3), rangeSliderState, z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905944325, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM4676getString2EP1pXo2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$41$lambda$40(strM4676getString2EP1pXo2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusable2 = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierRangeSliderEndThumbSemantics, true, (Function1) objRememberedValue4), z, mutableInteractionSource2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusable2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 85810862, "C1016@44774L15:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 15) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -979172334, "C1018@44881L12:Slider.kt#uh7d8r");
            Integer numValueOf = Integer.valueOf(((i3 >> 18) & 112) | i4);
            function35 = function33;
            function35.invoke(rangeSliderState, composerStartRestartGroup, numValueOf);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function34 = function32;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36 = function34;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.RangeSliderImpl$lambda$46(modifier, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function36, function35, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$34$lambda$33(RangeSliderState rangeSliderState, IntSize intSize) {
        rangeSliderState.setStartThumbWidth$material3((int) (intSize.m9289unboximpl() >> 32));
        rangeSliderState.setStartThumbHeight$material3((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$36$lambda$35(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$39$lambda$38(RangeSliderState rangeSliderState, IntSize intSize) {
        rangeSliderState.setEndThumbWidth$material3((int) (intSize.m9289unboximpl() >> 32));
        rangeSliderState.setEndThumbHeight$material3((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$41$lambda$40(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$46(Modifier modifier, RangeSliderState rangeSliderState, boolean z, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, Composer composer, int i2) {
        RangeSliderImpl(modifier, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z2;
        int i7;
        Function0<Unit> function02;
        final SliderColors sliderColorsColors;
        int i8;
        final MutableInteractionSource mutableInteractionSource2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final boolean z3;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        final MutableInteractionSource mutableInteractionSource3;
        final Function0<Unit> function03;
        final SliderColors sliderColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i17;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i18;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i19;
        int i20;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(985901935);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Slider)N(value,onValueChange,modifier,enabled,onValueChangeFinished,colors,interactionSource,steps,thumb,track,valueRange)294@13990L92,299@14208L185:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i21 = i4 & 4;
        if (i21 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        function02 = function0;
                        i5 |= composerStartRestartGroup.changedInstance(function02) ? 16384 : 8192;
                    }
                    if ((196608 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            sliderColorsColors = sliderColors;
                            int i22 = composerStartRestartGroup.changed(sliderColorsColors) ? 131072 : 65536;
                            i5 |= i22;
                        } else {
                            sliderColorsColors = sliderColors;
                        }
                        i5 |= i22;
                    } else {
                        sliderColorsColors = sliderColors;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(i) ? 8388608 : 4194304;
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        }
                        i12 = i4 & 512;
                        if (i12 == 0) {
                            if ((i2 & 805306368) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
                            }
                            if ((i3 & 6) != 0) {
                                i14 = i3 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(closedFloatingPointRange)) ? 4 : 2);
                            } else {
                                i14 = i3;
                            }
                            i15 = i5;
                            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                i16 = i;
                                function33 = function3;
                                closedFloatingPointRange2 = closedFloatingPointRange;
                                z3 = z2;
                                function34 = function32;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                function03 = function02;
                                sliderColors2 = sliderColorsColors;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "278@13393L8,279@13453L39,281@13581L158,288@13788L114");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i21 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                    if (i7 != 0) {
                                        function02 = null;
                                    }
                                    if ((i4 & 32) != 0) {
                                        i17 = i15 & (-458753);
                                        sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    } else {
                                        i17 = i15;
                                    }
                                    if (i8 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1736002634, "CC(remember):Slider.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    }
                                    int i23 = i9 != 0 ? 0 : i;
                                    composableLambdaRememberComposableLambda = i11 != 0 ? ComposableLambdaKt.rememberComposableLambda(-1689130945, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.6
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer2, Integer num) {
                                            invoke(sliderState, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState, Composer composer2, int i24) {
                                            ComposerKt.sourceInformation(composer2, "CN(it)282@13606L127:Slider.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1689130945, i24, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:282)");
                                            }
                                            SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource2, null, sliderColorsColors, z2, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54) : function3;
                                    if (i13 != 0) {
                                        i18 = i23;
                                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-294493388, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.7
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer2, Integer num) {
                                                invoke(sliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState, Composer composer2, int i24) {
                                                ComposerKt.sourceInformation(composer2, "CN(sliderState)289@13828L68:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-294493388, i24, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:289)");
                                                }
                                                SliderDefaults.INSTANCE.m4096Track4EFweAY(sliderState, (Modifier) null, z2, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer2, (i24 & 14) | 100663296, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                    } else {
                                        i18 = i23;
                                        composableLambdaRememberComposableLambda2 = function32;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                        i14 &= -15;
                                    } else {
                                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                                    }
                                    i19 = i17;
                                    i20 = i14;
                                    function35 = composableLambdaRememberComposableLambda2;
                                    i16 = i18;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 32) != 0) {
                                        i15 &= -458753;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i14 &= -15;
                                    }
                                    i16 = i;
                                    function35 = function32;
                                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                                    i20 = i14;
                                    i19 = i15;
                                    composableLambdaRememberComposableLambda = function3;
                                }
                                composerStartRestartGroup.endDefaults();
                                Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36 = composableLambdaRememberComposableLambda;
                                if (ComposerKt.isTraceInProgress()) {
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    ComposerKt.traceEventStart(985901935, i19, i20, "androidx.compose.material3.Slider (Slider.kt:292)");
                                } else {
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1735985397, "CC(remember):Slider.kt#9igjgp");
                                boolean z4 = ((29360128 & i19) == 8388608) | ((((i20 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) || (i20 & 6) == 4);
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new SliderState(f, i16, function02, closedFloatingPointRangeRangeTo);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                SliderState sliderState = (SliderState) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                sliderState.setOnValueChangeFinished(function02);
                                sliderState.setOnValueChange(function1);
                                sliderState.setValue(f);
                                int i24 = ((i19 >> 3) & PointerIconCompat.TYPE_TEXT) | ((i19 >> 6) & 57344);
                                int i25 = i19 >> 9;
                                Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function37 = function35;
                                Slider(sliderState, modifier2, z2, null, mutableInteractionSource4, function36, function37, composerStartRestartGroup, i24 | (458752 & i25) | (i25 & 3670016), 8);
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                function33 = function36;
                                z3 = z2;
                                function34 = function37;
                                mutableInteractionSource3 = mutableInteractionSource5;
                                sliderColors2 = sliderColorsColors;
                                function03 = function02;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final Modifier modifier3 = modifier2;
                                final int i26 = i16;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderKt.Slider$lambda$4(f, function1, modifier3, z3, function03, sliderColors2, mutableInteractionSource3, i26, function33, function34, closedFloatingPointRange2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= 805306368;
                        i13 = i12;
                        if ((i3 & 6) != 0) {
                        }
                        i15 = i5;
                        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i4 & 512;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    if ((i3 & 6) != 0) {
                    }
                    i15 = i5;
                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function02 = function0;
                if ((196608 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i9 = i4 & 128;
                if (i9 == 0) {
                }
                i10 = i4 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i4 & 512;
                if (i12 == 0) {
                }
                i13 = i12;
                if ((i3 & 6) != 0) {
                }
                i15 = i5;
                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            function02 = function0;
            if ((196608 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i9 = i4 & 128;
            if (i9 == 0) {
            }
            i10 = i4 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i4 & 512;
            if (i12 == 0) {
            }
            i13 = i12;
            if ((i3 & 6) != 0) {
            }
            i15 = i5;
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        function02 = function0;
        if ((196608 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        i10 = i4 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i4 & 512;
        if (i12 == 0) {
        }
        i13 = i12;
        if ((i3 & 6) != 0) {
        }
        i15 = i5;
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        float f2;
        int i4;
        Function1<? super Float, Unit> function12;
        Modifier modifier2;
        int i5;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i6;
        int i7;
        int i8;
        Function0<Unit> function02;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final SliderColors sliderColors2;
        final Modifier modifier3;
        final boolean z3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final int i12;
        final Function0<Unit> function03;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        final SliderColors sliderColorsColors;
        final MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i14;
        Function0<Unit> function04;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Slider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors,interactionSource)201@9624L182,208@9824L122,192@9332L654:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            f2 = f;
        } else {
            f2 = f;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(f2) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i16 = i3 & 4;
        if (i16 != 0) {
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
                        int i17 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i4 |= i17;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i4 |= i17;
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
                    } else {
                        if ((1572864 & i2) == 0) {
                            function02 = function0;
                            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
                        }
                        if ((i2 & 12582912) == 0) {
                            i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 8388608 : 4194304;
                        }
                        i9 = i3 & 256;
                        if (i9 == 0) {
                            if ((i2 & 100663296) == 0) {
                                i10 = i9;
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                            i11 = i4;
                            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                sliderColors2 = sliderColors;
                                modifier3 = modifier2;
                                z3 = z2;
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                i12 = i7;
                                function03 = function02;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "189@9223L8,190@9283L39");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z2 = true;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i13 = i11 & (-57345);
                                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                    } else {
                                        i13 = i11;
                                    }
                                    if (i6 != 0) {
                                        i7 = 0;
                                    }
                                    if (i8 != 0) {
                                        function02 = null;
                                    }
                                    if ((i3 & 128) != 0) {
                                        sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i13 = (-29360129) & i13;
                                    } else {
                                        sliderColorsColors = sliderColors;
                                    }
                                    if (i10 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -890767796, "CC(remember):Slider.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    modifier4 = modifier2;
                                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                                    i14 = i7;
                                    function04 = function02;
                                    i15 = -202044027;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    int i18 = (i3 & 16) != 0 ? i11 & (-57345) : i11;
                                    if ((i3 & 128) != 0) {
                                        i18 &= -29360129;
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i13 = i18;
                                    modifier4 = modifier2;
                                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                                    i14 = i7;
                                    function04 = function02;
                                    i15 = -202044027;
                                    sliderColorsColors = sliderColors;
                                }
                                final boolean z4 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i15, i13, -1, "androidx.compose.material3.Slider (Slider.kt:191)");
                                }
                                int i19 = i13 >> 6;
                                SliderColors sliderColors3 = sliderColorsColors;
                                composer2 = composerStartRestartGroup;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                Slider(f2, function12, modifier4, z4, function04, sliderColors3, mutableInteractionSource4, i14, ComposableLambdaKt.rememberComposableLambda(308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                        invoke(sliderState, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "CN(it)202@9653L143:Slider.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(308249025, i20, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:202)");
                                        }
                                        SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource3, null, sliderColorsColors, z4, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.3
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                        invoke(sliderState, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "CN(sliderState)209@9868L68:Slider.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1843234110, i20, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:209)");
                                        }
                                        SliderDefaults.INSTANCE.m4096Track4EFweAY(sliderState, (Modifier) null, z4, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i20 & 14) | 100663296, 242);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), closedFloatingPointRange3, composer2, (i13 & 14) | 905969664 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i19) | (458752 & i19) | (i19 & 3670016) | ((i13 << 6) & 29360128), (i13 >> 12) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z3 = z4;
                                function03 = function04;
                                sliderColors2 = sliderColors3;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                i12 = i14;
                                closedFloatingPointRange2 = closedFloatingPointRange3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderKt.Slider$lambda$1(f, function1, modifier3, z3, closedFloatingPointRange2, i12, function03, sliderColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 100663296;
                        i10 = i9;
                        i11 = i4;
                        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function02 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    i11 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                function02 = function0;
                if ((i2 & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
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
            function02 = function0;
            if ((i2 & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
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
        if (i6 != 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i2 & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        SliderState sliderState2;
        int i3;
        int i4;
        final boolean z2;
        final SliderColors sliderColorsColors;
        int i5;
        final MutableInteractionSource mutableInteractionSource2;
        int i6;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        int i7;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda2;
        final Modifier modifier2;
        final boolean z3;
        final SliderColors sliderColors2;
        final MutableInteractionSource mutableInteractionSource3;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(409861960);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Slider)N(state,modifier,enabled,colors,interactionSource,thumb,track)374@17399L189:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderState2 = sliderState;
        } else {
            sliderState2 = sliderState;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(sliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
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
                        sliderColorsColors = sliderColors;
                        int i9 = composerStartRestartGroup.changed(sliderColorsColors) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        sliderColorsColors = sliderColors;
                    }
                    i3 |= i9;
                } else {
                    sliderColorsColors = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            function3RememberComposableLambda = function3;
                            i3 |= composerStartRestartGroup.changedInstance(function3RememberComposableLambda) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 == 0) {
                            if ((1572864 & i) == 0) {
                                function3RememberComposableLambda2 = function32;
                                i3 |= composerStartRestartGroup.changedInstance(function3RememberComposableLambda2) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                z3 = z2;
                                sliderColors2 = sliderColorsColors;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                function33 = function3RememberComposableLambda;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "359@16862L8,360@16922L39,361@17010L158,368@17217L114");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    }
                                    if (i5 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1259639953, "CC(remember):Slider.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    }
                                    if (i6 != 0) {
                                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2100927368, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.10
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState3, Composer composer2, Integer num) {
                                                invoke(sliderState3, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState3, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "CN(it)362@17035L127:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2100927368, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:362)");
                                                }
                                                SliderDefaults.INSTANCE.m4093Thumb9LiSoMs(mutableInteractionSource2, null, sliderColorsColors, z2, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                    }
                                    if (i7 != 0) {
                                        function3RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-81224541, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.11
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState3, Composer composer2, Integer num) {
                                                invoke(sliderState3, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState3, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "CN(sliderState)369@17257L68:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-81224541, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:369)");
                                                }
                                                SliderDefaults.INSTANCE.m4096Track4EFweAY(sliderState3, (Modifier) null, z2, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer2, (i10 & 14) | 100663296, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                    }
                                    z4 = z2;
                                    function34 = function3RememberComposableLambda;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    modifier3 = companion;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    z4 = z2;
                                    function34 = function3RememberComposableLambda;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    modifier3 = modifier;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(409861960, i3, -1, "androidx.compose.material3.Slider (Slider.kt:371)");
                                }
                                if (sliderState2.getSteps() < 0) {
                                    throw new IllegalArgumentException("steps should be >= 0".toString());
                                }
                                int i10 = i3 >> 3;
                                SliderImpl(modifier3, sliderState2, z4, mutableInteractionSource4, function34, function3RememberComposableLambda2, composerStartRestartGroup, (i3 & 896) | (i10 & 14) | ((i3 << 3) & 112) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                sliderColors2 = sliderColorsColors;
                                modifier2 = modifier3;
                                z3 = z4;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                function33 = function34;
                            }
                            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = function3RememberComposableLambda2;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda23
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderKt.Slider$lambda$7(sliderState, modifier2, z3, sliderColors2, mutableInteractionSource3, function33, function35, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 1572864;
                        function3RememberComposableLambda2 = function32;
                        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        }
                        final Function3 function352 = function3RememberComposableLambda2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function3RememberComposableLambda = function3;
                    i7 = i2 & 64;
                    if (i7 == 0) {
                    }
                    function3RememberComposableLambda2 = function32;
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                    }
                    final Function3 function3522 = function3RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function3RememberComposableLambda = function3;
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                function3RememberComposableLambda2 = function32;
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                final Function3 function35222 = function3RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function3RememberComposableLambda = function3;
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            function3RememberComposableLambda2 = function32;
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            final Function3 function352222 = function3RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function3RememberComposableLambda = function3;
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        function3RememberComposableLambda2 = function32;
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        final Function3 function3522222 = function3RememberComposableLambda2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit Slider$lambda$1(float f, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange, int i, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        Slider(f, function1, modifier, z, closedFloatingPointRange, i, function0, sliderColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit Slider$lambda$4(float f, Function1 function1, Modifier modifier, boolean z, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3 function3, Function3 function32, ClosedFloatingPointRange closedFloatingPointRange, int i2, int i3, int i4, Composer composer, int i5) {
        Slider(f, function1, modifier, z, function0, sliderColors, mutableInteractionSource, i, function3, function32, closedFloatingPointRange, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit Slider$lambda$7(SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        Slider(sliderState, modifier, z, sliderColors, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void SliderImpl(final Modifier modifier, final SliderState sliderState, final boolean z, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i) {
        int i2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        MutableInteractionSource mutableInteractionSource2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34 = function32;
        Composer composerStartRestartGroup = composer.startRestartGroup(898172835);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderImpl)N(modifier,state,enabled,interactionSource,thumb,track)751@33925L7,762@34446L28,806@36026L3110,773@34814L4322:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(sliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function34) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(898172835, i2, -1, "androidx.compose.material3.SliderImpl (Slider.kt:750)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            sliderState.setRtl$material3(objConsume == LayoutDirection.Rtl);
            boolean z2 = (sliderState.getOrientation() == Orientation.Horizontal && sliderState.getIsRtl()) || (sliderState.getOrientation() == Orientation.Vertical && sliderState.getReverseVerticalDirection());
            Modifier modifierSliderTapModifier = sliderTapModifier(Modifier.INSTANCE, sliderState, mutableInteractionSource, z);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation$material3 = sliderState.getOrientation();
            boolean z3 = z2;
            boolean zIsDragging = sliderState.isDragging();
            Modifier.Companion companion2 = companion;
            SliderState sliderState2 = sliderState;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -144304801, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sliderState);
            SliderKt$SliderImpl$drag$1$1 sliderKt$SliderImpl$drag$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || sliderKt$SliderImpl$drag$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$SliderImpl$drag$1$1RememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                composerStartRestartGroup.updateRememberedValue(sliderKt$SliderImpl$drag$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            Modifier modifierDraggable$default = DraggableKt.draggable$default(companion2, sliderState2, orientation$material3, z, mutableInteractionSource, zIsDragging, null, (Function3) sliderKt$SliderImpl$drag$1$1RememberedValue, z3, 32, null);
            mutableInteractionSource2 = mutableInteractionSource;
            Modifier modifierWrapContentHeight$default = sliderState.getOrientation() == Orientation.Vertical ? SizeKt.wrapContentHeight$default(LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB), null, false, 3, null) : SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB), null, false, 3, null);
            Modifier modifierThen = slideOnKeyEvents(FocusableKt.focusable(sliderSemantics(SizeKt.m2079requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), sliderState.getOrientation() == Orientation.Vertical ? TrackHeight : ThumbWidth, sliderState.getOrientation() == Orientation.Vertical ? ThumbWidth : TrackHeight, 0.0f, 0.0f, 12, null), sliderState, z), z, mutableInteractionSource2), z, sliderState.getSteps(), sliderState.getValueRange(), sliderState.getValue(), z3, sliderState.getOnValueChange(), sliderState.getOnValueChangeFinished()).then(modifierSliderTapModifier).then(modifierDraggable$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -144251159, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(sliderState);
            SliderKt$SliderImpl$2$1 sliderKt$SliderImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || sliderKt$SliderImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$SliderImpl$2$1RememberedValue = new SliderKt$SliderImpl$2$1(sliderState);
                composerStartRestartGroup.updateRememberedValue(sliderKt$SliderImpl$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) sliderKt$SliderImpl$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1885666906, "C777@34924L129,775@34844L268,784@35125L74:Slider.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1878837019, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.SliderImpl$lambda$29$lambda$26$lambda$25(sliderState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentHeight$default, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -294052009, "C782@35086L12:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function33 = function3;
            function33.invoke(sliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 9) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -836287744, "C784@35185L12:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(sliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function33 = function3;
            mutableInteractionSource2 = mutableInteractionSource;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = function34;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36 = function33;
            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderImpl$lambda$31(modifier, sliderState, z, mutableInteractionSource3, function36, function35, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SliderImpl$lambda$29$lambda$26$lambda$25(SliderState sliderState, IntSize intSize) {
        sliderState.setThumbWidth$material3((int) (intSize.m9289unboximpl() >> 32));
        sliderState.setThumbHeight$material3((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        return Unit.INSTANCE;
    }

    static final Unit SliderImpl$lambda$31(Modifier modifier, SliderState sliderState, boolean z, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, Composer composer, int i2) {
        SliderImpl(modifier, sliderState, z, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final long SliderRange(float f, float f2) {
        if (!(Float.isNaN(f) && Float.isNaN(f2)) && f > f2) {
            throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f2 + ')').toString());
        }
        return SliderRange.m4117constructorimpl((((long) Float.floatToRawIntBits(f2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float fFloatValue = closedFloatingPointRange.getStart().floatValue();
        float fFloatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
        if (!(Float.isNaN(fFloatValue) && Float.isNaN(fFloatValue2)) && fFloatValue > fFloatValue2) {
            throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + fFloatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + fFloatValue2 + ')').toString());
        }
        return SliderRange.m4117constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(fFloatValue2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VerticalSlider(final SliderState sliderState, Modifier modifier, boolean z, boolean z2, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z3;
        int i5;
        boolean z4;
        final SliderColors sliderColorsColors;
        int i6;
        final MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final boolean z5;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1841025790);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalSlider)N(state,modifier,enabled,reverseDirection,colors,interactionSource,thumb,track)444@20428L189:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
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
                    z3 = z;
                    i3 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            sliderColorsColors = sliderColors;
                            int i13 = composerStartRestartGroup.changed(sliderColorsColors) ? 16384 : 8192;
                            i3 |= i13;
                        } else {
                            sliderColorsColors = sliderColors;
                        }
                        i3 |= i13;
                    } else {
                        sliderColorsColors = sliderColors;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 == 0) {
                            if ((i & 12582912) == 0) {
                                i9 = i8;
                                i3 |= composerStartRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                            }
                            i10 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function33 = function32;
                                z5 = z3;
                                function34 = function3;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "419@19613L8,420@19673L39,421@19761L255,430@20065L207");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i12 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z3 = true;
                                    }
                                    if (i5 != 0) {
                                        z4 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i11 = i10 & (-57345);
                                        sliderColorsColors = SliderDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    } else {
                                        i11 = i10;
                                    }
                                    if (i6 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 300751721, "CC(remember):Slider.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    }
                                    composableLambdaRememberComposableLambda = i7 != 0 ? ComposableLambdaKt.rememberComposableLambda(1896624690, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.VerticalSlider.2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState2, Composer composer3, Integer num) {
                                            invoke(sliderState2, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState2, Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "CN(sliderState)422@19801L209:Slider.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1896624690, i14, -1, "androidx.compose.material3.VerticalSlider.<anonymous> (Slider.kt:422)");
                                            }
                                            SliderDefaults.INSTANCE.m4094ThumbHwbPF3A$material3(mutableInteractionSource2, sliderState2, null, sliderColorsColors, z3, SliderKt.VerticalThumbSize, composer3, ((i14 << 3) & 112) | 1769472, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54) : function3;
                                    composableLambdaRememberComposableLambda2 = i9 != 0 ? ComposableLambdaKt.rememberComposableLambda(-1702448035, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.VerticalSlider.3
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState2, Composer composer3, Integer num) {
                                            invoke(sliderState2, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState2, Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "CN(sliderState)431@20105L161:Slider.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1702448035, i14, -1, "androidx.compose.material3.VerticalSlider.<anonymous> (Slider.kt:431)");
                                            }
                                            SliderDefaults.INSTANCE.m4098TrackmnvyFg4$material3(sliderState2, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), (Modifier) null, z3, sliderColorsColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i14 & 14) | 805306416, Videoio.CAP_PROP_XI_CC_MATRIX_11);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54) : function32;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1841025790, i11, -1, "androidx.compose.material3.VerticalSlider (Slider.kt:438)");
                                    }
                                    if (sliderState.getSteps() < 0) {
                                        throw new IllegalArgumentException("steps should be >= 0".toString());
                                    }
                                    sliderState.setOrientation$material3(Orientation.Vertical);
                                    sliderState.setReverseVerticalDirection$material3(z4);
                                    int i14 = i11 >> 6;
                                    Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = composableLambdaRememberComposableLambda2;
                                    SliderImpl(modifier2, sliderState, z3, mutableInteractionSource2, composableLambdaRememberComposableLambda, function35, composerStartRestartGroup, (i14 & 458752) | ((i11 >> 3) & 14) | ((i11 << 3) & 112) | (i11 & 896) | (i14 & 7168) | (57344 & i14));
                                    composer2 = composerStartRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z5 = z3;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function33 = function35;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        composableLambdaRememberComposableLambda = function3;
                                        i11 = i10 & (-57345);
                                        composerStartRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (sliderState.getSteps() < 0) {
                                        }
                                    } else {
                                        composableLambdaRememberComposableLambda = function3;
                                        composableLambdaRememberComposableLambda2 = function32;
                                        i11 = i10;
                                        composerStartRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (sliderState.getSteps() < 0) {
                                        }
                                    }
                                }
                            }
                            final Modifier modifier3 = modifier2;
                            final boolean z6 = z4;
                            final SliderColors sliderColors2 = sliderColorsColors;
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderKt.VerticalSlider$lambda$10(sliderState, modifier3, z5, z6, sliderColors2, mutableInteractionSource3, function34, function33, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 12582912;
                        i9 = i8;
                        i10 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                        }
                        final Modifier modifier32 = modifier2;
                        final boolean z62 = z4;
                        final SliderColors sliderColors22 = sliderColorsColors;
                        final MutableInteractionSource mutableInteractionSource32 = mutableInteractionSource2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                    }
                    final Modifier modifier322 = modifier2;
                    final boolean z622 = z4;
                    final SliderColors sliderColors222 = sliderColorsColors;
                    final MutableInteractionSource mutableInteractionSource322 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z4 = z2;
                if ((i & 24576) != 0) {
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                }
                final Modifier modifier3222 = modifier2;
                final boolean z6222 = z4;
                final SliderColors sliderColors2222 = sliderColorsColors;
                final MutableInteractionSource mutableInteractionSource3222 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z4 = z2;
            if ((i & 24576) != 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
            }
            final Modifier modifier32222 = modifier2;
            final boolean z62222 = z4;
            final SliderColors sliderColors22222 = sliderColorsColors;
            final MutableInteractionSource mutableInteractionSource32222 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z4 = z2;
        if ((i & 24576) != 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
        }
        final Modifier modifier322222 = modifier2;
        final boolean z622222 = z4;
        final SliderColors sliderColors222222 = sliderColorsColors;
        final MutableInteractionSource mutableInteractionSource322222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit VerticalSlider$lambda$10(SliderState sliderState, Modifier modifier, boolean z, boolean z2, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        VerticalSlider(sliderState, modifier, z, z2, sliderColors, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m4110awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
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
            Function2 function2 = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SliderKt.awaitSlop_8vUncbI$lambda$49(floatRef2, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            };
            sliderKt$awaitSlop$12.L$0 = floatRef2;
            sliderKt$awaitSlop$12.label = 1;
            Object objM4583awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m4583awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
            if (objM4583awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objM4583awaitHorizontalPointerSlopOrCancellationgDDlDlE;
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

    static final Unit awaitSlop_8vUncbI$lambda$49(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
        pointerInputChange.consume();
        floatRef.element = f;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    private static final String formatForSemantics(float f) {
        return String.valueOf(MathKt.roundToInt(f * 100.0f) / 100.0f);
    }

    public static final VerticalAlignmentLine getCornerSizeAlignmentLine() {
        return CornerSizeAlignmentLine;
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4, reason: not valid java name */
    public static final boolean m4111isSpecifiedIf1S1O4(long j) {
        return j != SliderRange.INSTANCE.m4126getUnspecifiedFYbKRX4();
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4$annotations, reason: not valid java name */
    public static /* synthetic */ void m4112isSpecifiedIf1S1O4$annotations(long j) {
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), rangeSliderState.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.rangeSliderEndThumbSemantics$lambda$58(z, rangeSliderState, closedFloatingPointRangeRangeTo, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeEnd(), closedFloatingPointRangeRangeTo, rangeSliderState.getEndSteps$material3());
    }

    static final Unit rangeSliderEndThumbSemantics$lambda$58(boolean z, final RangeSliderState rangeSliderState, final ClosedFloatingPointRange closedFloatingPointRange, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(rangeSliderState.getActiveRangeEnd()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.rangeSliderEndThumbSemantics$lambda$58$lambda$57(closedFloatingPointRange, rangeSliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final boolean rangeSliderEndThumbSemantics$lambda$58$lambda$57(ClosedFloatingPointRange closedFloatingPointRange, RangeSliderState rangeSliderState, float f) {
        int endSteps$material3;
        float fCoerceIn = RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (rangeSliderState.getEndSteps$material3() > 0 && (endSteps$material3 = rangeSliderState.getEndSteps$material3() + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f2 = fAbs;
            int i = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState.getEndSteps$material3() + 1));
                float f3 = fLerp - fCoerceIn;
                if (Math.abs(f3) <= fAbs) {
                    fAbs = Math.abs(f3);
                    f2 = fLerp;
                }
                if (i == endSteps$material3) {
                    break;
                }
                i++;
            }
            fCoerceIn = f2;
        }
        if (fCoerceIn == rangeSliderState.getActiveRangeEnd()) {
            return false;
        }
        long jSliderRange = SliderRange(rangeSliderState.getActiveRangeStart(), fCoerceIn);
        if (!SliderRange.m4119equalsimpl0(jSliderRange, SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
            if (rangeSliderState.getOnValueChange$material3() != null) {
                Function1<SliderRange, Unit> onValueChange$material3 = rangeSliderState.getOnValueChange$material3();
                if (onValueChange$material3 != null) {
                    onValueChange$material3.invoke(SliderRange.m4116boximpl(jSliderRange));
                }
            } else {
                rangeSliderState.setActiveRangeStart(SliderRange.m4121getStartimpl(jSliderRange));
                rangeSliderState.setActiveRangeEnd(SliderRange.m4120getEndInclusiveimpl(jSliderRange));
            }
        }
        Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, final RangeSliderState rangeSliderState, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, new PointerInputEventHandler() { // from class: androidx.compose.material3.SliderKt.rangeSliderPressDragModifier.1

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {2437}, m = "invokeSuspend", n = {}, s = {})
            static final class C00691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ RangeSliderState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {2438, 2450, 2473}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", NotificationCompat.CATEGORY_EVENT, "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
                static final class C00701 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ RangeSliderState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {2493}, m = "invokeSuspend", n = {}, s = {})
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
                    C00701(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, CoroutineScope coroutineScope, Continuation<? super C00701> continuation) {
                        super(2, continuation);
                        this.$state = rangeSliderState;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$$this$coroutineScope = coroutineScope;
                    }

                    static final Unit invokeSuspend$lambda$1(RangeSliderState rangeSliderState, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32));
                        boolean z = booleanRef.element;
                        if (rangeSliderState.isRtl$material3()) {
                            fIntBitsToFloat = -fIntBitsToFloat;
                        }
                        rangeSliderState.onDrag$material3(z, fIntBitsToFloat);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00701 c00701 = new C00701(this.$state, this.$rangeSliderLogic, this.$$this$coroutineScope, continuation);
                        c00701.L$0 = obj;
                        return c00701;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00701) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x018a  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0194 A[Catch: all -> 0x0026, CancellationException -> 0x01a6, TryCatch #0 {all -> 0x0026, blocks: (B:8:0x001f, B:57:0x018c, B:59:0x0194, B:60:0x019c, B:63:0x01a6, B:53:0x0164), top: B:69:0x000f }] */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x019c A[Catch: all -> 0x0026, CancellationException -> 0x01a6, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:8:0x001f, B:57:0x018c, B:59:0x0194, B:60:0x019c, B:63:0x01a6, B:53:0x0164), top: B:69:0x000f }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        Object objAwaitFirstDown$default;
                        AwaitPointerEventScope awaitPointerEventScope;
                        PointerInputChange pointerInputChange;
                        char c;
                        Object objM4110awaitSlop8vUncbI;
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
                        try {
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
                                    this.$state.setDragging$material3(false);
                                    this.$state.getGestureEndAction$material3().invoke(Boxing.boxBoolean(booleanRef2.element));
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
                                objM4110awaitSlop8vUncbI = obj;
                                pair = (Pair) objM4110awaitSlop8vUncbI;
                                if (pair != null) {
                                    RangeSliderState rangeSliderState = this.$state;
                                    float fM4586pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m4586pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
                                    if (Math.abs(rangeSliderState.getRawOffsetEnd$material3() - floatRef.element) < fM4586pointerSlopE8SPZFQ && Math.abs(rangeSliderState.getRawOffsetStart$material3() - floatRef.element) < fM4586pointerSlopE8SPZFQ) {
                                        float fFloatValue = ((Number) pair.getSecond()).floatValue();
                                        booleanRef.element = !rangeSliderState.isRtl$material3() ? fFloatValue >= 0.0f : fFloatValue < 0.0f;
                                        floatRef.element += Float.intBitsToFloat((int) (PointerEventKt.positionChange((PointerInputChange) pair.getFirst()) >> c));
                                    }
                                }
                                this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                                try {
                                    this.$state.setDragging$material3(true);
                                    long id = pointerInputChange.getId();
                                    final RangeSliderState rangeSliderState2 = this.$state;
                                    this.L$0 = start;
                                    this.L$1 = booleanRef;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.label = 3;
                                    objM1693horizontalDragjO51t88 = DragGestureDetectorKt.m1693horizontalDragjO51t88(awaitPointerEventScope, id, new Function1() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return SliderKt.C04501.C00691.C00701.invokeSuspend$lambda$1(rangeSliderState2, booleanRef, (PointerInputChange) obj2);
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
                                    this.$state.setDragging$material3(false);
                                    this.$state.getGestureEndAction$material3().invoke(Boxing.boxBoolean(booleanRef2.element));
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
                            floatRef3.element = this.$state.isRtl$material3() ? this.$state.getTotalWidth$material3() - Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) : Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32));
                            int iCompareOffsets = this.$rangeSliderLogic.compareOffsets(floatRef3.element);
                            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                            booleanRef3.element = iCompareOffsets == 0 ? this.$state.getRawOffsetStart$material3() > floatRef3.element : iCompareOffsets < 0;
                            c = ' ';
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerInputChange;
                            this.L$2 = start3;
                            this.L$3 = floatRef3;
                            this.L$4 = booleanRef3;
                            this.label = 2;
                            objM4110awaitSlop8vUncbI = SliderKt.m4110awaitSlop8vUncbI(awaitPointerEventScope, pointerInputChange.getId(), pointerInputChange.getType(), this);
                            if (objM4110awaitSlop8vUncbI != coroutine_suspended) {
                                floatRef = floatRef3;
                                start = start3;
                                booleanRef = booleanRef3;
                                pair = (Pair) objM4110awaitSlop8vUncbI;
                                if (pair != null) {
                                }
                                this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                                this.$state.setDragging$material3(true);
                                long id2 = pointerInputChange.getId();
                                final RangeSliderState rangeSliderState22 = this.$state;
                                this.L$0 = start;
                                this.L$1 = booleanRef;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 3;
                                objM1693horizontalDragjO51t88 = DragGestureDetectorKt.m1693horizontalDragjO51t88(awaitPointerEventScope, id2, new Function1() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return SliderKt.C04501.C00691.C00701.invokeSuspend$lambda$1(rangeSliderState22, booleanRef, (PointerInputChange) obj2);
                                    }
                                }, this);
                                if (objM1693horizontalDragjO51t88 != coroutine_suspended) {
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            this.$state.setDragging$material3(false);
                            throw th;
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00691(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, Continuation<? super C00691> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = rangeSliderState;
                    this.$rangeSliderLogic = rangeSliderLogic;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00691 c00691 = new C00691(this.$this_pointerInput, this.$state, this.$rangeSliderLogic, continuation);
                    c00691.L$0 = obj;
                    return c00691;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00701(this.$state, this.$rangeSliderLogic, coroutineScope, null), this) == coroutine_suspended) {
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
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00691(pointerInputScope, rangeSliderState, new RangeSliderLogic(rangeSliderState, mutableInteractionSource, mutableInteractionSource2), null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(rangeSliderState.getValueRange().getStart().floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.rangeSliderStartThumbSemantics$lambda$55(z, rangeSliderState, closedFloatingPointRangeRangeTo, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeStart(), closedFloatingPointRangeRangeTo, rangeSliderState.getStartSteps$material3());
    }

    static final Unit rangeSliderStartThumbSemantics$lambda$55(boolean z, final RangeSliderState rangeSliderState, final ClosedFloatingPointRange closedFloatingPointRange, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(rangeSliderState.getActiveRangeStart()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.rangeSliderStartThumbSemantics$lambda$55$lambda$54(closedFloatingPointRange, rangeSliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final boolean rangeSliderStartThumbSemantics$lambda$55$lambda$54(ClosedFloatingPointRange closedFloatingPointRange, RangeSliderState rangeSliderState, float f) {
        int startSteps$material3;
        float fCoerceIn = RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (rangeSliderState.getStartSteps$material3() > 0 && (startSteps$material3 = rangeSliderState.getStartSteps$material3() + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f2 = fAbs;
            int i = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState.getStartSteps$material3() + 1));
                float f3 = fLerp - fCoerceIn;
                if (Math.abs(f3) <= fAbs) {
                    fAbs = Math.abs(f3);
                    f2 = fLerp;
                }
                if (i == startSteps$material3) {
                    break;
                }
                i++;
            }
            fCoerceIn = f2;
        }
        if (fCoerceIn == rangeSliderState.getActiveRangeStart()) {
            return false;
        }
        long jSliderRange = SliderRange(fCoerceIn, rangeSliderState.getActiveRangeEnd());
        if (!SliderRange.m4119equalsimpl0(jSliderRange, SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
            if (rangeSliderState.getOnValueChange$material3() != null) {
                Function1<SliderRange, Unit> onValueChange$material3 = rangeSliderState.getOnValueChange$material3();
                if (onValueChange$material3 != null) {
                    onValueChange$material3.invoke(SliderRange.m4116boximpl(jSliderRange));
                }
            } else {
                rangeSliderState.setActiveRangeStart(SliderRange.m4121getStartimpl(jSliderRange));
                rangeSliderState.setActiveRangeEnd(SliderRange.m4120getEndInclusiveimpl(jSliderRange));
            }
        }
        Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    public static final RangeSliderState rememberRangeSliderState(float f, float f2, int i, Function0<Unit> function0, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 756708139, "C(rememberRangeSliderState)N(activeRangeStart,activeRangeEnd,steps,onValueChangeFinished,valueRange)3126@135179L260,3126@135095L344:Slider.kt#uh7d8r");
        final float f3 = (i3 & 1) != 0 ? 0.0f : f;
        final float f4 = (i3 & 2) != 0 ? 1.0f : f2;
        final int i4 = (i3 & 4) != 0 ? 0 : i;
        final Function0<Unit> function02 = (i3 & 8) != 0 ? null : function0;
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = (i3 & 16) != 0 ? RangesKt.rangeTo(0.0f, 1.0f) : closedFloatingPointRange;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(756708139, i2, -1, "androidx.compose.material3.rememberRangeSliderState (Slider.kt:3125)");
        }
        Object[] objArr = new Object[0];
        Saver<RangeSliderState, ?> Saver = RangeSliderState.INSTANCE.Saver(function02, closedFloatingPointRangeRangeTo);
        ComposerKt.sourceInformationMarkerStart(composer, 1347061551, "CC(remember):Slider.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i2 & 14) ^ 6) > 4 && composer.changed(f3)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(f4)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i4)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(function02)) || (i2 & 3072) == 2048);
        if ((((57344 & i2) ^ 24576) <= 16384 || !composer.changed(closedFloatingPointRangeRangeTo)) && (i2 & 24576) != 16384) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Function0 function03 = new Function0() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SliderKt.rememberRangeSliderState$lambda$62$lambda$61(f3, f4, i4, function02, closedFloatingPointRangeRangeTo);
                }
            };
            composer.updateRememberedValue(function03);
            objRememberedValue = function03;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        RangeSliderState rangeSliderState = (RangeSliderState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rangeSliderState;
    }

    static final RangeSliderState rememberRangeSliderState$lambda$62$lambda$61(float f, float f2, int i, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
        return new RangeSliderState(f, f2, i, function0, closedFloatingPointRange);
    }

    public static final SliderState rememberSliderState(final float f, final int i, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1193499219, "C(rememberSliderState)N(value,steps,onValueChangeFinished,valueRange)2912@125235L188,2912@125156L267:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            f = 0.0f;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        if ((i3 & 8) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1193499219, i2, -1, "androidx.compose.material3.rememberSliderState (Slider.kt:2911)");
        }
        Object[] objArr = new Object[0];
        Saver<SliderState, ?> Saver = SliderState.INSTANCE.Saver(function0, closedFloatingPointRange);
        ComposerKt.sourceInformationMarkerStart(composer, 196492495, "CC(remember):Slider.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i2 & 14) ^ 6) > 4 && composer.changed(f)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(function0)) || (i2 & 384) == 256);
        if ((((i2 & 7168) ^ 3072) <= 2048 || !composer.changed(closedFloatingPointRange)) && (i2 & 3072) != 2048) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SliderKt.rememberSliderState$lambda$60$lambda$59(f, i, function0, closedFloatingPointRange);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SliderState sliderState = (SliderState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sliderState;
    }

    static final SliderState rememberSliderState$lambda$60$lambda$59(float f, int i, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
        return new SliderState(f, i, function0, closedFloatingPointRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: scale-2geJ7wY, reason: not valid java name */
    public static final long m4113scale2geJ7wY(boolean z, float f, float f2, long j, float f3, float f4) {
        float fScale = scale(f, f2, SliderRange.m4121getStartimpl(j), f3, f4);
        float fScale2 = scale(f, f2, SliderRange.m4120getEndInclusiveimpl(j), f3, f4);
        return z ? SliderRange(RangesKt.coerceAtMost(fScale, fScale2), fScale2) : SliderRange(fScale, RangesKt.coerceAtLeast(fScale2, fScale));
    }

    private static final Modifier slideOnKeyEvents(Modifier modifier, final boolean z, final int i, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final float f, final boolean z2, final Function1<? super Float, Unit> function1, final Function0<Unit> function0) {
        if (i >= 0) {
            return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.SliderKt.slideOnKeyEvents.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m4114invokeZmokQxo(keyEvent.m7470unboximpl());
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m4114invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    boolean z3 = false;
                    if (!z || function1 == null) {
                        return false;
                    }
                    int iM7482getTypeZmokQxo = KeyEvent_androidKt.m7482getTypeZmokQxo(keyEvent);
                    if (KeyEventType.m7474equalsimpl0(iM7482getTypeZmokQxo, KeyEventType.INSTANCE.m7478getKeyDownCS__XNY())) {
                        float fAbs = Math.abs(closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue());
                        int i2 = i;
                        float f2 = fAbs / (i2 > 0 ? i2 + 1 : 100);
                        int i3 = z2 ? -1 : 1;
                        long jM7481getKeyZmokQxo = KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent);
                        if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7251getDirectionUpEK5gGoQ())) {
                            function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f + (i3 * f2)), closedFloatingPointRange));
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7246getDirectionDownEK5gGoQ())) {
                            function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f - (i3 * f2)), closedFloatingPointRange));
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7250getDirectionRightEK5gGoQ())) {
                            function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f + (i3 * f2)), closedFloatingPointRange));
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7249getDirectionLeftEK5gGoQ())) {
                            function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f - (i3 * f2)), closedFloatingPointRange));
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7325getMoveHomeEK5gGoQ())) {
                            function1.invoke(closedFloatingPointRange.getStart());
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7324getMoveEndEK5gGoQ())) {
                            function1.invoke(closedFloatingPointRange.getEndInclusive());
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7362getPageUpEK5gGoQ())) {
                            function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f - (RangesKt.coerceIn(r2 / 10, 1, 10) * f2)), closedFloatingPointRange));
                        } else if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7361getPageDownEK5gGoQ())) {
                            function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f + (RangesKt.coerceIn(r2 / 10, 1, 10) * f2)), closedFloatingPointRange));
                        }
                        z3 = true;
                    } else if (KeyEventType.m7474equalsimpl0(iM7482getTypeZmokQxo, KeyEventType.INSTANCE.m7479getKeyUpCS__XNY())) {
                        long jM7481getKeyZmokQxo2 = KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent);
                        if (Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7251getDirectionUpEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7246getDirectionDownEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7250getDirectionRightEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7249getDirectionLeftEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7325getMoveHomeEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7324getMoveEndEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7362getPageUpEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo2, Key.INSTANCE.m7361getPageDownEK5gGoQ())) {
                            Function0<Unit> function02 = function0;
                            if (function02 != null) {
                                function02.invoke();
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

    private static final Modifier sliderSemantics(Modifier modifier, final SliderState sliderState, final boolean z) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.sliderSemantics$lambda$52(z, sliderState, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(sliderState.getOrientation() == Orientation.Vertical ? AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds() : AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), sliderState.getValue(), RangesKt.rangeTo(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue()), sliderState.getSteps());
    }

    static final Unit sliderSemantics$lambda$52(boolean z, final SliderState sliderState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(sliderState.getValue()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.sliderSemantics$lambda$52$lambda$51(sliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    static final boolean sliderSemantics$lambda$52$lambda$51(SliderState sliderState, float f) {
        int steps;
        float fCoerceIn = RangesKt.coerceIn(f, sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue());
        if (sliderState.getSteps() > 0 && (steps = sliderState.getSteps() + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f2 = fAbs;
            int i = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue(), i / (sliderState.getSteps() + 1));
                float f3 = fLerp - fCoerceIn;
                if (Math.abs(f3) <= fAbs) {
                    fAbs = Math.abs(f3);
                    f2 = fLerp;
                }
                if (i == steps) {
                    break;
                }
                i++;
            }
            fCoerceIn = f2;
        }
        if (fCoerceIn == sliderState.getValue()) {
            return false;
        }
        if (fCoerceIn != sliderState.getValue()) {
            if (sliderState.getOnValueChange() != null) {
                Function1<Float, Unit> onValueChange = sliderState.getOnValueChange();
                if (onValueChange != null) {
                    onValueChange.invoke(Float.valueOf(fCoerceIn));
                }
            } else {
                sliderState.setValue(fCoerceIn);
            }
        }
        Function0<Unit> onValueChangeFinished = sliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, sliderState, mutableInteractionSource, new C04521(sliderState)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f, float[] fArr, float f2, float f3) {
        Float fValueOf;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f4 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                fValueOf = Float.valueOf(f4);
            } else {
                float fAbs = Math.abs(MathHelpersKt.lerp(f2, f3, f4) - f);
                int i = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        float f5 = fArr[i];
                        float fAbs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f5) - f);
                        if (Float.compare(fAbs, fAbs2) > 0) {
                            f4 = f5;
                            fAbs = fAbs2;
                        }
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                fValueOf = Float.valueOf(f4);
            }
        }
        return fValueOf != null ? MathHelpersKt.lerp(f2, f3, fValueOf.floatValue()) : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = i3 / (i + 1);
        }
        return fArr;
    }
}
