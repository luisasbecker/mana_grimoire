package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventPlayerListBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventPlayerListFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPlayerListFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/studiolaganne/lengendarylens/PlayerListClickListener;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/EventContentCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/EventContentCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/EventContentCallback;)V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventPlayerListBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventPlayerListBinding;", "playerEditClicked", "", "player", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "playerDropClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventPlayerListFragment extends BottomSheetDialogFragment implements PlayerListClickListener {
    private FragmentEventPlayerListBinding _binding;
    public EventContentCallback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventPlayerListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventPlayerListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventPlayerListFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventPlayerListFragment newInstance() {
            EventPlayerListFragment eventPlayerListFragment = new EventPlayerListFragment();
            eventPlayerListFragment.setArguments(new Bundle());
            return eventPlayerListFragment;
        }
    }

    @JvmStatic
    public static final EventPlayerListFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit playerDropClicked$lambda$0(EventPlayerListFragment eventPlayerListFragment, PreferencesManager preferencesManager, TournamentPlayer tournamentPlayer, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (eventPlayerListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        if (currentTournament != null) {
            currentTournament.getPlayers().get(currentTournament.getPlayers().indexOf(tournamentPlayer)).setDroppedAfterRound(currentTournament.getCurrentRound());
            preferencesManager.saveCurrentTournament(currentTournament);
            eventPlayerListFragment.getBinding().playersRecyclerView.setAdapter(new PlayerListAdapter(currentTournament.getPlayers(), eventPlayerListFragment));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit playerDropClicked$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    public final FragmentEventPlayerListBinding getBinding() {
        FragmentEventPlayerListBinding fragmentEventPlayerListBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventPlayerListBinding);
        return fragmentEventPlayerListBinding;
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
        this._binding = FragmentEventPlayerListBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Tournament currentTournament = new PreferencesManager(contextRequireContext).getCurrentTournament();
        if (currentTournament != null) {
            getBinding().playersRecyclerView.setAdapter(new PlayerListAdapter(currentTournament.getPlayers(), this));
            getBinding().playersRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        }
    }

    @Override // com.studiolaganne.lengendarylens.PlayerListClickListener
    public void playerDropClicked(final TournamentPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.confirm_drop_player);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = title.setBody(StringsKt.replace$default(string2, "{1}", player.getName(), false, 4, (Object) null)).setPositiveButtonRed().setPositiveButton(getString(R.string.drop_player) + " '" + player.getName() + "'", new Function2() { // from class: com.studiolaganne.lengendarylens.EventPlayerListFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventPlayerListFragment.playerDropClicked$lambda$0(this.f$0, preferencesManager, player, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string3 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string3, new Function1() { // from class: com.studiolaganne.lengendarylens.EventPlayerListFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventPlayerListFragment.playerDropClicked$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "CustomDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.PlayerListClickListener
    public void playerEditClicked(TournamentPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    public final void setCallback(EventContentCallback eventContentCallback) {
        Intrinsics.checkNotNullParameter(eventContentCallback, "<set-?>");
        this.callback = eventContentCallback;
    }
}
