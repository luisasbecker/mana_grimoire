package com.studiolaganne.lengendarylens;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.studiolaganne.lengendarylens.EmbeddingsManager;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.io.FileUtils;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: EmbeddingsManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\u0006\u0010\u001d\u001a\u00020\u0007J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0007J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/EmbeddingsManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "EMBEDDING_SIZE", "", "SCRYFALL_ID_SIZE", "RECORD_SIZE", "embeddings", "", "Lcom/studiolaganne/lengendarylens/CardEmbedding;", "similarityResults", "Lcom/studiolaganne/lengendarylens/SimilarCard;", "minHeapComparator", "Ljava/util/Comparator;", "Lcom/studiolaganne/lengendarylens/EmbeddingsManager$SimilarityItem;", "getAvailableMemoryMB", "", "loadEmbeddingsFromAssets", "", "loadFromMEBFormat", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "startTime", "loadFromMEBFormatMapped", "file", "Ljava/io/File;", "size", "findSimilarCards", "", "queryEmbedding", "", "topK", "cosineSimilarityOptimized", "", "a", "normA", "b", "Companion", "SimilarityItem", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmbeddingsManager {
    private static final String TAG = "EmbeddingsManager";
    private final int EMBEDDING_SIZE;
    private final int RECORD_SIZE;
    private final int SCRYFALL_ID_SIZE;
    private final Context context;
    private final List<CardEmbedding> embeddings;
    private final Comparator<SimilarityItem> minHeapComparator;
    private final List<SimilarCard> similarityResults;
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: EmbeddingsManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/EmbeddingsManager$SimilarityItem;", "", FirebaseAnalytics.Param.INDEX, "", "similarity", "", "<init>", "(IF)V", "getIndex", "()I", "getSimilarity", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class SimilarityItem {
        private final int index;
        private final float similarity;

        public SimilarityItem(int i, float f) {
            this.index = i;
            this.similarity = f;
        }

        public static /* synthetic */ SimilarityItem copy$default(SimilarityItem similarityItem, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = similarityItem.index;
            }
            if ((i2 & 2) != 0) {
                f = similarityItem.similarity;
            }
            return similarityItem.copy(i, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getSimilarity() {
            return this.similarity;
        }

        public final SimilarityItem copy(int index, float similarity) {
            return new SimilarityItem(index, similarity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimilarityItem)) {
                return false;
            }
            SimilarityItem similarityItem = (SimilarityItem) other;
            return this.index == similarityItem.index && Float.compare(this.similarity, similarityItem.similarity) == 0;
        }

        public final int getIndex() {
            return this.index;
        }

        public final float getSimilarity() {
            return this.similarity;
        }

        public int hashCode() {
            return (Integer.hashCode(this.index) * 31) + Float.hashCode(this.similarity);
        }

        public String toString() {
            return "SimilarityItem(index=" + this.index + ", similarity=" + this.similarity + ")";
        }
    }

    public EmbeddingsManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.EMBEDDING_SIZE = 128;
        this.SCRYFALL_ID_SIZE = 36;
        this.RECORD_SIZE = Videoio.CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_COMMIT;
        this.embeddings = new ArrayList();
        this.similarityResults = new ArrayList();
        this.minHeapComparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.EmbeddingsManager$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Float.compare(((EmbeddingsManager.SimilarityItem) obj).getSimilarity(), ((EmbeddingsManager.SimilarityItem) obj2).getSimilarity());
            }
        };
    }

    private final float cosineSimilarityOptimized(float[] a2, float normA, float[] b) {
        int length = a2.length - 3;
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < length) {
            float f3 = a2[i];
            int i2 = i + 1;
            float f4 = a2[i2];
            int i3 = i + 2;
            float f5 = a2[i3];
            int i4 = i + 3;
            float f6 = a2[i4];
            float f7 = b[i];
            float f8 = b[i2];
            float f9 = b[i3];
            float f10 = b[i4];
            f += (f3 * f7) + (f4 * f8) + (f5 * f9) + (f6 * f10);
            f2 += (f7 * f7) + (f8 * f8) + (f9 * f9) + (f10 * f10);
            i += 4;
        }
        while (i < a2.length) {
            float f11 = a2[i];
            float f12 = b[i];
            f += f11 * f12;
            f2 += f12 * f12;
            i++;
        }
        return f / (normA * ((float) Math.sqrt(f2)));
    }

    public static /* synthetic */ List findSimilarCards$default(EmbeddingsManager embeddingsManager, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return embeddingsManager.findSimilarCards(fArr, i);
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
            System.out.println((Object) "MEB file too small for header");
            return false;
        }
        String str = new String(data, 0, 4, Charsets.US_ASCII);
        if (!Intrinsics.areEqual(str, "MEB1")) {
            System.out.println((Object) "Invalid MEB magic number: ".concat(str));
            return false;
        }
        int i3 = ByteBuffer.wrap(data, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
        System.out.println((Object) ("Loading " + i3 + " embeddings from MEB format..."));
        int i4 = (this.RECORD_SIZE * i3) + 8;
        if (data.length < i4) {
            System.out.println((Object) ("MEB file size mismatch: expected " + i4 + ", got " + data.length));
            return false;
        }
        this.embeddings.clear();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (this.RECORD_SIZE * i5) + i2;
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
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.wrap(data, i6 + this.SCRYFALL_ID_SIZE + 4, this.EMBEDDING_SIZE * 4).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
                float[] fArr = new float[this.EMBEDDING_SIZE];
                floatBufferAsFloatBuffer.get(fArr);
                this.embeddings.add(new CardEmbedding(string, i10, fArr));
                if (i5 > 0 && i5 % AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH == 0) {
                    System.out.println((Object) ("Loaded " + i5 + DomExceptionUtils.SEPARATOR + i3 + " embeddings in " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms..."));
                }
            } catch (Exception e) {
                System.out.println((Object) ("Error parsing record " + i5 + ": " + e.getMessage()));
            }
            i5++;
            i = 0;
            i2 = 8;
        }
        System.out.println((Object) ("Loaded " + this.embeddings.size() + " embeddings in " + (System.currentTimeMillis() - startTime) + "ms"));
        return !this.embeddings.isEmpty();
    }

    private final boolean loadFromMEBFormatMapped(File file, long startTime) {
        try {
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                ByteBuffer byteBufferOrder = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).order(ByteOrder.LITTLE_ENDIAN);
                byte[] bArr = new byte[4];
                byteBufferOrder.get(bArr);
                String str = new String(bArr, Charsets.US_ASCII);
                if (!Intrinsics.areEqual(str, "MEB1")) {
                    Log.e(TAG, "Invalid MEB magic number: ".concat(str));
                    channel.close();
                    return false;
                }
                int i = byteBufferOrder.getInt();
                Log.d(TAG, "Loading " + i + " embeddings with memory mapping...");
                this.embeddings.clear();
                int i2 = 0;
                while (i2 < i) {
                    int iMin = Math.min(i2 + 10000, i);
                    int i3 = i2;
                    while (i3 < iMin) {
                        try {
                            byteBufferOrder.position();
                            byte[] bArr2 = new byte[this.SCRYFALL_ID_SIZE];
                            byteBufferOrder.get(bArr2);
                            String str2 = new String(bArr2, Charsets.UTF_8);
                            int length = str2.length() - 1;
                            int i4 = 0;
                            boolean z = false;
                            while (i4 <= length) {
                                char cCharAt = str2.charAt(!z ? i4 : length);
                                boolean z2 = Intrinsics.compare((int) cCharAt, 32) <= 0 || cCharAt == 0;
                                if (z) {
                                    if (!z2) {
                                        break;
                                    }
                                    length--;
                                } else if (z2) {
                                    i4++;
                                } else {
                                    z = true;
                                }
                            }
                            String string = str2.subSequence(i4, length + 1).toString();
                            int i5 = byteBufferOrder.getInt();
                            int i6 = this.EMBEDDING_SIZE;
                            float[] fArr = new float[i6];
                            for (int i7 = 0; i7 < i6; i7++) {
                                fArr[i7] = byteBufferOrder.getFloat();
                            }
                            this.embeddings.add(new CardEmbedding(string, i5, fArr));
                        } catch (Exception e) {
                            Log.e(TAG, "Error parsing record " + i3 + ": " + e.getMessage());
                            int iPosition = byteBufferOrder.position() + this.RECORD_SIZE;
                            if (iPosition <= byteBufferOrder.limit()) {
                                byteBufferOrder.position(iPosition);
                            }
                        }
                        i3++;
                    }
                    if (i3 % AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH == 0) {
                        Log.d(TAG, "Processed " + i3 + DomExceptionUtils.SEPARATOR + i + " embeddings in " + (System.currentTimeMillis() - startTime) + "ms...");
                        System.gc();
                    }
                    i2 = i3;
                }
                channel.close();
                Log.d(TAG, "Loaded " + this.embeddings.size() + " embeddings in " + (System.currentTimeMillis() - startTime) + "ms (mapped mode)");
                return !this.embeddings.isEmpty();
            } catch (OutOfMemoryError e2) {
                Log.e(TAG, "Out of memory during memory-mapped loading", e2);
                return false;
            }
        } catch (Exception e3) {
            Log.e(TAG, "Error in memory-mapped loading: " + e3.getMessage(), e3);
            return false;
        }
    }

    public final List<SimilarCard> findSimilarCards(float[] queryEmbedding, int topK) {
        Intrinsics.checkNotNullParameter(queryEmbedding, "queryEmbedding");
        if (this.embeddings.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
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
        float fSqrt = (float) Math.sqrt(f);
        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        PriorityQueue priorityQueue = new PriorityQueue(topK, this.minHeapComparator);
        int size = this.embeddings.size();
        for (int i2 = 0; i2 < size; i2++) {
            float fCosineSimilarityOptimized = cosineSimilarityOptimized(queryEmbedding, fSqrt, this.embeddings.get(i2).getEmbedding());
            if (priorityQueue.size() < topK) {
                priorityQueue.offer(new SimilarityItem(i2, fCosineSimilarityOptimized));
            } else {
                Object objPeek = priorityQueue.peek();
                Intrinsics.checkNotNull(objPeek);
                if (fCosineSimilarityOptimized > ((SimilarityItem) objPeek).getSimilarity()) {
                    priorityQueue.poll();
                    priorityQueue.offer(new SimilarityItem(i2, fCosineSimilarityOptimized));
                }
            }
        }
        this.similarityResults.clear();
        ArrayList<SimilarityItem> arrayList = new ArrayList();
        while (!priorityQueue.isEmpty()) {
            SimilarityItem similarityItem = (SimilarityItem) priorityQueue.poll();
            if (similarityItem != null) {
                arrayList.add(similarityItem);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.EmbeddingsManager$findSimilarCards$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Float.valueOf(((EmbeddingsManager.SimilarityItem) t2).getSimilarity()), Float.valueOf(((EmbeddingsManager.SimilarityItem) t).getSimilarity()));
                }
            });
        }
        for (SimilarityItem similarityItem2 : arrayList) {
            CardEmbedding cardEmbedding = this.embeddings.get(similarityItem2.getIndex());
            this.similarityResults.add(new SimilarCard(cardEmbedding.getScryfallId(), cardEmbedding.getFace(), similarityItem2.getSimilarity()));
        }
        System.out.println((Object) ("-------->>>>>>> SIMILARITY SEARCH TIMING - Total: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms | Norm: " + jCurrentTimeMillis3 + "ms | Heap: " + (System.currentTimeMillis() - jCurrentTimeMillis4) + "ms"));
        return CollectionsKt.toList(this.similarityResults);
    }

    public final boolean loadEmbeddingsFromAssets() {
        try {
            Log.d(TAG, "Loading embeddings from assets");
            long jCurrentTimeMillis = System.currentTimeMillis();
            GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "embeddings_cards", ".meb");
            if (!genericDBHelper.isValid()) {
                Log.e(TAG, "Invalid embeddings database");
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
            Log.e(TAG, "Error loading embeddings: " + e.getMessage(), e);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "Out of memory while loading embeddings", e2);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("embeddings_load_error_oom", null);
            return false;
        }
    }

    public final int size() {
        return this.embeddings.size();
    }
}
