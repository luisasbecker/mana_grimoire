package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016JX\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0001\u0010\u00162B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u000b2-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0#¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/datastore/core/FileStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final Function0<Unit> onClose;
    private final Serializer<T> serializer;
    private final Mutex transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", i = {0, 0, 0}, l = {101}, m = "readScope", n = {"this", "$this$use$iv", "lock"}, s = {"L$0", "L$1", "Z$0"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FileStorageConnection<T> fileStorageConnection, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = fileStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {214, Imgproc.COLOR_YUV2BGR_YVYU}, m = "writeScope", n = {"this", "block", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "scratchFile", "$this$use$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C05381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05381(FileStorageConnection<T> fileStorageConnection, Continuation<? super C05381> continuation) {
            super(continuation);
            this.this$0 = fileStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
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

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        Closeable closeable;
        FileStorageConnection<T> fileStorageConnection;
        boolean z;
        ?? r10;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        }
        ?? r102 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(r102);
                checkNotClosed();
                boolean zTryLock$default = Mutex.DefaultImpls.tryLock$default(this.transactionMutex, null, 1, null);
                FileReadScope fileReadScope = new FileReadScope(this.file, this.serializer);
                try {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zTryLock$default);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = fileReadScope;
                    anonymousClass1.Z$0 = zTryLock$default;
                    anonymousClass1.label = 1;
                    Object objInvoke = function3.invoke(fileReadScope, boolBoxBoolean, anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fileStorageConnection = this;
                    z = zTryLock$default ? 1 : 0;
                    r10 = objInvoke;
                    closeable = fileReadScope;
                    closeable.close();
                    th = null;
                    if (th != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileReadScope;
                    r102 = zTryLock$default;
                    closeable.close();
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = anonymousClass1.Z$0;
                closeable = (Closeable) anonymousClass1.L$1;
                fileStorageConnection = (FileStorageConnection) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(r102);
                    r10 = r102;
                    try {
                        closeable.close();
                        th = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    if (th != null) {
                        if (z) {
                            Mutex.DefaultImpls.unlock$default(fileStorageConnection.transactionMutex, null, 1, null);
                        }
                        return r10;
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        th = th4;
                        r102 = z;
                        this = fileStorageConnection;
                    }
                } catch (Throwable th5) {
                    r102 = z ? 1 : 0;
                    this = fileStorageConnection;
                    th = th5;
                    try {
                        closeable.close();
                        throw th;
                    } catch (Throwable th6) {
                        ExceptionsKt.addSuppressed(th, th6);
                        throw th;
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
        if (r102 != 0) {
            Mutex.DefaultImpls.unlock$default(this.transactionMutex, null, 1, null);
        }
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3 A[Catch: all -> 0x010e, IOException -> 0x0111, TRY_ENTER, TryCatch #5 {IOException -> 0x0111, blocks: (B:34:0x00c3, B:36:0x00c9, B:39:0x00d2, B:40:0x00f6, B:44:0x00ff, B:51:0x010d, B:50:0x010a), top: B:66:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff A[Catch: all -> 0x010e, IOException -> 0x0111, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0111, blocks: (B:34:0x00c3, B:36:0x00c9, B:39:0x00d2, B:40:0x00f6, B:44:0x00ff, B:51:0x010d, B:50:0x010a), top: B:66:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.File, java.lang.Object] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        C05381 c05381;
        ?? file;
        Mutex mutex;
        FileWriteScope fileWriteScope;
        Throwable th;
        Closeable closeable;
        FileStorageConnection<T> fileStorageConnection;
        Mutex mutex2;
        ?? r9;
        if (continuation instanceof C05381) {
            c05381 = (C05381) continuation;
            if ((c05381.label & Integer.MIN_VALUE) != 0) {
                c05381.label -= Integer.MIN_VALUE;
            } else {
                c05381 = new C05381(this, continuation);
            }
        }
        ?? r10 = c05381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05381.label;
        try {
            try {
                try {
                    try {
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(r10);
                                checkNotClosed();
                                createParentDirectories(this.file);
                                mutex = this.transactionMutex;
                                c05381.L$0 = this;
                                c05381.L$1 = function2;
                                c05381.L$2 = mutex;
                                c05381.label = 1;
                                if (mutex.lock(null, c05381) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            }
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                closeable = (Closeable) c05381.L$3;
                                File file2 = (File) c05381.L$2;
                                mutex2 = (Mutex) c05381.L$1;
                                fileStorageConnection = (FileStorageConnection) c05381.L$0;
                                try {
                                    ResultKt.throwOnFailure(r10);
                                    r9 = file2;
                                    Unit unit = Unit.INSTANCE;
                                    try {
                                        closeable.close();
                                        th = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    if (th == null) {
                                        throw th;
                                    }
                                    if (r9.exists() && !FileMoves_androidKt.atomicMoveTo(r9, fileStorageConnection.file)) {
                                        throw new IOException("Unable to rename " + r9 + " to " + fileStorageConnection.file + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                    mutex2.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        closeable.close();
                                    } catch (Throwable th4) {
                                        ExceptionsKt.addSuppressed(th, th4);
                                    }
                                    throw th;
                                }
                            }
                            Mutex mutex3 = (Mutex) c05381.L$2;
                            function2 = (Function2) c05381.L$1;
                            FileStorageConnection<T> fileStorageConnection2 = (FileStorageConnection) c05381.L$0;
                            ResultKt.throwOnFailure(r10);
                            mutex = mutex3;
                            this = fileStorageConnection2;
                            c05381.L$0 = this;
                            c05381.L$1 = mutex;
                            c05381.L$2 = file;
                            c05381.L$3 = fileWriteScope;
                            c05381.label = 2;
                            if (function2.invoke(fileWriteScope, c05381) != coroutine_suspended) {
                                fileStorageConnection = this;
                                mutex2 = mutex;
                                r9 = file;
                                closeable = fileWriteScope;
                                Unit unit3 = Unit.INSTANCE;
                                closeable.close();
                                th = null;
                                if (th == null) {
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = fileWriteScope;
                            closeable.close();
                            throw th;
                        }
                        fileWriteScope = new FileWriteScope(file, this.serializer);
                    } catch (IOException e) {
                        e = e;
                        if (file.exists()) {
                            file.delete();
                        }
                        throw e;
                    }
                    file = new File(this.file.getAbsolutePath() + ".tmp");
                } catch (Throwable th6) {
                    th = th6;
                    r10.unlock(null);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                file = function2;
            }
        } catch (Throwable th7) {
            th = th7;
            r10 = coroutine_suspended;
            r10.unlock(null);
            throw th;
        }
    }
}
