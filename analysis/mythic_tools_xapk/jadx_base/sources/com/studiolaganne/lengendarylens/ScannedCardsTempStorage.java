package com.studiolaganne.lengendarylens;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedCardsTempStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000eR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScannedCardsTempStorage;", "", "<init>", "()V", "storage", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "storeScannedCards", "cards", "retrieveAndRemoveScannedCards", "id", "clear", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScannedCardsTempStorage {
    public static final ScannedCardsTempStorage INSTANCE = new ScannedCardsTempStorage();
    private static final ConcurrentHashMap<String, List<MTFullCard>> storage = new ConcurrentHashMap<>();
    public static final int $stable = 8;

    private ScannedCardsTempStorage() {
    }

    public final void clear() {
        storage.clear();
    }

    public final List<MTFullCard> retrieveAndRemoveScannedCards(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return storage.remove(id);
    }

    public final String storeScannedCards(List<MTFullCard> cards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        storage.put(string, cards);
        return string;
    }
}
