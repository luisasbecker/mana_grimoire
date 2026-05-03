package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.util.Log;
import androidx.camera.core.ImageProxy;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.MimeTypes;
import com.google.firebase.messaging.Constants;
import com.studiolaganne.lengendarylens.FrameMetadata;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J+\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u001bJ+\u0010\u001c\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u001eJ8\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/BitmapUtils;", "", "<init>", "()V", "TAG", "", "getBitmap", "Landroid/graphics/Bitmap;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Ljava/nio/ByteBuffer;", "metadata", "Lcom/studiolaganne/lengendarylens/FrameMetadata;", MimeTypes.BASE_TYPE_IMAGE, "Landroidx/camera/core/ImageProxy;", "rotateBitmap", "bitmap", "rotationDegrees", "", "flipX", "", "flipY", "yuv420ThreePlanesToNV21", "yuv420888planes", "", "Landroid/media/Image$Plane;", "width", "height", "([Landroid/media/Image$Plane;II)Ljava/nio/ByteBuffer;", "areUVPlanesNV21", "planes", "([Landroid/media/Image$Plane;II)Z", "unpackPlane", "", "plane", "out", "", TypedValues.CycleType.S_WAVE_OFFSET, "pixelStride", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BitmapUtils {
    public static final int $stable = 0;
    public static final BitmapUtils INSTANCE = new BitmapUtils();
    private static final String TAG = "BitmapUtils";

    private BitmapUtils() {
    }

    private final boolean areUVPlanesNV21(Image.Plane[] planes, int width, int height) {
        int i = width * height;
        ByteBuffer buffer = planes[1].getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        ByteBuffer buffer2 = planes[2].getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer2, "getBuffer(...)");
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        boolean z = buffer2.remaining() == ((i * 2) / 4) - 2 && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        return z;
    }

    private final Bitmap rotateBitmap(Bitmap bitmap, int rotationDegrees, boolean flipX, boolean flipY) {
        Matrix matrix = new Matrix();
        matrix.postRotate(rotationDegrees);
        matrix.postScale(flipX ? -1.0f : 1.0f, flipY ? -1.0f : 1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (!Intrinsics.areEqual(bitmapCreateBitmap, bitmap)) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private final void unpackPlane(Image.Plane plane, int width, int height, byte[] out, int offset, int pixelStride) {
        ByteBuffer buffer = plane.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i = width / (height / iLimit);
        int rowStride = 0;
        for (int i2 = 0; i2 < iLimit; i2++) {
            int pixelStride2 = rowStride;
            for (int i3 = 0; i3 < i; i3++) {
                if (offset < out.length && pixelStride2 < buffer.limit()) {
                    out[offset] = buffer.get(pixelStride2);
                }
                offset += pixelStride;
                pixelStride2 += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }

    private final ByteBuffer yuv420ThreePlanesToNV21(Image.Plane[] yuv420888planes, int width, int height) {
        int i = width * height;
        byte[] bArr = new byte[((i / 4) * 2) + i];
        if (areUVPlanesNV21(yuv420888planes, width, height)) {
            yuv420888planes[0].getBuffer().get(bArr, 0, i);
            ByteBuffer buffer = yuv420888planes[1].getBuffer();
            Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
            ByteBuffer buffer2 = yuv420888planes[2].getBuffer();
            Intrinsics.checkNotNullExpressionValue(buffer2, "getBuffer(...)");
            buffer2.get(bArr, i, 1);
            buffer.get(bArr, i + 1, ((i * 2) / 4) - 1);
        } else {
            unpackPlane(yuv420888planes[0], width, height, bArr, 0, 1);
            unpackPlane(yuv420888planes[1], width, height, bArr, i + 1, 2);
            unpackPlane(yuv420888planes[2], width, height, bArr, i, 2);
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        return byteBufferWrap;
    }

    public final Bitmap getBitmap(ImageProxy image) {
        Intrinsics.checkNotNullParameter(image, "image");
        FrameMetadata frameMetadataBuild = new FrameMetadata.Builder().setWidth(image.getWidth()).setHeight(image.getHeight()).setRotation(image.getImageInfo().getRotationDegrees()).build();
        Image image2 = image.getImage();
        Intrinsics.checkNotNull(image2);
        Image.Plane[] planes = image2.getPlanes();
        Intrinsics.checkNotNullExpressionValue(planes, "getPlanes(...)");
        return getBitmap(yuv420ThreePlanesToNV21(planes, image.getWidth(), image.getHeight()), frameMetadataBuild);
    }

    public final Bitmap getBitmap(ByteBuffer data, FrameMetadata metadata) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        data.rewind();
        int iLimit = data.limit();
        byte[] bArr = new byte[iLimit];
        data.get(bArr, 0, iLimit);
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, metadata.getWidth(), metadata.getHeight(), null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, metadata.getWidth(), metadata.getHeight()), 80, byteArrayOutputStream);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
            Intrinsics.checkNotNull(bitmapDecodeByteArray);
            return rotateBitmap(bitmapDecodeByteArray, metadata.getRotation(), false, false);
        } catch (Exception e) {
            Log.e("VisionProcessorBase", "Error: " + e.getMessage());
            return null;
        }
    }
}
