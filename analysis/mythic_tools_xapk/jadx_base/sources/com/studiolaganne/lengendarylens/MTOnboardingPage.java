package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTOnboardingPage;", "Landroid/os/Parcelable;", "url", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTOnboardingPage implements Parcelable {
    private final String text;
    private final String url;
    public static final Parcelable.Creator<MTOnboardingPage> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MTApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MTOnboardingPage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MTOnboardingPage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MTOnboardingPage(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MTOnboardingPage[] newArray(int i) {
            return new MTOnboardingPage[i];
        }
    }

    public MTOnboardingPage(String url, String text) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(text, "text");
        this.url = url;
        this.text = text;
    }

    public static /* synthetic */ MTOnboardingPage copy$default(MTOnboardingPage mTOnboardingPage, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTOnboardingPage.url;
        }
        if ((i & 2) != 0) {
            str2 = mTOnboardingPage.text;
        }
        return mTOnboardingPage.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final MTOnboardingPage copy(String url, String text) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(text, "text");
        return new MTOnboardingPage(url, text);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTOnboardingPage)) {
            return false;
        }
        MTOnboardingPage mTOnboardingPage = (MTOnboardingPage) other;
        return Intrinsics.areEqual(this.url, mTOnboardingPage.url) && Intrinsics.areEqual(this.text, mTOnboardingPage.text);
    }

    public final String getText() {
        return this.text;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "MTOnboardingPage(url=" + this.url + ", text=" + this.text + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.url);
        dest.writeString(this.text);
    }
}
