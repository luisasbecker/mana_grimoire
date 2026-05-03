package com.google.android.datatransport;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ProductData {
    public static ProductData withProductId(Integer num) {
        return new AutoValue_ProductData(num);
    }

    public abstract Integer getProductId();
}
