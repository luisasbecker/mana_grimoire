package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.databinding.FragmentGamePlaygroupUsersBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: GamePlaygroupUsersFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000212B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\fH\u0016J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlaygroupUsersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/GameUserClickListener;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "deckRequestStarted", "", "decksByUserResponse", "", "", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGamePlaygroupUsersBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGamePlaygroupUsersBinding;", "callback", "Lcom/studiolaganne/lengendarylens/GamePlaygroupUsersFragment$PlaygroupUsersSetupCallback;", "users", "Lcom/studiolaganne/lengendarylens/MTUser;", "checkAll", "onUserSelectionChanged", "", "user", "selected", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onHiddenChanged", "hidden", "updateDecks", "updateButtonState", "PlaygroupUsersSetupCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GamePlaygroupUsersFragment extends Fragment implements GameUserClickListener {
    private FragmentGamePlaygroupUsersBinding _binding;
    private PlaygroupUsersSetupCallback callback;
    private boolean checkAll = true;
    private boolean deckRequestStarted;
    private Map<String, ? extends List<MTDeck>> decksByUserResponse;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;
    private List<MTUser> users;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GamePlaygroupUsersFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlaygroupUsersFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GamePlaygroupUsersFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GamePlaygroupUsersFragment newInstance() {
            return new GamePlaygroupUsersFragment();
        }
    }

    /* JADX INFO: compiled from: GamePlaygroupUsersFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlaygroupUsersFragment$PlaygroupUsersSetupCallback;", "", "playersSelectedFromPlaygroup", "", "userIds", "", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface PlaygroupUsersSetupCallback {
        void playersSelectedFromPlaygroup(List<Integer> userIds);
    }

    public GamePlaygroupUsersFragment() {
        final GamePlaygroupUsersFragment gamePlaygroupUsersFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gamePlaygroupUsersFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gamePlaygroupUsersFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gamePlaygroupUsersFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gamePlaygroupUsersFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final GamePlaygroupUsersFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onCreateView$lambda$0(GamePlaygroupUsersFragment gamePlaygroupUsersFragment, Integer num) {
        gamePlaygroupUsersFragment.deckRequestStarted = false;
        gamePlaygroupUsersFragment.decksByUserResponse = null;
        gamePlaygroupUsersFragment.getSharedViewModel().getDecks().setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$1$0$0(GamePlaygroupUsersFragment gamePlaygroupUsersFragment, List list) {
        if (gamePlaygroupUsersFragment.checkAll) {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                MTUser mTUser = (MTUser) it.next();
                if (i >= 8 || Intrinsics.areEqual(mTUser.getStatus(), "pending")) {
                    mTUser.setFcm(false);
                } else {
                    mTUser.setFcm(true);
                    i++;
                }
            }
            gamePlaygroupUsersFragment.updateButtonState();
            RecyclerView.Adapter adapter = gamePlaygroupUsersFragment.getBinding().playersRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            gamePlaygroupUsersFragment.checkAll = false;
            gamePlaygroupUsersFragment.getBinding().uncheckLabel.setText(gamePlaygroupUsersFragment.getResources().getString(R.string.uncheck_all));
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((MTUser) it2.next()).setFcm(false);
            }
            gamePlaygroupUsersFragment.updateButtonState();
            RecyclerView.Adapter adapter2 = gamePlaygroupUsersFragment.getBinding().playersRecyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
            }
            gamePlaygroupUsersFragment.checkAll = true;
            gamePlaygroupUsersFragment.getBinding().uncheckLabel.setText(gamePlaygroupUsersFragment.getResources().getString(R.string.check_all));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$1$0$2(List list, GamePlaygroupUsersFragment gamePlaygroupUsersFragment, PreferencesManager preferencesManager) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MTUser) obj).getFcm()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(Integer.valueOf(((MTUser) it.next()).getId()));
        }
        ArrayList arrayList5 = arrayList4;
        gamePlaygroupUsersFragment.getSharedViewModel().getNumberOfPlayers().setValue(Integer.valueOf(arrayList2.size()));
        gamePlaygroupUsersFragment.getSharedViewModel().getPlaygroupUsers().setValue(arrayList5);
        List<MTUser> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserCache());
        mutableList.clear();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            mutableList.add((MTUser) it2.next());
        }
        preferencesManager.saveCurrentUserCache(mutableList);
        PlaygroupUsersSetupCallback playgroupUsersSetupCallback = gamePlaygroupUsersFragment.callback;
        if (playgroupUsersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playgroupUsersSetupCallback = null;
        }
        playgroupUsersSetupCallback.playersSelectedFromPlaygroup(arrayList5);
        return Unit.INSTANCE;
    }

    private final void updateButtonState() {
        ArrayList arrayList;
        List<MTUser> list = this.users;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((MTUser) obj).getFcm()) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        int size = arrayList != null ? arrayList.size() : 0;
        if (size >= 2) {
            getBinding().nextButtonLayout.setEnabled(true);
            getBinding().nextButtonLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background));
            getBinding().nextButtonLayout.setAlpha(1.0f);
        } else {
            getBinding().nextButtonLayout.setEnabled(false);
            getBinding().nextButtonLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background_grey));
            getBinding().nextButtonLayout.setAlpha(0.5f);
        }
        if (size == 0) {
            getBinding().playersLabel.setVisibility(4);
            return;
        }
        if (size == 1) {
            getBinding().playersLabel.setVisibility(0);
            getBinding().playersLabel.setText(getResources().getString(R.string.one_player));
            return;
        }
        getBinding().playersLabel.setVisibility(0);
        TextView textView = getBinding().playersLabel;
        String string = getResources().getString(R.string.num_players);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(string, "{0}", String.valueOf(size), false, 4, (Object) null));
    }

    private final void updateDecks() {
        MTUser currentUser;
        Integer value = getSharedViewModel().getPlaygroupId().getValue();
        if (value != null) {
            int iIntValue = value.intValue();
            if (this.deckRequestStarted || iIntValue == -1) {
                return;
            }
            this.deckRequestStarted = true;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (!preferencesManager.hasValidUser() || (currentUser = preferencesManager.getCurrentUser()) == null) {
                return;
            }
            MTApiKt.getMtApi().getPlaygroupById(currentUser.getId(), iIntValue).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$updateDecks$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) throws IOException {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    if (responseBodyErrorBody != null) {
                        responseBodyErrorBody.string();
                    }
                    if (!response.isSuccessful() || this.this$0.getContext() == null) {
                        return;
                    }
                    MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                    this.this$0.getSharedViewModel().getPlaygroup().setValue(mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null);
                }
            });
            MTApiKt.getMtApi().getPlaygroupDecks(currentUser.getId(), iIntValue).enqueue(new GamePlaygroupUsersFragment$updateDecks$1$2(this, preferencesManager));
        }
    }

    public final FragmentGamePlaygroupUsersBinding getBinding() {
        FragmentGamePlaygroupUsersBinding fragmentGamePlaygroupUsersBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGamePlaygroupUsersBinding);
        return fragmentGamePlaygroupUsersBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment.PlaygroupUsersSetupCallback");
            this.callback = (PlaygroupUsersSetupCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object next;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGamePlaygroupUsersBinding.inflate(inflater, container, false);
        getSharedViewModel().getPlaygroupId().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GamePlaygroupUsersFragment.onCreateView$lambda$0(this.f$0, (Integer) obj);
            }
        });
        Integer value = getSharedViewModel().getPlaygroupId().getValue();
        if (value != null && value.intValue() == -1) {
            getBinding().playgroupGameLayout.setVisibility(8);
        } else {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (!preferencesManager.hasValidUser()) {
                getBinding().playgroupGameLayout.setVisibility(8);
            } else if (preferencesManager.getCurrentUser() != null) {
                Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    int id = ((MTPlaygroup) next).getId();
                    if (value != null && id == value.intValue()) {
                        break;
                    }
                }
                MTPlaygroup mTPlaygroup = (MTPlaygroup) next;
                if (mTPlaygroup != null) {
                    final List<MTUser> users = mTPlaygroup.getUsers();
                    this.users = users;
                    if (users != null) {
                        updateButtonState();
                        getBinding().playgroupName.setText(mTPlaygroup.getName());
                        getBinding().usersCount.setText(String.valueOf(mTPlaygroup.getUsers().size()));
                        getBinding().formatName.setVisibility(8);
                        getBinding().profileImage.setOutlineProvider(new CircularOutlineProvider());
                        getBinding().profileImage.setClipToOutline(true);
                        String picture = mTPlaygroup.getPicture();
                        String str = picture;
                        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                            getBinding().defaultProfileImage.setVisibility(0);
                            getBinding().profileImage.setVisibility(8);
                        } else {
                            getBinding().defaultProfileImage.setVisibility(8);
                            getBinding().profileImage.setVisibility(0);
                            getBinding().profileImage.setAutoLoad(false);
                            getBinding().profileImage.reset();
                            getBinding().profileImage.loadImage(picture);
                        }
                        TextView uncheckLabel = getBinding().uncheckLabel;
                        Intrinsics.checkNotNullExpressionValue(uncheckLabel, "uncheckLabel");
                        ViewExtensionsKt.setOnClickWithFade(uncheckLabel, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GamePlaygroupUsersFragment.onCreateView$lambda$1$1$0$0(this.f$0, users);
                            }
                        });
                        MTUser currentUser = preferencesManager.getCurrentUser();
                        if (currentUser != null) {
                            getBinding().playersRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                            getBinding().playersRecyclerView.setAdapter(new GameUsersAdapter(users, currentUser, this));
                        }
                        ConstraintLayout nextButtonLayout = getBinding().nextButtonLayout;
                        Intrinsics.checkNotNullExpressionValue(nextButtonLayout, "nextButtonLayout");
                        ViewExtensionsKt.setOnClickWithFade(nextButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GamePlaygroupUsersFragment$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GamePlaygroupUsersFragment.onCreateView$lambda$1$1$0$2(users, this, preferencesManager);
                            }
                        });
                    }
                }
            }
            updateDecks();
        }
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        if (getContext() == null) {
            return;
        }
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        updateDecks();
    }

    @Override // com.studiolaganne.lengendarylens.GameUserClickListener
    public void onUserSelectionChanged(MTUser user, boolean selected) {
        int iIndexOf;
        Intrinsics.checkNotNullParameter(user, "user");
        List<MTUser> list = this.users;
        if (list != null && (iIndexOf = list.indexOf(user)) != -1) {
            list.get(iIndexOf).setFcm(selected);
        }
        updateButtonState();
    }
}
