package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTQuestion;", "", "id", "", "order", "question", "", "localization", "", "Lcom/studiolaganne/lengendarylens/MTLocalizedQuestion;", "answers", "Lcom/studiolaganne/lengendarylens/MTAnswer;", "<init>", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()I", "getOrder", "getQuestion", "()Ljava/lang/String;", "getLocalization", "()Ljava/util/List;", "getAnswers", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTQuestion {
    public static final int $stable = 8;
    private final List<MTAnswer> answers;
    private final int id;
    private final List<MTLocalizedQuestion> localization;
    private final int order;
    private final String question;

    public MTQuestion(int i, int i2, String question, List<MTLocalizedQuestion> list, List<MTAnswer> answers) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answers, "answers");
        this.id = i;
        this.order = i2;
        this.question = question;
        this.localization = list;
        this.answers = answers;
    }

    public /* synthetic */ MTQuestion(int i, int i2, String str, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i3 & 8) != 0 ? null : list, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTQuestion copy$default(MTQuestion mTQuestion, int i, int i2, String str, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTQuestion.id;
        }
        if ((i3 & 2) != 0) {
            i2 = mTQuestion.order;
        }
        if ((i3 & 4) != 0) {
            str = mTQuestion.question;
        }
        if ((i3 & 8) != 0) {
            list = mTQuestion.localization;
        }
        if ((i3 & 16) != 0) {
            list2 = mTQuestion.answers;
        }
        List list3 = list2;
        String str2 = str;
        return mTQuestion.copy(i, i2, str2, list, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public final List<MTLocalizedQuestion> component4() {
        return this.localization;
    }

    public final List<MTAnswer> component5() {
        return this.answers;
    }

    public final MTQuestion copy(int id, int order, String question, List<MTLocalizedQuestion> localization, List<MTAnswer> answers) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answers, "answers");
        return new MTQuestion(id, order, question, localization, answers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTQuestion)) {
            return false;
        }
        MTQuestion mTQuestion = (MTQuestion) other;
        return this.id == mTQuestion.id && this.order == mTQuestion.order && Intrinsics.areEqual(this.question, mTQuestion.question) && Intrinsics.areEqual(this.localization, mTQuestion.localization) && Intrinsics.areEqual(this.answers, mTQuestion.answers);
    }

    public final List<MTAnswer> getAnswers() {
        return this.answers;
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTLocalizedQuestion> getLocalization() {
        return this.localization;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.order)) * 31) + this.question.hashCode()) * 31;
        List<MTLocalizedQuestion> list = this.localization;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.answers.hashCode();
    }

    public String toString() {
        return "MTQuestion(id=" + this.id + ", order=" + this.order + ", question=" + this.question + ", localization=" + this.localization + ", answers=" + this.answers + ")";
    }
}
