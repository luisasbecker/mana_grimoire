package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HorizontalStack.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJc\u0010\u001c\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2F\u0010\u001f\u001aB\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\t0 ¢\u0006\u0002\b\n¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\b\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/HorizontalStackScopeImpl;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/HorizontalStackScope;", "distribution", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "spacing", "Landroidx/compose/ui/unit/Dp;", "fillSpaceSpacer", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "width", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "(Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;FLkotlin/jvm/functions/Function3;Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Lkotlin/jvm/functions/Function3;", "hasAnyItemsWithFillWidth", "", "rowContent", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "getRowContent", "()Lkotlin/jvm/functions/Function3;", "setRowContent", "(Lkotlin/jvm/functions/Function3;)V", "shouldApplyFillSpacers", "getShouldApplyFillSpacers", "()Z", "F", FirebaseAnalytics.Param.ITEMS, "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "itemContent", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "item", "(Ljava/util/List;Lkotlin/jvm/functions/Function5;)V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HorizontalStackScopeImpl implements HorizontalStackScope {
    private final FlexDistribution distribution;
    private final Function3<Float, Composer, Integer, Unit> fillSpaceSpacer;
    private boolean hasAnyItemsWithFillWidth;
    private Function3<? super RowScope, ? super Composer, ? super Integer, Unit> rowContent;
    private final float spacing;
    private final SizeConstraint width;

    /* JADX WARN: Multi-variable type inference failed */
    private HorizontalStackScopeImpl(FlexDistribution distribution, float f, Function3<? super Float, ? super Composer, ? super Integer, Unit> fillSpaceSpacer, SizeConstraint width) {
        Intrinsics.checkNotNullParameter(distribution, "distribution");
        Intrinsics.checkNotNullParameter(fillSpaceSpacer, "fillSpaceSpacer");
        Intrinsics.checkNotNullParameter(width, "width");
        this.distribution = distribution;
        this.spacing = f;
        this.fillSpaceSpacer = fillSpaceSpacer;
        this.width = width;
        this.rowContent = ComposableSingletons$HorizontalStackKt.INSTANCE.m10561getLambda1$revenuecatui_defaultsBc8Release();
    }

    public /* synthetic */ HorizontalStackScopeImpl(FlexDistribution flexDistribution, float f, Function3 function3, SizeConstraint sizeConstraint, DefaultConstructorMarker defaultConstructorMarker) {
        this(flexDistribution, f, function3, sizeConstraint);
    }

    public final Function3<RowScope, Composer, Integer, Unit> getRowContent() {
        return this.rowContent;
    }

    public final boolean getShouldApplyFillSpacers() {
        return (Intrinsics.areEqual(this.width, SizeConstraint.Fit.INSTANCE) || this.hasAnyItemsWithFillWidth) ? false : true;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.stack.HorizontalStackScope
    public void items(final List<? extends ComponentStyle> items, final Function5<? super RowScope, ? super Integer, ? super ComponentStyle, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        List<? extends ComponentStyle> list = items;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((ComponentStyle) it.next()).getSize().getWidth(), SizeConstraint.Fill.INSTANCE)) {
                    z = true;
                    break;
                }
            }
        }
        this.hasAnyItemsWithFillWidth = z;
        this.rowContent = ComposableLambdaKt.composableLambdaInstance(1239185597, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.HorizontalStackScopeImpl.items.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                invoke(rowScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope rowScope, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(rowScope, "$this$null");
                ComposerKt.sourceInformation(composer, "C*98@3783L24:HorizontalStack.kt#280jdz");
                if ((i & 6) == 0) {
                    i |= composer.changed(rowScope) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1239185597, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.HorizontalStackScopeImpl.items.<anonymous> (HorizontalStack.kt:96)");
                }
                List<ComponentStyle> list2 = items;
                Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit> function5 = itemContent;
                HorizontalStackScopeImpl horizontalStackScopeImpl = this;
                int i2 = 0;
                for (Object obj : list2) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ComponentStyle componentStyle = (ComponentStyle) obj;
                    boolean z2 = i2 == list2.size() - 1;
                    RowScope rowScope2 = rowScope;
                    Composer composer2 = composer;
                    function5.invoke(rowScope2, Integer.valueOf(i2), componentStyle, composer2, Integer.valueOf(i & 14));
                    composer2.startReplaceGroup(-855017870);
                    ComposerKt.sourceInformation(composer2, "101@3898L50,103@4023L78");
                    if (StackComponentViewKt.getUsesAllAvailableSpace(horizontalStackScopeImpl.distribution) && !z2) {
                        SpacerKt.Spacer(SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, horizontalStackScopeImpl.spacing, 0.0f, 2, null), composer2, 0);
                        if (horizontalStackScopeImpl.getShouldApplyFillSpacers()) {
                            horizontalStackScopeImpl.fillSpaceSpacer.invoke(Float.valueOf(horizontalStackScopeImpl.distribution == FlexDistribution.SPACE_AROUND ? 2.0f : 1.0f), composer2, 0);
                        }
                    }
                    composer2.endReplaceGroup();
                    rowScope = rowScope2;
                    composer = composer2;
                    i2 = i3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    public final void setRowContent(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.rowContent = function3;
    }
}
