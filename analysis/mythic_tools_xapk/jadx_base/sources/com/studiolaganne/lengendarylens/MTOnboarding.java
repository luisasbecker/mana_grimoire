package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTOnboarding;", "Landroid/os/Parcelable;", "version", "", "id", "", "pages", "", "Lcom/studiolaganne/lengendarylens/MTOnboardingPage;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getId", "()I", "getPages", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTOnboarding implements Parcelable {
    private final int id;
    private final List<MTOnboardingPage> pages;
    private final String version;
    public static final Parcelable.Creator<MTOnboarding> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MTApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MTOnboarding> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MTOnboarding createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(MTOnboardingPage.CREATOR.createFromParcel(parcel));
            }
            return new MTOnboarding(string, i, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MTOnboarding[] newArray(int i) {
            return new MTOnboarding[i];
        }
    }

    public MTOnboarding(String version, int i, List<MTOnboardingPage> pages) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.version = version;
        this.id = i;
        this.pages = pages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTOnboarding copy$default(MTOnboarding mTOnboarding, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTOnboarding.version;
        }
        if ((i2 & 2) != 0) {
            i = mTOnboarding.id;
        }
        if ((i2 & 4) != 0) {
            list = mTOnboarding.pages;
        }
        return mTOnboarding.copy(str, i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<MTOnboardingPage> component3() {
        return this.pages;
    }

    public final MTOnboarding copy(String version, int id, List<MTOnboardingPage> pages) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new MTOnboarding(version, id, pages);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTOnboarding)) {
            return false;
        }
        MTOnboarding mTOnboarding = (MTOnboarding) other;
        return Intrinsics.areEqual(this.version, mTOnboarding.version) && this.id == mTOnboarding.id && Intrinsics.areEqual(this.pages, mTOnboarding.pages);
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTOnboardingPage> getPages() {
        return this.pages;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.version.hashCode() * 31) + Integer.hashCode(this.id)) * 31) + this.pages.hashCode();
    }

    public String toString() {
        return "MTOnboarding(version=" + this.version + ", id=" + this.id + ", pages=" + this.pages + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.version);
        dest.writeInt(this.id);
        List<MTOnboardingPage> list = this.pages;
        dest.writeInt(list.size());
        Iterator<MTOnboardingPage> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
