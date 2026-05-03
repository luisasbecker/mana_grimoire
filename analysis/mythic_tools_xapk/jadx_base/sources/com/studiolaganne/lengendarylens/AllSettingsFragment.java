package com.studiolaganne.lengendarylens;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.FontPreviewDialogFragment;
import com.studiolaganne.lengendarylens.LocaleHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: AllSettingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/AllSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "<init>", "()V", "enableSettings", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "setupThemePreference", "", "loadThemesForPreference", "preference", "Landroidx/preference/ListPreference;", "updateThemePreferenceEntries", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "setDefaultThemeEntries", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "onDisplayPreferenceDialog", "Landroidx/preference/Preference;", "showLoadingDialog", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AllSettingsFragment extends PreferenceFragmentCompat {
    public static final int $stable = 8;
    private BillingClient billingClient;
    private boolean enableSettings;
    private List<MTTheme> themes = CollectionsKt.emptyList();
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda5
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        }
    };

    private final void loadThemesForPreference(final ListPreference preference) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTApiKt.getMtApi().getThemes(preferencesManager.getDeviceLanguage()).enqueue(new Callback<MTThemesResponse>() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment.loadThemesForPreference.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTThemesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (AllSettingsFragment.this.getContext() != null && AllSettingsFragment.this.isAdded()) {
                    AllSettingsFragment.this.setDefaultThemeEntries(preference);
                }
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTThemesResponse> call, Response<MTThemesResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful() && AllSettingsFragment.this.isAdded()) {
                    MTThemesResponse mTThemesResponseBody = response.body();
                    List<MTTheme> themes = mTThemesResponseBody != null ? mTThemesResponseBody.getThemes() : null;
                    if (themes != null) {
                        AllSettingsFragment.this.updateThemePreferenceEntries(preference, themes, preferencesManager);
                    }
                }
            }
        });
    }

    static final boolean onCreatePreferences$lambda$0(final AllSettingsFragment allSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        final Context context = preference.getContext();
        if (context == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AllSettingsFragment.onCreatePreferences$lambda$0$0$0(this.f$0, context);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreatePreferences$lambda$0$0$0(AllSettingsFragment allSettingsFragment, Context context) {
        if (allSettingsFragment.getContext() == null) {
            return;
        }
        LocaleHelper.Companion companion = LocaleHelper.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.updateAppLocale(applicationContext);
        PreferencesManager.syncCurrentSettingsToAPI$default(new PreferencesManager(context), null, 1, null);
        FragmentActivity activity = allSettingsFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            allSettingsFragment.startActivity(intent);
            activity.finish();
        }
    }

    static final boolean onCreatePreferences$lambda$1(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        allSettingsFragment.startActivity(new Intent(allSettingsFragment.requireContext(), (Class<?>) AboutActivity.class));
        return true;
    }

    static final boolean onCreatePreferences$lambda$10(final AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context contextRequireContext = allSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final AlertDialog alertDialogShowLoadingDialog = allSettingsFragment.showLoadingDialog(contextRequireContext);
        BillingClient billingClient = allSettingsFragment.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), new PurchasesResponseListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda9
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                AllSettingsFragment.onCreatePreferences$lambda$10$0(this.f$0, alertDialogShowLoadingDialog, billingResult, list);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreatePreferences$lambda$10$0(AllSettingsFragment allSettingsFragment, final AlertDialog alertDialog, BillingResult p0, List p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        if (p0.getResponseCode() == 0) {
            Iterator it = p1.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                if (purchase.getProducts().contains(PreferencesManager.SOLRING_THEME) && purchase.getPurchaseState() == 1) {
                    Log.d("Billing", "SolRing theme already purchased - restoring");
                    Context contextRequireContext = allSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                    preferencesManager.addThemePurchased(PreferencesManager.SOLRING_THEME);
                    Map<String, String> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    String purchaseToken = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
                    Log.d("Billing", "SolRing theme already purchased - token = " + purchaseToken);
                    if (!mutableMap.containsKey(PreferencesManager.SOLRING_THEME)) {
                        mutableMap.put(PreferencesManager.SOLRING_THEME, purchaseToken);
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap);
                    preferencesManager.syncThemePurchase(PreferencesManager.SOLRING_THEME);
                }
                if (purchase.getProducts().contains(PreferencesManager.XMAS_THEME) && purchase.getPurchaseState() == 1) {
                    Log.d("Billing", "XMAS_THEME theme already purchased - restoring");
                    Context contextRequireContext2 = allSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext2);
                    preferencesManager2.addThemePurchased(PreferencesManager.XMAS_THEME);
                    Map<String, String> mutableMap2 = MapsKt.toMutableMap(preferencesManager2.getAllThemeTokens());
                    String purchaseToken2 = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken2, "getPurchaseToken(...)");
                    Log.d("Billing", "XMAS_THEME theme already purchased - token = " + purchaseToken2);
                    if (!mutableMap2.containsKey(PreferencesManager.XMAS_THEME)) {
                        mutableMap2.put(PreferencesManager.XMAS_THEME, purchaseToken2);
                    }
                    preferencesManager2.saveAllThemeTokens(mutableMap2);
                    preferencesManager2.syncThemePurchase(PreferencesManager.XMAS_THEME);
                }
                if (purchase.getProducts().contains(PreferencesManager.BURN_THEME) && purchase.getPurchaseState() == 1) {
                    Log.d("Billing", "BURN_THEME theme already purchased - restoring");
                    Context contextRequireContext3 = allSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                    PreferencesManager preferencesManager3 = new PreferencesManager(contextRequireContext3);
                    preferencesManager3.addThemePurchased(PreferencesManager.BURN_THEME);
                    Map<String, String> mutableMap3 = MapsKt.toMutableMap(preferencesManager3.getAllThemeTokens());
                    String purchaseToken3 = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken3, "getPurchaseToken(...)");
                    Log.d("Billing", "BURN_THEME theme already purchased - token = " + purchaseToken3);
                    if (!mutableMap3.containsKey(PreferencesManager.BURN_THEME)) {
                        mutableMap3.put(PreferencesManager.BURN_THEME, purchaseToken3);
                    }
                    preferencesManager3.saveAllThemeTokens(mutableMap3);
                    preferencesManager3.syncThemePurchase(PreferencesManager.BURN_THEME);
                }
                if (purchase.getProducts().contains(PreferencesManager.LOVE_THEME) && purchase.getPurchaseState() == 1) {
                    Log.d("Billing", "LOVE_THEME theme already purchased - restoring");
                    Context contextRequireContext4 = allSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                    PreferencesManager preferencesManager4 = new PreferencesManager(contextRequireContext4);
                    preferencesManager4.addThemePurchased(PreferencesManager.LOVE_THEME);
                    Map<String, String> mutableMap4 = MapsKt.toMutableMap(preferencesManager4.getAllThemeTokens());
                    String purchaseToken4 = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken4, "getPurchaseToken(...)");
                    Log.d("Billing", "LOVE_THEME theme already purchased - token = " + purchaseToken4);
                    if (!mutableMap4.containsKey(PreferencesManager.LOVE_THEME)) {
                        mutableMap4.put(PreferencesManager.LOVE_THEME, purchaseToken4);
                    }
                    preferencesManager4.saveAllThemeTokens(mutableMap4);
                    preferencesManager4.syncThemePurchase(PreferencesManager.LOVE_THEME);
                }
                if (purchase.getProducts().contains(PreferencesManager.AF_THEME) && purchase.getPurchaseState() == 1) {
                    Log.d("Billing", "AF_THEME theme already purchased - restoring");
                    Context contextRequireContext5 = allSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                    PreferencesManager preferencesManager5 = new PreferencesManager(contextRequireContext5);
                    preferencesManager5.addThemePurchased(PreferencesManager.AF_THEME);
                    Map<String, String> mutableMap5 = MapsKt.toMutableMap(preferencesManager5.getAllThemeTokens());
                    String purchaseToken5 = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken5, "getPurchaseToken(...)");
                    Log.d("Billing", "AF_THEME theme already purchased - token = " + purchaseToken5);
                    if (!mutableMap5.containsKey(PreferencesManager.AF_THEME)) {
                        mutableMap5.put(PreferencesManager.AF_THEME, purchaseToken5);
                    }
                    preferencesManager5.saveAllThemeTokens(mutableMap5);
                    preferencesManager5.syncThemePurchase(PreferencesManager.AF_THEME);
                }
                if (purchase.getProducts().contains(PreferencesManager.LUPO_THEME) && purchase.getPurchaseState() == 1) {
                    Log.d("Billing", "LUPO_THEME theme already purchased - restoring");
                    Context contextRequireContext6 = allSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                    PreferencesManager preferencesManager6 = new PreferencesManager(contextRequireContext6);
                    preferencesManager6.addThemePurchased(PreferencesManager.LUPO_THEME);
                    Map<String, String> mutableMap6 = MapsKt.toMutableMap(preferencesManager6.getAllThemeTokens());
                    String purchaseToken6 = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken6, "getPurchaseToken(...)");
                    Log.d("Billing", "LUPO_THEME theme already purchased - token = " + purchaseToken6);
                    if (!mutableMap6.containsKey(PreferencesManager.LUPO_THEME)) {
                        mutableMap6.put(PreferencesManager.LUPO_THEME, purchaseToken6);
                    }
                    preferencesManager6.saveAllThemeTokens(mutableMap6);
                    preferencesManager6.syncThemePurchase(PreferencesManager.LUPO_THEME);
                }
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                alertDialog.dismiss();
            }
        }, 500L);
    }

    static final boolean onCreatePreferences$lambda$12(PreferencesManager preferencesManager, AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return true;
        }
        Context contextRequireContext = allSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTApiKt.getMtApi().syncSubscription(currentUser.getId()).enqueue(new AllSettingsFragment$onCreatePreferences$14$1(allSettingsFragment.showLoadingDialog(contextRequireContext), allSettingsFragment));
        return true;
    }

    static final boolean onCreatePreferences$lambda$13(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(allSettingsFragment.requireContext(), R.style.TransparentBottomSheetDialog);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_disclaimer_layout);
        bottomSheetDialog.show();
        return true;
    }

    static final boolean onCreatePreferences$lambda$14(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            String packageName = allSettingsFragment.requireContext().getPackageName();
            try {
                allSettingsFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
            } catch (ActivityNotFoundException unused) {
                allSettingsFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
            }
            return true;
        } catch (ActivityNotFoundException unused2) {
            return true;
        }
    }

    static final boolean onCreatePreferences$lambda$2(AllSettingsFragment allSettingsFragment, Preference it) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(it, "it");
        PackageInfo packageInfo = allSettingsFragment.requireContext().getPackageManager().getPackageInfo(allSettingsFragment.requireContext().getPackageName(), 0);
        String str = packageInfo.versionName;
        if (str == null) {
            str = "";
        }
        int longVersionCode = Build.VERSION.SDK_INT >= 28 ? (int) packageInfo.getLongVersionCode() : packageInfo.versionCode;
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:support@studiomythic.com"));
        intent.putExtra("android.intent.extra.SUBJECT", "Mythic Tools Android v" + str + " (" + longVersionCode + ")");
        try {
            allSettingsFragment.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(allSettingsFragment.requireContext(), allSettingsFragment.getString(R.string.no_email_app), 1).show();
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$3(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        Context context = preference.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            preferencesManager.invalidateAllContainers();
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$4(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        Context context = preference.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            preferencesManager.invalidateAllContainers();
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        }
        return true;
    }

    static final boolean onCreatePreferences$lambda$5(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = allSettingsFragment.getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setTitle(allSettingsFragment.getString(R.string.advanced_game_settings));
            }
        }
        allSettingsFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_container, new AdvancedGameSettingsFragment()).addToBackStack(null).commit();
        return true;
    }

    static final boolean onCreatePreferences$lambda$6(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = allSettingsFragment.getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setTitle(allSettingsFragment.getString(R.string.timer_game_settings));
            }
        }
        allSettingsFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_container, new GameTimerSettingsFragment()).addToBackStack(null).commit();
        return true;
    }

    static final boolean onCreatePreferences$lambda$7(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = allSettingsFragment.getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setTitle(allSettingsFragment.getString(R.string.event_settings_header));
            }
        }
        allSettingsFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_container, new SettingsForEventsFragment()).addToBackStack(null).commit();
        return true;
    }

    static final boolean onCreatePreferences$lambda$8(AllSettingsFragment allSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FragmentActivity activity = allSettingsFragment.getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setTitle(allSettingsFragment.getString(R.string.language_settings));
            }
        }
        allSettingsFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_container, new LanguageSettingsFragment()).addToBackStack(null).commit();
        return true;
    }

    static final boolean onCreatePreferences$lambda$9(PreferencesManager preferencesManager, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (!(bool != null ? bool.booleanValue() : false)) {
            CustomerIOHelper.INSTANCE.setOptOut(preferencesManager);
            return true;
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return true;
        }
        CustomerIOHelper.INSTANCE.identifyOptedInUser(currentUser, preferencesManager);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDefaultThemeEntries(ListPreference preference) {
        preference.setEntries(new String[]{getString(R.string.default_theme)});
        preference.setEntryValues(new String[]{"default"});
        preference.setValue("default");
    }

    private final void setupThemePreference() {
        ListPreference listPreference = (ListPreference) findPreference(PreferencesManager.CREATOR_CODE);
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda8
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AllSettingsFragment.setupThemePreference$lambda$0$0(this.f$0, preference, obj);
                }
            });
            loadThemesForPreference(listPreference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupThemePreference$lambda$0$0(final AllSettingsFragment allSettingsFragment, Preference preference, Object obj) {
        Object next;
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Log.d("ThemePreference", "Theme changed to: " + ((String) obj));
        if (((CharSequence) obj).length() <= 0 || Intrinsics.areEqual(obj, "default")) {
            return true;
        }
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = allSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (companion.getCurrentSkinDefinition(contextRequireContext) != null) {
            return true;
        }
        Iterator<T> it = allSettingsFragment.themes.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((MTTheme) next).getGoogleproductid(), obj)) {
                break;
            }
        }
        final MTTheme mTTheme = (MTTheme) next;
        if (mTTheme == null) {
            return true;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = allSettingsFragment.getString(R.string.theme_already_obtained_not_insalled);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = allSettingsFragment.getString(R.string.theme_download_again);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = allSettingsFragment.getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return AllSettingsFragment.setupThemePreference$lambda$0$0$1$0(this.f$0, mTTheme, ((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
            }
        });
        String string4 = allSettingsFragment.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return AllSettingsFragment.setupThemePreference$lambda$0$0$1$1((CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = allSettingsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "theme_re_download");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupThemePreference$lambda$0$0$1$0(AllSettingsFragment allSettingsFragment, MTTheme mTTheme, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent(allSettingsFragment.requireContext(), (Class<?>) DownloadThemeActivity.class);
        intent.putExtra("theme", new Gson().toJson(mTTheme));
        allSettingsFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupThemePreference$lambda$0$0$1$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final AlertDialog showLoadingDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_dialog);
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateThemePreferenceEntries(ListPreference preference, List<MTTheme> themes, PreferencesManager prefs) {
        Object obj;
        String str;
        ArrayList arrayList = new ArrayList();
        for (MTTheme mTTheme : themes) {
            Boolean instore = mTTheme.getInstore();
            if (instore == null) {
                arrayList.add(mTTheme);
            } else if (instore.booleanValue()) {
                arrayList.add(mTTheme);
            } else if (prefs.getThemesPurchased().contains(mTTheme.getGoogleproductid())) {
                arrayList.add(mTTheme);
            }
        }
        for (MTTheme mTTheme2 : prefs.getLocalThemesCache()) {
            ArrayList arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((MTTheme) it.next()).getGoogleproductid(), mTTheme2.getGoogleproductid())) {
                        break;
                    }
                }
            }
            arrayList.add(mTTheme2);
        }
        Set set = CollectionsKt.toSet(prefs.getThemesPurchased());
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            MTTheme mTTheme3 = (MTTheme) next;
            if (StringsKt.startsWith$default(mTTheme3.getGoogleproductid(), "free_", false, 2, (Object) null) || set.contains(mTTheme3.getGoogleproductid())) {
                arrayList3.add(next);
            }
        }
        List<MTTheme> listSortedWith = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$updateThemePreferenceEntries$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t).getGoogleproductid(), "free_", false, 2, (Object) null)), Boolean.valueOf(StringsKt.startsWith$default(((MTTheme) t2).getGoogleproductid(), "free_", false, 2, (Object) null)));
            }
        });
        this.themes = listSortedWith;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        String string = getString(R.string.default_theme);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList4.add(string);
        arrayList5.add("default");
        for (MTTheme mTTheme4 : listSortedWith) {
            String title = mTTheme4.getTitle();
            if (title == null) {
                title = "Unknown Theme";
            }
            arrayList4.add(title);
            arrayList5.add(mTTheme4.getGoogleproductid());
        }
        preference.setEntries((CharSequence[]) arrayList4.toArray(new String[0]));
        preference.setEntryValues((CharSequence[]) arrayList5.toArray(new String[0]));
        String value = preference.getValue();
        if (value == null || !arrayList5.contains(value)) {
            preference.setValue("default");
        } else {
            preference.setValue(value);
        }
        try {
            Preference.SummaryProvider summaryProvider = preference.getSummaryProvider();
            if (summaryProvider != null) {
                preference.setSummary(summaryProvider.provideSummary(preference));
            }
        } catch (Exception unused) {
            if (Intrinsics.areEqual(preference.getValue(), "default")) {
                Iterator it3 = arrayList5.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next2 = it3.next();
                    if (!Intrinsics.areEqual((String) next2, "default")) {
                        obj = next2;
                        break;
                    }
                }
                str = (String) obj;
                if (str == null) {
                    str = "default";
                }
            }
            preference.setValue(str);
            preference.setValue(value != null ? value : "default");
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_all, rootKey);
        setupThemePreference();
        Preference preferenceFindPreference = findPreference(PreferencesManager.APP_LANGUAGE);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AllSettingsFragment.onCreatePreferences$lambda$0(this.f$0, preference, obj);
                }
            });
        }
        Preference preferenceFindPreference2 = findPreference("about_mythic_tools");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda16
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$1(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference("contact_support_email");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda17
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$2(this.f$0, preference);
                }
            });
        }
        ListPreference listPreference = (ListPreference) findPreference(PreferencesManager.PREFERRED_CURRENCY_V2);
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda18
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AllSettingsFragment.onCreatePreferences$lambda$3(preference, obj);
                }
            });
        }
        MarketplaceIconListPreference marketplaceIconListPreference = (MarketplaceIconListPreference) findPreference(PreferencesManager.PREFERRED_MARKET);
        if (marketplaceIconListPreference != null) {
            marketplaceIconListPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda19
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AllSettingsFragment.onCreatePreferences$lambda$4(preference, obj);
                }
            });
        }
        Preference preferenceFindPreference4 = findPreference("advanced_game_settings");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda20
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$5(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference5 = findPreference("timer_game_settings");
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$6(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference6 = findPreference("event_settings");
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$7(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference7 = findPreference("language_settings");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda3
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$8(this.f$0, preference);
                }
            });
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Preference preferenceFindPreference8 = findPreference(PreferencesManager.ENABLE_STREAMING);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        BillingClient billingClient = null;
        boolean z = preferencesManager.hasValidUser() && (currentUser != null ? currentUser.getUid() : null) != null;
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setVisible(z);
        }
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(PreferencesManager.EMAIL_OPT_IN);
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setVisible(z);
        }
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda4
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return AllSettingsFragment.onCreatePreferences$lambda$9(preferencesManager, preference, obj);
                }
            });
        }
        BillingClient billingClientBuild = BillingClient.newBuilder(requireContext()).setListener(this.purchasesUpdatedListener).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        if (billingClientBuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        } else {
            billingClient = billingClientBuild;
        }
        billingClient.startConnection(new BillingClientStateListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment.onCreatePreferences.11
            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingServiceDisconnected() {
            }

            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingSetupFinished(BillingResult billingResult) {
                Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                billingResult.getResponseCode();
            }
        });
        Preference preferenceFindPreference9 = findPreference("restore_purchases");
        if (preferenceFindPreference9 != null) {
            preferenceFindPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda11
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$10(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference10 = findPreference("refresh_mythic_subscription");
        int color = ContextCompat.getColor(requireContext(), R.color.mythic_plus);
        if (preferenceFindPreference10 != null) {
            SpannableString spannableString = new SpannableString(getString(R.string.refresh_mythic_subscription));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 0);
            preferenceFindPreference10.setTitle(spannableString);
        }
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setVisible(z);
        }
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda13
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$12(preferencesManager, this, preference);
                }
            });
        }
        Preference preferenceFindPreference11 = findPreference("disclaimer");
        if (preferenceFindPreference11 != null) {
            preferenceFindPreference11.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda14
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$13(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference12 = findPreference("rate_app");
        if (preferenceFindPreference12 != null) {
            preferenceFindPreference12.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$$ExternalSyntheticLambda15
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return AllSettingsFragment.onCreatePreferences$lambda$14(this.f$0, preference);
                }
            });
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        if (!(preference instanceof FontPreviewListPreference)) {
            super.onDisplayPreferenceDialog(preference);
            return;
        }
        FontPreviewDialogFragment.Companion companion = FontPreviewDialogFragment.INSTANCE;
        String key = ((FontPreviewListPreference) preference).getKey();
        Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
        FontPreviewDialogFragment fontPreviewDialogFragmentNewInstance = companion.newInstance(key);
        fontPreviewDialogFragmentNewInstance.setTargetFragment(this, 0);
        fontPreviewDialogFragmentNewInstance.show(getParentFragmentManager(), "FontPreviewDialogFragment");
    }
}
