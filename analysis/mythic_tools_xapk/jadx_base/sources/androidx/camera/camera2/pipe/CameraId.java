package androidx.camera.camera2.pipe;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CameraDevices.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u001b\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\tHÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/CameraId;", "", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "toCamera1Id", "", "toCamera1Id-impl", "(Ljava/lang/String;)Ljava/lang/Integer;", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "(Ljava/lang/String;)I", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class CameraId {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* JADX INFO: compiled from: CameraDevices.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/CameraId$Companion;", "", "<init>", "()V", "fromCamera2Id", "Landroidx/camera/camera2/pipe/CameraId;", "value", "", "fromCamera2Id-c9D3src", "(Ljava/lang/String;)Ljava/lang/String;", "fromCamera1Id", "", "fromCamera1Id-c9D3src", "(I)Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: fromCamera1Id-c9D3src, reason: not valid java name */
        public final String m387fromCamera1Idc9D3src(int value) {
            return CameraId.m380constructorimpl(String.valueOf(value));
        }

        /* JADX INFO: renamed from: fromCamera2Id-c9D3src, reason: not valid java name */
        public final String m388fromCamera2Idc9D3src(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CameraId.m380constructorimpl(value);
        }
    }

    private /* synthetic */ CameraId(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CameraId m379boximpl(String str) {
        return new CameraId(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m380constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(value)) {
            throw new IllegalArgumentException("CameraId cannot be null or blank!".toString());
        }
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m381equalsimpl(String str, Object obj) {
        return (obj instanceof CameraId) && Intrinsics.areEqual(str, ((CameraId) obj).m386unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m382equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m383hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toCamera1Id-impl, reason: not valid java name */
    public static final Integer m384toCamera1Idimpl(String str) {
        return StringsKt.toIntOrNull(str);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m385toStringimpl(String str) {
        return "CameraId-" + str;
    }

    public boolean equals(Object obj) {
        return m381equalsimpl(this.value, obj);
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m383hashCodeimpl(this.value);
    }

    public String toString() {
        return m385toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m386unboximpl() {
        return this.value;
    }
}
