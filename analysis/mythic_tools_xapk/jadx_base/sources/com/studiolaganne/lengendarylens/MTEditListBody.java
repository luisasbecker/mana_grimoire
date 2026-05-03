package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\bHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00068"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEditListBody;", "", "name", "", "color", "faceCard", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "type", "", "deck", "Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;", "privacy", "Lcom/studiolaganne/lengendarylens/MTCreateListPrivacy;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSimpleCard;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;Lcom/studiolaganne/lengendarylens/MTCreateListPrivacy;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getColor", "setColor", "getFaceCard", "()Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "setFaceCard", "(Lcom/studiolaganne/lengendarylens/MTSimpleCard;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;", "setDeck", "(Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;)V", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTCreateListPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTCreateListPrivacy;)V", "includeNullColor", "", "getIncludeNullColor", "()Z", "setIncludeNullColor", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSimpleCard;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTEditListBodyDeckSettings;Lcom/studiolaganne/lengendarylens/MTCreateListPrivacy;)Lcom/studiolaganne/lengendarylens/MTEditListBody;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEditListBody {
    public static final int $stable = 8;
    private String color;
    private MTEditListBodyDeckSettings deck;
    private MTSimpleCard faceCard;
    private transient boolean includeNullColor;
    private String name;
    private MTCreateListPrivacy privacy;
    private Integer type;

    public MTEditListBody() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTEditListBody(String str, String str2, MTSimpleCard mTSimpleCard, Integer num, MTEditListBodyDeckSettings mTEditListBodyDeckSettings, MTCreateListPrivacy mTCreateListPrivacy) {
        this.name = str;
        this.color = str2;
        this.faceCard = mTSimpleCard;
        this.type = num;
        this.deck = mTEditListBodyDeckSettings;
        this.privacy = mTCreateListPrivacy;
    }

    public /* synthetic */ MTEditListBody(String str, String str2, MTSimpleCard mTSimpleCard, Integer num, MTEditListBodyDeckSettings mTEditListBodyDeckSettings, MTCreateListPrivacy mTCreateListPrivacy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : mTSimpleCard, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : mTEditListBodyDeckSettings, (i & 32) != 0 ? null : mTCreateListPrivacy);
    }

    public static /* synthetic */ MTEditListBody copy$default(MTEditListBody mTEditListBody, String str, String str2, MTSimpleCard mTSimpleCard, Integer num, MTEditListBodyDeckSettings mTEditListBodyDeckSettings, MTCreateListPrivacy mTCreateListPrivacy, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTEditListBody.name;
        }
        if ((i & 2) != 0) {
            str2 = mTEditListBody.color;
        }
        if ((i & 4) != 0) {
            mTSimpleCard = mTEditListBody.faceCard;
        }
        if ((i & 8) != 0) {
            num = mTEditListBody.type;
        }
        if ((i & 16) != 0) {
            mTEditListBodyDeckSettings = mTEditListBody.deck;
        }
        if ((i & 32) != 0) {
            mTCreateListPrivacy = mTEditListBody.privacy;
        }
        MTEditListBodyDeckSettings mTEditListBodyDeckSettings2 = mTEditListBodyDeckSettings;
        MTCreateListPrivacy mTCreateListPrivacy2 = mTCreateListPrivacy;
        return mTEditListBody.copy(str, str2, mTSimpleCard, num, mTEditListBodyDeckSettings2, mTCreateListPrivacy2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTSimpleCard getFaceCard() {
        return this.faceCard;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTEditListBodyDeckSettings getDeck() {
        return this.deck;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTCreateListPrivacy getPrivacy() {
        return this.privacy;
    }

    public final MTEditListBody copy(String name, String color, MTSimpleCard faceCard, Integer type, MTEditListBodyDeckSettings deck, MTCreateListPrivacy privacy) {
        return new MTEditListBody(name, color, faceCard, type, deck, privacy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEditListBody)) {
            return false;
        }
        MTEditListBody mTEditListBody = (MTEditListBody) other;
        return Intrinsics.areEqual(this.name, mTEditListBody.name) && Intrinsics.areEqual(this.color, mTEditListBody.color) && Intrinsics.areEqual(this.faceCard, mTEditListBody.faceCard) && Intrinsics.areEqual(this.type, mTEditListBody.type) && Intrinsics.areEqual(this.deck, mTEditListBody.deck) && Intrinsics.areEqual(this.privacy, mTEditListBody.privacy);
    }

    public final String getColor() {
        return this.color;
    }

    public final MTEditListBodyDeckSettings getDeck() {
        return this.deck;
    }

    public final MTSimpleCard getFaceCard() {
        return this.faceCard;
    }

    public final boolean getIncludeNullColor() {
        return this.includeNullColor;
    }

    public final String getName() {
        return this.name;
    }

    public final MTCreateListPrivacy getPrivacy() {
        return this.privacy;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.color;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MTSimpleCard mTSimpleCard = this.faceCard;
        int iHashCode3 = (iHashCode2 + (mTSimpleCard == null ? 0 : mTSimpleCard.hashCode())) * 31;
        Integer num = this.type;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        MTEditListBodyDeckSettings mTEditListBodyDeckSettings = this.deck;
        int iHashCode5 = (iHashCode4 + (mTEditListBodyDeckSettings == null ? 0 : mTEditListBodyDeckSettings.hashCode())) * 31;
        MTCreateListPrivacy mTCreateListPrivacy = this.privacy;
        return iHashCode5 + (mTCreateListPrivacy != null ? mTCreateListPrivacy.hashCode() : 0);
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setDeck(MTEditListBodyDeckSettings mTEditListBodyDeckSettings) {
        this.deck = mTEditListBodyDeckSettings;
    }

    public final void setFaceCard(MTSimpleCard mTSimpleCard) {
        this.faceCard = mTSimpleCard;
    }

    public final void setIncludeNullColor(boolean z) {
        this.includeNullColor = z;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPrivacy(MTCreateListPrivacy mTCreateListPrivacy) {
        this.privacy = mTCreateListPrivacy;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "MTEditListBody(name=" + this.name + ", color=" + this.color + ", faceCard=" + this.faceCard + ", type=" + this.type + ", deck=" + this.deck + ", privacy=" + this.privacy + ")";
    }
}
