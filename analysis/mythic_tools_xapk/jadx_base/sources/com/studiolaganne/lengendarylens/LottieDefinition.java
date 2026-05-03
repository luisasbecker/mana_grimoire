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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019JH\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/LottieDefinition;", "", "file", "", "alpha", "", "scale", "speed", "loop", "", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFile", "()Ljava/lang/String;", "getAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScale", "getSpeed", "getLoop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/LottieDefinition;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class LottieDefinition {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Float alpha;
    private final String file;
    private final Boolean loop;
    private final Float scale;
    private final Float speed;

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/LottieDefinition$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/studiolaganne/lengendarylens/LottieDefinition;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<LottieDefinition> serializer() {
            return LottieDefinition$$serializer.INSTANCE;
        }
    }

    public LottieDefinition() {
        this((String) null, (Float) null, (Float) null, (Float) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ LottieDefinition(int i, String str, Float f, Float f2, Float f3, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        this.file = (i & 1) == 0 ? "" : str;
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
    }

    public LottieDefinition(String file, Float f, Float f2, Float f3, Boolean bool) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.alpha = f;
        this.scale = f2;
        this.speed = f3;
        this.loop = bool;
    }

    public /* synthetic */ LottieDefinition(String str, Float f, Float f2, Float f3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Float.valueOf(1.0f) : f, (i & 4) != 0 ? Float.valueOf(1.0f) : f2, (i & 8) != 0 ? Float.valueOf(1.0f) : f3, (i & 16) != 0 ? false : bool);
    }

    public static /* synthetic */ LottieDefinition copy$default(LottieDefinition lottieDefinition, String str, Float f, Float f2, Float f3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lottieDefinition.file;
        }
        if ((i & 2) != 0) {
            f = lottieDefinition.alpha;
        }
        if ((i & 4) != 0) {
            f2 = lottieDefinition.scale;
        }
        if ((i & 8) != 0) {
            f3 = lottieDefinition.speed;
        }
        if ((i & 16) != 0) {
            bool = lottieDefinition.loop;
        }
        Boolean bool2 = bool;
        Float f4 = f2;
        return lottieDefinition.copy(str, f, f4, f3, bool2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(LottieDefinition self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.file, "")) {
            output.encodeStringElement(serialDesc, 0, self.file);
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
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Intrinsics.areEqual((Object) self.loop, (Object) false)) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.loop);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile() {
        return this.file;
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

    public final LottieDefinition copy(String file, Float alpha, Float scale, Float speed, Boolean loop) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new LottieDefinition(file, alpha, scale, speed, loop);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LottieDefinition)) {
            return false;
        }
        LottieDefinition lottieDefinition = (LottieDefinition) other;
        return Intrinsics.areEqual(this.file, lottieDefinition.file) && Intrinsics.areEqual((Object) this.alpha, (Object) lottieDefinition.alpha) && Intrinsics.areEqual((Object) this.scale, (Object) lottieDefinition.scale) && Intrinsics.areEqual((Object) this.speed, (Object) lottieDefinition.speed) && Intrinsics.areEqual(this.loop, lottieDefinition.loop);
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

    public int hashCode() {
        int iHashCode = this.file.hashCode() * 31;
        Float f = this.alpha;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.scale;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.speed;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Boolean bool = this.loop;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "LottieDefinition(file=" + this.file + ", alpha=" + this.alpha + ", scale=" + this.scale + ", speed=" + this.speed + ", loop=" + this.loop + ")";
    }
}
