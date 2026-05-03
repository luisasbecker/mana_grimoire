package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J°\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFace;", "", "face_index", "", "name", "", "mana_cost", "type_line", "oracle_text", "power", "toughness", "loyalty", "defense", "printed_name", "printed_text", "printed_type_line", "colors", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFace_index", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getMana_cost", "getType_line", "getOracle_text", "getPower", "getToughness", "getLoyalty", "getDefense", "getPrinted_name", "getPrinted_text", "getPrinted_type_line", "getColors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTFace;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFace {
    public static final int $stable = 8;
    private final List<String> colors;
    private final String defense;
    private final Integer face_index;
    private final String loyalty;
    private final String mana_cost;
    private final String name;
    private final String oracle_text;
    private final String power;
    private final String printed_name;
    private final String printed_text;
    private final String printed_type_line;
    private final String toughness;
    private final String type_line;

    public MTFace() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public MTFace(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<String> list) {
        this.face_index = num;
        this.name = str;
        this.mana_cost = str2;
        this.type_line = str3;
        this.oracle_text = str4;
        this.power = str5;
        this.toughness = str6;
        this.loyalty = str7;
        this.defense = str8;
        this.printed_name = str9;
        this.printed_text = str10;
        this.printed_type_line = str11;
        this.colors = list;
    }

    public /* synthetic */ MTFace(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTFace copy$default(MTFace mTFace, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTFace.face_index;
        }
        return mTFace.copy(num, (i & 2) != 0 ? mTFace.name : str, (i & 4) != 0 ? mTFace.mana_cost : str2, (i & 8) != 0 ? mTFace.type_line : str3, (i & 16) != 0 ? mTFace.oracle_text : str4, (i & 32) != 0 ? mTFace.power : str5, (i & 64) != 0 ? mTFace.toughness : str6, (i & 128) != 0 ? mTFace.loyalty : str7, (i & 256) != 0 ? mTFace.defense : str8, (i & 512) != 0 ? mTFace.printed_name : str9, (i & 1024) != 0 ? mTFace.printed_text : str10, (i & 2048) != 0 ? mTFace.printed_type_line : str11, (i & 4096) != 0 ? mTFace.colors : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getFace_index() {
        return this.face_index;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPrinted_text() {
        return this.printed_text;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    public final List<String> component13() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMana_cost() {
        return this.mana_cost;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType_line() {
        return this.type_line;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOracle_text() {
        return this.oracle_text;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPower() {
        return this.power;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getToughness() {
        return this.toughness;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLoyalty() {
        return this.loyalty;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDefense() {
        return this.defense;
    }

    public final MTFace copy(Integer face_index, String name, String mana_cost, String type_line, String oracle_text, String power, String toughness, String loyalty, String defense, String printed_name, String printed_text, String printed_type_line, List<String> colors) {
        return new MTFace(face_index, name, mana_cost, type_line, oracle_text, power, toughness, loyalty, defense, printed_name, printed_text, printed_type_line, colors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFace)) {
            return false;
        }
        MTFace mTFace = (MTFace) other;
        return Intrinsics.areEqual(this.face_index, mTFace.face_index) && Intrinsics.areEqual(this.name, mTFace.name) && Intrinsics.areEqual(this.mana_cost, mTFace.mana_cost) && Intrinsics.areEqual(this.type_line, mTFace.type_line) && Intrinsics.areEqual(this.oracle_text, mTFace.oracle_text) && Intrinsics.areEqual(this.power, mTFace.power) && Intrinsics.areEqual(this.toughness, mTFace.toughness) && Intrinsics.areEqual(this.loyalty, mTFace.loyalty) && Intrinsics.areEqual(this.defense, mTFace.defense) && Intrinsics.areEqual(this.printed_name, mTFace.printed_name) && Intrinsics.areEqual(this.printed_text, mTFace.printed_text) && Intrinsics.areEqual(this.printed_type_line, mTFace.printed_type_line) && Intrinsics.areEqual(this.colors, mTFace.colors);
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final String getDefense() {
        return this.defense;
    }

    public final Integer getFace_index() {
        return this.face_index;
    }

    public final String getLoyalty() {
        return this.loyalty;
    }

    public final String getMana_cost() {
        return this.mana_cost;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final String getPower() {
        return this.power;
    }

    public final String getPrinted_name() {
        return this.printed_name;
    }

    public final String getPrinted_text() {
        return this.printed_text;
    }

    public final String getPrinted_type_line() {
        return this.printed_type_line;
    }

    public final String getToughness() {
        return this.toughness;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public int hashCode() {
        Integer num = this.face_index;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mana_cost;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type_line;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.oracle_text;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.power;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.toughness;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.loyalty;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.defense;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.printed_name;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.printed_text;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.printed_type_line;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<String> list = this.colors;
        return iHashCode12 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MTFace(face_index=" + this.face_index + ", name=" + this.name + ", mana_cost=" + this.mana_cost + ", type_line=" + this.type_line + ", oracle_text=" + this.oracle_text + ", power=" + this.power + ", toughness=" + this.toughness + ", loyalty=" + this.loyalty + ", defense=" + this.defense + ", printed_name=" + this.printed_name + ", printed_text=" + this.printed_text + ", printed_type_line=" + this.printed_type_line + ", colors=" + this.colors + ")";
    }
}
