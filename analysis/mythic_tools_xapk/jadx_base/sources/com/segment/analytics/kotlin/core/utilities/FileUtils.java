package com.segment.analytics.kotlin.core.utilities;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"createDirectory", "", FirebaseAnalytics.Param.LOCATION, "Ljava/io/File;", "removeFileExtension", "", "fileName", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FileUtils {
    public static final void createDirectory(File location) throws IOException {
        Intrinsics.checkNotNullParameter(location, "location");
        if (!location.exists() && !location.mkdirs() && !location.isDirectory()) {
            throw new IOException("Could not create directory at " + location);
        }
    }

    public static final String removeFileExtension(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) fileName, FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1 || iLastIndexOf$default <= 0) {
            return fileName;
        }
        String strSubstring = fileName.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
