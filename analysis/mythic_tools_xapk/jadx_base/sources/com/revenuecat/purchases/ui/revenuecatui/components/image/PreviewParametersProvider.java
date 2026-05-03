package com.revenuecat.purchases.ui.revenuecatui.components.image;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ImageComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParametersProvider;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParameters;", "()V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PreviewParametersProvider implements PreviewParameterProvider<PreviewParameters> {
    private final Sequence<PreviewParameters> values = SequencesKt.sequenceOf((Object[]) new PreviewParameters[]{new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null)), FitMode.FILL, null), new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null)), FitMode.FIT, null), new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(50, null)), FitMode.FILL, null), new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(50, null)), FitMode.FIT, null), new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(50, null), new SizeConstraint.Fixed(200, null)), FitMode.FILL, null), new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(50, null), new SizeConstraint.Fixed(200, null)), FitMode.FIT, null), new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(72, null), SizeConstraint.Fit.INSTANCE), FitMode.FILL, null), new PreviewParameters(100, 100, new Size(SizeConstraint.Fit.INSTANCE, new SizeConstraint.Fixed(72, null)), FitMode.FILL, null), new PreviewParameters(1909, 1306, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), FitMode.FIT, null), new PreviewParameters(1306, 1909, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE), FitMode.FIT, null)});

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<PreviewParameters> getValues() {
        return this.values;
    }
}
