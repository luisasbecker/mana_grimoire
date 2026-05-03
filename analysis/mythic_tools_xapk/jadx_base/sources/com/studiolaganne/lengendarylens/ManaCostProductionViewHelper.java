package com.studiolaganne.lengendarylens;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManaCostProductionViewHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManaCostProductionViewHelper;", "", "<init>", "()V", "bindDataToView", "", "rootView", "Landroid/view/View;", "entry", "Lcom/studiolaganne/lengendarylens/MTManaCostProductionEntry;", "maxCost", "", "maxProduction", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManaCostProductionViewHelper {
    public static final int $stable = 0;
    public static final ManaCostProductionViewHelper INSTANCE = new ManaCostProductionViewHelper();

    private ManaCostProductionViewHelper() {
    }

    public final void bindDataToView(View rootView, MTManaCostProductionEntry entry, int maxCost, int maxProduction) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(entry, "entry");
        View viewFindViewById = rootView.findViewById(R.id.manaChartView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = rootView.findViewById(R.id.costValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = rootView.findViewById(R.id.costCards);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById3;
        View viewFindViewById4 = rootView.findViewById(R.id.productionValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById4;
        View viewFindViewById5 = rootView.findViewById(R.id.productionCards);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextView textView4 = (TextView) viewFindViewById5;
        ((ManaCostProductionChartView) viewFindViewById).setData(entry, maxCost, maxProduction);
        MTProductionEntry costs = entry.getCosts();
        int symbols = costs != null ? costs.getSymbols() : 0;
        MTProductionEntry costs2 = entry.getCosts();
        int cards = costs2 != null ? costs2.getCards() : 0;
        textView.setText(String.valueOf(symbols));
        textView2.setText(rootView.getContext().getString(R.string.on_cards, Integer.valueOf(cards)));
        MTProductionEntry production = entry.getProduction();
        int symbols2 = production != null ? production.getSymbols() : 0;
        MTProductionEntry production2 = entry.getProduction();
        int cards2 = production2 != null ? production2.getCards() : 0;
        textView3.setText(String.valueOf(symbols2));
        textView4.setText(rootView.getContext().getString(R.string.on_cards, Integer.valueOf(cards2)));
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, Integer.valueOf(Color.parseColor("#F5F5DC"))), TuplesKt.to("U", Integer.valueOf(Color.parseColor("#5EA8FB"))), TuplesKt.to("B", Integer.valueOf(Color.parseColor("#B5BBB0"))), TuplesKt.to("R", Integer.valueOf(Color.parseColor("#F3403A"))), TuplesKt.to(GameUtils.CONDITION_GOOD, Integer.valueOf(Color.parseColor("#30D34E"))), TuplesKt.to("C", Integer.valueOf(Color.parseColor("#CAC5C0"))));
        String upperCase = entry.getColor().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Integer num = (Integer) mapMapOf.get(upperCase);
        int iIntValue = num != null ? num.intValue() : -7829368;
        int iArgb = Color.argb(175, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
        View viewFindViewById6 = rootView.findViewById(R.id.costIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        View viewFindViewById7 = rootView.findViewById(R.id.costLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        ((TextView) viewFindViewById6).setTextColor(iArgb);
        ((TextView) viewFindViewById7).setTextColor(iArgb);
        textView.setTextColor(iArgb);
        View viewFindViewById8 = rootView.findViewById(R.id.productionIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        View viewFindViewById9 = rootView.findViewById(R.id.productionLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        ((TextView) viewFindViewById8).setTextColor(iIntValue);
        ((TextView) viewFindViewById9).setTextColor(iIntValue);
        textView3.setTextColor(iIntValue);
    }
}
