package com.studiolaganne.lengendarylens;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingConverter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingConverter;", "", "<init>", "()V", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StreamingConverter {
    public static final int $stable = 0;
    private static boolean formatHasCommander;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String cachedFormatName = "";
    private static Map<Integer, String> commanderNameCache = new LinkedHashMap();
    private static Map<Integer, String> commanderIdCache = new LinkedHashMap();
    private static Map<Integer, String> partnerNameCache = new LinkedHashMap();
    private static Map<Integer, String> partnerIdCache = new LinkedHashMap();

    /* JADX INFO: compiled from: StreamingConverter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingConverter$Companion;", "", "<init>", "()V", "cachedFormatName", "", "getCachedFormatName", "()Ljava/lang/String;", "setCachedFormatName", "(Ljava/lang/String;)V", "formatHasCommander", "", "getFormatHasCommander", "()Z", "setFormatHasCommander", "(Z)V", "commanderNameCache", "", "", "getCommanderNameCache", "()Ljava/util/Map;", "setCommanderNameCache", "(Ljava/util/Map;)V", "commanderIdCache", "getCommanderIdCache", "setCommanderIdCache", "partnerNameCache", "getPartnerNameCache", "setPartnerNameCache", "partnerIdCache", "getPartnerIdCache", "setPartnerIdCache", "convertToStreamingData", "Lcom/studiolaganne/lengendarylens/GameStreamingData;", "context", "Landroid/content/Context;", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final GameStreamingData convertToStreamingData(Context context, GameState gameState) {
            boolean z;
            Object next;
            String str;
            String name;
            GameStatus gameStatus;
            boolean z2;
            CommanderData commanderData;
            CommanderData commanderData2;
            String str2;
            CommanderData commanderData3;
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(gameState, "gameState");
            GameStatus gameStatus2 = GameStatus.IN_PROGRESS;
            if (gameState.getGameSyncable() && (!gameState.getUsersSeated() || !gameState.getDecksSelected())) {
                gameStatus2 = GameStatus.NOT_STARTED;
            }
            List<MTGameEvent> events = gameState.getEvents();
            if ((events instanceof Collection) && events.isEmpty()) {
                z = false;
            } else {
                Iterator<T> it = events.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((MTGameEvent) it.next()).getType(), MTEvent.GameDraw.getValue())) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(gameState);
            if (z || !gameWinners.isEmpty()) {
                gameStatus2 = GameStatus.FINISHED;
            }
            if (getCachedFormatName().length() > 0) {
                name = getCachedFormatName();
            } else {
                Iterator<T> it2 = DecksDBHelper.INSTANCE.getInstance(context2).getFormats().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (((MTFormat) next).getId() == gameState.getFormatId()) {
                        break;
                    }
                }
                MTFormat mTFormat = (MTFormat) next;
                if (mTFormat == null) {
                    str = "";
                    GameSet currentSet = new PreferencesManager(context2).getCurrentSet();
                    StreamingGameSet streamingGameSet = currentSet == null ? new StreamingGameSet(currentSet.getFinishedGames().size(), currentSet.getBestOf()) : null;
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (Player player : gameState.getPlayers()) {
                        int i2 = i + 1;
                        ArrayList arrayList2 = new ArrayList();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (player.getDeckId() == -1 || !getFormatHasCommander()) {
                            gameStatus = gameStatus2;
                            z2 = z;
                            commanderData = null;
                            commanderData2 = null;
                        } else {
                            String str3 = getCommanderNameCache().get(Integer.valueOf(player.getDeckId()));
                            String str4 = getCommanderIdCache().get(Integer.valueOf(player.getDeckId()));
                            if (str4 != null) {
                                if (str3 == null) {
                                    str3 = "";
                                }
                                gameStatus = gameStatus2;
                                z2 = z;
                                str2 = str3;
                            } else if (player.getBackgroundType() == BackgroundType.SCRYFALL_ID) {
                                Pair<String, Integer> pairExtractIdAndFace = DeckUtils.INSTANCE.extractIdAndFace(player.getScryfallId());
                                String strComponent1 = pairExtractIdAndFace.component1();
                                int iIntValue = pairExtractIdAndFace.component2().intValue();
                                gameStatus = gameStatus2;
                                z2 = z;
                                getCommanderIdCache().put(Integer.valueOf(player.getDeckId()), strComponent1);
                                CardRecord cardLocal = GameUtils.INSTANCE.getInstance().getCardLocal(context2, strComponent1, iIntValue);
                                if (cardLocal != null) {
                                    String title = cardLocal.getTitle();
                                    StreamingConverter.INSTANCE.getCommanderNameCache().put(Integer.valueOf(player.getDeckId()), title);
                                    str2 = title;
                                    str4 = strComponent1;
                                } else {
                                    str4 = strComponent1;
                                    str2 = "";
                                }
                            } else {
                                gameStatus = gameStatus2;
                                z2 = z;
                                str4 = "";
                                str2 = str4;
                            }
                            CommanderData commanderData4 = new CommanderData(str2, str4);
                            String title2 = getPartnerNameCache().get(Integer.valueOf(player.getDeckId()));
                            String strComponent12 = getPartnerIdCache().get(Integer.valueOf(player.getDeckId()));
                            if (strComponent12 != null) {
                                if (title2 == null) {
                                    title2 = "";
                                }
                                commanderData3 = commanderData4;
                            } else if (player.getLeftBackgroundType() == BackgroundType.SCRYFALL_ID) {
                                Pair<String, Integer> pairExtractIdAndFace2 = DeckUtils.INSTANCE.extractIdAndFace(player.getLeftScryfallId());
                                strComponent12 = pairExtractIdAndFace2.component1();
                                int iIntValue2 = pairExtractIdAndFace2.component2().intValue();
                                commanderData3 = commanderData4;
                                getPartnerIdCache().put(Integer.valueOf(player.getDeckId()), strComponent12);
                                CardRecord cardLocal2 = GameUtils.INSTANCE.getInstance().getCardLocal(context2, strComponent12, iIntValue2);
                                if (cardLocal2 != null) {
                                    title2 = cardLocal2.getTitle();
                                    StreamingConverter.INSTANCE.getPartnerNameCache().put(Integer.valueOf(player.getDeckId()), title2);
                                } else {
                                    title2 = "";
                                }
                            } else {
                                commanderData3 = commanderData4;
                                title2 = "";
                                strComponent12 = title2;
                            }
                            commanderData2 = new CommanderData(title2, strComponent12);
                            commanderData = commanderData3;
                        }
                        int size = gameState.getPlayers().size();
                        for (int i3 = 0; i3 < size; i3++) {
                            linkedHashMap.put(String.valueOf(i3), Integer.valueOf(Math.max(player.getCommanderDamageList().get(i3).intValue(), player.getCommanderDamageListPartner().get(i3).intValue())));
                        }
                        if (z2) {
                            arrayList2.add(Integer.valueOf(GameResult.DRAW.getValue()));
                        } else if (!gameWinners.isEmpty()) {
                            if (gameWinners.contains(Integer.valueOf(i))) {
                                arrayList2.add(Integer.valueOf(GameResult.WIN.getValue()));
                            } else {
                                arrayList2.add(Integer.valueOf(GameResult.LOSS.getValue()));
                            }
                        }
                        arrayList.add(new PlayerStreamingData(player.getName(), player.getLifeTotal(), commanderData, commanderData2, player.getPoisonCounters(), 0, CollectionsKt.toList(arrayList2), linkedHashMap));
                        context2 = context;
                        i = i2;
                        gameStatus2 = gameStatus;
                        z = z2;
                    }
                    return new GameStreamingData(gameStatus2.getValue(), str, streamingGameSet, 0, gameState.getCurrentGameTurn(), 0, gameState.getCurrentTurnPlayerIndex(), arrayList);
                }
                name = mTFormat.getName();
                StreamingConverter.INSTANCE.setCachedFormatName(mTFormat.getName());
                StreamingConverter.INSTANCE.setFormatHasCommander(mTFormat.getHascommander());
            }
            str = name;
            GameSet currentSet2 = new PreferencesManager(context2).getCurrentSet();
            if (currentSet2 == null) {
            }
            ArrayList arrayList3 = new ArrayList();
            int i4 = 0;
            while (r9.hasNext()) {
            }
            return new GameStreamingData(gameStatus2.getValue(), str, streamingGameSet, 0, gameState.getCurrentGameTurn(), 0, gameState.getCurrentTurnPlayerIndex(), arrayList3);
        }

        public final String getCachedFormatName() {
            return StreamingConverter.cachedFormatName;
        }

        public final Map<Integer, String> getCommanderIdCache() {
            return StreamingConverter.commanderIdCache;
        }

        public final Map<Integer, String> getCommanderNameCache() {
            return StreamingConverter.commanderNameCache;
        }

        public final boolean getFormatHasCommander() {
            return StreamingConverter.formatHasCommander;
        }

        public final Map<Integer, String> getPartnerIdCache() {
            return StreamingConverter.partnerIdCache;
        }

        public final Map<Integer, String> getPartnerNameCache() {
            return StreamingConverter.partnerNameCache;
        }

        public final void setCachedFormatName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            StreamingConverter.cachedFormatName = str;
        }

        public final void setCommanderIdCache(Map<Integer, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            StreamingConverter.commanderIdCache = map;
        }

        public final void setCommanderNameCache(Map<Integer, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            StreamingConverter.commanderNameCache = map;
        }

        public final void setFormatHasCommander(boolean z) {
            StreamingConverter.formatHasCommander = z;
        }

        public final void setPartnerIdCache(Map<Integer, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            StreamingConverter.partnerIdCache = map;
        }

        public final void setPartnerNameCache(Map<Integer, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            StreamingConverter.partnerNameCache = map;
        }
    }
}
