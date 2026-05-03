package com.segment.analytics.kotlin.core;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0011\u0010\u0010\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J!\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/segment/analytics/kotlin/core/Storage;", "", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/segment/analytics/kotlin/core/Storage$Constants;", "readAsStream", "Ljava/io/InputStream;", "source", "remove", "", "removeFile", "filePath", "rollover", "write", "value", "(Lcom/segment/analytics/kotlin/core/Storage$Constants;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePrefs", "Companion", "Constants", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Storage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MAX_BATCH_SIZE = 475000;
    public static final int MAX_FILE_SIZE = 475000;
    public static final int MAX_PAYLOAD_SIZE = 32000;

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/segment/analytics/kotlin/core/Storage$Companion;", "", "()V", "MAX_BATCH_SIZE", "", "MAX_FILE_SIZE", "MAX_PAYLOAD_SIZE", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MAX_BATCH_SIZE = 475000;
        public static final int MAX_FILE_SIZE = 475000;
        public static final int MAX_PAYLOAD_SIZE = 32000;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/Storage$Constants;", "", "rawVal", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawVal", "()Ljava/lang/String;", "UserId", "Traits", "AnonymousId", "Settings", "Events", "AppVersion", "AppBuild", "LegacyAppBuild", "DeviceId", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Constants {
        UserId("segment.userId"),
        Traits("segment.traits"),
        AnonymousId("segment.anonymousId"),
        Settings("segment.settings"),
        Events("segment.events"),
        AppVersion("segment.app.version"),
        AppBuild("segment.app.build"),
        LegacyAppBuild("build"),
        DeviceId("segment.device.id");

        private final String rawVal;

        Constants(String str) {
            this.rawVal = str;
        }

        public final String getRawVal() {
            return this.rawVal;
        }
    }

    Object initialize(Continuation<? super Unit> continuation);

    String read(Constants key);

    InputStream readAsStream(String source);

    boolean remove(Constants key);

    boolean removeFile(String filePath);

    Object rollover(Continuation<? super Unit> continuation);

    Object write(Constants constants, String str, Continuation<? super Unit> continuation);

    void writePrefs(Constants key, String value);
}
