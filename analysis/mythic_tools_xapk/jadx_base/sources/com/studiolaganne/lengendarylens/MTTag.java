package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J$\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTag;", "", "id", "", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTTag;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTag {
    public static final int $stable = 8;
    private Integer id;
    private String name;

    /* JADX WARN: Multi-variable type inference failed */
    public MTTag() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTTag(Integer num, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = num;
        this.name = name;
    }

    public /* synthetic */ MTTag(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ MTTag copy$default(MTTag mTTag, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTTag.id;
        }
        if ((i & 2) != 0) {
            str = mTTag.name;
        }
        return mTTag.copy(num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final MTTag copy(Integer id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTTag(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTTag)) {
            return false;
        }
        MTTag mTTag = (MTTag) other;
        return Intrinsics.areEqual(this.id, mTTag.id) && Intrinsics.areEqual(this.name, mTTag.name);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        Integer num = this.id;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.name.hashCode();
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "MTTag(id=" + this.id + ", name=" + this.name + ")";
    }
}
