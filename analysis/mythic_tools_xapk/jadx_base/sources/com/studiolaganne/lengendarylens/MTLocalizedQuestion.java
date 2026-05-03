package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTLocalizedQuestion;", "", AndroidContextPlugin.LOCALE_KEY, "", "question", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getQuestion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTLocalizedQuestion {
    public static final int $stable = 0;
    private final String locale;
    private final String question;

    public MTLocalizedQuestion(String locale, String question) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(question, "question");
        this.locale = locale;
        this.question = question;
    }

    public static /* synthetic */ MTLocalizedQuestion copy$default(MTLocalizedQuestion mTLocalizedQuestion, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTLocalizedQuestion.locale;
        }
        if ((i & 2) != 0) {
            str2 = mTLocalizedQuestion.question;
        }
        return mTLocalizedQuestion.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public final MTLocalizedQuestion copy(String locale, String question) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(question, "question");
        return new MTLocalizedQuestion(locale, question);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTLocalizedQuestion)) {
            return false;
        }
        MTLocalizedQuestion mTLocalizedQuestion = (MTLocalizedQuestion) other;
        return Intrinsics.areEqual(this.locale, mTLocalizedQuestion.locale) && Intrinsics.areEqual(this.question, mTLocalizedQuestion.question);
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        return (this.locale.hashCode() * 31) + this.question.hashCode();
    }

    public String toString() {
        return "MTLocalizedQuestion(locale=" + this.locale + ", question=" + this.question + ")";
    }
}
