package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/RuleParagraph;", "", "sectionNumber", "", "rulesText", "rulesTextFolded", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSectionNumber", "()Ljava/lang/String;", "setSectionNumber", "(Ljava/lang/String;)V", "getRulesText", "setRulesText", "getRulesTextFolded", "setRulesTextFolded", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RuleParagraph {
    public static final int $stable = 8;
    private String rulesText;
    private String rulesTextFolded;
    private String sectionNumber;

    public RuleParagraph() {
        this(null, null, null, 7, null);
    }

    public RuleParagraph(String sectionNumber, String rulesText, String rulesTextFolded) {
        Intrinsics.checkNotNullParameter(sectionNumber, "sectionNumber");
        Intrinsics.checkNotNullParameter(rulesText, "rulesText");
        Intrinsics.checkNotNullParameter(rulesTextFolded, "rulesTextFolded");
        this.sectionNumber = sectionNumber;
        this.rulesText = rulesText;
        this.rulesTextFolded = rulesTextFolded;
    }

    public /* synthetic */ RuleParagraph(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ RuleParagraph copy$default(RuleParagraph ruleParagraph, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ruleParagraph.sectionNumber;
        }
        if ((i & 2) != 0) {
            str2 = ruleParagraph.rulesText;
        }
        if ((i & 4) != 0) {
            str3 = ruleParagraph.rulesTextFolded;
        }
        return ruleParagraph.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSectionNumber() {
        return this.sectionNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRulesText() {
        return this.rulesText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRulesTextFolded() {
        return this.rulesTextFolded;
    }

    public final RuleParagraph copy(String sectionNumber, String rulesText, String rulesTextFolded) {
        Intrinsics.checkNotNullParameter(sectionNumber, "sectionNumber");
        Intrinsics.checkNotNullParameter(rulesText, "rulesText");
        Intrinsics.checkNotNullParameter(rulesTextFolded, "rulesTextFolded");
        return new RuleParagraph(sectionNumber, rulesText, rulesTextFolded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleParagraph)) {
            return false;
        }
        RuleParagraph ruleParagraph = (RuleParagraph) other;
        return Intrinsics.areEqual(this.sectionNumber, ruleParagraph.sectionNumber) && Intrinsics.areEqual(this.rulesText, ruleParagraph.rulesText) && Intrinsics.areEqual(this.rulesTextFolded, ruleParagraph.rulesTextFolded);
    }

    public final String getRulesText() {
        return this.rulesText;
    }

    public final String getRulesTextFolded() {
        return this.rulesTextFolded;
    }

    public final String getSectionNumber() {
        return this.sectionNumber;
    }

    public int hashCode() {
        return (((this.sectionNumber.hashCode() * 31) + this.rulesText.hashCode()) * 31) + this.rulesTextFolded.hashCode();
    }

    public final void setRulesText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rulesText = str;
    }

    public final void setRulesTextFolded(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rulesTextFolded = str;
    }

    public final void setSectionNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sectionNumber = str;
    }

    public String toString() {
        return "RuleParagraph(sectionNumber=" + this.sectionNumber + ", rulesText=" + this.rulesText + ", rulesTextFolded=" + this.rulesTextFolded + ")";
    }
}
