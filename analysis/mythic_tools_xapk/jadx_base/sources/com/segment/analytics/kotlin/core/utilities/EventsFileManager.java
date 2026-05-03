package com.segment.analytics.kotlin.core.utilities;

import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.WebmConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: EventsFileManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "Deprecated in favor of EventStream")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0005J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0011\u0010\u001d\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0003H\u0002J\u0019\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\u0003H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/EventsFileManager;", "", "directory", "Ljava/io/File;", "writeKey", "", "kvs", "Lcom/segment/analytics/kotlin/core/utilities/KVS;", "subject", "(Ljava/io/File;Ljava/lang/String;Lcom/segment/analytics/kotlin/core/utilities/KVS;Ljava/lang/String;)V", "curFile", "getDirectory", "()Ljava/io/File;", "fileIndexKey", AndroidContextPlugin.OS_KEY, "Ljava/io/FileOutputStream;", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "currentFile", "finish", "", "incrementFileIndex", "", "read", "", "registerShutdownHook", "remove", "filePath", "reset", "rollover", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "file", "storeEvent", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLock", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeToFile", FirebaseAnalytics.Param.CONTENT, "", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EventsFileManager {
    public static final int MAX_FILE_SIZE = 475000;
    private File curFile;
    private final File directory;
    private final String fileIndexKey;
    private final KVS kvs;
    private FileOutputStream os;
    private final Semaphore semaphore;
    private final String writeKey;

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.utilities.EventsFileManager$withLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventsFileManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.utilities.EventsFileManager", f = "EventsFileManager.kt", i = {0, 0}, l = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS}, m = "withLock", n = {"this", "block"}, s = {"L$0", "L$1"})
    static final class C10911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10911(Continuation<? super C10911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventsFileManager.this.withLock(null, this);
        }
    }

    public EventsFileManager(File directory, String writeKey, KVS kvs, String str) throws IOException {
        StringBuilder sb;
        StringBuilder sbAppend;
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(kvs, "kvs");
        this.directory = directory;
        this.writeKey = writeKey;
        this.kvs = kvs;
        FileUtils.createDirectory(directory);
        registerShutdownHook();
        if (str == null) {
            sb = new StringBuilder("segment.events.file.index.");
            sbAppend = sb.append(writeKey);
        } else {
            sb = new StringBuilder("segment.events.file.index.");
            sbAppend = sb.append(writeKey).append(FilenameUtils.EXTENSION_SEPARATOR).append(str);
        }
        this.fileIndexKey = sbAppend.toString();
        this.semaphore = SemaphoreKt.Semaphore$default(1, 0, 2, null);
    }

    public /* synthetic */ EventsFileManager(File file, String str, KVS kvs, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, str, kvs, (i & 8) != 0 ? null : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File currentFile() {
        File file = this.curFile;
        if (file == null) {
            file = new File(this.directory, this.writeKey + Soundex.SILENT_MARKER + this.kvs.getInt(this.fileIndexKey, 0) + ".tmp");
        }
        this.curFile = file;
        Intrinsics.checkNotNull(file);
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finish() throws IOException {
        File fileCurrentFile = currentFile();
        if (fileCurrentFile.exists()) {
            byte[] bytes = ("],\"sentAt\":\"" + SegmentInstant.INSTANCE.now() + "\",\"writeKey\":\"" + this.writeKey + "\"}").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            writeToFile(bytes, fileCurrentFile);
            fileCurrentFile.renameTo(new File(this.directory, FilesKt.getNameWithoutExtension(fileCurrentFile)));
            FileOutputStream fileOutputStream = this.os;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            incrementFileIndex();
            reset();
        }
    }

    private final boolean incrementFileIndex() {
        return this.kvs.putInt(this.fileIndexKey, this.kvs.getInt(this.fileIndexKey, 0) + 1);
    }

    static final boolean read$lambda$0(EventsFileManager this$0, File file, String name) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt.contains$default((CharSequence) name, (CharSequence) this$0.writeKey, false, 2, (Object) null) && !StringsKt.endsWith$default(name, ".tmp", false, 2, (Object) null);
    }

    private final void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.segment.analytics.kotlin.core.utilities.EventsFileManager.registerShutdownHook.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws IOException {
                FileOutputStream fileOutputStream = EventsFileManager.this.os;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        });
    }

    private final void reset() {
        this.os = null;
        this.curFile = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void start(File file) throws IOException {
        byte[] bytes = "{\"batch\":[".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        writeToFile(bytes, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object withLock(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        C10911 c10911;
        if (continuation instanceof C10911) {
            c10911 = (C10911) continuation;
            if ((c10911.label & Integer.MIN_VALUE) != 0) {
                c10911.label -= Integer.MIN_VALUE;
            } else {
                c10911 = new C10911(continuation);
            }
        }
        Object obj = c10911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10911.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore semaphore = this.semaphore;
            c10911.L$0 = this;
            c10911.L$1 = function0;
            c10911.label = 1;
            if (semaphore.acquire(c10911) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) c10911.L$1;
            this = (EventsFileManager) c10911.L$0;
            ResultKt.throwOnFailure(obj);
        }
        function0.invoke();
        this.semaphore.release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeToFile(byte[] content, File file) throws IOException {
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream == null) {
            fileOutputStream = new FileOutputStream(file, true);
        }
        this.os = fileOutputStream;
        if (fileOutputStream != null) {
            fileOutputStream.write(content);
            fileOutputStream.flush();
        }
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final List<String> read() {
        File[] fileArrListFiles = this.directory.listFiles(new FilenameFilter() { // from class: com.segment.analytics.kotlin.core.utilities.EventsFileManager$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return EventsFileManager.read$lambda$0(this.f$0, file, str);
            }
        });
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file : fileArrListFiles) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    public final boolean remove(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new File(filePath).delete();
    }

    public final Object rollover(Continuation<? super Unit> continuation) {
        Object objWithLock = withLock(new Function0<Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.EventsFileManager.rollover.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws IOException {
                EventsFileManager.this.finish();
            }
        }, continuation);
        return objWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithLock : Unit.INSTANCE;
    }

    public final Object storeEvent(final String str, Continuation<? super Unit> continuation) {
        Object objWithLock = withLock(new Function0<Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.EventsFileManager.storeEvent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws IOException {
                boolean z;
                File fileCurrentFile = EventsFileManager.this.currentFile();
                boolean z2 = true;
                if (fileCurrentFile.exists()) {
                    z = false;
                } else {
                    fileCurrentFile.createNewFile();
                    EventsFileManager.this.start(fileCurrentFile);
                    z = true;
                }
                if (fileCurrentFile.length() > 475000) {
                    EventsFileManager.this.finish();
                    fileCurrentFile = EventsFileManager.this.currentFile();
                    fileCurrentFile.createNewFile();
                    EventsFileManager.this.start(fileCurrentFile);
                } else {
                    z2 = z;
                }
                String str2 = (!z2 ? "," : "") + str;
                EventsFileManager eventsFileManager = EventsFileManager.this;
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                eventsFileManager.writeToFile(bytes, fileCurrentFile);
            }
        }, continuation);
        return objWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithLock : Unit.INSTANCE;
    }
}
