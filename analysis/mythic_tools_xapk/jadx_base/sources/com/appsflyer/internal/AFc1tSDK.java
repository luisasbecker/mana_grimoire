package com.appsflyer.internal;

import android.content.Context;
import android.util.Base64;
import com.appsflyer.AFLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFc1tSDK implements AFc1vSDK {
    private final AFc1fSDK AFAdRevenueData;
    private final AFc1jSDK getMediationNetwork;
    private final AFc1sSDK getMonetizationNetwork;
    private final Map<String, Integer> getRevenue;

    public AFc1tSDK(AFc1fSDK aFc1fSDK, AFc1jSDK aFc1jSDK) {
        Intrinsics.checkNotNullParameter(aFc1fSDK, "");
        Intrinsics.checkNotNullParameter(aFc1jSDK, "");
        this.AFAdRevenueData = aFc1fSDK;
        this.getMediationNetwork = aFc1jSDK;
        this.getMonetizationNetwork = new AFc1sSDK(CollectionsKt.listOf((Object[]) new AFc1uSDK[]{new AFc1uSDK("ConversionsCache", CollectionsKt.listOf(AFe1lSDK.CONVERSION), 1), new AFc1uSDK("AttrCache", CollectionsKt.listOf(AFe1lSDK.ATTR), 1), new AFc1uSDK("OtherCache", CollectionsKt.listOf((Object[]) new AFe1lSDK[]{AFe1lSDK.LAUNCH, AFe1lSDK.INAPP, AFe1lSDK.ADREVENUE, AFe1lSDK.ARS_VALIDATE, AFe1lSDK.PURCHASE_VALIDATE, AFe1lSDK.MANUAL_PURCHASE_VALIDATION, AFe1lSDK.SDK_SERVICES}), 40)}));
        this.getRevenue = MapsKt.mutableMapOf(TuplesKt.to("ConversionsCache", 0), TuplesKt.to("AttrCache", 0), TuplesKt.to("OtherCache", 0));
    }

    private final AFc1uSDK AFAdRevenueData(AFe1lSDK aFe1lSDK) {
        Object next;
        Iterator<T> it = this.getMonetizationNetwork.getRevenue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AFc1uSDK) next).getMonetizationNetwork.contains(aFe1lSDK)) {
                break;
            }
        }
        return (AFc1uSDK) next;
    }

    private final boolean AFAdRevenueData(File file) {
        try {
            file.delete();
            getMediationNetwork();
            return true;
        } catch (Exception e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not delete " + file.getName() + " from cache", e, false, false, false, false, 120, null);
            return false;
        }
    }

    private static AFc1rSDK getCurrencyIso4217Code(File file) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charset.defaultCharset());
            try {
                char[] cArr = new char[(int) file.length()];
                inputStreamReader.read(cArr);
                AFc1rSDK aFc1rSDK = new AFc1rSDK(cArr);
                aFc1rSDK.AFAdRevenueData = file.getName();
                CloseableKt.closeFinally(inputStreamReader, null);
                return aFc1rSDK;
            } finally {
            }
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.CACHE, "Error while loading request from cache", e, false, false, true, false);
            return null;
        }
    }

    private final String getMediationNetwork(AFe1lSDK aFe1lSDK) {
        String str;
        AFc1uSDK aFc1uSDKAFAdRevenueData = AFAdRevenueData(aFe1lSDK);
        if (aFc1uSDKAFAdRevenueData == null || (str = aFc1uSDKAFAdRevenueData.getCurrencyIso4217Code) == null) {
            throw new UnsupportedOperationException("Cache do not support this type of events");
        }
        return str;
    }

    private final void getMediationNetwork() {
        for (AFc1uSDK aFc1uSDK : this.getMonetizationNetwork.getRevenue) {
            String str = aFc1uSDK.getCurrencyIso4217Code;
            Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context);
            File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
            if (file.exists()) {
                Map<String, Integer> map = this.getRevenue;
                String str2 = aFc1uSDK.getCurrencyIso4217Code;
                File[] fileArrListFiles = file.listFiles();
                map.put(str2, Integer.valueOf(fileArrListFiles != null ? fileArrListFiles.length : 0));
            } else {
                file.mkdirs();
                this.getRevenue.put(aFc1uSDK.getCurrencyIso4217Code, 0);
            }
        }
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final List<AFc1rSDK> AFAdRevenueData() {
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Get Cached Requests", false, 4, null);
        ArrayList arrayList = new ArrayList();
        ArrayList<File> arrayList2 = new ArrayList();
        try {
            Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context);
            if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                Context context2 = this.AFAdRevenueData.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context2);
                new File(context2.getFilesDir(), "AFRequestCache").mkdir();
            }
            Iterator<T> it = this.getMonetizationNetwork.getRevenue.iterator();
            while (it.hasNext()) {
                String str = ((AFc1uSDK) it.next()).getCurrencyIso4217Code;
                Context context3 = this.AFAdRevenueData.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context3);
                File file = new File(new File(context3.getFilesDir(), "AFRequestCache"), str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    fileArrListFiles = new File[0];
                }
                CollectionsKt.addAll(arrayList2, fileArrListFiles);
            }
            for (File file2 : arrayList2) {
                AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Found cached request: " + file2.getName(), false, 4, null);
                AFc1rSDK currencyIso4217Code = getCurrencyIso4217Code(file2);
                if (currencyIso4217Code != null) {
                    arrayList.add(currencyIso4217Code);
                }
            }
        } catch (Exception e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not get cached requests", e, false, false, false, false, 120, null);
        }
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Found " + arrayList.size() + " Cached Requests", false, 4, null);
        return arrayList;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final void getCurrencyIso4217Code() {
        try {
            if (this.getMediationNetwork.getCurrencyIso4217Code("AF_CACHE_VERSION", -1) == 2) {
                Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context);
                if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                    Context context2 = this.AFAdRevenueData.getCurrencyIso4217Code;
                    Intrinsics.checkNotNull(context2);
                    new File(context2.getFilesDir(), "AFRequestCache").mkdir();
                }
            } else {
                this.getMediationNetwork.AFAdRevenueData("AF_CACHE_VERSION", 2);
                Context context3 = this.AFAdRevenueData.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context3);
                if (new File(context3.getFilesDir(), "AFRequestCache").exists()) {
                    Context context4 = this.AFAdRevenueData.getCurrencyIso4217Code;
                    Intrinsics.checkNotNull(context4);
                    FilesKt.deleteRecursively(new File(context4.getFilesDir(), "AFRequestCache"));
                    Context context5 = this.AFAdRevenueData.getCurrencyIso4217Code;
                    Intrinsics.checkNotNull(context5);
                    new File(context5.getFilesDir(), "AFRequestCache").mkdir();
                }
            }
            getMediationNetwork();
        } catch (Exception e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not init cache", e, false, false, false, false, 120, null);
        }
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final void getMonetizationNetwork() {
        try {
            Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context);
            if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                Context context2 = this.AFAdRevenueData.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context2);
                new File(context2.getFilesDir(), "AFRequestCache").mkdir();
                return;
            }
            Iterator<T> it = this.getMonetizationNetwork.getRevenue.iterator();
            while (it.hasNext()) {
                String str = ((AFc1uSDK) it.next()).getCurrencyIso4217Code;
                Context context3 = this.AFAdRevenueData.getCurrencyIso4217Code;
                Intrinsics.checkNotNull(context3);
                File[] fileArrListFiles = new File(new File(context3.getFilesDir(), "AFRequestCache"), str).listFiles();
                if (fileArrListFiles != null) {
                    Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                    for (File file : fileArrListFiles) {
                        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "ClearCache : Found cached request " + file.getName(), false, 4, null);
                        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Deleting " + file.getName() + " from cache", false, 4, null);
                        file.delete();
                    }
                }
            }
            Context context4 = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context4);
            FilesKt.deleteRecursively(new File(context4.getFilesDir(), "AFRequestCache"));
            getMediationNetwork();
        } catch (Exception e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not clearCache request", e, false, false, false, false, 120, null);
        }
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final boolean getMonetizationNetwork(String str) {
        if (str == null) {
            return false;
        }
        Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
        Intrinsics.checkNotNull(context);
        if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
            Context context2 = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context2);
            new File(context2.getFilesDir(), "AFRequestCache").mkdir();
            return true;
        }
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Deleting " + str + " from cache", false, 4, null);
        Iterator<T> it = this.getMonetizationNetwork.getRevenue.iterator();
        while (it.hasNext()) {
            String str2 = ((AFc1uSDK) it.next()).getCurrencyIso4217Code;
            Context context3 = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context3);
            File file = new File(new File(new File(context3.getFilesDir(), "AFRequestCache"), str2), str);
            if (file.exists()) {
                return AFAdRevenueData(file);
            }
        }
        return true;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final String getRevenue(AFc1rSDK aFc1rSDK) {
        File file;
        String str;
        List listSortedWith;
        List<File> listTake;
        Intrinsics.checkNotNullParameter(aFc1rSDK, "");
        try {
            AFe1lSDK aFe1lSDK = aFc1rSDK.getMonetizationNetwork;
            Intrinsics.checkNotNullExpressionValue(aFe1lSDK, "");
            Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
            Intrinsics.checkNotNull(context);
            File file2 = new File(new File(context.getFilesDir(), "AFRequestCache"), getMediationNetwork(aFe1lSDK));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Caching request with URL: " + aFc1rSDK.getRevenue, false, 4, null);
            String strValueOf = String.valueOf(System.currentTimeMillis());
            file = new File(file2, strValueOf);
            try {
                file.createNewFile();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file.getPath(), true), Charset.defaultCharset());
                try {
                    OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
                    outputStreamWriter2.write("version=");
                    outputStreamWriter2.write(aFc1rSDK.getMediationNetwork);
                    outputStreamWriter2.write(10);
                    outputStreamWriter2.write("url=");
                    outputStreamWriter2.write(aFc1rSDK.getRevenue);
                    outputStreamWriter2.write(10);
                    outputStreamWriter2.write("data=");
                    outputStreamWriter2.write(Base64.encodeToString(aFc1rSDK.getCurrencyIso4217Code(), 2));
                    outputStreamWriter2.write(10);
                    AFe1lSDK aFe1lSDK2 = aFc1rSDK.getMonetizationNetwork;
                    outputStreamWriter2.write("type=");
                    outputStreamWriter2.write(aFe1lSDK2.name());
                    outputStreamWriter2.write(10);
                    Map<String, String> map = aFc1rSDK.getCurrencyIso4217Code;
                    if (map != null && !map.isEmpty()) {
                        outputStreamWriter2.write("headers=");
                        Map<String, String> map2 = aFc1rSDK.getCurrencyIso4217Code;
                        Intrinsics.checkNotNull(map2, "");
                        String string = new JSONObject(map2).toString();
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        byte[] bytes = string.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "");
                        outputStreamWriter2.write(Base64.encodeToString(bytes, 2));
                        outputStreamWriter2.write(10);
                    }
                    outputStreamWriter2.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStreamWriter, null);
                    AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Cache request: done, cacheKey: " + strValueOf, false, 4, null);
                    AFe1lSDK aFe1lSDK3 = aFc1rSDK.getMonetizationNetwork;
                    Intrinsics.checkNotNullExpressionValue(aFe1lSDK3, "");
                    AFc1uSDK aFc1uSDKAFAdRevenueData = AFAdRevenueData(aFe1lSDK3);
                    Integer numValueOf = aFc1uSDKAFAdRevenueData != null ? Integer.valueOf(aFc1uSDKAFAdRevenueData.getMediationNetwork) : null;
                    if (numValueOf == null) {
                        return strValueOf;
                    }
                    int iIntValue = numValueOf.intValue();
                    Map<String, Integer> map3 = this.getRevenue;
                    AFc1uSDK aFc1uSDKAFAdRevenueData2 = AFAdRevenueData(aFe1lSDK3);
                    if (aFc1uSDKAFAdRevenueData2 == null || (str = aFc1uSDKAFAdRevenueData2.getCurrencyIso4217Code) == null) {
                        throw new UnsupportedOperationException("Cache do not support this type of events");
                    }
                    Integer num = map3.get(str);
                    int iIntValue2 = num != null ? num.intValue() : 0;
                    if (iIntValue2 >= iIntValue) {
                        int i = (iIntValue2 + 1) - iIntValue;
                        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Cache overflown for type " + aFe1lSDK3 + ", removing " + i + " item(s)", false, 4, null);
                        Context context2 = this.AFAdRevenueData.getCurrencyIso4217Code;
                        Intrinsics.checkNotNull(context2);
                        File file3 = new File(new File(context2.getFilesDir(), "AFRequestCache"), getMediationNetwork(aFe1lSDK3));
                        if (!file3.exists()) {
                            file3.mkdirs();
                        }
                        File[] fileArrListFiles = file3.listFiles();
                        if (fileArrListFiles != null && (listSortedWith = ArraysKt.sortedWith(fileArrListFiles, new Comparator() { // from class: com.appsflyer.internal.AFc1tSDK.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((File) t).getName(), ((File) t2).getName());
                            }
                        })) != null && (listTake = CollectionsKt.take(listSortedWith, i)) != null) {
                            for (File file4 : listTake) {
                                file4.delete();
                                AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Cache entry " + file4.getName() + " removed", false, 4, null);
                            }
                        }
                    }
                    getMediationNetwork();
                    return strValueOf;
                } finally {
                }
            } catch (Exception e) {
                e = e;
                if (file != null) {
                    file.delete();
                }
                AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not cache request", e, false, false, false, false, 120, null);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        }
    }
}
