package com.segment.analytics.kotlin.core.utilities;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EventStream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH&J/\u0010\u000b\u001a\u00020\n2%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000eH&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/EventStream;", "", "isOpened", "", "()Z", "length", "", "getLength", "()J", "close", "", "finishAndClose", "withRename", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "openOrCreate", "file", "read", "", "readAsStream", "Ljava/io/InputStream;", "source", "remove", "write", FirebaseAnalytics.Param.CONTENT, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EventStream {

    /* JADX INFO: compiled from: EventStream.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void finishAndClose$default(EventStream eventStream, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishAndClose");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            eventStream.finishAndClose(function1);
        }
    }

    void close();

    void finishAndClose(Function1<? super String, String> withRename);

    long getLength();

    boolean isOpened();

    boolean openOrCreate(String file);

    List<String> read();

    InputStream readAsStream(String source);

    void remove(String file);

    void write(String content);
}
