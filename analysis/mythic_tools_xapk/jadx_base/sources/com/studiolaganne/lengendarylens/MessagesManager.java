package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MessagesManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessagesManager;", "", "<init>", "()V", "messagesDBHelper", "Lcom/studiolaganne/lengendarylens/MessagesDBHelper;", "updateAllMessages", "", "context", "Landroid/content/Context;", "callback", "Lcom/studiolaganne/lengendarylens/MessagesManagerListener;", "updatePlaygroupMessages", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "playgroupId", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessagesManager {
    private static MessagesManager instance;
    private MessagesDBHelper messagesDBHelper;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MessagesManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessagesManager$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/MessagesManager;", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized MessagesManager getInstance() {
            MessagesManager messagesManager;
            if (MessagesManager.instance == null) {
                MessagesManager.instance = new MessagesManager(null);
            }
            messagesManager = MessagesManager.instance;
            Intrinsics.checkNotNull(messagesManager);
            return messagesManager;
        }
    }

    private MessagesManager() {
    }

    public /* synthetic */ MessagesManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void updateAllMessages(Context context, MessagesManagerListener callback) {
        MTUser currentUser;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.d("MTApi", "----> updateAllMessages()");
        this.messagesDBHelper = MessagesDBHelper.INSTANCE.getInstance(context);
        PreferencesManager preferencesManager = new PreferencesManager(context);
        if (!preferencesManager.hasValidUser() || (currentUser = preferencesManager.getCurrentUser()) == null) {
            return;
        }
        Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
        while (it.hasNext()) {
            updatePlaygroupMessages(context, currentUser, ((MTPlaygroup) it.next()).getId(), callback);
        }
    }

    public final void updatePlaygroupMessages(Context context, MTUser user, final int playgroupId, final MessagesManagerListener callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.d("MTApi", "----> updatePlaygroupMessages() for playgroup " + playgroupId);
        final PreferencesManager preferencesManager = new PreferencesManager(context);
        if (this.messagesDBHelper == null) {
            this.messagesDBHelper = MessagesDBHelper.INSTANCE.getInstance(context);
        }
        final MessagesDBHelper messagesDBHelper = this.messagesDBHelper;
        if (messagesDBHelper != null) {
            String strLastReceivedTimestampForPlaygroup = messagesDBHelper.lastReceivedTimestampForPlaygroup(playgroupId);
            Log.d("MTApi", "Get messages sinceTimestamp = " + strLastReceivedTimestampForPlaygroup);
            Call<MTMessagesResponse> messagesFromPlaygroupSinceTimestamp = strLastReceivedTimestampForPlaygroup.length() > 0 ? MTApiKt.getMtApi().getMessagesFromPlaygroupSinceTimestamp(user.getId(), playgroupId, strLastReceivedTimestampForPlaygroup) : MTApiKt.getMtApi().getLatestMessagesFromPlaygroup(user.getId(), playgroupId);
            if (messagesFromPlaygroupSinceTimestamp != null) {
                messagesFromPlaygroupSinceTimestamp.enqueue(new Callback<MTMessagesResponse>() { // from class: com.studiolaganne.lengendarylens.MessagesManager$updatePlaygroupMessages$1$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTMessagesResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTMessagesResponse> call, Response<MTMessagesResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            MTMessagesResponse mTMessagesResponseBody = response.body();
                            List<MTMessage> messages = mTMessagesResponseBody != null ? mTMessagesResponseBody.getMessages() : null;
                            MTMessagesResponse mTMessagesResponseBody2 = response.body();
                            Integer numValueOf = mTMessagesResponseBody2 != null ? Integer.valueOf(mTMessagesResponseBody2.getLastRead()) : null;
                            if (messages != null) {
                                PreferencesManager preferencesManager2 = preferencesManager;
                                MessagesDBHelper messagesDBHelper2 = messagesDBHelper;
                                int i = playgroupId;
                                MessagesManagerListener messagesManagerListener = callback;
                                preferencesManager2.setLastMessagesUpdate(System.currentTimeMillis());
                                if (messages.isEmpty()) {
                                    return;
                                }
                                messagesDBHelper2.addMessagesForPlaygroup(i, messages);
                                if (numValueOf != null) {
                                    messagesDBHelper2.setLastReadMessageIdForPlaygroup(i, numValueOf.intValue());
                                }
                                String timestamp = "";
                                for (MTMessage mTMessage : messages) {
                                    if (mTMessage.getTimestamp().compareTo(timestamp) > 0) {
                                        timestamp = mTMessage.getTimestamp();
                                    }
                                }
                                if (timestamp.length() > 0) {
                                    messagesDBHelper2.setLastReceivedTimestampForPlaygroup(i, timestamp);
                                }
                                messagesManagerListener.onMessagesUpdated(i);
                            }
                        }
                    }
                });
            }
        }
    }
}
