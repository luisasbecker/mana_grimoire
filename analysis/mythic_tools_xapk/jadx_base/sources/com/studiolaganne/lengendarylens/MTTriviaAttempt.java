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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTriviaAttempt;", "", "attempt_number", "", "total", FirebaseAnalytics.Param.SCORE, "answers", "", "Lcom/studiolaganne/lengendarylens/MTAnswerAttempt;", "<init>", "(IIILjava/util/List;)V", "getAttempt_number", "()I", "getTotal", "getScore", "getAnswers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTriviaAttempt {
    public static final int $stable = 8;
    private final List<MTAnswerAttempt> answers;
    private final int attempt_number;
    private final int score;
    private final int total;

    public MTTriviaAttempt(int i, int i2, int i3, List<MTAnswerAttempt> list) {
        this.attempt_number = i;
        this.total = i2;
        this.score = i3;
        this.answers = list;
    }

    public /* synthetic */ MTTriviaAttempt(int i, int i2, int i3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTTriviaAttempt copy$default(MTTriviaAttempt mTTriviaAttempt, int i, int i2, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mTTriviaAttempt.attempt_number;
        }
        if ((i4 & 2) != 0) {
            i2 = mTTriviaAttempt.total;
        }
        if ((i4 & 4) != 0) {
            i3 = mTTriviaAttempt.score;
        }
        if ((i4 & 8) != 0) {
            list = mTTriviaAttempt.answers;
        }
        return mTTriviaAttempt.copy(i, i2, i3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAttempt_number() {
        return this.attempt_number;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    public final List<MTAnswerAttempt> component4() {
        return this.answers;
    }

    public final MTTriviaAttempt copy(int attempt_number, int total, int score, List<MTAnswerAttempt> answers) {
        return new MTTriviaAttempt(attempt_number, total, score, answers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTTriviaAttempt)) {
            return false;
        }
        MTTriviaAttempt mTTriviaAttempt = (MTTriviaAttempt) other;
        return this.attempt_number == mTTriviaAttempt.attempt_number && this.total == mTTriviaAttempt.total && this.score == mTTriviaAttempt.score && Intrinsics.areEqual(this.answers, mTTriviaAttempt.answers);
    }

    public final List<MTAnswerAttempt> getAnswers() {
        return this.answers;
    }

    public final int getAttempt_number() {
        return this.attempt_number;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.attempt_number) * 31) + Integer.hashCode(this.total)) * 31) + Integer.hashCode(this.score)) * 31;
        List<MTAnswerAttempt> list = this.answers;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "MTTriviaAttempt(attempt_number=" + this.attempt_number + ", total=" + this.total + ", score=" + this.score + ", answers=" + this.answers + ")";
    }
}
