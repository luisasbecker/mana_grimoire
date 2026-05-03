package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.DataStore;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: SharedSessionRepository.kt */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\u00010BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u001e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/google/firebase/sessions/SharedSessionRepositoryImpl;", "Lcom/google/firebase/sessions/SharedSessionRepository;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionFirelogPublisher", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "sessionDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/google/firebase/sessions/SessionData;", "processDataManager", "Lcom/google/firebase/sessions/ProcessDataManager;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/SessionGenerator;Lcom/google/firebase/sessions/SessionFirelogPublisher;Lcom/google/firebase/sessions/TimeProvider;Landroidx/datastore/core/DataStore;Lcom/google/firebase/sessions/ProcessDataManager;Lkotlin/coroutines/CoroutineContext;)V", "localSessionData", "getLocalSessionData$com_google_firebase_firebase_sessions", "()Lcom/google/firebase/sessions/SessionData;", "setLocalSessionData$com_google_firebase_firebase_sessions", "(Lcom/google/firebase/sessions/SessionData;)V", "value", "", "isInForeground", "()Z", "pendingForegroundCheck", "previousNotificationType", "Lcom/google/firebase/sessions/SharedSessionRepositoryImpl$NotificationType;", "getPreviousNotificationType$com_google_firebase_firebase_sessions", "()Lcom/google/firebase/sessions/SharedSessionRepositoryImpl$NotificationType;", "setPreviousNotificationType$com_google_firebase_firebase_sessions", "(Lcom/google/firebase/sessions/SharedSessionRepositoryImpl$NotificationType;)V", "previousSessionId", "", "appBackground", "", "appForeground", "notifySubscribers", "sessionId", "type", "(Ljava/lang/String;Lcom/google/firebase/sessions/SharedSessionRepositoryImpl$NotificationType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSessionExpired", "sessionData", "isColdStart", "isMyProcessStale", "NotificationType", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedSessionRepositoryImpl implements SharedSessionRepository {
    private final CoroutineContext backgroundDispatcher;
    private boolean isInForeground;
    public SessionData localSessionData;
    private boolean pendingForegroundCheck;
    private NotificationType previousNotificationType;
    private String previousSessionId;
    private final ProcessDataManager processDataManager;
    private final DataStore<SessionData> sessionDataStore;
    private final SessionFirelogPublisher sessionFirelogPublisher;
    private final SessionGenerator sessionGenerator;
    private final SessionsSettings sessionsSettings;
    private final TimeProvider timeProvider;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedSessionRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$1", f = "SharedSessionRepository.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SharedSessionRepository.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/firebase/sessions/SessionData;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$1$1", f = "SharedSessionRepository.kt", i = {}, l = {Imgproc.COLOR_YUV2RGBA_NV12}, m = "invokeSuspend", n = {}, s = {})
        static final class C01361 extends SuspendLambda implements Function3<FlowCollector<? super SessionData>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ SharedSessionRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01361(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation<? super C01361> continuation) {
                super(3, continuation);
                this.this$0 = sharedSessionRepositoryImpl;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super SessionData> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01361 c01361 = new C01361(this.this$0, continuation);
                c01361.L$0 = flowCollector;
                c01361.L$1 = th;
                return c01361.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    SessionData sessionData = new SessionData(this.this$0.sessionGenerator.generateNewSession(null), (Time) null, (Map) null, 4, (DefaultConstructorMarker) null);
                    Log.d(FirebaseSessions.TAG, "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + sessionData.getSessionDetails().getSessionId());
                    this.L$0 = null;
                    this.label = 1;
                    if (flowCollector.emit(sessionData, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharedSessionRepositoryImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM12989catch = FlowKt.m12989catch(SharedSessionRepositoryImpl.this.sessionDataStore.getData(), new C01361(SharedSessionRepositoryImpl.this, null));
                final SharedSessionRepositoryImpl sharedSessionRepositoryImpl = SharedSessionRepositoryImpl.this;
                this.label = 1;
                if (flowM12989catch.collect(new FlowCollector() { // from class: com.google.firebase.sessions.SharedSessionRepositoryImpl.1.2
                    public final Object emit(SessionData sessionData, Continuation<? super Unit> continuation) {
                        sharedSessionRepositoryImpl.setLocalSessionData$com_google_firebase_firebase_sessions(sessionData);
                        if (sharedSessionRepositoryImpl.pendingForegroundCheck) {
                            sharedSessionRepositoryImpl.pendingForegroundCheck = false;
                            sharedSessionRepositoryImpl.appForeground();
                        }
                        Object objNotifySubscribers = sharedSessionRepositoryImpl.notifySubscribers(sessionData.getSessionDetails().getSessionId(), NotificationType.GENERAL, continuation);
                        return objNotifySubscribers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objNotifySubscribers : Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SessionData) obj2, (Continuation<? super Unit>) continuation);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SharedSessionRepository.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/SharedSessionRepositoryImpl$NotificationType;", "", "<init>", "(Ljava/lang/String;I)V", "GENERAL", "FALLBACK", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NotificationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NotificationType[] $VALUES;
        public static final NotificationType GENERAL = new NotificationType("GENERAL", 0);
        public static final NotificationType FALLBACK = new NotificationType("FALLBACK", 1);

        private static final /* synthetic */ NotificationType[] $values() {
            return new NotificationType[]{GENERAL, FALLBACK};
        }

        static {
            NotificationType[] notificationTypeArr$values = $values();
            $VALUES = notificationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(notificationTypeArr$values);
        }

        private NotificationType(String str, int i) {
        }

        public static EnumEntries<NotificationType> getEntries() {
            return $ENTRIES;
        }

        public static NotificationType valueOf(String str) {
            return (NotificationType) Enum.valueOf(NotificationType.class, str);
        }

        public static NotificationType[] values() {
            return (NotificationType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: SharedSessionRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationType.values().length];
            try {
                iArr[NotificationType.GENERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationType.FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedSessionRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1", f = "SharedSessionRepository.kt", i = {}, l = {Imgproc.COLOR_YUV2BGR_YVYU}, m = "invokeSuspend", n = {}, s = {})
    static final class C05771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SharedSessionRepository.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/google/firebase/sessions/SessionData;", "sessionData"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1$1", f = "SharedSessionRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01371 extends SuspendLambda implements Function2<SessionData, Continuation<? super SessionData>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SharedSessionRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01371(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation<? super C01371> continuation) {
                super(2, continuation);
                this.this$0 = sharedSessionRepositoryImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01371 c01371 = new C01371(this.this$0, continuation);
                c01371.L$0 = obj;
                return c01371;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SessionData sessionData, Continuation<? super SessionData> continuation) {
                return ((C01371) create(sessionData, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return SessionData.copy$default((SessionData) this.L$0, null, this.this$0.timeProvider.currentTime(), null, 5, null);
            }
        }

        C05771(Continuation<? super C05771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharedSessionRepositoryImpl.this.new C05771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objUpdateData = SharedSessionRepositoryImpl.this.sessionDataStore.updateData(new C01371(SharedSessionRepositoryImpl.this, null), this);
                    this = objUpdateData;
                    if (objUpdateData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (Exception e) {
                Log.d(FirebaseSessions.TAG, "App backgrounded, failed to update data. Message: " + e.getMessage());
                SharedSessionRepositoryImpl sharedSessionRepositoryImpl = SharedSessionRepositoryImpl.this;
                sharedSessionRepositoryImpl.setLocalSessionData$com_google_firebase_firebase_sessions(SessionData.copy$default(sharedSessionRepositoryImpl.getLocalSessionData$com_google_firebase_firebase_sessions(), null, SharedSessionRepositoryImpl.this.timeProvider.currentTime(), null, 5, null));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedSessionRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1", f = "SharedSessionRepository.kt", i = {}, l = {142, 193}, m = "invokeSuspend", n = {}, s = {})
    static final class C05781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionData $sessionData;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SharedSessionRepository.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/google/firebase/sessions/SessionData;", "currentSessionData"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1", f = "SharedSessionRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01381 extends SuspendLambda implements Function2<SessionData, Continuation<? super SessionData>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SharedSessionRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01381(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation<? super C01381> continuation) {
                super(2, continuation);
                this.this$0 = sharedSessionRepositoryImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01381 c01381 = new C01381(this.this$0, continuation);
                c01381.L$0 = obj;
                return c01381;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SessionData sessionData, Continuation<? super SessionData> continuation) {
                return ((C01381) create(sessionData, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SessionData sessionData = (SessionData) this.L$0;
                boolean zIsSessionExpired = this.this$0.isSessionExpired(sessionData);
                boolean zIsColdStart = this.this$0.isColdStart(sessionData);
                boolean zIsMyProcessStale = this.this$0.isMyProcessStale(sessionData);
                Map<String, ProcessData> mapGenerateProcessDataMap = zIsColdStart ? this.this$0.processDataManager.generateProcessDataMap() : zIsMyProcessStale ? this.this$0.processDataManager.updateProcessDataMap(sessionData.getProcessDataMap()) : sessionData.getProcessDataMap();
                SessionDetails sessionDetails = zIsColdStart ? null : sessionData.getSessionDetails();
                if (!zIsSessionExpired && !zIsColdStart) {
                    return zIsMyProcessStale ? SessionData.copy$default(sessionData, null, null, this.this$0.processDataManager.updateProcessDataMap(mapGenerateProcessDataMap), 3, null) : sessionData;
                }
                SessionDetails sessionDetailsGenerateNewSession = this.this$0.sessionGenerator.generateNewSession(sessionDetails);
                this.this$0.sessionFirelogPublisher.mayLogSession(sessionDetailsGenerateNewSession);
                this.this$0.processDataManager.onSessionGenerated();
                return sessionData.copy(sessionDetailsGenerateNewSession, null, mapGenerateProcessDataMap);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05781(SessionData sessionData, Continuation<? super C05781> continuation) {
            super(2, continuation);
            this.$sessionData = sessionData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SharedSessionRepositoryImpl.this.new C05781(this.$sessionData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            if (r9 == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
        
            if (r9.this$0.notifySubscribers(r4.getSessionId(), com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType.FALLBACK, r9) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
        
            return r1;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                Log.d(FirebaseSessions.TAG, "App foregrounded, failed to update data. Message: " + e.getMessage());
                if (SharedSessionRepositoryImpl.this.isSessionExpired(this.$sessionData)) {
                    SessionDetails sessionDetailsGenerateNewSession = SharedSessionRepositoryImpl.this.sessionGenerator.generateNewSession(this.$sessionData.getSessionDetails());
                    SharedSessionRepositoryImpl.this.setLocalSessionData$com_google_firebase_firebase_sessions(SessionData.copy$default(this.$sessionData, sessionDetailsGenerateNewSession, null, null, 4, null));
                    SharedSessionRepositoryImpl.this.sessionFirelogPublisher.mayLogSession(sessionDetailsGenerateNewSession);
                    this.label = 2;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                Object objUpdateData = SharedSessionRepositoryImpl.this.sessionDataStore.updateData(new C01381(SharedSessionRepositoryImpl.this, null), this);
                this = objUpdateData;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$notifySubscribers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedSessionRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl", f = "SharedSessionRepository.kt", i = {0, 0}, l = {206}, m = "notifySubscribers", n = {"sessionId", "type"}, s = {"L$0", "L$1"})
    static final class C05791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05791(Continuation<? super C05791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedSessionRepositoryImpl.this.notifySubscribers(null, null, this);
        }
    }

    @Inject
    public SharedSessionRepositoryImpl(SessionsSettings sessionsSettings, SessionGenerator sessionGenerator, SessionFirelogPublisher sessionFirelogPublisher, TimeProvider timeProvider, DataStore<SessionData> sessionDataStore, ProcessDataManager processDataManager, @Background CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(sessionsSettings, "sessionsSettings");
        Intrinsics.checkNotNullParameter(sessionGenerator, "sessionGenerator");
        Intrinsics.checkNotNullParameter(sessionFirelogPublisher, "sessionFirelogPublisher");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(sessionDataStore, "sessionDataStore");
        Intrinsics.checkNotNullParameter(processDataManager, "processDataManager");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.sessionsSettings = sessionsSettings;
        this.sessionGenerator = sessionGenerator;
        this.sessionFirelogPublisher = sessionFirelogPublisher;
        this.timeProvider = timeProvider;
        this.sessionDataStore = sessionDataStore;
        this.processDataManager = processDataManager;
        this.backgroundDispatcher = backgroundDispatcher;
        this.previousNotificationType = NotificationType.GENERAL;
        this.previousSessionId = "";
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isColdStart(SessionData sessionData) {
        Map<String, ProcessData> processDataMap = sessionData.getProcessDataMap();
        if (processDataMap == null) {
            Log.d(FirebaseSessions.TAG, "No process data map");
            return true;
        }
        boolean zIsColdStart = this.processDataManager.isColdStart(processDataMap);
        if (zIsColdStart) {
            Log.d(FirebaseSessions.TAG, "Cold app start detected");
        }
        return zIsColdStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMyProcessStale(SessionData sessionData) {
        Map<String, ProcessData> processDataMap = sessionData.getProcessDataMap();
        ProcessDataManager processDataManager = this.processDataManager;
        if (processDataMap == null) {
            Log.d(FirebaseSessions.TAG, "No process data for " + processDataManager.getMyProcessName());
            return true;
        }
        boolean zIsMyProcessStale = processDataManager.isMyProcessStale(processDataMap);
        if (zIsMyProcessStale) {
            Log.d(FirebaseSessions.TAG, "Process " + this.processDataManager.getMyProcessName() + " is stale");
        }
        return zIsMyProcessStale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSessionExpired(SessionData sessionData) {
        Time backgroundTime = sessionData.getBackgroundTime();
        if (backgroundTime == null) {
            Log.d(FirebaseSessions.TAG, "Session " + sessionData.getSessionDetails().getSessionId() + " has not backgrounded yet");
            return false;
        }
        boolean z = Duration.m12795compareToLRDsOJo(this.timeProvider.currentTime().m10240minus5sfh64U(backgroundTime), this.sessionsSettings.m10244getSessionRestartTimeoutUwyO8pc()) > 0;
        if (z) {
            Log.d(FirebaseSessions.TAG, "Session " + sessionData.getSessionDetails().getSessionId() + " is expired");
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifySubscribers(String str, NotificationType notificationType, Continuation<? super Unit> continuation) {
        C05791 c05791;
        String str2;
        if (continuation instanceof C05791) {
            c05791 = (C05791) continuation;
            if ((c05791.label & Integer.MIN_VALUE) != 0) {
                c05791.label -= Integer.MIN_VALUE;
            } else {
                c05791 = new C05791(continuation);
            }
        }
        Object registeredSubscribers$com_google_firebase_firebase_sessions = c05791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05791.label;
        if (i == 0) {
            ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
            this.previousNotificationType = notificationType;
            if (Intrinsics.areEqual(this.previousSessionId, str)) {
                return Unit.INSTANCE;
            }
            this.previousSessionId = str;
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
            c05791.L$0 = str;
            c05791.L$1 = notificationType;
            c05791.label = 1;
            registeredSubscribers$com_google_firebase_firebase_sessions = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(c05791);
            if (registeredSubscribers$com_google_firebase_firebase_sessions == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            notificationType = (NotificationType) c05791.L$1;
            str = (String) c05791.L$0;
            ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
        }
        for (SessionSubscriber sessionSubscriber : ((Map) registeredSubscribers$com_google_firebase_firebase_sessions).values()) {
            sessionSubscriber.onSessionChanged(new SessionSubscriber.SessionDetails(str));
            int i2 = WhenMappings.$EnumSwitchMapping$0[notificationType.ordinal()];
            if (i2 == 1) {
                str2 = "Notified " + sessionSubscriber.getSessionSubscriberName() + " of new session " + str;
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = "Notified " + sessionSubscriber.getSessionSubscriberName() + " of new fallback session " + str;
            }
            Log.d(FirebaseSessions.TAG, str2);
        }
        return Unit.INSTANCE;
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public void appBackground() {
        this.isInForeground = false;
        if (this.localSessionData == null) {
            Log.d(FirebaseSessions.TAG, "App backgrounded, but local SessionData not initialized");
        } else {
            Log.d(FirebaseSessions.TAG, "App backgrounded on " + this.processDataManager.getMyProcessName());
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new C05771(null), 3, null);
        }
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public void appForeground() {
        this.isInForeground = true;
        if (this.localSessionData == null) {
            this.pendingForegroundCheck = true;
            Log.d(FirebaseSessions.TAG, "App foregrounded, but local SessionData not initialized");
            return;
        }
        SessionData localSessionData$com_google_firebase_firebase_sessions = getLocalSessionData$com_google_firebase_firebase_sessions();
        Log.d(FirebaseSessions.TAG, "App foregrounded on " + this.processDataManager.getMyProcessName());
        if (isSessionExpired(localSessionData$com_google_firebase_firebase_sessions) || isMyProcessStale(localSessionData$com_google_firebase_firebase_sessions)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new C05781(localSessionData$com_google_firebase_firebase_sessions, null), 3, null);
        }
    }

    public final SessionData getLocalSessionData$com_google_firebase_firebase_sessions() {
        SessionData sessionData = this.localSessionData;
        if (sessionData != null) {
            return sessionData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localSessionData");
        return null;
    }

    /* JADX INFO: renamed from: getPreviousNotificationType$com_google_firebase_firebase_sessions, reason: from getter */
    public final NotificationType getPreviousNotificationType() {
        return this.previousNotificationType;
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    /* JADX INFO: renamed from: isInForeground, reason: from getter */
    public boolean getIsInForeground() {
        return this.isInForeground;
    }

    public final void setLocalSessionData$com_google_firebase_firebase_sessions(SessionData sessionData) {
        Intrinsics.checkNotNullParameter(sessionData, "<set-?>");
        this.localSessionData = sessionData;
    }

    public final void setPreviousNotificationType$com_google_firebase_firebase_sessions(NotificationType notificationType) {
        Intrinsics.checkNotNullParameter(notificationType, "<set-?>");
        this.previousNotificationType = notificationType;
    }
}
