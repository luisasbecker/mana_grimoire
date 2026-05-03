package com.appsflyer.internal;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.revenuecat.purchases.common.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1kSDK {
    private StringBuilder AFAdRevenueData = new StringBuilder();
    private final List<AFa1ySDK> getMonetizationNetwork = new ArrayList();
    private final String getMediationNetwork = null;

    enum AFa1ySDK {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    private void AFAdRevenueData() throws AFg1jSDK {
        if (this.getMonetizationNetwork.isEmpty()) {
            return;
        }
        AFa1ySDK monetizationNetwork = getMonetizationNetwork();
        if (monetizationNetwork == AFa1ySDK.EMPTY_ARRAY) {
            AFa1ySDK aFa1ySDK = AFa1ySDK.NONEMPTY_ARRAY;
            this.getMonetizationNetwork.set(r2.size() - 1, aFa1ySDK);
        } else {
            if (monetizationNetwork == AFa1ySDK.NONEMPTY_ARRAY) {
                this.AFAdRevenueData.append(AbstractJsonLexerKt.COMMA);
                return;
            }
            if (monetizationNetwork != AFa1ySDK.DANGLING_KEY) {
                if (monetizationNetwork != AFa1ySDK.NULL) {
                    throw new AFg1jSDK("Nesting problem");
                }
            } else {
                this.AFAdRevenueData.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                AFa1ySDK aFa1ySDK2 = AFa1ySDK.NONEMPTY_OBJECT;
                this.getMonetizationNetwork.set(r2.size() - 1, aFa1ySDK2);
            }
        }
    }

    private AFa1ySDK getMonetizationNetwork() throws AFg1jSDK {
        if (this.getMonetizationNetwork.isEmpty()) {
            throw new AFg1jSDK("Nesting problem");
        }
        return this.getMonetizationNetwork.get(r1.size() - 1);
    }

    public final AFg1kSDK AFAdRevenueData(Object obj) throws AFg1jSDK {
        if (this.getMonetizationNetwork.isEmpty()) {
            throw new AFg1jSDK("Nesting problem");
        }
        if (((Class) AFa1kSDK.getMediationNetwork((char) (View.resolveSize(0, 0) + 2133), 38 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 323 - TextUtils.indexOf("", ""))).isInstance(obj)) {
            try {
                Object[] objArr = {this};
                Object declaredMethod = AFa1kSDK.i.get(83448719);
                if (declaredMethod == null) {
                    declaredMethod = ((Class) AFa1kSDK.getMediationNetwork((char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2133), TextUtils.indexOf("", "") + 37, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 323)).getDeclaredMethod("getMonetizationNetwork", AFg1kSDK.class);
                    AFa1kSDK.i.put(83448719, declaredMethod);
                }
                ((Method) declaredMethod).invoke(obj, objArr);
                return this;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        if (obj instanceof AFg1iSDK) {
            ((AFg1iSDK) obj).getMediationNetwork(this);
            return this;
        }
        AFAdRevenueData();
        if (obj == null || (obj instanceof Boolean) || obj == AFg1iSDK.getMediationNetwork) {
            this.AFAdRevenueData.append(obj);
            return this;
        }
        if (obj instanceof Number) {
            this.AFAdRevenueData.append(AFg1iSDK.getCurrencyIso4217Code((Number) obj));
            return this;
        }
        getRevenue(obj.toString());
        return this;
    }

    public final AFg1kSDK getCurrencyIso4217Code(AFa1ySDK aFa1ySDK, AFa1ySDK aFa1ySDK2, String str) throws AFg1jSDK {
        AFa1ySDK monetizationNetwork = getMonetizationNetwork();
        if (monetizationNetwork != aFa1ySDK2 && monetizationNetwork != aFa1ySDK) {
            throw new AFg1jSDK("Nesting problem");
        }
        this.getMonetizationNetwork.remove(r2.size() - 1);
        this.AFAdRevenueData.append(str);
        return this;
    }

    public final AFg1kSDK getCurrencyIso4217Code(AFa1ySDK aFa1ySDK, String str) throws AFg1jSDK {
        if (this.getMonetizationNetwork.isEmpty() && this.AFAdRevenueData.length() > 0) {
            throw new AFg1jSDK("Nesting problem: multiple top-level roots");
        }
        AFAdRevenueData();
        this.getMonetizationNetwork.add(aFa1ySDK);
        this.AFAdRevenueData.append(str);
        return this;
    }

    final void getMediationNetwork() throws AFg1jSDK {
        AFa1ySDK monetizationNetwork = getMonetizationNetwork();
        if (monetizationNetwork == AFa1ySDK.NONEMPTY_OBJECT) {
            this.AFAdRevenueData.append(AbstractJsonLexerKt.COMMA);
        } else if (monetizationNetwork != AFa1ySDK.EMPTY_OBJECT) {
            throw new AFg1jSDK("Nesting problem");
        }
        AFa1ySDK aFa1ySDK = AFa1ySDK.DANGLING_KEY;
        this.getMonetizationNetwork.set(r2.size() - 1, aFa1ySDK);
    }

    final void getRevenue(String str) {
        this.AFAdRevenueData.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                this.AFAdRevenueData.append("\\f");
            } else if (cCharAt == '\r') {
                this.AFAdRevenueData.append("\\r");
            } else if (cCharAt != '\"' && cCharAt != '/' && cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        this.AFAdRevenueData.append("\\b");
                        break;
                    case '\t':
                        this.AFAdRevenueData.append("\\t");
                        break;
                    case '\n':
                        this.AFAdRevenueData.append("\\n");
                        break;
                    default:
                        StringBuilder sb = this.AFAdRevenueData;
                        if (cCharAt <= 31) {
                            sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                this.AFAdRevenueData.append('\\').append(cCharAt);
            }
        }
        this.AFAdRevenueData.append("\"");
    }

    public final String toString() {
        if (this.AFAdRevenueData.length() == 0) {
            return null;
        }
        return this.AFAdRevenueData.toString();
    }
}
