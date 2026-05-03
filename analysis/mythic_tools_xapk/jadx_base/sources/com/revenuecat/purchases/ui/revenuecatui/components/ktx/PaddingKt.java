package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PaddingKt {
    public static final /* synthetic */ PaddingValues toPaddingValues(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "<this>");
        return androidx.compose.foundation.layout.PaddingKt.m2033PaddingValuesa9UjIt4(Dp.m9114constructorimpl((float) padding.getLeading()), Dp.m9114constructorimpl((float) padding.getTop()), Dp.m9114constructorimpl((float) padding.getTrailing()), Dp.m9114constructorimpl((float) padding.getBottom()));
    }
}
