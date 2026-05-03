package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.databinding.FragmentGameLayoutBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GameLayoutFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameLayoutFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "playgroupId", "", "formatId", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGameLayoutBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGameLayoutBinding;", "callback", "Lcom/studiolaganne/lengendarylens/GameLayoutFragment$LayoutSetupCallback;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "LayoutSetupCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameLayoutFragment extends Fragment {
    private FragmentGameLayoutBinding _binding;
    private LayoutSetupCallback callback;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int playgroupId = -1;
    private int formatId = -1;

    /* JADX INFO: compiled from: GameLayoutFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameLayoutFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameLayoutFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameLayoutFragment newInstance() {
            return new GameLayoutFragment();
        }
    }

    /* JADX INFO: compiled from: GameLayoutFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameLayoutFragment$LayoutSetupCallback;", "", "layoutSelected", "", "value", "Lcom/studiolaganne/lengendarylens/LayoutType;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface LayoutSetupCallback {
        void layoutSelected(LayoutType value);
    }

    public GameLayoutFragment() {
        final GameLayoutFragment gameLayoutFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gameLayoutFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gameLayoutFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gameLayoutFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gameLayoutFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final GameLayoutFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$1$0(GameLayoutFragment gameLayoutFragment, Integer num) {
        gameLayoutFragment.getBinding().usersCount.setText(String.valueOf(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$1$5(MTPlaygroup mTPlaygroup, GameLayoutFragment gameLayoutFragment, List list) {
        Object next;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                Iterator<T> it2 = mTPlaygroup.getUsers().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (((MTUser) next).getId() == iIntValue) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                MTUser mTUser = (MTUser) next;
                if (mTUser != null) {
                    arrayList.add(mTUser);
                }
            }
            gameLayoutFragment.getBinding().usersRecyclerView.setAdapter(new SmallUsersAdapter(arrayList, false, 0));
            gameLayoutFragment.getBinding().usersRecyclerView.setLayoutManager(new LinearLayoutManager(gameLayoutFragment.requireContext(), 0, false));
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = gameLayoutFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(12, contextRequireContext));
            int itemDecorationCount = gameLayoutFragment.getBinding().usersRecyclerView.getItemDecorationCount();
            for (int i = 0; i < itemDecorationCount; i++) {
                gameLayoutFragment.getBinding().usersRecyclerView.removeItemDecorationAt(0);
            }
            gameLayoutFragment.getBinding().usersRecyclerView.addItemDecoration(overlapDecoration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(View view, final GameLayoutFragment gameLayoutFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GameLayoutFragment.onCreateView$lambda$1$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0$0(GameLayoutFragment gameLayoutFragment) {
        LayoutSetupCallback layoutSetupCallback = gameLayoutFragment.callback;
        if (layoutSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            layoutSetupCallback = null;
        }
        layoutSetupCallback.layoutSelected(LayoutType.TYPE_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0(View view, final GameLayoutFragment gameLayoutFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                GameLayoutFragment.onCreateView$lambda$2$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0$0(GameLayoutFragment gameLayoutFragment) {
        LayoutSetupCallback layoutSetupCallback = gameLayoutFragment.callback;
        if (layoutSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            layoutSetupCallback = null;
        }
        layoutSetupCallback.layoutSelected(LayoutType.TYPE_2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$0(View view, final GameLayoutFragment gameLayoutFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GameLayoutFragment.onCreateView$lambda$3$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$0$0(GameLayoutFragment gameLayoutFragment) {
        LayoutSetupCallback layoutSetupCallback = gameLayoutFragment.callback;
        if (layoutSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            layoutSetupCallback = null;
        }
        layoutSetupCallback.layoutSelected(LayoutType.TYPE_3);
    }

    static final void onCreateView$lambda$4(GameLayoutFragment gameLayoutFragment, Integer num) {
        Object next;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        gameLayoutFragment.formatId = iIntValue;
        if (iIntValue == -1) {
            gameLayoutFragment.getBinding().formatName.setVisibility(8);
            return;
        }
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = gameLayoutFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Iterator<T> it = companion.getInstance(contextRequireContext).getFormats().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((MTFormat) next).getId() == gameLayoutFragment.formatId) {
                    break;
                }
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        if (mTFormat == null) {
            gameLayoutFragment.getBinding().formatName.setVisibility(8);
        } else {
            gameLayoutFragment.getBinding().formatName.setText(mTFormat.getName());
            gameLayoutFragment.getBinding().formatName.setVisibility(0);
        }
    }

    static final void onCreateView$lambda$5(GameLayoutFragment gameLayoutFragment, Integer num) {
        gameLayoutFragment.getBinding().imageView3.setVisibility(8);
        gameLayoutFragment.getBinding().cameraMode.setVisibility(8);
        if (num != null && num.intValue() == 1) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_1_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_1_type2));
            return;
        }
        if (num != null && num.intValue() == 2) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_2_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_2_type2));
            gameLayoutFragment.getBinding().imageView3.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_2_type3));
            gameLayoutFragment.getBinding().imageView3.setVisibility(0);
            gameLayoutFragment.getBinding().cameraMode.setVisibility(0);
            return;
        }
        if (num != null && num.intValue() == 3) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_3_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_3_type2));
            return;
        }
        if (num != null && num.intValue() == 4) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_4_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_4_type2));
            return;
        }
        if (num != null && num.intValue() == 5) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_5_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_5_type2));
            return;
        }
        if (num != null && num.intValue() == 6) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_6_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_6_type2));
        } else if (num != null && num.intValue() == 7) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_7_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_7_type2));
        } else if (num != null && num.intValue() == 8) {
            gameLayoutFragment.getBinding().imageView1.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_8_type1));
            gameLayoutFragment.getBinding().imageView2.setImageDrawable(ContextCompat.getDrawable(gameLayoutFragment.requireContext(), R.drawable.layout_8_type2));
        }
    }

    public final FragmentGameLayoutBinding getBinding() {
        FragmentGameLayoutBinding fragmentGameLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGameLayoutBinding);
        return fragmentGameLayoutBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GameLayoutFragment.LayoutSetupCallback");
            this.callback = (LayoutSetupCallback) parentFragment;
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
        Object next2;
        Object next3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGameLayoutBinding.inflate(inflater, container, false);
        Integer value = getSharedViewModel().getPlaygroupId().getValue();
        this.playgroupId = value != null ? value.intValue() : -1;
        Integer value2 = getSharedViewModel().getFormatId().getValue();
        this.formatId = value2 != null ? value2.intValue() : -1;
        if (this.playgroupId == -1) {
            getBinding().playgroupGameLayout.setVisibility(8);
        } else {
            getBinding().playgroupGameLayout.setVisibility(0);
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
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
                    if (((MTPlaygroup) next).getId() == this.playgroupId) {
                        break;
                    }
                }
                final MTPlaygroup mTPlaygroup = (MTPlaygroup) next;
                if (mTPlaygroup != null) {
                    getBinding().playgroupName.setText(mTPlaygroup.getName());
                    getBinding().usersCount.setText(String.valueOf(getSharedViewModel().getNumberOfPlayers().getValue()));
                    getSharedViewModel().getNumberOfPlayers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda7
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            GameLayoutFragment.onCreateView$lambda$0$1$0(this.f$0, (Integer) obj);
                        }
                    });
                    if (this.formatId != -1) {
                        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                        Context contextRequireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        Iterator<T> it2 = companion.getInstance(contextRequireContext2).getFormats().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next3 = null;
                                break;
                            }
                            next3 = it2.next();
                            if (((MTFormat) next3).getId() == this.formatId) {
                                break;
                            }
                        }
                        MTFormat mTFormat = (MTFormat) next3;
                        if (mTFormat != null) {
                            getBinding().formatName.setText(mTFormat.getName());
                            getBinding().formatName.setVisibility(0);
                        } else {
                            getBinding().formatName.setVisibility(8);
                        }
                    } else {
                        getBinding().formatName.setVisibility(8);
                    }
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
                    List<Integer> value3 = getSharedViewModel().getPlaygroupUsers().getValue();
                    if (value3 != null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Integer> it3 = value3.iterator();
                        while (it3.hasNext()) {
                            int iIntValue = it3.next().intValue();
                            Iterator<T> it4 = mTPlaygroup.getUsers().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it4.next();
                                if (((MTUser) next2).getId() == iIntValue) {
                                    break;
                                }
                            }
                            MTUser mTUser = (MTUser) next2;
                            if (mTUser != null) {
                                arrayList.add(mTUser);
                            }
                        }
                        getBinding().usersRecyclerView.setAdapter(new SmallUsersAdapter(arrayList, false, 0));
                        getBinding().usersRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
                        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                        Context contextRequireContext3 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                        OverlapDecoration overlapDecoration = new OverlapDecoration(companion2.dpToPx(12, contextRequireContext3));
                        int itemDecorationCount = getBinding().usersRecyclerView.getItemDecorationCount();
                        for (int i = 0; i < itemDecorationCount; i++) {
                            getBinding().usersRecyclerView.removeItemDecorationAt(0);
                        }
                        getBinding().usersRecyclerView.addItemDecoration(overlapDecoration);
                    }
                    getSharedViewModel().getPlaygroupUsers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda8
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            GameLayoutFragment.onCreateView$lambda$0$1$5(mTPlaygroup, this, (List) obj);
                        }
                    });
                }
            }
        }
        getBinding().imageView1.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameLayoutFragment.onCreateView$lambda$1$0(view, gameLayoutFragment);
                    }
                });
            }
        });
        getBinding().imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameLayoutFragment.onCreateView$lambda$2$0(view, gameLayoutFragment);
                    }
                });
            }
        });
        getBinding().imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameLayoutFragment.onCreateView$lambda$3$0(view, gameLayoutFragment);
                    }
                });
            }
        });
        getSharedViewModel().getFormatId().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GameLayoutFragment.onCreateView$lambda$4(this.f$0, (Integer) obj);
            }
        });
        getSharedViewModel().getNumberOfPlayers().observe(getViewLifecycleOwner(), new Observer() { // from class: com.studiolaganne.lengendarylens.GameLayoutFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GameLayoutFragment.onCreateView$lambda$5(this.f$0, (Integer) obj);
            }
        });
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
