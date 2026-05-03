package com.studiolaganne.lengendarylens;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GlossaryManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rR*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/GlossaryManager;", "", "<init>", "()V", "value", "", "Lcom/studiolaganne/lengendarylens/GlossaryEntry;", "enGlossaryEntries", "getEnGlossaryEntries", "()Ljava/util/List;", "frGlossaryEntries", "getFrGlossaryEntries", "loadGlossaries", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GlossaryManager {
    public static final GlossaryManager INSTANCE = new GlossaryManager();
    private static List<GlossaryEntry> enGlossaryEntries = CollectionsKt.emptyList();
    private static List<GlossaryEntry> frGlossaryEntries = CollectionsKt.emptyList();
    public static final int $stable = 8;

    private GlossaryManager() {
    }

    public final List<GlossaryEntry> getEnGlossaryEntries() {
        return enGlossaryEntries;
    }

    public final List<GlossaryEntry> getFrGlossaryEntries() {
        return frGlossaryEntries;
    }

    public final void loadGlossaries() {
        try {
            enGlossaryEntries = GlossaryDBHelper.INSTANCE.getInstance(LegendaryLensApplication.INSTANCE.applicationContext()).getGlossaryEntries();
            frGlossaryEntries = GlossaryDBHelperLocalized.INSTANCE.getInstance(LegendaryLensApplication.INSTANCE.applicationContext(), "fr").getGlossaryEntries();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
