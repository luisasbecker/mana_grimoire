package com.vanniktech.ui.theming.night;

import kotlin.Metadata;

/* JADX INFO: compiled from: HardcodedNightModeProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vanniktech/ui/theming/night/HardcodedNightModeProvider;", "Lcom/vanniktech/ui/theming/night/NightModeProvider;", "isNightMode", "", "<init>", "(Z)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HardcodedNightModeProvider implements NightModeProvider {
    private boolean isNightMode;

    public HardcodedNightModeProvider(boolean z) {
        this.isNightMode = z;
    }

    @Override // com.vanniktech.ui.theming.night.NightModeProvider
    /* JADX INFO: renamed from: isNightMode, reason: from getter */
    public boolean getIsNightMode() {
        return this.isNightMode;
    }
}
