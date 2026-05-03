package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: compiled from: RulingsDBHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\u001a\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0002J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0006\u0010#\u001a\u00020\u001bJ\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010%\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulingsDBHelper;", "Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;", "context", "Landroid/content/Context;", AndroidContextPlugin.LOCALE_KEY, "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "dbFile", "Ljava/io/File;", "initialize", "", "useDatabase", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Landroid/database/sqlite/SQLiteDatabase;", "findDbFilesInContext", "", "Lkotlin/Pair;", "", "findDbFilesInAssets", "extractVersionFromFilename", "filename", "(Ljava/lang/String;)Ljava/lang/Integer;", "copyDatabaseFromAssets", "cleanUpOldVersions", "isDatabaseValid", "", "dbFilePath", "getLang", "getVersion", "isValid", "doesTableExist", UserDataStore.DATE_OF_BIRTH, "tableName", "hasDBInAppContext", "getRulingsForCard", "oracleId", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RulingsDBHelper extends UpdatableMTGHelper {
    private static final String DATABASE_PREFIX = "rulings_";
    private static final String DATABASE_SUFFIX = ".db";
    private final Context context;
    private File dbFile;
    private final String locale;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static List<Pair<RulingsDBHelper, String>> instances = new ArrayList();

    /* JADX INFO: compiled from: RulingsDBHelper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulingsDBHelper$Companion;", "", "<init>", "()V", "DATABASE_PREFIX", "", "DATABASE_SUFFIX", "instances", "", "Lkotlin/Pair;", "Lcom/studiolaganne/lengendarylens/RulingsDBHelper;", "getInstance", "context", "Landroid/content/Context;", AndroidContextPlugin.LOCALE_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized RulingsDBHelper getInstance(Context context, String locale) {
            DefaultConstructorMarker defaultConstructorMarker;
            Object next;
            Object first;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Iterator it = RulingsDBHelper.instances.iterator();
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
            Pair pair = (Pair) next;
            if (pair == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                pair = new Pair(new RulingsDBHelper(applicationContext, locale, defaultConstructorMarker), locale);
                RulingsDBHelper.instances.add(pair);
            }
            first = pair.getFirst();
            Intrinsics.checkNotNull(first);
            return (RulingsDBHelper) first;
        }
    }

    private RulingsDBHelper(Context context, String str) throws IOException {
        super(context);
        this.context = context;
        this.locale = str;
        initialize();
    }

    public /* synthetic */ RulingsDBHelper(Context context, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str);
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
            Breadcrumbs.INSTANCE.leaveBreadcrumb("rulings_db_corrupt");
            firebaseAnalytics.logEvent("rulings_db_corrupt", null);
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

    static final Unit getRulingsForCard$lambda$0(String str, String str2, Ref.ObjectRef objectRef, RulingsDBHelper rulingsDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    List list = (List) objectRef.element;
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("r_comment"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    list.add(string);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(rulingsDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", rulingsDBHelper.getLocale());
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = rulingsDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = rulingsDBHelper.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            bundle.putBoolean("db_valid", rulingsDBHelper.isValid());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_rulings_error");
            firebaseAnalytics.logEvent("db_rulings_error", bundle);
        }
        return Unit.INSTANCE;
    }

    private final boolean isDatabaseValid(String dbFilePath) {
        boolean z = true;
        try {
            SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(dbFilePath, null, 1);
            try {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseOpenDatabase;
                List listListOf = CollectionsKt.listOf((Object[]) new String[]{"rulings", "cards_rulings"});
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

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    /* JADX INFO: renamed from: getLang, reason: from getter */
    public String getLocale() {
        return this.locale;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    public final List<String> getRulingsForCard(final String oracleId) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        final String str = "SELECT r.comment as r_comment FROM rulings r JOIN cards_rulings c ON c.ruling_id = r.ruling_id WHERE c.oracle_id = ? ORDER BY r.published_at";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.RulingsDBHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RulingsDBHelper.getRulingsForCard$lambda$0(str, oracleId, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (List) objectRef.element;
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
        setDbType("rulings");
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
}
