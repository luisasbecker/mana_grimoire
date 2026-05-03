package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f320a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    static List a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file2.listFiles(new FilenameFilter() { // from class: com.google.android.play.core.assetpacks.fe
            @Override // java.io.FilenameFilter
            public final boolean accept(File file3, String str) {
                return ff.f320a.matcher(str).matches();
            }
        });
        if (fileArrListFiles != null) {
            File[] fileArr2 = new File[fileArrListFiles.length];
            int i = 0;
            while (true) {
                int length = fileArrListFiles.length;
                if (i >= length) {
                    fileArr = fileArr2;
                    break;
                }
                File file3 = fileArrListFiles[i];
                int i2 = Integer.parseInt(file3.getName().split("-")[0]);
                if (i2 > length || fileArr2[i2] != null) {
                    break;
                }
                fileArr2[i2] = file3;
                i++;
            }
            throw new cz("Metadata folder ordering corrupt.");
        }
        fileArr = new File[0];
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    fj fjVarB = new ch(fileInputStream).b();
                    if (fjVarB.c() == null) {
                        throw new cz("Metadata files corrupt. Could not read local file header.");
                    }
                    File file5 = new File(file, fjVarB.c());
                    if (!file5.exists()) {
                        throw new cz(String.format("Missing asset file %s during slice reconstruction.", file5.getCanonicalPath()));
                    }
                    arrayList.add(file5);
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }
}
