package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import com.studiolaganne.lengendarylens.MTSubscriptionSyncResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: AllSettingsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/AllSettingsFragment$onCreatePreferences$14$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AllSettingsFragment$onCreatePreferences$14$1 implements Callback<MTSubscriptionSyncResponse> {
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ AllSettingsFragment this$0;

    AllSettingsFragment$onCreatePreferences$14$1(AlertDialog alertDialog, AllSettingsFragment allSettingsFragment) {
        this.$dialog = alertDialog;
        this.this$0 = allSettingsFragment;
    }

    static final void onFailure$lambda$1(AlertDialog alertDialog, AllSettingsFragment allSettingsFragment) {
        alertDialog.dismiss();
        if (allSettingsFragment.isAdded()) {
            new AlertDialog.Builder(allSettingsFragment.requireContext()).setTitle(allSettingsFragment.getString(R.string.mythic_plus_inactive)).setMessage(allSettingsFragment.getString(R.string.mythic_plus_sync_failed)).setPositiveButton(allSettingsFragment.getString(R.string.close), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$onCreatePreferences$14$1$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    static final void onResponse$lambda$0(AlertDialog alertDialog, AllSettingsFragment allSettingsFragment, Response response) {
        String string;
        String string2;
        alertDialog.dismiss();
        if (allSettingsFragment.isAdded()) {
            MTSubscriptionSyncResponse mTSubscriptionSyncResponse = (MTSubscriptionSyncResponse) response.body();
            if (!response.isSuccessful() || mTSubscriptionSyncResponse == null) {
                new AlertDialog.Builder(allSettingsFragment.requireContext()).setTitle(allSettingsFragment.getString(R.string.mythic_plus_inactive)).setMessage(allSettingsFragment.getString(R.string.mythic_plus_sync_failed)).setPositiveButton(allSettingsFragment.getString(R.string.close), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$onCreatePreferences$14$1$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
                return;
            }
            MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
            Context contextRequireContext = allSettingsFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTSubscriptionSyncResponse.MythicPlusStatus mythicPlus = mTSubscriptionSyncResponse.getMythicPlus();
            mythicPlusManager.setActive(contextRequireContext, mythicPlus != null ? mythicPlus.getActive() : false);
            MTSubscriptionSyncResponse.MythicPlusStatus mythicPlus2 = mTSubscriptionSyncResponse.getMythicPlus();
            if (mythicPlus2 == null || !mythicPlus2.getActive()) {
                string = allSettingsFragment.getString(R.string.mythic_plus_inactive);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = allSettingsFragment.getString(R.string.mythic_plus_not_active);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            } else {
                string = allSettingsFragment.getString(R.string.mythic_plus_active);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ArrayList arrayList = new ArrayList();
                String expiresAt = mythicPlus2.getExpiresAt();
                if (expiresAt != null) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        Date date = simpleDateFormat.parse(expiresAt);
                        DateFormat dateInstance = DateFormat.getDateInstance(2);
                        Intrinsics.checkNotNull(date);
                        String string3 = allSettingsFragment.getString(R.string.mythic_plus_expires, dateInstance.format(date));
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        Boolean.valueOf(arrayList.add(string3));
                    } catch (Exception unused) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                Boolean willRenew = mythicPlus2.getWillRenew();
                if (Intrinsics.areEqual((Object) willRenew, (Object) true)) {
                    String string4 = allSettingsFragment.getString(R.string.mythic_plus_auto_renewal_enabled);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    arrayList.add(string4);
                } else if (Intrinsics.areEqual((Object) willRenew, (Object) false)) {
                    String string5 = allSettingsFragment.getString(R.string.mythic_plus_auto_renewal_disabled);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    arrayList.add(string5);
                } else {
                    if (willRenew != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String string6 = allSettingsFragment.getString(R.string.mythic_plus_auto_renewal_unknown);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    arrayList.add(string6);
                }
                string2 = CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
            }
            new AlertDialog.Builder(allSettingsFragment.requireContext()).setTitle(string).setMessage(string2).setPositiveButton(allSettingsFragment.getString(R.string.close), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$onCreatePreferences$14$1$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTSubscriptionSyncResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Handler handler = new Handler(Looper.getMainLooper());
        final AlertDialog alertDialog = this.$dialog;
        final AllSettingsFragment allSettingsFragment = this.this$0;
        handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$onCreatePreferences$14$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AllSettingsFragment$onCreatePreferences$14$1.onFailure$lambda$1(alertDialog, allSettingsFragment);
            }
        });
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTSubscriptionSyncResponse> call, final Response<MTSubscriptionSyncResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Handler handler = new Handler(Looper.getMainLooper());
        final AlertDialog alertDialog = this.$dialog;
        final AllSettingsFragment allSettingsFragment = this.this$0;
        handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllSettingsFragment$onCreatePreferences$14$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AllSettingsFragment$onCreatePreferences$14$1.onResponse$lambda$0(alertDialog, allSettingsFragment, response);
            }
        });
    }
}
