package androidx.compose.ui.node;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: NodeKind.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0086\f¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/NodeKind;", ExifInterface.GPS_DIRECTION_TRUE, "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "or", "other", "or-H91voCI", "(II)I", "or-impl", "equals", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class NodeKind<T> {
    private final int mask;

    private /* synthetic */ NodeKind(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NodeKind m8087boximpl(int i) {
        return new NodeKind(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> int m8088constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8089equalsimpl(int i, Object obj) {
        return (obj instanceof NodeKind) && i == ((NodeKind) obj).m8095unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8090equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8091hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: or-H91voCI, reason: not valid java name */
    public static final int m8092orH91voCI(int i, int i2) {
        return i | i2;
    }

    /* JADX INFO: renamed from: or-impl, reason: not valid java name */
    public static final int m8093orimpl(int i, int i2) {
        return i | i2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8094toStringimpl(int i) {
        return "NodeKind(mask=" + i + ')';
    }

    public boolean equals(Object other) {
        return m8089equalsimpl(this.mask, other);
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return m8091hashCodeimpl(this.mask);
    }

    public String toString() {
        return m8094toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m8095unboximpl() {
        return this.mask;
    }
}
