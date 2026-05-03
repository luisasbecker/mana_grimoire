package androidx.media3.muxer;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class AnnexBUtils {
    private static final int THREE_BYTE_NAL_START_CODE_SIZE = 3;

    private AnnexBUtils() {
    }

    public static boolean doesSampleContainAnnexBNalUnits(Format format) {
        String str = format.sampleMimeType;
        Preconditions.checkNotNull(str);
        return str.equals(MimeTypes.VIDEO_DOLBY_VISION) ? ((Integer) ((Pair) Preconditions.checkNotNull(Boxes.getDolbyVisionProfileAndLevel(format))).first).intValue() != 10 : str.equals("video/avc") || str.equals(MimeTypes.VIDEO_H265);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        if (r2 == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int findNalEndIndex(ByteBuffer byteBuffer, int i) {
        while (true) {
            if (i > byteBuffer.limit() - 4) {
                if (i == byteBuffer.limit() - 3) {
                    short s = byteBuffer.getShort(i);
                    byte b = byteBuffer.get(i + 2);
                    if (s == 0) {
                        if (b != 0) {
                        }
                    }
                }
                return byteBuffer.limit();
            }
            int i2 = byteBuffer.getInt(i);
            int i3 = i2 & (-256);
            if (i3 == 0 || i3 == 256) {
                break;
            }
            int i4 = 16777215 & i2;
            if (i4 == 0 || i4 == 1) {
                break;
            }
            i = (65535 & i2) == 0 ? i + 2 : (i2 & 255) == 0 ? i + 3 : i + 4;
        }
        return i + 1;
    }

    public static ImmutableList<ByteBuffer> findNalUnits(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return ImmutableList.of();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        int iSkipLeadingZerosAndFindNalStartCodeIndex = skipLeadingZerosAndFindNalStartCodeIndex(byteBufferAsReadOnlyBuffer, byteBufferAsReadOnlyBuffer.position()) + 3;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = iSkipLeadingZerosAndFindNalStartCodeIndex;
        boolean z = true;
        while (iSkipLeadingZerosAndFindNalStartCodeIndex < byteBufferAsReadOnlyBuffer.limit()) {
            if (!z) {
                int iSkipLeadingZerosAndFindNalStartCodeIndex2 = skipLeadingZerosAndFindNalStartCodeIndex(byteBufferAsReadOnlyBuffer, iSkipLeadingZerosAndFindNalStartCodeIndex);
                if (iSkipLeadingZerosAndFindNalStartCodeIndex2 == byteBufferAsReadOnlyBuffer.limit()) {
                    break;
                }
                i = iSkipLeadingZerosAndFindNalStartCodeIndex2 + 3;
                z = true;
                iSkipLeadingZerosAndFindNalStartCodeIndex = i;
            } else {
                iSkipLeadingZerosAndFindNalStartCodeIndex = findNalEndIndex(byteBufferAsReadOnlyBuffer, iSkipLeadingZerosAndFindNalStartCodeIndex);
                builder.add(getBytes(byteBufferAsReadOnlyBuffer, i, iSkipLeadingZerosAndFindNalStartCodeIndex - i));
                z = false;
            }
        }
        return builder.build();
    }

    private static ByteBuffer getBytes(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(i + i2);
        return byteBufferDuplicate.slice();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int skipLeadingZerosAndFindNalStartCodeIndex(ByteBuffer byteBuffer, int i) {
        while (true) {
            if (i > byteBuffer.limit() - 4) {
                if (i <= byteBuffer.limit() - 3) {
                    Preconditions.checkState(byteBuffer.getShort(i) == 0, "Invalid NAL units");
                    byte b = byteBuffer.get(i + 2);
                    if (b != 1) {
                        Preconditions.checkState(b == 0, "Invalid NAL units");
                    }
                } else {
                    while (i < byteBuffer.limit()) {
                        Preconditions.checkState(byteBuffer.get(i) == 0, "Invalid NAL units");
                        i++;
                    }
                }
                return byteBuffer.limit();
            }
            int i2 = byteBuffer.getInt(i);
            int i3 = i2 & (-256);
            if (i3 == 256) {
                break;
            }
            Preconditions.checkState(i3 == 0, "Invalid Nal units");
            int i4 = i2 & 255;
            if (i4 == 1) {
                return i + 1;
            }
            if (i4 == 0) {
                z = true;
            }
            Preconditions.checkState(z, "Invalid Nal units");
            i++;
        }
    }

    public static ByteBuffer stripEmulationPrevention(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit());
        int i = 0;
        for (int i2 = 0; i2 < byteBuffer.limit(); i2++) {
            if (byteBuffer.get(i2) != 3 || i < 2) {
                byteBufferAllocate.put(byteBuffer.get(i2));
            }
            i = byteBuffer.get(i2) == 0 ? i + 1 : 0;
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
