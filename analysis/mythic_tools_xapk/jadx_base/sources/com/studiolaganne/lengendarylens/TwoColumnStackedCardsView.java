package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TwoColumnStackedCardsView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u0017J6\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u0017J@\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u00172\b\u0010%\u001a\u0004\u0018\u00010\u000fJ^\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u00172\b\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J:\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u0017H\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007H\u0002JD\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00180 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J$\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0006\u00107\u001a\u00020.J\u0006\u00108\u001a\u00020\u001eJ\u0006\u00109\u001a\u00020\u001eJ&\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00122\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0001H\u0002J\u0006\u0010>\u001a\u00020\u001eJ\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0001H\u0002R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010&\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006@"}, d2 = {"Lcom/studiolaganne/lengendarylens/TwoColumnStackedCardsView;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftColumn", "rightColumn", "cardErrorPopupManager", "Lcom/studiolaganne/lengendarylens/CardErrorPopupManager;", "deckCardMenuCallback", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "listId", "ignoreCollection", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "selectionMode", "selectionChecker", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getSelectionChecker", "()Lkotlin/jvm/functions/Function1;", "setSelectionChecker", "(Lkotlin/jvm/functions/Function1;)V", "setCardGroups", "", "cardGroups", "", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "onCardClick", "errors", "Lcom/studiolaganne/lengendarylens/MTListError;", "menuCallback", "isThemeMode", "()Z", "setThemeMode", "(Z)V", "addGroupToColumn", "group", "column", "createSectionHeader", "Landroid/view/View;", "type", "", "count", "createStackedCardsView", "Lcom/studiolaganne/lengendarylens/StackedCardsView;", "cards", "showCardErrorPopup", "card", "anchorView", "hideCardErrorPopup", "cleanup", "setSelectionMode", "enabled", "checker", "setSelectionModeInColumn", "restoreAllStacks", "restoreStacksInColumn", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TwoColumnStackedCardsView extends FlexboxLayout {
    public static final int $stable = 8;
    private CardErrorPopupManager cardErrorPopupManager;
    private MTDeck deck;
    private DeckCardMenuCallback deckCardMenuCallback;
    private boolean ignoreCollection;
    private boolean isThemeMode;
    private final FlexboxLayout leftColumn;
    private int listId;
    private final FlexboxLayout rightColumn;
    private Function1<? super MTFullCard, Boolean> selectionChecker;
    private boolean selectionMode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TwoColumnStackedCardsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TwoColumnStackedCardsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoColumnStackedCardsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listId = -1;
        setFlexDirection(0);
        setFlexWrap(0);
        setJustifyContent(5);
        setAlignItems(0);
        setAlignContent(0);
        FlexboxLayout flexboxLayout = new FlexboxLayout(context);
        flexboxLayout.setFlexDirection(2);
        flexboxLayout.setFlexWrap(0);
        flexboxLayout.setJustifyContent(0);
        flexboxLayout.setAlignItems(4);
        flexboxLayout.setPadding(0, 0, GameUtils.INSTANCE.getInstance().dpToPx(4, context), 0);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(0, -2);
        layoutParams.setFlexGrow(1.0f);
        layoutParams.setFlexShrink(1.0f);
        flexboxLayout.setLayoutParams(layoutParams);
        this.leftColumn = flexboxLayout;
        FlexboxLayout flexboxLayout2 = new FlexboxLayout(context);
        flexboxLayout2.setFlexDirection(2);
        flexboxLayout2.setFlexWrap(0);
        flexboxLayout2.setJustifyContent(0);
        flexboxLayout2.setAlignItems(4);
        flexboxLayout2.setPadding(GameUtils.INSTANCE.getInstance().dpToPx(4, context), 0, 0, 0);
        FlexboxLayout.LayoutParams layoutParams2 = new FlexboxLayout.LayoutParams(0, -2);
        layoutParams2.setFlexGrow(1.0f);
        layoutParams2.setFlexShrink(1.0f);
        flexboxLayout2.setLayoutParams(layoutParams2);
        this.rightColumn = flexboxLayout2;
        addView(flexboxLayout);
        addView(flexboxLayout2);
        if (context instanceof DeckDetailsActivity) {
            this.cardErrorPopupManager = new CardErrorPopupManager((DeckDetailsActivity) context);
        }
    }

    public /* synthetic */ TwoColumnStackedCardsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void addGroupToColumn(MTCardGroup group, FlexboxLayout column, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick) {
        column.addView(createSectionHeader(group.getType(), group.getTotal_count()));
        List<MTFullCard> cards = group.getCards();
        if (cards == null || cards.isEmpty()) {
            return;
        }
        StackedCardsView stackedCardsViewCreateStackedCardsView = createStackedCardsView(cards, errors, onCardClick, (StringsKt.equals(group.getType(), "commander", true) || StringsKt.equals(group.getType(), "commanders", true)) ? this.deck : null);
        if (this.isThemeMode) {
            stackedCardsViewCreateStackedCardsView.setGroupType(group.getType());
        }
        column.addView(stackedCardsViewCreateStackedCardsView);
    }

    private final View createSectionHeader(String type, int count) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.deck_card_section_header, (ViewGroup) null, false);
        View viewFindViewById = viewInflate.findViewById(R.id.typeIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.typeName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.cardCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById3;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(DeckCardItemKt.getCardTypeNameString(context, type));
        textView2.setText(String.valueOf(count));
        if (this.isThemeMode) {
            int color = ContextCompat.getColor(getContext(), R.color.mythic_plus);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.mythic_plus_small);
            ImageViewCompat.setImageTintList(imageView, null);
        } else {
            textView.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
            textView2.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
            int cardTypeIconResource = DeckCardItemKt.getCardTypeIconResource(type);
            if (DeckCardItemKt.shouldTintIconForCardType(type)) {
                ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.selected_color_new)));
            } else {
                ImageViewCompat.setImageTintList(imageView, null);
            }
            if (cardTypeIconResource != R.drawable.type_unknown) {
                imageView.setVisibility(0);
                imageView.setImageResource(cardTypeIconResource);
            } else {
                imageView.setVisibility(8);
            }
        }
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-1, -2);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        layoutParams.setMargins(0, 0, 0, companion.dpToPx(8, context2));
        viewInflate.setLayoutParams(layoutParams);
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    private final StackedCardsView createStackedCardsView(List<MTFullCard> cards, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick, MTDeck deck) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        StackedCardsView stackedCardsView = new StackedCardsView(context, null, 0, 6, null);
        stackedCardsView.setSelectionChecker(this.selectionChecker);
        stackedCardsView.setSelectionMode(this.selectionMode);
        stackedCardsView.setCards(cards, errors, onCardClick, this.deckCardMenuCallback, this.listId, this.ignoreCollection, deck);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-1, -2);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        layoutParams.setMargins(0, 0, 0, companion.dpToPx(16, context2));
        stackedCardsView.setLayoutParams(layoutParams);
        return stackedCardsView;
    }

    static /* synthetic */ StackedCardsView createStackedCardsView$default(TwoColumnStackedCardsView twoColumnStackedCardsView, List list, List list2, Function1 function1, MTDeck mTDeck, int i, Object obj) {
        if ((i & 8) != 0) {
            mTDeck = null;
        }
        return twoColumnStackedCardsView.createStackedCardsView(list, list2, function1, mTDeck);
    }

    private final void restoreStacksInColumn(FlexboxLayout column) {
        int childCount = column.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = column.getChildAt(i);
            if (childAt instanceof StackedCardsView) {
                ((StackedCardsView) childAt).restoreOriginalOrder();
            }
        }
    }

    public static /* synthetic */ void setCardGroups$default(TwoColumnStackedCardsView twoColumnStackedCardsView, List list, List list2, Function1 function1, DeckCardMenuCallback deckCardMenuCallback, int i, boolean z, MTDeck mTDeck, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = false;
        }
        twoColumnStackedCardsView.setCardGroups(list, list2, function1, deckCardMenuCallback, i, z, (i2 & 64) != 0 ? null : mTDeck);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setSelectionMode$default(TwoColumnStackedCardsView twoColumnStackedCardsView, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        twoColumnStackedCardsView.setSelectionMode(z, function1);
    }

    private final void setSelectionModeInColumn(FlexboxLayout column) {
        int childCount = column.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = column.getChildAt(i);
            if (childAt instanceof StackedCardsView) {
                StackedCardsView stackedCardsView = (StackedCardsView) childAt;
                stackedCardsView.setSelectionChecker(this.selectionChecker);
                stackedCardsView.setSelectionMode(this.selectionMode);
            }
        }
    }

    public final void cleanup() {
        CardErrorPopupManager cardErrorPopupManager = this.cardErrorPopupManager;
        if (cardErrorPopupManager != null) {
            cardErrorPopupManager.cleanup();
        }
        this.cardErrorPopupManager = null;
    }

    public final Function1<MTFullCard, Boolean> getSelectionChecker() {
        return this.selectionChecker;
    }

    public final void hideCardErrorPopup() {
        CardErrorPopupManager cardErrorPopupManager = this.cardErrorPopupManager;
        if (cardErrorPopupManager != null) {
            cardErrorPopupManager.hideErrorPopup();
        }
    }

    /* JADX INFO: renamed from: isThemeMode, reason: from getter */
    public final boolean getIsThemeMode() {
        return this.isThemeMode;
    }

    public final void restoreAllStacks() {
        restoreStacksInColumn(this.leftColumn);
        restoreStacksInColumn(this.rightColumn);
    }

    public final void setCardGroups(List<MTCardGroup> cardGroups, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick) {
        Intrinsics.checkNotNullParameter(cardGroups, "cardGroups");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        setCardGroups$default(this, cardGroups, errors, onCardClick, null, -1, false, null, 96, null);
    }

    public final void setCardGroups(List<MTCardGroup> cardGroups, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback menuCallback) {
        Intrinsics.checkNotNullParameter(cardGroups, "cardGroups");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        setCardGroups$default(this, cardGroups, errors, onCardClick, menuCallback, -1, false, null, 96, null);
    }

    public final void setCardGroups(List<MTCardGroup> cardGroups, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback menuCallback, int listId, boolean ignoreCollection, MTDeck deck) {
        Intrinsics.checkNotNullParameter(cardGroups, "cardGroups");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        Log.d("TwoColumnStackedCardsView", "setCardGroups called with " + cardGroups.size() + " groups and " + errors.size() + " errors");
        this.deckCardMenuCallback = menuCallback;
        this.listId = listId;
        this.ignoreCollection = ignoreCollection;
        this.deck = deck;
        this.leftColumn.removeAllViews();
        this.rightColumn.removeAllViews();
        int i = 0;
        for (Object obj : cardGroups) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MTCardGroup mTCardGroup = (MTCardGroup) obj;
            int i3 = i % 2;
            FlexboxLayout flexboxLayout = i3 == 0 ? this.leftColumn : this.rightColumn;
            Log.d("TwoColumnStackedCardsView", "Adding group " + mTCardGroup.getType() + " to " + (i3 == 0 ? ViewHierarchyConstants.DIMENSION_LEFT_KEY : "right") + " column");
            addGroupToColumn(mTCardGroup, flexboxLayout, errors, onCardClick);
            i = i2;
        }
        requestLayout();
    }

    public final void setCardGroups(List<MTCardGroup> cardGroups, Function1<? super MTFullCard, Unit> onCardClick) {
        Intrinsics.checkNotNullParameter(cardGroups, "cardGroups");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        setCardGroups$default(this, cardGroups, CollectionsKt.emptyList(), onCardClick, null, -1, false, null, 96, null);
    }

    public final void setSelectionChecker(Function1<? super MTFullCard, Boolean> function1) {
        this.selectionChecker = function1;
    }

    public final void setSelectionMode(boolean enabled, Function1<? super MTFullCard, Boolean> checker) {
        this.selectionMode = enabled;
        if (checker != null) {
            this.selectionChecker = checker;
        }
        setSelectionModeInColumn(this.leftColumn);
        setSelectionModeInColumn(this.rightColumn);
    }

    public final void setThemeMode(boolean z) {
        this.isThemeMode = z;
    }

    public final void showCardErrorPopup(MTFullCard card, List<MTListError> errors, View anchorView) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        CardErrorPopupManager cardErrorPopupManager = this.cardErrorPopupManager;
        if (cardErrorPopupManager != null) {
            cardErrorPopupManager.showCardErrorPopup(card, errors, anchorView);
        }
    }
}
