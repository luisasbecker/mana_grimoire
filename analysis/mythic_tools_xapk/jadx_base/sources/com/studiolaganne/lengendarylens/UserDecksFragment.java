package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.databinding.FragmentUserDecksBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: UserDecksFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserDecksFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentUserDecksBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentUserDecksBinding;", "isCurrentUser", "", "userId", "", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "formatsForFilter", "Lcom/studiolaganne/lengendarylens/MTFormat;", "filterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "onDeckRestore", "", "deck", "onDeckEdit", "onDeckTemporary", "onDeckSelected", "onDeckDelete", "onDeckFullDelete", "updateDecks", "decklist", "updateFilter", "filter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserDecksFragment extends Fragment implements DecksListClickListener {
    private FragmentUserDecksBinding _binding;
    private MTUser currentUser;
    private boolean isCurrentUser;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int userId = -1;
    private List<MTDeck> decks = CollectionsKt.emptyList();
    private List<MTFormat> formatsForFilter = CollectionsKt.emptyList();
    private FilterDefinition filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);

    /* JADX INFO: compiled from: UserDecksFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserDecksFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/UserGamesFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserGamesFragment newInstance() {
            UserGamesFragment userGamesFragment = new UserGamesFragment();
            userGamesFragment.setArguments(new Bundle());
            return userGamesFragment;
        }
    }

    @JvmStatic
    public static final UserGamesFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecks(List<MTDeck> decklist) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (decklist == null) {
            decklist = CollectionsKt.emptyList();
        }
        this.decks = decklist;
        RecyclerView decksRecyclerView = getBinding().decksRecyclerView;
        Intrinsics.checkNotNullExpressionValue(decksRecyclerView, "decksRecyclerView");
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<MTFormat> formats = companion.getInstance(contextRequireContext).getFormats();
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
        MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        MTGDBHelper companion3 = companion2.getInstance(contextRequireContext2);
        ArrayList arrayList2 = new ArrayList();
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        for (String str : new PreferencesManager(contextRequireContext3).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                arrayList2.add(companion4.getInstance(contextRequireContext4, str));
            }
        }
        decksRecyclerView.setAdapter(new DecksListAdapter(this.decks, formats, companion3, arrayList2, this, true));
        TextView noDecksText = getBinding().noDecksText;
        Intrinsics.checkNotNullExpressionValue(noDecksText, "noDecksText");
        noDecksText.setVisibility(this.decks.isEmpty() ? 0 : 8);
    }

    public final FragmentUserDecksBinding getBinding() {
        FragmentUserDecksBinding fragmentUserDecksBinding = this._binding;
        Intrinsics.checkNotNull(fragmentUserDecksBinding);
        return fragmentUserDecksBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.userId = arguments.getInt("userId");
            this.isCurrentUser = false;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser != null) {
                this.currentUser = currentUser;
                if (currentUser.getId() == this.userId) {
                    this.isCurrentUser = true;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentUserDecksBinding.inflate(inflater, container, false);
        getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List mutableList = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext).getFormats());
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            MTFormat mTFormat = (MTFormat) obj;
            List<MTDeck> list = this.decks;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((MTDeck) it.next()).getFormatid() == mTFormat.getId()) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        this.formatsForFilter = CollectionsKt.toMutableList((Collection) arrayList);
        getBinding().decksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MTUser mTUser = this.currentUser;
        if (mTUser != null) {
            getBinding().noDecksText.setVisibility(8);
            MTApiKt.getMtApi().getUserDecksWithPrivacy(mTUser.getId(), this.userId).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.UserDecksFragment$onCreateView$2$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                    this.this$0.getBinding().noDecksText.setVisibility(0);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                    if (response.isSuccessful()) {
                        MTDecksResponse mTDecksResponseBody = response.body();
                        List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                        if (decks != null) {
                            UserDecksFragment userDecksFragment = this.this$0;
                            userDecksFragment.decks = decks;
                            if (userDecksFragment.filterDefinition.getFormatId() == null) {
                                userDecksFragment.updateDecks(decks);
                            } else {
                                userDecksFragment.updateFilter(userDecksFragment.filterDefinition);
                            }
                        }
                    }
                }
            });
        }
        return getBinding().getRoot();
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
    public void onDeckFullDelete(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckRestore(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckSelected(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null) {
            return;
        }
        if (this.isCurrentUser) {
            Intent intent = new Intent(requireContext(), (Class<?>) DeckDetailsActivity.class);
            intent.putExtra("deckId", deck.getId());
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(requireContext(), (Class<?>) DeckDetailsActivity.class);
            intent2.putExtra("deckId", deck.getId());
            intent2.putExtra("otherUserId", this.userId);
            intent2.putExtra("otherUserDeck", new Gson().toJson(deck));
            startActivity(intent2);
        }
    }

    @Override // com.studiolaganne.lengendarylens.DecksListClickListener
    public void onDeckTemporary(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    public final void updateFilter(FilterDefinition filter) {
        Unit unit;
        Object next;
        Intrinsics.checkNotNullParameter(filter, "filter");
        Integer formatId = filter.getFormatId();
        if (formatId != null) {
            int iIntValue = formatId.intValue();
            Iterator<T> it = this.formatsForFilter.iterator();
            while (true) {
                unit = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (((MTFormat) next).getId() == iIntValue) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            if (mTFormat != null) {
                if (getContext() != null) {
                    List<MTDeck> list = this.decks;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((MTDeck) obj).getFormatid() == mTFormat.getId()) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    RecyclerView decksRecyclerView = getBinding().decksRecyclerView;
                    Intrinsics.checkNotNullExpressionValue(decksRecyclerView, "decksRecyclerView");
                    DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                    Context contextRequireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    List<MTFormat> formats = companion.getInstance(contextRequireContext).getFormats();
                    MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
                    Context contextRequireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    MTGDBHelper companion3 = companion2.getInstance(contextRequireContext2);
                    ArrayList arrayList3 = new ArrayList();
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                    for (String str : new PreferencesManager(contextRequireContext3).getEnabledLanguages()) {
                        if (!Intrinsics.areEqual(str, "en")) {
                            MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                            Context contextRequireContext4 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                            arrayList3.add(companion4.getInstance(contextRequireContext4, str));
                        }
                    }
                    TextView noDecksText = getBinding().noDecksText;
                    Intrinsics.checkNotNullExpressionValue(noDecksText, "noDecksText");
                    noDecksText.setVisibility(arrayList2.isEmpty() ? 0 : 8);
                    decksRecyclerView.setAdapter(new DecksListAdapter(arrayList2, formats, companion3, arrayList3, this, true));
                }
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
        }
        updateDecks(this.decks);
    }
}
