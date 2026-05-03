package io.customer.tracking.migration.store;

import android.content.Context;
import io.customer.sdk.core.util.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lio/customer/tracking/migration/store/FileStorage;", "", "siteId", "", "context", "Landroid/content/Context;", "logger", "Lio/customer/sdk/core/util/Logger;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lio/customer/sdk/core/util/Logger;)V", "sdkRootDirectoryPath", "Ljava/io/File;", "getSdkRootDirectoryPath", "()Ljava/io/File;", "siteIdRootDirectoryPath", "getSiteIdRootDirectoryPath", "save", "", "type", "Lio/customer/tracking/migration/store/FileType;", "contents", "get", "delete", "deleteAllSdkFiles", "", "path", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileStorage {
    private final Context context;
    private final Logger logger;
    private final File sdkRootDirectoryPath;
    private final String siteId;

    public FileStorage(String siteId, Context context, Logger logger) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.siteId = siteId;
        this.context = context;
        this.logger = logger;
        this.sdkRootDirectoryPath = new File(context.getFilesDir(), "io.customer");
    }

    public static /* synthetic */ void deleteAllSdkFiles$default(FileStorage fileStorage, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            file = fileStorage.sdkRootDirectoryPath;
        }
        fileStorage.deleteAllSdkFiles(file);
    }

    public final boolean delete(FileType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        File file = new File(type.getFilePath(getSiteIdRootDirectoryPath()), type.getFileName());
        try {
            return file.delete();
        } catch (Throwable th) {
            Logger.DefaultImpls.error$default(this.logger, "error while deleting file " + type + ". path " + file.getAbsolutePath() + ". message: " + th.getMessage(), null, null, 6, null);
            return false;
        }
    }

    public final void deleteAllSdkFiles(File path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!path.isDirectory()) {
            path.delete();
            return;
        }
        String[] list = path.list();
        if (list != null) {
            for (String str : list) {
                deleteAllSdkFiles(new File(path, str));
            }
        }
    }

    public final String get(FileType type) {
        String text$default;
        Intrinsics.checkNotNullParameter(type, "type");
        File file = new File(type.getFilePath(getSiteIdRootDirectoryPath()), type.getFileName());
        if (!file.exists()) {
            return null;
        }
        try {
            text$default = FilesKt.readText$default(file, null, 1, null);
        } catch (Exception e) {
            Logger.DefaultImpls.error$default(this.logger, "error while reading file " + type + ". path " + file.getAbsolutePath() + ". message: " + e.getMessage(), null, null, 6, null);
            text$default = null;
        }
        String str = text$default;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return text$default;
    }

    public final File getSdkRootDirectoryPath() {
        return this.sdkRootDirectoryPath;
    }

    public final File getSiteIdRootDirectoryPath() {
        return new File(this.sdkRootDirectoryPath, this.siteId);
    }

    public final boolean save(FileType type, String contents) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(contents, "contents");
        File filePath = type.getFilePath(getSiteIdRootDirectoryPath());
        File file = new File(filePath, type.getFileName());
        try {
            filePath.mkdirs();
            file.createNewFile();
            FilesKt.writeText$default(file, contents, null, 2, null);
            return true;
        } catch (Throwable th) {
            Logger.DefaultImpls.error$default(this.logger, "error while saving file " + type + ". path " + file.getAbsolutePath() + ". message: " + th.getMessage(), null, null, 6, null);
            return false;
        }
    }
}
