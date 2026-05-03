package com.studiolaganne.lengendarylens;

import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SignUpActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.SignUpActivity$onCreate$2$1", f = "SignUpActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SignUpActivity$onCreate$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SignUpActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignUpActivity$onCreate$2$1(SignUpActivity signUpActivity, Continuation<? super SignUpActivity$onCreate$2$1> continuation) {
        super(2, continuation);
        this.this$0 = signUpActivity;
    }

    static final void invokeSuspend$lambda$0(SignUpActivity signUpActivity, Task task) {
        GoogleSignInClient googleSignInClient = signUpActivity.googleSignInClient;
        if (googleSignInClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
            googleSignInClient = null;
        }
        Intent signInIntent = googleSignInClient.getSignInIntent();
        Intrinsics.checkNotNullExpressionValue(signInIntent, "getSignInIntent(...)");
        signUpActivity.googleSignInLauncher.launch(signInIntent);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignUpActivity$onCreate$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignUpActivity$onCreate$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        GoogleSignInClient googleSignInClient = this.this$0.googleSignInClient;
        if (googleSignInClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
            googleSignInClient = null;
        }
        Task<Void> taskSignOut = googleSignInClient.signOut();
        final SignUpActivity signUpActivity = this.this$0;
        taskSignOut.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onCreate$2$1$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignUpActivity$onCreate$2$1.invokeSuspend$lambda$0(signUpActivity, task);
            }
        });
        return Unit.INSTANCE;
    }
}
