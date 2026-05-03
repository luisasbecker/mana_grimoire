package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SubgamesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/SubgamesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "games", "", "Lcom/studiolaganne/lengendarylens/MTGame;", "clickListener", "Lcom/studiolaganne/lengendarylens/SubgamesClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/SubgamesClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubgamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_GAME = 1;
    private final SubgamesClickListener clickListener;
    private final List<MTGame> games;
    public static final int $stable = 8;

    public SubgamesAdapter(List<MTGame> games, SubgamesClickListener clickListener) {
        Intrinsics.checkNotNullParameter(games, "games");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.games = games;
        this.clickListener = clickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$4$0(SubgamesAdapter subgamesAdapter, MTGame mTGame) {
        subgamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$4$5(RecyclerView.ViewHolder viewHolder) {
        ((SubgameViewHolder) viewHolder).getPlaygroupName().setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onBindViewHolder$lambda$4$6(MTGamePlayer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFirstname();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.games.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0497  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        boolean z;
        int i;
        boolean z2;
        List<MTGamePlayer> players;
        Iterator<T> it;
        boolean z3;
        List<MTTag> tags;
        String strValueOf;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MTGame mTGame = this.games.get(position);
        if (holder instanceof SubgameViewHolder) {
            SubgameViewHolder subgameViewHolder = (SubgameViewHolder) holder;
            subgameViewHolder.getLeaderImage().setVisibility(8);
            subgameViewHolder.getGuardianImage().setVisibility(8);
            subgameViewHolder.getAssassinsImage().setVisibility(8);
            subgameViewHolder.getTraitorsImage().setVisibility(8);
            subgameViewHolder.getDotsLayout().setVisibility(8);
            if (mTGame == null || mTGame.getPlaygroup() == null) {
                subgameViewHolder.getDotsLayout().setVisibility(8);
                subgameViewHolder.getProfileLayout().setVisibility(8);
                subgameViewHolder.getPlaygroupName().setVisibility(8);
                Unit unit = Unit.INSTANCE;
            } else {
                subgameViewHolder.getProfileLayout().setVisibility(0);
                Unit unit2 = Unit.INSTANCE;
            }
            subgameViewHolder.getTagsFlexboxLayout().setVisibility(8);
            if (mTGame != null && (tags = mTGame.getTags()) != null) {
                if (!tags.isEmpty()) {
                    subgameViewHolder.getTagsFlexboxLayout().removeAllViews();
                    for (MTTag mTTag : tags) {
                        View viewInflate = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.tag_item, (ViewGroup) null);
                        TextView textView = (TextView) viewInflate.findViewById(R.id.tagName);
                        String name = mTTag.getName();
                        if (name.length() > 0) {
                            StringBuilder sb = new StringBuilder();
                            char cCharAt = name.charAt(0);
                            if (Character.isLowerCase(cCharAt)) {
                                Locale localeForLanguageTag = Locale.forLanguageTag("en");
                                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                                strValueOf = CharsKt.titlecase(cCharAt, localeForLanguageTag);
                            } else {
                                strValueOf = String.valueOf(cCharAt);
                            }
                            StringBuilder sbAppend = sb.append((Object) strValueOf);
                            String strSubstring = name.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            name = sbAppend.append(strSubstring).toString();
                        }
                        textView.setText(name);
                        subgameViewHolder.getTagsFlexboxLayout().addView(viewInflate);
                    }
                    subgameViewHolder.getTagsFlexboxLayout().setVisibility(0);
                }
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            subgameViewHolder.getNoteImage().setVisibility(8);
            if (mTGame != null && mTGame.getNote() != null) {
                subgameViewHolder.getNoteImage().setVisibility(0);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(context);
            subgameViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
            subgameViewHolder.getProfileLayout().setClipToOutline(true);
            subgameViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
            subgameViewHolder.getProfileIcon().setClipToOutline(true);
            if (mTGame != null) {
                ViewExtensionsKt.setOnClickWithFade(subgameViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SubgamesAdapter$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SubgamesAdapter.onBindViewHolder$lambda$4$0(this.f$0, mTGame);
                    }
                });
                MTGameFormat format = mTGame.getFormat();
                if (format != null) {
                    subgameViewHolder.getGameName().setText(format.getName());
                    Unit unit7 = Unit.INSTANCE;
                } else {
                    subgameViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.game_title));
                    Unit unit8 = Unit.INSTANCE;
                }
                MTGameSubformat subformat = mTGame.getSubformat();
                if (subformat != null) {
                    if (subformat.getId() > 0 && subformat.getName().length() > 0) {
                        subgameViewHolder.getGameName().setText(subformat.getName());
                        if (subformat.getId() == 5) {
                            subgameViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.two_headed_giant));
                        }
                        if (subformat.getId() == 6) {
                            subgameViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.three_headed_giant));
                        }
                    }
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                }
                MTGamePlaygroup playgroup = mTGame.getPlaygroup();
                if (playgroup != null) {
                    subgameViewHolder.getPlaygroupName().setVisibility(0);
                    subgameViewHolder.getPlaygroupName().setText("@ " + playgroup.getName());
                    String picture = playgroup.getPicture();
                    String str = picture;
                    if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                        subgameViewHolder.getNoPhotoIcon().setVisibility(0);
                        subgameViewHolder.getProfileIcon().setVisibility(8);
                    } else {
                        subgameViewHolder.getNoPhotoIcon().setVisibility(8);
                        subgameViewHolder.getProfileIcon().setVisibility(0);
                        subgameViewHolder.getProfileIcon().setAutoLoad(false);
                        subgameViewHolder.getProfileIcon().reset();
                        subgameViewHolder.getProfileIcon().loadImage(picture);
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                } else {
                    new Function0() { // from class: com.studiolaganne.lengendarylens.SubgamesAdapter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SubgamesAdapter.onBindViewHolder$lambda$4$5(holder);
                        }
                    };
                }
                subgameViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGame.getStarted_at()));
                ArrayList arrayList = new ArrayList();
                for (MTGamePlayer mTGamePlayer : mTGame.getPlayers()) {
                    Integer resultid = mTGamePlayer.getResultid();
                    if (resultid != null && resultid.intValue() == 1) {
                        arrayList.add(mTGamePlayer);
                    }
                }
                int size = arrayList.size();
                if (size > 0) {
                    subgameViewHolder.getWinnersHeaderLabel().setVisibility(0);
                    subgameViewHolder.getWinnersRecyclerView().setVisibility(0);
                    subgameViewHolder.getWinnerNamesLabel().setVisibility(0);
                    subgameViewHolder.getWinnersRecyclerView().setAdapter(new BigGamePlayerAdapter(arrayList));
                    subgameViewHolder.getWinnersRecyclerView().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context context2 = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(22, context2));
                    int itemDecorationCount = subgameViewHolder.getWinnersRecyclerView().getItemDecorationCount();
                    for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                        subgameViewHolder.getWinnersRecyclerView().removeItemDecorationAt(0);
                    }
                    subgameViewHolder.getWinnersRecyclerView().addItemDecoration(overlapDecoration);
                    if (size > 1) {
                        subgameViewHolder.getWinnersHeaderLabel().setText(holder.itemView.getResources().getString(R.string.winners));
                    } else {
                        subgameViewHolder.getWinnersHeaderLabel().setText(holder.itemView.getResources().getString(R.string.winner));
                    }
                    subgameViewHolder.getWinnerNamesLabel().setText(CollectionsKt.joinToString$default(arrayList, " & ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.SubgamesAdapter$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SubgamesAdapter.onBindViewHolder$lambda$4$6((MTGamePlayer) obj);
                        }
                    }, 30, null));
                } else {
                    subgameViewHolder.getWinnersHeaderLabel().setVisibility(8);
                    subgameViewHolder.getWinnersRecyclerView().setVisibility(8);
                    subgameViewHolder.getWinnerNamesLabel().setVisibility(8);
                }
                MTUser currentUser = preferencesManager.getCurrentUser();
                if (currentUser != null) {
                    Boolean published = mTGame.getPublished();
                    if (published != null) {
                        z = !published.booleanValue();
                        Unit unit13 = Unit.INSTANCE;
                        Unit unit14 = Unit.INSTANCE;
                    } else {
                        z = false;
                    }
                    List<MTGamePlayer> players2 = mTGame.getPlayers();
                    if ((players2 instanceof Collection) && players2.isEmpty()) {
                        i = 0;
                    } else {
                        Iterator<T> it2 = players2.iterator();
                        i = 0;
                        while (it2.hasNext()) {
                            Integer resultid2 = ((MTGamePlayer) it2.next()).getResultid();
                            if ((resultid2 != null && resultid2.intValue() == 3) && (i = i + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    }
                    boolean z4 = i >= 2;
                    ArrayList arrayList2 = arrayList;
                    if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
                        z2 = false;
                        players = mTGame.getPlayers();
                        if (players instanceof Collection) {
                            it = players.iterator();
                            while (it.hasNext()) {
                            }
                            z3 = false;
                            TextView victoryLabel = subgameViewHolder.getVictoryLabel();
                            if (z) {
                            }
                            Unit unit15 = Unit.INSTANCE;
                            Unit unit16 = Unit.INSTANCE;
                        }
                    } else {
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            if (((MTGamePlayer) it3.next()).getId() == currentUser.getId()) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        players = mTGame.getPlayers();
                        if ((players instanceof Collection) || !players.isEmpty()) {
                            it = players.iterator();
                            while (it.hasNext()) {
                                if (((MTGamePlayer) it.next()).getId() == currentUser.getId()) {
                                    z3 = true;
                                    break;
                                }
                            }
                            z3 = false;
                            TextView victoryLabel2 = subgameViewHolder.getVictoryLabel();
                            if (z) {
                                victoryLabel2.setText(holder.itemView.getResources().getString(R.string.unpublished_caps));
                                victoryLabel2.setBackgroundResource(R.drawable.grey_box);
                                victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                                victoryLabel2.setVisibility(0);
                            } else if (z4) {
                                victoryLabel2.setText(holder.itemView.getResources().getString(R.string.draw));
                                victoryLabel2.setBackgroundResource(R.drawable.orange_box);
                                victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                                victoryLabel2.setVisibility(0);
                            } else if (z2) {
                                victoryLabel2.setText(holder.itemView.getResources().getString(R.string.victory));
                                victoryLabel2.setBackgroundResource(R.drawable.green_box);
                                victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_black));
                                victoryLabel2.setVisibility(0);
                            } else if (z3) {
                                victoryLabel2.setText(holder.itemView.getResources().getString(R.string.defeat));
                                victoryLabel2.setBackgroundResource(R.drawable.red_box);
                                victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                                victoryLabel2.setVisibility(0);
                            } else {
                                victoryLabel2.setVisibility(4);
                            }
                            Unit unit152 = Unit.INSTANCE;
                            Unit unit162 = Unit.INSTANCE;
                        } else {
                            z3 = false;
                            TextView victoryLabel22 = subgameViewHolder.getVictoryLabel();
                            if (z) {
                            }
                            Unit unit1522 = Unit.INSTANCE;
                            Unit unit1622 = Unit.INSTANCE;
                        }
                    }
                }
                subgameViewHolder.getInterLabel1().setVisibility(8);
                List<MTGamePlayer> players3 = mTGame.getPlayers();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(players3, 10));
                Iterator<T> it4 = players3.iterator();
                while (it4.hasNext()) {
                    arrayList3.add(((MTGamePlayer) it4.next()).getTeamid());
                }
                List listSortedWith = CollectionsKt.sortedWith(CollectionsKt.distinct(arrayList3), new Comparator() { // from class: com.studiolaganne.lengendarylens.SubgamesAdapter$onBindViewHolder$lambda$4$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Integer) t, (Integer) t2);
                    }
                });
                if (listSortedWith.isEmpty() || listSortedWith.size() == 1) {
                    subgameViewHolder.getSmallUsersRecyclerView1().setAdapter(new SmallGamePlayerAdapter(mTGame.getPlayers(), false, 0));
                    subgameViewHolder.getSmallUsersRecyclerView1().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                    GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                    Context context3 = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    OverlapDecoration overlapDecoration2 = new OverlapDecoration(companion2.dpToPx(16, context3));
                    int itemDecorationCount2 = subgameViewHolder.getSmallUsersRecyclerView1().getItemDecorationCount();
                    for (int i3 = 0; i3 < itemDecorationCount2; i3++) {
                        subgameViewHolder.getSmallUsersRecyclerView1().removeItemDecorationAt(0);
                    }
                    subgameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                    subgameViewHolder.getSmallUsersRecyclerView1().addItemDecoration(overlapDecoration2);
                    if (mTGame.getPlayers().size() > 2) {
                        subgameViewHolder.getInterLabel1().setVisibility(0);
                        subgameViewHolder.getInterLabel1().setText("FFA");
                    }
                    subgameViewHolder.getSmallUsersRecyclerView2().setVisibility(8);
                    subgameViewHolder.getInterLabel2().setVisibility(8);
                    subgameViewHolder.getSmallUsersRecyclerView3().setVisibility(8);
                } else {
                    List list = listSortedWith;
                    if (list.size() >= 2) {
                        subgameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                        subgameViewHolder.getInterLabel1().setVisibility(0);
                        subgameViewHolder.getSmallUsersRecyclerView2().setVisibility(0);
                        subgameViewHolder.getInterLabel2().setVisibility(8);
                        subgameViewHolder.getSmallUsersRecyclerView3().setVisibility(8);
                        subgameViewHolder.getInterLabel1().setText("vs");
                        List<MTGamePlayer> players4 = mTGame.getPlayers();
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj : players4) {
                            if (Intrinsics.areEqual(((MTGamePlayer) obj).getTeamid(), listSortedWith.get(0))) {
                                arrayList4.add(obj);
                            }
                        }
                        subgameViewHolder.getSmallUsersRecyclerView1().setAdapter(new SmallGamePlayerAdapter(arrayList4, false, 0));
                        subgameViewHolder.getSmallUsersRecyclerView1().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                        GameUtils companion3 = GameUtils.INSTANCE.getInstance();
                        Context context4 = holder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        OverlapDecoration overlapDecoration3 = new OverlapDecoration(companion3.dpToPx(16, context4));
                        int itemDecorationCount3 = subgameViewHolder.getSmallUsersRecyclerView1().getItemDecorationCount();
                        for (int i4 = 0; i4 < itemDecorationCount3; i4++) {
                            subgameViewHolder.getSmallUsersRecyclerView1().removeItemDecorationAt(0);
                        }
                        subgameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                        subgameViewHolder.getSmallUsersRecyclerView1().addItemDecoration(overlapDecoration3);
                        List<MTGamePlayer> players5 = mTGame.getPlayers();
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj2 : players5) {
                            if (Intrinsics.areEqual(((MTGamePlayer) obj2).getTeamid(), listSortedWith.get(1))) {
                                arrayList5.add(obj2);
                            }
                        }
                        subgameViewHolder.getSmallUsersRecyclerView2().setAdapter(new SmallGamePlayerAdapter(arrayList5, false, 0));
                        subgameViewHolder.getSmallUsersRecyclerView2().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                        GameUtils companion4 = GameUtils.INSTANCE.getInstance();
                        Context context5 = holder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                        OverlapDecoration overlapDecoration4 = new OverlapDecoration(companion4.dpToPx(16, context5));
                        int itemDecorationCount4 = subgameViewHolder.getSmallUsersRecyclerView2().getItemDecorationCount();
                        for (int i5 = 0; i5 < itemDecorationCount4; i5++) {
                            subgameViewHolder.getSmallUsersRecyclerView2().removeItemDecorationAt(0);
                        }
                        subgameViewHolder.getSmallUsersRecyclerView2().setVisibility(0);
                        subgameViewHolder.getSmallUsersRecyclerView2().addItemDecoration(overlapDecoration4);
                    }
                    if (list.size() >= 3) {
                        subgameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                        subgameViewHolder.getInterLabel1().setVisibility(0);
                        subgameViewHolder.getSmallUsersRecyclerView2().setVisibility(0);
                        subgameViewHolder.getInterLabel2().setVisibility(0);
                        subgameViewHolder.getSmallUsersRecyclerView3().setVisibility(0);
                        subgameViewHolder.getInterLabel2().setText("vs");
                        List<MTGamePlayer> players6 = mTGame.getPlayers();
                        ArrayList arrayList6 = new ArrayList();
                        for (Object obj3 : players6) {
                            if (Intrinsics.areEqual(((MTGamePlayer) obj3).getTeamid(), listSortedWith.get(2))) {
                                arrayList6.add(obj3);
                            }
                        }
                        subgameViewHolder.getSmallUsersRecyclerView3().setAdapter(new SmallGamePlayerAdapter(arrayList6, false, 0));
                        subgameViewHolder.getSmallUsersRecyclerView3().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                        GameUtils companion5 = GameUtils.INSTANCE.getInstance();
                        Context context6 = holder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                        OverlapDecoration overlapDecoration5 = new OverlapDecoration(companion5.dpToPx(16, context6));
                        int itemDecorationCount5 = subgameViewHolder.getSmallUsersRecyclerView3().getItemDecorationCount();
                        for (int i6 = 0; i6 < itemDecorationCount5; i6++) {
                            subgameViewHolder.getSmallUsersRecyclerView3().removeItemDecorationAt(0);
                        }
                        subgameViewHolder.getSmallUsersRecyclerView3().setVisibility(0);
                        subgameViewHolder.getSmallUsersRecyclerView3().addItemDecoration(overlapDecoration5);
                    }
                    MTGameSubformat subformat2 = mTGame.getSubformat();
                    if (subformat2 != null && subformat2.getId() == 3) {
                        subgameViewHolder.getLeaderImage().setVisibility(0);
                        subgameViewHolder.getGuardianImage().setVisibility(0);
                        subgameViewHolder.getAssassinsImage().setVisibility(0);
                        subgameViewHolder.getTraitorsImage().setVisibility(0);
                    }
                }
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new SubgameViewHolder(viewInflate, this.clickListener);
    }
}
