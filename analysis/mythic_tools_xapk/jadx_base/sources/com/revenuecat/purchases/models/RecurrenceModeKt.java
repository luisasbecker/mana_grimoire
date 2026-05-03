package com.revenuecat.purchases.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecurrenceMode.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toRecurrenceMode", "Lcom/revenuecat/purchases/models/RecurrenceMode;", "", "(Ljava/lang/Integer;)Lcom/revenuecat/purchases/models/RecurrenceMode;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RecurrenceModeKt {
    public static final RecurrenceMode toRecurrenceMode(Integer num) {
        RecurrenceMode recurrenceMode;
        RecurrenceMode[] recurrenceModeArrValues = RecurrenceMode.values();
        int length = recurrenceModeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                recurrenceMode = null;
                break;
            }
            recurrenceMode = recurrenceModeArrValues[i];
            if (Intrinsics.areEqual(recurrenceMode.getIdentifier(), num)) {
                break;
            }
            i++;
        }
        return recurrenceMode == null ? RecurrenceMode.UNKNOWN : recurrenceMode;
    }
}
