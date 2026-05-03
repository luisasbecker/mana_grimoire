package io.customer.sdk.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lio/customer/sdk/data/store/PreferenceStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "prefsName", "", "getPrefsName", "()Ljava/lang/String;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "clearAll", "", "clear", SubscriberAttributeKt.JSON_NAME_KEY, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PreferenceStore {
    private final Context context;

    public PreferenceStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public void clear(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        getPrefs().edit().remove(key).apply();
    }

    public void clearAll() {
        getPrefs().edit().clear().apply();
    }

    public final Context getContext() {
        return this.context;
    }

    protected final SharedPreferences getPrefs() {
        SharedPreferences sharedPreferences = this.context.getApplicationContext().getSharedPreferences(getPrefsName(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public abstract String getPrefsName();
}
