package com.studiolaganne.lengendarylens;

import android.content.Context;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ServerUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fJ0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ServerUtils;", "", "<init>", "()V", "parseAndFormatTimestamp", "", DiagnosticsEntry.TIMESTAMP_KEY, "formatRelativeTimestamp", "context", "Landroid/content/Context;", "formatDurationSeconds", "durationInSeconds", "", "formatDuration", "durationInMinutes", "startedAt", "endedAt", "pauseTimeSeconds", "includeHours", "", "getDurationSeconds", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ServerUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ServerUtils instance;

    /* JADX INFO: compiled from: ServerUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/ServerUtils$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/ServerUtils;", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized ServerUtils getInstance() {
            ServerUtils serverUtils;
            if (ServerUtils.instance == null) {
                ServerUtils.instance = new ServerUtils();
            }
            serverUtils = ServerUtils.instance;
            Intrinsics.checkNotNull(serverUtils);
            return serverUtils;
        }
    }

    public static /* synthetic */ String formatDuration$default(ServerUtils serverUtils, Context context, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = true;
        }
        return serverUtils.formatDuration(context, str, str2, i, z);
    }

    public final String formatDuration(Context context, int durationInMinutes) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = durationInMinutes / 60;
        int i2 = durationInMinutes % 60;
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            sb.append(i).append(" ").append(context.getResources().getQuantityString(R.plurals.hours, i, Integer.valueOf(i)));
        }
        if (i2 > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(i2).append(" ").append(context.getResources().getQuantityString(R.plurals.minutes, i2, Integer.valueOf(i2)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String formatDuration(Context context, String startedAt, String endedAt, int pauseTimeSeconds, boolean includeHours) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(startedAt, "startedAt");
        Intrinsics.checkNotNullParameter(endedAt, "endedAt");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        Duration durationMinusSeconds = Duration.between(ZonedDateTime.parse(startedAt, dateTimeFormatter), ZonedDateTime.parse(endedAt, dateTimeFormatter)).minusSeconds(pauseTimeSeconds);
        long hours = durationMinusSeconds.toHours();
        long minutes = durationMinusSeconds.toMinutes() % 60;
        StringBuilder sb = new StringBuilder();
        if (includeHours && hours > 0) {
            StringBuilder sbAppend = sb.append(hours).append(" ");
            int i = (int) hours;
            sbAppend.append(context.getResources().getQuantityString(R.plurals.hours, i, Integer.valueOf(i)));
        }
        if (minutes > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            int i2 = (int) minutes;
            sb.append(minutes).append(" ").append(context.getResources().getQuantityString(R.plurals.minutes, i2, Integer.valueOf(i2)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String formatDurationSeconds(int durationInSeconds) {
        int i = durationInSeconds / 60;
        int i2 = durationInSeconds % 60;
        if (i > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02dm %02ds", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%02ds", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [java.time.ZonedDateTime] */
    public final String formatRelativeTimestamp(String timestamp, Context context) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(context, "context");
        ?? WithZoneSameInstant = ZonedDateTime.parse(timestamp, DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"))).withZoneSameInstant(ZoneId.systemDefault());
        long jBetween = ChronoUnit.DAYS.between(WithZoneSameInstant.toLocalDate(), ZonedDateTime.now(ZoneId.systemDefault()).toLocalDate());
        if (jBetween == 0) {
            String string = context.getString(R.string.today);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (jBetween == 1) {
            String string2 = context.getString(R.string.yesterday);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (2 > jBetween || jBetween >= 7) {
            String str = WithZoneSameInstant.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        String str2 = WithZoneSameInstant.format(DateTimeFormatter.ofPattern("EEEE"));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final int getDurationSeconds(String startedAt, String endedAt, int pauseTimeSeconds) {
        Intrinsics.checkNotNullParameter(startedAt, "startedAt");
        Intrinsics.checkNotNullParameter(endedAt, "endedAt");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        return ((int) Duration.between(ZonedDateTime.parse(startedAt, dateTimeFormatter), ZonedDateTime.parse(endedAt, dateTimeFormatter)).getSeconds()) - pauseTimeSeconds;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [java.time.ZonedDateTime] */
    public final String parseAndFormatTimestamp(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        String str = ZonedDateTime.parse(timestamp, DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"))).withZoneSameInstant(ZoneId.systemDefault()).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.getDefault()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
