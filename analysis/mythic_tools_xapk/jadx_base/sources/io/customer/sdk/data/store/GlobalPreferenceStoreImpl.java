package io.customer.sdk.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import io.customer.sdk.data.model.Settings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: GlobalPreferenceStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u001b\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lio/customer/sdk/data/store/GlobalPreferenceStoreImpl;", "Lio/customer/sdk/data/store/PreferenceStore;", "Lio/customer/sdk/data/store/GlobalPreferenceStore;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefsName", "", "getPrefsName", "()Ljava/lang/String;", "prefsName$delegate", "Lkotlin/Lazy;", "saveDeviceToken", "", "token", "saveSettings", "value", "Lio/customer/sdk/data/model/Settings;", "getDeviceToken", "getSettings", "removeDeviceToken", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalPreferenceStoreImpl extends PreferenceStore implements GlobalPreferenceStore {
    private static final String KEY_CONFIG_SETTINGS = "config_settings";
    private static final String KEY_DEVICE_TOKEN = "device_token";

    /* JADX INFO: renamed from: prefsName$delegate, reason: from kotlin metadata */
    private final Lazy prefsName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalPreferenceStoreImpl(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefsName = LazyKt.lazy(new Function0() { // from class: io.customer.sdk.data.store.GlobalPreferenceStoreImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GlobalPreferenceStoreImpl.prefsName_delegate$lambda$0(context);
            }
        });
    }

    static final String prefsName_delegate$lambda$0(Context context) {
        return "io.customer.sdk." + context.getPackageName();
    }

    @Override // io.customer.sdk.data.store.GlobalPreferenceStore
    public String getDeviceToken() {
        Object objM11445constructorimpl;
        SharedPreferences prefs = getPrefs();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(prefs.getString(KEY_DEVICE_TOKEN, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
    }

    @Override // io.customer.sdk.data.store.PreferenceStore
    public String getPrefsName() {
        return (String) this.prefsName.getValue();
    }

    @Override // io.customer.sdk.data.store.GlobalPreferenceStore
    public Settings getSettings() {
        Object objM11445constructorimpl;
        Object objM11445constructorimpl2;
        SharedPreferences prefs = getPrefs();
        try {
            Result.Companion companion = Result.INSTANCE;
            try {
                Result.Companion companion2 = Result.INSTANCE;
                Json.Companion companion3 = Json.INSTANCE;
                KSerializer<Settings> kSerializerSerializer = Settings.INSTANCE.serializer();
                String string = prefs.getString(KEY_CONFIG_SETTINGS, null);
                if (string == null) {
                    return null;
                }
                objM11445constructorimpl2 = Result.m11445constructorimpl((Settings) companion3.decodeFromString(kSerializerSerializer, string));
            } catch (Throwable th) {
                Result.Companion companion4 = Result.INSTANCE;
                objM11445constructorimpl2 = Result.m11445constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m11451isFailureimpl(objM11445constructorimpl2)) {
                objM11445constructorimpl2 = null;
            }
            objM11445constructorimpl = Result.m11445constructorimpl((Settings) objM11445constructorimpl2);
        } catch (Throwable th2) {
            Result.Companion companion5 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th2));
        }
        return (Settings) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
    }

    @Override // io.customer.sdk.data.store.GlobalPreferenceStore
    public void removeDeviceToken() {
        clear(KEY_DEVICE_TOKEN);
    }

    @Override // io.customer.sdk.data.store.GlobalPreferenceStore
    public void saveDeviceToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.putString(KEY_DEVICE_TOKEN, token);
        editorEdit.apply();
    }

    @Override // io.customer.sdk.data.store.GlobalPreferenceStore
    public void saveSettings(Settings value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.putString(KEY_CONFIG_SETTINGS, Json.INSTANCE.encodeToString(Settings.INSTANCE.serializer(), value));
        editorEdit.apply();
    }
}
