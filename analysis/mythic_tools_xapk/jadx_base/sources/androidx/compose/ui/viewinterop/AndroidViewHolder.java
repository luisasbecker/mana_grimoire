package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.media3.muxer.MuxerUtil;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000 º\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002º\u0001B9\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0017J\b\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020\u001aH\u0016J\b\u0010g\u001a\u00020\u001aH\u0016J\b\u0010h\u001a\u00020\u001aH\u0016J\u0018\u0010i\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\u000bH\u0014J\u0006\u0010l\u001a\u00020\u001aJ0\u0010m\u001a\u00020\u001a2\u0006\u0010n\u001a\u00020!2\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u000bH\u0014J\n\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0010\u0010u\u001a\u00020\u001a2\u0006\u0010v\u001a\u00020!H\u0016J\b\u0010w\u001a\u00020\u001aH\u0014J\b\u0010x\u001a\u00020\u001aH\u0014J\u001e\u0010y\u001a\u0004\u0018\u00010z2\b\u0010\\\u001a\u0004\u0018\u00010J2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0018\u0010}\u001a\u00020\u001a2\u0006\u0010~\u001a\u00020\u000f2\u0006\u0010\u007f\u001a\u00020\u000fH\u0016J%\u0010\u0080\u0001\u001a\u00020!2\u0006\u0010~\u001a\u00020\u000f2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010|2\u0007\u0010\u0082\u0001\u001a\u00020!H\u0016J\u0007\u0010\u0083\u0001\u001a\u00020\u001aJ\u0012\u0010\u0084\u0001\u001a\u00020\u001a2\u0007\u0010\u0085\u0001\u001a\u00020\u000bH\u0014J\u0015\u0010\u0086\u0001\u001a\u00020!2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J$\u0010\u008d\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0091\u0001\u001a\u00020!H\u0016J+\u0010\u0092\u0001\u001a\u00020!2\u0006\u0010~\u001a\u00020\u000f2\u0006\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0095\u0001\u001a\u00020\u000bH\u0016J+\u0010\u0096\u0001\u001a\u00020\u001a2\u0006\u0010~\u001a\u00020\u000f2\u0006\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000bH\u0016J\u001a\u0010\u0097\u0001\u001a\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u0094\u0001\u001a\u00020\u000bH\u0016JG\u0010\u0098\u0001\u001a\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u009d\u0001\u001a\u00020JH\u0016J>\u0010\u0098\u0001\u001a\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000bH\u0016J5\u0010\u009e\u0001\u001a\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u009f\u0001\u001a\u00020\u000b2\u0007\u0010 \u0001\u001a\u00020\u000b2\u0007\u0010\u009d\u0001\u001a\u00020J2\u0007\u0010\u0094\u0001\u001a\u00020\u000bH\u0016J.\u0010¡\u0001\u001a\u00020!2\u0006\u0010\u007f\u001a\u00020\u000f2\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030£\u00012\u0007\u0010\u009d\u0001\u001a\u00020!H\u0016J%\u0010¥\u0001\u001a\u00020!2\u0006\u0010\u007f\u001a\u00020\u000f2\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030£\u0001H\u0016J\t\u0010¦\u0001\u001a\u00020!H\u0016J\u001a\u0010§\u0001\u001a\u00020O2\u0007\u0010¨\u0001\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020OH\u0016J\u0011\u0010©\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH\u0002J\u0014\u0010ª\u0001\u001a\u00030«\u00012\b\u0010¬\u0001\u001a\u00030«\u0001H\u0002J\u008e\u0001\u0010\u00ad\u0001\u001a\u0003H®\u0001\"\u0005\b\u0000\u0010®\u00012\u0007\u0010\u0018\u001a\u0003H®\u00012k\u0010¯\u0001\u001af\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(o\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(p\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(q\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(r\u0012\u0005\u0012\u0003H®\u00010°\u0001H\u0082\b¢\u0006\u0003\u0010³\u0001J3\u0010´\u0001\u001a\u00030µ\u0001*\u00030µ\u00012\u0007\u0010¶\u0001\u001a\u00020\u000b2\u0007\u0010·\u0001\u001a\u00020\u000b2\u0007\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010¹\u0001\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR$\u0010)\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020(@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0002042\u0006\u0010\u0018\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010:\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001a\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R(\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\u0018\u001a\u0004\u0018\u00010=@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u0018\u001a\u0004\u0018\u00010C@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010P\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010Q\u0012\u0004\u0012\u00020\u001a\u0018\u00010/j\u0004\u0018\u0001`RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020T8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001a\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00101\"\u0004\b[\u00103R\u000e\u0010\\\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0015\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006»\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHash", "", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;Landroidx/compose/ui/node/Owner;)V", "getView", "()Landroid/view/View;", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "value", "Lkotlin/Function0;", "", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "hasUpdateBlock", "", "reset", "getReset", "setReset", "release", "getRelease", "setRelease", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "onModifierChanged", "Lkotlin/Function1;", "getOnModifierChanged$ui", "()Lkotlin/jvm/functions/Function1;", "setOnModifierChanged$ui", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/unit/Density;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "onDensityChanged", "getOnDensityChanged$ui", "setOnDensityChanged$ui", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "position", "", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "insets", "Landroidx/core/view/WindowInsetsCompat;", "bringIntoViewRequester", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/viewinterop/BringIntoViewRequester;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "runUpdate", "runInvalidate", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui", "setOnRequestDisallowInterceptTouchEvent$ui", FirebaseAnalytics.Param.LOCATION, "lastWidthMeasureSpec", "lastHeightMeasureSpec", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "isDrawing", "isValidOwnerScope", "()Z", "getAccessibilityClassName", "", "onReuse", "onDeactivate", "onRelease", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "remeasure", "onLayout", "changed", "l", "t", "r", "b", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onAttachedToWindow", "onDetachedFromWindow", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", "child", TypedValues.AttributesType.S_TARGET, "requestChildRectangleOnScreen", "rectangle", "immediate", "invalidateOrDefer", "onWindowVisibilityChanged", "visibility", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "obtainMeasureSpec", "min", "max", "preferred", "shouldDelayChildPressedState", "onStartNestedScroll", "axes", "type", "getNestedScrollAxes", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "consumed", "onNestedPreScroll", "dx", "dy", "onNestedFling", "velocityX", "", "velocityY", "onNestedPreFling", "isNestedScrollingEnabled", "onApplyWindowInsets", "v", "insetToLayoutPosition", "insetBounds", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "insetValue", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "inset", "Landroidx/core/graphics/Insets;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope, OnApplyWindowInsetsListener {
    private Function1<? super Rect, Unit> bringIntoViewRequester;
    private final int compositeKeyHash;
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private WindowInsetsCompat insets;
    private boolean isDrawing;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private final int[] position;
    private Function0<Unit> release;
    private Function0<Unit> reset;
    private final Function0<Unit> runInvalidate;
    private final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private long size;
    private Function0<Unit> update;
    private final View view;
    public static final int $stable = 8;
    private static final Function1<AndroidViewHolder, Unit> OnCommitAffectingUpdate = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidViewHolder.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {633, 635}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $consumed;
        final /* synthetic */ long $viewVelocity;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, AndroidViewHolder androidViewHolder, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$consumed = z;
            this.this$0 = androidViewHolder;
            this.$viewVelocity = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            if (r11 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            if (r11 == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.$consumed;
                AndroidViewHolder androidViewHolder = this.this$0;
                if (z) {
                    this.label = 2;
                    obj = androidViewHolder.dispatcher.m7499dispatchPostFlingRZ2iAVY(this.$viewVelocity, Velocity.INSTANCE.m9363getZero9UxMQ8M(), this);
                } else {
                    this.label = 1;
                    obj = androidViewHolder.dispatcher.m7499dispatchPostFlingRZ2iAVY(Velocity.INSTANCE.m9363getZero9UxMQ8M(), this.$viewVelocity, this);
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                ((Velocity) obj).getPackedValue();
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((Velocity) obj).getPackedValue();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidViewHolder.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {644}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C05051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $toBeConsumed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05051(long j, Continuation<? super C05051> continuation) {
            super(2, continuation);
            this.$toBeConsumed = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidViewHolder.this.new C05051(this.$toBeConsumed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AndroidViewHolder.this.dispatcher.m7501dispatchPreFlingQWom1Mo(this.$toBeConsumed, this) == coroutine_suspended) {
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

    public AndroidViewHolder(Context context, CompositionContext compositionContext, int i, NestedScrollDispatcher nestedScrollDispatcher, View view, Owner owner) {
        super(context);
        this.compositeKeyHash = i;
        this.dispatcher = nestedScrollDispatcher;
        this.view = view;
        this.owner = owner;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        AndroidViewHolder androidViewHolder = this;
        ViewCompat.setWindowInsetsAnimationCallback(androidViewHolder, new WindowInsetsAnimationCompat.Callback() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder.2
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                return AndroidViewHolder.this.insetToLayoutPosition(insets);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
                return AndroidViewHolder.this.insetBounds(bounds);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(androidViewHolder, this);
        this.update = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.reset = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.release = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.modifier = Modifier.INSTANCE;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.position = new int[2];
        this.size = IntSize.INSTANCE.m9290getZeroYbymL2g();
        this.runUpdate = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.hasUpdateBlock && this.this$0.isAttachedToWindow()) {
                    ViewParent parent = this.this$0.getView().getParent();
                    AndroidViewHolder androidViewHolder2 = this.this$0;
                    if (parent == androidViewHolder2) {
                        OwnerSnapshotObserver snapshotObserver = androidViewHolder2.getSnapshotObserver();
                        snapshotObserver.observer.observeReads(this.this$0, AndroidViewHolder.OnCommitAffectingUpdate, this.this$0.getUpdate());
                    }
                }
            }
        };
        this.runInvalidate = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runInvalidate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getLayoutNode().invalidateLayer$ui();
            }
        };
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        final LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.setInteropViewFactoryHolder$ui(this);
        final Modifier modifierThen = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, AndroidViewHolder_androidKt.NoOpScrollConnection, this.dispatcher), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }
        }), this), new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                LayoutNode layoutNode2 = layoutNode;
                AndroidViewHolder androidViewHolder3 = this;
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                if (androidViewHolder2.getView().getVisibility() != 8) {
                    androidViewHolder2.isDrawing = true;
                    Owner owner2 = layoutNode2.getOwner();
                    AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                    if (androidComposeView != null) {
                        androidComposeView.drawAndroidView(androidViewHolder3, AndroidCanvas_androidKt.getNativeCanvas(canvas));
                    }
                    androidViewHolder2.isDrawing = false;
                }
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                WindowInsets windowInsets;
                AndroidViewHolder_androidKt.layoutAccordingTo(this.$this_run, layoutNode);
                this.$this_run.owner.onInteropViewLayoutChange(this.$this_run);
                int i2 = this.$this_run.position[0];
                int i3 = this.$this_run.position[1];
                this.$this_run.getView().getLocationOnScreen(this.$this_run.position);
                long j = this.$this_run.size;
                this.$this_run.size = layoutCoordinates.mo7777getSizeYbymL2g();
                WindowInsetsCompat windowInsetsCompat = this.$this_run.insets;
                if (windowInsetsCompat != null) {
                    if ((i2 == this.$this_run.position[0] && i3 == this.$this_run.position[1] && IntSize.m9283equalsimpl0(j, this.$this_run.size)) || (windowInsets = this.$this_run.insetToLayoutPosition(windowInsetsCompat).toWindowInsets()) == null) {
                        return;
                    }
                    this.$this_run.getView().dispatchApplyWindowInsets(windowInsets);
                }
            }
        }).then(new BringIntoViewElement(new Function1<Function1<? super Rect, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Rect, ? extends Unit> function1) {
                invoke2((Function1<? super Rect, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super Rect, Unit> function1) {
                this.$this_run.bringIntoViewRequester = function1;
            }
        }));
        layoutNode.setCompositeKeyHash(this.compositeKeyHash);
        layoutNode.setModifier(this.modifier.then(modifierThen));
        this.onModifierChanged = new Function1<Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier) {
                invoke2(modifier);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Modifier modifier) {
                layoutNode.setModifier(modifier.then(modifierThen));
            }
        };
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new Function1<Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Density density) {
                invoke2(density);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Density density) {
                layoutNode.setDensity(density);
            }
        };
        layoutNode.setOnAttach$ui(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Owner owner2) {
                invoke2(owner2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Owner owner2) {
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(this.$this_run, layoutNode);
                }
                ViewParent parent = this.$this_run.getView().getParent();
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                if (parent != androidViewHolder2) {
                    androidViewHolder2.addView(androidViewHolder2.getView());
                }
            }
        });
        layoutNode.setOnDetach$ui(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Owner owner2) {
                invoke2(owner2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Owner owner2) {
                if (ComposeUiFlags.isViewFocusFixEnabled && this.$this_run.hasFocus()) {
                    owner2.getFocusOwner().clearFocus(true);
                }
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(this.$this_run);
                }
                this.$this_run.removeAllViewsInLayout();
            }
        });
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            private final int intrinsicHeight(int width) {
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder2.measure(androidViewHolder2.obtainMeasureSpec(0, width, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return this.$this_run.getMeasuredHeight();
            }

            private final int intrinsicWidth(int height) {
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder3 = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder2.measure(iMakeMeasureSpec, androidViewHolder3.obtainMeasureSpec(0, height, layoutParams.height));
                return this.$this_run.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                return intrinsicHeight(i2);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                return intrinsicWidth(i2);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                if (this.$this_run.getChildCount() == 0) {
                    return MeasureScope.layout$default(measureScope, Constraints.m9069getMinWidthimpl(j), Constraints.m9068getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                        }
                    }, 4, null);
                }
                if (Constraints.m9069getMinWidthimpl(j) != 0) {
                    this.$this_run.getChildAt(0).setMinimumWidth(Constraints.m9069getMinWidthimpl(j));
                }
                if (Constraints.m9068getMinHeightimpl(j) != 0) {
                    this.$this_run.getChildAt(0).setMinimumHeight(Constraints.m9068getMinHeightimpl(j));
                }
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                int iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(j);
                int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(j);
                ViewGroup.LayoutParams layoutParams = this.$this_run.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                int iObtainMeasureSpec = androidViewHolder2.obtainMeasureSpec(iM9069getMinWidthimpl, iM9067getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder3 = this.$this_run;
                int iM9068getMinHeightimpl = Constraints.m9068getMinHeightimpl(j);
                int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(j);
                ViewGroup.LayoutParams layoutParams2 = this.$this_run.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                androidViewHolder2.measure(iObtainMeasureSpec, androidViewHolder3.obtainMeasureSpec(iM9068getMinHeightimpl, iM9066getMaxHeightimpl, layoutParams2.height));
                int measuredWidth = this.$this_run.getMeasuredWidth();
                int measuredHeight = this.$this_run.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder4 = this.$this_run;
                final LayoutNode layoutNode2 = layoutNode;
                return MeasureScope.layout$default(measureScope, measuredWidth, measuredHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                        AndroidViewHolder_androidKt.layoutAccordingTo(androidViewHolder4, layoutNode2);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                return intrinsicHeight(i2);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                return intrinsicWidth(i2);
            }
        });
        this.layoutNode = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.owner.getSnapshotObserver();
    }

    private final Insets inset(Insets insets, int i, int i2, int i3, int i4) {
        int i5 = insets.left - i;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = insets.top - i2;
        if (i6 < 0) {
            i6 = 0;
        }
        int i7 = insets.right - i3;
        if (i7 < 0) {
            i7 = 0;
        }
        int i8 = insets.bottom - i4;
        return Insets.of(i5, i6, i7, i8 >= 0 ? i8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsAnimationCompat.BoundsCompat insetBounds(WindowInsetsAnimationCompat.BoundsCompat bounds) {
        NodeCoordinator innerCoordinator$ui = this.layoutNode.getInnerCoordinator$ui();
        if (innerCoordinator$ui.isAttached()) {
            NodeCoordinator nodeCoordinator = innerCoordinator$ui;
            long jM9259roundk4lQ0M = IntOffsetKt.m9259roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(nodeCoordinator));
            int iM9242getXimpl = IntOffset.m9242getXimpl(jM9259roundk4lQ0M);
            if (iM9242getXimpl < 0) {
                iM9242getXimpl = 0;
            }
            int iM9243getYimpl = IntOffset.m9243getYimpl(jM9259roundk4lQ0M);
            if (iM9243getYimpl < 0) {
                iM9243getYimpl = 0;
            }
            long jMo7777getSizeYbymL2g = LayoutCoordinatesKt.findRootCoordinates(nodeCoordinator).mo7777getSizeYbymL2g();
            int i = (int) (jMo7777getSizeYbymL2g >> 32);
            int i2 = (int) (jMo7777getSizeYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            long jM9259roundk4lQ0M2 = IntOffsetKt.m9259roundk4lQ0M(innerCoordinator$ui.mo7780localToRootMKHz9U(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((int) (r11 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits((int) (innerCoordinator$ui.mo7777getSizeYbymL2g() >> 32))) << 32))));
            int iM9242getXimpl2 = i - IntOffset.m9242getXimpl(jM9259roundk4lQ0M2);
            if (iM9242getXimpl2 < 0) {
                iM9242getXimpl2 = 0;
            }
            int iM9243getYimpl2 = i2 - IntOffset.m9243getYimpl(jM9259roundk4lQ0M2);
            int i3 = iM9243getYimpl2 >= 0 ? iM9243getYimpl2 : 0;
            if (iM9242getXimpl != 0 || iM9243getYimpl != 0 || iM9242getXimpl2 != 0 || i3 != 0) {
                int i4 = iM9242getXimpl;
                int i5 = i3;
                return new WindowInsetsAnimationCompat.BoundsCompat(inset(bounds.getLowerBound(), i4, iM9243getYimpl, iM9242getXimpl2, i5), inset(bounds.getUpperBound(), i4, iM9243getYimpl, iM9242getXimpl2, i5));
            }
        }
        return bounds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsCompat insetToLayoutPosition(WindowInsetsCompat insets) {
        if (insets.hasInsets()) {
            NodeCoordinator innerCoordinator$ui = this.layoutNode.getInnerCoordinator$ui();
            if (innerCoordinator$ui.isAttached()) {
                NodeCoordinator nodeCoordinator = innerCoordinator$ui;
                long jM9259roundk4lQ0M = IntOffsetKt.m9259roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(nodeCoordinator));
                int iM9242getXimpl = IntOffset.m9242getXimpl(jM9259roundk4lQ0M);
                if (iM9242getXimpl < 0) {
                    iM9242getXimpl = 0;
                }
                int iM9243getYimpl = IntOffset.m9243getYimpl(jM9259roundk4lQ0M);
                if (iM9243getYimpl < 0) {
                    iM9243getYimpl = 0;
                }
                long jMo7777getSizeYbymL2g = LayoutCoordinatesKt.findRootCoordinates(nodeCoordinator).mo7777getSizeYbymL2g();
                int i = (int) (jMo7777getSizeYbymL2g >> 32);
                int i2 = (int) (jMo7777getSizeYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
                long jM9259roundk4lQ0M2 = IntOffsetKt.m9259roundk4lQ0M(innerCoordinator$ui.mo7780localToRootMKHz9U(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((int) (r9 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits((int) (innerCoordinator$ui.mo7777getSizeYbymL2g() >> 32))) << 32))));
                int iM9242getXimpl2 = i - IntOffset.m9242getXimpl(jM9259roundk4lQ0M2);
                if (iM9242getXimpl2 < 0) {
                    iM9242getXimpl2 = 0;
                }
                int iM9243getYimpl2 = i2 - IntOffset.m9243getYimpl(jM9259roundk4lQ0M2);
                int i3 = iM9243getYimpl2 >= 0 ? iM9243getYimpl2 : 0;
                if (iM9242getXimpl != 0 || iM9243getYimpl != 0 || iM9242getXimpl2 != 0 || i3 != 0) {
                    return insets.inset(iM9242getXimpl, iM9243getYimpl, iM9242getXimpl2, i3);
                }
            }
        }
        return insets;
    }

    private final <T> T insetValue(T value, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> block) {
        NodeCoordinator innerCoordinator$ui = this.layoutNode.getInnerCoordinator$ui();
        if (innerCoordinator$ui.isAttached()) {
            NodeCoordinator nodeCoordinator = innerCoordinator$ui;
            long jM9259roundk4lQ0M = IntOffsetKt.m9259roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(nodeCoordinator));
            int iM9242getXimpl = IntOffset.m9242getXimpl(jM9259roundk4lQ0M);
            if (iM9242getXimpl < 0) {
                iM9242getXimpl = 0;
            }
            int iM9243getYimpl = IntOffset.m9243getYimpl(jM9259roundk4lQ0M);
            if (iM9243getYimpl < 0) {
                iM9243getYimpl = 0;
            }
            long jMo7777getSizeYbymL2g = LayoutCoordinatesKt.findRootCoordinates(nodeCoordinator).mo7777getSizeYbymL2g();
            int i = (int) (jMo7777getSizeYbymL2g >> 32);
            int i2 = (int) (jMo7777getSizeYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            long jM9259roundk4lQ0M2 = IntOffsetKt.m9259roundk4lQ0M(innerCoordinator$ui.mo7780localToRootMKHz9U(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits((int) (r9 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits((int) (innerCoordinator$ui.mo7777getSizeYbymL2g() >> 32))) << 32))));
            int iM9242getXimpl2 = i - IntOffset.m9242getXimpl(jM9259roundk4lQ0M2);
            if (iM9242getXimpl2 < 0) {
                iM9242getXimpl2 = 0;
            }
            int iM9243getYimpl2 = i2 - IntOffset.m9243getYimpl(jM9259roundk4lQ0M2);
            int i3 = iM9243getYimpl2 >= 0 ? iM9243getYimpl2 : 0;
            if (iM9242getXimpl != 0 || iM9243getYimpl != 0 || iM9242getXimpl2 != 0 || i3 != 0) {
                return block.invoke(Integer.valueOf(iM9242getXimpl), Integer.valueOf(iM9243getYimpl), Integer.valueOf(iM9242getXimpl2), Integer.valueOf(i3));
            }
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int min, int max, int preferred) {
        return (preferred >= 0 || min == max) ? View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(preferred, min, max), 1073741824) : (preferred != -2 || max == Integer.MAX_VALUE) ? (preferred != -1 || max == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(max, 1073741824) : View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i = iArr[0];
        region.op(i, iArr[1], i + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: getInteropView, reason: from getter */
    public final View getView() {
        return this.view;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui() {
        return this.onDensityChanged;
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui() {
        return this.onModifierChanged;
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final Function0<Unit> getRelease() {
        return this.release;
    }

    public final Function0<Unit> getReset() {
        return this.reset;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] location, android.graphics.Rect dirty) {
        super.invalidateChildInParent(location, dirty);
        invalidateOrDefer();
        return null;
    }

    public final void invalidateOrDefer() {
        if (!this.isDrawing) {
            this.layoutNode.invalidateLayer$ui();
            return;
        }
        View view = this.view;
        final Function0<Unit> function0 = this.runInvalidate;
        view.postOnAnimation(new Runnable() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        this.insets = new WindowInsetsCompat(insets);
        return insetToLayoutPosition(insets);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View child, View target) {
        super.onDescendantInvalidated(child, target);
        invalidateOrDefer();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().clear$ui(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.view.layout(0, 0, r - l, b - t);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            return;
        }
        if (this.view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        this.view.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = widthMeasureSpec;
        this.lastHeightMeasureSpec = heightMeasureSpec;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AnonymousClass1(consumed, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(velocityX), AndroidViewHolder_androidKt.toComposeVelocity(velocityY)), null), 3, null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new C05051(VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(velocityX), AndroidViewHolder_androidKt.toComposeVelocity(velocityY)), null), 3, null);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            float composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dx);
            long jM7502dispatchPreScrollOzD1aCk = nestedScrollDispatcher.m7502dispatchPreScrollOzD1aCk(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.toComposeOffset(dy))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(composeOffset) << 32)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM7502dispatchPreScrollOzD1aCk >> 32)));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM7502dispatchPreScrollOzD1aCk & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            float composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dxConsumed);
            long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.toComposeOffset(dyConsumed))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(composeOffset) << 32));
            float composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed);
            nestedScrollDispatcher.m7500dispatchPostScrollDzOQY0M(jM6072constructorimpl, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(composeOffset2) << 32)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            float composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dxConsumed);
            long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.toComposeOffset(dyConsumed))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(composeOffset) << 32));
            float composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed);
            long jM7500dispatchPostScrollDzOQY0M = nestedScrollDispatcher.m7500dispatchPostScrollDzOQY0M(jM6072constructorimpl, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(composeOffset2) << 32)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM7500dispatchPostScrollDzOQY0M >> 32)));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM7500dispatchPostScrollDzOQY0M & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        this.release.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        return ((axes & 2) == 0 && (axes & 1) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int type) {
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 == Integer.MIN_VALUE || (i = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, android.graphics.Rect rectangle, boolean immediate) {
        Function1<? super Rect, Unit> function1 = this.bringIntoViewRequester;
        if (function1 == null) {
            return true;
        }
        function1.invoke(rectangle != null ? RectHelper_androidKt.toComposeRect(rectangle) : null);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(disallowIntercept));
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public final void setDensity(Density density) {
        if (density != this.density) {
            this.density = density;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density);
            }
        }
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final void setModifier(Modifier modifier) {
        if (modifier != this.modifier) {
            this.modifier = modifier;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier);
            }
        }
    }

    public final void setOnDensityChanged$ui(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final void setOnModifierChanged$ui(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    protected final void setRelease(Function0<Unit> function0) {
        this.release = function0;
    }

    protected final void setReset(Function0<Unit> function0) {
        this.reset = function0;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    protected final void setUpdate(Function0<Unit> function0) {
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }
}
