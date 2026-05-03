package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.appsflyer.AFLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1lSDK {
    private static AFf1lSDK getMonetizationNetwork;
    private final Map<String, String> getMediationNetwork = new HashMap<String, String>() { // from class: com.appsflyer.internal.AFf1lSDK.5
        {
            put("aa", "ro.arch");
            put("ab", "ro.chipname");
            put("ac", "ro.dalvik.vm.native.bridge");
            put("ad", "persist.sys.nativebridge");
            put("ae", "ro.enable.native.bridge.exec");
            put("af", "dalvik.vm.isa.x86.features");
            put("ag", "dalvik.vm.isa.x86.variant");
            put("ah", "ro.zygote");
            put("ai", "ro.allow.mock.location");
            put("aj", "ro.dalvik.vm.isa.arm");
            put("ak", "dalvik.vm.isa.arm.features");
            put("al", "dalvik.vm.isa.arm.variant");
            put("am", "dalvik.vm.isa.arm64.features");
            put("an", "dalvik.vm.isa.arm64.variant");
            put("ao", "vzw.os.rooted");
            put("ap", "ro.build.user");
            put("aq", "ro.kernel.qemu");
            put("ar", "ro.hardware");
            put("as", "ro.product.cpu.abi");
            put("at", "ro.product.cpu.abilist");
            put("au", "ro.product.cpu.abilist32");
            put("av", "ro.product.cpu.abilist64");
        }
    };

    enum AFa1tSDK {
        XPOSED("xps"),
        FRIDA("frd");

        String getMonetizationNetwork;

        AFa1tSDK(String str) {
            this.getMonetizationNetwork = str;
        }
    }

    enum AFa1uSDK {
        HOOKING("hk"),
        DEBUGGABLE("dbg");

        String getCurrencyIso4217Code;

        AFa1uSDK(String str) {
            this.getCurrencyIso4217Code = str;
        }
    }

    private AFf1lSDK() {
    }

    private AFg1iSDK AFAdRevenueData(Context context) {
        AFg1iSDK aFg1iSDK = new AFg1iSDK();
        try {
            aFg1iSDK.getRevenue(AFa1uSDK.HOOKING.getCurrencyIso4217Code, AFAdRevenueData());
            aFg1iSDK.getRevenue(AFa1uSDK.DEBUGGABLE.getCurrencyIso4217Code, Boolean.valueOf(getRevenue(context)));
            return aFg1iSDK;
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("failed to perform analysis checks", th);
            return aFg1iSDK;
        }
    }

    private static String AFAdRevenueData() {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = Thread.getAllStackTraces().entrySet().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                for (StackTraceElement stackTraceElement : it.next().getValue()) {
                    if (stackTraceElement.toString().contains("de.robv.android.xposed") && i2 <= 2) {
                        i2++;
                        sb.append(AFa1tSDK.XPOSED.getMonetizationNetwork);
                        if (stackTraceElement.getMethodName().equals("main")) {
                            sb.append("+a");
                        }
                        if (stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                            sb.append("+h");
                        }
                        sb.append(";");
                    }
                    if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
                        i++;
                    }
                }
            }
            if (i > 1) {
                sb.append("mz;");
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("hooking check error", th);
        }
        try {
            if (getCurrencyIso4217Code(new StringBuilder("/proc/").append(Process.myPid()).append("/maps").toString(), "frida")) {
                sb.append(AFa1tSDK.FRIDA.getMonetizationNetwork);
                if (Build.VERSION.SDK_INT < 29 && getCurrencyIso4217Code("/proc/net/tcp", "69A2")) {
                    sb.append("+prt");
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("frida detection error", e);
            sb.append(e.getMessage().toLowerCase(Locale.getDefault()));
        }
        sb.append(";");
        return sb.toString();
    }

    private static boolean AFAdRevenueData(String str) {
        return str.matches("\\d+");
    }

    private AFg1iSDK getCurrencyIso4217Code() throws Throwable {
        AFg1iSDK aFg1iSDK = new AFg1iSDK();
        try {
            for (Map.Entry<String, String> entry : this.getMediationNetwork.entrySet()) {
                String currencyIso4217Code = getCurrencyIso4217Code(entry.getValue());
                if (currencyIso4217Code != null && !currencyIso4217Code.equals("")) {
                    aFg1iSDK.getRevenue(entry.getKey(), currencyIso4217Code);
                }
            }
            return aFg1iSDK;
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("failed to create props", e);
            return aFg1iSDK;
        }
    }

    private static String getCurrencyIso4217Code(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("error in props rfl", e);
            return null;
        }
    }

    private static boolean getCurrencyIso4217Code(String str, String str2) throws Exception {
        String line;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, Charset.defaultCharset()));
            String lowerCase = str2.toLowerCase(Locale.getDefault());
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    fileInputStream.close();
                    return false;
                }
            } while (!new HashSet(Arrays.asList(line.toLowerCase(Locale.getDefault()).split("[\\s.,\\]\\-:/_\\[]"))).contains(lowerCase));
            bufferedReader.close();
            fileInputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly("FNF", e);
            throw new Exception("FNF");
        } catch (IOException e2) {
            AFLogger.afErrorLogForExcManagerOnly("IOF", e2);
            throw new Exception("IOF");
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("GF", e3);
            throw new Exception("GF");
        }
    }

    public static AFf1lSDK getRevenue() {
        if (getMonetizationNetwork == null) {
            getMonetizationNetwork = new AFf1lSDK();
        }
        return getMonetizationNetwork;
    }

    private static boolean getRevenue(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getMediationNetwork(Context context, String str) throws Throwable {
        if (str != null) {
            try {
                str = AFAdRevenueData(str) ? null : "invalid timestamp";
            } catch (Exception e) {
                AFLogger.afErrorLogForExcManagerOnly("could not get anti fraud data", e);
                return str;
            }
        }
        AFg1iSDK aFg1iSDK = new AFg1iSDK();
        aFg1iSDK.getRevenue("pr", getCurrencyIso4217Code());
        aFg1iSDK.getRevenue("an", AFAdRevenueData(context));
        return aFg1iSDK;
    }
}
