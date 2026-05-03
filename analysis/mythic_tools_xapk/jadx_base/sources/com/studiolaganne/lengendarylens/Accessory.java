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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JF\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/Accessory;", "", "type", "", "scale", "", "xOffset", "yOffset", "file", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getXOffset", "getYOffset", "getFile", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/Accessory;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class Accessory {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String file;
    private final Float scale;
    private final String type;
    private final Float xOffset;
    private final Float yOffset;

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/Accessory$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/studiolaganne/lengendarylens/Accessory;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Accessory> serializer() {
            return Accessory$$serializer.INSTANCE;
        }
    }

    public Accessory() {
        this((String) null, (Float) null, (Float) null, (Float) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ Accessory(int i, String str, Float f, Float f2, Float f3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.type = "";
        } else {
            this.type = str;
        }
        if ((i & 2) == 0) {
            this.scale = Float.valueOf(1.0f);
        } else {
            this.scale = f;
        }
        if ((i & 4) == 0) {
            this.xOffset = Float.valueOf(0.0f);
        } else {
            this.xOffset = f2;
        }
        if ((i & 8) == 0) {
            this.yOffset = Float.valueOf(0.0f);
        } else {
            this.yOffset = f3;
        }
        if ((i & 16) == 0) {
            this.file = "";
        } else {
            this.file = str2;
        }
    }

    public Accessory(String type, Float f, Float f2, Float f3, String file) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(file, "file");
        this.type = type;
        this.scale = f;
        this.xOffset = f2;
        this.yOffset = f3;
        this.file = file;
    }

    public /* synthetic */ Accessory(String str, Float f, Float f2, Float f3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Float.valueOf(1.0f) : f, (i & 4) != 0 ? Float.valueOf(0.0f) : f2, (i & 8) != 0 ? Float.valueOf(0.0f) : f3, (i & 16) != 0 ? "" : str2);
    }

    public static /* synthetic */ Accessory copy$default(Accessory accessory, String str, Float f, Float f2, Float f3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accessory.type;
        }
        if ((i & 2) != 0) {
            f = accessory.scale;
        }
        if ((i & 4) != 0) {
            f2 = accessory.xOffset;
        }
        if ((i & 8) != 0) {
            f3 = accessory.yOffset;
        }
        if ((i & 16) != 0) {
            str2 = accessory.file;
        }
        String str3 = str2;
        Float f4 = f2;
        return accessory.copy(str, f, f4, f3, str3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(Accessory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.type, "")) {
            output.encodeStringElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual((Object) self.scale, (Object) Float.valueOf(1.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 1, FloatSerializer.INSTANCE, self.scale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual((Object) self.xOffset, (Object) Float.valueOf(0.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 2, FloatSerializer.INSTANCE, self.xOffset);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual((Object) self.yOffset, (Object) Float.valueOf(0.0f))) {
            output.encodeNullableSerializableElement(serialDesc, 3, FloatSerializer.INSTANCE, self.yOffset);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Intrinsics.areEqual(self.file, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 4, self.file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getXOffset() {
        return this.xOffset;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getYOffset() {
        return this.yOffset;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final Accessory copy(String type, Float scale, Float xOffset, Float yOffset, String file) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(file, "file");
        return new Accessory(type, scale, xOffset, yOffset, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Accessory)) {
            return false;
        }
        Accessory accessory = (Accessory) other;
        return Intrinsics.areEqual(this.type, accessory.type) && Intrinsics.areEqual((Object) this.scale, (Object) accessory.scale) && Intrinsics.areEqual((Object) this.xOffset, (Object) accessory.xOffset) && Intrinsics.areEqual((Object) this.yOffset, (Object) accessory.yOffset) && Intrinsics.areEqual(this.file, accessory.file);
    }

    public final String getFile() {
        return this.file;
    }

    public final Float getScale() {
        return this.scale;
    }

    public final String getType() {
        return this.type;
    }

    public final Float getXOffset() {
        return this.xOffset;
    }

    public final Float getYOffset() {
        return this.yOffset;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Float f = this.scale;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.xOffset;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.yOffset;
        return ((iHashCode3 + (f3 != null ? f3.hashCode() : 0)) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "Accessory(type=" + this.type + ", scale=" + this.scale + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", file=" + this.file + ")";
    }
}
