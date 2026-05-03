package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MultiCardCollectionStatusDialogResult;", "", "results", "", "Lcom/studiolaganne/lengendarylens/CollectionStatusDialogResult;", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MultiCardCollectionStatusDialogResult {
    public static final int $stable = 8;
    private final List<CollectionStatusDialogResult> results;

    public MultiCardCollectionStatusDialogResult(List<CollectionStatusDialogResult> results) {
        Intrinsics.checkNotNullParameter(results, "results");
        this.results = results;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiCardCollectionStatusDialogResult copy$default(MultiCardCollectionStatusDialogResult multiCardCollectionStatusDialogResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = multiCardCollectionStatusDialogResult.results;
        }
        return multiCardCollectionStatusDialogResult.copy(list);
    }

    public final List<CollectionStatusDialogResult> component1() {
        return this.results;
    }

    public final MultiCardCollectionStatusDialogResult copy(List<CollectionStatusDialogResult> results) {
        Intrinsics.checkNotNullParameter(results, "results");
        return new MultiCardCollectionStatusDialogResult(results);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MultiCardCollectionStatusDialogResult) && Intrinsics.areEqual(this.results, ((MultiCardCollectionStatusDialogResult) other).results);
    }

    public final List<CollectionStatusDialogResult> getResults() {
        return this.results;
    }

    public int hashCode() {
        return this.results.hashCode();
    }

    public String toString() {
        return "MultiCardCollectionStatusDialogResult(results=" + this.results + ")";
    }
}
