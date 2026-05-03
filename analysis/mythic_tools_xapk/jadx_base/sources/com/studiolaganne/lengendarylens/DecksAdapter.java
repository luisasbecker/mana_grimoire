package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DecksAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bBA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "formats", "Lcom/studiolaganne/lengendarylens/MTFormat;", "mtgDBHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "localizedHelpers", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "clickListener", "Lcom/studiolaganne/lengendarylens/DecksClickListener;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;Lcom/studiolaganne/lengendarylens/DecksClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_DECK = 1;
    private final DecksClickListener clickListener;
    private final List<MTDeck> decks;
    private final List<MTFormat> formats;
    private final List<MTGDBHelperLocalized> localizedHelpers;
    private final MTGDBHelper mtgDBHelper;
    public static final int $stable = 8;

    public DecksAdapter(List<MTDeck> decks, List<MTFormat> formats, MTGDBHelper mtgDBHelper, List<MTGDBHelperLocalized> localizedHelpers, DecksClickListener clickListener) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(mtgDBHelper, "mtgDBHelper");
        Intrinsics.checkNotNullParameter(localizedHelpers, "localizedHelpers");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.decks = decks;
        this.formats = formats;
        this.mtgDBHelper = mtgDBHelper;
        this.localizedHelpers = localizedHelpers;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(MTDeck mTDeck, DecksAdapter decksAdapter) {
        if (mTDeck.getTemporary()) {
            decksAdapter.clickListener.onDeckTemporary(mTDeck);
            return Unit.INSTANCE;
        }
        decksAdapter.clickListener.onDeckSelected(mTDeck);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$0(DeckViewHolder deckViewHolder, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDeckImageURL().length() > 0) {
            deckViewHolder.getDeckImage().setVisibility(0);
            deckViewHolder.getDeckImage().setImageUrl(data.getDeckImageURL());
            deckViewHolder.getDeckImage().setAutoLoad(false);
            deckViewHolder.getDeckImage().setVisibility(0);
            deckViewHolder.getDeckImage().setArtCrop(data.isArtCrop());
            deckViewHolder.getDeckImage().setVisibility(0);
            deckViewHolder.getDeckImage().loadSingleImage(data.getDeckImageURL());
        } else {
            deckViewHolder.getDeckImage().setVisibility(8);
        }
        deckViewHolder.getManaLayout().setVisibility(0);
        deckViewHolder.getWMana().setVisibility(8);
        deckViewHolder.getUMana().setVisibility(8);
        deckViewHolder.getBMana().setVisibility(8);
        deckViewHolder.getRMana().setVisibility(8);
        deckViewHolder.getGMana().setVisibility(8);
        deckViewHolder.getCMana().setVisibility(8);
        for (String str : data.getColors()) {
            int iHashCode = str.hashCode();
            if (iHashCode != 66) {
                if (iHashCode != 71) {
                    if (iHashCode != 82) {
                        if (iHashCode != 85) {
                            if (iHashCode == 87 && str.equals(ExifInterface.LONGITUDE_WEST)) {
                                deckViewHolder.getWMana().setVisibility(0);
                            }
                        } else if (str.equals("U")) {
                            deckViewHolder.getUMana().setVisibility(0);
                        }
                    } else if (str.equals("R")) {
                        deckViewHolder.getRMana().setVisibility(0);
                    }
                } else if (str.equals(GameUtils.CONDITION_GOOD)) {
                    deckViewHolder.getGMana().setVisibility(0);
                }
            } else if (str.equals("B")) {
                deckViewHolder.getBMana().setVisibility(0);
            }
        }
        if (data.getColors().isEmpty() && data.getHasColors()) {
            deckViewHolder.getCMana().setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$1(DeckViewHolder deckViewHolder, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("DecksListAdapter", "Error fetching deck data: " + error);
        deckViewHolder.getManaLayout().setVisibility(8);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.decks.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object next;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final DeckViewHolder deckViewHolder = (DeckViewHolder) holder;
        final MTDeck mTDeck = this.decks.get(position);
        ViewExtensionsKt.setOnClickWithFade(deckViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.DecksAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksAdapter.onBindViewHolder$lambda$0(mTDeck, this);
            }
        });
        deckViewHolder.getInnerLayout().setClipToOutline(true);
        deckViewHolder.getInnerLayout().setClipChildren(true);
        deckViewHolder.getPendingText().setVisibility(8);
        if (mTDeck.getTemporary()) {
            deckViewHolder.getPendingText().setVisibility(0);
        }
        deckViewHolder.getOwnerLayout().setVisibility(8);
        MTPrivacyUser owner = mTDeck.getOwner();
        if (owner != null) {
            Context context = deckViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            MTUser currentUser = new PreferencesManager(context).getCurrentUser();
            if (currentUser != null && currentUser.getId() != owner.getId()) {
                deckViewHolder.getOwnerLayout().setVisibility(0);
                String picture = owner.getPicture();
                if (picture == null || picture.length() == 0) {
                    deckViewHolder.getProfileIcon().setVisibility(8);
                    deckViewHolder.getNoPhotoIcon().setVisibility(0);
                } else {
                    deckViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
                    deckViewHolder.getProfileIcon().setClipToOutline(true);
                    deckViewHolder.getProfileIcon().setVisibility(0);
                    deckViewHolder.getNoPhotoIcon().setVisibility(8);
                    deckViewHolder.getProfileIcon().setAutoLoad(false);
                    CachedImageView profileIcon = deckViewHolder.getProfileIcon();
                    String picture2 = owner.getPicture();
                    Intrinsics.checkNotNull(picture2);
                    profileIcon.loadImage(picture2);
                }
                deckViewHolder.getUserName().setText("@" + owner.getUsername());
            }
        }
        deckViewHolder.getDeckName().setText(mTDeck.getName());
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
            deckViewHolder.getDeckFormat().setText(name);
        } else {
            deckViewHolder.getDeckFormat().setVisibility(8);
        }
        deckViewHolder.getDeckImage().setVisibility(8);
        if (mTFormat != null) {
            DeckUtils companion = DeckUtils.INSTANCE.getInstance();
            Context context2 = deckViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            companion.fetchDeckData(context2, mTDeck, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DecksAdapter.onBindViewHolder$lambda$5$0(deckViewHolder, (MTDeckData) obj);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DecksAdapter.onBindViewHolder$lambda$5$1(deckViewHolder, (String) obj);
                }
            });
        } else {
            deckViewHolder.getManaLayout().setVisibility(8);
        }
        MTStats stats = mTDeck.getStats();
        if (stats == null || stats.getGames() <= 0) {
            deckViewHolder.getWinrateValue().setText("--");
            deckViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(deckViewHolder.getWinrateValue().getContext(), R.color.text_color));
        } else {
            try {
                float f = Float.parseFloat(stats.getRate());
                if (Math.abs(f) <= Float.MAX_VALUE) {
                    deckViewHolder.getWinrateValue().setText(MathKt.roundToInt(f) + "%");
                    TextView winrateValue = deckViewHolder.getWinrateValue();
                    GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                    Context context3 = deckViewHolder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    winrateValue.setTextColor(companion2.getWinRateColor(context3, Float.parseFloat(stats.getRate()), Integer.valueOf(mTDeck.getFormatid())));
                } else {
                    deckViewHolder.getWinrateValue().setText("--");
                    deckViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(deckViewHolder.itemView.getContext(), R.color.text_color));
                }
            } catch (NumberFormatException unused) {
                deckViewHolder.getWinrateValue().setText("--");
                deckViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(deckViewHolder.itemView.getContext(), R.color.text_color));
            }
        }
        MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
        Context context4 = deckViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        boolean zIsActive = mythicPlusManager.isActive(context4);
        boolean zAreEqual = Intrinsics.areEqual((Object) mTDeck.is_smart_deck(), (Object) true);
        boolean z = mTDeck.getFormatid() == 6;
        MythicBorderAnimationView smartDeckBorderView = deckViewHolder.getSmartDeckBorderView();
        if (smartDeckBorderView != null) {
            smartDeckBorderView.setCornerRadiusDp(16);
        }
        if (zIsActive && z) {
            deckViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background_mythic_small);
            ConstraintLayout smartDeckHeaderLayout = deckViewHolder.getSmartDeckHeaderLayout();
            if (smartDeckHeaderLayout != null) {
                smartDeckHeaderLayout.setVisibility(8);
            }
            MythicBorderAnimationView smartDeckBorderView2 = deckViewHolder.getSmartDeckBorderView();
            if (smartDeckBorderView2 != null) {
                smartDeckBorderView2.setVisibility(8);
                return;
            }
            return;
        }
        if (!zAreEqual || !z) {
            deckViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background);
            ConstraintLayout smartDeckHeaderLayout2 = deckViewHolder.getSmartDeckHeaderLayout();
            if (smartDeckHeaderLayout2 != null) {
                smartDeckHeaderLayout2.setVisibility(8);
            }
            MythicBorderAnimationView smartDeckBorderView3 = deckViewHolder.getSmartDeckBorderView();
            if (smartDeckBorderView3 != null) {
                smartDeckBorderView3.setVisibility(8);
                return;
            }
            return;
        }
        deckViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background_mythic_small);
        ConstraintLayout smartDeckHeaderLayout3 = deckViewHolder.getSmartDeckHeaderLayout();
        if (smartDeckHeaderLayout3 != null) {
            smartDeckHeaderLayout3.setVisibility(0);
        }
        MythicBorderAnimationView smartDeckBorderView4 = deckViewHolder.getSmartDeckBorderView();
        if (smartDeckBorderView4 != null) {
            smartDeckBorderView4.setAnimateEnabled(true);
        }
        MythicBorderAnimationView smartDeckBorderView5 = deckViewHolder.getSmartDeckBorderView();
        if (smartDeckBorderView5 != null) {
            smartDeckBorderView5.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new DeckViewHolder(viewInflate, this.clickListener);
    }
}
