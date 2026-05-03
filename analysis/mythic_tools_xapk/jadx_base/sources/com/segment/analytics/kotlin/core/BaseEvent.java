package com.segment.analytics.kotlin.core;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.segment.analytics.kotlin.core.utilities.SegmentInstant;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonObject;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J<\u00103\u001a\u0002042-\u0010\u0016\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0017j\u0004\u0018\u0001`\u001bH\u0000¢\u0006\u0002\b5J\u001b\u00106\u001a\u0002042\u0006\u00107\u001a\u000208H\u0080@ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u0002H<\"\b\b\u0000\u0010<*\u00020\u0000¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010A\u001a\u00020BH\u0016R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RA\u0010\u0016\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0017j\u0004\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00060\u0010j\u0002`!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u0018\u0010$\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u0018\u0010'\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u0018\u0010*\u001a\u00020+X¦\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00100\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000e\u0082\u0001\u0005DEFGH\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Lcom/segment/analytics/kotlin/core/BaseEvent;", "", "()V", "_metadata", "Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "get_metadata", "()Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "set_metadata", "(Lcom/segment/analytics/kotlin/core/DestinationMetadata;)V", "anonymousId", "", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "(Ljava/lang/String;)V", "context", "Lkotlinx/serialization/json/JsonObject;", "Lcom/segment/analytics/kotlin/core/AnalyticsContext;", "getContext", "()Lkotlinx/serialization/json/JsonObject;", "setContext", "(Lkotlinx/serialization/json/JsonObject;)V", "enrichment", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/EnrichmentClosure;", "getEnrichment", "()Lkotlin/jvm/functions/Function1;", "setEnrichment", "(Lkotlin/jvm/functions/Function1;)V", "integrations", "Lcom/segment/analytics/kotlin/core/Integrations;", "getIntegrations", "setIntegrations", "messageId", "getMessageId", "setMessageId", DiagnosticsEntry.TIMESTAMP_KEY, "getTimestamp", "setTimestamp", "type", "Lcom/segment/analytics/kotlin/core/EventType;", "getType", "()Lcom/segment/analytics/kotlin/core/EventType;", "setType", "(Lcom/segment/analytics/kotlin/core/EventType;)V", "userId", "getUserId", "setUserId", "applyBaseData", "", "applyBaseData$core", "applyBaseEventData", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "applyBaseEventData$core", "(Lsovran/kotlin/Store;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copy", ExifInterface.GPS_DIRECTION_TRUE, "()Lcom/segment/analytics/kotlin/core/BaseEvent;", "equals", "", "other", "hashCode", "", "Companion", "Lcom/segment/analytics/kotlin/core/AliasEvent;", "Lcom/segment/analytics/kotlin/core/GroupEvent;", "Lcom/segment/analytics/kotlin/core/IdentifyEvent;", "Lcom/segment/analytics/kotlin/core/ScreenEvent;", "Lcom/segment/analytics/kotlin/core/TrackEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable(with = BaseEventSerializer.class)
public abstract class BaseEvent {
    public static final String ALL_INTEGRATIONS_KEY = "All";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Function1<? super BaseEvent, ? extends BaseEvent> enrichment;

