package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.facebook.appevents.AppEventsConstants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public final class AFc1hSDK extends HashMap<String, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int component1 = 0;
    private static int component2 = 1;
    private static long component4;
    private static char getCurrencyIso4217Code;
    private static char[] getMediationNetwork;
    private static char[] getRevenue;
    private final Context AFAdRevenueData;
    private final Map<String, Object> getMonetizationNetwork;

    public static class AFa1tSDK {
        static byte[] getCurrencyIso4217Code(String str) throws Exception {
            return str.getBytes(Charset.defaultCharset());
        }

        static byte[] getRevenue(byte[] bArr) throws Exception {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
            }
            return bArr;
        }
    }

    static {
        getMediationNetwork();
        TextUtils.indexOf((CharSequence) "", '0');
        TextUtils.lastIndexOf("", '0', 0, 0);
        ViewConfiguration.getMaximumDrawingCacheSize();
        ExpandableListView.getPackedPositionForChild(0, 0);
        ExpandableListView.getPackedPositionChild(0L);
        View.resolveSizeAndState(0, 0, 0);
        TextUtils.lastIndexOf("", '0');
        Color.argb(0, 0, 0, 0);
        PointF.length(0.0f, 0.0f);
        ExpandableListView.getPackedPositionForChild(0, 0);
        ImageFormat.getBitsPerPixel(0);
        PointF.length(0.0f, 0.0f);
        AudioTrack.getMaxVolume();
        KeyEvent.normalizeMetaState(0);
        TextUtils.lastIndexOf("", '0', 0);
        ExpandableListView.getPackedPositionType(0L);
        View.resolveSizeAndState(0, 0, 0);
        ViewConfiguration.getScrollFriction();
        int i = component1 + 87;
        component2 = i % 128;
        int i2 = i % 2;
    }

    public AFc1hSDK(Map<String, Object> map, Context context) {
        this.getMonetizationNetwork = map;
        this.AFAdRevenueData = context;
        put(getRevenue(), getMonetizationNetwork());
    }

    private static StringBuilder AFAdRevenueData(String... strArr) throws Exception {
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = component2 + 33;
        component1 = i2 % 128;
        int i3 = i2 % 2;
        for (int i4 = 0; i4 < 3; i4++) {
            arrayList.add(Integer.valueOf(strArr[i4].length()));
        }
        Collections.sort(arrayList);
        int iIntValue = ((Integer) arrayList.get(0)).intValue();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < iIntValue; i5++) {
            int i6 = component1;
            int i7 = i6 + 61;
            component2 = i7 % 128;
            int i8 = i7 % 2;
            int length2 = strArr.length;
            int i9 = i6 + 17;
            component2 = i9 % 128;
            int i10 = i9 % 2;
            Integer numValueOf = null;
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = component1 + 41;
                component2 = i12 % 128;
                int i13 = i12 % 2;
                int iCharAt = strArr[i11].charAt(i5);
                if (numValueOf != null) {
                    iCharAt ^= numValueOf.intValue();
                }
                numValueOf = Integer.valueOf(iCharAt);
            }
            sb.append(Integer.toHexString(numValueOf.intValue()));
        }
        return sb;
    }

    private static void a(byte b, String str, int i, Object[] objArr) {
        int i2;
        int i3 = 2 % 2;
        Object charArray = str;
        if (str != null) {
            int i4 = $10 + 111;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        AFk1oSDK aFk1oSDK = new AFk1oSDK();
        char[] cArr2 = getRevenue;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i6 = 0; i6 < length; i6++) {
                cArr3[i6] = (char) (((long) cArr2[i6]) ^ 3069006688033654235L);
            }
            cArr2 = cArr3;
        }
        char c = (char) (3069006688033654235L ^ ((long) getCurrencyIso4217Code));
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i7 = $11 + Imgproc.COLOR_YUV2RGB_YVYU;
            int i8 = i7 % 128;
            $10 = i8;
            int i9 = i7 % 2;
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
            int i10 = i8 + 55;
            $11 = i10 % 128;
            int i11 = i10 % 2;
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            aFk1oSDK.AFAdRevenueData = 0;
            while (aFk1oSDK.AFAdRevenueData < i2) {
                aFk1oSDK.getCurrencyIso4217Code = cArr[aFk1oSDK.AFAdRevenueData];
                aFk1oSDK.getRevenue = cArr[aFk1oSDK.AFAdRevenueData + 1];
                if (aFk1oSDK.getCurrencyIso4217Code == aFk1oSDK.getRevenue) {
                    cArr4[aFk1oSDK.AFAdRevenueData] = (char) (aFk1oSDK.getCurrencyIso4217Code - b);
                    cArr4[aFk1oSDK.AFAdRevenueData + 1] = (char) (aFk1oSDK.getRevenue - b);
                } else {
                    aFk1oSDK.getMonetizationNetwork = aFk1oSDK.getCurrencyIso4217Code / c;
                    aFk1oSDK.component3 = aFk1oSDK.getCurrencyIso4217Code % c;
                    aFk1oSDK.getMediationNetwork = aFk1oSDK.getRevenue / c;
                    aFk1oSDK.component1 = aFk1oSDK.getRevenue % c;
                    if (aFk1oSDK.component3 == aFk1oSDK.component1) {
                        aFk1oSDK.getMonetizationNetwork = ((aFk1oSDK.getMonetizationNetwork + c) - 1) % c;
                        aFk1oSDK.getMediationNetwork = ((aFk1oSDK.getMediationNetwork + c) - 1) % c;
                        int i12 = (aFk1oSDK.getMonetizationNetwork * c) + aFk1oSDK.component3;
                        int i13 = (aFk1oSDK.getMediationNetwork * c) + aFk1oSDK.component1;
                        cArr4[aFk1oSDK.AFAdRevenueData] = cArr2[i12];
                        cArr4[aFk1oSDK.AFAdRevenueData + 1] = cArr2[i13];
                    } else if (aFk1oSDK.getMonetizationNetwork == aFk1oSDK.getMediationNetwork) {
                        aFk1oSDK.component3 = ((aFk1oSDK.component3 + c) - 1) % c;
                        aFk1oSDK.component1 = ((aFk1oSDK.component1 + c) - 1) % c;
                        int i14 = (aFk1oSDK.getMonetizationNetwork * c) + aFk1oSDK.component3;
                        int i15 = (aFk1oSDK.getMediationNetwork * c) + aFk1oSDK.component1;
                        cArr4[aFk1oSDK.AFAdRevenueData] = cArr2[i14];
                        cArr4[aFk1oSDK.AFAdRevenueData + 1] = cArr2[i15];
                    } else {
                        int i16 = (aFk1oSDK.getMonetizationNetwork * c) + aFk1oSDK.component1;
                        int i17 = (aFk1oSDK.getMediationNetwork * c) + aFk1oSDK.component3;
                        cArr4[aFk1oSDK.AFAdRevenueData] = cArr2[i16];
                        cArr4[aFk1oSDK.AFAdRevenueData + 1] = cArr2[i17];
                    }
                }
                aFk1oSDK.AFAdRevenueData += 2;
            }
        }
        for (int i18 = 0; i18 < i; i18++) {
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    private static void b(char c, int i, int i2, Object[] objArr) {
        int i3 = 2 % 2;
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        long[] jArr = new long[i];
        aFk1kSDK.getMediationNetwork = 0;
        while (aFk1kSDK.getMediationNetwork < i) {
            int i4 = $11 + 113;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            jArr[aFk1kSDK.getMediationNetwork] = (((long) ((char) (((long) getMediationNetwork[aFk1kSDK.getMediationNetwork + i2]) ^ 5211070536272185776L))) ^ (((long) aFk1kSDK.getMediationNetwork) * (5211070536272185776L ^ component4))) ^ ((long) c);
            aFk1kSDK.getMediationNetwork++;
        }
        char[] cArr = new char[i];
        aFk1kSDK.getMediationNetwork = 0;
        int i6 = $11 + 5;
        $10 = i6 % 128;
        int i7 = i6 % 2;
        while (aFk1kSDK.getMediationNetwork < i) {
            cArr[aFk1kSDK.getMediationNetwork] = (char) jArr[aFk1kSDK.getMediationNetwork];
            aFk1kSDK.getMediationNetwork++;
        }
        String str = new String(cArr);
        int i8 = $11 + Imgproc.COLOR_YUV2RGB_YVYU;
        $10 = i8 % 128;
        int i9 = i8 % 2;
        objArr[0] = str;
    }

    static void getMediationNetwork() {
        getRevenue = new char[]{28789, 28768, 28779, 28769, 28795, 28713, 28706, 28787, 28771, 28717, 28776, 28774, 28781, 28778, 28780, 28716, 28791, 28719, 28723, 28788, 28695, 28712, 28727, 28724, 28682, 28721, 28714, 28704, 28793, 28792, 28726, 28722, 28725, 28783, 28718, 28777, 28709, 28711, 28770, 28708, 28782, 28784, 28728, 28707, 28710, 28775, 28702, 28729, 28785};
        getCurrencyIso4217Code = (char) 17884;
        getMediationNetwork = new char[]{5817, 23451, 36062, 61731, 8823, 2558, 17613, 37771, 61028, 15658, 34827, 50898, 5546, 2518, 17635, 37821, 61002, 15645, 34862, 50876, 5513, 24645, 48924, 2593, 22756, 38793, 57934, 12645, 35888, 56055, 10690, 25695, 45923, 3646, 23690, 43927, 59051, 13689, 32882, 57043, 11679, 30908, 46962, 588, 20699, 44936, 64161, 18801, 33814, 53964, 8675, 31923, 52032, 1626, 21650, 34848, 50461, 4688, 28579, 48378, 2544, 18187, 37997, 57784, 16103, 35802, 55588, 5759, 25528, 45215, 15744, 28861, 42977, 55813, 2374, 48242, 62121, 8593, 21528, 35661, 15969, 27810, 41943, 54815, 1395, 47214, 61090, 7623, 20492, 34616, 14951, 26837, 40943, 53982, 261, 46167, 60080, 6645, 19648, 33556, 13950, 25767, 39904, 52957, 32002, 45170, 59053, 38308, 55431, 4057, 29238, 41341, 5208, 23197, 35322, 64565, 9056, 38465, 2454, 17650, 2519, 17639, 37792, 61040, 15690, 34844, 50941, 5506, 24661, 48919, 2660, 22771, 38810, 57928, 12643, 35884, 28263, 8963, 62484, 35239, 23224, 61386, 41309, 29294, 2017, 55537, 28103, 16196, 61489, 34303, 22236, 60290};
        component4 = 8166711332525589634L;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0198 A[Catch: Exception -> 0x0331, TryCatch #5 {Exception -> 0x0331, blocks: (B:22:0x0166, B:24:0x0198, B:25:0x01bf, B:28:0x01d3, B:32:0x0203), top: B:60:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getMonetizationNetwork() {
        long j;
        int i;
        String string;
        float f;
        Intent intentRegisterReceiver;
        String str;
        int i2;
        String string2;
        String string3;
        String strIntern;
        int i3 = 2 % 2;
        try {
            Map<String, Object> map = this.getMonetizationNetwork;
            try {
                Object[] objArr = new Object[1];
                a((byte) (TextUtils.indexOf((CharSequence) "", '0') + 30), "\u0017)\u0004'\u0016\u000e& \"\u0019\u0012\u0016", 12 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr);
                string2 = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.getMonetizationNetwork;
                i = 4;
                try {
                    Object[] objArr2 = new Object[1];
                    b((char) (TextUtils.getOffsetAfter("", 0) + 33270), 15 - KeyEvent.normalizeMetaState(0), Color.rgb(0, 0, 0) + 16777271, objArr2);
                    string3 = map2.get(((String) objArr2[0]).intern()).toString();
                    Object[] objArr3 = new Object[1];
                    a((byte) (122 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), "\u0013\u001e#\"\"/", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 5, objArr3);
                    strIntern = ((String) objArr3[0]).intern();
                    j = 0;
                } catch (Exception e) {
                    e = e;
                    j = 0;
                }
            } catch (Exception e2) {
                e = e2;
                j = 0;
                i = 4;
                Object[] objArr4 = new Object[1];
                a((byte) (91 - View.resolveSize(0, 0)), ".%\"\u0012\r\u000e\u0017\r\u0019%\u0002&\u0015\u0016\u000b%&\u0001.%\u0012&\u0014\u0019\u001c\u0019\u0010-\u0005\u0018(&\u0001\u0018\u0017\r\u0019%", 38 - (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), objArr4);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr4[0]).intern(), e);
                StringBuilder sb = new StringBuilder();
                Object[] objArr5 = new Object[1];
                a((byte) (View.combineMeasuredStates(0, 0) + 83), ")\u0017\u0017\u0007(%\u0002-&\u0012.\u0019\u0019\"\u0018\u000e-\u0002\u0019(&\u0002\u0017\u0015\u0010\u001e&\u0004\u001c\u0017!\u0004\u0004&0\u0005. \u001c\u0019\u001f\u0014\u0005\u0004", MotionEvent.axisFromString("") + 45, objArr5);
                AFLogger.afRDLog(sb.append(((String) objArr5[0]).intern()).append(e).toString());
                StringBuilder sb2 = new StringBuilder("");
                Object[] objArr6 = new Object[1];
                a((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 80), "0\u0016.$\u0019)/\u0014\u0006*+$#&\r*#\"", 18 - (ViewConfiguration.getScrollBarSize() >> 8), objArr6);
                string = sb2.append(((String) objArr6[0]).intern()).toString();
                String str2 = string;
                Context context = this.AFAdRevenueData;
                Object[] objArr7 = new Object[1];
                b((char) (ExpandableListView.getPackedPositionChild(j) + 13394), Color.alpha(0) + 37, (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 69, objArr7);
                intentRegisterReceiver = context.registerReceiver(null, new IntentFilter(((String) objArr7[0]).intern()));
                int intExtra = -2700;
                if (intentRegisterReceiver != null) {
                }
                str = this.AFAdRevenueData.getApplicationInfo().nativeLibraryDir;
                if (str == null) {
                }
                Object[] objArr8 = new Object[1];
                b((char) (ViewConfiguration.getPressedStateDuration() >> 16), ExpandableListView.getPackedPositionChild(j) + 17, ImageFormat.getBitsPerPixel(0) + Imgproc.COLOR_YUV2RGBA_YVYU, objArr8);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr8[0]).intern(), e);
                StringBuilder sb3 = new StringBuilder();
                Object[] objArr9 = new Object[1];
                a((byte) ((ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)) + 82), ")\u0017\u0017\u0007(%\u0002-&\u0012.\u0019\u0019\"\u0018\u000e-\u0002\u0019(&\u0002\u0017\u0015\u0010\u001e&\u0004\u001c\u0017!\u0004\u0004&0\u0005. \u001c\u0019\u001f\u0014\u0005\u0004", View.combineMeasuredStates(0, 0) + 44, objArr9);
                AFLogger.afRDLog(sb3.append(((String) objArr9[0]).intern()).append(e).toString());
                StringBuilder sbAppend = new StringBuilder().append(str2);
                Object[] objArr10 = new Object[1];
                b((char) (Color.alpha(0) + 26545), 16 - KeyEvent.getDeadChar(0, 0), 137 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)), objArr10);
                return sbAppend.append(((String) objArr10[0]).intern()).toString();
            }
            try {
                Object[] objArr11 = new Object[1];
                a((byte) (53 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), "\u000f\u0013\u0005\"㗥", 4 - TextUtils.lastIndexOf("", '0', 0, 0), objArr11);
                string = new StringBuilder("").append(AFj1jSDK.getCurrencyIso4217Code(new StringBuilder().append(string2).append(string3).append(strIntern.replaceAll(((String) objArr11[0]).intern(), "")).toString()).substring(0, 16)).toString();
            } catch (Exception e3) {
                e = e3;
                Object[] objArr42 = new Object[1];
                a((byte) (91 - View.resolveSize(0, 0)), ".%\"\u0012\r\u000e\u0017\r\u0019%\u0002&\u0015\u0016\u000b%&\u0001.%\u0012&\u0014\u0019\u001c\u0019\u0010-\u0005\u0018(&\u0001\u0018\u0017\r\u0019%", 38 - (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), objArr42);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr42[0]).intern(), e);
                StringBuilder sb4 = new StringBuilder();
                Object[] objArr52 = new Object[1];
                a((byte) (View.combineMeasuredStates(0, 0) + 83), ")\u0017\u0017\u0007(%\u0002-&\u0012.\u0019\u0019\"\u0018\u000e-\u0002\u0019(&\u0002\u0017\u0015\u0010\u001e&\u0004\u001c\u0017!\u0004\u0004&0\u0005. \u001c\u0019\u001f\u0014\u0005\u0004", MotionEvent.axisFromString("") + 45, objArr52);
                AFLogger.afRDLog(sb4.append(((String) objArr52[0]).intern()).append(e).toString());
                StringBuilder sb22 = new StringBuilder("");
                Object[] objArr62 = new Object[1];
                a((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 80), "0\u0016.$\u0019)/\u0014\u0006*+$#&\r*#\"", 18 - (ViewConfiguration.getScrollBarSize() >> 8), objArr62);
                string = sb22.append(((String) objArr62[0]).intern()).toString();
            }
        } catch (Exception e4) {
            e = e4;
        }
        String str22 = string;
        try {
            Context context2 = this.AFAdRevenueData;
            Object[] objArr72 = new Object[1];
            b((char) (ExpandableListView.getPackedPositionChild(j) + 13394), Color.alpha(0) + 37, (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 69, objArr72);
            intentRegisterReceiver = context2.registerReceiver(null, new IntentFilter(((String) objArr72[0]).intern()));
            int intExtra2 = -2700;
            if (intentRegisterReceiver != null) {
                Object[] objArr12 = new Object[1];
                b((char) (40032 - (ViewConfiguration.getEdgeSlop() >> 16)), View.getDefaultSize(0, 0) + 11, TextUtils.getOffsetAfter("", 0) + 107, objArr12);
                intExtra2 = intentRegisterReceiver.getIntExtra(((String) objArr12[0]).intern(), -2700);
            }
            str = this.AFAdRevenueData.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                int i4 = component1 + 71;
                component2 = i4 % 128;
                int i5 = i4 % 2;
                Object[] objArr13 = new Object[1];
                a((byte) ((ViewConfiguration.getTapTimeout() >> 16) + 114), "*!㘞", TextUtils.indexOf("", "", 0, 0) + 3, objArr13);
                if (str.contains(((String) objArr13[0]).intern())) {
                    int i6 = component1 + 77;
                    component2 = i6 % 128;
                    int i7 = i6 % 2;
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                Context context3 = this.AFAdRevenueData;
                Object[] objArr14 = new Object[1];
                a((byte) (Color.rgb(0, 0, 0) + 16777322), " &\u0018& \u0014", View.resolveSizeAndState(0, 0, 0) + 6, objArr14);
                int size = ((SensorManager) context3.getSystemService(((String) objArr14[0]).intern())).getSensorList(-1).size();
                StringBuilder sb5 = new StringBuilder();
                f = 0.0f;
                try {
                    Object[] objArr15 = new Object[1];
                    a((byte) (View.MeasureSpec.getSize(0) + 35), "㘛", 1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr15);
                    StringBuilder sbAppend2 = sb5.append(((String) objArr15[0]).intern()).append(intExtra2);
                    Object[] objArr16 = new Object[1];
                    a((byte) (KeyEvent.keyCodeFromString("") + 69), ".0", (ViewConfiguration.getWindowTouchSlop() >> 8) + 2, objArr16);
                    StringBuilder sbAppend3 = sbAppend2.append(((String) objArr16[0]).intern()).append(i2);
                    Object[] objArr17 = new Object[1];
                    a((byte) (121 - View.getDefaultSize(0, 0)), "\u0003&", (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)) + 1, objArr17);
                    StringBuilder sbAppend4 = sbAppend3.append(((String) objArr17[0]).intern()).append(size);
                    Object[] objArr18 = new Object[1];
                    b((char) (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1, TextUtils.lastIndexOf("", '0') + 119, objArr18);
                    String string4 = sbAppend4.append(((String) objArr18[0]).intern()).append(this.getMonetizationNetwork.size()).toString();
                    StringBuilder sbAppend5 = new StringBuilder().append(str22);
                    byte[] revenue = AFa1tSDK.getRevenue(AFa1tSDK.getCurrencyIso4217Code(string4));
                    StringBuilder sb6 = new StringBuilder();
                    for (byte b : revenue) {
                        String hexString = Integer.toHexString(b);
                        if (hexString.length() == 1) {
                            hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
                        }
                        sb6.append(hexString);
                    }
                    String string5 = sbAppend5.append(sb6.toString()).toString();
                    int i8 = component2 + 59;
                    component1 = i8 % 128;
                    if (i8 % 2 == 0) {
                        return string5;
                    }
                    int i9 = i / i;
                    return string5;
                } catch (Exception e5) {
                    e = e5;
                }
            }
        } catch (Exception e6) {
            e = e6;
            f = 0.0f;
        }
        Object[] objArr82 = new Object[1];
        b((char) (ViewConfiguration.getPressedStateDuration() >> 16), ExpandableListView.getPackedPositionChild(j) + 17, ImageFormat.getBitsPerPixel(0) + Imgproc.COLOR_YUV2RGBA_YVYU, objArr82);
        AFLogger.afErrorLogForExcManagerOnly(((String) objArr82[0]).intern(), e);
        StringBuilder sb32 = new StringBuilder();
        Object[] objArr92 = new Object[1];
        a((byte) ((ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)) + 82), ")\u0017\u0017\u0007(%\u0002-&\u0012.\u0019\u0019\"\u0018\u000e-\u0002\u0019(&\u0002\u0017\u0015\u0010\u001e&\u0004\u001c\u0017!\u0004\u0004&0\u0005. \u001c\u0019\u001f\u0014\u0005\u0004", View.combineMeasuredStates(0, 0) + 44, objArr92);
        AFLogger.afRDLog(sb32.append(((String) objArr92[0]).intern()).append(e).toString());
        StringBuilder sbAppend6 = new StringBuilder().append(str22);
        Object[] objArr102 = new Object[1];
        b((char) (Color.alpha(0) + 26545), 16 - KeyEvent.getDeadChar(0, 0), 137 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)), objArr102);
        return sbAppend6.append(((String) objArr102[0]).intern()).toString();
    }

    private String getRevenue() {
        int i = 2 % 2;
        try {
            String string = Integer.toString(Build.VERSION.SDK_INT);
            Map<String, Object> map = this.getMonetizationNetwork;
            Object[] objArr = new Object[1];
            a((byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30), "\u0017)\u0004'\u0016\u000e& \"\u0019\u0012\u0016", (ViewConfiguration.getWindowTouchSlop() >> 8) + 12, objArr);
            String string2 = map.get(((String) objArr[0]).intern()).toString();
            Map<String, Object> map2 = this.getMonetizationNetwork;
            Object[] objArr2 = new Object[1];
            b((char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 8044), TextUtils.getOffsetAfter("", 0) + 5, ViewConfiguration.getMinimumFlingVelocity() >> 16, objArr2);
            String string3 = map2.get(((String) objArr2[0]).intern()).toString();
            if (string3 == null) {
                int i2 = component2 + 47;
                component1 = i2 % 128;
                int i3 = i2 % 2;
                Object[] objArr3 = new Object[1];
                b((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 8 - (Process.myTid() >> 22), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 5, objArr3);
                string3 = ((String) objArr3[0]).intern();
            }
            StringBuilder sb = new StringBuilder(string2);
            sb.reverse();
            StringBuilder sbAFAdRevenueData = AFAdRevenueData(string, string3, sb.toString());
            int length = sbAFAdRevenueData.length();
            if (length > 4) {
                sbAFAdRevenueData.delete(4, length);
            } else {
                while (length < 4) {
                    int i4 = component2 + 103;
                    component1 = i4 % 128;
                    if (i4 % 2 != 0) {
                        length += 9;
                        sbAFAdRevenueData.append('Y');
                    } else {
                        length++;
                        sbAFAdRevenueData.append('1');
                    }
                }
            }
            Object[] objArr4 = new Object[1];
            a((byte) (17 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), "\u0019(㘍", 3 - ExpandableListView.getPackedPositionGroup(0L), objArr4);
            sbAFAdRevenueData.insert(0, ((String) objArr4[0]).intern());
            return sbAFAdRevenueData.toString();
        } catch (Exception e) {
            Object[] objArr5 = new Object[1];
            a((byte) (TextUtils.lastIndexOf("", '0', 0) + 50), "\u0002-.'\u000e\r\u0019&-\u0000)\u0017\u0017\u0007(%\u0002-&\u0012.\u0019\u0019\"\u0018\u000e-\u0002\u0019(&\u0002\u0019(-\u0000\u001c\u0017!\u0004", (KeyEvent.getMaxKeyCode() >> 16) + 40, objArr5);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e);
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr6 = new Object[1];
            b((char) (ViewConfiguration.getPressedStateDuration() >> 16), MotionEvent.axisFromString("") + 43, TextUtils.getOffsetBefore("", 0) + 13, objArr6);
            AFLogger.afRDLog(sb2.append(((String) objArr6[0]).intern()).append(e).toString());
            Object[] objArr7 = new Object[1];
            a((byte) (ImageFormat.getBitsPerPixel(0) + 17), "\u0019($\u001e㖳㖳㖳", (Process.myPid() >> 22) + 7, objArr7);
            return ((String) objArr7[0]).intern();
        }
    }
}
