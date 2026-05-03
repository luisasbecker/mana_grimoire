package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\f\u0010\rBm\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u000fHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerToss;", "", "type", "", "enMessage", "Lcom/studiolaganne/lengendarylens/MessageData;", "frMessage", "backgroundColor", "borderColor", "enChallenges", "", "frChallenges", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MessageData;Lcom/studiolaganne/lengendarylens/MessageData;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/studiolaganne/lengendarylens/MessageData;Lcom/studiolaganne/lengendarylens/MessageData;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getEnMessage", "()Lcom/studiolaganne/lengendarylens/MessageData;", "getFrMessage", "getBackgroundColor", "getBorderColor", "getEnChallenges", "()Ljava/util/List;", "getFrChallenges", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerToss {
    private final String backgroundColor;
    private final String borderColor;
    private final List<String> enChallenges;
    private final MessageData enMessage;
    private final List<String> frChallenges;
    private final MessageData frMessage;
    private final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerToss$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PlayerToss._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerToss$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PlayerToss._childSerializers$_anonymous_$0();
        }
    })};

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerToss$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/studiolaganne/lengendarylens/PlayerToss;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PlayerToss> serializer() {
            return PlayerToss$$serializer.INSTANCE;
        }
    }

    public PlayerToss() {
        this((String) null, (MessageData) null, (MessageData) null, (String) null, (String) null, (List) null, (List) null, 127, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ PlayerToss(int i, String str, MessageData messageData, MessageData messageData2, String str2, String str3, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        this.type = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.enMessage = null;
        } else {
            this.enMessage = messageData;
        }
        if ((i & 4) == 0) {
            this.frMessage = null;
        } else {
            this.frMessage = messageData2;
        }
        if ((i & 8) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = str2;
        }
        if ((i & 16) == 0) {
            this.borderColor = null;
        } else {
            this.borderColor = str3;
        }
        if ((i & 32) == 0) {
            this.enChallenges = CollectionsKt.emptyList();
        } else {
            this.enChallenges = list;
        }
        if ((i & 64) == 0) {
            this.frChallenges = CollectionsKt.emptyList();
        } else {
            this.frChallenges = list2;
        }
    }

    public PlayerToss(String type, MessageData messageData, MessageData messageData2, String str, String str2, List<String> enChallenges, List<String> frChallenges) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(enChallenges, "enChallenges");
        Intrinsics.checkNotNullParameter(frChallenges, "frChallenges");
        this.type = type;
        this.enMessage = messageData;
        this.frMessage = messageData2;
        this.backgroundColor = str;
        this.borderColor = str2;
        this.enChallenges = enChallenges;
        this.frChallenges = frChallenges;
    }

    public /* synthetic */ PlayerToss(String str, MessageData messageData, MessageData messageData2, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : messageData, (i & 4) != 0 ? null : messageData2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerToss copy$default(PlayerToss playerToss, String str, MessageData messageData, MessageData messageData2, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playerToss.type;
        }
        if ((i & 2) != 0) {
            messageData = playerToss.enMessage;
        }
        if ((i & 4) != 0) {
            messageData2 = playerToss.frMessage;
        }
        if ((i & 8) != 0) {
            str2 = playerToss.backgroundColor;
        }
        if ((i & 16) != 0) {
            str3 = playerToss.borderColor;
        }
        if ((i & 32) != 0) {
            list = playerToss.enChallenges;
        }
        if ((i & 64) != 0) {
            list2 = playerToss.frChallenges;
        }
        List list3 = list;
        List list4 = list2;
        String str4 = str3;
        MessageData messageData3 = messageData2;
        return playerToss.copy(str, messageData, messageData3, str2, str4, list3, list4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlayerToss self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.type, "")) {
            output.encodeStringElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.enMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, MessageData$$serializer.INSTANCE, self.enMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.frMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, MessageData$$serializer.INSTANCE, self.frMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.borderColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.borderColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.enChallenges, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.enChallenges);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && Intrinsics.areEqual(self.frChallenges, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.frChallenges);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MessageData getEnMessage() {
        return this.enMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MessageData getFrMessage() {
        return this.frMessage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> component6() {
        return this.enChallenges;
    }

    public final List<String> component7() {
        return this.frChallenges;
    }

    public final PlayerToss copy(String type, MessageData enMessage, MessageData frMessage, String backgroundColor, String borderColor, List<String> enChallenges, List<String> frChallenges) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(enChallenges, "enChallenges");
        Intrinsics.checkNotNullParameter(frChallenges, "frChallenges");
        return new PlayerToss(type, enMessage, frMessage, backgroundColor, borderColor, enChallenges, frChallenges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerToss)) {
            return false;
        }
        PlayerToss playerToss = (PlayerToss) other;
        return Intrinsics.areEqual(this.type, playerToss.type) && Intrinsics.areEqual(this.enMessage, playerToss.enMessage) && Intrinsics.areEqual(this.frMessage, playerToss.frMessage) && Intrinsics.areEqual(this.backgroundColor, playerToss.backgroundColor) && Intrinsics.areEqual(this.borderColor, playerToss.borderColor) && Intrinsics.areEqual(this.enChallenges, playerToss.enChallenges) && Intrinsics.areEqual(this.frChallenges, playerToss.frChallenges);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> getEnChallenges() {
        return this.enChallenges;
    }

    public final MessageData getEnMessage() {
        return this.enMessage;
    }

    public final List<String> getFrChallenges() {
        return this.frChallenges;
    }

    public final MessageData getFrMessage() {
        return this.frMessage;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        MessageData messageData = this.enMessage;
        int iHashCode2 = (iHashCode + (messageData == null ? 0 : messageData.hashCode())) * 31;
        MessageData messageData2 = this.frMessage;
        int iHashCode3 = (iHashCode2 + (messageData2 == null ? 0 : messageData2.hashCode())) * 31;
        String str = this.backgroundColor;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.borderColor;
        return ((((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.enChallenges.hashCode()) * 31) + this.frChallenges.hashCode();
    }

    public String toString() {
        return "PlayerToss(type=" + this.type + ", enMessage=" + this.enMessage + ", frMessage=" + this.frMessage + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", enChallenges=" + this.enChallenges + ", frChallenges=" + this.frChallenges + ")";
    }
}
