package io.customer.sdk.data.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Region.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lio/customer/sdk/data/model/Region;", "", "code", "", "<init>", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "US", "EU", "Companion", "Lio/customer/sdk/data/model/Region$EU;", "Lio/customer/sdk/data/model/Region$US;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Region {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String code;

    /* JADX INFO: compiled from: Region.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lio/customer/sdk/data/model/Region$Companion;", "", "<init>", "()V", "getRegion", "Lio/customer/sdk/data/model/Region;", "region", "", "fallback", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Region getRegion$default(Companion companion, String str, Region region, int i, Object obj) {
            if ((i & 2) != 0) {
                region = US.INSTANCE;
            }
            return companion.getRegion(str, region);
        }

        public final Region getRegion(String region, Region fallback) {
            Object next;
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            String str = region;
            if (str == null || StringsKt.isBlank(str)) {
                return fallback;
            }
            Iterator it = CollectionsKt.listOf((Object[]) new Region[]{US.INSTANCE, EU.INSTANCE}).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (StringsKt.equals(((Region) next).getCode(), region, true)) {
                    break;
                }
            }
            Region region2 = (Region) next;
            return region2 == null ? fallback : region2;
        }
    }

    /* JADX INFO: compiled from: Region.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/customer/sdk/data/model/Region$EU;", "Lio/customer/sdk/data/model/Region;", "<init>", "()V", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EU extends Region {
        public static final EU INSTANCE = new EU();

        private EU() {
            super("eu", null);
        }
    }

    /* JADX INFO: compiled from: Region.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/customer/sdk/data/model/Region$US;", "Lio/customer/sdk/data/model/Region;", "<init>", "()V", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class US extends Region {
        public static final US INSTANCE = new US();

        private US() {
            super("us", null);
        }
    }

    private Region(String str) {
        this.code = str;
    }

    public /* synthetic */ Region(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getCode() {
        return this.code;
    }
}
