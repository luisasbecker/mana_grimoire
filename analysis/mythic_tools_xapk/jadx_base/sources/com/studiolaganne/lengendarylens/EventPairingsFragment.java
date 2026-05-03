package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.PeriodicWorkRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventPairingsBinding;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: EventPairingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0015H\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0014J\b\u00100\u001a\u00020\u0015H\u0014J\b\u00101\u001a\u00020\u0015H\u0014J\b\u00102\u001a\u00020\u0015H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPairingsFragment;", "Lcom/studiolaganne/lengendarylens/TimerFragment;", "Lcom/studiolaganne/lengendarylens/PairingsCallback;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventContentCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/EventContentCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/EventContentCallback;)V", "hasDraws", "", "hasConflict", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventPairingsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventPairingsBinding;", "isViewDestroyed", "pairingsUpdated", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onStart", "onStop", "onResume", "submitScores", "updateSubmitButton", "tournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "updateCountdownText", "timeMillis", "", "updateAutoStartCountdownText", "onTimerStarted", "onTimerPaused", "onTimerExpired", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventPairingsFragment extends TimerFragment implements PairingsCallback {
    private FragmentEventPairingsBinding _binding;
    public EventContentCallback callback;
    private boolean hasConflict;
    private boolean hasDraws;
    private boolean isViewDestroyed;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventPairingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPairingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventPairingsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventPairingsFragment newInstance() {
            EventPairingsFragment eventPairingsFragment = new EventPairingsFragment();
            eventPairingsFragment.setArguments(new Bundle());
            return eventPairingsFragment;
        }
    }

    /* JADX INFO: compiled from: EventPairingsFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MatchType.values().length];
            try {
                iArr[MatchType.BO1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MatchType.BO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final EventPairingsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onTimerExpired$lambda$0(EventPairingsFragment eventPairingsFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (eventPairingsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Intent intent = new Intent(eventPairingsFragment.requireContext(), (Class<?>) TimerService.class);
        intent.setAction(TimerService.ACTION_STOP_ALARM);
        FragmentActivity activity = eventPairingsFragment.getActivity();
        if (activity != null) {
            activity.startService(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(EventPairingsFragment eventPairingsFragment) {
        EventStandingsFragment eventStandingsFragmentNewInstance = EventStandingsFragment.INSTANCE.newInstance();
        eventStandingsFragmentNewInstance.show(eventPairingsFragment.getChildFragmentManager(), eventStandingsFragmentNewInstance.getTag());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$1(EventPairingsFragment eventPairingsFragment) {
        EventPlayerListFragment eventPlayerListFragmentNewInstance = EventPlayerListFragment.INSTANCE.newInstance();
        eventPlayerListFragmentNewInstance.show(eventPairingsFragment.getChildFragmentManager(), eventPlayerListFragmentNewInstance.getTag());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$2(EventPairingsFragment eventPairingsFragment) {
        if (eventPairingsFragment.getTimeLeft() == 0) {
            return Unit.INSTANCE;
        }
        if (eventPairingsFragment.getIsTimerRunning()) {
            eventPairingsFragment.pauseCountdown();
        } else {
            eventPairingsFragment.startCountdown();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3(final EventPairingsFragment eventPairingsFragment, Tournament tournament) {
        if (eventPairingsFragment.hasConflict) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = eventPairingsFragment.getString(R.string.pairing_error_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = eventPairingsFragment.getString(R.string.pairing_error_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = eventPairingsFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EventPairingsFragment.onViewCreated$lambda$0$3$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = eventPairingsFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "CustomDialogFragment");
        } else if (eventPairingsFragment.hasDraws && tournament.getPairingType() == PairingType.SINGLE_ELIMINATION) {
            CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
            String string4 = eventPairingsFragment.getString(R.string.pairing_error_title);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
            String string5 = eventPairingsFragment.getString(R.string.pairing_error_draws_body);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            CustomDialogFragment.Builder body2 = title2.setBody(string5);
            String string6 = eventPairingsFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EventPairingsFragment.onViewCreated$lambda$0$3$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager2 = eventPairingsFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            positiveButton2.show(childFragmentManager2, "CustomDialogFragment");
        } else if (eventPairingsFragment.hasDraws) {
            CustomDialogFragment.Builder builder3 = new CustomDialogFragment.Builder();
            String string7 = eventPairingsFragment.getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            CustomDialogFragment.Builder title3 = builder3.setTitle(string7);
            String string8 = eventPairingsFragment.getString(R.string.all_draws_body);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title3.setBody(string8).setPositiveButtonRed();
            String string9 = eventPairingsFragment.getString(R.string.submit);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            CustomDialogFragment.Builder positiveButton3 = positiveButtonRed.setPositiveButton(string9, new Function2() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EventPairingsFragment.onViewCreated$lambda$0$3$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string10 = eventPairingsFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton3.setNegativeButton(string10, new Function1() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EventPairingsFragment.onViewCreated$lambda$0$3$3((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager3 = eventPairingsFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager3, "CustomDialogFragment");
        } else {
            eventPairingsFragment.submitScores();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3$2(EventPairingsFragment eventPairingsFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        eventPairingsFragment.submitScores();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void submitScores() {
        PreferencesManager preferencesManager;
        Tournament currentTournament;
        pauseCountdown();
        Context context = getContext();
        if (context != null && (currentTournament = (preferencesManager = new PreferencesManager(context)).getCurrentTournament()) != null) {
            currentTournament.setCurrentTimerActive(false);
            currentTournament.setCurrentTimeLeft(0L);
            preferencesManager.saveCurrentTournament(currentTournament);
        }
        getCallback().submitStandings();
    }

    private final void updateSubmitButton(Tournament tournament) {
        List<Pairing> pairings = tournament.getRounds().get(tournament.getCurrentRound()).getPairings();
        this.hasDraws = false;
        this.hasConflict = false;
        for (Pairing pairing : pairings) {
            if (pairing.getSecondPlayerId().length() != 0) {
                int i = WhenMappings.$EnumSwitchMapping$0[tournament.getMatchType().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        if (pairing.getFirstPlayerScore() == 2 && pairing.getSecondPlayerScore() == 2) {
                            this.hasConflict = true;
                        } else if ((pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 0) || (pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 1)) {
                            this.hasDraws = true;
                        }
                    }
                } else if (pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 1) {
                    this.hasConflict = true;
                } else if (pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 0) {
                    this.hasDraws = true;
                }
            }
        }
        if (this.hasConflict) {
            getBinding().submitButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
            getBinding().submitButton.setBackgroundResource(R.drawable.custom_life_button_background_disabled);
        } else {
            getBinding().submitButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
            getBinding().submitButton.setBackgroundResource(R.drawable.custom_life_button_background);
        }
    }

    public final FragmentEventPairingsBinding getBinding() {
        FragmentEventPairingsBinding fragmentEventPairingsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventPairingsBinding);
        return fragmentEventPairingsBinding;
    }

    public final EventContentCallback getCallback() {
        EventContentCallback eventContentCallback = this.callback;
        if (eventContentCallback != null) {
            return eventContentCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.isViewDestroyed = false;
        this._binding = FragmentEventPairingsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isViewDestroyed = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Tournament currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament();
        if (currentTournament == null || !currentTournament.getCurrentTimerActive()) {
            return;
        }
        updateCountdownText(currentTournament.getCurrentTimeLeft());
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment
    protected void onTimerExpired() {
        if (getContext() == null || isStateSaved()) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.timer_service_finished_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.timer_service_finished_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventPairingsFragment.onTimerExpired$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "CustomDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment
    protected void onTimerPaused() {
        getBinding().playButton.setImageResource(R.drawable.play_button);
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment
    protected void onTimerStarted() {
        getBinding().autoStartLabel.setVisibility(8);
        getBinding().playButton.setImageResource(R.drawable.pause_button);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getContext() == null) {
            return;
        }
        RecyclerView pairingsRecyclerView = getBinding().pairingsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(pairingsRecyclerView, "pairingsRecyclerView");
        pairingsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final Tournament currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament();
        if (currentTournament != null) {
            TextView textView = getBinding().header;
            String string = getString(R.string.round_x_pairings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            boolean z2 = true;
            textView.setText(StringsKt.replace$default(string, "{0}", String.valueOf(currentTournament.getCurrentRound() + 1), false, 4, (Object) null));
            boolean z3 = false;
            if (currentTournament.getCurrentRound() > 0) {
                getBinding().standingsLayout.setVisibility(0);
            } else {
                getBinding().standingsLayout.setVisibility(8);
            }
            ConstraintLayout standingsLayout = getBinding().standingsLayout;
            Intrinsics.checkNotNullExpressionValue(standingsLayout, "standingsLayout");
            ViewExtensionsKt.setOnClickWithFade(standingsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventPairingsFragment.onViewCreated$lambda$0$0(this.f$0);
                }
            });
            ConstraintLayout constraintLayout = getBinding().playersLayout;
            if (constraintLayout != null) {
                ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EventPairingsFragment.onViewCreated$lambda$0$1(this.f$0);
                    }
                });
            }
            pairingsRecyclerView.setAdapter(new PairingsAdapter(this, currentTournament, currentTournament.getRounds().get(currentTournament.getCurrentRound()).getPairings()));
            pairingsRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.pairings_spacing)));
            if (currentTournament.getRoundTimer() > 0) {
                getBinding().clockLayout.setVisibility(0);
                setInitialTimeLeft(((long) currentTournament.getRoundTimer()) * DurationKt.MILLIS_IN_MINUTE);
                setTimeLeft(getInitialTimeLeft());
                setAutoStartTimeLeft(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
                if (currentTournament.getCurrentTimerActive()) {
                    setTimeLeft(currentTournament.getCurrentTimeLeft());
                    if (getTimeLeft() == 0) {
                        getBinding().autoStartLabel.setVisibility(8);
                        z2 = false;
                        z3 = true;
                    }
                    updateCountdownText(getTimeLeft());
                    z = z3;
                    z3 = z2;
                } else {
                    updateCountdownText(getInitialTimeLeft());
                    z = false;
                }
                ImageView playButton = getBinding().playButton;
                Intrinsics.checkNotNullExpressionValue(playButton, "playButton");
                ViewExtensionsKt.setOnClickWithFade(playButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EventPairingsFragment.onViewCreated$lambda$0$2(this.f$0);
                    }
                });
                if (z3) {
                    startCountdown();
                } else if (!z) {
                    TextView textView2 = getBinding().autoStartLabel;
                    String string2 = getString(R.string.auto_start);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    textView2.setText(StringsKt.replace$default(string2, "{0}", "5:00", false, 4, (Object) null));
                    startAutoStartCountdown(getAutoStartTimeLeft());
                }
            } else {
                getBinding().clockLayout.setVisibility(8);
            }
            updateSubmitButton(currentTournament);
            MaterialButton submitButton = getBinding().submitButton;
            Intrinsics.checkNotNullExpressionValue(submitButton, "submitButton");
            ViewExtensionsKt.setOnClickWithFade(submitButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventPairingsFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventPairingsFragment.onViewCreated$lambda$0$3(this.f$0, currentTournament);
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.PairingsCallback
    public void pairingsUpdated() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Tournament currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament();
        if (currentTournament != null) {
            updateSubmitButton(currentTournament);
        }
    }

    public final void setCallback(EventContentCallback eventContentCallback) {
        Intrinsics.checkNotNullParameter(eventContentCallback, "<set-?>");
        this.callback = eventContentCallback;
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment
    protected void updateAutoStartCountdownText(long timeMillis) {
        if (getContext() == null) {
            return;
        }
        if (timeMillis == 0) {
            getBinding().autoStartLabel.setVisibility(8);
            startCountdown();
            return;
        }
        int i = (int) (timeMillis / 1000);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        TextView textView = getBinding().autoStartLabel;
        String string = getString(R.string.auto_start);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(string, "{0}", str, false, 4, (Object) null));
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment
    protected void updateCountdownText(long timeMillis) {
        if (getContext() == null) {
            return;
        }
        if (timeMillis == 0) {
            getBinding().clockLabel.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        getBinding().clockLabel.setText(formatTime(timeMillis));
    }
}
