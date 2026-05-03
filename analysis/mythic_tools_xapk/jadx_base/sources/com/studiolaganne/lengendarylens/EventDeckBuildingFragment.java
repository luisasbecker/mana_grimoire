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
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventDeckBuildingBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: EventDeckBuildingFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0014J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020\u0012H\u0014J\b\u0010&\u001a\u00020\u0012H\u0014J\b\u0010'\u001a\u00020\u0012H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventDeckBuildingFragment;", "Lcom/studiolaganne/lengendarylens/TimerFragment;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventContentCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/EventContentCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/EventContentCallback;)V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventDeckBuildingBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventDeckBuildingBinding;", "isViewDestroyed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateCountdownText", "timeMillis", "", "updateAutoStartCountdownText", "onTimerStarted", "onTimerPaused", "onTimerExpired", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventDeckBuildingFragment extends TimerFragment {
    private FragmentEventDeckBuildingBinding _binding;
    public EventContentCallback callback;
    private boolean isViewDestroyed;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventDeckBuildingFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventDeckBuildingFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventDeckBuildingFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventDeckBuildingFragment newInstance() {
            EventDeckBuildingFragment eventDeckBuildingFragment = new EventDeckBuildingFragment();
            eventDeckBuildingFragment.setArguments(new Bundle());
            return eventDeckBuildingFragment;
        }
    }

    @JvmStatic
    public static final EventDeckBuildingFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onTimerExpired$lambda$0(EventDeckBuildingFragment eventDeckBuildingFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (eventDeckBuildingFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Intent intent = new Intent(eventDeckBuildingFragment.requireContext(), (Class<?>) TimerService.class);
        intent.setAction(TimerService.ACTION_STOP_ALARM);
        FragmentActivity activity = eventDeckBuildingFragment.getActivity();
        if (activity != null) {
            activity.startService(intent);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$0(EventDeckBuildingFragment eventDeckBuildingFragment) {
        PreferencesManager preferencesManager;
        Tournament currentTournament;
        eventDeckBuildingFragment.pauseCountdown();
        eventDeckBuildingFragment.pauseAutoStartCountdown();
        Context context = eventDeckBuildingFragment.getContext();
        if (context != null && (currentTournament = (preferencesManager = new PreferencesManager(context)).getCurrentTournament()) != null) {
            currentTournament.setCurrentTimerActive(false);
            currentTournament.setCurrentTimeLeft(0L);
            preferencesManager.saveCurrentTournament(currentTournament);
        }
        EventContentCallback.moveToRoundOne$default(eventDeckBuildingFragment.getCallback(), false, 1, null);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(EventDeckBuildingFragment eventDeckBuildingFragment) {
        if (eventDeckBuildingFragment.getTimeLeft() == 0) {
            return Unit.INSTANCE;
        }
        if (eventDeckBuildingFragment.getIsTimerRunning()) {
            eventDeckBuildingFragment.pauseCountdown();
        } else {
            eventDeckBuildingFragment.startCountdown();
        }
        return Unit.INSTANCE;
    }

    public final FragmentEventDeckBuildingBinding getBinding() {
        FragmentEventDeckBuildingBinding fragmentEventDeckBuildingBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventDeckBuildingBinding);
        return fragmentEventDeckBuildingBinding;
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
        this._binding = FragmentEventDeckBuildingBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isViewDestroyed = true;
    }

    @Override // com.studiolaganne.lengendarylens.TimerFragment
    protected void onTimerExpired() {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.timer_service_finished_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.timer_service_finished_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EventDeckBuildingFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventDeckBuildingFragment.onTimerExpired$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
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
        MaterialButton nextButton = getBinding().nextButton;
        Intrinsics.checkNotNullExpressionValue(nextButton, "nextButton");
        ViewExtensionsKt.setOnClickWithFade(nextButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventDeckBuildingFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDeckBuildingFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        setInitialTimeLeft(((long) preferencesManager.getIntFromString(PreferencesManager.DEFAULT_DECK_DURATION, 45)) * DurationKt.MILLIS_IN_MINUTE);
        setTimeLeft(getInitialTimeLeft());
        if (currentTournament != null) {
            boolean z2 = false;
            if (currentTournament.getCurrentTimerActive()) {
                setTimeLeft(currentTournament.getCurrentTimeLeft());
                z = true;
                if (getTimeLeft() == 0) {
                    getBinding().autoStartLabel.setVisibility(8);
                } else {
                    z2 = true;
                    z = false;
                }
                updateCountdownText(getTimeLeft());
            } else {
                updateCountdownText(getInitialTimeLeft());
                z = false;
            }
            if (z2) {
                startCountdown();
            } else if (!z) {
                TextView textView = getBinding().autoStartLabel;
                String string = getString(R.string.auto_start);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                textView.setText(StringsKt.replace$default(string, "{0}", "5:00", false, 4, (Object) null));
                startAutoStartCountdown(getAutoStartTimeLeft());
            }
        }
        ImageView playButton = getBinding().playButton;
        Intrinsics.checkNotNullExpressionValue(playButton, "playButton");
        ViewExtensionsKt.setOnClickWithFade(playButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventDeckBuildingFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDeckBuildingFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
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
