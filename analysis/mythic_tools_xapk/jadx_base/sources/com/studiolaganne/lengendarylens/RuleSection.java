package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/RuleSection;", "", "number", "", Constants.GP_IAP_TITLE, "", "<init>", "(ILjava/lang/String;)V", "getNumber", "()I", "setNumber", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RuleSection {
    public static final int $stable = 8;
    private int number;
    private String title;

    /* JADX WARN: Multi-variable type inference failed */
    public RuleSection() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public RuleSection(int i, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.number = i;
        this.title = title;
    }

    public /* synthetic */ RuleSection(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ RuleSection copy$default(RuleSection ruleSection, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ruleSection.number;
        }
        if ((i2 & 2) != 0) {
            str = ruleSection.title;
        }
        return ruleSection.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final RuleSection copy(int number, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new RuleSection(number, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleSection)) {
            return false;
        }
        RuleSection ruleSection = (RuleSection) other;
        return this.number == ruleSection.number && Intrinsics.areEqual(this.title, ruleSection.title);
    }

    public final int getNumber() {
        return this.number;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (Integer.hashCode(this.number) * 31) + this.title.hashCode();
    }

    public final void setNumber(int i) {
        this.number = i;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "RuleSection(number=" + this.number + ", title=" + this.title + ")";
    }
}
