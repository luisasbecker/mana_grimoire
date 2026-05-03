package com.segment.analytics.kotlin.android.plugins;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"getReferrer", "Landroid/net/Uri;", "activity", "Landroid/app/Activity;", "getReferrerCompatible", "getVersionCode", "", "Landroid/content/pm/PackageInfo;", "android_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidLifecyclePluginKt {
    public static final Uri getReferrer(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity.getReferrer();
    }

    private static final Uri getReferrerCompatible(Activity activity) {
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra == null) {
            return null;
        }
        try {
            return Uri.parse(stringExtra);
        } catch (ParseException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Number getVersionCode(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.valueOf(packageInfo.getLongVersionCode()) : Integer.valueOf(packageInfo.versionCode);
    }
}
