package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
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
import com.studiolaganne.lengendarylens.databinding.FragmentCollectionRootBinding;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CollectionRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u0002062\b\u0010!\u001a\u0004\u0018\u0001072\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020 H\u0002J\u0010\u0010=\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010>\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0002J\b\u0010A\u001a\u00020 H\u0002J\b\u0010B\u001a\u00020 H\u0002J\u0006\u0010C\u001a\u00020 J\u000e\u0010D\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010E\u001a\u00020 J\u000e\u0010F\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionRootFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentCollectionRootBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentCollectionRootBinding;", "layoutType", "", "getLayoutType", "()Ljava/lang/String;", "setLayoutType", "(Ljava/lang/String;)V", "collection", "Lcom/studiolaganne/lengendarylens/MTCollection;", "getCollection", "()Lcom/studiolaganne/lengendarylens/MTCollection;", "setCollection", "(Lcom/studiolaganne/lengendarylens/MTCollection;)V", "scrollStoppedRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "cardActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "emptyGlobalList", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "deleteUserList", "editContainer", "onCardContainerClick", "onCardContainerDotsClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onCardContainerDetailsClick", "onCardContainerEditClick", "onCardContainerDeleteClick", "onCardContainerSingleCardClick", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "lastKnownCollectionVersion", "onResume", "updateContainersFromCache", "", "refreshTotalsInBackground", "updateHeaderTotals", "onViewCreated", "onDestroyView", "setupScrollListener", "hideAddButton", "showAddButton", "refreshFromRemote", "updateUI", "refreshLayoutType", "updateRecyclerView", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionRootFragment extends Fragment implements CardContainerClickListener, CardContainerDetailsClickListener {
    private FragmentCollectionRootBinding _binding;
    private final ActivityResultLauncher<Intent> cardActivityLauncher;
    private MTCollection collection;
    private int lastKnownCollectionVersion;
    private Runnable scrollStoppedRunnable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String layoutType = "grid";
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: CollectionRootFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionRootFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/CollectionRootFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CollectionRootFragment newInstance() {
            CollectionRootFragment collectionRootFragment = new CollectionRootFragment();
            collectionRootFragment.setArguments(new Bundle());
            return collectionRootFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionRootFragment$setupScrollListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionRootFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/studiolaganne/lengendarylens/CollectionRootFragment$setupScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11391 extends RecyclerView.OnScrollListener {
        C11391() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                final CollectionRootFragment collectionRootFragment = CollectionRootFragment.this;
                collectionRootFragment.scrollStoppedRunnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$setupScrollListener$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        collectionRootFragment.showAddButton();
                    }
                };
                Handler handler = CollectionRootFragment.this.handler;
                Runnable runnable = CollectionRootFragment.this.scrollStoppedRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 2000L);
                return;
            }
            if (newState != 1) {
                return;
            }
            CollectionRootFragment.this.hideAddButton();
            Runnable runnable2 = CollectionRootFragment.this.scrollStoppedRunnable;
            if (runnable2 != null) {
                CollectionRootFragment.this.handler.removeCallbacks(runnable2);
            }
        }
    }

    public CollectionRootFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CollectionRootFragment.cardActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cardActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    static final void cardActivityLauncher$lambda$0(final CollectionRootFragment collectionRootFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Context context = collectionRootFragment.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            if (preferencesManager.getBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, false)) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, true);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rating_prompt_card_from_collection", null);
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CollectionRootFragment.cardActivityLauncher$lambda$0$0$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cardActivityLauncher$lambda$0$0$0(CollectionRootFragment collectionRootFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = collectionRootFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    static final Unit deleteUserList$lambda$0(CollectionRootFragment collectionRootFragment, MTCardContainer mTCardContainer, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (collectionRootFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = collectionRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = collectionRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            MTApiKt.getMtApi().deleteUserList(currentUser.getId(), mTCardContainer.getId(), z ? true : null).enqueue(new CollectionRootFragment$deleteUserList$dialog$1$1$1(collectionRootFragment, overlay));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit deleteUserList$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit editContainer$lambda$0(CollectionRootFragment collectionRootFragment, MTCardContainer mTCardContainer, MTEditListBody editBody, boolean z) {
        Intrinsics.checkNotNullParameter(editBody, "editBody");
        if (collectionRootFragment.getContext() == null || collectionRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = collectionRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = collectionRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            (editBody.getIncludeNullColor() ? MTApiKt.getMtApi().updateList(currentUser.getId(), mTCardContainer.getId(), MTApiKt.toRequestBody(editBody)) : MTApiKt.getMtApi().updateList(currentUser.getId(), mTCardContainer.getId(), editBody)).enqueue(new CollectionRootFragment$editContainer$dialog$1$1$1(collectionRootFragment, overlay, z, mTCardContainer));
        }
        return Unit.INSTANCE;
    }

    static final Unit emptyGlobalList$lambda$0(CollectionRootFragment collectionRootFragment, MTCardContainer mTCardContainer, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (collectionRootFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = collectionRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null && collectionRootFragment.getContext() != null) {
            ConstraintLayout overlay = collectionRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            MTApiKt.getMtApi().emptyGlobalList(currentUser.getId(), mTCardContainer.getId()).enqueue(new CollectionRootFragment$emptyGlobalList$1$1$1(collectionRootFragment, mTCardContainer, overlay));
        }
        return Unit.INSTANCE;
    }

    static final Unit emptyGlobalList$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentCollectionRootBinding getBinding() {
        FragmentCollectionRootBinding fragmentCollectionRootBinding = this._binding;
        Intrinsics.checkNotNull(fragmentCollectionRootBinding);
        return fragmentCollectionRootBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().importButtonLayout.animate().cancel();
        getBinding().addButtonLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                CollectionRootFragment.hideAddButton$lambda$0(this.f$0);
            }
        }).start();
        getBinding().importButtonLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                CollectionRootFragment.hideAddButton$lambda$1(this.f$0);
            }
        }).start();
    }

    static final void hideAddButton$lambda$0(CollectionRootFragment collectionRootFragment) {
        collectionRootFragment.getBinding().addButtonLayout.setClickable(false);
        collectionRootFragment.getBinding().addButtonLayout.setFocusable(false);
    }

    static final void hideAddButton$lambda$1(CollectionRootFragment collectionRootFragment) {
        collectionRootFragment.getBinding().importButtonLayout.setClickable(false);
        collectionRootFragment.getBinding().importButtonLayout.setFocusable(false);
    }

    @JvmStatic
    public static final CollectionRootFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCardContainerDotsClick$lambda$0(CollectionRootFragment collectionRootFragment, MTCardContainer mTCardContainer) {
        collectionRootFragment.emptyGlobalList(mTCardContainer);
        return Unit.INSTANCE;
    }

    static final Unit onCardContainerDotsClick$lambda$1(CollectionRootFragment collectionRootFragment, MTCardContainer mTCardContainer) {
        collectionRootFragment.editContainer(mTCardContainer);
        return Unit.INSTANCE;
    }

    static final Unit onCardContainerDotsClick$lambda$2(CollectionRootFragment collectionRootFragment, MTCardContainer mTCardContainer) {
        collectionRootFragment.deleteUserList(mTCardContainer);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(CollectionRootFragment collectionRootFragment) {
        if (collectionRootFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = collectionRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GenericFragmentActivityKt.launchBrowseListFragment$default(contextRequireContext, -1, null, null, 12, null);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(CollectionRootFragment collectionRootFragment) {
        if (collectionRootFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        ActivityResultCaller parentFragment = collectionRootFragment.getParentFragment();
        CollectionRootListener collectionRootListener = parentFragment instanceof CollectionRootListener ? (CollectionRootListener) parentFragment : null;
        if (collectionRootListener != null) {
            collectionRootListener.onImportRequested();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(final CollectionRootFragment collectionRootFragment) {
        new EditContainerDialogFragment.Builder().setIsCollection(true).setOnEditClickedListener(new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionRootFragment.onViewCreated$lambda$3$0(this.f$0, (MTEditListBody) obj, ((Boolean) obj2).booleanValue());
            }
        }).build().show(collectionRootFragment.getChildFragmentManager(), "edit_container_dialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3$0(CollectionRootFragment collectionRootFragment, MTEditListBody editBody, boolean z) {
        Intrinsics.checkNotNullParameter(editBody, "editBody");
        if (collectionRootFragment.getContext() == null || collectionRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(collectionRootFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_create_container", null);
        Context contextRequireContext = collectionRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = collectionRootFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            MTApiKt.getMtApi().createList(currentUser.getId(), editBody).enqueue(new CollectionRootFragment$onViewCreated$4$dialog$1$1$1(collectionRootFragment, overlay));
        }
        return Unit.INSTANCE;
    }

    private final void refreshTotalsInBackground() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        MTApiKt.getMtApi().getCollection(currentUser.getId()).enqueue(new Callback<MTCollectionResponse>() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment.refreshTotalsInBackground.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCollectionResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCollectionResponse> call, Response<MTCollectionResponse> response) {
                MTCollectionResponse mTCollectionResponseBody;
                MTCollection collection;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (CollectionRootFragment.this.getContext() == null || CollectionRootFragment.this._binding == null || !response.isSuccessful() || (mTCollectionResponseBody = response.body()) == null || (collection = mTCollectionResponseBody.getCollection()) == null) {
                    return;
                }
                CollectionRootFragment collectionRootFragment = CollectionRootFragment.this;
                PreferencesManager preferencesManager2 = preferencesManager;
                collectionRootFragment.updateHeaderTotals(collection);
                if (collectionRootFragment.getCollection() != null) {
                    preferencesManager2.saveCurrentUserCollection(collection);
                }
            }
        });
    }

    private final void setupScrollListener() {
        getBinding().collectionRecyclerView.addOnScrollListener(new C11391());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().importButtonLayout.animate().cancel();
        getBinding().addButtonLayout.setVisibility(0);
        getBinding().addButtonLayout.setClickable(true);
        getBinding().addButtonLayout.setFocusable(true);
        getBinding().addButtonLayout.animate().alpha(1.0f).setDuration(200L).start();
        getBinding().importButtonLayout.setVisibility(0);
        getBinding().importButtonLayout.setClickable(true);
        getBinding().importButtonLayout.setFocusable(true);
        getBinding().importButtonLayout.animate().alpha(1.0f).setDuration(200L).start();
    }

    private final boolean updateContainersFromCache() {
        boolean z;
        MTCollection mTCollection = this.collection;
        if (mTCollection == null) {
            return false;
        }
        List<MTCardContainer> boxes = mTCollection.getBoxes();
        if (boxes != null) {
            int size = boxes.size();
            z = false;
            for (int i = 0; i < size; i++) {
                MTCardContainer mTCardContainer = boxes.get(i);
                MTCardContainer cachedContainer = CardContainerCache.INSTANCE.getCachedContainer(mTCardContainer.getId());
                if (cachedContainer != null && (!Intrinsics.areEqual(cachedContainer.getCount(), mTCardContainer.getCount()) || !Intrinsics.areEqual(cachedContainer.getValues(), mTCardContainer.getValues()))) {
                    boxes.set(i, cachedContainer);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        List<MTCardContainer> binders = mTCollection.getBinders();
        if (binders != null) {
            int size2 = binders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MTCardContainer mTCardContainer2 = binders.get(i2);
                MTCardContainer cachedContainer2 = CardContainerCache.INSTANCE.getCachedContainer(mTCardContainer2.getId());
                if (cachedContainer2 != null && (!Intrinsics.areEqual(cachedContainer2.getCount(), mTCardContainer2.getCount()) || !Intrinsics.areEqual(cachedContainer2.getValues(), mTCardContainer2.getValues()))) {
                    binders.set(i2, cachedContainer2);
                    z = true;
                }
            }
        }
        if (z) {
            updateUI(mTCollection);
            refreshTotalsInBackground();
            return true;
        }
        List<MTCardContainer> boxes2 = mTCollection.getBoxes();
        if (boxes2 == null || boxes2.isEmpty()) {
            List<MTCardContainer> binders2 = mTCollection.getBinders();
            if (binders2 == null || binders2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHeaderTotals(MTCollection collection) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        getBinding().cardsValue.setText(String.valueOf(collection.getTotal_cards()));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String preferredCurrency = new PreferencesManager(contextRequireContext).getPreferredCurrency();
        MTCardsValue containerValue = GameUtils.INSTANCE.getInstance().getContainerValue(collection.getValues(), preferredCurrency);
        if (containerValue != null) {
            getBinding().priceValue.setText(GameUtils.INSTANCE.getInstance().formatPrice(containerValue.getTotal_value(), preferredCurrency));
            MTPriceDelta delta = containerValue.getDelta();
            if (delta != null) {
                getBinding().deltaValue.setText(GameUtils.INSTANCE.getInstance().formatDelta(delta, preferredCurrency));
                if (delta.getAmount() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    getBinding().deltaValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_green));
                } else if (delta.getAmount() < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    getBinding().deltaValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.loser_red));
                } else {
                    getBinding().deltaValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                }
            }
        }
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
        title.setBody(string2).setShowRestoreCheckBox(true).setCheckBoxLabel(getString(R.string.keep_cards_in_bulk)).setCheckBoxDefaultChecked(false).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CollectionRootFragment.deleteUserList$lambda$0(this.f$0, container, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionRootFragment.deleteUserList$lambda$1((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getChildFragmentManager(), "CustomDeleteDialogFragment");
    }

    public final void editContainer(final MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        new EditContainerDialogFragment.Builder().setContainer(container).setOnEditClickedListener(new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionRootFragment.editContainer$lambda$0(this.f$0, container, (MTEditListBody) obj, ((Boolean) obj2).booleanValue());
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
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionRootFragment.emptyGlobalList$lambda$0(this.f$0, container, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionRootFragment.emptyGlobalList$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "empty_container_dialog");
    }

    public final MTCollection getCollection() {
        return this.collection;
    }

    public final String getLayoutType() {
        return this.layoutType;
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
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.empty_container_menu, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionRootFragment.onCardContainerDotsClick$lambda$0(this.f$0, container);
                }
            }, 30, (Object) null);
        } else {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.edit_container_menu, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionRootFragment.onCardContainerDotsClick$lambda$1(this.f$0, container);
                }
            }, 28, (Object) null);
            iconPopupMenu.addDivider();
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.delete_container_menu, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionRootFragment.onCardContainerDotsClick$lambda$2(this.f$0, container);
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
            MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser.getId(), container.getId(), null, null, null, null, null, null, null, null, null, null, null, 8188, null).enqueue(new CollectionRootFragment$onCardContainerSingleCardClick$1$1(this, card, position, container));
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
        this._binding = FragmentCollectionRootBinding.inflate(inflater, container, false);
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
        int collectionVersion = new PreferencesManager(contextRequireContext).getCollectionVersion();
        if (collectionVersion > this.lastKnownCollectionVersion) {
            this.lastKnownCollectionVersion = collectionVersion;
            if (updateContainersFromCache()) {
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
        RecyclerView collectionRecyclerView = getBinding().collectionRecyclerView;
        Intrinsics.checkNotNullExpressionValue(collectionRecyclerView, "collectionRecyclerView");
        collectionRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        setupScrollListener();
        getBinding().swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda4
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.refreshFromRemote();
            }
        });
        LinearLayout allCollectionLayout = getBinding().allCollectionLayout;
        Intrinsics.checkNotNullExpressionValue(allCollectionLayout, "allCollectionLayout");
        ViewExtensionsKt.setOnClickWithFade(allCollectionLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRootFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        ConstraintLayout importButtonLayout = getBinding().importButtonLayout;
        Intrinsics.checkNotNullExpressionValue(importButtonLayout, "importButtonLayout");
        ViewExtensionsKt.setOnClickWithBounce(importButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRootFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        ConstraintLayout addButtonLayout = getBinding().addButtonLayout;
        Intrinsics.checkNotNullExpressionValue(addButtonLayout, "addButtonLayout");
        ViewExtensionsKt.setOnClickWithBounce(addButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionRootFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        refreshFromRemote();
    }

    public final void refreshFromRemote() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (!getBinding().swipeRefreshLayout.isRefreshing()) {
            getBinding().overlay.setVisibility(0);
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getCollection(currentUser.getId()).enqueue(new CollectionRootFragment$refreshFromRemote$1$1(this));
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
        MTCollection mTCollection = this.collection;
        if (mTCollection != null) {
            updateRecyclerView(mTCollection);
        }
    }

    public final void setCollection(MTCollection mTCollection) {
        this.collection = mTCollection;
    }

    public final void setLayoutType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.layoutType = str;
    }

    public final void updateRecyclerView(MTCollection collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (!Intrinsics.areEqual(this.layoutType, "grid")) {
            ArrayList arrayList = new ArrayList();
            List<MTCardContainer> boxes = collection.getBoxes();
            if (boxes != null && !boxes.isEmpty()) {
                arrayList.add(new CardContainerDetailsItemHolder(2, null, getString(R.string.boxes), 2, null));
                Iterator<MTCardContainer> it = boxes.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CardContainerDetailsItemHolder(1, it.next(), null, 4, null));
                }
            }
            List<MTCardContainer> binders = collection.getBinders();
            if (binders != null && !binders.isEmpty()) {
                arrayList.add(new CardContainerDetailsItemHolder(2, null, getString(R.string.binders), 2, null));
                Iterator<MTCardContainer> it2 = binders.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new CardContainerDetailsItemHolder(1, it2.next(), null, 4, null));
                }
            }
            getBinding().collectionRecyclerView.setAdapter(new CardContainerDetailsAdapter(arrayList, this));
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<MTCardContainer> boxes2 = collection.getBoxes();
        if (boxes2 != null && !boxes2.isEmpty()) {
            arrayList2.add(new CardContainerItemHolder(2, null, getString(R.string.boxes), 2, null));
            Iterator<MTCardContainer> it3 = boxes2.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new CardContainerItemHolder(1, it3.next(), null, 4, null));
            }
        }
        List<MTCardContainer> binders2 = collection.getBinders();
        if (binders2 != null && !binders2.isEmpty()) {
            arrayList2.add(new CardContainerItemHolder(2, null, getString(R.string.binders), 2, null));
            Iterator<MTCardContainer> it4 = binders2.iterator();
            while (it4.hasNext()) {
                arrayList2.add(new CardContainerItemHolder(1, it4.next(), null, 4, null));
            }
        }
        getBinding().collectionRecyclerView.setAdapter(new CardContainerAdapter(arrayList2, this, false, 4, null));
    }

    public final void updateUI(MTCollection collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.collection = collection;
        getBinding().cardsValue.setText(String.valueOf(collection.getTotal_cards()));
        getBinding().priceValue.setText("--");
        getBinding().deltaValue.setText("");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String preferredCurrency = new PreferencesManager(contextRequireContext).getPreferredCurrency();
        MTCardsValue containerValue = GameUtils.INSTANCE.getInstance().getContainerValue(collection.getValues(), preferredCurrency);
        if (containerValue != null) {
            getBinding().priceValue.setText(GameUtils.INSTANCE.getInstance().formatPrice(containerValue.getTotal_value(), preferredCurrency));
            MTPriceDelta delta = containerValue.getDelta();
            if (delta != null) {
                getBinding().deltaValue.setText(GameUtils.INSTANCE.getInstance().formatDelta(delta, preferredCurrency));
                if (delta.getAmount() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    getBinding().deltaValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_green));
                } else if (delta.getAmount() < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    getBinding().deltaValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.loser_red));
                } else {
                    getBinding().deltaValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                }
            }
        }
        updateRecyclerView(collection);
    }
}
