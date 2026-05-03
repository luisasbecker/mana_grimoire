package com.vanniktech.emoji.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: EmojiResultReceiver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiResultReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "receiver", "Lcom/vanniktech/emoji/internal/EmojiResultReceiver$Receiver;", "setReceiver", "", "onReceiveResult", "resultCode", "", "resultData", "Landroid/os/Bundle;", "Receiver", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiResultReceiver extends ResultReceiver {
    private Receiver receiver;

    /* JADX INFO: compiled from: EmojiResultReceiver.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiResultReceiver$Receiver;", "", "onReceiveResult", "", "resultCode", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/os/Bundle;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle data);
    }

    public EmojiResultReceiver(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        Receiver receiver = this.receiver;
        if (receiver != null) {
            receiver.onReceiveResult(resultCode, resultData);
        }
    }

    public final void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
