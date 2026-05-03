package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.ContainerAdapter;
import com.studiolaganne.lengendarylens.DeckAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 22\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020 2\u0006\u0010/\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/MoveCardDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "addMode", "", "collection", "Lcom/studiolaganne/lengendarylens/MTCollection;", "lists", "Lcom/studiolaganne/lengendarylens/MTUserLists;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/MoveCardDialogListener;", "applyToQty", "", "containerAdapter", "Lcom/studiolaganne/lengendarylens/ContainerAdapter;", "deckAdapter", "Lcom/studiolaganne/lengendarylens/DeckAdapter;", "selectedContainerId", "selectedDeck", "selectedDeckListId", "isCreatingNewContainer", "currentTabIndex", "fetchedDeckListIds", "", "isFetchingDeckInfo", "onStart", "", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "updateContainersList", "updateDecksList", "fetchDeckInfo", "deck", "updateDeckListRadioButtons", "Builder", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MoveCardDialogFragment extends DialogFragment {
    public static final String TAG = "MoveCardDialogFragment";
    private boolean addMode;
    private MTFullCard card;
    private MTCollection collection;
    private ContainerAdapter containerAdapter;
    private int currentTabIndex;
    private DeckAdapter deckAdapter;
    private List<MTDeck> decks;
    private boolean isCreatingNewContainer;
    private boolean isFetchingDeckInfo;
    private MoveCardDialogListener listener;
    private MTUserLists lists;
    private MTDeck selectedDeck;
    public static final int $stable = 8;
    private int applyToQty = 1;
    private int selectedContainerId = -1;
    private int selectedDeckListId = -1;
    private final Map<Integer, MTDeck> fetchedDeckListIds = new LinkedHashMap();

    /* JADX INFO: compiled from: MoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MoveCardDialogFragment$Builder;", "", "<init>", "()V", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "collection", "Lcom/studiolaganne/lengendarylens/MTCollection;", "lists", "Lcom/studiolaganne/lengendarylens/MTUserLists;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "addMode", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/MoveCardDialogListener;", "setCard", "setAddMode", "setCollection", "setLists", "setDecks", InAppPurchaseConstants.METHOD_SET_LISTENER, "build", "Lcom/studiolaganne/lengendarylens/MoveCardDialogFragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean addMode;
        private MTFullCard card;
        private MTCollection collection;
        private List<MTDeck> decks;
        private MoveCardDialogListener listener;
        private MTUserLists lists;

        public final MoveCardDialogFragment build() {
            MoveCardDialogFragment moveCardDialogFragment = new MoveCardDialogFragment();
            moveCardDialogFragment.card = this.card;
            moveCardDialogFragment.addMode = this.addMode;
            moveCardDialogFragment.collection = this.collection;
            moveCardDialogFragment.lists = this.lists;
            moveCardDialogFragment.decks = this.decks;
            moveCardDialogFragment.listener = this.listener;
            return moveCardDialogFragment;
        }

        public final Builder setAddMode(boolean addMode) {
            this.addMode = addMode;
            return this;
        }

        public final Builder setCard(MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.card = card;
            return this;
        }

        public final Builder setCollection(MTCollection collection) {
            Intrinsics.checkNotNullParameter(collection, "collection");
            this.collection = collection;
            return this;
        }

        public final Builder setDecks(List<MTDeck> decks) {
            Intrinsics.checkNotNullParameter(decks, "decks");
            this.decks = decks;
            return this;
        }

        public final Builder setListener(MoveCardDialogListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder setLists(MTUserLists lists) {
            Intrinsics.checkNotNullParameter(lists, "lists");
            this.lists = lists;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchDeckInfo(final MTDeck deck) {
        final View view;
        final Context context;
        if (this.isFetchingDeckInfo || (view = getView()) == null || (context = getContext()) == null) {
            return;
        }
        this.isFetchingDeckInfo = true;
        View viewFindViewById = view.findViewById(R.id.deckLoadingLayout);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        View viewFindViewById2 = view.findViewById(R.id.deckListSelectionLayout);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        final View viewFindViewById3 = view.findViewById(R.id.moveButtonLayout);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setEnabled(false);
        }
        if (viewFindViewById3 != null) {
            viewFindViewById3.setAlpha(0.5f);
        }
        final PreferencesManager preferencesManager = new PreferencesManager(context);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApi.getUserDeckById$default(MTApiKt.getMtApi(), currentUser.getId(), currentUser.getId(), deck.getId(), null, null, null, null, null, null, null, null, null, 4088, null).enqueue(new Callback<MTDeckResponse>() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment.fetchDeckInfo.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDeckResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    MoveCardDialogFragment.this.isFetchingDeckInfo = false;
                    if (MoveCardDialogFragment.this.getActivity() == null || MoveCardDialogFragment.this.getView() == null) {
                        return;
                    }
                    View viewFindViewById4 = view.findViewById(R.id.deckLoadingLayout);
                    if (viewFindViewById4 != null) {
                        viewFindViewById4.setVisibility(8);
                    }
                    View view2 = viewFindViewById3;
                    if (view2 != null) {
                        view2.setEnabled(true);
                    }
                    View view3 = viewFindViewById3;
                    if (view3 != null) {
                        view3.setAlpha(1.0f);
                    }
                    Toast.makeText(context, R.string.error_loading_deck_info, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDeckResponse> call, Response<MTDeckResponse> response) {
                    MTCardContainer maybeboard;
                    MTCardContainer sideboard;
                    MTCardContainer main;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    int i = 0;
                    MoveCardDialogFragment.this.isFetchingDeckInfo = false;
                    if (MoveCardDialogFragment.this.getActivity() == null || MoveCardDialogFragment.this.getView() == null) {
                        return;
                    }
                    View viewFindViewById4 = view.findViewById(R.id.deckLoadingLayout);
                    if (viewFindViewById4 != null) {
                        viewFindViewById4.setVisibility(8);
                    }
                    View view2 = viewFindViewById3;
                    if (view2 != null) {
                        view2.setEnabled(true);
                    }
                    View view3 = viewFindViewById3;
                    if (view3 != null) {
                        view3.setAlpha(1.0f);
                    }
                    if (!response.isSuccessful()) {
                        Toast.makeText(context, R.string.error_loading_deck_info, 0).show();
                        return;
                    }
                    MTDeckResponse mTDeckResponseBody = response.body();
                    MTDeck deck2 = mTDeckResponseBody != null ? mTDeckResponseBody.getDeck() : null;
                    MTDeckLists lists = mTDeckResponseBody != null ? mTDeckResponseBody.getLists() : null;
                    if (deck2 != null) {
                        MTDeck mTDeckCopy$default = MTDeck.copy$default(deck, 0, 0, null, 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (lists == null || (main = lists.getMain()) == null) ? deck2.getListid() : Integer.valueOf(main.getId()), (lists == null || (maybeboard = lists.getMaybeboard()) == null) ? deck2.getMaybeboardlistid() : Integer.valueOf(maybeboard.getId()), (lists == null || (sideboard = lists.getSideboard()) == null) ? deck2.getSideboardlistid() : Integer.valueOf(sideboard.getId()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -7340033, 2047, null);
                        MoveCardDialogFragment.this.fetchedDeckListIds.put(Integer.valueOf(deck.getId()), mTDeckCopy$default);
                        List<MTDeck> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserDecks());
                        MTDeck mTDeck = deck;
                        Iterator<MTDeck> it = mutableList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            } else if (it.next().getId() == mTDeck.getId()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            mutableList.set(i, mTDeckCopy$default);
                            preferencesManager.saveCurrentUserDecks(mutableList);
                        }
                        MoveCardDialogFragment.this.selectedDeck = mTDeckCopy$default;
                        MoveCardDialogFragment.this.updateDeckListRadioButtons(mTDeckCopy$default);
                    }
                }
            });
            return;
        }
        this.isFetchingDeckInfo = false;
        View viewFindViewById4 = view.findViewById(R.id.deckLoadingLayout);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setVisibility(8);
        }
    }

    static final Unit onCreateView$lambda$2(MoveCardDialogFragment moveCardDialogFragment, TextView textView, TextView textView2) {
        int i = moveCardDialogFragment.applyToQty;
        if (i > 1) {
            moveCardDialogFragment.applyToQty = i - 1;
        }
        textView.setText(String.valueOf(moveCardDialogFragment.applyToQty));
        if (moveCardDialogFragment.applyToQty == 1) {
            textView2.setText(moveCardDialogFragment.getResources().getString(R.string.cards_singular));
        } else {
            textView2.setText(moveCardDialogFragment.getResources().getString(R.string.cards_plural));
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(MoveCardDialogFragment moveCardDialogFragment, TextView textView, TextView textView2) {
        Integer quantity;
        MTFullCard mTFullCard = moveCardDialogFragment.card;
        int iIntValue = (mTFullCard == null || (quantity = mTFullCard.getQuantity()) == null) ? 1 : quantity.intValue();
        int i = moveCardDialogFragment.applyToQty;
        if (i < iIntValue) {
            int i2 = i + 1;
            moveCardDialogFragment.applyToQty = i2;
            textView.setText(String.valueOf(i2));
            if (moveCardDialogFragment.applyToQty == 1) {
                textView2.setText(moveCardDialogFragment.getResources().getString(R.string.cards_singular));
            } else {
                textView2.setText(moveCardDialogFragment.getResources().getString(R.string.cards_plural));
            }
        }
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$4(View view, MoveCardDialogFragment moveCardDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            ((TextInputLayout) view.findViewById(R.id.newContainerInputLayout)).setHint(moveCardDialogFragment.getString(R.string.new_container_name));
        }
    }

    static final void onCreateView$lambda$5(View view, MoveCardDialogFragment moveCardDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            ((TextInputLayout) view.findViewById(R.id.newContainerInputLayout)).setHint(moveCardDialogFragment.getString(R.string.new_container_name));
        }
    }

    static final Unit onCreateView$lambda$6(MoveCardDialogFragment moveCardDialogFragment) {
        MoveCardDialogListener moveCardDialogListener = moveCardDialogFragment.listener;
        if (moveCardDialogListener != null) {
            moveCardDialogListener.onCancelMoveCard();
        }
        moveCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(MoveCardDialogFragment moveCardDialogFragment, View view) {
        int i = 2;
        if (moveCardDialogFragment.currentTabIndex == 2) {
            int i2 = moveCardDialogFragment.selectedDeckListId;
            if (i2 != -1) {
                MoveCardDialogListener moveCardDialogListener = moveCardDialogFragment.listener;
                if (moveCardDialogListener != null) {
                    moveCardDialogListener.onMoveCard(i2, moveCardDialogFragment.applyToQty, false, null, null);
                }
                moveCardDialogFragment.dismiss();
            }
        } else if (moveCardDialogFragment.isCreatingNewContainer) {
            String strValueOf = String.valueOf(((TextInputEditText) view.findViewById(R.id.newContainerEditText)).getText());
            if (strValueOf.length() > 0) {
                if (moveCardDialogFragment.currentTabIndex != 0) {
                    i = 0;
                } else if (!((RadioButton) view.findViewById(R.id.boxRadioButton)).isChecked()) {
                    i = 1;
                }
                MoveCardDialogListener moveCardDialogListener2 = moveCardDialogFragment.listener;
                if (moveCardDialogListener2 != null) {
                    moveCardDialogListener2.onMoveCard(-1, moveCardDialogFragment.applyToQty, true, strValueOf, Integer.valueOf(i));
                }
                moveCardDialogFragment.dismiss();
            }
        } else {
            int i3 = moveCardDialogFragment.selectedContainerId;
            if (i3 != -1) {
                MoveCardDialogListener moveCardDialogListener3 = moveCardDialogFragment.listener;
                if (moveCardDialogListener3 != null) {
                    moveCardDialogListener3.onMoveCard(i3, moveCardDialogFragment.applyToQty, false, null, null);
                }
                moveCardDialogFragment.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContainersList() {
        List<MTCardContainer> user;
        List<MTCardContainer> global;
        View viewFindViewById;
        List<MTCardContainer> binders;
        List<MTCardContainer> boxes;
        ArrayList arrayList = new ArrayList();
        if (this.currentTabIndex == 0) {
            MTCollection mTCollection = this.collection;
            if (mTCollection != null && (boxes = mTCollection.getBoxes()) != null) {
                for (MTCardContainer mTCardContainer : boxes) {
                    String name = mTCardContainer.getName();
                    if (mTCardContainer.getId() == 4) {
                        name = getString(R.string.list_bulk);
                        Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                    }
                    int id = mTCardContainer.getId();
                    Integer type = mTCardContainer.getType();
                    arrayList.add(new ContainerItem(id, name, type != null ? type.intValue() : 2));
                }
            }
            MTCollection mTCollection2 = this.collection;
            if (mTCollection2 != null && (binders = mTCollection2.getBinders()) != null) {
                for (MTCardContainer mTCardContainer2 : binders) {
                    int id2 = mTCardContainer2.getId();
                    String name2 = mTCardContainer2.getName();
                    Integer type2 = mTCardContainer2.getType();
                    arrayList.add(new ContainerItem(id2, name2, type2 != null ? type2.intValue() : 1));
                }
            }
        } else {
            MTUserLists mTUserLists = this.lists;
            if (mTUserLists != null && (global = mTUserLists.getGlobal()) != null) {
                for (MTCardContainer mTCardContainer3 : global) {
                    if (mTCardContainer3.getId() != 1) {
                        String name3 = mTCardContainer3.getName();
                        if (mTCardContainer3.getId() == 2) {
                            name3 = getString(R.string.list_wants);
                            Intrinsics.checkNotNullExpressionValue(name3, "getString(...)");
                        }
                        if (mTCardContainer3.getId() == 3) {
                            name3 = getString(R.string.list_trade);
                            Intrinsics.checkNotNullExpressionValue(name3, "getString(...)");
                        }
                        int id3 = mTCardContainer3.getId();
                        Integer type3 = mTCardContainer3.getType();
                        arrayList.add(new ContainerItem(id3, name3, type3 != null ? type3.intValue() : 0));
                    }
                }
            }
            MTUserLists mTUserLists2 = this.lists;
            if (mTUserLists2 != null && (user = mTUserLists2.getUser()) != null) {
                for (MTCardContainer mTCardContainer4 : user) {
                    int id4 = mTCardContainer4.getId();
                    String name4 = mTCardContainer4.getName();
                    Integer type4 = mTCardContainer4.getType();
                    arrayList.add(new ContainerItem(id4, name4, type4 != null ? type4.intValue() : 0));
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$updateContainersList$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((ContainerItem) t).getName(), ((ContainerItem) t2).getName());
                }
            });
        }
        this.selectedContainerId = -1;
        this.isCreatingNewContainer = false;
        View view = getView();
        if (view != null && (viewFindViewById = view.findViewById(R.id.newContainerLayout)) != null) {
            viewFindViewById.setVisibility(8);
        }
        ContainerAdapter containerAdapter = this.containerAdapter;
        if (containerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerAdapter");
            containerAdapter = null;
        }
        containerAdapter.updateData(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateDeckListRadioButtons(final MTDeck deck) {
        View viewFindViewById;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioGroup radioGroup;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(R.id.deckListSelectionLayout)) == null || (radioButton = (RadioButton) view.findViewById(R.id.mainDeckRadioButton)) == null || (radioButton2 = (RadioButton) view.findViewById(R.id.sideboardRadioButton)) == null || (radioButton3 = (RadioButton) view.findViewById(R.id.maybeboardRadioButton)) == null || (radioGroup = (RadioGroup) view.findViewById(R.id.deckListRadioGroup)) == null) {
            return;
        }
        radioGroup.clearCheck();
        this.selectedDeckListId = -1;
        if (deck.getListid() != null) {
            Integer listid = deck.getListid();
            Intrinsics.checkNotNull(listid);
            z = listid.intValue() > 0;
        }
        if (deck.getSideboardlistid() != null) {
            Integer sideboardlistid = deck.getSideboardlistid();
            Intrinsics.checkNotNull(sideboardlistid);
            z2 = sideboardlistid.intValue() > 0;
        }
        if (deck.getMaybeboardlistid() != null) {
            Integer maybeboardlistid = deck.getMaybeboardlistid();
            Intrinsics.checkNotNull(maybeboardlistid);
            z3 = maybeboardlistid.intValue() > 0;
        }
        if (z) {
            radioButton.setVisibility(0);
            z4 = true;
        } else {
            radioButton.setVisibility(8);
            z4 = false;
        }
        if (z2) {
            radioButton2.setVisibility(0);
            z4 = true;
        } else {
            radioButton2.setVisibility(8);
        }
        if (z3) {
            radioButton3.setVisibility(0);
            z4 = true;
        } else {
            radioButton3.setVisibility(8);
        }
        if (!z4) {
            viewFindViewById.setVisibility(8);
            return;
        }
        viewFindViewById.setVisibility(0);
        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoveCardDialogFragment.updateDeckListRadioButtons$lambda$0(this.f$0, deck, view2);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoveCardDialogFragment.updateDeckListRadioButtons$lambda$1(this.f$0, deck, view2);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoveCardDialogFragment.updateDeckListRadioButtons$lambda$2(this.f$0, deck, view2);
            }
        });
        if (z) {
            radioButton.setChecked(true);
            Integer listid2 = deck.getListid();
            Intrinsics.checkNotNull(listid2);
            this.selectedDeckListId = listid2.intValue();
            return;
        }
        if (z2) {
            radioButton2.setChecked(true);
            Integer sideboardlistid2 = deck.getSideboardlistid();
            Intrinsics.checkNotNull(sideboardlistid2);
            this.selectedDeckListId = sideboardlistid2.intValue();
            return;
        }
        if (z3) {
            radioButton3.setChecked(true);
            Integer maybeboardlistid2 = deck.getMaybeboardlistid();
            Intrinsics.checkNotNull(maybeboardlistid2);
            this.selectedDeckListId = maybeboardlistid2.intValue();
        }
    }

    static final void updateDeckListRadioButtons$lambda$0(MoveCardDialogFragment moveCardDialogFragment, MTDeck mTDeck, View view) {
        Integer listid = mTDeck.getListid();
        moveCardDialogFragment.selectedDeckListId = listid != null ? listid.intValue() : -1;
    }

    static final void updateDeckListRadioButtons$lambda$1(MoveCardDialogFragment moveCardDialogFragment, MTDeck mTDeck, View view) {
        Integer sideboardlistid = mTDeck.getSideboardlistid();
        moveCardDialogFragment.selectedDeckListId = sideboardlistid != null ? sideboardlistid.intValue() : -1;
    }

    static final void updateDeckListRadioButtons$lambda$2(MoveCardDialogFragment moveCardDialogFragment, MTDeck mTDeck, View view) {
        Integer maybeboardlistid = mTDeck.getMaybeboardlistid();
        moveCardDialogFragment.selectedDeckListId = maybeboardlistid != null ? maybeboardlistid.intValue() : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecksList() {
        View viewFindViewById;
        ArrayList arrayList = new ArrayList();
        List<MTDeck> list = this.decks;
        if (list != null) {
            for (MTDeck mTDeck : list) {
                if (!Intrinsics.areEqual((Object) mTDeck.getActive(), (Object) false)) {
                    arrayList.add(new DeckItem(mTDeck.getId(), mTDeck.getName(), mTDeck));
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$updateDecksList$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((DeckItem) t).getName(), ((DeckItem) t2).getName());
                }
            });
        }
        DeckAdapter deckAdapter = null;
        this.selectedDeck = null;
        this.selectedDeckListId = -1;
        View view = getView();
        if (view != null && (viewFindViewById = view.findViewById(R.id.deckListSelectionLayout)) != null) {
            viewFindViewById.setVisibility(8);
        }
        DeckAdapter deckAdapter2 = this.deckAdapter;
        if (deckAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deckAdapter");
        } else {
            deckAdapter = deckAdapter2;
        }
        deckAdapter.updateData(arrayList);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        MoveCardDialogListener moveCardDialogListener = this.listener;
        if (moveCardDialogListener != null) {
            moveCardDialogListener.onCancelMoveCard();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Integer quantity;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View viewInflate = inflater.inflate(R.layout.move_card_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.dialogTitleTextView);
        MTFullCard mTFullCard = this.card;
        int iIntValue = 1;
        if (mTFullCard != null) {
            String string = getString(R.string.move_card_to);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String name = mTFullCard.getName();
            textView.setText(StringsKt.replace$default(string, "{1}", name == null ? "" : name, false, 4, (Object) null));
            if (this.addMode) {
                String string2 = getString(R.string.add_card_to);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String name2 = mTFullCard.getName();
                textView.setText(StringsKt.replace$default(string2, "{1}", name2 == null ? "" : name2, false, 4, (Object) null));
            }
            Integer quantity2 = mTFullCard.getQuantity();
            int iIntValue2 = quantity2 != null ? quantity2.intValue() : 1;
            this.applyToQty = iIntValue2;
            if (iIntValue2 > 1) {
                View viewFindViewById = viewInflate.findViewById(R.id.applyLayout);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                ((LinearLayout) viewFindViewById).setVisibility(0);
            }
        } else {
            textView.setText(getString(R.string.move_card));
            if (this.addMode) {
                textView.setText(getString(R.string.add_cards_to_list));
            }
            this.applyToQty = 1;
        }
        View viewFindViewById2 = viewInflate.findViewById(R.id.applyValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.minusApplyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.plusApplyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView4 = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.applyFooter);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final TextView textView5 = (TextView) viewFindViewById5;
        MTFullCard mTFullCard2 = this.card;
        if (mTFullCard2 != null && (quantity = mTFullCard2.getQuantity()) != null) {
            iIntValue = quantity.intValue();
        }
        textView2.setText(String.valueOf(iIntValue));
        ViewExtensionsKt.setOnClickWithFade(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MoveCardDialogFragment.onCreateView$lambda$2(this.f$0, textView2, textView5);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView4, new Function0() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MoveCardDialogFragment.onCreateView$lambda$3(this.f$0, textView2, textView5);
            }
        });
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(R.id.tabLayout);
        if (!this.addMode || this.decks == null) {
            tabLayout.removeTabAt(2);
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment.onCreateView.5
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                MoveCardDialogFragment.this.currentTabIndex = tab != null ? tab.getPosition() : 0;
                int i = MoveCardDialogFragment.this.currentTabIndex;
                if (i == 0) {
                    viewInflate.findViewById(R.id.containersRecyclerView).setVisibility(0);
                    viewInflate.findViewById(R.id.decksRecyclerView).setVisibility(8);
                    viewInflate.findViewById(R.id.deckListSelectionLayout).setVisibility(8);
                    MoveCardDialogFragment.this.updateContainersList();
                    return;
                }
                if (i == 1) {
                    viewInflate.findViewById(R.id.containersRecyclerView).setVisibility(0);
                    viewInflate.findViewById(R.id.decksRecyclerView).setVisibility(8);
                    viewInflate.findViewById(R.id.deckListSelectionLayout).setVisibility(8);
                    MoveCardDialogFragment.this.updateContainersList();
                    return;
                }
                if (i != 2) {
                    return;
                }
                viewInflate.findViewById(R.id.containersRecyclerView).setVisibility(8);
                viewInflate.findViewById(R.id.decksRecyclerView).setVisibility(0);
                viewInflate.findViewById(R.id.deckListSelectionLayout).setVisibility(8);
                viewInflate.findViewById(R.id.newContainerLayout).setVisibility(8);
                MoveCardDialogFragment.this.updateDecksList();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.containersRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        ContainerAdapter containerAdapter = new ContainerAdapter(new ArrayList(), new ContainerAdapter.ContainerSelectionListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment.onCreateView.6
            @Override // com.studiolaganne.lengendarylens.ContainerAdapter.ContainerSelectionListener
            public void onContainerSelected(int containerId) {
                MoveCardDialogFragment.this.selectedContainerId = containerId;
                MoveCardDialogFragment.this.isCreatingNewContainer = false;
                viewInflate.findViewById(R.id.newContainerLayout).setVisibility(8);
            }

            @Override // com.studiolaganne.lengendarylens.ContainerAdapter.ContainerSelectionListener
            public void onNewContainerSelected() {
                MoveCardDialogFragment.this.selectedContainerId = -1;
                MoveCardDialogFragment.this.isCreatingNewContainer = true;
                viewInflate.findViewById(R.id.newContainerLayout).setVisibility(0);
                viewInflate.findViewById(R.id.containerTypeRadioGroup).setVisibility(MoveCardDialogFragment.this.currentTabIndex != 0 ? 8 : 0);
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.newContainerInputLayout);
                if (MoveCardDialogFragment.this.currentTabIndex == 0) {
                    boolean zIsChecked = ((RadioButton) viewInflate.findViewById(R.id.boxRadioButton)).isChecked();
                    MoveCardDialogFragment moveCardDialogFragment = MoveCardDialogFragment.this;
                    textInputLayout.setHint(zIsChecked ? moveCardDialogFragment.getString(R.string.new_container_name) : moveCardDialogFragment.getString(R.string.new_container_name));
                } else {
                    textInputLayout.setHint(MoveCardDialogFragment.this.getString(R.string.new_list_name));
                }
                View viewFindViewById6 = viewInflate.findViewById(R.id.newContainerEditText);
                viewFindViewById6.requestFocus();
                Object systemService = MoveCardDialogFragment.this.requireContext().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).showSoftInput(viewFindViewById6, 1);
            }
        });
        this.containerAdapter = containerAdapter;
        recyclerView.setAdapter(containerAdapter);
        RecyclerView recyclerView2 = (RecyclerView) viewInflate.findViewById(R.id.decksRecyclerView);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        DeckAdapter deckAdapter = new DeckAdapter(new ArrayList(), new DeckAdapter.DeckSelectionListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment.onCreateView.7
            @Override // com.studiolaganne.lengendarylens.DeckAdapter.DeckSelectionListener
            public void onDeckSelected(MTDeck deck) {
                Intrinsics.checkNotNullParameter(deck, "deck");
                MoveCardDialogFragment.this.selectedDeck = deck;
                MoveCardDialogFragment.this.selectedContainerId = -1;
                MoveCardDialogFragment.this.isCreatingNewContainer = false;
                View viewFindViewById6 = viewInflate.findViewById(R.id.newContainerLayout);
                if (viewFindViewById6 != null) {
                    viewFindViewById6.setVisibility(8);
                }
                MTDeck mTDeck = (MTDeck) MoveCardDialogFragment.this.fetchedDeckListIds.get(Integer.valueOf(deck.getId()));
                if (mTDeck != null) {
                    MoveCardDialogFragment.this.updateDeckListRadioButtons(mTDeck);
                    return;
                }
                Integer listid = deck.getListid();
                MoveCardDialogFragment moveCardDialogFragment = MoveCardDialogFragment.this;
                if (listid == null) {
                    moveCardDialogFragment.fetchDeckInfo(deck);
                } else {
                    moveCardDialogFragment.updateDeckListRadioButtons(deck);
                }
            }
        });
        this.deckAdapter = deckAdapter;
        recyclerView2.setAdapter(deckAdapter);
        updateContainersList();
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(R.id.boxRadioButton);
        RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(R.id.binderRadioButton);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MoveCardDialogFragment.onCreateView$lambda$4(viewInflate, this, compoundButton, z);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MoveCardDialogFragment.onCreateView$lambda$5(viewInflate, this, compoundButton, z);
            }
        });
        View viewFindViewById6 = viewInflate.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNull(viewFindViewById6);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MoveCardDialogFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        View viewFindViewById7 = viewInflate.findViewById(R.id.moveButtonLayout);
        if (this.addMode) {
            ((TextView) viewFindViewById7.findViewById(R.id.moveButtonText)).setText(getString(R.string.select));
        }
        Intrinsics.checkNotNull(viewFindViewById7);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById7, new Function0() { // from class: com.studiolaganne.lengendarylens.MoveCardDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MoveCardDialogFragment.onCreateView$lambda$7(this.f$0, viewInflate);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
