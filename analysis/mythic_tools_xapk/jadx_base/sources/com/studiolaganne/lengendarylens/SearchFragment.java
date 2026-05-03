package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.studiolaganne.lengendarylens.databinding.FragmentSearchBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentSearchBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentSearchBinding;", "pickACardMode", "", "condense", "searchQuery", "", "lang", "forceLocalDb", "condenseSettingsWasDefault", "cardSelectionListener", "Lcom/studiolaganne/lengendarylens/CardSelectionListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setCardSelectionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchFragment extends Fragment {
    private FragmentSearchBinding _binding;
    private CardSelectionListener cardSelectionListener;
    private boolean forceLocalDb;
    private boolean pickACardMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private boolean condense = true;
    private String searchQuery = "";
    private String lang = "";
    private boolean condenseSettingsWasDefault = true;

    /* JADX INFO: compiled from: SearchFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/SearchFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SearchFragment newInstance() {
            SearchFragment searchFragment = new SearchFragment();
            searchFragment.setArguments(new Bundle());
            return searchFragment;
        }
    }

    private final FragmentSearchBinding getBinding() {
        FragmentSearchBinding fragmentSearchBinding = this._binding;
        Intrinsics.checkNotNull(fragmentSearchBinding);
        return fragmentSearchBinding;
    }

    @JvmStatic
    public static final SearchFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onViewCreated$lambda$1(SearchFragment searchFragment, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Drawable drawable = null;
        tab.setText(i != 0 ? i != 1 ? null : searchFragment.getString(R.string.sets_tab) : searchFragment.getString(R.string.cards_tab));
        if (i == 0) {
            drawable = ContextCompat.getDrawable(searchFragment.requireContext(), R.drawable.cards_icon);
        } else if (i == 1) {
            drawable = ContextCompat.getDrawable(searchFragment.requireContext(), R.drawable.sets_icon);
        }
        tab.setIcon(drawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean z = new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.CONDENSE_SEARCH, true);
        this.condense = z;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pickACardMode = arguments.getBoolean("pickACardMode", false);
            this.condense = arguments.getBoolean("condense", z);
            String string = arguments.getString(SearchIntents.EXTRA_QUERY, "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.searchQuery = string;
            String string2 = arguments.getString("lang", "");
            this.lang = string2 != null ? string2 : "";
            this.forceLocalDb = arguments.getBoolean("forceLocalDb", false);
            arguments.getBoolean("condense", z);
            this.condenseSettingsWasDefault = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSearchBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.condenseSettingsWasDefault) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            this.condense = new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.CONDENSE_SEARCH, true);
            Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("f0");
            if (fragmentFindFragmentByTag == null || !(fragmentFindFragmentByTag instanceof SearchCardsFragment)) {
                return;
            }
            ((SearchCardsFragment) fragmentFindFragmentByTag).updateCondenseSetting(this.condense);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final Bundle bundle = new Bundle();
        bundle.putBoolean("pickACardMode", this.pickACardMode);
        bundle.putBoolean("condense", this.condense);
        bundle.putBoolean("forceLocalDb", this.forceLocalDb);
        bundle.putString(SearchIntents.EXTRA_QUERY, this.searchQuery);
        bundle.putString("lang", this.lang);
        ViewPager2 viewPager = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        viewPager.setAdapter(new FragmentStateAdapter() { // from class: com.studiolaganne.lengendarylens.SearchFragment.onViewCreated.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(SearchFragment.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int position) {
                if (position == 0) {
                    SearchCardsFragment searchCardsFragment = new SearchCardsFragment();
                    searchCardsFragment.setArguments(bundle);
                    searchCardsFragment.setCardSelectionListener(SearchFragment.this.cardSelectionListener);
                    return searchCardsFragment;
                }
                if (position != 1) {
                    return new Fragment();
                }
                BrowseSetsFragment browseSetsFragment = new BrowseSetsFragment();
                browseSetsFragment.setArguments(bundle);
                browseSetsFragment.setCardSelectionListener(SearchFragment.this.cardSelectionListener);
                return browseSetsFragment;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return 2;
            }
        });
        TabLayout tabs = getBinding().tabs;
        Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
        new TabLayoutMediator(tabs, getBinding().viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.studiolaganne.lengendarylens.SearchFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                SearchFragment.onViewCreated$lambda$1(this.f$0, tab, i);
            }
        }).attach();
    }

    public final void setCardSelectionListener(CardSelectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cardSelectionListener = listener;
    }
}