    /* JADX INFO: compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/segment/analytics/kotlin/core/BaseEvent$Companion;", "", "()V", "ALL_INTEGRATIONS_KEY", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BaseEvent> serializer() {
            return BaseEventSerializer.INSTANCE;
        }
    }

    private BaseEvent() {
    }

    public /* synthetic */ BaseEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void applyBaseData$core(Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        this.enrichment = enrichment;
        setTimestamp(SegmentInstant.INSTANCE.now());
        setContext(EventsKt.getEmptyJsonObject());
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        setMessageId(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object applyBaseEventData$core(Store store, Continuation<? super Unit> continuation) {
        BaseEvent$applyBaseEventData$1 baseEvent$applyBaseEventData$1;
        if (continuation instanceof BaseEvent$applyBaseEventData$1) {
            baseEvent$applyBaseEventData$1 = (BaseEvent$applyBaseEventData$1) continuation;
            if ((baseEvent$applyBaseEventData$1.label & Integer.MIN_VALUE) != 0) {
                baseEvent$applyBaseEventData$1.label -= Integer.MIN_VALUE;
            } else {
                baseEvent$applyBaseEventData$1 = new BaseEvent$applyBaseEventData$1(this, continuation);
            }
        }
        Object objCurrentState = baseEvent$applyBaseEventData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = baseEvent$applyBaseEventData$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCurrentState);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(UserInfo.class);
            baseEvent$applyBaseEventData$1.L$0 = this;
            baseEvent$applyBaseEventData$1.label = 1;
            objCurrentState = store.currentState(orCreateKotlinClass, baseEvent$applyBaseEventData$1);
            if (objCurrentState == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (BaseEvent) baseEvent$applyBaseEventData$1.L$0;
            ResultKt.throwOnFailure(objCurrentState);
        }
        UserInfo userInfo = (UserInfo) objCurrentState;
        if (userInfo == null) {
            return Unit.INSTANCE;
        }
        this.setAnonymousId(userInfo.getAnonymousId());
        this.setIntegrations(EventsKt.getEmptyJsonObject());
        if (StringsKt.isBlank(this.getUserId())) {
            String userId = userInfo.getUserId();
            if (userId == null) {
                userId = "";
            }
            this.setUserId(userId);
        }
        return Unit.INSTANCE;
    }

    public final <T extends BaseEvent> T copy() {
        TrackEvent trackEvent;
        if (this instanceof AliasEvent) {
            trackEvent = new AliasEvent(getUserId(), ((AliasEvent) this).getPreviousId());
        } else if (this instanceof GroupEvent) {
            GroupEvent groupEvent = (GroupEvent) this;
            trackEvent = new GroupEvent(groupEvent.getGroupId(), groupEvent.getTraits());
        } else if (this instanceof IdentifyEvent) {
            trackEvent = new IdentifyEvent(getUserId(), ((IdentifyEvent) this).getTraits());
        } else if (this instanceof ScreenEvent) {
            ScreenEvent screenEvent = (ScreenEvent) this;
            trackEvent = new ScreenEvent(screenEvent.getName(), screenEvent.getCategory(), screenEvent.getProperties());
        } else {
            if (!(this instanceof TrackEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            TrackEvent trackEvent2 = (TrackEvent) this;
            trackEvent = new TrackEvent(trackEvent2.getProperties(), trackEvent2.getEvent());
        }
        trackEvent.setAnonymousId(getAnonymousId());
        trackEvent.setMessageId(getMessageId());
        trackEvent.setTimestamp(getTimestamp());
        trackEvent.setContext(getContext());
        trackEvent.setIntegrations(getIntegrations());
        trackEvent.setUserId(getUserId());
        trackEvent.set_metadata(get_metadata());
        trackEvent.enrichment = this.enrichment;
        return trackEvent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.segment.analytics.kotlin.core.BaseEvent");
        BaseEvent baseEvent = (BaseEvent) other;
        return getType() == baseEvent.getType() && Intrinsics.areEqual(getAnonymousId(), baseEvent.getAnonymousId()) && Intrinsics.areEqual(getMessageId(), baseEvent.getMessageId()) && Intrinsics.areEqual(getTimestamp(), baseEvent.getTimestamp()) && Intrinsics.areEqual(getContext(), baseEvent.getContext()) && Intrinsics.areEqual(getIntegrations(), baseEvent.getIntegrations()) && Intrinsics.areEqual(getUserId(), baseEvent.getUserId()) && Intrinsics.areEqual(get_metadata(), baseEvent.get_metadata());
    }

    public abstract String getAnonymousId();

    public abstract JsonObject getContext();

    public final Function1<BaseEvent, BaseEvent> getEnrichment() {
        return this.enrichment;
    }

    public abstract JsonObject getIntegrations();

    public abstract String getMessageId();

    public abstract String getTimestamp();

    public abstract EventType getType();

    public abstract String getUserId();

    public abstract DestinationMetadata get_metadata();

    public int hashCode() {
        return (((((((((((((getType().hashCode() * 31) + getAnonymousId().hashCode()) * 31) + getMessageId().hashCode()) * 31) + getTimestamp().hashCode()) * 31) + getContext().hashCode()) * 31) + getIntegrations().hashCode()) * 31) + getUserId().hashCode()) * 31) + get_metadata().hashCode();
    }

    public abstract void setAnonymousId(String str);

    public abstract void setContext(JsonObject jsonObject);

    public final void setEnrichment(Function1<? super BaseEvent, ? extends BaseEvent> function1) {
        this.enrichment = function1;
    }

    public abstract void setIntegrations(JsonObject jsonObject);

    public abstract void setMessageId(String str);

    public abstract void setTimestamp(String str);

    public abstract void setType(EventType eventType);

    public abstract void setUserId(String str);

    public abstract void set_metadata(DestinationMetadata destinationMetadata);
}
