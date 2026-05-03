package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "", "id", "", "name", "", "description", "localization", "", "Lcom/studiolaganne/lengendarylens/MTEntryLocalization;", "logo_url", "trivia", "Lcom/studiolaganne/lengendarylens/MTTrivia;", "challenges", "Lcom/studiolaganne/lengendarylens/MTChallenge;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getLocalization", "()Ljava/util/List;", "setLocalization", "(Ljava/util/List;)V", "getLogo_url", "setLogo_url", "getTrivia", "setTrivia", "getChallenges", "setChallenges", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCommunityEvent {
    public static final int $stable = 8;
    private List<MTChallenge> challenges;
    private String description;
    private int id;
    private List<MTEntryLocalization> localization;
    private String logo_url;
    private String name;
    private List<MTTrivia> trivia;

    public MTCommunityEvent(int i, String str, String str2, List<MTEntryLocalization> localization, String str3, List<MTTrivia> list, List<MTChallenge> list2) {
        Intrinsics.checkNotNullParameter(localization, "localization");
        this.id = i;
        this.name = str;
        this.description = str2;
        this.localization = localization;
        this.logo_url = str3;
        this.trivia = list;
        this.challenges = list2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTCommunityEvent(int r9, java.lang.String r10, java.lang.String r11, java.util.List r12, java.lang.String r13, java.util.List r14, java.util.List r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 8
            if (r0 == 0) goto L8
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r4 = r12
            r12 = r16 & 32
            r0 = 0
            if (r12 == 0) goto L10
            r6 = r0
            goto L11
        L10:
            r6 = r14
        L11:
            r12 = r16 & 64
            if (r12 == 0) goto L1c
            r7 = r0
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r13
            r0 = r8
            goto L22
        L1c:
            r7 = r15
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r13
        L22:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTCommunityEvent.<init>(int, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCommunityEvent copy$default(MTCommunityEvent mTCommunityEvent, int i, String str, String str2, List list, String str3, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCommunityEvent.id;
        }
        if ((i2 & 2) != 0) {
            str = mTCommunityEvent.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mTCommunityEvent.description;
        }
        if ((i2 & 8) != 0) {
            list = mTCommunityEvent.localization;
        }
        if ((i2 & 16) != 0) {
            str3 = mTCommunityEvent.logo_url;
        }
        if ((i2 & 32) != 0) {
            list2 = mTCommunityEvent.trivia;
        }
        if ((i2 & 64) != 0) {
            list3 = mTCommunityEvent.challenges;
        }
        List list4 = list2;
        List list5 = list3;
        String str4 = str3;
        String str5 = str2;
        return mTCommunityEvent.copy(i, str, str5, list, str4, list4, list5);
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
    public final String getDescription() {
        return this.description;
    }

    public final List<MTEntryLocalization> component4() {
        return this.localization;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogo_url() {
        return this.logo_url;
    }

    public final List<MTTrivia> component6() {
        return this.trivia;
    }

    public final List<MTChallenge> component7() {
        return this.challenges;
    }

    public final MTCommunityEvent copy(int id, String name, String description, List<MTEntryLocalization> localization, String logo_url, List<MTTrivia> trivia, List<MTChallenge> challenges) {
        Intrinsics.checkNotNullParameter(localization, "localization");
        return new MTCommunityEvent(id, name, description, localization, logo_url, trivia, challenges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCommunityEvent)) {
            return false;
        }
        MTCommunityEvent mTCommunityEvent = (MTCommunityEvent) other;
        return this.id == mTCommunityEvent.id && Intrinsics.areEqual(this.name, mTCommunityEvent.name) && Intrinsics.areEqual(this.description, mTCommunityEvent.description) && Intrinsics.areEqual(this.localization, mTCommunityEvent.localization) && Intrinsics.areEqual(this.logo_url, mTCommunityEvent.logo_url) && Intrinsics.areEqual(this.trivia, mTCommunityEvent.trivia) && Intrinsics.areEqual(this.challenges, mTCommunityEvent.challenges);
    }

    public final List<MTChallenge> getChallenges() {
        return this.challenges;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTEntryLocalization> getLocalization() {
        return this.localization;
    }

    public final String getLogo_url() {
        return this.logo_url;
    }

    public final String getName() {
        return this.name;
    }

    public final List<MTTrivia> getTrivia() {
        return this.trivia;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.localization.hashCode()) * 31;
        String str3 = this.logo_url;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MTTrivia> list = this.trivia;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<MTChallenge> list2 = this.challenges;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setChallenges(List<MTChallenge> list) {
        this.challenges = list;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLocalization(List<MTEntryLocalization> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.localization = list;
    }

    public final void setLogo_url(String str) {
        this.logo_url = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setTrivia(List<MTTrivia> list) {
        this.trivia = list;
    }

    public String toString() {
        return "MTCommunityEvent(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", localization=" + this.localization + ", logo_url=" + this.logo_url + ", trivia=" + this.trivia + ", challenges=" + this.challenges + ")";
    }
}
