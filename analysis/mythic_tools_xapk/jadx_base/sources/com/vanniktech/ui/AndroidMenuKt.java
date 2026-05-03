package com.vanniktech.ui;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AndroidMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"themeMenu", "", "Landroid/view/Menu;", "color", "Lcom/vanniktech/ui/Color;", "subMenuColor", "themeMenu-FUHGC9k", "(Landroid/view/Menu;II)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenuKt {
    /* JADX INFO: renamed from: themeMenu-FUHGC9k, reason: not valid java name */
    public static final void m11329themeMenuFUHGC9k(Menu themeMenu, int i, int i2) {
        Intrinsics.checkNotNullParameter(themeMenu, "$this$themeMenu");
        IntRange intRangeUntil = RangesKt.until(0, themeMenu.size());
        ArrayList<MenuItem> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(themeMenu.getItem(((IntIterator) it).nextInt()));
        }
        for (MenuItem menuItem : arrayList) {
            SubMenu subMenu = menuItem.getSubMenu();
            if (subMenu != null) {
                m11329themeMenuFUHGC9k(subMenu, i2, i2);
            }
            menuItem.setTitle(AndroidColorKt.m11320coloredTextyAn5nI(i, menuItem.getTitle()));
            Drawable icon = menuItem.getIcon();
            if (icon != null) {
                AndroidThemingHacksKt.m11333tintedxAbW3D8(icon, i);
            }
        }
    }
}
