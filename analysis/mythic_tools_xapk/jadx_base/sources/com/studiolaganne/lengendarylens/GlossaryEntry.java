package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/GlossaryEntry;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "foldedValue", "foldedKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getValue", "setValue", "getFoldedValue", "setFoldedValue", "getFoldedKey", "setFoldedKey", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GlossaryEntry {
    public static final int $stable = 8;
    private String foldedKey;
    private String foldedValue;
    private String key;
    private String value;

    public GlossaryEntry() {
        this(null, null, null, null, 15, null);
    }

    public GlossaryEntry(String key, String value, String foldedValue, String foldedKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(foldedValue, "foldedValue");
        Intrinsics.checkNotNullParameter(foldedKey, "foldedKey");
        this.key = key;
        this.value = value;
        this.foldedValue = foldedValue;
        this.foldedKey = foldedKey;
    }

    public /* synthetic */ GlossaryEntry(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public static /* synthetic */ GlossaryEntry copy$default(GlossaryEntry glossaryEntry, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = glossaryEntry.key;
        }
        if ((i & 2) != 0) {
            str2 = glossaryEntry.value;
        }
        if ((i & 4) != 0) {
            str3 = glossaryEntry.foldedValue;
        }
        if ((i & 8) != 0) {
            str4 = glossaryEntry.foldedKey;
        }
        return glossaryEntry.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFoldedValue() {
        return this.foldedValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFoldedKey() {
        return this.foldedKey;
    }

    public final GlossaryEntry copy(String key, String value, String foldedValue, String foldedKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(foldedValue, "foldedValue");
        Intrinsics.checkNotNullParameter(foldedKey, "foldedKey");
        return new GlossaryEntry(key, value, foldedValue, foldedKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlossaryEntry)) {
            return false;
        }
        GlossaryEntry glossaryEntry = (GlossaryEntry) other;
        return Intrinsics.areEqual(this.key, glossaryEntry.key) && Intrinsics.areEqual(this.value, glossaryEntry.value) && Intrinsics.areEqual(this.foldedValue, glossaryEntry.foldedValue) && Intrinsics.areEqual(this.foldedKey, glossaryEntry.foldedKey);
    }

    public final String getFoldedKey() {
        return this.foldedKey;
    }

    public final String getFoldedValue() {
        return this.foldedValue;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((this.key.hashCode() * 31) + this.value.hashCode()) * 31) + this.foldedValue.hashCode()) * 31) + this.foldedKey.hashCode();
    }

    public final void setFoldedKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.foldedKey = str;
    }

    public final void setFoldedValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.foldedValue = str;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public String toString() {
        return "GlossaryEntry(key=" + this.key + ", value=" + this.value + ", foldedValue=" + this.foldedValue + ", foldedKey=" + this.foldedKey + ")";
    }
}
