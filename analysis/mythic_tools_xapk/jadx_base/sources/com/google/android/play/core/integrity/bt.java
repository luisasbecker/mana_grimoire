package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f400a;

    bt(bn bnVar) {
        this.f400a = bnVar;
    }

    final /* synthetic */ Task a(long j, long j2, int i, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f400a.d(standardIntegrityTokenRequest.a(), j, j2, 0);
    }
}
