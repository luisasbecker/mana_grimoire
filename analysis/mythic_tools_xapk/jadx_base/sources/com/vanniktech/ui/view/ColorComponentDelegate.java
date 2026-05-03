package com.vanniktech.ui.view;

import kotlin.Metadata;

/* JADX INFO: compiled from: ColorComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/vanniktech/ui/view/ColorComponentDelegate;", "", "onComponentChanged", "", "componentChange", "Lcom/vanniktech/ui/view/ColorComponentChange;", "hideKeyboardAndFocus", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ColorComponentDelegate {
    void hideKeyboardAndFocus();

    void onComponentChanged(ColorComponentChange componentChange);
}
