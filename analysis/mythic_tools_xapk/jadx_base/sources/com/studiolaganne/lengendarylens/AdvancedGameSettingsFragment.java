package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdvancedGameSettingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/AdvancedGameSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "<init>", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onCreate", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdvancedGameSettingsFragment extends PreferenceFragmentCompat {
    public static final int $stable = 8;

    static final boolean onCreate$lambda$0(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Integer intOrNull = StringsKt.toIntOrNull((String) obj);
        return intOrNull != null && new IntRange(1, 100).contains(intOrNull.intValue());
    }

    static final boolean onCreate$lambda$1(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Integer intOrNull = StringsKt.toIntOrNull((String) obj);
        return intOrNull != null && new IntRange(1, 20).contains(intOrNull.intValue());
    }

    static final boolean onCreate$lambda$2(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Integer intOrNull = StringsKt.toIntOrNull((String) obj);
        return intOrNull != null && new IntRange(1, 9).contains(intOrNull.intValue());
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(PreferencesManager.LOW_LIFE_THRESHOLD);
        if (editTextPreference != null) {
            editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AdvancedGameSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AdvancedGameSettingsFragment.onCreate$lambda$0(preference, obj);
                }
            });
        }
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(PreferencesManager.HIGH_CMD_DAMAGE_THRESHOLD);
        if (editTextPreference2 != null) {
            editTextPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AdvancedGameSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AdvancedGameSettingsFragment.onCreate$lambda$1(preference, obj);
                }
            });
        }
        EditTextPreference editTextPreference3 = (EditTextPreference) findPreference(PreferencesManager.HIGH_POISON_THRESHOLD);
        if (editTextPreference3 != null) {
            editTextPreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AdvancedGameSettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AdvancedGameSettingsFragment.onCreate$lambda$2(preference, obj);
                }
            });
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_game_advanced, rootKey);
    }
}
