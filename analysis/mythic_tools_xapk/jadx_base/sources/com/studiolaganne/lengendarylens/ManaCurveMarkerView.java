package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManaCurveMarkerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManaCurveMarkerView;", "Lcom/github/mikephil/charting/components/MarkerView;", "context", "Landroid/content/Context;", "manaCurve", "", "Lcom/studiolaganne/lengendarylens/MTManaCurveEntry;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "tvSpells", "Landroid/widget/TextView;", "tvPermanents", "refreshContent", "", "e", "Lcom/github/mikephil/charting/data/Entry;", "highlight", "Lcom/github/mikephil/charting/highlight/Highlight;", "getOffset", "Lcom/github/mikephil/charting/utils/MPPointF;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManaCurveMarkerView extends MarkerView {
    public static final int $stable = 8;
    private final List<MTManaCurveEntry> manaCurve;
    private final TextView tvPermanents;
    private final TextView tvSpells;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManaCurveMarkerView(Context context, List<MTManaCurveEntry> manaCurve) {
        super(context, R.layout.marker_mana_curve);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(manaCurve, "manaCurve");
        this.manaCurve = manaCurve;
        View viewFindViewById = findViewById(R.id.markerSpells);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.tvSpells = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.markerPermanents);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tvPermanents = (TextView) viewFindViewById2;
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2.0f), (-getHeight()) - 10.0f);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry e, Highlight highlight) {
        Object next;
        if (e == null) {
            return;
        }
        int x = (int) e.getX();
        Iterator<T> it = this.manaCurve.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((MTManaCurveEntry) next).getCmc() == x) {
                    break;
                }
            }
        }
        MTManaCurveEntry mTManaCurveEntry = (MTManaCurveEntry) next;
        if (mTManaCurveEntry != null) {
            this.tvSpells.setText(getContext().getString(R.string.mana_curve_spells) + ": " + mTManaCurveEntry.getSpells());
            this.tvPermanents.setText(getContext().getString(R.string.mana_curve_permanents) + ": " + mTManaCurveEntry.getPermanents());
        }
        super.refreshContent(e, highlight);
    }
}
