package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.common.Constants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1jSDK {
    private final int getMediationNetwork;

    public AFd1jSDK(int i) {
        this.getMediationNetwork = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String AFAdRevenueData(HttpURLConnection httpURLConnection) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        InputStream errorStream;
        InputStreamReader inputStreamReader = null;
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (Exception e) {
                errorStream = httpURLConnection.getErrorStream();
                AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, e.getMessage() != null ? e.getMessage() : "", e, false, false, false, false);
            }
            if (errorStream == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader2 = new InputStreamReader(errorStream, Charset.defaultCharset());
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                boolean z = true;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            String string = sb.toString();
                            inputStreamReader2.close();
                            bufferedReader2.close();
                            return string;
                        }
                        if (!z) {
                            sb.append('\n');
                        }
                        sb.append(line);
                        z = false;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        inputStreamReader = inputStreamReader2;
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (bufferedReader != null) {
            throw th;
        }
        bufferedReader.close();
        throw th;
    }

    public final AFe1ySDK<String> getMonetizationNetwork(AFd1cSDK aFd1cSDK) throws IOException {
        Throwable th;
        byte[] mediationNetwork;
        HttpURLConnection httpURLConnection;
        long jCurrentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            mediationNetwork = aFd1cSDK.getMediationNetwork();
            StringBuilder sb = new StringBuilder(new StringBuilder().append(aFd1cSDK.getMediationNetwork).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).append(aFd1cSDK.AFAdRevenueData).toString());
            byte[] mediationNetwork2 = aFd1cSDK.getMediationNetwork();
            if (aFd1cSDK.getRevenue() && mediationNetwork2 != null) {
                sb.append("\n payload: ").append(aFd1cSDK.getMonetizationNetwork() ? "<encrypted>" : new String(mediationNetwork2, Charset.defaultCharset()));
            }
            for (Map.Entry<String, String> entry : aFd1cSDK.getRevenue.entrySet()) {
                sb.append("\n ").append(entry.getKey()).append(": ").append(entry.getValue());
            }
            AFLogger.INSTANCE.d(AFg1cSDK.HTTP_CLIENT, new StringBuilder("[").append(aFd1cSDK.hashCode()).append("] ").append((Object) sb).toString());
            httpURLConnection = (HttpURLConnection) new URL(aFd1cSDK.AFAdRevenueData).openConnection();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            httpURLConnection.setRequestMethod(aFd1cSDK.getMediationNetwork);
            if (aFd1cSDK.AFAdRevenueData()) {
                httpURLConnection.setUseCaches(false);
            }
            if (!aFd1cSDK.component3()) {
                httpURLConnection.setInstanceFollowRedirects(false);
            }
            int i = this.getMediationNetwork;
            int i2 = aFd1cSDK.areAllFieldsValid;
            if (i2 != -1) {
                i = i2;
            }
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, aFd1cSDK.getMonetizationNetwork() ? "application/octet-stream" : "application/json");
            for (Map.Entry<String, String> entry2 : aFd1cSDK.getRevenue.entrySet()) {
                httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
            }
            if (mediationNetwork != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, new StringBuilder().append(mediationNetwork.length).toString());
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream2.write(mediationNetwork);
                        bufferedOutputStream2.close();
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            boolean z = httpURLConnection.getResponseCode() / 100 == 2;
            String strAFAdRevenueData = aFd1cSDK.getCurrencyIso4217Code() ? AFAdRevenueData(httpURLConnection) : "";
            AFd1dSDK aFd1dSDK = new AFd1dSDK(System.currentTimeMillis() - jCurrentTimeMillis);
            AFLogger.INSTANCE.d(AFg1cSDK.HTTP_CLIENT, new StringBuilder("[").append(aFd1cSDK.hashCode()).append("] ").append(new StringBuilder("response code:").append(httpURLConnection.getResponseCode()).append(" ").append(httpURLConnection.getResponseMessage()).append("\n body:").append(strAFAdRevenueData).append("\n took ").append(aFd1dSDK.AFAdRevenueData).append("ms").toString()).toString());
            HashMap map = new HashMap(httpURLConnection.getHeaderFields());
            map.remove(null);
            AFe1ySDK<String> aFe1ySDK = new AFe1ySDK<>(strAFAdRevenueData, httpURLConnection.getResponseCode(), z, map, aFd1dSDK);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return aFe1ySDK;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection2 = httpURLConnection;
            try {
                AFd1dSDK aFd1dSDK2 = new AFd1dSDK(System.currentTimeMillis() - jCurrentTimeMillis);
                AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, new StringBuilder("[").append(aFd1cSDK.hashCode()).append("] ").append(new StringBuilder("error: ").append(th).append("\n took ").append(aFd1dSDK2.AFAdRevenueData).append("ms").toString()).toString(), th, false, false, false);
                throw new HttpException(th, aFd1dSDK2);
            } catch (Throwable th6) {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th6;
            }
        }
    }
}
