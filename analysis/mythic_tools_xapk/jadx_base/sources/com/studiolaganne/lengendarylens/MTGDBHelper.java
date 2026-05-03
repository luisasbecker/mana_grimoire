package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
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
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MTGDBHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 g2\u00020\u0001:\u0002ghB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\u0002J\u001c\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\u0002J\u001a\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010H\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010H\u0002J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0012H\u0002J(\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u000e\u0010&\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(H\u0002J\b\u0010)\u001a\u00020*H\u0002J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0010J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0010J\u0016\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0013J\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u00109\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0006\u0010<\u001a\u00020,J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u00103\u001a\u00020\u0012J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u0010@\u001a\u00020\u0012J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0002J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020\u0019J,\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020,0H2\u0018\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010J7\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00122\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020,0OH\u0002¢\u0006\u0002\u0010PJ\u001a\u0010Q\u001a\u0004\u0018\u00010,2\u0006\u0010R\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u0013J\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u0013J\u001a\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u0013J\u001a\u0010V\u001a\u0004\u0018\u00010\u00122\u0006\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u0013J(\u0010W\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0013J0\u0010Z\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00132\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0012J\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\u0012J\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010X\u001a\u00020\u0012J\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010X\u001a\u00020\u0012J\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010X\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\u0012J\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u00103\u001a\u00020\u0012J\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u00103\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0013J,\u0010c\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u0012J$\u0010`\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0006\u0010e\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dbFile", "Ljava/io/File;", "initialize", "", "useDatabase", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Landroid/database/sqlite/SQLiteDatabase;", "readDatabaseFromAssets", "findDbFilesInContext", "", "Lkotlin/Pair;", "", "", "findDbFilesInAssets", "extractVersionFromFilename", "filename", "(Ljava/lang/String;)Ljava/lang/Integer;", "copyDatabaseFromAssets", "", "cleanUpOldVersions", "isDatabaseValid", "dbFilePath", "getVersion", "isValid", "getLang", "doesTableExist", UserDataStore.DATE_OF_BIRTH, "tableName", "logFirebaseEvent", "eventName", "message", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getAvailableStorage", "", "getAllPlanes", "Lcom/studiolaganne/lengendarylens/CardRecord;", "getAllSchemes", "getOracleForCard", "oracleId", OptionalModuleUtils.FACE, "searchForPlaneswalker", "Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "searchTitle", "searchForLegendaryCreatureOrPlaneswalker", "searchForUncommonCreature", "searchForCanBeYourCommander", "searchForBackground", "searchForFriendsForever", "searchForDoctorCompanion", "searchForDoctor", "searchForInstantOrSorcery", "getRandomCard", "getCardsByTitleMatchingWords", "getCardsByTitleMatchingWordsWithWildcards", "getCardsByTitleMatchingSingleWord", "word", "buildSqlQuery", "rootElement", "Lcom/studiolaganne/lengendarylens/SearchElement;", "getFullCardsBySearchQuery", "searchQuery", "condense", "getCardsByScryFallIds", "", "scryfallIds", "queryCards", "queryStr", "parameters", "", "results", "", "(Ljava/lang/String;[Ljava/lang/String;Ljava/util/Map;)V", "getCardByScryFallId", "scryfallId", "getAllPrints", "getFirstPrintInfo", "Lcom/studiolaganne/lengendarylens/MTGDBHelper$FirstPrintInfo;", "getFirstPrintScryfallId", "getCardByOracleIdAndPrintData", "setCode", "cardNumber", "getCardByOracleIdAndOptionalPrintData", "getRowsWithBottomTextContaining", "dateStr", "numberStr", "getAllCardsFromSet", "getAllPrintsFromSet", "getPartialMatch", "getCardsByTitle", "getCardsByTitleAndFace", "getExactMatch", Constants.GP_IAP_TITLE, "set", "number", "Companion", "FirstPrintInfo", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTGDBHelper extends UpdatableMTGHelper {
    private static final String DATABASE_PREFIX = "cards_";
    private static final String DATABASE_SUFFIX = ".db";
    private static MTGDBHelper instance;
    private final Context context;
    private File dbFile;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MTGDBHelper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGDBHelper$Companion;", "", "<init>", "()V", "DATABASE_PREFIX", "", "DATABASE_SUFFIX", "instance", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized MTGDBHelper getInstance(Context context) {
            MTGDBHelper mTGDBHelper;
            Intrinsics.checkNotNullParameter(context, "context");
            if (MTGDBHelper.instance == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                MTGDBHelper.instance = new MTGDBHelper(applicationContext, null);
            }
            mTGDBHelper = MTGDBHelper.instance;
            Intrinsics.checkNotNull(mTGDBHelper);
            return mTGDBHelper;
        }
    }

    /* JADX INFO: compiled from: MTGDBHelper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGDBHelper$FirstPrintInfo;", "", "scryfallId", "", "setCode", "collectorNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScryfallId", "()Ljava/lang/String;", "getSetCode", "getCollectorNumber", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FirstPrintInfo {
        public static final int $stable = 0;
        private final String collectorNumber;
        private final String scryfallId;
        private final String setCode;

        public FirstPrintInfo(String scryfallId, String setCode, String collectorNumber) {
            Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
            Intrinsics.checkNotNullParameter(setCode, "setCode");
            Intrinsics.checkNotNullParameter(collectorNumber, "collectorNumber");
            this.scryfallId = scryfallId;
            this.setCode = setCode;
            this.collectorNumber = collectorNumber;
        }

        public static /* synthetic */ FirstPrintInfo copy$default(FirstPrintInfo firstPrintInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = firstPrintInfo.scryfallId;
            }
            if ((i & 2) != 0) {
                str2 = firstPrintInfo.setCode;
            }
            if ((i & 4) != 0) {
                str3 = firstPrintInfo.collectorNumber;
            }
            return firstPrintInfo.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getScryfallId() {
            return this.scryfallId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSetCode() {
            return this.setCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCollectorNumber() {
            return this.collectorNumber;
        }

        public final FirstPrintInfo copy(String scryfallId, String setCode, String collectorNumber) {
            Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
            Intrinsics.checkNotNullParameter(setCode, "setCode");
            Intrinsics.checkNotNullParameter(collectorNumber, "collectorNumber");
            return new FirstPrintInfo(scryfallId, setCode, collectorNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FirstPrintInfo)) {
                return false;
            }
            FirstPrintInfo firstPrintInfo = (FirstPrintInfo) other;
            return Intrinsics.areEqual(this.scryfallId, firstPrintInfo.scryfallId) && Intrinsics.areEqual(this.setCode, firstPrintInfo.setCode) && Intrinsics.areEqual(this.collectorNumber, firstPrintInfo.collectorNumber);
        }

        public final String getCollectorNumber() {
            return this.collectorNumber;
        }

        public final String getScryfallId() {
            return this.scryfallId;
        }

        public final String getSetCode() {
            return this.setCode;
        }

        public int hashCode() {
            return (((this.scryfallId.hashCode() * 31) + this.setCode.hashCode()) * 31) + this.collectorNumber.hashCode();
        }

        public String toString() {
            return "FirstPrintInfo(scryfallId=" + this.scryfallId + ", setCode=" + this.setCode + ", collectorNumber=" + this.collectorNumber + ")";
        }
    }

    private MTGDBHelper(Context context) {
        super(context);
        this.context = context;
        initialize();
    }

    public /* synthetic */ MTGDBHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final String buildSqlQuery(SearchElement rootElement) {
        return "SELECT \n    c.oracle_id as c_oracle_id,\n    p.scryfall_id as p_scryfall_id,\n    p.number as p_number,\n    p.face as p_face,\n    c.title as c_title,\n    p.`set` as p_set,\n    c.type_line as c_type_line,\n    c.oracle_text as c_oracle_text,\n    c.mana_cost as c_mana_cost,\n    c.int_field_1 as c_int_field_1,\n    c.int_field_2 as c_int_field_2,\n    c.layout as c_layout,\n    c.identity as c_identity\nFROM cards_fts f\nJOIN cards c ON f.docid = c.rowid\nJOIN prints p ON c.oracle_id = p.oracle_id WHERE " + SearchDataUtils.searchElementToSql$default(SearchDataUtils.INSTANCE.getInstance(), rootElement, "en", false, 4, null);
    }

    private final void cleanUpOldVersions() {
        String str = "cards_en_" + getCurrentVersion() + DATABASE_SUFFIX;
        String[] strArrDatabaseList = this.context.databaseList();
        Intrinsics.checkNotNullExpressionValue(strArrDatabaseList, "databaseList(...)");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrDatabaseList) {
            String str3 = str2;
            Intrinsics.checkNotNull(str3);
            if (StringsKt.startsWith$default(str3, "cards_en", false, 2, (Object) null) && StringsKt.endsWith$default(str3, DATABASE_SUFFIX, false, 2, (Object) null) && !Intrinsics.areEqual(str3, str)) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.context.getDatabasePath((String) it.next()).delete();
        }
    }

    private final boolean copyDatabaseFromAssets(String filename) {
        try {
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
                return true;
            } finally {
            }
        } catch (Exception e) {
            Log.e("MTGDBHelper", "Error copying database from assets", e);
            logFirebaseEvent("cards_en_mtg_db_copy_failed", "Error copying database from assets", e);
            return false;
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
        } catch (SQLiteDatabaseCorruptException e) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("cards_en_mtg_db_corrupt");
            logFirebaseEvent("cards_en_mtg_db_corrupt", "Database is corrupt", e);
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
                if (StringsKt.startsWith$default(str, "cards_en", false, 2, (Object) null) && StringsKt.endsWith$default(str, DATABASE_SUFFIX, false, 2, (Object) null)) {
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
            if (StringsKt.startsWith$default(str2, "cards_en", false, 2, (Object) null) && StringsKt.endsWith$default(str2, DATABASE_SUFFIX, false, 2, (Object) null)) {
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

    static final Unit getAllCardsFromSet$lambda$0(String str, String str2, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
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
                    String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cursor = cursorRawQuery;
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
                    cardRecord.setLang("en");
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
                    Intrinsics.checkNotNull(string12);
                    cardRecord.setAndroid_hash(string12);
                    list.add(cardRecord);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    cursorRawQuery = cursor;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getAllPlanes$lambda$0(String str, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_identity"));
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
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setIdentity(string6);
                    ((List) objectRef.element).add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    public static /* synthetic */ List getAllPrints$default(MTGDBHelper mTGDBHelper, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelper.getAllPrints(str, i);
    }

    static final Unit getAllPrints$lambda$0(String str, String str2, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("android_hash"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cardRecord.setOracle_id(str2);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setScryfall_id(string);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setNumber(string2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setSet(string3);
                    cardRecord.setFace(i);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setAndroid_hash(string4);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getAllPrintsFromSet$lambda$0(String str, String str2, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
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
                    String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cursor = cursorRawQuery;
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
                    cardRecord.setLang("en");
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
                    Intrinsics.checkNotNull(string12);
                    cardRecord.setAndroid_hash(string12);
                    list.add(cardRecord);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    cursorRawQuery = cursor;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getAllSchemes$lambda$0(String str, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_identity"));
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
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setIdentity(string6);
                    ((List) objectRef.element).add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    private final long getAvailableStorage() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public static /* synthetic */ CardRecord getCardByOracleIdAndOptionalPrintData$default(MTGDBHelper mTGDBHelper, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return mTGDBHelper.getCardByOracleIdAndOptionalPrintData(str, i, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a7  */
    /* JADX WARN: Type inference failed for: r13v0, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit getCardByOracleIdAndOptionalPrintData$lambda$0(String str, int i, MTGDBHelper mTGDBHelper, String str2, String str3, Ref.ObjectRef objectRef, SQLiteDatabase db) {
        Cursor cursorRawQuery;
        Cursor cursor;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            cursorRawQuery = db.rawQuery("SELECT * FROM cards WHERE oracle_id = ? AND face = ?", new String[]{str, String.valueOf(i)});
            try {
                cursor = cursorRawQuery;
            } finally {
            }
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
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
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en_flexible");
            firebaseAnalytics.logEvent("db_error_en_flexible", bundle);
        }
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
        cardRecord.setLang("en");
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
                String string9 = cursor2.getString(cursor2.getColumnIndexOrThrow("android_hash"));
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                cardRecord.setAndroid_hash(string9);
                cardRecord.setBottom_text(cursor2.getString(cursor2.getColumnIndexOrThrow("bottom_text")));
                objectRef.element = cardRecord;
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorRawQuery, null);
            Unit unit3 = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorRawQuery, null);
            return Unit.INSTANCE;
        } finally {
        }
        FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(mTGDBHelper.context);
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
        Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en_flexible");
        firebaseAnalytics2.logEvent("db_error_en_flexible", bundle2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit getCardByOracleIdAndPrintData$lambda$0(String str, CardRecord cardRecord, String str2, String str3, String str4, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        File file;
        MTGDBHelper mTGDBHelper2;
        File file2;
        File file3;
        File file4;
        Cursor cursorRawQuery;
        Cursor cursor;
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
                    try {
                        cursorRawQuery = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + str2 + "' AND `set` = '" + str3 + "' AND number = '" + str4 + "' AND face = " + i, null);
                        Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
                    } catch (SQLiteException e) {
                        e = e;
                        file = null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    file = null;
                }
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("scryfall_id"));
                        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                        cardRecord.setScryfall_id(string6);
                        cardRecord.setSet(str3);
                        cardRecord.setNumber(str4);
                        cardRecord.setFace(i);
                        String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("android_hash"));
                        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                        cardRecord.setAndroid_hash(string7);
                        cardRecord.setBottom_text(cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("bottom_text")));
                        objectRef.element = cardRecord;
                        cursor = cursorRawQuery;
                        file = null;
                    } else {
                        cursor = cursorRawQuery;
                        try {
                            Cursor cursorRawQuery3 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + str2 + "' AND face = " + i + " AND `set` = '" + str3 + "'", null);
                            Intrinsics.checkNotNullExpressionValue(cursorRawQuery3, "rawQuery(...)");
                            if (cursorRawQuery3.moveToFirst()) {
                                String string8 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("scryfall_id"));
                                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                                cardRecord.setScryfall_id(string8);
                                cardRecord.setSet(str3);
                                String string9 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("number"));
                                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                                cardRecord.setNumber(string9);
                                cardRecord.setFace(i);
                                String string10 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("android_hash"));
                                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                                cardRecord.setAndroid_hash(string10);
                                cardRecord.setBottom_text(cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("bottom_text")));
                                objectRef.element = cardRecord;
                                file = null;
                            } else {
                                file = null;
                                try {
                                    Cursor cursorRawQuery4 = db.rawQuery("SELECT * FROM prints WHERE oracle_id = '" + str2 + "' AND face = " + i, null);
                                    Intrinsics.checkNotNullExpressionValue(cursorRawQuery4, "rawQuery(...)");
                                    if (cursorRawQuery4.moveToFirst()) {
                                        String string11 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("scryfall_id"));
                                        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                                        cardRecord.setScryfall_id(string11);
                                        String string12 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("set"));
                                        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                                        cardRecord.setSet(string12);
                                        String string13 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("number"));
                                        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                                        cardRecord.setNumber(string13);
                                        cardRecord.setFace(i);
                                        String string14 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("android_hash"));
                                        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                                        cardRecord.setAndroid_hash(string14);
                                        cardRecord.setBottom_text(cursorRawQuery4.getString(cursorRawQuery4.getColumnIndexOrThrow("bottom_text")));
                                        objectRef.element = cardRecord;
                                    }
                                    cursorRawQuery4.close();
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    mTGDBHelper2 = mTGDBHelper;
                                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper2.context);
                                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                                    Bundle bundle = new Bundle();
                                    bundle.putString("language_code", "en");
                                    bundle.putString(SearchIntents.EXTRA_QUERY, str);
                                    bundle.putString("exception", e.getLocalizedMessage());
                                    file2 = mTGDBHelper2.dbFile;
                                    if (file2 == null) {
                                    }
                                    bundle.putBoolean("db_exists", file2.exists());
                                    file3 = mTGDBHelper2.dbFile;
                                    if (file3 == null) {
                                    }
                                    bundle.putLong("db_size", file4.length());
                                    Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
                                    firebaseAnalytics.logEvent("db_error_en", bundle);
                                }
                            }
                            cursorRawQuery3.close();
                        } catch (SQLiteException e4) {
                            e = e4;
                            file = null;
                            mTGDBHelper2 = mTGDBHelper;
                            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(mTGDBHelper2.context);
                            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("language_code", "en");
                            bundle2.putString(SearchIntents.EXTRA_QUERY, str);
                            bundle2.putString("exception", e.getLocalizedMessage());
                            file2 = mTGDBHelper2.dbFile;
                            if (file2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                                file2 = file;
                            }
                            bundle2.putBoolean("db_exists", file2.exists());
                            file3 = mTGDBHelper2.dbFile;
                            if (file3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                                file4 = file;
                            } else {
                                file4 = file3;
                            }
                            bundle2.putLong("db_size", file4.length());
                            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
                            firebaseAnalytics2.logEvent("db_error_en", bundle2);
                        }
                    }
                    cursor.close();
                } catch (SQLiteException e5) {
                    e = e5;
                    mTGDBHelper2 = mTGDBHelper;
                    file = null;
                    FirebaseAnalytics firebaseAnalytics22 = FirebaseAnalytics.getInstance(mTGDBHelper2.context);
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics22, "getInstance(...)");
                    Bundle bundle22 = new Bundle();
                    bundle22.putString("language_code", "en");
                    bundle22.putString(SearchIntents.EXTRA_QUERY, str);
                    bundle22.putString("exception", e.getLocalizedMessage());
                    file2 = mTGDBHelper2.dbFile;
                    if (file2 == null) {
                    }
                    bundle22.putBoolean("db_exists", file2.exists());
                    file3 = mTGDBHelper2.dbFile;
                    if (file3 == null) {
                    }
                    bundle22.putLong("db_size", file4.length());
                    Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en");
                    firebaseAnalytics22.logEvent("db_error_en", bundle22);
                }
            } else {
                file = null;
            }
            cursorRawQuery2.close();
        } catch (SQLiteException e6) {
            e = e6;
            file = null;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ CardRecord getCardByScryFallId$default(MTGDBHelper mTGDBHelper, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelper.getCardByScryFallId(str, i);
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    static final Unit getCardByScryFallId$lambda$0(String str, String str2, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_keywords"));
                String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
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
                cardRecord.setLang("en");
                Intrinsics.checkNotNull(string5);
                cardRecord.setMana_cost(string5);
                Intrinsics.checkNotNull(string6);
                cardRecord.setInt_field_1(string6);
                Intrinsics.checkNotNull(string7);
                cardRecord.setInt_field_2(string7);
                Intrinsics.checkNotNull(string10);
                cardRecord.setIdentity(string10);
                Intrinsics.checkNotNull(string11);
                cardRecord.setKeywords(string11);
                Intrinsics.checkNotNull(string12);
                cardRecord.setLayout(string12);
                objectRef.element = cardRecord;
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file2 = mTGDBHelper.dbFile;
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

    static final CharSequence getCardsByScryFallIds$lambda$4(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "?";
    }

    static final CharSequence getCardsByScryFallIds$lambda$5(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "?";
    }

    static final Unit getCardsByTitle$lambda$0(String str, String str2, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_bottom_text"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                    String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                    String string13 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cursor = cursorRawQuery;
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    cardRecord.setBottom_text(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setAndroid_hash(string7);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setType_line(string8);
                    Intrinsics.checkNotNull(string9);
                    cardRecord.setOracle_text(string9);
                    Intrinsics.checkNotNull(string10);
                    cardRecord.setMana_cost(string10);
                    Intrinsics.checkNotNull(string11);
                    cardRecord.setInt_field_1(string11);
                    Intrinsics.checkNotNull(string12);
                    cardRecord.setInt_field_2(string12);
                    Intrinsics.checkNotNull(string13);
                    cardRecord.setLayout(string13);
                    list.add(cardRecord);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    cursorRawQuery = cursor;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getCardsByTitleAndFace$lambda$0(String str, String str2, int i, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, String.valueOf(i)});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_bottom_text"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                    String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                    String string13 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cursor = cursorRawQuery;
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    cardRecord.setBottom_text(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setAndroid_hash(string7);
                    cardRecord.setFace(i2);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setType_line(string8);
                    Intrinsics.checkNotNull(string9);
                    cardRecord.setOracle_text(string9);
                    Intrinsics.checkNotNull(string10);
                    cardRecord.setMana_cost(string10);
                    Intrinsics.checkNotNull(string11);
                    cardRecord.setInt_field_1(string11);
                    Intrinsics.checkNotNull(string12);
                    cardRecord.setInt_field_2(string12);
                    Intrinsics.checkNotNull(string13);
                    cardRecord.setLayout(string13);
                    list.add(cardRecord);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    cursorRawQuery = cursor;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getCardsByTitleMatchingSingleWord$lambda$0(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final CharSequence getCardsByTitleMatchingWords$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word : "";
    }

    static final Unit getCardsByTitleMatchingWords$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final CharSequence getCardsByTitleMatchingWordsWithWildcards$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit getCardsByTitleMatchingWordsWithWildcards$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit getExactMatch$lambda$0(String str, String str2, String str3, Ref.ObjectRef objectRef, String str4, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, str3, objectRef.element, str4});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_bottom_text"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setBottom_text(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setAndroid_hash(string7);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setLayout(string8);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    public static /* synthetic */ FirstPrintInfo getFirstPrintInfo$default(MTGDBHelper mTGDBHelper, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelper.getFirstPrintInfo(str, i);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, com.studiolaganne.lengendarylens.MTGDBHelper$FirstPrintInfo] */
    static final Unit getFirstPrintInfo$lambda$0(String str, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        File file = null;
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("scryfall_id"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("set"));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("number"));
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string3);
                objectRef.element = new FirstPrintInfo(string, string2, string3);
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    public static /* synthetic */ String getFirstPrintScryfallId$default(MTGDBHelper mTGDBHelper, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mTGDBHelper.getFirstPrintScryfallId(str, i);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    static final Unit getFirstPrintScryfallId$lambda$0(String str, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getFullCardsBySearchQuery$lambda$0(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
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
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_identity"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    cursor = cursorRawQuery;
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
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setMana_cost(string5);
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setInt_field_1(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setInt_field_2(string7);
                    Intrinsics.checkNotNull(string11);
                    cardRecord.setIdentity(string11);
                    list.add(cardRecord);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    cursorRawQuery = cursor;
                }
            } else {
                cursor = cursorRawQuery;
            }
            cursor.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file2 = mTGDBHelper.dbFile;
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

    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object, java.lang.String] */
    static final Unit getOracleForCard$lambda$0(String str, String str2, String str3, Ref.ObjectRef objectRef, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("en_db_error");
            firebaseAnalytics.logEvent("en_db_error", bundle);
        }
        return Unit.INSTANCE;
    }

    static final Unit getPartialMatch$lambda$0(String str, String str2, String str3, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, str3});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_bottom_text"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
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
                    cardRecord.setBottom_text(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setAndroid_hash(string7);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setLayout(string8);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit getPartialMatch$lambda$1(String str, String str2, Ref.ObjectRef objectRef, String str3, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{str2, objectRef.element, str3});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_bottom_text"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    cardRecord.setFace(i);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    cardRecord.setBottom_text(string6);
                    Intrinsics.checkNotNull(string7);
                    cardRecord.setAndroid_hash(string7);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setLayout(string8);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit getRandomCard$lambda$0(String str, CardRecord cardRecord, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
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
                String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_identity"));
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
                cardRecord.setLang("en");
                Intrinsics.checkNotNull(string6);
                cardRecord.setIdentity(string6);
            }
            cursorRawQuery.close();
        } catch (SQLiteException unused) {
        }
        return Unit.INSTANCE;
    }

    static final Unit getRowsWithBottomTextContaining$lambda$0(String str, String str2, String str3, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, new String[]{"%" + str2 + "%", "%" + str3 + "%"});
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                    int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_bottom_text"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_android_hash"));
                    CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                    Intrinsics.checkNotNull(string);
                    cardRecord.setOracle_id(string);
                    Intrinsics.checkNotNull(string2);
                    cardRecord.setScryfall_id(string2);
                    cardRecord.setBottom_text(string7);
                    Intrinsics.checkNotNull(string8);
                    cardRecord.setAndroid_hash(string8);
                    Intrinsics.checkNotNull(string5);
                    cardRecord.setSet(string5);
                    Intrinsics.checkNotNull(string3);
                    cardRecord.setNumber(string3);
                    Intrinsics.checkNotNull(string4);
                    cardRecord.setTitle(string4);
                    cardRecord.setFace(i);
                    cardRecord.setLang("en");
                    Intrinsics.checkNotNull(string6);
                    cardRecord.setOracle_text(string6);
                    list.add(cardRecord);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
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
        } catch (Exception e) {
            Log.e("MTGDBHelper", "Error validating database", e);
            logFirebaseEvent("cards_en_mtg_db_validation_failed", "Error validating database", e);
            return false;
        }
    }

    private final void logFirebaseEvent(String eventName, String message, Exception exception) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        bundle.putString(AndroidContextPlugin.DEVICE_KEY, Build.MANUFACTURER + " " + Build.MODEL);
        bundle.putString("android_version", Build.VERSION.RELEASE);
        bundle.putLong("free_space_bytes", getAvailableStorage());
        File file = this.dbFile;
        if (file != null) {
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putString("database_path", file.getPath());
        }
        if (exception != null) {
            String localizedMessage = exception.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            bundle.putString("exception_message", localizedMessage);
            bundle.putString("exception_type", exception.getClass().getSimpleName());
            bundle.putString("stack_trace", Log.getStackTraceString(exception));
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent(eventName, bundle);
    }

    private final void queryCards(final String queryStr, final String[] parameters, final Map<String, CardRecord> results) {
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.queryCards$lambda$0(queryStr, parameters, results, this, (SQLiteDatabase) obj);
            }
        });
    }

    static final Unit queryCards$lambda$0(String str, String[] strArr, Map map, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            Cursor cursorRawQuery = db.rawQuery(str, strArr);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_id"));
                int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("p_face"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_scryfall_id"));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_title"));
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_type_line"));
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_oracle_text"));
                String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_mana_cost"));
                String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_1"));
                String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_int_field_2"));
                String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_set"));
                String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("p_number"));
                String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_identity"));
                String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_keywords"));
                String string13 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("c_layout"));
                int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("p_border_color");
                String string14 = cursorRawQuery.isNull(columnIndexOrThrow) ? "unknown" : cursorRawQuery.getString(columnIndexOrThrow);
                CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                Intrinsics.checkNotNull(string2);
                cardRecord.setScryfall_id(string2);
                Intrinsics.checkNotNull(string);
                cardRecord.setOracle_id(string);
                cardRecord.setFace(i);
                Intrinsics.checkNotNull(string3);
                cardRecord.setTitle(string3);
                Intrinsics.checkNotNull(string4);
                cardRecord.setType_line(string4);
                Intrinsics.checkNotNull(string5);
                cardRecord.setOracle_text(string5);
                Intrinsics.checkNotNull(string9);
                cardRecord.setSet(string9);
                Intrinsics.checkNotNull(string10);
                cardRecord.setNumber(string10);
                cardRecord.setLang("en");
                Intrinsics.checkNotNull(string6);
                cardRecord.setMana_cost(string6);
                Intrinsics.checkNotNull(string7);
                cardRecord.setInt_field_1(string7);
                Intrinsics.checkNotNull(string8);
                cardRecord.setInt_field_2(string8);
                Intrinsics.checkNotNull(string11);
                cardRecord.setIdentity(string11);
                Intrinsics.checkNotNull(string12);
                cardRecord.setKeywords(string12);
                Intrinsics.checkNotNull(string13);
                cardRecord.setLayout(string13);
                cardRecord.setBorder_color(string14);
                map.put(string2 + "_" + i, cardRecord);
                cursorRawQuery = cursorRawQuery;
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file = mTGDBHelper.dbFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            bundle.putBoolean("db_exists", file.exists());
            File file3 = mTGDBHelper.dbFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
            } else {
                file2 = file3;
            }
            bundle.putLong("db_size", file2.length());
            Breadcrumbs.INSTANCE.leaveBreadcrumb("db_error_en_batch");
            firebaseAnalytics.logEvent("db_error_en_batch", bundle);
        }
        return Unit.INSTANCE;
    }

    private final void readDatabaseFromAssets(Function1<? super SQLiteDatabase, Unit> action) {
        try {
            AssetManager assets = this.context.getAssets();
            File file = this.dbFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            }
            InputStream inputStreamOpen = assets.open(file.getName());
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            File fileCreateTempFile = File.createTempFile("temp_cards_db", DATABASE_SUFFIX, this.context.getCacheDir());
            SQLiteDatabase fileOutputStream = inputStreamOpen;
            try {
                InputStream inputStream = fileOutputStream;
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    fileOutputStream = SQLiteDatabase.openDatabase(fileCreateTempFile.getPath(), null, 1);
                    try {
                        SQLiteDatabase sQLiteDatabase = fileOutputStream;
                        Intrinsics.checkNotNull(sQLiteDatabase);
                        action.invoke(sQLiteDatabase);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        fileCreateTempFile.delete();
                    } finally {
                    }
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (IOException e) {
            Log.e("MTGDBHelper", "Error reading database from assets", e);
            logFirebaseEvent("cards_en_mtg_db_read_failed", "Error reading database from assets", e);
        }
    }

    static final CharSequence searchForBackground$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForBackground$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final CharSequence searchForCanBeYourCommander$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForCanBeYourCommander$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit searchForDoctor$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit searchForDoctorCompanion$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final CharSequence searchForFriendsForever$lambda$3(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        return word.length() > 0 ? "title: " + word + ProxyConfig.MATCH_ALL_SCHEMES : "";
    }

    static final Unit searchForFriendsForever$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit searchForInstantOrSorcery$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit searchForLegendaryCreatureOrPlaneswalker$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit searchForPlaneswalker$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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

    static final Unit searchForUncommonCreature$lambda$4(String str, List list, MTGDBHelper mTGDBHelper, SQLiteDatabase db) {
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
                    list.add(new MTGCardRecord(string, i, string2, string3, string4, "en", string5, null, null, null, false, 1920, null));
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        } catch (SQLiteException e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(mTGDBHelper.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("language_code", "en");
            bundle.putString(SearchIntents.EXTRA_QUERY, str);
            bundle.putString("exception", e.getLocalizedMessage());
            File file2 = mTGDBHelper.dbFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file2 = null;
            }
            bundle.putBoolean("db_exists", file2.exists());
            File file3 = mTGDBHelper.dbFile;
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
            Log.e("MTGDBHelper", "Database file not initialized.");
            return;
        }
        if (file == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                file = null;
            } catch (SQLiteCantOpenDatabaseException e) {
                Log.e("MTGDBHelper", "Database file missing, trying to read from assets...", e);
                logFirebaseEvent("cards_en_mtg_db_missing", "Database file missing", e);
                try {
                    readDatabaseFromAssets(action);
                    return;
                } catch (Exception e2) {
                    Log.e("MTGDBHelper", "Failed to open database from assets", e2);
                    logFirebaseEvent("cards_en_mtg_db_open_failed", "Failed to open database from assets", e2);
                    return;
                }
            }
        }
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getPath(), null, 1);
        try {
            SQLiteDatabase sQLiteDatabase = sQLiteDatabaseOpenDatabase;
            Intrinsics.checkNotNull(sQLiteDatabase);
            action.invoke(sQLiteDatabase);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(sQLiteDatabaseOpenDatabase, null);
        } finally {
        }
    }

    public final List<CardRecord> getAllCardsFromSet(final String setCode) {
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2,\n                    c.layout as c_layout,\n                    p.android_hash as p_android_hash\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE p_set = ? AND c.face = 0\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getAllCardsFromSet$lambda$0(str, setCode, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    public final List<CardRecord> getAllPlanes() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.identity as c_identity\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE c.layout = 'planar';\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getAllPlanes$lambda$0(str, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (List) objectRef.element;
    }

    public final List<CardRecord> getAllPrints(final String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final ArrayList arrayList = new ArrayList();
        final String str = "SELECT * FROM prints WHERE oracle_id = '" + oracleId + "' AND face = " + face;
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getAllPrints$lambda$0(str, oracleId, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getAllPrintsFromSet(final String setCode) {
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2,\n                    c.layout as c_layout,\n                    p.android_hash as p_android_hash\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE p_set = ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getAllPrintsFromSet$lambda$0(str, setCode, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    public final List<CardRecord> getAllSchemes() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.identity as c_identity\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE c.layout = 'scheme';\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getAllSchemes$lambda$0(str, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (List) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CardRecord getCardByOracleIdAndOptionalPrintData(final String oracleId, final int face, final String setCode, final String cardNumber) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardByOracleIdAndOptionalPrintData$lambda$0(oracleId, face, this, setCode, cardNumber, objectRef, (SQLiteDatabase) obj);
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
        cardRecord.setLang("en");
        final String str = "SELECT * FROM cards WHERE oracle_id = '" + oracleId + "' AND face = " + face;
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardByOracleIdAndPrintData$lambda$0(str, cardRecord, oracleId, setCode, cardNumber, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (CardRecord) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CardRecord getCardByScryFallId(final String scryfallId, int face) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final String strTrimIndent = StringsKt.trimIndent("\n            SELECT \n                c.oracle_id as c_oracle_id,\n                p.scryfall_id as p_scryfall_id,\n                p.number as p_number,\n                p.face as p_face,\n                c.title as c_title,\n                p.`set` as p_set,\n                c.type_line as c_type_line,\n                c.oracle_text as c_oracle_text,\n                c.mana_cost as c_mana_cost,\n                c.int_field_1 as c_int_field_1,\n                c.int_field_2 as c_int_field_2,\n                c.layout as c_layout,\n                c.identity as c_identity,\n                c.keywords as c_keywords\n            FROM cards c\n            JOIN prints p ON c.oracle_id = p.oracle_id\n            WHERE p.scryfall_id = '" + scryfallId + "' AND p.face = '" + face + "' LIMIT 1\n        ");
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardByScryFallId$lambda$0(strTrimIndent, scryfallId, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (CardRecord) objectRef.element;
    }

    public final Map<String, CardRecord> getCardsByScryFallIds(List<Pair<String, Integer>> scryfallIds) {
        Intrinsics.checkNotNullParameter(scryfallIds, "scryfallIds");
        if (scryfallIds.isEmpty()) {
            return MapsKt.emptyMap();
        }
        List<Pair<String, Integer>> list = scryfallIds;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Number) ((Pair) obj).getSecond()).intValue() == 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add((String) ((Pair) it.next()).getFirst());
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : list) {
            if (((Number) ((Pair) obj2).getSecond()).intValue() == 1) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        Iterator it2 = arrayList6.iterator();
        while (it2.hasNext()) {
            arrayList7.add((String) ((Pair) it2.next()).getFirst());
        }
        ArrayList arrayList8 = arrayList7;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList9 = arrayList4;
        if (!arrayList9.isEmpty()) {
            queryCards(StringsKt.trimIndent("\n            SELECT \n                c.oracle_id as c_oracle_id,\n                p.scryfall_id as p_scryfall_id,\n                p.number as p_number,\n                p.face as p_face,\n                c.title as c_title,\n                p.`set` as p_set,\n                c.type_line as c_type_line,\n                c.oracle_text as c_oracle_text,\n                c.mana_cost as c_mana_cost,\n                c.int_field_1 as c_int_field_1,\n                c.int_field_2 as c_int_field_2,\n                c.layout as c_layout,\n                c.identity as c_identity,\n                c.keywords as c_keywords,\n                p.border_color as p_border_color\n            FROM cards c\n            JOIN prints p ON c.oracle_id = p.oracle_id\n            WHERE p.scryfall_id IN (" + CollectionsKt.joinToString$default(arrayList4, ",", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return MTGDBHelper.getCardsByScryFallIds$lambda$4((String) obj3);
                }
            }, 30, null) + ") AND p.face = 0\n        "), (String[]) arrayList9.toArray(new String[0]), linkedHashMap);
        }
        ArrayList arrayList10 = arrayList8;
        if (!arrayList10.isEmpty()) {
            queryCards(StringsKt.trimIndent("\n            SELECT \n                c.oracle_id as c_oracle_id,\n                p.scryfall_id as p_scryfall_id,\n                p.number as p_number,\n                p.face as p_face,\n                c.title as c_title,\n                p.`set` as p_set,\n                c.type_line as c_type_line,\n                c.oracle_text as c_oracle_text,\n                c.mana_cost as c_mana_cost,\n                c.int_field_1 as c_int_field_1,\n                c.int_field_2 as c_int_field_2,\n                c.layout as c_layout,\n                c.identity as c_identity,\n                c.keywords as c_keywords,\n                p.border_color as p_border_color\n            FROM cards c\n            JOIN prints p ON c.oracle_id = p.oracle_id\n            WHERE p.scryfall_id IN (" + CollectionsKt.joinToString$default(arrayList8, ",", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return MTGDBHelper.getCardsByScryFallIds$lambda$5((String) obj3);
                }
            }, 30, null) + ") AND p.face = 1\n        "), (String[]) arrayList10.toArray(new String[0]), linkedHashMap);
        }
        return linkedHashMap;
    }

    public final List<CardRecord> getCardsByTitle(final String searchTitle) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    p.bottom_text as p_bottom_text,\n                    p.android_hash as p_android_hash,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2,\n                    c.layout as c_layout\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE title = ?  AND c_layout != 'art_series'\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitle$lambda$0(str, searchTitle, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getCardsByTitleAndFace(final String searchTitle, final int face) {
        Intrinsics.checkNotNullParameter(searchTitle, "searchTitle");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    p.bottom_text as p_bottom_text,\n                    p.android_hash as p_android_hash,\n                    c.type_line as c_type_line,\n                    c.oracle_text as c_oracle_text,\n                    c.mana_cost as c_mana_cost,\n                    c.int_field_1 as c_int_field_1,\n                    c.int_field_2 as c_int_field_2,\n                    c.layout as c_layout\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE title = ? AND p.face = ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitleAndFace$lambda$0(str, searchTitle, face, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> getCardsByTitleMatchingSingleWord(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        final ArrayList arrayList = new ArrayList();
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH 'title: " + StringsKt.replace$default(StringsKt.replace$default(word, "'", "''", false, 4, (Object) null), "\"", "", false, 4, (Object) null) + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitleMatchingSingleWord$lambda$0(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitleMatchingWords$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitleMatchingWords$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> getCardsByTitleMatchingWordsWithWildcards(String searchTitle) {
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitleMatchingWordsWithWildcards$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "'";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getCardsByTitleMatchingWordsWithWildcards$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [T, java.lang.String] */
    public final List<CardRecord> getExactMatch(final String title, final String set, int face, final String number) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(number, "number");
        final ArrayList arrayList = new ArrayList();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = String.valueOf(face);
        final String str = "\n                    SELECT\n                    p.oracle_id as p_oracle_id, \n                    p.scryfall_id as p_scryfall_id, \n                    p.number as p_number, \n                    p.face as p_face, \n                    c.title as c_title, \n                    c.layout as c_layout,\n                    p.`set` as p_set, \n                    c.oracle_text as c_oracle_text, \n                    p.bottom_text as p_bottom_text, \n                    p.android_hash as p_android_hash                     \n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE title = ? AND `set` = ? AND p.face = ? AND number = ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getExactMatch$lambda$0(str, title, set, objectRef, number, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FirstPrintInfo getFirstPrintInfo(String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final String str = "SELECT * FROM prints WHERE oracle_id = '" + oracleId + "' AND face = " + face + " LIMIT 1";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getFirstPrintInfo$lambda$0(str, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (FirstPrintInfo) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getFirstPrintScryfallId(String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final String str = "SELECT * FROM prints WHERE oracle_id = '" + oracleId + "' AND face = " + face + " LIMIT 1";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getFirstPrintScryfallId$lambda$0(str, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (String) objectRef.element;
    }

    public final List<CardRecord> getFullCardsBySearchQuery(SearchElement searchQuery, boolean condense) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        final ArrayList arrayList = new ArrayList();
        final String strBuildSqlQuery = buildSqlQuery(searchQuery);
        Log.d("MTGDBHelper", "SQLITE ADVANCED QUERY : " + strBuildSqlQuery);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getFullCardsBySearchQuery$lambda$0(strBuildSqlQuery, arrayList, this, (SQLiteDatabase) obj);
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

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    /* JADX INFO: renamed from: getLang */
    public String getLocale() {
        return "en";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getOracleForCard(final String oracleId, int face) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final String strValueOf = String.valueOf(face);
        final String str = "SELECT * FROM cards WHERE oracle_id = ? AND face = ?";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getOracleForCard$lambda$0(str, oracleId, strValueOf, objectRef, this, (SQLiteDatabase) obj);
            }
        });
        return (String) objectRef.element;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.lang.String] */
    public final List<CardRecord> getPartialMatch(final String set, int face, final String number) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(number, "number");
        final ArrayList arrayList = new ArrayList();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = String.valueOf(face);
        final String str = "\n                    SELECT\n                    p.oracle_id as p_oracle_id, \n                    p.scryfall_id as p_scryfall_id, \n                    p.number as p_number, \n                    p.face as p_face, \n                    c.title as c_title, \n                    p.`set` as p_set, \n                    c.oracle_text as c_oracle_text, \n                    c.layout as c_layout,\n                    p.bottom_text as p_bottom_text, \n                    p.android_hash as p_android_hash                     \n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE `set` = ? AND p.face = ? AND number = ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getPartialMatch$lambda$1(str, set, objectRef, number, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<CardRecord> getPartialMatch(final String setCode, final String numberStr) {
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        Intrinsics.checkNotNullParameter(numberStr, "numberStr");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    p.bottom_text as p_bottom_text,\n                    p.android_hash as p_android_hash,\n                    c.layout as c_layout\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE `set` = ? AND number = ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getPartialMatch$lambda$0(str, setCode, numberStr, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final CardRecord getRandomCard() {
        final CardRecord cardRecord = new CardRecord(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id,\n                    p.scryfall_id as p_scryfall_id,\n                    p.number as p_number,\n                    p.face as p_face,\n                    c.title as c_title,\n                    p.`set` as p_set,\n                    c.identity as c_identity\n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    ORDER BY RANDOM() LIMIT 1;\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getRandomCard$lambda$0(str, cardRecord, (SQLiteDatabase) obj);
            }
        });
        return cardRecord;
    }

    public final List<CardRecord> getRowsWithBottomTextContaining(final String dateStr, final String numberStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        Intrinsics.checkNotNullParameter(numberStr, "numberStr");
        final ArrayList arrayList = new ArrayList();
        final String str = "\n                    SELECT\n                    c.oracle_id as c_oracle_id, \n                    p.scryfall_id as p_scryfall_id, \n                    p.number as p_number, \n                    p.face as p_face, \n                    c.title as c_title, \n                    p.`set` as p_set, \n                    c.oracle_text as c_oracle_text, \n                    p.bottom_text as p_bottom_text, \n                    p.android_hash as p_android_hash                    \n                    FROM prints p\n                    JOIN cards c ON p.oracle_id = c.oracle_id AND p.face = c.face\n                    WHERE p.bottom_text LIKE ? AND p.bottom_text LIKE ?\n                    ";
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.getRowsWithBottomTextContaining$lambda$0(str, dateStr, numberStr, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final int getVersion() {
        return getCurrentVersion();
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    public void initialize() {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        setDbType("cards");
        List<Pair<String, Integer>> listFindDbFilesInContext = findDbFilesInContext();
        List<Pair<String, Integer>> listFindDbFilesInAssets = findDbFilesInAssets();
        List<Pair<String, Integer>> list = listFindDbFilesInContext;
        Iterator<T> it = list.iterator();
        File file = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).getSecond()).intValue();
                do {
                    Object next5 = it.next();
                    int iIntValue2 = ((Number) ((Pair) next5).getSecond()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next5;
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
                    Object next6 = it2.next();
                    int iIntValue5 = ((Number) ((Pair) next6).getSecond()).intValue();
                    if (iIntValue4 < iIntValue5) {
                        next2 = next6;
                        iIntValue4 = iIntValue5;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        Pair pair2 = (Pair) next2;
        int iIntValue6 = pair2 != null ? ((Number) pair2.getSecond()).intValue() : 0;
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            } else {
                next3 = it3.next();
                if (((Number) ((Pair) next3).getSecond()).intValue() == iIntValue3) {
                    break;
                }
            }
        }
        Pair pair3 = (Pair) next3;
        Iterator<T> it4 = list2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            } else {
                next4 = it4.next();
                if (((Number) ((Pair) next4).getSecond()).intValue() == iIntValue6) {
                    break;
                }
            }
        }
        Pair pair4 = (Pair) next4;
        if (iIntValue3 >= iIntValue6 && pair3 != null) {
            File databasePath = this.context.getDatabasePath((String) pair3.getFirst());
            Intrinsics.checkNotNullExpressionValue(databasePath, "getDatabasePath(...)");
            this.dbFile = databasePath;
            setCurrentVersion(iIntValue3);
        } else if (pair4 != null) {
            if (copyDatabaseFromAssets((String) pair4.getFirst())) {
                File databasePath2 = this.context.getDatabasePath((String) pair4.getFirst());
                Intrinsics.checkNotNullExpressionValue(databasePath2, "getDatabasePath(...)");
                this.dbFile = databasePath2;
                setCurrentVersion(iIntValue6);
            } else {
                Log.e("MTGDBHelper", "Failed to copy database from assets: " + pair4.getFirst());
                logFirebaseEvent("cards_en_mtg_db_copy_failed", "Failed to copy database from assets", null);
            }
        }
        if (!isValid()) {
            Log.e("MTGDBHelper", "Database validation failed. Deleting and retrying copy...");
            logFirebaseEvent("cards_en_mtg_db_invalid", "Database validation failed", null);
            File file2 = this.dbFile;
            if (file2 != null) {
                Context context = this.context;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dbFile");
                } else {
                    file = file2;
                }
                context.getDatabasePath(file.getName()).delete();
            }
            if (pair4 != null) {
                copyDatabaseFromAssets((String) pair4.getFirst());
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForBackground$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%legendary%' AND y.type_line LIKE '%background%'";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForBackground$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForCanBeYourCommander(String searchTitle) {
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForCanBeYourCommander$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%legendary%' AND y.type_line LIKE '%artifact%' AND y.oracle_text LIKE '%commander%' AND y.oracle_text LIKE '%your%'";
        Log.d("MTGDBHelper", "searchForLegendaryCreature FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForCanBeYourCommander$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForDoctor$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%Time Lord Doctor%'";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForDoctor$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForDoctorCompanion$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.keywords LIKE '%doctor''s companion%'";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForDoctorCompanion$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }

    public final List<MTGCardRecord> searchForFriendsForever(String searchTitle) {
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForFriendsForever$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.keywords LIKE '%friends%' AND y.keywords LIKE '%forever%'";
        Log.d("MTGDBHelper", "searchForFriendsForever FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForFriendsForever$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForInstantOrSorcery$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND (y.type_line LIKE '%instant%' OR y.type_line LIKE '%sorcery%')";
        Log.d("MTGDBHelper", "searchForBackground FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForInstantOrSorcery$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForLegendaryCreatureOrPlaneswalker$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%legendary%' AND (y.type_line LIKE '%creature%' OR y.type_line LIKE '%planeswalker%' OR y.type_line LIKE '%vehicle%' OR y.type_line LIKE '%spacecraft%')";
        Log.d("MTGDBHelper", "searchForLegendaryCreature FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForLegendaryCreatureOrPlaneswalker$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForPlaneswalker$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND y.type_line LIKE '%planeswalker%'";
        Log.d("MTGDBHelper", "searchForPlaneswalker FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForPlaneswalker$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
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
        final String str = "SELECT y.* FROM cards_fts f JOIN cards y ON f.docid = y.rowid JOIN prints p on p.oracle_id = y.oracle_id WHERE f.cards_fts MATCH '" + StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList6, " ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForUncommonCreature$lambda$3((String) obj);
            }
        }, 30, null)).toString() + "' AND (y.type_line LIKE '%creature%' OR y.type_line LIKE '%planeswalker%' OR y.type_line LIKE '%vehicle%' OR y.type_line LIKE '%spacecraft%') AND p.rarity = 'u'";
        Log.d("MTGDBHelper", "searchForUncommonCreature FTS4 QUERY : " + str);
        useDatabase(new Function1() { // from class: com.studiolaganne.lengendarylens.MTGDBHelper$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTGDBHelper.searchForUncommonCreature$lambda$4(str, arrayList, this, (SQLiteDatabase) obj);
            }
        });
        return arrayList;
    }
}
