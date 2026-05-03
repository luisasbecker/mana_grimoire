package androidx.datastore.core.okio;

import androidx.datastore.core.Closeable;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.ReadScope;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.core.WriteScope;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
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
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: OkioStorage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016JX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0001\u0010\u00182B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001a¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\r2-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 \u0012\u0006\u0012\u0004\u0018\u00010!0%¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010'R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final FileSystem fileSystem;
    private final Function0<Unit> onClose;
    private final Path path;
    private final OkioSerializer<T> serializer;
    private final Mutex transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkioStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", i = {0, 0, 0}, l = {113}, m = "readScope", n = {"this", "$this$use$iv", "lock"}, s = {"L$0", "L$1", "Z$0"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OkioStorageConnection<T> okioStorageConnection, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = okioStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OkioStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {WebmConstants.MkvEbmlElement.VOID, 137}, m = "writeScope", n = {"this", "block", "parentDir", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "scratchPath", "$this$use$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class C05421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05421(OkioStorageConnection<T> okioStorageConnection, Continuation<? super C05421> continuation) {
            super(continuation);
            this.this$0 = okioStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public OkioStorageConnection(FileSystem fileSystem, Path path, OkioSerializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        Closeable closeable;
        OkioStorageConnection<T> okioStorageConnection;
        boolean z;
        ?? r11;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        }
        ?? r112 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(r112);
                checkNotClosed();
                boolean zTryLock$default = Mutex.DefaultImpls.tryLock$default(this.transactionMutex, null, 1, null);
                OkioReadScope okioReadScope = new OkioReadScope(this.fileSystem, this.path, this.serializer);
                try {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zTryLock$default);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = okioReadScope;
                    anonymousClass1.Z$0 = zTryLock$default;
                    anonymousClass1.label = 1;
                    Object objInvoke = function3.invoke(okioReadScope, boolBoxBoolean, anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    okioStorageConnection = this;
                    z = zTryLock$default ? 1 : 0;
                    r11 = objInvoke;
                    closeable = okioReadScope;
                    closeable.close();
                    th = null;
                    if (th != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = okioReadScope;
                    r112 = zTryLock$default;
                    closeable.close();
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = anonymousClass1.Z$0;
                closeable = (Closeable) anonymousClass1.L$1;
                okioStorageConnection = (OkioStorageConnection) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(r112);
                    r11 = r112;
                    try {
                        closeable.close();
                        th = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    if (th != null) {
                        if (z) {
                            Mutex.DefaultImpls.unlock$default(okioStorageConnection.transactionMutex, null, 1, null);
                        }
                        return r11;
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        th = th4;
                        r112 = z;
                        this = okioStorageConnection;
                    }
                } catch (Throwable th5) {
                    r112 = z ? 1 : 0;
                    this = okioStorageConnection;
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
        if (r112 != 0) {
            Mutex.DefaultImpls.unlock$default(this.transactionMutex, null, 1, null);
        }
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9 A[Catch: all -> 0x00ff, IOException -> 0x0102, TRY_ENTER, TryCatch #6 {IOException -> 0x0102, blocks: (B:37:0x00d9, B:39:0x00e1, B:43:0x00f0, B:50:0x00fe, B:49:0x00fb), top: B:79:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0 A[Catch: all -> 0x00ff, IOException -> 0x0102, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x0102, blocks: (B:37:0x00d9, B:39:0x00e1, B:43:0x00f0, B:50:0x00fe, B:49:0x00fb), top: B:79:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v4, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r10v1, types: [okio.Path] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v1, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        C05421 c05421;
        ?? r11;
        ?? r10;
        ?? r0;
        Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22;
        Path path;
        Path path2;
        OkioWriteScope okioWriteScope;
        Throwable th;
        Closeable closeable;
        OkioStorageConnection<T> okioStorageConnection;
        ?? r1;
        Path path3;
        if (continuation instanceof C05421) {
            C05421 c054212 = (C05421) continuation;
            if ((c054212.label & Integer.MIN_VALUE) != 0) {
                c054212.label -= Integer.MIN_VALUE;
                c05421 = c054212;
            } else {
                c05421 = new C05421(this, continuation);
            }
        }
        Object obj = c05421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05421.label;
        try {
            try {
                try {
                    try {
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                checkNotClosed();
                                Path pathParent = this.path.parent();
                                if (pathParent == null) {
                                    throw new IllegalStateException("must have a parent path".toString());
                                }
                                this.fileSystem.createDirectories(pathParent, false);
                                Mutex mutex = this.transactionMutex;
                                c05421.L$0 = this;
                                c05421.L$1 = function2;
                                c05421.L$2 = pathParent;
                                c05421.L$3 = mutex;
                                c05421.label = 1;
                                if (mutex.lock(null, c05421) != coroutine_suspended) {
                                    function22 = function2;
                                    path = pathParent;
                                    r11 = mutex;
                                }
                                return coroutine_suspended;
                            }
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                closeable = (Closeable) c05421.L$3;
                                Path path4 = (Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object>) ((Path) c05421.L$2);
                                Mutex mutex2 = (Mutex) c05421.L$1;
                                okioStorageConnection = (OkioStorageConnection) c05421.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r1 = mutex2;
                                    path3 = path4;
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
                                    if (okioStorageConnection.fileSystem.exists(path3)) {
                                        okioStorageConnection.fileSystem.atomicMove(path3, okioStorageConnection.path);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                    r1.unlock(null);
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
                            Mutex mutex3 = (Mutex) c05421.L$3;
                            path = (Path) c05421.L$2;
                            Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function23 = (Function2) c05421.L$1;
                            OkioStorageConnection<T> okioStorageConnection2 = (OkioStorageConnection) c05421.L$0;
                            ResultKt.throwOnFailure(obj);
                            r11 = mutex3;
                            this = okioStorageConnection2;
                            function22 = function23;
                            c05421.L$0 = this;
                            c05421.L$1 = r11;
                            c05421.L$2 = path2;
                            c05421.L$3 = okioWriteScope;
                            c05421.label = 2;
                            if (function22.invoke(okioWriteScope, c05421) != coroutine_suspended) {
                                okioStorageConnection = this;
                                r1 = r11;
                                closeable = okioWriteScope;
                                path3 = path2;
                                Unit unit3 = Unit.INSTANCE;
                                closeable.close();
                                th = null;
                                if (th == null) {
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = okioWriteScope;
                            closeable.close();
                            throw th;
                        }
                        this.fileSystem.delete(path2, false);
                        okioWriteScope = new OkioWriteScope(this.fileSystem, path2, this.serializer);
                    } catch (IOException e) {
                        r0 = this;
                        e = e;
                        r10 = path2;
                        r11 = r11;
                        if (!r0.fileSystem.exists(r10)) {
                            throw e;
                        }
                        try {
                            r0.fileSystem.delete(r10);
                            throw e;
                        } catch (IOException unused) {
                            throw e;
                        }
                    }
                    path2 = (Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object>) path.resolve(this.path.name() + ".tmp");
                } catch (Throwable th6) {
                    th = th6;
                    r11.unlock(null);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                r11 = coroutine_suspended;
                r0 = c05421;
                r10 = function2;
            }
        } catch (Throwable th7) {
            th = th7;
            r11 = coroutine_suspended;
            r11.unlock(null);
            throw th;
        }
    }
}
