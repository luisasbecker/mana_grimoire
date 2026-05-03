package io.customer.sdk.core.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CioLogLevel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lio/customer/sdk/core/util/CioLogLevel;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "NONE", "ERROR", "INFO", "DEBUG", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CioLogLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CioLogLevel[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final CioLogLevel DEBUG;
    private static final CioLogLevel DEFAULT;
    public static final CioLogLevel ERROR;
    public static final CioLogLevel INFO;
    public static final CioLogLevel NONE = new CioLogLevel("NONE", 0, 0);
    private final int priority;

    /* JADX INFO: compiled from: CioLogLevel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lio/customer/sdk/core/util/CioLogLevel$Companion;", "", "<init>", "()V", "DEFAULT", "Lio/customer/sdk/core/util/CioLogLevel;", "getDEFAULT", "()Lio/customer/sdk/core/util/CioLogLevel;", "getLogLevel", FirebaseAnalytics.Param.LEVEL, "", "fallback", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CioLogLevel getLogLevel$default(Companion companion, String str, CioLogLevel cioLogLevel, int i, Object obj) {
            if ((i & 2) != 0) {
                cioLogLevel = companion.getDEFAULT();
            }
            return companion.getLogLevel(str, cioLogLevel);
        }

        public final CioLogLevel getDEFAULT() {
            return CioLogLevel.DEFAULT;
        }

        public final CioLogLevel getLogLevel(String level, CioLogLevel fallback) {
            CioLogLevel cioLogLevel;
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            CioLogLevel[] cioLogLevelArrValues = CioLogLevel.values();
            int length = cioLogLevelArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    cioLogLevel = null;
                    break;
                }
                cioLogLevel = cioLogLevelArrValues[i];
                if (StringsKt.equals(cioLogLevel.name(), level, true)) {
                    break;
                }
                i++;
            }
            return cioLogLevel == null ? fallback : cioLogLevel;
        }
    }

    private static final /* synthetic */ CioLogLevel[] $values() {
        return new CioLogLevel[]{NONE, ERROR, INFO, DEBUG};
    }

    static {
        CioLogLevel cioLogLevel = new CioLogLevel("ERROR", 1, 1);
        ERROR = cioLogLevel;
        INFO = new CioLogLevel("INFO", 2, 2);
        DEBUG = new CioLogLevel("DEBUG", 3, 3);
        CioLogLevel[] cioLogLevelArr$values = $values();
        $VALUES = cioLogLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cioLogLevelArr$values);
        INSTANCE = new Companion(null);
        DEFAULT = cioLogLevel;
    }

    private CioLogLevel(String str, int i, int i2) {
        this.priority = i2;
    }

    public static EnumEntries<CioLogLevel> getEntries() {
        return $ENTRIES;
    }

    public static CioLogLevel valueOf(String str) {
        return (CioLogLevel) Enum.valueOf(CioLogLevel.class, str);
    }

    public static CioLogLevel[] values() {
        return (CioLogLevel[]) $VALUES.clone();
    }

    public final int getPriority() {
        return this.priority;
    }
}
