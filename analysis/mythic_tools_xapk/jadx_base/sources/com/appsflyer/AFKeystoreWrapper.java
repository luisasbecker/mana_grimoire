package com.appsflyer;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
public class AFKeystoreWrapper {
    private Context getCurrencyIso4217Code;
    public KeyStore getRevenue;
    public final Object getMediationNetwork = new Object();
    public String AFAdRevenueData = "";
    public int getMonetizationNetwork = 0;

    public AFKeystoreWrapper(Context context) {
        this.getCurrencyIso4217Code = context;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.getRevenue = keyStore;
            keyStore.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e);
        }
    }

    private static boolean getMonetizationNetwork(String str) {
        return str.startsWith("com.appsflyer");
    }

    public final String AFAdRevenueData() {
        String str;
        synchronized (this.getMediationNetwork) {
            str = this.AFAdRevenueData;
        }
        return str;
    }

    public final int getCurrencyIso4217Code() {
        int i;
        synchronized (this.getMediationNetwork) {
            i = this.getMonetizationNetwork;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        r1 = r3.split(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r1.length != 3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r3)));
        r2 = true;
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        if (r3.length != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r1.length != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        r6.AFAdRevenueData = r3[1].trim();
        r6.getMonetizationNetwork = java.lang.Integer.parseInt(r1[1].trim());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getMediationNetwork() {
        boolean z;
        synchronized (this.getMediationNetwork) {
            KeyStore keyStore = this.getRevenue;
            z = false;
            if (keyStore != null) {
                try {
                    Enumeration<String> enumerationAliases = keyStore.aliases();
                    while (true) {
                        if (!enumerationAliases.hasMoreElements()) {
                            break;
                        }
                        String strNextElement = enumerationAliases.nextElement();
                        if (strNextElement != null && getMonetizationNetwork(strNextElement)) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    AFLogger.afErrorLog(new StringBuilder("Couldn't list KeyStore Aliases: ").append(th.getClass().getName()).toString(), th);
                }
            }
        }
        return z;
    }

    public final String getRevenue() {
        StringBuilder sb = new StringBuilder("com.appsflyer,KSAppsFlyerId=");
        synchronized (this.getMediationNetwork) {
            sb.append(this.AFAdRevenueData).append(",KSAppsFlyerRICounter=");
            sb.append(this.getMonetizationNetwork);
        }
        return sb.toString();
    }

    public final void getRevenue(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 5);
            synchronized (this.getMediationNetwork) {
                if (this.getRevenue.containsAlias(str)) {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                } else {
                    KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator.initialize(keyGenParameterSpecBuild);
                    keyPairGenerator.generateKeyPair();
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(new StringBuilder("Exception ").append(th.getMessage()).append(" occurred").toString(), th);
        }
    }
}
