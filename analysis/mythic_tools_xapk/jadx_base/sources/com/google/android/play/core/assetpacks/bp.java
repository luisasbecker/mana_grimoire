package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bp extends com.google.android.play.core.assetpacks.internal.an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f238a;
    private final File b;
    private final NavigableMap c = new TreeMap();

    bp(File file, File file2) throws IOException {
        this.f238a = file;
        this.b = file2;
        List<File> listA = ff.a(file, file2);
        if (listA.isEmpty()) {
            throw new cz(String.format("Virtualized slice archive empty for %s, %s", file, file2));
        }
        long length = 0;
        for (File file3 : listA) {
            this.c.put(Long.valueOf(length), file3);
            length += file3.length();
        }
    }

    private final InputStream d(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new cz(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l));
    }

    @Override // com.google.android.play.core.assetpacks.internal.an
    public final long a() {
        Map.Entry entryLastEntry = this.c.lastEntry();
        return ((Long) entryLastEntry.getKey()).longValue() + ((File) entryLastEntry.getValue()).length();
    }

    @Override // com.google.android.play.core.assetpacks.internal.an
    protected final InputStream b(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new cz(String.format("Invalid input parameters %s, %s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long j3 = j + j2;
        if (j3 > a()) {
            throw new cz(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(a()), Long.valueOf(j3)));
        }
        Long l = (Long) this.c.floorKey(Long.valueOf(j));
        Long l2 = (Long) this.c.floorKey(Long.valueOf(j3));
        if (l.equals(l2)) {
            return new bo(d(j, l), j2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(j, l));
        Collection collectionValues = this.c.subMap(l, false, l2, false).values();
        if (!collectionValues.isEmpty()) {
            arrayList.add(new eg(Collections.enumeration(collectionValues)));
        }
        arrayList.add(new bo(new FileInputStream((File) this.c.get(l2)), j2 - (l2.longValue() - j)));
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
