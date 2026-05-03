package com.studiolaganne.lengendarylens;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getDisplayString", "", "Lcom/studiolaganne/lengendarylens/SortBy;", "context", "Landroid/content/Context;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DataStructsKt {

    /* JADX INFO: compiled from: DataStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SortBy.values().length];
            try {
                iArr[SortBy.ADDED_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SortBy.COLLECTOR_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SortBy.NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SortBy.QUANTITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SortBy.FOIL_STATUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SortBy.SET_CODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SortBy.CONDITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SortBy.LANGUAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SortBy.PRICE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SortBy.TOTAL_PRICE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SortBy.ALTERED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SortBy.SIGNED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SortBy.MISPRINT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SortBy.PROXY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SortBy.MANA_VALUE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[SortBy.RARITY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getDisplayString(SortBy sortBy, Context context) {
        Intrinsics.checkNotNullParameter(sortBy, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        switch (WhenMappings.$EnumSwitchMapping$0[sortBy.ordinal()]) {
            case 1:
                String string = context.getString(R.string.sort_added_date);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = context.getString(R.string.sort_collector_number);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = context.getString(R.string.sort_name);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = context.getString(R.string.sort_quantity);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = context.getString(R.string.sort_foil_status);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = context.getString(R.string.sort_set_code);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = context.getString(R.string.sort_condition);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 8:
                String string8 = context.getString(R.string.sort_language);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 9:
                String string9 = context.getString(R.string.sort_price);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            case 10:
                String string10 = context.getString(R.string.sort_total_price);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 11:
                String string11 = context.getString(R.string.sort_altered);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            case 12:
                String string12 = context.getString(R.string.sort_signed);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                return string12;
            case 13:
                String string13 = context.getString(R.string.sort_misprint);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return string13;
            case 14:
                String string14 = context.getString(R.string.sort_proxy);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                return string14;
            case 15:
                String string15 = context.getString(R.string.sort_mana_value);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                return string15;
            case 16:
                String string16 = context.getString(R.string.sort_rarity);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                return string16;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
