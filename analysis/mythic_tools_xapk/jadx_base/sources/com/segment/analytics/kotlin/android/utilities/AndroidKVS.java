package com.segment.analytics.kotlin.android.utilities;

import android.content.SharedPreferences;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.utilities.KVS;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidKVS.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/android/utilities/AndroidKVS;", "Lcom/segment/analytics/kotlin/core/utilities/KVS;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "contains", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "get", "", "defaultVal", "put", "value", "remove", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidKVS implements KVS {
    private final SharedPreferences sharedPreferences;

    public AndroidKVS(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.contains(key);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public int get(String key, int defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.getInt(key, defaultVal);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public String get(String key, String defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.sharedPreferences.getString(key, defaultVal);
        return string == null ? defaultVal : string;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    @Deprecated(message = "Deprecated in favor of `get`", replaceWith = @ReplaceWith(expression = "get(key, defaultVal)", imports = {}))
    public int getInt(String str, int i) {
        return KVS.DefaultImpls.getInt(this, str, i);
    }

    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean put(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.edit().putInt(key, value).commit();
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.sharedPreferences.edit().putString(key, value).commit();
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    @Deprecated(message = "Deprecated in favor of `put`", replaceWith = @ReplaceWith(expression = "put(key, value)", imports = {}))
    public boolean putInt(String str, int i) {
        return KVS.DefaultImpls.putInt(this, str, i);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.edit().remove(key).commit();
    }
}
