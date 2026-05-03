package com.segment.analytics.kotlin.core.platform;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Connection;
import com.segment.analytics.kotlin.core.Constants;
import com.segment.analytics.kotlin.core.ErrorsKt;
import com.segment.analytics.kotlin.core.EventsKt;
import com.segment.analytics.kotlin.core.HTTPClient;
import com.segment.analytics.kotlin.core.HTTPException;
import com.segment.analytics.kotlin.core.ScreenEvent;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.StorageKt;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LogKind;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LoggerKt;
import com.segment.analytics.kotlin.core.platform.plugins.logger.SegmentLogKt;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: EventPipeline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0006\u0010+\u001a\u00020,J\u001c\u0010-\u001a\u00020\u001b2\n\u0010.\u001a\u00060/j\u0002`02\u0006\u00101\u001a\u00020\u0005H\u0002J\u000e\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020*J\b\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u00020,H\u0002J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020*H\u0016J\b\u0010:\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020<H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/EventPipeline;", "", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "logTag", "", "apiKey", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "apiHost", "(Lcom/segment/analytics/kotlin/core/Analytics;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getApiHost", "()Ljava/lang/String;", "setApiHost", "(Ljava/lang/String;)V", "fileIODispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getFileIODispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "httpClient", "Lcom/segment/analytics/kotlin/core/HTTPClient;", "getHttpClient", "()Lcom/segment/analytics/kotlin/core/HTTPClient;", "networkIODispatcher", "getNetworkIODispatcher", "<set-?>", "", "running", "getRunning", "()Z", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "storage", "Lcom/segment/analytics/kotlin/core/Storage;", "getStorage", "()Lcom/segment/analytics/kotlin/core/Storage;", "uploadChannel", "Lkotlinx/coroutines/channels/Channel;", "writeChannel", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "flush", "", "handleUploadException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "file", "put", NotificationCompat.CATEGORY_EVENT, "registerShutdownHook", "schedule", "start", "stop", "stringifyBaseEvent", "payload", "unschedule", "upload", "Lkotlinx/coroutines/Job;", "write", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class EventPipeline {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ScreenEvent FLUSH_EVENT;
    public static final String FLUSH_POISON = "#!flush";
    public static final String UPLOAD_SIG = "#!upload";
    private final Analytics analytics;
    private String apiHost;
    private final List<FlushPolicy> flushPolicies;
    private final HTTPClient httpClient;
    private final String logTag;
    private boolean running;
    private Channel<String> uploadChannel;
    private Channel<BaseEvent> writeChannel;

    /* JADX INFO: compiled from: EventPipeline.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/EventPipeline$Companion;", "", "()V", "FLUSH_EVENT", "Lcom/segment/analytics/kotlin/core/ScreenEvent;", "getFLUSH_EVENT$core", "()Lcom/segment/analytics/kotlin/core/ScreenEvent;", "FLUSH_POISON", "", "UPLOAD_SIG", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScreenEvent getFLUSH_EVENT$core() {
            return EventPipeline.FLUSH_EVENT;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.platform.EventPipeline$upload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventPipeline.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.platform.EventPipeline$upload$1", f = "EventPipeline.kt", i = {0, 1}, l = {222, 130}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1"})
    static final class C10881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C10881(Continuation<? super C10881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventPipeline.this.new C10881(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[Catch: all -> 0x013e, TryCatch #2 {all -> 0x013e, blocks: (B:7:0x001b, B:26:0x00aa, B:27:0x00bc, B:16:0x004f, B:20:0x0061, B:22:0x0069, B:40:0x0136, B:29:0x00c2, B:31:0x00d2, B:33:0x00e4, B:34:0x00f9, B:39:0x012e, B:37:0x011e, B:12:0x0036, B:15:0x004a), top: B:52:0x0009, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c2 A[Catch: all -> 0x013e, TRY_LEAVE, TryCatch #2 {all -> 0x013e, blocks: (B:7:0x001b, B:26:0x00aa, B:27:0x00bc, B:16:0x004f, B:20:0x0061, B:22:0x0069, B:40:0x0136, B:29:0x00c2, B:31:0x00d2, B:33:0x00e4, B:34:0x00f9, B:39:0x012e, B:37:0x011e, B:12:0x0036, B:15:0x004a), top: B:52:0x0009, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0136 A[Catch: all -> 0x013e, TRY_LEAVE, TryCatch #2 {all -> 0x013e, blocks: (B:7:0x001b, B:26:0x00aa, B:27:0x00bc, B:16:0x004f, B:20:0x0061, B:22:0x0069, B:40:0x0136, B:29:0x00c2, B:31:0x00d2, B:33:0x00e4, B:34:0x00f9, B:39:0x012e, B:37:0x011e, B:12:0x0036, B:15:0x004a), top: B:52:0x0009, inners: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a9 -> B:26:0x00aa). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Channel channel;
            EventPipeline eventPipeline;
            ChannelIterator it;
            Throwable th;
            EventPipeline eventPipeline2;
            Object objHasNext;
            boolean zHandleUploadException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    channel = EventPipeline.this.uploadChannel;
                    eventPipeline = EventPipeline.this;
                    it = channel.iterator();
                    th = null;
                    this.L$0 = eventPipeline;
                    this.L$1 = channel;
                    this.L$2 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext == coroutine_suspended) {
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (ChannelIterator) this.L$2;
                        channel = (ReceiveChannel) this.L$1;
                        EventPipeline eventPipeline3 = (EventPipeline) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        eventPipeline = eventPipeline3;
                        th = null;
                        for (String str : StorageKt.parseFilePaths(eventPipeline.getStorage().read(Storage.Constants.Events))) {
                            InputStream asStream = eventPipeline.getStorage().readAsStream(str);
                            if (asStream != null) {
                                try {
                                    Connection connectionUpload = eventPipeline.getHttpClient().upload(eventPipeline.getApiHost());
                                    if (connectionUpload.getOutputStream() != null) {
                                        ByteStreamsKt.copyTo$default(asStream, connectionUpload.getOutputStream(), 0, 2, null);
                                        asStream.close();
                                        connectionUpload.getOutputStream().close();
                                        connectionUpload.close();
                                    }
                                    LoggerKt.log$default(eventPipeline.analytics, eventPipeline.logTag + " uploaded " + str, null, 2, null);
                                    zHandleUploadException = true;
                                } catch (Exception e) {
                                    ErrorsKt.reportInternalError(eventPipeline.analytics, e);
                                    zHandleUploadException = eventPipeline.handleUploadException(e, str);
                                }
                                if (zHandleUploadException) {
                                    eventPipeline.getStorage().removeFile(str);
                                }
                            }
                        }
                        this.L$0 = eventPipeline;
                        this.L$1 = channel;
                        this.L$2 = it;
                        this.label = 1;
                        objHasNext = it.hasNext(this);
                        if (objHasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eventPipeline2 = eventPipeline;
                        obj = objHasNext;
                        if (((Boolean) obj).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(channel, th);
                            return Unit.INSTANCE;
                        }
                        LoggerKt.log$default(eventPipeline2.analytics, eventPipeline2.logTag + " performing flush", null, 2, null);
                        CoroutineDispatcher fileIODispatcher = eventPipeline2.getFileIODispatcher();
                        EventPipeline$upload$1$1$1 eventPipeline$upload$1$1$1 = new EventPipeline$upload$1$1$1(eventPipeline2, null);
                        this.L$0 = eventPipeline2;
                        this.L$1 = channel;
                        this.L$2 = it;
                        this.label = 2;
                        if (BuildersKt.withContext(fileIODispatcher, eventPipeline$upload$1$1$1, this) != coroutine_suspended) {
                            eventPipeline = eventPipeline2;
                            while (r7.hasNext()) {
                            }
                            this.L$0 = eventPipeline;
                            this.L$1 = channel;
                            this.L$2 = it;
                            this.label = 1;
                            objHasNext = it.hasNext(this);
                            if (objHasNext == coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    it = (ChannelIterator) this.L$2;
                    channel = (ReceiveChannel) this.L$1;
                    EventPipeline eventPipeline4 = (EventPipeline) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    eventPipeline2 = eventPipeline4;
                    th = null;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.platform.EventPipeline$write$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventPipeline.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.platform.EventPipeline$write$1", f = "EventPipeline.kt", i = {1, 1}, l = {104, Videoio.CAP_PROP_OPENNI2_SYNC}, m = "invokeSuspend", n = {NotificationCompat.CATEGORY_EVENT, "isPoison"}, s = {"L$1", "Z$0"})
    static final class C10891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        C10891(Continuation<? super C10891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventPipeline.this.new C10891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00af, code lost:
        
            if (r10.this$0.getStorage().write(com.segment.analytics.kotlin.core.Storage.Constants.Events, r11, r10) == r0) goto L25;
         */
        /* JADX WARN: Path cross not found for [B:34:0x00f2, B:44:0x011f], limit reached: 52 */
        /* JADX WARN: Path cross not found for [B:44:0x011f, B:34:0x00f2], limit reached: 52 */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x013c A[LOOP:2: B:45:0x0136->B:47:0x013c, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0146  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006a -> B:32:0x00ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00af -> B:26:0x00b2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object objHasNext;
            Iterator it2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = EventPipeline.this.writeChannel.iterator();
                this.L$0 = it;
                this.L$1 = null;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean zAreEqual = this.Z$0;
                BaseEvent baseEvent = (BaseEvent) this.L$1;
                channelIterator = (ChannelIterator) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    ErrorsKt.reportInternalError(EventPipeline.this.analytics, e);
                    SegmentLogKt.segmentLog(Analytics.INSTANCE, "Error adding payload: " + baseEvent, LogKind.ERROR);
                    it = channelIterator;
                    if (!zAreEqual) {
                    }
                    EventPipeline.this.uploadChannel.mo12955trySendJP2dKIU(EventPipeline.UPLOAD_SIG);
                    it2 = EventPipeline.this.flushPolicies.iterator();
                    while (it2.hasNext()) {
                    }
                    this.L$0 = it;
                    this.L$1 = null;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                Iterator it3 = EventPipeline.this.flushPolicies.iterator();
                while (it3.hasNext()) {
                    ((FlushPolicy) it3.next()).updateState(baseEvent);
                }
                it = channelIterator;
                if (!zAreEqual) {
                    List list = EventPipeline.this.flushPolicies;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator it4 = list.iterator();
                        while (it4.hasNext()) {
                            if (((FlushPolicy) it4.next()).shouldFlush()) {
                                break;
                            }
                        }
                    }
                    this.L$0 = it;
                    this.L$1 = null;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                        channelIterator = it;
                        obj = objHasNext;
                        if (((Boolean) obj).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        baseEvent = (BaseEvent) channelIterator.next();
                        zAreEqual = Intrinsics.areEqual(baseEvent.getMessageId(), EventPipeline.FLUSH_POISON);
                        if (!zAreEqual) {
                            String strStringifyBaseEvent = EventPipeline.this.stringifyBaseEvent(baseEvent);
                            LoggerKt.log$default(EventPipeline.this.analytics, EventPipeline.this.logTag + " running " + strStringifyBaseEvent, null, 2, null);
                            this.L$0 = channelIterator;
                            this.L$1 = baseEvent;
                            this.Z$0 = zAreEqual;
                            this.label = 2;
                        }
                        it = channelIterator;
                        if (!zAreEqual) {
                        }
                    }
                    return coroutine_suspended;
                }
                EventPipeline.this.uploadChannel.mo12955trySendJP2dKIU(EventPipeline.UPLOAD_SIG);
                it2 = EventPipeline.this.flushPolicies.iterator();
                while (it2.hasNext()) {
                    ((FlushPolicy) it2.next()).reset();
                }
                this.L$0 = it;
                this.L$1 = null;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelIterator = channelIterator2;
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    static {
        ScreenEvent screenEvent = new ScreenEvent(FLUSH_POISON, FLUSH_POISON, EventsKt.getEmptyJsonObject());
        screenEvent.setMessageId(FLUSH_POISON);
        FLUSH_EVENT = screenEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventPipeline(Analytics analytics, String logTag, String apiKey, List<? extends FlushPolicy> flushPolicies, String apiHost) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        this.analytics = analytics;
        this.logTag = logTag;
        this.flushPolicies = flushPolicies;
        this.apiHost = apiHost;
        this.httpClient = new HTTPClient(apiKey, analytics.getConfiguration().getRequestFactory());
        this.running = false;
        this.writeChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.uploadChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        registerShutdownHook();
    }

    public /* synthetic */ EventPipeline(Analytics analytics, String str, String str2, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(analytics, str, str2, list, (i & 16) != 0 ? Constants.DEFAULT_API_HOST : str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleUploadException(Exception e, String file) {
        if (!(e instanceof HTTPException)) {
            SegmentLogKt.segmentLog(Analytics.INSTANCE, StringsKt.trimMargin$default("\n                    | Error uploading events from batch file\n                    | fileUrl=\"" + file + "\"\n                    | msg=" + e.getMessage() + "\n                ", null, 1, null), LogKind.ERROR);
            return false;
        }
        LoggerKt.log$default(this.analytics, this.logTag + " exception while uploading, " + e.getMessage(), null, 2, null);
        HTTPException hTTPException = (HTTPException) e;
        if (!hTTPException.is4xx() || hTTPException.getResponseCode() == 429) {
            SegmentLogKt.segmentLog(Analytics.INSTANCE, "Error while uploading payloads", LogKind.ERROR);
            return false;
        }
        SegmentLogKt.segmentLog(Analytics.INSTANCE, "Payloads were rejected by server. Marked for removal.", LogKind.ERROR);
        return true;
    }

    private final void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.segment.analytics.kotlin.core.platform.EventPipeline.registerShutdownHook.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                EventPipeline.this.stop();
            }
        });
    }

    private final void schedule() {
        Iterator<T> it = this.flushPolicies.iterator();
        while (it.hasNext()) {
            ((FlushPolicy) it.next()).schedule(this.analytics);
        }
    }

    private final void unschedule() {
        Iterator<T> it = this.flushPolicies.iterator();
        while (it.hasNext()) {
            ((FlushPolicy) it.next()).unschedule();
        }
    }

    private final Job upload() {
        return BuildersKt__Builders_commonKt.launch$default(getScope(), getNetworkIODispatcher(), null, new C10881(null), 2, null);
    }

    private final Job write() {
        return BuildersKt__Builders_commonKt.launch$default(getScope(), getFileIODispatcher(), null, new C10891(null), 2, null);
    }

    public final void flush() {
        this.writeChannel.mo12955trySendJP2dKIU(FLUSH_EVENT);
    }

    public final String getApiHost() {
        return this.apiHost;
    }

    protected CoroutineDispatcher getFileIODispatcher() {
        return this.analytics.getFileIODispatcher();
    }

    protected HTTPClient getHttpClient() {
        return this.httpClient;
    }

    protected CoroutineDispatcher getNetworkIODispatcher() {
        return this.analytics.getNetworkIODispatcher();
    }

    public final boolean getRunning() {
        return this.running;
    }

    protected CoroutineScope getScope() {
        return this.analytics.getAnalyticsScope();
    }

    protected Storage getStorage() {
        return this.analytics.getStorage();
    }

    public final void put(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.writeChannel.mo12955trySendJP2dKIU(event);
    }

    public final void setApiHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apiHost = str;
    }

    public final void start() {
        if (this.running) {
            return;
        }
        this.running = true;
        if (this.writeChannel.isClosedForSend() || this.writeChannel.isClosedForReceive()) {
            this.writeChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            this.uploadChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        }
        schedule();
        write();
        upload();
    }

    public final void stop() {
        if (this.running) {
            this.running = false;
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) this.uploadChannel, (CancellationException) null, 1, (Object) null);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) this.writeChannel, (CancellationException) null, 1, (Object) null);
            unschedule();
        }
    }

    public String stringifyBaseEvent(BaseEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Json encodeDefaultsJson = JsonUtils.getEncodeDefaultsJson();
        encodeDefaultsJson.getSerializersModule();
        JsonObject jsonObject = JsonElementKt.getJsonObject(encodeDefaultsJson.encodeToJsonElement(BaseEvent.INSTANCE.serializer(), payload));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (!Intrinsics.areEqual(key, "userId") || !StringsKt.isBlank(JsonElementKt.getJsonPrimitive(value).getContent())) {
                if (!Intrinsics.areEqual(key, "traits") || !Intrinsics.areEqual(value, EventsKt.getEmptyJsonObject())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Json.Companion companion = Json.INSTANCE;
        companion.getSerializersModule();
        return companion.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE), linkedHashMap);
    }
}
