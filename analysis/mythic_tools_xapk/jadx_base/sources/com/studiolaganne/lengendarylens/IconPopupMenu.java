package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconPopupMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JM\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015JO\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0000J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/IconPopupMenu;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "entries", "", "Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry;", "addItem", Constants.GP_IAP_TITLE, "", "faIcon", "destructive", "", "showBadge", "customColor", "", "onClick", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/studiolaganne/lengendarylens/IconPopupMenu;", "titleRes", "(ILjava/lang/String;ZZLjava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/studiolaganne/lengendarylens/IconPopupMenu;", "addDivider", "show", "anchor", "Landroid/view/View;", "Entry", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IconPopupMenu {
    public static final int $stable = 8;
    private final Context context;
    private final List<Entry> entries;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: IconPopupMenu.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry;", "", "<init>", "()V", "Item", "Divider", "Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry$Divider;", "Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry$Item;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static abstract class Entry {

        /* JADX INFO: compiled from: IconPopupMenu.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry$Divider;", "Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Divider extends Entry {
            public static final int $stable = 0;
            public static final Divider INSTANCE = new Divider();

            private Divider() {
                super(null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Divider)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1578272757;
            }

            public String toString() {
                return "Divider";
            }
        }

        /* JADX INFO: compiled from: IconPopupMenu.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JT\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry$Item;", "Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry;", "faIcon", "", Constants.GP_IAP_TITLE, "destructive", "", "showBadge", "customColor", "", "onClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "getFaIcon", "()Ljava/lang/String;", "getTitle", "getDestructive", "()Z", "getShowBadge", "getCustomColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/studiolaganne/lengendarylens/IconPopupMenu$Entry$Item;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Item extends Entry {
            public static final int $stable = 0;
            private final Integer customColor;
            private final boolean destructive;
            private final String faIcon;
            private final Function0<Unit> onClick;
            private final boolean showBadge;
            private final String title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(String str, String title, boolean z, boolean z2, Integer num, Function0<Unit> onClick) {
                super(null);
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(onClick, "onClick");
                this.faIcon = str;
                this.title = title;
                this.destructive = z;
                this.showBadge = z2;
                this.customColor = num;
                this.onClick = onClick;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Item copy$default(Item item, String str, String str2, boolean z, boolean z2, Integer num, Function0 function0, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.faIcon;
                }
                if ((i & 2) != 0) {
                    str2 = item.title;
                }
                if ((i & 4) != 0) {
                    z = item.destructive;
                }
                if ((i & 8) != 0) {
                    z2 = item.showBadge;
                }
                if ((i & 16) != 0) {
                    num = item.customColor;
                }
                if ((i & 32) != 0) {
                    function0 = item.onClick;
                }
                Integer num2 = num;
                Function0 function02 = function0;
                return item.copy(str, str2, z, z2, num2, function02);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFaIcon() {
                return this.faIcon;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getDestructive() {
                return this.destructive;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getShowBadge() {
                return this.showBadge;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Integer getCustomColor() {
                return this.customColor;
            }

            public final Function0<Unit> component6() {
                return this.onClick;
            }

            public final Item copy(String faIcon, String title, boolean destructive, boolean showBadge, Integer customColor, Function0<Unit> onClick) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(onClick, "onClick");
                return new Item(faIcon, title, destructive, showBadge, customColor, onClick);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics.areEqual(this.faIcon, item.faIcon) && Intrinsics.areEqual(this.title, item.title) && this.destructive == item.destructive && this.showBadge == item.showBadge && Intrinsics.areEqual(this.customColor, item.customColor) && Intrinsics.areEqual(this.onClick, item.onClick);
            }

            public final Integer getCustomColor() {
                return this.customColor;
            }

            public final boolean getDestructive() {
                return this.destructive;
            }

            public final String getFaIcon() {
                return this.faIcon;
            }

            public final Function0<Unit> getOnClick() {
                return this.onClick;
            }

            public final boolean getShowBadge() {
                return this.showBadge;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                String str = this.faIcon;
                int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.destructive)) * 31) + Boolean.hashCode(this.showBadge)) * 31;
                Integer num = this.customColor;
                return ((iHashCode + (num != null ? num.hashCode() : 0)) * 31) + this.onClick.hashCode();
            }

            public String toString() {
                return "Item(faIcon=" + this.faIcon + ", title=" + this.title + ", destructive=" + this.destructive + ", showBadge=" + this.showBadge + ", customColor=" + this.customColor + ", onClick=" + this.onClick + ")";
            }
        }

        private Entry() {
        }

        public /* synthetic */ Entry(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IconPopupMenu(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.entries = new ArrayList();
    }

    public static /* synthetic */ IconPopupMenu addItem$default(IconPopupMenu iconPopupMenu, int i, String str, boolean z, boolean z2, Integer num, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        if ((i2 & 16) != 0) {
            num = null;
        }
        return iconPopupMenu.addItem(i, str, z, z2, num, (Function0<Unit>) function0);
    }

    public static /* synthetic */ IconPopupMenu addItem$default(IconPopupMenu iconPopupMenu, String str, String str2, boolean z, boolean z2, Integer num, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            num = null;
        }
        return iconPopupMenu.addItem(str, str2, z, z2, num, (Function0<Unit>) function0);
    }

    static final int show$lambda$0(IconPopupMenu iconPopupMenu, float f) {
        return (int) TypedValue.applyDimension(1, f, iconPopupMenu.context.getResources().getDisplayMetrics());
    }

    static final void show$lambda$9(Entry entry, PopupWindow popupWindow, View view) {
        ((Entry.Item) entry).getOnClick().invoke();
        popupWindow.dismiss();
    }

    public final IconPopupMenu addDivider() {
        this.entries.add(Entry.Divider.INSTANCE);
        return this;
    }

    public final IconPopupMenu addItem(int titleRes, String faIcon, boolean destructive, boolean showBadge, Integer customColor, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        List<Entry> list = this.entries;
        String string = this.context.getString(titleRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        list.add(new Entry.Item(faIcon, string, destructive, showBadge, customColor, onClick));
        return this;
    }

    public final IconPopupMenu addItem(String title, String faIcon, boolean destructive, boolean showBadge, Integer customColor, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.entries.add(new Entry.Item(faIcon, title, destructive, showBadge, customColor, onClick));
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void show(View anchor) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        Typeface typeface;
        byte b;
        Entry.Item item;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.IconPopupMenu$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(IconPopupMenu.show$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        };
        int color = ContextCompat.getColor(this.context, R.color.text_color_opaque);
        int color2 = ContextCompat.getColor(this.context, R.color.loser_red);
        List<Entry> list = this.entries;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            for (Entry entry : list) {
                if ((entry instanceof Entry.Item) && ((Entry.Item) entry).getFaIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        Typeface font = ResourcesCompat.getFont(this.context, R.font.be_vietnam_pro_semibold);
        Typeface font2 = ResourcesCompat.getFont(this.context, R.font.fa6solid);
        int iIntValue = ((Number) function1.invoke(Float.valueOf(280.0f))).intValue();
        int iIntValue2 = ((Number) function1.invoke(Float.valueOf(28.0f))).intValue();
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(linearLayout.getContext(), R.color.background_color));
        gradientDrawable.setCornerRadius(((Number) function1.invoke(Float.valueOf(20.0f))).intValue());
        gradientDrawable.setStroke(2, ContextCompat.getColor(linearLayout.getContext(), R.color.text_color_very_transparent));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(0, ((Number) function1.invoke(Float.valueOf(8.0f))).intValue(), 0, ((Number) function1.invoke(Float.valueOf(8.0f))).intValue());
        linearLayout.setElevation(((Number) function1.invoke(Float.valueOf(8.0f))).intValue());
        final PopupWindow popupWindow = new PopupWindow(this.context);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(((Number) function1.invoke(Float.valueOf(8.0f))).intValue());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        for (final Entry entry2 : this.entries) {
            if (entry2 instanceof Entry.Item) {
                LinearLayout linearLayout2 = new LinearLayout(this.context);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(16);
                i = color;
                i2 = color2;
                z2 = z;
                linearLayout2.setPadding(((Number) function1.invoke(Float.valueOf(16.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(12.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(24.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(12.0f))).intValue());
                TypedArray typedArrayObtainStyledAttributes = linearLayout2.getContext().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
                Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
                linearLayout2.setForeground(typedArrayObtainStyledAttributes.getDrawable(0));
                typedArrayObtainStyledAttributes.recycle();
                linearLayout2.setClickable(true);
                linearLayout2.setFocusable(true);
                Entry.Item item2 = (Entry.Item) entry2;
                Integer customColor = item2.getCustomColor();
                int iIntValue3 = customColor != null ? customColor.intValue() : item2.getDestructive() ? i2 : i;
                if (item2.getFaIcon() != null) {
                    TextView textView = new TextView(this.context);
                    textView.setText(item2.getFaIcon());
                    textView.setTypeface(font2);
                    textView.setTextSize(16.0f);
                    textView.setTextColor(iIntValue3);
                    textView.setGravity(17);
                    item = item2;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iIntValue2, -2);
                    layoutParams.setMarginEnd(((Number) function1.invoke(Float.valueOf(12.0f))).intValue());
                    textView.setLayoutParams(layoutParams);
                    linearLayout2.addView(textView);
                } else {
                    item = item2;
                    if (z2) {
                        View view = new View(this.context);
                        typeface = font2;
                        view.setLayoutParams(new LinearLayout.LayoutParams(((Number) function1.invoke(Float.valueOf(12.0f))).intValue() + iIntValue2, 0));
                        linearLayout2.addView(view);
                    }
                    TextView textView2 = new TextView(this.context);
                    textView2.setText(item.getTitle());
                    textView2.setTextColor(iIntValue3);
                    textView2.setTextSize(16.0f);
                    textView2.setTypeface(font);
                    linearLayout2.addView(textView2);
                    if (item.getShowBadge()) {
                        int iIntValue4 = ((Number) function1.invoke(Float.valueOf(10.0f))).intValue();
                        View view2 = new View(this.context);
                        view2.setBackgroundResource(R.drawable.badge_dot);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iIntValue4, iIntValue4);
                        layoutParams2.setMarginStart(((Number) function1.invoke(Float.valueOf(8.0f))).intValue());
                        view2.setLayoutParams(layoutParams2);
                        linearLayout2.addView(view2);
                    }
                    linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.IconPopupMenu$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            IconPopupMenu.show$lambda$9(entry2, popupWindow, view3);
                        }
                    });
                    b = -2;
                    linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
                }
                typeface = font2;
                TextView textView22 = new TextView(this.context);
                textView22.setText(item.getTitle());
                textView22.setTextColor(iIntValue3);
                textView22.setTextSize(16.0f);
                textView22.setTypeface(font);
                linearLayout2.addView(textView22);
                if (item.getShowBadge()) {
                }
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.IconPopupMenu$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        IconPopupMenu.show$lambda$9(entry2, popupWindow, view3);
                    }
                });
                b = -2;
                linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            } else {
                i = color;
                i2 = color2;
                z2 = z;
                typeface = font2;
                b = -2;
                if (!(entry2 instanceof Entry.Divider)) {
                    throw new NoWhenBranchMatchedException();
                }
                View view3 = new View(this.context);
                view3.setBackgroundColor(ContextCompat.getColor(view3.getContext(), R.color.separator_grey));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, ((Number) function1.invoke(Float.valueOf(1.0f))).intValue());
                layoutParams3.topMargin = ((Number) function1.invoke(Float.valueOf(4.0f))).intValue();
                layoutParams3.bottomMargin = ((Number) function1.invoke(Float.valueOf(4.0f))).intValue();
                layoutParams3.setMarginStart(((Number) function1.invoke(Float.valueOf(16.0f))).intValue());
                layoutParams3.setMarginEnd(((Number) function1.invoke(Float.valueOf(16.0f))).intValue());
                view3.setLayoutParams(layoutParams3);
                linearLayout.addView(view3);
            }
            font2 = typeface;
            color = i;
            z = z2;
            color2 = i2;
        }
        popupWindow.setContentView(linearLayout);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(iIntValue, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = linearLayout.getMeasuredHeight();
        popupWindow.setWidth(measuredWidth);
        popupWindow.setHeight(measuredHeight);
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = this.context.getResources().getDisplayMetrics().heightPixels;
        int i6 = this.context.getResources().getDisplayMetrics().widthPixels;
        int iIntValue5 = ((Number) function1.invoke(Float.valueOf(8.0f))).intValue();
        int i7 = measuredHeight + iIntValue5;
        int height = i5 - (anchor.getHeight() + i4) >= i7 ? i4 + anchor.getHeight() : i4 >= i7 ? i4 - measuredHeight : (i5 - measuredHeight) - iIntValue5;
        int width = (i3 + anchor.getWidth()) - measuredWidth;
        if (width < iIntValue5) {
            width = iIntValue5;
        }
        if (width + measuredWidth > i6 - iIntValue5) {
            width = (i6 - measuredWidth) - iIntValue5;
        }
        popupWindow.showAtLocation(anchor, 0, width, height);
    }
}
