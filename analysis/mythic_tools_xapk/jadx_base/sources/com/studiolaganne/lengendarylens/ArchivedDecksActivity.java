package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ArchivedDecksActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/ArchivedDecksActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "<init>", "()V", "archivedDecks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "currentSearchQuery", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "loadArchivedDecks", "updateDecks", "onDeckRestore", "deck", "onDeckFullDelete", "onDeckSelected", "onDeckDelete", "onDeckEdit", "onDeckTemporary", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArchivedDecksActivity extends BaseActivity implements DecksListClickListener {
    public static final int $stable = 8;
    private List<MTDeck> archivedDecks = CollectionsKt.emptyList();
    private String currentSearchQuery = "";

    private final void loadArchivedDecks() {
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        constraintLayout.setVisibility(0);
        if (currentUser != null) {
            MTApiKt.getMtApi().getUserArchivedDecks(currentUser.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$loadArchivedDecks$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    constraintLayout.setVisibility(8);
                    Log.e("ArchivedDecksActivity", "Failed to load archived decks", t);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    constraintLayout.setVisibility(8);
                    if (!response.isSuccessful() || this.isDestroyed() || this.isFinishing()) {
                        return;
                    }
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        ArchivedDecksActivity archivedDecksActivity = this;
                        PreferencesManager preferencesManager2 = preferencesManager;
                        archivedDecksActivity.archivedDecks = decks;
                        preferencesManager2.saveCurrentUserArchivedDecks(decks);
                        archivedDecksActivity.updateDecks();
                    }
                }
            });
        } else {
            constraintLayout.setVisibility(8);
        }
    }

    static final Unit onCreate$lambda$0(ArchivedDecksActivity archivedDecksActivity) {
        archivedDecksActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(EditText editText) {
        editText.getText().clear();
        return Unit.INSTANCE;
    }

    static final Unit onDeckFullDelete$lambda$0(ArchivedDecksActivity archivedDecksActivity, MTDeck mTDeck, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(archivedDecksActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) archivedDecksActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().fullDeleteDeck(currentUser.getId(), mTDeck.getId(), Boolean.valueOf(z)).enqueue(new ArchivedDecksActivity$onDeckFullDelete$dialog$1$1$1(constraintLayout, archivedDecksActivity, preferencesManager, mTDeck));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckFullDelete$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecks() {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        boolean zIsBlank = StringsKt.isBlank(this.currentSearchQuery);
        ArrayList arrayList = this.archivedDecks;
        if (!zIsBlank) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (StringsKt.contains((CharSequence) ((MTDeck) obj).getName(), (CharSequence) this.currentSearchQuery, true)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$updateDecks$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTDeck) t).getName(), ((MTDeck) t2).getName());
            }
        });
        View viewFindViewById = findViewById(R.id.noDecksText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((TextView) viewFindViewById).setVisibility(listSortedWith.isEmpty() ? 0 : 8);
        View viewFindViewById2 = findViewById(R.id.decksRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        ArchivedDecksActivity archivedDecksActivity = this;
        MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(archivedDecksActivity);
        ArrayList arrayList3 = new ArrayList();
        for (String str : new PreferencesManager(archivedDecksActivity).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                arrayList3.add(MTGDBHelperLocalized.INSTANCE.getInstance(archivedDecksActivity, str));
            }
        }
        recyclerView.setAdapter(new DecksListAdapter(listSortedWith, DecksDBHelper.INSTANCE.getInstance(archivedDecksActivity).getFormats(), companion, arrayList3, this, false));
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archived_decks);
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchivedDecksActivity.onCreate$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.filterEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final EditText editText = (EditText) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.clearFilterButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final ImageView imageView = (ImageView) viewFindViewById3;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity.onCreate.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string;
                ArchivedDecksActivity archivedDecksActivity = ArchivedDecksActivity.this;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                archivedDecksActivity.currentSearchQuery = string;
                Editable editable = s;
                imageView.setVisibility((editable == null || editable.length() == 0) ? 8 : 0);
                ArchivedDecksActivity.this.updateDecks();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchivedDecksActivity.onCreate$lambda$1(editText);
            }
        });
        View viewFindViewById4 = findViewById(R.id.decksRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ((RecyclerView) viewFindViewById4).setLayoutManager(new LinearLayoutManager(this));
        loadArchivedDecks();
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckDelete(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckEdit(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
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
        title.setBody(string2).setShowRestoreCheckBox(true).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ArchivedDecksActivity.onDeckFullDelete$lambda$0(this.f$0, deck, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchivedDecksActivity.onDeckFullDelete$lambda$1((CustomDeleteDialogFragment) obj);
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
            MTApiKt.getMtApi().restoreDeck(currentUser.getId(), deck.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$onDeckRestore$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    constraintLayout.setVisibility(8);
                    Log.e("ArchivedDecksActivity", "Failed to restore deck", t);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    constraintLayout.setVisibility(8);
                    if (!response.isSuccessful() || this.isFinishing() || this.isDestroyed()) {
                        return;
                    }
                    ArchivedDecksActivity archivedDecksActivity = this;
                    List list = archivedDecksActivity.archivedDecks;
                    MTDeck mTDeck = deck;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((MTDeck) obj).getId() != mTDeck.getId()) {
                            arrayList.add(obj);
                        }
                    }
                    archivedDecksActivity.archivedDecks = arrayList;
                    preferencesManager.saveCurrentUserArchivedDecks(this.archivedDecks);
                    MTDecksResponse mTDecksResponseBody = response.body();
                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                    if (decks != null) {
                        preferencesManager.saveCurrentUserDecks(decks);
                    }
                    preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                    this.updateDecks();
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckSelected(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckTemporary(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }
}
