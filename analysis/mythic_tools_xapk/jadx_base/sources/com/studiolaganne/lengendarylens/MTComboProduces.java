package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTComboProduces;", "", "id", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTComboProduces {
    public static final int $stable = 0;
    private final int id;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public MTComboProduces() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public MTComboProduces(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
    }

    public /* synthetic */ MTComboProduces(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ MTComboProduces copy$default(MTComboProduces mTComboProduces, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTComboProduces.id;
        }
        if ((i2 & 2) != 0) {
            str = mTComboProduces.name;
        }
        return mTComboProduces.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final MTComboProduces copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTComboProduces(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTComboProduces)) {
            return false;
        }
        MTComboProduces mTComboProduces = (MTComboProduces) other;
        return this.id == mTComboProduces.id && Intrinsics.areEqual(this.name, mTComboProduces.name);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "MTComboProduces(id=" + this.id + ", name=" + this.name + ")";
    }
}
