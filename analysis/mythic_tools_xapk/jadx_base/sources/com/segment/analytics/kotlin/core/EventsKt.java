package com.segment.analytics.kotlin.core;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007*\n\u0010\b\"\u00020\u00052\u00020\u0005*H\u0010\t\"!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0010\u000f\"\u00020\u00052\u00020\u0005*\n\u0010\u0010\"\u00020\u00052\u00020\u0005*\n\u0010\u0011\"\u00020\u00052\u00020\u0005¨\u0006\u0012"}, d2 = {"emptyJsonArray", "Lkotlinx/serialization/json/JsonArray;", "getEmptyJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "emptyJsonObject", "Lkotlinx/serialization/json/JsonObject;", "getEmptyJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "AnalyticsContext", "EnrichmentClosure", "Lkotlin/Function1;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_EVENT, "Integrations", "Properties", "Traits", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EventsKt {
    private static final JsonObject emptyJsonObject = new JsonObject(MapsKt.emptyMap());
    private static final JsonArray emptyJsonArray = new JsonArray(CollectionsKt.emptyList());

    public static final JsonArray getEmptyJsonArray() {
        return emptyJsonArray;
    }

    public static final JsonObject getEmptyJsonObject() {
        return emptyJsonObject;
    }
}
