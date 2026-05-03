package com.revenuecat.purchases.ui.revenuecatui.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: URLOpener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class URLOpener$openURL$1 extends FunctionReferenceImpl implements Function1<Exception, Unit> {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    URLOpener$openURL$1(Context context) {
        super(1, Intrinsics.Kotlin.class, "handleException", "openURL$handleException(Landroid/content/Context;Ljava/lang/Exception;)V", 0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Exception p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        URLOpener.openURL$handleException(this.$context, p0);
    }
}
