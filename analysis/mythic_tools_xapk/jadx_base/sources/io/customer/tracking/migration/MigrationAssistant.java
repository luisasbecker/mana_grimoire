package io.customer.tracking.migration;

import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import io.customer.tracking.migration.di.MigrationSDKComponent;
import io.customer.tracking.migration.queue.Queue;
import io.customer.tracking.migration.repository.preference.SitePreferenceRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MigrationAssistant.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/customer/tracking/migration/MigrationAssistant;", "", "migrationProcessor", "Lio/customer/tracking/migration/MigrationProcessor;", "migrationSiteId", "", "migrationSDKComponent", "Lio/customer/tracking/migration/di/MigrationSDKComponent;", "<init>", "(Lio/customer/tracking/migration/MigrationProcessor;Ljava/lang/String;Lio/customer/tracking/migration/di/MigrationSDKComponent;)V", "sitePreferences", "Lio/customer/tracking/migration/repository/preference/SitePreferenceRepository;", "queue", "Lio/customer/tracking/migration/queue/Queue;", "logger", "Lio/customer/sdk/core/util/Logger;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "migrateExistingProfile", "", "migrateExistingDevice", "Companion", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MigrationAssistant {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CoroutineScope coroutineScope;
    private final Logger logger;
    private final MigrationProcessor migrationProcessor;
    private final Queue queue;
    private final SitePreferenceRepository sitePreferences;

    /* JADX INFO: renamed from: io.customer.tracking.migration.MigrationAssistant$1, reason: invalid class name */
    /* JADX INFO: compiled from: MigrationAssistant.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.tracking.migration.MigrationAssistant$1", f = "MigrationAssistant.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MigrationAssistant.this.new AnonymousClass1(continuation);
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
                Logger.DefaultImpls.debug$default(MigrationAssistant.this.logger, "Migrating existing token and profile...", null, 2, null);
                MigrationAssistant.this.migrateExistingDevice();
                MigrationAssistant.this.migrateExistingProfile();
                Logger.DefaultImpls.debug$default(MigrationAssistant.this.logger, "Requesting migration queue to run...", null, 2, null);
                this.label = 1;
                if (MigrationAssistant.this.queue.run(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger.DefaultImpls.debug$default(MigrationAssistant.this.logger, "Migration completed successfully", null, 2, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: MigrationAssistant.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lio/customer/tracking/migration/MigrationAssistant$Companion;", "", "<init>", "()V", "start", "Lio/customer/tracking/migration/MigrationAssistant;", "migrationProcessor", "Lio/customer/tracking/migration/MigrationProcessor;", "migrationSiteId", "", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MigrationAssistant start(MigrationProcessor migrationProcessor, String migrationSiteId) {
            Intrinsics.checkNotNullParameter(migrationProcessor, "migrationProcessor");
            Intrinsics.checkNotNullParameter(migrationSiteId, "migrationSiteId");
            return new MigrationAssistant(migrationProcessor, migrationSiteId, null, 4, null);
        }
    }

    public MigrationAssistant(MigrationProcessor migrationProcessor, String migrationSiteId, MigrationSDKComponent migrationSDKComponent) {
        Intrinsics.checkNotNullParameter(migrationProcessor, "migrationProcessor");
        Intrinsics.checkNotNullParameter(migrationSiteId, "migrationSiteId");
        Intrinsics.checkNotNullParameter(migrationSDKComponent, "migrationSDKComponent");
        this.migrationProcessor = migrationProcessor;
        this.sitePreferences = migrationSDKComponent.getSitePreferences();
        this.queue = migrationSDKComponent.getQueue();
        Logger logger = SDKComponent.INSTANCE.getLogger();
        this.logger = logger;
        CoroutineScope migrationQueueScope = migrationSDKComponent.getMigrationQueueScope();
        this.coroutineScope = migrationQueueScope;
        Logger.DefaultImpls.debug$default(logger, "Starting migration tracking data...", null, 2, null);
        BuildersKt__Builders_commonKt.launch$default(migrationQueueScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ MigrationAssistant(MigrationProcessor migrationProcessor, String str, MigrationSDKComponent migrationSDKComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        MigrationProcessor migrationProcessor2;
        String str2;
        if ((i & 4) != 0) {
            migrationProcessor2 = migrationProcessor;
            str2 = str;
            migrationSDKComponent = new MigrationSDKComponent(null, migrationProcessor2, str2, 1, null);
        } else {
            migrationProcessor2 = migrationProcessor;
            str2 = str;
        }
        this(migrationProcessor2, str2, migrationSDKComponent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void migrateExistingDevice() {
        String deviceToken = this.sitePreferences.getDeviceToken();
        if (deviceToken != null && Result.m11452isSuccessimpl(this.migrationProcessor.mo11433processDeviceMigrationIoAF18A(deviceToken))) {
            this.sitePreferences.removeDeviceToken();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void migrateExistingProfile() {
        String identifier = this.sitePreferences.getIdentifier();
        if (identifier == null) {
            return;
        }
        Logger.DefaultImpls.debug$default(this.logger, "Migrating existing profile with identifier: " + identifier, null, 2, null);
        if (Result.m11452isSuccessimpl(this.migrationProcessor.mo11434processProfileMigrationIoAF18A(identifier))) {
            this.sitePreferences.removeIdentifier(identifier);
        }
    }
}
