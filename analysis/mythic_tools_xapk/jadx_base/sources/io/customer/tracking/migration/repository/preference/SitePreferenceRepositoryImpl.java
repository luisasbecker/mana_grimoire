package io.customer.tracking.migration.repository.preference;

import android.content.Context;
import android.content.SharedPreferences;
import io.customer.sdk.data.store.PreferenceStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SitePreferenceRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lio/customer/tracking/migration/repository/preference/SitePreferenceRepositoryImpl;", "Lio/customer/sdk/data/store/PreferenceStore;", "Lio/customer/tracking/migration/repository/preference/SitePreferenceRepository;", "context", "Landroid/content/Context;", "siteId", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "prefsName", "getPrefsName", "()Ljava/lang/String;", "prefsName$delegate", "Lkotlin/Lazy;", "saveIdentifier", "", SitePreferenceRepositoryImpl.KEY_IDENTIFIER, "removeIdentifier", "getIdentifier", "saveDeviceToken", "token", "getDeviceToken", "removeDeviceToken", "Companion", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SitePreferenceRepositoryImpl extends PreferenceStore implements SitePreferenceRepository {
    private static final String KEY_DEVICE_TOKEN = "device_token";
    private static final String KEY_IDENTIFIER = "identifier";

    /* JADX INFO: renamed from: prefsName$delegate, reason: from kotlin metadata */
    private final Lazy prefsName;
    private final String siteId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SitePreferenceRepositoryImpl(final Context context, String siteId) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        this.siteId = siteId;
        this.prefsName = LazyKt.lazy(new Function0() { // from class: io.customer.tracking.migration.repository.preference.SitePreferenceRepositoryImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SitePreferenceRepositoryImpl.prefsName_delegate$lambda$0(context, this);
            }
        });
    }

    static final String prefsName_delegate$lambda$0(Context context, SitePreferenceRepositoryImpl sitePreferenceRepositoryImpl) {
        return "io.customer.sdk." + context.getPackageName() + "." + sitePreferenceRepositoryImpl.siteId;
    }

    @Override // io.customer.tracking.migration.repository.preference.SitePreferenceRepository
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

    @Override // io.customer.tracking.migration.repository.preference.SitePreferenceRepository
    public String getIdentifier() {
        Object objM11445constructorimpl;
        SharedPreferences prefs = getPrefs();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(prefs.getString(KEY_IDENTIFIER, null));
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

    @Override // io.customer.tracking.migration.repository.preference.SitePreferenceRepository
    public void removeDeviceToken() {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.remove(KEY_DEVICE_TOKEN);
        editorEdit.apply();
    }

    @Override // io.customer.tracking.migration.repository.preference.SitePreferenceRepository
    public void removeIdentifier(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.remove(KEY_IDENTIFIER);
        editorEdit.apply();
    }

    @Override // io.customer.tracking.migration.repository.preference.SitePreferenceRepository
    public void saveDeviceToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.putString(KEY_DEVICE_TOKEN, token);
        editorEdit.apply();
    }

    @Override // io.customer.tracking.migration.repository.preference.SitePreferenceRepository
    public void saveIdentifier(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.putString(KEY_IDENTIFIER, identifier);
        editorEdit.apply();
    }
}
