package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003JR\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/LowLifeAnimDefinition;", "", "type", "", "alpha", "", "scale", "speed", "loop", "", "file", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScale", "getSpeed", "getLoop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFile", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/LowLifeAnimDefinition;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class LowLifeAnimDefinition {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Float alpha;
    private final String file;
    private final Boolean loop;
    private final Float scale;
    private final Float speed;
    private final String type;

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/LowLifeAnimDefinition$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/studiolaganne/lengendarylens/LowLifeAnimDefinition;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<LowLifeAnimDefinition> serializer() {
            return LowLifeAnimDefinition$$serializer.INSTANCE;
        }
    }

    public LowLifeAnimDefinition() {
        this((String) null, (Float) null, (Float) null, (Float) null, (Boolean) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ LowLifeAnimDefinition(int i, String str, Float f, Float f2, Float f3, Boolean bool, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.type = "";
        } else {
            this.type = str;
        }
        if ((i & 2) == 0) {
            this.alpha = Float.valueOf(1.0f);
        } else {
            this.alpha = f;
        }
        if ((i & 4) == 0) {
            this.scale = Float.valueOf(1.0f);
        } else {
            this.scale = f2;
        }
        if ((i & 8) == 0) {
            this.speed = Float.valueOf(1.0f);
        } else {
            this.speed = f3;
        }
        if ((i & 16) == 0) {
            this.loop = false;
        } else {
            this.loop = bool;
        }
        if ((i & 32) == 0) {
            this.file = "";
        } else {
            this.file = str2;
        }
    }

    public LowLifeAnimDefinition(String type, Float f, Float f2, Float f3, Boolean bool, String file) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(file, "file");
        this.type = type;
        this.alpha = f;
        this.scale = f2;
        this.speed = f3;
        this.loop = bool;
        this.file = file;
    }

    public /* synthetic */ LowLifeAnimDefinition(String str, Float f, Float f2, Float f3, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Float.valueOf(1.0f) : f, (i & 4) != 0 ? Float.valueOf(1.0f) : f2, (i & 8) != 0 ? Float.valueOf(1.0f) : f3, (i & 16) != 0 ? false : bool, (i & 32) != 0 ? "" : str2);
    }

    public static /* synthetic */ LowLifeAnimDefinition copy$default(LowLifeAnimDefinition lowLifeAnimDefinition, String str, Float f, Float f2, Float f3, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lowLifeAnimDefinition.type;
        }
        if ((i & 2) != 0) {
            f = lowLifeAnimDefinition.alpha;
        }
        if ((i & 4) != 0) {
            f2 = lowLifeAnimDefinition.scale;
        }
        if ((i & 8) != 0) {
            f3 = lowLifeAnimDefinition.speed;
        }
        if ((i & 16) != 0) {
            bool = lowLifeAnimDefinition.loop;
        }
        if ((i & 32) != 0) {
            str2 = lowLifeAnimDefinition.file;
        }
        Boolean bool2 = bool;
        String str3 = str2;
        return lowLifeAnimDefinition.copy(str, f, f2, f3, bool2, str3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(LowLifeAnimDefinition self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.type, "")) {
            output.encodeStringElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual((Object) self.alpha, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 1, FloatSerializer.INSTANCE, self.alpha);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual((Object) self.scale, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 2, FloatSerializer.INSTANCE, self.scale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual((Object) self.speed, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 3, FloatSerializer.INSTANCE, self.speed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual((Object) self.loop, (Object) false)) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.loop);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.file, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 5, self.file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getSpeed() {
        return this.speed;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getLoop() {
        return this.loop;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final LowLifeAnimDefinition copy(String type, Float alpha, Float scale, Float speed, Boolean loop, String file) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(file, "file");
        return new LowLifeAnimDefinition(type, alpha, scale, speed, loop, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LowLifeAnimDefinition)) {
            return false;
        }
        LowLifeAnimDefinition lowLifeAnimDefinition = (LowLifeAnimDefinition) other;
        return Intrinsics.areEqual(this.type, lowLifeAnimDefinition.type) && Intrinsics.areEqual((Object) this.alpha, (Object) lowLifeAnimDefinition.alpha) && Intrinsics.areEqual((Object) this.scale, (Object) lowLifeAnimDefinition.scale) && Intrinsics.areEqual((Object) this.speed, (Object) lowLifeAnimDefinition.speed) && Intrinsics.areEqual(this.loop, lowLifeAnimDefinition.loop) && Intrinsics.areEqual(this.file, lowLifeAnimDefinition.file);
    }

    public final Float getAlpha() {
        return this.alpha;
    }

    public final String getFile() {
        return this.file;
    }

    public final Boolean getLoop() {
        return this.loop;
    }

    public final Float getScale() {
        return this.scale;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Float f = this.alpha;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.scale;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.speed;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Boolean bool = this.loop;
        return ((iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "LowLifeAnimDefinition(type=" + this.type + ", alpha=" + this.alpha + ", scale=" + this.scale + ", speed=" + this.speed + ", loop=" + this.loop + ", file=" + this.file + ")";
    }
}
