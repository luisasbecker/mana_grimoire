package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RulesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/RuleObject;", "", "type", "", "originalIndex", "sectionNumber", "", "isSelected", "", "<init>", "(IILjava/lang/String;Z)V", "getType", "()I", "setType", "(I)V", "getOriginalIndex", "setOriginalIndex", "getSectionNumber", "()Ljava/lang/String;", "setSectionNumber", "(Ljava/lang/String;)V", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RuleObject {
    public static final int $stable = 8;
    private boolean isSelected;
    private int originalIndex;
    private String sectionNumber;
    private int type;

    public RuleObject(int i, int i2, String sectionNumber, boolean z) {
        Intrinsics.checkNotNullParameter(sectionNumber, "sectionNumber");
        this.type = i;
        this.originalIndex = i2;
        this.sectionNumber = sectionNumber;
        this.isSelected = z;
    }

    public /* synthetic */ RuleObject(int i, int i2, String str, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? -1 : i2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? false : z);
    }

    public static /* synthetic */ RuleObject copy$default(RuleObject ruleObject, int i, int i2, String str, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ruleObject.type;
        }
        if ((i3 & 2) != 0) {
            i2 = ruleObject.originalIndex;
        }
        if ((i3 & 4) != 0) {
            str = ruleObject.sectionNumber;
        }
        if ((i3 & 8) != 0) {
            z = ruleObject.isSelected;
        }
        return ruleObject.copy(i, i2, str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getOriginalIndex() {
        return this.originalIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSectionNumber() {
        return this.sectionNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final RuleObject copy(int type, int originalIndex, String sectionNumber, boolean isSelected) {
        Intrinsics.checkNotNullParameter(sectionNumber, "sectionNumber");
        return new RuleObject(type, originalIndex, sectionNumber, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleObject)) {
            return false;
        }
        RuleObject ruleObject = (RuleObject) other;
        return this.type == ruleObject.type && this.originalIndex == ruleObject.originalIndex && Intrinsics.areEqual(this.sectionNumber, ruleObject.sectionNumber) && this.isSelected == ruleObject.isSelected;
    }

    public final int getOriginalIndex() {
        return this.originalIndex;
    }

    public final String getSectionNumber() {
        return this.sectionNumber;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.originalIndex)) * 31) + this.sectionNumber.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setOriginalIndex(int i) {
        this.originalIndex = i;
    }

    public final void setSectionNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sectionNumber = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "RuleObject(type=" + this.type + ", originalIndex=" + this.originalIndex + ", sectionNumber=" + this.sectionNumber + ", isSelected=" + this.isSelected + ")";
    }
}
