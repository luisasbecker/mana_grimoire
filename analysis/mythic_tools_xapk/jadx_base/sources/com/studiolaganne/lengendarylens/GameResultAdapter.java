package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.Constants;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GameResultAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "game", "Lcom/studiolaganne/lengendarylens/MTCreateGame;", "fullGame", "Lcom/studiolaganne/lengendarylens/MTGame;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCreateGame;Lcom/studiolaganne/lengendarylens/MTGame;)V", "playerPositions", "", "", "calculatePlayerPositions", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final long TIE_THRESHOLD_SECONDS = 10;
    private static final int VIEW_TYPE_RESULT = 1;
    private final MTGame fullGame;
    private final MTCreateGame game;
    private final Map<Integer, Integer> playerPositions;
    public static final int $stable = 8;

    public GameResultAdapter(MTCreateGame game, MTGame fullGame) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(fullGame, "fullGame");
        this.game = game;
        this.fullGame = fullGame;
        this.playerPositions = calculatePlayerPositions();
    }

    private final Map<Integer, Integer> calculatePlayerPositions() {
        Object pair;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.fullGame.getPlayers().size();
        List<MTGamePlayer> players = this.fullGame.getPlayers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : players) {
            Integer resultid = ((MTGamePlayer) obj).getResultid();
            if (resultid != null && resultid.intValue() == 1) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(Integer.valueOf(((MTGamePlayer) it.next()).getId()), 1);
        }
        List<MTGameEvent> events = this.game.getEvents();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : events) {
            MTGameEvent mTGameEvent = (MTGameEvent) obj2;
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerLose.getValue()) || Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerConcede.getValue())) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (true) {
            pair = null;
            if (!it2.hasNext()) {
                break;
            }
            MTGameEvent mTGameEvent2 = (MTGameEvent) it2.next();
            try {
                pair = new Pair(Integer.valueOf(mTGameEvent2.getPlayerid()), ZonedDateTime.parse(mTGameEvent2.getDate(), DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"))));
            } catch (Exception unused) {
            }
            if (pair != null) {
                arrayList3.add(pair);
            }
        }
        List<Pair> listSortedWith = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.studiolaganne.lengendarylens.GameResultAdapter$calculatePlayerPositions$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((ZonedDateTime) ((Pair) t).getSecond(), (ZonedDateTime) ((Pair) t2).getSecond());
            }
        });
        if (!listSortedWith.isEmpty()) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (Pair pair2 : listSortedWith) {
                int iIntValue = ((Number) pair2.component1()).intValue();
                ZonedDateTime zonedDateTime = (ZonedDateTime) pair2.component2();
                if (pair == null || Math.abs(ChronoUnit.SECONDS.between((Temporal) pair, zonedDateTime)) <= 10) {
                    arrayList5.add(Integer.valueOf(iIntValue));
                } else {
                    if (!arrayList5.isEmpty()) {
                        arrayList4.add(arrayList5);
                    }
                    arrayList5 = CollectionsKt.mutableListOf(Integer.valueOf(iIntValue));
                }
                pair = zonedDateTime;
            }
            if (!arrayList5.isEmpty()) {
                arrayList4.add(arrayList5);
            }
            int size = 2;
            for (List list : CollectionsKt.reversed(arrayList4)) {
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    linkedHashMap.put(Integer.valueOf(((Number) it3.next()).intValue()), Integer.valueOf(size));
                }
                size += list.size();
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$3$1$3(GameResultViewHolder gameResultViewHolder, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        gameResultViewHolder.getManaLayout().setVisibility(0);
        gameResultViewHolder.getWMana().setVisibility(8);
        gameResultViewHolder.getUMana().setVisibility(8);
        gameResultViewHolder.getBMana().setVisibility(8);
        gameResultViewHolder.getRMana().setVisibility(8);
        gameResultViewHolder.getGMana().setVisibility(8);
        gameResultViewHolder.getCMana().setVisibility(8);
        for (String str : data.getColors()) {
            int iHashCode = str.hashCode();
            if (iHashCode != 66) {
                if (iHashCode != 71) {
                    if (iHashCode != 82) {
                        if (iHashCode != 85) {
                            if (iHashCode == 87 && str.equals(ExifInterface.LONGITUDE_WEST)) {
                                gameResultViewHolder.getWMana().setVisibility(0);
                            }
                        } else if (str.equals("U")) {
                            gameResultViewHolder.getUMana().setVisibility(0);
                        }
                    } else if (str.equals("R")) {
                        gameResultViewHolder.getRMana().setVisibility(0);
                    }
                } else if (str.equals(GameUtils.CONDITION_GOOD)) {
                    gameResultViewHolder.getGMana().setVisibility(0);
                }
            } else if (str.equals("B")) {
                gameResultViewHolder.getBMana().setVisibility(0);
            }
        }
        if (data.getColors().isEmpty() && data.getHasColors()) {
            gameResultViewHolder.getCMana().setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$3$1$4(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("LifeTotalView", "Error fetching deck data: " + error);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fullGame.getPlayers().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:210:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:281:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int i;
        Object next;
        boolean z;
        int value;
        int i2;
        String string;
        MTDeck deck;
        MTDeck mTDeck;
        int i3;
        int i4;
        MTGamePlayer mTGamePlayer;
        Iterator<MTGameEvent> it;
        Integer source_playerid;
        int i5;
        Integer source_playerid2;
        int i6;
        Object next2;
        Object next3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final GameResultViewHolder gameResultViewHolder = (GameResultViewHolder) holder;
        gameResultViewHolder.getLifeTotalView().setSummary(true);
        gameResultViewHolder.getLifeTotalView().setClipToOutline(true);
        gameResultViewHolder.getLifeTotalView().setUserInteractionEnabled(false);
        gameResultViewHolder.getLifeTotalView().setPlayerName("");
        gameResultViewHolder.getLifeTotalView().showCommanderDamage(false);
        gameResultViewHolder.getLifeTotalView().showPoisonCounters(false);
        gameResultViewHolder.getLifeTotalView().hidePlusAndMinus();
        gameResultViewHolder.getWinnerTextView().setVisibility(4);
        gameResultViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        gameResultViewHolder.getProfileLayout().setClipToOutline(true);
        gameResultViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        gameResultViewHolder.getProfileIcon().setClipToOutline(true);
        gameResultViewHolder.getTotalTimeLayout().setVisibility(8);
        List<MTGamePlayer> players = this.fullGame.getPlayers();
        if ((players instanceof Collection) && players.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it2 = players.iterator();
            i = 0;
            while (it2.hasNext()) {
                Integer resultid = ((MTGamePlayer) it2.next()).getResultid();
                if ((resultid != null && resultid.intValue() == 3) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        boolean z2 = i >= 2;
        Iterator<T> it3 = this.game.getEvents().iterator();
        while (true) {
            if (it3.hasNext()) {
                next = it3.next();
                if (Intrinsics.areEqual(((MTGameEvent) next).getType(), MTEvent.PlayerStart.getValue())) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTGameEvent mTGameEvent = (MTGameEvent) next;
        if (mTGameEvent != null) {
            z = mTGameEvent.getPlayerid() == this.fullGame.getPlayers().get(position).getId();
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        } else {
            z = false;
        }
        gameResultViewHolder.getStartingPlayerLabel().setVisibility(z ? 0 : 8);
        gameResultViewHolder.getLifeTotalView().setOrangeBorder(z);
        MTGamePlayer mTGamePlayer2 = this.fullGame.getPlayers().get(position);
        String picture = mTGamePlayer2.getPicture();
        String str = picture;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            gameResultViewHolder.getProfileIcon().setVisibility(4);
            gameResultViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            gameResultViewHolder.getProfileIcon().setVisibility(0);
            gameResultViewHolder.getNoPhotoIcon().setVisibility(4);
            gameResultViewHolder.getProfileIcon().reset();
            gameResultViewHolder.getProfileIcon().setAutoLoad(false);
            gameResultViewHolder.getProfileIcon().loadImage(picture);
        }
        gameResultViewHolder.getUserFirstnameTextView().setText(mTGamePlayer2.getFirstname());
        gameResultViewHolder.getUserNameTextView().setText("@" + mTGamePlayer2.getUsername());
        List<MTGameEvent> events = this.game.getEvents();
        int size = this.game.getPlayers().size();
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(0);
        }
        ArrayList arrayList2 = arrayList;
        int size2 = this.game.getPlayers().size();
        ArrayList arrayList3 = new ArrayList(size2);
        for (int i8 = 0; i8 < size2; i8++) {
            arrayList3.add(0);
        }
        ArrayList arrayList4 = arrayList3;
        MTGameFormat format = this.fullGame.getFormat();
        if (format != null) {
            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
            Context context = gameResultViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Iterator<T> it4 = companion.getInstance(context).getFormats().iterator();
            while (true) {
                if (it4.hasNext()) {
                    next2 = it4.next();
                    if (((MTFormat) next2).getId() == format.getId()) {
                        break;
                    }
                } else {
                    next2 = null;
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next2;
            if (mTFormat != null) {
                value = mTFormat.getLifetotal();
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            } else {
                value = 40;
            }
            MTGameSubformat subformat = this.fullGame.getSubformat();
            if (subformat != null) {
                DecksDBHelper.Companion companion2 = DecksDBHelper.INSTANCE;
                Context context2 = gameResultViewHolder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                Iterator<T> it5 = companion2.getInstance(context2).getSubformats(format.getId()).iterator();
                while (true) {
                    if (it5.hasNext()) {
                        next3 = it5.next();
                        if (((MTSubformat) next3).getId() == subformat.getId()) {
                            break;
                        }
                    } else {
                        next3 = null;
                        break;
                    }
                }
                MTSubformat mTSubformat = (MTSubformat) next3;
                if (mTSubformat != null) {
                    Integer lifetotal = mTSubformat.getLifetotal();
                    if (lifetotal != null) {
                        value = lifetotal.intValue();
                    }
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
            }
        } else {
            value = 40;
        }
        Iterator<MTGameEvent> it6 = events.iterator();
        int value2 = 0;
        int value3 = 0;
        while (it6.hasNext()) {
            MTGameEvent next4 = it6.next();
            if (Intrinsics.areEqual(next4.getType(), MTEvent.LifeOffset.getValue()) && next4.getPlayerid() == mTGamePlayer2.getId()) {
                value += next4.getValue();
            }
            if (Intrinsics.areEqual(next4.getType(), MTEvent.CommanderDamage.getValue()) && next4.getPlayerid() == mTGamePlayer2.getId() && (source_playerid2 = next4.getSource_playerid()) != null) {
                int iIntValue = source_playerid2.intValue();
                Iterator<MTGamePlayer> it7 = this.fullGame.getPlayers().iterator();
                int i9 = 0;
                while (true) {
                    if (!it7.hasNext()) {
                        mTGamePlayer = mTGamePlayer2;
                        i6 = -1;
                        break;
                    }
                    mTGamePlayer = mTGamePlayer2;
                    if (it7.next().getId() == iIntValue) {
                        i6 = i9;
                        break;
                    } else {
                        i9++;
                        mTGamePlayer2 = mTGamePlayer;
                    }
                }
                if (i6 != -1) {
                    arrayList2.set(i6, Integer.valueOf(((Number) arrayList2.get(i6)).intValue() + next4.getValue()));
                }
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            } else {
                mTGamePlayer = mTGamePlayer2;
            }
            if (Intrinsics.areEqual(next4.getType(), MTEvent.PartnerDamage.getValue()) && next4.getPlayerid() == mTGamePlayer.getId() && (source_playerid = next4.getSource_playerid()) != null) {
                int iIntValue2 = source_playerid.intValue();
                Iterator<MTGamePlayer> it8 = this.fullGame.getPlayers().iterator();
                int i10 = 0;
                while (true) {
                    if (!it8.hasNext()) {
                        it = it6;
                        i5 = -1;
                        break;
                    }
                    it = it6;
                    if (it8.next().getId() == iIntValue2) {
                        i5 = i10;
                        break;
                    } else {
                        i10++;
                        it6 = it;
                    }
                }
                if (i5 != -1) {
                    arrayList4.set(i5, Integer.valueOf(((Number) arrayList4.get(i5)).intValue() + next4.getValue()));
                }
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            } else {
                it = it6;
            }
            if (Intrinsics.areEqual(next4.getType(), MTEvent.Poison.getValue()) && next4.getPlayerid() == mTGamePlayer.getId()) {
                value2 += next4.getValue();
            }
            if (Intrinsics.areEqual(next4.getType(), MTEvent.TurnEnd.getValue()) && next4.getPlayerid() == mTGamePlayer.getId()) {
                value3 += next4.getValue();
            }
            it6 = it;
            mTGamePlayer2 = mTGamePlayer;
        }
        MTGamePlayer mTGamePlayer3 = mTGamePlayer2;
        gameResultViewHolder.getLifeTotalView().setLifeTotal(value);
        ArrayList arrayList5 = arrayList2;
        if (CollectionsKt.maxOrNull((Iterable) arrayList5) != null || CollectionsKt.maxOrNull((Iterable) arrayList4) != null) {
            gameResultViewHolder.getLifeTotalView().showCommanderDamage(true);
            LifeTotalView lifeTotalView = gameResultViewHolder.getLifeTotalView();
            Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) arrayList5);
            int iIntValue3 = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) CollectionsKt.maxOrNull((Iterable) arrayList4);
            lifeTotalView.setDisplayedCommanderDamage(Integer.max(iIntValue3, num2 != null ? num2.intValue() : 0));
        }
        if (value2 > 0) {
            gameResultViewHolder.getLifeTotalView().showPoisonCounters(true);
            gameResultViewHolder.getLifeTotalView().setPoisonCounters(value2);
        }
        if (value3 > 0) {
            gameResultViewHolder.getTotalTimeLayout().setVisibility(0);
            gameResultViewHolder.getTotalTimeTextView().setText(ServerUtils.INSTANCE.getInstance().formatDurationSeconds(value3));
        }
        Unit unit11 = Unit.INSTANCE;
        if (z2) {
            gameResultViewHolder.getWinnerTextView().setText(gameResultViewHolder.itemView.getResources().getString(R.string.draw));
            gameResultViewHolder.getWinnerTextView().setBackgroundResource(R.drawable.orange_box);
            gameResultViewHolder.getWinnerTextView().setTextColor(ContextCompat.getColor(gameResultViewHolder.itemView.getContext(), R.color.almost_white));
            gameResultViewHolder.getWinnerTextView().setVisibility(0);
        } else {
            Integer resultid2 = mTGamePlayer3.getResultid();
            if (resultid2 == null || resultid2.intValue() != 1) {
                gameResultViewHolder.getLifeTotalView().stopVitals();
                gameResultViewHolder.getLifeTotalView().dimForLoss();
                Integer num3 = this.playerPositions.get(Integer.valueOf(mTGamePlayer3.getId()));
                if (num3 == null || num3.intValue() < 2) {
                    i2 = 8;
                    gameResultViewHolder.getWinnerTextView().setVisibility(8);
                } else {
                    switch (num3.intValue()) {
                        case 2:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_2nd);
                            break;
                        case 3:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_3rd);
                            break;
                        case 4:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_4th);
                            break;
                        case 5:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_5th);
                            break;
                        case 6:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_6th);
                            break;
                        case 7:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_7th);
                            break;
                        case 8:
                            string = gameResultViewHolder.itemView.getResources().getString(R.string.position_8th);
                            break;
                        default:
                            string = null;
                            break;
                    }
                    if (string != null) {
                        gameResultViewHolder.getWinnerTextView().setText(string);
                        gameResultViewHolder.getWinnerTextView().setBackgroundResource(R.drawable.custom_player_background);
                        gameResultViewHolder.getWinnerTextView().setTextColor(ContextCompat.getColor(gameResultViewHolder.itemView.getContext(), R.color.almost_white));
                        gameResultViewHolder.getWinnerTextView().setVisibility(0);
                    } else {
                        i2 = 8;
                        gameResultViewHolder.getWinnerTextView().setVisibility(8);
                    }
                }
                gameResultViewHolder.getWMana().setVisibility(i2);
                gameResultViewHolder.getUMana().setVisibility(i2);
                gameResultViewHolder.getBMana().setVisibility(i2);
                gameResultViewHolder.getRMana().setVisibility(i2);
                gameResultViewHolder.getGMana().setVisibility(i2);
                gameResultViewHolder.getCMana().setVisibility(i2);
                gameResultViewHolder.getBracketLayout().setVisibility(i2);
                deck = mTGamePlayer3.getDeck();
                if (deck == null) {
                    MTBracket bracket = deck.getBracket();
                    if (bracket != null) {
                        Integer user = bracket.getUser();
                        if (user != null) {
                            int iIntValue4 = user.intValue();
                            gameResultViewHolder.getBracketLayout().setVisibility(0);
                            gameResultViewHolder.getBracketValueTextView().setText(String.valueOf(iIntValue4));
                            Unit unit12 = Unit.INSTANCE;
                            Unit unit13 = Unit.INSTANCE;
                        } else {
                            Integer auto = bracket.getAuto();
                            if (auto != null) {
                                int iIntValue5 = auto.intValue();
                                gameResultViewHolder.getBracketLayout().setVisibility(0);
                                gameResultViewHolder.getBracketValueTextView().setText(String.valueOf(iIntValue5));
                                Unit unit14 = Unit.INSTANCE;
                                Unit unit15 = Unit.INSTANCE;
                            }
                        }
                    }
                    Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
                    player.setName("");
                    player.setLeftBackgroundType(BackgroundType.BLACK);
                    player.setBackgroundType(BackgroundType.BLACK);
                    String leftplaymat = deck.getLeftplaymat();
                    if (leftplaymat != null) {
                        if (StringsKt.startsWith$default(leftplaymat, "id:", false, 2, (Object) null)) {
                            String strSubstring = leftplaymat.substring(3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            String str2 = strSubstring;
                            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                                List listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                                String str3 = (String) listSplit$default.get(0);
                                i4 = Integer.parseInt((String) listSplit$default.get(1));
                                strSubstring = str3;
                            } else {
                                i4 = 0;
                            }
                            GameUtils companion3 = GameUtils.INSTANCE.getInstance();
                            Context context3 = gameResultViewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                            CardRecord cardLocal = companion3.getCardLocal(context3, strSubstring, i4);
                            if (cardLocal != null) {
                                String strTranslateTag = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal.getLang());
                                String lowerCase = cardLocal.getType_line().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                mTDeck = deck;
                                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) strTranslateTag, false, 2, (Object) null)) {
                                    player.setLeftIsPlaneswalker(true);
                                }
                                Unit unit16 = Unit.INSTANCE;
                                Unit unit17 = Unit.INSTANCE;
                            } else {
                                mTDeck = deck;
                            }
                            player.setLeftBackgroundType(BackgroundType.SCRYFALL_ID);
                            player.setLeftScryfallId(strSubstring + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i4);
                        } else {
                            mTDeck = deck;
                        }
                        Unit unit18 = Unit.INSTANCE;
                        Unit unit19 = Unit.INSTANCE;
                    } else {
                        mTDeck = deck;
                    }
                    String rightplaymat = mTDeck.getRightplaymat();
                    if (rightplaymat != null) {
                        if (StringsKt.startsWith$default(rightplaymat, "id:", false, 2, (Object) null)) {
                            String strSubstring2 = rightplaymat.substring(3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                            String str4 = strSubstring2;
                            if (StringsKt.contains$default((CharSequence) str4, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                                List listSplit$default2 = StringsKt.split$default((CharSequence) str4, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                                String str5 = (String) listSplit$default2.get(0);
                                i3 = Integer.parseInt((String) listSplit$default2.get(1));
                                strSubstring2 = str5;
                            } else {
                                i3 = 0;
                            }
                            GameUtils companion4 = GameUtils.INSTANCE.getInstance();
                            Context context4 = gameResultViewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                            CardRecord cardLocal2 = companion4.getCardLocal(context4, strSubstring2, i3);
                            if (cardLocal2 != null) {
                                String strTranslateTag2 = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal2.getLang());
                                String lowerCase2 = cardLocal2.getType_line().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) strTranslateTag2, false, 2, (Object) null)) {
                                    player.setPlaneswalker(true);
                                }
                                Unit unit20 = Unit.INSTANCE;
                                Unit unit21 = Unit.INSTANCE;
                            }
                            player.setBackgroundType(BackgroundType.SCRYFALL_ID);
                            player.setScryfallId(strSubstring2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i3);
                        }
                        Unit unit22 = Unit.INSTANCE;
                        Unit unit23 = Unit.INSTANCE;
                    }
                    gameResultViewHolder.getLifeTotalView().updatePlayer(player);
                    gameResultViewHolder.getDeckNameTextView().setText(mTDeck.getName());
                    String lowerCase3 = mTDeck.getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase3, "unknown deck")) {
                        gameResultViewHolder.getDeckNameTextView().setText(holder.itemView.getResources().getString(R.string.unknown_deck));
                    }
                    gameResultViewHolder.getManaLayout().setVisibility(4);
                    DeckUtils companion5 = DeckUtils.INSTANCE.getInstance();
                    Context context5 = gameResultViewHolder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                    companion5.fetchDeckData(context5, mTDeck, new Function1() { // from class: com.studiolaganne.lengendarylens.GameResultAdapter$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GameResultAdapter.onBindViewHolder$lambda$3$1$3(gameResultViewHolder, (MTDeckData) obj);
                        }
                    }, new Function1() { // from class: com.studiolaganne.lengendarylens.GameResultAdapter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GameResultAdapter.onBindViewHolder$lambda$3$1$4((String) obj);
                        }
                    });
                    Unit unit24 = Unit.INSTANCE;
                    Unit unit25 = Unit.INSTANCE;
                    return;
                }
                return;
            }
            gameResultViewHolder.getWinnerTextView().setText(gameResultViewHolder.itemView.getResources().getString(R.string.winner));
            gameResultViewHolder.getWinnerTextView().setBackgroundResource(R.drawable.green_box);
            gameResultViewHolder.getWinnerTextView().setTextColor(ContextCompat.getColor(gameResultViewHolder.itemView.getContext(), R.color.almost_black));
            gameResultViewHolder.getWinnerTextView().setVisibility(0);
        }
        i2 = 8;
        gameResultViewHolder.getWMana().setVisibility(i2);
        gameResultViewHolder.getUMana().setVisibility(i2);
        gameResultViewHolder.getBMana().setVisibility(i2);
        gameResultViewHolder.getRMana().setVisibility(i2);
        gameResultViewHolder.getGMana().setVisibility(i2);
        gameResultViewHolder.getCMana().setVisibility(i2);
        gameResultViewHolder.getBracketLayout().setVisibility(i2);
        deck = mTGamePlayer3.getDeck();
        if (deck == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_summary_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new GameResultViewHolder(viewInflate);
    }
}
