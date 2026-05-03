package io.customer.tracking.migration;

import io.customer.tracking.migration.request.MigrationTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MigrationProcessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/customer/tracking/migration/MigrationProcessor;", "", "processProfileMigration", "Lkotlin/Result;", "", "identifier", "", "processProfileMigration-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "processDeviceMigration", "oldDeviceToken", "processDeviceMigration-IoAF18A", "processTask", "task", "Lio/customer/tracking/migration/request/MigrationTask;", "processTask-gIAlu-s", "(Lio/customer/tracking/migration/request/MigrationTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MigrationProcessor {
    /* JADX INFO: renamed from: processDeviceMigration-IoAF18A */
    Object mo11433processDeviceMigrationIoAF18A(String oldDeviceToken);

    /* JADX INFO: renamed from: processProfileMigration-IoAF18A */
    Object mo11434processProfileMigrationIoAF18A(String identifier);

    /* JADX INFO: renamed from: processTask-gIAlu-s */
    Object mo11435processTaskgIAlus(MigrationTask migrationTask, Continuation<? super Result<Unit>> continuation);
}
