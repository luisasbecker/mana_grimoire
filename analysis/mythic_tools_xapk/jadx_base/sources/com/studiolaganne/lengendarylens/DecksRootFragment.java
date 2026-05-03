package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.databinding.FragmentDecksRootBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: DecksRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u00020-H\u0002J\u0018\u00104\u001a\u00020-2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u00108\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u00109\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u0010:\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u0010;\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u0010<\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0018\u0010>\u001a\u00020-2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010?\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0018\u0010@\u001a\u00020-2\u0006\u00107\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0014H\u0016J\u0006\u0010B\u001a\u00020-J\b\u0010C\u001a\u00020-H\u0016J\b\u0010D\u001a\u00020-H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksRootFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentDecksRootBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentDecksRootBinding;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "formatsPopupMenu", "Landroid/widget/PopupMenu;", "currentFormatId", "", "Ljava/lang/Integer;", "currentSortingType", "Lcom/studiolaganne/lengendarylens/DeckSortingType;", "currentSearchQuery", "", "handler", "Landroid/os/Handler;", "scrollStoppedRunnable", "Ljava/lang/Runnable;", "deckActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "pickCardLauncher", "searchActivityLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "setupScrollListener", "hideAddButton", "showAddButton", "setupSorting", "setupFiltering", "updateDecks", "decklist", "onDeckTemporary", "deck", "onDeckRestore", "onDeckFullDelete", "onDeckDelete", "onDeckSelected", "onDeckEdit", "onDeckEdited", "onDeckCreated", "onGhostDeckCreated", "onDeckCreatedForUser", "userId", "refreshFromRemote", "onResume", "onDestroyView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecksRootFragment extends Fragment implements DecksListClickListener, CreateDeckCallback {
    public static final int $stable = 8;
    private FragmentDecksRootBinding _binding;
    private Integer currentFormatId;
    private final ActivityResultLauncher<Intent> deckActivityLauncher;
    private PopupMenu formatsPopupMenu;
    private final ActivityResultLauncher<Intent> pickCardLauncher;
    private Runnable scrollStoppedRunnable;
    private final ActivityResultLauncher<Intent> searchActivityLauncher;
    private List<MTDeck> decks = CollectionsKt.emptyList();
    private List<MTFormat> formatsForFilter = new ArrayList();
    private DeckSortingType currentSortingType = DeckSortingType.UPDATED_AT;
    private String currentSearchQuery = "";
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: DecksRootFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeckSortingType.values().length];
            try {
                iArr[DeckSortingType.A_TO_Z.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeckSortingType.WINRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeckSortingType.NUM_GAMES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeckSortingType.CREATED_AT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeckSortingType.UPDATED_AT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeckSortingType.BRACKET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DecksRootFragment$setupScrollListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: DecksRootFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/studiolaganne/lengendarylens/DecksRootFragment$setupScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                final DecksRootFragment decksRootFragment = DecksRootFragment.this;
                decksRootFragment.scrollStoppedRunnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$setupScrollListener$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        decksRootFragment.showAddButton();
                    }
                };
                Handler handler = DecksRootFragment.this.handler;
                Runnable runnable = DecksRootFragment.this.scrollStoppedRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 2000L);
                return;
            }
            if (newState != 1) {
                return;
            }
            DecksRootFragment.this.hideAddButton();
            Runnable runnable2 = DecksRootFragment.this.scrollStoppedRunnable;
            if (runnable2 != null) {
                DecksRootFragment.this.handler.removeCallbacks(runnable2);
            }
        }
    }

    public DecksRootFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda13
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.deckActivityLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda14
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DecksRootFragment.pickCardLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.pickCardLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda15
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DecksRootFragment.searchActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.searchActivityLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentDecksRootBinding getBinding() {
        FragmentDecksRootBinding fragmentDecksRootBinding = this._binding;
        Intrinsics.checkNotNull(fragmentDecksRootBinding);
        return fragmentDecksRootBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().addButtonLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DecksRootFragment.hideAddButton$lambda$0(this.f$0);
            }
        }).start();
    }

    static final void hideAddButton$lambda$0(DecksRootFragment decksRootFragment) {
        decksRootFragment.getBinding().addButtonLayout.setClickable(false);
        decksRootFragment.getBinding().addButtonLayout.setFocusable(false);
    }

    static final Unit onDeckDelete$lambda$0(final DecksRootFragment decksRootFragment, MTDeck mTDeck, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Context contextRequireContext = decksRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null && decksRootFragment.getContext() != null && decksRootFragment._binding != null) {
            decksRootFragment.getBinding().overlay.setVisibility(0);
            MTApiKt.getMtApi().deleteDeck(currentUser.getId(), mTDeck.getId(), Boolean.valueOf(z)).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$onDeckDelete$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                    if (!response.isSuccessful() || this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    preferencesManager.setForcedApiUpdate(true);
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        DecksRootFragment decksRootFragment2 = this.this$0;
                        preferencesManager2.saveCurrentUserDecks(decks);
                        preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : decks) {
                            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                                arrayList.add(obj);
                            }
                        }
                        decksRootFragment2.decks = arrayList;
                        decksRootFragment2.updateDecks(decksRootFragment2.decks);
                    }
                }
            });
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckDelete$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckFullDelete$lambda$0(final DecksRootFragment decksRootFragment, MTDeck mTDeck, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Context contextRequireContext = decksRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            decksRootFragment.getBinding().overlay.setVisibility(0);
            MTApiKt.getMtApi().fullDeleteDeck(currentUser.getId(), mTDeck.getId(), Boolean.valueOf(z)).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$onDeckFullDelete$dialog$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                    if (!response.isSuccessful() || this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    preferencesManager.setForcedApiUpdate(true);
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        DecksRootFragment decksRootFragment2 = this.this$0;
                        preferencesManager2.saveCurrentUserDecks(decks);
                        preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : decks) {
                            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                                arrayList.add(obj);
                            }
                        }
                        decksRootFragment2.decks = arrayList;
                        decksRootFragment2.updateDecks(decksRootFragment2.decks);
                    }
                }
            });
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckFullDelete$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckTemporary$lambda$0(final DecksRootFragment decksRootFragment, MTDeck mTDeck, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Context contextRequireContext = decksRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            decksRootFragment.getBinding().overlay.setVisibility(0);
            MTApiKt.getMtApi().acceptDeck(currentUser.getId(), mTDeck.getId()).enqueue(new Callback<MTSingleDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$onDeckTemporary$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSingleDeckResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSingleDeckResponse> call, Response<MTSingleDeckResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                    if (!response.isSuccessful() || this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    MTSingleDeckResponse mTSingleDeckResponseBody = response.body();
                    MTDeck deck = mTSingleDeckResponseBody != null ? mTSingleDeckResponseBody.getDeck() : null;
                    if (deck != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        DecksRootFragment decksRootFragment2 = this.this$0;
                        List<MTDeck> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getCurrentUserDecks());
                        Iterator<MTDeck> it = mutableList.iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            } else if (it.next().getId() == deck.getId()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            mutableList.set(i, deck);
                        }
                        preferencesManager2.saveCurrentUserDecks(mutableList);
                        preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : mutableList) {
                            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                                arrayList.add(obj);
                            }
                        }
                        decksRootFragment2.decks = arrayList;
                        decksRootFragment2.updateDecks(decksRootFragment2.decks);
                    }
                }
            });
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckTemporary$lambda$1(final DecksRootFragment decksRootFragment, MTDeck mTDeck, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (decksRootFragment.getContext() == null || decksRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = decksRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            decksRootFragment.getBinding().overlay.setVisibility(0);
            MTApiKt.getMtApi().deleteDeck(currentUser.getId(), mTDeck.getId(), false).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$onDeckTemporary$2$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                    if (!response.isSuccessful() || this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        DecksRootFragment decksRootFragment2 = this.this$0;
                        preferencesManager2.saveCurrentUserDecks(decks);
                        preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : decks) {
                            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                                arrayList.add(obj);
                            }
                        }
                        decksRootFragment2.decks = arrayList;
                        decksRootFragment2.updateDecks(decksRootFragment2.decks);
                    }
                }
            });
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(DecksRootFragment decksRootFragment) {
        decksRootFragment.getBinding().filterEditText.getText().clear();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(DecksRootFragment decksRootFragment) {
        decksRootFragment.startActivity(new Intent(decksRootFragment.requireContext(), (Class<?>) ArchivedDecksActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(DecksRootFragment decksRootFragment) {
        if (decksRootFragment.getContext() == null || decksRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = decksRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("create_deck_click");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(decksRootFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("create_deck_click", null);
            CreateDeckBottomSheetFragment.Companion.newInstance$default(CreateDeckBottomSheetFragment.INSTANCE, decksRootFragment, decksRootFragment.searchActivityLauncher, decksRootFragment.pickCardLauncher, currentUser, null, 16, null).show(decksRootFragment.getParentFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final void pickCardLauncher$lambda$0(DecksRootFragment decksRootFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = decksRootFragment.getParentFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.cardScanned(mTFullCard, intExtra);
            }
        }
    }

    static final void searchActivityLauncher$lambda$0(DecksRootFragment decksRootFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = decksRootFragment.getParentFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.updateCardId(mTFullCard, intExtra);
            }
        }
    }

    private final void setupFiltering() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        final List<MTFormat> formats = companion.getInstance(contextRequireContext2).getFormats();
        List mutableList = CollectionsKt.toMutableList((Collection) formats);
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            MTFormat mTFormat = (MTFormat) obj;
            List<MTDeck> list = this.decks;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((MTDeck) it.next()).getFormatid() == mTFormat.getId()) {
                            arrayList.add(obj);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        this.formatsForFilter = CollectionsKt.toMutableList((Collection) arrayList);
        PopupMenu popupMenu = new PopupMenu(requireContext(), getBinding().filterLayout);
        this.formatsPopupMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (MTFormat mTFormat2 : this.formatsForFilter) {
            menu.add(0, mTFormat2.getId(), 0, mTFormat2.getName());
        }
        PopupMenu popupMenu2 = this.formatsPopupMenu;
        if (popupMenu2 != null) {
            popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda18
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return DecksRootFragment.setupFiltering$lambda$2(formats, this, menuItem);
                }
            });
        }
        ConstraintLayout filterLayout = getBinding().filterLayout;
        Intrinsics.checkNotNullExpressionValue(filterLayout, "filterLayout");
        ViewExtensionsKt.setOnClickWithFade(filterLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksRootFragment.setupFiltering$lambda$3(this.f$0);
            }
        });
        ImageView closeFilterIcon = getBinding().closeFilterIcon;
        Intrinsics.checkNotNullExpressionValue(closeFilterIcon, "closeFilterIcon");
        ViewExtensionsKt.setOnClickWithFade(closeFilterIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksRootFragment.setupFiltering$lambda$4(this.f$0);
            }
        });
    }

    static final boolean setupFiltering$lambda$2(List list, DecksRootFragment decksRootFragment, MenuItem menuItem) {
        Object next;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        if (mTFormat == null) {
            return true;
        }
        decksRootFragment.getBinding().filterLayout.setVisibility(8);
        decksRootFragment.getBinding().activeFilterLayout.setVisibility(0);
        decksRootFragment.getBinding().activeFilterText.setText(mTFormat.getName());
        decksRootFragment.currentFormatId = Integer.valueOf(mTFormat.getId());
        decksRootFragment.updateDecks(decksRootFragment.decks);
        return true;
    }

    static final Unit setupFiltering$lambda$3(DecksRootFragment decksRootFragment) {
        PopupMenu popupMenu = decksRootFragment.formatsPopupMenu;
        if (popupMenu != null) {
            popupMenu.show();
        }
        return Unit.INSTANCE;
    }

    static final Unit setupFiltering$lambda$4(DecksRootFragment decksRootFragment) {
        decksRootFragment.getBinding().activeFilterLayout.setVisibility(8);
        decksRootFragment.getBinding().filterLayout.setVisibility(0);
        decksRootFragment.currentFormatId = null;
        decksRootFragment.updateDecks(decksRootFragment.decks);
        return Unit.INSTANCE;
    }

    private final void setupScrollListener() {
        getBinding().decksRecyclerView.addOnScrollListener(new AnonymousClass1());
    }

    private final void setupSorting() {
        String string;
        TextView textView = getBinding().sortValueText;
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentSortingType.ordinal()]) {
            case 1:
                string = getString(R.string.sort_by_az);
                break;
            case 2:
                string = getString(R.string.sort_by_winrate);
                break;
            case 3:
                string = getString(R.string.sort_by_games);
                break;
            case 4:
                string = getString(R.string.sort_by_created);
                break;
            case 5:
                string = getString(R.string.sort_by_updated);
                break;
            case 6:
                string = getString(R.string.sort_by_bracket);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        textView.setText(string);
        ConstraintLayout sortLayout = getBinding().sortLayout;
        Intrinsics.checkNotNullExpressionValue(sortLayout, "sortLayout");
        ViewExtensionsKt.setOnClickWithFade(sortLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksRootFragment.setupSorting$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupSorting$lambda$0(final DecksRootFragment decksRootFragment) {
        if (decksRootFragment.getContext() == null || decksRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(decksRootFragment.requireContext(), decksRootFragment.getBinding().sortLayout);
        Menu menu = popupMenu.getMenu();
        menu.add(0, 0, 0, decksRootFragment.getString(R.string.sort_by_az));
        menu.add(0, 1, 0, decksRootFragment.getString(R.string.sort_by_winrate));
        menu.add(0, 2, 0, decksRootFragment.getString(R.string.sort_by_games));
        menu.add(0, 3, 0, decksRootFragment.getString(R.string.sort_by_created));
        menu.add(0, 4, 0, decksRootFragment.getString(R.string.sort_by_updated));
        menu.add(0, 5, 0, decksRootFragment.getString(R.string.sort_by_bracket));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda3
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DecksRootFragment.setupSorting$lambda$0$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupSorting$lambda$0$0(DecksRootFragment decksRootFragment, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            decksRootFragment.currentSortingType = DeckSortingType.A_TO_Z;
            decksRootFragment.getBinding().sortValueText.setText(decksRootFragment.getString(R.string.sort_by_az));
        } else if (itemId == 1) {
            decksRootFragment.currentSortingType = DeckSortingType.WINRATE;
            decksRootFragment.getBinding().sortValueText.setText(decksRootFragment.getString(R.string.sort_by_winrate));
        } else if (itemId == 2) {
            decksRootFragment.currentSortingType = DeckSortingType.NUM_GAMES;
            decksRootFragment.getBinding().sortValueText.setText(decksRootFragment.getString(R.string.sort_by_games));
        } else if (itemId == 3) {
            decksRootFragment.currentSortingType = DeckSortingType.CREATED_AT;
            decksRootFragment.getBinding().sortValueText.setText(decksRootFragment.getString(R.string.sort_by_created));
        } else if (itemId == 4) {
            decksRootFragment.currentSortingType = DeckSortingType.UPDATED_AT;
            decksRootFragment.getBinding().sortValueText.setText(decksRootFragment.getString(R.string.sort_by_updated));
        } else if (itemId == 5) {
            decksRootFragment.currentSortingType = DeckSortingType.BRACKET;
            decksRootFragment.getBinding().sortValueText.setText(decksRootFragment.getString(R.string.sort_by_bracket));
        }
        Context contextRequireContext = decksRootFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setDeckSortOrder(decksRootFragment.currentSortingType.name());
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        decksRootFragment.updateDecks(decksRootFragment.decks);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().addButtonLayout.setVisibility(0);
        getBinding().addButtonLayout.setClickable(true);
        getBinding().addButtonLayout.setFocusable(true);
        getBinding().addButtonLayout.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecks(List<MTDeck> decklist) {
        ArrayList arrayList;
        List listSortedWith;
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (decklist == null) {
            decklist = CollectionsKt.emptyList();
        }
        this.decks = decklist;
        if (this.currentFormatId != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : decklist) {
                MTDeck mTDeck = (MTDeck) obj;
                int formatid = mTDeck.getFormatid();
                Integer num = this.currentFormatId;
                if (num != null && formatid == num.intValue() && !Intrinsics.areEqual((Object) mTDeck.getActive(), (Object) false)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : decklist) {
                if (!Intrinsics.areEqual((Object) ((MTDeck) obj2).getActive(), (Object) false)) {
                    arrayList3.add(obj2);
                }
            }
            arrayList = arrayList3;
        }
        if (!StringsKt.isBlank(this.currentSearchQuery)) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : arrayList) {
                if (StringsKt.contains((CharSequence) ((MTDeck) obj3).getName(), (CharSequence) this.currentSearchQuery, true)) {
                    arrayList4.add(obj3);
                }
            }
            arrayList = arrayList4;
        }
        getBinding().noDecksText.setVisibility(arrayList.isEmpty() ? 0 : 8);
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentSortingType.ordinal()]) {
            case 1:
                listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t).getName(), ((MTDeck) t2).getName());
                    }
                });
                break;
            case 2:
                final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$compareByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String rate;
                        String rate2;
                        MTStats stats = ((MTDeck) t2).getStats();
                        Float fValueOf = null;
                        Float fValueOf2 = (stats == null || (rate2 = stats.getRate()) == null) ? null : Float.valueOf(Float.parseFloat(rate2));
                        MTStats stats2 = ((MTDeck) t).getStats();
                        if (stats2 != null && (rate = stats2.getRate()) != null) {
                            fValueOf = Float.valueOf(Float.parseFloat(rate));
                        }
                        return ComparisonsKt.compareValues(fValueOf2, fValueOf);
                    }
                };
                listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$thenByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator.compare(t, t2);
                        if (iCompare != 0) {
                            return iCompare;
                        }
                        MTStats stats = ((MTDeck) t2).getStats();
                        Integer numValueOf = stats != null ? Integer.valueOf(stats.getGames()) : null;
                        MTStats stats2 = ((MTDeck) t).getStats();
                        return ComparisonsKt.compareValues(numValueOf, stats2 != null ? Integer.valueOf(stats2.getGames()) : null);
                    }
                });
                break;
            case 3:
                listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        MTStats stats = ((MTDeck) t2).getStats();
                        Integer numValueOf = stats != null ? Integer.valueOf(stats.getGames()) : null;
                        MTStats stats2 = ((MTDeck) t).getStats();
                        return ComparisonsKt.compareValues(numValueOf, stats2 != null ? Integer.valueOf(stats2.getGames()) : null);
                    }
                });
                break;
            case 4:
                listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$sortedByDescending$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t2).getCreated_at(), ((MTDeck) t).getCreated_at());
                    }
                });
                break;
            case 5:
                listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$sortedByDescending$3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t2).getUpdated_at(), ((MTDeck) t).getUpdated_at());
                    }
                });
                break;
            case 6:
                listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$updateDecks$$inlined$sortedByDescending$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:6:0x0010 A[PHI: r2
                      0x0010: PHI (r2v11 java.lang.Integer) = (r2v4 java.lang.Integer), (r2v13 java.lang.Integer) binds: [B:11:0x0021, B:5:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
                    @Override // java.util.Comparator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final int compare(T t, T t2) {
                        int iIntValue;
                        Integer user;
                        MTDeck mTDeck2 = (MTDeck) t2;
                        MTBracket bracket = mTDeck2.getBracket();
                        int iIntValue2 = 0;
                        if (bracket == null || (auto = bracket.getUser()) == null) {
                            MTBracket bracket2 = mTDeck2.getBracket();
                            Integer auto = bracket2 != null ? bracket2.getAuto() : null;
                            iIntValue = auto != null ? auto.intValue() : 0;
                        }
                        Integer numValueOf = Integer.valueOf(iIntValue);
                        MTDeck mTDeck3 = (MTDeck) t;
                        MTBracket bracket3 = mTDeck3.getBracket();
                        if (bracket3 == null || (user = bracket3.getUser()) == null) {
                            MTBracket bracket4 = mTDeck3.getBracket();
                            Integer auto2 = bracket4 != null ? bracket4.getAuto() : null;
                            if (auto2 != null) {
                                iIntValue2 = auto2.intValue();
                            }
                        } else {
                            iIntValue2 = user.intValue();
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(iIntValue2));
                    }
                });
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        List list = listSortedWith;
        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTGDBHelper companion2 = companion.getInstance(contextRequireContext);
        ArrayList arrayList5 = new ArrayList();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        for (String str : new PreferencesManager(contextRequireContext2).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion3 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                arrayList5.add(companion3.getInstance(contextRequireContext3, str));
            }
        }
        DecksDBHelper.Companion companion4 = DecksDBHelper.INSTANCE;
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        getBinding().decksRecyclerView.setAdapter(new DecksListAdapter(list, companion4.getInstance(contextRequireContext4).getFormats(), companion2, arrayList5, this, false));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDecksRootBinding.inflate(inflater, container, false);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreated(List<MTDeck> decks) {
        if (decks != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : decks) {
                if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                    arrayList.add(obj);
                }
            }
            this.decks = arrayList;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            preferencesManager.saveCurrentUserDecks(decks);
            preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
            updateDecks(this.decks);
        }
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreatedForUser(MTDeck deck, int userId) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckDelete(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null || this._binding == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.delete_deck_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder showRestoreCheckBox = title.setBody(string2).setPositiveButtonRed().setShowRestoreCheckBox(true);
        String string3 = getString(R.string.archive_deck_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = showRestoreCheckBox.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DecksRootFragment.onDeckDelete$lambda$0(this.f$0, deck, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecksRootFragment.onDeckDelete$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "CustomDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckEdit(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            CreateDeckBottomSheetFragment.INSTANCE.newInstance(this, this.searchActivityLauncher, this.pickCardLauncher, currentUser, deck).show(getParentFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckEdited(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
        List<MTDeck> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserDecks());
        Iterator<MTDeck> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == deck.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            mutableList.set(i, deck);
            preferencesManager.saveCurrentUserDecks(mutableList);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.decks = arrayList2;
        updateDecks(arrayList2);
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckFullDelete(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null || this._binding == null) {
            return;
        }
        CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.full_delete_deck_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        title.setBody(string2).setShowRestoreCheckBox(true).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DecksRootFragment.onDeckFullDelete$lambda$0(this.f$0, deck, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecksRootFragment.onDeckFullDelete$lambda$1((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getChildFragmentManager(), "CustomDeleteDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckRestore(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckSelected(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        Intent intent = new Intent(requireContext(), (Class<?>) DeckDetailsActivity.class);
        intent.putExtra("deckId", deck.getId());
        this.deckActivityLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckTemporary(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null || this._binding == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.temporary_deck_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.temporary_deck_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.keep_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DecksRootFragment.onDeckTemporary$lambda$0(this.f$0, deck, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.discard_button);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecksRootFragment.onDeckTemporary$lambda$1(this.f$0, deck, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "temp_deck_dialog");
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

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onGhostDeckCreated(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getBoolean(PreferencesManager.NEED_USER_RELOAD, false) && preferencesManager.getCurrentUser() != null) {
            List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
            ArrayList arrayList = new ArrayList();
            for (Object obj : currentUserDecks) {
                if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            this.decks = arrayList2;
            updateDecks(arrayList2);
        }
        if (preferencesManager.getForcedApiUpdate()) {
            refreshFromRemote();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        DeckSortingType deckSortingTypeValueOf;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentUserDecks) {
            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                arrayList.add(obj);
            }
        }
        this.decks = arrayList;
        try {
            deckSortingTypeValueOf = DeckSortingType.valueOf(preferencesManager.getDeckSortOrder());
        } catch (Exception unused) {
            deckSortingTypeValueOf = DeckSortingType.UPDATED_AT;
        }
        this.currentSortingType = deckSortingTypeValueOf;
        getBinding().decksRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        setupScrollListener();
        getBinding().swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.refreshFromRemote();
            }
        });
        setupSorting();
        setupFiltering();
        getBinding().filterEditText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment.onViewCreated.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string;
                DecksRootFragment decksRootFragment = DecksRootFragment.this;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                decksRootFragment.currentSearchQuery = string;
                Editable editable = s;
                DecksRootFragment.this.getBinding().clearFilterButton.setVisibility((editable == null || editable.length() == 0) ? 8 : 0);
                DecksRootFragment decksRootFragment2 = DecksRootFragment.this;
                decksRootFragment2.updateDecks(decksRootFragment2.decks);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ImageView clearFilterButton = getBinding().clearFilterButton;
        Intrinsics.checkNotNullExpressionValue(clearFilterButton, "clearFilterButton");
        ViewExtensionsKt.setOnClickWithFade(clearFilterButton, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksRootFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        LinearLayout archivedDecksLayout = getBinding().archivedDecksLayout;
        Intrinsics.checkNotNullExpressionValue(archivedDecksLayout, "archivedDecksLayout");
        ViewExtensionsKt.setOnClickWithFade(archivedDecksLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksRootFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        ConstraintLayout addButtonLayout = getBinding().addButtonLayout;
        Intrinsics.checkNotNullExpressionValue(addButtonLayout, "addButtonLayout");
        ViewExtensionsKt.setOnClickWithBounce(addButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksRootFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        updateDecks(this.decks);
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
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getDecks(currentUser.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksRootFragment$refreshFromRemote$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                    this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().overlay.setVisibility(8);
                    this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
                    if (!response.isSuccessful() || this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        DecksRootFragment decksRootFragment = this.this$0;
                        preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                        preferencesManager2.saveCurrentUserDecks(decks);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : decks) {
                            if (!Intrinsics.areEqual((Object) ((MTDeck) obj).getActive(), (Object) false)) {
                                arrayList.add(obj);
                            }
                        }
                        decksRootFragment.decks = arrayList;
                        decksRootFragment.updateDecks(decksRootFragment.decks);
                    }
                }
            });
        } else {
            if (getContext() == null || this._binding == null) {
                return;
            }
            getBinding().swipeRefreshLayout.setRefreshing(false);
            getBinding().overlay.setVisibility(8);
        }
    }
}
