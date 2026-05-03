package com.studiolaganne.lengendarylens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DraftUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/DraftUtils;", "", "<init>", "()V", "getDraftTables", "", "", "numPlayers", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DraftUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DraftUtils instance;

    /* JADX INFO: compiled from: DraftUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/DraftUtils$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/DraftUtils;", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized DraftUtils getInstance() {
            DraftUtils draftUtils;
            if (DraftUtils.instance == null) {
                DraftUtils.instance = new DraftUtils(null);
            }
            draftUtils = DraftUtils.instance;
            Intrinsics.checkNotNull(draftUtils);
            return draftUtils;
        }
    }

    private DraftUtils() {
    }

    public /* synthetic */ DraftUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final List<Integer> getDraftTables(int numPlayers) {
        if (numPlayers <= 0) {
            return CollectionsKt.emptyList();
        }
        switch (numPlayers) {
            case 1:
                return CollectionsKt.listOf(1);
            case 2:
                return CollectionsKt.listOf(2);
            case 3:
                return CollectionsKt.listOf(3);
            case 4:
                return CollectionsKt.listOf(4);
            case 5:
                return CollectionsKt.listOf(5);
            case 6:
                return CollectionsKt.listOf(6);
            case 7:
                return CollectionsKt.listOf(7);
            case 8:
                return CollectionsKt.listOf(8);
            case 9:
                return CollectionsKt.listOf((Object[]) new Integer[]{5, 4});
            case 10:
                return CollectionsKt.listOf((Object[]) new Integer[]{6, 4});
            case 11:
                return CollectionsKt.listOf((Object[]) new Integer[]{6, 5});
            case 12:
                return CollectionsKt.listOf((Object[]) new Integer[]{6, 6});
            case 13:
                return CollectionsKt.listOf((Object[]) new Integer[]{7, 6});
            case 14:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 6});
            case 15:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 7});
            case 16:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 8});
            case 17:
                return CollectionsKt.listOf((Object[]) new Integer[]{6, 6, 5});
            case 18:
                return CollectionsKt.listOf((Object[]) new Integer[]{6, 6, 6});
            case 19:
                return CollectionsKt.listOf((Object[]) new Integer[]{7, 6, 6});
            case 20:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 6, 6});
            case 21:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 7, 6});
            case 22:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 8, 6});
            case 23:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 8, 7});
            case 24:
                return CollectionsKt.listOf((Object[]) new Integer[]{8, 8, 8});
            default:
                int i = ((numPlayers - 24) / 8) + 1;
                int i2 = numPlayers - (i * 8);
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < i; i3++) {
                    arrayList.add(8);
                }
                Iterator<Integer> it = getDraftTables(i2).iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().intValue()));
                }
                return arrayList;
        }
    }
}
