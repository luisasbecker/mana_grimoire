package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.media3.muxer.WebmConstants;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.TimeProvider;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: RemoteSettings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u001dH\u0081@¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "<init>", "(Lcom/google/firebase/sessions/TimeProvider;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Lcom/google/firebase/sessions/settings/SettingsCache;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "updateSettings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSettingsStale", "clearCachedSettings", "clearCachedSettings$com_google_firebase_firebase_sessions", "sanitize", "", "s", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);
    private static final int defaultCacheDuration;
    private static final Regex sanitizeRegex;
    private final ApplicationInfo appInfo;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final SettingsCache settingsCache;
    private final TimeProvider timeProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "<init>", "()V", "defaultCacheDuration", "", "getDefaultCacheDuration", "()I", "sanitizeRegex", "Lkotlin/text/Regex;", "getSanitizeRegex", "()Lkotlin/text/Regex;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getDefaultCacheDuration() {
            return RemoteSettings.defaultCacheDuration;
        }

        public final Regex getSanitizeRegex() {
            return RemoteSettings.sanitizeRegex;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", i = {0, 0, 1, 1, 2}, l = {WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, 78, Imgproc.COLOR_YUV2BGRA_NV12}, m = "updateSettings", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        defaultCacheDuration = (int) Duration.m12810getInWholeSecondsimpl(DurationKt.toDuration(24, DurationUnit.HOURS));
        sanitizeRegex = new Regex("com/google/firebase/sessions//");
    }

    @Inject
    public RemoteSettings(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, SettingsCache settingsCache) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(settingsCache, "settingsCache");
        this.timeProvider = timeProvider;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = settingsCache;
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, null);
    }

    private final String sanitize(String s) {
        return sanitizeRegex.replace(s, "");
    }

    public final Object clearCachedSettings$com_google_firebase_firebase_sessions(Continuation<? super Unit> continuation) {
        Object objUpdateConfigs = this.settingsCache.updateConfigs(SessionConfigsSerializer.INSTANCE.getDefaultValue(), continuation);
        return objUpdateConfigs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigs : Unit.INSTANCE;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    public Duration mo10242getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m12794boximpl(DurationKt.toDuration(numSessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x014a, code lost:
    
        if (r3.doConfigFetch(r13, r5, r2, r0) == r1) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #1 {all -> 0x004c, blocks: (B:14:0x0033, B:51:0x014d, B:19:0x0048, B:42:0x00ac, B:44:0x00ba, B:48:0x00c6), top: B:59:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.firebase.sessions.settings.RemoteSettings, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.google.firebase.sessions.settings.RemoteSettings, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.google.firebase.sessions.settings.RemoteSettings] */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSettings(Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        ?? r12;
        ?? r2;
        Mutex mutex2;
        String fid;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.fetchInProgress.isLocked() && !this.settingsCache.hasCacheExpired()) {
                        return Unit.INSTANCE;
                    }
                    mutex = this.fetchInProgress;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = mutex;
                    anonymousClass1.label = 1;
                    this = this;
                    if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    Mutex mutex3 = (Mutex) anonymousClass1.L$1;
                    RemoteSettings remoteSettings = (RemoteSettings) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                    r12 = remoteSettings;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (Mutex) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    mutex2 = (Mutex) anonymousClass1.L$1;
                    RemoteSettings remoteSettings2 = (RemoteSettings) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = remoteSettings2;
                    fid = ((InstallationId) obj).getFid();
                    if (!Intrinsics.areEqual(fid, "")) {
                        Log.w(FirebaseSessions.TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit2;
                    }
                    String INCREMENTAL = Build.VERSION.INCREMENTAL;
                    Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                    String RELEASE = Build.VERSION.RELEASE;
                    Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                    Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-Crashlytics-Installation-ID", fid), TuplesKt.to("X-Crashlytics-Device-Model", r2.sanitize(Build.MANUFACTURER + Build.MODEL)), TuplesKt.to("X-Crashlytics-OS-Build-Version", r2.sanitize(INCREMENTAL)), TuplesKt.to("X-Crashlytics-OS-Display-Version", r2.sanitize(RELEASE)), TuplesKt.to("X-Crashlytics-API-Client-Version", r2.appInfo.getSessionSdkVersion()));
                    Log.d(FirebaseSessions.TAG, "Fetching settings from server.");
                    CrashlyticsSettingsFetcher crashlyticsSettingsFetcher = r2.configsFetcher;
                    RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(r2, null);
                    RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                    anonymousClass1.L$0 = mutex2;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 3;
                }
                if (!r12.settingsCache.hasCacheExpired()) {
                    Log.d(FirebaseSessions.TAG, "Remote settings cache not expired. Using cached values.");
                    Unit unit3 = Unit.INSTANCE;
                    mutex.unlock(null);
                    return unit3;
                }
                InstallationId.Companion companion = InstallationId.INSTANCE;
                FirebaseInstallationsApi firebaseInstallationsApi = r12.firebaseInstallationsApi;
                anonymousClass1.L$0 = r12;
                anonymousClass1.L$1 = mutex;
                anonymousClass1.label = 2;
                Object objCreate = companion.create(firebaseInstallationsApi, anonymousClass1);
                if (objCreate != coroutine_suspended) {
                    r2 = r12;
                    mutex2 = mutex;
                    obj = objCreate;
                    fid = ((InstallationId) obj).getFid();
                    if (!Intrinsics.areEqual(fid, "")) {
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                Mutex mutex4 = mutex;
                th = th;
                this = mutex4;
                this.unlock(null);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
