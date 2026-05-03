package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDialogResult;", "", "initialChoice", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusInitialChoice;", "sameAction", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusSameAction;", "ownAction", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusOwnAction;", "dontOwnAction", "Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDontOwnAction;", "<init>", "(Lcom/studiolaganne/lengendarylens/BatchCollectionStatusInitialChoice;Lcom/studiolaganne/lengendarylens/BatchCollectionStatusSameAction;Lcom/studiolaganne/lengendarylens/BatchCollectionStatusOwnAction;Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDontOwnAction;)V", "getInitialChoice", "()Lcom/studiolaganne/lengendarylens/BatchCollectionStatusInitialChoice;", "getSameAction", "()Lcom/studiolaganne/lengendarylens/BatchCollectionStatusSameAction;", "getOwnAction", "()Lcom/studiolaganne/lengendarylens/BatchCollectionStatusOwnAction;", "getDontOwnAction", "()Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDontOwnAction;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BatchCollectionStatusDialogResult {
    public static final int $stable = 0;
    private final BatchCollectionStatusDontOwnAction dontOwnAction;
    private final BatchCollectionStatusInitialChoice initialChoice;
    private final BatchCollectionStatusOwnAction ownAction;
    private final BatchCollectionStatusSameAction sameAction;

    public BatchCollectionStatusDialogResult(BatchCollectionStatusInitialChoice initialChoice, BatchCollectionStatusSameAction batchCollectionStatusSameAction, BatchCollectionStatusOwnAction batchCollectionStatusOwnAction, BatchCollectionStatusDontOwnAction batchCollectionStatusDontOwnAction) {
        Intrinsics.checkNotNullParameter(initialChoice, "initialChoice");
        this.initialChoice = initialChoice;
        this.sameAction = batchCollectionStatusSameAction;
        this.ownAction = batchCollectionStatusOwnAction;
        this.dontOwnAction = batchCollectionStatusDontOwnAction;
    }

    public /* synthetic */ BatchCollectionStatusDialogResult(BatchCollectionStatusInitialChoice batchCollectionStatusInitialChoice, BatchCollectionStatusSameAction batchCollectionStatusSameAction, BatchCollectionStatusOwnAction batchCollectionStatusOwnAction, BatchCollectionStatusDontOwnAction batchCollectionStatusDontOwnAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(batchCollectionStatusInitialChoice, (i & 2) != 0 ? null : batchCollectionStatusSameAction, (i & 4) != 0 ? null : batchCollectionStatusOwnAction, (i & 8) != 0 ? null : batchCollectionStatusDontOwnAction);
    }

    public static /* synthetic */ BatchCollectionStatusDialogResult copy$default(BatchCollectionStatusDialogResult batchCollectionStatusDialogResult, BatchCollectionStatusInitialChoice batchCollectionStatusInitialChoice, BatchCollectionStatusSameAction batchCollectionStatusSameAction, BatchCollectionStatusOwnAction batchCollectionStatusOwnAction, BatchCollectionStatusDontOwnAction batchCollectionStatusDontOwnAction, int i, Object obj) {
        if ((i & 1) != 0) {
            batchCollectionStatusInitialChoice = batchCollectionStatusDialogResult.initialChoice;
        }
        if ((i & 2) != 0) {
            batchCollectionStatusSameAction = batchCollectionStatusDialogResult.sameAction;
        }
        if ((i & 4) != 0) {
            batchCollectionStatusOwnAction = batchCollectionStatusDialogResult.ownAction;
        }
        if ((i & 8) != 0) {
            batchCollectionStatusDontOwnAction = batchCollectionStatusDialogResult.dontOwnAction;
        }
        return batchCollectionStatusDialogResult.copy(batchCollectionStatusInitialChoice, batchCollectionStatusSameAction, batchCollectionStatusOwnAction, batchCollectionStatusDontOwnAction);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BatchCollectionStatusInitialChoice getInitialChoice() {
        return this.initialChoice;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BatchCollectionStatusSameAction getSameAction() {
        return this.sameAction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BatchCollectionStatusOwnAction getOwnAction() {
        return this.ownAction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final BatchCollectionStatusDontOwnAction getDontOwnAction() {
        return this.dontOwnAction;
    }

    public final BatchCollectionStatusDialogResult copy(BatchCollectionStatusInitialChoice initialChoice, BatchCollectionStatusSameAction sameAction, BatchCollectionStatusOwnAction ownAction, BatchCollectionStatusDontOwnAction dontOwnAction) {
        Intrinsics.checkNotNullParameter(initialChoice, "initialChoice");
        return new BatchCollectionStatusDialogResult(initialChoice, sameAction, ownAction, dontOwnAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchCollectionStatusDialogResult)) {
            return false;
        }
        BatchCollectionStatusDialogResult batchCollectionStatusDialogResult = (BatchCollectionStatusDialogResult) other;
        return this.initialChoice == batchCollectionStatusDialogResult.initialChoice && this.sameAction == batchCollectionStatusDialogResult.sameAction && this.ownAction == batchCollectionStatusDialogResult.ownAction && this.dontOwnAction == batchCollectionStatusDialogResult.dontOwnAction;
    }

    public final BatchCollectionStatusDontOwnAction getDontOwnAction() {
        return this.dontOwnAction;
    }

    public final BatchCollectionStatusInitialChoice getInitialChoice() {
        return this.initialChoice;
    }

    public final BatchCollectionStatusOwnAction getOwnAction() {
        return this.ownAction;
    }

    public final BatchCollectionStatusSameAction getSameAction() {
        return this.sameAction;
    }

    public int hashCode() {
        int iHashCode = this.initialChoice.hashCode() * 31;
        BatchCollectionStatusSameAction batchCollectionStatusSameAction = this.sameAction;
        int iHashCode2 = (iHashCode + (batchCollectionStatusSameAction == null ? 0 : batchCollectionStatusSameAction.hashCode())) * 31;
        BatchCollectionStatusOwnAction batchCollectionStatusOwnAction = this.ownAction;
        int iHashCode3 = (iHashCode2 + (batchCollectionStatusOwnAction == null ? 0 : batchCollectionStatusOwnAction.hashCode())) * 31;
        BatchCollectionStatusDontOwnAction batchCollectionStatusDontOwnAction = this.dontOwnAction;
        return iHashCode3 + (batchCollectionStatusDontOwnAction != null ? batchCollectionStatusDontOwnAction.hashCode() : 0);
    }

    public String toString() {
        return "BatchCollectionStatusDialogResult(initialChoice=" + this.initialChoice + ", sameAction=" + this.sameAction + ", ownAction=" + this.ownAction + ", dontOwnAction=" + this.dontOwnAction + ")";
    }
}
