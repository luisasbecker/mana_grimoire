package com.vanniktech.ui.theming.night;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextNightModeProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vanniktech/ui/theming/night/ContextNightModeProvider;", "Lcom/vanniktech/ui/theming/night/NightModeProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isNightMode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextNightModeProvider implements NightModeProvider {
    private final Context context;

    public ContextNightModeProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.vanniktech.ui.theming.night.NightModeProvider
    /* JADX INFO: renamed from: isNightMode */
    public boolean getIsNightMode() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        if (defaultNightMode != 1) {
            return defaultNightMode == 2 || (this.context.getResources().getConfiguration().uiMode & 48) == 32;
        }
        return false;
    }
}
