package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010D\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000fHÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$Jî\u0001\u0010M\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0005HÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010,R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b-\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b;\u0010$R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b<\u0010$¨\u0006T"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardContainer;", "", "color", "", "count", "", "faceCard", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "id", "name", "type", "type_name", "values", "", "Lcom/studiolaganne/lengendarylens/MTCardsValue;", "Lcom/studiolaganne/lengendarylens/MTCardsValues;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "grouped_cards", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "stats", "Lcom/studiolaganne/lengendarylens/MTCardContainerStats;", "errors", "Lcom/studiolaganne/lengendarylens/MTListError;", "user", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "privacy", "Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "owner_userid", "shared_from_userid", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTSimpleCard;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardContainerStats;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getColor", "()Ljava/lang/String;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFaceCard", "()Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "getId", "()I", "getName", "setName", "(Ljava/lang/String;)V", "getType", "getType_name", "getValues", "()Ljava/util/Map;", "getCards", "()Ljava/util/List;", "getGrouped_cards", "getStats", "()Lcom/studiolaganne/lengendarylens/MTCardContainerStats;", "getErrors", "getUser", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "getOwner_userid", "getShared_from_userid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTSimpleCard;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardContainerStats;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTCardContainer;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardContainer {
    public static final int $stable = 8;
    private final List<MTFullCard> cards;
    private final String color;
    private final Integer count;
    private final List<MTListError> errors;
    private final MTSimpleCard faceCard;
    private final List<MTCardGroup> grouped_cards;
    private final int id;
    private String name;
    private final Integer owner_userid;
    private final MTContainerPrivacy privacy;
    private final Integer shared_from_userid;
    private final MTCardContainerStats stats;
    private final Integer type;
    private final String type_name;
    private final MTPrivacyUser user;
    private final Map<String, MTCardsValue> values;

    public MTCardContainer() {
        this(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public MTCardContainer(String str, Integer num, MTSimpleCard mTSimpleCard, int i, String name, Integer num2, String str2, Map<String, MTCardsValue> map, List<MTFullCard> list, List<MTCardGroup> list2, MTCardContainerStats mTCardContainerStats, List<MTListError> list3, MTPrivacyUser mTPrivacyUser, MTContainerPrivacy mTContainerPrivacy, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.color = str;
        this.count = num;
        this.faceCard = mTSimpleCard;
        this.id = i;
        this.name = name;
        this.type = num2;
        this.type_name = str2;
        this.values = map;
        this.cards = list;
        this.grouped_cards = list2;
        this.stats = mTCardContainerStats;
        this.errors = list3;
        this.user = mTPrivacyUser;
        this.privacy = mTContainerPrivacy;
        this.owner_userid = num3;
        this.shared_from_userid = num4;
    }

    public /* synthetic */ MTCardContainer(String str, Integer num, MTSimpleCard mTSimpleCard, int i, String str2, Integer num2, String str3, Map map, List list, List list2, MTCardContainerStats mTCardContainerStats, List list3, MTPrivacyUser mTPrivacyUser, MTContainerPrivacy mTContainerPrivacy, Integer num3, Integer num4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? null : mTSimpleCard, (i2 & 8) == 0 ? i : 0, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? null : num2, (i2 & 64) != 0 ? null : str3, (i2 & 128) != 0 ? null : map, (i2 & 256) != 0 ? null : list, (i2 & 512) != 0 ? null : list2, (i2 & 1024) != 0 ? null : mTCardContainerStats, (i2 & 2048) != 0 ? null : list3, (i2 & 4096) != 0 ? null : mTPrivacyUser, (i2 & 8192) != 0 ? null : mTContainerPrivacy, (i2 & 16384) != 0 ? null : num3, (i2 & 32768) != 0 ? null : num4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardContainer copy$default(MTCardContainer mTCardContainer, String str, Integer num, MTSimpleCard mTSimpleCard, int i, String str2, Integer num2, String str3, Map map, List list, List list2, MTCardContainerStats mTCardContainerStats, List list3, MTPrivacyUser mTPrivacyUser, MTContainerPrivacy mTContainerPrivacy, Integer num3, Integer num4, int i2, Object obj) {
        String str4 = (i2 & 1) != 0 ? mTCardContainer.color : str;
        return mTCardContainer.copy(str4, (i2 & 2) != 0 ? mTCardContainer.count : num, (i2 & 4) != 0 ? mTCardContainer.faceCard : mTSimpleCard, (i2 & 8) != 0 ? mTCardContainer.id : i, (i2 & 16) != 0 ? mTCardContainer.name : str2, (i2 & 32) != 0 ? mTCardContainer.type : num2, (i2 & 64) != 0 ? mTCardContainer.type_name : str3, (i2 & 128) != 0 ? mTCardContainer.values : map, (i2 & 256) != 0 ? mTCardContainer.cards : list, (i2 & 512) != 0 ? mTCardContainer.grouped_cards : list2, (i2 & 1024) != 0 ? mTCardContainer.stats : mTCardContainerStats, (i2 & 2048) != 0 ? mTCardContainer.errors : list3, (i2 & 4096) != 0 ? mTCardContainer.user : mTPrivacyUser, (i2 & 8192) != 0 ? mTCardContainer.privacy : mTContainerPrivacy, (i2 & 16384) != 0 ? mTCardContainer.owner_userid : num3, (i2 & 32768) != 0 ? mTCardContainer.shared_from_userid : num4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    public final List<MTCardGroup> component10() {
        return this.grouped_cards;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTCardContainerStats getStats() {
        return this.stats;
    }

    public final List<MTListError> component12() {
        return this.errors;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final MTPrivacyUser getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final MTContainerPrivacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getOwner_userid() {
        return this.owner_userid;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getShared_from_userid() {
        return this.shared_from_userid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTSimpleCard getFaceCard() {
        return this.faceCard;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getType_name() {
        return this.type_name;
    }

    public final Map<String, MTCardsValue> component8() {
        return this.values;
    }

    public final List<MTFullCard> component9() {
        return this.cards;
    }

    public final MTCardContainer copy(String color, Integer count, MTSimpleCard faceCard, int id, String name, Integer type, String type_name, Map<String, MTCardsValue> values, List<MTFullCard> cards, List<MTCardGroup> grouped_cards, MTCardContainerStats stats, List<MTListError> errors, MTPrivacyUser user, MTContainerPrivacy privacy, Integer owner_userid, Integer shared_from_userid) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTCardContainer(color, count, faceCard, id, name, type, type_name, values, cards, grouped_cards, stats, errors, user, privacy, owner_userid, shared_from_userid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardContainer)) {
            return false;
        }
        MTCardContainer mTCardContainer = (MTCardContainer) other;
        return Intrinsics.areEqual(this.color, mTCardContainer.color) && Intrinsics.areEqual(this.count, mTCardContainer.count) && Intrinsics.areEqual(this.faceCard, mTCardContainer.faceCard) && this.id == mTCardContainer.id && Intrinsics.areEqual(this.name, mTCardContainer.name) && Intrinsics.areEqual(this.type, mTCardContainer.type) && Intrinsics.areEqual(this.type_name, mTCardContainer.type_name) && Intrinsics.areEqual(this.values, mTCardContainer.values) && Intrinsics.areEqual(this.cards, mTCardContainer.cards) && Intrinsics.areEqual(this.grouped_cards, mTCardContainer.grouped_cards) && Intrinsics.areEqual(this.stats, mTCardContainer.stats) && Intrinsics.areEqual(this.errors, mTCardContainer.errors) && Intrinsics.areEqual(this.user, mTCardContainer.user) && Intrinsics.areEqual(this.privacy, mTCardContainer.privacy) && Intrinsics.areEqual(this.owner_userid, mTCardContainer.owner_userid) && Intrinsics.areEqual(this.shared_from_userid, mTCardContainer.shared_from_userid);
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final String getColor() {
        return this.color;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final List<MTListError> getErrors() {
        return this.errors;
    }

    public final MTSimpleCard getFaceCard() {
        return this.faceCard;
    }

    public final List<MTCardGroup> getGrouped_cards() {
        return this.grouped_cards;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOwner_userid() {
        return this.owner_userid;
    }

    public final MTContainerPrivacy getPrivacy() {
        return this.privacy;
    }

    public final Integer getShared_from_userid() {
        return this.shared_from_userid;
    }

    public final MTCardContainerStats getStats() {
        return this.stats;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public final Map<String, MTCardsValue> getValues() {
        return this.values;
    }

    public int hashCode() {
        String str = this.color;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.count;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        MTSimpleCard mTSimpleCard = this.faceCard;
        int iHashCode3 = (((((iHashCode2 + (mTSimpleCard == null ? 0 : mTSimpleCard.hashCode())) * 31) + Integer.hashCode(this.id)) * 31) + this.name.hashCode()) * 31;
        Integer num2 = this.type;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.type_name;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, MTCardsValue> map = this.values;
        int iHashCode6 = (iHashCode5 + (map == null ? 0 : map.hashCode())) * 31;
        List<MTFullCard> list = this.cards;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List<MTCardGroup> list2 = this.grouped_cards;
        int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        MTCardContainerStats mTCardContainerStats = this.stats;
        int iHashCode9 = (iHashCode8 + (mTCardContainerStats == null ? 0 : mTCardContainerStats.hashCode())) * 31;
        List<MTListError> list3 = this.errors;
        int iHashCode10 = (iHashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.user;
        int iHashCode11 = (iHashCode10 + (mTPrivacyUser == null ? 0 : mTPrivacyUser.hashCode())) * 31;
        MTContainerPrivacy mTContainerPrivacy = this.privacy;
        int iHashCode12 = (iHashCode11 + (mTContainerPrivacy == null ? 0 : mTContainerPrivacy.hashCode())) * 31;
        Integer num3 = this.owner_userid;
        int iHashCode13 = (iHashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.shared_from_userid;
        return iHashCode13 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "MTCardContainer(color=" + this.color + ", count=" + this.count + ", faceCard=" + this.faceCard + ", id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", type_name=" + this.type_name + ", values=" + this.values + ", cards=" + this.cards + ", grouped_cards=" + this.grouped_cards + ", stats=" + this.stats + ", errors=" + this.errors + ", user=" + this.user + ", privacy=" + this.privacy + ", owner_userid=" + this.owner_userid + ", shared_from_userid=" + this.shared_from_userid + ")";
    }
}
