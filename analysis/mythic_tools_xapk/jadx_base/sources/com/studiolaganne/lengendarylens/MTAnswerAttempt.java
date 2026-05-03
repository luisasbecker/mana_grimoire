package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTAnswerAttempt;", "", "answer_id", "", "trivia_question_id", "<init>", "(II)V", "getAnswer_id", "()I", "getTrivia_question_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTAnswerAttempt {
    public static final int $stable = 0;
    private final int answer_id;
    private final int trivia_question_id;

    public MTAnswerAttempt(int i, int i2) {
        this.answer_id = i;
        this.trivia_question_id = i2;
    }

    public static /* synthetic */ MTAnswerAttempt copy$default(MTAnswerAttempt mTAnswerAttempt, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTAnswerAttempt.answer_id;
        }
        if ((i3 & 2) != 0) {
            i2 = mTAnswerAttempt.trivia_question_id;
        }
        return mTAnswerAttempt.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAnswer_id() {
        return this.answer_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTrivia_question_id() {
        return this.trivia_question_id;
    }

    public final MTAnswerAttempt copy(int answer_id, int trivia_question_id) {
        return new MTAnswerAttempt(answer_id, trivia_question_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTAnswerAttempt)) {
            return false;
        }
        MTAnswerAttempt mTAnswerAttempt = (MTAnswerAttempt) other;
        return this.answer_id == mTAnswerAttempt.answer_id && this.trivia_question_id == mTAnswerAttempt.trivia_question_id;
    }

    public final int getAnswer_id() {
        return this.answer_id;
    }

    public final int getTrivia_question_id() {
        return this.trivia_question_id;
    }

    public int hashCode() {
        return (Integer.hashCode(this.answer_id) * 31) + Integer.hashCode(this.trivia_question_id);
    }

    public String toString() {
        return "MTAnswerAttempt(answer_id=" + this.answer_id + ", trivia_question_id=" + this.trivia_question_id + ")";
    }
}
