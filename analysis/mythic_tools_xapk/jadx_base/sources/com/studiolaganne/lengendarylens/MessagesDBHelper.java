package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MessagesDBHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0012J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0012J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0017J\u001c\u0010 \u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0016\u0010#\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010$\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010(\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessagesDBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dbFile", "Ljava/io/File;", "sharedPreferences", "Landroid/content/SharedPreferences;", "initialize", "", "copyDatabase", "onCreate", "p0", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "", "p2", "clearAll", "getAllMessagesForPlaygroup", "", "Lcom/studiolaganne/lengendarylens/MTMessage;", "playgroupId", "getLast100MessagesForPlaygroup", "getLast100MessagesForPlaygroupBeforeTimestamp", DiagnosticsEntry.TIMESTAMP_KEY, "", "getLatestMessageForPlaygroup", "addMessageForPlaygroup", "message", "addMessagesForPlaygroup", "messages", "lastReadTimestampForPlaygroup", "setLastReadTimestampForPlaygroup", "setLastReadMessageIdForPlaygroup", "messageId", "getUnreadMessagesCountForPlaygroup", "lastReceivedTimestampForPlaygroup", "setLastReceivedTimestampForPlaygroup", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessagesDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Messages.db";
    private static final int DATABASE_VERSION = 8;
    private static MessagesDBHelper instance;
    private final Context context;
    private final File dbFile;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MessagesDBHelper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessagesDBHelper$Companion;", "", "<init>", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "instance", "Lcom/studiolaganne/lengendarylens/MessagesDBHelper;", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized MessagesDBHelper getInstance(Context context) {
            MessagesDBHelper messagesDBHelper;
            Intrinsics.checkNotNullParameter(context, "context");
            if (MessagesDBHelper.instance == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                MessagesDBHelper.instance = new MessagesDBHelper(applicationContext, null);
            }
            messagesDBHelper = MessagesDBHelper.instance;
            Intrinsics.checkNotNull(messagesDBHelper);
            return messagesDBHelper;
        }
    }

    private MessagesDBHelper(Context context) throws IOException {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 8);
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

    public /* synthetic */ MessagesDBHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
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

    private final void initialize() throws IOException {
        int i = this.sharedPreferences.getInt("messages_databaseVersion", 0);
        if (this.dbFile.exists() && i == 8) {
            return;
        }
        copyDatabase();
        this.sharedPreferences.edit().putInt("messages_databaseVersion", 8).apply();
    }

    private final String lastReadTimestampForPlaygroup(int playgroupId) {
        String str = "";
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM last_read WHERE playgroup_id = " + playgroupId, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return str;
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while getting last read timestamp for playgroup: " + playgroupId, e);
            return str;
        }
    }

    public final void addMessageForPlaygroup(int playgroupId, MTMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String strReplace$default = StringsKt.replace$default(message.getContent(), "'", "''", false, 4, (Object) null);
            String strReplace$default2 = StringsKt.replace$default(message.getFirstname(), "'", "''", false, 4, (Object) null);
            writableDatabase.execSQL("\n                INSERT OR IGNORE INTO messages (id, content, timestamp, picture, username, firstname, userid, playgroup_id)\n                VALUES ('" + message.getId() + "', '" + strReplace$default + "', '" + message.getTimestamp() + "', '" + message.getPicture() + "', '" + message.getUsername() + "', '" + strReplace$default2 + "', '" + message.getUserid() + "', '" + playgroupId + "')\n                ");
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while adding message for playgroup: " + message.getPlaygroup_id(), e);
        }
    }

    public final void addMessagesForPlaygroup(int playgroupId, List<MTMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Log.d("MessagesDBHelper", "Adding " + messages.size() + " messages for playgroup: " + playgroupId);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            for (MTMessage mTMessage : messages) {
                String strReplace$default = StringsKt.replace$default(mTMessage.getContent(), "'", "''", false, 4, (Object) null);
                String strReplace$default2 = StringsKt.replace$default(mTMessage.getFirstname(), "'", "''", false, 4, (Object) null);
                writableDatabase.execSQL("\n                    INSERT OR IGNORE INTO messages (id, content, timestamp, picture, username, firstname, userid, playgroup_id)\n                    VALUES ('" + mTMessage.getId() + "', '" + strReplace$default + "', '" + mTMessage.getTimestamp() + "', '" + mTMessage.getPicture() + "', '" + mTMessage.getUsername() + "', '" + strReplace$default2 + "', '" + mTMessage.getUserid() + "', '" + playgroupId + "')\n                    ");
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while adding messages for playgroup: " + ((MTMessage) CollectionsKt.first((List) messages)).getPlaygroup_id(), e);
        }
    }

    public final void clearAll() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM messages");
            writableDatabase.execSQL("DELETE FROM last_read");
            writableDatabase.execSQL("DELETE FROM last_received");
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while clearing all messages", e);
        }
    }

    public final List<MTMessage> getAllMessagesForPlaygroup(int playgroupId) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM messages WHERE playgroup_id = " + playgroupId, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("id"));
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("playgroup_id"));
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(FirebaseAnalytics.Param.CONTENT));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(AuthenticationTokenClaims.JSON_KEY_PICTURE));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(HintConstants.AUTOFILL_HINT_USERNAME));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("firstname"));
                    int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("userid"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    Intrinsics.checkNotNull(string3);
                    Intrinsics.checkNotNull(string4);
                    Intrinsics.checkNotNull(string5);
                    arrayList.add(new MTMessage(i, string, string2, string3, string4, string5, i3, i2));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while getting messages for playgroup: " + playgroupId, e);
            return arrayList;
        }
    }

    public final List<MTMessage> getLast100MessagesForPlaygroup(int playgroupId) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM messages WHERE playgroup_id = " + playgroupId + " ORDER BY timestamp DESC LIMIT 100", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("id"));
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("playgroup_id"));
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(FirebaseAnalytics.Param.CONTENT));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(AuthenticationTokenClaims.JSON_KEY_PICTURE));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(HintConstants.AUTOFILL_HINT_USERNAME));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("firstname"));
                    int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("userid"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    Intrinsics.checkNotNull(string3);
                    Intrinsics.checkNotNull(string4);
                    Intrinsics.checkNotNull(string5);
                    arrayList.add(new MTMessage(i, string, string2, string3, string4, string5, i3, i2));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while getting messages for playgroup: " + playgroupId, e);
            return arrayList;
        }
    }

    public final List<MTMessage> getLast100MessagesForPlaygroupBeforeTimestamp(int playgroupId, String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM messages WHERE playgroup_id = " + playgroupId + " AND timestamp < '" + timestamp + "' ORDER BY timestamp DESC LIMIT 100", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("id"));
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("playgroup_id"));
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(FirebaseAnalytics.Param.CONTENT));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(AuthenticationTokenClaims.JSON_KEY_PICTURE));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(HintConstants.AUTOFILL_HINT_USERNAME));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("firstname"));
                    int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("userid"));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    Intrinsics.checkNotNull(string3);
                    Intrinsics.checkNotNull(string4);
                    Intrinsics.checkNotNull(string5);
                    arrayList.add(new MTMessage(i, string, string2, string3, string4, string5, i3, i2));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return arrayList;
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while getting messages for playgroup: " + playgroupId, e);
            return arrayList;
        }
    }

    public final MTMessage getLatestMessageForPlaygroup(int playgroupId) {
        MTMessage mTMessage = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM messages WHERE playgroup_id = " + playgroupId + " ORDER BY timestamp DESC LIMIT 1", null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("id"));
                int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("playgroup_id"));
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(FirebaseAnalytics.Param.CONTENT));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(AuthenticationTokenClaims.JSON_KEY_PICTURE));
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(HintConstants.AUTOFILL_HINT_USERNAME));
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("firstname"));
                int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("userid"));
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string3);
                Intrinsics.checkNotNull(string4);
                Intrinsics.checkNotNull(string5);
                mTMessage = new MTMessage(i, string, string2, string3, string4, string5, i3, i2);
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return mTMessage;
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while getting latest message for playgroup: " + playgroupId, e);
            return mTMessage;
        }
    }

    public final int getUnreadMessagesCountForPlaygroup(int playgroupId) {
        String strLastReadTimestampForPlaygroup = lastReadTimestampForPlaygroup(playgroupId);
        if (strLastReadTimestampForPlaygroup.length() > 0) {
            Log.d("MessagesDBHelper", "getUnreadMessagesCountForPlaygroup - Last read timestamp for playgroup " + playgroupId + ": " + strLastReadTimestampForPlaygroup);
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT COUNT(*) FROM messages WHERE playgroup_id = " + playgroupId + " AND timestamp > '" + strLastReadTimestampForPlaygroup + "'", null);
                Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
                i = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
                cursorRawQuery.close();
                readableDatabase.close();
                return i;
            } catch (SQLiteException e) {
                Log.e("MessagesDBHelper", "Error while getting unread messages count for playgroup: " + playgroupId, e);
                return i;
            }
        }
        Log.d("MessagesDBHelper", "getUnreadMessagesCountForPlaygroup - No last read timestamp for playgroup " + playgroupId);
        try {
            SQLiteDatabase readableDatabase2 = getReadableDatabase();
            Cursor cursorRawQuery2 = readableDatabase2.rawQuery("SELECT COUNT(*) FROM messages WHERE playgroup_id = " + playgroupId, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery2, "rawQuery(...)");
            i = cursorRawQuery2.moveToFirst() ? cursorRawQuery2.getInt(0) : 0;
            cursorRawQuery2.close();
            readableDatabase2.close();
            return i;
        } catch (SQLiteException e2) {
            Log.e("MessagesDBHelper", "Error while getting unread messages count for playgroup: " + playgroupId, e2);
            return i;
        }
    }

    public final String lastReceivedTimestampForPlaygroup(int playgroupId) {
        String str = "";
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM last_received WHERE playgroup_id = " + playgroupId, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
            }
            cursorRawQuery.close();
            readableDatabase.close();
            return str;
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while getting last read timestamp for playgroup: " + playgroupId, e);
            return str;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase p0) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase p0, int p1, int p2) {
    }

    public final void setLastReadMessageIdForPlaygroup(int playgroupId, int messageId) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String string = "";
            Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM messages WHERE id = " + messageId, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(DiagnosticsEntry.TIMESTAMP_KEY));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                cursorRawQuery.close();
            }
            String strLastReadTimestampForPlaygroup = lastReadTimestampForPlaygroup(playgroupId);
            if (string.length() > 0 && string.compareTo(strLastReadTimestampForPlaygroup) > 0) {
                setLastReadTimestampForPlaygroup(playgroupId, string);
            }
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while setting last read message id for playgroup: " + playgroupId, e);
        }
    }

    public final void setLastReadTimestampForPlaygroup(int playgroupId, String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM last_read WHERE playgroup_id = " + playgroupId);
            String str = "\n                INSERT OR REPLACE INTO last_read (playgroup_id, timestamp)\n                VALUES ('" + playgroupId + "', '" + timestamp + "')\n                ";
            Log.d("MessagesDBHelper", "Setting last read timestamp for playgroup: " + str);
            writableDatabase.execSQL(str);
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while setting last read timestamp for playgroup: " + playgroupId, e);
        }
    }

    public final void setLastReceivedTimestampForPlaygroup(int playgroupId, String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM last_received WHERE playgroup_id = " + playgroupId);
            writableDatabase.execSQL("\n                INSERT OR REPLACE INTO last_received (playgroup_id, timestamp)\n                VALUES ('" + playgroupId + "', '" + timestamp + "')\n                ");
            writableDatabase.close();
        } catch (SQLiteException e) {
            Log.e("MessagesDBHelper", "Error while setting last received timestamp for playgroup: " + playgroupId, e);
        }
    }
}
