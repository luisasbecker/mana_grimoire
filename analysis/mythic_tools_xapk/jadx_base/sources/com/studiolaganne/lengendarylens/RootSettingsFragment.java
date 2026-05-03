package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.databinding.FragmentRootSettingsBinding;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootSettingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u001a\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/RootSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentRootSettingsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentRootSettingsBinding;", "initialSettings", "Lcom/studiolaganne/lengendarylens/MTUserSettings;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RootSettingsFragment extends Fragment {
    private FragmentRootSettingsBinding _binding;
    private MTUserSettings initialSettings;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: RootSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/RootSettingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/RootSettingsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final RootSettingsFragment newInstance() {
            RootSettingsFragment rootSettingsFragment = new RootSettingsFragment();
            rootSettingsFragment.setArguments(new Bundle());
            return rootSettingsFragment;
        }
    }

    private final FragmentRootSettingsBinding getBinding() {
        FragmentRootSettingsBinding fragmentRootSettingsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentRootSettingsBinding);
        return fragmentRootSettingsBinding;
    }

    @JvmStatic
    public static final RootSettingsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
        setHasOptionsMenu(true);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.initialSettings = new PreferencesManager(contextRequireContext).getMTUserSettings();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentRootSettingsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public boolean onOptionsItemSelected(MenuItem item) {
        ActionBar supportActionBar;
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        if (getChildFragmentManager().getBackStackEntryCount() != 0) {
            getChildFragmentManager().popBackStack();
            if (getChildFragmentManager().getBackStackEntryCount() == 1) {
                FragmentActivity activity = getActivity();
                if ((activity instanceof AppCompatActivity) && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                    supportActionBar.setTitle(getString(R.string.settings));
                }
            }
            return true;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 instanceof AppCompatActivity) {
            PreferencesManager preferencesManager = new PreferencesManager(activity2);
            MTUserSettings mTUserSettings = preferencesManager.getMTUserSettings();
            MTUserSettings mTUserSettings2 = this.initialSettings;
            if (mTUserSettings2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initialSettings");
                mTUserSettings2 = null;
            }
            if (!Intrinsics.areEqual(mTUserSettings, mTUserSettings2)) {
                PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
            }
            ((AppCompatActivity) activity2).finish();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            appCompatActivity.setSupportActionBar(getBinding().toolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
        }
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.RootSettingsFragment$onViewCreated$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (activity == null) {
                    return;
                }
                FragmentActivity fragmentActivityRequireActivity = this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                PreferencesManager preferencesManager = new PreferencesManager(fragmentActivityRequireActivity);
                MTUserSettings mTUserSettings = preferencesManager.getMTUserSettings();
                MTUserSettings mTUserSettings2 = this.initialSettings;
                if (mTUserSettings2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("initialSettings");
                    mTUserSettings2 = null;
                }
                if (!Intrinsics.areEqual(mTUserSettings, mTUserSettings2)) {
                    PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
                }
                activity.finish();
            }
        };
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
    }
}
