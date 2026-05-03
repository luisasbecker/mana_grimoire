package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCommunityEventResponse;", "", NotificationCompat.CATEGORY_EVENT, "Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "trivia", "", "Lcom/studiolaganne/lengendarylens/MTTrivia;", "challenges", "Lcom/studiolaganne/lengendarylens/MTChallenge;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCommunityEvent;Ljava/util/List;Ljava/util/List;)V", "getEvent", "()Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "setEvent", "(Lcom/studiolaganne/lengendarylens/MTCommunityEvent;)V", "getTrivia", "()Ljava/util/List;", "setTrivia", "(Ljava/util/List;)V", "getChallenges", "setChallenges", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCommunityEventResponse {
    public static final int $stable = 8;
    private List<MTChallenge> challenges;
    private MTCommunityEvent event;
    private List<MTTrivia> trivia;

    public MTCommunityEventResponse() {
        this(null, null, null, 7, null);
    }

    public MTCommunityEventResponse(MTCommunityEvent mTCommunityEvent, List<MTTrivia> list, List<MTChallenge> list2) {
        this.event = mTCommunityEvent;
        this.trivia = list;
        this.challenges = list2;
    }

    public /* synthetic */ MTCommunityEventResponse(MTCommunityEvent mTCommunityEvent, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCommunityEvent, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCommunityEventResponse copy$default(MTCommunityEventResponse mTCommunityEventResponse, MTCommunityEvent mTCommunityEvent, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCommunityEvent = mTCommunityEventResponse.event;
        }
        if ((i & 2) != 0) {
            list = mTCommunityEventResponse.trivia;
        }
        if ((i & 4) != 0) {
            list2 = mTCommunityEventResponse.challenges;
        }
        return mTCommunityEventResponse.copy(mTCommunityEvent, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCommunityEvent getEvent() {
        return this.event;
    }

    public final List<MTTrivia> component2() {
        return this.trivia;
    }

    public final List<MTChallenge> component3() {
        return this.challenges;
    }

    public final MTCommunityEventResponse copy(MTCommunityEvent event, List<MTTrivia> trivia, List<MTChallenge> challenges) {
        return new MTCommunityEventResponse(event, trivia, challenges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCommunityEventResponse)) {
            return false;
        }
        MTCommunityEventResponse mTCommunityEventResponse = (MTCommunityEventResponse) other;
        return Intrinsics.areEqual(this.event, mTCommunityEventResponse.event) && Intrinsics.areEqual(this.trivia, mTCommunityEventResponse.trivia) && Intrinsics.areEqual(this.challenges, mTCommunityEventResponse.challenges);
    }

    public final List<MTChallenge> getChallenges() {
        return this.challenges;
    }

    public final MTCommunityEvent getEvent() {
        return this.event;
    }

    public final List<MTTrivia> getTrivia() {
        return this.trivia;
    }

    public int hashCode() {
        MTCommunityEvent mTCommunityEvent = this.event;
        int iHashCode = (mTCommunityEvent == null ? 0 : mTCommunityEvent.hashCode()) * 31;
        List<MTTrivia> list = this.trivia;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<MTChallenge> list2 = this.challenges;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setChallenges(List<MTChallenge> list) {
        this.challenges = list;
    }

    public final void setEvent(MTCommunityEvent mTCommunityEvent) {
        this.event = mTCommunityEvent;
    }

    public final void setTrivia(List<MTTrivia> list) {
        this.trivia = list;
    }

    public String toString() {
        return "MTCommunityEventResponse(event=" + this.event + ", trivia=" + this.trivia + ", challenges=" + this.challenges + ")";
    }
}
