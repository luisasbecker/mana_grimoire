package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.compose.runtime.tooling.ComposeStackTraceMode;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.CompositionObserverKt;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 í\u00012\u00020\u0001:\né\u0001ê\u0001ë\u0001ì\u0001í\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010R\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002J\b\u0010S\u001a\u000202H\u0002J\u0006\u0010a\u001a\u00020bJ\b\u0010c\u001a\u000206H\u0002J\u001d\u0010c\u001a\u0002022\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002020eH\u0082\bJ\u0010\u0010f\u001a\u0002022\u0006\u0010g\u001a\u00020\u0014H\u0002J\u000e\u0010h\u001a\u000202H\u0086@¢\u0006\u0002\u0010iJ&\u0010j\u001a\u0002022\u0006\u0010k\u001a\u00020\u00162\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010m\u001a\u000206H\u0002J\u0017\u0010n\u001a\u0002022\f\u0010o\u001a\b\u0012\u0004\u0012\u0002020pH\u0082\bJ\u000e\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\u000e\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\b\u0010s\u001a\u000202H\u0002J\u0010\u0010t\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0010\u0010v\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0010\u0010w\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0010\u0010x\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0015\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020OH\u0000¢\u0006\u0002\b|J\n\u0010}\u001a\u0004\u0018\u000108H\u0002J\b\u0010~\u001a\u000202H\u0002J\u0010\u0010\u007f\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0018\u0010\u0080\u0001\u001a\u0002022\u0006\u0010D\u001a\u00020\u0003H\u0087@¢\u0006\u0003\u0010\u0081\u0001J$\u0010\u0082\u0001\u001a\u0002022\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0082@¢\u0006\u0003\u0010\u0087\u0001J\u000f\u0010\u008a\u0001\u001a\u000202H\u0082@¢\u0006\u0002\u0010iJV\u0010\u008b\u0001\u001a\u0002022D\u0010o\u001a@\b\u0001\u0012\u0005\u0012\u00030\u008d\u0001\u0012\u0017\u0012\u00150\u0084\u0001¢\u0006\u000f\b\u008e\u0001\u0012\n\b\u008f\u0001\u0012\u0005\b\b(\u0083\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002020\u0090\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u008c\u0001¢\u0006\u0003\b\u0091\u0001H\u0082@¢\u0006\u0003\u0010\u0092\u0001J\u0007\u0010\u0093\u0001\u001a\u000202J\u0007\u0010\u0094\u0001\u001a\u000202J\u000f\u0010\u0095\u0001\u001a\u000202H\u0086@¢\u0006\u0002\u0010iJ\u0019\u0010\u0096\u0001\u001a\u00030\u0097\u00012\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u0002020pH\u0016J/\u0010\u0099\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\u00192\u0013\u0010\u009a\u0001\u001a\u000e\u0012\u0004\u0012\u0002020p¢\u0006\u0003\b\u009b\u0001H\u0010¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J@\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020?0\u009f\u00012\u0006\u0010u\u001a\u00020\u00192\b\u0010 \u0001\u001a\u00030¡\u00012\u0013\u0010\u009a\u0001\u001a\u000e\u0012\u0004\u0012\u0002020p¢\u0006\u0003\b\u009b\u0001H\u0010¢\u0006\u0006\b¢\u0001\u0010£\u0001J8\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020?0\u009f\u00012\u0006\u0010u\u001a\u00020\u00192\b\u0010 \u0001\u001a\u00030¡\u00012\u000e\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020?0\u009f\u0001H\u0010¢\u0006\u0003\b¦\u0001J\u0018\u0010§\u0001\u001a\u0002022\u0007\u0010¨\u0001\u001a\u00020?H\u0010¢\u0006\u0003\b©\u0001J\u0011\u0010ª\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0002J$\u0010«\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010u\u001a\u00020\u00192\u000f\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0002J/\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\r\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\u000f\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0002J\t\u0010¯\u0001\u001a\u000202H\u0002J\u001d\u0010°\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002020e2\u0006\u0010u\u001a\u00020\u0019H\u0002J.\u0010±\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002020e2\u0006\u0010u\u001a\u00020\u00192\u000f\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0002J@\u0010²\u0001\u001a\u0003H³\u0001\"\u0005\b\u0000\u0010³\u00012\u0006\u0010u\u001a\u00020\u00192\u000f\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\r\u0010o\u001a\t\u0012\u0005\u0012\u0003H³\u00010pH\u0082\b¢\u0006\u0003\u0010´\u0001J\u0013\u0010µ\u0001\u001a\u0002022\b\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\u000f\u0010¾\u0001\u001a\u000202H\u0086@¢\u0006\u0002\u0010iJ\u0007\u0010¿\u0001\u001a\u000202J\u0007\u0010À\u0001\u001a\u000202J\u001f\u0010Ì\u0001\u001a\u0002022\u000e\u0010Í\u0001\u001a\t\u0012\u0005\u0012\u00030Î\u00010/H\u0010¢\u0006\u0003\bÏ\u0001J\u0017\u0010Ð\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0010¢\u0006\u0003\bÑ\u0001J\u0017\u0010Ò\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0010¢\u0006\u0003\bÓ\u0001J\u0017\u0010Ô\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0010¢\u0006\u0003\bÕ\u0001J\u0018\u0010Ö\u0001\u001a\u0002022\u0007\u0010¨\u0001\u001a\u00020?H\u0010¢\u0006\u0003\b×\u0001J\u0018\u0010Ø\u0001\u001a\u0002022\u0007\u0010Ù\u0001\u001a\u00020\"H\u0010¢\u0006\u0003\bÚ\u0001J\u0018\u0010Û\u0001\u001a\u0002022\u0007\u0010Ù\u0001\u001a\u00020\"H\u0010¢\u0006\u0003\bÜ\u0001J/\u0010Ý\u0001\u001a\u0002022\u0007\u0010Ù\u0001\u001a\u00020\"2\u0007\u0010Þ\u0001\u001a\u00020+2\f\u0010ß\u0001\u001a\u0007\u0012\u0002\b\u00030à\u0001H\u0010¢\u0006\u0003\bá\u0001J\u0017\u0010â\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\u0019H\u0010¢\u0006\u0003\bã\u0001J\u001a\u0010ä\u0001\u001a\u0004\u0018\u00010+2\u0007\u0010Ù\u0001\u001a\u00020\"H\u0010¢\u0006\u0003\bå\u0001R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100%\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020?\u0018\u00010\u001d0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0014\u0010F\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010HR\u0014\u0010K\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010HR\u001c\u0010M\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010NX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bP\u0010QR\u0014\u0010T\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010HR \u0010V\u001a\b\u0012\u0004\u0012\u00020<0W8FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010Q\u001a\u0004\bY\u0010ZR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020<0\\8F¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0012\u0010_\u001a\u00060`R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0088\u0001\u001a\u0002068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010HR\u0013\u0010¸\u0001\u001a\u0002068F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010HR\u0016\u0010º\u0001\u001a\u0002068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010HR\u0016\u0010¼\u0001\u001a\u0002068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b½\u0001\u0010HR\u001b\u0010Á\u0001\u001a\u00070\u0007j\u0003`Â\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010\nR\u0016\u0010Ä\u0001\u001a\u0002068PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010HR\u0016\u0010Æ\u0001\u001a\u0002068PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010HR\u0016\u0010È\u0001\u001a\u0002068PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010HR\u0016\u0010Ê\u0001\u001a\u0002068PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u0010HR\u0019\u0010u\u001a\u0005\u0018\u00010æ\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\bç\u0001\u0010è\u0001¨\u0006î\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "value", "", "changeCount", "getChangeCount", "()J", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "nextFrameEndCallbackQueue", "Landroidx/compose/runtime/NextFrameEndCallbackQueue;", "stateLock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", "closeCause", "", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "movableContentAwaitingInsert", "Landroidx/compose/runtime/MovableContentStateReference;", "movableContentRemoved", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/compose/runtime/MovableContent;", "Landroidx/collection/MutableScatterMap;", "movableContentNestedStatesAvailable", "Landroidx/compose/runtime/NestedContentMap;", "movableContentStatesAvailable", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/MovableContentState;", "movableContentNestedExtractionsPending", "failedCompositions", "compositionsRemoved", "", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "concurrentCompositionsOutstanding", "", "isClosed", "", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "pausedScopes", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "()Z", "hasNextFrameEndAwaitersLocked", "getHasNextFrameEndAwaitersLocked", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "registrationObservers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "getRegistrationObservers$annotations", "()V", "deriveStateLocked", "onNewFrameAwaiter", "shouldKeepRecomposing", "getShouldKeepRecomposing", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "recordComposerModifications", "onEachInvalidComposition", "Lkotlin/Function1;", "registerRunnerJob", "callingJob", "runRecomposeAndApplyChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCompositionError", "e", "failedInitialComposition", "recoverable", "withTransparentSnapshot", "block", "Lkotlin/Function0;", "knownCompositions", "knownCompositionsLocked", "clearKnownCompositionsLocked", "removeKnownCompositionLocked", "composition", "addKnownCompositionLocked", "registerCompositionLocked", "unregisterCompositionLocked", "addCompositionRegistrationObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "addCompositionRegistrationObserver$runtime", "resetErrorState", "retryFailedCompositions", "recordFailedCompositionLocked", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runFrameLoop", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasSchedulingWork", "getHasSchedulingWork", "awaitWorkAvailable", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "close", "join", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", NativeProtocol.WEB_DIALOG_ACTION, "composeInitial", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "reportPausedScope", "scope", "reportPausedScope$runtime", "performInitialMovableContentInserts", "performRecompose", "modifiedValues", "performInsertValues", "references", "discardUnusedMovableContentState", "readObserverOf", "writeObserverOf", "composing", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "hasPendingWork", "getHasPendingWork", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "awaitIdle", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "compositeKeyHashCode", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCompositeKeyHashCode$runtime", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "collectingParameterInformation", "getCollectingParameterInformation$runtime", "collectingSourceInformation", "getCollectingSourceInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime", "registerComposition", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "insertMovableContent", TypedValues.Custom.S_REFERENCE, "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateReleased", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "movableContentStateResolve", "movableContentStateResolve$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "State", "RecomposerInfoImpl", "HotReloadable", "RecomposerErrorState", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<MovableContentStateReference> movableContentAwaitingInsert;
    private final MutableScatterMap<Object, Object> movableContentNestedExtractionsPending;
    private final NestedContentMap movableContentNestedStatesAvailable;
    private final MutableScatterMap<Object, Object> movableContentRemoved;
    private final MutableScatterMap<MovableContentStateReference, MovableContentState> movableContentStatesAvailable;
    private final NextFrameEndCallbackQueue nextFrameEndCallbackQueue;
    private final SnapshotThreadLocal<MutableScatterSet<RecomposeScopeImpl>> pausedScopes;
    private final RecomposerInfoImpl recomposerInfo;
    private MutableObjectList<CompositionRegistrationObserver> registrationObservers;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0019J\u0014\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0007R\u00020\bH\u0002J\u0014\u0010\u001c\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0007R\u00020\bH\u0002J\r\u0010\u001d\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0001H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\u0017H\u0000¢\u0006\u0002\b+R\u001e\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007R\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006,"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "<init>", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "currentRunningRecomposers", "currentRunningRecomposers$runtime", "setHotReloadEnabled", "", "value", "setHotReloadEnabled$runtime", "addRunning", "info", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime", "invalidateGroupsWithKey", SubscriberAttributeKt.JSON_NAME_KEY, "", "invalidateGroupsWithKey$runtime", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime", "clearErrors", "clearErrors$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add(info);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove(info);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetRemove));
        }

        public final void clearErrors$runtime() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorState recomposerErrorStateResetErrorState = ((RecomposerInfoImpl) it.next()).resetErrorState();
                if (recomposerErrorStateResetErrorState != null) {
                    arrayList.add(recomposerErrorStateResetErrorState);
                }
            }
        }

        public final Set<RecomposerInfo> currentRunningRecomposers$runtime() {
            return (Set) Recomposer._runningRecomposers.getValue();
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorInfo currentError = ((RecomposerInfoImpl) it.next()).getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime(int key) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(key);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final void loadStateAndComposeForHotReload$runtime(Object token) {
            Recomposer._hotReloadEnabled.set(true);
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).resetErrorState();
            }
            Intrinsics.checkNotNull(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) token;
            List list2 = list;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            Iterator it2 = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it2.hasNext()) {
                ((RecomposerInfoImpl) it2.next()).retryFailedCompositions();
            }
        }

        public final Object saveStateAndDisposeForHotReload$runtime() {
            Recomposer._hotReloadEnabled.set(true);
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void setHotReloadEnabled$runtime(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "resetContent", "recompose", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m5529getLambda$1091980426$runtime());
            }
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "", "<init>", "(ZLjava/lang/Throwable;)V", "getRecoverable", "()Z", "getCause", "()Ljava/lang/Throwable;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Throwable cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Throwable th) {
            this.recoverable = z;
            this.cause = th;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Throwable getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "<init>", "(Landroidx/compose/runtime/Recomposer;)V", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "hasPendingWork", "", "getHasPendingWork", "()Z", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "invalidateGroupsWithKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int key) {
            List listKnownCompositions = Recomposer.this.knownCompositions();
            ArrayList arrayList = new ArrayList(listKnownCompositions.size());
            int size = listKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) listKnownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((CompositionImpl) arrayList2.get(i2)).invalidateGroupsWithKey(key);
            }
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public CompositionObserverHandle observe(CompositionRegistrationObserver observer) {
            return CompositionObserverKt.observe(Recomposer.this, observer);
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List listKnownCompositions = Recomposer.this.knownCompositions();
            ArrayList arrayList = new ArrayList(listKnownCompositions.size());
            int size = listKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) listKnownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList2.get(i2));
                hotReloadable.clearContent();
                arrayList3.add(hotReloadable);
            }
            return arrayList3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "<init>", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ShutDown = new State("ShutDown", 0);
        public static final State ShuttingDown = new State("ShuttingDown", 1);
        public static final State Inactive = new State("Inactive", 2);
        public static final State InactivePendingWork = new State("InactivePendingWork", 3);
        public static final State Idle = new State("Idle", 4);
        public static final State PendingWork = new State("PendingWork", 5);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ShutDown, ShuttingDown, Inactive, InactivePendingWork, Idle, PendingWork};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
        }

        private State(String str, int i) {
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2, reason: invalid class name */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$awaitIdle$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0).compareTo(State.Idle) > 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C04662 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C04662(Continuation<? super C04662> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04662 c04662 = new C04662(continuation);
            c04662.L$0 = obj;
            return c04662;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((C04662) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0) == State.ShutDown);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {1173}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"}, v = 1)
    static final class C04672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Recomposer.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$2", f = "Recomposer.kt", i = {}, l = {1173}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00872 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00872(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C00872> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00872 c00872 = new C00872(this.$block, this.$parentFrameClock, continuation);
                c00872.L$0 = obj;
                return c00872;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00872) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
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
        C04672(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C04672> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[Catch: all -> 0x00c2, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x001b, B:8:0x0024, B:11:0x0035, B:13:0x0045, B:15:0x0051, B:17:0x005a, B:19:0x0063, B:22:0x0073, B:23:0x0076, B:26:0x007e, B:36:0x00a9, B:27:0x0081, B:28:0x0087, B:30:0x008d, B:32:0x0095, B:35:0x00a5), top: B:47:0x0007 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static final Unit invokeSuspend$lambda$0(Recomposer recomposer, Set set, Snapshot snapshot) {
            CancellableContinuation cancellableContinuationDeriveStateLocked;
            synchronized (recomposer.stateLock) {
                if (((State) recomposer._state.getValue()).compareTo(State.Idle) >= 0) {
                    MutableScatterSet mutableScatterSet = recomposer.snapshotInvalidations;
                    if (set instanceof ScatterSetWrapper) {
                        ScatterSet set$runtime = ((ScatterSetWrapper) set).getSet$runtime();
                        Object[] objArr = set$runtime.elements;
                        long[] jArr = set$runtime.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i2 = 8 - ((~(i - length)) >>> 31);
                                    for (int i3 = 0; i3 < i2; i3++) {
                                        if ((255 & j) < 128) {
                                            Object obj = objArr[(i << 3) + i3];
                                            if (obj instanceof StateObjectImpl) {
                                                ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                                if (((StateObjectImpl) obj).m5786isReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(1))) {
                                                    mutableScatterSet.add(obj);
                                                }
                                            }
                                        }
                                        j >>= 8;
                                    }
                                    if (i2 != 8) {
                                        break;
                                    }
                                }
                                if (i == length) {
                                    break;
                                }
                                i++;
                            }
                        }
                    } else {
                        for (Object obj2 : set) {
                            if (obj2 instanceof StateObjectImpl) {
                                ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                if (!((StateObjectImpl) obj2).m5786isReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(1))) {
                                }
                            }
                            mutableScatterSet.add(obj2);
                        }
                    }
                    cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                } else {
                    cancellableContinuationDeriveStateLocked = null;
                }
            }
            if (cancellableContinuationDeriveStateLocked != null) {
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04672 c04672 = Recomposer.this.new C04672(this.$block, this.$parentFrameClock, continuation);
            c04672.L$0 = obj;
            return c04672;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Job job;
            ObserverHandle observerHandle;
            Throwable th;
            Object obj2;
            Object obj3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                Recomposer.this.registerRunnerJob(job);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                final Recomposer recomposer = Recomposer.this;
                ObserverHandle observerHandleRegisterApplyObserver = companion.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return Recomposer.C04672.invokeSuspend$lambda$0(recomposer, (Set) obj4, (Snapshot) obj5);
                    }
                });
                Recomposer.INSTANCE.addRunning(Recomposer.this.recomposerInfo);
                try {
                    List listKnownCompositions = Recomposer.this.knownCompositions();
                    int size = listKnownCompositions.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((ControlledComposition) listKnownCompositions.get(i2)).invalidateAll();
                    }
                    this.L$0 = job;
                    this.L$1 = observerHandleRegisterApplyObserver;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new C00872(this.$block, this.$parentFrameClock, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    observerHandle = observerHandleRegisterApplyObserver;
                    observerHandle.dispose();
                    obj3 = Recomposer.this.stateLock;
                    Recomposer recomposer2 = Recomposer.this;
                    synchronized (obj3) {
                    }
                } catch (Throwable th2) {
                    observerHandle = observerHandleRegisterApplyObserver;
                    th = th2;
                    observerHandle.dispose();
                    obj2 = Recomposer.this.stateLock;
                    Recomposer recomposer3 = Recomposer.this;
                    synchronized (obj2) {
                        if (recomposer3.runnerJob == job) {
                            recomposer3.runnerJob = null;
                        }
                        recomposer3.deriveStateLocked();
                    }
                    Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                observerHandle = (ObserverHandle) this.L$1;
                job = (Job) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    observerHandle.dispose();
                    obj3 = Recomposer.this.stateLock;
                    Recomposer recomposer22 = Recomposer.this;
                    synchronized (obj3) {
                        if (recomposer22.runnerJob == job) {
                            recomposer22.runnerJob = null;
                        }
                        recomposer22.deriveStateLocked();
                    }
                    Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    observerHandle.dispose();
                    obj2 = Recomposer.this.stateLock;
                    Recomposer recomposer32 = Recomposer.this;
                    synchronized (obj2) {
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1, reason: invalid class name */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {1042, 1049}, m = "runFrameLoop", n = {"parentFrameClock", "frameSignal", "toRecompose", "toApply", "parentFrameClock", "frameSignal", "toRecompose", "toApply"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {598, TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 1)
    static final class C04682 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        C04682(Continuation<? super C04682> continuation) {
            super(3, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00fd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
            long j;
            synchronized (recomposer.stateLock) {
                list.clear();
                list2.clear();
                int size = list3.size();
                for (int i = 0; i < size; i++) {
                    ControlledComposition controlledComposition = list3.get(i);
                    controlledComposition.abandonChanges();
                    recomposer.recordFailedCompositionLocked(controlledComposition);
                }
                list3.clear();
                MutableScatterSet<ControlledComposition> mutableScatterSet5 = mutableScatterSet;
                Object[] objArr = mutableScatterSet5.elements;
                long[] jArr = mutableScatterSet5.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j2 = jArr[i2];
                        j = 255;
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i3 = 8 - ((~(i2 - length)) >>> 31);
                            for (int i4 = 0; i4 < i3; i4++) {
                                if ((j2 & 255) < 128) {
                                    ControlledComposition controlledComposition2 = (ControlledComposition) objArr[(i2 << 3) + i4];
                                    controlledComposition2.abandonChanges();
                                    recomposer.recordFailedCompositionLocked(controlledComposition2);
                                }
                                j2 >>= 8;
                            }
                            if (i3 != 8) {
                                break;
                            } else if (i2 == length) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                j = 255;
                mutableScatterSet.clear();
                MutableScatterSet<ControlledComposition> mutableScatterSet6 = mutableScatterSet2;
                Object[] objArr2 = mutableScatterSet6.elements;
                long[] jArr2 = mutableScatterSet6.metadata;
                int length2 = jArr2.length - 2;
                if (length2 >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j3 = jArr2[i5];
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8 - ((~(i5 - length2)) >>> 31);
                            for (int i7 = 0; i7 < i6; i7++) {
                                if ((j3 & j) < 128) {
                                    ((ControlledComposition) objArr2[(i5 << 3) + i7]).changesApplied();
                                }
                                j3 >>= 8;
                            }
                            if (i6 != 8) {
                                break;
                            } else if (i5 == length2) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                }
                mutableScatterSet2.clear();
                mutableScatterSet3.clear();
                MutableScatterSet<ControlledComposition> mutableScatterSet7 = mutableScatterSet4;
                Object[] objArr3 = mutableScatterSet7.elements;
                long[] jArr3 = mutableScatterSet7.metadata;
                int length3 = jArr3.length - 2;
                if (length3 >= 0) {
                    int i8 = 0;
                    while (true) {
                        long j4 = jArr3[i8];
                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i9 = 8 - ((~(i8 - length3)) >>> 31);
                            for (int i10 = 0; i10 < i9; i10++) {
                                if ((j4 & j) < 128) {
                                    ControlledComposition controlledComposition3 = (ControlledComposition) objArr3[(i8 << 3) + i10];
                                    controlledComposition3.abandonChanges();
                                    recomposer.recordFailedCompositionLocked(controlledComposition3);
                                }
                                j4 >>= 8;
                            }
                            if (i9 != 8) {
                                break;
                            } else if (i8 == length3) {
                                break;
                            } else {
                                i8++;
                            }
                        }
                    }
                }
                mutableScatterSet4.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        private static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                List list2 = recomposer.movableContentAwaitingInsert;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    list.add((MovableContentStateReference) list2.get(i));
                }
                recomposer.movableContentAwaitingInsert.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01f1  */
        /* JADX WARN: Type inference failed for: r0v39 */
        /* JADX WARN: Type inference failed for: r0v67 */
        /* JADX WARN: Type inference failed for: r0v70 */
        /* JADX WARN: Type inference failed for: r14v3, types: [T[]] */
        /* JADX WARN: Type inference failed for: r2v5, types: [T[], java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v20, types: [int] */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v22, types: [int] */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v26 */
        /* JADX WARN: Type inference failed for: r4v15, types: [int] */
        /* JADX WARN: Type inference failed for: r4v22, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v23 */
        /* JADX WARN: Type inference failed for: r4v24 */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static final Unit invokeSuspend$lambda$2(Recomposer recomposer, MutableScatterSet mutableScatterSet, MutableScatterSet mutableScatterSet2, List list, List list2, MutableScatterSet mutableScatterSet3, List list3, MutableScatterSet mutableScatterSet4, Set set, long j) {
            boolean z;
            char c;
            long j2;
            long j3;
            Recomposer recomposer2 = recomposer;
            ?? r7 = list3;
            MutableScatterSet mutableScatterSet5 = mutableScatterSet4;
            if (recomposer2.getHasBroadcastFrameClockAwaiters()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
                try {
                    recomposer2.broadcastFrameClock.sendFrame(j);
                    Snapshot.INSTANCE.sendApplyNotifications();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(objBeginSection);
                }
            }
            Object objBeginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
            try {
                recomposer2.recordComposerModifications();
                synchronized (recomposer2.stateLock) {
                    MutableVector mutableVector = recomposer2.compositionInvalidations;
                    Object[] objArr = mutableVector.content;
                    int size = mutableVector.getSize();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        list.add((ControlledComposition) objArr[i]);
                    }
                    recomposer2.compositionInvalidations.clear();
                    Unit unit2 = Unit.INSTANCE;
                }
                mutableScatterSet.clear();
                mutableScatterSet2.clear();
            } catch (Throwable th) {
                throw th;
            }
            while (true) {
                if (list.isEmpty() && list2.isEmpty()) {
                    break;
                }
                try {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ControlledComposition controlledComposition = (ControlledComposition) list.get(i2);
                        ControlledComposition controlledCompositionPerformRecompose = recomposer2.performRecompose(controlledComposition, mutableScatterSet);
                        if (controlledCompositionPerformRecompose != null) {
                            list3.add(controlledCompositionPerformRecompose);
                            Unit unit3 = Unit.INSTANCE;
                            Unit unit4 = Unit.INSTANCE;
                        }
                        mutableScatterSet2.add(controlledComposition);
                    }
                    list.clear();
                    if (mutableScatterSet.isNotEmpty() || recomposer2.compositionInvalidations.getSize() != 0) {
                        synchronized (recomposer2.stateLock) {
                            List listKnownCompositionsLocked = recomposer2.knownCompositionsLocked();
                            int size3 = listKnownCompositionsLocked.size();
                            for (int i3 = 0; i3 < size3; i3++) {
                                ControlledComposition controlledComposition2 = (ControlledComposition) listKnownCompositionsLocked.get(i3);
                                if (!mutableScatterSet2.contains(controlledComposition2) && controlledComposition2.observesAnyOf(set)) {
                                    list.add(controlledComposition2);
                                }
                            }
                            MutableVector mutableVector2 = recomposer2.compositionInvalidations;
                            int size4 = mutableVector2.getSize();
                            int i4 = 0;
                            for (int i5 = 0; i5 < size4; i5++) {
                                ControlledComposition controlledComposition3 = (ControlledComposition) mutableVector2.content[i5];
                                if (!mutableScatterSet2.contains(controlledComposition3) && !list.contains(controlledComposition3)) {
                                    list.add(controlledComposition3);
                                    i4++;
                                } else if (i4 > 0) {
                                    mutableVector2.content[i5 - i4] = mutableVector2.content[i5];
                                }
                            }
                            int i6 = size4 - i4;
                            ArraysKt.fill((Object[]) mutableVector2.content, (Object) null, i6, size4);
                            mutableVector2.setSize(i6);
                            Unit unit5 = Unit.INSTANCE;
                        }
                    }
                    if (list.isEmpty()) {
                        try {
                            invokeSuspend$fillToInsert(list2, recomposer2);
                            while (!list2.isEmpty()) {
                                mutableScatterSet3.plusAssign((Iterable) recomposer2.performInsertValues(list2, mutableScatterSet));
                                invokeSuspend$fillToInsert(list2, recomposer2);
                            }
                        } catch (Throwable th2) {
                            Recomposer.processCompositionError$default(recomposer2, th2, null, true, 2, null);
                            invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                            return Unit.INSTANCE;
                        }
                    } else {
                        recomposer2 = recomposer;
                    }
                    r7 = list3;
                    mutableScatterSet5 = mutableScatterSet4;
                    z = false;
                } catch (Throwable th3) {
                    try {
                        Recomposer.processCompositionError$default(recomposer, th3, null, true, 2, null);
                        invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                        return Unit.INSTANCE;
                    } finally {
                        list.clear();
                    }
                }
                throw th;
            }
            Snapshot current = Snapshot.INSTANCE.getCurrent();
            TransparentObserverSnapshot transparentObserverMutableSnapshot = current instanceof MutableSnapshot ? new TransparentObserverMutableSnapshot((MutableSnapshot) current, null, null, true, false) : new TransparentObserverSnapshot(current, null, true, z);
            try {
                Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    if (!((Collection) r7).isEmpty()) {
                        recomposer2.changeCount = recomposer2.getChangeCount() + 1;
                        try {
                            int size5 = ((Collection) r7).size();
                            for (?? r3 = z; r3 < size5; r3++) {
                                mutableScatterSet5.add((ControlledComposition) r7.get(r3));
                            }
                            int size6 = ((Collection) r7).size();
                            for (?? r32 = z; r32 < size6; r32++) {
                                ((ControlledComposition) r7.get(r32)).applyChanges();
                            }
                            r7.clear();
                        } catch (Throwable th4) {
                            try {
                                Recomposer.processCompositionError$default(recomposer2, th4, null, false, 6, null);
                                invokeSuspend$clearRecompositionState(recomposer, list, list2, r7, mutableScatterSet3, mutableScatterSet5, mutableScatterSet, mutableScatterSet2);
                                return Unit.INSTANCE;
                            } finally {
                                list3.clear();
                            }
                        }
                    }
                    if (mutableScatterSet3.isNotEmpty()) {
                        try {
                            mutableScatterSet5.plusAssign((ScatterSet) mutableScatterSet3);
                            MutableScatterSet mutableScatterSet6 = mutableScatterSet3;
                            Object[] objArr2 = mutableScatterSet6.elements;
                            long[] jArr = mutableScatterSet6.metadata;
                            c = 7;
                            int length = jArr.length - 2;
                            j2 = 128;
                            ?? r4 = z;
                            if (length >= 0) {
                                while (true) {
                                    long j4 = jArr[r4];
                                    j3 = 255;
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i7 = 8 - ((~(r4 - length)) >>> 31);
                                        for (int i8 = 0; i8 < i7; i8++) {
                                            if ((j4 & 255) < 128) {
                                                ((ControlledComposition) objArr2[(r4 << 3) + i8]).applyLateChanges();
                                            }
                                            j4 >>= 8;
                                        }
                                        if (i7 != 8) {
                                            break;
                                        }
                                        if (r4 == length) {
                                            break;
                                        }
                                        r4++;
                                    }
                                }
                            } else {
                                j3 = 255;
                            }
                        } catch (Throwable th5) {
                            try {
                                Recomposer.processCompositionError$default(recomposer, th5, null, false, 6, null);
                                invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet5, mutableScatterSet, mutableScatterSet2);
                                return Unit.INSTANCE;
                            } finally {
                                mutableScatterSet3.clear();
                            }
                        }
                    } else {
                        c = 7;
                        j2 = 128;
                        j3 = 255;
                    }
                    if (mutableScatterSet4.isNotEmpty()) {
                        try {
                            MutableScatterSet mutableScatterSet7 = mutableScatterSet4;
                            Object[] objArr3 = mutableScatterSet7.elements;
                            long[] jArr2 = mutableScatterSet7.metadata;
                            int length2 = jArr2.length - 2;
                            if (length2 >= 0) {
                                int i9 = 0;
                                while (true) {
                                    long j5 = jArr2[i9];
                                    if ((((~j5) << c) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                        for (int i11 = 0; i11 < i10; i11++) {
                                            if ((j5 & j3) < j2) {
                                                ((ControlledComposition) objArr3[(i9 << 3) + i11]).changesApplied();
                                            }
                                            j5 >>= 8;
                                        }
                                        if (i10 != 8) {
                                            break;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                    }
                                }
                            }
                        } catch (Throwable th6) {
                            try {
                                Recomposer.processCompositionError$default(recomposer, th6, null, false, 6, null);
                                invokeSuspend$clearRecompositionState(recomposer, list, list2, list3, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                return Unit.INSTANCE;
                            } finally {
                                mutableScatterSet4.clear();
                            }
                        }
                    }
                    Unit unit6 = Unit.INSTANCE;
                    transparentObserverMutableSnapshot.dispose();
                    synchronized (recomposer.stateLock) {
                        recomposer.deriveStateLocked();
                    }
                    Snapshot.INSTANCE.notifyObjectsInitialized();
                    mutableScatterSet2.clear();
                    mutableScatterSet.clear();
                    recomposer.compositionsRemoved = null;
                    Unit unit7 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection2);
                    return Unit.INSTANCE;
                } finally {
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                transparentObserverMutableSnapshot.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C04682 c04682 = Recomposer.this.new C04682(continuation);
            c04682.L$0 = monotonicFrameClock;
            return c04682.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0130  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0110 -> B:24:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0127 -> B:12:0x00b5). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MonotonicFrameClock monotonicFrameClock;
            MutableScatterSet mutableScatterSetMutableScatterSetOf;
            MutableScatterSet mutableScatterSetMutableScatterSetOf2;
            List list;
            Set set;
            final List list2;
            MutableScatterSet mutableScatterSet;
            List list3;
            MutableScatterSet mutableScatterSet2;
            final List list4;
            final MutableScatterSet mutableScatterSet3;
            final List list5;
            final MutableScatterSet mutableScatterSet4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                monotonicFrameClock = (MonotonicFrameClock) this.L$0;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                MutableScatterSet mutableScatterSetMutableScatterSetOf3 = ScatterSetKt.mutableScatterSetOf();
                MutableScatterSet mutableScatterSet5 = new MutableScatterSet(0, i2, null);
                Set setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet5);
                mutableScatterSetMutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
                list = arrayList;
                set = setWrapIntoSet;
                list2 = arrayList2;
                mutableScatterSet = mutableScatterSet5;
                list3 = arrayList3;
                mutableScatterSet2 = mutableScatterSetMutableScatterSetOf3;
                if (!Recomposer.this.getShouldKeepRecomposing()) {
                }
            } else if (i == 1) {
                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) this.L$8;
                set = (Set) this.L$7;
                mutableScatterSet = (MutableScatterSet) this.L$6;
                mutableScatterSet2 = (MutableScatterSet) this.L$5;
                MutableScatterSet mutableScatterSet7 = (MutableScatterSet) this.L$4;
                List list6 = (List) this.L$3;
                list2 = (List) this.L$2;
                List list7 = (List) this.L$1;
                MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableScatterSet4 = mutableScatterSet6;
                monotonicFrameClock = monotonicFrameClock2;
                list4 = list6;
                list5 = list7;
                mutableScatterSet3 = mutableScatterSet7;
                final Set set2 = set;
                final MutableScatterSet mutableScatterSet8 = mutableScatterSet2;
                final MutableScatterSet mutableScatterSet9 = mutableScatterSet;
                if (Recomposer.this.recordComposerModifications()) {
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MutableScatterSet mutableScatterSet10 = (MutableScatterSet) this.L$8;
                set = (Set) this.L$7;
                mutableScatterSet = (MutableScatterSet) this.L$6;
                mutableScatterSet2 = (MutableScatterSet) this.L$5;
                mutableScatterSetMutableScatterSetOf = (MutableScatterSet) this.L$4;
                list3 = (List) this.L$3;
                list2 = (List) this.L$2;
                list = (List) this.L$1;
                MonotonicFrameClock monotonicFrameClock3 = (MonotonicFrameClock) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableScatterSetMutableScatterSetOf2 = mutableScatterSet10;
                monotonicFrameClock = monotonicFrameClock3;
                Recomposer.this.discardUnusedMovableContentState();
                Recomposer.this.nextFrameEndCallbackQueue.markFrameComplete();
                if (!Recomposer.this.getShouldKeepRecomposing()) {
                    this.L$0 = monotonicFrameClock;
                    this.L$1 = list;
                    this.L$2 = list2;
                    this.L$3 = list3;
                    this.L$4 = mutableScatterSetMutableScatterSetOf;
                    this.L$5 = mutableScatterSet2;
                    this.L$6 = mutableScatterSet;
                    this.L$7 = set;
                    this.L$8 = mutableScatterSetMutableScatterSetOf2;
                    this.label = 1;
                    if (Recomposer.this.awaitWorkAvailable(this) != coroutine_suspended) {
                        List list8 = list;
                        mutableScatterSet3 = mutableScatterSetMutableScatterSetOf;
                        mutableScatterSet4 = mutableScatterSetMutableScatterSetOf2;
                        list4 = list3;
                        list5 = list8;
                        final Set set22 = set;
                        final MutableScatterSet mutableScatterSet82 = mutableScatterSet2;
                        final MutableScatterSet mutableScatterSet92 = mutableScatterSet;
                        if (Recomposer.this.recordComposerModifications()) {
                            List list9 = list4;
                            mutableScatterSetMutableScatterSetOf2 = mutableScatterSet4;
                            mutableScatterSetMutableScatterSetOf = mutableScatterSet3;
                            list = list5;
                            list3 = list9;
                            mutableScatterSet = mutableScatterSet92;
                            mutableScatterSet2 = mutableScatterSet82;
                            set = set22;
                            if (!Recomposer.this.getShouldKeepRecomposing()) {
                            }
                        } else {
                            final Recomposer recomposer = Recomposer.this;
                            this.L$0 = monotonicFrameClock;
                            this.L$1 = list5;
                            this.L$2 = list2;
                            this.L$3 = list4;
                            this.L$4 = mutableScatterSet3;
                            this.L$5 = mutableScatterSet82;
                            this.L$6 = mutableScatterSet92;
                            this.L$7 = set22;
                            this.L$8 = mutableScatterSet4;
                            this.label = 2;
                            if (monotonicFrameClock.withFrameNanos(new Function1() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Recomposer.C04682.invokeSuspend$lambda$2(recomposer, mutableScatterSet92, mutableScatterSet4, list5, list2, mutableScatterSet3, list4, mutableScatterSet82, set22, ((Long) obj2).longValue());
                                }
                            }, this) != coroutine_suspended) {
                                List list10 = list4;
                                mutableScatterSetMutableScatterSetOf2 = mutableScatterSet4;
                                mutableScatterSetMutableScatterSetOf = mutableScatterSet3;
                                list = list5;
                                list3 = list10;
                                mutableScatterSet = mutableScatterSet92;
                                mutableScatterSet2 = mutableScatterSet82;
                                set = set22;
                                Recomposer.this.discardUnusedMovableContentState();
                                Recomposer.this.nextFrameEndCallbackQueue.markFrameComplete();
                                if (!Recomposer.this.getShouldKeepRecomposing()) {
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {PointerIconCompat.TYPE_COPY, 1031, 1032}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"}, v = 1)
    static final class C04692 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04692(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super C04692> continuation) {
            super(3, continuation);
            this.$recomposeCoroutineContext = coroutineContext;
            this.this$0 = recomposer;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C04692 c04692 = new C04692(this.$recomposeCoroutineContext, this.this$0, continuation);
            c04692.L$0 = coroutineScope;
            c04692.L$1 = monotonicFrameClock;
            return c04692.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00c8, code lost:
        
            if (r18.this$0.awaitWorkAvailable(r18) == r1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x01c5, code lost:
        
            if (kotlinx.coroutines.JobKt.cancelAndJoin(r2, r18) != r1) goto L80;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01a0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c8 -> B:25:0x00cc). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Job jobLaunch$default;
            CoroutineScope coroutineScope;
            ProduceFrameSignal produceFrameSignal;
            MutableScatterSet mutableScatterSet;
            Continuation<Unit> continuationRequestFrameLocked;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 0;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i3 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) this.L$1;
                boolean z = this.$recomposeCoroutineContext.get(Job.INSTANCE) == null;
                CoroutineContext coroutineContext = this.$recomposeCoroutineContext;
                if (!z) {
                    PreconditionsKt.throwIllegalArgumentException("recomposeCoroutineContext may not contain a Job; found " + coroutineContext.get(Job.INSTANCE));
                }
                CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineScope2.getCoroutineContext().plus(this.$recomposeCoroutineContext).plus(JobKt.Job(JobKt.getJob(coroutineScope2.getCoroutineContext()))));
                ProduceFrameSignal produceFrameSignal2 = new ProduceFrameSignal();
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, monotonicFrameClock, produceFrameSignal2, null), 3, null);
                coroutineScope = CoroutineScope;
                produceFrameSignal = produceFrameSignal2;
                if (this.this$0.getShouldKeepRecomposing()) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                jobLaunch$default = (Job) this.L$2;
                produceFrameSignal = (ProduceFrameSignal) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Recomposer recomposer = this.this$0;
                synchronized (recomposer.stateLock) {
                    mutableScatterSet = recomposer.snapshotInvalidations;
                    if (mutableScatterSet.isNotEmpty()) {
                        recomposer.snapshotInvalidations = new MutableScatterSet(i2, i3, defaultConstructorMarker);
                    }
                }
                Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
                if (!setWrapIntoSet.isEmpty()) {
                    List listKnownCompositionsLocked = recomposer.knownCompositionsLocked();
                    int size = listKnownCompositionsLocked.size();
                    for (int i4 = i2; i4 < size; i4++) {
                        ((ControlledComposition) listKnownCompositionsLocked.get(i4)).recordModificationsOf(setWrapIntoSet);
                    }
                }
                MutableVector mutableVector = recomposer.compositionInvalidations;
                Object[] objArr = mutableVector.content;
                int size2 = mutableVector.getSize();
                int i5 = i2;
                while (i5 < size2) {
                    ControlledComposition controlledComposition = (ControlledComposition) objArr[i5];
                    synchronized (recomposer.stateLock) {
                        recomposer.concurrentCompositionsOutstanding++;
                    }
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, CompositionKt.getRecomposeCoroutineContext(controlledComposition), null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(recomposer, controlledComposition, null), 2, null);
                    i5++;
                    size2 = size2;
                    objArr = objArr;
                }
                recomposer.compositionInvalidations.clear();
                synchronized (recomposer.stateLock) {
                    if (recomposer.deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    Unit unit = Unit.INSTANCE;
                }
                Object obj2 = this.this$0.stateLock;
                Recomposer recomposer2 = this.this$0;
                synchronized (obj2) {
                    continuationRequestFrameLocked = recomposer2.getHasConcurrentFrameWorkLocked() ? produceFrameSignal.requestFrameLocked() : null;
                }
                if (continuationRequestFrameLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    continuationRequestFrameLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
                }
                i2 = 0;
                if (this.this$0.getShouldKeepRecomposing()) {
                    this.L$0 = jobLaunch$default;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    if (JobKt.cancelAndJoin(JobKt.getJob(coroutineScope.getCoroutineContext()), this) != coroutine_suspended) {
                        this.L$0 = null;
                        this.label = 3;
                    }
                } else {
                    this.L$0 = coroutineScope;
                    this.L$1 = produceFrameSignal;
                    this.L$2 = jobLaunch$default;
                    this.label = 1;
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            jobLaunch$default = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 3;
        }
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Recomposer.broadcastFrameClock$lambda$0(this.f$0);
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.nextFrameEndCallbackQueue = new NextFrameEndCallbackQueue(new Function0() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Recomposer.nextFrameEndCallbackQueue$lambda$0(this.f$0);
            }
        });
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = MultiValueMap.m5675constructorimpl$default(null, 1, null);
        this.movableContentNestedStatesAvailable = new NestedContentMap();
        this.movableContentStatesAvailable = ScatterMapKt.mutableScatterMapOf();
        this.movableContentNestedExtractionsPending = MultiValueMap.m5675constructorimpl$default(null, 1, null);
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new SnapshotThreadLocal<>();
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        completableJobJob.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Recomposer.effectJob$lambda$0$0(this.f$0, (Throwable) obj);
            }
        });
        this.effectJob = completableJobJob;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(completableJobJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl2 = null;
            }
        }
        if (cancellableContinuationImpl2 != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    static final Unit broadcastFrameClock$lambda$0(Recomposer recomposer) {
        recomposer.onNewFrameAwaiter();
        return Unit.INSTANCE;
    }

    private final void clearKnownCompositionsLocked() {
        List<ControlledComposition> listKnownCompositionsLocked = knownCompositionsLocked();
        int size = listKnownCompositionsLocked.size();
        for (int i = 0; i < size; i++) {
            unregisterCompositionLocked(listKnownCompositionsLocked.get(i));
        }
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final <T> T composing(ControlledComposition composition, MutableScatterSet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
            Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
            try {
                return block.invoke();
            } finally {
                mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    private static final void deletedMovableContent$lambda$0$recordNestedStatesOf(Recomposer recomposer, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        List<MovableContentStateReference> nestedReferences$runtime = movableContentStateReference2.getNestedReferences$runtime();
        if (nestedReferences$runtime != null) {
            int size = nestedReferences$runtime.size();
            for (int i = 0; i < size; i++) {
                MovableContentStateReference movableContentStateReference3 = nestedReferences$runtime.get(i);
                recomposer.movableContentNestedStatesAvailable.add(movableContentStateReference3.getContent$runtime(), new NestedMovableContent(movableContentStateReference3, movableContentStateReference));
                deletedMovableContent$lambda$0$recordNestedStatesOf(recomposer, movableContentStateReference, movableContentStateReference3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.movableContentAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            state = (getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked()) ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (this.compositionInvalidations.getSize() == 0 && !this.snapshotInvalidations.isNotEmpty() && this.compositionsAwaitingApply.isEmpty() && this.movableContentAwaitingInsert.isEmpty() && this.concurrentCompositionsOutstanding <= 0 && !getHasBroadcastFrameClockAwaitersLocked() && !getHasNextFrameEndAwaitersLocked() && !MultiValueMap.m5684isNotEmptyimpl(this.movableContentRemoved)) ? State.Idle : State.PendingWork;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedMovableContentState() {
        int i;
        MutableObjectList mutableObjectListEmptyObjectList;
        synchronized (this.stateLock) {
            if (MultiValueMap.m5684isNotEmptyimpl(this.movableContentRemoved)) {
                ObjectList objectListM5689valuesimpl = MultiValueMap.m5689valuesimpl(this.movableContentRemoved);
                MultiValueMap.m5673clearimpl(this.movableContentRemoved);
                this.movableContentNestedStatesAvailable.clear();
                MultiValueMap.m5673clearimpl(this.movableContentNestedExtractionsPending);
                MutableObjectList mutableObjectList = new MutableObjectList(objectListM5689valuesimpl.getSize());
                Object[] objArr = objectListM5689valuesimpl.content;
                int i2 = objectListM5689valuesimpl._size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i3];
                    mutableObjectList.add(TuplesKt.to(movableContentStateReference, this.movableContentStatesAvailable.get(movableContentStateReference)));
                }
                mutableObjectListEmptyObjectList = mutableObjectList;
                this.movableContentStatesAvailable.clear();
            } else {
                mutableObjectListEmptyObjectList = ObjectListKt.emptyObjectList();
            }
        }
        Object[] objArr2 = mutableObjectListEmptyObjectList.content;
        int i4 = mutableObjectListEmptyObjectList._size;
        for (i = 0; i < i4; i++) {
            Pair pair = (Pair) objArr2[i];
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effectJob$lambda$0$0(final Recomposer recomposer, final Throwable th) {
        CancellableContinuation<? super Unit> cancellableContinuation;
        CancellableContinuation<? super Unit> cancellableContinuation2;
        CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
        synchronized (recomposer.stateLock) {
            Job job = recomposer.runnerJob;
            cancellableContinuation = null;
            if (job != null) {
                recomposer._state.setValue(State.ShuttingDown);
                if (recomposer.isClosed) {
                    cancellableContinuation2 = recomposer.workContinuation;
                    if (cancellableContinuation2 != null) {
                    }
                    recomposer.workContinuation = null;
                    job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Recomposer.effectJob$lambda$0$0$0$0(this.f$0, th, (Throwable) obj);
                        }
                    });
                    cancellableContinuation = cancellableContinuation2;
                } else {
                    job.cancel(CancellationException);
                }
                cancellableContinuation2 = null;
                recomposer.workContinuation = null;
                job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Recomposer.effectJob$lambda$0$0$0$0(this.f$0, th, (Throwable) obj);
                    }
                });
                cancellableContinuation = cancellableContinuation2;
            } else {
                recomposer.closeCause = CancellationException;
                recomposer._state.setValue(State.ShutDown);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effectJob$lambda$0$0$0$0(Recomposer recomposer, Throwable th, Throwable th2) {
        synchronized (recomposer.stateLock) {
            if (th != null) {
                if (th2 != null) {
                    if (th2 instanceof CancellationException) {
                        th2 = null;
                    }
                    if (th2 != null) {
                        kotlin.ExceptionsKt.addSuppressed(th, th2);
                    }
                }
            }
            th = null;
            recomposer.closeCause = th;
            recomposer._state.setValue(State.ShutDown);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked();
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.getSize() != 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked() || MultiValueMap.m5684isNotEmptyimpl(this.movableContentRemoved);
    }

    private final boolean getHasNextFrameEndAwaitersLocked() {
        return !this.frameClockPaused && this.nextFrameEndCallbackQueue.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.getSize() != 0 || getHasBroadcastFrameClockAwaitersLocked()) {
                z = true;
            } else if (!getHasNextFrameEndAwaitersLocked()) {
                z = false;
            }
        }
        return z;
    }

    private static /* synthetic */ void getRegistrationObservers$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (!z) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().isActive()) {
                return true;
            }
        }
        return false;
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositions() {
        List<ControlledComposition> listKnownCompositionsLocked;
        synchronized (this.stateLock) {
            listKnownCompositionsLocked = knownCompositionsLocked();
        }
        return listKnownCompositionsLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositionsLocked() {
        List list = this._knownCompositionsCache;
        if (list != null) {
            return list;
        }
        List<ControlledComposition> list2 = this._knownCompositions;
        ArrayList arrayListEmptyList = list2.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list2);
        this._knownCompositionsCache = arrayListEmptyList;
        return arrayListEmptyList;
    }

    static final Unit nextFrameEndCallbackQueue$lambda$0(Recomposer recomposer) {
        recomposer.onNewFrameAwaiter();
        return Unit.INSTANCE;
    }

    private final void onNewFrameAwaiter() {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", this.closeCause);
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.movableContentAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(list.get(i).getComposition(), composition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.movableContentAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x016a, code lost:
    
        r0 = r11.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0172, code lost:
    
        if (r2 >= r0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017e, code lost:
    
        if (r11.get(r2).getSecond() == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0180, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0183, code lost:
    
        r0 = new java.util.ArrayList(r11.size());
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0194, code lost:
    
        if (r3 >= r2) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0196, code lost:
    
        r4 = r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a0, code lost:
    
        if (r4.getSecond() != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a2, code lost:
    
        r4 = r4.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a9, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01aa, code lost:
    
        if (r4 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ac, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b2, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b5, code lost:
    
        r0 = r0;
        r2 = r17.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b9, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ba, code lost:
    
        kotlin.collections.CollectionsKt.addAll(r17.movableContentAwaitingInsert, r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01c5, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c6, code lost:
    
        r0 = new java.util.ArrayList(r11.size());
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01d7, code lost:
    
        if (r3 >= r2) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d9, code lost:
    
        r4 = r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01e4, code lost:
    
        if (r4.getSecond() == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01e6, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ec, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ef, code lost:
    
        r11 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> references, MutableScatterSet<Object> modifiedValues) {
        Iterator it;
        HashMap map;
        ArrayList arrayList;
        NestedMovableContent nestedMovableContentRemoveLast;
        HashMap map2;
        HashMap map3 = new HashMap(references.size());
        int size = references.size();
        for (int i = 0; i < size; i++) {
            MovableContentStateReference movableContentStateReference = references.get(i);
            ControlledComposition composition = movableContentStateReference.getComposition();
            HashMap map4 = map3;
            Object arrayList2 = map4.get(composition);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map4.put(composition, arrayList2);
            }
            ((ArrayList) arrayList2).add(movableContentStateReference);
        }
        HashMap map5 = map3;
        Iterator it2 = map5.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list = (List) entry.getValue();
            if (controlledComposition.isComposing()) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, modifiedValues));
            try {
                MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
                Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        ArrayList arrayList3 = new ArrayList(list.size());
                        int size2 = list.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            ArrayList arrayList4 = arrayList3;
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list.get(i2);
                            Iterator it3 = it2;
                            Object objM5686removeLastimpl = MultiValueMap.m5686removeLastimpl(this.movableContentRemoved, movableContentStateReference2.getContent$runtime());
                            MovableContentStateReference movableContentStateReference3 = (MovableContentStateReference) objM5686removeLastimpl;
                            if (movableContentStateReference3 != null) {
                                map2 = map5;
                                this.movableContentNestedStatesAvailable.usedContainer(movableContentStateReference3);
                            } else {
                                map2 = map5;
                            }
                            arrayList4.add(TuplesKt.to(movableContentStateReference2, objM5686removeLastimpl));
                            i2++;
                            it2 = it3;
                            map5 = map2;
                        }
                        it = it2;
                        map = map5;
                        arrayList = arrayList3;
                        if (ComposeRuntimeFlags.isMovingNestedMovableContentEnabled) {
                            int size3 = arrayList.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size3) {
                                    break;
                                }
                                Pair<MovableContentStateReference, MovableContentStateReference> pair = arrayList.get(i3);
                                if (pair.getSecond() == null && this.movableContentNestedStatesAvailable.contains(pair.getFirst().getContent$runtime())) {
                                    ArrayList arrayList5 = new ArrayList(arrayList.size());
                                    int size4 = arrayList.size();
                                    for (int i4 = 0; i4 < size4; i4++) {
                                        ArrayList arrayList6 = arrayList5;
                                        Pair<MovableContentStateReference, MovableContentStateReference> pair2 = arrayList.get(i4);
                                        if (pair2.getSecond() == null && (nestedMovableContentRemoveLast = this.movableContentNestedStatesAvailable.removeLast(pair2.getFirst().getContent$runtime())) != null) {
                                            MovableContentStateReference content = nestedMovableContentRemoveLast.getContent();
                                            MultiValueMap.m5671addimpl(this.movableContentNestedExtractionsPending, nestedMovableContentRemoveLast.getContainer(), content);
                                            pair2 = TuplesKt.to(pair2.getFirst(), content);
                                        }
                                        arrayList6.add(pair2);
                                    }
                                    arrayList = arrayList5;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    int size5 = arrayList.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size5) {
                            break;
                        }
                        if (arrayList.get(i5).getSecond() != null) {
                            break;
                        }
                        i5++;
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    Unit unit = Unit.INSTANCE;
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                    it2 = it;
                    map5 = map;
                } finally {
                    mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } catch (Throwable th) {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                throw th;
            }
        }
        return CollectionsKt.toList(map5.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        Set<ControlledComposition> set;
        if (composition.isComposing() || composition.isDisposed() || ((set = this.compositionsRemoved) != null && set.contains(composition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
            Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new Function0() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Recomposer.performRecompose$lambda$0$0(modifiedValues, composition);
                            }
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = composition.recompose();
            mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            if (zRecompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit performRecompose$lambda$0$0(MutableScatterSet mutableScatterSet, ControlledComposition controlledComposition) {
        MutableScatterSet mutableScatterSet2 = mutableScatterSet;
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            controlledComposition.recordWriteOf(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void processCompositionError(Throwable e, ControlledComposition failedInitialComposition, boolean recoverable) throws Throwable {
        int i = 0;
        if (!_hotReloadEnabled.get().booleanValue() || (e instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                Utils_androidKt.logError("Error was captured in composition.", e);
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.getCause();
                }
                this.errorState = new RecomposerErrorState(false, e);
                Unit unit = Unit.INSTANCE;
            }
            throw e;
        }
        synchronized (this.stateLock) {
            Utils_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
            this.compositionsAwaitingApply.clear();
            this.compositionInvalidations.clear();
            this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
            this.movableContentAwaitingInsert.clear();
            MultiValueMap.m5673clearimpl(this.movableContentRemoved);
            this.movableContentStatesAvailable.clear();
            this.errorState = new RecomposerErrorState(recoverable, e);
            if (failedInitialComposition != null) {
                recordFailedCompositionLocked(failedInitialComposition);
            }
            deriveStateLocked();
        }
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Throwable th, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(th, controlledComposition, z);
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Recomposer.readObserverOf$lambda$0(composition, obj);
            }
        };
    }

    static final Unit readObserverOf$lambda$0(ControlledComposition controlledComposition, Object obj) {
        controlledComposition.recordReadOf(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.broadcastFrameClock, new C04672(function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        MutableScatterSet mutableScatterSet;
        int i;
        synchronized (this.stateLock) {
            mutableScatterSet = this.snapshotInvalidations;
            i = 0;
            if (mutableScatterSet.isNotEmpty()) {
                this.snapshotInvalidations = new MutableScatterSet(i, 1, null);
            }
        }
        Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
        if (!setWrapIntoSet.isEmpty()) {
            List listKnownCompositionsLocked = knownCompositionsLocked();
            int size = listKnownCompositionsLocked.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ControlledComposition) listKnownCompositionsLocked.get(i2)).recordModificationsOf(setWrapIntoSet);
            }
        }
        MutableVector mutableVector = this.compositionInvalidations;
        T[] tArr = mutableVector.content;
        int size2 = mutableVector.getSize();
        while (i < size2) {
            onEachInvalidComposition.invoke(tArr[i]);
            i++;
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        boolean hasFrameWorkLocked;
        CollectionsKt.emptyList();
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            List<ControlledComposition> listKnownCompositionsLocked = knownCompositionsLocked();
            Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            int i = 0;
            this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
            try {
                Recomposer recomposer = this;
                int size = listKnownCompositionsLocked.size();
                while (i < size) {
                    listKnownCompositionsLocked.get(i).recordModificationsOf(setWrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                    i++;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    private final void registerCompositionLocked(ControlledComposition composition) {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i = mutableObjectList2._size;
            for (int i2 = 0; i2 < i; i2++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i2];
                if (composition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionRegistered((ObservableComposition) composition);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        if (this._knownCompositions.remove(composition)) {
            this._knownCompositionsCache = null;
            unregisterCompositionLocked(composition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (true) {
            i = 0;
            try {
                if (list.isEmpty()) {
                    break;
                }
                ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                if (controlledComposition instanceof CompositionImpl) {
                    ((CompositionImpl) controlledComposition).invalidateAll();
                    ((CompositionImpl) controlledComposition).setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        int size = list.size();
                        while (i < size) {
                            recordFailedCompositionLocked(list.get(i));
                            i++;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            int size2 = list.size();
            while (i < size2) {
                recordFailedCompositionLocked(list.get(i));
                i++;
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
    
        if (r5.withFrameNanos(r9, r0) != r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0098 -> B:13:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runFrameLoop(MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        ArrayList arrayList;
        ArrayList arrayList2;
        final List list;
        final List list2;
        MonotonicFrameClock monotonicFrameClock2;
        final ProduceFrameSignal produceFrameSignal2;
        Object obj;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            obj = this.stateLock;
            anonymousClass1.L$0 = monotonicFrameClock;
            anonymousClass1.L$1 = produceFrameSignal;
            anonymousClass1.L$2 = arrayList;
            anonymousClass1.L$3 = arrayList2;
            anonymousClass1.label = 1;
            if (produceFrameSignal.awaitFrameRequest(obj, anonymousClass1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list2 = (List) anonymousClass1.L$3;
            list = (List) anonymousClass1.L$2;
            produceFrameSignal2 = (ProduceFrameSignal) anonymousClass1.L$1;
            monotonicFrameClock2 = (MonotonicFrameClock) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj2);
            arrayList = list;
            produceFrameSignal = produceFrameSignal2;
            arrayList2 = list2;
            monotonicFrameClock = monotonicFrameClock2;
            obj = this.stateLock;
            anonymousClass1.L$0 = monotonicFrameClock;
            anonymousClass1.L$1 = produceFrameSignal;
            anonymousClass1.L$2 = arrayList;
            anonymousClass1.L$3 = arrayList2;
            anonymousClass1.label = 1;
            if (produceFrameSignal.awaitFrameRequest(obj, anonymousClass1) != coroutine_suspended) {
                monotonicFrameClock2 = monotonicFrameClock;
                list2 = arrayList2;
                produceFrameSignal2 = produceFrameSignal;
                list = arrayList;
                Function1 function1 = new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return Recomposer.runFrameLoop$lambda$0(this.f$0, list, list2, produceFrameSignal2, ((Long) obj3).longValue());
                    }
                };
                anonymousClass1.L$0 = monotonicFrameClock2;
                anonymousClass1.L$1 = produceFrameSignal2;
                anonymousClass1.L$2 = list;
                anonymousClass1.L$3 = list2;
                anonymousClass1.label = 2;
            }
            return coroutine_suspended;
        }
        list2 = (List) anonymousClass1.L$3;
        list = (List) anonymousClass1.L$2;
        produceFrameSignal2 = (ProduceFrameSignal) anonymousClass1.L$1;
        monotonicFrameClock2 = (MonotonicFrameClock) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj2);
        Function1 function12 = new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Recomposer.runFrameLoop$lambda$0(this.f$0, list, list2, produceFrameSignal2, ((Long) obj3).longValue());
            }
        };
        anonymousClass1.L$0 = monotonicFrameClock2;
        anonymousClass1.L$1 = produceFrameSignal2;
        anonymousClass1.L$2 = list;
        anonymousClass1.L$3 = list2;
        anonymousClass1.label = 2;
    }

    static final CancellableContinuation runFrameLoop$lambda$0(Recomposer recomposer, List list, List list2, ProduceFrameSignal produceFrameSignal, long j) {
        Object objBeginSection;
        int i;
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        if (recomposer.getHasBroadcastFrameClockAwaiters()) {
            objBeginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
            try {
                recomposer.broadcastFrameClock.sendFrame(j);
                Snapshot.INSTANCE.sendApplyNotifications();
                Unit unit = Unit.INSTANCE;
            } finally {
            }
        }
        objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
        try {
            recomposer.recordComposerModifications();
            synchronized (recomposer.stateLock) {
                List<ControlledComposition> list3 = recomposer.compositionsAwaitingApply;
                int size = list3.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    list2.add(list3.get(i2));
                }
                recomposer.compositionsAwaitingApply.clear();
                MutableVector<ControlledComposition> mutableVector = recomposer.compositionInvalidations;
                ControlledComposition[] controlledCompositionArr = mutableVector.content;
                int size2 = mutableVector.getSize();
                for (int i3 = 0; i3 < size2; i3++) {
                    list.add(controlledCompositionArr[i3]);
                }
                recomposer.compositionInvalidations.clear();
                produceFrameSignal.takeFrameRequestLocked();
                Unit unit2 = Unit.INSTANCE;
            }
            MutableScatterSet<Object> mutableScatterSet = new MutableScatterSet<>(i, 1, null);
            try {
                int size3 = list.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    ControlledComposition controlledCompositionPerformRecompose = recomposer.performRecompose((ControlledComposition) list.get(i4), mutableScatterSet);
                    if (controlledCompositionPerformRecompose != null) {
                        list2.add(controlledCompositionPerformRecompose);
                    }
                }
                list.clear();
                if (!list2.isEmpty()) {
                    recomposer.changeCount++;
                }
                try {
                    int size4 = list2.size();
                    while (i < size4) {
                        ((ControlledComposition) list2.get(i)).applyChanges();
                        i++;
                    }
                    list2.clear();
                    synchronized (recomposer.stateLock) {
                        cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                    }
                    return cancellableContinuationDeriveStateLocked;
                } catch (Throwable th) {
                    list2.clear();
                    throw th;
                }
            } catch (Throwable th2) {
                list.clear();
                throw th2;
            }
        } finally {
        }
    }

    private final void unregisterCompositionLocked(ControlledComposition composition) {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i = mutableObjectList2._size;
            for (int i2 = 0; i2 < i; i2++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i2];
                if (composition instanceof ObservableComposition) {
                    compositionRegistrationObserver.onCompositionUnregistered((ObservableComposition) composition);
                }
            }
        }
    }

    private final void withTransparentSnapshot(Function0<Unit> block) {
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        TransparentObserverSnapshot transparentObserverMutableSnapshot = current instanceof MutableSnapshot ? new TransparentObserverMutableSnapshot((MutableSnapshot) current, null, null, true, false) : new TransparentObserverSnapshot(current, null, true, false);
        try {
            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
            try {
                block.invoke();
                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            } catch (Throwable th) {
                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } finally {
            transparentObserverMutableSnapshot.dispose();
        }
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Recomposer.writeObserverOf$lambda$0(composition, modifiedValues, obj);
            }
        };
    }

    static final Unit writeObserverOf$lambda$0(ControlledComposition controlledComposition, MutableScatterSet mutableScatterSet, Object obj) {
        controlledComposition.recordWriteOf(obj);
        if (mutableScatterSet != null) {
            mutableScatterSet.add(obj);
        }
        return Unit.INSTANCE;
    }

    public final CompositionObserverHandle addCompositionRegistrationObserver$runtime(final CompositionRegistrationObserver observer) {
        synchronized (this.stateLock) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
            int i = 0;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(i, 1, null);
                this.registrationObservers = mutableObjectList;
            }
            mutableObjectList.add(observer);
            List<ControlledComposition> list = this._knownCompositions;
            int size = list.size();
            while (i < size) {
                ControlledComposition controlledComposition = list.get(i);
                if (controlledComposition instanceof ObservableComposition) {
                    observer.onCompositionRegistered((ObservableComposition) controlledComposition);
                }
                i++;
            }
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.Recomposer$addCompositionRegistrationObserver$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                CompositionRegistrationObserver compositionRegistrationObserver = observer;
                synchronized (obj) {
                    MutableObjectList mutableObjectList2 = recomposer.registrationObservers;
                    if (mutableObjectList2 != null) {
                        Boolean.valueOf(mutableObjectList2.remove(compositionRegistrationObserver));
                    }
                }
            }
        };
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new AnonymousClass2(null)), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) throws Throwable {
        boolean z;
        boolean zIsComposing = composition.isComposing();
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                boolean zContains = knownCompositionsLocked().contains(composition);
                z = !zContains;
                if (!zContains) {
                    registerCompositionLocked(composition);
                }
            } else {
                z = true;
            }
        }
        try {
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
                Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                    synchronized (this.stateLock) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                            unregisterCompositionLocked(composition);
                        } else if (!knownCompositionsLocked().contains(composition)) {
                            addKnownCompositionLocked(composition);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    if (!zIsComposing) {
                        Snapshot.INSTANCE.notifyObjectsInitialized();
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (zIsComposing) {
                                return;
                            }
                            Snapshot.INSTANCE.notifyObjectsInitialized();
                        } catch (Throwable th) {
                            processCompositionError$default(this, th, null, false, 6, null);
                        }
                    } catch (Throwable th2) {
                        processCompositionError(th2, composition, true);
                    }
                } catch (Throwable th3) {
                    mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th3;
                }
            } catch (Throwable th4) {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                throw th4;
            }
        } catch (Throwable th5) {
            if (z) {
                synchronized (this.stateLock) {
                    unregisterCompositionLocked(composition);
                    Unit unit3 = Unit.INSTANCE;
                }
            }
            processCompositionError(th5, composition, true);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            ShouldPauseCallback andSetShouldPauseCallback = composition.getAndSetShouldPauseCallback(shouldPause);
            try {
                composeInitial$runtime(composition, content);
                MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
                return mutableScatterSet != null ? mutableScatterSet : ScatterSetKt.emptyScatterSet();
            } finally {
                composition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            }
        } finally {
            this.pausedScopes.set(null);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime(MovableContentStateReference reference) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            MultiValueMap.m5671addimpl(this.movableContentRemoved, reference.getContent$runtime(), reference);
            if (reference.getNestedReferences$runtime() != null) {
                deletedMovableContent$lambda$0$recordNestedStatesOf(this, reference, reference);
            }
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* JADX INFO: renamed from: getCollectingParameterInformation$runtime */
    public boolean getCollectingParameterInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* JADX INFO: renamed from: getCollectingSourceInformation$runtime */
    public boolean getCollectingSourceInformation() {
        return ComposeStackTraceMode.m5791equalsimpl0(ComposerKt.getComposeStackTraceMode(), ComposeStackTraceMode.INSTANCE.m5798getSourceInformationMD5MrJc());
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* JADX INFO: renamed from: getCompositeKeyHashCode$runtime */
    public long getCompositeKeyHashCode() {
        return 1000L;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public Composition getComposition$runtime() {
        return null;
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.getSize() != 0 || this.concurrentCompositionsOutstanding > 0 || !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked()) {
                z = true;
            } else if (!MultiValueMap.m5684isNotEmptyimpl(this.movableContentRemoved)) {
                z = false;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getStackTraceEnabled$runtime() {
        return !ComposeStackTraceMode.m5791equalsimpl0(ComposerKt.getComposeStackTraceMode(), ComposeStackTraceMode.INSTANCE.m5797getNoneMD5MrJc());
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime(MovableContentStateReference reference) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.movableContentAwaitingInsert.add(reference);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(scope);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object objFirst = FlowKt.first(getCurrentState(), new C04662(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    @Override // androidx.compose.runtime.CompositionContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void movableContentStateReleased$runtime(MovableContentStateReference reference, MovableContentState data, Applier<?> applier) {
        synchronized (this.stateLock) {
            this.movableContentStatesAvailable.set(reference, data);
            ObjectList<MovableContentStateReference> objectListM5681getimpl = MultiValueMap.m5681getimpl(this.movableContentNestedExtractionsPending, reference);
            if (objectListM5681getimpl.isNotEmpty()) {
                ScatterMap<MovableContentStateReference, MovableContentState> scatterMapExtractNestedStates$runtime = data.extractNestedStates$runtime(applier, objectListM5681getimpl);
                Object[] objArr = scatterMapExtractNestedStates$runtime.keys;
                Object[] objArr2 = scatterMapExtractNestedStates$runtime.values;
                long[] jArr = scatterMapExtractNestedStates$runtime.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    Object obj = objArr[i4];
                                    this.movableContentStatesAvailable.set((MovableContentStateReference) obj, (MovableContentState) objArr2[i4]);
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            } else if (i == length) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        synchronized (this.stateLock) {
            movableContentStateRemove = this.movableContentStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes) {
        try {
            recordComposerModifications();
            composition.recordModificationsOf(ScatterSetWrapperKt.wrapIntoSet(invalidScopes));
            ShouldPauseCallback andSetShouldPauseCallback = composition.getAndSetShouldPauseCallback(shouldPause);
            try {
                ControlledComposition controlledCompositionPerformRecompose = performRecompose(composition, null);
                if (controlledCompositionPerformRecompose != null) {
                    performInitialMovableContentInserts(composition);
                    controlledCompositionPerformRecompose.applyChanges();
                    controlledCompositionPerformRecompose.applyLateChanges();
                }
                MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
                return mutableScatterSet != null ? mutableScatterSet : ScatterSetKt.emptyScatterSet();
            } finally {
                composition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            }
        } finally {
            this.pausedScopes.set(null);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime(ControlledComposition composition) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportPausedScope$runtime(RecomposeScopeImpl scope) {
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSetMutableScatterSetOf = this.pausedScopes.get();
        if (mutableScatterSetMutableScatterSetOf == null) {
            mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            this.pausedScopes.set(mutableScatterSetMutableScatterSetOf);
        }
        mutableScatterSetMutableScatterSetOf.add(scope);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime(ControlledComposition composition) {
        synchronized (this.stateLock) {
            LinkedHashSet linkedHashSet = this.compositionsRemoved;
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                this.compositionsRemoved = linkedHashSet;
            }
            linkedHashSet.add(composition);
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C04682(null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C04692(coroutineContext, this, null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CancellationHandle scheduleFrameEndCallback(Function0<Unit> action) {
        return this.nextFrameEndCallbackQueue.scheduleFrameEndCallback(action);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime(ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }
}
