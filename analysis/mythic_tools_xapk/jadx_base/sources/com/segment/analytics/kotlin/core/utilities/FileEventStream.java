package com.segment.analytics.kotlin.core.utilities;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventStream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J-\u0010\u0019\u001a\u00020\u00182#\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001cH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001cH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/FileEventStream;", "Lcom/segment/analytics/kotlin/core/utilities/EventStream;", "directory", "Ljava/io/File;", "(Ljava/io/File;)V", "currFile", "getCurrFile", "()Ljava/io/File;", "setCurrFile", "getDirectory", "fs", "Ljava/io/FileOutputStream;", "getFs", "()Ljava/io/FileOutputStream;", "setFs", "(Ljava/io/FileOutputStream;)V", "isOpened", "", "()Z", "length", "", "getLength", "()J", "close", "", "finishAndClose", "withRename", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "openOrCreate", "file", "read", "", "readAsStream", "Ljava/io/InputStream;", "source", "registerShutdownHook", "remove", "write", FirebaseAnalytics.Param.CONTENT, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class FileEventStream implements EventStream {
    private File currFile;
    private final File directory;
    private FileOutputStream fs;

    public FileEventStream(File directory) throws IOException {
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.directory = directory;
        FileUtils.createDirectory(directory);
        registerShutdownHook();
    }

    private final void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.segment.analytics.kotlin.core.utilities.FileEventStream.registerShutdownHook.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws IOException {
                FileOutputStream fs = FileEventStream.this.getFs();
                if (fs != null) {
                    fs.close();
                }
            }
        });
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void close() throws IOException {
        FileOutputStream fs = getFs();
        if (fs != null) {
            fs.close();
        }
        setFs(null);
        setCurrFile(null);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void finishAndClose(Function1<? super String, String> withRename) throws IOException {
        FileOutputStream fs = getFs();
        if (fs != null) {
            fs.close();
        }
        setFs(null);
        File currFile = getCurrFile();
        if (currFile != null && withRename != null) {
            File file = this.directory;
            String name = currFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            currFile.renameTo(new File(file, withRename.invoke(name)));
        }
        setCurrFile(null);
    }

    protected File getCurrFile() {
        return this.currFile;
    }

    public final File getDirectory() {
        return this.directory;
    }

    protected FileOutputStream getFs() {
        return this.fs;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public long getLength() {
        File currFile = getCurrFile();
        if (currFile != null) {
            return currFile.length();
        }
        return 0L;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public boolean isOpened() {
        return (getCurrFile() == null || getFs() == null) ? false : true;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public boolean openOrCreate(String file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        File currFile = getCurrFile();
        boolean z = false;
        if (currFile != null) {
            String name = currFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            if (!StringsKt.endsWith$default(name, file, false, 2, (Object) null)) {
                close();
            }
        }
        if (getCurrFile() == null) {
            setCurrFile(new File(this.directory, file));
        }
        File currFile2 = getCurrFile();
        if (currFile2 != null) {
            if (!currFile2.exists()) {
                currFile2.createNewFile();
                z = true;
            }
            FileOutputStream fs = getFs();
            if (fs == null) {
                fs = new FileOutputStream(currFile2, true);
            }
            setFs(fs);
        }
        return z;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public List<String> read() {
        File[] fileArrListFiles = this.directory.listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file : fileArrListFiles) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public InputStream readAsStream(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        File file = new File(source);
        if (file.exists()) {
            return new FileInputStream(file);
        }
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void remove(String file) {
        Intrinsics.checkNotNullParameter(file, "file");
        new File(file).delete();
    }

    protected void setCurrFile(File file) {
        this.currFile = file;
    }

    protected void setFs(FileOutputStream fileOutputStream) {
        this.fs = fileOutputStream;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void write(String content) throws IOException {
        Intrinsics.checkNotNullParameter(content, "content");
        FileOutputStream fs = getFs();
        if (fs != null) {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            fs.write(bytes);
            fs.flush();
        }
    }
}
