package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class er {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f308a = new com.google.android.play.core.assetpacks.internal.o("PackMetadataManager");
    private final bm b;
    private final et c;

    er(bm bmVar, et etVar) {
        this.b = bmVar;
        this.c = etVar;
    }

    final String a(String str) {
        if (!this.b.G(str)) {
            return "";
        }
        et etVar = this.c;
        bm bmVar = this.b;
        int iA = etVar.a();
        File fileK = bmVar.k(str, iA, bmVar.c(str));
        try {
            if (!fileK.exists()) {
                return String.valueOf(iA);
            }
            FileInputStream fileInputStream = new FileInputStream(fileK);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                String property = properties.getProperty("moduleVersionTag");
                return property == null ? String.valueOf(iA) : property;
            } finally {
            }
        } catch (IOException unused) {
            f308a.b("Failed to read pack version tag for pack %s", str);
            return "";
        }
    }

    final void b(String str, int i, long j, String str2) throws IOException {
        if (str2 == null || str2.isEmpty()) {
            str2 = String.valueOf(i);
        }
        Properties properties = new Properties();
        properties.put("moduleVersionTag", str2);
        File fileK = this.b.k(str, i, j);
        fileK.getParentFile().mkdirs();
        fileK.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(fileK);
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
