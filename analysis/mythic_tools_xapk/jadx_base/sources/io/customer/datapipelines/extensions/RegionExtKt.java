package io.customer.datapipelines.extensions;

import io.customer.sdk.data.model.Region;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegionExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"apiHost", "", "Lio/customer/sdk/data/model/Region;", "cdnHost", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RegionExtKt {
    public static final String apiHost(Region region) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        if (Intrinsics.areEqual(region, Region.US.INSTANCE)) {
            return "cdp.customer.io/v1";
        }
        if (Intrinsics.areEqual(region, Region.EU.INSTANCE)) {
            return "cdp-eu.customer.io/v1";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String cdnHost(Region region) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        if (Intrinsics.areEqual(region, Region.US.INSTANCE)) {
            return "cdp.customer.io/v1";
        }
        if (Intrinsics.areEqual(region, Region.EU.INSTANCE)) {
            return "cdp-eu.customer.io/v1";
        }
        throw new NoWhenBranchMatchedException();
    }
}
