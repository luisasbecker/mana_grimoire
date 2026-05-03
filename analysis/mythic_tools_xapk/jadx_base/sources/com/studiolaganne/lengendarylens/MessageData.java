package com.studiolaganne.lengendarylens;

import androidx.media3.common.MimeTypes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessageData;", "", MimeTypes.BASE_TYPE_IMAGE, "", "text", "color", "imagePlacement", "animation", "Lcom/studiolaganne/lengendarylens/LottieDefinition;", "fullscreenImage", "dimColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/LottieDefinition;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/LottieDefinition;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImage", "()Ljava/lang/String;", "getText", "getColor", "getImagePlacement", "getAnimation", "()Lcom/studiolaganne/lengendarylens/LottieDefinition;", "getFullscreenImage", "getDimColor", "setDimColor", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class MessageData {
    private final LottieDefinition animation;
    private final String color;
    private String dimColor;
    private final String fullscreenImage;
    private final String image;
    private final String imagePlacement;
    private final String text;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessageData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/studiolaganne/lengendarylens/MessageData;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<MessageData> serializer() {
            return MessageData$$serializer.INSTANCE;
        }
    }

    public MessageData() {
        this((String) null, (String) null, (String) null, (String) null, (LottieDefinition) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ MessageData(int i, String str, String str2, String str3, String str4, LottieDefinition lottieDefinition, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.image = "";
        } else {
            this.image = str;
        }
        if ((i & 2) == 0) {
            this.text = "";
        } else {
            this.text = str2;
        }
        if ((i & 4) == 0) {
            this.color = "";
        } else {
            this.color = str3;
        }
        if ((i & 8) == 0) {
            this.imagePlacement = "front";
        } else {
            this.imagePlacement = str4;
        }
        if ((i & 16) == 0) {
            this.animation = null;
        } else {
            this.animation = lottieDefinition;
        }
        if ((i & 32) == 0) {
            this.fullscreenImage = null;
        } else {
            this.fullscreenImage = str5;
        }
        if ((i & 64) == 0) {
            this.dimColor = null;
        } else {
            this.dimColor = str6;
        }
    }

    public MessageData(String str, String text, String str2, String str3, LottieDefinition lottieDefinition, String str4, String str5) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.image = str;
        this.text = text;
        this.color = str2;
        this.imagePlacement = str3;
        this.animation = lottieDefinition;
        this.fullscreenImage = str4;
        this.dimColor = str5;
    }

    public /* synthetic */ MessageData(String str, String str2, String str3, String str4, LottieDefinition lottieDefinition, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "front" : str4, (i & 16) != 0 ? null : lottieDefinition, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
    }

    public static /* synthetic */ MessageData copy$default(MessageData messageData, String str, String str2, String str3, String str4, LottieDefinition lottieDefinition, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageData.image;
        }
        if ((i & 2) != 0) {
            str2 = messageData.text;
        }
        if ((i & 4) != 0) {
            str3 = messageData.color;
        }
        if ((i & 8) != 0) {
            str4 = messageData.imagePlacement;
        }
        if ((i & 16) != 0) {
            lottieDefinition = messageData.animation;
        }
        if ((i & 32) != 0) {
            str5 = messageData.fullscreenImage;
        }
        if ((i & 64) != 0) {
            str6 = messageData.dimColor;
        }
        String str7 = str5;
        String str8 = str6;
        LottieDefinition lottieDefinition2 = lottieDefinition;
        String str9 = str3;
        return messageData.copy(str, str2, str9, str4, lottieDefinition2, str7, str8);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(MessageData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.image, "")) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.image);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.text, "")) {
            output.encodeStringElement(serialDesc, 1, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.color, "")) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.imagePlacement, "front")) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.imagePlacement);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.animation != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LottieDefinition$$serializer.INSTANCE, self.animation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fullscreenImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.fullscreenImage);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.dimColor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.dimColor);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImagePlacement() {
        return this.imagePlacement;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final LottieDefinition getAnimation() {
        return this.animation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFullscreenImage() {
        return this.fullscreenImage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDimColor() {
        return this.dimColor;
    }

    public final MessageData copy(String image, String text, String color, String imagePlacement, LottieDefinition animation, String fullscreenImage, String dimColor) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new MessageData(image, text, color, imagePlacement, animation, fullscreenImage, dimColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageData)) {
            return false;
        }
        MessageData messageData = (MessageData) other;
        return Intrinsics.areEqual(this.image, messageData.image) && Intrinsics.areEqual(this.text, messageData.text) && Intrinsics.areEqual(this.color, messageData.color) && Intrinsics.areEqual(this.imagePlacement, messageData.imagePlacement) && Intrinsics.areEqual(this.animation, messageData.animation) && Intrinsics.areEqual(this.fullscreenImage, messageData.fullscreenImage) && Intrinsics.areEqual(this.dimColor, messageData.dimColor);
    }

    public final LottieDefinition getAnimation() {
        return this.animation;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDimColor() {
        return this.dimColor;
    }

    public final String getFullscreenImage() {
        return this.fullscreenImage;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getImagePlacement() {
        return this.imagePlacement;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.image;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.text.hashCode()) * 31;
        String str2 = this.color;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imagePlacement;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        LottieDefinition lottieDefinition = this.animation;
        int iHashCode4 = (iHashCode3 + (lottieDefinition == null ? 0 : lottieDefinition.hashCode())) * 31;
        String str4 = this.fullscreenImage;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.dimColor;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setDimColor(String str) {
        this.dimColor = str;
    }

    public String toString() {
        return "MessageData(image=" + this.image + ", text=" + this.text + ", color=" + this.color + ", imagePlacement=" + this.imagePlacement + ", animation=" + this.animation + ", fullscreenImage=" + this.fullscreenImage + ", dimColor=" + this.dimColor + ")";
    }
}
