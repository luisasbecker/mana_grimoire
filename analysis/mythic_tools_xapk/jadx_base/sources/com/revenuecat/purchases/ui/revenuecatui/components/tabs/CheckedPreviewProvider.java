package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: TabControlToggleView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/tabs/CheckedPreviewProvider;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "", "()V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CheckedPreviewProvider implements PreviewParameterProvider<Boolean> {
    private final Sequence<Boolean> values = SequencesKt.sequenceOf((Object[]) new Boolean[]{false, true});

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<Boolean> getValues() {
        return this.values;
    }
}
