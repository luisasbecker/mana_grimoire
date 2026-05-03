package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: PathTreeWalk.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0082\u0004JC\u0010\u0017\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 \u0012\u0004\u0012\u00020\u00180\u001fH\u0082È\u0004¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0082\u0080\u0004J\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0082\u0080\u0004R\u000f\u0010\u0003\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\tR\u0015\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "[Lkotlin/io/path/PathWalkOption;", "followLinks", "", "getFollowLinks", "()Z", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "includeDirectories", "getIncludeDirectories", "isBFS", "iterator", "", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dfsIterator", "bfsIterator", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {191, 197}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded"}, nl = {193, 199}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = PathTreeWalk.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
        
            r2 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws FileSystemLoopException {
            DirectoryEntriesReader directoryEntriesReader;
            ArrayDeque arrayDeque;
            Path path;
            DirectoryEntriesReader directoryEntriesReader2;
            PathTreeWalk pathTreeWalk;
            PathNode pathNode;
            LinkOption[] linkOptionArr;
            ArrayDeque arrayDeque2;
            DirectoryEntriesReader directoryEntriesReader3;
            Path path2;
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayDeque arrayDeque3 = new ArrayDeque();
                directoryEntriesReader = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                arrayDeque3.addLast(new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null));
                arrayDeque = arrayDeque3;
            } else if (i == 1) {
                path2 = (Path) this.L$8;
                directoryEntriesReader3 = (DirectoryEntriesReader) this.L$7;
                pathNode = (PathNode) this.L$6;
                pathTreeWalk = (PathTreeWalk) this.L$4;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
                arrayDeque2 = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
                path = path2;
                directoryEntriesReader = directoryEntriesReader3;
                arrayDeque = arrayDeque2;
                LinkOption[] linkOptions = pathTreeWalk.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    arrayDeque.addAll(directoryEntriesReader.readEntries(pathNode));
                    directoryEntriesReader = directoryEntriesReader2;
                } else {
                    directoryEntriesReader = directoryEntriesReader2;
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                directoryEntriesReader = (DirectoryEntriesReader) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            while (!arrayDeque.isEmpty()) {
                pathNode = (PathNode) arrayDeque.removeFirst();
                pathTreeWalk = PathTreeWalk.this;
                path = pathNode.getPath();
                if (pathNode.getParent() != null) {
                    PathsKt.checkFileName(path);
                }
                LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    if (PathTreeWalkKt.createsCycle(pathNode)) {
                        throw new FileSystemLoopException(path.toString());
                    }
                    if (pathTreeWalk.getIncludeDirectories()) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.L$4 = pathTreeWalk;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$6 = pathNode;
                        this.L$7 = directoryEntriesReader;
                        this.L$8 = path;
                        this.I$0 = 0;
                        this.label = 1;
                        if (sequenceScope.yield(path, this) != coroutine_suspended) {
                            directoryEntriesReader2 = directoryEntriesReader;
                            arrayDeque2 = arrayDeque;
                            path2 = path;
                            directoryEntriesReader3 = directoryEntriesReader2;
                            path = path2;
                            directoryEntriesReader = directoryEntriesReader3;
                            arrayDeque = arrayDeque2;
                            LinkOption[] linkOptions3 = pathTreeWalk.getLinkOptions();
                            linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                            }
                            while (!arrayDeque.isEmpty()) {
                            }
                        }
                    } else {
                        directoryEntriesReader2 = directoryEntriesReader;
                        LinkOption[] linkOptions32 = pathTreeWalk.getLinkOptions();
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        }
                        while (!arrayDeque.isEmpty()) {
                        }
                    }
                } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                    this.L$0 = sequenceScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = directoryEntriesReader;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(pathNode);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(directoryEntriesReader);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(path);
                    this.I$0 = 0;
                    this.label = 2;
                    if (sequenceScope.yield(path, this) == coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {191, 197, 210, 216}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded"}, nl = {193, 199, 212, 218}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C12721 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        C12721(Continuation<? super C12721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12721 c12721 = PathTreeWalk.this.new C12721(continuation);
            c12721.L$0 = obj;
            return c12721;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C12721) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x01e5, code lost:
        
            if (r1.yield(r12, r17) == r2) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0317, code lost:
        
            if (r1.yield(r14, r17) == r2) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01eb, code lost:
        
            r6 = r13;
            r4 = 4;
         */
        /* JADX WARN: Path cross not found for [B:4:0x0013, B:14:0x00d0], limit reached: 74 */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01f4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x02a1  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x02af  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0324  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0317 -> B:71:0x031a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x031d -> B:71:0x031a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x031f -> B:71:0x031a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws FileSystemLoopException {
            ArrayDeque arrayDeque;
            DirectoryEntriesReader directoryEntriesReader;
            PathNode pathNode;
            DirectoryEntriesReader directoryEntriesReader2;
            PathNode pathNode2;
            PathTreeWalk pathTreeWalk;
            Path path;
            DirectoryEntriesReader directoryEntriesReader3;
            PathNode pathNode3;
            DirectoryEntriesReader directoryEntriesReader4;
            ArrayDeque arrayDeque2;
            PathNode pathNode4;
            PathTreeWalk pathTreeWalk2;
            Path path2;
            LinkOption[] linkOptionArr;
            Path path3;
            DirectoryEntriesReader directoryEntriesReader5;
            PathNode next;
            PathNode pathNode5;
            PathTreeWalk pathTreeWalk3;
            LinkOption[] linkOptionArr2;
            ArrayDeque arrayDeque3;
            PathNode pathNode6;
            PathNode pathNode7;
            Path path4;
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            char c = 4;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                arrayDeque = new ArrayDeque();
                directoryEntriesReader = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                pathNode = new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null);
                PathTreeWalk pathTreeWalk4 = PathTreeWalk.this;
                Path path5 = pathNode.getPath();
                if (pathNode.getParent() != null) {
                    PathsKt.checkFileName(path5);
                }
                LinkOption[] linkOptions = pathTreeWalk4.getLinkOptions();
                LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (!Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                    if (Files.exists(path5, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk4);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(directoryEntriesReader);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(path5);
                        this.I$0 = 0;
                        this.label = 2;
                    }
                    directoryEntriesReader2 = directoryEntriesReader;
                    pathNode2 = pathNode;
                    if (arrayDeque.isEmpty()) {
                    }
                } else {
                    if (PathTreeWalkKt.createsCycle(pathNode)) {
                        throw new FileSystemLoopException(path5.toString());
                    }
                    if (pathTreeWalk4.getIncludeDirectories()) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.L$3 = pathNode;
                        this.L$4 = pathTreeWalk4;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$6 = pathNode;
                        this.L$7 = directoryEntriesReader;
                        this.L$8 = path5;
                        this.I$0 = 0;
                        this.label = 1;
                        if (sequenceScope.yield(path5, this) != coroutine_suspended) {
                            directoryEntriesReader4 = directoryEntriesReader;
                            arrayDeque2 = arrayDeque;
                            pathNode4 = pathNode;
                            pathTreeWalk2 = pathTreeWalk4;
                            path2 = path5;
                            directoryEntriesReader3 = directoryEntriesReader4;
                            pathNode3 = pathNode4;
                            ArrayDeque arrayDeque4 = arrayDeque2;
                            path = path2;
                            directoryEntriesReader = directoryEntriesReader4;
                            pathTreeWalk = pathTreeWalk2;
                            pathNode = pathNode4;
                            arrayDeque = arrayDeque4;
                            LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                            linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                            }
                            pathNode2 = pathNode3;
                            directoryEntriesReader2 = directoryEntriesReader3;
                            if (arrayDeque.isEmpty()) {
                            }
                        }
                    } else {
                        pathTreeWalk = pathTreeWalk4;
                        path = path5;
                        directoryEntriesReader3 = directoryEntriesReader;
                        pathNode3 = pathNode;
                        LinkOption[] linkOptions22 = pathTreeWalk.getLinkOptions();
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
                        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        }
                        pathNode2 = pathNode3;
                        directoryEntriesReader2 = directoryEntriesReader3;
                        if (arrayDeque.isEmpty()) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                path2 = (Path) this.L$8;
                directoryEntriesReader4 = (DirectoryEntriesReader) this.L$7;
                pathNode4 = (PathNode) this.L$6;
                pathTreeWalk2 = (PathTreeWalk) this.L$4;
                pathNode3 = (PathNode) this.L$3;
                directoryEntriesReader3 = (DirectoryEntriesReader) this.L$2;
                arrayDeque2 = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
                ArrayDeque arrayDeque42 = arrayDeque2;
                path = path2;
                directoryEntriesReader = directoryEntriesReader4;
                pathTreeWalk = pathTreeWalk2;
                pathNode = pathNode4;
                arrayDeque = arrayDeque42;
                LinkOption[] linkOptions222 = pathTreeWalk.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions222, linkOptions222.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    pathNode3.setContentIterator(directoryEntriesReader.readEntries(pathNode).iterator());
                    arrayDeque.addLast(pathNode3);
                }
                pathNode2 = pathNode3;
                directoryEntriesReader2 = directoryEntriesReader3;
                if (arrayDeque.isEmpty()) {
                }
            } else if (i == 2) {
                pathNode2 = (PathNode) this.L$3;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
                if (arrayDeque.isEmpty()) {
                }
            } else if (i == 3) {
                path4 = (Path) this.L$11;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.L$10;
                pathNode7 = (PathNode) this.L$9;
                pathTreeWalk3 = (PathTreeWalk) this.L$7;
                pathNode5 = (PathNode) this.L$6;
                pathNode6 = (PathNode) this.L$3;
                directoryEntriesReader5 = (DirectoryEntriesReader) this.L$2;
                arrayDeque3 = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
                ArrayDeque arrayDeque5 = arrayDeque3;
                path3 = path4;
                pathNode2 = pathNode6;
                next = pathNode7;
                arrayDeque = arrayDeque5;
                LinkOption[] linkOptions3 = pathTreeWalk3.getLinkOptions();
                linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                }
                if (arrayDeque.isEmpty()) {
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pathNode2 = (PathNode) this.L$3;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
                char c2 = 4;
                c = c2;
                if (arrayDeque.isEmpty()) {
                    PathNode pathNode8 = (PathNode) arrayDeque.last();
                    Iterator<PathNode> contentIterator = pathNode8.getContentIterator();
                    Intrinsics.checkNotNull(contentIterator);
                    if (contentIterator.hasNext()) {
                        next = contentIterator.next();
                        PathTreeWalk pathTreeWalk5 = PathTreeWalk.this;
                        path3 = next.getPath();
                        if (next.getParent() != null) {
                            PathsKt.checkFileName(path3);
                        }
                        LinkOption[] linkOptions4 = pathTreeWalk5.getLinkOptions();
                        LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
                        if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                            if (PathTreeWalkKt.createsCycle(next)) {
                                throw new FileSystemLoopException(path3.toString());
                            }
                            if (pathTreeWalk5.getIncludeDirectories()) {
                                this.L$0 = sequenceScope;
                                this.L$1 = arrayDeque;
                                this.L$2 = directoryEntriesReader2;
                                this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(pathNode8);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                                this.L$6 = next;
                                this.L$7 = pathTreeWalk5;
                                this.L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                this.L$9 = next;
                                this.L$10 = directoryEntriesReader2;
                                this.L$11 = path3;
                                this.I$0 = 0;
                                this.label = 3;
                                if (sequenceScope.yield(path3, this) != coroutine_suspended) {
                                    pathNode5 = next;
                                    pathTreeWalk3 = pathTreeWalk5;
                                    pathNode6 = pathNode2;
                                    directoryEntriesReader5 = directoryEntriesReader2;
                                    path4 = path3;
                                    arrayDeque3 = arrayDeque;
                                    pathNode7 = pathNode5;
                                    ArrayDeque arrayDeque52 = arrayDeque3;
                                    path3 = path4;
                                    pathNode2 = pathNode6;
                                    next = pathNode7;
                                    arrayDeque = arrayDeque52;
                                    LinkOption[] linkOptions32 = pathTreeWalk3.getLinkOptions();
                                    linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                                    if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                                        pathNode5.setContentIterator(directoryEntriesReader2.readEntries(next).iterator());
                                        arrayDeque.addLast(pathNode5);
                                        directoryEntriesReader2 = directoryEntriesReader5;
                                        c = 4;
                                    } else {
                                        directoryEntriesReader2 = directoryEntriesReader5;
                                        c = 4;
                                    }
                                    if (arrayDeque.isEmpty()) {
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else {
                                pathNode5 = next;
                                pathTreeWalk3 = pathTreeWalk5;
                                directoryEntriesReader5 = directoryEntriesReader2;
                                LinkOption[] linkOptions322 = pathTreeWalk3.getLinkOptions();
                                linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions322, linkOptions322.length);
                                if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                                }
                                if (arrayDeque.isEmpty()) {
                                }
                            }
                        } else if (Files.exists(path3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                            this.L$0 = sequenceScope;
                            this.L$1 = arrayDeque;
                            this.L$2 = directoryEntriesReader2;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(pathNode8);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(next);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(pathTreeWalk5);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(next);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(directoryEntriesReader2);
                            this.L$11 = SpillingKt.nullOutSpilledVariable(path3);
                            this.I$0 = 0;
                            c2 = 4;
                            this.label = 4;
                        } else {
                            c2 = 4;
                        }
                        return coroutine_suspended;
                    }
                    c2 = c;
                    arrayDeque.removeLast();
                    c = c2;
                    if (arrayDeque.isEmpty()) {
                    }
                }
            }
        }
    }

    public PathTreeWalk(Path start, PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new AnonymousClass1(null));
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C12721(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> sequenceScope, PathNode pathNode, DirectoryEntriesReader directoryEntriesReader, Function1<? super List<PathNode>, Unit> function1, Continuation<? super Unit> continuation) throws FileSystemLoopException {
        Path path = pathNode.getPath();
        if (pathNode.getParent() != null) {
            PathsKt.checkFileName(path);
        }
        LinkOption[] linkOptions = getLinkOptions();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (PathTreeWalkKt.createsCycle(pathNode)) {
                throw new FileSystemLoopException(path.toString());
            }
            if (getIncludeDirectories()) {
                sequenceScope.yield(path, continuation);
            }
            LinkOption[] linkOptions2 = getLinkOptions();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                function1.invoke(directoryEntriesReader.readEntries(pathNode));
            }
        } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            sequenceScope.yield(path, continuation);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        return isBFS() ? bfsIterator() : dfsIterator();
    }
}
