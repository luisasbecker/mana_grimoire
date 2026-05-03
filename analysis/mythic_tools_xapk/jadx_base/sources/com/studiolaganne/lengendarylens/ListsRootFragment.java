package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.EditContainerDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentListsRootBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListsRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u0002062\b\u0010!\u001a\u0004\u0018\u0001072\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020;H\u0002J\u001a\u0010<\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010=\u001a\u00020 H\u0016J\b\u0010>\u001a\u00020 H\u0002J\b\u0010?\u001a\u00020 H\u0002J\b\u0010@\u001a\u00020 H\u0002J\u0006\u0010A\u001a\u00020 J\u0006\u0010B\u001a\u00020 J\u000e\u0010C\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010D\u001a\u00020 R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListsRootFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentListsRootBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentListsRootBinding;", "layoutType", "", "getLayoutType", "()Ljava/lang/String;", "setLayoutType", "(Ljava/lang/String;)V", "lists", "Lcom/studiolaganne/lengendarylens/MTUserLists;", "getLists", "()Lcom/studiolaganne/lengendarylens/MTUserLists;", "setLists", "(Lcom/studiolaganne/lengendarylens/MTUserLists;)V", "scrollStoppedRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "cardActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "emptyGlobalList", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "deleteUserList", "editContainer", "onCardContainerClick", "onCardContainerDotsClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onCardContainerDetailsClick", "onCardContainerEditClick", "onCardContainerDeleteClick", "onCardContainerSingleCardClick", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "lastKnownListsVersion", "onResume", "updateListsFromCache", "", "onViewCreated", "onDestroyView", "setupScrollListener", "hideAddButton", "showAddButton", "refreshFromRemote", "refreshUILocal", "updateUI", "refreshLayoutType", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListsRootFragment extends Fragment implements CardContainerClickListener, CardContainerDetailsClickListener {
    private FragmentListsRootBinding _binding;
    private final ActivityResultLauncher<Intent> cardActivityLauncher;
    private int lastKnownListsVersion;
    private MTUserLists lists;
    private Runnable scrollStoppedRunnable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String layoutType = "grid";
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: ListsRootFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/ListsRootFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/ListsRootFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ListsRootFragment newInstance() {
            ListsRootFragment listsRootFragment = new ListsRootFragment();
            listsRootFragment.setArguments(new Bundle());
            return listsRootFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ListsRootFragment$setupScrollListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListsRootFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/studiolaganne/lengendarylens/ListsRootFragment$setupScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                final ListsRootFragment listsRootFragment = ListsRootFragment.this;
                listsRootFragment.scrollStoppedRunnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$setupScrollListener$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        listsRootFragment.showAddButton();
                    }
                };
                Handler handler = ListsRootFragment.this.handler;
                Runnable runnable = ListsRootFragment.this.scrollStoppedRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 2000L);
                return;
            }
            if (newState != 1) {
                return;
            }
            ListsRootFragment.this.hideAddButton();
            Runnable runnable2 = ListsRootFragment.this.scrollStoppedRunnable;
            if (runnable2 != null) {
                ListsRootFragment.this.handler.removeCallbacks(runnable2);
            }
        }
    }

    public ListsRootFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ListsRootFragment.cardActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cardActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    static final void cardActivityLauncher$lambda$0(final ListsRootFragment listsRootFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Context context = listsRootFragment.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            if (preferencesManager.getBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, false)) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, true);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rating_prompt_card_from_lists", null);
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda9
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ListsRootFragment.cardActivityLauncher$lambda$0$0$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cardActivityLauncher$lambda$0$0$0(ListsRootFragment listsRootFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = listsRootFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    static final Unit deleteUserList$lambda$0(ListsRootFragment listsRootFragment, MTCardContainer mTCardContainer, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (listsRootFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = listsRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = listsRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            MTApi.deleteUserList$default(MTApiKt.getMtApi(), currentUser.getId(), mTCardContainer.getId(), null, 4, null).enqueue(new ListsRootFragment$deleteUserList$dialog$1$1$1(listsRootFragment, overlay, mTCardContainer));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit deleteUserList$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit editContainer$lambda$0(ListsRootFragment listsRootFragment, MTCardContainer mTCardContainer, MTEditListBody editBody, boolean z) {
        Intrinsics.checkNotNullParameter(editBody, "editBody");
        if (listsRootFragment.getContext() == null || listsRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = listsRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = listsRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            (editBody.getIncludeNullColor() ? MTApiKt.getMtApi().updateList(currentUser.getId(), mTCardContainer.getId(), MTApiKt.toRequestBody(editBody)) : MTApiKt.getMtApi().updateList(currentUser.getId(), mTCardContainer.getId(), editBody)).enqueue(new ListsRootFragment$editContainer$dialog$1$1$1(overlay, listsRootFragment, z, mTCardContainer));
        }
        return Unit.INSTANCE;
    }

    static final Unit emptyGlobalList$lambda$0(ListsRootFragment listsRootFragment, MTCardContainer mTCardContainer, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (listsRootFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = listsRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null && listsRootFragment.getContext() != null) {
            ConstraintLayout overlay = listsRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            MTApiKt.getMtApi().emptyGlobalList(currentUser.getId(), mTCardContainer.getId()).enqueue(new ListsRootFragment$emptyGlobalList$1$1$1(listsRootFragment, overlay, mTCardContainer));
        }
        return Unit.INSTANCE;
    }

    static final Unit emptyGlobalList$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentListsRootBinding getBinding() {
        FragmentListsRootBinding fragmentListsRootBinding = this._binding;
        Intrinsics.checkNotNull(fragmentListsRootBinding);
        return fragmentListsRootBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().addButtonLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ListsRootFragment.hideAddButton$lambda$0(this.f$0);
            }
        }).start();
    }

    static final void hideAddButton$lambda$0(ListsRootFragment listsRootFragment) {
        listsRootFragment.getBinding().addButtonLayout.setClickable(false);
        listsRootFragment.getBinding().addButtonLayout.setFocusable(false);
    }

    @JvmStatic
    public static final ListsRootFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCardContainerDotsClick$lambda$0(ListsRootFragment listsRootFragment, MTCardContainer mTCardContainer) {
        listsRootFragment.emptyGlobalList(mTCardContainer);
        return Unit.INSTANCE;
    }

    static final Unit onCardContainerDotsClick$lambda$1(ListsRootFragment listsRootFragment, MTCardContainer mTCardContainer) {
        listsRootFragment.editContainer(mTCardContainer);
        return Unit.INSTANCE;
    }

    static final Unit onCardContainerDotsClick$lambda$2(ListsRootFragment listsRootFragment, MTCardContainer mTCardContainer) {
        listsRootFragment.deleteUserList(mTCardContainer);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(final ListsRootFragment listsRootFragment) {
        new EditContainerDialogFragment.Builder().setIsCollection(false).setOnEditClickedListener(new Function2() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListsRootFragment.onViewCreated$lambda$1$0(this.f$0, (MTEditListBody) obj, ((Boolean) obj2).booleanValue());
            }
        }).build().show(listsRootFragment.getChildFragmentManager(), "edit_container_dialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1$0(ListsRootFragment listsRootFragment, MTEditListBody editBody, boolean z) {
        Intrinsics.checkNotNullParameter(editBody, "editBody");
        if (listsRootFragment.getContext() == null || listsRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(listsRootFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_create_list", null);
        Context contextRequireContext = listsRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = listsRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            MTApiKt.getMtApi().createList(currentUser.getId(), editBody).enqueue(new ListsRootFragment$onViewCreated$2$dialog$1$1$1(overlay, listsRootFragment));
        }
        return Unit.INSTANCE;
    }

    private final void setupScrollListener() {
        getBinding().listsRecyclerView.addOnScrollListener(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().addButtonLayout.setVisibility(0);
        getBinding().addButtonLayout.setClickable(true);
        getBinding().addButtonLayout.setFocusable(true);
        getBinding().addButtonLayout.animate().alpha(1.0f).setDuration(200L).start();
    }

    private final boolean updateListsFromCache() {
        boolean z;
        MTUserLists mTUserLists = this.lists;
        if (mTUserLists == null) {
            return false;
        }
        List<MTCardContainer> global = mTUserLists.getGlobal();
        if (global != null) {
            int size = global.size();
            z = false;
            for (int i = 0; i < size; i++) {
                MTCardContainer mTCardContainer = global.get(i);
                MTCardContainer cachedContainer = CardContainerCache.INSTANCE.getCachedContainer(mTCardContainer.getId());
                if (cachedContainer != null && (!Intrinsics.areEqual(cachedContainer.getCount(), mTCardContainer.getCount()) || !Intrinsics.areEqual(cachedContainer.getValues(), mTCardContainer.getValues()))) {
                    global.set(i, cachedContainer);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        List<MTCardContainer> user = mTUserLists.getUser();
        if (user != null) {
            int size2 = user.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MTCardContainer mTCardContainer2 = user.get(i2);
                MTCardContainer cachedContainer2 = CardContainerCache.INSTANCE.getCachedContainer(mTCardContainer2.getId());
                if (cachedContainer2 != null && (!Intrinsics.areEqual(cachedContainer2.getCount(), mTCardContainer2.getCount()) || !Intrinsics.areEqual(cachedContainer2.getValues(), mTCardContainer2.getValues()))) {
                    user.set(i2, cachedContainer2);
                    z = true;
                }
            }
        }
        if (z) {
            updateUI(mTUserLists);
            return true;
        }
        List<MTCardContainer> global2 = mTUserLists.getGlobal();
        if (global2 == null || global2.isEmpty()) {
            List<MTCardContainer> user2 = mTUserLists.getUser();
            if (user2 == null || user2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void deleteUserList(final MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.full_delete_list_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        title.setBody(string2).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ListsRootFragment.deleteUserList$lambda$0(this.f$0, container, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListsRootFragment.deleteUserList$lambda$1((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getChildFragmentManager(), "CustomDeleteDialogFragment");
    }

    public final void editContainer(final MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        new EditContainerDialogFragment.Builder().setContainer(container).setOnEditClickedListener(new Function2() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListsRootFragment.editContainer$lambda$0(this.f$0, container, (MTEditListBody) obj, ((Boolean) obj2).booleanValue());
            }
        }).build().show(getChildFragmentManager(), "edit_container_dialog");
    }

    public final void emptyGlobalList(final MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getResources().getString(R.string.empty_list_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getResources().getString(R.string.empty_list_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListsRootFragment.emptyGlobalList$lambda$0(this.f$0, container, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListsRootFragment.emptyGlobalList$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "empty_container_dialog");
    }

    public final String getLayoutType() {
        return this.layoutType;
    }

    public final MTUserLists getLists() {
        return this.lists;
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerClickListener
    public void onCardContainerClick(MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GenericFragmentActivityKt.launchBrowseListFragment$default(contextRequireContext, container.getId(), null, null, 12, null);
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerDetailsClickListener
    public void onCardContainerDeleteClick(MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        if (container.getId() == 4 || container.getId() == 1 || container.getId() == 3 || container.getId() == 2) {
            emptyGlobalList(container);
        } else {
            deleteUserList(container);
        }
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerDetailsClickListener
    public void onCardContainerDetailsClick(MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GenericFragmentActivityKt.launchBrowseListFragment$default(contextRequireContext, container.getId(), null, null, 12, null);
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerClickListener
    public void onCardContainerDotsClick(final MTCardContainer container, View view) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        if (getContext() == null) {
            return;
        }
        boolean z = true;
        if (container.getId() != 4 && container.getId() != 1 && container.getId() != 3 && container.getId() != 2) {
            z = false;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        IconPopupMenu iconPopupMenu = new IconPopupMenu(contextRequireContext);
        if (z) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.empty_container_menu, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ListsRootFragment.onCardContainerDotsClick$lambda$0(this.f$0, container);
                }
            }, 30, (Object) null);
        } else {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.edit_container_menu, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ListsRootFragment.onCardContainerDotsClick$lambda$1(this.f$0, container);
                }
            }, 28, (Object) null);
            iconPopupMenu.addDivider();
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.delete_container_menu, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ListsRootFragment.onCardContainerDotsClick$lambda$2(this.f$0, container);
                }
            }, 24, (Object) null);
        }
        iconPopupMenu.show(view);
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerDetailsClickListener
    public void onCardContainerEditClick(MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        editContainer(container);
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerDetailsClickListener
    public void onCardContainerSingleCardClick(MTCardContainer container, MTFullCard card, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser.getId(), container.getId(), null, null, null, null, null, null, null, null, null, null, null, 8188, null).enqueue(new ListsRootFragment$onCardContainerSingleCardClick$1$1(card, this, position, container));
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
        this._binding = FragmentListsRootBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Runnable runnable = this.scrollStoppedRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.scrollStoppedRunnable = null;
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int listsVersion = new PreferencesManager(contextRequireContext).getListsVersion();
        if (listsVersion > this.lastKnownListsVersion) {
            this.lastKnownListsVersion = listsVersion;
            if (updateListsFromCache()) {
                return;
            }
            refreshFromRemote();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.layoutType = new PreferencesManager(contextRequireContext).getString(PreferencesManager.LAST_COLLECTION_LAYOUT_TYPE, "grid");
        RecyclerView listsRecyclerView = getBinding().listsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(listsRecyclerView, "listsRecyclerView");
        listsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        setupScrollListener();
        getBinding().swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda6
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.refreshFromRemote();
            }
        });
        ConstraintLayout addButtonLayout = getBinding().addButtonLayout;
        Intrinsics.checkNotNullExpressionValue(addButtonLayout, "addButtonLayout");
        ViewExtensionsKt.setOnClickWithBounce(addButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ListsRootFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        refreshFromRemote();
    }

    public final void refreshFromRemote() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (!getBinding().swipeRefreshLayout.isRefreshing()) {
            getBinding().overlay.setVisibility(0);
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getLists(currentUser.getId()).enqueue(new ListsRootFragment$refreshFromRemote$1$1(this));
        } else {
            getBinding().swipeRefreshLayout.setRefreshing(false);
            getBinding().overlay.setVisibility(8);
        }
    }

    public final void refreshLayoutType() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.layoutType = new PreferencesManager(contextRequireContext).getString(PreferencesManager.LAST_COLLECTION_LAYOUT_TYPE, "grid");
        MTUserLists mTUserLists = this.lists;
        if (mTUserLists != null) {
            updateUI(mTUserLists);
        }
    }

    public final void refreshUILocal() {
        MTUserLists mTUserLists;
        if (getContext() == null || this._binding == null || (mTUserLists = this.lists) == null) {
            return;
        }
        updateUI(mTUserLists);
    }

    public final void setLayoutType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.layoutType = str;
    }

    public final void setLists(MTUserLists mTUserLists) {
        this.lists = mTUserLists;
    }

    public final void updateUI(MTUserLists lists) {
        Intrinsics.checkNotNullParameter(lists, "lists");
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.lists = lists;
        if (!Intrinsics.areEqual(this.layoutType, "grid")) {
            ArrayList arrayList = new ArrayList();
            List<MTCardContainer> global = lists.getGlobal();
            if (global != null && !global.isEmpty()) {
                Iterator<MTCardContainer> it = global.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CardContainerDetailsItemHolder(1, it.next(), null, 4, null));
                }
            }
            List<MTCardContainer> user = lists.getUser();
            if (user != null && !user.isEmpty()) {
                Iterator<MTCardContainer> it2 = user.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new CardContainerDetailsItemHolder(1, it2.next(), null, 4, null));
                }
            }
            getBinding().listsRecyclerView.setAdapter(new CardContainerDetailsAdapter(arrayList, this));
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<MTCardContainer> global2 = lists.getGlobal();
        if (global2 != null && !global2.isEmpty()) {
            Iterator<MTCardContainer> it3 = global2.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new CardContainerItemHolder(1, it3.next(), null, 4, null));
            }
        }
        List<MTCardContainer> user2 = lists.getUser();
        if (user2 != null && !user2.isEmpty()) {
            Iterator<MTCardContainer> it4 = user2.iterator();
            while (it4.hasNext()) {
                arrayList2.add(new CardContainerItemHolder(1, it4.next(), null, 4, null));
            }
        }
        getBinding().listsRecyclerView.setAdapter(new CardContainerAdapter(arrayList2, this, false, 4, null));
    }
}
