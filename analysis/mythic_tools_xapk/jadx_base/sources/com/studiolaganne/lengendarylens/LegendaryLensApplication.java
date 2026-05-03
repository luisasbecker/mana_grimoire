package com.studiolaganne.lengendarylens;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;
import androidx.credentials.provider.CredentialEntry;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;
import io.customer.sdk.CustomerIO;
import io.customer.sdk.CustomerIOConfigBuilder;
import io.customer.sdk.data.model.Region;
import java.net.InetAddress;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: LegendaryLensApplication.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/LegendaryLensApplication;", "Landroid/app/Application;", "Landroidx/camera/core/CameraXConfig$Provider;", "<init>", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "getCameraXConfig", "Landroidx/camera/core/CameraXConfig;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LegendaryLensApplication extends Application implements CameraXConfig.Provider {
    private static LegendaryLensApplication instance;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: LegendaryLensApplication.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/LegendaryLensApplication$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/LegendaryLensApplication;", "applicationContext", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context applicationContext() {
            LegendaryLensApplication legendaryLensApplication = LegendaryLensApplication.instance;
            Intrinsics.checkNotNull(legendaryLensApplication);
            Context applicationContext = legendaryLensApplication.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return applicationContext;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.LegendaryLensApplication$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: LegendaryLensApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.LegendaryLensApplication$onCreate$1", f = "LegendaryLensApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CardSetsManager.INSTANCE.loadCardSets();
            GlossaryManager.INSTANCE.loadGlossaries();
            TagsAndThemesManager.INSTANCE.load();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.LegendaryLensApplication$onCreate$3, reason: invalid class name */
    /* JADX INFO: compiled from: LegendaryLensApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.LegendaryLensApplication$onCreate$3", f = "LegendaryLensApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Log.d("DNS Prefetch", "Resolved: " + InetAddress.getAllByName("api.mythic.tools"));
            } catch (Exception e) {
                Log.w("DNS Prefetch", "Failed to pre-resolve", e);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.LegendaryLensApplication$onCreate$4, reason: invalid class name */
    /* JADX INFO: compiled from: LegendaryLensApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.LegendaryLensApplication$onCreate$4", f = "LegendaryLensApplication.kt", i = {}, l = {Imgproc.COLOR_YUV2RGB_YVYU}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LegendaryLensApplication.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FirebaseTokenManager.INSTANCE.ensureFreshToken(LegendaryLensApplication.this, this) == coroutine_suspended) {
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

    public LegendaryLensApplication() {
        instance = this;
    }

    static final void onCreate$lambda$0(LegendaryLensApplication legendaryLensApplication, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Log.w("MTApp", "Fetching FCM registration token failed", task.getException());
            return;
        }
        String str = (String) task.getResult();
        Log.d("MTApp", "FCM token: " + str);
        PreferencesManager preferencesManager = new PreferencesManager(legendaryLensApplication);
        Intrinsics.checkNotNull(str);
        preferencesManager.setString(PreferencesManager.FCM_TOKEN, str);
    }

    static final void onCreate$lambda$1(LegendaryLensApplication legendaryLensApplication, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        MythicPlusManager.INSTANCE.handleCustomerInfoUpdate(legendaryLensApplication, customerInfo);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        Intrinsics.checkNotNullParameter(base, "base");
        super.attachBaseContext(LocaleHelper.INSTANCE.setLocale(base));
    }

    @Override // androidx.camera.core.CameraXConfig.Provider
    public CameraXConfig getCameraXConfig() {
        return Camera2Config.INSTANCE.defaultConfig();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        LocaleHelper.INSTANCE.setLocale(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        LegendaryLensApplication legendaryLensApplication = this;
        CardEmbeddings.INSTANCE.tryPreloadNativeLibraries(legendaryLensApplication);
        EmojiManager.install(new GoogleEmojiProvider());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.LegendaryLensApplication$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                LegendaryLensApplication.onCreate$lambda$0(this.f$0, task);
            }
        });
        Map<FirebaseAnalytics.ConsentType, FirebaseAnalytics.ConsentStatus> mapMapOf = MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, FirebaseAnalytics.ConsentStatus.GRANTED), TuplesKt.to(FirebaseAnalytics.ConsentType.AD_STORAGE, FirebaseAnalytics.ConsentStatus.DENIED));
        new PreferencesManager(legendaryLensApplication).debugDeviceLanguage();
        new PreferencesManager(legendaryLensApplication).debugCompiledResources();
        FirebaseAnalytics.getInstance(legendaryLensApplication).setConsent(mapMapOf);
        FirebaseAnalytics.getInstance(legendaryLensApplication).setUserProperty("is_logged_in", new PreferencesManager(legendaryLensApplication).getCurrentUser() != null ? "true" : CredentialEntry.FALSE_STRING);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(null), 3, null);
        FirebaseTokenManager.INSTANCE.startTokenAutoRefresh(legendaryLensApplication);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass4(null), 3, null);
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = country.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (Intrinsics.areEqual(upperCase, "US")) {
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.setAdvertiserIDCollectionEnabled(true);
            FacebookSdk.setAutoLogAppEventsEnabled(true);
            FacebookSdk.fullyInitialize();
            AppEventsLogger.INSTANCE.activateApp(this);
        } else {
            FacebookSdk.setAutoInitEnabled(false);
            FacebookSdk.setAdvertiserIDCollectionEnabled(false);
            FacebookSdk.setAutoLogAppEventsEnabled(false);
            FacebookSdk.fullyInitialize();
        }
        Log.d(Utility.LOG_TAG, "AutoInitEnabled: " + FacebookSdk.getAutoInitEnabled());
        Log.d(Utility.LOG_TAG, "AdvertiserIDCollectionEnabled: " + FacebookSdk.getAdvertiserIDCollectionEnabled());
        Log.d(Utility.LOG_TAG, "AutoLogAppEventsEnabled: " + FacebookSdk.getAutoLogAppEventsEnabled());
        Log.d(Utility.LOG_TAG, "Detected country code: " + upperCase);
        AppsFlyerLib.getInstance().setDebugLog(true);
        AppsFlyerLib.getInstance().init("WeSEmMcgQqCKaMPfLR3mZB", null, legendaryLensApplication);
        AppsFlyerLib.getInstance().start(legendaryLensApplication);
        CustomerIO.INSTANCE.initialize(new CustomerIOConfigBuilder(this, "12cd6b510e5c693ec259").region(Region.EU.INSTANCE).build());
        PreferencesManager preferencesManager = new PreferencesManager(legendaryLensApplication);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            CustomerIOHelper.INSTANCE.maybeIdentifyAfterLogin(currentUser, preferencesManager);
            Purchases.INSTANCE.setLogLevel(LogLevel.DEBUG);
            Purchases.INSTANCE.configure(new PurchasesConfiguration.Builder(legendaryLensApplication, "goog_GyzqdIHbVPBiWPlJUdPUezfmayQ").appUserID(String.valueOf(currentUser.getId())).preferredUILocaleOverride(preferencesManager.getDeviceLanguage()).build());
        } else {
            Purchases.INSTANCE.setLogLevel(LogLevel.DEBUG);
            Purchases.INSTANCE.configure(new PurchasesConfiguration.Builder(legendaryLensApplication, "goog_GyzqdIHbVPBiWPlJUdPUezfmayQ").build());
        }
        MythicPlusManager.INSTANCE.initFromCache(legendaryLensApplication);
        Purchases.INSTANCE.getSharedInstance().setUpdatedCustomerInfoListener(new UpdatedCustomerInfoListener() { // from class: com.studiolaganne.lengendarylens.LegendaryLensApplication$$ExternalSyntheticLambda1
            @Override // com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener
            public final void onReceived(CustomerInfo customerInfo) {
                LegendaryLensApplication.onCreate$lambda$1(this.f$0, customerInfo);
            }
        });
    }
}
