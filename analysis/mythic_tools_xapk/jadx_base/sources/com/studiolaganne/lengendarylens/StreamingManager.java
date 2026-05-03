package com.studiolaganne.lengendarylens;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: compiled from: StreamingManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 -2\u00020\u0001:\u0003-./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u0019J\u0016\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u001bJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u001bJ\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0006\u0010,\u001a\u00020\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingManager;", "", "<init>", "()V", "webSocket", "Lokhttp3/WebSocket;", "client", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "currentState", "Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionState;", "connectionListeners", "", "Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionStateListener;", "currentToken", "", "getCurrentToken", "()Ljava/lang/String;", "setCurrentToken", "(Ljava/lang/String;)V", "currentUid", "getCurrentUid", "setCurrentUid", "isProduction", "", "addConnectionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeConnectionListener", "getConnectionState", "isConnected", "connect", "token", "uid", "disconnect", "sendGameUpdate", "gameData", "Lcom/studiolaganne/lengendarylens/GameStreamingData;", "reconnect", "updateConnectionState", "newState", "notifyError", "error", "cleanup", "Companion", "ConnectionState", "ConnectionStateListener", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StreamingManager {
    private static volatile StreamingManager INSTANCE = null;
    private static final String PREPROD_URL = "wss://mythic-tools-preprod-streaming-204802869803.europe-north1.run.app/";
    private static final String PROD_URL = "wss://mythic-tools-streaming-204802869803.europe-north1.run.app/";
    private static final String TAG = "StreamingManager";
    private final OkHttpClient client;
    private List<ConnectionStateListener> connectionListeners;
    private ConnectionState currentState;
    private String currentToken;
    private String currentUid;
    private final Gson gson;
    private boolean isProduction;
    private WebSocket webSocket;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: StreamingManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingManager$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/studiolaganne/lengendarylens/StreamingManager;", "getInstance", "TAG", "", "PREPROD_URL", "PROD_URL", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StreamingManager getInstance() {
            StreamingManager streamingManager;
            StreamingManager streamingManager2 = StreamingManager.INSTANCE;
            if (streamingManager2 != null) {
                return streamingManager2;
            }
            synchronized (this) {
                streamingManager = StreamingManager.INSTANCE;
                if (streamingManager == null) {
                    streamingManager = new StreamingManager(null);
                    Companion companion = StreamingManager.INSTANCE;
                    StreamingManager.INSTANCE = streamingManager;
                }
            }
            return streamingManager;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: StreamingManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTING", "CONNECTED", "ERROR", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ConnectionState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConnectionState[] $VALUES;
        public static final ConnectionState DISCONNECTED = new ConnectionState("DISCONNECTED", 0);
        public static final ConnectionState CONNECTING = new ConnectionState("CONNECTING", 1);
        public static final ConnectionState CONNECTED = new ConnectionState("CONNECTED", 2);
        public static final ConnectionState ERROR = new ConnectionState("ERROR", 3);

        private static final /* synthetic */ ConnectionState[] $values() {
            return new ConnectionState[]{DISCONNECTED, CONNECTING, CONNECTED, ERROR};
        }

        static {
            ConnectionState[] connectionStateArr$values = $values();
            $VALUES = connectionStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(connectionStateArr$values);
        }

        private ConnectionState(String str, int i) {
        }

        public static EnumEntries<ConnectionState> getEntries() {
            return $ENTRIES;
        }

        public static ConnectionState valueOf(String str) {
            return (ConnectionState) Enum.valueOf(ConnectionState.class, str);
        }

        public static ConnectionState[] values() {
            return (ConnectionState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: StreamingManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionStateListener;", "", "onStreamingConnectionStateChanged", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/studiolaganne/lengendarylens/StreamingManager$ConnectionState;", "onStreamingError", "error", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ConnectionStateListener {
        void onStreamingConnectionStateChanged(ConnectionState state);

        void onStreamingError(String error);
    }

    private StreamingManager() {
        this.client = new OkHttpClient.Builder().pingInterval(30L, TimeUnit.SECONDS).build();
        this.gson = new Gson();
        this.currentState = ConnectionState.DISCONNECTED;
        this.connectionListeners = new ArrayList();
    }

    public /* synthetic */ StreamingManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyError(final String error) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.StreamingManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                StreamingManager.notifyError$lambda$0(this.f$0, error);
            }
        });
    }

    static final void notifyError$lambda$0(StreamingManager streamingManager, String str) {
        Iterator<T> it = streamingManager.connectionListeners.iterator();
        while (it.hasNext()) {
            ((ConnectionStateListener) it.next()).onStreamingError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateConnectionState(final ConnectionState newState) {
        if (this.currentState != newState) {
            this.currentState = newState;
            Log.d(TAG, "Connection state changed to: " + newState);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.StreamingManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    StreamingManager.updateConnectionState$lambda$0(this.f$0, newState);
                }
            });
        }
    }

    static final void updateConnectionState$lambda$0(StreamingManager streamingManager, ConnectionState connectionState) {
        Iterator<T> it = streamingManager.connectionListeners.iterator();
        while (it.hasNext()) {
            ((ConnectionStateListener) it.next()).onStreamingConnectionStateChanged(connectionState);
        }
    }

    public final void addConnectionListener(ConnectionStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.connectionListeners.add(listener);
    }

    public final void cleanup() {
        disconnect();
        this.connectionListeners.clear();
    }

    public final void connect(String token, String uid) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (this.currentState == ConnectionState.CONNECTING || this.currentState == ConnectionState.CONNECTED) {
            Log.w(TAG, "Already connecting or connected, ignoring connect request");
            return;
        }
        boolean zContains$default = StringsKt.contains$default((CharSequence) "https://api.mythic.tools/", (CharSequence) "preprod", false, 2, (Object) null);
        this.currentToken = token;
        this.currentUid = uid;
        this.isProduction = !zContains$default;
        String str = (!zContains$default ? PROD_URL : PREPROD_URL) + "?token=" + token + "&uid=" + uid;
        Log.d(TAG, "Connecting to WebSocket: " + str);
        Request requestBuild = new Request.Builder().url(str).build();
        updateConnectionState(ConnectionState.CONNECTING);
        this.webSocket = this.client.newWebSocket(requestBuild, new WebSocketListener() { // from class: com.studiolaganne.lengendarylens.StreamingManager.connect.1
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int code, String reason) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                Log.d(StreamingManager.TAG, "WebSocket closed: " + code + " " + reason);
                StreamingManager.this.updateConnectionState(ConnectionState.DISCONNECTED);
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int code, String reason) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                Log.d(StreamingManager.TAG, "WebSocket closing: " + code + " " + reason);
                webSocket.close(1000, null);
                StreamingManager.this.updateConnectionState(ConnectionState.DISCONNECTED);
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.e(StreamingManager.TAG, "WebSocket failure", t);
                StreamingManager.this.updateConnectionState(ConnectionState.ERROR);
                StreamingManager.this.notifyError("Connection failed: " + t.getMessage());
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String text) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(text, "text");
                Log.d(StreamingManager.TAG, "Received message: " + text);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                Log.d(StreamingManager.TAG, "Received bytes: " + bytes.hex());
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(response, "response");
                Log.d(StreamingManager.TAG, "WebSocket connection opened");
                StreamingManager.this.updateConnectionState(ConnectionState.CONNECTED);
            }
        });
    }

    public final void disconnect() {
        Log.d(TAG, "Disconnecting WebSocket");
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            webSocket.close(1000, "User disconnected");
        }
        this.webSocket = null;
        updateConnectionState(ConnectionState.DISCONNECTED);
    }

    /* JADX INFO: renamed from: getConnectionState, reason: from getter */
    public final ConnectionState getCurrentState() {
        return this.currentState;
    }

    public final String getCurrentToken() {
        return this.currentToken;
    }

    public final String getCurrentUid() {
        return this.currentUid;
    }

    public final boolean isConnected() {
        return this.currentState == ConnectionState.CONNECTED;
    }

    public final void reconnect() {
        final String str = this.currentToken;
        final String str2 = this.currentUid;
        if (str == null || str2 == null) {
            Log.e(TAG, "Cannot reconnect: missing token or uid");
            notifyError("Cannot reconnect: missing credentials");
        } else {
            disconnect();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.StreamingManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.connect(str, str2);
                }
            }, 1000L);
        }
    }

    public final void removeConnectionListener(ConnectionStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.connectionListeners.remove(listener);
    }

    public final void sendGameUpdate(GameStreamingData gameData) {
        boolean zSend;
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        if (!isConnected()) {
            Log.w(TAG, "Not connected, cannot send game update");
            return;
        }
        try {
            String json = this.gson.toJson(new StreamingMessage(gameData));
            Log.d(TAG, "Sending game update: " + json);
            WebSocket webSocket = this.webSocket;
            if (webSocket != null) {
                Intrinsics.checkNotNull(json);
                zSend = webSocket.send(json);
            } else {
                zSend = false;
            }
            if (zSend) {
                return;
            }
            Log.e(TAG, "Failed to send message to WebSocket");
            notifyError("Failed to send game update");
        } catch (Exception e) {
            Log.e(TAG, "Error serializing game data", e);
            notifyError("Error preparing game data: " + e.getMessage());
        }
    }

    public final void setCurrentToken(String str) {
        this.currentToken = str;
    }

    public final void setCurrentUid(String str) {
        this.currentUid = str;
    }
}
