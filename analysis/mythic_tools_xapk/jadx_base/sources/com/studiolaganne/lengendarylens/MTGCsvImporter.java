package com.studiolaganne.lengendarylens;

import androidx.core.text.util.LocalePreferences;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.provider.CredentialEntry;
import androidx.webkit.ProxyConfig;
import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.ui.ColorKt;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: MTGCsvImporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 `2\u00020\u0001:\u0006[\\]^_`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J4\u0010\u000f\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J.\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00140\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0002J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0002J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0011H\u0002J.\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00182\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00107\u001a\u0002062\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00108\u001a\u0002062\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00109\u001a\u0002062\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010;\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010@\u001a\u0002062\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010A\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J$\u0010B\u001a\u0002062\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0010\u0010C\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010D\u001a\u0002062\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010E\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J*\u0010F\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0010\u0010G\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J$\u0010H\u001a\u0002062\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0010\u0010I\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J$\u0010J\u001a\u0002062\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0010\u0010K\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002JJ\u0010M\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u000b0\u00142\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000bH\u0002J0\u0010O\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0012\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bH\u0002J\u000e\u0010P\u001a\u00020Q2\u0006\u0010\u0012\u001a\u00020\u0005J$\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000b2\u0006\u0010*\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\"\u0010S\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00052\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0018J\u0012\u0010U\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010W\u001a\u0004\u0018\u00010\u00052\b\u0010X\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010Y\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter;", "", "<init>", "()V", "decodeUtf7", "", "value", "cleanCardName", "name", "cleanTcgPlayerCardName", "parseCsvLine", "", "line", "delimiter", "", "extractPreviewData", "Lkotlin/Triple;", "", "csvContent", "findColumnByAlias", "Lkotlin/Pair;", "headers", "field", "analyzeColumnContent", "", "values", "validateSetCodes", "codes", "calculateConfidence", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ConfidenceLevel;", "mappings", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ColumnMapping;", "needsUserMapping", "", "confidence", "importFromCsv", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ImportResult;", "inputStream", "Ljava/io/InputStream;", "detectCsvFormat", "normalizeMalformedQuotedFields", "cleanCsvContent", "format", "getRecordValue", "record", "Lorg/apache/commons/csv/CSVRecord;", "headerMap", "columnName", "parseDragonShield", "parseMoxfield", "parseManaBox", "parseArchidekt", "parseCardBinder", "createCardFromDragonShield", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "createCardFromMoxfield", "createCardFromManaBox", "createCardFromArchidekt", "createCardsFromCardBinder", "parseDecked", "createCardsFromDecked", "lookupSetCodeFromName", "setName", "parseTopDecked", "createCardFromTopDecked", "parseMythicTools", "createCardFromMythicTools", "parseGeneric", "createCardFromGeneric", "parseUrzaGatherer", "createCardsFromUrzaGatherer", "parseDeckBox", "createCardFromDeckBox", "parseDelverLens", "createCardFromDelverLens", "parseTCGPlayerSimple", "parseTCGPlayerDetailed", "parseGenericWithDetection", "dataRows", "parseCardsWithMappings", "importFromCsvWithDetection", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$CsvParseResult;", "buildMappingsForKnownFormat", "parseWithUserMappings", "userMappings", "convertLanguage", "language", "convertCondition", "condition", "convertFinish", "finish", "ImportResult", "DetectionMethod", "ConfidenceLevel", "ColumnMapping", "CsvParseResult", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTGCsvImporter {
    public static final int $stable = 0;
    public static final int FORMAT_ARCHIDEKT = 4;
    public static final int FORMAT_CARD_BINDER = 5;
    public static final int FORMAT_DECKBOX = 12;
    public static final int FORMAT_DECKED = 6;
    public static final int FORMAT_DELVER_LENS = 11;
    public static final int FORMAT_DRAGON_SHIELD = 1;
    public static final int FORMAT_GENERIC = 9;
    public static final int FORMAT_MANABOX = 3;
    public static final int FORMAT_MOXFIELD = 2;
    public static final int FORMAT_MYTHIC_TOOLS = 8;
    public static final int FORMAT_TCGPLAYER_DETAILED = 14;
    public static final int FORMAT_TCGPLAYER_SIMPLE = 13;
    public static final int FORMAT_TOP_DECKED = 7;
    public static final int FORMAT_UNKNOWN = 0;
    public static final int FORMAT_URZAGATHERER = 10;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, String> FORMAT_NAMES = MapsKt.mapOf(TuplesKt.to(0, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN), TuplesKt.to(1, "Dragon Shield"), TuplesKt.to(2, "Moxfield"), TuplesKt.to(3, "ManaBox"), TuplesKt.to(4, "Archidekt"), TuplesKt.to(5, "Card Binder"), TuplesKt.to(6, "Decked"), TuplesKt.to(7, "TopDecked"), TuplesKt.to(8, "Mythic Tools"), TuplesKt.to(9, "Generic"), TuplesKt.to(10, "UrzaGatherer"), TuplesKt.to(11, "Delver Lens"), TuplesKt.to(12, "Deckbox"), TuplesKt.to(13, "TCGPlayer (Simple)"), TuplesKt.to(14, "TCGPlayer (Detailed)"));
    private static final List<String> MAPPABLE_FIELDS = CollectionsKt.listOf((Object[]) new String[]{"name", FirebaseAnalytics.Param.QUANTITY, "set_code", "collector_number", "language", "condition", "finish"});
    private static final Map<String, List<String>> COLUMN_ALIASES = MapsKt.mapOf(TuplesKt.to("name", CollectionsKt.listOf((Object[]) new String[]{"name", "card name", "product name", "card_name", "card", "english_card_name", "cardname", Constants.GP_IAP_TITLE, "card title"})), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, CollectionsKt.listOf((Object[]) new String[]{FirebaseAnalytics.Param.QUANTITY, "count", "qty", "reg qty", "total qty", "total quantity", "regular quantity", "amount", "copies"})), TuplesKt.to("foil_quantity", CollectionsKt.listOf((Object[]) new String[]{"foil qty", "foil_quantity", "foil count", "special foil count", "foil quantity"})), TuplesKt.to("set_code", CollectionsKt.listOf((Object[]) new String[]{"set code", "set_code", "edition code", "setcode", "edition_code", "set", "expansion code", "set id", "expansion_code"})), TuplesKt.to("set_name", CollectionsKt.listOf((Object[]) new String[]{"set name", "set_name", "edition", "edition name", "expansion", "expansion name"})), TuplesKt.to("collector_number", CollectionsKt.listOf((Object[]) new String[]{"card number", "collector number", "number", "collector_number", "card_number", "cardnumber", ColorKt.HEX_PREFIX, SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO})), TuplesKt.to("finish", CollectionsKt.listOf((Object[]) new String[]{"foil", "printing", "foil/etched", "finish", "treatment", "card finish", "variant"})), TuplesKt.to("condition", CollectionsKt.listOf((Object[]) new String[]{"condition", "cond", "grade", "quality", "card condition"})), TuplesKt.to("language", CollectionsKt.listOf((Object[]) new String[]{"language", "lang", "languages", "card language"})), TuplesKt.to("scryfall_id", CollectionsKt.listOf((Object[]) new String[]{"scryfall id", "scryfall_id", "scryfall_uuid", "scryfall uuid"})), TuplesKt.to("container", CollectionsKt.listOf((Object[]) new String[]{"folder name", "container name", "binder", "folder", FirebaseAnalytics.Param.LOCATION, "box", "deck"})), TuplesKt.to("altered", CollectionsKt.listOf((Object[]) new String[]{"altered", "altered art", "alteration", "alter"})), TuplesKt.to("signed", CollectionsKt.listOf((Object[]) new String[]{"signed", "signing", "autograph"})), TuplesKt.to("misprint", CollectionsKt.listOf((Object[]) new String[]{"misprint", "missprint", "error"})));
    private static final Map<String, String> UTF7_DECODE_MAP = MapsKt.mapOf(TuplesKt.to("+ACI-", "\""), TuplesKt.to("+AC0-", "-"), TuplesKt.to("+ACc-", "'"), TuplesKt.to("+ACs-", "+"), TuplesKt.to("+AD0-", "="), TuplesKt.to("+ACE-", "!"), TuplesKt.to("+ACM-", ColorKt.HEX_PREFIX), TuplesKt.to("+ACQ-", "$"), TuplesKt.to("+ACU-", "%"), TuplesKt.to("+ACY-", "&"), TuplesKt.to("+ACo-", ProxyConfig.MATCH_ALL_SCHEMES), TuplesKt.to("+ACw-", ","), TuplesKt.to("+AC4-", "."), TuplesKt.to("+AC8-", DomExceptionUtils.SEPARATOR), TuplesKt.to("+ADo-", com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR), TuplesKt.to("+ADs-", ";"), TuplesKt.to("+ADw-", "<"), TuplesKt.to("+AD4-", ">"), TuplesKt.to("+AD8-", "?"), TuplesKt.to("+AEA-", "@"), TuplesKt.to("+AFw-", "\\"), TuplesKt.to("+AF4-", "^"), TuplesKt.to("+AF8-", "_"), TuplesKt.to("+AGA-", "`"), TuplesKt.to("+AHs-", "{"), TuplesKt.to("+AH0-", "}"), TuplesKt.to("+AHw-", "|"), TuplesKt.to("+AH4-", "~"));
    private static final List<String> CONDITION_PATTERNS = CollectionsKt.listOf((Object[]) new String[]{"m", "nm", "lp", "mp", "hp", "sp", "ex", "g", "p", "po", "mint", "near mint", "played", "excellent", "good", "poor", "damaged", "lightly played", "moderately played", "heavily played"});
    private static final List<String> LANGUAGE_CODES = CollectionsKt.listOf((Object[]) new String[]{"en", "fr", "de", "it", "es", "pt", "ja", "ko", "ru", "zhs", "zht", "english", "french", "german", "italian", "spanish", "portuguese", "japanese", "korean", "russian", LocalePreferences.CalendarType.CHINESE});
    private static final List<String> FINISH_PATTERNS = CollectionsKt.listOf((Object[]) new String[]{"foil", "nonfoil", "non-foil", "normal", "etched", "regular", "true", CredentialEntry.FALSE_STRING, "yes", SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO});

    /* JADX INFO: compiled from: MTGCsvImporter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ColumnMapping;", "", "field", "", "columnIndex", "", "columnHeader", "confidence", "detectionMethod", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$DetectionMethod;", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILcom/studiolaganne/lengendarylens/MTGCsvImporter$DetectionMethod;)V", "getField", "()Ljava/lang/String;", "getColumnIndex", "()I", "getColumnHeader", "getConfidence", "getDetectionMethod", "()Lcom/studiolaganne/lengendarylens/MTGCsvImporter$DetectionMethod;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ColumnMapping {
        public static final int $stable = 0;
        private final String columnHeader;
        private final int columnIndex;
        private final int confidence;
        private final DetectionMethod detectionMethod;
        private final String field;

        public ColumnMapping(String field, int i, String columnHeader, int i2, DetectionMethod detectionMethod) {
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(columnHeader, "columnHeader");
            Intrinsics.checkNotNullParameter(detectionMethod, "detectionMethod");
            this.field = field;
            this.columnIndex = i;
            this.columnHeader = columnHeader;
            this.confidence = i2;
            this.detectionMethod = detectionMethod;
        }

        public static /* synthetic */ ColumnMapping copy$default(ColumnMapping columnMapping, String str, int i, String str2, int i2, DetectionMethod detectionMethod, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = columnMapping.field;
            }
            if ((i3 & 2) != 0) {
                i = columnMapping.columnIndex;
            }
            if ((i3 & 4) != 0) {
                str2 = columnMapping.columnHeader;
            }
            if ((i3 & 8) != 0) {
                i2 = columnMapping.confidence;
            }
            if ((i3 & 16) != 0) {
                detectionMethod = columnMapping.detectionMethod;
            }
            DetectionMethod detectionMethod2 = detectionMethod;
            String str3 = str2;
            return columnMapping.copy(str, i, str3, i2, detectionMethod2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getField() {
            return this.field;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getColumnIndex() {
            return this.columnIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getColumnHeader() {
            return this.columnHeader;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getConfidence() {
            return this.confidence;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final DetectionMethod getDetectionMethod() {
            return this.detectionMethod;
        }

        public final ColumnMapping copy(String field, int columnIndex, String columnHeader, int confidence, DetectionMethod detectionMethod) {
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(columnHeader, "columnHeader");
            Intrinsics.checkNotNullParameter(detectionMethod, "detectionMethod");
            return new ColumnMapping(field, columnIndex, columnHeader, confidence, detectionMethod);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColumnMapping)) {
                return false;
            }
            ColumnMapping columnMapping = (ColumnMapping) other;
            return Intrinsics.areEqual(this.field, columnMapping.field) && this.columnIndex == columnMapping.columnIndex && Intrinsics.areEqual(this.columnHeader, columnMapping.columnHeader) && this.confidence == columnMapping.confidence && this.detectionMethod == columnMapping.detectionMethod;
        }

        public final String getColumnHeader() {
            return this.columnHeader;
        }

        public final int getColumnIndex() {
            return this.columnIndex;
        }

        public final int getConfidence() {
            return this.confidence;
        }

        public final DetectionMethod getDetectionMethod() {
            return this.detectionMethod;
        }

        public final String getField() {
            return this.field;
        }

        public int hashCode() {
            return (((((((this.field.hashCode() * 31) + Integer.hashCode(this.columnIndex)) * 31) + this.columnHeader.hashCode()) * 31) + Integer.hashCode(this.confidence)) * 31) + this.detectionMethod.hashCode();
        }

        public String toString() {
            return "ColumnMapping(field=" + this.field + ", columnIndex=" + this.columnIndex + ", columnHeader=" + this.columnHeader + ", confidence=" + this.confidence + ", detectionMethod=" + this.detectionMethod + ")";
        }
    }

    /* JADX INFO: compiled from: MTGCsvImporter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter$Companion;", "", "<init>", "()V", "FORMAT_UNKNOWN", "", "FORMAT_DRAGON_SHIELD", "FORMAT_MOXFIELD", "FORMAT_MANABOX", "FORMAT_ARCHIDEKT", "FORMAT_CARD_BINDER", "FORMAT_DECKED", "FORMAT_TOP_DECKED", "FORMAT_MYTHIC_TOOLS", "FORMAT_GENERIC", "FORMAT_URZAGATHERER", "FORMAT_DELVER_LENS", "FORMAT_DECKBOX", "FORMAT_TCGPLAYER_SIMPLE", "FORMAT_TCGPLAYER_DETAILED", "FORMAT_NAMES", "", "", "getFORMAT_NAMES", "()Ljava/util/Map;", "MAPPABLE_FIELDS", "", "getMAPPABLE_FIELDS", "()Ljava/util/List;", "COLUMN_ALIASES", "UTF7_DECODE_MAP", "CONDITION_PATTERNS", "LANGUAGE_CODES", "FINISH_PATTERNS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<Integer, String> getFORMAT_NAMES() {
            return MTGCsvImporter.FORMAT_NAMES;
        }

        public final List<String> getMAPPABLE_FIELDS() {
            return MTGCsvImporter.MAPPABLE_FIELDS;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: MTGCsvImporter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ConfidenceLevel;", "", "<init>", "(Ljava/lang/String;I)V", "HIGH", "MEDIUM", "LOW", "NONE", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ConfidenceLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConfidenceLevel[] $VALUES;
        public static final ConfidenceLevel HIGH = new ConfidenceLevel("HIGH", 0);
        public static final ConfidenceLevel MEDIUM = new ConfidenceLevel("MEDIUM", 1);
        public static final ConfidenceLevel LOW = new ConfidenceLevel("LOW", 2);
        public static final ConfidenceLevel NONE = new ConfidenceLevel("NONE", 3);

        private static final /* synthetic */ ConfidenceLevel[] $values() {
            return new ConfidenceLevel[]{HIGH, MEDIUM, LOW, NONE};
        }

        static {
            ConfidenceLevel[] confidenceLevelArr$values = $values();
            $VALUES = confidenceLevelArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(confidenceLevelArr$values);
        }

        private ConfidenceLevel(String str, int i) {
        }

        public static EnumEntries<ConfidenceLevel> getEntries() {
            return $ENTRIES;
        }

        public static ConfidenceLevel valueOf(String str) {
            return (ConfidenceLevel) Enum.valueOf(ConfidenceLevel.class, str);
        }

        public static ConfidenceLevel[] values() {
            return (ConfidenceLevel[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: MTGCsvImporter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003J\u0087\u0001\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0011HÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter$CsvParseResult;", "", "containers", "", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "errors", "", "detectedFormat", "confidence", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ConfidenceLevel;", "columnMappings", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ColumnMapping;", "needsUserMapping", "", "headers", "sampleRows", "totalRowCount", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ConfidenceLevel;Ljava/util/List;ZLjava/util/List;Ljava/util/List;I)V", "getContainers", "()Ljava/util/List;", "getErrors", "getDetectedFormat", "()Ljava/lang/String;", "getConfidence", "()Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ConfidenceLevel;", "getColumnMappings", "getNeedsUserMapping", "()Z", "getHeaders", "getSampleRows", "getTotalRowCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CsvParseResult {
        public static final int $stable = 8;
        private final List<ColumnMapping> columnMappings;
        private final ConfidenceLevel confidence;
        private final List<MTCardContainer> containers;
        private final String detectedFormat;
        private final List<String> errors;
        private final List<String> headers;
        private final boolean needsUserMapping;
        private final List<List<String>> sampleRows;
        private final int totalRowCount;

        /* JADX WARN: Multi-variable type inference failed */
        public CsvParseResult(List<MTCardContainer> containers, List<String> errors, String detectedFormat, ConfidenceLevel confidence, List<ColumnMapping> columnMappings, boolean z, List<String> headers, List<? extends List<String>> sampleRows, int i) {
            Intrinsics.checkNotNullParameter(containers, "containers");
            Intrinsics.checkNotNullParameter(errors, "errors");
            Intrinsics.checkNotNullParameter(detectedFormat, "detectedFormat");
            Intrinsics.checkNotNullParameter(confidence, "confidence");
            Intrinsics.checkNotNullParameter(columnMappings, "columnMappings");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(sampleRows, "sampleRows");
            this.containers = containers;
            this.errors = errors;
            this.detectedFormat = detectedFormat;
            this.confidence = confidence;
            this.columnMappings = columnMappings;
            this.needsUserMapping = z;
            this.headers = headers;
            this.sampleRows = sampleRows;
            this.totalRowCount = i;
        }

        public /* synthetic */ CsvParseResult(List list, List list2, String str, ConfidenceLevel confidenceLevel, List list3, boolean z, List list4, List list5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, str, confidenceLevel, list3, z, list4, list5, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CsvParseResult copy$default(CsvParseResult csvParseResult, List list, List list2, String str, ConfidenceLevel confidenceLevel, List list3, boolean z, List list4, List list5, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = csvParseResult.containers;
            }
            if ((i2 & 2) != 0) {
                list2 = csvParseResult.errors;
            }
            if ((i2 & 4) != 0) {
                str = csvParseResult.detectedFormat;
            }
            if ((i2 & 8) != 0) {
                confidenceLevel = csvParseResult.confidence;
            }
            if ((i2 & 16) != 0) {
                list3 = csvParseResult.columnMappings;
            }
            if ((i2 & 32) != 0) {
                z = csvParseResult.needsUserMapping;
            }
            if ((i2 & 64) != 0) {
                list4 = csvParseResult.headers;
            }
            if ((i2 & 128) != 0) {
                list5 = csvParseResult.sampleRows;
            }
            if ((i2 & 256) != 0) {
                i = csvParseResult.totalRowCount;
            }
            List list6 = list5;
            int i3 = i;
            boolean z2 = z;
            List list7 = list4;
            List list8 = list3;
            String str2 = str;
            return csvParseResult.copy(list, list2, str2, confidenceLevel, list8, z2, list7, list6, i3);
        }

        public final List<MTCardContainer> component1() {
            return this.containers;
        }

        public final List<String> component2() {
            return this.errors;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDetectedFormat() {
            return this.detectedFormat;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ConfidenceLevel getConfidence() {
            return this.confidence;
        }

        public final List<ColumnMapping> component5() {
            return this.columnMappings;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getNeedsUserMapping() {
            return this.needsUserMapping;
        }

        public final List<String> component7() {
            return this.headers;
        }

        public final List<List<String>> component8() {
            return this.sampleRows;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getTotalRowCount() {
            return this.totalRowCount;
        }

        public final CsvParseResult copy(List<MTCardContainer> containers, List<String> errors, String detectedFormat, ConfidenceLevel confidence, List<ColumnMapping> columnMappings, boolean needsUserMapping, List<String> headers, List<? extends List<String>> sampleRows, int totalRowCount) {
            Intrinsics.checkNotNullParameter(containers, "containers");
            Intrinsics.checkNotNullParameter(errors, "errors");
            Intrinsics.checkNotNullParameter(detectedFormat, "detectedFormat");
            Intrinsics.checkNotNullParameter(confidence, "confidence");
            Intrinsics.checkNotNullParameter(columnMappings, "columnMappings");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(sampleRows, "sampleRows");
            return new CsvParseResult(containers, errors, detectedFormat, confidence, columnMappings, needsUserMapping, headers, sampleRows, totalRowCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CsvParseResult)) {
                return false;
            }
            CsvParseResult csvParseResult = (CsvParseResult) other;
            return Intrinsics.areEqual(this.containers, csvParseResult.containers) && Intrinsics.areEqual(this.errors, csvParseResult.errors) && Intrinsics.areEqual(this.detectedFormat, csvParseResult.detectedFormat) && this.confidence == csvParseResult.confidence && Intrinsics.areEqual(this.columnMappings, csvParseResult.columnMappings) && this.needsUserMapping == csvParseResult.needsUserMapping && Intrinsics.areEqual(this.headers, csvParseResult.headers) && Intrinsics.areEqual(this.sampleRows, csvParseResult.sampleRows) && this.totalRowCount == csvParseResult.totalRowCount;
        }

        public final List<ColumnMapping> getColumnMappings() {
            return this.columnMappings;
        }

        public final ConfidenceLevel getConfidence() {
            return this.confidence;
        }

        public final List<MTCardContainer> getContainers() {
            return this.containers;
        }

        public final String getDetectedFormat() {
            return this.detectedFormat;
        }

        public final List<String> getErrors() {
            return this.errors;
        }

        public final List<String> getHeaders() {
            return this.headers;
        }

        public final boolean getNeedsUserMapping() {
            return this.needsUserMapping;
        }

        public final List<List<String>> getSampleRows() {
            return this.sampleRows;
        }

        public final int getTotalRowCount() {
            return this.totalRowCount;
        }

        public int hashCode() {
            return (((((((((((((((this.containers.hashCode() * 31) + this.errors.hashCode()) * 31) + this.detectedFormat.hashCode()) * 31) + this.confidence.hashCode()) * 31) + this.columnMappings.hashCode()) * 31) + Boolean.hashCode(this.needsUserMapping)) * 31) + this.headers.hashCode()) * 31) + this.sampleRows.hashCode()) * 31) + Integer.hashCode(this.totalRowCount);
        }

        public String toString() {
            return "CsvParseResult(containers=" + this.containers + ", errors=" + this.errors + ", detectedFormat=" + this.detectedFormat + ", confidence=" + this.confidence + ", columnMappings=" + this.columnMappings + ", needsUserMapping=" + this.needsUserMapping + ", headers=" + this.headers + ", sampleRows=" + this.sampleRows + ", totalRowCount=" + this.totalRowCount + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: MTGCsvImporter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter$DetectionMethod;", "", "<init>", "(Ljava/lang/String;I)V", "ALIAS", "HEURISTIC", "USER", "NONE", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DetectionMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DetectionMethod[] $VALUES;
        public static final DetectionMethod ALIAS = new DetectionMethod("ALIAS", 0);
        public static final DetectionMethod HEURISTIC = new DetectionMethod("HEURISTIC", 1);
        public static final DetectionMethod USER = new DetectionMethod("USER", 2);
        public static final DetectionMethod NONE = new DetectionMethod("NONE", 3);

        private static final /* synthetic */ DetectionMethod[] $values() {
            return new DetectionMethod[]{ALIAS, HEURISTIC, USER, NONE};
        }

        static {
            DetectionMethod[] detectionMethodArr$values = $values();
            $VALUES = detectionMethodArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(detectionMethodArr$values);
        }

        private DetectionMethod(String str, int i) {
        }

        public static EnumEntries<DetectionMethod> getEntries() {
            return $ENTRIES;
        }

        public static DetectionMethod valueOf(String str) {
            return (DetectionMethod) Enum.valueOf(DetectionMethod.class, str);
        }

        public static DetectionMethod[] values() {
            return (DetectionMethod[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: MTGCsvImporter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ImportResult;", "", "containers", "", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "errors", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getContainers", "()Ljava/util/List;", "getErrors", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ImportResult {
        public static final int $stable = 8;
        private final List<MTCardContainer> containers;
        private final List<String> errors;

        public ImportResult(List<MTCardContainer> containers, List<String> errors) {
            Intrinsics.checkNotNullParameter(containers, "containers");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.containers = containers;
            this.errors = errors;
        }

        public /* synthetic */ ImportResult(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ImportResult copy$default(ImportResult importResult, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = importResult.containers;
            }
            if ((i & 2) != 0) {
                list2 = importResult.errors;
            }
            return importResult.copy(list, list2);
        }

        public final List<MTCardContainer> component1() {
            return this.containers;
        }

        public final List<String> component2() {
            return this.errors;
        }

        public final ImportResult copy(List<MTCardContainer> containers, List<String> errors) {
            Intrinsics.checkNotNullParameter(containers, "containers");
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new ImportResult(containers, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImportResult)) {
                return false;
            }
            ImportResult importResult = (ImportResult) other;
            return Intrinsics.areEqual(this.containers, importResult.containers) && Intrinsics.areEqual(this.errors, importResult.errors);
        }

        public final List<MTCardContainer> getContainers() {
            return this.containers;
        }

        public final List<String> getErrors() {
            return this.errors;
        }

        public int hashCode() {
            return (this.containers.hashCode() * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "ImportResult(containers=" + this.containers + ", errors=" + this.errors + ")";
        }
    }

    private final Map<String, Pair<Integer, String>> analyzeColumnContent(List<String> values) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        int i;
        char c;
        ArrayList<String> arrayList;
        String str2;
        int i2;
        int i3;
        String str3;
        int i4;
        ArrayList arrayList2;
        int i5;
        String str4;
        int i6;
        int i7;
        String str5;
        int i8;
        int i9;
        int i10;
        String str6;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : values) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        String str7 = "finish";
        int i14 = 2;
        char c2 = 1;
        if (arrayList4.isEmpty()) {
            return MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, new Pair(0, "empty")), TuplesKt.to("set_code", new Pair(0, "empty")), TuplesKt.to("collector_number", new Pair(0, "empty")), TuplesKt.to("name", new Pair(0, "empty")), TuplesKt.to("condition", new Pair(0, "empty")), TuplesKt.to("language", new Pair(0, "empty")), TuplesKt.to("finish", new Pair(0, "empty")));
        }
        ArrayList<String> arrayList5 = arrayList4;
        boolean z4 = arrayList5 instanceof Collection;
        if (z4 && arrayList5.isEmpty()) {
            z = true;
        } else {
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                if (StringsKt.toIntOrNull((String) it.next()) == null) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            Integer intOrNull = StringsKt.toIntOrNull((String) it2.next());
            if (intOrNull != null) {
                arrayList6.add(intOrNull);
            }
        }
        ArrayList arrayList7 = arrayList6;
        boolean z5 = arrayList7 instanceof Collection;
        if (z5 && arrayList7.isEmpty()) {
            z2 = true;
        } else {
            Iterator it3 = arrayList7.iterator();
            while (it3.hasNext()) {
                int iIntValue = ((Number) it3.next()).intValue();
                if (1 > iIntValue || iIntValue >= 1000) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (z5 && arrayList7.isEmpty()) {
            z3 = true;
        } else {
            Iterator it4 = arrayList7.iterator();
            while (it4.hasNext()) {
                int iIntValue2 = ((Number) it4.next()).intValue();
                if (1 > iIntValue2 || iIntValue2 >= 100) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
        }
        String str8 = "";
        if (z) {
            if (z2) {
                str = "all integers, in range 1-999";
                i = 80;
            } else {
                str = "all integers";
                i = 50;
            }
            if (z3) {
                str = str + ", typical qty range";
                i += 20;
            }
        } else {
            str = "";
            i = 0;
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList8.add(Integer.valueOf(((String) it5.next()).length()));
        }
        double dAverageOfInt = CollectionsKt.averageOfInt(arrayList8);
        if (z4 && arrayList5.isEmpty()) {
            arrayList = arrayList5;
            c = c2;
        } else {
            for (String str9 : arrayList5) {
                c = c2;
                int length = str9.length();
                if (i14 > length || length >= 6) {
                    arrayList = arrayList5;
                    c2 = 0;
                    break;
                }
                String str10 = str9;
                arrayList = arrayList5;
                if (!new Regex("[a-zA-Z0-9]+").matches(str10)) {
                    c2 = 0;
                    break;
                }
                arrayList5 = arrayList;
                c2 = c;
                i14 = 2;
            }
            arrayList = arrayList5;
            c = c2;
        }
        if (c2 == 0 || dAverageOfInt > 4.0d) {
            str2 = "";
            i2 = 0;
        } else {
            i2 = 70;
            str2 = "short alphanumeric codes";
        }
        int i15 = i2;
        Regex regex = new Regex("^\\d+[a-z]?$|^[A-Z]+-?\\d+$", RegexOption.IGNORE_CASE);
        if (z4 && arrayList.isEmpty()) {
            i3 = 0;
        } else {
            Iterator it6 = arrayList.iterator();
            i3 = 0;
            while (it6.hasNext()) {
                Iterator it7 = it6;
                if (regex.matches((String) it6.next()) && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
                it6 = it7;
            }
        }
        float size = i3 / arrayList4.size();
        float f = 100.0f;
        if (size > 0.8f) {
            str3 = ((int) (size * 100.0f)) + "% match collector pattern";
            i4 = 70;
        } else {
            str3 = "";
            i4 = 0;
        }
        if (z4 && arrayList.isEmpty()) {
            arrayList2 = arrayList4;
            i5 = 0;
        } else {
            Iterator it8 = arrayList.iterator();
            int i16 = 0;
            while (it8.hasNext()) {
                float f2 = f;
                ArrayList arrayList9 = arrayList4;
                boolean z6 = z4;
                String str11 = str7;
                int i17 = i4;
                if (StringsKt.contains$default((CharSequence) it8.next(), (CharSequence) " ", false, 2, (Object) null) && (i16 = i16 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
                z4 = z6;
                f = f2;
                arrayList4 = arrayList9;
                i4 = i17;
                str7 = str11;
            }
            arrayList2 = arrayList4;
            i5 = i16;
        }
        String str12 = str7;
        boolean z7 = z4;
        int i18 = i4;
        float f3 = f;
        float size2 = i5 / arrayList2.size();
        if (dAverageOfInt <= 8.0d || size2 <= 0.3f) {
            str4 = "";
            i6 = 0;
        } else {
            str4 = "avg length " + ((int) dAverageOfInt) + ", " + ((int) (size2 * f3)) + "% have spaces";
            i6 = 50;
        }
        if (z7 && arrayList.isEmpty()) {
            i7 = 0;
        } else {
            Iterator it9 = arrayList.iterator();
            i7 = 0;
            while (it9.hasNext()) {
                String str13 = (String) it9.next();
                List<String> list = CONDITION_PATTERNS;
                Iterator it10 = it9;
                String lowerCase = str13.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (list.contains(StringsKt.trim((CharSequence) lowerCase).toString()) && (i7 = i7 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
                it9 = it10;
            }
        }
        float size3 = i7 / arrayList2.size();
        float f4 = 0.5f;
        if (size3 > 0.5f) {
            str5 = ((int) (size3 * f3)) + "% match condition patterns";
            i8 = 80;
        } else {
            str5 = "";
            i8 = 0;
        }
        if (z7 && arrayList.isEmpty()) {
            i9 = i8;
            i10 = 0;
        } else {
            int i19 = 0;
            for (String str14 : arrayList) {
                float f5 = f4;
                int i20 = i8;
                List<String> list2 = LANGUAGE_CODES;
                int i21 = i6;
                String lowerCase2 = str14.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (list2.contains(StringsKt.trim((CharSequence) lowerCase2).toString()) && (i19 = i19 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
                i8 = i20;
                f4 = f5;
                i6 = i21;
            }
            i9 = i8;
            i10 = i19;
        }
        int i22 = i6;
        float f6 = f4;
        float size4 = i10 / arrayList2.size();
        if (size4 > f6) {
            str6 = ((int) (size4 * f3)) + "% match language codes";
            i11 = 80;
        } else {
            str6 = "";
            i11 = 0;
        }
        if (z7 && arrayList.isEmpty()) {
            i12 = 0;
        } else {
            Iterator it11 = arrayList.iterator();
            int i23 = 0;
            while (it11.hasNext()) {
                int i24 = i11;
                String str15 = (String) it11.next();
                Iterator it12 = it11;
                List<String> list3 = FINISH_PATTERNS;
                int i25 = i23;
                String lowerCase3 = str15.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (list3.contains(StringsKt.trim((CharSequence) lowerCase3).toString())) {
                    i23 = i25 + 1;
                    if (i23 < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                    it11 = it12;
                    i11 = i24;
                } else {
                    it11 = it12;
                    i11 = i24;
                    i23 = i25;
                }
            }
            i12 = i23;
        }
        int i26 = i11;
        float size5 = i12 / arrayList2.size();
        if (size5 > f6) {
            str8 = ((int) (size5 * f3)) + "% match finish patterns";
            i13 = 80;
        } else {
            i13 = 0;
        }
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, new Pair(Integer.valueOf(i), str));
        pairArr[c] = TuplesKt.to("set_code", new Pair(Integer.valueOf(i15), str2));
        pairArr[2] = TuplesKt.to("collector_number", new Pair(Integer.valueOf(i18), str3));
        pairArr[3] = TuplesKt.to("name", new Pair(Integer.valueOf(i22), str4));
        pairArr[4] = TuplesKt.to("condition", new Pair(Integer.valueOf(i9), str5));
        pairArr[5] = TuplesKt.to("language", new Pair(Integer.valueOf(i26), str6));
        pairArr[6] = TuplesKt.to(str12, new Pair(Integer.valueOf(i13), str8));
        return MapsKt.mapOf(pairArr);
    }

    private final List<ColumnMapping> buildMappingsForKnownFormat(int format, List<String> headers) {
        Map mapMapOf;
        ArrayList arrayList = new ArrayList();
        switch (format) {
            case 1:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Card Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Quantity"), TuplesKt.to("set_code", "Set Code"), TuplesKt.to("collector_number", "Card Number"), TuplesKt.to("language", "Language"), TuplesKt.to("condition", "Condition"), TuplesKt.to("finish", "Printing"));
                break;
            case 2:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Count"), TuplesKt.to("set_code", "Edition"), TuplesKt.to("collector_number", "Collector Number"), TuplesKt.to("language", "Language"), TuplesKt.to("condition", "Condition"), TuplesKt.to("finish", "Foil"));
                break;
            case 3:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Quantity"), TuplesKt.to("set_code", "Set code"), TuplesKt.to("collector_number", "Collector number"), TuplesKt.to("language", "Language"), TuplesKt.to("condition", "Condition"), TuplesKt.to("finish", "Foil"));
                break;
            case 4:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Quantity"), TuplesKt.to("set_code", "Edition Code"), TuplesKt.to("collector_number", "Collector Number"), TuplesKt.to("language", "Language"), TuplesKt.to("condition", "Condition"), TuplesKt.to("finish", "Finish"));
                break;
            case 5:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "card_name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, FirebaseAnalytics.Param.QUANTITY), TuplesKt.to("set_code", "set_code"), TuplesKt.to("collector_number", "collector_number"), TuplesKt.to("language", "lang"));
                break;
            case 6:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Card"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Reg Qty"), TuplesKt.to("set_name", "Set"));
                break;
            case 7:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "NAME"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "QUANTITY"), TuplesKt.to("set_code", "SETCODE"), TuplesKt.to("collector_number", "COLLECTOR NUMBER"), TuplesKt.to("language", "LANG"), TuplesKt.to("condition", "CONDITION"), TuplesKt.to("finish", "FINISH"));
                break;
            case 8:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Card Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Quantity"), TuplesKt.to("set_code", "Set Code"), TuplesKt.to("collector_number", "Collector Number"), TuplesKt.to("language", "Language"), TuplesKt.to("condition", "Condition"), TuplesKt.to("finish", "Finish"));
                break;
            case 9:
            default:
                mapMapOf = MapsKt.emptyMap();
                break;
            case 10:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Count"), TuplesKt.to("set_code", "Set code"), TuplesKt.to("collector_number", "Number"), TuplesKt.to("language", "Languages"), TuplesKt.to("condition", "Condition"));
                break;
            case 11:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Card Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Quantity"), TuplesKt.to("set_code", "Set Code"), TuplesKt.to("collector_number", "Number"), TuplesKt.to("finish", "Foil/Etched"));
                break;
            case 12:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Count"), TuplesKt.to("set_code", "Edition Code"), TuplesKt.to("collector_number", "Card Number"), TuplesKt.to("language", "Language"), TuplesKt.to("condition", "Condition"), TuplesKt.to("finish", "Foil"));
                break;
            case 13:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Product Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Qty"), TuplesKt.to("collector_number", "Number"));
                break;
            case 14:
                mapMapOf = MapsKt.mapOf(TuplesKt.to("name", "Product Name"), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, "Total Quantity"), TuplesKt.to("set_name", "Set Name"), TuplesKt.to("collector_number", "Number"), TuplesKt.to("condition", "Condition"));
                break;
        }
        List<String> list = headers;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList2.add(StringsKt.trim((CharSequence) lowerCase).toString());
        }
        ArrayList arrayList3 = arrayList2;
        for (Map.Entry entry : mapMapOf.entrySet()) {
            String str = (String) entry.getKey();
            String lowerCase2 = ((String) entry.getValue()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            int iIndexOf = arrayList3.indexOf(lowerCase2);
            if (iIndexOf >= 0) {
                arrayList.add(new ColumnMapping(str, iIndexOf, headers.get(iIndexOf), 100, DetectionMethod.ALIAS));
            }
        }
        return arrayList;
    }

    private final ConfidenceLevel calculateConfidence(List<ColumnMapping> mappings) {
        List<ColumnMapping> list = mappings;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ColumnMapping) obj).getColumnIndex() >= 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ColumnMapping) it.next()).getField());
        }
        Set set = CollectionsKt.toSet(arrayList3);
        boolean z = set.contains("set_code") || set.contains("set_name");
        if (z && set.contains("collector_number") && set.contains("language")) {
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"set_code", "set_name", "collector_number", "language"});
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : list) {
                ColumnMapping columnMapping = (ColumnMapping) obj2;
                if (listListOf.contains(columnMapping.getField()) && columnMapping.getColumnIndex() >= 0) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = arrayList4;
            if (!(arrayList5 instanceof Collection) || !arrayList5.isEmpty()) {
                Iterator it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    if (((ColumnMapping) it2.next()).getConfidence() >= 70) {
                    }
                }
            }
            return ConfidenceLevel.HIGH;
        }
        return (z && set.contains("collector_number")) ? ConfidenceLevel.MEDIUM : (set.contains("name") && z) ? ConfidenceLevel.MEDIUM : set.contains("name") ? ConfidenceLevel.LOW : ConfidenceLevel.NONE;
    }

    private final String cleanCardName(String name) {
        if (StringsKt.isBlank(name)) {
            return name;
        }
        return StringsKt.trim((CharSequence) new Regex("^\"+|\"+$").replace(decodeUtf7(name), "")).toString();
    }

    private final String cleanCsvContent(String csvContent, int format) {
        String strNormalizeMalformedQuotedFields = normalizeMalformedQuotedFields(csvContent);
        if (format != 1 && format != 10) {
            return strNormalizeMalformedQuotedFields;
        }
        List<String> listLines = StringsKt.lines(strNormalizeMalformedQuotedFields);
        return StringsKt.contains$default((CharSequence) CollectionsKt.first((List) listLines), (CharSequence) "\"sep=,\"", false, 2, (Object) null) ? CollectionsKt.joinToString$default(CollectionsKt.drop(listLines, 1), "\n", null, null, 0, null, null, 62, null) : strNormalizeMalformedQuotedFields;
    }

    private final String cleanTcgPlayerCardName(String name) {
        if (StringsKt.isBlank(name)) {
            return name;
        }
        return StringsKt.trim((CharSequence) new Regex("(\\s*\\([^)]*\\))+\\s*$").replace(cleanCardName(name), "")).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x015b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String convertCondition(String condition) {
        String str;
        String str2 = condition;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        String lowerCase = condition.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = StringsKt.trim((CharSequence) lowerCase).toString();
        switch (string.hashCode()) {
            case -2131139238:
                str = "near mint";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            case -2119133465:
                str = "near-mint";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            case -2072957415:
                str = "near_mint";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            case -1691408535:
                return !string.equals("lightplayed") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case -1577584145:
                return !string.equals("heavily played") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_PLAYED;
            case -985752877:
                if (!string.equals("played")) {
                    return GameUtils.CONDITION_NEAR_MINT;
                }
                break;
            case -908334173:
                return !string.equals("slightly played") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case -266861570:
                return !string.equals("light play") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case 103:
                return !string.equals("g") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_GOOD;
            case 109:
                return !string.equals("m") ? GameUtils.CONDITION_NEAR_MINT : "M";
            case 112:
                if (!string.equals("p")) {
                    return GameUtils.CONDITION_NEAR_MINT;
                }
                break;
            case 3251:
                return !string.equals("ex") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_EXCELENT;
            case 3293:
                return !string.equals("gd") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_GOOD;
            case 3336:
                if (!string.equals("hp")) {
                    return GameUtils.CONDITION_NEAR_MINT;
                }
                break;
            case 3460:
                return !string.equals("lp") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case 3491:
                return !string.equals("mp") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_PLAYED;
            case 3495:
                return !string.equals("mt") ? GameUtils.CONDITION_NEAR_MINT : "M";
            case 3519:
                str = "nm";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            case 3580:
                if (!string.equals("pl")) {
                    return GameUtils.CONDITION_NEAR_MINT;
                }
                break;
            case 3583:
                return !string.equals("po") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_POOR;
            case 3677:
                return !string.equals("sp") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case 99582:
                return !string.equals("dmg") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_POOR;
            case 100880:
                return !string.equals("exc") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_EXCELENT;
            case 3178685:
                return !string.equals("good") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_GOOD;
            case 3351650:
                return !string.equals("mint") ? GameUtils.CONDITION_NEAR_MINT : "M";
            case 3383325:
                str = "nm/m";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            case 3446818:
                return !string.equals("poor") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_POOR;
            case 764827786:
                str = "nearmint";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            case 1244072221:
                return !string.equals("light played") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case 1436738261:
                return !string.equals("damaged") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_POOR;
            case 1477689398:
                return !string.equals("excellent") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_EXCELENT;
            case 1583285027:
                if (!string.equals("moderately played")) {
                    return GameUtils.CONDITION_NEAR_MINT;
                }
                break;
            case 1717878419:
                return !string.equals("gem mint") ? GameUtils.CONDITION_NEAR_MINT : "M";
            case 1816866928:
                return !string.equals("lightly played") ? GameUtils.CONDITION_NEAR_MINT : GameUtils.CONDITION_LIGHT_PLAYED;
            case 2005870641:
                if (!string.equals("moderate play")) {
                    return GameUtils.CONDITION_NEAR_MINT;
                }
                break;
            case 2006644656:
                str = "nm-mint";
                string.equals(str);
                return GameUtils.CONDITION_NEAR_MINT;
            default:
                return GameUtils.CONDITION_NEAR_MINT;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r8.equals("nonfoil") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r8.equals("non-foil") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (r8.equals("regular") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r8.equals(androidx.credentials.provider.CredentialEntry.FALSE_STRING) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        if (r8.equals("true") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r8.equals("foil") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r8.equals("yes") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r8.equals(com.caverock.androidsvg.SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
    
        if (r8.equals("y") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
    
        if (r8.equals("n") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
    
        if (r8.equals("f") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        return "foil";
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a2, code lost:
    
        if (r8.equals("e") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
    
        if (r8.equals("") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b4, code lost:
    
        if (r8.equals("etchedfoil") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bd, code lost:
    
        if (r8.equals("foil-etched") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c6, code lost:
    
        if (r8.equals("normal") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c9, code lost:
    
        return "nonfoil";
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ce, code lost:
    
        if (r8.equals("etched") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d7, code lost:
    
        if (r8.equals("etched foil") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00da, code lost:
    
        return "etched";
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String convertFinish(String finish) {
        String str = finish;
        if (str != null && !StringsKt.isBlank(str)) {
            String lowerCase = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.trim((CharSequence) lowerCase).toString();
            switch (string.hashCode()) {
                case -2065700167:
                    break;
                case -1293242125:
                    break;
                case -1039745817:
                    break;
                case -513092044:
                    break;
                case -341636321:
                    break;
                case 0:
                    break;
                case 101:
                    break;
                case 102:
                    break;
                case Videoio.CAP_PROP_OPENNI2_SYNC /* 110 */:
                    break;
                case Imgproc.COLOR_YUV2RGBA_YVYU /* 121 */:
                    break;
                case 3521:
                    break;
                case 119527:
                    break;
                case 3148716:
                    break;
                case 3569038:
                    break;
                case 97196323:
                    break;
                case 1086463900:
                    break;
                case 1358183084:
                    break;
                case 2123728889:
                    break;
                default:
                    String lowerCase2 = finish.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "etched", false, 2, (Object) null)) {
                        return "etched";
                    }
                    String lowerCase3 = finish.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "foil", false, 2, (Object) null)) {
                        return "foil";
                    }
                    break;
            }
        }
        return "nonfoil";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0207 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0211 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0224 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0148 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String convertLanguage(String language) {
        String str;
        String str2 = language;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            String lowerCase = language.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.trim((CharSequence) lowerCase).toString();
            switch (string.hashCode()) {
                case -2081850205:
                    if (string.equals("espagnol")) {
                        return "es";
                    }
                    break;
                case -2011831052:
                    if (!string.equals("spanish")) {
                    }
                    break;
                case -1728035076:
                    if (string.equals("chinese (simplified)")) {
                        return "zhs";
                    }
                    break;
                case -1644106879:
                    if (string.equals("francais")) {
                        return "fr";
                    }
                    break;
                case -1640174467:
                    if (!string.equals("français")) {
                    }
                    break;
                case -1603757456:
                    str = "english";
                    string.equals(str);
                    break;
                case -1266394726:
                    if (!string.equals("french")) {
                    }
                    break;
                case -1249385082:
                    if (string.equals("german")) {
                        return "de";
                    }
                    break;
                case -1125640956:
                    if (string.equals("korean")) {
                        return "ko";
                    }
                    break;
                case -858812871:
                    str = "anglais";
                    string.equals(str);
                    break;
                case -752730191:
                    if (string.equals("japanese")) {
                        return "ja";
                    }
                    break;
                case -628315054:
                    if (string.equals("phyrexian")) {
                        return UserDataStore.PHONE;
                    }
                    break;
                case -517015820:
                    if (string.equals("chinese traditional")) {
                        return "zht";
                    }
                    break;
                case 3184:
                    if (!string.equals("cs")) {
                    }
                    break;
                case 3185:
                    if (!string.equals(UserDataStore.CITY)) {
                    }
                    break;
                case 3201:
                    if (!string.equals("de")) {
                    }
                    break;
                case 3241:
                    string.equals("en");
                    break;
                case 3246:
                    if (!string.equals("es")) {
                    }
                    break;
                case 3276:
                    if (!string.equals("fr")) {
                    }
                    break;
                case 3371:
                    if (string.equals("it")) {
                        return "it";
                    }
                    break;
                case 3383:
                    if (!string.equals("ja")) {
                    }
                    break;
                case 3398:
                    if (!string.equals("jp")) {
                    }
                    break;
                case 3428:
                    if (!string.equals("ko")) {
                    }
                    break;
                case 3431:
                    if (!string.equals("kr")) {
                    }
                    break;
                case 3576:
                    if (!string.equals(UserDataStore.PHONE)) {
                    }
                    break;
                case 3588:
                    if (string.equals("pt")) {
                        return "pt";
                    }
                    break;
                case 3651:
                    if (string.equals("ru")) {
                        return "ru";
                    }
                    break;
                case 100574:
                    str = "eng";
                    string.equals(str);
                    break;
                case 101657:
                    if (!string.equals("fre")) {
                    }
                    break;
                case 102228:
                    if (!string.equals("ger")) {
                    }
                    break;
                case 104598:
                    if (!string.equals("ita")) {
                    }
                    break;
                case 105448:
                    if (!string.equals("jpn")) {
                    }
                    break;
                case 106382:
                    if (!string.equals("kor")) {
                    }
                    break;
                case 111187:
                    if (!string.equals("por")) {
                    }
                    break;
                case 113296:
                    if (!string.equals("rus")) {
                    }
                    break;
                case 114084:
                    if (!string.equals("spa")) {
                    }
                    break;
                case 120581:
                    if (!string.equals("zhs")) {
                    }
                    break;
                case 120582:
                    if (!string.equals("zht")) {
                    }
                    break;
                case 73288564:
                    if (!string.equals("traditional chinese")) {
                    }
                    break;
                case 108881122:
                    if (!string.equals("russe")) {
                    }
                    break;
                case 746330349:
                    if (!string.equals(LocalePreferences.CalendarType.CHINESE)) {
                    }
                    break;
                case 837788213:
                    if (!string.equals("portuguese")) {
                    }
                    break;
                case 1062696047:
                    if (!string.equals("italiano")) {
                    }
                    break;
                case 1135384984:
                    if (!string.equals("portugais")) {
                    }
                    break;
                case 1555550099:
                    if (!string.equals("russian")) {
                    }
                    break;
                case 1559220536:
                    if (!string.equals("deutsch")) {
                    }
                    break;
                case 1803595566:
                    if (!string.equals("allemand")) {
                    }
                    break;
                case 1921595429:
                    if (!string.equals("simplified chinese")) {
                    }
                    break;
                case 2010527127:
                    if (!string.equals("chinese (traditional)")) {
                    }
                    break;
                case 2088612971:
                    if (!string.equals("chinese simplified")) {
                    }
                    break;
                case 2112490496:
                    if (!string.equals("italian")) {
                    }
                    break;
                case 2112490620:
                    if (!string.equals("italien")) {
                    }
                    break;
            }
        }
        return "en";
    }

    private final MTFullCard createCardFromArchidekt(CSVRecord record) {
        String str = record.get("Edition Code");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = record.get("Collector Number");
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String string = StringsKt.trim((CharSequence) str2).toString();
        String strConvertLanguage = convertLanguage(record.get("Language"));
        String str3 = record.get("Quantity");
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str3);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
        String str4 = record.get("Name");
        Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        String string2 = StringsKt.trim((CharSequence) str4).toString();
        String strConvertCondition = convertCondition(record.get("Condition"));
        String strConvertFinish = convertFinish(record.get("Finish"));
        String str5 = record.get("Purchase Price");
        return new MTFullCard(null, false, null, null, null, string, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, string2, null, null, null, null, null, null, str5 != null ? StringsKt.toDoubleOrNull(str5) : null, false, Integer.valueOf(iIntValue), null, null, lowerCase, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1208369, 127, null);
    }

    private final MTFullCard createCardFromDeckBox(CSVRecord record, Map<String, Integer> headerMap) {
        String str;
        boolean z;
        boolean z2;
        String string;
        String string2;
        String string3;
        String string4;
        Integer intOrNull;
        String string5;
        String string6;
        String recordValue = getRecordValue(record, headerMap, "Edition Code");
        if (recordValue == null || (string6 = StringsKt.trim((CharSequence) recordValue).toString()) == null) {
            str = null;
        } else {
            String lowerCase = string6.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            str = lowerCase;
        }
        String recordValue2 = getRecordValue(record, headerMap, "Card Number");
        String string7 = recordValue2 != null ? StringsKt.trim((CharSequence) recordValue2).toString() : null;
        String recordValue3 = getRecordValue(record, headerMap, "Name");
        String str2 = "";
        String str3 = (recordValue3 == null || (string5 = StringsKt.trim((CharSequence) recordValue3).toString()) == null) ? "" : string5;
        String strConvertLanguage = convertLanguage(getRecordValue(record, headerMap, "Language"));
        String recordValue4 = getRecordValue(record, headerMap, "Count");
        int iIntValue = (recordValue4 == null || (intOrNull = StringsKt.toIntOrNull(recordValue4)) == null) ? 1 : intOrNull.intValue();
        String strConvertCondition = convertCondition(getRecordValue(record, headerMap, "Condition"));
        String recordValue5 = getRecordValue(record, headerMap, "Foil");
        if (recordValue5 != null && (string4 = StringsKt.trim((CharSequence) recordValue5).toString()) != null) {
            str2 = string4;
        }
        String str4 = !StringsKt.isBlank(str2) ? "foil" : "nonfoil";
        String recordValue6 = getRecordValue(record, headerMap, "Signed");
        boolean z3 = (recordValue6 == null || (string3 = StringsKt.trim((CharSequence) recordValue6).toString()) == null) ? false : !StringsKt.isBlank(string3);
        String recordValue7 = getRecordValue(record, headerMap, "Altered Art");
        boolean z4 = (recordValue7 == null || (string2 = StringsKt.trim((CharSequence) recordValue7).toString()) == null) ? false : !StringsKt.isBlank(string2);
        String recordValue8 = getRecordValue(record, headerMap, "Misprint");
        if (recordValue8 == null || (string = StringsKt.trim((CharSequence) recordValue8).toString()) == null) {
            z = false;
            z2 = false;
        } else {
            z = !StringsKt.isBlank(string);
            z2 = false;
        }
        return new MTFullCard(null, Boolean.valueOf(z4), null, null, null, string7, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, str4, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, Boolean.valueOf(z), str3, null, null, null, null, null, null, null, Boolean.valueOf(z2), Integer.valueOf(iIntValue), null, null, str, null, null, Boolean.valueOf(z3), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MTFullCard createCardFromDelverLens(CSVRecord record, Map<String, Integer> headerMap) {
        String str;
        String string;
        Integer intOrNull;
        String string2;
        String string3;
        String string4;
        String recordValue = getRecordValue(record, headerMap, "Set Code");
        String str2 = "";
        if (recordValue == null || (string4 = StringsKt.trim((CharSequence) recordValue).toString()) == null) {
            str = "";
        } else {
            String lowerCase = string4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                str = lowerCase;
            }
        }
        String recordValue2 = getRecordValue(record, headerMap, "Number");
        String str3 = (recordValue2 == null || (string3 = StringsKt.trim((CharSequence) recordValue2).toString()) == null) ? "" : string3;
        String recordValue3 = getRecordValue(record, headerMap, "Card Name");
        String str4 = (recordValue3 == null || (string2 = StringsKt.trim((CharSequence) recordValue3).toString()) == null) ? "" : string2;
        String recordValue4 = getRecordValue(record, headerMap, "Quantity");
        int iIntValue = (recordValue4 == null || (intOrNull = StringsKt.toIntOrNull(recordValue4)) == null) ? 1 : intOrNull.intValue();
        String recordValue5 = getRecordValue(record, headerMap, "Foil/Etched");
        if (recordValue5 != null && (string = StringsKt.trim((CharSequence) recordValue5).toString()) != null) {
            String lowerCase2 = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (lowerCase2 != null) {
                str2 = lowerCase2;
            }
        }
        String str5 = "foil";
        if (!Intrinsics.areEqual(str2, "foil")) {
            str5 = "etched";
            if (!Intrinsics.areEqual(str2, "etched")) {
                str5 = "nonfoil";
            }
        }
        return new MTFullCard(null, false, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str5, null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, str4, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null);
    }

    private final MTFullCard createCardFromDragonShield(CSVRecord record) {
        String str = record.get("Set Code");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = record.get("Card Number");
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String string = StringsKt.trim((CharSequence) str2).toString();
        String strConvertLanguage = convertLanguage(record.get("Language"));
        String str3 = record.get("Quantity");
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str3);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
        String str4 = record.get("Card Name");
        Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        String string2 = StringsKt.trim((CharSequence) str4).toString();
        String strConvertCondition = convertCondition(record.get("Condition"));
        String strConvertFinish = convertFinish(record.get("Printing"));
        String str5 = record.get("Price Bought");
        return new MTFullCard(null, false, null, null, null, string, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, string2, null, null, null, null, null, null, str5 != null ? StringsKt.toDoubleOrNull(str5) : null, false, Integer.valueOf(iIntValue), null, null, lowerCase, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1208369, 127, null);
    }

    private final MTFullCard createCardFromGeneric(CSVRecord record) {
        String str = record.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
        String str2 = record.get(1);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        return new MTFullCard(null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, StringsKt.trim((CharSequence) str2).toString(), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null);
    }

    private final MTFullCard createCardFromManaBox(CSVRecord record) {
        String str = record.get("Set code");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = record.get("Collector number");
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String string = StringsKt.trim((CharSequence) str2).toString();
        String strConvertLanguage = convertLanguage(record.get("Language"));
        String str3 = record.get("Quantity");
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str3);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
        String str4 = record.get("Name");
        Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        String string2 = StringsKt.trim((CharSequence) str4).toString();
        String strConvertCondition = convertCondition(record.get("Condition"));
        String strConvertFinish = convertFinish(record.get("Foil"));
        boolean zEquals = StringsKt.equals(record.get("Altered"), "true", true);
        boolean zEquals2 = StringsKt.equals(record.get("Misprint"), "true", true);
        String str5 = record.get("Purchase price");
        return new MTFullCard(null, Boolean.valueOf(zEquals), null, null, null, string, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, Boolean.valueOf(zEquals2), string2, null, null, null, null, null, null, str5 != null ? StringsKt.toDoubleOrNull(str5) : null, false, Integer.valueOf(iIntValue), null, null, lowerCase, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1208369, 127, null);
    }

    private final MTFullCard createCardFromMoxfield(CSVRecord record) {
        String str = record.get("Edition");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = record.get("Collector Number");
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String string = StringsKt.trim((CharSequence) str2).toString();
        String strConvertLanguage = convertLanguage(record.get("Language"));
        String str3 = record.get("Count");
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str3);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
        String str4 = record.get("Name");
        Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        String string2 = StringsKt.trim((CharSequence) str4).toString();
        String strConvertCondition = convertCondition(record.get("Condition"));
        String strConvertFinish = convertFinish(record.get("Foil"));
        boolean zEquals = StringsKt.equals(record.get("Alter"), "True", true);
        boolean zEquals2 = StringsKt.equals(record.get("Proxy"), "True", true);
        String str5 = record.get("Purchase Price");
        return new MTFullCard(null, Boolean.valueOf(zEquals), null, null, null, string, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, string2, null, null, null, null, null, null, str5 != null ? StringsKt.toDoubleOrNull(str5) : null, Boolean.valueOf(zEquals2), Integer.valueOf(iIntValue), null, null, lowerCase, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1208369, 127, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MTFullCard createCardFromMythicTools(CSVRecord record, Map<String, Integer> headerMap) {
        String str;
        String lowerCase;
        String string;
        String string2;
        Integer intOrNull;
        String string3;
        String string4;
        String recordValue = getRecordValue(record, headerMap, "Set Code");
        if (recordValue == null || (string4 = StringsKt.trim((CharSequence) recordValue).toString()) == null) {
            str = "";
        } else {
            String lowerCase2 = string4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (lowerCase2 != null) {
                str = lowerCase2;
            }
        }
        String recordValue2 = getRecordValue(record, headerMap, "Collector Number");
        String str2 = (recordValue2 == null || (string3 = StringsKt.trim((CharSequence) recordValue2).toString()) == null) ? "" : string3;
        String strConvertLanguage = convertLanguage(getRecordValue(record, headerMap, "Language"));
        String recordValue3 = getRecordValue(record, headerMap, "Quantity");
        int iIntValue = (recordValue3 == null || (intOrNull = StringsKt.toIntOrNull(recordValue3)) == null) ? 1 : intOrNull.intValue();
        String recordValue4 = getRecordValue(record, headerMap, "Finish");
        if (recordValue4 == null || (string2 = StringsKt.trim((CharSequence) recordValue4).toString()) == null) {
            lowerCase = "nonfoil";
        } else {
            lowerCase = string2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
            }
        }
        String recordValue5 = getRecordValue(record, headerMap, "Card Name");
        String str3 = (recordValue5 == null || (string = StringsKt.trim((CharSequence) recordValue5).toString()) == null) ? "" : string;
        String strConvertCondition = convertCondition(getRecordValue(record, headerMap, "Condition"));
        String strConvertFinish = convertFinish(lowerCase);
        String recordValue6 = getRecordValue(record, headerMap, "Altered");
        boolean zEquals = recordValue6 != null ? StringsKt.equals(recordValue6, "true", true) : false;
        String recordValue7 = getRecordValue(record, headerMap, "Misprint");
        boolean zEquals2 = recordValue7 != null ? StringsKt.equals(recordValue7, "true", true) : false;
        String recordValue8 = getRecordValue(record, headerMap, "Signed");
        return new MTFullCard(null, Boolean.valueOf(zEquals), null, null, null, str2, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, Boolean.valueOf(zEquals2), str3, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, str, null, null, Boolean.valueOf(recordValue8 != null ? StringsKt.equals(recordValue8, "true", true) : false), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MTFullCard createCardFromTopDecked(CSVRecord record) {
        String str;
        String lowerCase;
        String string;
        String string2;
        Integer intOrNull;
        String string3;
        String string4;
        Map<String, Integer> headerMap = record.getParser().getHeaderMap();
        Intrinsics.checkNotNull(headerMap);
        String recordValue = getRecordValue(record, headerMap, "SETCODE");
        if (recordValue == null || (string4 = StringsKt.trim((CharSequence) recordValue).toString()) == null) {
            str = "";
        } else {
            String lowerCase2 = string4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (lowerCase2 != null) {
                str = lowerCase2;
            }
        }
        String recordValue2 = getRecordValue(record, headerMap, "COLLECTOR NUMBER");
        String str2 = (recordValue2 == null || (string3 = StringsKt.trim((CharSequence) recordValue2).toString()) == null) ? "" : string3;
        String strConvertLanguage = convertLanguage(getRecordValue(record, headerMap, "LANG"));
        String recordValue3 = getRecordValue(record, headerMap, "QUANTITY");
        int iIntValue = (recordValue3 == null || (intOrNull = StringsKt.toIntOrNull(recordValue3)) == null) ? 1 : intOrNull.intValue();
        String recordValue4 = getRecordValue(record, headerMap, "FINISH");
        if (recordValue4 == null || (string2 = StringsKt.trim((CharSequence) recordValue4).toString()) == null) {
            lowerCase = "nonfoil";
        } else {
            lowerCase = string2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
            }
        }
        String recordValue5 = getRecordValue(record, headerMap, "NAME");
        String str3 = (recordValue5 == null || (string = StringsKt.trim((CharSequence) recordValue5).toString()) == null) ? "" : string;
        String strConvertCondition = convertCondition(getRecordValue(record, headerMap, "CONDITION"));
        String strConvertFinish = convertFinish(lowerCase);
        String recordValue6 = getRecordValue(record, headerMap, "ALTERATION");
        boolean zEquals = recordValue6 != null ? StringsKt.equals(recordValue6, "true", true) : false;
        String recordValue7 = getRecordValue(record, headerMap, "SIGNING");
        boolean zEquals2 = recordValue7 != null ? StringsKt.equals(recordValue7, "true", true) : false;
        String recordValue8 = getRecordValue(record, headerMap, "ACQUIRED PRICE");
        return new MTFullCard(null, Boolean.valueOf(zEquals), null, null, null, str2, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, str3, null, null, null, null, null, null, recordValue8 != null ? StringsKt.toDoubleOrNull(recordValue8) : null, false, Integer.valueOf(iIntValue), null, null, str, null, null, Boolean.valueOf(zEquals2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1208369, 127, null);
    }

    private final List<MTFullCard> createCardsFromCardBinder(CSVRecord record) {
        String str;
        String str2 = record.get("set_code");
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String lowerCase = StringsKt.trim((CharSequence) str2).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str3 = record.get("collector_number");
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        String string = StringsKt.trim((CharSequence) str3).toString();
        String strConvertLanguage = convertLanguage(record.get("lang"));
        String str4 = record.get("card_name");
        Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        String string2 = StringsKt.trim((CharSequence) str4).toString();
        String str5 = record.get(FirebaseAnalytics.Param.QUANTITY);
        Intrinsics.checkNotNullExpressionValue(str5, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str5);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
        String str6 = record.get("foil_quantity");
        Intrinsics.checkNotNullExpressionValue(str6, "get(...)");
        Integer intOrNull2 = StringsKt.toIntOrNull(str6);
        int iIntValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
        ArrayList arrayList = new ArrayList();
        if (iIntValue > 0) {
            str = lowerCase;
            arrayList.add(new MTFullCard(null, false, null, null, null, string, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, string2, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
        } else {
            str = lowerCase;
        }
        if (iIntValue2 > 0) {
            arrayList.add(new MTFullCard(null, false, null, null, null, string, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "foil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, string2, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue2), null, null, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
        }
        return arrayList;
    }

    private final List<MTFullCard> createCardsFromDecked(CSVRecord record) {
        String str = record.get("Set");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String strLookupSetCodeFromName = lookupSetCodeFromName(StringsKt.trim((CharSequence) str).toString());
        String str2 = record.get("Card");
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String string = StringsKt.trim((CharSequence) str2).toString();
        String str3 = record.get("Reg Qty");
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        Integer intOrNull = StringsKt.toIntOrNull(str3);
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
        String str4 = record.get("Foil Qty");
        Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        Integer intOrNull2 = StringsKt.toIntOrNull(str4);
        int iIntValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
        ArrayList arrayList = new ArrayList();
        if (iIntValue > 0) {
            arrayList.add(new MTFullCard(null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, string, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, strLookupSetCodeFromName, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
        }
        if (iIntValue2 > 0) {
            arrayList.add(new MTFullCard(null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "foil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, string, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue2), null, null, strLookupSetCodeFromName, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<MTFullCard> createCardsFromUrzaGatherer(CSVRecord record, Map<String, Integer> headerMap) {
        String str;
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        String string;
        String string2;
        String string3;
        String recordValue = getRecordValue(record, headerMap, "Set code");
        if (recordValue == null || (string3 = StringsKt.trim((CharSequence) recordValue).toString()) == null) {
            str = "";
        } else {
            String lowerCase = string3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                str = lowerCase;
            }
        }
        String recordValue2 = getRecordValue(record, headerMap, "Number");
        String str2 = (recordValue2 == null || (string2 = StringsKt.trim((CharSequence) recordValue2).toString()) == null) ? "" : string2;
        String strConvertLanguage = convertLanguage(getRecordValue(record, headerMap, "Languages"));
        String recordValue3 = getRecordValue(record, headerMap, "Name");
        String str3 = (recordValue3 == null || (string = StringsKt.trim((CharSequence) recordValue3).toString()) == null) ? "" : string;
        String strConvertCondition = convertCondition(getRecordValue(record, headerMap, "Condition"));
        String recordValue4 = getRecordValue(record, headerMap, "Scryfall ID");
        String string4 = recordValue4 != null ? StringsKt.trim((CharSequence) recordValue4).toString() : null;
        String recordValue5 = getRecordValue(record, headerMap, "Count");
        int iIntValue = (recordValue5 == null || (intOrNull3 = StringsKt.toIntOrNull(recordValue5)) == null) ? 0 : intOrNull3.intValue();
        String recordValue6 = getRecordValue(record, headerMap, "Foil count");
        int iIntValue2 = (recordValue6 == null || (intOrNull2 = StringsKt.toIntOrNull(recordValue6)) == null) ? 0 : intOrNull2.intValue();
        String recordValue7 = getRecordValue(record, headerMap, "Special foil count");
        int iIntValue3 = (recordValue7 == null || (intOrNull = StringsKt.toIntOrNull(recordValue7)) == null) ? 0 : intOrNull.intValue();
        ArrayList arrayList = new ArrayList();
        if (iIntValue > 0) {
            arrayList.add(new MTFullCard(null, false, null, null, null, str2, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, str3, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, string4, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1269809, 127, null));
        }
        if (iIntValue2 > 0) {
            arrayList.add(new MTFullCard(null, false, null, null, null, str2, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, "foil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, str3, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue2), null, string4, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1269809, 127, null));
        }
        if (iIntValue3 > 0) {
            arrayList.add(new MTFullCard(null, false, null, null, null, str2, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, "foil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, str3, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue3), null, string4, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1269809, 127, null));
        }
        return arrayList;
    }

    private final String decodeUtf7(String value) {
        if (!StringsKt.contains$default((CharSequence) value, (CharSequence) "+", false, 2, (Object) null)) {
            return value;
        }
        String strReplace$default = value;
        for (Map.Entry<String, String> entry : UTF7_DECODE_MAP.entrySet()) {
            strReplace$default = StringsKt.replace$default(strReplace$default, entry.getKey(), entry.getValue(), false, 4, (Object) null);
        }
        return strReplace$default;
    }

    private final int detectCsvFormat(String csvContent) {
        List<String> listLines = StringsKt.lines(csvContent);
        if (listLines.isEmpty()) {
            return 0;
        }
        String str = (!StringsKt.contains$default((CharSequence) CollectionsKt.first((List) listLines), (CharSequence) "\"sep=,\"", false, 2, (Object) null) || listLines.size() <= 1) ? (String) CollectionsKt.first((List) listLines) : listLines.get(1);
        if (StringsKt.contains((CharSequence) str, (CharSequence) "Qty", true) && StringsKt.contains((CharSequence) str, (CharSequence) "Product Name", true) && StringsKt.contains((CharSequence) str, (CharSequence) "Number", true) && !StringsKt.contains((CharSequence) str, (CharSequence) "Rarity", true)) {
            return 13;
        }
        if (StringsKt.contains((CharSequence) str, (CharSequence) "Set Name", true) && StringsKt.contains((CharSequence) str, (CharSequence) "Product Name", true) && StringsKt.contains((CharSequence) str, (CharSequence) "Rarity", true)) {
            return 14;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Name", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Set code", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Foil count", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Scryfall ID", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Multiverse ID", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "Folder Name", false, 2, (Object) null)) {
            return 10;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Folder Name", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Set Code", false, 2, (Object) null)) {
            return 1;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Count", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Tradelist Count", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Edition Code", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Printing Id", false, 2, (Object) null)) {
            return 12;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Count", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Tradelist Count", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Edition", false, 2, (Object) null)) {
            return 2;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "ManaBox ID", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Set code", false, 2, (Object) null)) {
            return 3;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Multiverse Id", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Edition Code", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Scryfall ID", false, 2, (Object) null)) {
            return 4;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) FirebaseAnalytics.Param.QUANTITY, false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "foil_quantity", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "card_name", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "set_code", false, 2, (Object) null)) {
            return 5;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Reg Qty", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Foil Qty", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Card", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Set", false, 2, (Object) null)) {
            return 6;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "QUANTITY", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "SETCODE", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "COLLECTOR NUMBER", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "FINISH", false, 2, (Object) null)) {
            return 7;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Scryfall ID", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Container Type", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Container Name", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Price (USD)", false, 2, (Object) null)) {
            return 8;
        }
        if ((StringsKt.contains((CharSequence) str, (CharSequence) "TCGplayer ProductId", true) || StringsKt.contains((CharSequence) str, (CharSequence) "TCGplayer SKU", true)) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Card Name", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Set Code", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "Foil/Etched", false, 2, (Object) null)) {
            return 11;
        }
        return new Regex("^\\d+,\".*\"$|^\\d+,[^,]+$").matches(str) ? 9 : 0;
    }

    private final Triple<List<String>, List<List<String>>, Integer> extractPreviewData(String csvContent) {
        List<String> listLines = StringsKt.lines(csvContent);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return new Triple<>(CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0);
        }
        List listDrop = CollectionsKt.drop(arrayList2, (StringsKt.contains$default((CharSequence) CollectionsKt.first((List) arrayList2), (CharSequence) "\"sep=,\"", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) CollectionsKt.first((List) arrayList2), (CharSequence) "sep=,", false, 2, (Object) null)) ? 1 : 0);
        if (listDrop.isEmpty()) {
            return new Triple<>(CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0);
        }
        List csvLine$default = parseCsvLine$default(this, (String) CollectionsKt.first(listDrop), (char) 0, 2, null);
        List listTake = CollectionsKt.take(CollectionsKt.drop(listDrop, 1), 3);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList3.add(parseCsvLine$default(this, (String) it.next(), (char) 0, 2, null));
        }
        return new Triple<>(csvLine$default, arrayList3, Integer.valueOf(listDrop.size() - 1));
    }

    private final Pair<Integer, Integer> findColumnByAlias(List<String> headers, String field) {
        List<String> list = COLUMN_ALIASES.get(field);
        if (list == null) {
            return new Pair<>(-1, 0);
        }
        List<String> list2 = headers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(new Regex("^\"|\"$").replace(StringsKt.trim((CharSequence) lowerCase).toString(), ""));
        }
        ArrayList arrayList2 = arrayList;
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            String lowerCase2 = it2.next().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            int iIndexOf = arrayList2.indexOf(lowerCase2);
            if (iIndexOf != -1) {
                return new Pair<>(Integer.valueOf(iIndexOf), 100);
            }
        }
        return new Pair<>(-1, 0);
    }

    private final String getRecordValue(CSVRecord record, Map<String, Integer> headerMap, String columnName) {
        String str;
        if (!headerMap.containsKey(columnName)) {
            return null;
        }
        try {
            Integer num = headerMap.get(columnName);
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            if (iIntValue >= record.size() || (str = record.get(iIntValue)) == null) {
                return null;
            }
            if (StringsKt.isBlank(str)) {
                return null;
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    private final String lookupSetCodeFromName(String setName) {
        Object next;
        Object next2;
        Object next3;
        String str = setName;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Iterator<T> it = CardSetsManager.INSTANCE.getCardSets().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String lowerCase2 = ((CardSet) next).getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase2, lowerCase)) {
                break;
            }
        }
        CardSet cardSet = (CardSet) next;
        if (cardSet != null) {
            return cardSet.getCode();
        }
        Iterator<T> it2 = CardSetsManager.INSTANCE.getCardSets().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            String lowerCase3 = ((CardSet) next2).getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            String str2 = lowerCase3;
            String str3 = lowerCase;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) str2, false, 2, (Object) null)) {
                break;
            }
        }
        CardSet cardSet2 = (CardSet) next2;
        if (cardSet2 != null) {
            return cardSet2.getCode();
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"edition", "set", "the", "of", "and", "&"});
        List listSplit$default = StringsKt.split$default((CharSequence) lowerCase, new String[]{" "}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (!listListOf.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
        Iterator<T> it3 = CardSetsManager.INSTANCE.getCardSets().iterator();
        while (true) {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
            String lowerCase4 = ((CardSet) next3).getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            List listSplit$default2 = StringsKt.split$default((CharSequence) lowerCase4, new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listSplit$default2) {
                if (!listListOf.contains((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList2, " ", null, null, 0, null, null, 62, null);
            String str4 = strJoinToString$default;
            if (StringsKt.contains$default((CharSequence) strJoinToString$default2, (CharSequence) str4, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str4, (CharSequence) strJoinToString$default2, false, 2, (Object) null)) {
                break;
            }
        }
        CardSet cardSet3 = (CardSet) next3;
        if (cardSet3 != null) {
            return cardSet3.getCode();
        }
        return null;
    }

    private final boolean needsUserMapping(ConfidenceLevel confidence, List<ColumnMapping> mappings) {
        Object next;
        int i;
        if (confidence == ConfidenceLevel.NONE) {
            return true;
        }
        List<ColumnMapping> list = mappings;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((ColumnMapping) next).getField(), "name")) {
                break;
            }
        }
        ColumnMapping columnMapping = (ColumnMapping) next;
        if (columnMapping != null && columnMapping.getDetectionMethod() == DetectionMethod.HEURISTIC && columnMapping.getConfidence() < 70) {
            return true;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (ColumnMapping columnMapping2 : list) {
                if ((CollectionsKt.listOf((Object[]) new String[]{"name", "set_code", "collector_number", FirebaseAnalytics.Param.QUANTITY}).contains(columnMapping2.getField()) && columnMapping2.getDetectionMethod() == DetectionMethod.HEURISTIC) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= 2;
    }

    private final String normalizeMalformedQuotedFields(String csvContent) {
        return new Regex(",\"\"([^\",]+)\"\"([^\"]*)(,|\r?\n|$)").replace(csvContent, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGCsvImporter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGCsvImporter.normalizeMalformedQuotedFields$lambda$0((kotlin.text.MatchResult) obj);
            }
        });
    }

    static final CharSequence normalizeMalformedQuotedFields$lambda$0(kotlin.text.MatchResult mr) {
        Intrinsics.checkNotNullParameter(mr, "mr");
        return ",\"\"\"" + ((Object) mr.getGroupValues().get(1)) + "\"\"" + ((Object) mr.getGroupValues().get(2)) + "\"" + ((Object) mr.getGroupValues().get(3));
    }

    private final ImportResult parseArchidekt(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.add(createCardFromArchidekt(next));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Archidekt CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseCardBinder(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.addAll(createCardsFromCardBinder(next));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Card Binder CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0364  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<MTFullCard> parseCardsWithMappings(List<? extends List<String>> dataRows, List<ColumnMapping> mappings) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object next6;
        Object next7;
        Object next8;
        Object next9;
        String string;
        Iterator<? extends List<String>> it;
        String str;
        String strLookupSetCodeFromName;
        String string2;
        Integer intOrNull;
        Integer intOrNull2;
        ArrayList arrayList = new ArrayList();
        List<ColumnMapping> list = mappings;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((ColumnMapping) next).getField(), "name")) {
                break;
            }
        }
        ColumnMapping columnMapping = (ColumnMapping) next;
        int columnIndex = columnMapping != null ? columnMapping.getColumnIndex() : -1;
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it3.next();
            if (Intrinsics.areEqual(((ColumnMapping) next2).getField(), FirebaseAnalytics.Param.QUANTITY)) {
                break;
            }
        }
        ColumnMapping columnMapping2 = (ColumnMapping) next2;
        int columnIndex2 = columnMapping2 != null ? columnMapping2.getColumnIndex() : -1;
        Iterator<T> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it4.next();
            if (Intrinsics.areEqual(((ColumnMapping) next3).getField(), "foil_quantity")) {
                break;
            }
        }
        ColumnMapping columnMapping3 = (ColumnMapping) next3;
        int columnIndex3 = columnMapping3 != null ? columnMapping3.getColumnIndex() : -1;
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it5.next();
            if (Intrinsics.areEqual(((ColumnMapping) next4).getField(), "set_code")) {
                break;
            }
        }
        ColumnMapping columnMapping4 = (ColumnMapping) next4;
        int columnIndex4 = columnMapping4 != null ? columnMapping4.getColumnIndex() : -1;
        Iterator<T> it6 = list.iterator();
        while (true) {
            if (!it6.hasNext()) {
                next5 = null;
                break;
            }
            next5 = it6.next();
            if (Intrinsics.areEqual(((ColumnMapping) next5).getField(), "set_name")) {
                break;
            }
        }
        ColumnMapping columnMapping5 = (ColumnMapping) next5;
        int columnIndex5 = columnMapping5 != null ? columnMapping5.getColumnIndex() : -1;
        Iterator<T> it7 = list.iterator();
        while (true) {
            if (!it7.hasNext()) {
                next6 = null;
                break;
            }
            next6 = it7.next();
            if (Intrinsics.areEqual(((ColumnMapping) next6).getField(), "collector_number")) {
                break;
            }
        }
        ColumnMapping columnMapping6 = (ColumnMapping) next6;
        int columnIndex6 = columnMapping6 != null ? columnMapping6.getColumnIndex() : -1;
        Iterator<T> it8 = list.iterator();
        while (true) {
            if (!it8.hasNext()) {
                next7 = null;
                break;
            }
            next7 = it8.next();
            if (Intrinsics.areEqual(((ColumnMapping) next7).getField(), "finish")) {
                break;
            }
        }
        ColumnMapping columnMapping7 = (ColumnMapping) next7;
        int columnIndex7 = columnMapping7 != null ? columnMapping7.getColumnIndex() : -1;
        Iterator<T> it9 = list.iterator();
        while (true) {
            if (!it9.hasNext()) {
                next8 = null;
                break;
            }
            next8 = it9.next();
            if (Intrinsics.areEqual(((ColumnMapping) next8).getField(), "condition")) {
                break;
            }
        }
        ColumnMapping columnMapping8 = (ColumnMapping) next8;
        int columnIndex8 = columnMapping8 != null ? columnMapping8.getColumnIndex() : -1;
        Iterator<T> it10 = list.iterator();
        while (true) {
            if (!it10.hasNext()) {
                next9 = null;
                break;
            }
            next9 = it10.next();
            if (Intrinsics.areEqual(((ColumnMapping) next9).getField(), "language")) {
                break;
            }
        }
        ColumnMapping columnMapping9 = (ColumnMapping) next9;
        int columnIndex9 = columnMapping9 != null ? columnMapping9.getColumnIndex() : -1;
        Iterator<? extends List<String>> it11 = dataRows.iterator();
        while (it11.hasNext()) {
            List<String> next10 = it11.next();
            if (!next10.isEmpty()) {
                List<String> list2 = next10;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it12 = list2.iterator();
                    while (true) {
                        if (!it12.hasNext()) {
                            break;
                        }
                        if (!StringsKt.isBlank((String) it12.next())) {
                            String str2 = (String) CollectionsKt.getOrNull(next10, columnIndex);
                            if (str2 != null && (string = StringsKt.trim((CharSequence) str2).toString()) != null) {
                                String strCleanCardName = cleanCardName(string);
                                if (!StringsKt.isBlank(strCleanCardName) && strCleanCardName.length() >= 2) {
                                    String str3 = (String) CollectionsKt.getOrNull(next10, columnIndex2);
                                    int iIntValue = (str3 == null || (intOrNull2 = StringsKt.toIntOrNull(str3)) == null) ? 1 : intOrNull2.intValue();
                                    String str4 = (String) CollectionsKt.getOrNull(next10, columnIndex3);
                                    int iIntValue2 = (str4 == null || (intOrNull = StringsKt.toIntOrNull(str4)) == null) ? 0 : intOrNull.intValue();
                                    String str5 = (String) CollectionsKt.getOrNull(next10, columnIndex4);
                                    String string3 = str5 != null ? StringsKt.trim((CharSequence) str5).toString() : null;
                                    String str6 = (String) CollectionsKt.getOrNull(next10, columnIndex5);
                                    String string4 = str6 != null ? StringsKt.trim((CharSequence) str6).toString() : null;
                                    String str7 = string3;
                                    if (str7 == null || StringsKt.isBlank(str7)) {
                                        it = it11;
                                    } else {
                                        it = it11;
                                        int length = string3.length();
                                        if (2 <= length && length < 6) {
                                            strLookupSetCodeFromName = string3.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(strLookupSetCodeFromName, "toLowerCase(...)");
                                        }
                                        str = strLookupSetCodeFromName;
                                        String str8 = (String) CollectionsKt.getOrNull(next10, columnIndex6);
                                        String str9 = (str8 == null || (string2 = StringsKt.trim((CharSequence) str8).toString()) == null || StringsKt.isBlank(string2)) ? null : string2;
                                        String strConvertFinish = convertFinish((String) CollectionsKt.getOrNull(next10, columnIndex7));
                                        String strConvertCondition = convertCondition((String) CollectionsKt.getOrNull(next10, columnIndex8));
                                        String strConvertLanguage = convertLanguage((String) CollectionsKt.getOrNull(next10, columnIndex9));
                                        if (iIntValue > 0) {
                                            arrayList.add(new MTFullCard(null, false, null, null, null, str9, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, strConvertFinish, null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, strCleanCardName, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                                        }
                                        if (iIntValue2 > 0) {
                                            arrayList.add(new MTFullCard(null, false, null, null, null, str9, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, "foil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, strCleanCardName, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue2), null, null, str, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                                        }
                                    }
                                    String str10 = string4;
                                    String str11 = str10;
                                    if (str11 == null || StringsKt.isBlank(str11)) {
                                        str = null;
                                        String str82 = (String) CollectionsKt.getOrNull(next10, columnIndex6);
                                        if (str82 == null) {
                                            String strConvertFinish2 = convertFinish((String) CollectionsKt.getOrNull(next10, columnIndex7));
                                            String strConvertCondition2 = convertCondition((String) CollectionsKt.getOrNull(next10, columnIndex8));
                                            String strConvertLanguage2 = convertLanguage((String) CollectionsKt.getOrNull(next10, columnIndex9));
                                            if (iIntValue > 0) {
                                            }
                                            if (iIntValue2 > 0) {
                                            }
                                        }
                                    } else {
                                        strLookupSetCodeFromName = lookupSetCodeFromName(str10);
                                        str = strLookupSetCodeFromName;
                                        String str822 = (String) CollectionsKt.getOrNull(next10, columnIndex6);
                                        if (str822 == null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                it = it11;
                it11 = it;
            }
        }
        return arrayList;
    }

    private final List<String> parseCsvLine(String line, char delimiter) {
        int i;
        String strDecodeUtf7 = decodeUtf7(line);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (i2 < strDecodeUtf7.length()) {
            char cCharAt = strDecodeUtf7.charAt(i2);
            if (cCharAt == '\"') {
                if (z && (i = i2 + 1) < strDecodeUtf7.length() && strDecodeUtf7.charAt(i) == '\"') {
                    sb.append('\"');
                    i2 = i;
                } else {
                    z = !z;
                }
            } else if (cCharAt != delimiter || z) {
                sb.append(cCharAt);
            } else {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                arrayList.add(new Regex("^\"|\"$").replace(StringsKt.trim((CharSequence) string).toString(), ""));
                sb = new StringBuilder();
            }
            i2++;
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        arrayList.add(new Regex("^\"|\"$").replace(StringsKt.trim((CharSequence) string2).toString(), ""));
        return arrayList;
    }

    static /* synthetic */ List parseCsvLine$default(MTGCsvImporter mTGCsvImporter, String str, char c, int i, Object obj) {
        if ((i & 2) != 0) {
            c = AbstractJsonLexerKt.COMMA;
        }
        return mTGCsvImporter.parseCsvLine(str, c);
    }

    private final ImportResult parseDeckBox(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            Map<String, Integer> headerMap = cSVParser.getHeaderMap();
            Iterator<CSVRecord> it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(headerMap);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.add(createCardFromDeckBox(next, headerMap));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing DeckBox CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseDecked(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.addAll(createCardsFromDecked(next));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Decked CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseDelverLens(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            Map<String, Integer> headerMap = cSVParser.getHeaderMap();
            Iterator<CSVRecord> it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(headerMap);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.add(createCardFromDelverLens(next, headerMap));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Delver Lens CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseDragonShield(String csvContent) {
        String str;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    str = next.get("Folder Name");
                    if (str == null) {
                        str = "Unknown Folder";
                    }
                    Intrinsics.checkNotNull(next);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    MTFullCard mTFullCardCreateCardFromDragonShield = createCardFromDragonShield(next);
                    if (!linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, new ArrayList());
                    }
                    List list = (List) linkedHashMap.get(str);
                    if (list != null) {
                        list.add(mTFullCardCreateCardFromDragonShield);
                    }
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList2.add(new MTCardContainer(null, null, null, 0, (String) entry.getKey(), 2, "Box", null, (List) entry.getValue(), null, null, null, null, null, null, null, 65159, null));
            }
            return new ImportResult(arrayList2, arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Dragon Shield CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseGeneric(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    if (next.size() != 2) {
                        arrayList.add("Skipping invalid line: expected 2 columns, got " + next.size());
                    } else {
                        Intrinsics.checkNotNull(next);
                        try {
                            arrayList2.add(createCardFromGeneric(next));
                        } catch (Exception e) {
                            e = e;
                            arrayList.add("Error parsing card: " + e.getMessage());
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Generic CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0269 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<List<ColumnMapping>, List<MTFullCard>> parseGenericWithDetection(String csvContent, List<String> headers, List<? extends List<String>> dataRows) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        String str;
        boolean z4;
        String str2;
        boolean z5;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z6 = false;
        String str3 = "name";
        String str4 = FirebaseAnalytics.Param.QUANTITY;
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"name", FirebaseAnalytics.Param.QUANTITY, "foil_quantity", "set_code", "set_name", "collector_number", "finish", "condition", "language", "container"})) {
            Pair<Integer, Integer> pairFindColumnByAlias = findColumnByAlias(headers, str5);
            int iIntValue = pairFindColumnByAlias.component1().intValue();
            int iIntValue2 = pairFindColumnByAlias.component2().intValue();
            if (iIntValue >= 0) {
                arrayList2.add(new ColumnMapping(str5, iIntValue, headers.get(iIntValue), iIntValue2, DetectionMethod.ALIAS));
                linkedHashSet.add(Integer.valueOf(iIntValue));
            }
        }
        ArrayList arrayList3 = arrayList2;
        boolean z7 = arrayList3 instanceof Collection;
        if (z7 && arrayList3.isEmpty()) {
            z = false;
        } else {
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ColumnMapping) it.next()).getField(), "name")) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (!z7 || !arrayList3.isEmpty()) {
            Iterator it2 = arrayList3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z6 = false;
                    break;
                }
                if (Intrinsics.areEqual(((ColumnMapping) it2.next()).getField(), "set_code")) {
                    z6 = true;
                    break;
                }
            }
        }
        if (z7 && arrayList3.isEmpty()) {
            z2 = false;
        } else {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                if (Intrinsics.areEqual(((ColumnMapping) it3.next()).getField(), "collector_number")) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z7 && arrayList3.isEmpty()) {
            z3 = false;
        } else {
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                if (Intrinsics.areEqual(((ColumnMapping) it4.next()).getField(), FirebaseAnalytics.Param.QUANTITY)) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        if (!z || !z6 || !z2 || !z3) {
            int size = headers.size();
            int i2 = 0;
            while (i2 < size) {
                boolean z8 = z6;
                if (linkedHashSet.contains(Integer.valueOf(i2))) {
                    i = i2;
                    str = str3;
                    z4 = z2;
                    str2 = str4;
                    z5 = z3;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator<T> it5 = dataRows.iterator();
                    while (it5.hasNext()) {
                        boolean z9 = z2;
                        String str6 = (String) CollectionsKt.getOrNull((List) it5.next(), i2);
                        if (str6 != null) {
                            arrayList4.add(str6);
                        }
                        z2 = z9;
                    }
                    z4 = z2;
                    ArrayList arrayList5 = arrayList4;
                    Map<String, Pair<Integer, String>> mapAnalyzeColumnContent = analyzeColumnContent(arrayList5);
                    z5 = z3;
                    ArrayList<String> arrayList6 = new ArrayList();
                    if (!z) {
                        arrayList6.add(str3);
                    }
                    if (!z5) {
                        arrayList6.add(str4);
                    }
                    if (!z8) {
                        arrayList6.add("set_code");
                    }
                    if (!z4) {
                        arrayList6.add("collector_number");
                    }
                    for (String str7 : arrayList6) {
                        str = str3;
                        if (!z7 || !arrayList3.isEmpty()) {
                            Iterator it6 = arrayList3.iterator();
                            while (it6.hasNext()) {
                                str2 = str4;
                                if (Intrinsics.areEqual(((ColumnMapping) it6.next()).getField(), str7)) {
                                    break;
                                }
                                str4 = str2;
                            }
                        }
                        str2 = str4;
                        Pair<Integer, String> pair = mapAnalyzeColumnContent.get(str7);
                        if (pair == null) {
                            continue;
                        } else {
                            int iIntValue3 = pair.component1().intValue();
                            Map<String, Pair<Integer, String>> map = mapAnalyzeColumnContent;
                            if (iIntValue3 >= 50) {
                                if (Intrinsics.areEqual(str7, "set_code")) {
                                    Pair<Integer, Integer> pairValidateSetCodes = validateSetCodes(arrayList5);
                                    int iIntValue4 = pairValidateSetCodes.component1().intValue();
                                    if (pairValidateSetCodes.component2().intValue() > 0) {
                                        arrayList = arrayList5;
                                        if (iIntValue4 >= 3) {
                                            iIntValue3 = Math.min(95, iIntValue3 + 30);
                                        } else {
                                            iIntValue3 = iIntValue4 >= 1 ? Math.min(80, iIntValue3 + 10) : Math.max(30, iIntValue3 - 20);
                                            if (iIntValue3 >= 50) {
                                                i = i2;
                                                arrayList2.add(new ColumnMapping(str7, i, headers.get(i2), iIntValue3, DetectionMethod.HEURISTIC));
                                                linkedHashSet.add(Integer.valueOf(i));
                                                break;
                                            }
                                            mapAnalyzeColumnContent = map;
                                            arrayList5 = arrayList;
                                        }
                                    }
                                    if (iIntValue3 >= 50) {
                                    }
                                }
                                arrayList = arrayList5;
                                if (iIntValue3 >= 50) {
                                }
                            } else {
                                mapAnalyzeColumnContent = map;
                            }
                        }
                        str3 = str;
                        str4 = str2;
                    }
                    i = i2;
                    str = str3;
                    str2 = str4;
                }
                i2 = i + 1;
                z6 = z8;
                z2 = z4;
                z3 = z5;
                str3 = str;
                str4 = str2;
            }
        }
        return new Pair<>(arrayList2, parseCardsWithMappings(dataRows, arrayList2));
    }

    private final ImportResult parseManaBox(String csvContent) {
        Map<String, Integer> headerMap;
        Iterator<CSVRecord> it;
        List list;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            headerMap = cSVParser.getHeaderMap();
            it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        } catch (Exception e) {
            arrayList.add("Error parsing ManaBox CSV: " + e.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                break;
            }
            CSVRecord next = it.next();
            try {
                Intrinsics.checkNotNull(next);
                Intrinsics.checkNotNull(headerMap);
                String recordValue = getRecordValue(next, headerMap, "Binder Name");
                if (recordValue == null) {
                    recordValue = "ManaBox";
                }
                String recordValue2 = getRecordValue(next, headerMap, "Binder Type");
                if (recordValue2 == null) {
                    recordValue2 = "list";
                }
                MTFullCard mTFullCardCreateCardFromManaBox = createCardFromManaBox(next);
                String lowerCase = recordValue2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase, "binder")) {
                    Intrinsics.areEqual(lowerCase, "box");
                    i = 2;
                }
                if (!linkedHashMap.containsKey(recordValue)) {
                    linkedHashMap.put(recordValue, new Pair(Integer.valueOf(i), new ArrayList()));
                }
                Pair pair = (Pair) linkedHashMap.get(recordValue);
                if (pair != null && (list = (List) pair.getSecond()) != null) {
                    list.add(mTFullCardCreateCardFromManaBox);
                }
            } catch (Exception e2) {
                arrayList.add("Error parsing card: " + e2.getMessage());
            }
            arrayList.add("Error parsing ManaBox CSV: " + e.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            Pair pair2 = (Pair) entry.getValue();
            int iIntValue = ((Number) pair2.component1()).intValue();
            arrayList2.add(new MTCardContainer(null, null, null, 0, str, Integer.valueOf(iIntValue), iIntValue != 1 ? iIntValue != 2 ? "List" : "Box" : "Binder", null, (List) pair2.component2(), null, null, null, null, null, null, null, 65159, null));
        }
        return new ImportResult(arrayList2, arrayList);
    }

    private final ImportResult parseMoxfield(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.add(createCardFromMoxfield(next));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing Moxfield CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[Catch: Exception -> 0x00a3, TryCatch #1 {Exception -> 0x00a3, blocks: (B:7:0x003e, B:10:0x004e, B:14:0x0059, B:24:0x0087, B:26:0x008d, B:27:0x0097, B:29:0x009f, B:22:0x007f), top: B:44:0x003e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ImportResult parseMythicTools(String csvContent) {
        String recordValue;
        String str;
        MTFullCard mTFullCardCreateCardFromMythicTools;
        String lowerCase;
        int iHashCode;
        List list;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            Map<String, Integer> headerMap = cSVParser.getHeaderMap();
            Iterator<CSVRecord> it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(headerMap);
                    recordValue = getRecordValue(next, headerMap, "Container Name");
                    if (recordValue == null) {
                        recordValue = "Unknown Container";
                    }
                    String recordValue2 = getRecordValue(next, headerMap, "Container Type");
                    str = "box";
                    if (recordValue2 == null) {
                        recordValue2 = "box";
                    }
                    mTFullCardCreateCardFromMythicTools = createCardFromMythicTools(next, headerMap);
                    lowerCase = recordValue2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    iHashCode = lowerCase.hashCode();
                } catch (Exception e) {
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
                if (iHashCode == -1388964438) {
                    str = "binder";
                } else if (iHashCode != 97739) {
                    if (iHashCode != 3322014) {
                        if (!linkedHashMap.containsKey(recordValue)) {
                            linkedHashMap.put(recordValue, new ArrayList());
                        }
                        list = (List) linkedHashMap.get(recordValue);
                        if (list == null) {
                            list.add(mTFullCardCreateCardFromMythicTools);
                        }
                    } else {
                        str = "list";
                    }
                }
                lowerCase.equals(str);
                if (!linkedHashMap.containsKey(recordValue)) {
                }
                list = (List) linkedHashMap.get(recordValue);
                if (list == null) {
                }
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList2.add(new MTCardContainer(null, null, null, 0, (String) entry.getKey(), 2, "Box", null, (List) entry.getValue(), null, null, null, null, null, null, null, 65159, null));
            }
            return new ImportResult(arrayList2, arrayList);
        } catch (Exception e2) {
            arrayList.add("Error parsing Mythic Tools CSV: " + e2.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5 A[Catch: Exception -> 0x0163, TryCatch #1 {Exception -> 0x0163, blocks: (B:7:0x003e, B:9:0x004c, B:12:0x0055, B:14:0x005e, B:16:0x0067, B:18:0x006f, B:32:0x0097, B:34:0x009d, B:36:0x00a5, B:37:0x00af, B:21:0x0076, B:23:0x007e, B:27:0x0087, B:29:0x008f), top: B:48:0x003e, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ImportResult parseTCGPlayerDetailed(String csvContent) {
        String recordValue;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            Map<String, Integer> headerMap = cSVParser.getHeaderMap();
            Iterator<CSVRecord> it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(headerMap);
                    recordValue = getRecordValue(next, headerMap, "Product Name");
                } catch (Exception e) {
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
                if (recordValue != null || (recordValue = getRecordValue(next, headerMap, "Name")) != null) {
                    String recordValue2 = getRecordValue(next, headerMap, "Set Name");
                    String strLookupSetCodeFromName = recordValue2 != null ? lookupSetCodeFromName(recordValue2) : null;
                    String recordValue3 = getRecordValue(next, headerMap, "Total Quantity");
                    if (recordValue3 == null || (intOrNull = StringsKt.toIntOrNull(recordValue3)) == null) {
                        String recordValue4 = getRecordValue(next, headerMap, "Quantity");
                        Integer intOrNull = recordValue4 != null ? StringsKt.toIntOrNull(recordValue4) : null;
                        if (intOrNull != null) {
                            String recordValue5 = getRecordValue(next, headerMap, "Number");
                            arrayList2.add(new MTFullCard(null, false, null, null, null, recordValue5 != null ? StringsKt.trim((CharSequence) recordValue5).toString() : null, null, null, null, convertCondition(getRecordValue(next, headerMap, "Condition")), null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, cleanTcgPlayerCardName(recordValue), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, strLookupSetCodeFromName, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                        } else {
                            String recordValue6 = getRecordValue(next, headerMap, "Qty");
                            intOrNull = recordValue6 != null ? StringsKt.toIntOrNull(recordValue6) : null;
                            int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
                            String recordValue52 = getRecordValue(next, headerMap, "Number");
                            arrayList2.add(new MTFullCard(null, false, null, null, null, recordValue52 != null ? StringsKt.trim((CharSequence) recordValue52).toString() : null, null, null, null, convertCondition(getRecordValue(next, headerMap, "Condition")), null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, cleanTcgPlayerCardName(recordValue), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, strLookupSetCodeFromName, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                        }
                    } else {
                        String recordValue522 = getRecordValue(next, headerMap, "Number");
                        arrayList2.add(new MTFullCard(null, false, null, null, null, recordValue522 != null ? StringsKt.trim((CharSequence) recordValue522).toString() : null, null, null, null, convertCondition(getRecordValue(next, headerMap, "Condition")), null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, cleanTcgPlayerCardName(recordValue), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, strLookupSetCodeFromName, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                    }
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "TCGPlayer Import", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e2) {
            arrayList.add("Error parsing TCGPlayer Detailed CSV: " + e2.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[Catch: Exception -> 0x013b, TryCatch #0 {Exception -> 0x013b, blocks: (B:7:0x003e, B:9:0x004c, B:12:0x0055, B:14:0x005e, B:16:0x0064, B:24:0x007b, B:26:0x0083, B:27:0x008d, B:17:0x0069, B:19:0x0071), top: B:36:0x003e, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ImportResult parseTCGPlayerSimple(String csvContent) {
        String recordValue;
        Integer intOrNull;
        int iIntValue;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            Map<String, Integer> headerMap = cSVParser.getHeaderMap();
            Iterator<CSVRecord> it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(headerMap);
                    recordValue = getRecordValue(next, headerMap, "Product Name");
                } catch (Exception e) {
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
                if (recordValue != null || (recordValue = getRecordValue(next, headerMap, "Name")) != null) {
                    String recordValue2 = getRecordValue(next, headerMap, "Qty");
                    if (recordValue2 == null || (intOrNull = StringsKt.toIntOrNull(recordValue2)) == null) {
                        String recordValue3 = getRecordValue(next, headerMap, "Quantity");
                        intOrNull = recordValue3 != null ? StringsKt.toIntOrNull(recordValue3) : null;
                        if (intOrNull != null) {
                            iIntValue = intOrNull.intValue();
                            String recordValue4 = getRecordValue(next, headerMap, "Number");
                            arrayList2.add(new MTFullCard(null, false, null, null, null, recordValue4 != null ? StringsKt.trim((CharSequence) recordValue4).toString() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, cleanTcgPlayerCardName(recordValue), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                        } else {
                            iIntValue = 1;
                            String recordValue42 = getRecordValue(next, headerMap, "Number");
                            arrayList2.add(new MTFullCard(null, false, null, null, null, recordValue42 != null ? StringsKt.trim((CharSequence) recordValue42).toString() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, cleanTcgPlayerCardName(recordValue), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                        }
                    } else {
                        iIntValue = intOrNull.intValue();
                        String recordValue422 = getRecordValue(next, headerMap, "Number");
                        arrayList2.add(new MTFullCard(null, false, null, null, null, recordValue422 != null ? StringsKt.trim((CharSequence) recordValue422).toString() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "nonfoil", null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, false, cleanTcgPlayerCardName(recordValue), null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue), null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                    }
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "TCGPlayer Import", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e2) {
            arrayList.add("Error parsing TCGPlayer Simple CSV: " + e2.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseTopDecked(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<CSVRecord> it = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent)).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.add(createCardFromTopDecked(next));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing TopDecked CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final ImportResult parseUrzaGatherer(String csvContent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            CSVParser cSVParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new StringReader(csvContent));
            Map<String, Integer> headerMap = cSVParser.getHeaderMap();
            Iterator<CSVRecord> it = cSVParser.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CSVRecord next = it.next();
                try {
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(headerMap);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    arrayList2.addAll(createCardsFromUrzaGatherer(next, headerMap));
                } catch (Exception e2) {
                    e = e2;
                    arrayList.add("Error parsing card: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "Bulk", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e3) {
            arrayList.add("Error parsing UrzaGatherer CSV: " + e3.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    private final Pair<Integer, Integer> validateSetCodes(List<String> codes) {
        List<String> list = codes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(StringsKt.trim((CharSequence) lowerCase).toString());
        }
        List<String> listTake = CollectionsKt.take(CollectionsKt.distinct(arrayList), 5);
        int i = 0;
        if (listTake.isEmpty()) {
            return new Pair<>(0, 0);
        }
        for (String str : listTake) {
            List<CardSet> cardSets = CardSetsManager.INSTANCE.getCardSets();
            if (!(cardSets instanceof Collection) || !cardSets.isEmpty()) {
                Iterator<T> it2 = cardSets.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (StringsKt.equals(((CardSet) it2.next()).getCode(), str, true)) {
                        i++;
                        break;
                    }
                }
            }
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(listTake.size()));
    }

    public final ImportResult importFromCsv(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        try {
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return importFromCsv(text);
            } finally {
            }
        } catch (Exception e) {
            return new ImportResult(CollectionsKt.emptyList(), CollectionsKt.listOf("Error reading input stream: " + e.getMessage()));
        }
    }

    public final ImportResult importFromCsv(String csvContent) {
        Intrinsics.checkNotNullParameter(csvContent, "csvContent");
        ArrayList arrayList = new ArrayList();
        try {
            if (StringsKt.isBlank(csvContent)) {
                return new ImportResult(CollectionsKt.emptyList(), CollectionsKt.listOf("CSV content is empty"));
            }
            int iDetectCsvFormat = detectCsvFormat(csvContent);
            if (iDetectCsvFormat == 0) {
                return new ImportResult(CollectionsKt.emptyList(), CollectionsKt.listOf("Unknown CSV format"));
            }
            String strCleanCsvContent = cleanCsvContent(csvContent, iDetectCsvFormat);
            switch (iDetectCsvFormat) {
                case 1:
                    return parseDragonShield(strCleanCsvContent);
                case 2:
                    return parseMoxfield(strCleanCsvContent);
                case 3:
                    return parseManaBox(strCleanCsvContent);
                case 4:
                    return parseArchidekt(strCleanCsvContent);
                case 5:
                    return parseCardBinder(strCleanCsvContent);
                case 6:
                    return parseDecked(strCleanCsvContent);
                case 7:
                    return parseTopDecked(strCleanCsvContent);
                case 8:
                    return parseMythicTools(strCleanCsvContent);
                case 9:
                    return parseGeneric(strCleanCsvContent);
                case 10:
                    return parseUrzaGatherer(strCleanCsvContent);
                case 11:
                    return parseDelverLens(strCleanCsvContent);
                case 12:
                    return parseDeckBox(strCleanCsvContent);
                case 13:
                    return parseTCGPlayerSimple(strCleanCsvContent);
                case 14:
                    return parseTCGPlayerDetailed(strCleanCsvContent);
                default:
                    return new ImportResult(CollectionsKt.emptyList(), CollectionsKt.listOf("Unsupported CSV format"));
            }
        } catch (Exception e) {
            arrayList.add("Error parsing CSV: " + e.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }

    public final CsvParseResult importFromCsvWithDetection(String csvContent) {
        Intrinsics.checkNotNullParameter(csvContent, "csvContent");
        ArrayList arrayList = new ArrayList();
        String str = csvContent;
        if (StringsKt.isBlank(str)) {
            return new CsvParseResult(CollectionsKt.emptyList(), CollectionsKt.listOf("CSV content is empty"), "unknown", ConfidenceLevel.NONE, CollectionsKt.emptyList(), true, CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0);
        }
        Triple<List<String>, List<List<String>>, Integer> tripleExtractPreviewData = extractPreviewData(csvContent);
        List<String> listComponent1 = tripleExtractPreviewData.component1();
        List<List<String>> listComponent2 = tripleExtractPreviewData.component2();
        int iIntValue = tripleExtractPreviewData.component3().intValue();
        int iDetectCsvFormat = detectCsvFormat(csvContent);
        String str2 = FORMAT_NAMES.get(Integer.valueOf(iDetectCsvFormat));
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str4 = str2 == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : str2;
        String strCleanCsvContent = cleanCsvContent(csvContent, iDetectCsvFormat);
        if (iDetectCsvFormat != 0 && iDetectCsvFormat != 9) {
            ImportResult importResultImportFromCsv = importFromCsv(csvContent);
            List<ColumnMapping> listBuildMappingsForKnownFormat = buildMappingsForKnownFormat(iDetectCsvFormat, listComponent1);
            return new CsvParseResult(importResultImportFromCsv.getContainers(), importResultImportFromCsv.getErrors(), str4, calculateConfidence(listBuildMappingsForKnownFormat), listBuildMappingsForKnownFormat, false, listComponent1, listComponent2, iIntValue);
        }
        List<String> listLines = StringsKt.lines(str);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listLines) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        List listDrop = CollectionsKt.drop(arrayList2, 1);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDrop, 10));
        Iterator it = listDrop.iterator();
        while (it.hasNext()) {
            arrayList3.add(parseCsvLine$default(this, (String) it.next(), (char) 0, 2, null));
        }
        Pair<List<ColumnMapping>, List<MTFullCard>> genericWithDetection = parseGenericWithDetection(strCleanCsvContent, listComponent1, arrayList3);
        List<ColumnMapping> listComponent12 = genericWithDetection.component1();
        List<MTFullCard> listComponent22 = genericWithDetection.component2();
        ConfidenceLevel confidenceLevelCalculateConfidence = calculateConfidence(listComponent12);
        boolean zNeedsUserMapping = needsUserMapping(confidenceLevelCalculateConfidence, listComponent12);
        List listListOf = !listComponent22.isEmpty() ? CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "CSV Import", 2, "Box", null, listComponent22, null, null, null, null, null, null, null, 65159, null)) : CollectionsKt.emptyList();
        if (confidenceLevelCalculateConfidence != ConfidenceLevel.NONE) {
            str3 = "Generic (Auto-detected)";
        }
        return new CsvParseResult(listListOf, arrayList, str3, confidenceLevelCalculateConfidence, listComponent12, zNeedsUserMapping, listComponent1, listComponent2, iIntValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01de A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e4 A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0173 A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019c A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a4 A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bd A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c5 A[Catch: Exception -> 0x0293, TryCatch #1 {Exception -> 0x0293, blocks: (B:20:0x008d, B:22:0x0097, B:24:0x009e, B:27:0x00a8, B:28:0x00ac, B:30:0x00b2, B:32:0x00c0, B:34:0x00cb, B:37:0x00d3, B:39:0x00db, B:42:0x00e8, B:44:0x00f6, B:47:0x00fd, B:49:0x0107, B:52:0x010f, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:63:0x0135, B:65:0x013d, B:68:0x014b, B:75:0x0158, B:77:0x0169, B:79:0x0173, B:82:0x017b, B:84:0x0183, B:86:0x0192, B:88:0x019c, B:91:0x01a4, B:93:0x01b1, B:95:0x01bd, B:98:0x01c5, B:100:0x01d4, B:102:0x01de, B:104:0x01e4, B:106:0x01f1), top: B:117:0x008d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImportResult parseWithUserMappings(String csvContent, Map<String, Integer> userMappings) {
        String str;
        String string;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(csvContent, "csvContent");
        Intrinsics.checkNotNullParameter(userMappings, "userMappings");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            List<String> listLines = StringsKt.lines(csvContent);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : listLines) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = arrayList3;
            Iterator it = CollectionsKt.drop(arrayList4, ((StringsKt.contains$default((CharSequence) CollectionsKt.first((List) arrayList4), (CharSequence) "\"sep=,\"", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) CollectionsKt.first((List) arrayList4), (CharSequence) "sep=,", false, 2, (Object) null)) ? 1 : 0) + 1).iterator();
            while (it.hasNext()) {
                try {
                    List csvLine$default = parseCsvLine$default(this, (String) it.next(), (char) 0, 2, null);
                    if (!csvLine$default.isEmpty()) {
                        List list = csvLine$default;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                if (!StringsKt.isBlank((String) it2.next())) {
                                    Integer num = userMappings.get("name");
                                    int iIntValue = num != null ? num.intValue() : -1;
                                    if (iIntValue >= 0 && (str = (String) CollectionsKt.getOrNull(csvLine$default, iIntValue)) != null && (string = StringsKt.trim((CharSequence) str).toString()) != null) {
                                        String strCleanCardName = cleanCardName(string);
                                        if (!StringsKt.isBlank(strCleanCardName) && strCleanCardName.length() >= 2) {
                                            Integer num2 = userMappings.get(FirebaseAnalytics.Param.QUANTITY);
                                            int iIntValue2 = num2 != null ? num2.intValue() : -1;
                                            int iIntValue3 = (iIntValue2 < 0 || (str5 = (String) CollectionsKt.getOrNull(csvLine$default, iIntValue2)) == null || (intOrNull = StringsKt.toIntOrNull(str5)) == null) ? 1 : intOrNull.intValue();
                                            Integer num3 = userMappings.get("set_code");
                                            int iIntValue4 = num3 != null ? num3.intValue() : -1;
                                            String string2 = (iIntValue4 < 0 || (str4 = (String) CollectionsKt.getOrNull(csvLine$default, iIntValue4)) == null) ? null : StringsKt.trim((CharSequence) str4).toString();
                                            if (string2 == null) {
                                                str2 = null;
                                                Integer num4 = userMappings.get("collector_number");
                                                int iIntValue5 = num4 == null ? num4.intValue() : -1;
                                                String string3 = (iIntValue5 >= 0 || (str3 = (String) CollectionsKt.getOrNull(csvLine$default, iIntValue5)) == null) ? null : StringsKt.trim((CharSequence) str3).toString();
                                                Integer num5 = userMappings.get("language");
                                                int iIntValue6 = num5 == null ? num5.intValue() : -1;
                                                String strConvertLanguage = iIntValue6 < 0 ? convertLanguage((String) CollectionsKt.getOrNull(csvLine$default, iIntValue6)) : "en";
                                                Integer num6 = userMappings.get("condition");
                                                int iIntValue7 = num6 == null ? num6.intValue() : -1;
                                                String strConvertCondition = iIntValue7 < 0 ? convertCondition((String) CollectionsKt.getOrNull(csvLine$default, iIntValue7)) : null;
                                                Integer num7 = userMappings.get("finish");
                                                int iIntValue8 = num7 != null ? num7.intValue() : -1;
                                                arrayList2.add(new MTFullCard(null, false, null, null, null, string3, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, iIntValue8 < 0 ? convertFinish((String) CollectionsKt.getOrNull(csvLine$default, iIntValue8)) : "nonfoil", null, null, null, null, null, null, null, strConvertLanguage, null, null, null, null, null, null, null, false, strCleanCardName, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue3), null, null, str2, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                                            } else {
                                                int length = string2.length();
                                                if (2 > length || length >= 6) {
                                                    string2 = null;
                                                }
                                                if (string2 != null) {
                                                    String lowerCase = string2.toLowerCase(Locale.ROOT);
                                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                                    str2 = lowerCase;
                                                }
                                                Integer num42 = userMappings.get("collector_number");
                                                if (num42 == null) {
                                                }
                                                if (iIntValue5 >= 0) {
                                                    Integer num52 = userMappings.get("language");
                                                    if (num52 == null) {
                                                    }
                                                    String strConvertLanguage2 = iIntValue6 < 0 ? convertLanguage((String) CollectionsKt.getOrNull(csvLine$default, iIntValue6)) : "en";
                                                    Integer num62 = userMappings.get("condition");
                                                    if (num62 == null) {
                                                    }
                                                    if (iIntValue7 < 0) {
                                                    }
                                                    Integer num72 = userMappings.get("finish");
                                                    if (num72 != null) {
                                                    }
                                                    arrayList2.add(new MTFullCard(null, false, null, null, null, string3, null, null, null, strConvertCondition, null, null, null, null, null, null, null, null, null, null, iIntValue8 < 0 ? convertFinish((String) CollectionsKt.getOrNull(csvLine$default, iIntValue8)) : "nonfoil", null, null, null, null, null, null, null, strConvertLanguage2, null, null, null, null, null, null, null, false, strCleanCardName, null, null, null, null, null, null, null, false, Integer.valueOf(iIntValue3), null, null, str2, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1204273, 127, null));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    arrayList.add("Error parsing line: " + e.getMessage());
                }
            }
            return new ImportResult(CollectionsKt.listOf(new MTCardContainer(null, null, null, 4, "CSV Import", 2, "Box", null, arrayList2, null, null, null, null, null, null, null, 65159, null)), arrayList);
        } catch (Exception e2) {
            arrayList.add("Error parsing CSV with user mappings: " + e2.getMessage());
            return new ImportResult(CollectionsKt.emptyList(), arrayList);
        }
    }
}
