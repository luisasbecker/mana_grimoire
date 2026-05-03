package com.studiolaganne.lengendarylens;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Breadcrumbs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/Breadcrumbs;", "", "<init>", "()V", "actions", "Ljava/util/LinkedList;", "", "leaveBreadcrumb", "", NativeProtocol.WEB_DIALOG_ACTION, "logBreadcrumbs", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Breadcrumbs {
    public static final Breadcrumbs INSTANCE = new Breadcrumbs();
    private static final LinkedList<String> actions = new LinkedList<>();
    public static final int $stable = 8;

    private Breadcrumbs() {
    }

    public final void leaveBreadcrumb(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        LinkedList<String> linkedList = actions;
        if (linkedList.size() >= 30) {
            linkedList.removeFirst();
        }
        linkedList.addLast(action);
    }

    public final void logBreadcrumbs() {
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        LinkedList<String> linkedList = actions;
        firebaseCrashlytics.log("Breadcrumbs: " + linkedList);
        FirebaseCrashlytics.getInstance().setCustomKey("breadcrumbs", String.valueOf(linkedList));
    }
}
