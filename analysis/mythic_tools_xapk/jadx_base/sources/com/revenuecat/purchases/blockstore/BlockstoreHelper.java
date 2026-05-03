package com.revenuecat.purchases.blockstore;

import android.content.Context;
import com.google.android.gms.auth.blockstore.Blockstore;
import com.google.android.gms.auth.blockstore.BlockstoreClient;
import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.auth.blockstore.StoreBytesData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.identity.IdentityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: BlockstoreHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u0014\u0010\u0010\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0082@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J*\u0010\u0016\u001a\u00020\r2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/blockstore/BlockstoreHelper;", "", "applicationContext", "Landroid/content/Context;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "blockstoreClient", "Lcom/google/android/gms/auth/blockstore/BlockstoreClient;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "(Landroid/content/Context;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/google/android/gms/auth/blockstore/BlockstoreClient;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineScope;)V", "aliasCurrentAndStoredUserIdsIfNeeded", "", "callback", "Lkotlin/Function0;", "clearUserIdBackupIfNeeded", "getBlockstoreData", "", "", "Lcom/google/android/gms/auth/blockstore/RetrieveBytesResponse$BlockstoreData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeUserIdIfNeeded", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "blockstoreDataMap", "userId", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockstoreHelper {

    @Deprecated
    public static final int BLOCKSTORE_MAX_ENTRIES = 16;

    @Deprecated
    public static final String BLOCKSTORE_USER_ID_KEY = "com.revenuecat.purchases.app_user_id";
    private static final Companion Companion = new Companion(null);
    private final BlockstoreClient blockstoreClient;
    private final IdentityManager identityManager;
    private final CoroutineScope ioScope;
    private final CoroutineScope mainScope;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BlockstoreHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/blockstore/BlockstoreHelper$Companion;", "", "()V", "BLOCKSTORE_MAX_ENTRIES", "", "BLOCKSTORE_USER_ID_KEY", "", "initializeBlockstoreClient", "Lcom/google/android/gms/auth/blockstore/BlockstoreClient;", "applicationContext", "Landroid/content/Context;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BlockstoreClient initializeBlockstoreClient(Context applicationContext) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            try {
                return Blockstore.getClient(applicationContext);
            } catch (NoClassDefFoundError e) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Cannot find Blockstore at runtime. Disabling automatic backups.", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlockstoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1", f = "BlockstoreHelper.kt", i = {}, l = {87, 100}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentUserId = str;
            this.$callback = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlockstoreHelper.this.new AnonymousClass1(this.$currentUserId, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
        
            if (r9.this$0.identityManager.aliasCurrentUserIdTo(r3, r9) == r2) goto L36;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            byte[] bytes;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = BlockstoreHelper.this.getBlockstoreData(this);
                        if (obj == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        BlockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper.this, this.$callback);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    RetrieveBytesResponse.BlockstoreData blockstoreData = (RetrieveBytesResponse.BlockstoreData) ((Map) obj).get(BlockstoreHelper.BLOCKSTORE_USER_ID_KEY);
                    String str = (blockstoreData == null || (bytes = blockstoreData.getBytes()) == null) ? null : new String(bytes, Charsets.UTF_8);
                    if (str == null || Intrinsics.areEqual(str, this.$currentUserId)) {
                        BlockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper.this, this.$callback);
                        return Unit.INSTANCE;
                    }
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Aliasing Blockstore user ID: " + str + " with current UserID");
                    }
                    this.label = 2;
                } catch (Exception e) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to retrieve Block store data. Will not recover userId. Error: " + e.getMessage(), e);
                    BlockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper.this, this.$callback);
                    return Unit.INSTANCE;
                }
            } catch (PurchasesException e2) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to alias Block store user ID: " + e2.getMessage() + ". Underlying error: " + e2.getUnderlyingErrorMessage() + ". Any purchases on previous anonymous user will not be recovered.", e2);
                BlockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper.this, this.$callback);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockstoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1", f = "BlockstoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BlockstoreClient $blockstoreClient;
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ DeleteBytesRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06401(BlockstoreClient blockstoreClient, DeleteBytesRequest deleteBytesRequest, Function0<Unit> function0, Continuation<? super C06401> continuation) {
            super(2, continuation);
            this.$blockstoreClient = blockstoreClient;
            this.$request = deleteBytesRequest;
            this.$callback = function0;
        }

        static final void invokeSuspend$lambda$2(Function0 function0, Exception exc) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Tried to clear Block store cached UserID but failed: " + exc.getMessage(), exc);
            function0.invoke();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06401(this.$blockstoreClient, this.$request, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Task<Boolean> taskDeleteBytes = this.$blockstoreClient.deleteBytes(this.$request);
            final Function0<Unit> function0 = this.$callback;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper.clearUserIdBackupIfNeeded.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store cached UserID cleared if any");
                    }
                    function0.invoke();
                }
            };
            Task<Boolean> taskAddOnSuccessListener = taskDeleteBytes.addOnSuccessListener(new OnSuccessListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    function1.invoke(obj2);
                }
            });
            final Function0<Unit> function02 = this.$callback;
            taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    BlockstoreHelper.C06401.invokeSuspend$lambda$2(function02, exc);
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockstoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1", f = "BlockstoreHelper.kt", i = {}, l = {61, 67}, m = "invokeSuspend", n = {}, s = {})
    static final class C06411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06411(String str, Continuation<? super C06411> continuation) {
            super(2, continuation);
            this.$currentUserId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlockstoreHelper.this.new C06411(this.$currentUserId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        
            if (r6.this$0.storeUserIdIfNeeded(r7, r6.$currentUserId, r6) == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Exception e) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to store user Id in Block store: " + e.getMessage(), e);
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = BlockstoreHelper.this.getBlockstoreData(this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                Map map = (Map) obj;
                this.label = 2;
            } catch (Exception e2) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to retrieve Block store data. Will not store userId. Error: " + e2.getMessage(), e2);
                return Unit.INSTANCE;
            }
        }
    }

    public BlockstoreHelper(Context applicationContext, IdentityManager identityManager, BlockstoreClient blockstoreClient, CoroutineScope ioScope, CoroutineScope mainScope) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        this.identityManager = identityManager;
        this.blockstoreClient = blockstoreClient;
        this.ioScope = ioScope;
        this.mainScope = mainScope;
    }

    public /* synthetic */ BlockstoreHelper(Context context, IdentityManager identityManager, BlockstoreClient blockstoreClient, CoroutineScope coroutineScope, CoroutineScope coroutineScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, identityManager, (i & 4) != 0 ? Companion.initializeBlockstoreClient(context) : blockstoreClient, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO().limitedParallelism(1))) : coroutineScope, (i & 16) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())) : coroutineScope2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper blockstoreHelper, Function0<Unit> function0) {
        BuildersKt__Builders_commonKt.launch$default(blockstoreHelper.mainScope, null, null, new BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(function0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBlockstoreData(Continuation<? super Map<String, ? extends RetrieveBytesResponse.BlockstoreData>> continuation) throws Throwable {
        BlockstoreClient blockstoreClient = this.blockstoreClient;
        if (blockstoreClient == null) {
            return MapsKt.emptyMap();
        }
        RetrieveBytesRequest retrieveBytesRequestBuild = new RetrieveBytesRequest.Builder().setRetrieveAll(true).build();
        Intrinsics.checkNotNullExpressionValue(retrieveBytesRequestBuild, "Builder()\n            .s…rue)\n            .build()");
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        blockstoreClient.retrieveBytes(retrieveBytesRequestBuild).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new Function1<RetrieveBytesResponse, Unit>() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$getBlockstoreData$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RetrieveBytesResponse retrieveBytesResponse) {
                invoke2(retrieveBytesResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RetrieveBytesResponse retrieveBytesResponse) {
                Continuation<Map<String, ? extends RetrieveBytesResponse.BlockstoreData>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(retrieveBytesResponse.getBlockstoreDataMap()));
            }
        })).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$getBlockstoreData$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<Map<String, ? extends RetrieveBytesResponse.BlockstoreData>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(it)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object storeUserIdIfNeeded(Map<String, ? extends RetrieveBytesResponse.BlockstoreData> map, final String str, Continuation<? super Unit> continuation) throws Throwable {
        BlockstoreClient blockstoreClient = this.blockstoreClient;
        if (blockstoreClient == null) {
            return Unit.INSTANCE;
        }
        if (map.get(BLOCKSTORE_USER_ID_KEY) != null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store: Not storing user id since there is one already present.");
            }
            return Unit.INSTANCE;
        }
        if (map.size() >= 16) {
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Block store: Not storing user id since block store is already full.");
            }
            return Unit.INSTANCE;
        }
        LogLevel logLevel3 = LogLevel.DEBUG;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Block store: Storing UserID: " + str + " in Block store.");
        }
        StoreBytesData.Builder builder = new StoreBytesData.Builder();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        StoreBytesData storeBytesDataBuild = builder.setBytes(bytes).setKey(BLOCKSTORE_USER_ID_KEY).setShouldBackupToCloud(true).build();
        Intrinsics.checkNotNullExpressionValue(storeBytesDataBuild, "Builder()\n            .s…rue)\n            .build()");
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        blockstoreClient.storeBytes(storeBytesDataBuild).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new Function1<Integer, Unit>() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                String str2 = str;
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), "Block store: User ID: " + str2 + " stored in Block store.");
                }
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
            }
        })).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$6$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(it)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    public final void aliasCurrentAndStoredUserIdsIfNeeded(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (IdentityManager.INSTANCE.isUserIDAnonymous(currentAppUserID)) {
            BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new AnonymousClass1(currentAppUserID, callback, null), 3, null);
        } else {
            aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(this, callback);
        }
    }

    public final void clearUserIdBackupIfNeeded(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BlockstoreClient blockstoreClient = this.blockstoreClient;
        if (blockstoreClient == null) {
            callback.invoke();
            return;
        }
        DeleteBytesRequest deleteBytesRequestBuild = new DeleteBytesRequest.Builder().setKeys(CollectionsKt.listOf(BLOCKSTORE_USER_ID_KEY)).build();
        Intrinsics.checkNotNullExpressionValue(deleteBytesRequestBuild, "Builder()\n            .s…EY))\n            .build()");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C06401(blockstoreClient, deleteBytesRequestBuild, callback, null), 3, null);
    }

    public final void storeUserIdIfNeeded(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        if (this.blockstoreClient == null) {
            return;
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (!IdentityManager.INSTANCE.isUserIDAnonymous(currentAppUserID) || customerInfo.getAllPurchasedProductIds().isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C06411(currentAppUserID, null), 3, null);
    }
}
