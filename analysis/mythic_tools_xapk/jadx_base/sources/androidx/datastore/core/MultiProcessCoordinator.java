package androidx.datastore.core;

import androidx.datastore.core.SharedCounter;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u000e\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J2\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0)H\u0096@¢\u0006\u0002\u0010,J8\u0010-\u001a\u0002H'\"\u0004\b\u0000\u0010'2\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H\u0096@¢\u0006\u0002\u00100J:\u00101\u001a\u0002H'\"\u0004\b\u0000\u0010'2$\b\u0004\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H\u0082H¢\u0006\u0002\u00100J\f\u00102\u001a\u00020\u001d*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\u001d*\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a*\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", "context", "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "LOCK_ERROR_MESSAGE", "", "LOCK_SUFFIX", "VERSION_SUFFIX", "getFile", "()Ljava/io/File;", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "fileWithSuffix", "suffix", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "lock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLazyCounter", "createIfNotExists", "createParentDirectories", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiProcessCoordinator implements InterProcessCoordinator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = DurationKt.MILLIS_IN_MINUTE;
    private final String LOCK_ERROR_MESSAGE;
    private final String LOCK_SUFFIX;
    private final String VERSION_SUFFIX;
    private final CoroutineContext context;
    private final File file;
    private final Mutex inMemoryMutex;
    private final Lazy<SharedCounter> lazySharedCounter;

    /* JADX INFO: renamed from: lockFile$delegate, reason: from kotlin metadata */
    private final Lazy lockFile;
    private final Flow<Unit> updateNotifications;

    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "()V", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:27:0x0084). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getExclusiveFileLockWithRetryIfDeadlock(FileOutputStream fileOutputStream, Continuation<? super FileLock> continuation) throws IOException {
            MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
            long j;
            MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12;
            if (continuation instanceof MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) {
                multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 = (MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) continuation;
                if ((multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label & Integer.MIN_VALUE) != 0) {
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label -= Integer.MIN_VALUE;
                } else {
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 = new MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1(this, continuation);
                }
            }
            Object obj = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.J$0;
                fileOutputStream = (FileOutputStream) multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.L$0;
                ResultKt.throwOnFailure(obj);
                multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
                j *= 2;
                if (j <= MultiProcessCoordinator.MAX_WAIT_MILLIS) {
                    FileLock fileLockLock = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                    Intrinsics.checkNotNullExpressionValue(fileLockLock, "lockFileStream.getChanne…LUE, /* shared= */ false)");
                    return fileLockLock;
                }
                try {
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null)) {
                        throw e;
                    }
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12.L$0 = fileOutputStream;
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12.J$0 = j;
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12.label = 1;
                    if (DelayKt.delay(j, multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                FileLock fileLockLock2 = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                Intrinsics.checkNotNullExpressionValue(fileLockLock2, "lockFileStream.getChanne…LUE, /* shared= */ false)");
                return fileLockLock2;
            }
            ResultKt.throwOnFailure(obj);
            j = MultiProcessCoordinator.INITIAL_WAIT_MILLIS;
            multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
            if (j <= MultiProcessCoordinator.MAX_WAIT_MILLIS) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {211, 47, 48}, m = "lock", n = {"this", "block", "$this$withLock_u24default$iv", "block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "lock"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$2"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", i = {0, 0, 1, 1, 1}, l = {62, 87}, m = "tryLock", n = {"$this$withTryLock_u24default$iv", "locked$iv", "$this$withTryLock_u24default$iv", "lock", "locked$iv"}, s = {"L$0", "Z$0", "L$0", "L$2", "Z$0"})
    static final class C05391<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C05391(Continuation<? super C05391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.tryLock(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2, reason: invalid class name */
    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", f = "MultiProcessCoordinator.android.kt", i = {}, l = {WebmConstants.MkvEbmlElement.SIMPLE_BLOCK}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<SharedCounter, Continuation<? super T>, Object> $block;
        int label;
        final /* synthetic */ MultiProcessCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, MultiProcessCoordinator multiProcessCoordinator, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.this$0 = multiProcessCoordinator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function2<SharedCounter, Continuation<? super T>, Object> function2 = this.$block;
            SharedCounter sharedCounter = this.this$0.getSharedCounter();
            this.label = 1;
            Object objInvoke = function2.invoke(sharedCounter, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(this.this$0.getSharedCounter(), this);
        }
    }

    public MultiProcessCoordinator(CoroutineContext context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        this.context = context;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.INSTANCE.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = MutexKt.Mutex$default(false, 1, null);
        this.lockFile = LazyKt.lazy(new Function0<File>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lockFile$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() throws IOException {
                MultiProcessCoordinator multiProcessCoordinator = this.this$0;
                File fileFileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.LOCK_SUFFIX);
                this.this$0.createIfNotExists(fileFileWithSuffix);
                return fileFileWithSuffix;
            }
        });
        this.lazySharedCounter = LazyKt.lazy(new Function0<SharedCounter>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedCounter invoke() {
                SharedCounter.INSTANCE.loadLib();
                SharedCounter.Companion companion = SharedCounter.INSTANCE;
                final MultiProcessCoordinator multiProcessCoordinator = this.this$0;
                return companion.create$datastore_core_release(new Function0<File>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final File invoke() throws IOException {
                        MultiProcessCoordinator multiProcessCoordinator2 = multiProcessCoordinator;
                        File fileFileWithSuffix = multiProcessCoordinator2.fileWithSuffix(multiProcessCoordinator2.VERSION_SUFFIX);
                        multiProcessCoordinator.createIfNotExists(fileFileWithSuffix);
                        return fileFileWithSuffix;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createIfNotExists(File file) throws IOException {
        createParentDirectories(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File fileWithSuffix(String suffix) {
        return new File(this.file.getAbsolutePath() + suffix);
    }

    private final File getLockFile() {
        return (File) this.lockFile.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return this.lazySharedCounter.getValue();
    }

    private final <T> Object withLazyCounter(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return this.lazySharedCounter.isInitialized() ? function2.invoke(getSharedCounter(), continuation) : BuildersKt.withContext(this.context, new AnonymousClass2(function2, this, null), continuation);
    }

    protected final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Flow<Unit> getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(Continuation<? super Integer> continuation) {
        return this.lazySharedCounter.isInitialized() ? Boxing.boxInt(getSharedCounter().getValue()) : BuildersKt.withContext(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(Continuation<? super Integer> continuation) {
        return this.lazySharedCounter.isInitialized() ? Boxing.boxInt(getSharedCounter().incrementAndGetValue()) : BuildersKt.withContext(this.context, new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[Catch: all -> 0x00df, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00df, blocks: (B:42:0x00c1, B:53:0x00db, B:56:0x00e2), top: B:82:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #8 {all -> 0x00df, blocks: (B:42:0x00c1, B:53:0x00db, B:56:0x00e2), top: B:82:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v24, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object lock(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r10;
        ?? r9;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        java.io.Closeable closeable;
        ?? r8;
        Function1<? super Continuation<? super T>, ? extends Object> function13;
        FileLock fileLock;
        FileLock fileLock2;
        Object objInvoke;
        ?? r0;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Mutex mutex = this.inMemoryMutex;
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = function1;
                            anonymousClass1.L$2 = mutex;
                            anonymousClass1.label = 1;
                            Object objLock = mutex.lock(null, anonymousClass1);
                            function12 = function1;
                            r10 = mutex;
                            if (objLock != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                fileLock = (FileLock) anonymousClass1.L$2;
                                closeable = (java.io.Closeable) anonymousClass1.L$1;
                                Mutex mutex2 = (Mutex) anonymousClass1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r0 = mutex2;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    try {
                                        kotlin.io.CloseableKt.closeFinally(closeable, null);
                                        r0.unlock(null);
                                        return obj;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r10 = r0;
                                        r10.unlock(null);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (fileLock != null) {
                                    }
                                    throw th;
                                }
                            }
                            closeable = (java.io.Closeable) anonymousClass1.L$2;
                            r8 = (Mutex) anonymousClass1.L$1;
                            Function1<? super Continuation<? super T>, ? extends Object> function14 = (Function1) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                function13 = function14;
                                r8 = r8;
                                fileLock2 = (FileLock) obj;
                            } catch (Throwable th4) {
                                th = th4;
                                fileLock = null;
                                if (fileLock != null) {
                                }
                                throw th;
                            }
                            try {
                                anonymousClass1.L$0 = r8;
                                anonymousClass1.L$1 = closeable;
                                anonymousClass1.L$2 = fileLock2;
                                anonymousClass1.label = 3;
                                objInvoke = function13.invoke(anonymousClass1);
                                if (objInvoke != coroutine_suspended) {
                                    r0 = r8;
                                    fileLock = fileLock2;
                                    obj = objInvoke;
                                    if (fileLock != null) {
                                    }
                                    kotlin.io.CloseableKt.closeFinally(closeable, null);
                                    r0.unlock(null);
                                    return obj;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th5) {
                                fileLock = fileLock2;
                                th = th5;
                                if (fileLock != null) {
                                }
                                throw th;
                            }
                        }
                        Mutex mutex3 = (Mutex) anonymousClass1.L$2;
                        Function1<? super Continuation<? super T>, ? extends Object> function15 = (Function1) anonymousClass1.L$1;
                        MultiProcessCoordinator multiProcessCoordinator = (MultiProcessCoordinator) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        r10 = mutex3;
                        this = multiProcessCoordinator;
                        function12 = function15;
                        Companion companion = INSTANCE;
                        anonymousClass1.L$0 = function12;
                        anonymousClass1.L$1 = r10;
                        anonymousClass1.L$2 = fileOutputStream;
                        anonymousClass1.label = 2;
                        Object exclusiveFileLockWithRetryIfDeadlock = companion.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream2, anonymousClass1);
                        if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                            Function1<? super Continuation<? super T>, ? extends Object> function16 = function12;
                            closeable = fileOutputStream;
                            r8 = r10;
                            obj = exclusiveFileLockWithRetryIfDeadlock;
                            function13 = function16;
                            fileLock2 = (FileLock) obj;
                            anonymousClass1.L$0 = r8;
                            anonymousClass1.L$1 = closeable;
                            anonymousClass1.L$2 = fileLock2;
                            anonymousClass1.label = 3;
                            objInvoke = function13.invoke(anonymousClass1);
                            if (objInvoke != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th6) {
                        th = th6;
                        fileLock = null;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        throw th;
                    }
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th7) {
                    boolean z = (Function1<? super Continuation<? super T>, ? extends Object>) fileOutputStream;
                    th = th7;
                    r9 = z;
                    r10 = r10;
                    try {
                        throw th;
                    } finally {
                    }
                }
                fileOutputStream = new FileOutputStream(this.getLockFile());
            } catch (Throwable th8) {
                th = th8;
                r10.unlock(null);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            r10 = anonymousClass1;
            r9 = function1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e7 A[Catch: all -> 0x0101, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0101, blocks: (B:59:0x00e7, B:70:0x00fd, B:73:0x0107), top: B:92:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fd A[Catch: all -> 0x0101, TRY_ENTER, TryCatch #2 {all -> 0x0101, blocks: (B:59:0x00e7, B:70:0x00fd, B:73:0x0107), top: B:92:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object tryLock(Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        C05391 c05391;
        ?? TryLock;
        ?? r2;
        ?? r11;
        Throwable th;
        Throwable th2;
        ?? r1;
        FileLock fileLock;
        String message;
        FileLock fileLockTryLock;
        Mutex mutex;
        java.io.Closeable closeable;
        ?? r22;
        ?? r12;
        if (continuation instanceof C05391) {
            c05391 = (C05391) continuation;
            if ((c05391.label & Integer.MIN_VALUE) != 0) {
                c05391.label -= Integer.MIN_VALUE;
            } else {
                c05391 = new C05391(continuation);
            }
        }
        Object objInvoke = c05391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05391.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Mutex mutex2 = this.inMemoryMutex;
                TryLock = mutex2.tryLock(null);
                try {
                    if (TryLock == 0) {
                        Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                        c05391.L$0 = mutex2;
                        c05391.Z$0 = TryLock;
                        c05391.label = 1;
                        objInvoke = function2.invoke(boolBoxBoolean, c05391);
                        if (objInvoke != coroutine_suspended) {
                            r22 = mutex2;
                            r12 = TryLock == true ? 1 : 0;
                            if (r12 != 0) {
                            }
                            return objInvoke;
                        }
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(getLockFile());
                        try {
                            try {
                                try {
                                    fileLockTryLock = fileInputStream.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                                } catch (IOException e) {
                                    String message2 = e.getMessage();
                                    if ((message2 == null || !StringsKt.startsWith$default(message2, this.LOCK_ERROR_MESSAGE, false, 2, (Object) null)) && ((message = e.getMessage()) == null || !StringsKt.startsWith$default(message, DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null))) {
                                        throw e;
                                    }
                                    fileLockTryLock = null;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileLock = null;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                            try {
                                Boolean boolBoxBoolean2 = Boxing.boxBoolean(fileLockTryLock != null);
                                c05391.L$0 = mutex2;
                                c05391.L$1 = fileInputStream;
                                c05391.L$2 = fileLockTryLock;
                                c05391.Z$0 = TryLock;
                                c05391.label = 2;
                                objInvoke = function2.invoke(boolBoxBoolean2, c05391);
                                if (objInvoke != coroutine_suspended) {
                                    fileLock = fileLockTryLock;
                                    mutex = mutex2;
                                    r1 = TryLock == true ? 1 : 0;
                                    closeable = fileInputStream;
                                    if (fileLock != null) {
                                    }
                                    kotlin.io.CloseableKt.closeFinally(closeable, null);
                                    if (r1 != 0) {
                                    }
                                    return objInvoke;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileLock = fileLockTryLock;
                                if (fileLock != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            r2 = mutex2;
                            TryLock = TryLock;
                            r11 = fileInputStream;
                            try {
                                throw th;
                            } catch (Throwable th6) {
                                try {
                                    kotlin.io.CloseableKt.closeFinally(r11, th);
                                    throw th6;
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    r1 = TryLock;
                                    if (r1 != 0) {
                                    }
                                    throw th2;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th8) {
                    th2 = th8;
                    r2 = mutex2;
                    r1 = TryLock;
                }
            } else if (i == 1) {
                r1 = c05391.Z$0;
                r2 = (Mutex) c05391.L$0;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    r12 = r1;
                    r22 = r2;
                    if (r12 != 0) {
                        r22.unlock(null);
                    }
                    return objInvoke;
                } catch (Throwable th9) {
                    th2 = th9;
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z = c05391.Z$0;
                fileLock = (FileLock) c05391.L$2;
                java.io.Closeable closeable2 = (java.io.Closeable) c05391.L$1;
                mutex = (Mutex) c05391.L$0;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    r1 = z;
                    closeable = closeable2;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    try {
                        kotlin.io.CloseableKt.closeFinally(closeable, null);
                        if (r1 != 0) {
                            mutex.unlock(null);
                        }
                        return objInvoke;
                    } catch (Throwable th10) {
                        th2 = th10;
                        r2 = mutex;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    if (fileLock != null) {
                    }
                    throw th;
                }
            }
            if (r1 != 0) {
                r2.unlock(null);
            }
            throw th2;
        } catch (Throwable th12) {
            TryLock = this;
            r2 = c05391;
            r11 = coroutine_suspended;
            th = th12;
        }
    }
}
