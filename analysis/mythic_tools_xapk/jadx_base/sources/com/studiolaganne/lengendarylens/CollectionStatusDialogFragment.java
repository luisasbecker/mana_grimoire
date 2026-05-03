package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.revenuecat.purchases.common.Constants;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CollectionStatusDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00106\u001a\u00020\u0011H\u0016J&\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010@\u001a\u00020\u0011H\u0002J\b\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\n\u0010C\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\n0EH\u0002J\b\u0010F\u001a\u00020\u0011H\u0002J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020(H\u0002J\b\u0010I\u001a\u00020\u0011H\u0002J\b\u0010J\u001a\u00020\u0011H\u0002J\b\u0010K\u001a\u00020\u0011H\u0002J\b\u0010L\u001a\u00020\u0011H\u0002J\b\u0010M\u001a\u00020\u0011H\u0002J\b\u0010N\u001a\u00020\u0011H\u0002J\b\u0010O\u001a\u00020\u0011H\u0002J$\u0010P\u001a\u00020\u00112\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007H\u0002J\b\u0010S\u001a\u00020\u0011H\u0002J\b\u0010T\u001a\u00020\u0011H\u0002J\b\u0010U\u001a\u00020\u0011H\u0002J\b\u0010V\u001a\u00020\u0011H\u0002J\u0010\u0010W\u001a\u00020\u00112\u0006\u0010X\u001a\u00020\u0015H\u0002J\b\u0010Y\u001a\u00020\u0011H\u0002J\b\u0010Z\u001a\u00020\u0011H\u0002J\b\u0010[\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionStatusDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "rootView", "Landroid/view/View;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentCardIndex", "", "results", "", "Lcom/studiolaganne/lengendarylens/CollectionStatusDialogResult;", "onResultListener", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MultiCardCollectionStatusDialogResult;", "", "selectedChoice", "Lcom/studiolaganne/lengendarylens/CollectionStatusChoice;", "selectedMatch", "Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "isShowingMatches", "", "isUpdatingRadioButtons", "exactMatches", "partialMatches", "exactMatchAdapter", "Lcom/studiolaganne/lengendarylens/CardMatchAdapter;", "partialMatchAdapter", "currentCardImage", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "cardName", "Landroid/widget/TextView;", "setCodeTextView", "collectorNumberTextView", "progressHeader", "addToCollectionLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "addToCollectionRadioButton", "Landroid/widget/RadioButton;", "grabFromCollectionLayout", "grabFromCollectionRadioButton", "grabFromCollectionSubtitle", "makeAProxyLayout", "makeAProxyRadioButton", "backImage", "Landroid/widget/ImageView;", "matchesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cancelButton", "Lcom/google/android/material/button/MaterialButton;", "previousButton", "saveButton", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "initializeViews", "setupProgressHeader", "setupCardInfo", "getCurrentCard", "getSelectedListCardIds", "", "setupOptions", "uncheckOtherRadioButtons", "selectedButton", "setupGrabFromCollectionSubtitle", "showMatchesView", "hideMatchesView", "resetToInitialState", "setupMatchesRecyclerView", "setupExactMatchesRecyclerView", "setupPartialMatchesRecyclerView", "setupCombinedMatchesRecyclerView", "allMatches", "isExactFlags", "setupButtons", "saveCurrentChoice", "goToNextCard", "goToPreviousCard", "selectMatchInAdapter", "match", "restoreRadioButtonState", "updateButtonStates", "updateSaveButtonState", "onDestroyView", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionStatusDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private ConstraintLayout addToCollectionLayout;
    private RadioButton addToCollectionRadioButton;
    private ImageView backImage;
    private MaterialButton cancelButton;
    private TextView cardName;
    private TextView collectorNumberTextView;
    private LoadingImageView currentCardImage;
    private int currentCardIndex;
    private CardMatchAdapter exactMatchAdapter;
    private ConstraintLayout grabFromCollectionLayout;
    private RadioButton grabFromCollectionRadioButton;
    private TextView grabFromCollectionSubtitle;
    private boolean isShowingMatches;
    private boolean isUpdatingRadioButtons;
    private ConstraintLayout makeAProxyLayout;
    private RadioButton makeAProxyRadioButton;
    private RecyclerView matchesRecyclerView;
    private Function1<? super MultiCardCollectionStatusDialogResult, Unit> onResultListener;
    private CardMatchAdapter partialMatchAdapter;
    private MaterialButton previousButton;
    private TextView progressHeader;
    private View rootView;
    private MaterialButton saveButton;
    private CollectionStatusChoice selectedChoice;
    private MTCollectionCardMatch selectedMatch;
    private TextView setCodeTextView;
    private List<MTFullCard> cards = CollectionsKt.emptyList();
    private List<CollectionStatusDialogResult> results = new ArrayList();
    private List<MTCollectionCardMatch> exactMatches = CollectionsKt.emptyList();
    private List<MTCollectionCardMatch> partialMatches = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: CollectionStatusDialogFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\u001a\u0010\f\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionStatusDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/CollectionStatusDialogFragment;", "setCard", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "setCards", "cards", "", "setOnResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MultiCardCollectionStatusDialogResult;", "", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final CollectionStatusDialogFragment dialogFragment = new CollectionStatusDialogFragment();

        public final Builder setCard(MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.dialogFragment.cards = CollectionsKt.listOf(card);
            this.dialogFragment.currentCardIndex = 0;
            return this;
        }

        public final Builder setCards(List<MTFullCard> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.cards = cards;
            this.dialogFragment.currentCardIndex = 0;
            return this;
        }

        public final Builder setOnResultListener(Function1<? super MultiCardCollectionStatusDialogResult, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.dialogFragment.onResultListener = listener;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    /* JADX INFO: compiled from: CollectionStatusDialogFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CollectionStatusChoice.values().length];
            try {
                iArr[CollectionStatusChoice.GRAB_FROM_COLLECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CollectionStatusChoice.ADD_TO_COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CollectionStatusChoice.MAKE_PROXY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final MTFullCard getCurrentCard() {
        if (this.currentCardIndex < this.cards.size()) {
            return this.cards.get(this.currentCardIndex);
        }
        return null;
    }

    private final Set<Integer> getSelectedListCardIds() {
        MTCardMatch card;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        for (Object obj : this.results) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CollectionStatusDialogResult collectionStatusDialogResult = (CollectionStatusDialogResult) obj;
            if (i != this.currentCardIndex && collectionStatusDialogResult.getChoice() == CollectionStatusChoice.GRAB_FROM_COLLECTION) {
                MTCollectionCardMatch selectedMatch = collectionStatusDialogResult.getSelectedMatch();
                if (((selectedMatch == null || (card = selectedMatch.getCard()) == null) ? null : card.getList_card_id()) != null) {
                    MTCardMatch card2 = collectionStatusDialogResult.getSelectedMatch().getCard();
                    Intrinsics.checkNotNull(card2);
                    Integer list_card_id = card2.getList_card_id();
                    Intrinsics.checkNotNull(list_card_id);
                    linkedHashSet.add(list_card_id);
                }
            }
            i = i2;
        }
        return linkedHashSet;
    }

    private final void goToNextCard() {
        Object next;
        MTCollectionCardMatch mTCollectionCardMatch;
        Object next2;
        saveCurrentChoice();
        int i = this.currentCardIndex + 1;
        this.currentCardIndex = i;
        if (i < this.results.size()) {
            CollectionStatusDialogResult collectionStatusDialogResult = this.results.get(this.currentCardIndex);
            this.selectedChoice = collectionStatusDialogResult.getChoice();
            this.selectedMatch = collectionStatusDialogResult.getSelectedMatch();
        } else {
            this.selectedChoice = null;
            this.selectedMatch = null;
        }
        this.isShowingMatches = false;
        setupProgressHeader();
        setupCardInfo();
        setupOptions();
        updateButtonStates();
        restoreRadioButtonState();
        if (this.selectedChoice != CollectionStatusChoice.GRAB_FROM_COLLECTION) {
            hideMatchesView();
            return;
        }
        MTCollectionCardMatch mTCollectionCardMatch2 = this.selectedMatch;
        if (mTCollectionCardMatch2 == null) {
            showMatchesView();
            return;
        }
        MTCardMatch card = mTCollectionCardMatch2.getCard();
        Integer list_card_id = card != null ? card.getList_card_id() : null;
        List listPlus = CollectionsKt.plus((Collection) this.exactMatches, (Iterable) this.partialMatches);
        if (list_card_id != null) {
            Iterator it = listPlus.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                MTCardMatch card2 = ((MTCollectionCardMatch) next2).getCard();
                if (card2 != null) {
                    Integer list_card_id2 = card2.getList_card_id();
                    int iIntValue = list_card_id.intValue();
                    if (list_card_id2 != null && list_card_id2.intValue() == iIntValue) {
                        break;
                    }
                }
            }
            mTCollectionCardMatch = (MTCollectionCardMatch) next2;
        } else {
            Iterator it2 = listPlus.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                MTCardMatch card3 = ((MTCollectionCardMatch) next).getCard();
                String cardid = card3 != null ? card3.getCardid() : null;
                MTCardMatch card4 = mTCollectionCardMatch2.getCard();
                if (Intrinsics.areEqual(cardid, card4 != null ? card4.getCardid() : null)) {
                    break;
                }
            }
            mTCollectionCardMatch = (MTCollectionCardMatch) next;
        }
        if (mTCollectionCardMatch == null) {
            this.selectedMatch = null;
            showMatchesView();
        } else {
            this.selectedMatch = mTCollectionCardMatch;
            showMatchesView();
            selectMatchInAdapter(mTCollectionCardMatch);
        }
    }

    private final void goToPreviousCard() {
        Object next;
        MTCollectionCardMatch mTCollectionCardMatch;
        Object next2;
        saveCurrentChoice();
        int i = this.currentCardIndex - 1;
        this.currentCardIndex = i;
        if (i < this.results.size()) {
            CollectionStatusDialogResult collectionStatusDialogResult = this.results.get(this.currentCardIndex);
            this.selectedChoice = collectionStatusDialogResult.getChoice();
            this.selectedMatch = collectionStatusDialogResult.getSelectedMatch();
        } else {
            this.selectedChoice = null;
            this.selectedMatch = null;
        }
        this.isShowingMatches = false;
        setupProgressHeader();
        setupCardInfo();
        setupOptions();
        updateButtonStates();
        restoreRadioButtonState();
        if (this.selectedChoice != CollectionStatusChoice.GRAB_FROM_COLLECTION) {
            hideMatchesView();
            return;
        }
        MTCollectionCardMatch mTCollectionCardMatch2 = this.selectedMatch;
        if (mTCollectionCardMatch2 == null) {
            showMatchesView();
            return;
        }
        MTCardMatch card = mTCollectionCardMatch2.getCard();
        Integer list_card_id = card != null ? card.getList_card_id() : null;
        List listPlus = CollectionsKt.plus((Collection) this.exactMatches, (Iterable) this.partialMatches);
        if (list_card_id != null) {
            Iterator it = listPlus.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                MTCardMatch card2 = ((MTCollectionCardMatch) next2).getCard();
                if (card2 != null) {
                    Integer list_card_id2 = card2.getList_card_id();
                    int iIntValue = list_card_id.intValue();
                    if (list_card_id2 != null && list_card_id2.intValue() == iIntValue) {
                        break;
                    }
                }
            }
            mTCollectionCardMatch = (MTCollectionCardMatch) next2;
        } else {
            Iterator it2 = listPlus.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                MTCardMatch card3 = ((MTCollectionCardMatch) next).getCard();
                String cardid = card3 != null ? card3.getCardid() : null;
                MTCardMatch card4 = mTCollectionCardMatch2.getCard();
                if (Intrinsics.areEqual(cardid, card4 != null ? card4.getCardid() : null)) {
                    break;
                }
            }
            mTCollectionCardMatch = (MTCollectionCardMatch) next;
        }
        if (mTCollectionCardMatch == null) {
            this.selectedMatch = null;
            showMatchesView();
        } else {
            this.selectedMatch = mTCollectionCardMatch;
            showMatchesView();
            selectMatchInAdapter(mTCollectionCardMatch);
        }
    }

    private final void hideMatchesView() {
        this.isShowingMatches = false;
        ConstraintLayout constraintLayout = this.addToCollectionLayout;
        RecyclerView recyclerView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        ConstraintLayout constraintLayout2 = this.makeAProxyLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(0);
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        imageView.setVisibility(8);
        RecyclerView recyclerView2 = this.matchesRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }

    private final void initializeViews() {
        View view = this.rootView;
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.currentCardImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.currentCardImage = (LoadingImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.cardName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.cardName = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.setCodeTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.setCodeTextView = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.collectorNumberTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.collectorNumberTextView = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.progressHeader);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.progressHeader = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.addToCollectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.addToCollectionLayout = (ConstraintLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.addToCollectionRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.addToCollectionRadioButton = (RadioButton) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.grabFromCollectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.grabFromCollectionLayout = (ConstraintLayout) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.grabFromCollectionRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.grabFromCollectionRadioButton = (RadioButton) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.grabFromCollectionSubtitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.grabFromCollectionSubtitle = (TextView) viewFindViewById10;
            View viewFindViewById11 = view.findViewById(R.id.makeAProxyLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.makeAProxyLayout = (ConstraintLayout) viewFindViewById11;
            View viewFindViewById12 = view.findViewById(R.id.makeAProxyRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.makeAProxyRadioButton = (RadioButton) viewFindViewById12;
            View viewFindViewById13 = view.findViewById(R.id.backImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.backImage = (ImageView) viewFindViewById13;
            View viewFindViewById14 = view.findViewById(R.id.matchesRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            this.matchesRecyclerView = (RecyclerView) viewFindViewById14;
            View viewFindViewById15 = view.findViewById(R.id.cancelButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
            this.cancelButton = (MaterialButton) viewFindViewById15;
            View viewFindViewById16 = view.findViewById(R.id.previousButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
            this.previousButton = (MaterialButton) viewFindViewById16;
            View viewFindViewById17 = view.findViewById(R.id.saveButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
            this.saveButton = (MaterialButton) viewFindViewById17;
        }
    }

    private final void resetToInitialState() {
        RadioButton radioButton = this.addToCollectionRadioButton;
        RecyclerView recyclerView = null;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(false);
        RadioButton radioButton2 = this.grabFromCollectionRadioButton;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton2 = null;
        }
        radioButton2.setChecked(false);
        RadioButton radioButton3 = this.makeAProxyRadioButton;
        if (radioButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton3 = null;
        }
        radioButton3.setChecked(false);
        this.selectedChoice = null;
        this.selectedMatch = null;
        this.isShowingMatches = false;
        CardMatchAdapter cardMatchAdapter = this.exactMatchAdapter;
        if (cardMatchAdapter != null) {
            cardMatchAdapter.updateSelection(-1);
        }
        CardMatchAdapter cardMatchAdapter2 = this.partialMatchAdapter;
        if (cardMatchAdapter2 != null) {
            cardMatchAdapter2.updateSelection(-1);
        }
        ConstraintLayout constraintLayout = this.addToCollectionLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        if (!this.exactMatches.isEmpty() || !this.partialMatches.isEmpty()) {
            ConstraintLayout constraintLayout2 = this.grabFromCollectionLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(0);
        }
        ConstraintLayout constraintLayout3 = this.makeAProxyLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
            constraintLayout3 = null;
        }
        constraintLayout3.setVisibility(0);
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        imageView.setVisibility(8);
        RecyclerView recyclerView2 = this.matchesRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
        updateSaveButtonState();
    }

    private final void restoreRadioButtonState() {
        boolean z = true;
        this.isUpdatingRadioButtons = true;
        try {
            RadioButton radioButton = this.addToCollectionRadioButton;
            RadioButton radioButton2 = null;
            if (radioButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
                radioButton = null;
            }
            radioButton.setChecked(this.selectedChoice == CollectionStatusChoice.ADD_TO_COLLECTION);
            RadioButton radioButton3 = this.grabFromCollectionRadioButton;
            if (radioButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
                radioButton3 = null;
            }
            radioButton3.setChecked(this.selectedChoice == CollectionStatusChoice.GRAB_FROM_COLLECTION);
            RadioButton radioButton4 = this.makeAProxyRadioButton;
            if (radioButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            } else {
                radioButton2 = radioButton4;
            }
            if (this.selectedChoice != CollectionStatusChoice.MAKE_PROXY) {
                z = false;
            }
            radioButton2.setChecked(z);
        } finally {
            this.isUpdatingRadioButtons = false;
        }
    }

    private final void saveCurrentChoice() {
        CollectionStatusChoice collectionStatusChoice;
        MTFullCard currentCard = getCurrentCard();
        if (currentCard == null || (collectionStatusChoice = this.selectedChoice) == null) {
            return;
        }
        CollectionStatusDialogResult collectionStatusDialogResult = new CollectionStatusDialogResult(collectionStatusChoice, collectionStatusChoice == CollectionStatusChoice.GRAB_FROM_COLLECTION ? this.selectedMatch : null, currentCard.getList_card_id());
        int i = this.currentCardIndex;
        int size = this.results.size();
        List<CollectionStatusDialogResult> list = this.results;
        if (i < size) {
            list.set(this.currentCardIndex, collectionStatusDialogResult);
        } else {
            list.add(collectionStatusDialogResult);
        }
    }

    private final void selectMatchInAdapter(MTCollectionCardMatch match) {
        Iterator<MTCollectionCardMatch> it = this.exactMatches.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            MTCardMatch card = it.next().getCard();
            String cardid = card != null ? card.getCardid() : null;
            MTCardMatch card2 = match.getCard();
            if (Intrinsics.areEqual(cardid, card2 != null ? card2.getCardid() : null)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            CardMatchAdapter cardMatchAdapter = this.exactMatchAdapter;
            if (cardMatchAdapter != null) {
                cardMatchAdapter.updateSelection(i2);
            }
            CardMatchAdapter cardMatchAdapter2 = this.partialMatchAdapter;
            if (cardMatchAdapter2 != null) {
                cardMatchAdapter2.updateSelection(-1);
                return;
            }
            return;
        }
        Iterator<MTCollectionCardMatch> it2 = this.partialMatches.iterator();
        int i3 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i3 = -1;
                break;
            }
            MTCardMatch card3 = it2.next().getCard();
            String cardid2 = card3 != null ? card3.getCardid() : null;
            MTCardMatch card4 = match.getCard();
            if (Intrinsics.areEqual(cardid2, card4 != null ? card4.getCardid() : null)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            CardMatchAdapter cardMatchAdapter3 = this.partialMatchAdapter;
            if (cardMatchAdapter3 != null) {
                cardMatchAdapter3.updateSelection(i3);
            }
            CardMatchAdapter cardMatchAdapter4 = this.exactMatchAdapter;
            if (cardMatchAdapter4 != null) {
                cardMatchAdapter4.updateSelection(-1);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it3 = this.exactMatches.iterator();
        while (it3.hasNext()) {
            arrayList.add((MTCollectionCardMatch) it3.next());
            arrayList2.add(true);
        }
        Iterator<T> it4 = this.partialMatches.iterator();
        while (it4.hasNext()) {
            arrayList.add((MTCollectionCardMatch) it4.next());
            arrayList2.add(false);
        }
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                i = -1;
                break;
            }
            MTCardMatch card5 = ((MTCollectionCardMatch) it5.next()).getCard();
            String cardid3 = card5 != null ? card5.getCardid() : null;
            MTCardMatch card6 = match.getCard();
            if (Intrinsics.areEqual(cardid3, card6 != null ? card6.getCardid() : null)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                int iIndexOf = this.exactMatches.indexOf(arrayList.get(i));
                CardMatchAdapter cardMatchAdapter5 = this.exactMatchAdapter;
                if (cardMatchAdapter5 != null) {
                    cardMatchAdapter5.updateSelection(iIndexOf);
                }
                CardMatchAdapter cardMatchAdapter6 = this.partialMatchAdapter;
                if (cardMatchAdapter6 != null) {
                    cardMatchAdapter6.updateSelection(-1);
                    return;
                }
                return;
            }
            int iIndexOf2 = this.partialMatches.indexOf(arrayList.get(i));
            CardMatchAdapter cardMatchAdapter7 = this.partialMatchAdapter;
            if (cardMatchAdapter7 != null) {
                cardMatchAdapter7.updateSelection(iIndexOf2);
            }
            CardMatchAdapter cardMatchAdapter8 = this.exactMatchAdapter;
            if (cardMatchAdapter8 != null) {
                cardMatchAdapter8.updateSelection(-1);
            }
        }
    }

    private final void setupButtons() {
        MaterialButton materialButton = this.cancelButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            materialButton = null;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionStatusDialogFragment.setupButtons$lambda$0(this.f$0);
            }
        });
        MaterialButton materialButton3 = this.previousButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousButton");
            materialButton3 = null;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton3, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionStatusDialogFragment.setupButtons$lambda$1(this.f$0);
            }
        });
        MaterialButton materialButton4 = this.saveButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton2 = materialButton4;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionStatusDialogFragment.setupButtons$lambda$2(this.f$0);
            }
        });
    }

    static final Unit setupButtons$lambda$0(CollectionStatusDialogFragment collectionStatusDialogFragment) {
        collectionStatusDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$1(CollectionStatusDialogFragment collectionStatusDialogFragment) {
        collectionStatusDialogFragment.goToPreviousCard();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$2(CollectionStatusDialogFragment collectionStatusDialogFragment) {
        if (collectionStatusDialogFragment.selectedChoice != null) {
            collectionStatusDialogFragment.saveCurrentChoice();
            if (collectionStatusDialogFragment.currentCardIndex < collectionStatusDialogFragment.cards.size() - 1) {
                collectionStatusDialogFragment.goToNextCard();
            } else {
                Function1<? super MultiCardCollectionStatusDialogResult, Unit> function1 = collectionStatusDialogFragment.onResultListener;
                if (function1 != null) {
                    function1.invoke(new MultiCardCollectionStatusDialogResult(collectionStatusDialogFragment.results));
                }
                collectionStatusDialogFragment.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupCardInfo() {
        String str;
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String normal;
        MTImageURIs mTImageURIs3;
        String gatherer2;
        MTImageURIs mTImageURIs4;
        String normal2;
        MTFullCard currentCard = getCurrentCard();
        if (currentCard != null) {
            TextView textView = this.cardName;
            LoadingImageView loadingImageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardName");
                textView = null;
            }
            String printed_name = currentCard.getPrinted_name();
            textView.setText((printed_name == null && (printed_name = currentCard.getName()) == null) ? "" : printed_name);
            TextView textView2 = this.setCodeTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setCodeTextView");
                textView2 = null;
            }
            String set_code = currentCard.getSet_code();
            if (set_code != null) {
                String upperCase = set_code.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                str = upperCase != null ? upperCase : "";
            }
            textView2.setText(str);
            TextView textView3 = this.collectorNumberTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectorNumberTextView");
                textView3 = null;
            }
            String collector_number = currentCard.getCollector_number();
            if (collector_number == null) {
                collector_number = "---";
            }
            textView3.setText(ColorKt.HEX_PREFIX + collector_number);
            LoadingImageView loadingImageView2 = this.currentCardImage;
            if (loadingImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                loadingImageView2 = null;
            }
            loadingImageView2.setAutoLoad(false);
            LoadingImageView loadingImageView3 = this.currentCardImage;
            if (loadingImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                loadingImageView3 = null;
            }
            loadingImageView3.reset();
            List<MTImageURIs> images = currentCard.getImages();
            if (images != null && (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) != null && (normal2 = mTImageURIs4.getNormal()) != null) {
                LoadingImageView loadingImageView4 = this.currentCardImage;
                if (loadingImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                } else {
                    loadingImageView = loadingImageView4;
                }
                loadingImageView.loadImage(normal2);
                return;
            }
            List<MTImageURIs> images2 = currentCard.getImages();
            if (images2 != null && (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer2 = mTImageURIs3.getGatherer()) != null) {
                LoadingImageView loadingImageView5 = this.currentCardImage;
                if (loadingImageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                } else {
                    loadingImageView = loadingImageView5;
                }
                loadingImageView.loadImage(gatherer2);
                return;
            }
            List<MTImageURIs> en_images = currentCard.getEn_images();
            if (en_images != null && (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) != null && (normal = mTImageURIs2.getNormal()) != null) {
                LoadingImageView loadingImageView6 = this.currentCardImage;
                if (loadingImageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
                } else {
                    loadingImageView = loadingImageView6;
                }
                loadingImageView.loadImage(normal);
                return;
            }
            List<MTImageURIs> en_images2 = currentCard.getEn_images();
            if (en_images2 == null || (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) == null || (gatherer = mTImageURIs.getGatherer()) == null) {
                return;
            }
            LoadingImageView loadingImageView7 = this.currentCardImage;
            if (loadingImageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentCardImage");
            } else {
                loadingImageView = loadingImageView7;
            }
            loadingImageView.loadImage(gatherer);
        }
    }

    private final void setupCombinedMatchesRecyclerView(List<MTCollectionCardMatch> allMatches, List<Boolean> isExactFlags) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView = this.matchesRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        Ref.IntRef intRef = new Ref.IntRef();
        int i = -1;
        intRef.element = -1;
        Iterator<Boolean> it = isExactFlags.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().booleanValue()) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            intRef.element = i;
            this.selectedMatch = allMatches.get(i);
        } else if (!allMatches.isEmpty()) {
            intRef.element = 0;
            this.selectedMatch = allMatches.get(0);
        }
        CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1 collectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1 = new CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1(intRef, this, allMatches, isExactFlags);
        RecyclerView recyclerView3 = this.matchesRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(collectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1);
        updateSaveButtonState();
    }

    private final void setupExactMatchesRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView = this.matchesRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        this.exactMatchAdapter = new CardMatchAdapter(this.exactMatches, true, 0, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionStatusDialogFragment.setupExactMatchesRecyclerView$lambda$0(this.f$0, ((Integer) obj).intValue(), (MTCollectionCardMatch) obj2);
            }
        });
        RecyclerView recyclerView3 = this.matchesRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.exactMatchAdapter);
        this.selectedMatch = (MTCollectionCardMatch) CollectionsKt.firstOrNull((List) this.exactMatches);
        updateSaveButtonState();
    }

    static final Unit setupExactMatchesRecyclerView$lambda$0(CollectionStatusDialogFragment collectionStatusDialogFragment, int i, MTCollectionCardMatch match) {
        Intrinsics.checkNotNullParameter(match, "match");
        CardMatchAdapter cardMatchAdapter = collectionStatusDialogFragment.exactMatchAdapter;
        if (cardMatchAdapter != null) {
            cardMatchAdapter.updateSelection(i);
        }
        CardMatchAdapter cardMatchAdapter2 = collectionStatusDialogFragment.partialMatchAdapter;
        if (cardMatchAdapter2 != null) {
            cardMatchAdapter2.updateSelection(-1);
        }
        collectionStatusDialogFragment.selectedMatch = match;
        collectionStatusDialogFragment.updateSaveButtonState();
        return Unit.INSTANCE;
    }

    private final void setupGrabFromCollectionSubtitle() {
        int size = this.exactMatches.size();
        int size2 = this.partialMatches.size();
        int i = size + size2;
        String string = (size == 1 && size2 == 0) ? getString(R.string.collection_status_grab_subtitle_one_exact) : (size == 0 && size2 == 1) ? getString(R.string.collection_status_grab_subtitle_partial_single) : (size != 0 || size2 <= 1) ? size >= 1 ? getString(R.string.collection_status_grab_subtitle_at_least_one_exact) : i == 1 ? getString(R.string.collection_status_grab_subtitle_mixed_single) : getString(R.string.collection_status_grab_subtitle_mixed_plural, Integer.valueOf(i)) : getString(R.string.collection_status_grab_subtitle_partial_plural, Integer.valueOf(size2));
        Intrinsics.checkNotNull(string);
        TextView textView = this.grabFromCollectionSubtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionSubtitle");
            textView = null;
        }
        textView.setText(string);
    }

    private final void setupMatchesRecyclerView() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = this.exactMatches.iterator();
        while (it.hasNext()) {
            arrayList.add((MTCollectionCardMatch) it.next());
            arrayList2.add(true);
        }
        Iterator<T> it2 = this.partialMatches.iterator();
        while (it2.hasNext()) {
            arrayList.add((MTCollectionCardMatch) it2.next());
            arrayList2.add(false);
        }
        if (!this.exactMatches.isEmpty() && !this.partialMatches.isEmpty()) {
            setupCombinedMatchesRecyclerView(arrayList, arrayList2);
        } else if (!this.exactMatches.isEmpty()) {
            setupExactMatchesRecyclerView();
        } else {
            if (this.partialMatches.isEmpty()) {
                return;
            }
            setupPartialMatchesRecyclerView();
        }
    }

    private final void setupOptions() {
        List<MTCollectionCardMatch> listEmptyList;
        ArrayList arrayListEmptyList;
        List<MTCollectionCardMatch> all;
        MTFullCard currentCard = getCurrentCard();
        ConstraintLayout constraintLayout = null;
        MTCardCollectionStatus collection = currentCard != null ? currentCard.getCollection() : null;
        MTCardCollectionMatches matches = collection != null ? collection.getMatches() : null;
        Set<Integer> selectedListCardIds = getSelectedListCardIds();
        if (matches == null || (listEmptyList = matches.getExact()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<MTCollectionCardMatch> list = listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            MTCardMatch card = ((MTCollectionCardMatch) obj).getCard();
            Integer list_card_id = card != null ? card.getList_card_id() : null;
            if (list_card_id == null || !selectedListCardIds.contains(list_card_id)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            String str = setupOptions$getMatchKey((MTCollectionCardMatch) obj2);
            if (str != null && !linkedHashSet.contains(str)) {
                linkedHashSet.add(str);
            } else if (str == null) {
            }
            arrayList2.add(obj2);
        }
        this.exactMatches = arrayList2;
        if (matches == null || (all = matches.getAll()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : all) {
                String str2 = setupOptions$getMatchKey((MTCollectionCardMatch) obj3);
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(setupOptions$getMatchKey((MTCollectionCardMatch) it.next()), str2)) {
                            break;
                        }
                    }
                }
                arrayList3.add(obj3);
            }
            arrayListEmptyList = arrayList3;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : arrayListEmptyList) {
            MTCardMatch card2 = ((MTCollectionCardMatch) obj4).getCard();
            Integer list_card_id2 = card2 != null ? card2.getList_card_id() : null;
            if (list_card_id2 == null || !selectedListCardIds.contains(list_card_id2)) {
                arrayList4.add(obj4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj5 : arrayList4) {
            String str3 = setupOptions$getMatchKey((MTCollectionCardMatch) obj5);
            if (str3 != null && !linkedHashSet2.contains(str3)) {
                linkedHashSet2.add(str3);
            } else if (str3 == null) {
            }
            arrayList5.add(obj5);
        }
        this.partialMatches = arrayList5;
        boolean z = (this.exactMatches.isEmpty() && this.partialMatches.isEmpty()) ? false : true;
        final boolean z2 = this.exactMatches.size() == 1 && this.partialMatches.isEmpty();
        ConstraintLayout constraintLayout2 = this.grabFromCollectionLayout;
        if (z) {
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(0);
            setupGrabFromCollectionSubtitle();
            RadioButton radioButton = this.grabFromCollectionRadioButton;
            if (radioButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
                radioButton = null;
            }
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    CollectionStatusDialogFragment.setupOptions$lambda$5(this.f$0, z2, compoundButton, z3);
                }
            });
            ConstraintLayout constraintLayout3 = this.grabFromCollectionLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionLayout");
                constraintLayout3 = null;
            }
            constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionStatusDialogFragment.setupOptions$lambda$6(this.f$0, view);
                }
            });
        } else {
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(8);
        }
        RadioButton radioButton2 = this.addToCollectionRadioButton;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton2 = null;
        }
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CollectionStatusDialogFragment.setupOptions$lambda$7(this.f$0, compoundButton, z3);
            }
        });
        ConstraintLayout constraintLayout4 = this.addToCollectionLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionStatusDialogFragment.setupOptions$lambda$8(this.f$0, view);
            }
        });
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionStatusDialogFragment.setupOptions$lambda$9(this.f$0);
            }
        });
        RadioButton radioButton3 = this.makeAProxyRadioButton;
        if (radioButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton3 = null;
        }
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CollectionStatusDialogFragment.setupOptions$lambda$10(this.f$0, compoundButton, z3);
            }
        });
        ConstraintLayout constraintLayout5 = this.makeAProxyLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
        } else {
            constraintLayout = constraintLayout5;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionStatusDialogFragment.setupOptions$lambda$11(this.f$0, view);
            }
        });
    }

    private static final String setupOptions$getMatchKey(MTCollectionCardMatch mTCollectionCardMatch) {
        MTCardContainer list = mTCollectionCardMatch.getList();
        Integer numValueOf = list != null ? Integer.valueOf(list.getId()) : null;
        MTCardMatch card = mTCollectionCardMatch.getCard();
        Integer list_card_id = card != null ? card.getList_card_id() : null;
        if (numValueOf == null || list_card_id == null) {
            return null;
        }
        return numValueOf + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + list_card_id;
    }

    static final void setupOptions$lambda$10(CollectionStatusDialogFragment collectionStatusDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z || collectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = collectionStatusDialogFragment.makeAProxyRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton = null;
        }
        collectionStatusDialogFragment.uncheckOtherRadioButtons(radioButton);
        collectionStatusDialogFragment.selectedChoice = CollectionStatusChoice.MAKE_PROXY;
        collectionStatusDialogFragment.hideMatchesView();
        collectionStatusDialogFragment.updateSaveButtonState();
    }

    static final void setupOptions$lambda$11(CollectionStatusDialogFragment collectionStatusDialogFragment, View view) {
        RadioButton radioButton = collectionStatusDialogFragment.makeAProxyRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
    }

    static final void setupOptions$lambda$5(CollectionStatusDialogFragment collectionStatusDialogFragment, boolean z, CompoundButton compoundButton, boolean z2) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z2 || collectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = collectionStatusDialogFragment.grabFromCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton = null;
        }
        collectionStatusDialogFragment.uncheckOtherRadioButtons(radioButton);
        collectionStatusDialogFragment.selectedChoice = CollectionStatusChoice.GRAB_FROM_COLLECTION;
        if (z) {
            collectionStatusDialogFragment.selectedMatch = collectionStatusDialogFragment.exactMatches.get(0);
        } else {
            collectionStatusDialogFragment.showMatchesView();
        }
        collectionStatusDialogFragment.updateSaveButtonState();
    }

    static final void setupOptions$lambda$6(CollectionStatusDialogFragment collectionStatusDialogFragment, View view) {
        RadioButton radioButton = collectionStatusDialogFragment.grabFromCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
    }

    static final void setupOptions$lambda$7(CollectionStatusDialogFragment collectionStatusDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z || collectionStatusDialogFragment.isUpdatingRadioButtons) {
            return;
        }
        RadioButton radioButton = collectionStatusDialogFragment.addToCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton = null;
        }
        collectionStatusDialogFragment.uncheckOtherRadioButtons(radioButton);
        collectionStatusDialogFragment.selectedChoice = CollectionStatusChoice.ADD_TO_COLLECTION;
        collectionStatusDialogFragment.hideMatchesView();
        collectionStatusDialogFragment.updateSaveButtonState();
    }

    static final void setupOptions$lambda$8(CollectionStatusDialogFragment collectionStatusDialogFragment, View view) {
        RadioButton radioButton = collectionStatusDialogFragment.addToCollectionRadioButton;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
            radioButton = null;
        }
        radioButton.setChecked(true);
    }

    static final Unit setupOptions$lambda$9(CollectionStatusDialogFragment collectionStatusDialogFragment) {
        collectionStatusDialogFragment.resetToInitialState();
        return Unit.INSTANCE;
    }

    private final void setupPartialMatchesRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView = this.matchesRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        this.partialMatchAdapter = new CardMatchAdapter(this.partialMatches, false, 0, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionStatusDialogFragment.setupPartialMatchesRecyclerView$lambda$0(this.f$0, ((Integer) obj).intValue(), (MTCollectionCardMatch) obj2);
            }
        });
        RecyclerView recyclerView3 = this.matchesRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.partialMatchAdapter);
        this.selectedMatch = (MTCollectionCardMatch) CollectionsKt.firstOrNull((List) this.partialMatches);
        updateSaveButtonState();
    }

    static final Unit setupPartialMatchesRecyclerView$lambda$0(CollectionStatusDialogFragment collectionStatusDialogFragment, int i, MTCollectionCardMatch match) {
        Intrinsics.checkNotNullParameter(match, "match");
        CardMatchAdapter cardMatchAdapter = collectionStatusDialogFragment.partialMatchAdapter;
        if (cardMatchAdapter != null) {
            cardMatchAdapter.updateSelection(i);
        }
        CardMatchAdapter cardMatchAdapter2 = collectionStatusDialogFragment.exactMatchAdapter;
        if (cardMatchAdapter2 != null) {
            cardMatchAdapter2.updateSelection(-1);
        }
        collectionStatusDialogFragment.selectedMatch = match;
        collectionStatusDialogFragment.updateSaveButtonState();
        return Unit.INSTANCE;
    }

    private final void setupProgressHeader() {
        int size = this.cards.size();
        TextView textView = this.progressHeader;
        TextView textView2 = null;
        if (size <= 1) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressHeader");
                textView = null;
            }
            textView.setVisibility(8);
            return;
        }
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressHeader");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.progressHeader;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressHeader");
        } else {
            textView2 = textView3;
        }
        textView2.setText(getString(R.string.card_progress, Integer.valueOf(this.currentCardIndex + 1), Integer.valueOf(this.cards.size())));
    }

    private final void showMatchesView() {
        this.isShowingMatches = true;
        ConstraintLayout constraintLayout = this.addToCollectionLayout;
        RecyclerView recyclerView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToCollectionLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.makeAProxyLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeAProxyLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(8);
        ImageView imageView = this.backImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            imageView = null;
        }
        imageView.setVisibility(0);
        setupMatchesRecyclerView();
        RecyclerView recyclerView2 = this.matchesRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchesRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(0);
    }

    private final void uncheckOtherRadioButtons(RadioButton selectedButton) {
        this.isUpdatingRadioButtons = true;
        try {
            RadioButton[] radioButtonArr = new RadioButton[3];
            RadioButton radioButton = this.addToCollectionRadioButton;
            RadioButton radioButton2 = null;
            if (radioButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addToCollectionRadioButton");
                radioButton = null;
            }
            radioButtonArr[0] = radioButton;
            RadioButton radioButton3 = this.grabFromCollectionRadioButton;
            if (radioButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("grabFromCollectionRadioButton");
                radioButton3 = null;
            }
            radioButtonArr[1] = radioButton3;
            RadioButton radioButton4 = this.makeAProxyRadioButton;
            if (radioButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("makeAProxyRadioButton");
            } else {
                radioButton2 = radioButton4;
            }
            radioButtonArr[2] = radioButton2;
            List listListOf = CollectionsKt.listOf((Object[]) radioButtonArr);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                RadioButton radioButton5 = (RadioButton) obj;
                if (!Intrinsics.areEqual(radioButton5, selectedButton) && radioButton5.isChecked()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((RadioButton) it.next()).setChecked(false);
            }
        } finally {
            this.isUpdatingRadioButtons = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateButtonStates() {
        boolean z;
        CollectionStatusChoice collectionStatusChoice = this.selectedChoice;
        int i = collectionStatusChoice == null ? -1 : WhenMappings.$EnumSwitchMapping$0[collectionStatusChoice.ordinal()];
        if (i == -1) {
            z = false;
        } else {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (this.selectedMatch != null) {
            }
            z = true;
        }
        boolean z2 = this.currentCardIndex >= this.cards.size() - 1;
        MaterialButton materialButton = this.saveButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton = null;
        }
        materialButton.setText(z2 ? getString(R.string.save) : getString(R.string.next));
        MaterialButton materialButton3 = this.saveButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton3 = null;
        }
        materialButton3.setEnabled(z);
        int color = z ? ContextCompat.getColor(requireContext(), R.color.almost_white) : ContextCompat.getColor(requireContext(), R.color.text_color);
        MaterialButton materialButton4 = this.saveButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton4 = null;
        }
        materialButton4.setTextColor(color);
        MaterialButton materialButton5 = this.previousButton;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousButton");
        } else {
            materialButton2 = materialButton5;
        }
        materialButton2.setVisibility(this.currentCardIndex <= 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSaveButtonState() {
        updateButtonStates();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_collection_status, container, false);
        this.rootView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.rootView = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.85d));
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initializeViews();
        setupProgressHeader();
        setupCardInfo();
        setupOptions();
        setupButtons();
        updateButtonStates();
    }
}
