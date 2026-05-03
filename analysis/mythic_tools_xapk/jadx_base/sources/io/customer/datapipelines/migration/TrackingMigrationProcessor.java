package io.customer.datapipelines.migration;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.IdentifyEvent;
import com.segment.analytics.kotlin.core.ScreenEvent;
import com.segment.analytics.kotlin.core.System;
import com.segment.analytics.kotlin.core.TrackEvent;
import com.segment.analytics.kotlin.core.utilities.EventTransformer;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import io.customer.datapipelines.extensions.JsonExtensionsKt;
import io.customer.datapipelines.util.SegmentInstantFormatter;
import io.customer.sdk.CustomerIO;
import io.customer.sdk.DataPipelineInstance;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import io.customer.sdk.data.store.GlobalPreferenceStore;
import io.customer.sdk.util.EventNames;
import io.customer.tracking.migration.MigrationAssistant;
import io.customer.tracking.migration.MigrationProcessor;
import io.customer.tracking.migration.request.MigrationTask;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.opencv.imgproc.Imgproc;
import sovran.kotlin.Store;
import sovran.kotlin.Subscriber;

/* JADX INFO: compiled from: TrackingMigrationProcessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006%"}, d2 = {"Lio/customer/datapipelines/migration/TrackingMigrationProcessor;", "Lio/customer/tracking/migration/MigrationProcessor;", "Lsovran/kotlin/Subscriber;", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "migrationSiteId", "", "<init>", "(Lcom/segment/analytics/kotlin/core/Analytics;Ljava/lang/String;)V", "logger", "Lio/customer/sdk/core/util/Logger;", "globalPreferenceStore", "Lio/customer/sdk/data/store/GlobalPreferenceStore;", "subscriptionID", "", "Lsovran/kotlin/SubscriptionID;", "Ljava/lang/Integer;", "start", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/segment/analytics/kotlin/core/System;", "(Lcom/segment/analytics/kotlin/core/System;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processProfileMigration", "Lkotlin/Result;", "identifier", "processProfileMigration-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "processDeviceMigration", "oldDeviceToken", "processDeviceMigration-IoAF18A", "processTask", "task", "Lio/customer/tracking/migration/request/MigrationTask;", "processTask-gIAlu-s", "(Lio/customer/tracking/migration/request/MigrationTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "MigrationEventData", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackingMigrationProcessor implements MigrationProcessor, Subscriber {
    private static final String PAYLOAD_JSON_KEY_DEVICE = "device";
    private static final String PAYLOAD_JSON_KEY_TOKEN = "token";
    private static final String PAYLOAD_JSON_KEY_TYPE = "type";
    private static final String PAYLOAD_JSON_VALUE_ANDROID = "android";
    private final Analytics analytics;
    private final GlobalPreferenceStore globalPreferenceStore;
    private final Logger logger;
    private final String migrationSiteId;
    private Integer subscriptionID;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TrackingMigrationProcessor.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012/\b\u0002\u0010\u0004\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J0\u0010\u0011\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003JD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032/\b\u0002\u0010\u0004\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR8\u0010\u0004\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/customer/datapipelines/migration/TrackingMigrationProcessor$MigrationEventData;", "", "trackEvent", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "enrichmentClosure", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/platform/EnrichmentClosure;", "<init>", "(Lcom/segment/analytics/kotlin/core/BaseEvent;Lkotlin/jvm/functions/Function1;)V", "getTrackEvent", "()Lcom/segment/analytics/kotlin/core/BaseEvent;", "getEnrichmentClosure", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class MigrationEventData {
        private final Function1<BaseEvent, BaseEvent> enrichmentClosure;
        private final BaseEvent trackEvent;

        /* JADX WARN: Multi-variable type inference failed */
        public MigrationEventData(BaseEvent trackEvent, Function1<? super BaseEvent, ? extends BaseEvent> function1) {
            Intrinsics.checkNotNullParameter(trackEvent, "trackEvent");
            this.trackEvent = trackEvent;
            this.enrichmentClosure = function1;
        }

        public /* synthetic */ MigrationEventData(BaseEvent baseEvent, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(baseEvent, (i & 2) != 0 ? null : function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MigrationEventData copy$default(MigrationEventData migrationEventData, BaseEvent baseEvent, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                baseEvent = migrationEventData.trackEvent;
            }
            if ((i & 2) != 0) {
                function1 = migrationEventData.enrichmentClosure;
            }
            return migrationEventData.copy(baseEvent, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BaseEvent getTrackEvent() {
            return this.trackEvent;
        }

        public final Function1<BaseEvent, BaseEvent> component2() {
            return this.enrichmentClosure;
        }

        public final MigrationEventData copy(BaseEvent trackEvent, Function1<? super BaseEvent, ? extends BaseEvent> enrichmentClosure) {
            Intrinsics.checkNotNullParameter(trackEvent, "trackEvent");
            return new MigrationEventData(trackEvent, enrichmentClosure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MigrationEventData)) {
                return false;
            }
            MigrationEventData migrationEventData = (MigrationEventData) other;
            return Intrinsics.areEqual(this.trackEvent, migrationEventData.trackEvent) && Intrinsics.areEqual(this.enrichmentClosure, migrationEventData.enrichmentClosure);
        }

        public final Function1<BaseEvent, BaseEvent> getEnrichmentClosure() {
            return this.enrichmentClosure;
        }

        public final BaseEvent getTrackEvent() {
            return this.trackEvent;
        }

        public int hashCode() {
            int iHashCode = this.trackEvent.hashCode() * 31;
            Function1<BaseEvent, BaseEvent> function1 = this.enrichmentClosure;
            return iHashCode + (function1 == null ? 0 : function1.hashCode());
        }

        public String toString() {
            return "MigrationEventData(trackEvent=" + this.trackEvent + ", enrichmentClosure=" + this.enrichmentClosure + ")";
        }
    }

    /* JADX INFO: renamed from: io.customer.datapipelines.migration.TrackingMigrationProcessor$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackingMigrationProcessor.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.datapipelines.migration.TrackingMigrationProcessor", f = "TrackingMigrationProcessor.kt", i = {}, l = {Imgproc.COLOR_Luv2LRGB}, m = "start", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackingMigrationProcessor.this.start(null, this);
        }
    }

    public TrackingMigrationProcessor(Analytics analytics, String migrationSiteId) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(migrationSiteId, "migrationSiteId");
        this.analytics = analytics;
        this.migrationSiteId = migrationSiteId;
        this.logger = SDKComponent.INSTANCE.getLogger();
        this.globalPreferenceStore = SDKComponent.INSTANCE.android().getGlobalPreferenceStore();
        BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), null, null, new TrackingMigrationProcessor$1$1(analytics, this, null), 3, null);
    }

    static final BaseEvent processDeviceMigration_IoAF18A$lambda$9$lambda$8(String str, BaseEvent baseEvent) {
        if (baseEvent != null) {
            Json.INSTANCE.getSerializersModule();
            EventTransformer.putInContextUnderKey(baseEvent, "device", PAYLOAD_JSON_KEY_TOKEN, str, StringSerializer.INSTANCE);
        }
        if (baseEvent == null) {
            return null;
        }
        Json.INSTANCE.getSerializersModule();
        return EventTransformer.putInContextUnderKey(baseEvent, "device", "type", "android", StringSerializer.INSTANCE);
    }

    static final BaseEvent processTask_gIAlu_s$lambda$21$lambda$14(MigrationTask migrationTask, BaseEvent baseEvent) {
        if (baseEvent != null) {
            String token = ((MigrationTask.RegisterDeviceToken) migrationTask).getToken();
            Json.INSTANCE.getSerializersModule();
            EventTransformer.putInContextUnderKey(baseEvent, "device", PAYLOAD_JSON_KEY_TOKEN, token, StringSerializer.INSTANCE);
        }
        if (baseEvent == null) {
            return null;
        }
        Json.INSTANCE.getSerializersModule();
        return EventTransformer.putInContextUnderKey(baseEvent, "device", "type", "android", StringSerializer.INSTANCE);
    }

    static final BaseEvent processTask_gIAlu_s$lambda$21$lambda$17(MigrationTask migrationTask, BaseEvent baseEvent) {
        if (baseEvent != null) {
            String token = ((MigrationTask.DeletePushToken) migrationTask).getToken();
            Json.INSTANCE.getSerializersModule();
            EventTransformer.putInContextUnderKey(baseEvent, "device", PAYLOAD_JSON_KEY_TOKEN, token, StringSerializer.INSTANCE);
        }
        if (baseEvent == null) {
            return null;
        }
        Json.INSTANCE.getSerializersModule();
        return EventTransformer.putInContextUnderKey(baseEvent, "device", "type", "android", StringSerializer.INSTANCE);
    }

    static final Unit processTask_gIAlu_s$lambda$21$lambda$19(MigrationEventData migrationEventData, MigrationTask migrationTask, TrackingMigrationProcessor trackingMigrationProcessor, BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1<BaseEvent, BaseEvent> enrichmentClosure = migrationEventData.getEnrichmentClosure();
        if (enrichmentClosure != null) {
            enrichmentClosure.invoke(event);
        }
        event.setUserId(migrationTask.getIdentifier());
        String strFrom = SegmentInstantFormatter.INSTANCE.from(migrationTask.getTimestamp());
        if (strFrom != null) {
            event.setTimestamp(strFrom);
        }
        Logger.DefaultImpls.debug$default(trackingMigrationProcessor.logger, "forwarding migrated event: " + event, null, 2, null);
        return Unit.INSTANCE;
    }

    static final BaseEvent processTask_gIAlu_s$lambda$21$lambda$20(Function1 function1, BaseEvent baseEvent) {
        if (baseEvent == null) {
            return null;
        }
        function1.invoke(baseEvent);
        return baseEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object start(System system, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM11445constructorimpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object obj = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!system.getRunning()) {
                return Unit.INSTANCE;
            }
            synchronized (this) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    TrackingMigrationProcessor trackingMigrationProcessor = this;
                    objM11445constructorimpl = Result.m11445constructorimpl(MigrationAssistant.INSTANCE.start(this, this.migrationSiteId));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
                if (thM11448exceptionOrNullimpl != null) {
                    Logger.DefaultImpls.error$default(this.logger, "Migration failed with exception: " + thM11448exceptionOrNullimpl, null, null, 6, null);
                }
            }
            Integer num = this.subscriptionID;
            if (num != null) {
                int iIntValue = num.intValue();
                Store store = this.analytics.getStore();
                anonymousClass12.label = 1;
                if (store.unsubscribe(iIntValue, anonymousClass12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.subscriptionID = null;
        return Unit.INSTANCE;
    }

    @Override // io.customer.tracking.migration.MigrationProcessor
    /* JADX INFO: renamed from: processDeviceMigration-IoAF18A, reason: not valid java name */
    public Object mo11433processDeviceMigrationIoAF18A(final String oldDeviceToken) {
        Intrinsics.checkNotNullParameter(oldDeviceToken, "oldDeviceToken");
        try {
            Result.Companion companion = Result.INSTANCE;
            TrackingMigrationProcessor trackingMigrationProcessor = this;
            String deviceToken = this.globalPreferenceStore.getDeviceToken();
            if (deviceToken == null) {
                Logger.DefaultImpls.debug$default(this.logger, "Migrating existing device with token: " + oldDeviceToken, null, 2, null);
                CustomerIO.INSTANCE.instance().registerDeviceToken(oldDeviceToken);
            } else {
                boolean zAreEqual = Intrinsics.areEqual(deviceToken, oldDeviceToken);
                Logger logger = this.logger;
                if (zAreEqual) {
                    Logger.DefaultImpls.debug$default(logger, "Device token already migrated: " + oldDeviceToken, null, 2, null);
                } else {
                    Logger.DefaultImpls.debug$default(logger, "Device token refreshed, deleting old device token from migration: " + oldDeviceToken, null, 2, null);
                    JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                    JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                    JsonElementBuildersKt.put(jsonObjectBuilder2, PAYLOAD_JSON_KEY_TOKEN, oldDeviceToken);
                    JsonElementBuildersKt.put(jsonObjectBuilder2, "type", "android");
                    Unit unit = Unit.INSTANCE;
                    jsonObjectBuilder.put("device", jsonObjectBuilder2.build());
                    this.analytics.process(new TrackEvent(jsonObjectBuilder.build(), EventNames.DEVICE_DELETE), new Function1() { // from class: io.customer.datapipelines.migration.TrackingMigrationProcessor$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TrackingMigrationProcessor.processDeviceMigration_IoAF18A$lambda$9$lambda$8(oldDeviceToken, (BaseEvent) obj);
                        }
                    });
                }
            }
            return Result.m11445constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.customer.tracking.migration.MigrationProcessor
    /* JADX INFO: renamed from: processProfileMigration-IoAF18A, reason: not valid java name */
    public Object mo11434processProfileMigrationIoAF18A(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        try {
            Result.Companion companion = Result.INSTANCE;
            TrackingMigrationProcessor trackingMigrationProcessor = this;
            String strUserId = this.analytics.userId();
            if (strUserId != null) {
                Logger.DefaultImpls.error$default(this.logger, "User already identified with userId: " + strUserId + ", skipping migration profile for: " + identifier, null, null, 6, null);
            } else {
                DataPipelineInstance.identify$default(CustomerIO.INSTANCE.instance(), identifier, null, 2, null);
            }
            return Result.m11445constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.customer.tracking.migration.MigrationProcessor
    /* JADX INFO: renamed from: processTask-gIAlu-s, reason: not valid java name */
    public Object mo11435processTaskgIAlus(final MigrationTask migrationTask, Continuation<? super Result<Unit>> continuation) {
        MigrationEventData migrationEventData;
        final MigrationEventData migrationEventData2;
        TrackEvent trackEvent;
        try {
            Result.Companion companion = Result.INSTANCE;
            TrackingMigrationProcessor trackingMigrationProcessor = this;
            int i = 2;
            Function1 function1 = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            if (migrationTask instanceof MigrationTask.IdentifyProfile) {
                migrationEventData2 = new MigrationEventData(new IdentifyEvent(((MigrationTask.IdentifyProfile) migrationTask).getIdentifier(), JsonExtensionsKt.toJsonObject(((MigrationTask.IdentifyProfile) migrationTask).getAttributes())), function1, i, objArr7 == true ? 1 : 0);
            } else if (migrationTask instanceof MigrationTask.TrackEvent) {
                if (Intrinsics.areEqual(((MigrationTask.TrackEvent) migrationTask).getType(), AndroidContextPlugin.SCREEN_KEY)) {
                    trackEvent = new ScreenEvent(((MigrationTask.TrackEvent) migrationTask).getEvent(), "", JsonExtensionsKt.toJsonObject(((MigrationTask.TrackEvent) migrationTask).getProperties()));
                } else {
                    trackEvent = new TrackEvent(JsonExtensionsKt.toJsonObject(((MigrationTask.TrackEvent) migrationTask).getProperties()), ((MigrationTask.TrackEvent) migrationTask).getEvent());
                }
                migrationEventData2 = new MigrationEventData(trackEvent, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
            } else if (migrationTask instanceof MigrationTask.TrackPushMetric) {
                JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                JsonElementBuildersKt.put(jsonObjectBuilder, "recipient", ((MigrationTask.TrackPushMetric) migrationTask).getDeviceToken());
                JsonElementBuildersKt.put(jsonObjectBuilder, "deliveryId", ((MigrationTask.TrackPushMetric) migrationTask).getDeliveryId());
                JsonElementBuildersKt.put(jsonObjectBuilder, "metric", ((MigrationTask.TrackPushMetric) migrationTask).getEvent());
                migrationEventData2 = new MigrationEventData(new TrackEvent(jsonObjectBuilder.build(), EventNames.METRIC_DELIVERY), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
            } else if (migrationTask instanceof MigrationTask.TrackDeliveryEvent) {
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                JsonUtils.putAll(jsonObjectBuilder2, JsonExtensionsKt.toJsonObject(((MigrationTask.TrackDeliveryEvent) migrationTask).getMetadata()));
                JsonElementBuildersKt.put(jsonObjectBuilder2, "deliveryId", ((MigrationTask.TrackDeliveryEvent) migrationTask).getDeliveryId());
                JsonElementBuildersKt.put(jsonObjectBuilder2, "metric", ((MigrationTask.TrackDeliveryEvent) migrationTask).getEvent());
                migrationEventData2 = new MigrationEventData(new TrackEvent(jsonObjectBuilder2.build(), EventNames.METRIC_DELIVERY), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
            } else {
                if (migrationTask instanceof MigrationTask.RegisterDeviceToken) {
                    JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
                    JsonUtils.putAll(jsonObjectBuilder3, JsonExtensionsKt.toJsonObject(((MigrationTask.RegisterDeviceToken) migrationTask).getAttributes()));
                    JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
                    JsonElementBuildersKt.put(jsonObjectBuilder4, PAYLOAD_JSON_KEY_TOKEN, ((MigrationTask.RegisterDeviceToken) migrationTask).getToken());
                    JsonElementBuildersKt.put(jsonObjectBuilder4, "type", "android");
                    Unit unit = Unit.INSTANCE;
                    jsonObjectBuilder3.put("device", jsonObjectBuilder4.build());
                    migrationEventData = new MigrationEventData(new TrackEvent(jsonObjectBuilder3.build(), EventNames.DEVICE_UPDATE), new Function1() { // from class: io.customer.datapipelines.migration.TrackingMigrationProcessor$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TrackingMigrationProcessor.processTask_gIAlu_s$lambda$21$lambda$14(migrationTask, (BaseEvent) obj);
                        }
                    });
                } else {
                    if (!(migrationTask instanceof MigrationTask.DeletePushToken)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    JsonObjectBuilder jsonObjectBuilder5 = new JsonObjectBuilder();
                    JsonObjectBuilder jsonObjectBuilder6 = new JsonObjectBuilder();
                    JsonElementBuildersKt.put(jsonObjectBuilder6, PAYLOAD_JSON_KEY_TOKEN, ((MigrationTask.DeletePushToken) migrationTask).getToken());
                    JsonElementBuildersKt.put(jsonObjectBuilder6, "type", "android");
                    Unit unit2 = Unit.INSTANCE;
                    jsonObjectBuilder5.put("device", jsonObjectBuilder6.build());
                    migrationEventData = new MigrationEventData(new TrackEvent(jsonObjectBuilder5.build(), EventNames.DEVICE_DELETE), new Function1() { // from class: io.customer.datapipelines.migration.TrackingMigrationProcessor$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TrackingMigrationProcessor.processTask_gIAlu_s$lambda$21$lambda$17(migrationTask, (BaseEvent) obj);
                        }
                    });
                }
                migrationEventData2 = migrationEventData;
            }
            Logger.DefaultImpls.debug$default(this.logger, "processing migrated task: " + migrationEventData2, null, 2, null);
            final Function1 function12 = new Function1() { // from class: io.customer.datapipelines.migration.TrackingMigrationProcessor$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TrackingMigrationProcessor.processTask_gIAlu_s$lambda$21$lambda$19(migrationEventData2, migrationTask, this, (BaseEvent) obj);
                }
            };
            this.analytics.process(migrationEventData2.getTrackEvent(), new Function1() { // from class: io.customer.datapipelines.migration.TrackingMigrationProcessor$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TrackingMigrationProcessor.processTask_gIAlu_s$lambda$21$lambda$20(function12, (BaseEvent) obj);
                }
            });
            return Result.m11445constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
    }
}
