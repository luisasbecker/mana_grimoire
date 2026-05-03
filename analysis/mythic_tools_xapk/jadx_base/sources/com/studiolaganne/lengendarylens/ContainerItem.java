package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerItem;", "", "id", "", "name", "", "type", "<init>", "(ILjava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ContainerItem {
    public static final int $stable = 0;
    private final int id;
    private final String name;
    private final int type;

    public ContainerItem(int i, String name, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.type = i2;
    }

    public static /* synthetic */ ContainerItem copy$default(ContainerItem containerItem, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = containerItem.id;
        }
        if ((i3 & 2) != 0) {
            str = containerItem.name;
        }
        if ((i3 & 4) != 0) {
            i2 = containerItem.type;
        }
        return containerItem.copy(i, str, i2);
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
    public final int getType() {
        return this.type;
    }

    public final ContainerItem copy(int id, String name, int type) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ContainerItem(id, name, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContainerItem)) {
            return false;
        }
        ContainerItem containerItem = (ContainerItem) other;
        return this.id == containerItem.id && Intrinsics.areEqual(this.name, containerItem.name) && this.type == containerItem.type;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        return "ContainerItem(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ")";
    }
}
