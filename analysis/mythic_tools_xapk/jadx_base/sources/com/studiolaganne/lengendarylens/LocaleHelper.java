package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocaleHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/studiolaganne/lengendarylens/LocaleHelper;", "", "<init>", "()V", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocaleHelper {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PREF_LANGUAGE_KEY = "app_language";
    private static final String TAG = "LocaleHelper";

    /* JADX INFO: compiled from: LocaleHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/LocaleHelper$Companion;", "", "<init>", "()V", "PREF_LANGUAGE_KEY", "", "TAG", "setLocale", "Landroid/content/Context;", "context", "updateAppLocale", "", "updateResources", "languageCode", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Context updateResources(Context context, String languageCode) {
            Locale localeForLanguageTag = Locale.forLanguageTag(languageCode);
            Log.d(LocaleHelper.TAG, "Creating locale for: " + languageCode + " -> " + localeForLanguageTag);
            Locale.setDefault(localeForLanguageTag);
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.setLocale(localeForLanguageTag);
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            Log.d(LocaleHelper.TAG, "New context locale: " + contextCreateConfigurationContext.getResources().getConfiguration().getLocales().get(0));
            Intrinsics.checkNotNull(contextCreateConfigurationContext);
            return contextCreateConfigurationContext;
        }

        public final Context setLocale(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString("app_language", AndroidContextPlugin.DEVICE_KEY);
            if (string == null) {
                string = AndroidContextPlugin.DEVICE_KEY;
            }
            Log.d(LocaleHelper.TAG, "Preference language setting: " + string);
            Log.d(LocaleHelper.TAG, "System default locale: " + Locale.getDefault());
            Log.d(LocaleHelper.TAG, "Context locale: " + context.getResources().getConfiguration().getLocales().get(0));
            return Intrinsics.areEqual(string, AndroidContextPlugin.DEVICE_KEY) ? context : updateResources(context, string);
        }

        public final void updateAppLocale(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString("app_language", AndroidContextPlugin.DEVICE_KEY);
            if (string == null) {
                string = AndroidContextPlugin.DEVICE_KEY;
            }
            if (Intrinsics.areEqual(string, AndroidContextPlugin.DEVICE_KEY)) {
                return;
            }
            Locale localeForLanguageTag = Locale.forLanguageTag(string);
            Locale.setDefault(localeForLanguageTag);
            Configuration configuration = context.getResources().getConfiguration();
            configuration.setLocale(localeForLanguageTag);
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
    }
}
