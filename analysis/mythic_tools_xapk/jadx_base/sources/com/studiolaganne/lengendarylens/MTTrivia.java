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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0011HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\bHÆ\u0003J\u008b\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\bHÆ\u0001J\u0013\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001c¨\u00067"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTrivia;", "", "id", "", "trivia_id", "name", "", "localization", "", "Lcom/studiolaganne/lengendarylens/MTEntryLocalization;", "max_attempts", FirebaseAnalytics.Param.START_DATE, FirebaseAnalytics.Param.END_DATE, "questions", "Lcom/studiolaganne/lengendarylens/MTQuestion;", "user_attempts", "validated", "", "attempts", "Lcom/studiolaganne/lengendarylens/MTTriviaAttempt;", "<init>", "(IILjava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;IZLjava/util/List;)V", "getId", "()I", "getTrivia_id", "getName", "()Ljava/lang/String;", "getLocalization", "()Ljava/util/List;", "setLocalization", "(Ljava/util/List;)V", "getMax_attempts", "getStart_date", "getEnd_date", "getQuestions", "getUser_attempts", "getValidated", "()Z", "getAttempts", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTrivia {
    public static final int $stable = 8;
    private final List<MTTriviaAttempt> attempts;
    private final String end_date;
    private final int id;
    private List<MTEntryLocalization> localization;
    private final int max_attempts;
    private final String name;
    private final List<MTQuestion> questions;
    private final String start_date;
    private final int trivia_id;
    private final int user_attempts;
    private final boolean validated;

    public MTTrivia(int i, int i2, String name, List<MTEntryLocalization> localization, int i3, String start_date, String end_date, List<MTQuestion> questions, int i4, boolean z, List<MTTriviaAttempt> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(questions, "questions");
        this.id = i;
        this.trivia_id = i2;
        this.name = name;
        this.localization = localization;
        this.max_attempts = i3;
        this.start_date = start_date;
        this.end_date = end_date;
        this.questions = questions;
        this.user_attempts = i4;
        this.validated = z;
        this.attempts = list;
    }

    public /* synthetic */ MTTrivia(int i, int i2, String str, List list, int i3, String str2, String str3, List list2, int i4, boolean z, List list3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list, i3, str2, str3, (i5 & 128) != 0 ? CollectionsKt.emptyList() : list2, i4, (i5 & 512) != 0 ? false : z, (i5 & 1024) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTTrivia copy$default(MTTrivia mTTrivia, int i, int i2, String str, List list, int i3, String str2, String str3, List list2, int i4, boolean z, List list3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTTrivia.id;
        }
        if ((i5 & 2) != 0) {
            i2 = mTTrivia.trivia_id;
        }
        if ((i5 & 4) != 0) {
            str = mTTrivia.name;
        }
        if ((i5 & 8) != 0) {
            list = mTTrivia.localization;
        }
        if ((i5 & 16) != 0) {
            i3 = mTTrivia.max_attempts;
        }
        if ((i5 & 32) != 0) {
            str2 = mTTrivia.start_date;
        }
        if ((i5 & 64) != 0) {
            str3 = mTTrivia.end_date;
        }
        if ((i5 & 128) != 0) {
            list2 = mTTrivia.questions;
        }
        if ((i5 & 256) != 0) {
            i4 = mTTrivia.user_attempts;
        }
        if ((i5 & 512) != 0) {
            z = mTTrivia.validated;
        }
        if ((i5 & 1024) != 0) {
            list3 = mTTrivia.attempts;
        }
        boolean z2 = z;
        List list4 = list3;
        List list5 = list2;
        int i6 = i4;
        String str4 = str2;
        String str5 = str3;
        int i7 = i3;
        String str6 = str;
        return mTTrivia.copy(i, i2, str6, list, i7, str4, str5, list5, i6, z2, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getValidated() {
        return this.validated;
    }

    public final List<MTTriviaAttempt> component11() {
        return this.attempts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTrivia_id() {
        return this.trivia_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<MTEntryLocalization> component4() {
        return this.localization;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMax_attempts() {
        return this.max_attempts;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    public final List<MTQuestion> component8() {
        return this.questions;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getUser_attempts() {
        return this.user_attempts;
    }

    public final MTTrivia copy(int id, int trivia_id, String name, List<MTEntryLocalization> localization, int max_attempts, String start_date, String end_date, List<MTQuestion> questions, int user_attempts, boolean validated, List<MTTriviaAttempt> attempts) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(questions, "questions");
        return new MTTrivia(id, trivia_id, name, localization, max_attempts, start_date, end_date, questions, user_attempts, validated, attempts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTTrivia)) {
            return false;
        }
        MTTrivia mTTrivia = (MTTrivia) other;
        return this.id == mTTrivia.id && this.trivia_id == mTTrivia.trivia_id && Intrinsics.areEqual(this.name, mTTrivia.name) && Intrinsics.areEqual(this.localization, mTTrivia.localization) && this.max_attempts == mTTrivia.max_attempts && Intrinsics.areEqual(this.start_date, mTTrivia.start_date) && Intrinsics.areEqual(this.end_date, mTTrivia.end_date) && Intrinsics.areEqual(this.questions, mTTrivia.questions) && this.user_attempts == mTTrivia.user_attempts && this.validated == mTTrivia.validated && Intrinsics.areEqual(this.attempts, mTTrivia.attempts);
    }

    public final List<MTTriviaAttempt> getAttempts() {
        return this.attempts;
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

    public final int getMax_attempts() {
        return this.max_attempts;
    }

    public final String getName() {
        return this.name;
    }

    public final List<MTQuestion> getQuestions() {
        return this.questions;
    }

    public final String getStart_date() {
        return this.start_date;
    }

    public final int getTrivia_id() {
        return this.trivia_id;
    }

    public final int getUser_attempts() {
        return this.user_attempts;
    }

    public final boolean getValidated() {
        return this.validated;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.trivia_id)) * 31) + this.name.hashCode()) * 31) + this.localization.hashCode()) * 31) + Integer.hashCode(this.max_attempts)) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.questions.hashCode()) * 31) + Integer.hashCode(this.user_attempts)) * 31) + Boolean.hashCode(this.validated)) * 31;
        List<MTTriviaAttempt> list = this.attempts;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setLocalization(List<MTEntryLocalization> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.localization = list;
    }

    public String toString() {
        return "MTTrivia(id=" + this.id + ", trivia_id=" + this.trivia_id + ", name=" + this.name + ", localization=" + this.localization + ", max_attempts=" + this.max_attempts + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", questions=" + this.questions + ", user_attempts=" + this.user_attempts + ", validated=" + this.validated + ", attempts=" + this.attempts + ")";
    }
}
