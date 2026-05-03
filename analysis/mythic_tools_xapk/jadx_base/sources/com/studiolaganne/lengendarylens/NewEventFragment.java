package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.databinding.FragmentNewEventBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: NewEventFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewEventFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/EventsViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/EventsViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "callback", "Lcom/studiolaganne/lengendarylens/NewEventFragment$NewEventCallback;", "eventTypeOptions", "", "", "pairingTypeOptions", "matchTypeOptions", "eventType", "Lcom/studiolaganne/lengendarylens/EventType;", "pairingType", "Lcom/studiolaganne/lengendarylens/PairingType;", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentNewEventBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentNewEventBinding;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "NewEventCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewEventFragment extends Fragment {
    private FragmentNewEventBinding _binding;
    private NewEventCallback callback;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<String> eventTypeOptions = new ArrayList();
    private List<String> pairingTypeOptions = new ArrayList();
    private List<String> matchTypeOptions = new ArrayList();
    private EventType eventType = EventType.CONSTRUCTED;
    private PairingType pairingType = PairingType.SINGLE_ELIMINATION;
    private MatchType matchType = MatchType.BO3;

    /* JADX INFO: compiled from: NewEventFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewEventFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/NewEventFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NewEventFragment newInstance() {
            NewEventFragment newEventFragment = new NewEventFragment();
            newEventFragment.setArguments(new Bundle());
            return newEventFragment;
        }
    }

    /* JADX INFO: compiled from: NewEventFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewEventFragment$NewEventCallback;", "", "newEventNextButtonPressed", "", "eventType", "Lcom/studiolaganne/lengendarylens/EventType;", "pairingType", "Lcom/studiolaganne/lengendarylens/PairingType;", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface NewEventCallback {
        void newEventNextButtonPressed(EventType eventType, PairingType pairingType, MatchType matchType);
    }

    /* JADX INFO: compiled from: NewEventFragment.kt */
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
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public NewEventFragment() {
        final NewEventFragment newEventFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(newEventFragment, Reflection.getOrCreateKotlinClass(EventsViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.NewEventFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return newEventFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.NewEventFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? newEventFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.NewEventFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return newEventFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final EventsViewModel getSharedViewModel() {
        return (EventsViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final NewEventFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCreateView$lambda$3(NewEventFragment newEventFragment) {
        NewEventCallback newEventCallback = newEventFragment.callback;
        if (newEventCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            newEventCallback = null;
        }
        newEventCallback.newEventNextButtonPressed(newEventFragment.eventType, newEventFragment.pairingType, newEventFragment.matchType);
        return Unit.INSTANCE;
    }

    public final FragmentNewEventBinding getBinding() {
        FragmentNewEventBinding fragmentNewEventBinding = this._binding;
        Intrinsics.checkNotNull(fragmentNewEventBinding);
        return fragmentNewEventBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.NewEventFragment.NewEventCallback");
            this.callback = (NewEventCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentNewEventBinding.inflate(inflater, container, false);
        String string = getResources().getString(R.string.event_type_constructed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.event_type_sealed);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getResources().getString(R.string.event_type_draft);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.eventTypeOptions = CollectionsKt.mutableListOf(string, string2, string3);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.custom_spinner_item, this.eventTypeOptions);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        getBinding().eventTypeSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        getBinding().eventTypeSpinner.setSelection(0);
        EventType value = getSharedViewModel().getEventType().getValue();
        if (value != null) {
            this.eventType = value;
            int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i == 1) {
                getBinding().eventTypeSpinner.setSelection(0);
            } else if (i == 2) {
                getBinding().eventTypeSpinner.setSelection(1);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                getBinding().eventTypeSpinner.setSelection(2);
            }
        }
        getBinding().eventTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.NewEventFragment.onCreateView.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (NewEventFragment.this.isDetached()) {
                    return;
                }
                String str = (String) NewEventFragment.this.eventTypeOptions.get(position);
                boolean zAreEqual = Intrinsics.areEqual(str, NewEventFragment.this.getResources().getString(R.string.event_type_constructed));
                NewEventFragment newEventFragment = NewEventFragment.this;
                if (zAreEqual) {
                    newEventFragment.eventType = EventType.CONSTRUCTED;
                    return;
                }
                boolean zAreEqual2 = Intrinsics.areEqual(str, newEventFragment.getResources().getString(R.string.event_type_sealed));
                NewEventFragment newEventFragment2 = NewEventFragment.this;
                if (zAreEqual2) {
                    newEventFragment2.eventType = EventType.SEALED;
                } else if (Intrinsics.areEqual(str, newEventFragment2.getResources().getString(R.string.event_type_draft))) {
                    NewEventFragment.this.eventType = EventType.DRAFT;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        String string4 = getResources().getString(R.string.pairing_type_single);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getResources().getString(R.string.pairing_type_swiss);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.pairingTypeOptions = CollectionsKt.mutableListOf(string4, string5);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(requireContext(), R.layout.custom_spinner_item, this.pairingTypeOptions);
        arrayAdapter2.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        getBinding().pairingTypeSpinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        getBinding().pairingTypeSpinner.setSelection(0);
        PairingType value2 = getSharedViewModel().getPairingType().getValue();
        if (value2 != null) {
            this.pairingType = value2;
            int i2 = WhenMappings.$EnumSwitchMapping$1[value2.ordinal()];
            if (i2 == 1) {
                getBinding().pairingTypeSpinner.setSelection(0);
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                getBinding().pairingTypeSpinner.setSelection(1);
            }
        }
        getBinding().pairingTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.NewEventFragment.onCreateView.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (NewEventFragment.this.isDetached()) {
                    return;
                }
                String str = (String) NewEventFragment.this.pairingTypeOptions.get(position);
                boolean zAreEqual = Intrinsics.areEqual(str, NewEventFragment.this.getResources().getString(R.string.pairing_type_single));
                NewEventFragment newEventFragment = NewEventFragment.this;
                if (zAreEqual) {
                    newEventFragment.pairingType = PairingType.SINGLE_ELIMINATION;
                } else if (Intrinsics.areEqual(str, newEventFragment.getResources().getString(R.string.pairing_type_swiss))) {
                    NewEventFragment.this.pairingType = PairingType.SWISS;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        String string6 = getResources().getString(R.string.match_type_bo1);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        String string7 = getResources().getString(R.string.match_type_bo3);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.matchTypeOptions = CollectionsKt.mutableListOf(string6, string7);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(requireContext(), R.layout.custom_spinner_item, this.matchTypeOptions);
        arrayAdapter3.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        getBinding().matchTypeSpinner.setAdapter((SpinnerAdapter) arrayAdapter3);
        getBinding().matchTypeSpinner.setSelection(1);
        MatchType value3 = getSharedViewModel().getMatchType().getValue();
        if (value3 != null) {
            this.matchType = value3;
            int i3 = WhenMappings.$EnumSwitchMapping$2[value3.ordinal()];
            if (i3 == 1) {
                getBinding().matchTypeSpinner.setSelection(0);
            } else if (i3 == 2) {
                getBinding().matchTypeSpinner.setSelection(1);
            }
        }
        getBinding().matchTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.NewEventFragment.onCreateView.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (NewEventFragment.this.isDetached()) {
                    return;
                }
                String str = (String) NewEventFragment.this.matchTypeOptions.get(position);
                boolean zAreEqual = Intrinsics.areEqual(str, NewEventFragment.this.getResources().getString(R.string.match_type_bo1));
                NewEventFragment newEventFragment = NewEventFragment.this;
                if (zAreEqual) {
                    newEventFragment.matchType = MatchType.BO1;
                } else if (Intrinsics.areEqual(str, newEventFragment.getResources().getString(R.string.match_type_bo3))) {
                    NewEventFragment.this.matchType = MatchType.BO3;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        MaterialButton nextButton = getBinding().nextButton;
        Intrinsics.checkNotNullExpressionValue(nextButton, "nextButton");
        ViewExtensionsKt.setOnClickWithFade(nextButton, new Function0() { // from class: com.studiolaganne.lengendarylens.NewEventFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewEventFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }
}
