package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserState;", "", "purchases", "", "Lcom/studiolaganne/lengendarylens/MTPurchase;", "settings", "Lcom/studiolaganne/lengendarylens/MTUserSettings;", "tutorials", "Lcom/studiolaganne/lengendarylens/MTTutorialState;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUserSettings;Ljava/util/List;)V", "getPurchases", "()Ljava/util/List;", "setPurchases", "(Ljava/util/List;)V", "getSettings", "()Lcom/studiolaganne/lengendarylens/MTUserSettings;", "setSettings", "(Lcom/studiolaganne/lengendarylens/MTUserSettings;)V", "getTutorials", "setTutorials", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserState {
    public static final int $stable = 8;
    private List<MTPurchase> purchases;
    private MTUserSettings settings;
    private List<MTTutorialState> tutorials;

    public MTUserState() {
        this(null, null, null, 7, null);
    }

    public MTUserState(List<MTPurchase> list, MTUserSettings mTUserSettings, List<MTTutorialState> list2) {
        this.purchases = list;
        this.settings = mTUserSettings;
        this.tutorials = list2;
    }

    public /* synthetic */ MTUserState(List list, MTUserSettings mTUserSettings, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : mTUserSettings, (i & 4) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUserState copy$default(MTUserState mTUserState, List list, MTUserSettings mTUserSettings, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTUserState.purchases;
        }
        if ((i & 2) != 0) {
            mTUserSettings = mTUserState.settings;
        }
        if ((i & 4) != 0) {
            list2 = mTUserState.tutorials;
        }
        return mTUserState.copy(list, mTUserSettings, list2);
    }

    public final List<MTPurchase> component1() {
        return this.purchases;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTUserSettings getSettings() {
        return this.settings;
    }

    public final List<MTTutorialState> component3() {
        return this.tutorials;
    }

    public final MTUserState copy(List<MTPurchase> purchases, MTUserSettings settings, List<MTTutorialState> tutorials) {
        return new MTUserState(purchases, settings, tutorials);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserState)) {
            return false;
        }
        MTUserState mTUserState = (MTUserState) other;
        return Intrinsics.areEqual(this.purchases, mTUserState.purchases) && Intrinsics.areEqual(this.settings, mTUserState.settings) && Intrinsics.areEqual(this.tutorials, mTUserState.tutorials);
    }

    public final List<MTPurchase> getPurchases() {
        return this.purchases;
    }

    public final MTUserSettings getSettings() {
        return this.settings;
    }

    public final List<MTTutorialState> getTutorials() {
        return this.tutorials;
    }

    public int hashCode() {
        List<MTPurchase> list = this.purchases;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        MTUserSettings mTUserSettings = this.settings;
        int iHashCode2 = (iHashCode + (mTUserSettings == null ? 0 : mTUserSettings.hashCode())) * 31;
        List<MTTutorialState> list2 = this.tutorials;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setPurchases(List<MTPurchase> list) {
        this.purchases = list;
    }

    public final void setSettings(MTUserSettings mTUserSettings) {
        this.settings = mTUserSettings;
    }

    public final void setTutorials(List<MTTutorialState> list) {
        this.tutorials = list;
    }

    public String toString() {
        return "MTUserState(purchases=" + this.purchases + ", settings=" + this.settings + ", tutorials=" + this.tutorials + ")";
    }
}
