package com.google.android.play.core.assetpacks;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f319a = new com.google.android.play.core.assetpacks.internal.o("SliceMetadataManager");
    private final bm c;
    private final String d;
    private final int e;
    private final long f;
    private final String g;
    private final byte[] b = new byte[8192];
    private int h = -1;

    fd(bm bmVar, String str, int i, long j, String str2) {
        this.c = bmVar;
        this.d = str;
        this.e = i;
        this.f = j;
        this.g = str2;
    }

    private final File n() {
        File fileO = this.c.o(this.d, this.e, this.f, this.g);
        if (!fileO.exists()) {
            fileO.mkdirs();
        }
        return fileO;
    }

    private final File o() throws IOException {
        File fileN = this.c.n(this.d, this.e, this.f, this.g);
        fileN.getParentFile().mkdirs();
        fileN.createNewFile();
        return fileN;
    }

    final int a() throws IOException {
        File fileN = this.c.n(this.d, this.e, this.f, this.g);
        if (!fileN.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(fileN);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new cz("Slice checkpoint file corrupt.");
        } finally {
        }
    }

    final fc b() throws IOException {
        File fileN = this.c.n(this.d, this.e, this.f, this.g);
        if (!fileN.exists()) {
            throw new cz("Slice checkpoint file does not exist.");
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(fileN);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                throw new cz("Slice checkpoint file corrupt.");
            }
            try {
                int i = Integer.parseInt(properties.getProperty("fileStatus"));
                String property = properties.getProperty("fileName");
                long j = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                long j2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                int i2 = Integer.parseInt(properties.getProperty("previousChunk"));
                this.h = Integer.parseInt(properties.getProperty("metadataFileCounter", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                return new bu(i, property, j, j2, i2);
            } catch (NumberFormatException e) {
                throw new cz("Slice checkpoint file corrupt.", e);
            }
        } finally {
        }
    }

    final File c() {
        return new File(n(), String.format("%s-NAM.dat", Integer.valueOf(this.h)));
    }

    final void d(InputStream inputStream, long j) throws IOException {
        int i;
        RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                i = inputStream.read(this.b);
                if (i > 0) {
                    randomAccessFile.write(this.b, 0, i);
                }
            } while (i >= 0);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final void e(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final void f(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_3D);
        properties.put("fileOffset", String.valueOf(c().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
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

    final void g(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
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

    final void h(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_2D);
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File fileM = this.c.m(this.d, this.e, this.f, this.g);
            if (fileM.exists()) {
                fileM.delete();
            }
            fileOutputStream = new FileOutputStream(fileM);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } finally {
        }
    }

    final void i(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
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

    final void j(byte[] bArr) throws IOException {
        this.h++;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(n(), String.format("%s-LFH.dat", Integer.valueOf(this.h))));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new cz("Could not write metadata file.", e);
        }
    }

    final void k(byte[] bArr, InputStream inputStream) throws IOException {
        this.h++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        try {
            fileOutputStream.write(bArr);
            int i = inputStream.read(this.b);
            while (i > 0) {
                fileOutputStream.write(this.b, 0, i);
                i = inputStream.read(this.b);
            }
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

    final void l(byte[] bArr, int i, int i2) throws IOException {
        this.h++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        try {
            fileOutputStream.write(bArr, 0, i2);
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

    final boolean m() {
        File fileN = this.c.n(this.d, this.e, this.f, this.g);
        if (!fileN.exists()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileN);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                f319a.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } finally {
            }
        } catch (IOException e) {
            f319a.b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        }
    }
}
