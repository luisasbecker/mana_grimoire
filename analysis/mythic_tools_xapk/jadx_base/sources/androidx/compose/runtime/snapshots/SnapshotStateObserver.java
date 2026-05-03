package androidx.compose.runtime.snapshots;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001<B0\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001d\u0010#\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001d\u0010%\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100\u0003H\u0082\bJ?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010-*\u00020\u00012\u0006\u0010.\u001a\u0002H-2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u000e\u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0001J)\u00103\u001a\u00020\u00052!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00100\u0003J\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u00020\u0005J\u001e\u00107\u001a\u00020\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u00109\u001a\u00020\u0014H\u0007J\u0006\u00102\u001a\u00020\u0005J&\u0010:\u001a\u00020\u001f\"\b\b\u0000\u0010-*\u00020\u00012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u0003H\u0002R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00060\u0001j\u0002`!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "sendingNotifications", "", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "drainChanges", "sendNotifications", "addChanges", "set", "removeChanges", "report", "", "readObserver", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "observedScopeMapsLock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "forEachScopeMap", "block", "removeScopeMapIf", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "isPaused", "currentMap", "currentMapThreadId", "", "observeReads", ExifInterface.GPS_DIRECTION_TRUE, "scope", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "withNoObservations", "clear", "clearIf", "predicate", "start", "stop", "notifyChanges", "changes", "snapshot", "ensureMap", "onChanged", "ObservedScopeMap", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SnapshotStateObserver.applyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SnapshotStateObserver.readObserver$lambda$0(this.f$0, obj);
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private final Object observedScopeMapsLock = new Object();
    private long currentMapThreadId = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0001J.\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002J7\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00012\u0014\b\b\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040.H\u0086\bJ\u0010\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001H\u0002J\u000e\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001d0\u0003J\u0006\u00105\u001a\u00020\u001dJ\u0018\u00106\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002J\u0006\u00107\u001a\u00020\u0004J\u0014\u00108\u001a\u00020\u001d2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010:J\u0012\u0010;\u001a\u00020\u00042\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0006\u0010=\u001a\u00020\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R6\u0010$\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010%j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001`&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "valueToScopes", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "invalidated", "Landroidx/collection/MutableScatterSet;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedState;", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "readingDerivedStates", "", "getReadingDerivedStates", "()Z", "setReadingDerivedStates", "(Z)V", "deriveStateScopeCount", "dependencyToDerivedStates", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordRead", "value", "recordedValues", "observe", "scope", "readObserver", "block", "Lkotlin/Function0;", "clearObsoleteStateReads", "clearScopeObservations", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "hasScopeObservations", "removeObservation", "clear", "recordInvalidation", "changes", "", "rereadDerivedState", "derivedState", "notifyInvalidatedScopes", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final Function1<Object, Unit> onChanged;
        private boolean readingDerivedStates;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final MutableScatterMap<Object, Object> valueToScopes = ScopeMap.m5697constructorimpl$default(null, 1, null);
        private final MutableScatterSet<Object> invalidated = new MutableScatterSet<>(0, 1, null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }
        };
        private final MutableScatterMap<Object, Object> dependencyToDerivedStates = ScopeMap.m5697constructorimpl$default(null, 1, null);
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
            int i = 0;
            this.scopeToValues = new MutableScatterMap<>(i, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(scope, obj);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i;
            int i2;
            int i3;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iPut = recordedValues.put(value, currentToken, -1);
            int i4 = 2;
            if (!(value instanceof DerivedState) || iPut == currentToken) {
                i = 2;
                i2 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                MutableScatterMap<Object, Object> mutableScatterMap = this.dependencyToDerivedStates;
                ScopeMap.m5706removeScopeimpl(mutableScatterMap, value);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8 - ((~(i5 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j & 255) < 128) {
                                    i3 = i4;
                                    StateObject stateObject = (StateObject) objArr[(i5 << 3) + i7];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        ((StateObjectImpl) stateObject).m5787recordReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(i3));
                                    }
                                    ScopeMap.m5691addimpl(mutableScatterMap, stateObject, value);
                                } else {
                                    i3 = i4;
                                }
                                j >>= 8;
                                i7++;
                                i4 = i3;
                            }
                            i = i4;
                            if (i6 != 8) {
                                break;
                            }
                        } else {
                            i = i4;
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        i4 = i;
                    }
                } else {
                    i = 2;
                }
                i2 = -1;
            }
            if (iPut == i2) {
                if (value instanceof StateObjectImpl) {
                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                    ((StateObjectImpl) value).m5787recordReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(i));
                }
                ScopeMap.m5691addimpl(this.valueToScopes, value, currentScope);
            }
        }

        private final void removeObservation(Object scope, Object value) {
            ScopeMap.m5704removeimpl(this.valueToScopes, value, scope);
            if (!(value instanceof DerivedState) || ScopeMap.m5698containsimpl(this.valueToScopes, value)) {
                return;
            }
            ScopeMap.m5706removeScopeimpl(this.dependencyToDerivedStates, value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            ScopeMap.m5695clearimpl(this.valueToScopes);
            this.scopeToValues.clear();
            ScopeMap.m5695clearimpl(this.dependencyToDerivedStates);
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap<Object> mutableObjectIntMapRemove = this.scopeToValues.remove(scope);
            if (mutableObjectIntMapRemove == null) {
                return;
            }
            MutableObjectIntMap<Object> mutableObjectIntMap = mutableObjectIntMapRemove;
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(scope, obj);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final boolean getReadingDerivedStates() {
            return this.readingDerivedStates;
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
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
                                function1.invoke(objArr[(i << 3) + i3]);
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
            mutableScatterSet.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot;
            Object obj = this.currentScope;
            MutableObjectIntMap mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = (MutableObjectIntMap) this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            DerivedStateObserver derivedStateObserver = getDerivedStateObserver();
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                if (readObserver == null) {
                    block.invoke();
                } else {
                    Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
                    if ((snapshot instanceof TransparentObserverMutableSnapshot) && ((TransparentObserverMutableSnapshot) snapshot).getThreadId() == Thread_jvmKt.currentThreadId()) {
                        Function1<Object, Unit> readObserver2 = ((TransparentObserverMutableSnapshot) snapshot).getReadObserver();
                        Function1<Object, Unit> writeObserver$runtime = ((TransparentObserverMutableSnapshot) snapshot).getWriteObserver$runtime();
                        try {
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(readObserver, readObserver2, false, 4, null));
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, writeObserver$runtime));
                            block.invoke();
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver2);
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                        } catch (Throwable th) {
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver2);
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                            throw th;
                        }
                    } else {
                        if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, readObserver, null, true, false);
                        } else {
                            transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(readObserver);
                        }
                        try {
                            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                            try {
                                block.invoke();
                                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                transparentObserverMutableSnapshot.dispose();
                            } catch (Throwable th2) {
                                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            transparentObserverMutableSnapshot.dispose();
                            throw th3;
                        }
                    }
                }
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th4) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th4;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:125:0x02a8 A[PHI: r21
          0x02a8: PHI (r21v12 boolean) = (r21v11 boolean), (r21v13 boolean) binds: [B:116:0x0280, B:124:0x02a6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x0331  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:193:0x0419  */
        /* JADX WARN: Removed duplicated region for block: B:226:0x04e3 A[PHI: r26
          0x04e3: PHI (r26v14 boolean) = (r26v13 boolean), (r26v15 boolean) binds: [B:217:0x04bb, B:225:0x04e1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:232:0x04fa  */
        /* JADX WARN: Removed duplicated region for block: B:260:0x0569  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x014b A[PHI: r21
          0x014b: PHI (r21v31 boolean) = (r21v30 boolean), (r21v32 boolean) binds: [B:49:0x0120, B:58:0x0149] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0226 A[PHI: r21
          0x0226: PHI (r21v20 boolean) = (r21v19 boolean), (r21v21 boolean) binds: [B:86:0x01fe, B:94:0x0224] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1, types: [int] */
        /* JADX WARN: Type inference failed for: r12v26 */
        /* JADX WARN: Type inference failed for: r8v42 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7, types: [int] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean recordInvalidation(Set<? extends Object> changes) {
            boolean z;
            Iterator it;
            MutableScatterMap<Object, Object> mutableScatterMap;
            String str;
            boolean z2;
            boolean z3;
            Object[] objArr;
            Iterator it2;
            MutableScatterMap<Object, Object> mutableScatterMap2;
            String str2;
            int i;
            Object[] objArr2;
            long j;
            long[] jArr;
            long[] jArr2;
            long[] jArr3;
            Object[] objArr3;
            int i2;
            long[] jArr4;
            Object[] objArr4;
            int i3;
            int i4;
            int i5;
            long j2;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            long j3;
            int i11;
            MutableScatterMap<Object, Object> mutableScatterMap3 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map = this.recordedDerivedStateValues;
            MutableScatterMap<Object, Object> mutableScatterMap4 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            String str3 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int i12 = 8;
            if (changes instanceof ScatterSetWrapper) {
                ScatterSet set$runtime = ((ScatterSetWrapper) changes).getSet$runtime();
                Object[] objArr5 = set$runtime.elements;
                long[] jArr5 = set$runtime.metadata;
                int length = jArr5.length - 2;
                if (length >= 0) {
                    int i13 = 0;
                    z = false;
                    while (true) {
                        long j4 = jArr5[i13];
                        int i14 = length;
                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i15 = 8 - ((~(i13 - i14)) >>> 31);
                            int i16 = 0;
                            while (i16 < i15) {
                                if ((j4 & 255) < 128) {
                                    Object obj = objArr5[(i13 << 3) + i16];
                                    int i17 = i12;
                                    if (obj instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        if (((StateObjectImpl) obj).m5786isReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(2))) {
                                            if (this.readingDerivedStates || !ScopeMap.m5698containsimpl(mutableScatterMap3, obj)) {
                                                jArr4 = jArr5;
                                                objArr4 = objArr5;
                                                i3 = i15;
                                                i4 = i16;
                                                i5 = i13;
                                                j2 = j4;
                                            } else {
                                                this.readingDerivedStates = true;
                                                try {
                                                    Object obj2 = mutableScatterMap3.get(obj);
                                                    if (obj2 == null) {
                                                        jArr4 = jArr5;
                                                        objArr4 = objArr5;
                                                    } else if (obj2 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj2;
                                                        Object[] objArr6 = mutableScatterSet2.elements;
                                                        long[] jArr6 = mutableScatterSet2.metadata;
                                                        jArr4 = jArr5;
                                                        int length2 = jArr6.length - 2;
                                                        objArr4 = objArr5;
                                                        if (length2 >= 0) {
                                                            j2 = j4;
                                                            int i18 = 0;
                                                            while (true) {
                                                                long j5 = jArr6[i18];
                                                                long[] jArr7 = jArr6;
                                                                Object[] objArr7 = objArr6;
                                                                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                    int i19 = 8 - ((~(i18 - length2)) >>> 31);
                                                                    int i20 = 0;
                                                                    while (i20 < i19) {
                                                                        if ((j5 & 255) < 128) {
                                                                            i7 = i20;
                                                                            DerivedState<?> derivedState = (DerivedState) objArr7[(i18 << 3) + i20];
                                                                            Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                                            i9 = i16;
                                                                            Object obj3 = map.get(derivedState);
                                                                            SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                                                                            if (policy == null) {
                                                                                policy = SnapshotStateKt.structuralEqualityPolicy();
                                                                            }
                                                                            j3 = j5;
                                                                            if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj3)) {
                                                                                i8 = i15;
                                                                                i10 = i13;
                                                                                Boolean.valueOf(this.statesToReread.add(derivedState));
                                                                            } else {
                                                                                Object obj4 = mutableScatterMap4.get(derivedState);
                                                                                if (obj4 == null) {
                                                                                    i8 = i15;
                                                                                    i10 = i13;
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                } else {
                                                                                    if (obj4 instanceof MutableScatterSet) {
                                                                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj4;
                                                                                        Object[] objArr8 = mutableScatterSet3.elements;
                                                                                        long[] jArr8 = mutableScatterSet3.metadata;
                                                                                        int length3 = jArr8.length - 2;
                                                                                        if (length3 >= 0) {
                                                                                            i10 = i13;
                                                                                            int i21 = 0;
                                                                                            while (true) {
                                                                                                long j6 = jArr8[i21];
                                                                                                long[] jArr9 = jArr8;
                                                                                                i8 = i15;
                                                                                                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                                    int i22 = 8 - ((~(i21 - length3)) >>> 31);
                                                                                                    int i23 = 0;
                                                                                                    while (i23 < i22) {
                                                                                                        if ((j6 & 255) < 128) {
                                                                                                            i11 = i23;
                                                                                                            mutableScatterSet.add(objArr8[(i21 << 3) + i23]);
                                                                                                            z = true;
                                                                                                        } else {
                                                                                                            i11 = i23;
                                                                                                        }
                                                                                                        j6 >>= i17;
                                                                                                        i23 = i11 + 1;
                                                                                                    }
                                                                                                    if (i22 != i17) {
                                                                                                        break;
                                                                                                    }
                                                                                                    if (i21 == length3) {
                                                                                                        break;
                                                                                                    }
                                                                                                    i21++;
                                                                                                    i15 = i8;
                                                                                                    jArr8 = jArr9;
                                                                                                    i17 = 8;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        i8 = i15;
                                                                                        i10 = i13;
                                                                                        mutableScatterSet.add(obj4);
                                                                                        z = true;
                                                                                    }
                                                                                    Unit unit2 = Unit.INSTANCE;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            i7 = i20;
                                                                            i8 = i15;
                                                                            i9 = i16;
                                                                            i10 = i13;
                                                                            j3 = j5;
                                                                        }
                                                                        j5 = j3 >> 8;
                                                                        i20 = i7 + 1;
                                                                        i17 = 8;
                                                                        i16 = i9;
                                                                        i13 = i10;
                                                                        i15 = i8;
                                                                    }
                                                                    i3 = i15;
                                                                    i4 = i16;
                                                                    i5 = i13;
                                                                    if (i19 != i17) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    i3 = i15;
                                                                    i4 = i16;
                                                                    i5 = i13;
                                                                }
                                                                if (i18 == length2) {
                                                                    break;
                                                                }
                                                                i18++;
                                                                objArr6 = objArr7;
                                                                jArr6 = jArr7;
                                                                i16 = i4;
                                                                i13 = i5;
                                                                i15 = i3;
                                                                i17 = 8;
                                                            }
                                                        }
                                                    } else {
                                                        jArr4 = jArr5;
                                                        objArr4 = objArr5;
                                                        i3 = i15;
                                                        i4 = i16;
                                                        i5 = i13;
                                                        j2 = j4;
                                                        DerivedState<?> derivedState2 = (DerivedState) obj2;
                                                        Object obj5 = map.get(derivedState2);
                                                        SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                                                        if (policy2 == null) {
                                                            policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                                        }
                                                        if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj5)) {
                                                            Boolean.valueOf(this.statesToReread.add(derivedState2));
                                                        } else {
                                                            Object obj6 = mutableScatterMap4.get(derivedState2);
                                                            if (obj6 != null) {
                                                                if (obj6 instanceof MutableScatterSet) {
                                                                    MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj6;
                                                                    Object[] objArr9 = mutableScatterSet4.elements;
                                                                    long[] jArr10 = mutableScatterSet4.metadata;
                                                                    int length4 = jArr10.length - 2;
                                                                    if (length4 >= 0) {
                                                                        int i24 = 0;
                                                                        while (true) {
                                                                            long j7 = jArr10[i24];
                                                                            if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                int i25 = 8 - ((~(i24 - length4)) >>> 31);
                                                                                for (int i26 = 0; i26 < i25; i26++) {
                                                                                    if ((j7 & 255) < 128) {
                                                                                        mutableScatterSet.add(objArr9[(i24 << 3) + i26]);
                                                                                        z = true;
                                                                                    }
                                                                                    j7 >>= 8;
                                                                                }
                                                                                if (i25 != 8) {
                                                                                    break;
                                                                                }
                                                                                if (i24 == length4) {
                                                                                    break;
                                                                                }
                                                                                i24++;
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    mutableScatterSet.add(obj6);
                                                                    z = true;
                                                                }
                                                            }
                                                            Unit unit3 = Unit.INSTANCE;
                                                        }
                                                    }
                                                    i3 = i15;
                                                    i4 = i16;
                                                    i5 = i13;
                                                    j2 = j4;
                                                } finally {
                                                }
                                            }
                                            Object obj7 = mutableScatterMap4.get(obj);
                                            if (obj7 != null) {
                                                if (obj7 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj7;
                                                    Object[] objArr10 = mutableScatterSet5.elements;
                                                    long[] jArr11 = mutableScatterSet5.metadata;
                                                    int length5 = jArr11.length - 2;
                                                    if (length5 >= 0) {
                                                        int i27 = 0;
                                                        while (true) {
                                                            long j8 = jArr11[i27];
                                                            if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i28 = 8 - ((~(i27 - length5)) >>> 31);
                                                                for (int i29 = 0; i29 < i28; i29++) {
                                                                    if ((j8 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr10[(i27 << 3) + i29]);
                                                                        z = true;
                                                                    }
                                                                    j8 >>= 8;
                                                                }
                                                                if (i28 != 8) {
                                                                    break;
                                                                }
                                                                if (i27 == length5) {
                                                                    break;
                                                                }
                                                                i27++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj7);
                                                    z = true;
                                                }
                                            }
                                        } else {
                                            jArr4 = jArr5;
                                            objArr4 = objArr5;
                                            i3 = i15;
                                            i4 = i16;
                                            i5 = i13;
                                            j2 = j4;
                                        }
                                        i6 = 8;
                                    }
                                } else {
                                    jArr4 = jArr5;
                                    objArr4 = objArr5;
                                    i3 = i15;
                                    i4 = i16;
                                    i5 = i13;
                                    j2 = j4;
                                    i6 = i12;
                                }
                                j4 = j2 >> i6;
                                i16 = i4 + 1;
                                i12 = i6;
                                jArr5 = jArr4;
                                objArr5 = objArr4;
                                i13 = i5;
                                i15 = i3;
                            }
                            jArr3 = jArr5;
                            objArr3 = objArr5;
                            int i30 = i13;
                            if (i15 != i12) {
                                break;
                            }
                            i2 = i30;
                        } else {
                            jArr3 = jArr5;
                            objArr3 = objArr5;
                            i2 = i13;
                        }
                        length = i14;
                        if (i2 == length) {
                            break;
                        }
                        i13 = i2 + 1;
                        jArr5 = jArr3;
                        objArr5 = objArr3;
                        i12 = 8;
                    }
                } else {
                    z = false;
                }
            } else {
                Iterator it3 = changes.iterator();
                boolean z4 = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (next instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                        if (((StateObjectImpl) next).m5786isReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(2))) {
                            if (this.readingDerivedStates || !ScopeMap.m5698containsimpl(mutableScatterMap3, next)) {
                                it = it3;
                                mutableScatterMap = mutableScatterMap3;
                                str = str3;
                                z2 = false;
                            } else {
                                this.readingDerivedStates = true;
                                try {
                                    Object obj8 = mutableScatterMap3.get(next);
                                    if (obj8 == null) {
                                        it = it3;
                                        mutableScatterMap = mutableScatterMap3;
                                        str = str3;
                                    } else if (obj8 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj8;
                                        Object[] objArr11 = mutableScatterSet6.elements;
                                        long[] jArr12 = mutableScatterSet6.metadata;
                                        int length6 = jArr12.length - 2;
                                        if (length6 >= 0) {
                                            int i31 = 0;
                                            while (true) {
                                                long j9 = jArr12[i31];
                                                long[] jArr13 = jArr12;
                                                if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i32 = 8 - ((~(i31 - length6)) >>> 31);
                                                    int i33 = 0;
                                                    while (i33 < i32) {
                                                        if ((j9 & 255) < 128) {
                                                            DerivedState<?> derivedState3 = (DerivedState) objArr11[(i31 << 3) + i33];
                                                            Intrinsics.checkNotNull(derivedState3, str3);
                                                            it2 = it3;
                                                            Object obj9 = map.get(derivedState3);
                                                            SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                            if (policy3 == null) {
                                                                policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            mutableScatterMap2 = mutableScatterMap3;
                                                            str2 = str3;
                                                            if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj9)) {
                                                                i = i33;
                                                                objArr2 = objArr11;
                                                                j = j9;
                                                                Boolean.valueOf(this.statesToReread.add(derivedState3));
                                                            } else {
                                                                Object obj10 = mutableScatterMap4.get(derivedState3);
                                                                if (obj10 == null) {
                                                                    i = i33;
                                                                    objArr2 = objArr11;
                                                                    j = j9;
                                                                    Unit unit4 = Unit.INSTANCE;
                                                                } else {
                                                                    if (obj10 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj10;
                                                                        Object[] objArr12 = mutableScatterSet7.elements;
                                                                        long[] jArr14 = mutableScatterSet7.metadata;
                                                                        int length7 = jArr14.length - 2;
                                                                        if (length7 >= 0) {
                                                                            i = i33;
                                                                            objArr2 = objArr11;
                                                                            int i34 = 0;
                                                                            while (true) {
                                                                                long j10 = jArr14[i34];
                                                                                j = j9;
                                                                                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                    int i35 = 8 - ((~(i34 - length7)) >>> 31);
                                                                                    int i36 = 0;
                                                                                    while (i36 < i35) {
                                                                                        if ((j10 & 255) < 128) {
                                                                                            jArr2 = jArr14;
                                                                                            mutableScatterSet.add(objArr12[(i34 << 3) + i36]);
                                                                                            z4 = true;
                                                                                        } else {
                                                                                            jArr2 = jArr14;
                                                                                        }
                                                                                        j10 >>= 8;
                                                                                        i36++;
                                                                                        jArr14 = jArr2;
                                                                                    }
                                                                                    jArr = jArr14;
                                                                                    if (i35 != 8) {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    jArr = jArr14;
                                                                                }
                                                                                if (i34 == length7) {
                                                                                    break;
                                                                                }
                                                                                i34++;
                                                                                j9 = j;
                                                                                jArr14 = jArr;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i = i33;
                                                                        objArr2 = objArr11;
                                                                        j = j9;
                                                                        mutableScatterSet.add(obj10);
                                                                        z4 = true;
                                                                    }
                                                                    Unit unit42 = Unit.INSTANCE;
                                                                }
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            mutableScatterMap2 = mutableScatterMap3;
                                                            str2 = str3;
                                                            i = i33;
                                                            objArr2 = objArr11;
                                                            j = j9;
                                                        }
                                                        j9 = j >> 8;
                                                        i33 = i + 1;
                                                        objArr11 = objArr2;
                                                        mutableScatterMap3 = mutableScatterMap2;
                                                        str3 = str2;
                                                        it3 = it2;
                                                    }
                                                    it = it3;
                                                    mutableScatterMap = mutableScatterMap3;
                                                    str = str3;
                                                    objArr = objArr11;
                                                    if (i32 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    it = it3;
                                                    mutableScatterMap = mutableScatterMap3;
                                                    str = str3;
                                                    objArr = objArr11;
                                                }
                                                if (i31 == length6) {
                                                    break;
                                                }
                                                i31++;
                                                it3 = it;
                                                jArr12 = jArr13;
                                                objArr11 = objArr;
                                                mutableScatterMap3 = mutableScatterMap;
                                                str3 = str;
                                            }
                                        }
                                    } else {
                                        it = it3;
                                        mutableScatterMap = mutableScatterMap3;
                                        str = str3;
                                        DerivedState<?> derivedState4 = (DerivedState) obj8;
                                        Object obj11 = map.get(derivedState4);
                                        SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                                        if (policy4 == null) {
                                            policy4 = SnapshotStateKt.structuralEqualityPolicy();
                                        }
                                        if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj11)) {
                                            Boolean.valueOf(this.statesToReread.add(derivedState4));
                                        } else {
                                            Object obj12 = mutableScatterMap4.get(derivedState4);
                                            if (obj12 != null) {
                                                if (obj12 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj12;
                                                    Object[] objArr13 = mutableScatterSet8.elements;
                                                    long[] jArr15 = mutableScatterSet8.metadata;
                                                    int length8 = jArr15.length - 2;
                                                    if (length8 >= 0) {
                                                        int i37 = 0;
                                                        while (true) {
                                                            long j11 = jArr15[i37];
                                                            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i38 = 8 - ((~(i37 - length8)) >>> 31);
                                                                for (int i39 = 0; i39 < i38; i39++) {
                                                                    if ((j11 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr13[(i37 << 3) + i39]);
                                                                        z4 = true;
                                                                    }
                                                                    j11 >>= 8;
                                                                }
                                                                if (i38 != 8) {
                                                                    break;
                                                                }
                                                                if (i37 == length8) {
                                                                    break;
                                                                }
                                                                i37++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj12);
                                                    z4 = true;
                                                }
                                            }
                                            Unit unit5 = Unit.INSTANCE;
                                        }
                                    }
                                } finally {
                                }
                            }
                            Object obj13 = mutableScatterMap4.get(next);
                            if (obj13 == null) {
                                z3 = z4;
                                z4 = z3;
                            } else if (obj13 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj13;
                                Object[] objArr14 = mutableScatterSet9.elements;
                                long[] jArr16 = mutableScatterSet9.metadata;
                                int length9 = jArr16.length - 2;
                                if (length9 >= 0) {
                                    ?? r8 = z2;
                                    while (true) {
                                        long j12 = jArr16[r8];
                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i40 = 8 - ((~(r8 - length9)) >>> 31);
                                            for (?? r12 = z2; r12 < i40; r12++) {
                                                if ((j12 & 255) < 128) {
                                                    mutableScatterSet.add(objArr14[(r8 << 3) + r12]);
                                                    z4 = true;
                                                }
                                                j12 >>= 8;
                                            }
                                            if (i40 != 8) {
                                                break;
                                            }
                                        }
                                        if (r8 == length9) {
                                            break;
                                        }
                                        r8++;
                                    }
                                }
                                z3 = z4;
                                z4 = z3;
                            } else {
                                mutableScatterSet.add(obj13);
                                z3 = true;
                                z4 = z3;
                            }
                        } else {
                            it = it3;
                            mutableScatterMap = mutableScatterMap3;
                            str = str3;
                        }
                    }
                    it3 = it;
                    mutableScatterMap3 = mutableScatterMap;
                    str3 = str;
                }
                z = z4;
            }
            if (!this.readingDerivedStates && this.statesToReread.getSize() != 0) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                DerivedState<?>[] derivedStateArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i41 = 0; i41 < size; i41++) {
                    rereadDerivedState(derivedStateArr[i41]);
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void recordRead(Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, mutableObjectIntMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            long j3;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j4 = jArr3[i2];
                char c2 = 7;
                long j5 = -9187201950435737472L;
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j4 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i6];
                            j2 = j5;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i6];
                            Boolean boolInvoke = predicate.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                MutableObjectIntMap mutableObjectIntMap2 = mutableObjectIntMap;
                                Object[] objArr = mutableObjectIntMap2.keys;
                                int[] iArr = mutableObjectIntMap2.values;
                                long[] jArr4 = mutableObjectIntMap2.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j4;
                                    int i8 = 0;
                                    while (true) {
                                        long j6 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        if ((((~j6) << c) & j6 & j2) != j2) {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            for (int i10 = 0; i10 < i9; i10++) {
                                                if ((j6 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    j3 = j6;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                } else {
                                                    j3 = j6;
                                                }
                                                j6 = j3 >> i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                            if (i8 == length2) {
                                                break;
                                            }
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j4;
                                }
                                if (boolInvoke.booleanValue()) {
                                    mutableScatterMap.removeValueAt(i6);
                                }
                                i = 8;
                            }
                        } else {
                            jArr2 = jArr3;
                            j = j4;
                            c = c2;
                            j2 = j5;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j4 = j >> i;
                        c2 = c;
                        j5 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int iHashCode = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            Object obj = this.valueToScopes.get(derivedState);
            if (obj == null) {
                return;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i2 = 1;
            int i3 = 0;
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(i3, i2, defaultConstructorMarker);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, iHashCode, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr3 = mutableScatterSet.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j = jArr3[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            i = i5;
                            Object obj2 = objArr[(i4 << 3) + i7];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            jArr2 = jArr3;
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(i3, i2, defaultConstructorMarker);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, iHashCode, obj2, mutableObjectIntMap);
                        } else {
                            jArr2 = jArr3;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i6 != i5) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i4 == length) {
                    return;
                }
                i4++;
                jArr3 = jArr;
            }
        }

        public final void setReadingDerivedStates(boolean z) {
            this.readingDerivedStates = z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    static final Unit applyObserver$lambda$0(SnapshotStateObserver snapshotStateObserver, Set set, Snapshot snapshot) {
        snapshotStateObserver.addChanges(set);
        if (snapshotStateObserver.drainChanges()) {
            snapshotStateObserver.sendNotifications();
        }
        return Unit.INSTANCE;
    }

    private final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMapsLock) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMapsLock) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    z2 = observedScopeMapArr[i].recordInvalidation(setRemoveChanges) || z2;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
        int size = mutableVector.getSize();
        int i = 0;
        while (true) {
            if (i >= size) {
                observedScopeMap = null;
                break;
            }
            observedScopeMap = observedScopeMapArr[i];
            if (observedScopeMap.getOnChanged() == onChanged) {
                break;
            }
            i++;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                block.invoke(observedScopeMapArr[i]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    static final Unit readObserver$lambda$0(SnapshotStateObserver snapshotStateObserver, Object obj) {
        if (!snapshotStateObserver.isPaused) {
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (block.invoke(mutableVector.content[i2]).booleanValue()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SnapshotStateObserver.sendNotifications$lambda$0(this.f$0);
            }
        });
    }

    static final Unit sendNotifications$lambda$0(SnapshotStateObserver snapshotStateObserver) {
        do {
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                if (!snapshotStateObserver.sendingNotifications) {
                    snapshotStateObserver.sendingNotifications = true;
                    try {
                        MutableVector<ObservedScopeMap> mutableVector = snapshotStateObserver.observedScopeMaps;
                        ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                        int size = mutableVector.getSize();
                        for (int i = 0; i < size; i++) {
                            observedScopeMapArr[i].notifyInvalidatedScopes();
                        }
                        snapshotStateObserver.sendingNotifications = false;
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } while (snapshotStateObserver.drainChanges());
        return Unit.INSTANCE;
    }

    public final void clear() {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                observedScopeMapArr[i].clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.content[i2];
                observedScopeMap.clearScopeObservations(scope);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.content[i2];
                observedScopeMap.removeScopeIf(predicate);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap observedScopeMapEnsureMap;
        long j;
        Function1<Object, Unit> function1;
        Object obj;
        MutableObjectIntMap mutableObjectIntMap;
        int i;
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers;
        MutableVector<DerivedStateObserver> mutableVector;
        long j2;
        TransparentObserverMutableSnapshot transparentObserverMutableSnapshot;
        synchronized (this.observedScopeMapsLock) {
            observedScopeMapEnsureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j3 = this.currentMapThreadId;
        if (j3 != -1) {
            if (!(j3 == Thread_jvmKt.currentThreadId())) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j3 + "), currentThread={id=" + Thread_jvmKt.currentThreadId() + ", name=" + Thread_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            this.currentMapThreadId = Thread_jvmKt.currentThreadId();
            function1 = this.readObserver;
            obj = observedScopeMapEnsureMap.currentScope;
            mutableObjectIntMap = observedScopeMapEnsureMap.currentScopeReads;
            i = observedScopeMapEnsureMap.currentToken;
            observedScopeMapEnsureMap.currentScope = scope;
            observedScopeMapEnsureMap.currentScopeReads = (MutableObjectIntMap) observedScopeMapEnsureMap.scopeToValues.get(scope);
            if (observedScopeMapEnsureMap.currentToken == -1) {
                observedScopeMapEnsureMap.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            DerivedStateObserver derivedStateObserver = observedScopeMapEnsureMap.getDerivedStateObserver();
            mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion companion = Snapshot.INSTANCE;
            } catch (Throwable th) {
                th = th;
                j = j3;
                mutableVector = mutableVectorDerivedStateObservers;
            }
        } catch (Throwable th2) {
            th = th2;
            j = j3;
        }
        if (function1 != null) {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            try {
                if (snapshot instanceof TransparentObserverMutableSnapshot) {
                    try {
                        if (((TransparentObserverMutableSnapshot) snapshot).getThreadId() == Thread_jvmKt.currentThreadId()) {
                            Function1<Object, Unit> readObserver = ((TransparentObserverMutableSnapshot) snapshot).getReadObserver();
                            Function1<Object, Unit> writeObserver$runtime = ((TransparentObserverMutableSnapshot) snapshot).getWriteObserver$runtime();
                            try {
                                j2 = j3;
                                try {
                                    ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(function1, readObserver, false, 4, null));
                                    ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, writeObserver$runtime));
                                    block.invoke();
                                    ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver);
                                    ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                                    mutableVector = mutableVectorDerivedStateObservers;
                                } catch (Throwable th3) {
                                    th = th3;
                                    ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver);
                                    ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } else {
                            j2 = j3;
                            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                                mutableVector = mutableVectorDerivedStateObservers;
                                try {
                                    transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, function1, null, true, false);
                                } catch (Throwable th5) {
                                    th = th5;
                                    j = j2;
                                    try {
                                        mutableVector.removeAt(mutableVector.getSize() - 1);
                                        throw th;
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                }
                            } else {
                                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(function1);
                                mutableVector = mutableVectorDerivedStateObservers;
                            }
                            Snapshot snapshot2 = transparentObserverMutableSnapshot;
                            try {
                                Snapshot snapshotMakeCurrent = snapshot2.makeCurrent();
                                try {
                                    block.invoke();
                                    snapshot2.restoreCurrent(snapshotMakeCurrent);
                                    snapshot2.dispose();
                                } catch (Throwable th7) {
                                    j = j2;
                                    try {
                                        snapshot2.restoreCurrent(snapshotMakeCurrent);
                                        throw th7;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        try {
                                            snapshot2.dispose();
                                            throw th;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            mutableVector.removeAt(mutableVector.getSize() - 1);
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                j = j2;
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        j2 = j3;
                        mutableVector = mutableVectorDerivedStateObservers;
                        j = j2;
                        mutableVector.removeAt(mutableVector.getSize() - 1);
                        throw th;
                    }
                }
            } catch (Throwable th12) {
                th = th12;
            }
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
            throw th;
        }
        block.invoke();
        j2 = j3;
        mutableVector = mutableVectorDerivedStateObservers;
        try {
            mutableVector.removeAt(mutableVector.getSize() - 1);
            Object obj2 = observedScopeMapEnsureMap.currentScope;
            Intrinsics.checkNotNull(obj2);
            observedScopeMapEnsureMap.clearObsoleteStateReads(obj2);
            observedScopeMapEnsureMap.currentScope = obj;
            observedScopeMapEnsureMap.currentScopeReads = mutableObjectIntMap;
            observedScopeMapEnsureMap.currentToken = i;
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j2;
        } catch (Throwable th13) {
            th = th13;
            j = j2;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z;
        }
    }
}
