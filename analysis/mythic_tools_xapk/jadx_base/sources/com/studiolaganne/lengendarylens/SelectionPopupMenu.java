package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionPopupMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectionPopupMenu;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "entries", "", "Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry;", "addItem", Constants.GP_IAP_TITLE, "", "icon", "Landroid/graphics/drawable/Drawable;", "textColor", "", "isSelected", "", "onClick", "Lkotlin/Function0;", "", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;)Lcom/studiolaganne/lengendarylens/SelectionPopupMenu;", "addDivider", "show", "anchor", "Landroid/view/View;", "Entry", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SelectionPopupMenu {
    public static final int $stable = 8;
    private final Context context;
    private final List<Entry> entries;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SelectionPopupMenu.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry;", "", "<init>", "()V", "Item", "Divider", "Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry$Divider;", "Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry$Item;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static abstract class Entry {

        /* JADX INFO: compiled from: SelectionPopupMenu.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry$Divider;", "Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 874244100;
            }

            public String toString() {
                return "Divider";
            }
        }

        /* JADX INFO: compiled from: SelectionPopupMenu.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry$Item;", "Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry;", Constants.GP_IAP_TITLE, "", "icon", "Landroid/graphics/drawable/Drawable;", "textColor", "", "isSelected", "", "onClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getTextColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;)Lcom/studiolaganne/lengendarylens/SelectionPopupMenu$Entry$Item;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Item extends Entry {
            public static final int $stable = 8;
            private final Drawable icon;
            private final boolean isSelected;
            private final Function0<Unit> onClick;
            private final Integer textColor;
            private final String title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(String title, Drawable drawable, Integer num, boolean z, Function0<Unit> onClick) {
                super(null);
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(onClick, "onClick");
                this.title = title;
                this.icon = drawable;
                this.textColor = num;
                this.isSelected = z;
                this.onClick = onClick;
            }

            public /* synthetic */ Item(String str, Drawable drawable, Integer num, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : drawable, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z, function0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Item copy$default(Item item, String str, Drawable drawable, Integer num, boolean z, Function0 function0, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.title;
                }
                if ((i & 2) != 0) {
                    drawable = item.icon;
                }
                if ((i & 4) != 0) {
                    num = item.textColor;
                }
                if ((i & 8) != 0) {
                    z = item.isSelected;
                }
                if ((i & 16) != 0) {
                    function0 = item.onClick;
                }
                Function0 function02 = function0;
                Integer num2 = num;
                return item.copy(str, drawable, num2, z, function02);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Drawable getIcon() {
                return this.icon;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getTextColor() {
                return this.textColor;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            public final Function0<Unit> component5() {
                return this.onClick;
            }

            public final Item copy(String title, Drawable icon, Integer textColor, boolean isSelected, Function0<Unit> onClick) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(onClick, "onClick");
                return new Item(title, icon, textColor, isSelected, onClick);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.icon, item.icon) && Intrinsics.areEqual(this.textColor, item.textColor) && this.isSelected == item.isSelected && Intrinsics.areEqual(this.onClick, item.onClick);
            }

            public final Drawable getIcon() {
                return this.icon;
            }

            public final Function0<Unit> getOnClick() {
                return this.onClick;
            }

            public final Integer getTextColor() {
                return this.textColor;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                Drawable drawable = this.icon;
                int iHashCode2 = (iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
                Integer num = this.textColor;
                return ((((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSelected)) * 31) + this.onClick.hashCode();
            }

            public final boolean isSelected() {
                return this.isSelected;
            }

            public String toString() {
                return "Item(title=" + this.title + ", icon=" + this.icon + ", textColor=" + this.textColor + ", isSelected=" + this.isSelected + ", onClick=" + this.onClick + ")";
            }
        }

        private Entry() {
        }

        public /* synthetic */ Entry(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SelectionPopupMenu(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.entries = new ArrayList();
    }

    public static /* synthetic */ SelectionPopupMenu addItem$default(SelectionPopupMenu selectionPopupMenu, String str, Drawable drawable, Integer num, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            drawable = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return selectionPopupMenu.addItem(str, drawable, num, z, function0);
    }

    static final int show$lambda$0(SelectionPopupMenu selectionPopupMenu, float f) {
        return (int) TypedValue.applyDimension(1, f, selectionPopupMenu.context.getResources().getDisplayMetrics());
    }

    static final void show$lambda$9(Entry entry, PopupWindow popupWindow, View view) {
        ((Entry.Item) entry).getOnClick().invoke();
        popupWindow.dismiss();
    }

    public final SelectionPopupMenu addDivider() {
        this.entries.add(Entry.Divider.INSTANCE);
        return this;
    }

    public final SelectionPopupMenu addItem(String title, Drawable icon, Integer textColor, boolean isSelected, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.entries.add(new Entry.Item(title, icon, textColor, isSelected, onClick));
        return this;
    }

    public final void show(View anchor) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        Iterator<Entry> it;
        byte b;
        int iIntValue;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.SelectionPopupMenu$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(SelectionPopupMenu.show$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        };
        int color = ContextCompat.getColor(this.context, R.color.text_color_opaque);
        int color2 = ContextCompat.getColor(this.context, R.color.mythic_plus);
        List<Entry> list = this.entries;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            for (Entry entry : list) {
                if ((entry instanceof Entry.Item) && ((Entry.Item) entry).getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        Typeface font = ResourcesCompat.getFont(this.context, R.font.be_vietnam_pro_semibold);
        Typeface font2 = ResourcesCompat.getFont(this.context, R.font.fa6solid);
        int iIntValue2 = ((Number) function1.invoke(Float.valueOf(280.0f))).intValue();
        int iIntValue3 = ((Number) function1.invoke(Float.valueOf(20.0f))).intValue();
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
        Iterator<Entry> it2 = this.entries.iterator();
        while (it2.hasNext()) {
            final Entry next = it2.next();
            if (next instanceof Entry.Item) {
                Entry.Item item = (Entry.Item) next;
                Integer textColor = item.getTextColor();
                if (textColor != null) {
                    i = color;
                    iIntValue = textColor.intValue();
                } else {
                    iIntValue = color;
                    i = iIntValue;
                }
                i2 = color2;
                LinearLayout linearLayout2 = new LinearLayout(this.context);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(16);
                z2 = z;
                it = it2;
                linearLayout2.setPadding(((Number) function1.invoke(Float.valueOf(16.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(12.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(16.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(12.0f))).intValue());
                TypedArray typedArrayObtainStyledAttributes = linearLayout2.getContext().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
                Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
                linearLayout2.setForeground(typedArrayObtainStyledAttributes.getDrawable(0));
                typedArrayObtainStyledAttributes.recycle();
                linearLayout2.setClickable(true);
                linearLayout2.setFocusable(true);
                if (item.getIcon() != null) {
                    ImageView imageView = new ImageView(this.context);
                    imageView.setImageDrawable(item.getIcon());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iIntValue3, iIntValue3);
                    layoutParams.setMarginEnd(((Number) function1.invoke(Float.valueOf(10.0f))).intValue());
                    imageView.setLayoutParams(layoutParams);
                    linearLayout2.addView(imageView);
                } else if (z2) {
                    View view = new View(this.context);
                    view.setLayoutParams(new LinearLayout.LayoutParams(((Number) function1.invoke(Float.valueOf(10.0f))).intValue() + iIntValue3, 0));
                    linearLayout2.addView(view);
                }
                TextView textView = new TextView(this.context);
                textView.setText(item.getTitle());
                textView.setTextColor(iIntValue);
                textView.setTextSize(16.0f);
                textView.setTypeface(font);
                textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                linearLayout2.addView(textView);
                if (item.isSelected()) {
                    TextView textView2 = new TextView(this.context);
                    textView2.setText("\uf00c");
                    textView2.setTypeface(font2);
                    textView2.setTextSize(14.0f);
                    textView2.setTextColor(item.getTextColor() != null ? item.getTextColor().intValue() : i2);
                    textView2.setGravity(17);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMarginStart(((Number) function1.invoke(Float.valueOf(12.0f))).intValue());
                    textView2.setLayoutParams(layoutParams2);
                    linearLayout2.addView(textView2);
                }
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SelectionPopupMenu$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SelectionPopupMenu.show$lambda$9(next, popupWindow, view2);
                    }
                });
                b = -2;
                linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            } else {
                i = color;
                i2 = color2;
                z2 = z;
                it = it2;
                b = -2;
                if (!(next instanceof Entry.Divider)) {
                    throw new NoWhenBranchMatchedException();
                }
                View view2 = new View(this.context);
                view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), R.color.separator_grey));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, ((Number) function1.invoke(Float.valueOf(1.0f))).intValue());
                layoutParams3.topMargin = ((Number) function1.invoke(Float.valueOf(4.0f))).intValue();
                layoutParams3.bottomMargin = ((Number) function1.invoke(Float.valueOf(4.0f))).intValue();
                layoutParams3.setMarginStart(((Number) function1.invoke(Float.valueOf(16.0f))).intValue());
                layoutParams3.setMarginEnd(((Number) function1.invoke(Float.valueOf(16.0f))).intValue());
                view2.setLayoutParams(layoutParams3);
                linearLayout.addView(view2);
            }
            color = i;
            color2 = i2;
            z = z2;
            it2 = it;
        }
        popupWindow.setContentView(linearLayout);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(iIntValue2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
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
        int iIntValue4 = ((Number) function1.invoke(Float.valueOf(8.0f))).intValue();
        int i7 = measuredHeight + iIntValue4;
        int height = i5 - (anchor.getHeight() + i4) >= i7 ? i4 + anchor.getHeight() : i4 >= i7 ? i4 - measuredHeight : (i5 - measuredHeight) - iIntValue4;
        int width = (i3 + anchor.getWidth()) - measuredWidth;
        if (width < iIntValue4) {
            width = iIntValue4;
        }
        if (width + measuredWidth > i6 - iIntValue4) {
            width = (i6 - measuredWidth) - iIntValue4;
        }
        popupWindow.showAtLocation(anchor, 0, width, height);
    }
}
