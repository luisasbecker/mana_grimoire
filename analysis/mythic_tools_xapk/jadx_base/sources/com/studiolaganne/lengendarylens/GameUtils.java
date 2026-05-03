package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: compiled from: GameUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u0098\u00012\u00020\u0001:\u0002\u0098\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u001f2\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u00020$J\u0016\u00106\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u00020$J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020$J\u0016\u00109\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u00020$J\u0016\u0010:\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010;\u001a\u00020<J\u0016\u0010>\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010;\u001a\u00020<J\u0016\u0010?\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010;\u001a\u00020<J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u001f2\u0006\u0010;\u001a\u00020<2\u0006\u0010B\u001a\u00020\u0006J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020$0\u001fJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fJ\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020 J\u0016\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020JJ\u0016\u0010K\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u0010L\u001a\u00020\u0006J\u000e\u0010M\u001a\u00020\f2\u0006\u0010;\u001a\u00020<J\u000e\u0010N\u001a\u00020\f2\u0006\u0010;\u001a\u00020<J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010P\u001a\u00020\f2\u0006\u0010;\u001a\u00020<H\u0002J\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\u0006\u0010;\u001a\u00020<J\u0016\u0010R\u001a\u00020S2\u0006\u0010;\u001a\u00020<2\u0006\u0010T\u001a\u00020\u0006J\u0016\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00062\u0006\u00102\u001a\u000203J%\u0010W\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010[J\u0006\u0010^\u001a\u00020$J\u0018\u0010_\u001a\u0004\u0018\u00010$2\u0006\u00102\u001a\u0002032\u0006\u0010`\u001a\u00020aJ\u0016\u0010b\u001a\u00020c2\u0006\u0010`\u001a\u00020d2\u0006\u0010e\u001a\u00020$J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020$H\u0002J\u0016\u0010i\u001a\u00020$2\u0006\u0010j\u001a\u00020c2\u0006\u0010h\u001a\u00020$J\u0016\u0010k\u001a\u00020$2\u0006\u0010j\u001a\u00020c2\u0006\u0010h\u001a\u00020$J,\u0010l\u001a\u0004\u0018\u00010m2\u001a\u0010n\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020m\u0018\u00010oj\u0004\u0018\u0001`p2\u0006\u0010h\u001a\u00020$J*\u0010q\u001a\u00020$2\u001a\u0010n\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020m\u0018\u00010oj\u0004\u0018\u0001`p2\u0006\u0010h\u001a\u00020$J\u0016\u0010r\u001a\u00020$2\u0006\u0010s\u001a\u00020t2\u0006\u0010h\u001a\u00020$J\u0018\u0010u\u001a\u00020c2\u0006\u0010`\u001a\u00020d2\u0006\u0010h\u001a\u00020$H\u0007J\u000e\u0010v\u001a\u00020d2\u0006\u0010`\u001a\u00020wJ\"\u0010x\u001a\u0004\u0018\u00010y2\u0006\u00102\u001a\u0002032\u0006\u0010z\u001a\u00020$2\b\b\u0002\u0010{\u001a\u00020\u0006J6\u0010|\u001a\u00020}2\u0006\u00102\u001a\u0002032\u0006\u0010z\u001a\u00020$2\b\b\u0002\u0010{\u001a\u00020\u00062\u0014\u0010~\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010y\u0012\u0004\u0012\u00020}0\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<J\u000f\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<J\u000f\u0010\u0082\u0001\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<J\u000f\u0010\u0083\u0001\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<J\u0007\u0010\u0084\u0001\u001a\u00020}J\u0007\u0010\u0085\u0001\u001a\u00020}J\u0007\u0010\u0086\u0001\u001a\u00020}J\u0007\u0010\u0087\u0001\u001a\u00020}J\u0019\u0010\u0088\u0001\u001a\u00020\u00062\u0007\u0010\u0089\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020YJ\u0010\u0010\u008b\u0001\u001a\u00020\u00062\u0007\u0010\u0089\u0001\u001a\u00020\u0006J\u0016\u0010\u008c\u0001\u001a\u00020$2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005J\u0016\u0010\u008e\u0001\u001a\u00020$2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005J\u0016\u0010\u008f\u0001\u001a\u00020$2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005J\u0016\u0010\u0090\u0001\u001a\u00020$2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005J\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J \u0010\u0093\u0001\u001a\u00020$2\b\u0010\u0094\u0001\u001a\u00030\u0092\u00012\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005J\u001f\u0010\u0093\u0001\u001a\u00020$2\u0007\u0010\u0095\u0001\u001a\u00020\f2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005J%\u0010\u0096\u0001\u001a\u00020$2\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u001f2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u0005R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\nR \u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR \u0010*\u001a\b\u0012\u0004\u0012\u00020$0\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR \u0010-\u001a\b\u0012\u0004\u0012\u00020$0\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\nR\u000e\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameUtils;", "", "<init>", "()V", "defaultColors", "", "", "getDefaultColors", "()Ljava/util/List;", "setDefaultColors", "(Ljava/util/List;)V", "monarchDragInProgress", "", "getMonarchDragInProgress", "()Z", "setMonarchDragInProgress", "(Z)V", "initiativeDragInProgress", "getInitiativeDragInProgress", "setInitiativeDragInProgress", "unseatedUsers", "Lcom/studiolaganne/lengendarylens/MTUser;", "getUnseatedUsers", "setUnseatedUsers", "unavailableUserIds", "getUnavailableUserIds", "setUnavailableUserIds", "gameParticipantUsers", "getGameParticipantUsers", "setGameParticipantUsers", "formats", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "getFormats", "setFormats", "decorsUsed", "", "getDecorsUsed", "setDecorsUsed", "kosUsed", "getKosUsed", "setKosUsed", "planarDeck", "getPlanarDeck", "setPlanarDeck", "schemeDeck", "getSchemeDeck", "setSchemeDeck", "getCounters", "Lcom/studiolaganne/lengendarylens/CounterDefinition;", "context", "Landroid/content/Context;", "colorForCardCondition", "condition", "nameForCardCondition", "conditionCodeForComboBracket", "bracketTag", "nameForComboBracket", "ensurePlanarDeck", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "rebuildPlanarDeck", "ensureSchemeDeck", "rebuildSchemeDeck", "getLifeHistoryEntries", "Lcom/studiolaganne/lengendarylens/LifeHistoryEntry;", "forPlayer", "getMainFormatIds", "getTop6FormatIds", "isDuel", "format", "getPlayerScore", "playerIndex", "set", "Lcom/studiolaganne/lengendarylens/GameSet;", "localizedTreacheryRoleName", "role", "isLeaderRevealed", "allPlayersHaveRole", "getTreacheryWinners", "isGameFinished", "getGameWinners", "createMTGameForUpload", "Lcom/studiolaganne/lengendarylens/MTCreateGame;", "currentUserId", "dpToPx", "dp", "getWinRateColor", "rate", "", "formatId", "(Landroid/content/Context;FLjava/lang/Integer;)I", "lastTimestamp", "", "getCurrentTimestamp", "getFirstPrintScryfallId", "card", "Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "getCardPrice", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "marketplace", "getLocaleForCurrency", "Ljava/util/Locale;", AppsFlyerProperties.CURRENCY_CODE, "formatPrice", FirebaseAnalytics.Param.PRICE, "formatPriceAmountOnly", "getContainerValue", "Lcom/studiolaganne/lengendarylens/MTCardsValue;", "values", "", "Lcom/studiolaganne/lengendarylens/MTCardsValues;", "formatContainerTotal", "formatDelta", "delta", "Lcom/studiolaganne/lengendarylens/MTPriceDelta;", "getCurrentPrice", "convertScryFallCard", "Lcom/studiolaganne/lengendarylens/Card;", "getCardLocal", "Lcom/studiolaganne/lengendarylens/CardRecord;", "scryfallId", OptionalModuleUtils.FACE, "getCard", "", "callback", "Lkotlin/Function1;", "timeElapsed", "timeLeft", "timeElapsedSeconds", "timeLeftSeconds", "startMonarchDrag", "stopMonarchDrag", "startInitiativeDrag", "stopInitiativeDrag", "adjustBrightness", "color", "brightness", "adjustOpacity", "randomBasicPlaymat", "excludingPlaymats", "randomSceneryPlaymat", "randomCreaturePlaymat", "randomGuildPlaymat", "pickRandomCategory", "Lcom/studiolaganne/lengendarylens/PlaymatCategory;", "randomPlaymat", "category", "basic", "randomPlaymatFromSkin", "from", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameUtils {
    public static final int ARCHENEMY_SUBFORMAT_ID = 7;
    public static final int BLITZ_SUBFORMAT_ID = 10;
    public static final int COMMANDER_FORMAT_ID = 6;
    public static final String CONDITION_EXCELENT = "EX";
    public static final String CONDITION_GOOD = "G";
    public static final String CONDITION_LIGHT_PLAYED = "LP";
    public static final String CONDITION_MINT = "M";
    public static final String CONDITION_NEAR_MINT = "NM";
    public static final String CONDITION_PLAYED = "PL";
    public static final String CONDITION_POOR = "P";
    public static final int PAUPER_COMMANDER_FORMAT_ID = 16;
    public static final int PLANECHASE_SUBFORMAT_ID = 1;
    public static final int THREE_HEADED_GIANT_SUBFORMAT_ID = 6;
    public static final int TREACHERY_ROLE_ASSASSIN_VALUE = 2;
    public static final int TREACHERY_ROLE_GUARDIAN_VALUE = 1;
    public static final int TREACHERY_ROLE_LEADER_VALUE = 0;
    public static final int TREACHERY_ROLE_TRAITOR_VALUE = 3;
    public static final int TREACHERY_SUBFORMAT_ID = 3;
    public static final int TWO_HEADED_GIANT_SUBFORMAT_ID = 5;
    private static GameUtils instance;
    private List<String> decorsUsed;
    private List<Integer> defaultColors;
    private List<MTFormat> formats;
    private List<MTUser> gameParticipantUsers;
    private boolean initiativeDragInProgress;
    private List<String> kosUsed;
    private long lastTimestamp;
    private boolean monarchDragInProgress;
    private List<String> planarDeck;
    private List<String> schemeDeck;
    private List<Integer> unavailableUserIds;
    private List<MTUser> unseatedUsers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static List<Integer> blitzTimePerTurn = CollectionsKt.listOf((Object[]) new Integer[]{10, 20, 30, 60, 120, 150, Integer.valueOf(SensibleDefaults.X_OFFSET)});
    private static List<Integer> blitzPenaltyTimeOffsets = CollectionsKt.listOf((Object[]) new Integer[]{0, 10, 20, 30, 45, 55, 60});
    private static List<Integer> blitzPenaltyLifeOffsets = CollectionsKt.listOf((Object[]) new Integer[]{1, 1, 2, 3, 4, 5, 1});

    /* JADX INFO: compiled from: GameUtils.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010'\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 ¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/GameUtils$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/GameUtils;", "PAUPER_COMMANDER_FORMAT_ID", "", "COMMANDER_FORMAT_ID", "TREACHERY_SUBFORMAT_ID", "TREACHERY_ROLE_LEADER_VALUE", "TREACHERY_ROLE_GUARDIAN_VALUE", "TREACHERY_ROLE_ASSASSIN_VALUE", "TREACHERY_ROLE_TRAITOR_VALUE", "TWO_HEADED_GIANT_SUBFORMAT_ID", "THREE_HEADED_GIANT_SUBFORMAT_ID", "CONDITION_POOR", "", "CONDITION_PLAYED", "CONDITION_LIGHT_PLAYED", "CONDITION_GOOD", "CONDITION_EXCELENT", "CONDITION_NEAR_MINT", "CONDITION_MINT", "PLANECHASE_SUBFORMAT_ID", "ARCHENEMY_SUBFORMAT_ID", "BLITZ_SUBFORMAT_ID", "blitzTimePerTurn", "", "getBlitzTimePerTurn", "()Ljava/util/List;", "setBlitzTimePerTurn", "(Ljava/util/List;)V", "blitzPenaltyTimeOffsets", "getBlitzPenaltyTimeOffsets", "setBlitzPenaltyTimeOffsets", "blitzPenaltyLifeOffsets", "getBlitzPenaltyLifeOffsets", "setBlitzPenaltyLifeOffsets", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Integer> getBlitzPenaltyLifeOffsets() {
            return GameUtils.blitzPenaltyLifeOffsets;
        }

        public final List<Integer> getBlitzPenaltyTimeOffsets() {
            return GameUtils.blitzPenaltyTimeOffsets;
        }

        public final List<Integer> getBlitzTimePerTurn() {
            return GameUtils.blitzTimePerTurn;
        }

        public final synchronized GameUtils getInstance() {
            GameUtils gameUtils;
            if (GameUtils.instance == null) {
                GameUtils.instance = new GameUtils(null);
            }
            gameUtils = GameUtils.instance;
            Intrinsics.checkNotNull(gameUtils);
            return gameUtils;
        }

        public final void setBlitzPenaltyLifeOffsets(List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            GameUtils.blitzPenaltyLifeOffsets = list;
        }

        public final void setBlitzPenaltyTimeOffsets(List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            GameUtils.blitzPenaltyTimeOffsets = list;
        }

        public final void setBlitzTimePerTurn(List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            GameUtils.blitzTimePerTurn = list;
        }
    }

    /* JADX INFO: compiled from: GameUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlaymatCategory.values().length];
            try {
                iArr[PlaymatCategory.BASIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlaymatCategory.CREATURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlaymatCategory.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlaymatCategory.SCENERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameUtils$getCard$2, reason: invalid class name */
    /* JADX INFO: compiled from: GameUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.GameUtils$getCard$2", f = "GameUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3}, l = {1333, 1337, 1342, 1347}, m = "invokeSuspend", n = {"$this$launch", "response", "cardData", "fetchedCard", "$i$a$-let-GameUtils$getCard$2$1", "$this$launch", "response", "$this$invokeSuspend_u24lambda_u241", "$i$a$-run-GameUtils$getCard$2$2", "$this$launch", "response", "$this$launch", "e"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Call<MTCardResponse> $call;
        final /* synthetic */ Function1<CardRecord, Unit> $callback;
        final /* synthetic */ int $face;
        final /* synthetic */ String $scryfallId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameUtils$getCard$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: GameUtils.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.GameUtils$getCard$2$3", f = "GameUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<CardRecord, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function1<? super CardRecord, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(null);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.GameUtils$getCard$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: GameUtils.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.GameUtils$getCard$2$4", f = "GameUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<CardRecord, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(Function1<? super CardRecord, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(null);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Call<MTCardResponse> call, String str, int i, Function1<? super CardRecord, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$call = call;
            this.$scryfallId = str;
            this.$face = i;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$call, this.$scryfallId, this.$face, this.$callback, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.GameUtils.AnonymousClass2.AnonymousClass3(r37.$callback, null), r37) == r3) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01b6, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.GameUtils.AnonymousClass2.AnonymousClass4(r37.$callback, null), r37) != r3) goto L74;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MTFullCard card;
            String strJoinToString$default;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                this.L$2 = null;
                this.L$3 = null;
                this.label = 4;
            }
            if (i != 0) {
                if (i == 1) {
                } else if (i == 2) {
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                Response<MTCardResponse> responseExecute = this.$call.execute();
                if (responseExecute.isSuccessful()) {
                    MTCardResponse mTCardResponseBody = responseExecute.body();
                    if (mTCardResponseBody == null || (card = mTCardResponseBody.getCard()) == null) {
                        Function1<CardRecord, Unit> function1 = this.$callback;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        GameUtils$getCard$2$2$1 gameUtils$getCard$2$2$1 = new GameUtils$getCard$2$2$1(function1, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseExecute);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$3 = null;
                        this.I$0 = 0;
                        this.label = 2;
                        if (BuildersKt.withContext(main, gameUtils$getCard$2$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        String str = this.$scryfallId;
                        int i2 = this.$face;
                        Function1<CardRecord, Unit> function12 = this.$callback;
                        String scryfallid = card.getScryfallid();
                        String str2 = scryfallid == null ? str : scryfallid;
                        String oracleid = card.getOracleid();
                        if (oracleid == null) {
                            oracleid = "";
                        }
                        String collector_number = card.getCollector_number();
                        if (collector_number == null) {
                            collector_number = "";
                        }
                        String name = card.getName();
                        String str3 = name == null ? "" : name;
                        String set_code = card.getSet_code();
                        String str4 = set_code == null ? "" : set_code;
                        String lang = card.getLang();
                        String type_line = card.getType_line();
                        String str5 = type_line == null ? "" : type_line;
                        String oracle_text = card.getOracle_text();
                        String str6 = oracle_text == null ? "" : oracle_text;
                        String mana_cost = card.getMana_cost();
                        String str7 = mana_cost == null ? "" : mana_cost;
                        List<String> color_identity = card.getColor_identity();
                        CardRecord cardRecord = new CardRecord(0, oracleid, str2, collector_number, 0, i2, str3, null, str4, null, null, null, lang, str5, str6, str7, null, null, (color_identity == null || (strJoinToString$default = CollectionsKt.joinToString$default(color_identity, "|", null, null, 0, null, null, 62, null)) == null) ? "" : strJoinToString$default, "", null, 1248913, null);
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        GameUtils$getCard$2$1$1 gameUtils$getCard$2$1$1 = new GameUtils$getCard$2$1$1(function12, cardRecord, null);
                        this.L$0 = coroutineScope;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseExecute);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(card);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(cardRecord);
                        this.I$0 = 0;
                        this.label = 1;
                        if (BuildersKt.withContext(main2, gameUtils$getCard$2$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseExecute);
                    this.label = 3;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private GameUtils() {
        this.defaultColors = new ArrayList();
        this.unseatedUsers = new ArrayList();
        this.unavailableUserIds = new ArrayList();
        this.gameParticipantUsers = new ArrayList();
        this.formats = CollectionsKt.emptyList();
        this.decorsUsed = new ArrayList();
        this.kosUsed = new ArrayList();
        this.planarDeck = CollectionsKt.emptyList();
        this.schemeDeck = CollectionsKt.emptyList();
        Integer[] numArr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            numArr[i] = Integer.valueOf(Color.HSVToColor(new float[]{((i + 4) * 36.0f) % 360.0f, 0.4f, 0.6f}));
        }
        this.defaultColors.addAll(ArraysKt.toList(numArr));
    }

    public /* synthetic */ GameUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getCard$default(GameUtils gameUtils, Context context, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        gameUtils.getCard(context, str, i, function1);
    }

    public static /* synthetic */ CardRecord getCardLocal$default(GameUtils gameUtils, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return gameUtils.getCardLocal(context, str, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x025b, code lost:
    
        if (r1.equals("DKK") == false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x025f, code lost:
    
        r1 = java.util.Locale.forLanguageTag("sv-SE");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "forLanguageTag(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0268, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bf, code lost:
    
        if (r1.equals("SEK") == false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0155, code lost:
    
        if (r1.equals("NOK") == false) goto L211;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Locale getLocaleForCurrency(String currencyCode) {
        String upperCase = currencyCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case 64672:
                if (upperCase.equals("AED")) {
                    Locale localeForLanguageTag = Locale.forLanguageTag("ar-AE");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                    return localeForLanguageTag;
                }
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                return locale;
            case 65090:
                if (upperCase.equals("ARS")) {
                    Locale localeForLanguageTag2 = Locale.forLanguageTag("es-AR");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
                    return localeForLanguageTag2;
                }
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                return locale2;
            case 65168:
                if (upperCase.equals("AUD")) {
                    Locale localeForLanguageTag3 = Locale.forLanguageTag("en-AU");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag3, "forLanguageTag(...)");
                    return localeForLanguageTag3;
                }
                Locale locale22 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22, "getDefault(...)");
                return locale22;
            case 65705:
                if (upperCase.equals("BGN")) {
                    Locale localeForLanguageTag4 = Locale.forLanguageTag("bg-BG");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag4, "forLanguageTag(...)");
                    return localeForLanguageTag4;
                }
                Locale locale222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222, "getDefault(...)");
                return locale222;
            case 66044:
                if (upperCase.equals("BRL")) {
                    Locale localeForLanguageTag5 = Locale.forLanguageTag("pt-BR");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag5, "forLanguageTag(...)");
                    return localeForLanguageTag5;
                }
                Locale locale2222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222, "getDefault(...)");
                return locale2222;
            case 66470:
                if (upperCase.equals("CAD")) {
                    Locale CANADA = Locale.CANADA;
                    Intrinsics.checkNotNullExpressionValue(CANADA, "CANADA");
                    return CANADA;
                }
                Locale locale22222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222, "getDefault(...)");
                return locale22222;
            case 66689:
                if (upperCase.equals("CHF")) {
                    Locale localeForLanguageTag6 = Locale.forLanguageTag("de-CH");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag6, "forLanguageTag(...)");
                    return localeForLanguageTag6;
                }
                Locale locale222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222, "getDefault(...)");
                return locale222222;
            case 66823:
                if (upperCase.equals("CLP")) {
                    Locale localeForLanguageTag7 = Locale.forLanguageTag("es-CL");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag7, "forLanguageTag(...)");
                    return localeForLanguageTag7;
                }
                Locale locale2222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222, "getDefault(...)");
                return locale2222222;
            case 66894:
                if (upperCase.equals("CNY")) {
                    Locale CHINA = Locale.CHINA;
                    Intrinsics.checkNotNullExpressionValue(CHINA, "CHINA");
                    return CHINA;
                }
                Locale locale22222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222, "getDefault(...)");
                return locale22222222;
            case 66916:
                if (upperCase.equals("COP")) {
                    Locale localeForLanguageTag8 = Locale.forLanguageTag("es-CO");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag8, "forLanguageTag(...)");
                    return localeForLanguageTag8;
                }
                Locale locale222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222, "getDefault(...)");
                return locale222222222;
            case 67252:
                if (upperCase.equals("CZK")) {
                    Locale localeForLanguageTag9 = Locale.forLanguageTag("cs-CZ");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag9, "forLanguageTag(...)");
                    return localeForLanguageTag9;
                }
                Locale locale2222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222, "getDefault(...)");
                return locale2222222222;
            case 67748:
                break;
            case 68590:
                if (upperCase.equals("EGP")) {
                    Locale localeForLanguageTag10 = Locale.forLanguageTag("ar-EG");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag10, "forLanguageTag(...)");
                    return localeForLanguageTag10;
                }
                Locale locale22222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222, "getDefault(...)");
                return locale22222222222;
            case 69026:
                if (upperCase.equals("EUR")) {
                    Locale FRANCE = Locale.FRANCE;
                    Intrinsics.checkNotNullExpressionValue(FRANCE, "FRANCE");
                    return FRANCE;
                }
                Locale locale222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222, "getDefault(...)");
                return locale222222222222;
            case 70357:
                if (upperCase.equals("GBP")) {
                    Locale UK = Locale.UK;
                    Intrinsics.checkNotNullExpressionValue(UK, "UK");
                    return UK;
                }
                Locale locale2222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222, "getDefault(...)");
                return locale2222222222222;
            case 71585:
                if (upperCase.equals("HKD")) {
                    Locale localeForLanguageTag11 = Locale.forLanguageTag("en-HK");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag11, "forLanguageTag(...)");
                    return localeForLanguageTag11;
                }
                Locale locale22222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222, "getDefault(...)");
                return locale22222222222222;
            case 71809:
                if (upperCase.equals("HRK")) {
                    Locale localeForLanguageTag12 = Locale.forLanguageTag("hr-HR");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag12, "forLanguageTag(...)");
                    return localeForLanguageTag12;
                }
                Locale locale222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222, "getDefault(...)");
                return locale222222222222222;
            case 71897:
                if (upperCase.equals("HUF")) {
                    Locale localeForLanguageTag13 = Locale.forLanguageTag("hu-HU");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag13, "forLanguageTag(...)");
                    return localeForLanguageTag13;
                }
                Locale locale2222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222, "getDefault(...)");
                return locale2222222222222222;
            case 72343:
                if (upperCase.equals("IDR")) {
                    Locale localeForLanguageTag14 = Locale.forLanguageTag("id-ID");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag14, "forLanguageTag(...)");
                    return localeForLanguageTag14;
                }
                Locale locale22222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222, "getDefault(...)");
                return locale22222222222222222;
            case 72592:
                if (upperCase.equals("ILS")) {
                    Locale localeForLanguageTag15 = Locale.forLanguageTag("he-IL");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag15, "forLanguageTag(...)");
                    return localeForLanguageTag15;
                }
                Locale locale222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222, "getDefault(...)");
                return locale222222222222222222;
            case 72653:
                if (upperCase.equals("INR")) {
                    Locale localeForLanguageTag16 = Locale.forLanguageTag("en-IN");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag16, "forLanguageTag(...)");
                    return localeForLanguageTag16;
                }
                Locale locale2222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222, "getDefault(...)");
                return locale2222222222222222222;
            case 73683:
                if (upperCase.equals("JPY")) {
                    Locale JAPAN = Locale.JAPAN;
                    Intrinsics.checkNotNullExpressionValue(JAPAN, "JAPAN");
                    return JAPAN;
                }
                Locale locale22222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222, "getDefault(...)");
                return locale22222222222222222222;
            case 74704:
                if (upperCase.equals("KRW")) {
                    Locale KOREA = Locale.KOREA;
                    Intrinsics.checkNotNullExpressionValue(KOREA, "KOREA");
                    return KOREA;
                }
                Locale locale222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222, "getDefault(...)");
                return locale222222222222222222222;
            case 76803:
                if (upperCase.equals("MXN")) {
                    Locale localeForLanguageTag17 = Locale.forLanguageTag("es-MX");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag17, "forLanguageTag(...)");
                    return localeForLanguageTag17;
                }
                Locale locale2222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222222, "getDefault(...)");
                return locale2222222222222222222222;
            case 76838:
                if (upperCase.equals("MYR")) {
                    Locale localeForLanguageTag18 = Locale.forLanguageTag("ms-MY");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag18, "forLanguageTag(...)");
                    return localeForLanguageTag18;
                }
                Locale locale22222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222222, "getDefault(...)");
                return locale22222222222222222222222;
            case 77482:
                break;
            case 77816:
                if (upperCase.equals("NZD")) {
                    Locale localeForLanguageTag19 = Locale.forLanguageTag("en-NZ");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag19, "forLanguageTag(...)");
                    return localeForLanguageTag19;
                }
                Locale locale222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222222, "getDefault(...)");
                return locale222222222222222222222222;
            case 79097:
                if (upperCase.equals("PEN")) {
                    Locale localeForLanguageTag20 = Locale.forLanguageTag("es-PE");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag20, "forLanguageTag(...)");
                    return localeForLanguageTag20;
                }
                Locale locale2222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222222222, "getDefault(...)");
                return locale2222222222222222222222222;
            case 79192:
                if (upperCase.equals("PHP")) {
                    Locale localeForLanguageTag21 = Locale.forLanguageTag("en-PH");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag21, "forLanguageTag(...)");
                    return localeForLanguageTag21;
                }
                Locale locale22222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222222222, "getDefault(...)");
                return locale22222222222222222222222222;
            case 79314:
                if (upperCase.equals("PLN")) {
                    Locale localeForLanguageTag22 = Locale.forLanguageTag("pl-PL");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag22, "forLanguageTag(...)");
                    return localeForLanguageTag22;
                }
                Locale locale222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222222222, "getDefault(...)");
                return locale222222222222222222222222222;
            case 81329:
                if (upperCase.equals("RON")) {
                    Locale localeForLanguageTag23 = Locale.forLanguageTag("ro-RO");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag23, "forLanguageTag(...)");
                    return localeForLanguageTag23;
                }
                Locale locale2222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222222222222, "getDefault(...)");
                return locale2222222222222222222222222222;
            case 81503:
                if (upperCase.equals("RUB")) {
                    Locale localeForLanguageTag24 = Locale.forLanguageTag("ru-RU");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag24, "forLanguageTag(...)");
                    return localeForLanguageTag24;
                }
                Locale locale22222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222222222222, "getDefault(...)");
                return locale22222222222222222222222222222;
            case 81860:
                if (upperCase.equals("SAR")) {
                    Locale localeForLanguageTag25 = Locale.forLanguageTag("ar-SA");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag25, "forLanguageTag(...)");
                    return localeForLanguageTag25;
                }
                Locale locale222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222222222222, "getDefault(...)");
                return locale222222222222222222222222222222;
            case 81977:
                break;
            case 82032:
                if (upperCase.equals("SGD")) {
                    Locale localeForLanguageTag26 = Locale.forLanguageTag("en-SG");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag26, "forLanguageTag(...)");
                    return localeForLanguageTag26;
                }
                Locale locale2222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222222222222222, "getDefault(...)");
                return locale2222222222222222222222222222222;
            case 83022:
                if (upperCase.equals("THB")) {
                    Locale localeForLanguageTag27 = Locale.forLanguageTag("th-TH");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag27, "forLanguageTag(...)");
                    return localeForLanguageTag27;
                }
                Locale locale22222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222222222222222, "getDefault(...)");
                return locale22222222222222222222222222222222;
            case 83355:
                if (upperCase.equals("TRY")) {
                    Locale localeForLanguageTag28 = Locale.forLanguageTag("tr-TR");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag28, "forLanguageTag(...)");
                    return localeForLanguageTag28;
                }
                Locale locale222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222222222222222, "getDefault(...)");
                return locale222222222222222222222222222222222;
            case 83489:
                if (upperCase.equals("TWD")) {
                    Locale localeForLanguageTag29 = Locale.forLanguageTag("zh-TW");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag29, "forLanguageTag(...)");
                    return localeForLanguageTag29;
                }
                Locale locale2222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222222222222222222, "getDefault(...)");
                return locale2222222222222222222222222222222222;
            case 84326:
                if (upperCase.equals("USD")) {
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    return US;
                }
                Locale locale22222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222222222222222222, "getDefault(...)");
                return locale22222222222222222222222222222222222;
            case 84529:
                if (upperCase.equals("UYU")) {
                    Locale localeForLanguageTag30 = Locale.forLanguageTag("es-UY");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag30, "forLanguageTag(...)");
                    return localeForLanguageTag30;
                }
                Locale locale222222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222222222222222222, "getDefault(...)");
                return locale222222222222222222222222222222222222;
            case 85132:
                if (upperCase.equals("VND")) {
                    Locale localeForLanguageTag31 = Locale.forLanguageTag("vi-VN");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag31, "forLanguageTag(...)");
                    return localeForLanguageTag31;
                }
                Locale locale2222222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2222222222222222222222222222222222222, "getDefault(...)");
                return locale2222222222222222222222222222222222222;
            case 88587:
                if (upperCase.equals("ZAR")) {
                    Locale localeForLanguageTag32 = Locale.forLanguageTag("en-ZA");
                    Intrinsics.checkNotNullExpressionValue(localeForLanguageTag32, "forLanguageTag(...)");
                    return localeForLanguageTag32;
                }
                Locale locale22222222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale22222222222222222222222222222222222222, "getDefault(...)");
                return locale22222222222222222222222222222222222222;
            default:
                Locale locale222222222222222222222222222222222222222 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale222222222222222222222222222222222222222, "getDefault(...)");
                return locale222222222222222222222222222222222222222;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0117 A[LOOP:2: B:59:0x0111->B:61:0x0117, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Integer> getTreacheryWinners(GameState gameState) {
        ArrayList arrayList;
        Iterator it;
        Iterator it2;
        Object next;
        ArrayList arrayList2 = new ArrayList();
        if (allPlayersHaveRole(gameState)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            int size = gameState.getPlayers().size();
            Player player = null;
            for (int i = 0; i < size; i++) {
                Iterator<T> it3 = gameState.getEvents().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    MTGameEvent mTGameEvent = (MTGameEvent) next;
                    if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == i) {
                        break;
                    }
                }
                MTGameEvent mTGameEvent2 = (MTGameEvent) next;
                if (mTGameEvent2 != null) {
                    int value = mTGameEvent2.getValue();
                    if (value == 0) {
                        player = gameState.getPlayers().get(i);
                    } else if (value == 1) {
                        arrayList3.add(gameState.getPlayers().get(i));
                    } else if (value == 2) {
                        arrayList4.add(gameState.getPlayers().get(i));
                    } else if (value == 3) {
                        arrayList5.add(gameState.getPlayers().get(i));
                    }
                }
            }
            Player player2 = player;
            if (player2 != null) {
                if (!player2.isKO()) {
                    ArrayList arrayList6 = arrayList4;
                    if ((arrayList6 instanceof Collection) && arrayList6.isEmpty()) {
                        arrayList = arrayList5;
                        if (arrayList instanceof Collection) {
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                            }
                            arrayList2.add(Integer.valueOf(player2.getUserId()));
                            it2 = arrayList3.iterator();
                            while (it2.hasNext()) {
                            }
                        }
                    } else {
                        Iterator it4 = arrayList6.iterator();
                        while (it4.hasNext()) {
                            if (!((Player) it4.next()).isKO()) {
                                break;
                            }
                        }
                        arrayList = arrayList5;
                        if ((arrayList instanceof Collection) || !arrayList.isEmpty()) {
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (!((Player) it.next()).isKO()) {
                                    if (!player2.isKO()) {
                                        ArrayList arrayList7 = arrayList4;
                                        if (!(arrayList7 instanceof Collection) || !arrayList7.isEmpty()) {
                                            Iterator it5 = arrayList7.iterator();
                                            while (it5.hasNext()) {
                                                if (!((Player) it5.next()).isKO()) {
                                                    Iterator it6 = arrayList7.iterator();
                                                    while (it6.hasNext()) {
                                                        arrayList2.add(Integer.valueOf(((Player) it6.next()).getUserId()));
                                                    }
                                                }
                                            }
                                            if (player2.isKO()) {
                                                ArrayList arrayList8 = arrayList4;
                                                if (!(arrayList8 instanceof Collection) || !arrayList8.isEmpty()) {
                                                    Iterator it7 = arrayList8.iterator();
                                                    while (it7.hasNext()) {
                                                        if (!((Player) it7.next()).isKO()) {
                                                            return arrayList2;
                                                        }
                                                    }
                                                }
                                                ArrayList arrayList9 = arrayList3;
                                                if (!(arrayList9 instanceof Collection) || !arrayList9.isEmpty()) {
                                                    Iterator it8 = arrayList9.iterator();
                                                    while (it8.hasNext()) {
                                                        if (!((Player) it8.next()).isKO()) {
                                                            return arrayList2;
                                                        }
                                                    }
                                                }
                                                ArrayList arrayList10 = new ArrayList();
                                                for (Object obj : arrayList5) {
                                                    if (!((Player) obj).isKO()) {
                                                        arrayList10.add(obj);
                                                    }
                                                }
                                                ArrayList arrayList11 = arrayList10;
                                                if (arrayList11.size() == 1) {
                                                    arrayList2.add(Integer.valueOf(((Player) arrayList11.get(0)).getUserId()));
                                                }
                                            }
                                        } else if (player2.isKO()) {
                                        }
                                    }
                                }
                            }
                        }
                        arrayList2.add(Integer.valueOf(player2.getUserId()));
                        it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(Integer.valueOf(((Player) it2.next()).getUserId()));
                        }
                    }
                } else if (!player2.isKO()) {
                }
            }
        }
        return arrayList2;
    }

    private final boolean isGameFinished(GameState gameState) {
        int i;
        int i2;
        if (gameState.getSubformatId() == 3) {
            if (allPlayersHaveRole(gameState)) {
                return !getTreacheryWinners(gameState).isEmpty();
            }
            return false;
        }
        if (gameState.getSubformatId() == 5 && gameState.getPlayers().size() == 4) {
            if (gameState.getPlayers().get(0).isKO() && gameState.getPlayers().get(3).isKO()) {
                return true;
            }
            if (gameState.getPlayers().get(1).isKO() && gameState.getPlayers().get(2).isKO()) {
                return true;
            }
        }
        if (gameState.getSubformatId() == 6 && gameState.getPlayers().size() == 6) {
            if (gameState.getPlayers().get(0).isKO() && gameState.getPlayers().get(1).isKO() && gameState.getPlayers().get(5).isKO()) {
                return true;
            }
            if (gameState.getPlayers().get(2).isKO() && gameState.getPlayers().get(3).isKO() && gameState.getPlayers().get(4).isKO()) {
                return true;
            }
        }
        List<Player> players = gameState.getPlayers();
        if ((players instanceof Collection) && players.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = players.iterator();
            i = 0;
            while (it.hasNext()) {
                if ((((Player) it.next()).getResultid() == 3) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i >= 2) {
            return true;
        }
        List<Player> players2 = gameState.getPlayers();
        if ((players2 instanceof Collection) && players2.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            for (Player player : players2) {
                if (((player.isKO() || player.getResultid() == 2) ? false : true) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return gameState.getPlayers().size() >= 2 && i2 == 1;
    }

    public final int adjustBrightness(int color, float brightness) {
        float[] fArr = {0.0f, 0.0f, brightness};
        Color.colorToHSV(color, fArr);
        return Color.HSVToColor(fArr);
    }

    public final int adjustOpacity(int color) {
        return (((color >> 16) & 255) << 16) | Integer.MIN_VALUE | (((color >> 8) & 255) << 8) | (color & 255);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean allPlayersHaveRole(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        int size = gameState.getPlayers().size();
        int i = 0;
        while (i < size) {
            List<MTGameEvent> events = gameState.getEvents();
            if (!(events instanceof Collection) || !events.isEmpty()) {
                for (MTGameEvent mTGameEvent : events) {
                    if (!Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) || mTGameEvent.getPlayerid() != i) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int colorForCardCondition(Context context, String condition) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(condition, "condition");
        int iHashCode = condition.hashCode();
        if (iHashCode != 71) {
            if (iHashCode != 77) {
                if (iHashCode != 80) {
                    if (iHashCode != 2227) {
                        if (iHashCode != 2436) {
                            if (iHashCode != 2495) {
                                if (iHashCode == 2556 && condition.equals(CONDITION_PLAYED)) {
                                    return ContextCompat.getColor(context, R.color.condition_played);
                                }
                            } else if (condition.equals(CONDITION_NEAR_MINT)) {
                                return ContextCompat.getColor(context, R.color.condition_near_mint);
                            }
                        } else if (condition.equals(CONDITION_LIGHT_PLAYED)) {
                            return ContextCompat.getColor(context, R.color.condition_light_played);
                        }
                    } else if (condition.equals(CONDITION_EXCELENT)) {
                        return ContextCompat.getColor(context, R.color.condition_excellent);
                    }
                } else if (condition.equals(CONDITION_POOR)) {
                    return ContextCompat.getColor(context, R.color.condition_poor);
                }
            } else if (condition.equals("M")) {
                return ContextCompat.getColor(context, R.color.condition_mint);
            }
        } else if (condition.equals(CONDITION_GOOD)) {
            return ContextCompat.getColor(context, R.color.condition_good);
        }
        return ContextCompat.getColor(context, R.color.condition_mint);
    }

    public final String conditionCodeForComboBracket(String bracketTag) {
        Intrinsics.checkNotNullParameter(bracketTag, "bracketTag");
        int iHashCode = bracketTag.hashCode();
        if (iHashCode == 67) {
            return !bracketTag.equals("C") ? "M" : CONDITION_NEAR_MINT;
        }
        if (iHashCode != 69) {
            return iHashCode != 79 ? iHashCode != 80 ? iHashCode != 82 ? (iHashCode == 83 && bracketTag.equals(ExifInterface.LATITUDE_SOUTH)) ? CONDITION_LIGHT_PLAYED : "M" : !bracketTag.equals("R") ? "M" : CONDITION_PLAYED : !bracketTag.equals(CONDITION_POOR) ? "M" : CONDITION_GOOD : !bracketTag.equals("O") ? "M" : CONDITION_EXCELENT;
        }
        bracketTag.equals(ExifInterface.LONGITUDE_EAST);
        return "M";
    }

    public final MTFullCard convertScryFallCard(Card card) {
        String eur;
        String usd;
        String eur_foil;
        String str;
        CardFace cardFace;
        ImageUris image_uris;
        String str2;
        CardFace cardFace2;
        ImageUris image_uris2;
        String png;
        String usd_foil;
        Intrinsics.checkNotNullParameter(card, "card");
        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard.setScryfallid(card.getId());
        mTFullCard.setOracleid(card.getOracle_id());
        String lowerCase = card.getSet().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        mTFullCard.setSet_code(lowerCase);
        mTFullCard.setCollector_number(card.getCollector_number());
        String lang = card.getLang();
        if (lang == null) {
            lang = "en";
        }
        mTFullCard.setLang(lang);
        mTFullCard.setLayout(card.getLayout());
        mTFullCard.setFinish(null);
        mTFullCard.setFinishes(card.getFinishes());
        mTFullCard.setName(card.getName());
        Prices prices = card.getPrices();
        String str3 = "0.0";
        if (prices == null || (eur = prices.getEur()) == null) {
            eur = "0.0";
        }
        mTFullCard.setCurrent_value_eur(Double.valueOf(Double.parseDouble(eur)));
        Prices prices2 = card.getPrices();
        if (prices2 == null || (usd = prices2.getUsd()) == null) {
            usd = "0.0";
        }
        mTFullCard.setCurrent_value_usd(Double.valueOf(Double.parseDouble(usd)));
        Prices prices3 = card.getPrices();
        if (prices3 == null || (eur_foil = prices3.getEur_foil()) == null) {
            eur_foil = "0.0";
        }
        mTFullCard.setCurrent_value_eur_foil(Double.valueOf(Double.parseDouble(eur_foil)));
        Prices prices4 = card.getPrices();
        if (prices4 != null && (usd_foil = prices4.getUsd_foil()) != null) {
            str3 = usd_foil;
        }
        mTFullCard.setCurrent_value_usd_foil(Double.valueOf(Double.parseDouble(str3)));
        ImageUris image_uris3 = card.getImage_uris();
        String png2 = "";
        if (image_uris3 == null || (normal = image_uris3.getNormal()) == null) {
            List<CardFace> card_faces = card.getCard_faces();
            if (card_faces == null || (cardFace = (CardFace) CollectionsKt.firstOrNull((List) card_faces)) == null || (image_uris = cardFace.getImage_uris()) == null) {
                str = "";
            } else {
                String normal = image_uris.getNormal();
                str = normal;
            }
        } else {
            str = normal;
        }
        ImageUris image_uris4 = card.getImage_uris();
        if (image_uris4 == null || (png = image_uris4.getPng()) == null) {
            List<CardFace> card_faces2 = card.getCard_faces();
            if (card_faces2 != null && (cardFace2 = (CardFace) CollectionsKt.firstOrNull((List) card_faces2)) != null && (image_uris2 = cardFace2.getImage_uris()) != null) {
                png2 = image_uris2.getPng();
            }
            str2 = png2;
        } else {
            str2 = png;
        }
        mTFullCard.setImages(CollectionsKt.listOf(new MTImageURIs(null, str, null, str2, null, null, null)));
        mTFullCard.setRarity(card.getRarity());
        mTFullCard.setType_line(card.getType_line());
        mTFullCard.setOracle_text(card.getOracle_text());
        mTFullCard.setMana_cost(card.getMana_cost());
        return mTFullCard;
    }

    public final MTCreateGame createMTGameForUpload(GameState gameState, int currentUserId) {
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        MTCreateGame mTCreateGame = new MTCreateGame(0, null, null, null, null, null, null, null, null, null, null, 2047, null);
        List<Integer> gameWinners = getGameWinners(gameState);
        if (gameState.getPlaygroupId() != -1) {
            mTCreateGame.setPlaygroupid(Integer.valueOf(gameState.getPlaygroupId()));
        }
        mTCreateGame.setFormatid(gameState.getFormatId());
        int subformatId = gameState.getSubformatId();
        if (subformatId != -1) {
            mTCreateGame.setSubformatid(Integer.valueOf(subformatId));
        }
        Object next3 = null;
        if (currentUserId == -1) {
            mTCreateGame.setCreated_by(null);
        } else {
            mTCreateGame.setCreated_by(Integer.valueOf(currentUserId));
        }
        int i = 0;
        for (Player player : gameState.getPlayers()) {
            int i2 = i + 1;
            MTCreateGamePlayer mTCreateGamePlayer = new MTCreateGamePlayer(null, null, 0, 0, null, null, null, 127, null);
            int resultid = gameWinners.contains(Integer.valueOf(player.getUserId())) ? 1 : (player.getResultid() == 3 || player.getResultid() == 2) ? player.getResultid() : 0;
            mTCreateGamePlayer.setUserid(player.getUserId() > 0 ? Integer.valueOf(player.getUserId()) : null);
            mTCreateGamePlayer.setDeckid(player.getDeckId() > 0 ? Integer.valueOf(player.getDeckId()) : null);
            mTCreateGamePlayer.setPosition(i);
            mTCreateGamePlayer.setResultid(resultid);
            mTCreateGamePlayer.setName(player.getName());
            mTCreateGamePlayer.setLifetotal(Integer.valueOf(player.getStartingLifeTotal()));
            if (gameState.getSubformatId() == 3) {
                Iterator<T> it = gameState.getEvents().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    MTGameEvent mTGameEvent = (MTGameEvent) next2;
                    if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == i) {
                        break;
                    }
                }
                MTGameEvent mTGameEvent2 = (MTGameEvent) next2;
                if (mTGameEvent2 != null) {
                    int value = mTGameEvent2.getValue();
                    if (value == 0 || value == 1) {
                        mTCreateGamePlayer.setTeamid(1);
                    } else if (value == 2) {
                        mTCreateGamePlayer.setTeamid(2);
                    } else if (value != 3) {
                        mTCreateGamePlayer.setTeamid(null);
                    } else {
                        mTCreateGamePlayer.setTeamid(3);
                    }
                }
            }
            if (gameState.getSubformatId() == 5) {
                if (i == 0 || i == 3) {
                    mTCreateGamePlayer.setTeamid(1);
                }
                if (i == 1 || i == 2) {
                    mTCreateGamePlayer.setTeamid(2);
                }
            }
            if (gameState.getSubformatId() == 6) {
                if (i == 0 || i == 1 || i == 5) {
                    mTCreateGamePlayer.setTeamid(1);
                }
                if (i == 2 || i == 3 || i == 4) {
                    mTCreateGamePlayer.setTeamid(2);
                }
            }
            mTCreateGame.getPlayers().add(mTCreateGamePlayer);
            i = i2;
        }
        mTCreateGame.setEvents(gameState.getEvents());
        String currentTimestamp = INSTANCE.getInstance().getCurrentTimestamp();
        if (gameState.getStartedAt().length() == 0) {
            gameState.setStartedAt(currentTimestamp);
            Iterator<T> it2 = gameState.getEvents().iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    String date = ((MTGameEvent) next).getDate();
                    do {
                        Object next4 = it2.next();
                        String date2 = ((MTGameEvent) next4).getDate();
                        if (date.compareTo(date2) > 0) {
                            next = next4;
                            date = date2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            MTGameEvent mTGameEvent3 = (MTGameEvent) next;
            if (mTGameEvent3 != null) {
                gameState.setStartedAt(mTGameEvent3.getDate());
            }
        }
        if (gameState.getEndedAt().length() == 0) {
            gameState.setEndedAt(gameState.getStartedAt());
            Iterator<T> it3 = gameState.getEvents().iterator();
            if (it3.hasNext()) {
                next3 = it3.next();
                if (it3.hasNext()) {
                    String date3 = ((MTGameEvent) next3).getDate();
                    do {
                        Object next5 = it3.next();
                        String date4 = ((MTGameEvent) next5).getDate();
                        if (date3.compareTo(date4) < 0) {
                            next3 = next5;
                            date3 = date4;
                        }
                    } while (it3.hasNext());
                }
            }
            MTGameEvent mTGameEvent4 = (MTGameEvent) next3;
            if (mTGameEvent4 != null) {
                gameState.setEndedAt(mTGameEvent4.getDate());
            }
        }
        int pauseTime = gameState.getPauseTime();
        if (gameState.getTimerPaused()) {
            pauseTime += (int) ((System.currentTimeMillis() - gameState.getTimerPausedAt()) / 1000);
        }
        mTCreateGame.setPausetime(Integer.valueOf(pauseTime));
        mTCreateGame.setStarted_at(gameState.getStartedAt());
        mTCreateGame.setEnded_at(gameState.getEndedAt());
        return mTCreateGame;
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public final int ensurePlanarDeck(Context context, GameState gameState) {
        List listSortedWith;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        int planechaseSeed = gameState.getPlanechaseSeed();
        int i = 0;
        if (planechaseSeed == 0) {
            planechaseSeed = Random.INSTANCE.nextInt(0, 1000000);
        }
        if (this.planarDeck.isEmpty()) {
            List<CardRecord> allPlanes = MTGDBHelper.INSTANCE.getInstance(context).getAllPlanes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allPlanes, 10));
            Iterator<T> it = allPlanes.iterator();
            while (it.hasNext()) {
                arrayList.add(((CardRecord) it.next()).getSet());
            }
            List listDistinct = CollectionsKt.distinct(arrayList);
            SharedPreferences sharedPreferences = context.getSharedPreferences("planechase_settings", 0);
            int size = listDistinct.size();
            boolean[] zArr = new boolean[size];
            for (int i2 = 0; i2 < size; i2++) {
                zArr[i2] = sharedPreferences.getBoolean("set_" + listDistinct.get(i2), true);
            }
            CollectionsKt.emptyList();
            while (true) {
                if (i >= size) {
                    listSortedWith = CollectionsKt.sortedWith(allPlanes, new Comparator() { // from class: com.studiolaganne.lengendarylens.GameUtils$ensurePlanarDeck$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((CardRecord) t).getScryfall_id(), ((CardRecord) t2).getScryfall_id());
                        }
                    });
                    break;
                }
                if (zArr[i]) {
                    i++;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : allPlanes) {
                        int iIndexOf = listDistinct.indexOf(((CardRecord) obj).getSet());
                        if (iIndexOf != -1 && zArr[iIndexOf]) {
                            arrayList2.add(obj);
                        }
                    }
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.GameUtils$ensurePlanarDeck$$inlined$sortedBy$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((CardRecord) t).getScryfall_id(), ((CardRecord) t2).getScryfall_id());
                        }
                    });
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listSortedWith) {
                if (hashSet.add(((CardRecord) obj2).getOracle_id())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                arrayList5.add(((CardRecord) it2.next()).getScryfall_id());
            }
            this.planarDeck = new DeterministicShuffler(planechaseSeed).shuffle(arrayList5);
        }
        return planechaseSeed;
    }

    public final int ensureSchemeDeck(Context context, GameState gameState) {
        List listSortedWith;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        int archenemySeed = gameState.getArchenemySeed();
        int i = 0;
        if (archenemySeed == 0) {
            archenemySeed = Random.INSTANCE.nextInt(0, 1000000);
        }
        if (this.schemeDeck.isEmpty()) {
            List<CardRecord> allSchemes = MTGDBHelper.INSTANCE.getInstance(context).getAllSchemes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allSchemes, 10));
            Iterator<T> it = allSchemes.iterator();
            while (it.hasNext()) {
                arrayList.add(((CardRecord) it.next()).getSet());
            }
            List listDistinct = CollectionsKt.distinct(arrayList);
            SharedPreferences sharedPreferences = context.getSharedPreferences("archenemy_settings", 0);
            int size = listDistinct.size();
            boolean[] zArr = new boolean[size];
            for (int i2 = 0; i2 < size; i2++) {
                zArr[i2] = sharedPreferences.getBoolean("set_" + listDistinct.get(i2), true);
            }
            CollectionsKt.emptyList();
            while (true) {
                if (i >= size) {
                    listSortedWith = CollectionsKt.sortedWith(allSchemes, new Comparator() { // from class: com.studiolaganne.lengendarylens.GameUtils$ensureSchemeDeck$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((CardRecord) t).getScryfall_id(), ((CardRecord) t2).getScryfall_id());
                        }
                    });
                    break;
                }
                if (zArr[i]) {
                    i++;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : allSchemes) {
                        int iIndexOf = listDistinct.indexOf(((CardRecord) obj).getSet());
                        if (iIndexOf != -1 && zArr[iIndexOf]) {
                            arrayList2.add(obj);
                        }
                    }
                    listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.GameUtils$ensureSchemeDeck$$inlined$sortedBy$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((CardRecord) t).getScryfall_id(), ((CardRecord) t2).getScryfall_id());
                        }
                    });
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listSortedWith) {
                if (hashSet.add(((CardRecord) obj2).getOracle_id())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                arrayList5.add(((CardRecord) it2.next()).getScryfall_id());
            }
            this.schemeDeck = new DeterministicShuffler(archenemySeed).shuffle(arrayList5);
        }
        return archenemySeed;
    }

    public final String formatContainerTotal(Map<String, MTCardsValue> values, String currencyCode) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        MTCardsValue containerValue = getContainerValue(values, currencyCode);
        return containerValue != null ? formatPrice(containerValue.getTotal_value(), currencyCode) : "--";
    }

    public final String formatDelta(MTPriceDelta delta, String currencyCode) {
        Intrinsics.checkNotNullParameter(delta, "delta");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        String price = formatPrice(Math.abs(delta.getAmount()), currencyCode);
        String str = delta.getAmount() > AudioStats.AUDIO_AMPLITUDE_NONE ? "+" : delta.getAmount() < AudioStats.AUDIO_AMPLITUDE_NONE ? "-" : "";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(Math.abs(delta.getPercentage()))}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str + price + " (" + str + str2 + "%)";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
    
        if (r3.equals("RON") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (r3.equals("PLN") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        if (r3.equals("NOK") != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        if (r3.equals("HUF") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        if (r3.equals("HRK") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        if (r3.equals("EUR") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        if (r3.equals("DKK") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
    
        if (r3.equals("CZK") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        if (r3.equals("CHF") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a1, code lost:
    
        if (r3.equals("BGN") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r5 = r0.getSymbol();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
    
        return r2 + " " + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
    
        if (r3.equals("TRY") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0044, code lost:
    
        if (r3.equals("SEK") == false) goto L45;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String formatPrice(double price, String currencyCode) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        CurrencyInfo currencyInfoFromCode = CurrencyInfo.INSTANCE.fromCode(currencyCode);
        NumberFormat numberInstance = NumberFormat.getNumberInstance(getLocaleForCurrency(currencyCode));
        numberInstance.setMinimumFractionDigits(2);
        numberInstance.setMaximumFractionDigits(2);
        String str = numberInstance.format(price);
        String upperCase = currencyCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case 65705:
                break;
            case 66689:
                break;
            case 67252:
                break;
            case 67748:
                break;
            case 69026:
                break;
            case 71809:
                break;
            case 71897:
                break;
            case 77482:
                break;
            case 79314:
                break;
            case 81329:
                break;
            case 81977:
                break;
            case 83355:
                break;
            default:
                return (currencyInfoFromCode != null ? currencyInfoFromCode.getSymbol() : null) + str;
        }
    }

    public final String formatPriceAmountOnly(double price, String currencyCode) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        NumberFormat numberInstance = NumberFormat.getNumberInstance(getLocaleForCurrency(currencyCode));
        numberInstance.setMinimumFractionDigits(2);
        numberInstance.setMaximumFractionDigits(2);
        String str = numberInstance.format(price);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final void getCard(Context context, String scryfallId, int face, Function1<? super CardRecord, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(context);
        ArrayList arrayList = new ArrayList();
        for (String str : new PreferencesManager(context).getSupportedLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized companion2 = MTGDBHelperLocalized.INSTANCE.getInstance(context, str);
                if (companion2.isValid()) {
                    arrayList.add(companion2);
                }
            }
        }
        CardRecord cardByScryFallId = companion.getCardByScryFallId(scryfallId, face);
        if (cardByScryFallId == null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext() && (cardByScryFallId = ((MTGDBHelperLocalized) it.next()).getCardByScryFallId(scryfallId, face)) == null) {
            }
        }
        if (cardByScryFallId != null) {
            callback.invoke(cardByScryFallId);
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(MTApiKt.getMtApi().getCardByScryfallId(scryfallId), scryfallId, face, callback, null), 3, null);
        }
    }

    public final CardRecord getCardLocal(Context context, String scryfallId, int face) {
        String strJoinToString$default;
        String strJoinToString$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(context);
        ArrayList arrayList = new ArrayList();
        PreferencesManager preferencesManager = new PreferencesManager(context);
        for (String str : preferencesManager.getSupportedLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized companion2 = MTGDBHelperLocalized.INSTANCE.getInstance(context, str);
                if (companion2.isValid()) {
                    arrayList.add(companion2);
                }
            }
        }
        CardRecord cardByScryFallId = companion.getCardByScryFallId(scryfallId, face);
        if (cardByScryFallId == null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext() && (cardByScryFallId = ((MTGDBHelperLocalized) it.next()).getCardByScryFallId(scryfallId, face)) == null) {
            }
        }
        if (cardByScryFallId != null) {
            return cardByScryFallId;
        }
        String string = preferencesManager.getString("mt_cached_scryfall_id_" + scryfallId, "");
        if (string.length() <= 0) {
            return null;
        }
        Card card = (Card) new Gson().fromJson(string, Card.class);
        String id = card.getId();
        String oracle_id = card.getOracle_id();
        String collector_number = card.getCollector_number();
        if (collector_number == null) {
            collector_number = "";
        }
        String name = card.getName();
        String set = card.getSet();
        String lang = card.getLang();
        String str2 = lang == null ? "en" : lang;
        String type_line = card.getType_line();
        String oracle_text = card.getOracle_text();
        String str3 = oracle_text == null ? "" : oracle_text;
        String mana_cost = card.getMana_cost();
        String str4 = mana_cost == null ? "" : mana_cost;
        List<String> color_identity = card.getColor_identity();
        String str5 = (color_identity == null || (strJoinToString$default2 = CollectionsKt.joinToString$default(color_identity, "|", null, null, 0, null, null, 62, null)) == null) ? "" : strJoinToString$default2;
        List<String> keywords = card.getKeywords();
        return new CardRecord(0, oracle_id, id, collector_number, 0, face, name, null, set, null, null, null, str2, type_line, str3, str4, null, null, str5, (keywords == null || (strJoinToString$default = CollectionsKt.joinToString$default(keywords, "|", null, null, 0, null, null, 62, null)) == null) ? "" : strJoinToString$default, null, 1248913, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099 A[PHI: r7
      0x0099: PHI (r7v19 com.studiolaganne.lengendarylens.MTMarketplaceFinishPrices) = 
      (r7v6 com.studiolaganne.lengendarylens.MTMarketplaceFinishPrices)
      (r7v10 com.studiolaganne.lengendarylens.MTMarketplaceFinishPrices)
      (r7v14 com.studiolaganne.lengendarylens.MTMarketplaceFinishPrices)
      (r7v23 com.studiolaganne.lengendarylens.MTMarketplaceFinishPrices)
     binds: [B:41:0x0096, B:31:0x0076, B:21:0x0056, B:11:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f2 A[PHI: r5
      0x00f2: PHI (r5v15 java.lang.String) = (r5v2 java.lang.String), (r5v20 java.lang.String) binds: [B:70:0x00ef, B:68:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double getCardPrice(MTFullCard card, String marketplace) {
        MTMarketplaceFinishPrices cardkingdom;
        String finish;
        String str;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        String lowerCase = marketplace.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        MTMarketplaceFinishPrices mythictools = null;
        switch (lowerCase.hashCode()) {
            case -1806040773:
                if (!lowerCase.equals("cardkingdom")) {
                    MTCardMarketplaceValues values = card.getValues();
                    if (values != null) {
                        mythictools = values.getMythictools();
                    }
                } else {
                    MTCardMarketplaceValues values2 = card.getValues();
                    if (values2 == null || (cardkingdom = values2.getCardkingdom()) == null) {
                        MTCardMarketplaceValues values3 = card.getValues();
                        if (values3 != null) {
                            mythictools = values3.getMythictools();
                        }
                    } else {
                        mythictools = cardkingdom;
                    }
                }
                break;
            case 1377207116:
                if (lowerCase.equals("cardmarket")) {
                    MTCardMarketplaceValues values4 = card.getValues();
                    if (values4 == null || (cardkingdom = values4.getCardmarket()) == null) {
                        MTCardMarketplaceValues values5 = card.getValues();
                        if (values5 != null) {
                            mythictools = values5.getMythictools();
                        }
                        break;
                    }
                }
                break;
            case 1562531549:
                if (lowerCase.equals("cardsphere")) {
                    MTCardMarketplaceValues values6 = card.getValues();
                    if (values6 == null || (cardkingdom = values6.getCardsphere()) == null) {
                        MTCardMarketplaceValues values7 = card.getValues();
                        if (values7 != null) {
                            mythictools = values7.getMythictools();
                        }
                        break;
                    }
                }
                break;
            case 1761024185:
                if (lowerCase.equals("tcgplayer")) {
                    MTCardMarketplaceValues values8 = card.getValues();
                    if (values8 == null || (cardkingdom = values8.getTcgplayer()) == null) {
                        MTCardMarketplaceValues values9 = card.getValues();
                        if (values9 != null) {
                            mythictools = values9.getMythictools();
                        }
                        break;
                    }
                }
                break;
        }
        if (mythictools == null) {
            return getCurrentPrice(card, "USD");
        }
        List<String> finishes = card.getFinishes();
        if (finishes == null) {
            finish = card.getFinish();
            str = finish != null ? finish : "nonfoil";
        } else {
            if (finishes.size() == 1 && finishes.contains("etched")) {
                finish = "etched";
            } else if (finishes.size() == 1 && finishes.contains("foil")) {
                finish = "foil";
            } else {
                finish = card.getFinish();
                if (finish == null) {
                    finish = "nonfoil";
                }
            }
            if (finish == null) {
            }
        }
        if (Intrinsics.areEqual(str, "etched")) {
            Double etched = mythictools.getEtched();
            if (etched != null) {
                return etched.doubleValue();
            }
            Double nonfoil = mythictools.getNonfoil();
            return nonfoil != null ? nonfoil.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (!Intrinsics.areEqual(str, "foil")) {
            Double nonfoil2 = mythictools.getNonfoil();
            return nonfoil2 != null ? nonfoil2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        Double foil = mythictools.getFoil();
        if (foil != null) {
            return foil.doubleValue();
        }
        Double nonfoil3 = mythictools.getNonfoil();
        return nonfoil3 != null ? nonfoil3.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final MTCardsValue getContainerValue(Map<String, MTCardsValue> values, String currencyCode) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        if (values == null) {
            return null;
        }
        String upperCase = currencyCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return values.get(upperCase);
    }

    public final List<CounterDefinition> getCounters(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.commander_tax);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.poison_counters_short);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(R.string.energy_counters);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = context.getString(R.string.experience_counters);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = context.getString(R.string.radiation_counters);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = context.getString(R.string.storm_count);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        return CollectionsKt.listOf((Object[]) new CounterDefinition[]{new CounterDefinition(string, CounterType.Tax), new CounterDefinition(string2, CounterType.Poison), new CounterDefinition(string3, CounterType.Energy), new CounterDefinition(string4, CounterType.Experience), new CounterDefinition(string5, CounterType.Radiation), new CounterDefinition(string6, CounterType.Storm)});
    }

    @Deprecated(message = "Use getCardPrice() instead", replaceWith = @ReplaceWith(expression = "getCardPrice(card, marketplace)", imports = {}))
    public final double getCurrentPrice(MTFullCard card, String currencyCode) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        String upperCase = currencyCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (Intrinsics.areEqual(upperCase, "EUR")) {
            String finish = card.getFinish();
            if (finish != null) {
                if (Intrinsics.areEqual(finish, "etched")) {
                    Double current_value_eur_etched = card.getCurrent_value_eur_etched();
                    return current_value_eur_etched != null ? current_value_eur_etched.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                if (Intrinsics.areEqual(finish, "foil")) {
                    Double current_value_eur_foil = card.getCurrent_value_eur_foil();
                    return current_value_eur_foil != null ? current_value_eur_foil.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                Double current_value_eur = card.getCurrent_value_eur();
                return current_value_eur != null ? current_value_eur.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            List<String> finishes = card.getFinishes();
            if (finishes != null) {
                if (finishes.size() == 1 && Intrinsics.areEqual(finishes.get(0), "etched")) {
                    Double current_value_eur_etched2 = card.getCurrent_value_eur_etched();
                    return current_value_eur_etched2 != null ? current_value_eur_etched2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                if (finishes.size() == 1 && finishes.contains("foil")) {
                    Double current_value_eur_foil2 = card.getCurrent_value_eur_foil();
                    return current_value_eur_foil2 != null ? current_value_eur_foil2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                Double current_value_eur2 = card.getCurrent_value_eur();
                return current_value_eur2 != null ? current_value_eur2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
            }
        } else {
            if (!Intrinsics.areEqual(upperCase, "USD")) {
                return getCurrentPrice(card, "USD");
            }
            String finish2 = card.getFinish();
            if (finish2 != null) {
                if (Intrinsics.areEqual(finish2, "etched")) {
                    Double current_value_usd_etched = card.getCurrent_value_usd_etched();
                    return current_value_usd_etched != null ? current_value_usd_etched.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                if (Intrinsics.areEqual(finish2, "foil")) {
                    Double current_value_usd_foil = card.getCurrent_value_usd_foil();
                    return current_value_usd_foil != null ? current_value_usd_foil.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                Double current_value_usd = card.getCurrent_value_usd();
                return current_value_usd != null ? current_value_usd.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            List<String> finishes2 = card.getFinishes();
            if (finishes2 != null) {
                if (finishes2.size() == 1 && Intrinsics.areEqual(finishes2.get(0), "etched")) {
                    Double current_value_usd_etched2 = card.getCurrent_value_usd_etched();
                    return current_value_usd_etched2 != null ? current_value_usd_etched2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                if (finishes2.size() == 1 && finishes2.contains("foil")) {
                    Double current_value_usd_foil2 = card.getCurrent_value_usd_foil();
                    return current_value_usd_foil2 != null ? current_value_usd_foil2.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                Double current_value_usd2 = card.getCurrent_value_usd();
                if (current_value_usd2 != null) {
                    return current_value_usd2.doubleValue();
                }
            }
        }
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final String getCurrentTimestamp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastTimestamp;
        if (jCurrentTimeMillis <= j) {
            jCurrentTimeMillis = 1 + j;
        }
        this.lastTimestamp = jCurrentTimeMillis;
        String str = Instant.ofEpochMilli(jCurrentTimeMillis).atZone(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final List<String> getDecorsUsed() {
        return this.decorsUsed;
    }

    public final List<Integer> getDefaultColors() {
        return this.defaultColors;
    }

    public final String getFirstPrintScryfallId(Context context, MTGCardRecord card) {
        String firstPrintScryfallId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        if (Intrinsics.areEqual(card.getLang(), "en")) {
            String firstPrintScryfallId2 = MTGDBHelper.INSTANCE.getInstance(context).getFirstPrintScryfallId(card.getOracle_id(), card.getFace());
            if (firstPrintScryfallId2 != null) {
                return firstPrintScryfallId2;
            }
        } else {
            MTGDBHelperLocalized companion = MTGDBHelperLocalized.INSTANCE.getInstance(context, card.getLang());
            if (companion.isValid() && (firstPrintScryfallId = companion.getFirstPrintScryfallId(card.getOracle_id(), card.getFace())) != null) {
                return firstPrintScryfallId;
            }
        }
        String string = new PreferencesManager(context).getString("mt_cached_oracle_id_" + card.getOracle_id(), "");
        if (string.length() > 0) {
            return ((Card) new Gson().fromJson(string, Card.class)).getId();
        }
        return null;
    }

    public final List<MTFormat> getFormats() {
        return this.formats;
    }

    public final List<MTUser> getGameParticipantUsers() {
        return this.gameParticipantUsers;
    }

    public final List<Integer> getGameWinners(GameState gameState) {
        int i;
        Object next;
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        if (!isGameFinished(gameState)) {
            return CollectionsKt.emptyList();
        }
        List<Player> players = gameState.getPlayers();
        if ((players instanceof Collection) && players.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = players.iterator();
            i = 0;
            while (it.hasNext()) {
                if ((((Player) it.next()).getResultid() == 3) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i >= 2) {
            return CollectionsKt.emptyList();
        }
        if (gameState.getSubformatId() == 3) {
            return getTreacheryWinners(gameState);
        }
        if (gameState.getSubformatId() == 5 && gameState.getPlayers().size() == 4) {
            if (gameState.getPlayers().get(0).isKO() && gameState.getPlayers().get(3).isKO()) {
                return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(gameState.getPlayers().get(1).getUserId()), Integer.valueOf(gameState.getPlayers().get(2).getUserId())});
            }
            if (gameState.getPlayers().get(1).isKO() && gameState.getPlayers().get(2).isKO()) {
                return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(gameState.getPlayers().get(0).getUserId()), Integer.valueOf(gameState.getPlayers().get(3).getUserId())});
            }
        }
        if (gameState.getSubformatId() == 6 && gameState.getPlayers().size() == 6) {
            if (gameState.getPlayers().get(0).isKO() && gameState.getPlayers().get(1).isKO() && gameState.getPlayers().get(5).isKO()) {
                return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(gameState.getPlayers().get(2).getUserId()), Integer.valueOf(gameState.getPlayers().get(3).getUserId()), Integer.valueOf(gameState.getPlayers().get(4).getUserId())});
            }
            if (gameState.getPlayers().get(2).isKO() && gameState.getPlayers().get(3).isKO() && gameState.getPlayers().get(4).isKO()) {
                return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(gameState.getPlayers().get(0).getUserId()), Integer.valueOf(gameState.getPlayers().get(1).getUserId()), Integer.valueOf(gameState.getPlayers().get(5).getUserId())});
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = gameState.getPlayers().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            Player player = (Player) next;
            if ((player.isKO() || player.getResultid() == 2) ? false : true) {
                break;
            }
        }
        Player player2 = (Player) next;
        if (player2 != null) {
            arrayList.add(player2);
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Integer.valueOf(((Player) it3.next()).getUserId()));
        }
        return arrayList3;
    }

    public final boolean getInitiativeDragInProgress() {
        return this.initiativeDragInProgress;
    }

    public final List<String> getKosUsed() {
        return this.kosUsed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<LifeHistoryEntry> getLifeHistoryEntries(GameState gameState, int forPlayer) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        if (!gameState.getPlayers().isEmpty() && !gameState.getEvents().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int startingLifeTotal = gameState.getPlayers().get(forPlayer).getStartingLifeTotal();
            for (MTGameEvent mTGameEvent : gameState.getEvents()) {
                if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.LifeOffset.getValue()) && mTGameEvent.getPlayerid() == forPlayer) {
                    int i = 2;
                    Integer num = null;
                    Object[] objArr = 0;
                    Object[] objArr2 = 0;
                    Object[] objArr3 = 0;
                    if (arrayList.isEmpty()) {
                        arrayList.add(new LifeHistoryEntry(startingLifeTotal, Integer.valueOf(mTGameEvent.getValue())));
                        startingLifeTotal += mTGameEvent.getValue();
                        arrayList.add(new LifeHistoryEntry(startingLifeTotal, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0));
                    } else {
                        ((LifeHistoryEntry) arrayList.get(arrayList.size() - 1)).setOffset(Integer.valueOf(mTGameEvent.getValue()));
                        startingLifeTotal += mTGameEvent.getValue();
                        arrayList.add(new LifeHistoryEntry(startingLifeTotal, num, i, objArr3 == true ? 1 : 0));
                    }
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final List<String> getMainFormatIds() {
        return CollectionsKt.listOf((Object[]) new String[]{"standard", "modern", "legacy", "vintage", "pauper", "paupercommander", "commander", "oathbreaker", "duel"});
    }

    public final boolean getMonarchDragInProgress() {
        return this.monarchDragInProgress;
    }

    public final List<String> getPlanarDeck() {
        return this.planarDeck;
    }

    public final int getPlayerScore(int playerIndex, GameSet set) {
        Intrinsics.checkNotNullParameter(set, "set");
        Iterator<GameState> it = set.getFinishedGames().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getPlayers().get(playerIndex).getResultid() == 1) {
                i++;
            }
        }
        return i;
    }

    public final List<String> getSchemeDeck() {
        return this.schemeDeck;
    }

    public final List<Integer> getTop6FormatIds() {
        return CollectionsKt.listOf((Object[]) new Integer[]{6, 9, 21, 12, 15, 10});
    }

    public final List<Integer> getUnavailableUserIds() {
        return this.unavailableUserIds;
    }

    public final List<MTUser> getUnseatedUsers() {
        return this.unseatedUsers;
    }

    public final int getWinRateColor(Context context, float rate, Integer formatId) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.formats.isEmpty()) {
            this.formats = DecksDBHelper.INSTANCE.getInstance(context).getFormats();
        }
        if (formatId == null) {
            return rate >= 50.0f ? ContextCompat.getColor(context, R.color.winner_green) : ContextCompat.getColor(context, R.color.loser_red);
        }
        int iIntValue = formatId.intValue();
        Iterator<T> it = this.formats.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == iIntValue) {
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        return mTFormat != null ? Intrinsics.areEqual(mTFormat.getScryfallid(), "commander") ? rate >= 25.0f ? ContextCompat.getColor(context, R.color.winner_green) : ContextCompat.getColor(context, R.color.loser_red) : Intrinsics.areEqual(mTFormat.getScryfallid(), "oathbreaker") ? rate >= 25.0f ? ContextCompat.getColor(context, R.color.winner_green) : ContextCompat.getColor(context, R.color.loser_red) : rate >= 50.0f ? ContextCompat.getColor(context, R.color.winner_green) : ContextCompat.getColor(context, R.color.loser_red) : rate >= 50.0f ? ContextCompat.getColor(context, R.color.winner_green) : ContextCompat.getColor(context, R.color.loser_red);
    }

    public final boolean isDuel(MTFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return format.getPlayersmin() == 2 && format.getPlayersmax() == 2;
    }

    public final boolean isLeaderRevealed(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        List<MTGameEvent> events = gameState.getEvents();
        if ((events instanceof Collection) && events.isEmpty()) {
            return false;
        }
        for (MTGameEvent mTGameEvent : events) {
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getValue() == 0) {
                return true;
            }
        }
        return false;
    }

    public final String localizedTreacheryRoleName(Context context, int role) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (role == 0) {
            String string = context.getResources().getString(R.string.treachery_leader);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (role == 1) {
            String string2 = context.getResources().getString(R.string.treachery_guardian);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (role == 2) {
            String string3 = context.getResources().getString(R.string.treachery_assassin);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (role != 3) {
            return "";
        }
        String string4 = context.getResources().getString(R.string.treachery_traitor);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return string4;
    }

    public final String nameForCardCondition(Context context, String condition) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(condition, "condition");
        int iHashCode = condition.hashCode();
        if (iHashCode != 71) {
            if (iHashCode != 77) {
                if (iHashCode != 80) {
                    if (iHashCode != 2227) {
                        if (iHashCode != 2436) {
                            if (iHashCode != 2495) {
                                if (iHashCode == 2556 && condition.equals(CONDITION_PLAYED)) {
                                    String string = context.getString(R.string.condition_played);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                    return string;
                                }
                            } else if (condition.equals(CONDITION_NEAR_MINT)) {
                                String string2 = context.getString(R.string.condition_near_mint);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                return string2;
                            }
                        } else if (condition.equals(CONDITION_LIGHT_PLAYED)) {
                            String string3 = context.getString(R.string.condition_light_played);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            return string3;
                        }
                    } else if (condition.equals(CONDITION_EXCELENT)) {
                        String string4 = context.getString(R.string.condition_excellent);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        return string4;
                    }
                } else if (condition.equals(CONDITION_POOR)) {
                    String string5 = context.getString(R.string.condition_poor);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    return string5;
                }
            } else if (condition.equals("M")) {
                String string6 = context.getString(R.string.condition_mint);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            }
        } else if (condition.equals(CONDITION_GOOD)) {
            String string7 = context.getString(R.string.condition_good);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        }
        String string8 = context.getString(R.string.condition_mint);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        return string8;
    }

    public final String nameForComboBracket(Context context, String bracketTag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bracketTag, "bracketTag");
        int iHashCode = bracketTag.hashCode();
        if (iHashCode != 67) {
            if (iHashCode != 69) {
                if (iHashCode != 79) {
                    if (iHashCode != 80) {
                        if (iHashCode != 82) {
                            if (iHashCode == 83 && bracketTag.equals(ExifInterface.LATITUDE_SOUTH)) {
                                String string = context.getString(R.string.combo_strength_very_strong);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                return string;
                            }
                        } else if (bracketTag.equals("R")) {
                            String string2 = context.getString(R.string.combo_strength_very_powerful);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            return string2;
                        }
                    } else if (bracketTag.equals(CONDITION_POOR)) {
                        String string3 = context.getString(R.string.combo_strength_strong);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        return string3;
                    }
                } else if (bracketTag.equals("O")) {
                    String string4 = context.getString(R.string.combo_strength_moderate);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    return string4;
                }
            } else if (bracketTag.equals(ExifInterface.LONGITUDE_EAST)) {
                String string5 = context.getString(R.string.combo_strength_very_casual);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            }
        } else if (bracketTag.equals("C")) {
            String string6 = context.getString(R.string.combo_strength_casual);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        String string7 = context.getString(R.string.combo_strength_very_casual);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        return string7;
    }

    public final PlaymatCategory pickRandomCategory() {
        int iRandom = RangesKt.random(new IntRange(1, 100), Random.INSTANCE);
        return iRandom <= 30 ? PlaymatCategory.BASIC : iRandom <= 60 ? PlaymatCategory.CREATURE : iRandom <= 90 ? PlaymatCategory.GUILD : PlaymatCategory.SCENERY;
    }

    public final String randomBasicPlaymat(List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        List listMutableListOf = CollectionsKt.mutableListOf("playmat_new_plains", "playmat_new_island", "playmat_new_swamp", "playmat_new_mountain", "playmat_new_forest", "playmat_new_wastes");
        Iterator<String> it = excludingPlaymats.iterator();
        while (it.hasNext()) {
            listMutableListOf.remove(it.next());
        }
        return listMutableListOf.isEmpty() ? "playmat_new_island" : (String) CollectionsKt.random(listMutableListOf, Random.INSTANCE);
    }

    public final String randomCreaturePlaymat(List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        List listMutableListOf = CollectionsKt.mutableListOf("creature_playmat_angel", "creature_playmat_cat", "creature_playmat_demon", "creature_playmat_elf", "creature_playmat_faerie", "creature_playmat_goblin", "creature_playmat_human", "creature_playmat_merfolk", "creature_playmat_pirate", "creature_playmat_rats", "creature_playmat_vampire", "creature_playmat_wolves", "creature_playmat_zombie");
        Iterator<String> it = excludingPlaymats.iterator();
        while (it.hasNext()) {
            listMutableListOf.remove(it.next());
        }
        return listMutableListOf.isEmpty() ? "creature_playmat_angel" : (String) CollectionsKt.random(listMutableListOf, Random.INSTANCE);
    }

    public final String randomGuildPlaymat(List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        List listMutableListOf = CollectionsKt.mutableListOf("guild_playmat_azorius", "guild_playmat_boros", "guild_playmat_dimir", "guild_playmat_golgari", "guild_playmat_gruul", "guild_playmat_izzet", "guild_playmat_orzhov", "guild_playmat_rakdos", "guild_playmat_selesnya", "guild_playmat_simic");
        Iterator<String> it = excludingPlaymats.iterator();
        while (it.hasNext()) {
            listMutableListOf.remove(it.next());
        }
        return listMutableListOf.isEmpty() ? "guild_playmat_azorius" : (String) CollectionsKt.random(listMutableListOf, Random.INSTANCE);
    }

    public final String randomPlaymat(PlaymatCategory category, List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        int i = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return randomBasicPlaymat(excludingPlaymats);
        }
        if (i == 2) {
            return randomCreaturePlaymat(excludingPlaymats);
        }
        if (i == 3) {
            return randomGuildPlaymat(excludingPlaymats);
        }
        if (i == 4) {
            return randomSceneryPlaymat(excludingPlaymats);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String randomPlaymat(boolean basic, List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        return basic ? randomBasicPlaymat(excludingPlaymats) : randomSceneryPlaymat(excludingPlaymats);
    }

    public final String randomPlaymatFromSkin(List<String> from, List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        List<String> list = from;
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        for (String str : excludingPlaymats) {
            if (mutableList.contains(str)) {
                mutableList.remove(str);
            }
        }
        return mutableList.isEmpty() ? (String) CollectionsKt.random(list, Random.INSTANCE) : (String) CollectionsKt.random(mutableList, Random.INSTANCE);
    }

    public final String randomSceneryPlaymat(List<String> excludingPlaymats) {
        Intrinsics.checkNotNullParameter(excludingPlaymats, "excludingPlaymats");
        List listMutableListOf = CollectionsKt.mutableListOf("playmat_new_cascade", "playmat_new_desert_city", "playmat_new_lake", "playmat_new_spaceshift", "playmat_new_castle", "playmat_new_desert", "playmat_new_lava", "playmat_new_witch_cottage", "playmat_new_cave", "playmat_new_dragon_island", "playmat_new_ocean", "playmat_new_woods", "playmat_new_city", "playmat_new_flying_rocks", "playmat_new_portal", "playmat_new_coast", "playmat_new_forest_glow", "playmat_new_snow", "playmat_new_dark_castle", "playmat_new_jungle", "playmat_new_space");
        Iterator<String> it = excludingPlaymats.iterator();
        while (it.hasNext()) {
            listMutableListOf.remove(it.next());
        }
        return (String) CollectionsKt.random(listMutableListOf, Random.INSTANCE);
    }

    public final int rebuildPlanarDeck(Context context, GameState gameState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        this.planarDeck = CollectionsKt.emptyList();
        return ensurePlanarDeck(context, gameState);
    }

    public final int rebuildSchemeDeck(Context context, GameState gameState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        this.schemeDeck = CollectionsKt.emptyList();
        return ensureSchemeDeck(context, gameState);
    }

    public final void setDecorsUsed(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.decorsUsed = list;
    }

    public final void setDefaultColors(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.defaultColors = list;
    }

    public final void setFormats(List<MTFormat> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.formats = list;
    }

    public final void setGameParticipantUsers(List<MTUser> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.gameParticipantUsers = list;
    }

    public final void setInitiativeDragInProgress(boolean z) {
        this.initiativeDragInProgress = z;
    }

    public final void setKosUsed(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.kosUsed = list;
    }

    public final void setMonarchDragInProgress(boolean z) {
        this.monarchDragInProgress = z;
    }

    public final void setPlanarDeck(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.planarDeck = list;
    }

    public final void setSchemeDeck(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.schemeDeck = list;
    }

    public final void setUnavailableUserIds(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.unavailableUserIds = list;
    }

    public final void setUnseatedUsers(List<MTUser> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.unseatedUsers = list;
    }

    public final void startInitiativeDrag() {
        this.initiativeDragInProgress = true;
    }

    public final void startMonarchDrag() {
        this.monarchDragInProgress = true;
    }

    public final void stopInitiativeDrag() {
        this.initiativeDragInProgress = false;
    }

    public final void stopMonarchDrag() {
        this.monarchDragInProgress = false;
    }

    public final int timeElapsed(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        int iCurrentTimeMillis = 0;
        if (gameState.getTurnTimerEnabled() && !gameState.getTurnTimerPromptDismissed()) {
            return 0;
        }
        long timerStartTime = gameState.getTimerStartTime();
        int pauseTime = gameState.getPauseTime();
        if (gameState.getTimerPaused()) {
            iCurrentTimeMillis = (int) ((System.currentTimeMillis() - gameState.getTimerPausedAt()) / 1000);
        }
        return (int) ((((System.currentTimeMillis() - timerStartTime) - ((long) (pauseTime * 1000))) - ((long) (iCurrentTimeMillis * 1000))) / DurationKt.MILLIS_IN_MINUTE);
    }

    public final int timeElapsedSeconds(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        int iCurrentTimeMillis = 0;
        if (gameState.getTurnTimerEnabled() && !gameState.getTurnTimerPromptDismissed()) {
            return 0;
        }
        long timerStartTime = gameState.getTimerStartTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int pauseTime = gameState.getPauseTime();
        if (gameState.getTimerPaused()) {
            iCurrentTimeMillis = (int) ((System.currentTimeMillis() - gameState.getTimerPausedAt()) / 1000);
        }
        return (int) ((((jCurrentTimeMillis - timerStartTime) - ((long) (pauseTime * 1000))) - ((long) (iCurrentTimeMillis * 1000))) / 1000);
    }

    public final int timeLeft(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        if (!gameState.getTimerEnabled()) {
            return 0;
        }
        if (gameState.getTurnTimerEnabled() && !gameState.getTurnTimerPromptDismissed()) {
            return gameState.getTimerTotalTime();
        }
        long timerTotalTime = ((long) (gameState.getTimerTotalTime() * 60000)) - (((System.currentTimeMillis() - gameState.getTimerStartTime()) - ((long) (gameState.getPauseTime() * 1000))) - ((long) ((gameState.getTimerPaused() ? (int) ((System.currentTimeMillis() - gameState.getTimerPausedAt()) / 1000) : 0) * 1000)));
        if (timerTotalTime <= 0) {
            return 0;
        }
        int i = ((int) ((timerTotalTime / 1000) / 60)) + 1;
        return i > gameState.getTimerTotalTime() ? gameState.getTimerTotalTime() : i;
    }

    public final int timeLeftSeconds(GameState gameState) {
        int iCurrentTimeMillis;
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        if (!gameState.getTimerEnabled()) {
            return 0;
        }
        if (gameState.getTurnTimerEnabled() && !gameState.getTurnTimerPromptDismissed()) {
            return gameState.getTimerTotalTime() * 60;
        }
        long timerStartTime = gameState.getTimerStartTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int pauseTime = gameState.getPauseTime();
        if (gameState.getTimerPaused()) {
            iCurrentTimeMillis = (int) ((System.currentTimeMillis() - gameState.getTimerPausedAt()) / 1000);
        } else {
            iCurrentTimeMillis = 0;
        }
        long timerTotalTime = ((long) (gameState.getTimerTotalTime() * 60000)) - (((jCurrentTimeMillis - timerStartTime) - ((long) (pauseTime * 1000))) - ((long) (iCurrentTimeMillis * 1000)));
        if (timerTotalTime <= 0) {
            return 0;
        }
        return Math.min(((int) (timerTotalTime / 1000)) + 1, gameState.getTimerTotalTime() * 60);
    }
}
