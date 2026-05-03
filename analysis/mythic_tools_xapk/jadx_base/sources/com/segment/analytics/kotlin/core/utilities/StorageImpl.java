package com.segment.analytics.kotlin.core.utilities;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.ErrorsKt;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.System;
import com.segment.analytics.kotlin.core.UserInfo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.FilenameUtils;
import org.opencv.imgproc.Imgproc;
import sovran.kotlin.Store;
import sovran.kotlin.Subscriber;

/* JADX INFO: compiled from: StorageImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0011\u0010 \u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nH\u0016J\u0011\u0010-\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\u0019\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\u0019\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0086@ø\u0001\u0000¢\u0006\u0002\u00108J\u001f\u00109\u001a\u00020\u001f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001f0;H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010<J!\u0010=\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010>\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010>\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\nX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/StorageImpl;", "Lsovran/kotlin/Subscriber;", "Lcom/segment/analytics/kotlin/core/Storage;", "propertiesFile", "Lcom/segment/analytics/kotlin/core/utilities/KVS;", "eventStream", "Lcom/segment/analytics/kotlin/core/utilities/EventStream;", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "writeKey", "", "fileIndexKey", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/segment/analytics/kotlin/core/utilities/KVS;Lcom/segment/analytics/kotlin/core/utilities/EventStream;Lsovran/kotlin/Store;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", "begin", "getBegin$core", "()Ljava/lang/String;", "currentFile", "getCurrentFile", "end", "getEnd$core", "getEventStream$core", "()Lcom/segment/analytics/kotlin/core/utilities/EventStream;", "ext", "getFileIndexKey$core", "getPropertiesFile", "()Lcom/segment/analytics/kotlin/core/utilities/KVS;", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "incrementFileIndex", "", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRollover", "read", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/segment/analytics/kotlin/core/Storage$Constants;", "readAsStream", "Ljava/io/InputStream;", "source", "remove", "", "removeFile", "filePath", "rollover", "storeEvent", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "systemUpdate", "system", "Lcom/segment/analytics/kotlin/core/System;", "(Lcom/segment/analytics/kotlin/core/System;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userInfoUpdate", "userInfo", "Lcom/segment/analytics/kotlin/core/UserInfo;", "(Lcom/segment/analytics/kotlin/core/UserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLock", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "value", "(Lcom/segment/analytics/kotlin/core/Storage$Constants;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePrefs", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class StorageImpl implements Subscriber, Storage {
    private final String begin;
    private final EventStream eventStream;
    private final String ext;
    private final String fileIndexKey;
    private final CoroutineDispatcher ioDispatcher;
    private final KVS propertiesFile;
    private final Semaphore semaphore;
    private final Store store;
    private final String writeKey;

    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Storage.Constants.values().length];
            try {
                iArr[Storage.Constants.Events.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.StorageImpl$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.utilities.StorageImpl", f = "StorageImpl.kt", i = {0}, l = {48, 55}, m = "initialize$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StorageImpl.initialize$suspendImpl(StorageImpl.this, this);
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.StorageImpl$initialize$2, reason: invalid class name */
    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<UserInfo, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass2(Object obj) {
            super(2, obj, StorageImpl.class, "userInfoUpdate", "userInfoUpdate(Lcom/segment/analytics/kotlin/core/UserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UserInfo userInfo, Continuation<? super Unit> continuation) {
            return ((StorageImpl) this.receiver).userInfoUpdate(userInfo, continuation);
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.StorageImpl$initialize$3, reason: invalid class name */
    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<System, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass3(Object obj) {
            super(2, obj, StorageImpl.class, "systemUpdate", "systemUpdate(Lcom/segment/analytics/kotlin/core/System;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(System system, Continuation<? super Unit> continuation) {
            return ((StorageImpl) this.receiver).systemUpdate(system, continuation);
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.StorageImpl$systemUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.utilities.StorageImpl", f = "StorageImpl.kt", i = {0}, l = {Imgproc.COLOR_BGR2YUV}, m = "systemUpdate", n = {"this"}, s = {"L$0"})
    static final class C10951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10951(Continuation<? super C10951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StorageImpl.this.systemUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.StorageImpl$userInfoUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.utilities.StorageImpl", f = "StorageImpl.kt", i = {0, 0, 1, 1, 2}, l = {65, 68, Imgproc.COLOR_LBGR2Lab}, m = "userInfoUpdate", n = {"this", "userInfo", "this", "userInfo", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    static final class C10961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10961(Continuation<? super C10961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StorageImpl.this.userInfoUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.StorageImpl$withLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StorageImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.utilities.StorageImpl", f = "StorageImpl.kt", i = {0, 0}, l = {194}, m = "withLock", n = {"this", "block"}, s = {"L$0", "L$1"})
    static final class C10971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10971(Continuation<? super C10971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StorageImpl.this.withLock(null, this);
        }
    }

    public StorageImpl(KVS propertiesFile, EventStream eventStream, Store store, String writeKey, String fileIndexKey, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(propertiesFile, "propertiesFile");
        Intrinsics.checkNotNullParameter(eventStream, "eventStream");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(fileIndexKey, "fileIndexKey");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.propertiesFile = propertiesFile;
        this.eventStream = eventStream;
        this.store = store;
        this.writeKey = writeKey;
        this.fileIndexKey = fileIndexKey;
        this.ioDispatcher = ioDispatcher;
        this.semaphore = SemaphoreKt.Semaphore$default(1, 0, 2, null);
        this.begin = "{\"batch\":[";
        this.ext = "tmp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentFile() {
        return this.writeKey + Soundex.SILENT_MARKER + this.propertiesFile.get(this.fileIndexKey, 0) + FilenameUtils.EXTENSION_SEPARATOR + this.ext;
    }

    private final void incrementFileIndex() {
        this.propertiesFile.put(this.fileIndexKey, this.propertiesFile.get(this.fileIndexKey, 0) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        if (r1.subscribe(r9, kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(com.segment.analytics.kotlin.core.System.class), true, r5, r10, r7) == r0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object initialize$suspendImpl(StorageImpl storageImpl, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = storageImpl.new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object obj = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Store store = storageImpl.store;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(storageImpl);
            CoroutineDispatcher coroutineDispatcher = storageImpl.ioDispatcher;
            anonymousClass12.L$0 = storageImpl;
            anonymousClass12.label = 1;
            if (store.subscribe(storageImpl, Reflection.getOrCreateKotlinClass(UserInfo.class), true, coroutineDispatcher, anonymousClass2, anonymousClass12) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        storageImpl = (StorageImpl) anonymousClass12.L$0;
        ResultKt.throwOnFailure(obj);
        Store store2 = storageImpl.store;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(storageImpl);
        CoroutineDispatcher coroutineDispatcher2 = storageImpl.ioDispatcher;
        anonymousClass12.L$0 = null;
        anonymousClass12.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performRollover() {
        if (this.eventStream.isOpened()) {
            this.eventStream.write(getEnd$core());
            this.eventStream.finishAndClose(new Function1<String, String>() { // from class: com.segment.analytics.kotlin.core.utilities.StorageImpl.performRollover.1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return FileUtils.removeFileExtension(it);
                }
            });
            incrementFileIndex();
        }
    }

    static /* synthetic */ Object rollover$suspendImpl(StorageImpl storageImpl, Continuation<? super Unit> continuation) {
        Object objWithLock = storageImpl.withLock(new Function0<Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.StorageImpl.rollover.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StorageImpl.this.performRollover();
            }
        }, continuation);
        return objWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithLock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object storeEvent(final String str, Continuation<? super Unit> continuation) {
        Object objWithLock = withLock(new Function0<Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.StorageImpl.storeEvent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean zOpenOrCreate = StorageImpl.this.getEventStream().openOrCreate(StorageImpl.this.getCurrentFile());
                if (zOpenOrCreate) {
                    StorageImpl.this.getEventStream().write(StorageImpl.this.getBegin());
                }
                if (StorageImpl.this.getEventStream().getLength() > 475000) {
                    StorageImpl.this.performRollover();
                    zOpenOrCreate = StorageImpl.this.getEventStream().openOrCreate(StorageImpl.this.getCurrentFile());
                    StorageImpl.this.getEventStream().write(StorageImpl.this.getBegin());
                }
                StringBuilder sb = new StringBuilder();
                if (!zOpenOrCreate) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                sb.append(str);
                EventStream eventStream = StorageImpl.this.getEventStream();
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "contents.toString()");
                eventStream.write(string);
            }
        }, continuation);
        return objWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithLock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object withLock(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        C10971 c10971;
        if (continuation instanceof C10971) {
            c10971 = (C10971) continuation;
            if ((c10971.label & Integer.MIN_VALUE) != 0) {
                c10971.label -= Integer.MIN_VALUE;
            } else {
                c10971 = new C10971(continuation);
            }
        }
        Object obj = c10971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10971.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore semaphore = this.semaphore;
            c10971.L$0 = this;
            c10971.L$1 = function0;
            c10971.label = 1;
            if (semaphore.acquire(c10971) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) c10971.L$1;
            this = (StorageImpl) c10971.L$0;
            ResultKt.throwOnFailure(obj);
        }
        function0.invoke();
        this.semaphore.release();
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object write$suspendImpl(StorageImpl storageImpl, Storage.Constants constants, String str, Continuation<? super Unit> continuation) throws Exception {
        if (WhenMappings.$EnumSwitchMapping$0[constants.ordinal()] != 1) {
            storageImpl.writePrefs(constants, str);
            return Unit.INSTANCE;
        }
        if (str.length() >= 32000) {
            throw new Exception("enqueued payload is too large");
        }
        Object objStoreEvent = storageImpl.storeEvent(str, continuation);
        return objStoreEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStoreEvent : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getBegin$core, reason: from getter */
    public final String getBegin() {
        return this.begin;
    }

    public final String getEnd$core() {
        return "],\"sentAt\":\"" + SegmentInstant.INSTANCE.now() + "\",\"writeKey\":\"" + this.writeKey + "\"}";
    }

    /* JADX INFO: renamed from: getEventStream$core, reason: from getter */
    public final EventStream getEventStream() {
        return this.eventStream;
    }

    /* JADX INFO: renamed from: getFileIndexKey$core, reason: from getter */
    public final String getFileIndexKey() {
        return this.fileIndexKey;
    }

    public final KVS getPropertiesFile() {
        return this.propertiesFile;
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public Object initialize(Continuation<? super Unit> continuation) {
        return initialize$suspendImpl(this, continuation);
    }

    public String read(Storage.Constants key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (WhenMappings.$EnumSwitchMapping$0[key.ordinal()] != 1) {
            return this.propertiesFile.get(key.getRawVal(), (String) null);
        }
        List<String> list = this.eventStream.read();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.endsWith$default((String) obj, "." + this.ext, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public InputStream readAsStream(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return this.eventStream.readAsStream(source);
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public boolean remove(Storage.Constants key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (WhenMappings.$EnumSwitchMapping$0[key.ordinal()] != 1) {
            this.propertiesFile.remove(key.getRawVal());
        }
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public boolean removeFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            this.eventStream.remove(filePath);
            return true;
        } catch (Exception e) {
            ErrorsKt.reportInternalError(Analytics.INSTANCE, e);
            return false;
        }
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public Object rollover(Continuation<? super Unit> continuation) {
        return rollover$suspendImpl(this, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object systemUpdate(System system, Continuation<? super Unit> continuation) {
        C10951 c10951;
        if (continuation instanceof C10951) {
            c10951 = (C10951) continuation;
            if ((c10951.label & Integer.MIN_VALUE) != 0) {
                c10951.label -= Integer.MIN_VALUE;
            } else {
                c10951 = new C10951(continuation);
            }
        }
        Object obj = c10951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10951.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Settings settings = system.getSettings();
            if (settings != null) {
                Storage.Constants constants = Storage.Constants.Settings;
                String strEncodeToString = Json.INSTANCE.encodeToString(Settings.INSTANCE.serializer(), settings);
                c10951.L$0 = this;
                c10951.label = 1;
                if (write(constants, strEncodeToString, c10951) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Boxing.boxBoolean(remove(Storage.Constants.Settings));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
    
        if (r7.write(r9, r8, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object userInfoUpdate(UserInfo userInfo, Continuation<? super Unit> continuation) {
        C10961 c10961;
        StorageImpl storageImpl;
        UserInfo userInfo2;
        JsonObject traits;
        if (continuation instanceof C10961) {
            c10961 = (C10961) continuation;
            if ((c10961.label & Integer.MIN_VALUE) != 0) {
                c10961.label -= Integer.MIN_VALUE;
            } else {
                c10961 = new C10961(continuation);
            }
        }
        Object obj = c10961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Storage.Constants constants = Storage.Constants.AnonymousId;
            String anonymousId = userInfo.getAnonymousId();
            c10961.L$0 = this;
            c10961.L$1 = userInfo;
            c10961.label = 1;
            if (write(constants, anonymousId, c10961) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            userInfo2 = (UserInfo) c10961.L$1;
            storageImpl = (StorageImpl) c10961.L$0;
            ResultKt.throwOnFailure(obj);
            StorageImpl storageImpl2 = storageImpl;
            userInfo = userInfo2;
            this = storageImpl2;
            traits = userInfo.getTraits();
            if (traits != null) {
                Storage.Constants constants2 = Storage.Constants.Traits;
                String strEncodeToString = Json.INSTANCE.encodeToString(JsonObject.INSTANCE.serializer(), traits);
                c10961.L$0 = this;
                c10961.L$1 = null;
                c10961.label = 3;
            } else {
                Boxing.boxBoolean(this.remove(Storage.Constants.Traits));
            }
            return Unit.INSTANCE;
        }
        userInfo = (UserInfo) c10961.L$1;
        this = (StorageImpl) c10961.L$0;
        ResultKt.throwOnFailure(obj);
        String userId = userInfo.getUserId();
        if (userId == null) {
            Boxing.boxBoolean(this.remove(Storage.Constants.UserId));
            traits = userInfo.getTraits();
            if (traits != null) {
            }
            return Unit.INSTANCE;
        }
        Storage.Constants constants3 = Storage.Constants.UserId;
        c10961.L$0 = this;
        c10961.L$1 = userInfo;
        c10961.label = 2;
        if (this.write(constants3, userId, c10961) != coroutine_suspended) {
            UserInfo userInfo3 = userInfo;
            storageImpl = this;
            userInfo2 = userInfo3;
            StorageImpl storageImpl22 = storageImpl;
            userInfo = userInfo2;
            this = storageImpl22;
            traits = userInfo.getTraits();
            if (traits != null) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public Object write(Storage.Constants constants, String str, Continuation<? super Unit> continuation) {
        return write$suspendImpl(this, constants, str, continuation);
    }

    @Override // com.segment.analytics.kotlin.core.Storage
    public void writePrefs(Storage.Constants key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.propertiesFile.put(key.getRawVal(), value);
    }
}
