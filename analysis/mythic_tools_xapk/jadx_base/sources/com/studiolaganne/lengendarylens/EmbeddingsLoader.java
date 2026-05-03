package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: EmbeddingsLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010 \u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0013J\u001a\u0010\"\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/EmbeddingsLoader;", "", "<init>", "()V", "TAG", "", "currentState", "Lcom/studiolaganne/lengendarylens/EmbeddingsLoader$LoadingState;", "cardEmbeddingsRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/studiolaganne/lengendarylens/CardEmbeddings;", "setSymbolEmbeddingsRef", "Lcom/studiolaganne/lengendarylens/SetSymbolEmbeddings;", "loadingJob", "Lkotlinx/coroutines/Job;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stateCallbacks", "", "Lkotlin/Function1;", "", "callbackLock", "startBackgroundLoading", "context", "Landroid/content/Context;", "getCardEmbeddings", "getSetSymbolEmbeddings", "isReady", "", "getState", "getProgress", "", "addStateCallback", "callback", "removeStateCallback", "cancelLoading", "reset", "updateState", "newState", "LoadingState", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmbeddingsLoader {
    private static final String TAG = "EmbeddingsLoader";
    private static Job loadingJob;
    public static final EmbeddingsLoader INSTANCE = new EmbeddingsLoader();
    private static volatile LoadingState currentState = LoadingState.NOT_STARTED;
    private static final AtomicReference<CardEmbeddings> cardEmbeddingsRef = new AtomicReference<>();
    private static final AtomicReference<SetSymbolEmbeddings> setSymbolEmbeddingsRef = new AtomicReference<>();
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final Set<Function1<LoadingState, Unit>> stateCallbacks = new LinkedHashSet();
    private static final Object callbackLock = new Object();
    public static final int $stable = 8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: EmbeddingsLoader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/EmbeddingsLoader$LoadingState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "LOADING_CARD_EMBEDDINGS", "LOADING_SET_EMBEDDINGS", "COMPLETED", "FAILED", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LoadingState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LoadingState[] $VALUES;
        public static final LoadingState NOT_STARTED = new LoadingState("NOT_STARTED", 0);
        public static final LoadingState LOADING_CARD_EMBEDDINGS = new LoadingState("LOADING_CARD_EMBEDDINGS", 1);
        public static final LoadingState LOADING_SET_EMBEDDINGS = new LoadingState("LOADING_SET_EMBEDDINGS", 2);
        public static final LoadingState COMPLETED = new LoadingState("COMPLETED", 3);
        public static final LoadingState FAILED = new LoadingState("FAILED", 4);

        private static final /* synthetic */ LoadingState[] $values() {
            return new LoadingState[]{NOT_STARTED, LOADING_CARD_EMBEDDINGS, LOADING_SET_EMBEDDINGS, COMPLETED, FAILED};
        }

        static {
            LoadingState[] loadingStateArr$values = $values();
            $VALUES = loadingStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(loadingStateArr$values);
        }

        private LoadingState(String str, int i) {
        }

        public static EnumEntries<LoadingState> getEntries() {
            return $ENTRIES;
        }

        public static LoadingState valueOf(String str) {
            return (LoadingState) Enum.valueOf(LoadingState.class, str);
        }

        public static LoadingState[] values() {
            return (LoadingState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: EmbeddingsLoader.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadingState.values().length];
            try {
                iArr[LoadingState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadingState.LOADING_CARD_EMBEDDINGS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadingState.LOADING_SET_EMBEDDINGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadingState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LoadingState.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private EmbeddingsLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(LoadingState newState) {
        currentState = newState;
        synchronized (callbackLock) {
            Iterator<T> it = stateCallbacks.iterator();
            while (it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EmbeddingsLoader$updateState$1$1$1((Function1) it.next(), newState, null), 3, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addStateCallback(Function1<? super LoadingState, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (callbackLock) {
            stateCallbacks.add(callback);
            callback.invoke(currentState);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cancelLoading() {
        Job job = loadingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        isLoading.set(false);
        Log.d(TAG, "Loading cancelled");
    }

    public final CardEmbeddings getCardEmbeddings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AtomicReference<CardEmbeddings> atomicReference = cardEmbeddingsRef;
        CardEmbeddings cardEmbeddings = atomicReference.get();
        if (cardEmbeddings != null) {
            return cardEmbeddings;
        }
        Log.d(TAG, "Card embeddings not ready, creating synchronously");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        CardEmbeddings cardEmbeddings2 = new CardEmbeddings(applicationContext);
        atomicReference.set(cardEmbeddings2);
        return cardEmbeddings2;
    }

    public final float getProgress() {
        int i = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
        if (i == 1) {
            return 0.0f;
        }
        if (i == 2) {
            return 0.3f;
        }
        if (i == 3) {
            return 0.7f;
        }
        if (i == 4) {
            return 1.0f;
        }
        if (i == 5) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final SetSymbolEmbeddings getSetSymbolEmbeddings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AtomicReference<SetSymbolEmbeddings> atomicReference = setSymbolEmbeddingsRef;
        SetSymbolEmbeddings setSymbolEmbeddings = atomicReference.get();
        if (setSymbolEmbeddings != null) {
            return setSymbolEmbeddings;
        }
        Log.d(TAG, "Set symbol embeddings not ready, creating synchronously");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        SetSymbolEmbeddings setSymbolEmbeddings2 = new SetSymbolEmbeddings(applicationContext);
        atomicReference.set(setSymbolEmbeddings2);
        return setSymbolEmbeddings2;
    }

    public final LoadingState getState() {
        return currentState;
    }

    public final boolean isReady() {
        return currentState == LoadingState.COMPLETED;
    }

    public final void removeStateCallback(Function1<? super LoadingState, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (callbackLock) {
            stateCallbacks.remove(callback);
        }
    }

    public final void reset() {
        synchronized (this) {
            EmbeddingsLoader embeddingsLoader = INSTANCE;
            embeddingsLoader.cancelLoading();
            cardEmbeddingsRef.set(null);
            setSymbolEmbeddingsRef.set(null);
            embeddingsLoader.updateState(LoadingState.NOT_STARTED);
            Log.d(TAG, "EmbeddingsLoader reset");
        }
    }

    public final void startBackgroundLoading(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this) {
            AtomicBoolean atomicBoolean = isLoading;
            if (!atomicBoolean.get() && currentState != LoadingState.COMPLETED) {
                atomicBoolean.set(true);
                INSTANCE.updateState(LoadingState.LOADING_CARD_EMBEDDINGS);
                loadingJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EmbeddingsLoader$startBackgroundLoading$1$1(context, null), 3, null);
                Unit unit = Unit.INSTANCE;
                return;
            }
            Log.d(TAG, "Already loading or completed, skipping");
        }
    }
}
