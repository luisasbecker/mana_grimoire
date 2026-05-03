package androidx.camera.camera2.pipe;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.pipe.compat.Api33Compat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Streams.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\b/0123456J\b\u0010-\u001a\u00020.H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u0004\u0018\u00010\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u0004\u0018\u00010&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u0004\u0018\u00010*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00067À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream;", "", "stream", "Landroidx/camera/camera2/pipe/CameraStream;", "getStream", "()Landroidx/camera/camera2/pipe/CameraStream;", "id", "Landroidx/camera/camera2/pipe/OutputId;", "getId-4LaLFng", "()I", "size", "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "getFormat-8FPWQzE", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "getMirrorMode-dO1_9xk", "()Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "getTimestampBase-pcPfPbY", "()Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getDynamicRangeProfile-OoVcG5w", "()Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "getStreamUseCase-8x2ez34", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "outputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "getOutputType", "()Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "getStreamUseHint-HIPxoCc", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "isValidForHighSpeedOperatingMode", "", "Config", "OutputType", "MirrorMode", "TimestampBase", "DynamicRangeProfile", "StreamUseHint", "StreamUseCase", "SensorPixelMode", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OutputStream {

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 -2\u00020\u0001:\u0004-./0Bc\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u0082\u0001\u0003123¨\u00064"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$Config;", "", "size", "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;)V", "getSize", "()Landroid/util/Size;", "getFormat-8FPWQzE", "()I", "I", "getCamera-1LO98Z0", "()Ljava/lang/String;", "Ljava/lang/String;", "getMirrorMode-dO1_9xk", "()Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "getTimestampBase-pcPfPbY", "()Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "getDynamicRangeProfile-OoVcG5w", "()Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getStreamUseCase-8x2ez34", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "getStreamUseHint-HIPxoCc", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "getSensorPixelModes", "()Ljava/util/List;", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "SimpleOutputConfig", "LazyOutputConfig", "ExternalOutputConfig", "Landroidx/camera/camera2/pipe/OutputStream$Config$ExternalOutputConfig;", "Landroidx/camera/camera2/pipe/OutputStream$Config$LazyOutputConfig;", "Landroidx/camera/camera2/pipe/OutputStream$Config$SimpleOutputConfig;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String camera;
        private final DynamicRangeProfile dynamicRangeProfile;
        private final int format;
        private final MirrorMode mirrorMode;
        private final List<SensorPixelMode> sensorPixelModes;
        private final Size size;
        private final StreamUseCase streamUseCase;
        private final StreamUseHint streamUseHint;
        private final TimestampBase timestampBase;

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u007f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\rH\u0002JM\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$Config$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "size", "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "outputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "create-vBYXiEU", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/OutputStream$OutputType;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;)Landroidx/camera/camera2/pipe/OutputStream$Config;", "isLazilyConfigurable", "", "external", "externalOutputConfig", "Landroid/hardware/camera2/params/OutputConfiguration;", "external-4cjX7jI", "(Landroid/util/Size;ILjava/lang/String;Landroid/hardware/camera2/params/OutputConfiguration;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;)Landroidx/camera/camera2/pipe/OutputStream$Config;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: create-vBYXiEU$default, reason: not valid java name */
            public static /* synthetic */ Config m560createvBYXiEU$default(Companion companion, Size size, int i, String str, OutputType outputType, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List list, int i2, Object obj) {
                if ((i2 & 4) != 0) {
                    str = null;
                }
                if ((i2 & 8) != 0) {
                    outputType = OutputType.INSTANCE.getSURFACE();
                }
                if ((i2 & 16) != 0) {
                    mirrorMode = null;
                }
                if ((i2 & 32) != 0) {
                    timestampBase = null;
                }
                if ((i2 & 64) != 0) {
                    dynamicRangeProfile = null;
                }
                if ((i2 & 128) != 0) {
                    streamUseCase = null;
                }
                if ((i2 & 256) != 0) {
                    streamUseHint = null;
                }
                if ((i2 & 512) != 0) {
                    list = CollectionsKt.emptyList();
                }
                return companion.m562createvBYXiEU(size, i, str, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: external-4cjX7jI$default, reason: not valid java name */
            public static /* synthetic */ Config m561external4cjX7jI$default(Companion companion, Size size, int i, String str, OutputConfiguration outputConfiguration, StreamUseHint streamUseHint, List list, int i2, Object obj) {
                if ((i2 & 4) != 0) {
                    str = null;
                }
                String str2 = str;
                if ((i2 & 32) != 0) {
                    list = CollectionsKt.emptyList();
                }
                return companion.m563external4cjX7jI(size, i, str2, outputConfiguration, streamUseHint, list);
            }

            private final boolean isLazilyConfigurable(OutputType outputType) {
                if (Intrinsics.areEqual(outputType, OutputType.INSTANCE.getSURFACE_TEXTURE()) || Intrinsics.areEqual(outputType, OutputType.INSTANCE.getSURFACE_VIEW())) {
                    return true;
                }
                return (Intrinsics.areEqual(outputType, OutputType.INSTANCE.getMEDIA_CODEC()) || Intrinsics.areEqual(outputType, OutputType.INSTANCE.getMEDIA_RECORDER())) && Build.VERSION.SDK_INT >= 35;
            }

            /* JADX INFO: renamed from: create-vBYXiEU, reason: not valid java name */
            public final Config m562createvBYXiEU(Size size, int format, String camera, OutputType outputType, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List<SensorPixelMode> sensorPixelModes) {
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(outputType, "outputType");
                Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
                if (isLazilyConfigurable(outputType)) {
                    return new LazyOutputConfig(size, format, camera, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes, null);
                }
                if (Intrinsics.areEqual(outputType, OutputType.INSTANCE.getSURFACE())) {
                    return new SimpleOutputConfig(size, format, camera, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes, null);
                }
                throw new IllegalStateException("Check failed.");
            }

            /* JADX INFO: renamed from: external-4cjX7jI, reason: not valid java name */
            public final Config m563external4cjX7jI(Size size, int format, String camera, OutputConfiguration externalOutputConfig, StreamUseHint streamUseHint, List<SensorPixelMode> sensorPixelModes) {
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(externalOutputConfig, "externalOutputConfig");
                Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
                return new ExternalOutputConfig(size, format, camera, externalOutputConfig, streamUseHint, sensorPixelModes, null);
            }
        }

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$Config$ExternalOutputConfig;", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "size", "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "output", "Landroid/hardware/camera2/params/OutputConfiguration;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroid/hardware/camera2/params/OutputConfiguration;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOutput", "()Landroid/hardware/camera2/params/OutputConfiguration;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ExternalOutputConfig extends Config {
            private final OutputConfiguration output;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private ExternalOutputConfig(Size size, int i, String str, OutputConfiguration output, StreamUseHint streamUseHint, List<SensorPixelMode> sensorPixelModes) {
                super(size, i, str, MirrorMode.m584boximpl(MirrorMode.m585constructorimpl(Api33Compat.getMirrorMode(output))), TimestampBase.m627boximpl(TimestampBase.m628constructorimpl(Api33Compat.getTimestampBase(output))), DynamicRangeProfile.m564boximpl(DynamicRangeProfile.m565constructorimpl(Api33Compat.getDynamicRangeProfile(output))), StreamUseCase.m604boximpl(StreamUseCase.m605constructorimpl(Api33Compat.getStreamUseCase(output))), streamUseHint, sensorPixelModes, null);
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(output, "output");
                Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
                this.output = output;
            }

            public /* synthetic */ ExternalOutputConfig(Size size, int i, String str, OutputConfiguration outputConfiguration, StreamUseHint streamUseHint, List list, DefaultConstructorMarker defaultConstructorMarker) {
                this(size, i, str, outputConfiguration, streamUseHint, list);
            }

            public final OutputConfiguration getOutput() {
                return this.output;
            }
        }

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$Config$LazyOutputConfig;", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "size", "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "outputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/OutputStream$OutputType;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOutputType$camera_camera2_pipe", "()Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class LazyOutputConfig extends Config {
            private final OutputType outputType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private LazyOutputConfig(Size size, int i, String str, OutputType outputType, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List<SensorPixelMode> sensorPixelModes) {
                super(size, i, str, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes, null);
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(outputType, "outputType");
                Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
                this.outputType = outputType;
            }

            public /* synthetic */ LazyOutputConfig(Size size, int i, String str, OutputType outputType, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List list, DefaultConstructorMarker defaultConstructorMarker) {
                this(size, i, str, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, list);
            }

            /* JADX INFO: renamed from: getOutputType$camera_camera2_pipe, reason: from getter */
            public final OutputType getOutputType() {
                return this.outputType;
            }
        }

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$Config$SimpleOutputConfig;", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "size", "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "<init>", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SimpleOutputConfig extends Config {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private SimpleOutputConfig(Size size, int i, String str, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List<SensorPixelMode> sensorPixelModes) {
                super(size, i, str, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes, null);
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
            }

            public /* synthetic */ SimpleOutputConfig(Size size, int i, String str, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List list, DefaultConstructorMarker defaultConstructorMarker) {
                this(size, i, str, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, list);
            }
        }

        private Config(Size size, int i, String str, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List<SensorPixelMode> sensorPixelModes) {
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
            this.size = size;
            this.format = i;
            this.camera = str;
            this.mirrorMode = mirrorMode;
            this.timestampBase = timestampBase;
            this.dynamicRangeProfile = dynamicRangeProfile;
            this.streamUseCase = streamUseCase;
            this.streamUseHint = streamUseHint;
            this.sensorPixelModes = sensorPixelModes;
        }

        public /* synthetic */ Config(Size size, int i, String str, MirrorMode mirrorMode, TimestampBase timestampBase, DynamicRangeProfile dynamicRangeProfile, StreamUseCase streamUseCase, StreamUseHint streamUseHint, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(size, i, str, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, list);
        }

        /* JADX INFO: renamed from: getCamera-1LO98Z0, reason: not valid java name and from getter */
        public final String getCamera() {
            return this.camera;
        }

        /* JADX INFO: renamed from: getDynamicRangeProfile-OoVcG5w, reason: not valid java name and from getter */
        public final DynamicRangeProfile getDynamicRangeProfile() {
            return this.dynamicRangeProfile;
        }

        /* JADX INFO: renamed from: getFormat-8FPWQzE, reason: not valid java name and from getter */
        public final int getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: getMirrorMode-dO1_9xk, reason: not valid java name and from getter */
        public final MirrorMode getMirrorMode() {
            return this.mirrorMode;
        }

        public final List<SensorPixelMode> getSensorPixelModes() {
            return this.sensorPixelModes;
        }

        public final Size getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: getStreamUseCase-8x2ez34, reason: not valid java name and from getter */
        public final StreamUseCase getStreamUseCase() {
            return this.streamUseCase;
        }

        /* JADX INFO: renamed from: getStreamUseHint-HIPxoCc, reason: not valid java name and from getter */
        public final StreamUseHint getStreamUseHint() {
            return this.streamUseHint;
        }

        /* JADX INFO: renamed from: getTimestampBase-pcPfPbY, reason: not valid java name and from getter */
        public final TimestampBase getTimestampBase() {
            return this.timestampBase;
        }

        public String toString() {
            StringBuilder sbAppend = new StringBuilder("Config(size=").append(this.size).append(", format=").append((Object) StreamFormat.m705toStringimpl(this.format)).append(", camera=");
            String str = this.camera;
            return sbAppend.append((Object) (str == null ? AbstractJsonLexerKt.NULL : CameraId.m385toStringimpl(str))).append(", mirrorMode=").append(this.mirrorMode).append(", timestampBase=").append(this.timestampBase).append(", dynamicRangeProfile=").append(this.dynamicRangeProfile).append(", streamUseCase=").append(this.streamUseCase).append(", streamUseHint=").append(this.streamUseHint).append(", sensorPixelModes=").append(this.sensorPixelModes).append(')').toString();
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isValidForHighSpeedOperatingMode(OutputStream outputStream) {
            return OutputStream.super.isValidForHighSpeedOperatingMode();
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "", "value", "", "constructor-impl", "(J)J", "getValue", "()J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class DynamicRangeProfile {
        private final long value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final long STANDARD = m565constructorimpl(1);
        private static final long HLG10 = m565constructorimpl(2);
        private static final long HDR10 = m565constructorimpl(4);
        private static final long HDR10_PLUS = m565constructorimpl(8);
        private static final long DOLBY_VISION_10B_HDR_REF = m565constructorimpl(16);
        private static final long DOLBY_VISION_10B_HDR_REF_PO = m565constructorimpl(32);
        private static final long DOLBY_VISION_10B_HDR_OEM = m565constructorimpl(64);
        private static final long DOLBY_VISION_10B_HDR_OEM_PO = m565constructorimpl(128);
        private static final long DOLBY_VISION_8B_HDR_REF = m565constructorimpl(256);
        private static final long DOLBY_VISION_8B_HDR_REF_PO = m565constructorimpl(512);
        private static final long DOLBY_VISION_8B_HDR_OEM = m565constructorimpl(1024);
        private static final long DOLBY_VISION_8B_HDR_OEM_PO = m565constructorimpl(2048);
        private static final long PUBLIC_MAX = m565constructorimpl(4096);

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007¨\u0006!"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile$Companion;", "", "<init>", "()V", "STANDARD", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getSTANDARD-fFAQAUE", "()J", "J", "HLG10", "getHLG10-fFAQAUE", "HDR10", "getHDR10-fFAQAUE", "HDR10_PLUS", "getHDR10_PLUS-fFAQAUE", "DOLBY_VISION_10B_HDR_REF", "getDOLBY_VISION_10B_HDR_REF-fFAQAUE", "DOLBY_VISION_10B_HDR_REF_PO", "getDOLBY_VISION_10B_HDR_REF_PO-fFAQAUE", "DOLBY_VISION_10B_HDR_OEM", "getDOLBY_VISION_10B_HDR_OEM-fFAQAUE", "DOLBY_VISION_10B_HDR_OEM_PO", "getDOLBY_VISION_10B_HDR_OEM_PO-fFAQAUE", "DOLBY_VISION_8B_HDR_REF", "getDOLBY_VISION_8B_HDR_REF-fFAQAUE", "DOLBY_VISION_8B_HDR_REF_PO", "getDOLBY_VISION_8B_HDR_REF_PO-fFAQAUE", "DOLBY_VISION_8B_HDR_OEM", "getDOLBY_VISION_8B_HDR_OEM-fFAQAUE", "DOLBY_VISION_8B_HDR_OEM_PO", "getDOLBY_VISION_8B_HDR_OEM_PO-fFAQAUE", "PUBLIC_MAX", "getPUBLIC_MAX-fFAQAUE", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_10B_HDR_OEM-fFAQAUE, reason: not valid java name */
            public final long m571getDOLBY_VISION_10B_HDR_OEMfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_10B_HDR_OEM;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_10B_HDR_OEM_PO-fFAQAUE, reason: not valid java name */
            public final long m572getDOLBY_VISION_10B_HDR_OEM_POfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_10B_HDR_OEM_PO;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_10B_HDR_REF-fFAQAUE, reason: not valid java name */
            public final long m573getDOLBY_VISION_10B_HDR_REFfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_10B_HDR_REF;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_10B_HDR_REF_PO-fFAQAUE, reason: not valid java name */
            public final long m574getDOLBY_VISION_10B_HDR_REF_POfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_10B_HDR_REF_PO;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_8B_HDR_OEM-fFAQAUE, reason: not valid java name */
            public final long m575getDOLBY_VISION_8B_HDR_OEMfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_8B_HDR_OEM;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_8B_HDR_OEM_PO-fFAQAUE, reason: not valid java name */
            public final long m576getDOLBY_VISION_8B_HDR_OEM_POfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_8B_HDR_OEM_PO;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_8B_HDR_REF-fFAQAUE, reason: not valid java name */
            public final long m577getDOLBY_VISION_8B_HDR_REFfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_8B_HDR_REF;
            }

            /* JADX INFO: renamed from: getDOLBY_VISION_8B_HDR_REF_PO-fFAQAUE, reason: not valid java name */
            public final long m578getDOLBY_VISION_8B_HDR_REF_POfFAQAUE() {
                return DynamicRangeProfile.DOLBY_VISION_8B_HDR_REF_PO;
            }

            /* JADX INFO: renamed from: getHDR10-fFAQAUE, reason: not valid java name */
            public final long m579getHDR10fFAQAUE() {
                return DynamicRangeProfile.HDR10;
            }

            /* JADX INFO: renamed from: getHDR10_PLUS-fFAQAUE, reason: not valid java name */
            public final long m580getHDR10_PLUSfFAQAUE() {
                return DynamicRangeProfile.HDR10_PLUS;
            }

            /* JADX INFO: renamed from: getHLG10-fFAQAUE, reason: not valid java name */
            public final long m581getHLG10fFAQAUE() {
                return DynamicRangeProfile.HLG10;
            }

            /* JADX INFO: renamed from: getPUBLIC_MAX-fFAQAUE, reason: not valid java name */
            public final long m582getPUBLIC_MAXfFAQAUE() {
                return DynamicRangeProfile.PUBLIC_MAX;
            }

            /* JADX INFO: renamed from: getSTANDARD-fFAQAUE, reason: not valid java name */
            public final long m583getSTANDARDfFAQAUE() {
                return DynamicRangeProfile.STANDARD;
            }
        }

        private /* synthetic */ DynamicRangeProfile(long j) {
            this.value = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ DynamicRangeProfile m564boximpl(long j) {
            return new DynamicRangeProfile(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m565constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m566equalsimpl(long j, Object obj) {
            return (obj instanceof DynamicRangeProfile) && j == ((DynamicRangeProfile) obj).m570unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m567equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m568hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m569toStringimpl(long j) {
            return "DynamicRangeProfile(value=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m566equalsimpl(this.value, obj);
        }

        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return m568hashCodeimpl(this.value);
        }

        public String toString() {
            return m569toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m570unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class MirrorMode {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int MIRROR_MODE_AUTO = m585constructorimpl(0);
        private static final int MIRROR_MODE_NONE = m585constructorimpl(1);
        private static final int MIRROR_MODE_H = m585constructorimpl(2);
        private static final int MIRROR_MODE_V = m585constructorimpl(3);

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$MirrorMode$Companion;", "", "<init>", "()V", "MIRROR_MODE_AUTO", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "getMIRROR_MODE_AUTO-DrUKqn0", "()I", "I", "MIRROR_MODE_NONE", "getMIRROR_MODE_NONE-DrUKqn0", "MIRROR_MODE_H", "getMIRROR_MODE_H-DrUKqn0", "MIRROR_MODE_V", "getMIRROR_MODE_V-DrUKqn0", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getMIRROR_MODE_AUTO-DrUKqn0, reason: not valid java name */
            public final int m591getMIRROR_MODE_AUTODrUKqn0() {
                return MirrorMode.MIRROR_MODE_AUTO;
            }

            /* JADX INFO: renamed from: getMIRROR_MODE_H-DrUKqn0, reason: not valid java name */
            public final int m592getMIRROR_MODE_HDrUKqn0() {
                return MirrorMode.MIRROR_MODE_H;
            }

            /* JADX INFO: renamed from: getMIRROR_MODE_NONE-DrUKqn0, reason: not valid java name */
            public final int m593getMIRROR_MODE_NONEDrUKqn0() {
                return MirrorMode.MIRROR_MODE_NONE;
            }

            /* JADX INFO: renamed from: getMIRROR_MODE_V-DrUKqn0, reason: not valid java name */
            public final int m594getMIRROR_MODE_VDrUKqn0() {
                return MirrorMode.MIRROR_MODE_V;
            }
        }

        private /* synthetic */ MirrorMode(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ MirrorMode m584boximpl(int i) {
            return new MirrorMode(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m585constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m586equalsimpl(int i, Object obj) {
            return (obj instanceof MirrorMode) && i == ((MirrorMode) obj).m590unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m587equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m588hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m589toStringimpl(int i) {
            return "MirrorMode(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m586equalsimpl(this.value, obj);
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return m588hashCodeimpl(this.value);
        }

        public String toString() {
            return m589toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m590unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "", "<init>", "()V", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OutputType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final OutputType SURFACE = new OutputType();
        private static final OutputType SURFACE_VIEW = new OutputType();
        private static final OutputType SURFACE_TEXTURE = new OutputType();
        private static final OutputType SURFACE_DEFERRED_FOR_QUERY_ONLY = new OutputType();
        private static final OutputType MEDIA_CODEC = new OutputType();
        private static final OutputType MEDIA_RECORDER = new OutputType();

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$OutputType$Companion;", "", "<init>", "()V", "SURFACE", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "getSURFACE", "()Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "SURFACE_VIEW", "getSURFACE_VIEW", "SURFACE_TEXTURE", "getSURFACE_TEXTURE", "SURFACE_DEFERRED_FOR_QUERY_ONLY", "getSURFACE_DEFERRED_FOR_QUERY_ONLY$camera_camera2_pipe", "MEDIA_CODEC", "getMEDIA_CODEC", "MEDIA_RECORDER", "getMEDIA_RECORDER", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final OutputType getMEDIA_CODEC() {
                return OutputType.MEDIA_CODEC;
            }

            public final OutputType getMEDIA_RECORDER() {
                return OutputType.MEDIA_RECORDER;
            }

            public final OutputType getSURFACE() {
                return OutputType.SURFACE;
            }

            public final OutputType getSURFACE_DEFERRED_FOR_QUERY_ONLY$camera_camera2_pipe() {
                return OutputType.SURFACE_DEFERRED_FOR_QUERY_ONLY;
            }

            public final OutputType getSURFACE_TEXTURE() {
                return OutputType.SURFACE_TEXTURE;
            }

            public final OutputType getSURFACE_VIEW() {
                return OutputType.SURFACE_VIEW;
            }
        }

        private OutputType() {
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class SensorPixelMode {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int DEFAULT = m596constructorimpl(0);
        private static final int MAXIMUM_RESOLUTION = m596constructorimpl(1);
        private final int value;

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "getDEFAULT-ApWyzMw", "()I", "I", "MAXIMUM_RESOLUTION", "getMAXIMUM_RESOLUTION-ApWyzMw", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getDEFAULT-ApWyzMw, reason: not valid java name */
            public final int m602getDEFAULTApWyzMw() {
                return SensorPixelMode.DEFAULT;
            }

            /* JADX INFO: renamed from: getMAXIMUM_RESOLUTION-ApWyzMw, reason: not valid java name */
            public final int m603getMAXIMUM_RESOLUTIONApWyzMw() {
                return SensorPixelMode.MAXIMUM_RESOLUTION;
            }
        }

        private /* synthetic */ SensorPixelMode(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ SensorPixelMode m595boximpl(int i) {
            return new SensorPixelMode(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m596constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m597equalsimpl(int i, Object obj) {
            return (obj instanceof SensorPixelMode) && i == ((SensorPixelMode) obj).m601unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m598equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m599hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m600toStringimpl(int i) {
            return "SensorPixelMode(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m597equalsimpl(this.value, obj);
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return m599hashCodeimpl(this.value);
        }

        public String toString() {
            return m600toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m601unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "", "value", "", "constructor-impl", "(J)J", "getValue", "()J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class StreamUseCase {
        private final long value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final long DEFAULT = m605constructorimpl(0);
        private static final long PREVIEW = m605constructorimpl(1);
        private static final long STILL_CAPTURE = m605constructorimpl(2);
        private static final long VIDEO_RECORD = m605constructorimpl(3);
        private static final long PREVIEW_VIDEO_STILL = m605constructorimpl(4);
        private static final long VIDEO_CALL = m605constructorimpl(5);
        private static final long CROPPED_RAW = m605constructorimpl(6);

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "getDEFAULT-vrKr8v8", "()J", "J", "PREVIEW", "getPREVIEW-vrKr8v8", "STILL_CAPTURE", "getSTILL_CAPTURE-vrKr8v8", "VIDEO_RECORD", "getVIDEO_RECORD-vrKr8v8", "PREVIEW_VIDEO_STILL", "getPREVIEW_VIDEO_STILL-vrKr8v8", "VIDEO_CALL", "getVIDEO_CALL-vrKr8v8", "CROPPED_RAW", "getCROPPED_RAW-vrKr8v8", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getCROPPED_RAW-vrKr8v8, reason: not valid java name */
            public final long m611getCROPPED_RAWvrKr8v8() {
                return StreamUseCase.CROPPED_RAW;
            }

            /* JADX INFO: renamed from: getDEFAULT-vrKr8v8, reason: not valid java name */
            public final long m612getDEFAULTvrKr8v8() {
                return StreamUseCase.DEFAULT;
            }

            /* JADX INFO: renamed from: getPREVIEW-vrKr8v8, reason: not valid java name */
            public final long m613getPREVIEWvrKr8v8() {
                return StreamUseCase.PREVIEW;
            }

            /* JADX INFO: renamed from: getPREVIEW_VIDEO_STILL-vrKr8v8, reason: not valid java name */
            public final long m614getPREVIEW_VIDEO_STILLvrKr8v8() {
                return StreamUseCase.PREVIEW_VIDEO_STILL;
            }

            /* JADX INFO: renamed from: getSTILL_CAPTURE-vrKr8v8, reason: not valid java name */
            public final long m615getSTILL_CAPTUREvrKr8v8() {
                return StreamUseCase.STILL_CAPTURE;
            }

            /* JADX INFO: renamed from: getVIDEO_CALL-vrKr8v8, reason: not valid java name */
            public final long m616getVIDEO_CALLvrKr8v8() {
                return StreamUseCase.VIDEO_CALL;
            }

            /* JADX INFO: renamed from: getVIDEO_RECORD-vrKr8v8, reason: not valid java name */
            public final long m617getVIDEO_RECORDvrKr8v8() {
                return StreamUseCase.VIDEO_RECORD;
            }
        }

        private /* synthetic */ StreamUseCase(long j) {
            this.value = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ StreamUseCase m604boximpl(long j) {
            return new StreamUseCase(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m605constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m606equalsimpl(long j, Object obj) {
            return (obj instanceof StreamUseCase) && j == ((StreamUseCase) obj).m610unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m607equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m608hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m609toStringimpl(long j) {
            return "StreamUseCase(value=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m606equalsimpl(this.value, obj);
        }

        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return m608hashCodeimpl(this.value);
        }

        public String toString() {
            return m609toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m610unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "", "value", "", "constructor-impl", "(J)J", "getValue", "()J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class StreamUseHint {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final long DEFAULT = m619constructorimpl(0);
        private static final long VIDEO_RECORD = m619constructorimpl(1);
        private final long value;

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "getDEFAULT-4VYZOf8", "()J", "J", "VIDEO_RECORD", "getVIDEO_RECORD-4VYZOf8", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getDEFAULT-4VYZOf8, reason: not valid java name */
            public final long m625getDEFAULT4VYZOf8() {
                return StreamUseHint.DEFAULT;
            }

            /* JADX INFO: renamed from: getVIDEO_RECORD-4VYZOf8, reason: not valid java name */
            public final long m626getVIDEO_RECORD4VYZOf8() {
                return StreamUseHint.VIDEO_RECORD;
            }
        }

        private /* synthetic */ StreamUseHint(long j) {
            this.value = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ StreamUseHint m618boximpl(long j) {
            return new StreamUseHint(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m619constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m620equalsimpl(long j, Object obj) {
            return (obj instanceof StreamUseHint) && j == ((StreamUseHint) obj).m624unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m621equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m622hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m623toStringimpl(long j) {
            return "StreamUseHint(value=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m620equalsimpl(this.value, obj);
        }

        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return m622hashCodeimpl(this.value);
        }

        public String toString() {
            return m623toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m624unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class TimestampBase {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int TIMESTAMP_BASE_DEFAULT = m628constructorimpl(0);
        private static final int TIMESTAMP_BASE_SENSOR = m628constructorimpl(1);
        private static final int TIMESTAMP_BASE_MONOTONIC = m628constructorimpl(2);
        private static final int TIMESTAMP_BASE_REALTIME = m628constructorimpl(3);
        private static final int TIMESTAMP_BASE_CHOREOGRAPHER_SYNCED = m628constructorimpl(4);

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/OutputStream$TimestampBase$Companion;", "", "<init>", "()V", "TIMESTAMP_BASE_DEFAULT", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "getTIMESTAMP_BASE_DEFAULT-6HVI0MA", "()I", "I", "TIMESTAMP_BASE_SENSOR", "getTIMESTAMP_BASE_SENSOR-6HVI0MA", "TIMESTAMP_BASE_MONOTONIC", "getTIMESTAMP_BASE_MONOTONIC-6HVI0MA", "TIMESTAMP_BASE_REALTIME", "getTIMESTAMP_BASE_REALTIME-6HVI0MA", "TIMESTAMP_BASE_CHOREOGRAPHER_SYNCED", "getTIMESTAMP_BASE_CHOREOGRAPHER_SYNCED-6HVI0MA", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getTIMESTAMP_BASE_CHOREOGRAPHER_SYNCED-6HVI0MA, reason: not valid java name */
            public final int m634getTIMESTAMP_BASE_CHOREOGRAPHER_SYNCED6HVI0MA() {
                return TimestampBase.TIMESTAMP_BASE_CHOREOGRAPHER_SYNCED;
            }

            /* JADX INFO: renamed from: getTIMESTAMP_BASE_DEFAULT-6HVI0MA, reason: not valid java name */
            public final int m635getTIMESTAMP_BASE_DEFAULT6HVI0MA() {
                return TimestampBase.TIMESTAMP_BASE_DEFAULT;
            }

            /* JADX INFO: renamed from: getTIMESTAMP_BASE_MONOTONIC-6HVI0MA, reason: not valid java name */
            public final int m636getTIMESTAMP_BASE_MONOTONIC6HVI0MA() {
                return TimestampBase.TIMESTAMP_BASE_MONOTONIC;
            }

            /* JADX INFO: renamed from: getTIMESTAMP_BASE_REALTIME-6HVI0MA, reason: not valid java name */
            public final int m637getTIMESTAMP_BASE_REALTIME6HVI0MA() {
                return TimestampBase.TIMESTAMP_BASE_REALTIME;
            }

            /* JADX INFO: renamed from: getTIMESTAMP_BASE_SENSOR-6HVI0MA, reason: not valid java name */
            public final int m638getTIMESTAMP_BASE_SENSOR6HVI0MA() {
                return TimestampBase.TIMESTAMP_BASE_SENSOR;
            }
        }

        private /* synthetic */ TimestampBase(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ TimestampBase m627boximpl(int i) {
            return new TimestampBase(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m628constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m629equalsimpl(int i, Object obj) {
            return (obj instanceof TimestampBase) && i == ((TimestampBase) obj).m633unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m630equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m631hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m632toStringimpl(int i) {
            return "TimestampBase(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m629equalsimpl(this.value, obj);
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return m631hashCodeimpl(this.value);
        }

        public String toString() {
            return m632toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m633unboximpl() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name */
    String getCamera();

    /* JADX INFO: renamed from: getDynamicRangeProfile-OoVcG5w, reason: not valid java name */
    DynamicRangeProfile getDynamicRangeProfile();

    /* JADX INFO: renamed from: getFormat-8FPWQzE, reason: not valid java name */
    int getFormat();

    /* JADX INFO: renamed from: getId-4LaLFng, reason: not valid java name */
    int getId();

    /* JADX INFO: renamed from: getMirrorMode-dO1_9xk, reason: not valid java name */
    MirrorMode getMirrorMode();

    OutputType getOutputType();

    Size getSize();

    CameraStream getStream();

    /* JADX INFO: renamed from: getStreamUseCase-8x2ez34, reason: not valid java name */
    StreamUseCase getStreamUseCase();

    /* JADX INFO: renamed from: getStreamUseHint-HIPxoCc, reason: not valid java name */
    StreamUseHint getStreamUseHint();

    /* JADX INFO: renamed from: getTimestampBase-pcPfPbY, reason: not valid java name */
    TimestampBase getTimestampBase();

    default boolean isValidForHighSpeedOperatingMode() {
        if (getStreamUseCase() == null) {
            return true;
        }
        StreamUseCase streamUseCase = getStreamUseCase();
        if (streamUseCase == null ? false : StreamUseCase.m607equalsimpl0(streamUseCase.m610unboximpl(), StreamUseCase.INSTANCE.m612getDEFAULTvrKr8v8())) {
            return true;
        }
        StreamUseCase streamUseCase2 = getStreamUseCase();
        if (streamUseCase2 == null ? false : StreamUseCase.m607equalsimpl0(streamUseCase2.m610unboximpl(), StreamUseCase.INSTANCE.m613getPREVIEWvrKr8v8())) {
            return true;
        }
        StreamUseCase streamUseCase3 = getStreamUseCase();
        if ((streamUseCase3 == null ? false : StreamUseCase.m607equalsimpl0(streamUseCase3.m610unboximpl(), StreamUseCase.INSTANCE.m617getVIDEO_RECORDvrKr8v8())) || getStreamUseHint() == null) {
            return true;
        }
        StreamUseHint streamUseHint = getStreamUseHint();
        if (streamUseHint == null ? false : StreamUseHint.m621equalsimpl0(streamUseHint.m624unboximpl(), StreamUseHint.INSTANCE.m625getDEFAULT4VYZOf8())) {
            return true;
        }
        StreamUseHint streamUseHint2 = getStreamUseHint();
        return streamUseHint2 == null ? false : StreamUseHint.m621equalsimpl0(streamUseHint2.m624unboximpl(), StreamUseHint.INSTANCE.m626getVIDEO_RECORD4VYZOf8());
    }
}
