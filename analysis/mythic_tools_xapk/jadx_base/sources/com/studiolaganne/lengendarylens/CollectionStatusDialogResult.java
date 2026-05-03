package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionStatusDialogResult;", "", "choice", "Lcom/studiolaganne/lengendarylens/CollectionStatusChoice;", "selectedMatch", "Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "listCardId", "", "<init>", "(Lcom/studiolaganne/lengendarylens/CollectionStatusChoice;Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;Ljava/lang/Integer;)V", "getChoice", "()Lcom/studiolaganne/lengendarylens/CollectionStatusChoice;", "getSelectedMatch", "()Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "getListCardId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/studiolaganne/lengendarylens/CollectionStatusChoice;Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/CollectionStatusDialogResult;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionStatusDialogResult {
    public static final int $stable = 8;
    private final CollectionStatusChoice choice;
    private final Integer listCardId;
    private final MTCollectionCardMatch selectedMatch;

    public CollectionStatusDialogResult(CollectionStatusChoice choice, MTCollectionCardMatch mTCollectionCardMatch, Integer num) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        this.choice = choice;
        this.selectedMatch = mTCollectionCardMatch;
        this.listCardId = num;
    }

    public /* synthetic */ CollectionStatusDialogResult(CollectionStatusChoice collectionStatusChoice, MTCollectionCardMatch mTCollectionCardMatch, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collectionStatusChoice, (i & 2) != 0 ? null : mTCollectionCardMatch, (i & 4) != 0 ? null : num);
    }

    public static /* synthetic */ CollectionStatusDialogResult copy$default(CollectionStatusDialogResult collectionStatusDialogResult, CollectionStatusChoice collectionStatusChoice, MTCollectionCardMatch mTCollectionCardMatch, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            collectionStatusChoice = collectionStatusDialogResult.choice;
        }
        if ((i & 2) != 0) {
            mTCollectionCardMatch = collectionStatusDialogResult.selectedMatch;
        }
        if ((i & 4) != 0) {
            num = collectionStatusDialogResult.listCardId;
        }
        return collectionStatusDialogResult.copy(collectionStatusChoice, mTCollectionCardMatch, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CollectionStatusChoice getChoice() {
        return this.choice;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCollectionCardMatch getSelectedMatch() {
        return this.selectedMatch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getListCardId() {
        return this.listCardId;
    }

    public final CollectionStatusDialogResult copy(CollectionStatusChoice choice, MTCollectionCardMatch selectedMatch, Integer listCardId) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        return new CollectionStatusDialogResult(choice, selectedMatch, listCardId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionStatusDialogResult)) {
            return false;
        }
        CollectionStatusDialogResult collectionStatusDialogResult = (CollectionStatusDialogResult) other;
        return this.choice == collectionStatusDialogResult.choice && Intrinsics.areEqual(this.selectedMatch, collectionStatusDialogResult.selectedMatch) && Intrinsics.areEqual(this.listCardId, collectionStatusDialogResult.listCardId);
    }

    public final CollectionStatusChoice getChoice() {
        return this.choice;
    }

    public final Integer getListCardId() {
        return this.listCardId;
    }

    public final MTCollectionCardMatch getSelectedMatch() {
        return this.selectedMatch;
    }

    public int hashCode() {
        int iHashCode = this.choice.hashCode() * 31;
        MTCollectionCardMatch mTCollectionCardMatch = this.selectedMatch;
        int iHashCode2 = (iHashCode + (mTCollectionCardMatch == null ? 0 : mTCollectionCardMatch.hashCode())) * 31;
        Integer num = this.listCardId;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "CollectionStatusDialogResult(choice=" + this.choice + ", selectedMatch=" + this.selectedMatch + ", listCardId=" + this.listCardId + ")";
    }
}
