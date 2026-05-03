package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018JF\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFavoriteFormat;", "", "id", "", "name", "", "color", "icon", "games_count", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getColor", "setColor", "getIcon", "setIcon", "getGames_count", "()Ljava/lang/Integer;", "setGames_count", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTFavoriteFormat;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFavoriteFormat {
    public static final int $stable = 8;
    private String color;
    private Integer games_count;
    private String icon;
    private int id;
    private String name;

    public MTFavoriteFormat() {
        this(0, null, null, null, null, 31, null);
    }

    public MTFavoriteFormat(int i, String name, String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.color = str;
        this.icon = str2;
        this.games_count = num;
    }

    public /* synthetic */ MTFavoriteFormat(int i, String str, String str2, String str3, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? 0 : num);
    }

    public static /* synthetic */ MTFavoriteFormat copy$default(MTFavoriteFormat mTFavoriteFormat, int i, String str, String str2, String str3, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTFavoriteFormat.id;
        }
        if ((i2 & 2) != 0) {
            str = mTFavoriteFormat.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mTFavoriteFormat.color;
        }
        if ((i2 & 8) != 0) {
            str3 = mTFavoriteFormat.icon;
        }
        if ((i2 & 16) != 0) {
            num = mTFavoriteFormat.games_count;
        }
        Integer num2 = num;
        String str4 = str2;
        return mTFavoriteFormat.copy(i, str, str4, str3, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getGames_count() {
        return this.games_count;
    }

    public final MTFavoriteFormat copy(int id, String name, String color, String icon, Integer games_count) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTFavoriteFormat(id, name, color, icon, games_count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFavoriteFormat)) {
            return false;
        }
        MTFavoriteFormat mTFavoriteFormat = (MTFavoriteFormat) other;
        return this.id == mTFavoriteFormat.id && Intrinsics.areEqual(this.name, mTFavoriteFormat.name) && Intrinsics.areEqual(this.color, mTFavoriteFormat.color) && Intrinsics.areEqual(this.icon, mTFavoriteFormat.icon) && Intrinsics.areEqual(this.games_count, mTFavoriteFormat.games_count);
    }

    public final String getColor() {
        return this.color;
    }

    public final Integer getGames_count() {
        return this.games_count;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.color;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.icon;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.games_count;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setGames_count(Integer num) {
        this.games_count = num;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "MTFavoriteFormat(id=" + this.id + ", name=" + this.name + ", color=" + this.color + ", icon=" + this.icon + ", games_count=" + this.games_count + ")";
    }
}
