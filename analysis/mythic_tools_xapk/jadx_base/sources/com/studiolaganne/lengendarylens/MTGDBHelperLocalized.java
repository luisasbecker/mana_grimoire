package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\u001a\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0002J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0006\u0010#\u001a\u00020\u001bJ\u001a\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020%J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u00103\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0013J\u001a\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0013J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u00106\u001a\u00020\u0005J\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010+\u001a\u00020\u0005J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010:\u001a\u00020\u0005J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010:\u001a\u00020\u0005J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u0010+\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u001bJ\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u0010+\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u001bJ\u0010\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020AH\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u0010C\u001a\u00020A2\u0006\u0010=\u001a\u00020\u001bJ(\u0010D\u001a\u0004\u0018\u00010%2\u0006\u00103\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0013J0\u0010F\u001a\u0004\u0018\u00010%2\u0006\u00103\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005J\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u0010+\u001a\u00020\u0005J\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020%0\u00112\u0006\u0010+\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0013J\u0016\u0010I\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0013J\u0016\u0010J\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0013J\u0016\u0010K\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;", "context", "Landroid/content/Context;", AndroidContextPlugin.LOCALE_KEY, "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "dbFile", "Ljava/io/File;", "initialize", "", "useDatabase", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Landroid/database/sqlite/SQLiteDatabase;", "findDbFilesInContext", "", "Lkotlin/Pair;", "", "findDbFilesInAssets", "extractVersionFromFilename", "filename", "(Ljava/lang/String;)Ljava/lang/Integer;", "copyDatabaseFromAssets", "cleanUpOldVersions", "isDatabaseValid", "", "dbFilePath", "getLang", "getVersion", "isValid", "doesTableExist", UserDataStore.DATE_OF_BIRTH, "tableName", "hasDBInAppContext", "getCardByScryFallId", "Lcom/studiolaganne/lengendarylens/CardRecord;", "scryfallId", OptionalModuleUtils.FACE, "getRandomCard", "searchForLegendaryCreatureOrPlaneswalker", "Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "searchTitle", "searchForUncommonCreature", "searchForPlaneswalker", "searchForBackground", "searchForDoctorCompanion", "searchForDoctor", "searchForInstantOrSorcery", "getAllPrints", "oracleId", "getFirstPrintScryfallId", "getAllCardsFromSet", "setCode", "getCardsByTitleMatchingWords", "getCardsByFoldedTitleMatchingWords", "getCardsByTitleMatchingSingleWord", "word", "getCardsByFoldedTitleMatchingSingleWord", "getFullCardsByTitleMatchingWordsWithWildcards", "condense", "getFullCardsByFoldedTitleMatchingWordsWithWildcards", "buildSqlQuery", "rootElement", "Lcom/studiolaganne/lengendarylens/SearchElement;", "getFullCardsBySearchQueryWithFolding", "searchQuery", "getCardByOracleIdAndPrintData", "cardNumber", "getCardByOracleIdAndOptionalPrintData", "getCardsByTitle", "getCardsByTitleAndFace", "getOracleForCard", "getNameForCard", "getTypeLineForCard", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTGDBHelperLocalized extends UpdatableMTGHelper {
    private static final String DATABASE_PREFIX = "cards_";
    private static final String DATABASE_SUFFIX = ".db";
    private final Context context;
    private File dbFile;
    private final String locale;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static List<Pair<MTGDBHelperLocalized, String>> instances = new ArrayList();

    /* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized$Companion;", "", "<init>", "()V", "DATABASE_PREFIX", "", "DATABASE_SUFFIX", "instances", "", "Lkotlin/Pair;", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "getInstance", "context", "Landroid/content/Context;", AndroidContextPlugin.LOCALE_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized MTGDBHelperLocalized getInstance(Context context, String locale) {
            DefaultConstructorMarker defaultConstructorMarker;
            Object next;
            Pair pair;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Iterator it = MTGDBHelperLocalized.instances.iterator();
            while (true) {
                defaultConstructorMarker = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((Pair) next).getSecond(), locale)) {
                    break;
                }
            }
            pair = (Pair) next;
            if (pair == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                pair = new Pair(new MTGDBHelperLocalized(applicationContext, locale, defaultConstructorMarker), locale);
                MTGDBHelperLocalized.instances.add(pair);
            }
            return (MTGDBHelperLocalized) pair.getFirst();
        }
    }

    private MTGDBHelperLocalized(Context context, String str) throws IOException {
        super(context);
        this.context = context;
        this.locale = str;
        initialize();
    }

    public /* synthetic */ MTGDBHelperLocalized(Context context, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str);
    }

    private final String buildSqlQuery(SearchElement rootElement) throws IOException {
        return "SELECT \n    c.oracle_id as c_oracle_id,\n    p.scryfall_id as p_scryfall_id,\n    p.number as p_number,\n    p.face as p_face,\n    c.title as c_title,\n    p.`set` as p_set,\n    c.type_line as c_type_line,\n    c.oracle_text as c_oracle_text,\n    c.mana_cost as c_mana_cost,\n    c.int_field_1 as c_int_field_1,\n    c.int_field_2 as c_int_field_2,\n    c.layout as c_layout\nFROM cards_fts f\nJOIN cards c ON f.docid = c.rowid\nJOIN prints p ON c.oracle_id = p.oracle_id WHERE " + SearchDataUtils.INSTANCE.getInstance().searchElementToSql(rootElement, getLocale(), true);
    }

    private final void cleanUpOldVersions() {
        String str = DATABASE_PREFIX + this.locale + "_" + getCurrentVersion() + DATABASE_SUFFIX;
        String[] strArrDatabaseList = this.context.databaseList();
        Intrinsics.checkNotNullExpressionValue(strArrDatabaseList, "databaseList(...)");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrDatabaseList) {
            String str3 = str2;
            Intrinsics.checkNotNull(str3);
            if (StringsKt.startsWith$default(str3, DATABASE_PREFIX + this.locale, false, 2, (Object) null) && StringsKt.endsWith$default(str3, DATABASE_SUFFIX, false, 2, (Object) null) && !Intrinsics.areEqual(str3, str)) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.context.getDatabasePath((String) it.next()).delete();
        }
    }

    private final void copyDatabaseFromAssets(String filename) throws IOException {
        InputStream inputStreamOpen = this.context.getAssets().open(filename);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        File file = new File(this.context.getDatabasePath(filename).getPath());
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            ByteStreamsKt.copyTo$default(inputStreamOpen, fileOutputStream, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    private final boolean doesTableExist(SQLiteDatabase db, String tableName) {
        try {
            Cursor cursorRawQuery = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{tableName});
            try {
                boolean z = cursorRawQuery.getCount() > 0;
                CloseableKt.closeFinally(cursorRawQuery, null);
                return z;
            } finally {
            }
        } catch (SQLiteDatabaseCorruptException unused) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Breadcrumbs.INSTANCE.leaveBreadcrumb(DATABASE_PREFIX + this.locale + "_mtg_db_corrupt");
            firebaseAnalytics.logEvent(DATABASE_PREFIX + this.locale + "_db_corrupt", null);
            return false;
        }
    }

    private final Integer extractVersionFromFilename(String filename) {
        List<String> groupValues;
        String str;
        try {
            kotlin.text.MatchResult matchResultFind$default = Regex.find$default(new Regex(".*_(\\d+)\\.db$"), filename, 0, 2, null);
            if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("download_db_" + this.getDbType() + "_" + this.getLocale() + "_exception_reading_version", null);
            return null;
        }
    }

    private final List<Pair<String, Integer>> findDbFilesInAssets() {
        try {
            String[] list = this.context.getAssets().list("");
            Intrinsics.checkNotNull(list);
            ArrayList<String> arrayList = new ArrayList();
            for (String str : list) {
                Intrinsics.checkNotNull(str);
                if (StringsKt.startsWith$default(str, DATABASE_PREFIX + this.locale, false, 2, (Object) null) && StringsKt.endsWith$default(str, DATABASE_SUFFIX, false, 2, (Object) null)) {
                    arrayList.add(str);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : arrayList) {
                Intrinsics.checkNotNull(str2);
                Integer numExtractVersionFromFilename = extractVersionFromFilename(str2);
                Pair pair = numExtractVersionFromFilename != null ? TuplesKt.to(str2, Integer.valueOf(numExtractVersionFromFilename.intValue())) : null;
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            return arrayList2;
        } catch (IOException unused) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("download_db_" + getDbType() + "_" + getLocale() + "_exception_reading_assets", null);
            return CollectionsKt.emptyList();
        }
    }

    private final List<Pair<String, Integer>> findDbFilesInContext() {
        String[] strArrDatabaseList = this.context.databaseList();
        Intrinsics.checkNotNullExpressionValue(strArrDatabaseList, "databaseList(...)");
        ArrayList<String> arrayList = new ArrayList();
        for (String str : strArrDatabaseList) {
            String str2 = str;
            Intrinsics.checkNotNull(str2);
            if (StringsKt.startsWith$default(str2, DATABASE_PREFIX + this.locale, false, 2, (Object) null) && StringsKt.endsWith$default(str2, DATABASE_SUFFIX, false, 2, (Object) null)) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : arrayList) {
            Intrinsics.checkNotNull(str3);
            Integer numExtractVersionFromFilename = extractVersionFromFilename(str3);
            Pair pair = numExtractVersionFromFilename != null ? TuplesKt.to(str3, Integer.valueOf(numExtractVersionFromFilename.intValue())) : null;
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return arrayList2;
    }

    static final Unit getAllCardsFromSet$lambda$0(String str, String str2, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setType_line(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setOracle_text(string7);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setMana_cost(string8);
                    Intrinsics.checkNotNull(string9);
                    cardRecord.setInt_field_1(string9);
                    Intrinsics.checkNotNull(string10);
                    cardRecord.setInt_field_2(string10);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ List getAllPrints$default(MTGDBHelperLocalized mTGDBHelperLocalized, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelperLocalized.getAllPrints(str, i);
    }

    static final Unit getAllPrints$lambda$0(String str, String str2, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("scryfall_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("number"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("set"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cardRecord.setOracle_id(str2);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setScryfall_id(string);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setNumber(string2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setSet(string3);
                    cardRecord.setFace(i);
                    cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_" + mTGDBHelperLocalized.getLocale());
            firebaseAnalytics.logEvent("db_error_" + mTGDBHelperLocalized.getLocale(), bundle);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ CardRecord getCardByOracleIdAndOptionalPrintData$default(MTGDBHelperLocalized mTGDBHelperLocalized, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return mTGDBHelperLocalized.getCardByOracleIdAndOptionalPrintData(str, i, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018d  */
    /* JADX WARN: Type inference failed for: r13v0, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit getCardByOracleIdAndOptionalPrintData$lambda$0(String str, int i, MTGDBHelperLocalized mTGDBHelperLocalized, String str2, String str3, Ref.ObjectRef objectRef, SQLiteDatabase db) {
        Cursor cursorRawQuery;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            cursorRawQuery = db.rawQuery("SELECT * FROM cards WHERE oracle_id = ? AND face = ?", new String[]{str, String.valueOf(i)});
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("query_type", "flexible_print");
            bundle.putString("oracle_id", str);
            String str5 = AbstractJsonLexerKt.NULL;
            if (str4 == null) {
            }
            bundle.putString("set_code", str4);
            if (str3 != null) {
            }
            bundle.putString("card_number", str5);
            bundle.putString("exception", e.getLocalizedMessage());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_" + mTGDBHelperLocalized.getLocale() + "_flexible");
            firebaseAnalytics.logEvent("db_error_" + mTGDBHelperLocalized.getLocale() + "_flexible", bundle);
        }
        try {
            Cursor cursor = cursorRawQuery;
            if (!cursor.moveToFirst()) {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorRawQuery, null);
                return unit;
            }
            ?? cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
            String string = cursor.getString(cursor.getColumnIndexOrThrow("oracle_id"));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            cardRecord.setOracle_id(string);
            cardRecord.setFace(cursor.getInt(cursor.getColumnIndexOrThrow(OptionalModuleUtils.FACE)));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            cardRecord.setTitle(string2);
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("type_line"));
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            cardRecord.setType_line(string3);
            String string4 = cursor.getString(cursor.getColumnIndexOrThrow("oracle_text"));
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            cardRecord.setOracle_text(string4);
            String string5 = cursor.getString(cursor.getColumnIndexOrThrow(WindowExtensionsConstants.LAYOUT_PACKAGE));
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            cardRecord.setLayout(string5);
            cardRecord.setLang(mTGDBHelperLocalized.getLocale());
            StringBuilder sb = new StringBuilder("SELECT * FROM prints WHERE oracle_id = ? AND face = ?");
            List listMutableListOf = CollectionsKt.mutableListOf(str, String.valueOf(i));
            if (str4 != null) {
                sb.append(" AND `set` = ?");
                listMutableListOf.add(str4);
            }
            if (str3 != null) {
                sb.append(" AND number = ?");
                listMutableListOf.add(str3);
            }
            cursorRawQuery = db.rawQuery(sb.toString(), (String[]) listMutableListOf.toArray(new String[0]));
            try {
                Cursor cursor2 = cursorRawQuery;
                if (cursor2.moveToFirst()) {
                    String string6 = cursor2.getString(cursor2.getColumnIndexOrThrow("scryfall_id"));
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    cardRecord.setScryfall_id(string6);
                    String string7 = cursor2.getString(cursor2.getColumnIndexOrThrow("set"));
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    cardRecord.setSet(string7);
                    String string8 = cursor2.getString(cursor2.getColumnIndexOrThrow("number"));
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    cardRecord.setNumber(string8);
                    objectRef.element = cardRecord;
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorRawQuery, null);
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorRawQuery, null);
                return Unit.INSTANCE;
            } finally {
            }
            return Unit.INSTANCE;
        } finally {
        }
        FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
        Bundle bundle2 = new Bundle();
        bundle2.putString("query_type", "flexible_print");
        bundle2.putString("oracle_id", str);
        String str52 = AbstractJsonLexerKt.NULL;
        if (str4 == null) {
            str4 = AbstractJsonLexerKt.NULL;
        }
        bundle2.putString("set_code", str4);
        if (str3 != null) {
            str52 = str3;
        }
        bundle2.putString("card_number", str52);
        bundle2.putString("exception", e.getLocalizedMessage());
        Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_" + mTGDBHelperLocalized.getLocale() + "_flexible");
        firebaseAnalytics2.logEvent("db_error_" + mTGDBHelperLocalized.getLocale() + "_flexible", bundle2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit getCardByOracleIdAndPrintData$lambda$0(String str, CardRecord cardRecord, String str2, String str3, String str4, Ref.ObjectRef objectRef, MTGDBHelperLocalized mTGDBHelperLocalized, SQLiteDatabase db) {
        File file;
        MTGDBHelperLocalized mTGDBHelperLocalized2;
        File file2;
        File file3;
        File file4;
        Cursor cursorRawQuery;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery2 = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery2, "rawQuery(...)");
            if (cursorRawQuery2.moveToFirst()) {
                String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("oracle_id"));
                int i = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                String string2 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                try {
                    String string3 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow(WindowExtensionsConstants.LAYOUT_PACKAGE));
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setTitle(string2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setType_line(string3);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setOracle_text(string4);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setLayout(string5);
                    file = null;
                    try {
                        cursorRawQuery = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + str2 + "' AND `set` = '" + str3 + "' AND number = '" + str4 + "' AND face = " + i, null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
                    } catch (SQLiteException e) {
                        e = e;
                        mTGDBHelperLocalized2 = mTGDBHelperLocalized;
                        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized2.context);
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                        Bundle bundle = new Bundle();
                        bundle.putString("language_code", mTGDBHelperLocalized2.getLocale());
                        bundle.putString(SearchIntents.EXTRA_QUERY, str);
                        bundle.putString("exception", e.getLocalizedMessage());
                        file2 = mTGDBHelperLocalized2.dbFile;
                        if (file2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                            file2 = file;
                        }
                        bundle.putBoolean("db_exists", file2.exists());
                        file3 = mTGDBHelperLocalized2.dbFile;
                        if (file3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                            file4 = file;
                        } else {
                            file4 = file3;
                        }
                        bundle.putLong("db_size", file4.length());
                        bundle.putBoolean("db_valid", mTGDBHelperLocalized2.isValid());
                        Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
                        firebaseAnalytics.logEvent("db_error", bundle);
                        return Unit.INSTANCE;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    file = null;
                    mTGDBHelperLocalized2 = mTGDBHelperLocalized;
                    FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(mTGDBHelperLocalized2.context);
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("language_code", mTGDBHelperLocalized2.getLocale());
                    bundle2.putString(SearchIntents.EXTRA_QUERY, str);
                    bundle2.putString("exception", e.getLocalizedMessage());
                    file2 = mTGDBHelperLocalized2.dbFile;
                    if (file2 == null) {
                    }
                    bundle2.putBoolean("db_exists", file2.exists());
                    file3 = mTGDBHelperLocalized2.dbFile;
                    if (file3 == null) {
                    }
                    bundle2.putLong("db_size", file4.length());
                    bundle2.putBoolean("db_valid", mTGDBHelperLocalized2.isValid());
                    Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
                    firebaseAnalytics2.logEvent("db_error", bundle2);
                    return Unit.INSTANCE;
                }
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("scryfall_id"));
                        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                        cardRecord.setScryfall_id(string6);
                        cardRecord.setSet(str3);
                        cardRecord.setNumber(str4);
                        cardRecord.setFace(i);
                        objectRef.element = cardRecord;
                        file = null;
                    } else {
                        Cursor cursorRawQuery3 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + str2 + "' AND face = " + i + " AND `set` = '" + str3 + "'", null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery3, "rawQuery(...)");
                        if (cursorRawQuery3.moveToFirst()) {
                            String string7 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("scryfall_id"));
                            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                            cardRecord.setScryfall_id(string7);
                            cardRecord.setSet(str3);
                            String string8 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("number"));
                            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                            cardRecord.setNumber(string8);
                            cardRecord.setFace(i);
                            objectRef.element = cardRecord;
                            file = null;
                        } else {
                            file = null;
                            Cursor cursorRawQuery4 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + str2 + "' AND face = " + i, null);
                            Intrinsics.checkNotNullExpressionValue(cursorRawQuery4, "rawQuery(...)");
                            if (cursorRawQuery4.moveToFirst()) {
                                String string9 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("scryfall_id"));
                                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                                cardRecord.setScryfall_id(string9);
                                String string10 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("set"));
                                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                                cardRecord.setSet(string10);
                                String string11 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("number"));
                                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                                cardRecord.setNumber(string11);
                                cardRecord.setFace(i);
                                objectRef.element = cardRecord;
                            }
                            cursorRawQuery4.close();
                        }
                        cursorRawQuery3.close();
                    }
                    cursorRawQuery.close();
                } catch (SQLiteException e3) {
                    e = e3;
                    mTGDBHelperLocalized2 = mTGDBHelperLocalized;
                    file = null;
                    FirebaseAnalytics firebaseAnalytics22 = FirebaseAnalytics.getInstance(mTGDBHelperLocalized2.context);
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics22, "getInstance(...)");
                    Bundle bundle22 = new Bundle();
                    bundle22.putString("language_code", mTGDBHelperLocalized2.getLocale());
                    bundle22.putString(SearchIntents.EXTRA_QUERY, str);
                    bundle22.putString("exception", e.getLocalizedMessage());
                    file2 = mTGDBHelperLocalized2.dbFile;
                    if (file2 == null) {
                    }
                    bundle22.putBoolean("db_exists", file2.exists());
                    file3 = mTGDBHelperLocalized2.dbFile;
                    if (file3 == null) {
                    }
                    bundle22.putLong("db_size", file4.length());
                    bundle22.putBoolean("db_valid", mTGDBHelperLocalized2.isValid());
                    Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
                    firebaseAnalytics22.logEvent("db_error", bundle22);
                }
            } else {
                file = null;
            }
            cursorRawQuery2.close();
        } catch (SQLiteException e4) {
            e = e4;
            file = null;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ CardRecord getCardByScryFallId$default(MTGDBHelperLocalized mTGDBHelperLocalized, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelperLocalized.getCardByScryFallId(str, i);
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    static final Unit getCardByScryFallId$lambda$0(String str, String str2, MTGDBHelperLocalized mTGDBHelperLocalized, Ref.ObjectRef objectRef, SQLiteDatabase db) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_identity"));
                String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_keywords"));
                ?? cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                cursor = cursorRawQuery;
                cardRecord.setScryfall_id(str2);
                Intrinsics.checkNotNull(string);
                cardRecord.setOracle_id(string);
                cardRecord.setFace(i);
                Intrinsics.checkNotNull(string2);
                cardRecord.setTitle(string2);
                Intrinsics.checkNotNull(string3);
                cardRecord.setType_line(string3);
                Intrinsics.checkNotNull(string4);
                cardRecord.setOracle_text(string4);
                Intrinsics.checkNotNull(string8);
                cardRecord.setSet(string8);
                Intrinsics.checkNotNull(string9);
                cardRecord.setNumber(string9);
                cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                Intrinsics.checkNotNull(string5);
                cardRecord.setMana_cost(string5);
                Intrinsics.checkNotNull(string6);
                cardRecord.setInt_field_1(string6);
                Intrinsics.checkNotNull(string7);
                cardRecord.setInt_field_2(string7);
                Intrinsics.checkNotNull(string10);
                cardRecord.setIdentity(string10);
                Intrinsics.checkNotNull(string11);
                cardRecord.setLayout(string11);
                Intrinsics.checkNotNull(string12);
                cardRecord.setKeywords(string12);
                objectRef.element = cardRecord;
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putLong("db_size", file2.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final Unit getCardsByFoldedTitleMatchingSingleWord$lambda$0(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence getCardsByFoldedTitleMatchingWords$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "folded_title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit getCardsByFoldedTitleMatchingWords$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final Unit getCardsByTitle$lambda$0(String str, String str2, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setType_line(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setOracle_text(string7);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setMana_cost(string8);
                    Intrinsics.checkNotNull(string9);
                    cardRecord.setInt_field_1(string9);
                    Intrinsics.checkNotNull(string10);
                    cardRecord.setInt_field_2(string10);
                    Intrinsics.checkNotNull(string11);
                    cardRecord.setLayout(string11);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final Unit getCardsByTitleAndFace$lambda$0(String str, String str2, int i, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, String.valueOf(i)});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    cardRecord.setFace(i2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setType_line(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setOracle_text(string7);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setMana_cost(string8);
                    Intrinsics.checkNotNull(string9);
                    cardRecord.setInt_field_1(string9);
                    Intrinsics.checkNotNull(string10);
                    cardRecord.setInt_field_2(string10);
                    Intrinsics.checkNotNull(string11);
                    cardRecord.setLayout(string11);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final Unit getCardsByTitleMatchingSingleWord$lambda$0(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence getCardsByTitleMatchingWords$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word : "";
    }

    static final Unit getCardsByTitleMatchingWords$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ String getFirstPrintScryfallId$default(MTGDBHelperLocalized mTGDBHelperLocalized, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelperLocalized.getFirstPrintScryfallId(str, i);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    static final Unit getFirstPrintScryfallId$lambda$0(String str, Ref.ObjectRef objectRef, MTGDBHelperLocalized mTGDBHelperLocalized, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                objectRef.element = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("scryfall_id"));
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence getFullCardsByFoldedTitleMatchingWordsWithWildcards$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "folded_title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit getFullCardsByFoldedTitleMatchingWordsWithWildcards$lambda$4(String str, boolean z, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase sQLiteDatabase) {
        File file;
        Cursor cursor;
        Cursor cursor2;
        String str2;
        SQLiteDatabase db = sQLiteDatabase;
        String str3 = "rawQuery(...)";
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("mana_cost"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("int_field_1"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("int_field_2"));
                    cursor = cursorRawQuery;
                    if (z) {
                        Cursor cursorRawQuery2 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + string + "' LIMIT 1", null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery2, str3);
                        if (cursorRawQuery2.moveToFirst()) {
                            String string8 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("scryfall_id"));
                            String string9 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("set"));
                            String string10 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("number"));
                            CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                            Intrinsics.checkNotNull(string8);
                            cardRecord.setScryfall_id(string8);
                            Intrinsics.checkNotNull(string);
                            cardRecord.setOracle_id(string);
                            cardRecord.setFace(i);
                            Intrinsics.checkNotNull(string2);
                            cardRecord.setTitle(string2);
                            Intrinsics.checkNotNull(string3);
                            cardRecord.setType_line(string3);
                            Intrinsics.checkNotNull(string4);
                            cardRecord.setOracle_text(string4);
                            Intrinsics.checkNotNull(string9);
                            cardRecord.setSet(string9);
                            Intrinsics.checkNotNull(string10);
                            cardRecord.setNumber(string10);
                            cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                            Intrinsics.checkNotNull(string5);
                            cardRecord.setMana_cost(string5);
                            Intrinsics.checkNotNull(string6);
                            cardRecord.setInt_field_1(string6);
                            Intrinsics.checkNotNull(string7);
                            cardRecord.setInt_field_2(string7);
                            list.add(cardRecord);
                        }
                        cursorRawQuery2.close();
                        str2 = str3;
                    } else {
                        Cursor cursorRawQuery3 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + string + "'", null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery3, str3);
                        if (cursorRawQuery3.moveToFirst()) {
                            while (true) {
                                String string11 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("scryfall_id"));
                                String string12 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("set"));
                                str2 = str3;
                                String string13 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("number"));
                                CardRecord cardRecord2 = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                                cursor2 = cursorRawQuery3;
                                Intrinsics.checkNotNull(string11);
                                cardRecord2.setScryfall_id(string11);
                                Intrinsics.checkNotNull(string);
                                cardRecord2.setOracle_id(string);
                                cardRecord2.setFace(i);
                                Intrinsics.checkNotNull(string2);
                                cardRecord2.setTitle(string2);
                                Intrinsics.checkNotNull(string3);
                                cardRecord2.setType_line(string3);
                                Intrinsics.checkNotNull(string4);
                                cardRecord2.setOracle_text(string4);
                                Intrinsics.checkNotNull(string12);
                                cardRecord2.setSet(string12);
                                Intrinsics.checkNotNull(string13);
                                cardRecord2.setNumber(string13);
                                cardRecord2.setLang(mTGDBHelperLocalized.getLocale());
                                Intrinsics.checkNotNull(string5);
                                cardRecord2.setMana_cost(string5);
                                Intrinsics.checkNotNull(string6);
                                cardRecord2.setInt_field_1(string6);
                                Intrinsics.checkNotNull(string7);
                                cardRecord2.setInt_field_2(string7);
                                list.add(cardRecord2);
                                if (!cursor2.moveToNext()) {
                                    break;
                                }
                                str3 = str2;
                                cursorRawQuery3 = cursor2;
                            }
                        } else {
                            cursor2 = cursorRawQuery3;
                            str2 = str3;
                        }
                        cursor2.close();
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    db = sQLiteDatabase;
                    cursorRawQuery = cursor;
                    str3 = str2;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final Unit getFullCardsBySearchQueryWithFolding$lambda$0(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setScryfall_id(string8);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setTitle(string2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setType_line(string3);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setOracle_text(string4);
                    Intrinsics.checkNotNull(string10);
                    cardRecord.setSet(string10);
                    Intrinsics.checkNotNull(string9);
                    cardRecord.setNumber(string9);
                    cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setMana_cost(string5);
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setInt_field_1(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setInt_field_2(string7);
                    Intrinsics.checkNotNull(string11);
                    cardRecord.setLayout(string11);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putLong("db_size", file2.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence getFullCardsByTitleMatchingWordsWithWildcards$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit getFullCardsByTitleMatchingWordsWithWildcards$lambda$4(String str, boolean z, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase sQLiteDatabase) {
        File file;
        Cursor cursor;
        Cursor cursor2;
        String str2;
        SQLiteDatabase db = sQLiteDatabase;
        String str3 = "rawQuery(...)";
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("mana_cost"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("int_field_1"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("int_field_2"));
                    cursor = cursorRawQuery;
                    if (z) {
                        Cursor cursorRawQuery2 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + string + "' LIMIT 1", null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery2, str3);
                        if (cursorRawQuery2.moveToFirst()) {
                            String string8 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("scryfall_id"));
                            String string9 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("set"));
                            String string10 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("number"));
                            CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                            Intrinsics.checkNotNull(string8);
                            cardRecord.setScryfall_id(string8);
                            Intrinsics.checkNotNull(string);
                            cardRecord.setOracle_id(string);
                            cardRecord.setFace(i);
                            Intrinsics.checkNotNull(string2);
                            cardRecord.setTitle(string2);
                            Intrinsics.checkNotNull(string3);
                            cardRecord.setType_line(string3);
                            Intrinsics.checkNotNull(string4);
                            cardRecord.setOracle_text(string4);
                            Intrinsics.checkNotNull(string9);
                            cardRecord.setSet(string9);
                            Intrinsics.checkNotNull(string10);
                            cardRecord.setNumber(string10);
                            cardRecord.setLang(mTGDBHelperLocalized.getLocale());
                            Intrinsics.checkNotNull(string5);
                            cardRecord.setMana_cost(string5);
                            Intrinsics.checkNotNull(string6);
                            cardRecord.setInt_field_1(string6);
                            Intrinsics.checkNotNull(string7);
                            cardRecord.setInt_field_2(string7);
                            list.add(cardRecord);
                        }
                        cursorRawQuery2.close();
                        str2 = str3;
                    } else {
                        Cursor cursorRawQuery3 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + string + "'", null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery3, str3);
                        if (cursorRawQuery3.moveToFirst()) {
                            while (true) {
                                String string11 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("scryfall_id"));
                                String string12 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("set"));
                                str2 = str3;
                                String string13 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("number"));
                                CardRecord cardRecord2 = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                                cursor2 = cursorRawQuery3;
                                Intrinsics.checkNotNull(string11);
                                cardRecord2.setScryfall_id(string11);
                                Intrinsics.checkNotNull(string);
                                cardRecord2.setOracle_id(string);
                                cardRecord2.setFace(i);
                                Intrinsics.checkNotNull(string2);
                                cardRecord2.setTitle(string2);
                                Intrinsics.checkNotNull(string3);
                                cardRecord2.setType_line(string3);
                                Intrinsics.checkNotNull(string4);
                                cardRecord2.setOracle_text(string4);
                                Intrinsics.checkNotNull(string12);
                                cardRecord2.setSet(string12);
                                Intrinsics.checkNotNull(string13);
                                cardRecord2.setNumber(string13);
                                cardRecord2.setLang(mTGDBHelperLocalized.getLocale());
                                Intrinsics.checkNotNull(string5);
                                cardRecord2.setMana_cost(string5);
                                Intrinsics.checkNotNull(string6);
                                cardRecord2.setInt_field_1(string6);
                                Intrinsics.checkNotNull(string7);
                                cardRecord2.setInt_field_2(string7);
                                list.add(cardRecord2);
                                if (!cursor2.moveToNext()) {
                                    break;
                                }
                                str3 = str2;
                                cursorRawQuery3 = cursor2;
                            }
                        } else {
                            cursor2 = cursorRawQuery3;
                            str2 = str3;
                        }
                        cursor2.close();
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    db = sQLiteDatabase;
                    cursorRawQuery = cursor;
                    str3 = str2;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object, java.lang.String] */
    static final Unit getNameForCard$lambda$0(String str, String str2, String str3, Ref.ObjectRef objectRef, MTGDBHelperLocalized mTGDBHelperLocalized, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, str3});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                ?? string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                objectRef.element = string;
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object, java.lang.String] */
    static final Unit getOracleForCard$lambda$0(String str, String str2, String str3, Ref.ObjectRef objectRef, MTGDBHelperLocalized mTGDBHelperLocalized, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, str3});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                ?? string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                objectRef.element = string;
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit getRandomCard$lambda$0(String str, Ref.ObjectRef objectRef, MTGDBHelperLocalized mTGDBHelperLocalized, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                CardRecord cardRecord = (CardRecord) objectRef.element;
                Intrinsics.checkNotNull(string);
                cardRecord.setOracle_id(string);
                CardRecord cardRecord2 = (CardRecord) objectRef.element;
                Intrinsics.checkNotNull(string2);
                cardRecord2.setScryfall_id(string2);
                CardRecord cardRecord3 = (CardRecord) objectRef.element;
                Intrinsics.checkNotNull(string3);
                cardRecord3.setNumber(string3);
                ((CardRecord) objectRef.element).setFace(i);
                CardRecord cardRecord4 = (CardRecord) objectRef.element;
                Intrinsics.checkNotNull(string4);
                cardRecord4.setTitle(string4);
                CardRecord cardRecord5 = (CardRecord) objectRef.element;
                Intrinsics.checkNotNull(string5);
                cardRecord5.setSet(string5);
                ((CardRecord) objectRef.element).setLang(mTGDBHelperLocalized.getLocale());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object, java.lang.String] */
    static final Unit getTypeLineForCard$lambda$0(String str, String str2, String str3, Ref.ObjectRef objectRef, MTGDBHelperLocalized mTGDBHelperLocalized, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, str3});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                ?? string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                objectRef.element = string;
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelperLocalized.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            bundle.putBoolean("db_valid", mTGDBHelperLocalized.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error");
            firebaseAnalytics.logEvent("db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    private final boolean isDatabaseValid(String dbFilePath) {
        boolean z = true;
        try {
            SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(dbFilePath, null, 1);
            try {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseOpenDatabase;
                List listListOf = CollectionsKt.listOf((Object[]) new String[]{"cards", "cards_fts", "prints"});
                if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
                    Iterator it = listListOf.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str = (String) it.next();
                        Intrinsics.checkNotNull(sQLiteDatabase);
                        if (!doesTableExist(sQLiteDatabase, str)) {
                            z = false;
                            break;
                        }
                    }
                }
                CloseableKt.closeFinally(sQLiteDatabaseOpenDatabase, null);
                return z;
            } finally {
            }
        } catch (Exception unused) {
            return false;
        }
    }

    static final CharSequence searchForBackground$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForBackground$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence searchForDoctor$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForDoctor$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence searchForDoctorCompanion$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForDoctorCompanion$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence searchForInstantOrSorcery$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForInstantOrSorcery$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence searchForLegendaryCreatureOrPlaneswalker$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForLegendaryCreatureOrPlaneswalker$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence searchForPlaneswalker$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForPlaneswalker$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    static final CharSequence searchForUncommonCreature$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForUncommonCreature$lambda$4(String str, MTGDBHelperLocalized mTGDBHelperLocalized, List list, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_id"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(OptionalModuleUtils.FACE));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Constants.GP_IAP_TITLE));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type_line"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("oracle_text"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("keywords"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, mTGDBHelperLocalized.getLocale(), string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelperLocalized.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", mTGDBHelperLocalized.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelperLocalized.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelperLocalized.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file = file3;
            }
            bundle.putLong("db_size", file.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
            firebaseAnalytics.logEvent("db_error_en", bundle);
        }
        return Unit.INSTANCE;
    }

    private final void useDatabase(Function1<? super SQLiteDatabase, Unit> action) {
        File file = this.dbFile;
        if (file == null) {
            Log.e("MTGDBHelperLocalized", "Database file not found for locale: " + this.locale + ".");
            return;
        }
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            file = null;
        }
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getPath(), null, 1);
        try {
            Intrinsics.checkNotNull(sQLiteDatabaseOpenDatabase);
            action.invoke(sQLiteDatabaseOpenDatabase);
        } finally {
            sQLiteDatabaseOpenDatabase.close();
        }
    }

    public final List<CardRecord> getAllCardsFromSet(final String setCode) {
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE p_set = ? AND c.face = 0\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getAllCardsFromSet$lambda$0(str, setCode, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getAllPrints(final String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final ArrayList arrayList = new ArrayList();
        final String str = "SELECT * FROM prints WHERE oracle_id = '" + oracleId + "' AND face = " + face;
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getAllPrints$lambda$0(str, oracleId, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CardRecord getCardByOracleIdAndOptionalPrintData(final String oracleId, final int face, final String setCode, final String cardNumber) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardByOracleIdAndOptionalPrintData$lambda$0(oracleId, face, this, setCode, cardNumber, objectRef, (SQLiteDatabase) obj);
            }
        });
        return (CardRecord) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CardRecord getCardByOracleIdAndPrintData(final String oracleId, final String setCode, final String cardNumber, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        cardRecord.setLang(getLocale());
        final String str = "SELECT * FROM cards WHERE oracle_id = '" + oracleId + "' AND face = " + face;
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardByOracleIdAndPrintData$lambda$0(str, cardRecord, oracleId, setCode, cardNumber, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (CardRecord) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CardRecord getCardByScryFallId(final String scryfallId, int face) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final String strTrimIndent = StringsKt.trimIndent("\n            SELECT \n                c.oracle_id as c_oracle_id,\n                p.scryfall_id as p_scryfall_id,\n                p.number as p_number,\n                p.face as p_face,\n                c.title as c_title,\n                p.`set` as p_set,\n                c.type_line as c_type_line,\n                c.oracle_text as c_oracle_text,\n                c.mana_cost as c_mana_cost,\n                c.int_field_1 as c_int_field_1,\n                c.int_field_2 as c_int_field_2,\n                c.layout as c_layout,\n                c.identity as c_identity,\n                c.keywords as c_keywords\n            FROM cards c\n            JOIN prints p ON c.oracle_id = p.oracle_id\n            WHERE p.scryfall_id = '" + scryfallId + "' AND p.face = '" + face + "' LIMIT 1\n        ");
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardByScryFallId$lambda$0(strTrimIndent, scryfallId, this, objectRef, (SQLiteDatabase) obj);
            }
        });
        return (CardRecord) objectRef.element;
    }

    public final List<MTGCardRecord> getCardsByFoldedTitleMatchingSingleWord(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        final ArrayList arrayList = new ArrayList();
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH 'folded_title: " + StringsKt.replace$default(StringsKt.replace$default(word, "'", "''", false, 4, (Object) null), "\"", "", false, 4, (Object) null) + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByFoldedTitleMatchingSingleWord$lambda$0(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> getCardsByFoldedTitleMatchingWords(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByFoldedTitleMatchingWords$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByFoldedTitleMatchingWords$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getCardsByTitle(final String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2,\n                    c.layout as c_layout\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE title = ? AND c_layout != 'art_series'\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByTitle$lambda$0(str, searchTitle, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getCardsByTitleAndFace(final String searchTitle, final int face) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2,\n                    c.layout as c_layout\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE title = ? AND p.face = ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByTitleAndFace$lambda$0(str, searchTitle, face, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> getCardsByTitleMatchingSingleWord(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        final ArrayList arrayList = new ArrayList();
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH 'title: " + StringsKt.replace$default(StringsKt.replace$default(word, "'", "''", false, 4, (Object) null), "\"", "", false, 4, (Object) null) + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByTitleMatchingSingleWord$lambda$0(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> getCardsByTitleMatchingWords(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByTitleMatchingWords$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getCardsByTitleMatchingWords$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getFirstPrintScryfallId(String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final String str = "SELECT * FROM prints WHERE oracle_id = '" + oracleId + "' AND face = " + face + " LIMIT 1";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getFirstPrintScryfallId$lambda$0(str, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (String) objectRef.element;
    }

    public final List<CardRecord> getFullCardsByFoldedTitleMatchingWordsWithWildcards(String searchTitle, final boolean condense) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getFullCardsByFoldedTitleMatchingWordsWithWildcards$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getFullCardsByFoldedTitleMatchingWordsWithWildcards$lambda$4(str, condense, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getFullCardsBySearchQueryWithFolding(SearchElement searchQuery, boolean condense) throws IOException {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        final ArrayList arrayList = new ArrayList();
        final String strBuildSqlQuery = buildSqlQuery(searchQuery);
        Log.d("MTGDBHelper", "SQLITE ADVANCED QUERY : " + strBuildSqlQuery);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getFullCardsBySearchQueryWithFolding$lambda$0(strBuildSqlQuery, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        if (!condense) {
            return arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList) {
            String oracle_id = ((CardRecord) obj).getOracle_id();
            Object obj2 = linkedHashMap.get(oracle_id);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(oracle_id, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList2.add((CardRecord) CollectionsKt.first((List) ((Map.Entry) it.next()).getValue()));
        }
        return arrayList2;
    }

    public final List<CardRecord> getFullCardsByTitleMatchingWordsWithWildcards(String searchTitle, final boolean condense) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getFullCardsByTitleMatchingWordsWithWildcards$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getFullCardsByTitleMatchingWordsWithWildcards$lambda$4(str, condense, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    /* JADX INFO: renamed from: getLang, reason: from getter */
    public String getLocale() {
        return this.locale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getNameForCard(final String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final String strValueOf = String.valueOf(face);
        final String str = "SELECT * FROM cards WHERE oracle_id = ? AND face = ?";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getNameForCard$lambda$0(str, oracleId, strValueOf, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (String) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getOracleForCard(final String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final String strValueOf = String.valueOf(face);
        final String str = "SELECT * FROM cards WHERE oracle_id = ? AND face = ?";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getOracleForCard$lambda$0(str, oracleId, strValueOf, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (String) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    public final CardRecord getRandomCard() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id\n                    ORDER BY RANDOM() LIMIT 1;\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getRandomCard$lambda$0(str, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (CardRecord) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTypeLineForCard(final String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final String strValueOf = String.valueOf(face);
        final String str = "SELECT * FROM cards WHERE oracle_id = ? AND face = ?";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.getTypeLineForCard$lambda$0(str, oracleId, strValueOf, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (String) objectRef.element;
    }

    public final int getVersion() {
        return getCurrentVersion();
    }

    public final boolean hasDBInAppContext() {
        File file = this.dbFile;
        if (file == null) {
            return false;
        }
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            file = null;
        }
        return file.exists();
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    public void initialize() throws IOException {
        Object next;
        Object next2;
        setDbType("cards");
        List<Pair<String, Integer>> listFindDbFilesInContext = findDbFilesInContext();
        List<Pair<String, Integer>> listFindDbFilesInAssets = findDbFilesInAssets();
        List<Pair<String, Integer>> list = listFindDbFilesInContext;
        Iterator<T> it = list.iterator();
        Object obj = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).getSecond()).intValue();
                do {
                    Object next3 = it.next();
                    int iIntValue2 = ((Number) ((Pair) next3).getSecond()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next3;
                        iIntValue = iIntValue2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair = (Pair) next;
        int iIntValue3 = pair != null ? ((Number) pair.getSecond()).intValue() : 0;
        List<Pair<String, Integer>> list2 = listFindDbFilesInAssets;
        Iterator<T> it2 = list2.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                int iIntValue4 = ((Number) ((Pair) next2).getSecond()).intValue();
                do {
                    Object next4 = it2.next();
                    int iIntValue5 = ((Number) ((Pair) next4).getSecond()).intValue();
                    if (iIntValue4 < iIntValue5) {
                        next2 = next4;
                        iIntValue4 = iIntValue5;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        Pair pair2 = (Pair) next2;
        int iIntValue6 = pair2 != null ? ((Number) pair2.getSecond()).intValue() : 0;
        if (iIntValue3 >= iIntValue6) {
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next5 = it3.next();
                if (((Number) ((Pair) next5).getSecond()).intValue() == iIntValue3) {
                    obj = next5;
                    break;
                }
            }
            Pair pair3 = (Pair) obj;
            if (pair3 != null) {
                File databasePath = this.context.getDatabasePath((String) pair3.getFirst());
                Intrinsics.checkNotNullExpressionValue(databasePath, "getDatabasePath(...)");
                this.dbFile = databasePath;
                setCurrentVersion(iIntValue3);
            }
        } else {
            Iterator<T> it4 = list2.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                Object next6 = it4.next();
                if (((Number) ((Pair) next6).getSecond()).intValue() == iIntValue6) {
                    obj = next6;
                    break;
                }
            }
            Pair pair4 = (Pair) obj;
            if (pair4 != null) {
                copyDatabaseFromAssets((String) pair4.getFirst());
                File databasePath2 = this.context.getDatabasePath((String) pair4.getFirst());
                Intrinsics.checkNotNullExpressionValue(databasePath2, "getDatabasePath(...)");
                this.dbFile = databasePath2;
                setCurrentVersion(iIntValue6);
            }
        }
        cleanUpOldVersions();
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    public boolean isValid() {
        File file = this.dbFile;
        if (file == null) {
            return false;
        }
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            file = null;
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return isDatabaseValid(path);
    }

    public final List<MTGCardRecord> searchForBackground(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForBackground$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("legendary", getLocale()) + "%' AND y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("background", getLocale()) + "%'";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForBackground$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForDoctor(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForDoctor$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%Time Lord%'";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForDoctor$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForDoctorCompanion(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForDoctorCompanion$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.keywords LIKE '%doctor''s companion%'";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForDoctorCompanion$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForInstantOrSorcery(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForInstantOrSorcery$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND (y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("instant", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("sorcery", getLocale()) + "%')";
        Log.d("MTGDBHelper", "searchForInstantOrSorcery FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForInstantOrSorcery$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForLegendaryCreatureOrPlaneswalker(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForLegendaryCreatureOrPlaneswalker$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("legendary", getLocale()) + "%' AND (y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("creature", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("vehicle", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("spacecraft", getLocale()) + "%')";
        Log.d("MTGDBHelper", "searchForLegendaryCreature FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForLegendaryCreatureOrPlaneswalker$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForPlaneswalker(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForPlaneswalker$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", getLocale()) + "%'";
        Log.d("MTGDBHelper", "searchForPlaneswalker FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForPlaneswalker$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForUncommonCreature(String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("[\\s-,]+").split(searchTitle, 0);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList2.add(StringsKt.trimEnd((String) it.next(), AbstractJsonLexerKt.COMMA));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(StringsKt.replace$default((String) it2.next(), "'", "''", false, 4, (Object) null));
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(StringsKt.replace$default((String) it3.next(), "\"", "", false, 4, (Object) null));
        }
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid JOIN prints p on p.oracle_id = y.oracle_id WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForUncommonCreature$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND (y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("creature", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("vehicle", getLocale()) + "%' OR y.type_line LIKE '%" + SearchDataUtils.INSTANCE.getInstance().translateTag("spacecraft", getLocale()) + "%') AND p.rarity = 'u'";
        Log.d("MTGDBHelper", "searchForUncommonCreature FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelperLocalized$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelperLocalized.searchForUncommonCreature$lambda$4(str, this, arrayList, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }
}
