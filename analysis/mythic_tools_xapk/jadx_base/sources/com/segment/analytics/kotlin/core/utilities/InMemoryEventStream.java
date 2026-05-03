package com.segment.analytics.kotlin.core.utilities;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: EventStream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J-\u0010\u0017\u001a\u00020\u00162#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/InMemoryEventStream;", "Lcom/segment/analytics/kotlin/core/utilities/EventStream;", "()V", "currFile", "Lcom/segment/analytics/kotlin/core/utilities/InMemoryEventStream$InMemoryFile;", "getCurrFile", "()Lcom/segment/analytics/kotlin/core/utilities/InMemoryEventStream$InMemoryFile;", "setCurrFile", "(Lcom/segment/analytics/kotlin/core/utilities/InMemoryEventStream$InMemoryFile;)V", "directory", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getDirectory", "()Ljava/util/concurrent/ConcurrentHashMap;", "isOpened", "", "()Z", "length", "", "getLength", "()J", "close", "", "finishAndClose", "withRename", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "openOrCreate", "file", "read", "", "readAsStream", "Ljava/io/InputStream;", "source", "remove", "write", FirebaseAnalytics.Param.CONTENT, "InMemoryFile", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class InMemoryEventStream implements EventStream {
    private InMemoryFile currFile;
    private final ConcurrentHashMap<String, InMemoryFile> directory = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: EventStream.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0013\u001a\u00020\u0003R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/InMemoryEventStream$InMemoryFile;", "", "name", "", "(Ljava/lang/String;)V", "fileStream", "Ljava/lang/StringBuilder;", "getFileStream", "()Ljava/lang/StringBuilder;", "length", "", "getLength", "()I", "getName", "()Ljava/lang/String;", "toStream", "Ljava/io/ByteArrayInputStream;", "write", "kotlin.jvm.PlatformType", FirebaseAnalytics.Param.CONTENT, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InMemoryFile {
        private final StringBuilder fileStream;
        private final String name;

        public InMemoryFile(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.fileStream = new StringBuilder();
        }

        public final StringBuilder getFileStream() {
            return this.fileStream;
        }

        public final int getLength() {
            return this.fileStream.length();
        }

        public final String getName() {
            return this.name;
        }

        public final ByteArrayInputStream toStream() {
            String string = this.fileStream.toString();
            Intrinsics.checkNotNullExpressionValue(string, "fileStream.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }

        public final StringBuilder write(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return this.fileStream.append(content);
        }
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void close() {
        setCurrFile(null);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void finishAndClose(Function1<? super String, String> withRename) {
        InMemoryFile currFile = getCurrFile();
        if (currFile != null) {
            if (withRename != null) {
                this.directory.remove(currFile.getName());
                this.directory.put(withRename.invoke(currFile.getName()), currFile);
            }
            setCurrFile(null);
        }
    }

    protected InMemoryFile getCurrFile() {
        return this.currFile;
    }

    protected final ConcurrentHashMap<String, InMemoryFile> getDirectory() {
        return this.directory;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public long getLength() {
        return getCurrFile() != null ? r2.getLength() : 0;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public boolean isOpened() {
        return getCurrFile() != null;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public boolean openOrCreate(String file) {
        boolean z;
        Intrinsics.checkNotNullParameter(file, "file");
        InMemoryFile currFile = getCurrFile();
        if (currFile != null && !Intrinsics.areEqual(currFile.getName(), file)) {
            close();
        }
        if (getCurrFile() == null) {
            boolean zContainsKey = this.directory.containsKey(file);
            z = !zContainsKey;
            setCurrFile(!zContainsKey ? new InMemoryFile(file) : this.directory.get(file));
        } else {
            z = false;
        }
        InMemoryFile currFile2 = getCurrFile();
        if (currFile2 != null) {
            this.directory.put(file, currFile2);
        }
        return z;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public List<String> read() {
        Enumeration<String> enumerationKeys = this.directory.keys();
        Intrinsics.checkNotNullExpressionValue(enumerationKeys, "directory.keys()");
        ArrayList list = Collections.list(enumerationKeys);
        Intrinsics.checkNotNullExpressionValue(list, "list(this)");
        return list;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public InputStream readAsStream(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        InMemoryFile inMemoryFile = this.directory.get(source);
        return inMemoryFile != null ? inMemoryFile.toStream() : null;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void remove(String file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.directory.remove(file);
    }

    protected void setCurrFile(InMemoryFile inMemoryFile) {
        this.currFile = inMemoryFile;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.EventStream
    public void write(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        InMemoryFile currFile = getCurrFile();
        if (currFile != null) {
            currFile.write(content);
        }
    }
}
