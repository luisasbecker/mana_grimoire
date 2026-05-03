package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: HorizontalStack.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001Jc\u0010\u0002\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042F\u0010\u0006\u001aB\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/HorizontalStackScope;", "", FirebaseAnalytics.Param.ITEMS, "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "itemContent", "Lkotlin/Function3;", "Landroidx/compose/foundation/layout/RowScope;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "item", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/List;Lkotlin/jvm/functions/Function5;)V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HorizontalStackScope {
    void items(List<? extends ComponentStyle> items, Function5<? super RowScope, ? super Integer, ? super ComponentStyle, ? super Composer, ? super Integer, Unit> itemContent);
}
