package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LanguageSettingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/LanguageSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "<init>", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "showHidePreference", SubscriberAttributeKt.JSON_NAME_KEY, "show", "", "handleLanguageToggle", "languageCode", "isEnabled", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LanguageSettingsFragment extends PreferenceFragmentCompat {
    public static final int $stable = 8;

    private final void handleLanguageToggle(final String languageCode, boolean isEnabled) {
        if (getContext() != null && isEnabled) {
            MTGDBHelperLocalized.Companion companion = MTGDBHelperLocalized.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final MTGDBHelperLocalized companion2 = companion.getInstance(contextRequireContext, languageCode);
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext2);
            if (companion2.hasDBInAppContext() && companion2.isValid()) {
                return;
            }
            String string = getString(R.string.download_db_body);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String lowerCase = preferencesManager.getNameForLanguage(languageCode).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String strReplace$default = StringsKt.replace$default(string, "{1}", lowerCase, false, 4, (Object) null);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string2 = getString(R.string.download_db_title);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = builder.setTitle(string2).setBody(strReplace$default).setPositiveButtonRed();
            String string3 = getString(R.string.download);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageSettingsFragment.handleLanguageToggle$lambda$0(this.f$0, companion2, languageCode, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LanguageSettingsFragment.handleLanguageToggle$lambda$1(this.f$0, languageCode, (CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "CustomDialogFragment");
        }
    }

    static final Unit handleLanguageToggle$lambda$0(final LanguageSettingsFragment languageSettingsFragment, final MTGDBHelperLocalized mTGDBHelperLocalized, final String str, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        languageSettingsFragment.showHidePreference("download_preference", true);
        ProgressBarPreference progressBarPreference = (ProgressBarPreference) languageSettingsFragment.findPreference("download_preference");
        if (progressBarPreference != null) {
            progressBarPreference.updateProgress(0);
        }
        mTGDBHelperLocalized.downloadDBFile(new Function1() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LanguageSettingsFragment.handleLanguageToggle$lambda$0$0(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LanguageSettingsFragment.handleLanguageToggle$lambda$0$1(mTGDBHelperLocalized, languageSettingsFragment);
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LanguageSettingsFragment.handleLanguageToggle$lambda$0$2(this.f$0, str, (String) obj);
            }
        });
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLanguageToggle$lambda$0$0(LanguageSettingsFragment languageSettingsFragment, int i) {
        ProgressBarPreference progressBarPreference = (ProgressBarPreference) languageSettingsFragment.findPreference("download_preference");
        if (progressBarPreference != null) {
            progressBarPreference.updateProgress(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLanguageToggle$lambda$0$1(MTGDBHelperLocalized mTGDBHelperLocalized, LanguageSettingsFragment languageSettingsFragment) {
        if (mTGDBHelperLocalized.hasDBInAppContext() && mTGDBHelperLocalized.isValid()) {
            languageSettingsFragment.showHidePreference("download_preference", false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLanguageToggle$lambda$0$2(LanguageSettingsFragment languageSettingsFragment, String str, String errorStr) {
        Intrinsics.checkNotNullParameter(errorStr, "errorStr");
        if (languageSettingsFragment.getContext() == null || languageSettingsFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        languageSettingsFragment.showHidePreference("download_preference", false);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) languageSettingsFragment.findPreference(str);
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setChecked(false);
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = languageSettingsFragment.getString(R.string.download_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody(languageSettingsFragment.getString(R.string.download_error_body) + "\n\n" + errorStr);
        String string2 = languageSettingsFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LanguageSettingsFragment.handleLanguageToggle$lambda$0$2$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = languageSettingsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLanguageToggle$lambda$0$2$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit handleLanguageToggle$lambda$1(LanguageSettingsFragment languageSettingsFragment, String str, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) languageSettingsFragment.findPreference(str);
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setChecked(false);
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final boolean onCreatePreferences$lambda$0(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("de", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$1(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("it", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$2(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("es", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$3(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("pt", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$4(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("ja", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$5(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("ko", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$6(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("ru", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$7(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("zhs", true);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$8(LanguageSettingsFragment languageSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            languageSettingsFragment.handleLanguageToggle("zht", true);
        }
        return true;
    }

    private final void showHidePreference(String key, boolean show) {
        ProgressBarPreference progressBarPreference = (ProgressBarPreference) findPreference(key);
        if (progressBarPreference != null) {
            progressBarPreference.setIsVisible(show);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_lang, rootKey);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference("de");
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$0(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference("it");
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda6
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$1(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) findPreference("es");
        if (switchPreferenceCompat3 != null) {
            switchPreferenceCompat3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda7
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$2(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) findPreference("pt");
        if (switchPreferenceCompat4 != null) {
            switchPreferenceCompat4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda8
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$3(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat5 = (SwitchPreferenceCompat) findPreference("ja");
        if (switchPreferenceCompat5 != null) {
            switchPreferenceCompat5.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda9
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$4(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat6 = (SwitchPreferenceCompat) findPreference("ko");
        if (switchPreferenceCompat6 != null) {
            switchPreferenceCompat6.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda10
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$5(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat7 = (SwitchPreferenceCompat) findPreference("ru");
        if (switchPreferenceCompat7 != null) {
            switchPreferenceCompat7.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda11
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$6(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat8 = (SwitchPreferenceCompat) findPreference("zhs");
        if (switchPreferenceCompat8 != null) {
            switchPreferenceCompat8.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda12
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$7(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat9 = (SwitchPreferenceCompat) findPreference("zht");
        if (switchPreferenceCompat9 != null) {
            switchPreferenceCompat9.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.LanguageSettingsFragment$$ExternalSyntheticLambda13
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return LanguageSettingsFragment.onCreatePreferences$lambda$8(this.f$0, preference, obj);
                }
            });
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        showHidePreference("download_preference", false);
    }
}
