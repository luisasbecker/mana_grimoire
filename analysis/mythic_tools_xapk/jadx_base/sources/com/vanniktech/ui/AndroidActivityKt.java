package com.vanniktech.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"asActivityOrNull", "Landroid/app/Activity;", "Landroid/content/Context;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidActivityKt {
    public static final Activity asActivityOrNull(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
