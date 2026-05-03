package com.revenuecat.purchases.utils;

import android.app.Activity;
import com.facebook.appevents.internal.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AlertDialogHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/utils/AlertDialogHelper;", "", "showDialog", "", "activity", "Landroid/app/Activity;", Constants.GP_IAP_TITLE, "", "message", "positiveButtonText", "negativeButtonText", "neutralButtonText", "onPositiveButtonClicked", "Lkotlin/Function0;", "onNegativeButtonClicked", "onNeutralButtonClicked", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AlertDialogHelper {
    void showDialog(Activity activity, String title, String message, String positiveButtonText, String negativeButtonText, String neutralButtonText, Function0<Unit> onPositiveButtonClicked, Function0<Unit> onNegativeButtonClicked, Function0<Unit> onNeutralButtonClicked);
}
