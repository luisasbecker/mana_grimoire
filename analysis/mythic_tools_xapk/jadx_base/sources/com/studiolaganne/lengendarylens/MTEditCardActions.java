package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEditCardActions;", "", "added", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "deleted", "Lcom/studiolaganne/lengendarylens/MTCardReference;", "edited", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAdded", "()Ljava/util/List;", "setAdded", "(Ljava/util/List;)V", "getDeleted", "setDeleted", "getEdited", "setEdited", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEditCardActions {
    public static final int $stable = 8;
    private List<MTFullCard> added;
    private List<MTCardReference> deleted;
    private List<MTFullCard> edited;

    public MTEditCardActions() {
        this(null, null, null, 7, null);
    }

    public MTEditCardActions(List<MTFullCard> list, List<MTCardReference> list2, List<MTFullCard> list3) {
        this.added = list;
        this.deleted = list2;
        this.edited = list3;
    }

    public /* synthetic */ MTEditCardActions(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTEditCardActions copy$default(MTEditCardActions mTEditCardActions, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTEditCardActions.added;
        }
        if ((i & 2) != 0) {
            list2 = mTEditCardActions.deleted;
        }
        if ((i & 4) != 0) {
            list3 = mTEditCardActions.edited;
        }
        return mTEditCardActions.copy(list, list2, list3);
    }

    public final List<MTFullCard> component1() {
        return this.added;
    }

    public final List<MTCardReference> component2() {
        return this.deleted;
    }

    public final List<MTFullCard> component3() {
        return this.edited;
    }

    public final MTEditCardActions copy(List<MTFullCard> added, List<MTCardReference> deleted, List<MTFullCard> edited) {
        return new MTEditCardActions(added, deleted, edited);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEditCardActions)) {
            return false;
        }
        MTEditCardActions mTEditCardActions = (MTEditCardActions) other;
        return Intrinsics.areEqual(this.added, mTEditCardActions.added) && Intrinsics.areEqual(this.deleted, mTEditCardActions.deleted) && Intrinsics.areEqual(this.edited, mTEditCardActions.edited);
    }

    public final List<MTFullCard> getAdded() {
        return this.added;
    }

    public final List<MTCardReference> getDeleted() {
        return this.deleted;
    }

    public final List<MTFullCard> getEdited() {
        return this.edited;
    }

    public int hashCode() {
        List<MTFullCard> list = this.added;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTCardReference> list2 = this.deleted;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTFullCard> list3 = this.edited;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setAdded(List<MTFullCard> list) {
        this.added = list;
    }

    public final void setDeleted(List<MTCardReference> list) {
        this.deleted = list;
    }

    public final void setEdited(List<MTFullCard> list) {
        this.edited = list;
    }

    public String toString() {
        return "MTEditCardActions(added=" + this.added + ", deleted=" + this.deleted + ", edited=" + this.edited + ")";
    }
}
