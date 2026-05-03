package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTColorOverrideBody;", "", "commander_color_override", "", "partner_color_override", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCommander_color_override", "()Ljava/lang/String;", "setCommander_color_override", "(Ljava/lang/String;)V", "getPartner_color_override", "setPartner_color_override", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTColorOverrideBody {
    public static final int $stable = 8;
    private String commander_color_override;
    private String partner_color_override;

    /* JADX WARN: Multi-variable type inference failed */
    public MTColorOverrideBody() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTColorOverrideBody(String str, String str2) {
        this.commander_color_override = str;
        this.partner_color_override = str2;
    }

    public /* synthetic */ MTColorOverrideBody(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ MTColorOverrideBody copy$default(MTColorOverrideBody mTColorOverrideBody, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTColorOverrideBody.commander_color_override;
        }
        if ((i & 2) != 0) {
            str2 = mTColorOverrideBody.partner_color_override;
        }
        return mTColorOverrideBody.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCommander_color_override() {
        return this.commander_color_override;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPartner_color_override() {
        return this.partner_color_override;
    }

    public final MTColorOverrideBody copy(String commander_color_override, String partner_color_override) {
        return new MTColorOverrideBody(commander_color_override, partner_color_override);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTColorOverrideBody)) {
            return false;
        }
        MTColorOverrideBody mTColorOverrideBody = (MTColorOverrideBody) other;
        return Intrinsics.areEqual(this.commander_color_override, mTColorOverrideBody.commander_color_override) && Intrinsics.areEqual(this.partner_color_override, mTColorOverrideBody.partner_color_override);
    }

    public final String getCommander_color_override() {
        return this.commander_color_override;
    }

    public final String getPartner_color_override() {
        return this.partner_color_override;
    }

    public int hashCode() {
        String str = this.commander_color_override;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.partner_color_override;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCommander_color_override(String str) {
        this.commander_color_override = str;
    }

    public final void setPartner_color_override(String str) {
        this.partner_color_override = str;
    }

    public String toString() {
        return "MTColorOverrideBody(commander_color_override=" + this.commander_color_override + ", partner_color_override=" + this.partner_color_override + ")";
    }
}
