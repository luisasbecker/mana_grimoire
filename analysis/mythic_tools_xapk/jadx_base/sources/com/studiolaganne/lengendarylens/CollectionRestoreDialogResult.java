package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionRestoreDialogResult;", "", "shouldRestore", "", "listCardId", "", "<init>", "(ZLjava/lang/Integer;)V", "getShouldRestore", "()Z", "getListCardId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ZLjava/lang/Integer;)Lcom/studiolaganne/lengendarylens/CollectionRestoreDialogResult;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionRestoreDialogResult {
    public static final int $stable = 0;
    private final Integer listCardId;
    private final boolean shouldRestore;

    public CollectionRestoreDialogResult(boolean z, Integer num) {
        this.shouldRestore = z;
        this.listCardId = num;
    }

    public static /* synthetic */ CollectionRestoreDialogResult copy$default(CollectionRestoreDialogResult collectionRestoreDialogResult, boolean z, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z = collectionRestoreDialogResult.shouldRestore;
        }
        if ((i & 2) != 0) {
            num = collectionRestoreDialogResult.listCardId;
        }
        return collectionRestoreDialogResult.copy(z, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldRestore() {
        return this.shouldRestore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getListCardId() {
        return this.listCardId;
    }

    public final CollectionRestoreDialogResult copy(boolean shouldRestore, Integer listCardId) {
        return new CollectionRestoreDialogResult(shouldRestore, listCardId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionRestoreDialogResult)) {
            return false;
        }
        CollectionRestoreDialogResult collectionRestoreDialogResult = (CollectionRestoreDialogResult) other;
        return this.shouldRestore == collectionRestoreDialogResult.shouldRestore && Intrinsics.areEqual(this.listCardId, collectionRestoreDialogResult.listCardId);
    }

    public final Integer getListCardId() {
        return this.listCardId;
    }

    public final boolean getShouldRestore() {
        return this.shouldRestore;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.shouldRestore) * 31;
        Integer num = this.listCardId;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "CollectionRestoreDialogResult(shouldRestore=" + this.shouldRestore + ", listCardId=" + this.listCardId + ")";
    }
}
