package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003J\\\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTInvitePreview;", "", "inviter_userid", "", "invitee_userid", "inviter_lists", "", "Lcom/studiolaganne/lengendarylens/MTMergePreviewList;", "invitee_lists", "merge_candidates", "Lcom/studiolaganne/lengendarylens/MTMergeCandidate;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getInviter_userid", "()Ljava/lang/Integer;", "setInviter_userid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInvitee_userid", "setInvitee_userid", "getInviter_lists", "()Ljava/util/List;", "setInviter_lists", "(Ljava/util/List;)V", "getInvitee_lists", "setInvitee_lists", "getMerge_candidates", "setMerge_candidates", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTInvitePreview;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTInvitePreview {
    public static final int $stable = 8;
    private List<MTMergePreviewList> invitee_lists;
    private Integer invitee_userid;
    private List<MTMergePreviewList> inviter_lists;
    private Integer inviter_userid;
    private List<MTMergeCandidate> merge_candidates;

    public MTInvitePreview() {
        this(null, null, null, null, null, 31, null);
    }

    public MTInvitePreview(Integer num, Integer num2, List<MTMergePreviewList> list, List<MTMergePreviewList> list2, List<MTMergeCandidate> list3) {
        this.inviter_userid = num;
        this.invitee_userid = num2;
        this.inviter_lists = list;
        this.invitee_lists = list2;
        this.merge_candidates = list3;
    }

    public /* synthetic */ MTInvitePreview(Integer num, Integer num2, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTInvitePreview copy$default(MTInvitePreview mTInvitePreview, Integer num, Integer num2, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTInvitePreview.inviter_userid;
        }
        if ((i & 2) != 0) {
            num2 = mTInvitePreview.invitee_userid;
        }
        if ((i & 4) != 0) {
            list = mTInvitePreview.inviter_lists;
        }
        if ((i & 8) != 0) {
            list2 = mTInvitePreview.invitee_lists;
        }
        if ((i & 16) != 0) {
            list3 = mTInvitePreview.merge_candidates;
        }
        List list4 = list3;
        List list5 = list;
        return mTInvitePreview.copy(num, num2, list5, list2, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getInviter_userid() {
        return this.inviter_userid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getInvitee_userid() {
        return this.invitee_userid;
    }

    public final List<MTMergePreviewList> component3() {
        return this.inviter_lists;
    }

    public final List<MTMergePreviewList> component4() {
        return this.invitee_lists;
    }

    public final List<MTMergeCandidate> component5() {
        return this.merge_candidates;
    }

    public final MTInvitePreview copy(Integer inviter_userid, Integer invitee_userid, List<MTMergePreviewList> inviter_lists, List<MTMergePreviewList> invitee_lists, List<MTMergeCandidate> merge_candidates) {
        return new MTInvitePreview(inviter_userid, invitee_userid, inviter_lists, invitee_lists, merge_candidates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTInvitePreview)) {
            return false;
        }
        MTInvitePreview mTInvitePreview = (MTInvitePreview) other;
        return Intrinsics.areEqual(this.inviter_userid, mTInvitePreview.inviter_userid) && Intrinsics.areEqual(this.invitee_userid, mTInvitePreview.invitee_userid) && Intrinsics.areEqual(this.inviter_lists, mTInvitePreview.inviter_lists) && Intrinsics.areEqual(this.invitee_lists, mTInvitePreview.invitee_lists) && Intrinsics.areEqual(this.merge_candidates, mTInvitePreview.merge_candidates);
    }

    public final List<MTMergePreviewList> getInvitee_lists() {
        return this.invitee_lists;
    }

    public final Integer getInvitee_userid() {
        return this.invitee_userid;
    }

    public final List<MTMergePreviewList> getInviter_lists() {
        return this.inviter_lists;
    }

    public final Integer getInviter_userid() {
        return this.inviter_userid;
    }

    public final List<MTMergeCandidate> getMerge_candidates() {
        return this.merge_candidates;
    }

    public int hashCode() {
        Integer num = this.inviter_userid;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.invitee_userid;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<MTMergePreviewList> list = this.inviter_lists;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<MTMergePreviewList> list2 = this.invitee_lists;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTMergeCandidate> list3 = this.merge_candidates;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setInvitee_lists(List<MTMergePreviewList> list) {
        this.invitee_lists = list;
    }

    public final void setInvitee_userid(Integer num) {
        this.invitee_userid = num;
    }

    public final void setInviter_lists(List<MTMergePreviewList> list) {
        this.inviter_lists = list;
    }

    public final void setInviter_userid(Integer num) {
        this.inviter_userid = num;
    }

    public final void setMerge_candidates(List<MTMergeCandidate> list) {
        this.merge_candidates = list;
    }

    public String toString() {
        return "MTInvitePreview(inviter_userid=" + this.inviter_userid + ", invitee_userid=" + this.invitee_userid + ", inviter_lists=" + this.inviter_lists + ", invitee_lists=" + this.invitee_lists + ", merge_candidates=" + this.merge_candidates + ")";
    }
}
