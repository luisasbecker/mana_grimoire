package io.customer.tracking.migration.di;

import android.content.Context;
import io.customer.sdk.core.di.AndroidSDKComponent;
import io.customer.sdk.core.di.DiGraph;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import io.customer.tracking.migration.MigrationProcessor;
import io.customer.tracking.migration.queue.Queue;
import io.customer.tracking.migration.queue.QueueImpl;
import io.customer.tracking.migration.queue.QueueQueryRunner;
import io.customer.tracking.migration.queue.QueueQueryRunnerImpl;
import io.customer.tracking.migration.queue.QueueRunRequest;
import io.customer.tracking.migration.queue.QueueRunRequestImpl;
import io.customer.tracking.migration.queue.QueueRunner;
import io.customer.tracking.migration.queue.QueueRunnerImpl;
import io.customer.tracking.migration.queue.QueueStorage;
import io.customer.tracking.migration.queue.QueueStorageImpl;
import io.customer.tracking.migration.repository.preference.SitePreferenceRepository;
import io.customer.tracking.migration.repository.preference.SitePreferenceRepositoryImpl;
import io.customer.tracking.migration.store.FileStorage;
import io.customer.tracking.migration.util.JsonAdapter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: MigrationSDKComponent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Lio/customer/tracking/migration/di/MigrationSDKComponent;", "Lio/customer/sdk/core/di/DiGraph;", "androidSDKComponent", "Lio/customer/sdk/core/di/AndroidSDKComponent;", "migrationProcessor", "Lio/customer/tracking/migration/MigrationProcessor;", "migrationSiteId", "", "<init>", "(Lio/customer/sdk/core/di/AndroidSDKComponent;Lio/customer/tracking/migration/MigrationProcessor;Ljava/lang/String;)V", "getMigrationProcessor$tracking_migration_release", "()Lio/customer/tracking/migration/MigrationProcessor;", "getMigrationSiteId$tracking_migration_release", "()Ljava/lang/String;", "applicationContext", "Landroid/content/Context;", "getApplicationContext$tracking_migration_release", "()Landroid/content/Context;", "logger", "Lio/customer/sdk/core/util/Logger;", "getLogger$tracking_migration_release", "()Lio/customer/sdk/core/util/Logger;", "migrationQueueScope", "Lkotlinx/coroutines/CoroutineScope;", "getMigrationQueueScope", "()Lkotlinx/coroutines/CoroutineScope;", "sitePreferences", "Lio/customer/tracking/migration/repository/preference/SitePreferenceRepository;", "getSitePreferences", "()Lio/customer/tracking/migration/repository/preference/SitePreferenceRepository;", "jsonAdapter", "Lio/customer/tracking/migration/util/JsonAdapter;", "getJsonAdapter$tracking_migration_release", "()Lio/customer/tracking/migration/util/JsonAdapter;", "fileStorage", "Lio/customer/tracking/migration/store/FileStorage;", "getFileStorage$tracking_migration_release", "()Lio/customer/tracking/migration/store/FileStorage;", "queueQueryRunner", "Lio/customer/tracking/migration/queue/QueueQueryRunner;", "getQueueQueryRunner$tracking_migration_release", "()Lio/customer/tracking/migration/queue/QueueQueryRunner;", "queueRunner", "Lio/customer/tracking/migration/queue/QueueRunner;", "getQueueRunner$tracking_migration_release", "()Lio/customer/tracking/migration/queue/QueueRunner;", "queueRunRequest", "Lio/customer/tracking/migration/queue/QueueRunRequest;", "getQueueRunRequest$tracking_migration_release", "()Lio/customer/tracking/migration/queue/QueueRunRequest;", "queueStorage", "Lio/customer/tracking/migration/queue/QueueStorage;", "getQueueStorage$tracking_migration_release", "()Lio/customer/tracking/migration/queue/QueueStorage;", "queue", "Lio/customer/tracking/migration/queue/Queue;", "getQueue", "()Lio/customer/tracking/migration/queue/Queue;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MigrationSDKComponent extends DiGraph {
    private final Context applicationContext;
    private final Logger logger;
    private final MigrationProcessor migrationProcessor;
    private final String migrationSiteId;

    public MigrationSDKComponent(AndroidSDKComponent androidSDKComponent, MigrationProcessor migrationProcessor, String migrationSiteId) {
        Intrinsics.checkNotNullParameter(androidSDKComponent, "androidSDKComponent");
        Intrinsics.checkNotNullParameter(migrationProcessor, "migrationProcessor");
        Intrinsics.checkNotNullParameter(migrationSiteId, "migrationSiteId");
        this.migrationProcessor = migrationProcessor;
        this.migrationSiteId = migrationSiteId;
        this.applicationContext = androidSDKComponent.getApplicationContext();
        this.logger = SDKComponent.INSTANCE.getLogger();
    }

    public /* synthetic */ MigrationSDKComponent(AndroidSDKComponent androidSDKComponent, MigrationProcessor migrationProcessor, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SDKComponent.INSTANCE.android() : androidSDKComponent, migrationProcessor, str);
    }

    /* JADX INFO: renamed from: getApplicationContext$tracking_migration_release, reason: from getter */
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final FileStorage getFileStorage$tracking_migration_release() {
        FileStorage fileStorage;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = FileStorage.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof FileStorage)) {
            obj = null;
        }
        FileStorage fileStorage2 = (FileStorage) obj;
        if (fileStorage2 != null) {
            return fileStorage2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = FileStorage.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            Object fileStorage3 = singletons.get(name2);
            if (fileStorage3 == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (fileStorage3 = new FileStorage(this.migrationSiteId, this.applicationContext, this.logger)))) != null) {
                fileStorage3 = objPutIfAbsent;
            }
            if (fileStorage3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.store.FileStorage");
            }
            fileStorage = (FileStorage) fileStorage3;
        }
        return fileStorage;
    }

    public final JsonAdapter getJsonAdapter$tracking_migration_release() {
        JsonAdapter jsonAdapter;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = JsonAdapter.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof JsonAdapter)) {
            obj = null;
        }
        JsonAdapter jsonAdapter2 = (JsonAdapter) obj;
        if (jsonAdapter2 != null) {
            return jsonAdapter2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = JsonAdapter.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            Object jsonAdapter3 = singletons.get(name2);
            if (jsonAdapter3 == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (jsonAdapter3 = new JsonAdapter()))) != null) {
                jsonAdapter3 = objPutIfAbsent;
            }
            if (jsonAdapter3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.util.JsonAdapter");
            }
            jsonAdapter = (JsonAdapter) jsonAdapter3;
        }
        return jsonAdapter;
    }

    /* JADX INFO: renamed from: getLogger$tracking_migration_release, reason: from getter */
    public final Logger getLogger() {
        return this.logger;
    }

    /* JADX INFO: renamed from: getMigrationProcessor$tracking_migration_release, reason: from getter */
    public final MigrationProcessor getMigrationProcessor() {
        return this.migrationProcessor;
    }

    public final CoroutineScope getMigrationQueueScope() {
        CoroutineScope coroutineScope;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = CoroutineScope.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof CoroutineScope)) {
            obj = null;
        }
        CoroutineScope coroutineScope2 = (CoroutineScope) obj;
        if (coroutineScope2 != null) {
            return coroutineScope2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = CoroutineScope.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            Object objCoroutineScope = singletons.get(name2);
            if (objCoroutineScope == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (objCoroutineScope = CoroutineScopeKt.CoroutineScope(SDKComponent.INSTANCE.getDispatchersProvider().getBackground())))) != null) {
                objCoroutineScope = objPutIfAbsent;
            }
            if (objCoroutineScope == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CoroutineScope");
            }
            coroutineScope = (CoroutineScope) objCoroutineScope;
        }
        return coroutineScope;
    }

    /* JADX INFO: renamed from: getMigrationSiteId$tracking_migration_release, reason: from getter */
    public final String getMigrationSiteId() {
        return this.migrationSiteId;
    }

    public final Queue getQueue() {
        Queue queue;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = Queue.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof Queue)) {
            obj = null;
        }
        Queue queue2 = (Queue) obj;
        if (queue2 != null) {
            return queue2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = Queue.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            QueueImpl queueImpl = singletons.get(name2);
            if (queueImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (queueImpl = new QueueImpl(this.logger, getQueueRunRequest$tracking_migration_release())))) != null) {
                queueImpl = objPutIfAbsent;
            }
            if (queueImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.queue.Queue");
            }
            queue = (Queue) queueImpl;
        }
        return queue;
    }

    public final QueueQueryRunner getQueueQueryRunner$tracking_migration_release() {
        QueueQueryRunner queueQueryRunner;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = QueueQueryRunner.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof QueueQueryRunner)) {
            obj = null;
        }
        QueueQueryRunner queueQueryRunner2 = (QueueQueryRunner) obj;
        if (queueQueryRunner2 != null) {
            return queueQueryRunner2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = QueueQueryRunner.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            QueueQueryRunnerImpl queueQueryRunnerImpl = singletons.get(name2);
            if (queueQueryRunnerImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (queueQueryRunnerImpl = new QueueQueryRunnerImpl(this.logger)))) != null) {
                queueQueryRunnerImpl = objPutIfAbsent;
            }
            if (queueQueryRunnerImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.queue.QueueQueryRunner");
            }
            queueQueryRunner = (QueueQueryRunner) queueQueryRunnerImpl;
        }
        return queueQueryRunner;
    }

    public final QueueRunRequest getQueueRunRequest$tracking_migration_release() {
        QueueRunRequest queueRunRequest;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = QueueRunRequest.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof QueueRunRequest)) {
            obj = null;
        }
        QueueRunRequest queueRunRequest2 = (QueueRunRequest) obj;
        if (queueRunRequest2 != null) {
            return queueRunRequest2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = QueueRunRequest.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            QueueRunRequestImpl queueRunRequestImpl = singletons.get(name2);
            if (queueRunRequestImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (queueRunRequestImpl = new QueueRunRequestImpl(getQueueRunner$tracking_migration_release(), getQueueStorage$tracking_migration_release(), this.logger, getQueueQueryRunner$tracking_migration_release())))) != null) {
                queueRunRequestImpl = objPutIfAbsent;
            }
            if (queueRunRequestImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.queue.QueueRunRequest");
            }
            queueRunRequest = (QueueRunRequest) queueRunRequestImpl;
        }
        return queueRunRequest;
    }

    public final QueueRunner getQueueRunner$tracking_migration_release() {
        QueueRunner queueRunner;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = QueueRunner.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof QueueRunner)) {
            obj = null;
        }
        QueueRunner queueRunner2 = (QueueRunner) obj;
        if (queueRunner2 != null) {
            return queueRunner2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = QueueRunner.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            QueueRunnerImpl queueRunnerImpl = singletons.get(name2);
            if (queueRunnerImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (queueRunnerImpl = new QueueRunnerImpl(getJsonAdapter$tracking_migration_release(), this.logger, this.migrationProcessor)))) != null) {
                queueRunnerImpl = objPutIfAbsent;
            }
            if (queueRunnerImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.queue.QueueRunner");
            }
            queueRunner = (QueueRunner) queueRunnerImpl;
        }
        return queueRunner;
    }

    public final QueueStorage getQueueStorage$tracking_migration_release() {
        QueueStorage queueStorage;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = QueueStorage.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof QueueStorage)) {
            obj = null;
        }
        QueueStorage queueStorage2 = (QueueStorage) obj;
        if (queueStorage2 != null) {
            return queueStorage2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = QueueStorage.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            QueueStorageImpl queueStorageImpl = singletons.get(name2);
            if (queueStorageImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (queueStorageImpl = new QueueStorageImpl(getFileStorage$tracking_migration_release(), getJsonAdapter$tracking_migration_release(), this.logger)))) != null) {
                queueStorageImpl = objPutIfAbsent;
            }
            if (queueStorageImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.queue.QueueStorage");
            }
            queueStorage = (QueueStorage) queueStorageImpl;
        }
        return queueStorage;
    }

    public final SitePreferenceRepository getSitePreferences() {
        SitePreferenceRepository sitePreferenceRepository;
        Object objPutIfAbsent;
        MigrationSDKComponent migrationSDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = migrationSDKComponent.getOverrides();
        String name = SitePreferenceRepository.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof SitePreferenceRepository)) {
            obj = null;
        }
        SitePreferenceRepository sitePreferenceRepository2 = (SitePreferenceRepository) obj;
        if (sitePreferenceRepository2 != null) {
            return sitePreferenceRepository2;
        }
        synchronized (migrationSDKComponent.getSingletons()) {
            String name2 = SitePreferenceRepository.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = migrationSDKComponent.getSingletons();
            SitePreferenceRepositoryImpl sitePreferenceRepositoryImpl = singletons.get(name2);
            if (sitePreferenceRepositoryImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (sitePreferenceRepositoryImpl = new SitePreferenceRepositoryImpl(this.applicationContext, this.migrationSiteId)))) != null) {
                sitePreferenceRepositoryImpl = objPutIfAbsent;
            }
            if (sitePreferenceRepositoryImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.tracking.migration.repository.preference.SitePreferenceRepository");
            }
            sitePreferenceRepository = (SitePreferenceRepository) sitePreferenceRepositoryImpl;
        }
        return sitePreferenceRepository;
    }
}
