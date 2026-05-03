package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J%\u0010\f\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDecksByUserResponse;", "", "decksByUser", "", "", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "<init>", "(Ljava/util/Map;)V", "getDecksByUser", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDecksByUserResponse {
    public static final int $stable = 8;
    private final Map<String, List<MTDeck>> decksByUser;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDecksByUserResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MTDecksByUserResponse(Map<String, ? extends List<MTDeck>> decksByUser) {
        Intrinsics.checkNotNullParameter(decksByUser, "decksByUser");
        this.decksByUser = decksByUser;
    }

    public /* synthetic */ MTDecksByUserResponse(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDecksByUserResponse copy$default(MTDecksByUserResponse mTDecksByUserResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = mTDecksByUserResponse.decksByUser;
        }
        return mTDecksByUserResponse.copy(map);
    }

    public final Map<String, List<MTDeck>> component1() {
        return this.decksByUser;
    }

    public final MTDecksByUserResponse copy(Map<String, ? extends List<MTDeck>> decksByUser) {
        Intrinsics.checkNotNullParameter(decksByUser, "decksByUser");
        return new MTDecksByUserResponse(decksByUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTDecksByUserResponse) && Intrinsics.areEqual(this.decksByUser, ((MTDecksByUserResponse) other).decksByUser);
    }

    public final Map<String, List<MTDeck>> getDecksByUser() {
        return this.decksByUser;
    }

    public int hashCode() {
        return this.decksByUser.hashCode();
    }

    public String toString() {
        return "MTDecksByUserResponse(decksByUser=" + this.decksByUser + ")";
    }
}
