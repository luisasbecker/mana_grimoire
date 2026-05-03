package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEntryLocalization;", "", AndroidContextPlugin.LOCALE_KEY, "", "name", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getName", "getDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEntryLocalization {
    public static final int $stable = 0;
    private final String description;
    private final String locale;
    private final String name;

    public MTEntryLocalization(String locale, String name, String str) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(name, "name");
        this.locale = locale;
        this.name = name;
        this.description = str;
    }

    public /* synthetic */ MTEntryLocalization(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ MTEntryLocalization copy$default(MTEntryLocalization mTEntryLocalization, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTEntryLocalization.locale;
        }
        if ((i & 2) != 0) {
            str2 = mTEntryLocalization.name;
        }
        if ((i & 4) != 0) {
            str3 = mTEntryLocalization.description;
        }
        return mTEntryLocalization.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final MTEntryLocalization copy(String locale, String name, String description) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTEntryLocalization(locale, name, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEntryLocalization)) {
            return false;
        }
        MTEntryLocalization mTEntryLocalization = (MTEntryLocalization) other;
        return Intrinsics.areEqual(this.locale, mTEntryLocalization.locale) && Intrinsics.areEqual(this.name, mTEntryLocalization.name) && Intrinsics.areEqual(this.description, mTEntryLocalization.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = ((this.locale.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MTEntryLocalization(locale=" + this.locale + ", name=" + this.name + ", description=" + this.description + ")";
    }
}
