package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/LanguageRow;", "", "lang", "", Constants.GP_IAP_TITLE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LanguageRow {
    public static final int $stable = 0;
    private final String lang;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public LanguageRow() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public LanguageRow(String lang, String title) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(title, "title");
        this.lang = lang;
        this.title = title;
    }

    public /* synthetic */ LanguageRow(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "en" : str, (i & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ LanguageRow copy$default(LanguageRow languageRow, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = languageRow.lang;
        }
        if ((i & 2) != 0) {
            str2 = languageRow.title;
        }
        return languageRow.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final LanguageRow copy(String lang, String title) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(title, "title");
        return new LanguageRow(lang, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageRow)) {
            return false;
        }
        LanguageRow languageRow = (LanguageRow) other;
        return Intrinsics.areEqual(this.lang, languageRow.lang) && Intrinsics.areEqual(this.title, languageRow.title);
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.lang.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "LanguageRow(lang=" + this.lang + ", title=" + this.title + ")";
    }
}
