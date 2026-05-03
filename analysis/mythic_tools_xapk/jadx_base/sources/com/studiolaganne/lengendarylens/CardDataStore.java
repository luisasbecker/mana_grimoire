package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardDataStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardDataStore;", "", "<init>", "()V", "mtCardList", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getMtCardList", "()Ljava/util/List;", "setMtCardList", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardDataStore {
    public static final CardDataStore INSTANCE = new CardDataStore();
    private static List<MTFullCard> mtCardList = CollectionsKt.emptyList();
    public static final int $stable = 8;

    private CardDataStore() {
    }

    public final List<MTFullCard> getMtCardList() {
        return mtCardList;
    }

    public final void setMtCardList(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        mtCardList = list;
    }
}
