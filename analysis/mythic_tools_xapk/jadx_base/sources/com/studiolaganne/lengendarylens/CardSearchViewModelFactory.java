package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CardSearchViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardSearchViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "databaseHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "databaseHelpers", "", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "context", "Landroid/content/Context;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;Lcom/studiolaganne/lengendarylens/PreferencesManager;Landroid/content/Context;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardSearchViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final Context context;
    private final MTGDBHelper databaseHelper;
    private final List<MTGDBHelperLocalized> databaseHelpers;
    private final PreferencesManager prefs;

    public CardSearchViewModelFactory(MTGDBHelper databaseHelper, List<MTGDBHelperLocalized> databaseHelpers, PreferencesManager prefs, Context context) {
        Intrinsics.checkNotNullParameter(databaseHelper, "databaseHelper");
        Intrinsics.checkNotNullParameter(databaseHelpers, "databaseHelpers");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(context, "context");
        this.databaseHelper = databaseHelper;
        this.databaseHelpers = databaseHelpers;
        this.prefs = prefs;
        this.context = context;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(CardSearchViewModel.class)) {
            return new CardSearchViewModel(this.databaseHelper, this.databaseHelpers, this.prefs, this.context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        return (T) super.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
        return (T) super.create(kClass, creationExtras);
    }
}
