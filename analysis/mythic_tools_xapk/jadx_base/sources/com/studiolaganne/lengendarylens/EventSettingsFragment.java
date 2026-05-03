package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.databinding.FragmentEventSettingsBinding;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventSettingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventSettingsFragment$EventSettingsCallback;", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/EventsViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/EventsViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventSettingsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventSettingsBinding;", "minRounds", "", "maxRounds", "currentRounds", "enableTimer", "", "timerMinutes", "enableCrossPod", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupMinRounds", "numPlayers", "EventSettingsCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventSettingsFragment extends Fragment {
    private FragmentEventSettingsBinding _binding;
    private EventSettingsCallback callback;
    private boolean enableCrossPod;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int minRounds = 3;
    private int maxRounds = 8;
    private int currentRounds = 3;
    private boolean enableTimer = true;
    private int timerMinutes = 50;

    /* JADX INFO: compiled from: EventSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventSettingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventSettingsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventSettingsFragment newInstance() {
            EventSettingsFragment eventSettingsFragment = new EventSettingsFragment();
            eventSettingsFragment.setArguments(new Bundle());
            return eventSettingsFragment;
        }
    }

    /* JADX INFO: compiled from: EventSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventSettingsFragment$EventSettingsCallback;", "", "eventSettingsCreateButtonPressed", "", "enableTimer", "", "timerMinutes", "", "rounds", "enableCrossPod", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface EventSettingsCallback {
        void eventSettingsCreateButtonPressed(boolean enableTimer, int timerMinutes, int rounds, boolean enableCrossPod);
    }

    /* JADX INFO: compiled from: EventSettingsFragment.kt */
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

    public EventSettingsFragment() {
        final EventSettingsFragment eventSettingsFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(eventSettingsFragment, Reflection.getOrCreateKotlinClass(EventsViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return eventSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? eventSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return eventSettingsFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final EventsViewModel getSharedViewModel() {
        return (EventsViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final EventSettingsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onViewCreated$lambda$0(EventSettingsFragment eventSettingsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            eventSettingsFragment.enableTimer = true;
            eventSettingsFragment.getBinding().maxRoundsTextView.setEnabled(true);
            eventSettingsFragment.getBinding().maxRoundsEditText.setEnabled(true);
            eventSettingsFragment.getBinding().maxRoundMinutes.setEnabled(true);
            return;
        }
        eventSettingsFragment.enableTimer = false;
        eventSettingsFragment.getBinding().maxRoundsTextView.setEnabled(false);
        eventSettingsFragment.getBinding().maxRoundsEditText.setEnabled(false);
        eventSettingsFragment.getBinding().maxRoundMinutes.setEnabled(false);
    }

    static final Unit onViewCreated$lambda$1(EventSettingsFragment eventSettingsFragment) {
        Integer intOrNull = StringsKt.toIntOrNull(eventSettingsFragment.getBinding().maxRoundsEditText.getText().toString());
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (intOrNull != null) {
            int iIntValue = intOrNull.intValue();
            eventSettingsFragment.timerMinutes = iIntValue;
            if (iIntValue <= 0) {
                booleanRef.element = false;
            }
        } else {
            new Function0() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventSettingsFragment.onViewCreated$lambda$1$1(booleanRef);
                }
            };
        }
        if (booleanRef.element) {
            EventSettingsCallback eventSettingsCallback = eventSettingsFragment.callback;
            if (eventSettingsCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                eventSettingsCallback = null;
            }
            eventSettingsCallback.eventSettingsCreateButtonPressed(eventSettingsFragment.enableTimer, eventSettingsFragment.timerMinutes, eventSettingsFragment.currentRounds, eventSettingsFragment.enableCrossPod);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1$1(Ref.BooleanRef booleanRef) {
        booleanRef.element = false;
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$2(EventSettingsFragment eventSettingsFragment, Integer num) {
        TextView textView = eventSettingsFragment.getBinding().numPlayersTextView;
        String string = eventSettingsFragment.getResources().getString(R.string.num_players);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(string, "{0}", String.valueOf(num), false, 4, (Object) null));
        Intrinsics.checkNotNull(num);
        eventSettingsFragment.setupMinRounds(num.intValue());
    }

    static final void onViewCreated$lambda$3(EventSettingsFragment eventSettingsFragment, EventType eventType) {
        int i = eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            eventSettingsFragment.getBinding().eventTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.event_type_constructed));
            eventSettingsFragment.getBinding().crossPodSwitch.setVisibility(8);
        } else if (i == 2) {
            eventSettingsFragment.getBinding().eventTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.event_type_sealed));
            eventSettingsFragment.getBinding().crossPodSwitch.setVisibility(8);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            eventSettingsFragment.getBinding().eventTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.event_type_draft));
            eventSettingsFragment.getBinding().crossPodSwitch.setVisibility(0);
        }
    }

    static final void onViewCreated$lambda$4(EventSettingsFragment eventSettingsFragment, PairingType pairingType) {
        int i = pairingType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[pairingType.ordinal()];
        if (i == 1) {
            eventSettingsFragment.getBinding().pairingTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.pairing_type_single));
            eventSettingsFragment.getBinding().roundsHeader.setVisibility(8);
            eventSettingsFragment.getBinding().roundsLayout.setVisibility(8);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            eventSettingsFragment.getBinding().pairingTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.pairing_type_swiss));
            eventSettingsFragment.getBinding().roundsHeader.setVisibility(0);
            eventSettingsFragment.getBinding().roundsLayout.setVisibility(0);
        }
    }

    static final void onViewCreated$lambda$5(EventSettingsFragment eventSettingsFragment, MatchType matchType) {
        int i = matchType == null ? -1 : WhenMappings.$EnumSwitchMapping$2[matchType.ordinal()];
        if (i == 1) {
            eventSettingsFragment.getBinding().matchTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.match_type_bo1));
        } else if (i == 2) {
            eventSettingsFragment.getBinding().matchTypeTextView.setText(eventSettingsFragment.getResources().getString(R.string.match_type_bo3));
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void setupMinRounds(int numPlayers) {
        this.minRounds = 2;
        if (numPlayers >= 410) {
            this.minRounds = 10;
        } else if (numPlayers >= 227) {
            this.minRounds = 9;
        } else if (numPlayers >= 129) {
            this.minRounds = 8;
        } else if (numPlayers >= 65) {
            this.minRounds = 7;
        } else if (numPlayers >= 33) {
            this.minRounds = 6;
        } else if (numPlayers >= 17) {
            this.minRounds = 5;
        } else if (numPlayers >= 9) {
            this.minRounds = 4;
        } else if (numPlayers >= 5) {
            this.minRounds = 3;
        }
        this.maxRounds = Math.min(this.minRounds + 3, numPlayers - 1);
        getBinding().seekBar.setMin(0);
        getBinding().seekBar.setMax(this.maxRounds - this.minRounds);
        getBinding().seekBar.setProgress(0);
        getBinding().seekBar.setKeyProgressIncrement(1);
        this.currentRounds = this.minRounds;
        getBinding().roundsValue.setText(String.valueOf(this.currentRounds));
    }

    public final FragmentEventSettingsBinding getBinding() {
        FragmentEventSettingsBinding fragmentEventSettingsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventSettingsBinding);
        return fragmentEventSettingsBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.EventSettingsFragment.EventSettingsCallback");
            this.callback = (EventSettingsCallback) parentFragment;
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
        this._binding = FragmentEventSettingsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventType value = getSharedViewModel().getEventType().getValue();
        PairingType value2 = getSharedViewModel().getPairingType().getValue();
        MatchType value3 = getSharedViewModel().getMatchType().getValue();
        Integer value4 = getSharedViewModel().getNumPlayers().getValue();
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1) {
            getBinding().eventTypeTextView.setText(getResources().getString(R.string.event_type_constructed));
        } else if (i == 2) {
            getBinding().eventTypeTextView.setText(getResources().getString(R.string.event_type_sealed));
        } else if (i == 3) {
            getBinding().eventTypeTextView.setText(getResources().getString(R.string.event_type_draft));
        }
        int i2 = value2 == null ? -1 : WhenMappings.$EnumSwitchMapping$1[value2.ordinal()];
        if (i2 == 1) {
            getBinding().pairingTypeTextView.setText(getResources().getString(R.string.pairing_type_single));
        } else if (i2 == 2) {
            getBinding().pairingTypeTextView.setText(getResources().getString(R.string.pairing_type_swiss));
        }
        int i3 = value3 != null ? WhenMappings.$EnumSwitchMapping$2[value3.ordinal()] : -1;
        if (i3 == 1) {
            getBinding().matchTypeTextView.setText(getResources().getString(R.string.match_type_bo1));
        } else if (i3 == 2) {
            getBinding().matchTypeTextView.setText(getResources().getString(R.string.match_type_bo3));
        }
        getBinding().roundTimerSwitch.setChecked(true);
        getBinding().maxRoundsTextView.setEnabled(true);
        getBinding().maxRoundsEditText.setEnabled(true);
        getBinding().maxRoundMinutes.setEnabled(true);
        getBinding().roundTimerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventSettingsFragment.onViewCreated$lambda$0(this.f$0, compoundButton, z);
            }
        });
        if (value != EventType.DRAFT) {
            getBinding().crossPodSwitch.setVisibility(8);
        }
        if (value2 == PairingType.SINGLE_ELIMINATION) {
            getBinding().roundsHeader.setVisibility(8);
            getBinding().roundsLayout.setVisibility(8);
        }
        setupMinRounds(value4 != null ? value4.intValue() : 2);
        getBinding().seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment.onViewCreated.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                EventSettingsFragment eventSettingsFragment = EventSettingsFragment.this;
                eventSettingsFragment.currentRounds = eventSettingsFragment.minRounds + progress;
                EventSettingsFragment.this.getBinding().roundsValue.setText(String.valueOf(EventSettingsFragment.this.currentRounds));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        MaterialButton nextButton = getBinding().nextButton;
        Intrinsics.checkNotNullExpressionValue(nextButton, "nextButton");
        ViewExtensionsKt.setOnClickWithFade(nextButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventSettingsFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        getSharedViewModel().getNumPlayers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventSettingsFragment.onViewCreated$lambda$2(this.f$0, (Integer) obj);
            }
        });
        getSharedViewModel().getEventType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventSettingsFragment.onViewCreated$lambda$3(this.f$0, (EventType) obj);
            }
        });
        getSharedViewModel().getPairingType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventSettingsFragment.onViewCreated$lambda$4(this.f$0, (PairingType) obj);
            }
        });
        getSharedViewModel().getMatchType().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.EventSettingsFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventSettingsFragment.onViewCreated$lambda$5(this.f$0, (MatchType) obj);
            }
        });
    }
}
