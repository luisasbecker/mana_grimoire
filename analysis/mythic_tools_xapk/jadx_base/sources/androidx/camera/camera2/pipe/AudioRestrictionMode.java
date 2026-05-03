package androidx.camera.camera2.pipe;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraGraph.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class AudioRestrictionMode {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int AUDIO_RESTRICTION_NONE = m168constructorimpl(0);
    private static final int AUDIO_RESTRICTION_VIBRATION = m168constructorimpl(1);
    private static final int AUDIO_RESTRICTION_VIBRATION_SOUND = m168constructorimpl(3);

    /* JADX INFO: compiled from: CameraGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/AudioRestrictionMode$Companion;", "", "<init>", "()V", "AUDIO_RESTRICTION_NONE", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getAUDIO_RESTRICTION_NONE-_b5Q8KE", "()I", "I", "AUDIO_RESTRICTION_VIBRATION", "getAUDIO_RESTRICTION_VIBRATION-_b5Q8KE", "AUDIO_RESTRICTION_VIBRATION_SOUND", "getAUDIO_RESTRICTION_VIBRATION_SOUND-_b5Q8KE", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getAUDIO_RESTRICTION_NONE-_b5Q8KE, reason: not valid java name */
        public final int m174getAUDIO_RESTRICTION_NONE_b5Q8KE() {
            return AudioRestrictionMode.AUDIO_RESTRICTION_NONE;
        }

        /* JADX INFO: renamed from: getAUDIO_RESTRICTION_VIBRATION-_b5Q8KE, reason: not valid java name */
        public final int m175getAUDIO_RESTRICTION_VIBRATION_b5Q8KE() {
            return AudioRestrictionMode.AUDIO_RESTRICTION_VIBRATION;
        }

        /* JADX INFO: renamed from: getAUDIO_RESTRICTION_VIBRATION_SOUND-_b5Q8KE, reason: not valid java name */
        public final int m176getAUDIO_RESTRICTION_VIBRATION_SOUND_b5Q8KE() {
            return AudioRestrictionMode.AUDIO_RESTRICTION_VIBRATION_SOUND;
        }
    }

    private /* synthetic */ AudioRestrictionMode(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AudioRestrictionMode m167boximpl(int i) {
        return new AudioRestrictionMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m168constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m169equalsimpl(int i, Object obj) {
        return (obj instanceof AudioRestrictionMode) && i == ((AudioRestrictionMode) obj).m173unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m170equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m171hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m172toStringimpl(int i) {
        return "AudioRestrictionMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m169equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m171hashCodeimpl(this.value);
    }

    public String toString() {
        return m172toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m173unboximpl() {
        return this.value;
    }
}
