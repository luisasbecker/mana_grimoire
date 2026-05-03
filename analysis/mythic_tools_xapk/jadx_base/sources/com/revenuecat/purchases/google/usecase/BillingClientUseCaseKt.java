package com.revenuecat.purchases.google.usecase;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: BillingClientUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006*\u0088\u0001\b\u0000\u0010\n\"@\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\u000b2@\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\u000b¨\u0006\u0014"}, d2 = {"MAX_RETRIES_DEFAULT", "", "RETRY_TIMER_MAX_TIME", "Lkotlin/time/Duration;", "getRETRY_TIMER_MAX_TIME", "()J", "J", "RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND", "getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND", "RETRY_TIMER_START", "ExecuteRequestOnUIThreadFunction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "", "onError", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingClientUseCaseKt {
    private static final int MAX_RETRIES_DEFAULT = 3;
    private static final long RETRY_TIMER_MAX_TIME;
    private static final long RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    private static final long RETRY_TIMER_START;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        RETRY_TIMER_START = DurationKt.toDuration(878, DurationUnit.MILLISECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        RETRY_TIMER_MAX_TIME = DurationKt.toDuration(15, DurationUnit.MINUTES);
        Duration.Companion companion3 = Duration.INSTANCE;
        RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND = DurationKt.toDuration(4, DurationUnit.SECONDS);
    }

    public static final long getRETRY_TIMER_MAX_TIME() {
        return RETRY_TIMER_MAX_TIME;
    }

    public static final long getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND() {
        return RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    }
}
