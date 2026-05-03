package com.segment.analytics.kotlin.core.utilities;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* JADX INFO: compiled from: AnySerializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"JsonAnySerializer", "Lkotlinx/serialization/json/Json;", "getJsonAnySerializer", "()Lkotlinx/serialization/json/Json;", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnySerializerKt {
    private static final Json JsonAnySerializer = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.AnySerializerKt$JsonAnySerializer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
            serializersModuleBuilder.contextual(Reflection.getOrCreateKotlinClass(Object.class), new Function1<List<? extends KSerializer<?>>, KSerializer<?>>() { // from class: com.segment.analytics.kotlin.core.utilities.AnySerializerKt$JsonAnySerializer$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public final KSerializer<?> invoke(List<? extends KSerializer<?>> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return AnySerializer.INSTANCE;
                }
            });
            Json.setSerializersModule(serializersModuleBuilder.build());
        }
    }, 1, null);

    public static final Json getJsonAnySerializer() {
        return JsonAnySerializer;
    }
}
