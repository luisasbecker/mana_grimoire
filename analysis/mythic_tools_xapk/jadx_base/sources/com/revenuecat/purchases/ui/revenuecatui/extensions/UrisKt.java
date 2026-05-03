package com.revenuecat.purchases.ui.revenuecatui.extensions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Uris.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042%\u0010\u0005\u001a!\u0012\u0017\u0012\u00150\u0007j\u0002`\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\f"}, d2 = {"openUriOrElse", "", "Landroid/content/Context;", "uri", "", "fallbackAction", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UrisKt {
    public static final void openUriOrElse(Context context, String uri, Function1<? super Exception, Unit> fallbackAction) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(fallbackAction, "fallbackAction");
        try {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
            } catch (ActivityNotFoundException e) {
                fallbackAction.invoke(e);
            }
        } catch (IllegalArgumentException e2) {
            fallbackAction.invoke(e2);
        }
    }
}
