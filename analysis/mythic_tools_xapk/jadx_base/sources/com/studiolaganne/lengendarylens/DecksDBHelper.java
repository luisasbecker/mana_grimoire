package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.facebook.appevents.UserDataStore;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecksDBHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ\u0014\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00182\u0006\u0010 \u001a\u00020\u0012J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0018J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0018J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u0004\u0018\u00010\"2\u0006\u0010(\u001a\u00020&J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020&J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00182\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020&H\u0002J\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020*0\u00182\u0006\u0010(\u001a\u00020&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksDBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dbFile", "Ljava/io/File;", "sharedPreferences", "Landroid/content/SharedPreferences;", "initialize", "", "copyDatabase", "onCreate", "p0", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "", "p2", "clearFormats", "clearSubformats", "addFormats", "formats", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "addSubformat", "subformat", "Lcom/studiolaganne/lengendarylens/MTSubformat;", "forFormat", "getFormats", "getSubformats", "forFormatId", "getAllTags", "Lcom/studiolaganne/lengendarylens/MTCardTag;", "getRootTags", "getSubTags", "parentTag", "", "getTagByName", "tagName", "getAllThemes", "Lcom/studiolaganne/lengendarylens/MTDeckTheme;", "getThemeById", "themeId", "getTagsForTheme", "Lcom/studiolaganne/lengendarylens/MTThemeTag;", UserDataStore.DATE_OF_BIRTH, "getThemesByTag", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecksDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "decks_5.db";
    private static final int DATABASE_VERSION = 9;
    private static DecksDBHelper instance;
    private final Context context;
    private final File dbFile;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: DecksDBHelper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksDBHelper$Companion;", "", "<init>", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "instance", "Lcom/studiolaganne/lengendarylens/DecksDBHelper;", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized DecksDBHelper getInstance(Context context) {
            DecksDBHelper decksDBHelper;
            Intrinsics.checkNotNullParameter(context, "context");
            if (DecksDBHelper.instance == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                DecksDBHelper.instance = new DecksDBHelper(applicationContext, null);
            }
            decksDBHelper = DecksDBHelper.instance;
            Intrinsics.checkNotNull(decksDBHelper);
            return decksDBHelper;
        }
    }

    private DecksDBHelper(Context context) throws IOException {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 9);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        File databasePath = context.getDatabasePath(DATABASE_NAME);
        Intrinsics.checkNotNullExpressionValue(databasePath, "getDatabasePath(...)");
        this.dbFile = databasePath;
        SharedPreferences sharedPreferences = context.getSharedPreferences("databasePrefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        initialize();
    }

    public /* synthetic */ DecksDBHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final void copyDatabase() throws IOException {
        if (this.dbFile.exists()) {
            this.dbFile.delete();
        }
        File parentFile = this.dbFile.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStreamOpen = this.context.getAssets().open(DATABASE_NAME);
        try {
            InputStream inputStream = fileOutputStreamOpen;
            fileOutputStreamOpen = new FileOutputStream(this.dbFile);
            try {
                Intrinsics.checkNotNull(inputStream);
                ByteStreamsKt.copyTo$default(inputStream, fileOutputStreamOpen, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStreamOpen, null);
                CloseableKt.closeFinally(fileOutputStreamOpen, null);
            } finally {
            }
        } finally {
        }
    }

    private final List<MTThemeTag> getTagsForTheme(SQLiteDatabase db, String themeId) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = db.rawQuery("SELECT tag_name, weight FROM theme_tags WHERE theme_id = ? ORDER BY weight DESC, tag_name", new String[]{themeId});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tag_name"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    arrayList.add(new MTThemeTag(string, cursorRawQuery.getDouble(cursorRawQuery.getColumnIndexOrThrow("weight"))));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting tags for theme: " + themeId, e);
            return arrayList;
        }
    }

    private final void initialize() throws IOException {
        int i = this.sharedPreferences.getInt("decks_databaseVersion", 0);
        if (this.dbFile.exists() && i == 9) {
            return;
        }
        copyDatabase();
        this.sharedPreferences.edit().putInt("decks_databaseVersion", 9).apply();
    }

    public final void addFormats(List<MTFormat> formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Iterator it = formats.iterator();
            while (it.hasNext()) {
                MTFormat mTFormat = (MTFormat) it.next();
                int id = mTFormat.getId();
                String name = mTFormat.getName();
                boolean hascommander = mTFormat.getHascommander();
                int commanderdamages = mTFormat.getCommanderdamages();
                boolean hassideboard = mTFormat.getHassideboard();
                String scryfallid = mTFormat.getScryfallid();
                int lifetotal = mTFormat.getLifetotal();
                int playersmax = mTFormat.getPlayersmax();
                int playersmin = mTFormat.getPlayersmin();
                int decksizemin = mTFormat.getDecksizemin();
                Iterator it2 = it;
                int decksizemax = mTFormat.getDecksizemax();
                int sideboardsizemax = mTFormat.getSideboardsizemax();
                SQLiteDatabase sQLiteDatabase = writableDatabase;
                boolean singleton = mTFormat.getSingleton();
                String str = "\n                    INSERT INTO formats (id, name, hascommander, commanderdamages, hassideboard, scryfallid, lifetotal, \n                                         playersmax, playersmin, decksizemin, decksizemax, sideboardsizemax, singleton, timelimit, bestof, color, icon)\n                    VALUES (" + id + ", '" + name + "', " + (hascommander ? 1 : 0) + ", " + commanderdamages + ", " + (hassideboard ? 1 : 0) + ", '" + scryfallid + "', " + lifetotal + ", \n                            " + playersmax + ", " + playersmin + ", " + decksizemin + ", " + decksizemax + ", " + sideboardsizemax + ", " + (singleton ? 1 : 0) + ", " + mTFormat.getTimelimit() + ", " + mTFormat.getBestof() + ",\n                            '" + mTFormat.getColor() + "', '" + mTFormat.getIcon() + "')\n                    ";
                writableDatabase = sQLiteDatabase;
                writableDatabase.execSQL(str);
                it = it2;
            }
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while adding formats", e);
        }
    }

    public final void addSubformat(MTSubformat subformat, MTFormat forFormat) {
        Intrinsics.checkNotNullParameter(subformat, "subformat");
        Intrinsics.checkNotNullParameter(forFormat, "forFormat");
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            int id = subformat.getId();
            String name = subformat.getName();
            Integer commanderdamages = subformat.getCommanderdamages();
            int iIntValue = commanderdamages != null ? commanderdamages.intValue() : 0;
            Integer lifetotal = subformat.getLifetotal();
            int iIntValue2 = lifetotal != null ? lifetotal.intValue() : 0;
            Integer playersmax = subformat.getPlayersmax();
            int iIntValue3 = playersmax != null ? playersmax.intValue() : 0;
            Integer playersmin = subformat.getPlayersmin();
            int iIntValue4 = playersmin != null ? playersmin.intValue() : 0;
            Integer timelimit = subformat.getTimelimit();
            int iIntValue5 = timelimit != null ? timelimit.intValue() : 0;
            Integer bestof = subformat.getBestof();
            writableDatabase.execSQL("\n                INSERT OR IGNORE INTO subformats (id, name, commanderdamages, lifetotal, \n                                     playersmax, playersmin, timelimit, bestof)\n                VALUES (" + id + ", '" + name + "', " + iIntValue + ", " + iIntValue2 + ", \n                         " + iIntValue3 + ", " + iIntValue4 + ", " + iIntValue5 + ", " + (bestof != null ? bestof.intValue() : 0) + ")\n                ");
            writableDatabase.execSQL("\n                INSERT OR IGNORE INTO format_subformats (formatid, subformatid)\n                VALUES (" + forFormat.getId() + ", " + subformat.getId() + ")\n                ");
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while adding formats", e);
        }
    }

    public final void clearFormats() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM formats");
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while clearing all formats", e);
        }
    }

    public final void clearSubformats() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM subformats");
            writableDatabase.execSQL("DELETE FROM format_subformats");
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while clearing all subformats", e);
        }
    }

    public final List<MTCardTag> getAllTags() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM tags ORDER BY tag_name", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tag_name"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("parent_tag"));
                    boolean z = true;
                    if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("is_root")) != 1) {
                        z = false;
                    }
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    arrayList.add(new MTCardTag(string, string2, string3, string4, z, string5, string6));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting tags", e);
            return arrayList;
        }
    }

    public final List<MTDeckTheme> getAllThemes() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM themes ORDER BY theme_name", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_id"));
                    Intrinsics.checkNotNull(readableDatabase);
                    Intrinsics.checkNotNull(string);
                    List<MTThemeTag> tagsForTheme = getTagsForTheme(readableDatabase, string);
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_name"));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_name_fr"));
                    if (string3 == null) {
                        string3 = "";
                    }
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                    if (string5 == null) {
                        string5 = "";
                    }
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    arrayList.add(new MTDeckTheme(string, string2, string3, string4, string5, string6, string7, tagsForTheme));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting themes", e);
            return arrayList;
        }
    }

    public final List<MTFormat> getFormats() {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        String str = "getString(...)";
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM formats", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("id"));
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("name"));
                    Intrinsics.checkNotNullExpressionValue(string, str);
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("commanderdamages"));
                    int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("decksizemax"));
                    int i4 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("decksizemin"));
                    boolean z2 = false;
                    if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("hascommander")) == 1) {
                        z = false;
                        z2 = true;
                    } else {
                        z = false;
                    }
                    boolean z3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("hassideboard")) == 1 ? true : z;
                    int i5 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("lifetotal"));
                    int i6 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("playersmax"));
                    int i7 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("playersmin"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("scryfallid"));
                    Intrinsics.checkNotNullExpressionValue(string2, str);
                    String str2 = str;
                    sQLiteDatabase = readableDatabase;
                    arrayList.add(new MTFormat(i, string, i2, i3, i4, z2, z3, i5, i6, i7, string2, cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("sideboardsizemax")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("singleton")) == 1, cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("timelimit")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("bestof")), cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("color")), cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("icon")), null, 131072, null));
                    if (!cursorRawQuery.moveToNext()) {
                        break;
                    }
                    str = str2;
                    readableDatabase = sQLiteDatabase;
                }
            } else {
                sQLiteDatabase = readableDatabase;
            }
            cursorRawQuery.close();
            sQLiteDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting formats", e);
            return arrayList;
        }
    }

    public final List<MTCardTag> getRootTags() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM tags WHERE is_root = 1 ORDER BY tag_name", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tag_name"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("parent_tag"));
                    boolean z = true;
                    if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("is_root")) != 1) {
                        z = false;
                    }
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    arrayList.add(new MTCardTag(string, string2, string3, string4, z, string5, string6));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting root tags", e);
            return arrayList;
        }
    }

    public final List<MTCardTag> getSubTags(String parentTag) {
        Intrinsics.checkNotNullParameter(parentTag, "parentTag");
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM tags WHERE parent_tag = ? ORDER BY tag_name", new String[]{parentTag});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tag_name"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("parent_tag"));
                    boolean z = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("is_root")) == 1;
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    arrayList.add(new MTCardTag(string, string2, string3, string4, z, string5, string6));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting subtags for parent: " + parentTag, e);
            return arrayList;
        }
    }

    public final List<MTSubformat> getSubformats(int forFormatId) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM format_subformats WHERE formatid = " + forFormatId, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    Cursor cursorRawQuery2 = readableDatabase.rawQuery("SELECT * FROM subformats WHERE id = " + cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("subformatid")), null);
                    Intrinsics.checkNotNullExpressionValue(cursorRawQuery2, "rawQuery(...)");
                    if (cursorRawQuery2.moveToFirst()) {
                        int i = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("id"));
                        String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("name"));
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        arrayList.add(new MTSubformat(i, string, Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("commanderdamages"))), Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("lifetotal"))), Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("playersmax"))), Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("playersmin"))), Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("timelimit"))), Integer.valueOf(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("bestof")))));
                    }
                    cursorRawQuery2.close();
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting formats", e);
            return arrayList;
        }
    }

    public final MTCardTag getTagByName(String tagName) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        MTCardTag mTCardTag = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM tags WHERE tag_name = ?", new String[]{tagName});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tag_name"));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("parent_tag"));
                boolean z = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("is_root")) == 1;
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                mTCardTag = new MTCardTag(string, string2, string3, string4, z, string5, string6);
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return mTCardTag;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting tag: " + tagName, e);
            return mTCardTag;
        }
    }

    public final MTDeckTheme getThemeById(String themeId) {
        String str;
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        MTDeckTheme mTDeckTheme = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM themes WHERE theme_id = ?", new String[]{themeId});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                Intrinsics.checkNotNull(readableDatabase);
                List<MTThemeTag> tagsForTheme = getTagsForTheme(readableDatabase, themeId);
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_name"));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_name_fr"));
                String str2 = string2 == null ? "" : string2;
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                String str3 = string4 == null ? "" : string4;
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                str = themeId;
                try {
                    mTDeckTheme = new MTDeckTheme(str, string, str2, string3, str3, string5, string6, tagsForTheme);
                } catch (SQLiteException e) {
                    e = e;
                    Log.e("DecksDBHelper", "Error while getting theme: " + str, e);
                    return mTDeckTheme;
                }
            } else {
                str = themeId;
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return mTDeckTheme;
        } catch (SQLiteException e2) {
            e = e2;
            str = themeId;
        }
    }

    public final List<MTDeckTheme> getThemesByTag(String tagName) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT DISTINCT t.* FROM themes t\nINNER JOIN theme_tags tt ON t.theme_id = tt.theme_id\nWHERE tt.tag_name = ?\nORDER BY t.theme_name", new String[]{tagName});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_id"));
                    Intrinsics.checkNotNull(readableDatabase);
                    Intrinsics.checkNotNull(string);
                    List<MTThemeTag> tagsForTheme = getTagsForTheme(readableDatabase, string);
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_name"));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("theme_name_fr"));
                    if (string3 == null) {
                        string3 = "";
                    }
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_en"));
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("description_fr"));
                    if (string5 == null) {
                        string5 = "";
                    }
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("created_at"));
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("updated_at"));
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    arrayList.add(new MTDeckTheme(string, string2, string3, string4, string5, string6, string7, tagsForTheme));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("DecksDBHelper", "Error while getting themes by tag: " + tagName, e);
            return arrayList;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase p0) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase p0, int p1, int p2) {
    }
}
