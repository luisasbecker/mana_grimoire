package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import java.util.Date;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.tasks.TasksKt;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: FirebaseTokenManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/FirebaseTokenManager;", "", "<init>", "()V", "TAG", "", "refreshJob", "Lkotlinx/coroutines/Job;", "isRefreshing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastRefreshAttempt", "", "MIN_REFRESH_INTERVAL", "startTokenAutoRefresh", "", "context", "Landroid/content/Context;", "stopTokenAutoRefresh", "ensureFreshToken", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "refreshTokenWithReason", "Lcom/studiolaganne/lengendarylens/TokenRefreshResult;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FirebaseTokenManager {
    private static final String TAG = "FirebaseTokenManager";
    private static long lastRefreshAttempt;
    private static Job refreshJob;
    public static final FirebaseTokenManager INSTANCE = new FirebaseTokenManager();
    private static final AtomicBoolean isRefreshing = new AtomicBoolean(false);
    private static final long MIN_REFRESH_INTERVAL = 30000;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.FirebaseTokenManager$refreshToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: FirebaseTokenManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.FirebaseTokenManager", f = "FirebaseTokenManager.kt", i = {0}, l = {Imgproc.COLOR_BGR2YUV}, m = "refreshToken", n = {"context"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FirebaseTokenManager.this.refreshToken(null, this);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.FirebaseTokenManager$refreshTokenWithReason$2, reason: invalid class name */
    /* JADX INFO: compiled from: FirebaseTokenManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/studiolaganne/lengendarylens/TokenRefreshResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.FirebaseTokenManager$refreshTokenWithReason$2", f = "FirebaseTokenManager.kt", i = {2}, l = {Imgproc.COLOR_YUV2BGR_NV12, 93, 106}, m = "invokeSuspend", n = {"user"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TokenRefreshResult>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TokenRefreshResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b4, code lost:
        
            if (r4 == r3) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TokenRefreshResult tokenRefreshResult;
            Object objAwait;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Exception e) {
                    Log.e(FirebaseTokenManager.TAG, "Error refreshing Firebase token", e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    tokenRefreshResult = new TokenRefreshResult(null, "Token refresh error: " + message, false, 5, null);
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (FirebaseTokenManager.isRefreshing.getAndSet(true)) {
                        this.label = 1;
                        if (DelayKt.delay(500L, this) != coroutine_suspended) {
                            while (FirebaseTokenManager.isRefreshing.get()) {
                            }
                            String string = new PreferencesManager(this.$context).getString(PreferencesManager.FIREBASE_TOKEN, "");
                            if (string.length() <= 0) {
                            }
                        }
                    } else {
                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                        if (currentUser == null) {
                            Log.w(FirebaseTokenManager.TAG, "No Firebase user found while refreshing token");
                            tokenRefreshResult = new TokenRefreshResult(null, "Firebase session expired", true, 1, null);
                            return tokenRefreshResult;
                        }
                        Task<GetTokenResult> idToken = currentUser.getIdToken(true);
                        Intrinsics.checkNotNullExpressionValue(idToken, "getIdToken(...)");
                        this.L$0 = SpillingKt.nullOutSpilledVariable(currentUser);
                        this.label = 3;
                        objAwait = TasksKt.await(idToken, this);
                    }
                    return coroutine_suspended;
                }
                if (i == 1 || i == 2) {
                    ResultKt.throwOnFailure(obj);
                    while (FirebaseTokenManager.isRefreshing.get()) {
                        this.label = 2;
                        if (DelayKt.delay(100L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    String string2 = new PreferencesManager(this.$context).getString(PreferencesManager.FIREBASE_TOKEN, "");
                    return string2.length() <= 0 ? new TokenRefreshResult(string2, null, false, 6, null) : new TokenRefreshResult(null, "No token available after waiting for refresh", false, 5, null);
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objAwait = obj;
                Intrinsics.checkNotNullExpressionValue(objAwait, "await(...)");
                String token = ((GetTokenResult) objAwait).getToken();
                String str = token;
                if (str == null || str.length() == 0) {
                    Log.w(FirebaseTokenManager.TAG, "Firebase returned null/empty token");
                    tokenRefreshResult = new TokenRefreshResult(null, "Firebase returned empty token", false, 5, null);
                } else {
                    PreferencesManager preferencesManager = new PreferencesManager(this.$context);
                    preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
                    long jCurrentTimeMillis = System.currentTimeMillis() + 3300000;
                    preferencesManager.setTokenExpiryTime(jCurrentTimeMillis);
                    Log.d(FirebaseTokenManager.TAG, "Firebase token refreshed, expires at: " + new Date(jCurrentTimeMillis));
                    tokenRefreshResult = new TokenRefreshResult(token, null, false, 6, null);
                }
                return tokenRefreshResult;
            } finally {
                FirebaseTokenManager.isRefreshing.set(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.FirebaseTokenManager$startTokenAutoRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FirebaseTokenManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.FirebaseTokenManager$startTokenAutoRefresh$1", f = "FirebaseTokenManager.kt", i = {0, 1}, l = {41, 42}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"}, v = 1)
    static final class C11661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11661(Context context, Continuation<? super C11661> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11661 c11661 = new C11661(this.$context, continuation);
            c11661.L$0 = obj;
            return c11661;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0048 -> B:11:0x0022). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = coroutineScope;
                    this.label = 2;
                    if (FirebaseTokenManager.INSTANCE.refreshToken(this.$context, this) != coroutine_suspended) {
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                            return Unit.INSTANCE;
                        }
                        this.L$0 = coroutineScope;
                        this.label = 1;
                        if (DelayKt.delay(3300000L, this) != coroutine_suspended) {
                            this.L$0 = coroutineScope;
                            this.label = 2;
                            if (FirebaseTokenManager.INSTANCE.refreshToken(this.$context, this) != coroutine_suspended) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
    }

    private FirebaseTokenManager() {
    }

    public final Object ensureFreshToken(Context context, Continuation<? super String> continuation) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastRefreshAttempt < MIN_REFRESH_INTERVAL && isRefreshing.get()) {
            return new PreferencesManager(context).getString(PreferencesManager.FIREBASE_TOKEN, "");
        }
        lastRefreshAttempt = jCurrentTimeMillis;
        PreferencesManager preferencesManager = new PreferencesManager(context);
        if (!preferencesManager.hasValidUser()) {
            Log.d(TAG, "No valid user found, not starting token refresh");
            return "";
        }
        if (!Intrinsics.areEqual(preferencesManager.getString(PreferencesManager.AUTH_PROVIDER, ""), FirebaseAuthProvider.PROVIDER_ID)) {
            return "";
        }
        if (!TokenValidator.INSTANCE.isTokenValid(context)) {
            return refreshToken(context, continuation);
        }
        Log.d(TAG, "Token is valid, no need to refresh");
        return new PreferencesManager(context).getString(PreferencesManager.FIREBASE_TOKEN, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshToken(Context context, Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objRefreshTokenWithReason = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRefreshTokenWithReason);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.label = 1;
            objRefreshTokenWithReason = refreshTokenWithReason(context, anonymousClass1);
            if (objRefreshTokenWithReason == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRefreshTokenWithReason);
        }
        return ((TokenRefreshResult) objRefreshTokenWithReason).getToken();
    }

    public final Object refreshTokenWithReason(Context context, Continuation<? super TokenRefreshResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, null), continuation);
    }

    public final void startTokenAutoRefresh(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        if (!preferencesManager.hasValidUser()) {
            Log.d(TAG, "No valid user found, not starting token refresh");
        } else if (Intrinsics.areEqual(preferencesManager.getString(PreferencesManager.AUTH_PROVIDER, ""), FirebaseAuthProvider.PROVIDER_ID)) {
            Job job = refreshJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            refreshJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C11661(context, null), 3, null);
        }
    }

    public final void stopTokenAutoRefresh() {
        Job job = refreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        refreshJob = null;
        Log.d(TAG, "Token auto-refresh stopped");
    }
}
