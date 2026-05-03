package com.google.android.play.core.assetpacks;

import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ce {
    /* JADX WARN: Multi-variable type inference failed */
    static AssetLocation a(String str, String str2) throws IOException {
        AssetLocation assetLocation;
        Long lValueOf;
        long j;
        com.google.android.play.core.assetpacks.internal.aj.b(str != null, "Attempted to get file location from a null apk path.");
        com.google.android.play.core.assetpacks.internal.aj.b(str2 != null, String.format("Attempted to get file location in apk %s with a null file path.", str));
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() - 22);
        randomAccessFile.readFully(bArr);
        cd cdVarB = cc.b(bArr, 0) == 1347093766 ? b(bArr) : null;
        if (cdVarB == null) {
            long length = randomAccessFile.length();
            long jMax = (-22) + length;
            assetLocation = null;
            int iMin = (int) Math.min(1024L, randomAccessFile.length());
            byte[] bArr2 = new byte[iMin];
            byte[] bArr3 = new byte[22];
            do {
                j = length - 65558;
                if (j < 0) {
                    j = 0;
                }
                jMax = Math.max((jMax - ((long) iMin)) + 3, j);
                randomAccessFile.seek(jMax);
                randomAccessFile.readFully(bArr2);
                for (int i = iMin - 4; i >= 0; i -= 4) {
                    byte b = bArr2[i];
                    int i2 = b != 5 ? b != 6 ? b != 75 ? b != 80 ? -1 : 0 : 1 : 3 : 2;
                    if (i2 >= 0 && i >= i2 && cc.b(bArr2, i - i2) == 1347093766) {
                        randomAccessFile.seek((jMax + ((long) i)) - ((long) i2));
                        randomAccessFile.readFully(bArr3);
                        cdVarB = b(bArr3);
                    }
                }
            } while (jMax != j);
            throw new ZipException(String.format("End Of Central Directory signature not found in APK %s", str));
        }
        assetLocation = null;
        byte[] bytes = str2.getBytes(Key.STRING_CHARSET_NAME);
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str2.length()];
        long jA = cdVarB.f247a;
        int i3 = 0;
        while (true) {
            if (i3 >= cdVarB.b) {
                lValueOf = assetLocation;
                break;
            }
            randomAccessFile.seek(jA);
            randomAccessFile.readFully(bArr4);
            int iB = cc.b(bArr4, 0);
            if (iB != 1347092738) {
                throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", str2, str, Integer.valueOf(i3), Integer.valueOf(cdVarB.b), Integer.valueOf(iB), 1347092738));
            }
            randomAccessFile.seek(28 + jA);
            int iA = cc.a(bArr4, 28);
            if (iA == str2.length()) {
                randomAccessFile.seek(46 + jA);
                randomAccessFile.read(bArr5);
                if (Arrays.equals(bArr5, bytes)) {
                    lValueOf = Long.valueOf(cc.c(bArr4, 42));
                    break;
                }
            }
            jA += (long) (iA + 46 + cc.a(bArr4, 30) + cc.a(bArr4, 32));
            i3++;
        }
        if (lValueOf == 0) {
            return assetLocation;
        }
        long jLongValue = lValueOf.longValue();
        byte[] bArr6 = new byte[8];
        randomAccessFile.seek(22 + jLongValue);
        randomAccessFile.readFully(bArr6);
        return new bq(str, ((long) cc.a(bArr6, 6)) + jLongValue + 30 + ((long) cc.a(bArr6, 4)), cc.c(bArr6, 0));
    }

    private static cd b(byte[] bArr) {
        int iA = cc.a(bArr, 10);
        return new cd(cc.c(bArr, 16), cc.c(bArr, 12), iA);
    }
}
