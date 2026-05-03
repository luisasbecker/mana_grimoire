package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.NewPlayerDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventPlayersBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventPlayersFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000201B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPlayersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/TournamentPlayerClickListener;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventPlayersFragment$EventPlayersCallback;", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/EventsViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/EventsViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventPlayersBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventPlayersBinding;", "players", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "getPlayers", "()Ljava/util/List;", "setPlayers", "(Ljava/util/List;)V", "currentPlayersAdapter", "Lcom/studiolaganne/lengendarylens/TournamentPlayersAdapter;", "onAddPlayerClick", "", "onPlayerRemoved", "id", "", "name", "addNewPlayer", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "EventPlayersCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventPlayersFragment extends Fragment implements TournamentPlayerClickListener {
    private FragmentEventPlayersBinding _binding;
    private EventPlayersCallback callback;
    private TournamentPlayersAdapter currentPlayersAdapter;
    private List<TournamentPlayer> players = new ArrayList();

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventPlayersFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPlayersFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventPlayersFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventPlayersFragment newInstance() {
            EventPlayersFragment eventPlayersFragment = new EventPlayersFragment();
            eventPlayersFragment.setArguments(new Bundle());
            return eventPlayersFragment;
        }
    }

    /* JADX INFO: compiled from: EventPlayersFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPlayersFragment$EventPlayersCallback;", "", "eventPlayersNextButtonPressed", "", "players", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface EventPlayersCallback {
        void eventPlayersNextButtonPressed(List<TournamentPlayer> players);
    }

    /* JADX INFO: compiled from: EventPlayersFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.CONSTRUCTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PairingType.values().length];
            try {
                iArr2[PairingType.SINGLE_ELIMINATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PairingType.SWISS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[MatchType.values().length];
            try {
                iArr3[MatchType.BO1.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[MatchType.BO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[MatchType.BO5.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public EventPlayersFragment() {
        final EventPlayersFragment eventPlayersFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(eventPlayersFragment, Reflection.getOrCreateKotlinClass(EventsViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return eventPlayersFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? eventPlayersFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return eventPlayersFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final void addNewPlayer(String name) {
        Object next;
        PreferencesManager preferencesManager;
        Tournament currentTournament;
        Iterator<T> it = this.players.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String lowerCase = ((TournamentPlayer) next).getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String lowerCase2 = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                break;
            }
        }
        if (((TournamentPlayer) next) != null) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.player_error_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.player_error_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EventPlayersFragment.addNewPlayer$lambda$1$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "CustomDialogFragment");
            return;
        }
        TournamentPlayer tournamentPlayer = new TournamentPlayer(null, null, null, 0, 15, null);
        String string4 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        tournamentPlayer.setId(string4);
        tournamentPlayer.setName(name);
        this.players.add(tournamentPlayer);
        Context context = getContext();
        if (context != null && (currentTournament = (preferencesManager = new PreferencesManager(context)).getCurrentTournament()) != null) {
            currentTournament.setPlayers(this.players);
            preferencesManager.saveCurrentTournament(currentTournament);
        }
        TournamentPlayersAdapter tournamentPlayersAdapter = new TournamentPlayersAdapter(this.players, this);
        getBinding().playersRecyclerView.setAdapter(tournamentPlayersAdapter);
        this.currentPlayersAdapter = tournamentPlayersAdapter;
        getBinding().playersRecyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EventPlayersFragment eventPlayersFragment = this.f$0;
                eventPlayersFragment.getBinding().playersRecyclerView.scrollToPosition(eventPlayersFragment.players.size());
            }
        });
        if (this.players.size() >= 2) {
            getBinding().nextButton.setEnabled(true);
            getBinding().nextButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
            getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background);
        } else {
            getBinding().nextButton.setEnabled(false);
            getBinding().nextButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
            getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background_disabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addNewPlayer$lambda$1$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final EventsViewModel getSharedViewModel() {
        return (EventsViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final EventPlayersFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onAddPlayerClick$lambda$0(EventPlayersFragment eventPlayersFragment, String str, NewPlayerDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            String string = StringsKt.trim((CharSequence) str2).toString();
            if (string.length() > 0) {
                eventPlayersFragment.addNewPlayer(string);
            }
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    static final Unit onAddPlayerClick$lambda$1(NewPlayerDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onAddPlayerClick$lambda$2(EventPlayersFragment eventPlayersFragment, String str, NewPlayerDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (str != null && str.length() > 0) {
            eventPlayersFragment.addNewPlayer(str);
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    static final Unit onAddPlayerClick$lambda$3(NewPlayerDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final boolean onPlayerRemoved$lambda$0(String str, TournamentPlayer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getId(), str);
    }

    static final Unit onViewCreated$lambda$1(EventPlayersFragment eventPlayersFragment) {
        EventPlayersCallback eventPlayersCallback = eventPlayersFragment.callback;
        if (eventPlayersCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            eventPlayersCallback = null;
        }
        eventPlayersCallback.eventPlayersNextButtonPressed(eventPlayersFragment.players);
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$2(EventPlayersFragment eventPlayersFragment, List list) {
        Intrinsics.checkNotNull(list);
        eventPlayersFragment.players = list;
        TournamentPlayersAdapter tournamentPlayersAdapter = new TournamentPlayersAdapter(list, eventPlayersFragment);
        eventPlayersFragment.getBinding().playersRecyclerView.setAdapter(tournamentPlayersAdapter);
        eventPlayersFragment.currentPlayersAdapter = tournamentPlayersAdapter;
        if (eventPlayersFragment.players.size() >= 2) {
            eventPlayersFragment.getBinding().nextButton.setEnabled(true);
            eventPlayersFragment.getBinding().nextButton.setTextColor(ContextCompat.getColor(eventPlayersFragment.requireContext(), R.color.almost_white));
            eventPlayersFragment.getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background);
        } else {
            eventPlayersFragment.getBinding().nextButton.setEnabled(false);
            eventPlayersFragment.getBinding().nextButton.setTextColor(ContextCompat.getColor(eventPlayersFragment.requireContext(), R.color.light_grey));
            eventPlayersFragment.getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background_disabled);
        }
    }

    static final void onViewCreated$lambda$3(EventPlayersFragment eventPlayersFragment, EventType eventType) {
        int i = eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            eventPlayersFragment.getBinding().eventTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.event_type_constructed));
        } else if (i == 2) {
            eventPlayersFragment.getBinding().eventTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.event_type_sealed));
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            eventPlayersFragment.getBinding().eventTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.event_type_draft));
        }
    }

    static final void onViewCreated$lambda$4(EventPlayersFragment eventPlayersFragment, PairingType pairingType) {
        int i = pairingType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[pairingType.ordinal()];
        if (i == 1) {
            eventPlayersFragment.getBinding().pairingTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.pairing_type_single));
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            eventPlayersFragment.getBinding().pairingTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.pairing_type_swiss));
        }
    }

    static final void onViewCreated$lambda$5(EventPlayersFragment eventPlayersFragment, MatchType matchType) {
        int i = matchType == null ? -1 : WhenMappings.$EnumSwitchMapping$2[matchType.ordinal()];
        if (i == 1) {
            eventPlayersFragment.getBinding().matchTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.match_type_bo1));
        } else if (i == 2) {
            eventPlayersFragment.getBinding().matchTypeTextView.setText(eventPlayersFragment.getResources().getString(R.string.match_type_bo3));
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final FragmentEventPlayersBinding getBinding() {
        FragmentEventPlayersBinding fragmentEventPlayersBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventPlayersBinding);
        return fragmentEventPlayersBinding;
    }

    public final List<TournamentPlayer> getPlayers() {
        return this.players;
    }

    @Override // com.studiolaganne.lengendarylens.TournamentPlayerClickListener
    public void onAddPlayerClick() {
        NewPlayerDialogFragment.Builder builder = new NewPlayerDialogFragment.Builder();
        String string = getString(R.string.new_player_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        builder.setTitle(string).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventPlayersFragment.onAddPlayerClick$lambda$0(this.f$0, (String) obj, (NewPlayerDialogFragment) obj2);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventPlayersFragment.onAddPlayerClick$lambda$1((NewPlayerDialogFragment) obj);
            }
        }).setKeyboardDismissCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventPlayersFragment.onAddPlayerClick$lambda$2(this.f$0, (String) obj, (NewPlayerDialogFragment) obj2);
            }
        }).setOutsideTouchCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventPlayersFragment.onAddPlayerClick$lambda$3((NewPlayerDialogFragment) obj);
            }
        }).build().show(getChildFragmentManager(), "newPlayerDialog");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.EventPlayersFragment.EventPlayersCallback");
            this.callback = (EventPlayersCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentEventPlayersBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.TournamentPlayerClickListener
    public void onPlayerRemoved(final String id, String name) {
        PreferencesManager preferencesManager;
        Tournament currentTournament;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        List<TournamentPlayer> list = this.players;
        final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(EventPlayersFragment.onPlayerRemoved$lambda$0(id, (TournamentPlayer) obj));
            }
        };
        list.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Boolean) function1.invoke(obj)).booleanValue();
            }
        });
        Context context = getContext();
        if (context != null && (currentTournament = (preferencesManager = new PreferencesManager(context)).getCurrentTournament()) != null) {
            currentTournament.setPlayers(this.players);
            preferencesManager.saveCurrentTournament(currentTournament);
        }
        TournamentPlayersAdapter tournamentPlayersAdapter = new TournamentPlayersAdapter(this.players, this);
        getBinding().playersRecyclerView.setAdapter(tournamentPlayersAdapter);
        this.currentPlayersAdapter = tournamentPlayersAdapter;
        if (this.players.size() >= 2) {
            getBinding().nextButton.setEnabled(true);
            getBinding().nextButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
            getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background);
        } else {
            getBinding().nextButton.setEnabled(false);
            getBinding().nextButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
            getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background_disabled);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        List<TournamentPlayer> value = getSharedViewModel().getPlayers().getValue();
        if (value != null) {
            this.players = value;
        }
        TournamentPlayersAdapter tournamentPlayersAdapter = new TournamentPlayersAdapter(this.players, this);
        getBinding().playersRecyclerView.setAdapter(tournamentPlayersAdapter);
        getBinding().playersRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        if (this.players.size() >= 2) {
            getBinding().nextButton.setEnabled(true);
            getBinding().nextButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
            getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background);
        } else {
            getBinding().nextButton.setEnabled(false);
            getBinding().nextButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
            getBinding().nextButton.setBackgroundResource(R.drawable.custom_life_button_background_disabled);
        }
        this.currentPlayersAdapter = tournamentPlayersAdapter;
        MaterialButton nextButton = getBinding().nextButton;
        Intrinsics.checkNotNullExpressionValue(nextButton, "nextButton");
        ViewExtensionsKt.setOnClickWithFade(nextButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventPlayersFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        getSharedViewModel().getPlayers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventPlayersFragment.onViewCreated$lambda$2(this.f$0, (List) obj);
            }
        });
        getSharedViewModel().getEventType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventPlayersFragment.onViewCreated$lambda$3(this.f$0, (EventType) obj);
            }
        });
        getSharedViewModel().getPairingType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventPlayersFragment.onViewCreated$lambda$4(this.f$0, (PairingType) obj);
            }
        });
        getSharedViewModel().getMatchType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventPlayersFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventPlayersFragment.onViewCreated$lambda$5(this.f$0, (MatchType) obj);
            }
        });
    }

    public final void setPlayers(List<TournamentPlayer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.players = list;
    }
}
