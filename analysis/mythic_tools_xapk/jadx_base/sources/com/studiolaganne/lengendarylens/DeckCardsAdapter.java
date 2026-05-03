package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.DeckCardItem;
import com.studiolaganne.lengendarylens.DeckCardsAdapter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckCardsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005ABCDEBm\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0013J\u0014\u0010(\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\nJ\u0016\u0010,\u001a\u00020\u000b2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\nJ\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001300J\u001a\u00101\u001a\u00020\u000b2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001300J\u000e\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0007J\u000e\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020\u000bJ\u0018\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000fH\u0016J\u0018\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u000fH\u0016J\b\u0010?\u001a\u00020\u000fH\u0016J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006F"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/DeckCardItem;", "displayMode", "Lcom/studiolaganne/lengendarylens/DeckDisplayMode;", "onCardClick", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "", "deckCardMenuCallback", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "listId", "", "onExpansionChanged", "Lkotlin/Function0;", "ignoreCollection", "", "readOnly", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/DeckDisplayMode;Lkotlin/jvm/functions/Function1;Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;ILkotlin/jvm/functions/Function0;ZZ)V", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "expandedCards", "", "", "value", "selectionMode", "getSelectionMode", "selectionChecker", "getSelectionChecker", "()Lkotlin/jvm/functions/Function1;", "setSelectionChecker", "(Lkotlin/jvm/functions/Function1;)V", "setSelectionMode", "enabled", "updateItems", "newItems", "toggleCardExpansion", "card", "setOnExpansionChanged", "callback", "isCardExpanded", "getExpandedCards", "", "setExpandedCards", "expanded", "updateDisplayMode", "newMode", "updateIgnoreCollection", "ignore", "restoreAllStacks", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "Companion", "SectionHeaderViewHolder", "ListItemViewHolder", "StacksItemViewHolder", "VariantItemViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_LIST_ITEM = 2;
    public static final int VIEW_TYPE_SECTION_HEADER = 1;
    public static final int VIEW_TYPE_STACKS_ITEM = 3;
    public static final int VIEW_TYPE_VARIANT_ITEM = 4;
    private final DeckCardMenuCallback deckCardMenuCallback;
    private DeckDisplayMode displayMode;
    private final Map<String, Boolean> expandedCards;
    private boolean ignoreCollection;
    private List<? extends DeckCardItem> items;
    private final int listId;
    private final Function1<MTFullCard, Unit> onCardClick;
    private Function0<Unit> onExpansionChanged;
    private boolean readOnly;
    private Function1<? super MTFullCard, Boolean> selectionChecker;
    private boolean selectionMode;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: DeckCardsAdapter.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0018\u00010\u0005J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0006H\u0002J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardsAdapter$ListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onCardClick", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "", "deckCardMenuCallback", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "listId", "", "adapter", "Lcom/studiolaganne/lengendarylens/DeckCardsAdapter;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;ILcom/studiolaganne/lengendarylens/DeckCardsAdapter;)V", "cardName", "Landroid/widget/TextView;", "qty", "manaCost", "errorImage", "Landroid/widget/ImageView;", "dotsLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "leftLayout", "Landroid/widget/LinearLayout;", "collectionStatusView", "Lcom/studiolaganne/lengendarylens/CollectionStatusView;", "chevronImage", "statusOrChevronContainer", "commanderColorIndicatorContainer", "commanderColorIndicatorIcon", "commanderColorIndicatorMana", "selectionCheckbox", "gameChangerIcon", "currentGroupType", "", "bind", "cardItem", "Lcom/studiolaganne/lengendarylens/DeckCardItem$ListCard;", "ignoreCollection", "", "selectionMode", "selectionChecker", "areAllCardsFinalized", "card", "showCardMenu", "anchorView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ListItemViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final DeckCardsAdapter adapter;
        private final TextView cardName;
        private final ImageView chevronImage;
        private final CollectionStatusView collectionStatusView;
        private final View commanderColorIndicatorContainer;
        private final TextView commanderColorIndicatorIcon;
        private final ImageView commanderColorIndicatorMana;
        private String currentGroupType;
        private final DeckCardMenuCallback deckCardMenuCallback;
        private final ConstraintLayout dotsLayout;
        private ImageView errorImage;
        private final TextView gameChangerIcon;
        private final LinearLayout leftLayout;
        private final int listId;
        private final TextView manaCost;
        private final Function1<MTFullCard, Unit> onCardClick;
        private TextView qty;
        private final TextView selectionCheckbox;
        private final ConstraintLayout statusOrChevronContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ListItemViewHolder(View itemView, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback deckCardMenuCallback, int i, DeckCardsAdapter deckCardsAdapter) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
            this.onCardClick = onCardClick;
            this.deckCardMenuCallback = deckCardMenuCallback;
            this.listId = i;
            this.adapter = deckCardsAdapter;
            View viewFindViewById = itemView.findViewById(R.id.cardName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.cardName = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.qty);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.qty = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.manaCost);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.manaCost = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.errorImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.errorImage = (ImageView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.dotsLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.dotsLayout = (ConstraintLayout) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.leftLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.leftLayout = (LinearLayout) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.collectionStatusView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.collectionStatusView = (CollectionStatusView) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(R.id.chevronImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.chevronImage = (ImageView) viewFindViewById8;
            View viewFindViewById9 = itemView.findViewById(R.id.statusOrChevronContainer);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.statusOrChevronContainer = (ConstraintLayout) viewFindViewById9;
            View viewFindViewById10 = itemView.findViewById(R.id.commanderColorIndicatorContainer);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.commanderColorIndicatorContainer = viewFindViewById10;
            View viewFindViewById11 = itemView.findViewById(R.id.commanderColorIndicatorIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.commanderColorIndicatorIcon = (TextView) viewFindViewById11;
            View viewFindViewById12 = itemView.findViewById(R.id.commanderColorIndicatorMana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.commanderColorIndicatorMana = (ImageView) viewFindViewById12;
            View viewFindViewById13 = itemView.findViewById(R.id.selectionCheckbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.selectionCheckbox = (TextView) viewFindViewById13;
            View viewFindViewById14 = itemView.findViewById(R.id.gameChangerIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            this.gameChangerIcon = (TextView) viewFindViewById14;
        }

        public /* synthetic */ ListItemViewHolder(View view, Function1 function1, DeckCardMenuCallback deckCardMenuCallback, int i, DeckCardsAdapter deckCardsAdapter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, function1, (i2 & 4) != 0 ? null : deckCardMenuCallback, (i2 & 8) != 0 ? -1 : i, (i2 & 16) != 0 ? null : deckCardsAdapter);
        }

        private final boolean areAllCardsFinalized(MTFullCard card) {
            if (!areAllCardsFinalized$isCardFinalized(card)) {
                return false;
            }
            List<MTFullCard> variants = card.getVariants();
            if (variants == null) {
                return true;
            }
            Iterator<T> it = variants.iterator();
            while (it.hasNext()) {
                if (!areAllCardsFinalized$isCardFinalized((MTFullCard) it.next())) {
                    return false;
                }
            }
            return true;
        }

        private static final boolean areAllCardsFinalized$isCardFinalized(MTFullCard mTFullCard) {
            if (Intrinsics.areEqual((Object) mTFullCard.getProxy(), (Object) true)) {
                return true;
            }
            MTCardCollectionStatus collection = mTFullCard.getCollection();
            return collection != null ? Intrinsics.areEqual((Object) collection.getIn(), (Object) true) : false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bind$default(ListItemViewHolder listItemViewHolder, DeckCardItem.ListCard listCard, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            listItemViewHolder.bind(listCard, z, z2, function1);
        }

        static final Unit bind$lambda$2(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardCommanderColorClick(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$3(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardOpen(mTFullCard, listItemViewHolder.listId, listItemViewHolder.currentGroupType);
            }
            return Unit.INSTANCE;
        }

        static final boolean bind$lambda$4(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard, View view) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback == null) {
                return true;
            }
            deckCardMenuCallback.onDeckCardSelect(mTFullCard, listItemViewHolder.listId);
            return true;
        }

        static final void bind$lambda$5(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard, View view) {
            DeckCardsAdapter deckCardsAdapter = listItemViewHolder.adapter;
            if (deckCardsAdapter != null) {
                deckCardsAdapter.toggleCardExpansion(mTFullCard);
            }
        }

        static final Unit bind$lambda$6(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardCollectionStatus(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final void bind$lambda$8(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard, View view) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSelect(mTFullCard, listItemViewHolder.listId);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCardMenu(final MTFullCard card, View anchorView) {
            Context context = this.itemView.getContext();
            if (context instanceof DeckDetailsActivity) {
                DeckCardsAdapter deckCardsAdapter = this.adapter;
                if (deckCardsAdapter != null && deckCardsAdapter.getReadOnly()) {
                    IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.open, "\uf06e", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$0(this.f$0, card);
                        }
                    }, 28, (Object) null).show(anchorView);
                    return;
                }
                boolean z = card.getFlag() != null && CollectionsKt.contains(CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5}), card.getFlag());
                IconPopupMenu iconPopupMenuAddItem$default = IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.open, "\uf06e", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$1(this.f$0, card);
                    }
                }, 28, (Object) null), R.string.edit, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$2(this.f$0, card);
                    }
                }, 28, (Object) null).addDivider(), R.string.select_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$3(this.f$0, card);
                    }
                }, 30, (Object) null);
                if (!z) {
                    IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.move, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$4(this.f$0, card);
                        }
                    }, 30, (Object) null);
                }
                String oracleid = card.getOracleid();
                if (oracleid != null && GameUtilsKt.getCompanionsOracleIds().contains(oracleid)) {
                    Integer flag = card.getFlag();
                    final boolean z2 = flag != null && flag.intValue() == 5;
                    String string = z2 ? ((DeckDetailsActivity) context).getString(R.string.remove_as_companion) : ((DeckDetailsActivity) context).getString(R.string.set_as_companion);
                    Intrinsics.checkNotNull(string);
                    IconPopupMenu.addItem$default(iconPopupMenuAddItem$default, string, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$6(this.f$0, card, z2);
                        }
                    }, 30, (Object) null);
                }
                if (!z) {
                    IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.delete, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$7(this.f$0, card);
                        }
                    }, 24, (Object) null);
                }
                IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.eval_evaluate_card, "\ue473", false, false, Integer.valueOf(ContextCompat.getColor(context, R.color.mythic_plus)), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$8(this.f$0, card);
                    }
                }, 12, (Object) null), R.string.mythic_find_similar, "\uf002", false, false, Integer.valueOf(ContextCompat.getColor(context, R.color.mythic_plus)), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$9(this.f$0, card);
                    }
                }, 12, (Object) null), R.string.mythic_find_played_together, "\uf500", false, false, Integer.valueOf(ContextCompat.getColor(context, R.color.mythic_plus)), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.showCardMenu$lambda$10(this.f$0, card);
                    }
                }, 12, (Object) null);
                iconPopupMenuAddItem$default.show(anchorView);
            }
        }

        static final Unit showCardMenu$lambda$0(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardOpen(mTFullCard, listItemViewHolder.listId, listItemViewHolder.currentGroupType);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$1(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardOpen(mTFullCard, listItemViewHolder.listId, listItemViewHolder.currentGroupType);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$10(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardFindSimilar(mTFullCard, "deck");
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$2(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardEdit(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$3(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSelect(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$4(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardMove(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$6(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard, boolean z) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSetCompanion(mTFullCard, listItemViewHolder.listId, !z);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$7(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardDelete(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$8(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardEvaluate(mTFullCard, listItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$9(ListItemViewHolder listItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = listItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardFindSimilar(mTFullCard, "hybrid");
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x026c  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(DeckCardItem.ListCard cardItem, boolean ignoreCollection, boolean selectionMode, Function1<? super MTFullCard, Boolean> selectionChecker) {
            String strValueOf;
            boolean z;
            int i;
            Intrinsics.checkNotNullParameter(cardItem, "cardItem");
            final MTFullCard card = cardItem.getCard();
            this.currentGroupType = cardItem.getGroupType();
            TextView textView = this.qty;
            Integer quantity = cardItem.getCard().getQuantity();
            if (quantity == null || (strValueOf = String.valueOf(quantity.intValue())) == null) {
                strValueOf = "1";
            }
            textView.setText(strValueOf);
            TextView textView2 = this.cardName;
            String printed_name = card.getPrinted_name();
            if (printed_name == null) {
                printed_name = card.getName();
            }
            textView2.setText(printed_name);
            ConstraintLayout constraintLayout = this.statusOrChevronContainer;
            if (ignoreCollection) {
                constraintLayout.setVisibility(8);
                this.collectionStatusView.setVisibility(8);
                this.chevronImage.setVisibility(8);
            } else {
                constraintLayout.setVisibility(0);
                this.collectionStatusView.setVisibility(0);
                float dimension = this.itemView.getResources().getDimension(R.dimen.title_size);
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                this.collectionStatusView.setIconSize(dimension / ViewExtensionsKt.getScaledDensity(context));
                CollectionStatus collectionStatus = CollectionStatus.NO_MATCH_IN_COLLECTION;
                if (Intrinsics.areEqual((Object) card.getProxy(), (Object) true)) {
                    collectionStatus = CollectionStatus.PROXY;
                } else {
                    MTCardCollectionStatus collection = card.getCollection();
                    if (collection != null) {
                        if (Intrinsics.areEqual((Object) collection.getIn(), (Object) true)) {
                            collectionStatus = CollectionStatus.EXACT_MATCH_FETCHED;
                        } else {
                            MTCardCollectionMatches matches = collection.getMatches();
                            if (matches != null) {
                                List<MTCollectionCardMatch> exact = matches.getExact();
                                int size = exact != null ? exact.size() : 0;
                                List<MTCollectionCardMatch> all = matches.getAll();
                                int size2 = all != null ? all.size() : 0;
                                if (size > 0) {
                                    collectionStatus = CollectionStatus.EXACT_MATCH_NOT_FETCHED;
                                } else if (size2 > 0) {
                                    collectionStatus = CollectionStatus.PARTIAL_MATCH_NOT_FETCHED;
                                } else if (size == 0 && size2 == 0) {
                                    collectionStatus = CollectionStatus.NO_MATCH_IN_COLLECTION;
                                }
                            }
                        }
                    }
                }
                this.collectionStatusView.setStatus(collectionStatus);
            }
            this.errorImage.setVisibility(8);
            if (cardItem.getProblematic()) {
                this.errorImage.setVisibility(0);
                this.errorImage.setImageResource(R.drawable.warning);
                MTCardError error = cardItem.getError();
                if (error != null && Intrinsics.areEqual(error.getLegality(), "banned")) {
                    this.errorImage.setImageResource(R.drawable.exclamation);
                }
            }
            this.gameChangerIcon.setVisibility(Intrinsics.areEqual((Object) cardItem.getCard().getGame_changer(), (Object) true) ? 0 : 8);
            String mana_cost = card.getMana_cost();
            if (mana_cost == null) {
                mana_cost = "";
            }
            String strReplace$default = StringsKt.replace$default(mana_cost, "}{", "} {", false, 4, (Object) null);
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            this.manaCost.setText(new SymbolToImage(context2).stringToAttributedStringWithSymbols(strReplace$default, this.itemView.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_smaller), new CharacterStyle[0]));
            boolean zIsColorChoosingCommander = cardItem.isColorChoosingCommander();
            View view = this.commanderColorIndicatorContainer;
            if (zIsColorChoosingCommander) {
                view.setVisibility(0);
                String commanderColorOverride = cardItem.getCommanderColorOverride();
                TextView textView3 = this.commanderColorIndicatorIcon;
                if (commanderColorOverride != null) {
                    textView3.setVisibility(8);
                    this.commanderColorIndicatorMana.setVisibility(0);
                    int iHashCode = commanderColorOverride.hashCode();
                    if (iHashCode == 66) {
                        if (commanderColorOverride.equals("B")) {
                            i = R.drawable.symbol_b;
                        }
                        this.commanderColorIndicatorMana.setImageResource(i);
                    } else if (iHashCode == 71) {
                        if (commanderColorOverride.equals(GameUtils.CONDITION_GOOD)) {
                            i = R.drawable.symbol_g;
                        }
                        this.commanderColorIndicatorMana.setImageResource(i);
                    } else if (iHashCode == 82) {
                        if (commanderColorOverride.equals("R")) {
                            i = R.drawable.symbol_r;
                        }
                        this.commanderColorIndicatorMana.setImageResource(i);
                    } else if (iHashCode != 85) {
                        i = (iHashCode == 87 && commanderColorOverride.equals(ExifInterface.LONGITUDE_WEST)) ? R.drawable.symbol_w : R.drawable.symbol_c;
                        this.commanderColorIndicatorMana.setImageResource(i);
                    } else {
                        if (commanderColorOverride.equals("U")) {
                            i = R.drawable.symbol_u;
                        }
                        this.commanderColorIndicatorMana.setImageResource(i);
                    }
                } else {
                    textView3.setVisibility(0);
                    this.commanderColorIndicatorMana.setVisibility(8);
                    this.commanderColorIndicatorIcon.setText("\uf06a");
                    this.commanderColorIndicatorIcon.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.gold));
                }
                ViewExtensionsKt.setOnClickWithFade(this.commanderColorIndicatorContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.ListItemViewHolder.bind$lambda$2(this.f$0, card);
                    }
                });
            } else {
                view.setVisibility(8);
                this.commanderColorIndicatorContainer.setOnClickListener(null);
            }
            ViewExtensionsKt.setOnClickWithFade(this.leftLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckCardsAdapter.ListItemViewHolder.bind$lambda$3(this.f$0, card);
                }
            });
            DeckCardsAdapter deckCardsAdapter = this.adapter;
            if (deckCardsAdapter == null || !deckCardsAdapter.getReadOnly()) {
                this.leftLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return DeckCardsAdapter.ListItemViewHolder.bind$lambda$4(this.f$0, card, view2);
                    }
                });
            } else {
                this.leftLayout.setOnLongClickListener(null);
            }
            Integer quantity2 = card.getQuantity();
            int iIntValue = quantity2 != null ? quantity2.intValue() : 1;
            Integer variant_quantity = card.getVariant_quantity();
            int iIntValue2 = variant_quantity != null ? variant_quantity.intValue() : 0;
            if (card.getVariants() != null) {
                List<MTFullCard> variants = card.getVariants();
                Intrinsics.checkNotNull(variants);
                z = !variants.isEmpty();
            }
            if (iIntValue <= 1 || (!z && (iIntValue2 <= 0 || iIntValue2 >= iIntValue))) {
                this.chevronImage.setVisibility(8);
                if (!ignoreCollection) {
                    this.collectionStatusView.setVisibility(0);
                    ViewExtensionsKt.setOnClickWithFade(this.collectionStatusView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.ListItemViewHolder.bind$lambda$6(this.f$0, card);
                        }
                    });
                }
                this.dotsLayout.setVisibility(0);
                this.dotsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DeckCardsAdapter.ListItemViewHolder listItemViewHolder = this.f$0;
                        listItemViewHolder.showCardMenu(card, listItemViewHolder.dotsLayout);
                    }
                });
            } else {
                this.statusOrChevronContainer.setVisibility(0);
                this.chevronImage.setVisibility(0);
                this.collectionStatusView.setVisibility(8);
                DeckCardsAdapter deckCardsAdapter2 = this.adapter;
                this.chevronImage.setRotation(deckCardsAdapter2 != null && deckCardsAdapter2.isCardExpanded(card) ? 90.0f : 0.0f);
                ImageViewCompat.setImageTintList(this.chevronImage, ColorStateList.valueOf(areAllCardsFinalized(card) ? ContextCompat.getColor(this.itemView.getContext(), R.color.selected_color_new) : ContextCompat.getColor(this.itemView.getContext(), R.color.text_color)));
                this.chevronImage.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DeckCardsAdapter.ListItemViewHolder.bind$lambda$5(this.f$0, card, view2);
                    }
                });
                this.collectionStatusView.setOnClickListener(null);
                this.dotsLayout.setVisibility(4);
                this.dotsLayout.setOnClickListener(null);
            }
            if (!selectionMode) {
                this.selectionCheckbox.setVisibility(8);
                this.leftLayout.setBackgroundResource(R.drawable.black_box);
                return;
            }
            this.statusOrChevronContainer.setVisibility(0);
            this.collectionStatusView.setVisibility(8);
            this.chevronImage.setVisibility(8);
            this.selectionCheckbox.setVisibility(0);
            this.dotsLayout.setVisibility(8);
            if (selectionChecker == null || !selectionChecker.invoke(card).booleanValue()) {
                this.selectionCheckbox.setTypeface(this.itemView.getResources().getFont(R.font.fa6regular));
                this.selectionCheckbox.setText("\uf0c8");
                this.selectionCheckbox.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.light_grey));
                this.leftLayout.setBackgroundResource(R.drawable.black_box);
            } else {
                this.selectionCheckbox.setTypeface(this.itemView.getResources().getFont(R.font.fa6solid));
                this.selectionCheckbox.setText("\uf14a");
                this.selectionCheckbox.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.selection_blue));
                this.leftLayout.setBackgroundResource(R.drawable.deck_card_selected_background);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$ListItemViewHolder$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DeckCardsAdapter.ListItemViewHolder.bind$lambda$8(this.f$0, card, view2);
                }
            };
            this.leftLayout.setOnClickListener(onClickListener);
            this.leftLayout.setOnLongClickListener(null);
            this.selectionCheckbox.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: compiled from: DeckCardsAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardsAdapter$SectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "typeIcon", "Landroid/widget/ImageView;", "typeName", "Landroid/widget/TextView;", "cardCount", "bind", "", "header", "Lcom/studiolaganne/lengendarylens/DeckCardItem$SectionHeader;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView cardCount;
        private final ImageView typeIcon;
        private final TextView typeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeaderViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.typeIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.typeIcon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.typeName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.typeName = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.cardCount);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cardCount = (TextView) viewFindViewById3;
        }

        public final void bind(DeckCardItem.SectionHeader header) {
            Intrinsics.checkNotNullParameter(header, "header");
            TextView textView = this.typeName;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(DeckCardItemKt.getCardTypeNameString(context, header.getType()));
            this.cardCount.setText(String.valueOf(header.getCount()));
            if (header.isThemeGroup()) {
                int color = ContextCompat.getColor(this.itemView.getContext(), R.color.mythic_plus);
                this.typeName.setTextColor(color);
                this.cardCount.setTextColor(color);
                this.typeIcon.setVisibility(0);
                this.typeIcon.setImageResource(R.drawable.mythic_plus_small);
                ImageViewCompat.setImageTintList(this.typeIcon, null);
                return;
            }
            this.typeName.setTextColor(ContextCompat.getColor(this.itemView.getContext(), android.R.color.white));
            this.cardCount.setTextColor(ContextCompat.getColor(this.itemView.getContext(), android.R.color.white));
            int cardTypeIconResource = DeckCardItemKt.getCardTypeIconResource(header.getType());
            boolean zShouldTintIconForCardType = DeckCardItemKt.shouldTintIconForCardType(header.getType());
            ImageView imageView = this.typeIcon;
            if (zShouldTintIconForCardType) {
                ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), R.color.selected_color_new)));
            } else {
                ImageViewCompat.setImageTintList(imageView, null);
            }
            int i = R.drawable.type_unknown;
            ImageView imageView2 = this.typeIcon;
            if (cardTypeIconResource == i) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                this.typeIcon.setImageResource(cardTypeIconResource);
            }
        }
    }

    /* JADX INFO: compiled from: DeckCardsAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005J\u0006\u0010\u0018\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardsAdapter$StacksItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onCardClick", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "", "deckCardMenuCallback", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "listId", "", "readOnly", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;IZ)V", "stackedCardsView", "Lcom/studiolaganne/lengendarylens/StackedCardsView;", "bind", "stacksItem", "Lcom/studiolaganne/lengendarylens/DeckCardItem$StacksGroup;", "ignoreCollection", "selectionMode", "selectionChecker", "restoreOriginalOrder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class StacksItemViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final DeckCardMenuCallback deckCardMenuCallback;
        private final int listId;
        private final Function1<MTFullCard, Unit> onCardClick;
        private boolean readOnly;
        private final StackedCardsView stackedCardsView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public StacksItemViewHolder(View itemView, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback deckCardMenuCallback, int i, boolean z) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
            this.onCardClick = onCardClick;
            this.deckCardMenuCallback = deckCardMenuCallback;
            this.listId = i;
            this.readOnly = z;
            View viewFindViewById = itemView.findViewById(R.id.stackedCardsView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.stackedCardsView = (StackedCardsView) viewFindViewById;
        }

        public /* synthetic */ StacksItemViewHolder(View view, Function1 function1, DeckCardMenuCallback deckCardMenuCallback, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, function1, (i2 & 4) != 0 ? null : deckCardMenuCallback, (i2 & 8) != 0 ? -1 : i, (i2 & 16) != 0 ? false : z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bind$default(StacksItemViewHolder stacksItemViewHolder, DeckCardItem.StacksGroup stacksGroup, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            stacksItemViewHolder.bind(stacksGroup, z, z2, function1);
        }

        public final void bind(DeckCardItem.StacksGroup stacksItem, boolean ignoreCollection, boolean selectionMode, Function1<? super MTFullCard, Boolean> selectionChecker) {
            Intrinsics.checkNotNullParameter(stacksItem, "stacksItem");
            this.stackedCardsView.setReadOnly(this.readOnly);
            this.stackedCardsView.setGroupType(stacksItem.getGroupType());
            this.stackedCardsView.setSelectionChecker(selectionChecker);
            this.stackedCardsView.setSelectionMode(selectionMode);
            this.stackedCardsView.setCards(stacksItem.getCards(), stacksItem.getErrors(), this.onCardClick, this.deckCardMenuCallback, this.listId, ignoreCollection, stacksItem.getDeck());
        }

        public final void restoreOriginalOrder() {
            this.stackedCardsView.restoreOriginalOrder();
        }
    }

    /* JADX INFO: compiled from: DeckCardsAdapter.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t\u0018\u00010!J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0003H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardsAdapter$VariantItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "deckCardMenuCallback", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "listId", "", "readOnly", "", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;IZ)V", "variantSetImage", "Landroid/widget/ImageView;", "variantSetCode", "Landroid/widget/TextView;", "variantCollectorNumber", "variantQuantity", "variantFoilImage", "collectionStatusView", "Lcom/studiolaganne/lengendarylens/CollectionStatusView;", "dotsLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "selectionCheckbox", "currentGroupType", "", "bind", "", "variantItem", "Lcom/studiolaganne/lengendarylens/DeckCardItem$VariantCard;", "ignoreCollection", "selectionMode", "selectionChecker", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "showCardMenu", "card", "anchorView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class VariantItemViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final CollectionStatusView collectionStatusView;
        private String currentGroupType;
        private final DeckCardMenuCallback deckCardMenuCallback;
        private final ConstraintLayout dotsLayout;
        private final int listId;
        private boolean readOnly;
        private final TextView selectionCheckbox;
        private final TextView variantCollectorNumber;
        private final ImageView variantFoilImage;
        private final TextView variantQuantity;
        private final TextView variantSetCode;
        private final ImageView variantSetImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VariantItemViewHolder(View itemView, DeckCardMenuCallback deckCardMenuCallback, int i, boolean z) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.deckCardMenuCallback = deckCardMenuCallback;
            this.listId = i;
            this.readOnly = z;
            View viewFindViewById = itemView.findViewById(R.id.variantSetImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.variantSetImage = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.variantSetCode);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.variantSetCode = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.variantCollectorNumber);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.variantCollectorNumber = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.variantQuantity);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.variantQuantity = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.variantFoilImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.variantFoilImage = (ImageView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.collectionStatusView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.collectionStatusView = (CollectionStatusView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.dotsLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.dotsLayout = (ConstraintLayout) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(R.id.selectionCheckbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.selectionCheckbox = (TextView) viewFindViewById8;
        }

        public /* synthetic */ VariantItemViewHolder(View view, DeckCardMenuCallback deckCardMenuCallback, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i2 & 2) != 0 ? null : deckCardMenuCallback, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? false : z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bind$default(VariantItemViewHolder variantItemViewHolder, DeckCardItem.VariantCard variantCard, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            variantItemViewHolder.bind(variantCard, z, z2, function1);
        }

        static final Unit bind$lambda$1(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardCollectionStatus(mTFullCard, variantItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final void bind$lambda$3(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard, View view) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSelect(mTFullCard, variantItemViewHolder.listId);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCardMenu(final MTFullCard card, View anchorView) {
            Context context = this.itemView.getContext();
            if (context instanceof DeckDetailsActivity) {
                if (this.readOnly) {
                    IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.open, "\uf06e", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$0(this.f$0, card);
                        }
                    }, 28, (Object) null).show(anchorView);
                    return;
                }
                final boolean z = false;
                boolean z2 = card.getFlag() != null && CollectionsKt.contains(CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5}), card.getFlag());
                IconPopupMenu iconPopupMenuAddItem$default = IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.open, "\uf06e", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$1(this.f$0, card);
                    }
                }, 28, (Object) null), R.string.edit, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$2(this.f$0, card);
                    }
                }, 28, (Object) null).addDivider(), R.string.select_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$3(this.f$0, card);
                    }
                }, 30, (Object) null);
                if (!z2) {
                    IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.move, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$4(this.f$0, card);
                        }
                    }, 30, (Object) null);
                }
                String oracleid = card.getOracleid();
                if (oracleid != null && GameUtilsKt.getCompanionsOracleIds().contains(oracleid)) {
                    Integer flag = card.getFlag();
                    if (flag != null && flag.intValue() == 5) {
                        z = true;
                    }
                    String string = z ? ((DeckDetailsActivity) context).getString(R.string.remove_as_companion) : ((DeckDetailsActivity) context).getString(R.string.set_as_companion);
                    Intrinsics.checkNotNull(string);
                    IconPopupMenu.addItem$default(iconPopupMenuAddItem$default, string, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$6(this.f$0, card, z);
                        }
                    }, 30, (Object) null);
                }
                if (!z2) {
                    IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.delete, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckCardsAdapter.VariantItemViewHolder.showCardMenu$lambda$7(this.f$0, card);
                        }
                    }, 24, (Object) null);
                }
                iconPopupMenuAddItem$default.show(anchorView);
            }
        }

        static final Unit showCardMenu$lambda$0(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardOpen(mTFullCard, variantItemViewHolder.listId, variantItemViewHolder.currentGroupType);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$1(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardOpen(mTFullCard, variantItemViewHolder.listId, variantItemViewHolder.currentGroupType);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$2(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardEdit(mTFullCard, variantItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$3(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSelect(mTFullCard, variantItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$4(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardMove(mTFullCard, variantItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$6(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard, boolean z) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSetCompanion(mTFullCard, variantItemViewHolder.listId, !z);
            }
            return Unit.INSTANCE;
        }

        static final Unit showCardMenu$lambda$7(VariantItemViewHolder variantItemViewHolder, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = variantItemViewHolder.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardDelete(mTFullCard, variantItemViewHolder.listId);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(DeckCardItem.VariantCard variantItem, boolean ignoreCollection, boolean selectionMode, Function1<? super MTFullCard, Boolean> selectionChecker) {
            String upperCase;
            int iIntValue;
            Intrinsics.checkNotNullParameter(variantItem, "variantItem");
            final MTFullCard variant = variantItem.getVariant();
            this.currentGroupType = variantItem.getGroupType();
            Resources resources = this.itemView.getContext().getResources();
            String set_code = variant.getSet_code();
            if (set_code == null) {
                set_code = "dpa";
            }
            int identifier = resources.getIdentifier("set_" + set_code, "drawable", this.variantSetImage.getContext().getPackageName());
            ImageView imageView = this.variantSetImage;
            if (identifier != 0) {
                imageView.setImageResource(identifier);
                this.variantSetImage.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            String set_code2 = variant.getSet_code();
            if (set_code2 != null) {
                upperCase = set_code2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (upperCase == null) {
                    upperCase = "";
                }
            }
            this.variantSetCode.setText(upperCase);
            String collector_number = variant.getCollector_number();
            if (collector_number == null) {
                collector_number = "";
            }
            this.variantCollectorNumber.setText(collector_number.length() > 0 ? " #" + collector_number : "");
            if (Intrinsics.areEqual(variant.getCardid(), variantItem.getParentCard().getCardid()) && Intrinsics.areEqual(variant.getList_card_id(), variantItem.getParentCard().getList_card_id()) && variant.getVariant_quantity() != null) {
                Integer variant_quantity = variant.getVariant_quantity();
                Intrinsics.checkNotNull(variant_quantity);
                if (variant_quantity.intValue() > 0) {
                    Integer variant_quantity2 = variant.getVariant_quantity();
                    Intrinsics.checkNotNull(variant_quantity2);
                    iIntValue = variant_quantity2.intValue();
                }
            } else {
                Integer quantity = variant.getQuantity();
                iIntValue = quantity != null ? quantity.intValue() : 1;
            }
            this.variantQuantity.setText(" x" + iIntValue);
            CollectionStatusView collectionStatusView = this.collectionStatusView;
            if (ignoreCollection) {
                collectionStatusView.setVisibility(8);
            } else {
                collectionStatusView.setVisibility(0);
                float dimension = this.itemView.getResources().getDimension(R.dimen.title_size);
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                this.collectionStatusView.setIconSize(dimension / ViewExtensionsKt.getScaledDensity(context));
                CollectionStatus collectionStatus = CollectionStatus.NO_MATCH_IN_COLLECTION;
                if (Intrinsics.areEqual((Object) variant.getProxy(), (Object) true)) {
                    collectionStatus = CollectionStatus.PROXY;
                } else {
                    MTCardCollectionStatus collection = variant.getCollection();
                    if (collection != null) {
                        if (Intrinsics.areEqual((Object) collection.getIn(), (Object) true)) {
                            collectionStatus = CollectionStatus.EXACT_MATCH_FETCHED;
                        } else {
                            MTCardCollectionMatches matches = collection.getMatches();
                            if (matches != null) {
                                List<MTCollectionCardMatch> exact = matches.getExact();
                                int size = exact != null ? exact.size() : 0;
                                List<MTCollectionCardMatch> all = matches.getAll();
                                collectionStatus = size > 0 ? CollectionStatus.EXACT_MATCH_NOT_FETCHED : (all != null ? all.size() : 0) > 0 ? CollectionStatus.PARTIAL_MATCH_NOT_FETCHED : CollectionStatus.NO_MATCH_IN_COLLECTION;
                            }
                        }
                    }
                }
                this.collectionStatusView.setStatus(collectionStatus);
            }
            this.variantFoilImage.setVisibility((Intrinsics.areEqual(variant.getFinish(), "foil") || Intrinsics.areEqual(variant.getFinish(), "etched")) ? 0 : 8);
            ViewExtensionsKt.setOnClickWithFade(this.collectionStatusView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckCardsAdapter.VariantItemViewHolder.bind$lambda$1(this.f$0, variant);
                }
            });
            this.dotsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeckCardsAdapter.VariantItemViewHolder variantItemViewHolder = this.f$0;
                    variantItemViewHolder.showCardMenu(variant, variantItemViewHolder.dotsLayout);
                }
            });
            if (!selectionMode) {
                this.selectionCheckbox.setVisibility(8);
                View viewFindViewById = this.itemView.findViewById(R.id.variantInfoLayout);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                LinearLayout linearLayout = (LinearLayout) viewFindViewById;
                linearLayout.setBackgroundResource(R.drawable.black_box);
                linearLayout.setOnClickListener(null);
                return;
            }
            this.collectionStatusView.setVisibility(8);
            this.selectionCheckbox.setVisibility(0);
            this.dotsLayout.setVisibility(8);
            View viewFindViewById2 = this.itemView.findViewById(R.id.variantInfoLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById2;
            if (selectionChecker == null || !selectionChecker.invoke(variant).booleanValue()) {
                this.selectionCheckbox.setTypeface(this.itemView.getResources().getFont(R.font.fa6regular));
                this.selectionCheckbox.setText("\uf0c8");
                this.selectionCheckbox.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.light_grey));
                linearLayout2.setBackgroundResource(R.drawable.black_box);
            } else {
                this.selectionCheckbox.setTypeface(this.itemView.getResources().getFont(R.font.fa6solid));
                this.selectionCheckbox.setText("\uf14a");
                this.selectionCheckbox.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.selection_blue));
                linearLayout2.setBackgroundResource(R.drawable.deck_card_selected_background);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapter$VariantItemViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeckCardsAdapter.VariantItemViewHolder.bind$lambda$3(this.f$0, variant, view);
                }
            };
            linearLayout2.setOnClickListener(onClickListener);
            this.selectionCheckbox.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeckCardsAdapter(List<? extends DeckCardItem> items, DeckDisplayMode displayMode, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback deckCardMenuCallback, int i, Function0<Unit> function0, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        this.items = items;
        this.displayMode = displayMode;
        this.onCardClick = onCardClick;
        this.deckCardMenuCallback = deckCardMenuCallback;
        this.listId = i;
        this.onExpansionChanged = function0;
        this.ignoreCollection = z;
        this.readOnly = z2;
        this.expandedCards = new LinkedHashMap();
    }

    public /* synthetic */ DeckCardsAdapter(List list, DeckDisplayMode deckDisplayMode, Function1 function1, DeckCardMenuCallback deckCardMenuCallback, int i, Function0 function0, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, deckDisplayMode, function1, (i2 & 8) != 0 ? null : deckCardMenuCallback, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? null : function0, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? false : z2);
    }

    public final Map<String, Boolean> getExpandedCards() {
        return MapsKt.toMap(this.expandedCards);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        DeckCardItem deckCardItem = this.items.get(position);
        if (deckCardItem instanceof DeckCardItem.SectionHeader) {
            return 1;
        }
        if (deckCardItem instanceof DeckCardItem.ListCard) {
            return 2;
        }
        if (deckCardItem instanceof DeckCardItem.StacksGroup) {
            return 3;
        }
        if (deckCardItem instanceof DeckCardItem.VariantCard) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final Function1<MTFullCard, Boolean> getSelectionChecker() {
        return this.selectionChecker;
    }

    public final boolean getSelectionMode() {
        return this.selectionMode;
    }

    public final boolean isCardExpanded(MTFullCard card) {
        String cardid;
        Intrinsics.checkNotNullParameter(card, "card");
        Integer list_card_id = card.getList_card_id();
        if ((list_card_id == null || (cardid = String.valueOf(list_card_id.intValue())) == null) && (cardid = card.getCardid()) == null) {
            cardid = "";
        }
        return Intrinsics.areEqual((Object) this.expandedCards.get(cardid), (Object) true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SectionHeaderViewHolder) {
            DeckCardItem deckCardItem = this.items.get(position);
            Intrinsics.checkNotNull(deckCardItem, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.DeckCardItem.SectionHeader");
            ((SectionHeaderViewHolder) holder).bind((DeckCardItem.SectionHeader) deckCardItem);
            return;
        }
        if (holder instanceof ListItemViewHolder) {
            DeckCardItem deckCardItem2 = this.items.get(position);
            Intrinsics.checkNotNull(deckCardItem2, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.DeckCardItem.ListCard");
            ((ListItemViewHolder) holder).bind((DeckCardItem.ListCard) deckCardItem2, this.ignoreCollection, this.selectionMode, this.selectionChecker);
        } else if (holder instanceof StacksItemViewHolder) {
            DeckCardItem deckCardItem3 = this.items.get(position);
            Intrinsics.checkNotNull(deckCardItem3, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.DeckCardItem.StacksGroup");
            ((StacksItemViewHolder) holder).bind((DeckCardItem.StacksGroup) deckCardItem3, this.ignoreCollection, this.selectionMode, this.selectionChecker);
        } else if (holder instanceof VariantItemViewHolder) {
            DeckCardItem deckCardItem4 = this.items.get(position);
            Intrinsics.checkNotNull(deckCardItem4, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.DeckCardItem.VariantCard");
            ((VariantItemViewHolder) holder).bind((DeckCardItem.VariantCard) deckCardItem4, this.ignoreCollection, this.selectionMode, this.selectionChecker);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_card_section_header, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SectionHeaderViewHolder(viewInflate);
        }
        if (viewType == 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_card_list_item, parent, false);
            Intrinsics.checkNotNull(viewInflate2);
            return new ListItemViewHolder(viewInflate2, this.onCardClick, this.deckCardMenuCallback, this.listId, this);
        }
        if (viewType == 3) {
            View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_card_stacks_item, parent, false);
            Intrinsics.checkNotNull(viewInflate3);
            return new StacksItemViewHolder(viewInflate3, this.onCardClick, this.deckCardMenuCallback, this.listId, this.readOnly);
        }
        if (viewType != 4) {
            throw new IllegalArgumentException("Invalid view type: " + viewType);
        }
        View viewInflate4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_card_variant_item, parent, false);
        Intrinsics.checkNotNull(viewInflate4);
        return new VariantItemViewHolder(viewInflate4, this.deckCardMenuCallback, this.listId, this.readOnly);
    }

    public final void restoreAllStacks() {
    }

    public final void setExpandedCards(Map<String, Boolean> expanded) {
        Intrinsics.checkNotNullParameter(expanded, "expanded");
        this.expandedCards.clear();
        this.expandedCards.putAll(expanded);
    }

    public final void setOnExpansionChanged(Function0<Unit> callback) {
        this.onExpansionChanged = callback;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final void setSelectionChecker(Function1<? super MTFullCard, Boolean> function1) {
        this.selectionChecker = function1;
    }

    public final void setSelectionMode(boolean enabled) {
        this.selectionMode = enabled;
        notifyDataSetChanged();
    }

    public final void toggleCardExpansion(MTFullCard card) {
        String cardid;
        Intrinsics.checkNotNullParameter(card, "card");
        Integer list_card_id = card.getList_card_id();
        if ((list_card_id == null || (cardid = String.valueOf(list_card_id.intValue())) == null) && (cardid = card.getCardid()) == null) {
            cardid = "";
        }
        this.expandedCards.put(cardid, Boolean.valueOf(!Intrinsics.areEqual((Object) this.expandedCards.get(cardid), (Object) true)));
        Function0<Unit> function0 = this.onExpansionChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void updateDisplayMode(DeckDisplayMode newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        this.displayMode = newMode;
        notifyDataSetChanged();
    }

    public final void updateIgnoreCollection(boolean ignore) {
        this.ignoreCollection = ignore;
        notifyDataSetChanged();
    }

    public final void updateItems(List<? extends DeckCardItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }
}
