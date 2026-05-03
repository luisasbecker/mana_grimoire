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
import com.facebook.appevents.AppEventsConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DecksListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dBI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "formats", "Lcom/studiolaganne/lengendarylens/MTFormat;", "mtgDBHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "localizedHelpers", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "clickListener", "Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "hideDotsMenu", "", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;Lcom/studiolaganne/lengendarylens/DecksListClickListener;Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecksListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_DECK = 1;
    private final DecksListClickListener clickListener;
    private final List<MTDeck> decks;
    private final List<MTFormat> formats;
    private final boolean hideDotsMenu;
    private final List<MTGDBHelperLocalized> localizedHelpers;
    private final MTGDBHelper mtgDBHelper;
    public static final int $stable = 8;

    public DecksListAdapter(List<MTDeck> decks, List<MTFormat> formats, MTGDBHelper mtgDBHelper, List<MTGDBHelperLocalized> localizedHelpers, DecksListClickListener clickListener, boolean z) {
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
        this.hideDotsMenu = z;
    }

    static final Unit onBindViewHolder$lambda$1(MTDeck mTDeck, DecksListAdapter decksListAdapter) {
        if (mTDeck.getTemporary()) {
            decksListAdapter.clickListener.onDeckTemporary(mTDeck);
            return Unit.INSTANCE;
        }
        decksListAdapter.clickListener.onDeckSelected(mTDeck);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$11(DecksListViewHolder decksListViewHolder, final MTDeck mTDeck, final DecksListAdapter decksListAdapter) {
        Context context = decksListViewHolder.itemView.getContext();
        if (Intrinsics.areEqual((Object) mTDeck.getActive(), (Object) true)) {
            Intrinsics.checkNotNull(context);
            IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.edit_deck, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DecksListAdapter.onBindViewHolder$lambda$11$0(this.f$0, mTDeck);
                }
            }, 28, (Object) null).addDivider(), R.string.delete_deck, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DecksListAdapter.onBindViewHolder$lambda$11$1(this.f$0, mTDeck);
                }
            }, 30, (Object) null), R.string.full_delete_deck, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DecksListAdapter.onBindViewHolder$lambda$11$2(this.f$0, mTDeck);
                }
            }, 24, (Object) null).show(decksListViewHolder.getDotsLayout());
        } else {
            Intrinsics.checkNotNull(context);
            IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.restore_deck, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DecksListAdapter.onBindViewHolder$lambda$11$3(this.f$0, mTDeck);
                }
            }, 30, (Object) null).addDivider(), R.string.full_delete_deck, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DecksListAdapter.onBindViewHolder$lambda$11$4(this.f$0, mTDeck);
                }
            }, 24, (Object) null).show(decksListViewHolder.getDotsLayout());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$11$0(DecksListAdapter decksListAdapter, MTDeck mTDeck) {
        decksListAdapter.clickListener.onDeckEdit(mTDeck);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$11$1(DecksListAdapter decksListAdapter, MTDeck mTDeck) {
        decksListAdapter.clickListener.onDeckDelete(mTDeck);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$11$2(DecksListAdapter decksListAdapter, MTDeck mTDeck) {
        decksListAdapter.clickListener.onDeckFullDelete(mTDeck);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$11$3(DecksListAdapter decksListAdapter, MTDeck mTDeck) {
        decksListAdapter.clickListener.onDeckRestore(mTDeck);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$11$4(DecksListAdapter decksListAdapter, MTDeck mTDeck) {
        decksListAdapter.clickListener.onDeckFullDelete(mTDeck);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$7$0(DecksListViewHolder decksListViewHolder, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDeckImageURL().length() > 0) {
            decksListViewHolder.getDeckImage().setVisibility(0);
            decksListViewHolder.getDeckImage().setImageUrl(data.getDeckImageURL());
            decksListViewHolder.getDeckImage().setAutoLoad(false);
            decksListViewHolder.getDeckImage().setArtCrop(data.isArtCrop());
            decksListViewHolder.getDeckImage().setVisibility(0);
            decksListViewHolder.getDeckImage().loadSingleImage(data.getDeckImageURL());
        } else {
            decksListViewHolder.getDeckImage().setVisibility(8);
        }
        decksListViewHolder.getManaLayout().setVisibility(0);
        decksListViewHolder.getWMana().setVisibility(8);
        decksListViewHolder.getUMana().setVisibility(8);
        decksListViewHolder.getBMana().setVisibility(8);
        decksListViewHolder.getRMana().setVisibility(8);
        decksListViewHolder.getGMana().setVisibility(8);
        decksListViewHolder.getCMana().setVisibility(8);
        for (String str : data.getColors()) {
            int iHashCode = str.hashCode();
            if (iHashCode != 66) {
                if (iHashCode != 71) {
                    if (iHashCode != 82) {
                        if (iHashCode != 85) {
                            if (iHashCode == 87 && str.equals(ExifInterface.LONGITUDE_WEST)) {
                                decksListViewHolder.getWMana().setVisibility(0);
                            }
                        } else if (str.equals("U")) {
                            decksListViewHolder.getUMana().setVisibility(0);
                        }
                    } else if (str.equals("R")) {
                        decksListViewHolder.getRMana().setVisibility(0);
                    }
                } else if (str.equals(GameUtils.CONDITION_GOOD)) {
                    decksListViewHolder.getGMana().setVisibility(0);
                }
            } else if (str.equals("B")) {
                decksListViewHolder.getBMana().setVisibility(0);
            }
        }
        if (data.getColors().isEmpty() && data.getHasColors()) {
            decksListViewHolder.getCMana().setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$7$1(DecksListViewHolder decksListViewHolder, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("DecksListAdapter", "Error fetching deck data: " + error);
        decksListViewHolder.getManaLayout().setVisibility(8);
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
        final DecksListViewHolder decksListViewHolder = (DecksListViewHolder) holder;
        final MTDeck mTDeck = this.decks.get(position);
        decksListViewHolder.getRootLayout().setAlpha(1.0f);
        Boolean active = mTDeck.getActive();
        if (active == null || active.booleanValue()) {
            ViewExtensionsKt.setOnClickWithFade(decksListViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DecksListAdapter.onBindViewHolder$lambda$1(mTDeck, this);
                }
            });
        } else {
            decksListViewHolder.getRootLayout().setAlpha(0.8f);
        }
        decksListViewHolder.getInnerLayout().setClipToOutline(true);
        decksListViewHolder.getInnerLayout().setClipChildren(true);
        decksListViewHolder.getPendingText().setVisibility(8);
        if (mTDeck.getTemporary()) {
            decksListViewHolder.getPendingText().setVisibility(0);
        }
        decksListViewHolder.getOwnerLayout().setVisibility(8);
        MTPrivacyUser owner = mTDeck.getOwner();
        if (owner != null) {
            Context context = decksListViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            MTUser currentUser = new PreferencesManager(context).getCurrentUser();
            if (currentUser != null && currentUser.getId() != owner.getId()) {
                decksListViewHolder.getOwnerLayout().setVisibility(0);
                String picture = owner.getPicture();
                if (picture == null || picture.length() == 0) {
                    decksListViewHolder.getProfileIcon().setVisibility(8);
                    decksListViewHolder.getNoPhotoIcon().setVisibility(0);
                } else {
                    decksListViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
                    decksListViewHolder.getProfileIcon().setClipToOutline(true);
                    decksListViewHolder.getProfileIcon().setVisibility(0);
                    decksListViewHolder.getNoPhotoIcon().setVisibility(8);
                    decksListViewHolder.getProfileIcon().setAutoLoad(false);
                    CachedImageView profileIcon = decksListViewHolder.getProfileIcon();
                    String picture2 = owner.getPicture();
                    Intrinsics.checkNotNull(picture2);
                    profileIcon.loadImage(picture2);
                }
                decksListViewHolder.getUserName().setText("@" + owner.getUsername());
            }
        }
        decksListViewHolder.getBracketLayout().setVisibility(8);
        MTBracket bracket = mTDeck.getBracket();
        if (bracket != null) {
            Integer user = bracket.getUser();
            if (user != null) {
                int iIntValue = user.intValue();
                decksListViewHolder.getBracketLayout().setVisibility(0);
                decksListViewHolder.getBracketValueTextView().setText(String.valueOf(iIntValue));
            } else {
                Integer auto = bracket.getAuto();
                if (auto != null) {
                    int iIntValue2 = auto.intValue();
                    decksListViewHolder.getBracketLayout().setVisibility(0);
                    decksListViewHolder.getBracketValueTextView().setText(String.valueOf(iIntValue2));
                }
            }
        }
        decksListViewHolder.getDeckName().setText(mTDeck.getName());
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
            decksListViewHolder.getDeckFormat().setText(name);
        } else {
            decksListViewHolder.getDeckFormat().setVisibility(8);
        }
        decksListViewHolder.getDeckImage().setVisibility(8);
        decksListViewHolder.getManaLayout().setVisibility(8);
        if (mTFormat != null) {
            DeckUtils companion = DeckUtils.INSTANCE.getInstance();
            Context context2 = decksListViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            companion.fetchDeckData(context2, mTDeck, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DecksListAdapter.onBindViewHolder$lambda$7$0(decksListViewHolder, (MTDeckData) obj);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DecksListAdapter.onBindViewHolder$lambda$7$1(decksListViewHolder, (String) obj);
                }
            });
        } else {
            decksListViewHolder.getManaLayout().setVisibility(8);
        }
        MTStats stats = mTDeck.getStats();
        if (stats == null || stats.getGames() <= 0) {
            decksListViewHolder.getWinrateValue().setText("--");
            decksListViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(decksListViewHolder.getWinrateValue().getContext(), R.color.text_color));
            decksListViewHolder.getGamesValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            decksListViewHolder.getWinsValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            decksListViewHolder.getLossesValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            decksListViewHolder.getDrawsValue().setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            decksListViewHolder.getGamesLabel().setText(decksListViewHolder.itemView.getResources().getString(R.string.games_singular));
            decksListViewHolder.getDrawsLabel().setVisibility(8);
            decksListViewHolder.getWinsLabel().setText("-");
            decksListViewHolder.getWinsLabel().setTextColor(ContextCompat.getColor(decksListViewHolder.itemView.getContext(), R.color.text_color));
            decksListViewHolder.getLossesLabel().setText("-");
            decksListViewHolder.getLossesLabel().setTextColor(ContextCompat.getColor(decksListViewHolder.itemView.getContext(), R.color.text_color));
        } else {
            try {
                float f = Float.parseFloat(stats.getRate());
                if (Math.abs(f) <= Float.MAX_VALUE) {
                    decksListViewHolder.getWinrateValue().setText(MathKt.roundToInt(f) + "%");
                    TextView winrateValue = decksListViewHolder.getWinrateValue();
                    GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                    Context context3 = decksListViewHolder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    winrateValue.setTextColor(companion2.getWinRateColor(context3, Float.parseFloat(stats.getRate()), Integer.valueOf(mTDeck.getFormatid())));
                } else {
                    decksListViewHolder.getWinrateValue().setText("--");
                    decksListViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(decksListViewHolder.itemView.getContext(), R.color.text_color));
                }
            } catch (NumberFormatException unused) {
                decksListViewHolder.getWinrateValue().setText("--");
                decksListViewHolder.getWinrateValue().setTextColor(ContextCompat.getColor(decksListViewHolder.itemView.getContext(), R.color.text_color));
            }
            decksListViewHolder.getGamesValue().setText(String.valueOf(stats.getGames()));
            decksListViewHolder.getWinsValue().setText(String.valueOf(stats.getWins()));
            decksListViewHolder.getLossesValue().setText(String.valueOf(stats.getLosses()));
            decksListViewHolder.getDrawsValue().setText(String.valueOf(stats.getDraws()));
            if (stats.getGames() == 1) {
                decksListViewHolder.getGamesLabel().setText(decksListViewHolder.itemView.getResources().getString(R.string.games_singular));
            } else {
                decksListViewHolder.getGamesLabel().setText(decksListViewHolder.itemView.getResources().getString(R.string.games_plural));
            }
            decksListViewHolder.getDrawsLabel().setVisibility(8);
            decksListViewHolder.getWinsLabel().setText("-");
            decksListViewHolder.getWinsLabel().setTextColor(ContextCompat.getColor(decksListViewHolder.itemView.getContext(), R.color.text_color));
            decksListViewHolder.getLossesLabel().setText("-");
            decksListViewHolder.getLossesLabel().setTextColor(ContextCompat.getColor(decksListViewHolder.itemView.getContext(), R.color.text_color));
        }
        MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
        Context context4 = decksListViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        boolean zIsActive = mythicPlusManager.isActive(context4);
        boolean zAreEqual = Intrinsics.areEqual((Object) mTDeck.is_smart_deck(), (Object) true);
        boolean z = mTDeck.getFormatid() == 6;
        MythicBorderAnimationView smartDeckBorderView = decksListViewHolder.getSmartDeckBorderView();
        if (smartDeckBorderView != null) {
            smartDeckBorderView.setCornerRadiusDp(16);
        }
        if (zIsActive && z) {
            decksListViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background_mythic_small);
            ConstraintLayout smartDeckHeaderLayout = decksListViewHolder.getSmartDeckHeaderLayout();
            if (smartDeckHeaderLayout != null) {
                smartDeckHeaderLayout.setVisibility(8);
            }
            MythicBorderAnimationView smartDeckBorderView2 = decksListViewHolder.getSmartDeckBorderView();
            if (smartDeckBorderView2 != null) {
                smartDeckBorderView2.setVisibility(8);
            }
        } else if (zAreEqual && z) {
            decksListViewHolder.getInnerLayout().setBackgroundResource(R.drawable.custom_playgroup_background_mythic_small);
            ConstraintLayout smartDeckHeaderLayout2 = decksListViewHolder.getSmartDeckHeaderLayout();
            if (smartDeckHeaderLayout2 != null) {
                smartDeckHeaderLayout2.setVisibility(0);
            }
            MythicBorderAnimationView smartDeckBorderView3 = decksListViewHolder.getSmartDeckBorderView();
            if (smartDeckBorderView3 != null) {
                smartDeckBorderView3.setAnimateEnabled(true);
            }
            MythicBorderAnimationView smartDeckBorderView4 = decksListViewHolder.getSmartDeckBorderView();
            if (smartDeckBorderView4 != null) {
                smartDeckBorderView4.setVisibility(0);
            }
        } else {
            ConstraintLayout smartDeckHeaderLayout3 = decksListViewHolder.getSmartDeckHeaderLayout();
            if (smartDeckHeaderLayout3 != null) {
                smartDeckHeaderLayout3.setVisibility(8);
            }
            MythicBorderAnimationView smartDeckBorderView5 = decksListViewHolder.getSmartDeckBorderView();
            if (smartDeckBorderView5 != null) {
                smartDeckBorderView5.setVisibility(8);
            }
        }
        if (this.hideDotsMenu) {
            decksListViewHolder.getDotsLayout().setVisibility(8);
        } else {
            decksListViewHolder.getDotsLayout().setVisibility(0);
        }
        ViewExtensionsKt.setOnClickWithFade(decksListViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.DecksListAdapter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DecksListAdapter.onBindViewHolder$lambda$11(decksListViewHolder, mTDeck, this);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new DecksListViewHolder(viewInflate, this.clickListener);
    }
}
