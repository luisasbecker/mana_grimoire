package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _UComparisons.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0088\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\u0088\u0004¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001b\u001a%\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b\u001d\u0010\u001e\u001a%\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b \u0010!\u001a%\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b&\u0010\u0005\u001a!\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b'\u0010\b\u001a!\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b(\u0010\u000b\u001a!\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b)\u0010\u000e\u001a)\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0088\u0004¢\u0006\u0004\b*\u0010\u0011\u001a)\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0004\b+\u0010\u0013\u001a)\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\b,\u0010\u0015\u001a)\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\u0088\u0004¢\u0006\u0004\b-\u0010\u0017\u001a%\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b.\u0010\u001b\u001a%\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b/\u0010\u001e\u001a%\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b0\u0010!\u001a%\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
public class UComparisonsKt___UComparisonsKt {
    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m12637maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m12638maxOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) >= 0 ? i : i2;
    }

    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m12639maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) >= 0 ? b : b2;
    }

    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m12640maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11601getSizeimpl = UIntArray.m11601getSizeimpl(other);
        for (int i2 = 0; i2 < iM11601getSizeimpl; i2++) {
            i = UComparisonsKt.m12638maxOfJ1ME1BU(i, UIntArray.m11600getpVg5ArA(other, i2));
        }
        return i;
    }

    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m12641maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11680getSizeimpl = ULongArray.m11680getSizeimpl(other);
        for (int i = 0; i < iM11680getSizeimpl; i++) {
            j = UComparisonsKt.m12646maxOfeb3DHEI(j, ULongArray.m11679getsVKNKU(other, i));
        }
        return j;
    }

    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m12642maxOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m12637maxOf5PvTz6A(s, UComparisonsKt.m12637maxOf5PvTz6A(s2, s3));
    }

    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m12643maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m12638maxOfJ1ME1BU(i, UComparisonsKt.m12638maxOfJ1ME1BU(i2, i3));
    }

    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m12644maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11522getSizeimpl = UByteArray.m11522getSizeimpl(other);
        for (int i = 0; i < iM11522getSizeimpl; i++) {
            b = UComparisonsKt.m12639maxOfKr8caGY(b, UByteArray.m11521getw2LRezQ(other, i));
        }
        return b;
    }

    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m12645maxOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m12639maxOfKr8caGY(b, UComparisonsKt.m12639maxOfKr8caGY(b2, b3));
    }

    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m12646maxOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) >= 0 ? j : j2;
    }

    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m12647maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m12646maxOfeb3DHEI(j, UComparisonsKt.m12646maxOfeb3DHEI(j2, j3));
    }

    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m12648maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11785getSizeimpl = UShortArray.m11785getSizeimpl(other);
        for (int i = 0; i < iM11785getSizeimpl; i++) {
            s = UComparisonsKt.m12637maxOf5PvTz6A(s, UShortArray.m11784getMh2AYeg(other, i));
        }
        return s;
    }

    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m12649minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m12650minOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) <= 0 ? i : i2;
    }

    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m12651minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) <= 0 ? b : b2;
    }

    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m12652minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11601getSizeimpl = UIntArray.m11601getSizeimpl(other);
        for (int i2 = 0; i2 < iM11601getSizeimpl; i2++) {
            i = UComparisonsKt.m12650minOfJ1ME1BU(i, UIntArray.m11600getpVg5ArA(other, i2));
        }
        return i;
    }

    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m12653minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11680getSizeimpl = ULongArray.m11680getSizeimpl(other);
        for (int i = 0; i < iM11680getSizeimpl; i++) {
            j = UComparisonsKt.m12658minOfeb3DHEI(j, ULongArray.m11679getsVKNKU(other, i));
        }
        return j;
    }

    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m12654minOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m12649minOf5PvTz6A(s, UComparisonsKt.m12649minOf5PvTz6A(s2, s3));
    }

    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m12655minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m12650minOfJ1ME1BU(i, UComparisonsKt.m12650minOfJ1ME1BU(i2, i3));
    }

    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m12656minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11522getSizeimpl = UByteArray.m11522getSizeimpl(other);
        for (int i = 0; i < iM11522getSizeimpl; i++) {
            b = UComparisonsKt.m12651minOfKr8caGY(b, UByteArray.m11521getw2LRezQ(other, i));
        }
        return b;
    }

    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m12657minOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m12651minOfKr8caGY(b, UComparisonsKt.m12651minOfKr8caGY(b2, b3));
    }

    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m12658minOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) <= 0 ? j : j2;
    }

    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m12659minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m12658minOfeb3DHEI(j, UComparisonsKt.m12658minOfeb3DHEI(j2, j3));
    }

    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m12660minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM11785getSizeimpl = UShortArray.m11785getSizeimpl(other);
        for (int i = 0; i < iM11785getSizeimpl; i++) {
            s = UComparisonsKt.m12649minOf5PvTz6A(s, UShortArray.m11784getMh2AYeg(other, i));
        }
        return s;
    }
}
