package com.appsflyer.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.internal.AttributionIdentifiers;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class AFb1kSDK extends AFb1tSDK<String> {
    public AFb1kSDK(Context context, Executor executor) {
        super(context, executor, AttributionIdentifiers.ATTRIBUTION_ID_CONTENT_PROVIDER, "E3F9E1E0CF99D0E56A055BA65E241B3399F7CEA524326B0CDD6EC1327ED0FDC1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFb1tSDK
    /* JADX INFO: renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
    public String getMediationNetwork() throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = this.getCurrencyIso4217Code.getContentResolver().query(Uri.parse(new StringBuilder("content://").append(this.getMonetizationNetwork).toString()), new String[]{"aid"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("aid"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final String getCurrencyIso4217Code() {
        this.getRevenue.execute(this.getMediationNetwork);
        return (String) super.getRevenue();
    }

    @Override // com.appsflyer.internal.AFb1tSDK
    public final /* synthetic */ String getRevenue() {
        this.getRevenue.execute(this.getMediationNetwork);
        return (String) super.getRevenue();
    }
}
