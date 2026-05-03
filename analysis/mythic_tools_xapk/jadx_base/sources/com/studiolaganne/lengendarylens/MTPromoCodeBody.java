package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J0\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPromoCodeBody;", "", "code", "", NotificationCompat.CATEGORY_EVENT, "", AndroidContextPlugin.LOCALE_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getEvent", "()Ljava/lang/Integer;", "setEvent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLocale", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTPromoCodeBody;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPromoCodeBody {
    public static final int $stable = 8;
    private String code;
    private Integer event;
    private final String locale;

    public MTPromoCodeBody(String str, Integer num, String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.code = str;
        this.event = num;
        this.locale = locale;
    }

    public /* synthetic */ MTPromoCodeBody(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, str2);
    }

    public static /* synthetic */ MTPromoCodeBody copy$default(MTPromoCodeBody mTPromoCodeBody, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTPromoCodeBody.code;
        }
        if ((i & 2) != 0) {
            num = mTPromoCodeBody.event;
        }
        if ((i & 4) != 0) {
            str2 = mTPromoCodeBody.locale;
        }
        return mTPromoCodeBody.copy(str, num, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final MTPromoCodeBody copy(String code, Integer event, String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new MTPromoCodeBody(code, event, locale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPromoCodeBody)) {
            return false;
        }
        MTPromoCodeBody mTPromoCodeBody = (MTPromoCodeBody) other;
        return Intrinsics.areEqual(this.code, mTPromoCodeBody.code) && Intrinsics.areEqual(this.event, mTPromoCodeBody.event) && Intrinsics.areEqual(this.locale, mTPromoCodeBody.locale);
    }

    public final String getCode() {
        return this.code;
    }

    public final Integer getEvent() {
        return this.event;
    }

    public final String getLocale() {
        return this.locale;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.event;
        return ((iHashCode + (num != null ? num.hashCode() : 0)) * 31) + this.locale.hashCode();
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setEvent(Integer num) {
        this.event = num;
    }

    public String toString() {
        return "MTPromoCodeBody(code=" + this.code + ", event=" + this.event + ", locale=" + this.locale + ")";
    }
}
