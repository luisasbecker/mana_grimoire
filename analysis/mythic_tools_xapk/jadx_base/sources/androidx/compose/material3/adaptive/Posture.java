package androidx.compose.material3.adaptive;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Posture.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/adaptive/Posture;", "", "isTabletop", "", "hingeList", "", "Landroidx/compose/material3/adaptive/HingeInfo;", "<init>", "(ZLjava/util/List;)V", "()Z", "getHingeList", "()Ljava/util/List;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "adaptive"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Posture {
    public static final int $stable = 0;
    private final List<HingeInfo> hingeList;
    private final boolean isTabletop;

    /* JADX WARN: Multi-variable type inference failed */
    public Posture() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public Posture(boolean z, List<HingeInfo> list) {
        this.isTabletop = z;
        this.hingeList = list;
    }

    public /* synthetic */ Posture(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Posture)) {
            return false;
        }
        Posture posture = (Posture) other;
        return this.isTabletop == posture.isTabletop && Intrinsics.areEqual(this.hingeList, posture.hingeList);
    }

    public final List<HingeInfo> getHingeList() {
        return this.hingeList;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isTabletop) * 31) + this.hingeList.hashCode();
    }

    /* JADX INFO: renamed from: isTabletop, reason: from getter */
    public final boolean getIsTabletop() {
        return this.isTabletop;
    }

    public String toString() {
        return "Posture(isTabletop=" + this.isTabletop + ", hinges=[" + CollectionsKt.joinToString$default(this.hingeList, ", ", null, null, 0, null, null, 62, null) + "])";
    }
}
