package androidx.camera.camera2.pipe.compat;

import android.graphics.ColorSpace;
import android.hardware.camera2.params.ColorSpaceProfiles;
import androidx.camera.camera2.pipe.CameraColorSpace;
import androidx.camera.camera2.pipe.CameraColorSpaceProfiles;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Camera2ColorSpaceProfiles.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0016¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2ColorSpaceProfiles;", "Landroidx/camera/camera2/pipe/CameraColorSpaceProfiles;", "colorSpaceProfiles", "Landroid/hardware/camera2/params/ColorSpaceProfiles;", "<init>", "(Landroid/hardware/camera2/params/ColorSpaceProfiles;)V", "getSupportedColorSpaces", "", "Landroidx/camera/camera2/pipe/CameraColorSpace;", "imageFormat", "Landroidx/camera/camera2/pipe/StreamFormat;", "getSupportedColorSpaces-hNQ4ISI", "(I)Ljava/util/Set;", "getSupportedImageFormatsForColorSpace", "cameraColorSpace", "getSupportedImageFormatsForColorSpace-jRxjvBE", "(Ljava/lang/String;)Ljava/util/Set;", "getSupportedDynamicRangeProfiles", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getSupportedDynamicRangeProfiles-6Yu6yh8", "(Ljava/lang/String;I)Ljava/util/Set;", "getSupportedColorSpacesForDynamicRange", "dynamicRangeProfile", "getSupportedColorSpacesForDynamicRange-sNWL0t8", "(IJ)Ljava/util/Set;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2ColorSpaceProfiles implements CameraColorSpaceProfiles {
    private final ColorSpaceProfiles colorSpaceProfiles;

    public Camera2ColorSpaceProfiles(ColorSpaceProfiles colorSpaceProfiles) {
        Intrinsics.checkNotNullParameter(colorSpaceProfiles, "colorSpaceProfiles");
        this.colorSpaceProfiles = colorSpaceProfiles;
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedColorSpaces-hNQ4ISI */
    public Set<CameraColorSpace> mo252getSupportedColorSpaceshNQ4ISI(int imageFormat) {
        Set<ColorSpace.Named> supportedColorSpaces = this.colorSpaceProfiles.getSupportedColorSpaces(imageFormat);
        Intrinsics.checkNotNullExpressionValue(supportedColorSpaces, "getSupportedColorSpaces(...)");
        ArrayList arrayList = new ArrayList();
        for (ColorSpace.Named named : supportedColorSpaces) {
            CameraColorSpace.Companion companion = CameraColorSpace.INSTANCE;
            Intrinsics.checkNotNull(named);
            String strM232fromColorSpaceNamed5GKeQC8 = companion.m232fromColorSpaceNamed5GKeQC8(named);
            if (strM232fromColorSpaceNamed5GKeQC8 == null && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Unsupported color space: " + named.name());
            }
            CameraColorSpace cameraColorSpaceM223boximpl = strM232fromColorSpaceNamed5GKeQC8 != null ? CameraColorSpace.m223boximpl(strM232fromColorSpaceNamed5GKeQC8) : null;
            if (cameraColorSpaceM223boximpl != null) {
                arrayList.add(cameraColorSpaceM223boximpl);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedColorSpacesForDynamicRange-sNWL0t8 */
    public Set<CameraColorSpace> mo253getSupportedColorSpacesForDynamicRangesNWL0t8(int imageFormat, long dynamicRangeProfile) {
        Set<ColorSpace.Named> supportedColorSpacesForDynamicRange = this.colorSpaceProfiles.getSupportedColorSpacesForDynamicRange(imageFormat, dynamicRangeProfile);
        Intrinsics.checkNotNullExpressionValue(supportedColorSpacesForDynamicRange, "getSupportedColorSpacesForDynamicRange(...)");
        ArrayList arrayList = new ArrayList();
        for (ColorSpace.Named named : supportedColorSpacesForDynamicRange) {
            CameraColorSpace.Companion companion = CameraColorSpace.INSTANCE;
            Intrinsics.checkNotNull(named);
            String strM232fromColorSpaceNamed5GKeQC8 = companion.m232fromColorSpaceNamed5GKeQC8(named);
            if (strM232fromColorSpaceNamed5GKeQC8 == null && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Unsupported color space: " + named.name());
            }
            CameraColorSpace cameraColorSpaceM223boximpl = strM232fromColorSpaceNamed5GKeQC8 != null ? CameraColorSpace.m223boximpl(strM232fromColorSpaceNamed5GKeQC8) : null;
            if (cameraColorSpaceM223boximpl != null) {
                arrayList.add(cameraColorSpaceM223boximpl);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedDynamicRangeProfiles-6Yu6yh8 */
    public Set<OutputStream.DynamicRangeProfile> mo254getSupportedDynamicRangeProfiles6Yu6yh8(String cameraColorSpace, int imageFormat) {
        Intrinsics.checkNotNullParameter(cameraColorSpace, "cameraColorSpace");
        ColorSpace.Named namedM229toColorSpaceNamedimpl = CameraColorSpace.m229toColorSpaceNamedimpl(cameraColorSpace);
        if (namedM229toColorSpaceNamedimpl == null) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Unsupported color space: " + cameraColorSpace);
            }
            return SetsKt.emptySet();
        }
        Set<Long> supportedDynamicRangeProfiles = this.colorSpaceProfiles.getSupportedDynamicRangeProfiles(namedM229toColorSpaceNamedimpl, imageFormat);
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRangeProfiles, "getSupportedDynamicRangeProfiles(...)");
        Set<Long> set = supportedDynamicRangeProfiles;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (Long l : set) {
            Intrinsics.checkNotNull(l);
            arrayList.add(OutputStream.DynamicRangeProfile.m564boximpl(OutputStream.DynamicRangeProfile.m565constructorimpl(l.longValue())));
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedImageFormatsForColorSpace-jRxjvBE */
    public Set<StreamFormat> mo255getSupportedImageFormatsForColorSpacejRxjvBE(String cameraColorSpace) {
        Intrinsics.checkNotNullParameter(cameraColorSpace, "cameraColorSpace");
        ColorSpace.Named namedM229toColorSpaceNamedimpl = CameraColorSpace.m229toColorSpaceNamedimpl(cameraColorSpace);
        if (namedM229toColorSpaceNamedimpl == null) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Unsupported color space: " + cameraColorSpace);
            }
            return SetsKt.emptySet();
        }
        Set<Integer> supportedImageFormatsForColorSpace = this.colorSpaceProfiles.getSupportedImageFormatsForColorSpace(namedM229toColorSpaceNamedimpl);
        Intrinsics.checkNotNullExpressionValue(supportedImageFormatsForColorSpace, "getSupportedImageFormatsForColorSpace(...)");
        Set<Integer> set = supportedImageFormatsForColorSpace;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (Integer num : set) {
            Intrinsics.checkNotNull(num);
            arrayList.add(StreamFormat.m698boximpl(StreamFormat.m699constructorimpl(num.intValue())));
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ColorSpaceProfiles.class))) {
            Object obj = this.colorSpaceProfiles;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2ColorSpaceProfiles.unwrapAs");
            return (T) obj;
        }
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Camera2ColorSpaceProfiles.class))) {
            return null;
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2ColorSpaceProfiles.unwrapAs");
        return (T) this;
    }
}
