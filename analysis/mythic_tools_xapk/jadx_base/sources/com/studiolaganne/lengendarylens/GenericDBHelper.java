package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u00150\u0014H\u0002J\u001a\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u00150\u0014H\u0002J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/GenericDBHelper;", "Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;", "context", "Landroid/content/Context;", "type", "", "extension", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "prefix", "currentFile", "Ljava/io/File;", "initialize", "", "getLang", "getVersion", "", "getCurrentFile", "getCurrentFilePath", "findDbFilesInContext", "", "Lkotlin/Pair;", "findDbFilesInAssets", "extractVersionFromFilename", "filename", "(Ljava/lang/String;)Ljava/lang/Integer;", "copyDatabaseFromAssets", "cleanUpOldVersions", "isValid", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GenericDBHelper extends UpdatableMTGHelper {
    public static final int $stable = 8;
    private final Context context;
    private File currentFile;
    private final String extension;
    private String prefix;
    private final String type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericDBHelper(Context context, String type, String extension) throws IOException {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(extension, "extension");
        this.context = context;
        this.type = type;
        this.extension = extension;
        this.prefix = "unknown_";
        initialize();
    }

    public /* synthetic */ GenericDBHelper(Context context, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? ".db" : str2);
    }

    private final void cleanUpOldVersions() {
        String str = this.prefix + "en_" + getCurrentVersion() + this.extension;
        String[] strArrDatabaseList = this.context.databaseList();
        Intrinsics.checkNotNullExpressionValue(strArrDatabaseList, "databaseList(...)");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrDatabaseList) {
            String str3 = str2;
            Intrinsics.checkNotNull(str3);
            if (StringsKt.startsWith$default(str3, this.prefix + "en", false, 2, (Object) null) && StringsKt.endsWith$default(str3, this.extension, false, 2, (Object) null) && !Intrinsics.areEqual(str3, str)) {
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

    private final Integer extractVersionFromFilename(String filename) {
        List<String> groupValues;
        String str;
        try {
            kotlin.text.MatchResult matchResultFind$default = Regex.find$default(new Regex(".*_(\\d+)" + this.extension + "$"), filename, 0, 2, null);
            if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("download_db_" + this.getDbType() + "_" + this.getLang() + "_exception_reading_version", null);
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
                if (StringsKt.startsWith$default(str, this.prefix + "en", false, 2, (Object) null) && StringsKt.endsWith$default(str, this.extension, false, 2, (Object) null)) {
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
            firebaseAnalytics.logEvent("download_db_" + getDbType() + "_" + getLang() + "_exception_reading_assets", null);
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
            if (StringsKt.startsWith$default(str2, this.prefix + "en", false, 2, (Object) null) && StringsKt.endsWith$default(str2, this.extension, false, 2, (Object) null)) {
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

    public final File getCurrentFile() {
        File file = this.currentFile;
        if (file != null) {
            return file;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentFile");
        return null;
    }

    public final String getCurrentFilePath() {
        File file = this.currentFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentFile");
            file = null;
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    public String getLang() {
        return "en";
    }

    public final int getVersion() {
        return getCurrentVersion();
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    public void initialize() throws IOException {
        Object next;
        Object next2;
        setDbType(this.type);
        if (this.type.length() > 0) {
            this.prefix = this.type + "_";
        }
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
                this.currentFile = databasePath;
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
                this.currentFile = databasePath2;
                setCurrentVersion(iIntValue6);
            }
        }
        cleanUpOldVersions();
    }

    @Override // com.studiolaganne.lengendarylens.UpdatableMTGHelper
    public boolean isValid() {
        File file = this.currentFile;
        if (file == null) {
            Log.e("GenericDBHelper", "Database file not found for type: " + this.type + ".");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("initialize_db_" + getDbType() + "_" + getLang() + "_no_file_found", null);
            return false;
        }
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentFile");
            file = null;
        }
        boolean zExists = file.exists();
        File file2 = this.currentFile;
        if (!zExists) {
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentFile");
                file2 = null;
            }
            Log.e("GenericDBHelper", "Database file does not exist: " + file2.getPath() + ".");
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            firebaseAnalytics2.logEvent("initialize_db_" + getDbType() + "_" + getLang() + "_file_not_found", null);
            return false;
        }
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentFile");
            file2 = null;
        }
        if (file2.length() > 0) {
            return true;
        }
        File file3 = this.currentFile;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentFile");
            file3 = null;
        }
        Log.e("GenericDBHelper", "Database file is empty: " + file3.getPath() + ".");
        FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(this.context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
        firebaseAnalytics3.logEvent("initialize_db_" + getDbType() + "_" + getLang() + "_file_empty", null);
        return false;
    }
}
