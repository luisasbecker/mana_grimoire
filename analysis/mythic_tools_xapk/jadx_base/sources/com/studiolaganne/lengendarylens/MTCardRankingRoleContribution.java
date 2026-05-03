package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingRoleContribution;", "", FirebaseAnalytics.Param.SCORE, "", "raw", Constants.ScionAnalytics.PARAM_LABEL, "", "roles", "", "Lcom/studiolaganne/lengendarylens/MTCardRankingRole;", "matchedThemes", "<init>", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getScore", "()I", "getRaw", "getLabel", "()Ljava/lang/String;", "getRoles", "()Ljava/util/List;", "getMatchedThemes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingRoleContribution {
    public static final int $stable = 8;
    private final String label;
    private final List<String> matchedThemes;
    private final int raw;
    private final List<MTCardRankingRole> roles;
    private final int score;

    public MTCardRankingRoleContribution() {
        this(0, 0, null, null, null, 31, null);
    }

    public MTCardRankingRoleContribution(int i, int i2, String str, List<MTCardRankingRole> roles, List<String> matchedThemes) {
        Intrinsics.checkNotNullParameter(roles, "roles");
        Intrinsics.checkNotNullParameter(matchedThemes, "matchedThemes");
        this.score = i;
        this.raw = i2;
        this.label = str;
        this.roles = roles;
        this.matchedThemes = matchedThemes;
    }

    public /* synthetic */ MTCardRankingRoleContribution(int i, int i2, String str, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardRankingRoleContribution copy$default(MTCardRankingRoleContribution mTCardRankingRoleContribution, int i, int i2, String str, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTCardRankingRoleContribution.score;
        }
        if ((i3 & 2) != 0) {
            i2 = mTCardRankingRoleContribution.raw;
        }
        if ((i3 & 4) != 0) {
            str = mTCardRankingRoleContribution.label;
        }
        if ((i3 & 8) != 0) {
            list = mTCardRankingRoleContribution.roles;
        }
        if ((i3 & 16) != 0) {
            list2 = mTCardRankingRoleContribution.matchedThemes;
        }
        List list3 = list2;
        String str2 = str;
        return mTCardRankingRoleContribution.copy(i, i2, str2, list, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRaw() {
        return this.raw;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final List<MTCardRankingRole> component4() {
        return this.roles;
    }

    public final List<String> component5() {
        return this.matchedThemes;
    }

    public final MTCardRankingRoleContribution copy(int score, int raw, String label, List<MTCardRankingRole> roles, List<String> matchedThemes) {
        Intrinsics.checkNotNullParameter(roles, "roles");
        Intrinsics.checkNotNullParameter(matchedThemes, "matchedThemes");
        return new MTCardRankingRoleContribution(score, raw, label, roles, matchedThemes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingRoleContribution)) {
            return false;
        }
        MTCardRankingRoleContribution mTCardRankingRoleContribution = (MTCardRankingRoleContribution) other;
        return this.score == mTCardRankingRoleContribution.score && this.raw == mTCardRankingRoleContribution.raw && Intrinsics.areEqual(this.label, mTCardRankingRoleContribution.label) && Intrinsics.areEqual(this.roles, mTCardRankingRoleContribution.roles) && Intrinsics.areEqual(this.matchedThemes, mTCardRankingRoleContribution.matchedThemes);
    }

    public final String getLabel() {
        return this.label;
    }

    public final List<String> getMatchedThemes() {
        return this.matchedThemes;
    }

    public final int getRaw() {
        return this.raw;
    }

    public final List<MTCardRankingRole> getRoles() {
        return this.roles;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.score) * 31) + Integer.hashCode(this.raw)) * 31;
        String str = this.label;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.roles.hashCode()) * 31) + this.matchedThemes.hashCode();
    }

    public String toString() {
        return "MTCardRankingRoleContribution(score=" + this.score + ", raw=" + this.raw + ", label=" + this.label + ", roles=" + this.roles + ", matchedThemes=" + this.matchedThemes + ")";
    }
}
