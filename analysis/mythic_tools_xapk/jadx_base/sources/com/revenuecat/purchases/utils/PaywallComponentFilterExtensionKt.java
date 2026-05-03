package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallComponentFilterExtension.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\u0006"}, d2 = {"filter", "", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "predicate", "Lkotlin/Function1;", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallComponentFilterExtensionKt {
    public static final List<PaywallComponent> filter(PaywallComponent paywallComponent, Function1<? super PaywallComponent, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(paywallComponent, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(paywallComponent);
        while (!arrayDeque.isEmpty()) {
            PaywallComponent paywallComponent2 = (PaywallComponent) arrayDeque.removeFirst();
            if (predicate.invoke(paywallComponent2).booleanValue()) {
                arrayList.add(paywallComponent2);
            }
            if (paywallComponent2 instanceof StackComponent) {
                arrayDeque.addAll(((StackComponent) paywallComponent2).getComponents());
            } else if (paywallComponent2 instanceof PurchaseButtonComponent) {
                arrayDeque.add(((PurchaseButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof ButtonComponent) {
                arrayDeque.add(((ButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof PackageComponent) {
                arrayDeque.add(((PackageComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof HeaderComponent) {
                arrayDeque.add(((HeaderComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof StickyFooterComponent) {
                arrayDeque.add(((StickyFooterComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof CarouselComponent) {
                arrayDeque.addAll(((CarouselComponent) paywallComponent2).getPages());
            } else if (paywallComponent2 instanceof TabControlButtonComponent) {
                arrayDeque.add(((TabControlButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof TabsComponent) {
                TabsComponent tabsComponent = (TabsComponent) paywallComponent2;
                TabsComponent.TabControl control = tabsComponent.getControl();
                if (control instanceof TabsComponent.TabControl.Buttons) {
                    arrayDeque.add(((TabsComponent.TabControl.Buttons) control).getStack());
                } else if (control instanceof TabsComponent.TabControl.Toggle) {
                    arrayDeque.add(((TabsComponent.TabControl.Toggle) control).getStack());
                }
                List tabs = tabsComponent.getTabs();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(tabs, 10));
                Iterator it = tabs.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((TabsComponent.Tab) it.next()).getStack());
                }
                arrayDeque.addAll(arrayList2);
            } else if (paywallComponent2 instanceof TimelineComponent) {
                List<TimelineComponent.Item> items = ((TimelineComponent) paywallComponent2).getItems();
                ArrayList arrayList3 = new ArrayList();
                for (TimelineComponent.Item item : items) {
                    CollectionsKt.addAll(arrayList3, CollectionsKt.listOfNotNull((Object[]) new PaywallComponent[]{item.getTitle(), item.getDescription(), item.getIcon()}));
                }
                arrayDeque.addAll(arrayList3);
            } else if (paywallComponent2 instanceof CountdownComponent) {
                CountdownComponent countdownComponent = (CountdownComponent) paywallComponent2;
                arrayDeque.add(countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                if (endStack != null) {
                    arrayDeque.add(endStack);
                }
                StackComponent fallback = countdownComponent.getFallback();
                if (fallback != null) {
                    arrayDeque.add(fallback);
                }
            } else if (!(paywallComponent2 instanceof FallbackHeaderComponent ? true : paywallComponent2 instanceof VideoComponent ? true : paywallComponent2 instanceof TabControlToggleComponent ? true : paywallComponent2 instanceof TabControlComponent ? true : paywallComponent2 instanceof ImageComponent ? true : paywallComponent2 instanceof IconComponent)) {
                boolean z = paywallComponent2 instanceof TextComponent;
            }
        }
        return arrayList;
    }
}
