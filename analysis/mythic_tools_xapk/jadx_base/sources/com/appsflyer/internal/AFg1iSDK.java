package com.appsflyer.internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.internal.AFg1kSDK;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1iSDK {
    public static final Object getMediationNetwork = new Object() { // from class: com.appsflyer.internal.AFg1iSDK.3
        public final boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        public final int hashCode() {
            return Objects.hashCode(null);
        }

        public final String toString() {
            return AbstractJsonLexerKt.NULL;
        }
    };
    private static final Double getMonetizationNetwork = Double.valueOf(-0.0d);
    private final LinkedHashMap<String, Object> getCurrencyIso4217Code;

    public AFg1iSDK() {
        this.getCurrencyIso4217Code = new LinkedHashMap<>();
    }

    private AFg1iSDK(Object obj) throws Throwable {
        try {
            Object declaredMethod = AFa1kSDK.i.get(1992192254);
            if (declaredMethod == null) {
                declaredMethod = ((Class) AFa1kSDK.getMediationNetwork((char) (6866 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), TextUtils.getTrimmedLength("") + 37, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 360)).getDeclaredMethod("getRevenue", null);
                AFa1kSDK.i.put(1992192254, declaredMethod);
            }
            Object objInvoke = ((Method) declaredMethod).invoke(obj, null);
            if (objInvoke instanceof AFg1iSDK) {
                this.getCurrencyIso4217Code = ((AFg1iSDK) objInvoke).getCurrencyIso4217Code;
                return;
            }
            Object[] objArr = {objInvoke, "AFJsonObject"};
            Object declaredMethod2 = AFa1kSDK.i.get(-606687041);
            if (declaredMethod2 == null) {
                declaredMethod2 = ((Class) AFa1kSDK.getMediationNetwork((char) TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 37, 286 - (ViewConfiguration.getDoubleTapTimeout() >> 16))).getDeclaredMethod("getRevenue", Object.class, String.class);
                AFa1kSDK.i.put(-606687041, declaredMethod2);
            }
            throw ((Throwable) ((Method) declaredMethod2).invoke(null, objArr));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private AFg1iSDK(String str) throws Throwable {
        try {
            Object[] objArr = {str};
            Object declaredConstructor = AFa1kSDK.i.get(-1460506496);
            if (declaredConstructor == null) {
                declaredConstructor = ((Class) AFa1kSDK.getMediationNetwork((char) (6866 - (ViewConfiguration.getTapTimeout() >> 16)), 37 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 360)).getDeclaredConstructor(String.class);
                AFa1kSDK.i.put(-1460506496, declaredConstructor);
            }
            this(((Constructor) declaredConstructor).newInstance(objArr));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public AFg1iSDK(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new NullPointerException("key == null");
            }
            this.getCurrencyIso4217Code.put(str, getMonetizationNetwork(entry.getValue()));
        }
    }

    static String getCurrencyIso4217Code(Number number) throws Throwable {
        if (number == null) {
            throw new AFg1jSDK("Number must be non-null");
        }
        double dDoubleValue = number.doubleValue();
        try {
            Object[] objArr = {Double.valueOf(dDoubleValue)};
            Object declaredMethod = AFa1kSDK.i.get(352463604);
            if (declaredMethod == null) {
                declaredMethod = ((Class) AFa1kSDK.getMediationNetwork((char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 37 - View.MeasureSpec.getSize(0), 286 - (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getDeclaredMethod("getCurrencyIso4217Code", Double.TYPE);
                AFa1kSDK.i.put(352463604, declaredMethod);
            }
            ((Double) ((Method) declaredMethod).invoke(null, objArr)).doubleValue();
            if (number.equals(getMonetizationNetwork)) {
                return "-0";
            }
            long jLongValue = number.longValue();
            return dDoubleValue == ((double) jLongValue) ? Long.toString(jLongValue) : number.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object getMonetizationNetwork(Object obj) throws Throwable {
        if (obj == null) {
            return getMediationNetwork;
        }
        if (((Class) AFa1kSDK.getMediationNetwork((char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 2133), 36 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 323 - Color.alpha(0))).isInstance(obj) || (obj instanceof AFg1iSDK)) {
            return obj;
        }
        if (obj instanceof JSONArray) {
            try {
                Object[] objArr = {obj.toString()};
                Object declaredConstructor = AFa1kSDK.i.get(1249008318);
                if (declaredConstructor == null) {
                    declaredConstructor = ((Class) AFa1kSDK.getMediationNetwork((char) (Color.green(0) + 2133), 37 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 323 - (ViewConfiguration.getLongPressTimeout() >> 16))).getDeclaredConstructor(String.class);
                    AFa1kSDK.i.put(1249008318, declaredConstructor);
                }
                obj = ((Constructor) declaredConstructor).newInstance(objArr);
                return obj;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        if (obj instanceof JSONObject) {
            return new AFg1iSDK(obj.toString());
        }
        if (obj.equals(getMediationNetwork)) {
            return obj;
        }
        if (obj instanceof Collection) {
            try {
                Object[] objArr2 = {(Collection) obj};
                Object declaredConstructor2 = AFa1kSDK.i.get(-2094813449);
                if (declaredConstructor2 == null) {
                    declaredConstructor2 = ((Class) AFa1kSDK.getMediationNetwork((char) (2134 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 37 - View.getDefaultSize(0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 323)).getDeclaredConstructor(Collection.class);
                    AFa1kSDK.i.put(-2094813449, declaredConstructor2);
                }
                return ((Constructor) declaredConstructor2).newInstance(objArr2);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        if (obj.getClass().isArray()) {
            try {
                Object[] objArr3 = {obj};
                Object declaredConstructor3 = AFa1kSDK.i.get(-455505300);
                if (declaredConstructor3 == null) {
                    declaredConstructor3 = ((Class) AFa1kSDK.getMediationNetwork((char) ((ViewConfiguration.getScrollBarSize() >> 8) + 2133), 37 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getEdgeSlop() >> 16) + 323)).getDeclaredConstructor(Object.class);
                    AFa1kSDK.i.put(-455505300, declaredConstructor3);
                }
                return ((Constructor) declaredConstructor3).newInstance(objArr3);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        }
        if (obj instanceof Map) {
            return new AFg1iSDK((Map) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
            return obj;
        }
        if (obj.getClass().getPackage().getName().startsWith("java.")) {
            return obj.toString();
        }
        return null;
        return null;
    }

    final void getMediationNetwork(AFg1kSDK aFg1kSDK) throws AFg1jSDK {
        aFg1kSDK.getCurrencyIso4217Code(AFg1kSDK.AFa1ySDK.EMPTY_OBJECT, "{");
        for (Map.Entry<String, Object> entry : this.getCurrencyIso4217Code.entrySet()) {
            String key = entry.getKey();
            if (key == null) {
                throw new AFg1jSDK("Names must be non-null");
            }
            aFg1kSDK.getMediationNetwork();
            aFg1kSDK.getRevenue(key);
            aFg1kSDK.AFAdRevenueData(entry.getValue());
        }
        aFg1kSDK.getCurrencyIso4217Code(AFg1kSDK.AFa1ySDK.EMPTY_OBJECT, AFg1kSDK.AFa1ySDK.NONEMPTY_OBJECT, "}");
    }

    public final AFg1iSDK getRevenue(String str, Object obj) throws Throwable {
        if (obj == null) {
            this.getCurrencyIso4217Code.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            try {
                Object[] objArr = {Double.valueOf(((Number) obj).doubleValue())};
                Object method = AFa1kSDK.i.get(352463604);
                if (method == null) {
                    method = ((Class) AFa1kSDK.getMediationNetwork((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 36, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 285)).getMethod("getCurrencyIso4217Code", Double.TYPE);
                    AFa1kSDK.i.put(352463604, method);
                }
                ((Double) ((Method) method).invoke(null, objArr)).doubleValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        LinkedHashMap<String, Object> linkedHashMap = this.getCurrencyIso4217Code;
        if (str == null) {
            throw new AFg1jSDK("Names must be non-null");
        }
        linkedHashMap.put(str, obj);
        return this;
    }

    public final String toString() {
        try {
            AFg1kSDK aFg1kSDK = new AFg1kSDK();
            getMediationNetwork(aFg1kSDK);
            return aFg1kSDK.toString();
        } catch (AFg1jSDK unused) {
            return null;
        }
    }
}
