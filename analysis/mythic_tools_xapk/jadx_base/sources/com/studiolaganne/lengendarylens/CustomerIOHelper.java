package com.studiolaganne.lengendarylens;

import android.util.Log;
import io.customer.sdk.CustomerIO;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerIOHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomerIOHelper;", "", "<init>", "()V", "TAG", "", "identifyOptedInUser", "", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "setOptOut", "maybeIdentifyAfterLogin", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerIOHelper {
    public static final int $stable = 0;
    public static final CustomerIOHelper INSTANCE = new CustomerIOHelper();
    private static final String TAG = "[CustomerIO]";

    private CustomerIOHelper() {
    }

    public final void identifyOptedInUser(MTUser user, PreferencesManager prefs) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        try {
            CustomerIO customerIOInstance = CustomerIO.INSTANCE.instance();
            String strValueOf = String.valueOf(user.getId());
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            String firstname = user.getFirstname();
            String str = "";
            if (firstname == null) {
                firstname = "";
            }
            mapCreateMapBuilder.put("first_name", firstname);
            String username = user.getUsername();
            if (username != null) {
                str = username;
            }
            mapCreateMapBuilder.put("user_name", str);
            mapCreateMapBuilder.put("email", user.getEmail());
            mapCreateMapBuilder.put(PreferencesManager.EMAIL_OPT_IN, true);
            Unit unit = Unit.INSTANCE;
            customerIOInstance.identify(strValueOf, MapsKt.build(mapCreateMapBuilder));
            prefs.setBoolean(PreferencesManager.EMAIL_OPT_IN, true);
            Log.d(TAG, "User identified (opted-in) successfully");
        } catch (Exception e) {
            Log.e(TAG, "Failed to identify opted-in user", e);
        }
    }

    public final void maybeIdentifyAfterLogin(MTUser user, PreferencesManager prefs) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        if (prefs.getBoolean(PreferencesManager.EMAIL_OPT_IN, false)) {
            identifyOptedInUser(user, prefs);
        }
    }

    public final void setOptOut(PreferencesManager prefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        boolean z = prefs.getBoolean(PreferencesManager.EMAIL_OPT_IN, false);
        prefs.setBoolean(PreferencesManager.EMAIL_OPT_IN, false);
        if (z) {
            try {
                CustomerIO.INSTANCE.instance().setProfileAttributes(MapsKt.mapOf(TuplesKt.to(PreferencesManager.EMAIL_OPT_IN, false)));
                Log.d(TAG, "User opted out, email_opt_in set to false");
            } catch (Exception e) {
                Log.e(TAG, "Failed to set opt-out attribute", e);
            }
        }
    }
}
