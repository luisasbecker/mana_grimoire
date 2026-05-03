package com.segment.analytics.kotlin.core.platform.plugins.logger;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogMessage;", "", "kind", "Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogKind;", "message", "", "dateTime", "Ljava/util/Date;", "(Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogKind;Ljava/lang/String;Ljava/util/Date;)V", "getDateTime", "()Ljava/util/Date;", "getKind", "()Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogKind;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogMessage {
    private final Date dateTime;
    private final LogKind kind;
    private final String message;

    public LogMessage(LogKind kind, String message, Date dateTime) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        this.kind = kind;
        this.message = message;
        this.dateTime = dateTime;
    }

    public /* synthetic */ LogMessage(LogKind logKind, String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(logKind, str, (i & 4) != 0 ? new Date() : date);
    }

    public static /* synthetic */ LogMessage copy$default(LogMessage logMessage, LogKind logKind, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            logKind = logMessage.kind;
        }
        if ((i & 2) != 0) {
            str = logMessage.message;
        }
        if ((i & 4) != 0) {
            date = logMessage.dateTime;
        }
        return logMessage.copy(logKind, str, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LogKind getKind() {
        return this.kind;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getDateTime() {
        return this.dateTime;
    }

    public final LogMessage copy(LogKind kind, String message, Date dateTime) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        return new LogMessage(kind, message, dateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogMessage)) {
            return false;
        }
        LogMessage logMessage = (LogMessage) other;
        return this.kind == logMessage.kind && Intrinsics.areEqual(this.message, logMessage.message) && Intrinsics.areEqual(this.dateTime, logMessage.dateTime);
    }

    public final Date getDateTime() {
        return this.dateTime;
    }

    public final LogKind getKind() {
        return this.kind;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.kind.hashCode() * 31) + this.message.hashCode()) * 31) + this.dateTime.hashCode();
    }

    public String toString() {
        return "LogMessage(kind=" + this.kind + ", message=" + this.message + ", dateTime=" + this.dateTime + ')';
    }
}
