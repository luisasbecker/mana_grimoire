package com.studiolaganne.lengendarylens;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.io.FileUtils;

/* JADX INFO: compiled from: SetSymbolsEmbeddings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0006\u0010\u001b\u001a\u00020\u0007J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0007J\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0007J(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/SetEmbeddingsManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "SET_EMBEDDING_SIZE", "", "SCRYFALL_ID_SIZE", "SET_RECORD_SIZE", "embeddings", "", "Lcom/studiolaganne/lengendarylens/SetEmbedding;", "embeddingIndex", "", "", "getAvailableMemoryMB", "", "loadEmbeddingsFromAssets", "", "loadFromMEBFormat", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "startTime", "loadFromMEBFormatMapped", "file", "Ljava/io/File;", "size", "calculateSimilarityToCard", "", "queryEmbedding", "", "scryfallId", OptionalModuleUtils.FACE, "getEmbeddingForCard", "cosineSimilarityOptimized", "", "a", "normA", "b", "normB", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetEmbeddingsManager {
    private static final String TAG = "SetEmbeddingsManager";
    private final int SCRYFALL_ID_SIZE;
    private final int SET_EMBEDDING_SIZE;
    private final int SET_RECORD_SIZE;
    private final Context context;
    private final Map<String, SetEmbedding> embeddingIndex;
    private final List<SetEmbedding> embeddings;
    public static final int $stable = 8;

    public SetEmbeddingsManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.SET_EMBEDDING_SIZE = 32;
        this.SCRYFALL_ID_SIZE = 36;
        this.SET_RECORD_SIZE = 168;
        this.embeddings = new ArrayList();
        this.embeddingIndex = new LinkedHashMap();
    }

    private final float cosineSimilarityOptimized(float[] a2, float normA, float[] b, float normB) {
        int length = a2.length - 7;
        float f = 0.0f;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            float f2 = (a2[i] * b[i]) + (a2[i2] * b[i2]);
            int i3 = i + 2;
            float f3 = f2 + (a2[i3] * b[i3]);
            int i4 = i + 3;
            float f4 = f3 + (a2[i4] * b[i4]);
            int i5 = i + 4;
            float f5 = f4 + (a2[i5] * b[i5]);
            int i6 = i + 5;
            float f6 = f5 + (a2[i6] * b[i6]);
            int i7 = i + 6;
            float f7 = f6 + (a2[i7] * b[i7]);
            int i8 = i + 7;
            f += f7 + (a2[i8] * b[i8]);
            i += 8;
        }
        while (i < a2.length) {
            f += a2[i] * b[i];
            i++;
        }
        return f / (normA * normB);
    }

    private final long getAvailableMemoryMB() {
        Object systemService = this.context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / FileUtils.ONE_MB;
    }

    private final boolean loadFromMEBFormat(byte[] data, long startTime) {
        int i = 0;
        int i2 = 8;
        if (data.length < 8) {
            System.out.println((Object) "Set symbol MEB file too small for header");
            return false;
        }
        String str = new String(data, 0, 4, Charsets.US_ASCII);
        if (!Intrinsics.areEqual(str, "MEB1")) {
            System.out.println((Object) "Invalid set symbol MEB magic number: ".concat(str));
            return false;
        }
        int i3 = ByteBuffer.wrap(data, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
        System.out.println((Object) ("Loading " + i3 + " set symbol embeddings from MEB format..."));
        int i4 = (this.SET_RECORD_SIZE * i3) + 8;
        if (data.length < i4) {
            System.out.println((Object) ("Set symbol MEB file size mismatch: expected " + i4 + ", got " + data.length));
            return false;
        }
        this.embeddings.clear();
        this.embeddingIndex.clear();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (this.SET_RECORD_SIZE * i5) + i2;
            try {
                int i7 = this.SCRYFALL_ID_SIZE;
                byte[] bArr = new byte[i7];
                System.arraycopy(data, i6, bArr, i, i7);
                String str2 = new String(bArr, Charsets.UTF_8);
                int length = str2.length() - 1;
                int i8 = i;
                int i9 = i8;
                while (i8 <= length) {
                    char cCharAt = str2.charAt(i9 == 0 ? i8 : length);
                    boolean z = Intrinsics.compare((int) cCharAt, 32) <= 0 || cCharAt == 0;
                    if (i9 == 0) {
                        if (z) {
                            i8++;
                        } else {
                            i9 = 1;
                        }
                    } else {
                        if (!z) {
                            break;
                        }
                        length--;
                    }
                }
                String string = str2.subSequence(i8, length + 1).toString();
                int i10 = ByteBuffer.wrap(data, this.SCRYFALL_ID_SIZE + i6, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.wrap(data, i6 + this.SCRYFALL_ID_SIZE + 4, this.SET_EMBEDDING_SIZE * 4).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
                int i11 = this.SET_EMBEDDING_SIZE;
                float[] fArr = new float[i11];
                floatBufferAsFloatBuffer.get(fArr);
                int i12 = i11 - 3;
                float f = 0.0f;
                int i13 = 0;
                while (i13 < i12) {
                    float f2 = fArr[i13];
                    float f3 = fArr[i13 + 1];
                    float f4 = fArr[i13 + 2];
                    float f5 = fArr[i13 + 3];
                    f += (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5);
                    i13 += 4;
                }
                while (i13 < i11) {
                    float f6 = fArr[i13];
                    f += f6 * f6;
                    i13++;
                }
                SetEmbedding setEmbedding = new SetEmbedding(string, i10, fArr, (float) Math.sqrt(f));
                this.embeddings.add(setEmbedding);
                this.embeddingIndex.put(string + "_" + i10, setEmbedding);
                if (i5 > 0 && i5 % 10000 == 0) {
                    System.out.println((Object) ("Loaded " + i5 + DomExceptionUtils.SEPARATOR + i3 + " set symbol embeddings in " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms..."));
                }
            } catch (Exception e) {
                System.out.println((Object) ("Error parsing set symbol record " + i5 + ": " + e.getMessage()));
            }
            i5++;
            i = 0;
            i2 = 8;
        }
        System.out.println((Object) ("Loaded " + this.embeddings.size() + " set symbol embeddings in " + (System.currentTimeMillis() - startTime) + "ms"));
        return !this.embeddings.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0170 A[Catch: Exception -> 0x01ff, OutOfMemoryError -> 0x0201, TryCatch #0 {Exception -> 0x01ff, blocks: (B:58:0x0173, B:55:0x0149, B:57:0x0170, B:59:0x017b, B:61:0x0182, B:63:0x01bd), top: B:78:0x0149 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [int] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r9v13, types: [int] */
    /* JADX WARN: Type inference failed for: r9v14, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [int] */
    /* JADX WARN: Type inference failed for: r9v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean loadFromMEBFormatMapped(File file, long startTime) {
        boolean z;
        int i;
        int iPosition;
        boolean z2 = false;
        try {
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                ByteBuffer byteBufferOrder = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).order(ByteOrder.LITTLE_ENDIAN);
                byte[] bArr = new byte[4];
                byteBufferOrder.get(bArr);
                String str = new String(bArr, Charsets.US_ASCII);
                if (!Intrinsics.areEqual(str, "MEB1")) {
                    Log.e(TAG, "Invalid set symbol MEB magic number: ".concat(str));
                    channel.close();
                    return false;
                }
                int i2 = byteBufferOrder.getInt();
                Log.d(TAG, "Loading " + i2 + " set symbol embeddings with memory mapping...");
                this.embeddings.clear();
                this.embeddingIndex.clear();
                int i3 = 0;
                while (true) {
                    int i4 = 1;
                    if (i3 >= i2) {
                        z = z2;
                        channel.close();
                        Log.d(TAG, "Loaded " + this.embeddings.size() + " set symbol embeddings in " + (System.currentTimeMillis() - startTime) + "ms (mapped mode)");
                        return !this.embeddings.isEmpty();
                    }
                    int iMin = Math.min(i3 + 5000, i2) - i3;
                    for (?? r11 = z2; r11 < iMin; r11++) {
                        try {
                            byte[] bArr2 = new byte[this.SCRYFALL_ID_SIZE];
                            byteBufferOrder.get(bArr2);
                            String str2 = new String(bArr2, Charsets.UTF_8);
                            int length = str2.length() - i4;
                            boolean z3 = z2;
                            int i5 = z3 ? 1 : 0;
                            ?? r13 = z3;
                            while (true) {
                                if (r13 > length) {
                                    z = z2;
                                    break;
                                }
                                char cCharAt = str2.charAt(i5 == 0 ? r13 : length);
                                z = z2;
                                try {
                                    try {
                                        ?? r4 = (Intrinsics.compare((int) cCharAt, 32) <= 0 || cCharAt == 0) ? i4 : z;
                                        if (i5 != 0) {
                                            if (r4 == 0) {
                                                break;
                                            }
                                            length--;
                                        } else if (r4 == 0) {
                                            i5 = i4;
                                        } else {
                                            r13++;
                                        }
                                        z2 = z;
                                        r13 = r13;
                                    } catch (OutOfMemoryError e) {
                                        e = e;
                                        Log.e(TAG, "Out of memory during memory-mapped loading", e);
                                        return z;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    i = i4;
                                    try {
                                        Log.e(TAG, "Error parsing record: " + e.getMessage());
                                        iPosition = byteBufferOrder.position() + this.SET_RECORD_SIZE;
                                        if (iPosition > byteBufferOrder.limit()) {
                                        }
                                        i4 = i;
                                        z2 = z;
                                    } catch (Exception e3) {
                                        e = e3;
                                        Log.e(TAG, "Error in memory-mapped loading: " + e.getMessage(), e);
                                        return z;
                                    }
                                }
                            }
                            String string = str2.subSequence(r13, length + 1).toString();
                            int i6 = byteBufferOrder.getInt();
                            int i7 = this.SET_EMBEDDING_SIZE;
                            float[] fArr = new float[i7];
                            for (?? r14 = z; r14 < i7; r14++) {
                                fArr[r14] = byteBufferOrder.getFloat();
                            }
                            int i8 = i7 - 3;
                            float f = 0.0f;
                            i = i4;
                            ?? r9 = z;
                            while (r9 < i8) {
                                try {
                                    float f2 = fArr[r9];
                                    float f3 = fArr[r9 + 1];
                                    float f4 = fArr[r9 + 2];
                                    float f5 = fArr[r9 + 3];
                                    f += (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5);
                                    r9 += 4;
                                } catch (Exception e4) {
                                    e = e4;
                                    Log.e(TAG, "Error parsing record: " + e.getMessage());
                                    iPosition = byteBufferOrder.position() + this.SET_RECORD_SIZE;
                                    if (iPosition > byteBufferOrder.limit()) {
                                        byteBufferOrder.position(iPosition);
                                    }
                                    i4 = i;
                                    z2 = z;
                                }
                            }
                            while (r9 < i7) {
                                float f6 = fArr[r9];
                                f += f6 * f6;
                                r9++;
                            }
                            SetEmbedding setEmbedding = new SetEmbedding(string, i6, fArr, (float) Math.sqrt(f));
                            this.embeddings.add(setEmbedding);
                            this.embeddingIndex.put(string + "_" + i6, setEmbedding);
                        } catch (Exception e5) {
                            e = e5;
                            z = z2;
                        }
                        i4 = i;
                        z2 = z;
                    }
                    boolean z4 = z2;
                    i3 += iMin;
                    if (i3 % 10000 == 0) {
                        Log.d(TAG, "Processed " + i3 + DomExceptionUtils.SEPARATOR + i2 + " set symbol embeddings in " + (System.currentTimeMillis() - startTime) + "ms...");
                        System.gc();
                    }
                    z2 = z4;
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                z = false;
            }
        } catch (Exception e7) {
            e = e7;
            z = false;
        }
    }

    public final double calculateSimilarityToCard(float[] queryEmbedding, String scryfallId, int face) {
        Intrinsics.checkNotNullParameter(queryEmbedding, "queryEmbedding");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        if (this.embeddingIndex.get(scryfallId + "_" + face) == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int length = queryEmbedding.length - 3;
        float f = 0.0f;
        int i = 0;
        while (i < length) {
            float f2 = queryEmbedding[i];
            float f3 = queryEmbedding[i + 1];
            float f4 = queryEmbedding[i + 2];
            float f5 = queryEmbedding[i + 3];
            f += (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5);
            i += 4;
        }
        while (i < queryEmbedding.length) {
            float f6 = queryEmbedding[i];
            f += f6 * f6;
            i++;
        }
        return cosineSimilarityOptimized(queryEmbedding, (float) Math.sqrt(f), r8.getEmbedding(), r8.getNorm());
    }

    public final float[] getEmbeddingForCard(String scryfallId, int face) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        SetEmbedding setEmbedding = this.embeddingIndex.get(scryfallId + "_" + face);
        if (setEmbedding != null) {
            return setEmbedding.getEmbedding();
        }
        return null;
    }

    public final boolean loadEmbeddingsFromAssets() {
        try {
            Log.d(TAG, "Loading set symbol embeddings from assets");
            long jCurrentTimeMillis = System.currentTimeMillis();
            GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "embeddings_sets", ".meb");
            if (!genericDBHelper.isValid()) {
                Log.e(TAG, "Invalid set embeddings database");
                return false;
            }
            File currentFile = genericDBHelper.getCurrentFile();
            long length = currentFile.length() / FileUtils.ONE_MB;
            long availableMemoryMB = getAvailableMemoryMB();
            Log.d(TAG, "Available memory: " + availableMemoryMB + " MB, File size: " + length + " MB");
            if (availableMemoryMB < length * 1.5d) {
                Log.d(TAG, "Memory constraints detected, using memory-mapped loading");
                return loadFromMEBFormatMapped(currentFile, jCurrentTimeMillis);
            }
            Log.d(TAG, "Sufficient memory, using standard loading");
            return loadFromMEBFormat(FilesKt.readBytes(currentFile), jCurrentTimeMillis);
        } catch (Exception e) {
            Log.e(TAG, "Error loading set embeddings: " + e.getMessage(), e);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "Out of memory while loading set embeddings", e2);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("embeddings_load_error_oom_set1", null);
            try {
                System.gc();
                File currentFile2 = new GenericDBHelper(this.context, "embeddings_sets", ".meb").getCurrentFile();
                Log.d(TAG, "Attempting memory-mapped loading as fallback after OOM");
                return loadFromMEBFormatMapped(currentFile2, System.currentTimeMillis());
            } catch (Exception e3) {
                Log.e(TAG, "Fallback loading also failed", e3);
                FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                firebaseAnalytics2.logEvent("embeddings_load_error_oom_set2", null);
                return false;
            }
        }
    }

    public final int size() {
        return this.embeddings.size();
    }
}
