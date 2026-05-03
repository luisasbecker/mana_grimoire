package com.studiolaganne.lengendarylens;

import android.content.Context;
import com.revenuecat.purchases.common.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/Operator;", "", "symbol", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", "CONTAINS", "EQUAL", "NOT_EQUAL", "LESS_THAN", "LESS_THAN_OR_EQUAL", "GREATER_THAN", "GREATER_THAN_OR_EQUAL", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Operator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Operator[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String symbol;
    public static final Operator CONTAINS = new Operator("CONTAINS", 0, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
    public static final Operator EQUAL = new Operator("EQUAL", 1, "=");
    public static final Operator NOT_EQUAL = new Operator("NOT_EQUAL", 2, "!=");
    public static final Operator LESS_THAN = new Operator("LESS_THAN", 3, "<");
    public static final Operator LESS_THAN_OR_EQUAL = new Operator("LESS_THAN_OR_EQUAL", 4, "<=");
    public static final Operator GREATER_THAN = new Operator("GREATER_THAN", 5, ">");
    public static final Operator GREATER_THAN_OR_EQUAL = new Operator("GREATER_THAN_OR_EQUAL", 6, ">=");

    /* JADX INFO: compiled from: SearchData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/Operator$Companion;", "", "<init>", "()V", "fromString", "Lcom/studiolaganne/lengendarylens/Operator;", "value", "", "operatorDisplayName", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: SearchData.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Operator.values().length];
                try {
                    iArr[Operator.CONTAINS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Operator.EQUAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Operator.NOT_EQUAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Operator.LESS_THAN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Operator.LESS_THAN_OR_EQUAL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Operator.GREATER_THAN.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Operator fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (Operator operator : Operator.values()) {
                if (Intrinsics.areEqual(operator.getSymbol(), value)) {
                    return operator;
                }
            }
            return null;
        }

        public final String operatorDisplayName(Operator value, Context context) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(context, "context");
            switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
                case 1:
                    String string = context.getResources().getString(R.string.op_contains);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                case 2:
                    String string2 = context.getResources().getString(R.string.op_equal);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    return string2;
                case 3:
                    String string3 = context.getResources().getString(R.string.op_not_equal);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    return string3;
                case 4:
                    String string4 = context.getResources().getString(R.string.op_less_than);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    return string4;
                case 5:
                    String string5 = context.getResources().getString(R.string.op_less_than_or_equal);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    return string5;
                case 6:
                    String string6 = context.getResources().getString(R.string.op_greater_than);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    return string6;
                case 7:
                    String string7 = context.getResources().getString(R.string.op_greater_than_or_equal);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    return string7;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    private static final /* synthetic */ Operator[] $values() {
        return new Operator[]{CONTAINS, EQUAL, NOT_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL};
    }

    static {
        Operator[] operatorArr$values = $values();
        $VALUES = operatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(operatorArr$values);
        INSTANCE = new Companion(null);
    }

    private Operator(String str, int i, String str2) {
        this.symbol = str2;
    }

    public static EnumEntries<Operator> getEntries() {
        return $ENTRIES;
    }

    public static Operator valueOf(String str) {
        return (Operator) Enum.valueOf(Operator.class, str);
    }

    public static Operator[] values() {
        return (Operator[]) $VALUES.clone();
    }

    public final String getSymbol() {
        return this.symbol;
    }
}
