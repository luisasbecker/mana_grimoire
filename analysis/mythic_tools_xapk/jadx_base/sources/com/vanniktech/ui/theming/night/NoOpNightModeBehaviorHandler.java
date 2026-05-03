package com.vanniktech.ui.theming.night;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpNightModeBehaviorHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/vanniktech/ui/theming/night/NoOpNightModeBehaviorHandler;", "Lcom/vanniktech/ui/theming/night/NightModeBehaviorHandler;", "<init>", "()V", "updateBehavior", "", "nightModeBehavior", "Lcom/vanniktech/ui/theming/night/NightModeBehavior;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoOpNightModeBehaviorHandler implements NightModeBehaviorHandler {
    public static final NoOpNightModeBehaviorHandler INSTANCE = new NoOpNightModeBehaviorHandler();

    private NoOpNightModeBehaviorHandler() {
    }

    @Override // com.vanniktech.ui.theming.night.NightModeBehaviorHandler
    public void updateBehavior(NightModeBehavior nightModeBehavior) {
        Intrinsics.checkNotNullParameter(nightModeBehavior, "nightModeBehavior");
    }
}
