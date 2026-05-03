package com.google.android.play.core.integrity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class as extends com.google.android.play.integrity.internal.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f379a;
    final com.google.android.play.integrity.internal.ae b;
    private final com.google.android.play.integrity.internal.s c = new com.google.android.play.integrity.internal.s("RequestDialogCallbackImpl");
    private final String d;
    private final k e;
    private final Activity f;

    as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, com.google.android.play.integrity.internal.ae aeVar) {
        this.d = context.getPackageName();
        this.e = kVar;
        this.f379a = taskCompletionSource;
        this.f = activity;
        this.b = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.r
    public final void b(Bundle bundle) {
        this.b.v(this.f379a);
        this.c.d("onRequestDialog(%s)", this.d);
        ApiException apiExceptionA = this.e.a(bundle);
        if (apiExceptionA != null) {
            this.f379a.trySetException(apiExceptionA);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            this.c.b("onRequestDialog(%s): got null dialog intent", this.d);
            this.f379a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new ar(this, this.b.c()));
        this.c.a("Starting dialog intent...", new Object[0]);
        this.f.startActivityForResult(intent, 0);
    }
}
