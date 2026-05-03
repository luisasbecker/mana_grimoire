package io.customer.tracking.migration.queue;

import io.customer.sdk.core.util.Logger;
import io.customer.tracking.migration.MigrationProcessor;
import io.customer.tracking.migration.request.MigrationTask;
import io.customer.tracking.migration.util.JsonAdapter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueRunner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/customer/tracking/migration/queue/QueueRunnerImpl;", "Lio/customer/tracking/migration/queue/QueueRunner;", "jsonAdapter", "Lio/customer/tracking/migration/util/JsonAdapter;", "logger", "Lio/customer/sdk/core/util/Logger;", "migrationProcessor", "Lio/customer/tracking/migration/MigrationProcessor;", "<init>", "(Lio/customer/tracking/migration/util/JsonAdapter;Lio/customer/sdk/core/util/Logger;Lio/customer/tracking/migration/MigrationProcessor;)V", "runTask", "Lkotlin/Result;", "", "Lio/customer/tracking/migration/queue/QueueRunTaskResult;", "task", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueTask;", "runTask-gIAlu-s", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueueRunnerImpl implements QueueRunner {
    private final JsonAdapter jsonAdapter;
    private final Logger logger;
    private final MigrationProcessor migrationProcessor;

    public QueueRunnerImpl(JsonAdapter jsonAdapter, Logger logger, MigrationProcessor migrationProcessor) {
        Intrinsics.checkNotNullParameter(jsonAdapter, "jsonAdapter");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(migrationProcessor, "migrationProcessor");
        this.jsonAdapter = jsonAdapter;
        this.logger = logger;
        this.migrationProcessor = migrationProcessor;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // io.customer.tracking.migration.queue.QueueRunner
    /* JADX INFO: renamed from: runTask-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo11439runTaskgIAlus(JSONObject jSONObject, Continuation<? super Result<Unit>> continuation) {
        QueueRunnerImpl$runTask$1 queueRunnerImpl$runTask$1;
        if (continuation instanceof QueueRunnerImpl$runTask$1) {
            queueRunnerImpl$runTask$1 = (QueueRunnerImpl$runTask$1) continuation;
            if ((queueRunnerImpl$runTask$1.label & Integer.MIN_VALUE) != 0) {
                queueRunnerImpl$runTask$1.label -= Integer.MIN_VALUE;
            } else {
                queueRunnerImpl$runTask$1 = new QueueRunnerImpl$runTask$1(this, continuation);
            }
        }
        Object obj = queueRunnerImpl$runTask$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = queueRunnerImpl$runTask$1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return ((Result) obj).getValue();
            }
            ResultKt.throwOnFailure(obj);
            Result.Companion companion = Result.INSTANCE;
            QueueRunnerImpl queueRunnerImpl = this;
            Logger.DefaultImpls.debug$default(this.logger, "migrating task: " + jSONObject, null, 2, null);
            Object objM11440parseMigrationTaskIoAF18A = this.jsonAdapter.m11440parseMigrationTaskIoAF18A(jSONObject);
            Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11440parseMigrationTaskIoAF18A);
            if (thM11448exceptionOrNullimpl == null) {
                MigrationProcessor migrationProcessor = this.migrationProcessor;
                queueRunnerImpl$runTask$1.label = 1;
                Object objMo11435processTaskgIAlus = migrationProcessor.mo11435processTaskgIAlus((MigrationTask) objM11440parseMigrationTaskIoAF18A, queueRunnerImpl$runTask$1);
                return objMo11435processTaskgIAlus == coroutine_suspended ? coroutine_suspended : objMo11435processTaskgIAlus;
            }
            String message = thM11448exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Queue task data is invalid for " + jSONObject + ". Could not run task.";
            }
            String str = message;
            Logger.DefaultImpls.error$default(this.logger, str, null, null, 6, null);
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(new RuntimeException(str)));
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
    }
}
