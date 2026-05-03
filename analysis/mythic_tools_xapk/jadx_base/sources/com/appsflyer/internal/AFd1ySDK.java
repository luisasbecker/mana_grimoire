package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1bSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1ySDK implements AFc1aSDK {
    private final AFc1fSDK getMonetizationNetwork;

    public AFd1ySDK(AFc1fSDK aFc1fSDK) {
        Intrinsics.checkNotNullParameter(aFc1fSDK, "");
        this.getMonetizationNetwork = aFc1fSDK;
    }

    private final File getMonetizationNetwork() {
        Context context = this.getMonetizationNetwork.getCurrencyIso4217Code;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088 A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x000e, B:9:0x001b, B:24:0x0078, B:25:0x007b, B:21:0x0051, B:26:0x007e, B:28:0x0088, B:10:0x001d, B:12:0x0023, B:14:0x0033, B:16:0x0047, B:17:0x004a, B:18:0x004d), top: B:36:0x0001, inners: #0 }] */
    @Override // com.appsflyer.internal.AFc1aSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<AFc1bSDK> AFAdRevenueData() {
        List<AFc1bSDK> listEmptyList;
        File[] fileArrListFiles;
        ArrayList arrayList;
        File[] fileArrListFiles2;
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            listEmptyList = null;
            if (monetizationNetwork != null && (fileArrListFiles = monetizationNetwork.listFiles()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (File file : fileArrListFiles) {
                    try {
                        fileArrListFiles2 = file.listFiles();
                    } catch (Throwable th) {
                        AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "Could not get stored exceptions\n " + th.getMessage(), false, 4, null);
                    }
                    if (fileArrListFiles2 != null) {
                        Intrinsics.checkNotNullExpressionValue(fileArrListFiles2, "");
                        ArrayList arrayList3 = new ArrayList();
                        for (File file2 : fileArrListFiles2) {
                            AFc1bSDK.Companion companion = AFc1bSDK.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(file2, "");
                            AFc1bSDK aFc1bSDKAFAdRevenueData = AFc1bSDK.Companion.AFAdRevenueData(FilesKt.readText$default(file2, null, 1, null));
                            if (aFc1bSDKAFAdRevenueData != null) {
                                arrayList3.add(aFc1bSDKAFAdRevenueData);
                            }
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        arrayList2.add(arrayList);
                    }
                }
                listEmptyList = CollectionsKt.flatten(arrayList2);
                if (listEmptyList == null) {
                }
            } else if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
        }
        return listEmptyList;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final void AFAdRevenueData(int i, int i2) {
        File[] fileArrListFiles;
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            if (monetizationNetwork != null && (fileArrListFiles = monetizationNetwork.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                ArrayList arrayList = new ArrayList();
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "");
                    int iAFAdRevenueData = AFj1aSDK.AFAdRevenueData(name);
                    if (i > iAFAdRevenueData || iAFAdRevenueData > i2) {
                        arrayList.add(file);
                    }
                }
                ArrayList<File> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (File file2 : arrayList2) {
                    Intrinsics.checkNotNullExpressionValue(file2, "");
                    arrayList3.add(Boolean.valueOf(FilesKt.deleteRecursively(file2)));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final String getCurrencyIso4217Code(Throwable th, String str) {
        String str2;
        File file;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            str2 = null;
            if (monetizationNetwork != null) {
                file = new File(monetizationNetwork, "6.18.0");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                file = null;
            }
            if (file != null) {
                try {
                    AFc1bSDK aFc1bSDKAFAdRevenueData = AFd1tSDK.AFAdRevenueData(th, str);
                    String str3 = aFc1bSDKAFAdRevenueData.getMonetizationNetwork;
                    File file2 = new File(file, str3);
                    if (file2.exists()) {
                        AFc1bSDK.Companion companion = AFc1bSDK.INSTANCE;
                        AFc1bSDK aFc1bSDKAFAdRevenueData2 = AFc1bSDK.Companion.AFAdRevenueData(FilesKt.readText$default(file2, null, 1, null));
                        if (aFc1bSDKAFAdRevenueData2 != null) {
                            aFc1bSDKAFAdRevenueData2.getRevenue++;
                            aFc1bSDKAFAdRevenueData = aFc1bSDKAFAdRevenueData2;
                        }
                    }
                    FilesKt.writeText$default(file2, aFc1bSDKAFAdRevenueData.getRevenue(), null, 2, null);
                    str2 = str3;
                } catch (Exception e) {
                    AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "Could not cache exception\n " + e.getMessage(), false, 4, null);
                }
            }
        }
        return str2;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final boolean getMediationNetwork() {
        return getRevenue(new String[0]);
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final int getRevenue() {
        Iterator<T> it = AFAdRevenueData().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((AFc1bSDK) it.next()).getRevenue;
        }
        return i;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final boolean getRevenue(String... strArr) {
        boolean zDeleteRecursively;
        Intrinsics.checkNotNullParameter(strArr, "");
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            zDeleteRecursively = true;
            if (monetizationNetwork != null) {
                if (strArr.length == 0) {
                    AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions", false, 4, null);
                    zDeleteRecursively = FilesKt.deleteRecursively(monetizationNetwork);
                } else {
                    AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions except for: " + ArraysKt.joinToString$default(strArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), false, 4, null);
                    File[] fileArrListFiles = monetizationNetwork.listFiles();
                    if (fileArrListFiles != null) {
                        Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                        ArrayList arrayList = new ArrayList();
                        for (File file : fileArrListFiles) {
                            if (!ArraysKt.contains(strArr, file.getName())) {
                                arrayList.add(file);
                            }
                        }
                        ArrayList<File> arrayList2 = arrayList;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                        for (File file2 : arrayList2) {
                            Intrinsics.checkNotNullExpressionValue(file2, "");
                            arrayList3.add(Boolean.valueOf(FilesKt.deleteRecursively(file2)));
                        }
                        Set set = CollectionsKt.toSet(arrayList3);
                        if (set.isEmpty()) {
                            set = SetsKt.setOf(Boolean.TRUE);
                        }
                        Set set2 = set;
                        if (set2.size() != 1 || !((Boolean) CollectionsKt.first(set2)).booleanValue()) {
                            zDeleteRecursively = false;
                        }
                    }
                }
            }
        }
        return zDeleteRecursively;
    }
}
