package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;

/* JADX INFO: compiled from: HelpPathsSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/customercenter/HelpPathsSerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HelpPathsSerializer implements KSerializer<List<? extends CustomerCenterConfigData.HelpPath>> {
    public static final HelpPathsSerializer INSTANCE = new HelpPathsSerializer();
    private static final SerialDescriptor descriptor = BuiltinSerializersKt.ListSerializer(CustomerCenterConfigData.HelpPath.INSTANCE.serializer()).getDescriptor();

    private HelpPathsSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public List<CustomerCenterConfigData.HelpPath> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        ArrayList arrayList = new ArrayList();
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new IllegalStateException("Can be deserialized only by JSON".toString());
        }
        Iterator<JsonElement> it = JsonElementKt.getJsonArray(jsonDecoder.decodeJsonElement()).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(jsonDecoder.getJson().decodeFromJsonElement(CustomerCenterConfigData.HelpPath.INSTANCE.serializer(), it.next()));
            } catch (IllegalArgumentException e) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Issue deserializing CustomerCenter HelpPath. Ignoring. Error: " + e);
                }
            }
        }
        return arrayList;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, List<CustomerCenterConfigData.HelpPath> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        BuiltinSerializersKt.ListSerializer(CustomerCenterConfigData.HelpPath.INSTANCE.serializer()).serialize(encoder, value);
    }
}
