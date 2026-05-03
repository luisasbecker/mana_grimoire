package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.EventContentFragment;
import com.studiolaganne.lengendarylens.EventPlayersFragment;
import com.studiolaganne.lengendarylens.EventSettingsFragment;
import com.studiolaganne.lengendarylens.NewEventFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventsBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;

/* JADX INFO: compiled from: EventsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002@AB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ(\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0016\u0010%\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J \u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001cH\u0002J\u0012\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001aH\u0016J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020?H\u0017R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/NewEventFragment$NewEventCallback;", "Lcom/studiolaganne/lengendarylens/EventPlayersFragment$EventPlayersCallback;", "Lcom/studiolaganne/lengendarylens/EventSettingsFragment$EventSettingsCallback;", "Lcom/studiolaganne/lengendarylens/EventContentFragment$ContentCallback;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/EventsViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/EventsViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventsBinding;", "adapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "currentTournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "isVisible", "", "clearCurrentTournament", "", "calculateRounds", "", "players", "eventSettingsCreateButtonPressed", "enableTimer", "timerMinutes", "rounds", "enableCrossPod", "eventPlayersNextButtonPressed", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "newEventNextButtonPressed", "eventType", "Lcom/studiolaganne/lengendarylens/EventType;", "pairingType", "Lcom/studiolaganne/lengendarylens/PairingType;", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "loadTournament", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHiddenChanged", "hidden", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "EventPagerAdapter", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventsFragment extends Fragment implements NewEventFragment.NewEventCallback, EventPlayersFragment.EventPlayersCallback, EventSettingsFragment.EventSettingsCallback, EventContentFragment.ContentCallback {
    private FragmentEventsBinding _binding;
    private FragmentStateAdapter adapter;
    private Tournament currentTournament = new Tournament(null, 0, null, 0, null, null, null, 0, 0, false, 0, null, null, null, 0, null, false, 131071, null);
    private boolean isVisible = true;
    private PreferencesManager prefs;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventsFragment newInstance() {
            return new EventsFragment();
        }
    }

    /* JADX INFO: compiled from: EventsFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventsFragment$EventPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "<init>", "(Lcom/studiolaganne/lengendarylens/EventsFragment;)V", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class EventPagerAdapter extends FragmentStateAdapter {
        public EventPagerAdapter() {
            super(EventsFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position == 0) {
                return NewEventFragment.INSTANCE.newInstance();
            }
            if (position == 1) {
                return EventPlayersFragment.INSTANCE.newInstance();
            }
            if (position == 2) {
                return EventSettingsFragment.INSTANCE.newInstance();
            }
            throw new IllegalArgumentException("Invalid position " + position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 3;
        }
    }

    /* JADX INFO: compiled from: EventsFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.CONSTRUCTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.DRAFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.SEALED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EventsFragment() {
        final EventsFragment eventsFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(eventsFragment, Reflection.getOrCreateKotlinClass(EventsViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.EventsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return eventsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.EventsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? eventsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.EventsFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return eventsFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eventSettingsCreateButtonPressed$lambda$0$0(TournamentPlayer tournamentPlayer, TournamentPlayer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getId(), tournamentPlayer.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eventSettingsCreateButtonPressed$lambda$0$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentEventsBinding getBinding() {
        FragmentEventsBinding fragmentEventsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventsBinding);
        return fragmentEventsBinding;
    }

    private final EventsViewModel getSharedViewModel() {
        return (EventsViewModel) this.sharedViewModel.getValue();
    }

    private final void loadTournament() {
        if (isDetached()) {
            return;
        }
        EventContentFragment eventContentFragmentNewInstance = EventContentFragment.INSTANCE.newInstance();
        eventContentFragmentNewInstance.setCallback(this);
        FragmentContainerView fragmentContainer = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        toolbar.setVisibility(8);
        getBinding().viewPager.setVisibility(8);
        fragmentContainer.setVisibility(0);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, eventContentFragmentNewInstance);
        fragmentTransactionBeginTransaction.commit();
    }

    @JvmStatic
    public static final EventsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0(EventsFragment eventsFragment, FragmentActivity fragmentActivity) {
        int setupStep = eventsFragment.currentTournament.getSetupStep();
        if (setupStep == 1) {
            if (fragmentActivity instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivity;
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayOptions(2, 2);
                }
                ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setDisplayHomeAsUpEnabled(true);
                }
            }
            eventsFragment.getBinding().viewPager.setCurrentItem(1, false);
            return;
        }
        if (setupStep != 2) {
            if (setupStep != 3) {
                return;
            }
            eventsFragment.loadTournament();
            return;
        }
        if (fragmentActivity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity2 = (AppCompatActivity) fragmentActivity;
            ActionBar supportActionBar3 = appCompatActivity2.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setDisplayOptions(2, 2);
            }
            ActionBar supportActionBar4 = appCompatActivity2.getSupportActionBar();
            if (supportActionBar4 != null) {
                supportActionBar4.setDisplayHomeAsUpEnabled(true);
            }
        }
        eventsFragment.getBinding().viewPager.setCurrentItem(2, false);
    }

    public final int calculateRounds(int players) {
        int i = 0;
        while (players > 1) {
            i++;
            if (players % 2 == 1) {
                players++;
            }
            players /= 2;
        }
        return i;
    }

    @Override // com.studiolaganne.lengendarylens.EventContentFragment.ContentCallback
    public void clearCurrentTournament() {
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("event_clear_tournament");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("event_clear_tournament", null);
        this.currentTournament = new Tournament(null, 0, null, 0, null, null, null, 0, 0, false, 0L, null, null, null, 0, null, false, 131071, null);
        getBinding().toolbar.setVisibility(0);
        getBinding().viewPager.setVisibility(0);
        getBinding().fragmentContainer.setVisibility(8);
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            appCompatActivity.setSupportActionBar(getBinding().toolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayOptions(0, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setTitle(getString(R.string.new_event));
            }
            ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setDisplayHomeAsUpEnabled(false);
            }
        }
        if (getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            Intent intent = new Intent(getContext(), (Class<?>) TimerService.class);
            intent.setAction(TimerService.ACTION_PAUSE);
            Context context = getContext();
            if (context != null) {
                context.startService(intent);
            }
        }
        if (getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            Intent intent2 = new Intent(getContext(), (Class<?>) TimerService.class);
            Context context2 = getContext();
            if (context2 != null) {
                context2.stopService(intent2);
            }
        }
        getSharedViewModel().getEventType().setValue(EventType.CONSTRUCTED);
        getSharedViewModel().getPairingType().setValue(PairingType.SINGLE_ELIMINATION);
        getSharedViewModel().getMatchType().setValue(MatchType.BO3);
        getSharedViewModel().getNumPlayers().setValue(0);
        getSharedViewModel().getPlayers().setValue(new ArrayList());
        getBinding().viewPager.setCurrentItem(0, false);
    }

    @Override // com.studiolaganne.lengendarylens.EventPlayersFragment.EventPlayersCallback
    public void eventPlayersNextButtonPressed(List<TournamentPlayer> players) {
        ActionBar supportActionBar;
        Intrinsics.checkNotNullParameter(players, "players");
        this.currentTournament.setPlayers(players);
        getSharedViewModel().getNumPlayers().setValue(Integer.valueOf(players.size()));
        this.currentTournament.setSetupStep(2);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentTournament(this.currentTournament);
        ViewPager2 viewPager2 = getBinding().viewPager;
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AppCompatActivity) || (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setTitle(getString(R.string.settings));
    }

    @Override // com.studiolaganne.lengendarylens.EventSettingsFragment.EventSettingsCallback
    public void eventSettingsCreateButtonPressed(boolean enableTimer, int timerMinutes, int rounds, boolean enableCrossPod) {
        Tournament tournament = this.currentTournament;
        if (!enableTimer) {
            timerMinutes = 0;
        }
        tournament.setRoundTimer(timerMinutes);
        this.currentTournament.setAllowCrossTablePairings(enableCrossPod);
        this.currentTournament.setNumberOfRounds(rounds);
        if (this.currentTournament.getPairingType() == PairingType.SINGLE_ELIMINATION) {
            this.currentTournament.setNumberOfRounds(calculateRounds(this.currentTournament.getPlayers().size()));
        }
        PreferencesManager preferencesManager = null;
        if (this.currentTournament.getEventType() == EventType.DRAFT) {
            int size = this.currentTournament.getPlayers().size();
            List mutableList = CollectionsKt.toMutableList((Collection) this.currentTournament.getPlayers());
            Iterator<Integer> it = DraftUtils.INSTANCE.getInstance().getDraftTables(size).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                DraftTable draftTable = new DraftTable(null, null, 3, null);
                for (int i = 0; i < iIntValue; i++) {
                    final TournamentPlayer tournamentPlayer = (TournamentPlayer) CollectionsKt.random(mutableList, Random.INSTANCE);
                    if (tournamentPlayer != null) {
                        draftTable.getPlayers().add(tournamentPlayer);
                        final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.EventsFragment$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(EventsFragment.eventSettingsCreateButtonPressed$lambda$0$0(tournamentPlayer, (TournamentPlayer) obj));
                            }
                        };
                        mutableList.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.EventsFragment$$ExternalSyntheticLambda2
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return EventsFragment.eventSettingsCreateButtonPressed$lambda$0$1(function1, obj);
                            }
                        });
                    }
                }
                this.currentTournament.getTables().add(draftTable);
            }
        }
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager2 = null;
        }
        int i2 = preferencesManager2.getInt(PreferencesManager.NUM_EVENTS, 0) + 1;
        PreferencesManager preferencesManager3 = this.prefs;
        if (preferencesManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager3 = null;
        }
        preferencesManager3.setInt(PreferencesManager.NUM_EVENTS, i2);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        if (i2 == 1) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("first_event");
            firebaseAnalytics.logEvent("first_event", null);
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("new_event");
        firebaseAnalytics.logEvent("new_event", null);
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.currentTournament.getEventType().ordinal()];
        if (i3 == 1) {
            this.currentTournament.setTournamentStep(TournamentStep.IN_ROUNDS);
        } else if (i3 == 2) {
            this.currentTournament.setTournamentStep(TournamentStep.DRAFTING);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.currentTournament.setTournamentStep(TournamentStep.DECK_BUILDING);
        }
        this.currentTournament.setSetupStep(3);
        PreferencesManager preferencesManager4 = this.prefs;
        if (preferencesManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager = preferencesManager4;
        }
        preferencesManager.saveCurrentTournament(this.currentTournament);
        loadTournament();
    }

    @Override // com.studiolaganne.lengendarylens.NewEventFragment.NewEventCallback
    public void newEventNextButtonPressed(EventType eventType, PairingType pairingType, MatchType matchType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(pairingType, "pairingType");
        Intrinsics.checkNotNullParameter(matchType, "matchType");
        FragmentActivity activity = getActivity();
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
                supportActionBar3.setTitle(getString(R.string.title_players));
            }
        }
        this.currentTournament.setEventType(eventType);
        this.currentTournament.setPairingType(pairingType);
        this.currentTournament.setMatchType(matchType);
        this.currentTournament.setSetupStep(1);
        PreferencesManager preferencesManager = this.prefs;
        if (preferencesManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            preferencesManager = null;
        }
        preferencesManager.saveCurrentTournament(this.currentTournament);
        getSharedViewModel().getEventType().setValue(eventType);
        getSharedViewModel().getPairingType().setValue(pairingType);
        getSharedViewModel().getMatchType().setValue(matchType);
        ViewPager2 viewPager2 = getBinding().viewPager;
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentEventsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        ActionBar supportActionBar;
        super.onHiddenChanged(hidden);
        this.isVisible = !hidden;
        if (hidden || getActivity() == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            appCompatActivity.setSupportActionBar(getBinding().toolbar);
            int currentItem = getBinding().viewPager.getCurrentItem();
            if (currentItem == 0) {
                ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setTitle(getString(R.string.new_event));
                }
            } else if (currentItem == 1) {
                ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.setTitle(getString(R.string.title_players));
                }
            } else if (currentItem == 2 && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
                supportActionBar.setTitle(getString(R.string.settings));
            }
            if (getBinding().viewPager.getCurrentItem() > 0) {
                ActionBar supportActionBar4 = appCompatActivity.getSupportActionBar();
                if (supportActionBar4 != null) {
                    supportActionBar4.setDisplayOptions(2, 2);
                }
                ActionBar supportActionBar5 = appCompatActivity.getSupportActionBar();
                if (supportActionBar5 != null) {
                    supportActionBar5.setDisplayHomeAsUpEnabled(true);
                    return;
                }
                return;
            }
            ActionBar supportActionBar6 = appCompatActivity.getSupportActionBar();
            if (supportActionBar6 != null) {
                supportActionBar6.setDisplayOptions(0, 2);
            }
            ActionBar supportActionBar7 = appCompatActivity.getSupportActionBar();
            if (supportActionBar7 != null) {
                supportActionBar7.setDisplayHomeAsUpEnabled(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public boolean onOptionsItemSelected(MenuItem item) {
        ActionBar supportActionBar;
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        if (getBinding().viewPager.getCurrentItem() > 0) {
            getBinding().viewPager.setCurrentItem(r6.getCurrentItem() - 1);
            FragmentActivity activity = getActivity();
            if (activity instanceof AppCompatActivity) {
                if (getBinding().viewPager.getCurrentItem() == 0) {
                    AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                    ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
                    if (supportActionBar2 != null) {
                        supportActionBar2.setDisplayOptions(0, 2);
                    }
                    ActionBar supportActionBar3 = appCompatActivity.getSupportActionBar();
                    if (supportActionBar3 != null) {
                        supportActionBar3.setDisplayHomeAsUpEnabled(false);
                    }
                }
                int currentItem = getBinding().viewPager.getCurrentItem();
                if (currentItem == 0) {
                    ActionBar supportActionBar4 = ((AppCompatActivity) activity).getSupportActionBar();
                    if (supportActionBar4 != null) {
                        supportActionBar4.setTitle(getString(R.string.new_event));
                    }
                } else if (currentItem == 1) {
                    ActionBar supportActionBar5 = ((AppCompatActivity) activity).getSupportActionBar();
                    if (supportActionBar5 != null) {
                        supportActionBar5.setTitle(getString(R.string.title_players));
                    }
                } else if (currentItem == 2 && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                    supportActionBar.setTitle(getString(R.string.settings));
                }
            }
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
                supportActionBar.setDisplayOptions(0, 2);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(false);
            }
        }
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.EventsFragment$onViewCreated$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                ActionBar supportActionBar3;
                if (activity == null) {
                    return;
                }
                if (this.getBinding().viewPager.getCurrentItem() <= 0 || !this.isVisible) {
                    setEnabled(false);
                    this.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                    setEnabled(true);
                    return;
                }
                this.getBinding().viewPager.setCurrentItem(r0.getCurrentItem() - 1);
                FragmentActivity fragmentActivity = activity;
                if (fragmentActivity instanceof AppCompatActivity) {
                    if (this.getBinding().viewPager.getCurrentItem() == 0) {
                        AppCompatActivity appCompatActivity2 = (AppCompatActivity) fragmentActivity;
                        ActionBar supportActionBar4 = appCompatActivity2.getSupportActionBar();
                        if (supportActionBar4 != null) {
                            supportActionBar4.setDisplayOptions(0, 2);
                        }
                        ActionBar supportActionBar5 = appCompatActivity2.getSupportActionBar();
                        if (supportActionBar5 != null) {
                            supportActionBar5.setDisplayHomeAsUpEnabled(false);
                        }
                    }
                    int currentItem = this.getBinding().viewPager.getCurrentItem();
                    if (currentItem == 0) {
                        ActionBar supportActionBar6 = ((AppCompatActivity) fragmentActivity).getSupportActionBar();
                        if (supportActionBar6 != null) {
                            supportActionBar6.setTitle(this.getString(R.string.new_event));
                            return;
                        }
                        return;
                    }
                    if (currentItem != 1) {
                        if (currentItem == 2 && (supportActionBar3 = ((AppCompatActivity) fragmentActivity).getSupportActionBar()) != null) {
                            supportActionBar3.setTitle(this.getString(R.string.settings));
                            return;
                        }
                        return;
                    }
                    ActionBar supportActionBar7 = ((AppCompatActivity) fragmentActivity).getSupportActionBar();
                    if (supportActionBar7 != null) {
                        supportActionBar7.setTitle(this.getString(R.string.title_players));
                    }
                }
            }
        };
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
        getSharedViewModel().getEventType().setValue(EventType.CONSTRUCTED);
        getSharedViewModel().getPairingType().setValue(PairingType.SINGLE_ELIMINATION);
        getSharedViewModel().getMatchType().setValue(MatchType.BO3);
        this.adapter = new EventPagerAdapter();
        ViewPager2 viewPager2 = getBinding().viewPager;
        FragmentStateAdapter fragmentStateAdapter = this.adapter;
        PreferencesManager preferencesManager = null;
        if (fragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fragmentStateAdapter = null;
        }
        viewPager2.setAdapter(fragmentStateAdapter);
        getBinding().viewPager.setUserInputEnabled(false);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext);
        this.prefs = preferencesManager2;
        if (preferencesManager2.hasTournament()) {
            PreferencesManager preferencesManager3 = this.prefs;
            if (preferencesManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
            } else {
                preferencesManager = preferencesManager3;
            }
            Tournament currentTournament = preferencesManager.getCurrentTournament();
            if (currentTournament != null) {
                this.currentTournament = currentTournament;
                getSharedViewModel().getEventType().setValue(this.currentTournament.getEventType());
                getSharedViewModel().getPairingType().setValue(this.currentTournament.getPairingType());
                getSharedViewModel().getMatchType().setValue(this.currentTournament.getMatchType());
                getSharedViewModel().getNumPlayers().setValue(Integer.valueOf(this.currentTournament.getPlayers().size()));
                getSharedViewModel().getPlayers().setValue(this.currentTournament.getPlayers());
                getBinding().fadeInOverlay.setVisibility(0);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getBinding().fadeInOverlay, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(600L);
                objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.EventsFragment$onViewCreated$1$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        this.this$0.getBinding().fadeInOverlay.setVisibility(8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }
                });
                objectAnimatorOfFloat.start();
                getBinding().viewPager.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.EventsFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventsFragment.onViewCreated$lambda$0$0(this.f$0, activity);
                    }
                });
            }
        }
    }
}
