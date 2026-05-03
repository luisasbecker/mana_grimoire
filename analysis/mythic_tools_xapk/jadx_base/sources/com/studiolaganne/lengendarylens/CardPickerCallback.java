package com.studiolaganne.lengendarylens;

import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: CardPickerBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPickerCallback;", "", "onCardSelected", "", "card", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", OptionalModuleUtils.FACE, "", "onCardPickerClosed", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CardPickerCallback {
    void onCardPickerClosed();

    void onCardSelected(MTSimpleCard card, int face);
}
