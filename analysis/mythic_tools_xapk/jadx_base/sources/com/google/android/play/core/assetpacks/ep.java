package com.google.android.play.core.assetpacks;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f306a;
    private final NotificationManager b;

    ep(Context context) {
        this.f306a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    private final synchronized void c(String str) {
        if (str == null) {
            str = "File downloads by Play";
        }
        this.b.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", str, 2));
    }

    final Notification a(Bundle bundle) {
        PendingIntent activity;
        Notification.Builder timeoutAfter = new Notification.Builder(this.f306a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(bundle.getLong("notification_timeout", 600000L));
        Parcelable parcelable = bundle.getParcelable("notification_on_click_intent");
        if (parcelable instanceof PendingIntent) {
            activity = (PendingIntent) parcelable;
        } else if (bundle.getBoolean("notification_intent_reconstruct_from_data")) {
            Intent intent = new Intent();
            String string = bundle.getString("notification_intent_component_class_name");
            String string2 = bundle.getString("notification_intent_component_package_name");
            if (string != null && string2 != null) {
                intent.setComponent(new ComponentName(string2, string));
            }
            intent.setPackage(bundle.getString("notification_intent_package"));
            intent.setAction(bundle.getString("notification_intent_action"));
            intent.setFlags(bundle.getInt("notification_intent_flags"));
            String string3 = bundle.getString("notification_intent_data");
            if (string3 != null) {
                intent.setData(Uri.parse(string3));
            }
            intent.putExtra("error_doc_id", bundle.getString("notification_intent_extra_error_dialog_document_id"));
            activity = PendingIntent.getActivity(this.f306a, 0, intent, 201326592);
        } else {
            activity = null;
        }
        if (activity != null) {
            timeoutAfter.setContentIntent(activity);
        }
        String string4 = bundle.getString("notification_title");
        String string5 = bundle.getString("notification_subtext");
        Notification.Builder ongoing = timeoutAfter.setSmallIcon(R.drawable.stat_sys_download).setOngoing(false);
        if (string4 == null) {
            string4 = "Downloading additional file";
        }
        Notification.Builder contentTitle = ongoing.setContentTitle(string4);
        if (string5 == null) {
            string5 = "Transferring";
        }
        contentTitle.setSubText(string5);
        int i = bundle.getInt("notification_color");
        if (i != 0) {
            timeoutAfter.setColor(i).setVisibility(-1);
        }
        return timeoutAfter.build();
    }

    final void b(Bundle bundle) {
        c(bundle.getString("notification_channel_name"));
    }
}
