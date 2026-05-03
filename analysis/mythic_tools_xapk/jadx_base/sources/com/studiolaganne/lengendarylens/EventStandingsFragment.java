package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.activity.result.ActivityResultCaller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.databinding.FragmentEventStandingsBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventStandingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventStandingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventContentCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/EventContentCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/EventContentCallback;)V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventStandingsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventStandingsBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventStandingsFragment extends BottomSheetDialogFragment {
    private FragmentEventStandingsBinding _binding;
    public EventContentCallback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventStandingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventStandingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventStandingsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventStandingsFragment newInstance() {
            EventStandingsFragment eventStandingsFragment = new EventStandingsFragment();
            eventStandingsFragment.setArguments(new Bundle());
            return eventStandingsFragment;
        }
    }

    @JvmStatic
    public static final EventStandingsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(final EventStandingsFragment eventStandingsFragment, Tournament tournament) {
        if (eventStandingsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        boolean z = tournament.getPlayers().size() > 16;
        boolean z2 = tournament.getPlayers().size() > 8;
        boolean z3 = tournament.getPlayers().size() > 4;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(eventStandingsFragment.requireContext(), R.style.TransparentBottomSheetDialog);
        View viewInflate = eventStandingsFragment.getLayoutInflater().inflate(R.layout.bottom_sheet_finals_layout, (ViewGroup) null);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        bottomSheetDialog.setContentView(viewInflate);
        Button button = (Button) viewInflate.findViewById(R.id.top2_button);
        Button button2 = (Button) viewInflate.findViewById(R.id.top4_button);
        Button button3 = (Button) viewInflate.findViewById(R.id.top8_button);
        Button button4 = (Button) viewInflate.findViewById(R.id.top16_button);
        final Spinner spinner = (Spinner) viewInflate.findViewById(R.id.match_type_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(eventStandingsFragment.requireContext(), R.layout.custom_spinner_item, new String[]{eventStandingsFragment.getString(R.string.match_type_bo1), eventStandingsFragment.getString(R.string.match_type_bo3)});
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(1);
        if (!z3) {
            button2.setVisibility(8);
        }
        if (!z2) {
            button3.setVisibility(8);
        }
        if (!z) {
            button4.setVisibility(8);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.EventStandingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventStandingsFragment.onViewCreated$lambda$0$0$0(bottomSheetDialog, spinner, eventStandingsFragment, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.EventStandingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventStandingsFragment.onViewCreated$lambda$0$0$1(bottomSheetDialog, spinner, eventStandingsFragment, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.EventStandingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventStandingsFragment.onViewCreated$lambda$0$0$2(bottomSheetDialog, spinner, eventStandingsFragment, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.EventStandingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventStandingsFragment.onViewCreated$lambda$0$0$3(bottomSheetDialog, spinner, eventStandingsFragment, view);
            }
        });
        bottomSheetDialog.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0$0(BottomSheetDialog bottomSheetDialog, Spinner spinner, EventStandingsFragment eventStandingsFragment, View view) {
        bottomSheetDialog.dismiss();
        eventStandingsFragment.getCallback().createFinals(2, spinner.getSelectedItemPosition() == 0 ? MatchType.BO1 : MatchType.BO3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0$1(BottomSheetDialog bottomSheetDialog, Spinner spinner, EventStandingsFragment eventStandingsFragment, View view) {
        bottomSheetDialog.dismiss();
        eventStandingsFragment.getCallback().createFinals(4, spinner.getSelectedItemPosition() == 0 ? MatchType.BO1 : MatchType.BO3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0$2(BottomSheetDialog bottomSheetDialog, Spinner spinner, EventStandingsFragment eventStandingsFragment, View view) {
        bottomSheetDialog.dismiss();
        eventStandingsFragment.getCallback().createFinals(8, spinner.getSelectedItemPosition() == 0 ? MatchType.BO1 : MatchType.BO3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0$3(BottomSheetDialog bottomSheetDialog, Spinner spinner, EventStandingsFragment eventStandingsFragment, View view) {
        bottomSheetDialog.dismiss();
        eventStandingsFragment.getCallback().createFinals(16, spinner.getSelectedItemPosition() == 0 ? MatchType.BO1 : MatchType.BO3);
    }

    public final FragmentEventStandingsBinding getBinding() {
        FragmentEventStandingsBinding fragmentEventStandingsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventStandingsBinding);
        return fragmentEventStandingsBinding;
    }

    public final EventContentCallback getCallback() {
        EventContentCallback eventContentCallback = this.callback;
        if (eventContentCallback != null) {
            return eventContentCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.EventContentCallback");
            setCallback((EventContentCallback) parentFragment);
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentEventStandingsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final Tournament currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament();
        if (currentTournament != null) {
            getBinding().createButton.setVisibility(8);
            if (currentTournament.getTournamentStep() == TournamentStep.FINAL_STANDINGS) {
                getBinding().header.setText(getString(R.string.final_standings));
                if (currentTournament.getPairingType() == PairingType.SWISS) {
                    getBinding().header.setText(getString(R.string.final_swiss_standings));
                    if (currentTournament.getPlayers().size() >= 3) {
                        getBinding().createButton.setVisibility(0);
                    }
                }
            } else {
                getBinding().header.setText(getString(R.string.current_standings));
            }
            List<StandingsRow> currentStandings = TournamentUtils.INSTANCE.getInstance().getCurrentStandings(currentTournament);
            RecyclerView standingsRecyclerView = getBinding().standingsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(standingsRecyclerView, "standingsRecyclerView");
            standingsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            standingsRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.pairings_spacing)));
            standingsRecyclerView.setAdapter(new StandingsAdapter(currentStandings));
            MaterialButton createButton = getBinding().createButton;
            Intrinsics.checkNotNullExpressionValue(createButton, "createButton");
            ViewExtensionsKt.setOnClickWithFade(createButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventStandingsFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventStandingsFragment.onViewCreated$lambda$0$0(this.f$0, currentTournament);
                }
            });
        }
    }

    public final void setCallback(EventContentCallback eventContentCallback) {
        Intrinsics.checkNotNullParameter(eventContentCallback, "<set-?>");
        this.callback = eventContentCallback;
    }
}
