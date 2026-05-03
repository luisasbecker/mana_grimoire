package kotlin.collections;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u000b\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001f\u0010\u0010\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b \u0010\u0015\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m11903partitionnroSd4(long[] jArr, int i, int i2) {
        long jM11679getsVKNKU = ULongArray.m11679getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m11679getsVKNKU(jArr, i), jM11679getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m11679getsVKNKU(jArr, i2), jM11679getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM11679getsVKNKU2 = ULongArray.m11679getsVKNKU(jArr, i);
                ULongArray.m11684setk8EXiF4(jArr, i, ULongArray.m11679getsVKNKU(jArr, i2));
                ULongArray.m11684setk8EXiF4(jArr, i2, jM11679getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m11904partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM11521getw2LRezQ = UByteArray.m11521getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM11521getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m11521getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m11521getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM11521getw2LRezQ2 = UByteArray.m11521getw2LRezQ(bArr, i);
                UByteArray.m11526setVurrAj0(bArr, i, UByteArray.m11521getw2LRezQ(bArr, i2));
                UByteArray.m11526setVurrAj0(bArr, i2, bM11521getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m11905partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM11784getMh2AYeg = UShortArray.m11784getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM11784getMh2AYeg = UShortArray.m11784getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM11784getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM11784getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m11784getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM11784getMh2AYeg2 = UShortArray.m11784getMh2AYeg(sArr, i);
                UShortArray.m11789set01HTLdE(sArr, i, UShortArray.m11784getMh2AYeg(sArr, i2));
                UShortArray.m11789set01HTLdE(sArr, i2, sM11784getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m11906partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM11600getpVg5ArA = UIntArray.m11600getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m11600getpVg5ArA(iArr, i), iM11600getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m11600getpVg5ArA(iArr, i2), iM11600getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM11600getpVg5ArA2 = UIntArray.m11600getpVg5ArA(iArr, i);
                UIntArray.m11605setVXSXFK8(iArr, i, UIntArray.m11600getpVg5ArA(iArr, i2));
                UIntArray.m11605setVXSXFK8(iArr, i2, iM11600getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m11907quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM11903partitionnroSd4 = m11903partitionnroSd4(jArr, i, i2);
        int i3 = iM11903partitionnroSd4 - 1;
        if (i < i3) {
            m11907quickSortnroSd4(jArr, i, i3);
        }
        if (iM11903partitionnroSd4 < i2) {
            m11907quickSortnroSd4(jArr, iM11903partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m11908quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM11904partition4UcCI2c = m11904partition4UcCI2c(bArr, i, i2);
        int i3 = iM11904partition4UcCI2c - 1;
        if (i < i3) {
            m11908quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM11904partition4UcCI2c < i2) {
            m11908quickSort4UcCI2c(bArr, iM11904partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m11909quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM11905partitionAa5vz7o = m11905partitionAa5vz7o(sArr, i, i2);
        int i3 = iM11905partitionAa5vz7o - 1;
        if (i < i3) {
            m11909quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM11905partitionAa5vz7o < i2) {
            m11909quickSortAa5vz7o(sArr, iM11905partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m11910quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM11906partitionoBK06Vg = m11906partitionoBK06Vg(iArr, i, i2);
        int i3 = iM11906partitionoBK06Vg - 1;
        if (i < i3) {
            m11910quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM11906partitionoBK06Vg < i2) {
            m11910quickSortoBK06Vg(iArr, iM11906partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m11911sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m11907quickSortnroSd4(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m11912sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m11908quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m11913sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m11909quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m11914sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m11910quickSortoBK06Vg(array, i, i2 - 1);
    }
}
