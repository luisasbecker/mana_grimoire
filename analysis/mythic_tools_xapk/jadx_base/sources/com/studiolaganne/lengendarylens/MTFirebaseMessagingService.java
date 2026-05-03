package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0002¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "onNewToken", "", "token", "", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "sendNotification", "remoteMessage", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTFirebaseMessagingService extends FirebaseMessagingService {
    public static final int $stable = 8;

    private final void sendNotification(RemoteMessage remoteMessage) {
        Log.d("MTFirebaseMessagingService", "messageData: " + remoteMessage.getData());
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        Log.d("MTFirebaseMessagingService", "messageNotification title: " + (notification != null ? notification.getTitle() : null));
        RemoteMessage.Notification notification2 = remoteMessage.getNotification();
        Log.d("MTFirebaseMessagingService", "messageNotification body: " + (notification2 != null ? notification2.getBody() : null));
        if (remoteMessage.getData().get("type") != null) {
            Intent intent = new Intent(PreferencesManager.MESSAGE_INTENT);
            intent.putExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE, remoteMessage.getData().get("type"));
            intent.putExtra("message_playgroupId", remoteMessage.getData().get("playgroupId"));
            intent.putExtra("message_fromUserId", remoteMessage.getData().get("fromUserId"));
            intent.putExtra("message_firstname", remoteMessage.getData().get("firstname"));
            intent.putExtra("message_username", remoteMessage.getData().get(HintConstants.AUTOFILL_HINT_USERNAME));
            intent.putExtra("message_playgroup", remoteMessage.getData().get("playgroup"));
            intent.putExtra("message_message", remoteMessage.getData().get("message"));
            intent.putExtra("message_sender", remoteMessage.getData().get("sender"));
            RemoteMessage.Notification notification3 = remoteMessage.getNotification();
            intent.putExtra("message_title", notification3 != null ? notification3.getTitle() : null);
            RemoteMessage.Notification notification4 = remoteMessage.getNotification();
            intent.putExtra("message_notification", notification4 != null ? notification4.getBody() : null);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessageReceived(RemoteMessage message) {
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        super.onMessageReceived(message);
        Log.d("MTFirebaseMessagingService", "From: " + message.getFrom());
        RemoteMessage.Notification notification = message.getNotification();
        if (notification != null) {
            Log.d("MTFirebaseMessagingService", "Message Notification Body: " + notification.getBody());
        }
        Map<String, String> data = message.getData();
        if (data != null && (str = data.get("type")) != null) {
            PreferencesManager preferencesManager = new PreferencesManager(this);
            Log.d("MTFirebaseMessagingService", "Saving Intent to process later: " + data);
            String json = new Gson().toJson(data);
            Intrinsics.checkNotNull(json);
            preferencesManager.setString(PreferencesManager.INTENT_TO_PROCESS, json);
            if (Intrinsics.areEqual(str, PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE)) {
                preferencesManager.setBoolean(PreferencesManager.UPDATE_MESSAGES, true);
            }
            switch (str.hashCode()) {
                case -1814490512:
                    if (str.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_INVITE)) {
                        preferencesManager.setInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, preferencesManager.getInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0) + 1);
                    }
                    break;
                case -1208568283:
                    if (str.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_REJECTED)) {
                    }
                    break;
                case -517166289:
                    if (str.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED)) {
                    }
                    break;
                case 610173073:
                    if (str.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_INVITE)) {
                    }
                    break;
                case 1020862470:
                    if (str.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_REJECTED)) {
                    }
                    break;
                case 1548370254:
                    if (str.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_ACCEPTED)) {
                    }
                    break;
            }
        }
        sendNotification(message);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        new PreferencesManager(this).setString(PreferencesManager.FCM_TOKEN, token);
    }
}
