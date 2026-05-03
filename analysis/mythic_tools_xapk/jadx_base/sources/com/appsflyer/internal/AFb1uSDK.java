package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class AFb1uSDK {
    public final String[] getRevenue;

    public AFb1uSDK(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            this.getRevenue = null;
            return;
        }
        Pattern patternCompile = Pattern.compile("[\\w]{1,45}");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null || !patternCompile.matcher(str).matches()) {
                AFLogger.afWarnLog("Invalid partner name: ".concat(String.valueOf(str)));
            } else {
                arrayList.add(str.toLowerCase(Locale.getDefault()));
            }
        }
        if (arrayList.contains(SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL)) {
            this.getRevenue = new String[]{SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL};
        } else if (arrayList.isEmpty()) {
            this.getRevenue = null;
        } else {
            this.getRevenue = (String[]) arrayList.toArray(new String[0]);
        }
    }
}
