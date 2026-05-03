package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzak implements Continuation<AuthResult, Task<AuthResult>> {
    private final /* synthetic */ zzal zza;

    zzak(zzal zzalVar) {
        Objects.requireNonNull(zzalVar);
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<AuthResult> then(Task<AuthResult> task) throws Exception {
        if (this.zza.zzd == null) {
            return task;
        }
        if (task.isSuccessful()) {
            AuthResult result = task.getResult();
            return Tasks.forResult(new zzz((zzaf) result.getUser(), (zzx) result.getAdditionalUserInfo(), this.zza.zzd));
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            ((FirebaseAuthUserCollisionException) exception).zza(this.zza.zzd);
        }
        return Tasks.forException(exception);
    }
}
