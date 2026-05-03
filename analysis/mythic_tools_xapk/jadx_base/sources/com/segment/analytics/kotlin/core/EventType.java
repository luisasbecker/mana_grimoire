package com.segment.analytics.kotlin.core;

import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/segment/analytics/kotlin/core/EventType;", "", "(Ljava/lang/String;I)V", "Track", "Screen", "Alias", "Identify", "Group", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public enum EventType {
    Track,
    Screen,
    Alias,
    Identify,
    Group;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.segment.analytics.kotlin.core.EventType$Companion$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return EnumsKt.createMarkedEnumSerializer("com.segment.analytics.kotlin.core.EventType", EventType.values(), new String[]{"track", AndroidContextPlugin.SCREEN_KEY, "alias", "identify", "group"}, new Annotation[][]{null, null, null, null, null});
        }
    });

    /* JADX INFO: compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/EventType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/EventType;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return EventType.$cachedSerializer$delegate;
        }

        public final KSerializer<EventType> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }
}
