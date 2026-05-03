package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
import androidx.work.PeriodicWorkRequest;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
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

/* JADX INFO: compiled from: DecksListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0018\u0010+\u001a\u00020\u001f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0016J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0014J\u0012\u00100\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020\u001fH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksListActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "<init>", "()V", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "formatsPopupMenu", "Landroid/widget/PopupMenu;", "currentFormatId", "", "Ljava/lang/Integer;", "currentDeckType", "currentSortingType", "Lcom/studiolaganne/lengendarylens/DeckSortingType;", "currentSearchQuery", "", "deckActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "isArchiveTab", "", "archivedDecks", "lastArchivedDecksAPIUpdate", "", "updateDecks", "", "decklist", "pickCardLauncher", "searchActivityLauncher", "onDeckTemporary", "deck", "onDeckRestore", "onDeckFullDelete", "onDeckDelete", "onDeckSelected", "onDeckEdit", "onDeckEdited", "onDeckCreated", "onGhostDeckCreated", "onDeckCreatedForUser", "userId", "onResume", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "loadArchivedDecks", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecksListActivity extends BaseActivity implements DecksListClickListener, CreateDeckCallback {
    public static final int $stable = 8;
    private int currentDeckType;
    private Integer currentFormatId;
    private PopupMenu formatsPopupMenu;
    private boolean isArchiveTab;
    private long lastArchivedDecksAPIUpdate;
    private List<MTDeck> decks = CollectionsKt.emptyList();
    private List<MTFormat> formatsForFilter = new ArrayList();
    private DeckSortingType currentSortingType = DeckSortingType.A_TO_Z;
    private String currentSearchQuery = "";
    private final ActivityResultLauncher<Intent> deckActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda16
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
        }
    });
    private List<MTDeck> archivedDecks = CollectionsKt.emptyList();
    private final ActivityResultLauncher<Intent> pickCardLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda17
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DecksListActivity.pickCardLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> searchActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DecksListActivity.searchActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });

    /* JADX INFO: compiled from: DecksListActivity.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadArchivedDecks() {
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (System.currentTimeMillis() - this.lastArchivedDecksAPIUpdate < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            updateDecks(this.archivedDecks);
            return;
        }
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        constraintLayout.setVisibility(0);
        Log.d("DecksListActivity", "Loading archived decks...");
        if (currentUser != null) {
            MTApiKt.getMtApi().getUserArchivedDecks(currentUser.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$loadArchivedDecks$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    constraintLayout.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    constraintLayout.setVisibility(8);
                    Log.d("DecksListActivity", "Archived decks response: " + response);
                    if (!response.isSuccessful() || this.isDestroyed() || this.isFinishing()) {
                        return;
                    }
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        DecksListActivity decksListActivity = this;
                        PreferencesManager preferencesManager2 = preferencesManager;
                        decksListActivity.archivedDecks = decks;
                        decksListActivity.lastArchivedDecksAPIUpdate = System.currentTimeMillis();
                        preferencesManager2.saveCurrentUserArchivedDecks(decks);
                        if (decksListActivity.isArchiveTab) {
                            decksListActivity.updateDecks(decks);
                        }
                    }
                }
            });
        }
    }

    static final Unit onCreate$lambda$1(DecksListActivity decksListActivity) {
        decksListActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$2(DecksListActivity decksListActivity, MTUser mTUser) {
        if (decksListActivity.isFinishing() || decksListActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("create_deck_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(decksListActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("create_deck_click", null);
        if (mTUser != null) {
            CreateDeckBottomSheetFragment.Companion.newInstance$default(CreateDeckBottomSheetFragment.INSTANCE, decksListActivity, decksListActivity.searchActivityLauncher, decksListActivity.pickCardLauncher, mTUser, null, 16, null).show(decksListActivity.getSupportFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(EditText editText) {
        editText.getText().clear();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$4(final DecksListActivity decksListActivity, ConstraintLayout constraintLayout, final PreferencesManager preferencesManager) {
        PopupMenu popupMenu = new PopupMenu(decksListActivity, constraintLayout);
        Menu menu = popupMenu.getMenu();
        menu.add(0, 0, 0, decksListActivity.getResources().getString(R.string.sort_by_az));
        menu.add(0, 1, 0, decksListActivity.getResources().getString(R.string.sort_by_winrate));
        menu.add(0, 2, 0, decksListActivity.getResources().getString(R.string.sort_by_games));
        menu.add(0, 3, 0, decksListActivity.getResources().getString(R.string.sort_by_created));
        menu.add(0, 4, 0, decksListActivity.getResources().getString(R.string.sort_by_updated));
        menu.add(0, 5, 0, decksListActivity.getResources().getString(R.string.sort_by_bracket));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda13
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DecksListActivity.onCreate$lambda$4$0(this.f$0, preferencesManager, menuItem);
            }
        });
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$4$0(DecksListActivity decksListActivity, PreferencesManager preferencesManager, MenuItem menuItem) {
        TextView textView = (TextView) decksListActivity.findViewById(R.id.sortValueText);
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            decksListActivity.currentSortingType = DeckSortingType.A_TO_Z;
            textView.setText(decksListActivity.getResources().getString(R.string.sort_by_az));
        } else if (itemId == 1) {
            decksListActivity.currentSortingType = DeckSortingType.WINRATE;
            textView.setText(decksListActivity.getResources().getString(R.string.sort_by_winrate));
        } else if (itemId == 2) {
            decksListActivity.currentSortingType = DeckSortingType.NUM_GAMES;
            textView.setText(decksListActivity.getResources().getString(R.string.sort_by_games));
        } else if (itemId == 3) {
            decksListActivity.currentSortingType = DeckSortingType.CREATED_AT;
            textView.setText(decksListActivity.getResources().getString(R.string.sort_by_created));
        } else if (itemId == 4) {
            decksListActivity.currentSortingType = DeckSortingType.UPDATED_AT;
            textView.setText(decksListActivity.getResources().getString(R.string.sort_by_updated));
        } else if (itemId == 5) {
            decksListActivity.currentSortingType = DeckSortingType.BRACKET;
            textView.setText(decksListActivity.getResources().getString(R.string.sort_by_bracket));
        }
        preferencesManager.setDeckSortOrder(decksListActivity.currentSortingType.name());
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        decksListActivity.updateDecks(decksListActivity.decks);
        return true;
    }

    static final Unit onCreate$lambda$5(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, DecksListActivity decksListActivity) {
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(0);
        decksListActivity.currentFormatId = null;
        decksListActivity.updateDecks(decksListActivity.decks);
        return Unit.INSTANCE;
    }

    static final boolean onCreate$lambda$8(List list, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, DecksListActivity decksListActivity, PreferencesManager preferencesManager, TextView textView2, MenuItem menuItem) {
        Object next;
        List listSortedWith;
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
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(0);
        textView.setText(mTFormat.getName());
        decksListActivity.currentFormatId = Integer.valueOf(mTFormat.getId());
        List<MTDeck> list2 = decksListActivity.decks;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            MTDeck mTDeck = (MTDeck) obj;
            if (mTDeck.getFormatid() == mTFormat.getId() && mTDeck.getType() == decksListActivity.currentDeckType) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        View viewFindViewById = decksListActivity.findViewById(R.id.decksRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        DecksListActivity decksListActivity2 = decksListActivity;
        MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(decksListActivity2);
        ArrayList arrayList3 = new ArrayList();
        for (String str : preferencesManager.getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                arrayList3.add(MTGDBHelperLocalized.INSTANCE.getInstance(decksListActivity2, str));
            }
        }
        textView2.setVisibility(arrayList2.isEmpty() ? 0 : 8);
        switch (WhenMappings.$EnumSwitchMapping$0[decksListActivity.currentSortingType.ordinal()]) {
            case 1:
                listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t).getName(), ((MTDeck) t2).getName());
                    }
                });
                break;
            case 2:
                final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$compareByDescending$1
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
                listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$thenByDescending$1
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
                listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$sortedByDescending$1
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
                listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$sortedByDescending$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t2).getCreated_at(), ((MTDeck) t).getCreated_at());
                    }
                });
                break;
            case 5:
                listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$sortedByDescending$3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t2).getUpdated_at(), ((MTDeck) t).getUpdated_at());
                    }
                });
                break;
            case 6:
                listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$lambda$8$1$$inlined$sortedByDescending$4
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
        recyclerView.setAdapter(new DecksListAdapter(listSortedWith, list, companion, arrayList3, decksListActivity, false));
        return true;
    }

    static final Unit onCreate$lambda$9(DecksListActivity decksListActivity) {
        PopupMenu popupMenu = decksListActivity.formatsPopupMenu;
        if (popupMenu != null) {
            popupMenu.show();
        }
        return Unit.INSTANCE;
    }

    static final Unit onDeckDelete$lambda$0(DecksListActivity decksListActivity, MTDeck mTDeck, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(decksListActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) decksListActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().deleteDeck(currentUser.getId(), mTDeck.getId(), Boolean.valueOf(z)).enqueue(new DecksListActivity$onDeckDelete$1$1$1(decksListActivity, preferencesManager, mTDeck, constraintLayout));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckDelete$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckFullDelete$lambda$0(DecksListActivity decksListActivity, MTDeck mTDeck, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(decksListActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) decksListActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().fullDeleteDeck(currentUser.getId(), mTDeck.getId(), Boolean.valueOf(z)).enqueue(new DecksListActivity$onDeckFullDelete$dialog$1$1$1(decksListActivity, preferencesManager, constraintLayout, mTDeck));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckFullDelete$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckTemporary$lambda$0(DecksListActivity decksListActivity, MTDeck mTDeck, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(decksListActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) decksListActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().acceptDeck(currentUser.getId(), mTDeck.getId()).enqueue(new DecksListActivity$onDeckTemporary$1$1$1(decksListActivity, constraintLayout, preferencesManager));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckTemporary$lambda$1(DecksListActivity decksListActivity, MTDeck mTDeck, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (decksListActivity.isFinishing() || decksListActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        PreferencesManager preferencesManager = new PreferencesManager(decksListActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) decksListActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().deleteDeck(currentUser.getId(), mTDeck.getId(), false).enqueue(new DecksListActivity$onDeckTemporary$2$1$1(decksListActivity, constraintLayout, preferencesManager, mTDeck));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void pickCardLauncher$lambda$0(DecksListActivity decksListActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = decksListActivity.getSupportFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.cardScanned(mTFullCard, intExtra);
            }
        }
    }

    static final void searchActivityLauncher$lambda$0(DecksListActivity decksListActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = decksListActivity.getSupportFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.updateCardId(mTFullCard, intExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecks(List<MTDeck> decklist) {
        ArrayList arrayListEmptyList;
        List listSortedWith;
        if (isDestroyed() || isFinishing()) {
            return;
        }
        if (!this.isArchiveTab) {
            this.decks = decklist == null ? CollectionsKt.emptyList() : decklist;
        }
        List<MTDeck> list = this.decks;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MTDeck) obj).getType() == this.currentDeckType) {
                arrayList.add(obj);
            }
        }
        final ArrayList arrayList2 = arrayList;
        View viewFindViewById = findViewById(R.id.decksRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        DecksListActivity decksListActivity = this;
        final List<MTFormat> formats = DecksDBHelper.INSTANCE.getInstance(decksListActivity).getFormats();
        List mutableList = CollectionsKt.toMutableList((Collection) formats);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : mutableList) {
            MTFormat mTFormat = (MTFormat) obj2;
            ArrayList arrayList4 = arrayList2;
            if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                Iterator it = arrayList4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((MTDeck) it.next()).getFormatid() == mTFormat.getId()) {
                            arrayList3.add(obj2);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        this.formatsForFilter = CollectionsKt.toMutableList((Collection) arrayList3);
        View viewFindViewById2 = findViewById(R.id.filterLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById2;
        PopupMenu popupMenu = new PopupMenu(decksListActivity, constraintLayout);
        this.formatsPopupMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        Iterator<T> it2 = this.formatsForFilter.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            MTFormat mTFormat2 = (MTFormat) it2.next();
            menu.add(0, mTFormat2.getId(), 0, mTFormat2.getName());
        }
        PopupMenu popupMenu2 = this.formatsPopupMenu;
        if (popupMenu2 != null) {
            popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda0
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return DecksListActivity.updateDecks$lambda$3(this.f$0, formats, constraintLayout, arrayList2, recyclerView, menuItem);
                }
            });
        }
        MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(decksListActivity);
        ArrayList arrayList5 = new ArrayList();
        for (String str : new PreferencesManager(decksListActivity).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                arrayList5.add(MTGDBHelperLocalized.INSTANCE.getInstance(decksListActivity, str));
            }
        }
        if (this.isArchiveTab) {
            arrayListEmptyList = this.archivedDecks;
        } else {
            ArrayList arrayList6 = null;
            if (this.currentFormatId != null) {
                if (decklist != null) {
                    ArrayList arrayList7 = new ArrayList();
                    for (Object obj3 : decklist) {
                        MTDeck mTDeck = (MTDeck) obj3;
                        int formatid = mTDeck.getFormatid();
                        Integer num = this.currentFormatId;
                        if (num != null && formatid == num.intValue() && mTDeck.getType() == this.currentDeckType) {
                            arrayList7.add(obj3);
                        }
                    }
                    arrayList6 = arrayList7;
                }
            } else if (decklist != null) {
                ArrayList arrayList8 = new ArrayList();
                for (Object obj4 : decklist) {
                    if (((MTDeck) obj4).getType() == this.currentDeckType) {
                        arrayList8.add(obj4);
                    }
                }
                arrayList6 = arrayList8;
            }
            arrayListEmptyList = arrayList6;
            if (arrayListEmptyList == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
        }
        if (!StringsKt.isBlank(this.currentSearchQuery)) {
            ArrayList arrayList9 = new ArrayList();
            for (Object obj5 : arrayListEmptyList) {
                if (StringsKt.contains((CharSequence) ((MTDeck) obj5).getName(), (CharSequence) this.currentSearchQuery, true)) {
                    arrayList9.add(obj5);
                }
            }
            arrayListEmptyList = arrayList9;
        }
        View viewFindViewById3 = findViewById(R.id.noDecksText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ((TextView) viewFindViewById3).setVisibility(arrayListEmptyList.isEmpty() ? 0 : 8);
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentSortingType.ordinal()]) {
            case 1:
                listSortedWith = CollectionsKt.sortedWith(arrayListEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t).getName(), ((MTDeck) t2).getName());
                    }
                });
                break;
            case 2:
                final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$compareByDescending$1
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
                listSortedWith = CollectionsKt.sortedWith(arrayListEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$thenByDescending$1
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
                listSortedWith = CollectionsKt.sortedWith(arrayListEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$sortedByDescending$1
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
                listSortedWith = CollectionsKt.sortedWith(arrayListEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$sortedByDescending$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t2).getCreated_at(), ((MTDeck) t).getCreated_at());
                    }
                });
                break;
            case 5:
                listSortedWith = CollectionsKt.sortedWith(arrayListEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$sortedByDescending$3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MTDeck) t2).getUpdated_at(), ((MTDeck) t).getUpdated_at());
                    }
                });
                break;
            case 6:
                listSortedWith = CollectionsKt.sortedWith(arrayListEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$$inlined$sortedByDescending$4
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
        recyclerView.setAdapter(new DecksListAdapter(listSortedWith, formats, companion, arrayList5, this, false));
    }

    static final boolean updateDecks$lambda$3(DecksListActivity decksListActivity, List list, ConstraintLayout constraintLayout, List list2, RecyclerView recyclerView, MenuItem menuItem) {
        Object next;
        List listSortedWith;
        View viewFindViewById = decksListActivity.findViewById(R.id.activeFilterLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = decksListActivity.findViewById(R.id.activeFilterText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = decksListActivity.findViewById(R.id.noDecksText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById3;
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
        if (mTFormat != null) {
            constraintLayout.setVisibility(8);
            constraintLayout2.setVisibility(0);
            textView.setText(mTFormat.getName());
            decksListActivity.currentFormatId = Integer.valueOf(mTFormat.getId());
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (((MTDeck) obj).getFormatid() == mTFormat.getId()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!StringsKt.isBlank(decksListActivity.currentSearchQuery)) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : arrayList2) {
                    if (StringsKt.contains((CharSequence) ((MTDeck) obj2).getName(), (CharSequence) decksListActivity.currentSearchQuery, true)) {
                        arrayList3.add(obj2);
                    }
                }
                arrayList2 = arrayList3;
            }
            DecksListActivity decksListActivity2 = decksListActivity;
            MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(decksListActivity2);
            ArrayList arrayList4 = new ArrayList();
            for (String str : new PreferencesManager(decksListActivity2).getEnabledLanguages()) {
                if (!Intrinsics.areEqual(str, "en")) {
                    arrayList4.add(MTGDBHelperLocalized.INSTANCE.getInstance(decksListActivity2, str));
                }
            }
            textView2.setVisibility(arrayList2.isEmpty() ? 0 : 8);
            switch (WhenMappings.$EnumSwitchMapping$0[decksListActivity.currentSortingType.ordinal()]) {
                case 1:
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((MTDeck) t).getName(), ((MTDeck) t2).getName());
                        }
                    });
                    break;
                case 2:
                    final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$compareByDescending$1
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
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$thenByDescending$1
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
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$sortedByDescending$1
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
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$sortedByDescending$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((MTDeck) t2).getCreated_at(), ((MTDeck) t).getCreated_at());
                        }
                    });
                    break;
                case 5:
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$sortedByDescending$3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((MTDeck) t2).getUpdated_at(), ((MTDeck) t).getUpdated_at());
                        }
                    });
                    break;
                case 6:
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$updateDecks$lambda$3$1$$inlined$sortedByDescending$4
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
                            MTDeck mTDeck = (MTDeck) t2;
                            MTBracket bracket = mTDeck.getBracket();
                            int iIntValue2 = 0;
                            if (bracket == null || (auto = bracket.getUser()) == null) {
                                MTBracket bracket2 = mTDeck.getBracket();
                                Integer auto = bracket2 != null ? bracket2.getAuto() : null;
                                iIntValue = auto != null ? auto.intValue() : 0;
                            }
                            Integer numValueOf = Integer.valueOf(iIntValue);
                            MTDeck mTDeck2 = (MTDeck) t;
                            MTBracket bracket3 = mTDeck2.getBracket();
                            if (bracket3 == null || (user = bracket3.getUser()) == null) {
                                MTBracket bracket4 = mTDeck2.getBracket();
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
            recyclerView.setAdapter(new DecksListAdapter(listSortedWith, list, companion, arrayList4, decksListActivity, false));
        }
        return true;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        DeckSortingType deckSortingTypeValueOf;
        String string;
        Iterator it;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks_list);
        DecksListActivity decksListActivity = this;
        final PreferencesManager preferencesManager = new PreferencesManager(decksListActivity);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        try {
            deckSortingTypeValueOf = DeckSortingType.valueOf(preferencesManager.getDeckSortOrder());
        } catch (Exception unused) {
            deckSortingTypeValueOf = DeckSortingType.UPDATED_AT;
        }
        this.currentSortingType = deckSortingTypeValueOf;
        if (currentUser != null) {
            this.decks = preferencesManager.getCurrentUserDecks();
            this.archivedDecks = preferencesManager.getCurrentUserArchivedDecks();
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListActivity.onCreate$lambda$1(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.plusIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListActivity.onCreate$lambda$2(this.f$0, currentUser);
            }
        });
        View viewFindViewById3 = findViewById(R.id.filterEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final EditText editText = (EditText) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.clearFilterButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final ImageView imageView = (ImageView) viewFindViewById4;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.DecksListActivity.onCreate.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string2;
                DecksListActivity decksListActivity2 = DecksListActivity.this;
                if (s == null || (string2 = s.toString()) == null) {
                    string2 = "";
                }
                decksListActivity2.currentSearchQuery = string2;
                Editable editable = s;
                imageView.setVisibility((editable == null || editable.length() == 0) ? 8 : 0);
                DecksListActivity decksListActivity3 = DecksListActivity.this;
                decksListActivity3.updateDecks(decksListActivity3.decks);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListActivity.onCreate$lambda$3(editText);
            }
        });
        View viewFindViewById5 = findViewById(R.id.sortLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.sortValueText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById6;
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentSortingType.ordinal()]) {
            case 1:
                string = getResources().getString(R.string.sort_by_az);
                break;
            case 2:
                string = getResources().getString(R.string.sort_by_winrate);
                break;
            case 3:
                string = getResources().getString(R.string.sort_by_games);
                break;
            case 4:
                string = getResources().getString(R.string.sort_by_created);
                break;
            case 5:
                string = getResources().getString(R.string.sort_by_updated);
                break;
            case 6:
                string = getResources().getString(R.string.sort_by_bracket);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        textView.setText(string);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListActivity.onCreate$lambda$4(this.f$0, constraintLayout, preferencesManager);
            }
        });
        View viewFindViewById7 = findViewById(R.id.activeFilterLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.activeFilterText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.closeFilterIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.filterLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        final ConstraintLayout constraintLayout3 = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = findViewById(R.id.noDecksText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById11;
        textView3.setVisibility(this.decks.isEmpty() ? 0 : 8);
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListActivity.onCreate$lambda$5(constraintLayout2, constraintLayout3, this);
            }
        });
        final List<MTFormat> formats = DecksDBHelper.INSTANCE.getInstance(decksListActivity).getFormats();
        List mutableList = CollectionsKt.toMutableList((Collection) formats);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = mutableList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            MTFormat mTFormat = (MTFormat) next;
            List<MTDeck> list = this.decks;
            if ((list instanceof Collection) && list.isEmpty()) {
                it = it2;
            } else {
                Iterator<T> it3 = list.iterator();
                while (it3.hasNext()) {
                    it = it2;
                    if (((MTDeck) it3.next()).getFormatid() == mTFormat.getId()) {
                        arrayList.add(next);
                    } else {
                        it2 = it;
                    }
                }
                it = it2;
            }
            it2 = it;
        }
        this.formatsForFilter = CollectionsKt.toMutableList((Collection) arrayList);
        ConstraintLayout constraintLayout4 = constraintLayout3;
        PopupMenu popupMenu = new PopupMenu(decksListActivity, constraintLayout4);
        this.formatsPopupMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (MTFormat mTFormat2 : this.formatsForFilter) {
            menu.add(0, mTFormat2.getId(), 0, mTFormat2.getName());
        }
        PopupMenu popupMenu2 = this.formatsPopupMenu;
        if (popupMenu2 != null) {
            popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda7
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return DecksListActivity.onCreate$lambda$8(formats, constraintLayout3, constraintLayout2, textView2, this, preferencesManager, textView3, menuItem);
                }
            });
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListActivity.onCreate$lambda$9(this.f$0);
            }
        });
        View viewFindViewById12 = findViewById(R.id.decksRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        ((RecyclerView) viewFindViewById12).setLayoutManager(new LinearLayoutManager(decksListActivity));
        updateDecks(this.decks);
        View viewFindViewById13 = findViewById(R.id.filterSortLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        final LinearLayout linearLayout = (LinearLayout) viewFindViewById13;
        ((TabLayout) findViewById(R.id.tabLayout)).addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.studiolaganne.lengendarylens.DecksListActivity.onCreate.12
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Integer numValueOf = tab != null ? Integer.valueOf(tab.getPosition()) : null;
                if (numValueOf != null && numValueOf.intValue() == 2) {
                    DecksListActivity.this.isArchiveTab = true;
                    linearLayout.setVisibility(8);
                    DecksListActivity.this.loadArchivedDecks();
                } else {
                    DecksListActivity.this.isArchiveTab = false;
                    DecksListActivity.this.currentDeckType = tab != null ? tab.getPosition() : 0;
                    linearLayout.setVisibility(0);
                    DecksListActivity decksListActivity2 = DecksListActivity.this;
                    decksListActivity2.updateDecks(decksListActivity2.decks);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        if (currentUser != null) {
            MTApiKt.getMtApi().getDecks(currentUser.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onCreate$13$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        DecksListActivity decksListActivity2 = this.this$0;
                        preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                        preferencesManager2.saveCurrentUserDecks(decks);
                        decksListActivity2.updateDecks(decks);
                    }
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreated(List<MTDeck> decks) {
        if (decks != null) {
            this.decks = decks;
            PreferencesManager preferencesManager = new PreferencesManager(this);
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
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getResources().getString(R.string.delete_deck_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder showRestoreCheckBox = title.setBody(string2).setPositiveButtonRed().setShowRestoreCheckBox(true);
        String string3 = getResources().getString(R.string.archive_deck_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = showRestoreCheckBox.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DecksListActivity.onDeckDelete$lambda$0(this.f$0, deck, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecksListActivity.onDeckDelete$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "CustomDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckEdit(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser != null) {
            CreateDeckBottomSheetFragment.INSTANCE.newInstance(this, this.searchActivityLauncher, this.pickCardLauncher, currentUser, deck).show(getSupportFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckEdited(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
        List<MTDeck> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserDecks());
        Iterator<MTDeck> it = mutableList.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().getId() == deck.getId()) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            mutableList.set(i2, deck);
            preferencesManager.saveCurrentUserDecks(mutableList);
        }
        List<MTDeck> mutableList2 = CollectionsKt.toMutableList((Collection) this.decks);
        Iterator<MTDeck> it2 = mutableList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (it2.next().getId() == deck.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            mutableList2.set(i, deck);
        }
        updateDecks(mutableList2);
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckFullDelete(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.full_delete_deck_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        title.setBody(string2).setShowRestoreCheckBox(true).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DecksListActivity.onDeckFullDelete$lambda$0(this.f$0, deck, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecksListActivity.onDeckFullDelete$lambda$1((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getSupportFragmentManager(), "CustomDeleteDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckRestore(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().restoreDeck(currentUser.getId(), deck.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$onDeckRestore$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    constraintLayout.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    constraintLayout.setVisibility(8);
                    if (!response.isSuccessful() || this.isFinishing() || this.isDestroyed()) {
                        return;
                    }
                    List<MTDeck> currentUserArchivedDecks = preferencesManager.getCurrentUserArchivedDecks();
                    MTDeck mTDeck = deck;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : currentUserArchivedDecks) {
                        if (((MTDeck) obj).getId() != mTDeck.getId()) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    preferencesManager.saveCurrentUserArchivedDecks(arrayList2);
                    this.archivedDecks = arrayList2;
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    preferencesManager.saveCurrentUserDecks(decks == null ? CollectionsKt.emptyList() : decks);
                    preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                    DecksListActivity decksListActivity = this;
                    if (decks == null) {
                        decks = CollectionsKt.emptyList();
                    }
                    decksListActivity.decks = decks;
                    if (this.isArchiveTab) {
                        this.updateDecks(null);
                    }
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckSelected(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        Intent intent = new Intent(this, (Class<?>) DeckDetailsActivity.class);
        intent.putExtra("deckId", deck.getId());
        this.deckActivityLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckTemporary(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (isFinishing() || isDestroyed()) {
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
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DecksListActivity.onDeckTemporary$lambda$0(this.f$0, deck, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.discard_button);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksListActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecksListActivity.onDeckTemporary$lambda$1(this.f$0, deck, (CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "temp_deck_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onGhostDeckCreated(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PreferencesManager preferencesManager = new PreferencesManager(this);
        if (!preferencesManager.getBoolean(PreferencesManager.NEED_USER_RELOAD, false) || preferencesManager.getCurrentUser() == null) {
            return;
        }
        List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
        this.decks = currentUserDecks;
        updateDecks(currentUserDecks);
    }
}
