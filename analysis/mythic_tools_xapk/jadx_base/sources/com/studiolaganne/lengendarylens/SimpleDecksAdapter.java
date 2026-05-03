package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleDecksAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(Bo\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleDecksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "currentFormatId", "", "formats", "Lcom/studiolaganne/lengendarylens/MTFormat;", "mtgDBHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "localizedHelpers", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", Key.ROTATION, "clickListener", "Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "showSharedDecksItem", "", "backOnlyMode", "guestMode", "<init>", "(Ljava/util/List;ILjava/util/List;Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;ILcom/studiolaganne/lengendarylens/SimpleDeckClickListener;ZZZ)V", "headerCount", "getHeaderCount", "()I", "dpToPx", "context", "Landroid/content/Context;", "dp", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleDecksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_BACK_ONLY = 6;
    private static final int VIEW_TYPE_DECK = 1;
    private static final int VIEW_TYPE_MENU_ITEMS = 2;
    private static final int VIEW_TYPE_NO_DECKS = 4;
    private static final int VIEW_TYPE_SHARED_DECKS = 5;
    private final boolean backOnlyMode;
    private final SimpleDeckClickListener clickListener;
    private final int currentFormatId;
    private final List<MTDeck> decks;
    private final List<MTFormat> formats;
    private final boolean guestMode;
    private final List<MTGDBHelperLocalized> localizedHelpers;
    private final MTGDBHelper mtgDBHelper;
    private final int rotation;
    private final boolean showSharedDecksItem;
    public static final int $stable = 8;

    public SimpleDecksAdapter(List<MTDeck> decks, int i, List<MTFormat> formats, MTGDBHelper mtgDBHelper, List<MTGDBHelperLocalized> localizedHelpers, int i2, SimpleDeckClickListener clickListener, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(mtgDBHelper, "mtgDBHelper");
        Intrinsics.checkNotNullParameter(localizedHelpers, "localizedHelpers");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.decks = decks;
        this.currentFormatId = i;
        this.formats = formats;
        this.mtgDBHelper = mtgDBHelper;
        this.localizedHelpers = localizedHelpers;
        this.rotation = i2;
        this.clickListener = clickListener;
        this.showSharedDecksItem = z;
        this.backOnlyMode = z2;
        this.guestMode = z3;
    }

    public /* synthetic */ SimpleDecksAdapter(List list, int i, List list2, MTGDBHelper mTGDBHelper, List list3, int i2, SimpleDeckClickListener simpleDeckClickListener, boolean z, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, list2, mTGDBHelper, list3, i2, simpleDeckClickListener, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? false : z2, (i3 & 512) != 0 ? false : z3);
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private final int getHeaderCount() {
        return this.showSharedDecksItem ? 2 : 1;
    }

    static final Unit onBindViewHolder$lambda$0(BackOnlyViewHolder backOnlyViewHolder) {
        backOnlyViewHolder.getClickListener().onBackFromDecksSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(SimpleDeckMenuItemsViewHolder simpleDeckMenuItemsViewHolder) {
        simpleDeckMenuItemsViewHolder.getClickListener().onBackFromDecksSelected();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$10$0(SimpleDeckViewHolder simpleDeckViewHolder, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDeckImageURL().length() > 0) {
            simpleDeckViewHolder.getDeckImage().setVisibility(0);
            simpleDeckViewHolder.getDeckImage().setImageUrl(data.getDeckImageURL());
            simpleDeckViewHolder.getDeckImage().setAutoLoad(false);
            simpleDeckViewHolder.getDeckImage().setVisibility(0);
            simpleDeckViewHolder.getDeckImage().setArtCrop(data.isArtCrop());
            simpleDeckViewHolder.getDeckImage().setVisibility(0);
            simpleDeckViewHolder.getDeckImage().loadSingleImage(data.getDeckImageURL());
        } else {
            simpleDeckViewHolder.getDeckImage().setVisibility(8);
        }
        simpleDeckViewHolder.getManaLayout().setVisibility(0);
        simpleDeckViewHolder.getWMana().setVisibility(8);
        simpleDeckViewHolder.getUMana().setVisibility(8);
        simpleDeckViewHolder.getBMana().setVisibility(8);
        simpleDeckViewHolder.getRMana().setVisibility(8);
        simpleDeckViewHolder.getGMana().setVisibility(8);
        simpleDeckViewHolder.getCMana().setVisibility(8);
        for (String str : data.getColors()) {
            int iHashCode = str.hashCode();
            if (iHashCode != 66) {
                if (iHashCode != 71) {
                    if (iHashCode != 82) {
                        if (iHashCode != 85) {
                            if (iHashCode == 87 && str.equals(ExifInterface.LONGITUDE_WEST)) {
                                simpleDeckViewHolder.getWMana().setVisibility(0);
                            }
                        } else if (str.equals("U")) {
                            simpleDeckViewHolder.getUMana().setVisibility(0);
                        }
                    } else if (str.equals("R")) {
                        simpleDeckViewHolder.getRMana().setVisibility(0);
                    }
                } else if (str.equals(GameUtils.CONDITION_GOOD)) {
                    simpleDeckViewHolder.getGMana().setVisibility(0);
                }
            } else if (str.equals("B")) {
                simpleDeckViewHolder.getBMana().setVisibility(0);
            }
        }
        if (data.getColors().isEmpty() && data.getHasColors()) {
            simpleDeckViewHolder.getCMana().setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$10$1(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("SimpleDecksAdapter", "Error fetching deck data: " + error);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$2(SimpleDeckMenuItemsViewHolder simpleDeckMenuItemsViewHolder) {
        simpleDeckMenuItemsViewHolder.getClickListener().onRefreshDecksSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$3(SimpleDeckMenuItemsViewHolder simpleDeckMenuItemsViewHolder) {
        simpleDeckMenuItemsViewHolder.getClickListener().onCreateDeckSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$4(SharedDecksViewHolder sharedDecksViewHolder) {
        sharedDecksViewHolder.getClickListener().onSharedDecksSelected();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$5(SimpleDecksAdapter simpleDecksAdapter, MTDeck mTDeck) {
        simpleDecksAdapter.clickListener.onDeckSelected(mTDeck);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.decks.isEmpty()) {
            return this.decks.size() + getHeaderCount();
        }
        boolean z = this.guestMode;
        int headerCount = getHeaderCount();
        return z ? headerCount : headerCount + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return this.backOnlyMode ? 6 : 2;
        }
        if (this.showSharedDecksItem && position == 1) {
            return 5;
        }
        return (this.decks.isEmpty() && position - getHeaderCount() == 0) ? 4 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object next;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0 && this.backOnlyMode) {
            final BackOnlyViewHolder backOnlyViewHolder = (BackOnlyViewHolder) holder;
            backOnlyViewHolder.getCardView().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(backOnlyViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SimpleDecksAdapter.onBindViewHolder$lambda$0(backOnlyViewHolder);
                }
            });
            return;
        }
        if (position == 0) {
            final SimpleDeckMenuItemsViewHolder simpleDeckMenuItemsViewHolder = (SimpleDeckMenuItemsViewHolder) holder;
            simpleDeckMenuItemsViewHolder.getCardView().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(simpleDeckMenuItemsViewHolder.getBackLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SimpleDecksAdapter.onBindViewHolder$lambda$1(simpleDeckMenuItemsViewHolder);
                }
            });
            if (this.guestMode) {
                simpleDeckMenuItemsViewHolder.getRefreshLayout().setAlpha(0.3f);
                simpleDeckMenuItemsViewHolder.getRefreshLayout().setOnClickListener(null);
            } else {
                ViewExtensionsKt.setOnClickWithFade(simpleDeckMenuItemsViewHolder.getRefreshLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SimpleDecksAdapter.onBindViewHolder$lambda$2(simpleDeckMenuItemsViewHolder);
                    }
                });
            }
            ViewExtensionsKt.setOnClickWithFade(simpleDeckMenuItemsViewHolder.getCreateLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SimpleDecksAdapter.onBindViewHolder$lambda$3(simpleDeckMenuItemsViewHolder);
                }
            });
            return;
        }
        if (this.showSharedDecksItem && position == 1) {
            final SharedDecksViewHolder sharedDecksViewHolder = (SharedDecksViewHolder) holder;
            sharedDecksViewHolder.getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(sharedDecksViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SimpleDecksAdapter.onBindViewHolder$lambda$4(sharedDecksViewHolder);
                }
            });
            return;
        }
        int headerCount = position - getHeaderCount();
        if (this.decks.isEmpty()) {
            ((NoDecksViewHolder) holder).getRootLayout().setRotation(this.rotation);
            return;
        }
        final SimpleDeckViewHolder simpleDeckViewHolder = (SimpleDeckViewHolder) holder;
        final MTDeck mTDeck = this.decks.get(headerCount);
        simpleDeckViewHolder.getRootLayout().setRotation(this.rotation);
        ViewExtensionsKt.setOnClickWithFade(simpleDeckViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SimpleDecksAdapter.onBindViewHolder$lambda$5(this.f$0, mTDeck);
            }
        });
        simpleDeckViewHolder.getInnerLayout().setClipToOutline(true);
        simpleDeckViewHolder.getInnerLayout().setClipChildren(true);
        if (mTDeck.getFormatid() == this.currentFormatId) {
            simpleDeckViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background_valid);
        } else {
            simpleDeckViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background);
        }
        simpleDeckViewHolder.getDeckName().setText(mTDeck.getName());
        Iterator<T> it = this.formats.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((MTFormat) next).getId() == mTDeck.getFormatid()) {
                    break;
                }
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        String name = mTFormat != null ? mTFormat.getName() : null;
        if (name != null) {
            simpleDeckViewHolder.getDeckFormat().setText(name);
        } else {
            simpleDeckViewHolder.getDeckFormat().setVisibility(8);
        }
        simpleDeckViewHolder.getDeckImage().setVisibility(8);
        simpleDeckViewHolder.getManaLayout().setVisibility(8);
        simpleDeckViewHolder.getBracketLayout().setVisibility(8);
        MTBracket bracket = mTDeck.getBracket();
        if (bracket != null) {
            Integer user = bracket.getUser();
            if (user != null) {
                int iIntValue = user.intValue();
                simpleDeckViewHolder.getBracketLayout().setVisibility(0);
                simpleDeckViewHolder.getBracketValueTextView().setText(String.valueOf(iIntValue));
            } else {
                Integer auto = bracket.getAuto();
                if (auto != null) {
                    int iIntValue2 = auto.intValue();
                    simpleDeckViewHolder.getBracketLayout().setVisibility(0);
                    simpleDeckViewHolder.getBracketValueTextView().setText(String.valueOf(iIntValue2));
                }
            }
        }
        if (mTFormat != null) {
            DeckUtils companion = DeckUtils.INSTANCE.getInstance();
            Context context = simpleDeckViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.fetchDeckData(context, mTDeck, new Function1() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SimpleDecksAdapter.onBindViewHolder$lambda$10$0(simpleDeckViewHolder, (MTDeckData) obj);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.SimpleDecksAdapter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SimpleDecksAdapter.onBindViewHolder$lambda$10$1((String) obj);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_item_square, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SimpleDeckViewHolder(viewInflate, this.clickListener);
        }
        if (viewType == 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_menu_items, parent, false);
            Intrinsics.checkNotNull(viewInflate2);
            return new SimpleDeckMenuItemsViewHolder(viewInflate2, this.clickListener);
        }
        if (viewType == 4) {
            View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_deck_item_square, parent, false);
            Intrinsics.checkNotNull(viewInflate3);
            return new NoDecksViewHolder(viewInflate3);
        }
        if (viewType == 5) {
            View viewInflate4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_item_shared_decks, parent, false);
            Intrinsics.checkNotNull(viewInflate4);
            return new SharedDecksViewHolder(viewInflate4, this.clickListener);
        }
        if (viewType != 6) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_item, parent, false);
        Intrinsics.checkNotNull(viewInflate5);
        return new BackOnlyViewHolder(viewInflate5, this.clickListener);
    }
}
