package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0085\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardManaInsight;", "", "id", "", "type", "severity", "message", "messageFr", "actionable", "actionableFr", "info", "infoFr", "cardNames", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getType", "getSeverity", "getMessage", "getMessageFr", "getActionable", "getActionableFr", "getInfo", "getInfoFr", "getCardNames", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardManaInsight {
    public static final int $stable = 8;
    private final String actionable;

    @SerializedName("actionable_fr")
    private final String actionableFr;
    private final List<String> cardNames;
    private final String id;
    private final String info;

    @SerializedName("info_fr")
    private final String infoFr;
    private final String message;

    @SerializedName("message_fr")
    private final String messageFr;
    private final String severity;
    private final String type;

    public MTIdCardManaInsight() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public MTIdCardManaInsight(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<String> cardNames) {
        Intrinsics.checkNotNullParameter(cardNames, "cardNames");
        this.id = str;
        this.type = str2;
        this.severity = str3;
        this.message = str4;
        this.messageFr = str5;
        this.actionable = str6;
        this.actionableFr = str7;
        this.info = str8;
        this.infoFr = str9;
        this.cardNames = cardNames;
    }

    public /* synthetic */ MTIdCardManaInsight(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardManaInsight copy$default(MTIdCardManaInsight mTIdCardManaInsight, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardManaInsight.id;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardManaInsight.type;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardManaInsight.severity;
        }
        if ((i & 8) != 0) {
            str4 = mTIdCardManaInsight.message;
        }
        if ((i & 16) != 0) {
            str5 = mTIdCardManaInsight.messageFr;
        }
        if ((i & 32) != 0) {
            str6 = mTIdCardManaInsight.actionable;
        }
        if ((i & 64) != 0) {
            str7 = mTIdCardManaInsight.actionableFr;
        }
        if ((i & 128) != 0) {
            str8 = mTIdCardManaInsight.info;
        }
        if ((i & 256) != 0) {
            str9 = mTIdCardManaInsight.infoFr;
        }
        if ((i & 512) != 0) {
            list = mTIdCardManaInsight.cardNames;
        }
        String str10 = str9;
        List list2 = list;
        String str11 = str7;
        String str12 = str8;
        String str13 = str5;
        String str14 = str6;
        return mTIdCardManaInsight.copy(str, str2, str3, str4, str13, str14, str11, str12, str10, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.cardNames;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeverity() {
        return this.severity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessageFr() {
        return this.messageFr;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getActionable() {
        return this.actionable;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getActionableFr() {
        return this.actionableFr;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getInfoFr() {
        return this.infoFr;
    }

    public final MTIdCardManaInsight copy(String id, String type, String severity, String message, String messageFr, String actionable, String actionableFr, String info, String infoFr, List<String> cardNames) {
        Intrinsics.checkNotNullParameter(cardNames, "cardNames");
        return new MTIdCardManaInsight(id, type, severity, message, messageFr, actionable, actionableFr, info, infoFr, cardNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardManaInsight)) {
            return false;
        }
        MTIdCardManaInsight mTIdCardManaInsight = (MTIdCardManaInsight) other;
        return Intrinsics.areEqual(this.id, mTIdCardManaInsight.id) && Intrinsics.areEqual(this.type, mTIdCardManaInsight.type) && Intrinsics.areEqual(this.severity, mTIdCardManaInsight.severity) && Intrinsics.areEqual(this.message, mTIdCardManaInsight.message) && Intrinsics.areEqual(this.messageFr, mTIdCardManaInsight.messageFr) && Intrinsics.areEqual(this.actionable, mTIdCardManaInsight.actionable) && Intrinsics.areEqual(this.actionableFr, mTIdCardManaInsight.actionableFr) && Intrinsics.areEqual(this.info, mTIdCardManaInsight.info) && Intrinsics.areEqual(this.infoFr, mTIdCardManaInsight.infoFr) && Intrinsics.areEqual(this.cardNames, mTIdCardManaInsight.cardNames);
    }

    public final String getActionable() {
        return this.actionable;
    }

    public final String getActionableFr() {
        return this.actionableFr;
    }

    public final List<String> getCardNames() {
        return this.cardNames;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getInfoFr() {
        return this.infoFr;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMessageFr() {
        return this.messageFr;
    }

    public final String getSeverity() {
        return this.severity;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.severity;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.messageFr;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.actionable;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.actionableFr;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.info;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.infoFr;
        return ((iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.cardNames.hashCode();
    }

    public String toString() {
        return "MTIdCardManaInsight(id=" + this.id + ", type=" + this.type + ", severity=" + this.severity + ", message=" + this.message + ", messageFr=" + this.messageFr + ", actionable=" + this.actionable + ", actionableFr=" + this.actionableFr + ", info=" + this.info + ", infoFr=" + this.infoFr + ", cardNames=" + this.cardNames + ")";
    }
}
