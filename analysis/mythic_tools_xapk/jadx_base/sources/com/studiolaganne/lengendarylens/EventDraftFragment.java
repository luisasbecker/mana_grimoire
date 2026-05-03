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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventDraftBinding;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
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

/* JADX INFO: compiled from: EventDraftFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0014J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010+\u001a\u00020\u0018H\u0014J\b\u0010,\u001a\u00020\u0018H\u0014J\b\u0010-\u001a\u00020\u0018H\u0014J\b\u0010.\u001a\u00020\u0018H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventDraftFragment;", "Lcom/studiolaganne/lengendarylens/TimerFragment;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventContentCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/EventContentCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/EventContentCallback;)V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventDraftBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventDraftBinding;", "adapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "currentTournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "numTables", "", "isViewDestroyed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateCountdownText", "timeMillis", "", "updateAutoStartCountdownText", "onTimerStarted", "onTimerPaused", "onTimerExpired", "updateHeader", "DraftTablesAdapter", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventDraftFragment extends TimerFragment {
    private FragmentEventDraftBinding _binding;
    private FragmentStateAdapter adapter;
    public EventContentCallback callback;
    private Tournament currentTournament;
    private boolean isViewDestroyed;
    private int numTables;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventDraftFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventDraftFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventDraftFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventDraftFragment newInstance() {
            EventDraftFragment eventDraftFragment = new EventDraftFragment();
            eventDraftFragment.setArguments(new Bundle());
            return eventDraftFragment;
        }
    }

    /* JADX INFO: compiled from: EventDraftFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventDraftFragment$DraftTablesAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "<init>", "(Lcom/studiolaganne/lengendarylens/EventDraftFragment;)V", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class DraftTablesAdapter extends FragmentStateAdapter {
        public DraftTablesAdapter() {
            super(EventDraftFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            Tournament tournament = EventDraftFragment.this.currentTournament;
            if (tournament == null) {
                return new Fragment();
            }
            return DraftTableFragment.INSTANCE.newInstance(tournament.getTables().get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            Tournament tournament = EventDraftFragment.this.currentTournament;
            if (tournament != null) {
                return tournament.getTables().size();
            }
            return 0;
        }
    }

    @JvmStatic
    public static final EventDraftFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onTimerExpired$lambda$0(EventDraftFragment eventDraftFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (eventDraftFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Intent intent = new Intent(eventDraftFragment.requireContext(), (Class<?>) TimerService.class);
        intent.setAction(TimerService.ACTION_STOP_ALARM);
        FragmentActivity activity = eventDraftFragment.getActivity();
        if (activity != null) {
            activity.startService(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(EventDraftFragment eventDraftFragment) {
        eventDraftFragment.getBinding().viewPager.setCurrentItem(r1.getCurrentItem() - 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$1(EventDraftFragment eventDraftFragment) {
        ViewPager2 viewPager2 = eventDraftFragment.getBinding().viewPager;
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$2(EventDraftFragment eventDraftFragment) {
        PreferencesManager preferencesManager;
        Tournament currentTournament;
        eventDraftFragment.pauseCountdown();
        eventDraftFragment.pauseAutoStartCountdown();
        Context context = eventDraftFragment.getContext();
        if (context != null && (currentTournament = (preferencesManager = new PreferencesManager(context)).getCurrentTournament()) != null) {
            currentTournament.setCurrentTimerActive(false);
            currentTournament.setCurrentTimeLeft(0L);
            preferencesManager.saveCurrentTournament(currentTournament);
        }
        eventDraftFragment.getCallback().moveToDeckBuilding();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3(EventDraftFragment eventDraftFragment) {
        if (eventDraftFragment.getTimeLeft() == 0) {
            return Unit.INSTANCE;
        }
        if (eventDraftFragment.getIsTimerRunning()) {
            eventDraftFragment.pauseCountdown();
        } else {
            eventDraftFragment.startCountdown();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHeader() {
        int currentItem = getBinding().viewPager.getCurrentItem();
        TextView textView = getBinding().tableHeaderTextView;
        String string = getResources().getString(R.string.table_index);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(StringsKt.replace$default(string, "{0}", String.valueOf(currentItem + 1), false, 4, (Object) null), "{1}", String.valueOf(this.numTables), false, 4, (Object) null));
        if (currentItem == 0) {
            getBinding().prevImage.setVisibility(4);
        } else {
            getBinding().prevImage.setVisibility(0);
        }
        if (currentItem == this.numTables - 1) {
            getBinding().nextImage.setVisibility(4);
        } else {
            getBinding().nextImage.setVisibility(0);
        }
    }

    public final FragmentEventDraftBinding getBinding() {
        FragmentEventDraftBinding fragmentEventDraftBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventDraftBinding);
        return fragmentEventDraftBinding;
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
        this._binding = FragmentEventDraftBinding.inflate(inflater, container, false);
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
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EventDraftFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventDraftFragment.onTimerExpired$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
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
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        boolean z = false;
        this.isViewDestroyed = false;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        if (currentTournament != null) {
            this.currentTournament = currentTournament;
            this.numTables = currentTournament.getTables().size();
            this.adapter = new DraftTablesAdapter();
            ViewPager2 viewPager2 = getBinding().viewPager;
            FragmentStateAdapter fragmentStateAdapter = this.adapter;
            if (fragmentStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                fragmentStateAdapter = null;
            }
            viewPager2.setAdapter(fragmentStateAdapter);
            WormDotsIndicator wormDotsIndicator = getBinding().wormDotsIndicator;
            ViewPager2 viewPager = getBinding().viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
            wormDotsIndicator.attachTo(viewPager);
            boolean z2 = true;
            if (this.numTables <= 1) {
                getBinding().wormDotsIndicator.setVisibility(8);
            }
            setInitialTimeLeft(((long) preferencesManager.getIntFromString(PreferencesManager.DEFAULT_DRAFT_DURATION, 25)) * DurationKt.MILLIS_IN_MINUTE);
            setTimeLeft(getInitialTimeLeft());
            if (currentTournament.getCurrentTimerActive()) {
                setTimeLeft(currentTournament.getCurrentTimeLeft());
                if (getTimeLeft() == 0) {
                    getBinding().autoStartLabel.setVisibility(8);
                } else {
                    z2 = false;
                    z = true;
                }
                updateCountdownText(getTimeLeft());
            } else {
                updateCountdownText(getInitialTimeLeft());
                z2 = false;
            }
            getBinding().viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.studiolaganne.lengendarylens.EventDraftFragment$onViewCreated$1$1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int position) {
                    this.this$0.updateHeader();
                }
            });
            updateHeader();
            ImageView prevImage = getBinding().prevImage;
            Intrinsics.checkNotNullExpressionValue(prevImage, "prevImage");
            ViewExtensionsKt.setOnClickWithFade(prevImage, new Function0() { // from class: com.studiolaganne.lengendarylens.EventDraftFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventDraftFragment.onViewCreated$lambda$0$0(this.f$0);
                }
            });
            ImageView nextImage = getBinding().nextImage;
            Intrinsics.checkNotNullExpressionValue(nextImage, "nextImage");
            ViewExtensionsKt.setOnClickWithFade(nextImage, new Function0() { // from class: com.studiolaganne.lengendarylens.EventDraftFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventDraftFragment.onViewCreated$lambda$0$1(this.f$0);
                }
            });
            MaterialButton nextButton = getBinding().nextButton;
            Intrinsics.checkNotNullExpressionValue(nextButton, "nextButton");
            ViewExtensionsKt.setOnClickWithFade(nextButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventDraftFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventDraftFragment.onViewCreated$lambda$0$2(this.f$0);
                }
            });
            ImageView playButton = getBinding().playButton;
            Intrinsics.checkNotNullExpressionValue(playButton, "playButton");
            ViewExtensionsKt.setOnClickWithFade(playButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventDraftFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EventDraftFragment.onViewCreated$lambda$0$3(this.f$0);
                }
            });
            if (z) {
                startCountdown();
                return;
            }
            if (z2) {
                return;
            }
            TextView textView = getBinding().autoStartLabel;
            String string = getString(R.string.auto_start);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{0}", "5:00", false, 4, (Object) null));
            startAutoStartCountdown(getAutoStartTimeLeft());
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
