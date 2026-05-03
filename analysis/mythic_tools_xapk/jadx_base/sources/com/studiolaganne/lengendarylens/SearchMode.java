package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CardSearchViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchMode;", "", "<init>", "()V", "Online", "Offline", "Lcom/studiolaganne/lengendarylens/SearchMode$Offline;", "Lcom/studiolaganne/lengendarylens/SearchMode$Online;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SearchMode {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchMode$Offline;", "Lcom/studiolaganne/lengendarylens/SearchMode;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Offline extends SearchMode {
        public static final int $stable = 0;
        public static final Offline INSTANCE = new Offline();

        private Offline() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CardSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchMode$Online;", "Lcom/studiolaganne/lengendarylens/SearchMode;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Online extends SearchMode {
        public static final int $stable = 0;
        public static final Online INSTANCE = new Online();

        private Online() {
            super(null);
        }
    }

    private SearchMode() {
    }

    public /* synthetic */ SearchMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
