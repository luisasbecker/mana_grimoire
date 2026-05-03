package com.studiolaganne.lengendarylens;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J \u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeterministicShuffler;", "", "initialSeed", "", "<init>", "(I)V", "nextRandom", "seed", "shuffle", "", ExifInterface.GPS_DIRECTION_TRUE, "list", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeterministicShuffler {
    public static final int $stable = 0;
    private final int initialSeed;

    public DeterministicShuffler(int i) {
        this.initialSeed = i;
    }

    private final int nextRandom(int seed) {
        return (int) (((((long) seed) * 1103515245) + 12345) & SieveCacheKt.NodeLinkMask);
    }

    public final <T> List<T> shuffle(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<T> mutableList = CollectionsKt.toMutableList((Collection) list);
        int iNextRandom = this.initialSeed;
        for (int size = mutableList.size() - 1; size > 0; size--) {
            iNextRandom = nextRandom(iNextRandom);
            int i = size + 1;
            int i2 = iNextRandom % i;
            if (i2 < 0) {
                i2 += i;
            }
            T t = mutableList.get(size);
            mutableList.set(size, mutableList.get(i2));
            mutableList.set(i2, t);
        }
        return mutableList;
    }
}
