package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.StackedCardsView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackedCardsView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\\B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J0\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0014J(\u0010=\u001a\u0002042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020#0\u00172\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002040\"J6\u0010=\u001a\u0002042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020#0\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002040\"J@\u0010=\u001a\u0002042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020#0\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002040\"2\b\u0010@\u001a\u0004\u0018\u00010\u001cJ^\u0010=\u001a\u0002042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020#0\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002040\"2\b\u0010@\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJB\u0010C\u001a\u00060\fR\u00020\u00002\u0006\u0010D\u001a\u00020#2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002040\"2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010.H\u0002J\u0018\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020H2\u0006\u0010D\u001a\u00020#H\u0002J\u0014\u0010I\u001a\u0002042\n\u0010J\u001a\u00060\fR\u00020\u0000H\u0002J\u0006\u0010K\u001a\u000204J\u000e\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020\u0007J$\u0010N\u001a\u0002042\u0006\u0010D\u001a\u00020#2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u000204J\u0018\u0010R\u001a\u0002042\u0006\u0010D\u001a\u00020#2\u0006\u0010O\u001a\u00020PH\u0002J\u000e\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\u001fJ\b\u0010U\u001a\u000204H\u0002J\u0006\u0010V\u001a\u000204J\u0010\u0010W\u001a\u00020\u001f2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020YH\u0016R\u0018\u0010\n\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\fR\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006]"}, d2 = {"Lcom/studiolaganne/lengendarylens/StackedCardsView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardViews", "", "Lcom/studiolaganne/lengendarylens/StackedCardsView$DeckCardImageContainer;", "originalCardOrder", "cardZOrder", "", "cardWidth", "cardHeight", "stackOffsetY", "horizontalMargin", "maxVisibleCards", "frontCard", "errors", "", "Lcom/studiolaganne/lengendarylens/MTListError;", "cardErrorPopupManager", "Lcom/studiolaganne/lengendarylens/CardErrorPopupManager;", "deckCardMenuCallback", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "listId", "ignoreCollection", "", "selectionMode", "selectionChecker", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getSelectionChecker", "()Lkotlin/jvm/functions/Function1;", "setSelectionChecker", "(Lkotlin/jvm/functions/Function1;)V", "readOnly", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "groupType", "", "getGroupType", "()Ljava/lang/String;", "setGroupType", "(Ljava/lang/String;)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "setCards", "cards", "onCardClick", "menuCallback", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "createCardView", "card", "commanderColorOverride", "loadCardImage", "cardView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "bringCardToFront", "clickedCard", "restoreOriginalOrder", "setMaxVisibleCards", "max", "showCardErrorPopup", "anchorView", "Landroid/view/View;", "hideCardErrorPopup", "showCardMenu", "setSelectionMode", "enabled", "updateSelectionVisuals", "cleanup", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "DeckCardImageContainer", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StackedCardsView extends ViewGroup {
    public static final int $stable = 8;
    private CardErrorPopupManager cardErrorPopupManager;
    private int cardHeight;
    private final List<DeckCardImageContainer> cardViews;
    private int cardWidth;
    private final Map<DeckCardImageContainer, Integer> cardZOrder;
    private DeckCardMenuCallback deckCardMenuCallback;
    private List<MTListError> errors;
    private DeckCardImageContainer frontCard;
    private String groupType;
    private int horizontalMargin;
    private boolean ignoreCollection;
    private int listId;
    private int maxVisibleCards;
    private final List<DeckCardImageContainer> originalCardOrder;
    private boolean readOnly;
    private Function1<? super MTFullCard, Boolean> selectionChecker;
    private boolean selectionMode;
    private int stackOffsetY;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StackedCardsView.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u000109R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0011\u0010\u0019\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013R\u0011\u0010'\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\rR\u0011\u0010)\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006:"}, d2 = {"Lcom/studiolaganne/lengendarylens/StackedCardsView$DeckCardImageContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Lcom/studiolaganne/lengendarylens/StackedCardsView;Landroid/content/Context;)V", "cardImage", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "getCardImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageView;", "foilImage", "Landroid/widget/ImageView;", "getFoilImage", "()Landroid/widget/ImageView;", "cornerView", "getCornerView", "qtyTextView", "Landroid/widget/TextView;", "getQtyTextView", "()Landroid/widget/TextView;", "errorLayout", "getErrorLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "errorImage", "getErrorImage", "menuLayout", "getMenuLayout", "collectionStatusView", "Lcom/studiolaganne/lengendarylens/CollectionStatusView;", "getCollectionStatusView", "()Lcom/studiolaganne/lengendarylens/CollectionStatusView;", "collectionStatusLayout", "getCollectionStatusLayout", "commanderColorOverlayContainer", "Landroid/view/View;", "getCommanderColorOverlayContainer", "()Landroid/view/View;", "commanderColorOverlayIcon", "getCommanderColorOverlayIcon", "commanderColorOverlayMana", "getCommanderColorOverlayMana", "selectionBorderView", "getSelectionBorderView", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getCard", "()Lcom/studiolaganne/lengendarylens/MTFullCard;", "setCard", "(Lcom/studiolaganne/lengendarylens/MTFullCard;)V", "bind", "", "errors", "", "Lcom/studiolaganne/lengendarylens/MTListError;", "ignoreCollection", "", "commanderColorOverride", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    final class DeckCardImageContainer extends ConstraintLayout {
        private MTFullCard card;
        private final LoadingImageView cardImage;
        private final ConstraintLayout collectionStatusLayout;
        private final CollectionStatusView collectionStatusView;
        private final View commanderColorOverlayContainer;
        private final TextView commanderColorOverlayIcon;
        private final ImageView commanderColorOverlayMana;
        private final ImageView cornerView;
        private final ImageView errorImage;
        private final ConstraintLayout errorLayout;
        private final ImageView foilImage;
        private final ConstraintLayout menuLayout;
        private final TextView qtyTextView;
        private final View selectionBorderView;
        final /* synthetic */ StackedCardsView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeckCardImageContainer(StackedCardsView stackedCardsView, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = stackedCardsView;
            LayoutInflater.from(context).inflate(R.layout.deck_card_image_item, (ViewGroup) this, true);
            View viewFindViewById = findViewById(R.id.cardImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.cardImage = (LoadingImageView) viewFindViewById;
            View viewFindViewById2 = findViewById(R.id.foilEffectImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.foilImage = (ImageView) viewFindViewById2;
            View viewFindViewById3 = findViewById(R.id.cornerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cornerView = (ImageView) viewFindViewById3;
            View viewFindViewById4 = findViewById(R.id.qtyTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.qtyTextView = (TextView) viewFindViewById4;
            View viewFindViewById5 = findViewById(R.id.errorLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.errorLayout = (ConstraintLayout) viewFindViewById5;
            View viewFindViewById6 = findViewById(R.id.errorImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.errorImage = (ImageView) viewFindViewById6;
            View viewFindViewById7 = findViewById(R.id.menuLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.menuLayout = (ConstraintLayout) viewFindViewById7;
            View viewFindViewById8 = findViewById(R.id.collectionStatusView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.collectionStatusView = (CollectionStatusView) viewFindViewById8;
            View viewFindViewById9 = findViewById(R.id.collectionStatusLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.collectionStatusLayout = (ConstraintLayout) viewFindViewById9;
            View viewFindViewById10 = findViewById(R.id.commanderColorOverlayContainer);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.commanderColorOverlayContainer = viewFindViewById10;
            View viewFindViewById11 = findViewById(R.id.commanderColorOverlayIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.commanderColorOverlayIcon = (TextView) viewFindViewById11;
            View viewFindViewById12 = findViewById(R.id.commanderColorOverlayMana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.commanderColorOverlayMana = (ImageView) viewFindViewById12;
            View viewFindViewById13 = findViewById(R.id.selectionBorderView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.selectionBorderView = viewFindViewById13;
        }

        public static /* synthetic */ void bind$default(DeckCardImageContainer deckCardImageContainer, MTFullCard mTFullCard, List list, boolean z, String str, int i, Object obj) {
            if ((i & 8) != 0) {
                str = null;
            }
            deckCardImageContainer.bind(mTFullCard, list, z, str);
        }

        static final void bind$lambda$3(DeckCardImageContainer deckCardImageContainer, MTFullCard mTFullCard, List list, View view) {
            for (ViewParent parent = deckCardImageContainer.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof StackedCardsView) {
                    ((StackedCardsView) parent).showCardErrorPopup(mTFullCard, list, deckCardImageContainer);
                    return;
                } else {
                    if (parent instanceof TwoColumnStackedCardsView) {
                        ((TwoColumnStackedCardsView) parent).showCardErrorPopup(mTFullCard, list, deckCardImageContainer);
                        return;
                    }
                }
            }
        }

        static final Unit bind$lambda$4(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardCollectionStatus(mTFullCard, stackedCardsView.listId);
            }
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$7(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
            DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardCommanderColorClick(mTFullCard, stackedCardsView.listId);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:120:0x0219  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(final MTFullCard card, final List<MTListError> errors, boolean ignoreCollection, String commanderColorOverride) {
            boolean z;
            int i;
            Object next;
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.card = card;
            ConstraintLayout constraintLayout = this.collectionStatusLayout;
            if (ignoreCollection) {
                constraintLayout.setVisibility(8);
            } else {
                constraintLayout.setVisibility(0);
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
            this.this$0.loadCardImage(this.cardImage, card);
            this.foilImage.setVisibility(8);
            if (Intrinsics.areEqual(card.getFinish(), "foil") || Intrinsics.areEqual(card.getFinish(), "etched")) {
                this.foilImage.setVisibility(0);
            }
            Integer quantity = card.getQuantity();
            int iIntValue = quantity != null ? quantity.intValue() : 1;
            ImageView imageView = this.cornerView;
            if (iIntValue > 1) {
                imageView.setVisibility(0);
                this.qtyTextView.setVisibility(0);
                this.qtyTextView.setText(String.valueOf(iIntValue));
            } else {
                imageView.setVisibility(8);
                this.qtyTextView.setVisibility(8);
            }
            int i2 = R.drawable.warning;
            Iterator<MTListError> it = errors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                MTListError next2 = it.next();
                List<String> problematic_cards = next2.getProblematic_cards();
                if (problematic_cards != null && CollectionsKt.contains(problematic_cards, card.getCardid())) {
                    List<MTCardError> cards = next2.getCards();
                    if (cards != null) {
                        Iterator<T> it2 = cards.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it2.next();
                                if (Intrinsics.areEqual(((MTCardError) next).getCardid(), card.getCardid())) {
                                    break;
                                }
                            }
                        }
                        MTCardError mTCardError = (MTCardError) next;
                        if (mTCardError != null && Intrinsics.areEqual(mTCardError.getLegality(), "banned")) {
                            i2 = R.drawable.exclamation;
                        }
                    }
                    z = true;
                }
            }
            ConstraintLayout constraintLayout2 = this.errorLayout;
            if (z) {
                constraintLayout2.setVisibility(0);
                this.errorImage.setImageResource(i2);
                this.errorLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$DeckCardImageContainer$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StackedCardsView.DeckCardImageContainer.bind$lambda$3(this.f$0, card, errors, view);
                    }
                });
            } else {
                constraintLayout2.setVisibility(8);
                this.errorLayout.setOnClickListener(null);
            }
            CollectionStatusView collectionStatusView = this.collectionStatusView;
            final StackedCardsView stackedCardsView = this.this$0;
            ViewExtensionsKt.setOnClickWithFade(collectionStatusView, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$DeckCardImageContainer$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.DeckCardImageContainer.bind$lambda$4(stackedCardsView, card);
                }
            });
            ConstraintLayout constraintLayout3 = this.menuLayout;
            final StackedCardsView stackedCardsView2 = this.this$0;
            constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$DeckCardImageContainer$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    stackedCardsView2.showCardMenu(card, this.menuLayout);
                }
            });
            if (this.this$0.selectionMode) {
                this.collectionStatusLayout.setVisibility(8);
                this.menuLayout.setVisibility(8);
                Function1<MTFullCard, Boolean> selectionChecker = this.this$0.getSelectionChecker();
                this.selectionBorderView.setVisibility(selectionChecker != null && selectionChecker.invoke(card).booleanValue() ? 0 : 8);
            } else {
                this.selectionBorderView.setVisibility(8);
                this.menuLayout.setVisibility(0);
            }
            String oracleid = card.getOracleid();
            if (oracleid == null || !GameUtilsKt.getColorChoosingCommanders().contains(oracleid)) {
                this.commanderColorOverlayContainer.setVisibility(8);
                this.commanderColorOverlayContainer.setOnClickListener(null);
                return;
            }
            this.commanderColorOverlayContainer.setVisibility(0);
            TextView textView = this.commanderColorOverlayIcon;
            if (commanderColorOverride != null) {
                textView.setVisibility(8);
                this.commanderColorOverlayMana.setVisibility(0);
                int iHashCode = commanderColorOverride.hashCode();
                if (iHashCode == 66) {
                    if (commanderColorOverride.equals("B")) {
                        i = R.drawable.symbol_b;
                    }
                    this.commanderColorOverlayMana.setImageResource(i);
                } else if (iHashCode == 71) {
                    if (commanderColorOverride.equals(GameUtils.CONDITION_GOOD)) {
                        i = R.drawable.symbol_g;
                    }
                    this.commanderColorOverlayMana.setImageResource(i);
                } else if (iHashCode == 82) {
                    if (commanderColorOverride.equals("R")) {
                        i = R.drawable.symbol_r;
                    }
                    this.commanderColorOverlayMana.setImageResource(i);
                } else if (iHashCode != 85) {
                    i = (iHashCode == 87 && commanderColorOverride.equals(ExifInterface.LONGITUDE_WEST)) ? R.drawable.symbol_w : R.drawable.symbol_c;
                    this.commanderColorOverlayMana.setImageResource(i);
                } else {
                    if (commanderColorOverride.equals("U")) {
                        i = R.drawable.symbol_u;
                    }
                    this.commanderColorOverlayMana.setImageResource(i);
                }
            } else {
                textView.setVisibility(0);
                this.commanderColorOverlayMana.setVisibility(8);
                this.commanderColorOverlayIcon.setText("\uf06a");
                this.commanderColorOverlayIcon.setTextColor(ContextCompat.getColor(getContext(), R.color.gold));
            }
            View view = this.commanderColorOverlayContainer;
            final StackedCardsView stackedCardsView3 = this.this$0;
            ViewExtensionsKt.setOnClickWithFade(view, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$DeckCardImageContainer$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.DeckCardImageContainer.bind$lambda$7(stackedCardsView3, card);
                }
            });
        }

        public final MTFullCard getCard() {
            return this.card;
        }

        public final LoadingImageView getCardImage() {
            return this.cardImage;
        }

        public final ConstraintLayout getCollectionStatusLayout() {
            return this.collectionStatusLayout;
        }

        public final CollectionStatusView getCollectionStatusView() {
            return this.collectionStatusView;
        }

        public final View getCommanderColorOverlayContainer() {
            return this.commanderColorOverlayContainer;
        }

        public final TextView getCommanderColorOverlayIcon() {
            return this.commanderColorOverlayIcon;
        }

        public final ImageView getCommanderColorOverlayMana() {
            return this.commanderColorOverlayMana;
        }

        public final ImageView getCornerView() {
            return this.cornerView;
        }

        public final ImageView getErrorImage() {
            return this.errorImage;
        }

        public final ConstraintLayout getErrorLayout() {
            return this.errorLayout;
        }

        public final ImageView getFoilImage() {
            return this.foilImage;
        }

        public final ConstraintLayout getMenuLayout() {
            return this.menuLayout;
        }

        public final TextView getQtyTextView() {
            return this.qtyTextView;
        }

        public final View getSelectionBorderView() {
            return this.selectionBorderView;
        }

        public final void setCard(MTFullCard mTFullCard) {
            this.card = mTFullCard;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StackedCardsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StackedCardsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackedCardsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardViews = new ArrayList();
        this.originalCardOrder = new ArrayList();
        this.cardZOrder = new LinkedHashMap();
        this.maxVisibleCards = 10;
        this.errors = CollectionsKt.emptyList();
        this.listId = -1;
        this.cardWidth = GameUtils.INSTANCE.getInstance().dpToPx(60, context);
        this.cardHeight = GameUtils.INSTANCE.getInstance().dpToPx(84, context);
        this.stackOffsetY = GameUtils.INSTANCE.getInstance().dpToPx(12, context);
        this.horizontalMargin = GameUtils.INSTANCE.getInstance().dpToPx(2, context);
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        if (context instanceof DeckDetailsActivity) {
            this.cardErrorPopupManager = new CardErrorPopupManager((DeckDetailsActivity) context);
        }
    }

    public /* synthetic */ StackedCardsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void bringCardToFront(DeckCardImageContainer clickedCard) {
        Log.d("StackedCardsView", "bringCardToFront called for: " + clickedCard);
        Log.d("StackedCardsView", "Current Z-orders: " + this.cardZOrder);
        if (Intrinsics.areEqual(this.frontCard, clickedCard)) {
            Log.d("StackedCardsView", "Card is already in front");
            return;
        }
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) this.cardZOrder.values());
        int iIntValue = num != null ? num.intValue() : 0;
        Log.d("StackedCardsView", "Max Z-order: " + iIntValue);
        Integer num2 = this.cardZOrder.get(clickedCard);
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        if (iIntValue2 >= iIntValue) {
            Log.d("StackedCardsView", "Card already has highest Z-order: " + iIntValue2);
            return;
        }
        int i = iIntValue + 1;
        this.cardZOrder.put(clickedCard, Integer.valueOf(i));
        this.frontCard = clickedCard;
        Log.d("StackedCardsView", "Card Z-order updated to " + i);
        Log.d("StackedCardsView", "New Z-orders: " + this.cardZOrder);
        clickedCard.setElevation(i);
        invalidate();
    }

    private final DeckCardImageContainer createCardView(final MTFullCard card, List<MTListError> errors, final Function1<? super MTFullCard, Unit> onCardClick, String commanderColorOverride) {
        String lowerCase;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final DeckCardImageContainer deckCardImageContainer = new DeckCardImageContainer(this, context);
        deckCardImageContainer.setLayoutParams(new ViewGroup.LayoutParams(this.cardWidth, this.cardHeight));
        deckCardImageContainer.getCardImage().setAutoLoad(false);
        LoadingImageView cardImage = deckCardImageContainer.getCardImage();
        String set_code = card.getSet_code();
        if (set_code != null) {
            lowerCase = set_code.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        cardImage.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        deckCardImageContainer.getCardImage().reset();
        deckCardImageContainer.setBackgroundColor(0);
        deckCardImageContainer.bind(card, errors, this.ignoreCollection, commanderColorOverride);
        deckCardImageContainer.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StackedCardsView.createCardView$lambda$0(this.f$0, card, deckCardImageContainer, onCardClick, view);
            }
        });
        deckCardImageContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return StackedCardsView.createCardView$lambda$1(this.f$0, card, view);
            }
        });
        return deckCardImageContainer;
    }

    static /* synthetic */ DeckCardImageContainer createCardView$default(StackedCardsView stackedCardsView, MTFullCard mTFullCard, List list, Function1 function1, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        return stackedCardsView.createCardView(mTFullCard, list, function1, str);
    }

    static final void createCardView$lambda$0(StackedCardsView stackedCardsView, MTFullCard mTFullCard, DeckCardImageContainer deckCardImageContainer, Function1 function1, View view) {
        if (stackedCardsView.selectionMode) {
            DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
            if (deckCardMenuCallback != null) {
                deckCardMenuCallback.onDeckCardSelect(mTFullCard, stackedCardsView.listId);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(stackedCardsView.frontCard, deckCardImageContainer)) {
            stackedCardsView.restoreOriginalOrder();
            return;
        }
        stackedCardsView.restoreOriginalOrder();
        stackedCardsView.bringCardToFront(deckCardImageContainer);
        function1.invoke(mTFullCard);
    }

    static final boolean createCardView$lambda$1(StackedCardsView stackedCardsView, MTFullCard mTFullCard, View view) {
        DeckCardMenuCallback deckCardMenuCallback;
        if (stackedCardsView.selectionMode || stackedCardsView.readOnly || (deckCardMenuCallback = stackedCardsView.deckCardMenuCallback) == null) {
            return true;
        }
        deckCardMenuCallback.onDeckCardSelect(mTFullCard, stackedCardsView.listId);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadCardImage(LoadingImageView cardView, MTFullCard card) {
        MTImageURIs mTImageURIs;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String gatherer2;
        MTImageURIs mTImageURIs3;
        String normal;
        MTImageURIs mTImageURIs4;
        String normal2;
        List<MTImageURIs> images = card.getImages();
        if (images == null || (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) == null || (normal2 = mTImageURIs4.getNormal()) == null) {
            List<MTImageURIs> images2 = card.getImages();
            if (images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer = mTImageURIs.getGatherer()) != null) {
                cardView.loadImage(gatherer);
            }
        } else {
            cardView.loadImage(normal2);
        }
        List<MTImageURIs> images3 = card.getImages();
        if (images3 == null || images3.isEmpty()) {
            List<MTImageURIs> en_images = card.getEn_images();
            if (en_images != null && (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) != null && (normal = mTImageURIs3.getNormal()) != null) {
                cardView.loadImage(normal);
                return;
            }
            List<MTImageURIs> en_images2 = card.getEn_images();
            if (en_images2 == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) == null || (gatherer2 = mTImageURIs2.getGatherer()) == null) {
                return;
            }
            cardView.loadImage(gatherer2);
        }
    }

    private static final String setCards$colorOverrideForCard(MTDeck mTDeck, MTFullCard mTFullCard) {
        Integer flag = mTFullCard.getFlag();
        if (flag != null && flag.intValue() == 1) {
            if (mTDeck != null) {
                return mTDeck.getCommander_color_override();
            }
            return null;
        }
        Integer flag2 = mTFullCard.getFlag();
        if (flag2 == null || flag2.intValue() != 2 || mTDeck == null) {
            return null;
        }
        return mTDeck.getPartner_color_override();
    }

    public static /* synthetic */ void setCards$default(StackedCardsView stackedCardsView, List list, List list2, Function1 function1, DeckCardMenuCallback deckCardMenuCallback, int i, boolean z, MTDeck mTDeck, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = false;
        }
        stackedCardsView.setCards(list, list2, function1, deckCardMenuCallback, i, z, (i2 & 64) != 0 ? null : mTDeck);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCardMenu(final MTFullCard card, View anchorView) {
        if (getContext() instanceof DeckDetailsActivity) {
            if (this.readOnly) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.open, "\uf06e", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StackedCardsView.showCardMenu$lambda$0(this.f$0, card);
                    }
                }, 28, (Object) null).show(anchorView);
                return;
            }
            final boolean z = false;
            boolean z2 = card.getFlag() != null && CollectionsKt.contains(CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5}), card.getFlag());
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            IconPopupMenu iconPopupMenuAddItem$default = IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context2), R.string.open, "\uf06e", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.showCardMenu$lambda$1(this.f$0, card);
                }
            }, 28, (Object) null), R.string.edit, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.showCardMenu$lambda$2(this.f$0, card);
                }
            }, 28, (Object) null).addDivider(), R.string.select_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.showCardMenu$lambda$3(this.f$0, card);
                }
            }, 30, (Object) null);
            if (!z2) {
                IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.move, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StackedCardsView.showCardMenu$lambda$4(this.f$0, card);
                    }
                }, 30, (Object) null);
            }
            String oracleid = card.getOracleid();
            if (oracleid != null && GameUtilsKt.getCompanionsOracleIds().contains(oracleid)) {
                Integer flag = card.getFlag();
                if (flag != null && flag.intValue() == 5) {
                    z = true;
                }
                String string = z ? getContext().getString(R.string.remove_as_companion) : getContext().getString(R.string.set_as_companion);
                Intrinsics.checkNotNull(string);
                IconPopupMenu.addItem$default(iconPopupMenuAddItem$default, string, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StackedCardsView.showCardMenu$lambda$6(this.f$0, card, z);
                    }
                }, 30, (Object) null);
            }
            if (!z2) {
                IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.delete, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StackedCardsView.showCardMenu$lambda$7(this.f$0, card);
                    }
                }, 24, (Object) null);
            }
            IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(iconPopupMenuAddItem$default.addDivider(), R.string.eval_evaluate_card, "\ue473", false, false, Integer.valueOf(ContextCompat.getColor(getContext(), R.color.mythic_plus)), new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.showCardMenu$lambda$8(this.f$0, card);
                }
            }, 12, (Object) null), R.string.mythic_find_similar, "\uf002", false, false, Integer.valueOf(ContextCompat.getColor(getContext(), R.color.mythic_plus)), new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.showCardMenu$lambda$9(this.f$0, card);
                }
            }, 12, (Object) null), R.string.mythic_find_played_together, "\uf500", false, false, Integer.valueOf(ContextCompat.getColor(getContext(), R.color.mythic_plus)), new Function0() { // from class: com.studiolaganne.lengendarylens.StackedCardsView$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StackedCardsView.showCardMenu$lambda$10(this.f$0, card);
                }
            }, 12, (Object) null);
            iconPopupMenuAddItem$default.show(anchorView);
        }
    }

    static final Unit showCardMenu$lambda$0(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardOpen(mTFullCard, stackedCardsView.listId, stackedCardsView.groupType);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$1(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardOpen(mTFullCard, stackedCardsView.listId, stackedCardsView.groupType);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$10(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardFindSimilar(mTFullCard, "deck");
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$2(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardEdit(mTFullCard, stackedCardsView.listId);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$3(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardSelect(mTFullCard, stackedCardsView.listId);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$4(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardMove(mTFullCard, stackedCardsView.listId);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$6(StackedCardsView stackedCardsView, MTFullCard mTFullCard, boolean z) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardSetCompanion(mTFullCard, stackedCardsView.listId, !z);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$7(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardDelete(mTFullCard, stackedCardsView.listId);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$8(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardEvaluate(mTFullCard, stackedCardsView.listId);
        }
        return Unit.INSTANCE;
    }

    static final Unit showCardMenu$lambda$9(StackedCardsView stackedCardsView, MTFullCard mTFullCard) {
        DeckCardMenuCallback deckCardMenuCallback = stackedCardsView.deckCardMenuCallback;
        if (deckCardMenuCallback != null) {
            deckCardMenuCallback.onDeckCardFindSimilar(mTFullCard, "hybrid");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateSelectionVisuals() {
        for (DeckCardImageContainer deckCardImageContainer : this.cardViews) {
            MTFullCard card = deckCardImageContainer.getCard();
            if (card != null) {
                if (this.selectionMode) {
                    deckCardImageContainer.getCollectionStatusLayout().setVisibility(8);
                    deckCardImageContainer.getMenuLayout().setVisibility(8);
                    Function1<? super MTFullCard, Boolean> function1 = this.selectionChecker;
                    if (function1 != null) {
                        boolean z = function1.invoke(card).booleanValue();
                        deckCardImageContainer.getSelectionBorderView().setVisibility(z ? 0 : 8);
                    }
                } else {
                    deckCardImageContainer.getSelectionBorderView().setVisibility(8);
                    deckCardImageContainer.getMenuLayout().setVisibility(0);
                    if (!this.ignoreCollection) {
                        deckCardImageContainer.getCollectionStatusLayout().setVisibility(0);
                    }
                }
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

    public final String getGroupType() {
        return this.groupType;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int size = this.cardViews.size();
        for (int i = 0; i < size; i++) {
            DeckCardImageContainer deckCardImageContainer = this.cardViews.get(i);
            int i2 = this.horizontalMargin;
            int i3 = this.stackOffsetY * i;
            deckCardImageContainer.layout(i2, i3, this.cardWidth + i2, this.cardHeight + i3);
            deckCardImageContainer.setElevation(this.cardZOrder.get(deckCardImageContainer) != null ? r6.intValue() : i);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i = size - (this.horizontalMargin * 2);
        this.cardWidth = i;
        this.cardHeight = (int) (i * 1.4f);
        this.stackOffsetY = (int) (((int) (i * 1.4f)) * 0.12f);
        boolean zIsEmpty = this.cardViews.isEmpty();
        int size2 = this.cardHeight;
        if (!zIsEmpty) {
            size2 += (this.cardViews.size() - 1) * this.stackOffsetY;
        }
        int size3 = this.cardViews.size();
        for (int i2 = 0; i2 < size3; i2++) {
            this.cardViews.get(i2).measure(View.MeasureSpec.makeMeasureSpec(this.cardWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.cardHeight, 1073741824));
        }
        setMeasuredDimension(ViewGroup.resolveSize(size, widthMeasureSpec), ViewGroup.resolveSize(size2, heightMeasureSpec));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    public final void restoreOriginalOrder() {
        this.frontCard = null;
        int i = 0;
        for (Object obj : this.originalCardOrder) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.cardZOrder.put((DeckCardImageContainer) obj, Integer.valueOf(i));
            i = i2;
        }
        Log.d("StackedCardsView", "Restored original Z-order");
        requestLayout();
    }

    public final void setCards(List<MTFullCard> cards, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        setCards$default(this, cards, errors, onCardClick, null, -1, false, null, 96, null);
    }

    public final void setCards(List<MTFullCard> cards, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback menuCallback) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        setCards$default(this, cards, errors, onCardClick, menuCallback, -1, false, null, 96, null);
    }

    public final void setCards(List<MTFullCard> cards, List<MTListError> errors, Function1<? super MTFullCard, Unit> onCardClick, DeckCardMenuCallback menuCallback, int listId, boolean ignoreCollection, MTDeck deck) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        Log.d("StackedCardsView", "setCards called with " + cards.size() + " cards and " + errors.size() + " errors");
        this.errors = errors;
        this.deckCardMenuCallback = menuCallback;
        this.listId = listId;
        this.ignoreCollection = ignoreCollection;
        this.cardViews.clear();
        this.originalCardOrder.clear();
        this.cardZOrder.clear();
        removeAllViews();
        int i = 0;
        for (Object obj : cards) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MTFullCard mTFullCard = (MTFullCard) obj;
            DeckCardImageContainer deckCardImageContainerCreateCardView = createCardView(mTFullCard, errors, onCardClick, setCards$colorOverrideForCard(deck, mTFullCard));
            this.cardViews.add(deckCardImageContainerCreateCardView);
            this.originalCardOrder.add(deckCardImageContainerCreateCardView);
            this.cardZOrder.put(deckCardImageContainerCreateCardView, Integer.valueOf(i));
            addView(deckCardImageContainerCreateCardView);
            i = i2;
        }
        Log.d("StackedCardsView", "Added " + this.cardViews.size() + " cards to view hierarchy");
        this.stackOffsetY = (int) (((int) (this.cardWidth * 1.4f)) * 0.12f);
        requestLayout();
    }

    public final void setCards(List<MTFullCard> cards, Function1<? super MTFullCard, Unit> onCardClick) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        setCards$default(this, cards, CollectionsKt.emptyList(), onCardClick, null, -1, false, null, 96, null);
    }

    public final void setGroupType(String str) {
        this.groupType = str;
    }

    public final void setMaxVisibleCards(int max) {
        this.maxVisibleCards = max;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final void setSelectionChecker(Function1<? super MTFullCard, Boolean> function1) {
        this.selectionChecker = function1;
    }

    public final void setSelectionMode(boolean enabled) {
        this.selectionMode = enabled;
        updateSelectionVisuals();
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
