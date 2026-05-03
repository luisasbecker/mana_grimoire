package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTChallenge;", "", "id", "", "challenge_id", "name", "", "localization", "", "Lcom/studiolaganne/lengendarylens/MTEntryLocalization;", FirebaseAnalytics.Param.START_DATE, FirebaseAnalytics.Param.END_DATE, "tasks", "Lcom/studiolaganne/lengendarylens/MTChallengeTask;", "<init>", "(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "getChallenge_id", "getName", "()Ljava/lang/String;", "getLocalization", "()Ljava/util/List;", "setLocalization", "(Ljava/util/List;)V", "getStart_date", "getEnd_date", "getTasks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTChallenge {
    public static final int $stable = 8;
    private final int challenge_id;
    private final String end_date;
    private final int id;
    private List<MTEntryLocalization> localization;
    private final String name;
    private final String start_date;
    private final List<MTChallengeTask> tasks;

    public MTChallenge(int i, int i2, String name, List<MTEntryLocalization> localization, String start_date, String end_date, List<MTChallengeTask> tasks) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        this.id = i;
        this.challenge_id = i2;
        this.name = name;
        this.localization = localization;
        this.start_date = start_date;
        this.end_date = end_date;
        this.tasks = tasks;
    }

    public /* synthetic */ MTChallenge(int i, int i2, String str, List list, String str2, String str3, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list, str2, str3, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTChallenge copy$default(MTChallenge mTChallenge, int i, int i2, String str, List list, String str2, String str3, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTChallenge.id;
        }
        if ((i3 & 2) != 0) {
            i2 = mTChallenge.challenge_id;
        }
        if ((i3 & 4) != 0) {
            str = mTChallenge.name;
        }
        if ((i3 & 8) != 0) {
            list = mTChallenge.localization;
        }
        if ((i3 & 16) != 0) {
            str2 = mTChallenge.start_date;
        }
        if ((i3 & 32) != 0) {
            str3 = mTChallenge.end_date;
        }
        if ((i3 & 64) != 0) {
            list2 = mTChallenge.tasks;
        }
        String str4 = str3;
        List list3 = list2;
        String str5 = str2;
        String str6 = str;
        return mTChallenge.copy(i, i2, str6, list, str5, str4, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getChallenge_id() {
        return this.challenge_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<MTEntryLocalization> component4() {
        return this.localization;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    public final List<MTChallengeTask> component7() {
        return this.tasks;
    }

    public final MTChallenge copy(int id, int challenge_id, String name, List<MTEntryLocalization> localization, String start_date, String end_date, List<MTChallengeTask> tasks) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        return new MTChallenge(id, challenge_id, name, localization, start_date, end_date, tasks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTChallenge)) {
            return false;
        }
        MTChallenge mTChallenge = (MTChallenge) other;
        return this.id == mTChallenge.id && this.challenge_id == mTChallenge.challenge_id && Intrinsics.areEqual(this.name, mTChallenge.name) && Intrinsics.areEqual(this.localization, mTChallenge.localization) && Intrinsics.areEqual(this.start_date, mTChallenge.start_date) && Intrinsics.areEqual(this.end_date, mTChallenge.end_date) && Intrinsics.areEqual(this.tasks, mTChallenge.tasks);
    }

    public final int getChallenge_id() {
        return this.challenge_id;
    }

    public final String getEnd_date() {
        return this.end_date;
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTEntryLocalization> getLocalization() {
        return this.localization;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStart_date() {
        return this.start_date;
    }

    public final List<MTChallengeTask> getTasks() {
        return this.tasks;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.challenge_id)) * 31) + this.name.hashCode()) * 31) + this.localization.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.tasks.hashCode();
    }

    public final void setLocalization(List<MTEntryLocalization> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.localization = list;
    }

    public String toString() {
        return "MTChallenge(id=" + this.id + ", challenge_id=" + this.challenge_id + ", name=" + this.name + ", localization=" + this.localization + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", tasks=" + this.tasks + ")";
    }
}
