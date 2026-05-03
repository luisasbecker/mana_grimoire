package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: DiagnosticsSynchronizer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0006\u0010\u0019\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;", "diagnosticsHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "diagnosticsTracker", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "diagnosticsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/Dispatcher;)V", "isSyncing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "enqueue", "", "command", "Lkotlin/Function0;", "getEventsToSync", "", "Lorg/json/JSONObject;", "onEventTracked", "syncDiagnosticsFileIfBigEnough", "syncDiagnosticsFileIfNeeded", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticsSynchronizer implements DiagnosticsEventTrackerListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_EVENTS_TO_SYNC_PER_REQUEST = 200;
    public static final int MAX_NUMBER_POST_RETRIES = 3;
    private final Backend backend;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsHelper diagnosticsHelper;
    private final DiagnosticsTracker diagnosticsTracker;
    private final AtomicBoolean isSyncing;

    /* JADX INFO: compiled from: DiagnosticsSynchronizer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer$Companion;", "", "()V", "MAX_EVENTS_TO_SYNC_PER_REQUEST", "", "getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations", "MAX_NUMBER_POST_RETRIES", "getMAX_NUMBER_POST_RETRIES$annotations", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations() {
        }

        public static /* synthetic */ void getMAX_NUMBER_POST_RETRIES$annotations() {
        }
    }

    public DiagnosticsSynchronizer(DiagnosticsHelper diagnosticsHelper, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsTracker diagnosticsTracker, Backend backend, Dispatcher diagnosticsDispatcher) {
        Intrinsics.checkNotNullParameter(diagnosticsHelper, "diagnosticsHelper");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsTracker, "diagnosticsTracker");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(diagnosticsDispatcher, "diagnosticsDispatcher");
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsTracker = diagnosticsTracker;
        this.backend = backend;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.isSyncing = new AtomicBoolean(false);
    }

    private final void enqueue(final Function0<Unit> command) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                command.invoke();
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.List] */
    public final List<JSONObject> getEventsToSync() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        this.diagnosticsFileHelper.readFileAsJson(new Function1<Sequence<? extends JSONObject>, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.getEventsToSync.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Sequence<? extends JSONObject> sequence) {
                invoke2(sequence);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.List] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Sequence<? extends JSONObject> sequence) {
                Intrinsics.checkNotNullParameter(sequence, "sequence");
                objectRef.element = SequencesKt.toList(SequencesKt.take(sequence, 200));
            }
        });
        return (List) objectRef.element;
    }

    private final void syncDiagnosticsFileIfBigEnough() {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfBigEnough.1
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
                if (DiagnosticsSynchronizer.this.diagnosticsFileHelper.isDiagnosticsFileBigEnoughToSync()) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Diagnostics file is big enough to sync. Syncing it.");
                    }
                    DiagnosticsSynchronizer.this.syncDiagnosticsFileIfNeeded();
                }
            }
        });
    }

    /* JADX INFO: renamed from: isSyncing, reason: from getter */
    public final AtomicBoolean getIsSyncing() {
        return this.isSyncing;
    }

    @Override // com.revenuecat.purchases.common.diagnostics.DiagnosticsEventTrackerListener
    public void onEventTracked() {
        syncDiagnosticsFileIfBigEnough();
    }

    public final void syncDiagnosticsFileIfNeeded() {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfNeeded.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws Throwable {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws Throwable {
                try {
                    if (DiagnosticsSynchronizer.this.getIsSyncing().getAndSet(true)) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Already syncing diagnostics file.");
                            return;
                        }
                        return;
                    }
                    List<? extends JSONObject> eventsToSync = DiagnosticsSynchronizer.this.getEventsToSync();
                    final int size = eventsToSync.size();
                    if (size == 0) {
                        LogLevel logLevel2 = LogLevel.VERBOSE;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "No diagnostics to sync.");
                        }
                        DiagnosticsSynchronizer.this.getIsSyncing().set(false);
                        return;
                    }
                    Backend backend = DiagnosticsSynchronizer.this.backend;
                    final DiagnosticsSynchronizer diagnosticsSynchronizer = DiagnosticsSynchronizer.this;
                    Function1<JSONObject, Unit> function1 = new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfNeeded.1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                            invoke2(jSONObject);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(JSONObject it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            LogLevel logLevel3 = LogLevel.VERBOSE;
                            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Synced diagnostics file successfully.");
                            }
                            diagnosticsSynchronizer.diagnosticsHelper.clearConsecutiveNumberOfErrors();
                            diagnosticsSynchronizer.diagnosticsFileHelper.clear(size);
                            diagnosticsSynchronizer.getIsSyncing().set(false);
                        }
                    };
                    final DiagnosticsSynchronizer diagnosticsSynchronizer2 = DiagnosticsSynchronizer.this;
                    backend.postDiagnostics(eventsToSync, function1, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfNeeded.1.4
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                            invoke(purchasesError, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PurchasesError error, boolean z) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            if (z) {
                                LogLevel logLevel3 = LogLevel.VERBOSE;
                                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                    currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Error syncing diagnostics file: " + error + ". Will retry the next time the SDK is initialized");
                                }
                                if (diagnosticsSynchronizer2.diagnosticsHelper.increaseConsecutiveNumberOfErrors() >= 3) {
                                    LogLevel logLevel4 = LogLevel.VERBOSE;
                                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                        currentLogHandler4.v("[Purchases] - " + logLevel4.name(), "Error syncing diagnostics file: " + error + ". This was the final attempt (3). Deleting diagnostics file without posting.");
                                    }
                                    diagnosticsSynchronizer2.diagnosticsHelper.resetDiagnosticsStatus();
                                    diagnosticsSynchronizer2.diagnosticsTracker.trackMaxDiagnosticsSyncRetriesReached();
                                }
                            } else {
                                LogLevel logLevel5 = LogLevel.VERBOSE;
                                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                    currentLogHandler5.v("[Purchases] - " + logLevel5.name(), "Error syncing diagnostics file: " + error + ". Deleting diagnostics file without retrying.");
                                }
                                diagnosticsSynchronizer2.diagnosticsHelper.resetDiagnosticsStatus();
                                diagnosticsSynchronizer2.diagnosticsTracker.trackClearingDiagnosticsAfterFailedSync();
                            }
                            diagnosticsSynchronizer2.getIsSyncing().set(false);
                        }
                    });
                } catch (Exception e) {
                    LogLevel logLevel3 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Error syncing diagnostics file: " + e);
                    }
                    try {
                        DiagnosticsSynchronizer.this.diagnosticsHelper.resetDiagnosticsStatus();
                    } catch (IOException e2) {
                        LogLevel logLevel4 = LogLevel.VERBOSE;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.v("[Purchases] - " + logLevel4.name(), "Error deleting diagnostics file: " + e2);
                        }
                    }
                    DiagnosticsSynchronizer.this.getIsSyncing().set(false);
                }
            }
        });
    }
}
