package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTAnswer;", "", "id", "", "answer", "", "localization", "", "Lcom/studiolaganne/lengendarylens/MTLocalizedAnswer;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getId", "()I", "getAnswer", "()Ljava/lang/String;", "getLocalization", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTAnswer {
    public static final int $stable = 8;
    private final String answer;
    private final int id;
    private final List<MTLocalizedAnswer> localization;

    public MTAnswer(int i, String answer, List<MTLocalizedAnswer> list) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.id = i;
        this.answer = answer;
        this.localization = list;
    }

    public /* synthetic */ MTAnswer(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTAnswer copy$default(MTAnswer mTAnswer, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTAnswer.id;
        }
        if ((i2 & 2) != 0) {
            str = mTAnswer.answer;
        }
        if ((i2 & 4) != 0) {
            list = mTAnswer.localization;
        }
        return mTAnswer.copy(i, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    public final List<MTLocalizedAnswer> component3() {
        return this.localization;
    }

    public final MTAnswer copy(int id, String answer, List<MTLocalizedAnswer> localization) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new MTAnswer(id, answer, localization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTAnswer)) {
            return false;
        }
        MTAnswer mTAnswer = (MTAnswer) other;
        return this.id == mTAnswer.id && Intrinsics.areEqual(this.answer, mTAnswer.answer) && Intrinsics.areEqual(this.localization, mTAnswer.localization);
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTLocalizedAnswer> getLocalization() {
        return this.localization;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.answer.hashCode()) * 31;
        List<MTLocalizedAnswer> list = this.localization;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "MTAnswer(id=" + this.id + ", answer=" + this.answer + ", localization=" + this.localization + ")";
    }
}
