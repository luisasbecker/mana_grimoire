package com.segment.analytics.kotlin.core;

import androidx.camera.video.AudioStats;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.platform.plugins.ContextPlugin;
import com.segment.analytics.kotlin.core.utilities.SegmentInstant;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import org.apache.commons.codec.language.Soundex;
import sovran.kotlin.Store;
import sovran.kotlin.Subscriber;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\u00042\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010Y\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J6\u0010Z\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00042\u001e\u0010[\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\\\u0012\u0004\u0012\u00020\u001b0\u0019J\u0006\u0010]\u001a\u00020\u001bJ.\u0010^\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\u00042\u001e\u0010[\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\\\u0012\u0004\u0012\u00020\u001b0\u0019J\u0006\u0010_\u001a\u00020\u001bJ\b\u0010`\u001a\u00020\u001bH\u0002J\b\u0010a\u001a\u00020\u001bH\u0002J\u0006\u0010b\u001a\u00020\u001bJ\u001b\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020eH\u0080@ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\u0019\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020jH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010kR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u001a\u00109\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u0017R\u001a\u0010K\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u0017R\u000e\u0010N\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006l"}, d2 = {"Lcom/segment/analytics/kotlin/core/Telemetry;", "Lsovran/kotlin/Subscriber;", "()V", "INTEGRATION_ERROR_METRIC", "", "INTEGRATION_METRIC", "INVOKE_ERROR_METRIC", "INVOKE_METRIC", "MAX_QUEUE_BYTES", "", "METRICS_BASE_TAG", "additionalTags", "", "getAdditionalTags", "()Ljava/util/Map;", "additionalTags$delegate", "Lkotlin/Lazy;", "value", "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "errorHandler", "Lkotlin/Function1;", "", "", "getErrorHandler", "()Lkotlin/jvm/functions/Function1;", "setErrorHandler", "(Lkotlin/jvm/functions/Function1;)V", "errorLogSizeMax", "getErrorLogSizeMax", "()I", "setErrorLogSizeMax", "(I)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "flushFirstError", "flushTimer", "getFlushTimer", "setFlushTimer", DiagnosticsTracker.HOST_KEY, "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "httpClient", "Lcom/segment/analytics/kotlin/core/HTTPClient;", "getHttpClient", "()Lcom/segment/analytics/kotlin/core/HTTPClient;", "setHttpClient", "(Lcom/segment/analytics/kotlin/core/HTTPClient;)V", "maxQueueBytes", "getMaxQueueBytes", "setMaxQueueBytes", "maxQueueSize", "getMaxQueueSize", "setMaxQueueSize", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/segment/analytics/kotlin/core/RemoteMetric;", "queueBytes", "rateLimitEndTime", "", "sampleRate", "", "getSampleRate", "()D", "setSampleRate", "(D)V", "sendErrorLogData", "getSendErrorLogData", "setSendErrorLogData", "sendWriteKeyOnError", "getSendWriteKeyOnError", "setSendWriteKeyOnError", "started", "telemetryDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "telemetryJob", "Lkotlinx/coroutines/Job;", "telemetryScope", "Lkotlinx/coroutines/CoroutineScope;", "addRemoteMetric", "metric", "tags", "log", "cleanErrorValue", "error", "buildTags", "", "flush", "increment", "reset", "resetQueue", "send", "start", "subscribe", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "subscribe$core", "(Lsovran/kotlin/Store;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "systemUpdate", "system", "Lcom/segment/analytics/kotlin/core/System;", "(Lcom/segment/analytics/kotlin/core/System;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Telemetry implements Subscriber {
    public static final String INTEGRATION_ERROR_METRIC = "analytics_mobile.integration.invoke.error";
    public static final String INTEGRATION_METRIC = "analytics_mobile.integration.invoke";
    public static final String INVOKE_ERROR_METRIC = "analytics_mobile.invoke.error";
    public static final String INVOKE_METRIC = "analytics_mobile.invoke";
    private static final String METRICS_BASE_TAG = "analytics_mobile";

    /* JADX INFO: renamed from: additionalTags$delegate, reason: from kotlin metadata */
    private static final Lazy additionalTags;
    private static final CoroutineExceptionHandler exceptionHandler;
    private static int queueBytes;
    private static long rateLimitEndTime;
    private static boolean sendErrorLogData;
    private static boolean started;
    private static ExecutorCoroutineDispatcher telemetryDispatcher;
    private static Job telemetryJob;
    private static CoroutineScope telemetryScope;
    public static final Telemetry INSTANCE = new Telemetry();
    private static boolean enable = true;
    private static String host = Constants.DEFAULT_API_HOST;
    private static double sampleRate = 1.0d;
    private static int flushTimer = 30000;
    private static HTTPClient httpClient = new HTTPClient("", new MetricsRequestFactory());
    private static boolean sendWriteKeyOnError = true;
    private static Function1<? super Throwable, Unit> errorHandler = Telemetry$errorHandler$1.INSTANCE;
    private static int maxQueueSize = 20;
    private static int errorLogSizeMax = 4000;
    private static final int MAX_QUEUE_BYTES = 28000;
    private static int maxQueueBytes = MAX_QUEUE_BYTES;
    private static final ConcurrentLinkedQueue<RemoteMetric> queue = new ConcurrentLinkedQueue<>();
    private static boolean flushFirstError = true;

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Telemetry$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: Telemetry.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Telemetry$start$1", f = "Telemetry.kt", i = {0}, l = {136}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:26:0x0061
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.util.concurrent.CancellationException -> L61
                goto L23
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                r1 = r6
            L23:
                boolean r6 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r6 == 0) goto L67
                com.segment.analytics.kotlin.core.Telemetry r6 = com.segment.analytics.kotlin.core.Telemetry.INSTANCE
                boolean r6 = r6.getEnable()
                if (r6 != 0) goto L3a
                com.segment.analytics.kotlin.core.Telemetry r5 = com.segment.analytics.kotlin.core.Telemetry.INSTANCE
                r5 = 0
                com.segment.analytics.kotlin.core.Telemetry.access$setStarted$p(r5)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L3a:
                com.segment.analytics.kotlin.core.Telemetry r6 = com.segment.analytics.kotlin.core.Telemetry.INSTANCE     // Catch: java.lang.Throwable -> L40
                r6.flush()     // Catch: java.lang.Throwable -> L40
                goto L4c
            L40:
                r6 = move-exception
                com.segment.analytics.kotlin.core.Telemetry r3 = com.segment.analytics.kotlin.core.Telemetry.INSTANCE
                kotlin.jvm.functions.Function1 r3 = r3.getErrorHandler()
                if (r3 == 0) goto L4c
                r3.invoke(r6)
            L4c:
                com.segment.analytics.kotlin.core.Telemetry r6 = com.segment.analytics.kotlin.core.Telemetry.INSTANCE     // Catch: java.util.concurrent.CancellationException -> L61
                int r6 = r6.getFlushTimer()     // Catch: java.util.concurrent.CancellationException -> L61
                long r3 = (long) r6     // Catch: java.util.concurrent.CancellationException -> L61
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.util.concurrent.CancellationException -> L61
                r5.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L61
                r5.label = r2     // Catch: java.util.concurrent.CancellationException -> L61
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)     // Catch: java.util.concurrent.CancellationException -> L61
                if (r6 != r0) goto L23
                return r0
            L61:
                com.segment.analytics.kotlin.core.Telemetry r6 = com.segment.analytics.kotlin.core.Telemetry.INSTANCE
                r6.flush()
                goto L23
            L67:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.segment.analytics.kotlin.core.Telemetry.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static {
        Telemetry$special$$inlined$CoroutineExceptionHandler$1 telemetry$special$$inlined$CoroutineExceptionHandler$1 = new Telemetry$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        exceptionHandler = telemetry$special$$inlined$CoroutineExceptionHandler$1;
        telemetryScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(telemetry$special$$inlined$CoroutineExceptionHandler$1));
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        telemetryDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        additionalTags = LazyKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.segment.analytics.kotlin.core.Telemetry$additionalTags$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends String> invoke() {
                String osVersion = java.lang.System.getProperty("os.version");
                Regex regex = new Regex("android[0-9][0-9]");
                Intrinsics.checkNotNullExpressionValue(osVersion, "osVersion");
                String str = osVersion;
                MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
                if (matchResultFind$default != null) {
                    osVersion = matchResultFind$default.getValue();
                } else {
                    Regex regex2 = new Regex("[0-9]+");
                    Intrinsics.checkNotNullExpressionValue(osVersion, "osVersion");
                    MatchResult matchResultFind$default2 = Regex.find$default(regex2, str, 0, 2, null);
                    if (matchResultFind$default2 != null) {
                        osVersion = matchResultFind$default2.getValue();
                    }
                }
                return MapsKt.mapOf(TuplesKt.to(AndroidContextPlugin.OS_KEY, java.lang.System.getProperty("os.name") + Soundex.SILENT_MARKER + osVersion), TuplesKt.to("interpreter", java.lang.System.getProperty("java.vendor") + Soundex.SILENT_MARKER + java.lang.System.getProperty("java.version")), TuplesKt.to(ContextPlugin.LIBRARY_KEY, "analytics.kotlin"), TuplesKt.to("library_version", "1.19.2"));
            }
        });
    }

    private Telemetry() {
    }

    private final void addRemoteMetric(String metric, Map<String, String> tags, int value, String log) {
        Object next;
        Map mapPlus = MapsKt.plus(tags, getAdditionalTags());
        Iterator<T> it = queue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            RemoteMetric remoteMetric = (RemoteMetric) next;
            if (Intrinsics.areEqual(remoteMetric.getMetric(), metric) && Intrinsics.areEqual(remoteMetric.getTags(), mapPlus)) {
                break;
            }
        }
        RemoteMetric remoteMetric2 = (RemoteMetric) next;
        if (remoteMetric2 != null) {
            remoteMetric2.setValue(remoteMetric2.getValue() + value);
            return;
        }
        ConcurrentLinkedQueue<RemoteMetric> concurrentLinkedQueue = queue;
        if (concurrentLinkedQueue.size() >= maxQueueSize) {
            return;
        }
        RemoteMetric remoteMetric3 = new RemoteMetric("Counter", metric, value, mapPlus, log != null ? MapsKt.mapOf(TuplesKt.to(DiagnosticsEntry.TIMESTAMP_KEY, SegmentInstant.INSTANCE.now()), TuplesKt.to("trace", log)) : null);
        byte[] bytes = remoteMetric3.toString().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        if (queueBytes + length <= maxQueueBytes) {
            concurrentLinkedQueue.add(remoteMetric3);
            queueBytes += length;
        }
    }

    static /* synthetic */ void addRemoteMetric$default(Telemetry telemetry, String str, Map map, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        telemetry.addRemoteMetric(str, map, i, str2);
    }

    private final Map<String, String> getAdditionalTags() {
        return (Map) additionalTags.getValue();
    }

    private final void resetQueue() {
        queue.clear();
        queueBytes = 0;
    }

    private final void send() {
        String str;
        if (sampleRate == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        int size = queue.size();
        queueBytes = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                break;
            }
            ConcurrentLinkedQueue<RemoteMetric> concurrentLinkedQueue = queue;
            if (concurrentLinkedQueue.isEmpty()) {
                break;
            }
            RemoteMetric remoteMetricPoll = concurrentLinkedQueue.poll();
            if (remoteMetricPoll != null) {
                remoteMetricPoll.setValue(MathKt.roundToInt(((double) remoteMetricPoll.getValue()) / sampleRate));
                arrayList.add(remoteMetricPoll);
            }
            size = i;
        }
        Long longOrNull = null;
        try {
            Json.Companion companion = Json.INSTANCE;
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("series", arrayList));
            companion.getSerializersModule();
            String strEncodeToString = companion.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(RemoteMetric$$serializer.INSTANCE)), mapMapOf);
            Connection connectionUpload = httpClient.upload(host);
            OutputStream outputStream = connectionUpload.getOutputStream();
            if (outputStream != null) {
                OutputStream outputStream2 = outputStream;
                try {
                    OutputStream outputStream3 = outputStream2;
                    byte[] bytes = strEncodeToString.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    outputStream3.write(bytes);
                    outputStream3.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStream2, null);
                } finally {
                }
            }
            InputStream inputStream = connectionUpload.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream4 = connectionUpload.getOutputStream();
            if (outputStream4 != null) {
                outputStream4.close();
            }
            connectionUpload.close();
        } catch (HTTPException e) {
            Function1<? super Throwable, Unit> function1 = errorHandler;
            if (function1 != null) {
                function1.invoke(e);
            }
            if (e.getResponseCode() == 429) {
                List<String> list = e.getResponseHeaders().get(HttpHeaders.RETRY_AFTER);
                if (list != null && (str = (String) CollectionsKt.firstOrNull((List) list)) != null) {
                    longOrNull = StringsKt.toLongOrNull(str);
                }
                if (longOrNull != null) {
                    rateLimitEndTime = longOrNull.longValue() + (java.lang.System.currentTimeMillis() / 1000);
                }
            }
        } catch (Exception e2) {
            Function1<? super Throwable, Unit> function12 = errorHandler;
            if (function12 != null) {
                function12.invoke(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object systemUpdate(System system, Continuation<? super Unit> continuation) {
        JsonElement jsonElement;
        JsonPrimitive jsonPrimitive;
        Settings settings = system.getSettings();
        if (settings != null && (jsonElement = (JsonElement) settings.getMetrics().get("sampleRate")) != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) != null) {
            double d = JsonElementKt.getDouble(jsonPrimitive);
            Telemetry telemetry = INSTANCE;
            sampleRate = d;
            telemetry.start();
        }
        return Unit.INSTANCE;
    }

    public final String cleanErrorValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new Regex("^[a-z][a-z0-9]\\.[a-z]:").replace(new Regex("[0-9a-fA-F]{6,}").replace(new Regex("0x[0-9a-fA-F]+").replace(new Regex("[0-9a-fA-F]{2,4}(:[0-9a-fA-F]{0,4}){2,8}[\\d._:port]*").replace(new Regex("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}[\\d._:port]*").replace(value, "_IP"), "_IP"), "0x00"), "0x00"), "");
    }

    public final void error(String metric, String log, Function1<? super Map<String, String>, Unit> buildTags) {
        LinkedHashMap map;
        String str;
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(buildTags, "buildTags");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        buildTags.invoke(linkedHashMap);
        if (!enable || sampleRate == AudioStats.AUDIO_AMPLITUDE_NONE || !StringsKt.startsWith$default(metric, METRICS_BASE_TAG, false, 2, (Object) null) || linkedHashMap.isEmpty() || Math.random() > sampleRate) {
            return;
        }
        if (linkedHashMap.containsKey("error")) {
            Object obj = linkedHashMap.get("error");
            Intrinsics.checkNotNull(obj);
            linkedHashMap.put("error", cleanErrorValue((String) obj));
        }
        if (sendWriteKeyOnError) {
            map = MapsKt.toMap(linkedHashMap);
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (!Intrinsics.areEqual(lowerCase, "writekey")) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            map = linkedHashMap2;
        }
        Map map2 = map;
        if (sendErrorLogData) {
            int length = log.length();
            int i = errorLogSizeMax;
            if (length > i) {
                log = log.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(log, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            str = log;
        } else {
            str = null;
        }
        addRemoteMetric$default(this, metric, map2, 0, str, 4, null);
        if (flushFirstError) {
            flushFirstError = false;
            flush();
        }
    }

    public final synchronized void flush() {
        if (enable && !queue.isEmpty()) {
            if (rateLimitEndTime > ((int) (java.lang.System.currentTimeMillis() / 1000))) {
                return;
            }
            rateLimitEndTime = 0L;
            try {
                send();
                queueBytes = 0;
            } catch (Throwable th) {
                Function1<? super Throwable, Unit> function1 = errorHandler;
                if (function1 != null) {
                    function1.invoke(th);
                }
                sampleRate = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
        }
    }

    public final boolean getEnable() {
        return enable;
    }

    public final Function1<Throwable, Unit> getErrorHandler() {
        return errorHandler;
    }

    public final int getErrorLogSizeMax() {
        return errorLogSizeMax;
    }

    public final int getFlushTimer() {
        return flushTimer;
    }

    public final String getHost() {
        return host;
    }

    public final HTTPClient getHttpClient() {
        return httpClient;
    }

    public final int getMaxQueueBytes() {
        return maxQueueBytes;
    }

    public final int getMaxQueueSize() {
        return maxQueueSize;
    }

    public final double getSampleRate() {
        return sampleRate;
    }

    public final boolean getSendErrorLogData() {
        return sendErrorLogData;
    }

    public final boolean getSendWriteKeyOnError() {
        return sendWriteKeyOnError;
    }

    public final void increment(String metric, Function1<? super Map<String, String>, Unit> buildTags) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(buildTags, "buildTags");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        buildTags.invoke(linkedHashMap);
        if (!enable || sampleRate == AudioStats.AUDIO_AMPLITUDE_NONE || !StringsKt.startsWith$default(metric, METRICS_BASE_TAG, false, 2, (Object) null) || linkedHashMap.isEmpty() || Math.random() > sampleRate) {
            return;
        }
        addRemoteMetric$default(this, metric, linkedHashMap, 0, null, 12, null);
    }

    public final void reset() {
        Job job = telemetryJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        resetQueue();
        started = false;
        rateLimitEndTime = 0L;
    }

    public final void setEnable(boolean z) {
        enable = z;
        if (z) {
            start();
        }
    }

    public final void setErrorHandler(Function1<? super Throwable, Unit> function1) {
        errorHandler = function1;
    }

    public final void setErrorLogSizeMax(int i) {
        errorLogSizeMax = i;
    }

    public final void setFlushTimer(int i) {
        flushTimer = i;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        host = str;
    }

    public final void setHttpClient(HTTPClient hTTPClient) {
        Intrinsics.checkNotNullParameter(hTTPClient, "<set-?>");
        httpClient = hTTPClient;
    }

    public final void setMaxQueueBytes(int i) {
        maxQueueBytes = Math.min(i, MAX_QUEUE_BYTES);
    }

    public final void setMaxQueueSize(int i) {
        maxQueueSize = i;
    }

    public final void setSampleRate(double d) {
        sampleRate = d;
    }

    public final void setSendErrorLogData(boolean z) {
        sendErrorLogData = z;
    }

    public final void setSendWriteKeyOnError(boolean z) {
        sendWriteKeyOnError = z;
    }

    public final void start() {
        if (!enable || started || sampleRate == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        started = true;
        if (Math.random() > sampleRate) {
            resetQueue();
        }
        telemetryJob = BuildersKt__Builders_commonKt.launch$default(telemetryScope, telemetryDispatcher, null, new AnonymousClass1(null), 2, null);
    }

    public final Object subscribe$core(Store store, Continuation<? super Unit> continuation) {
        Object objSubscribe = store.subscribe(this, Reflection.getOrCreateKotlinClass(System.class), true, telemetryDispatcher, new Telemetry$subscribe$2(this), continuation);
        return objSubscribe == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSubscribe : Unit.INSTANCE;
    }
}
