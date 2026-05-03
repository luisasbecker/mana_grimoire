package com.vanniktech.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087@\u0018\u0000 32\u00060\u0002j\u0002`\u0001:\u00013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001c\u0010\u0006J5\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ5\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020 2\b\b\u0002\u0010\u0017\u001a\u00020 2\b\b\u0002\u0010\u0019\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010!J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0006J\u0013\u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u001d\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b1\u00102R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u00064"}, d2 = {"Lcom/vanniktech/ui/Color;", "Lcom/vanniktech/ui/UiParcelable;", "Landroid/os/Parcelable;", "argb", "", "constructor-impl", "(I)I", "getArgb", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "hexString", "hexString-impl$ui_release", "htmlRgbaString", "htmlRgbaString-impl", "shouldUseBlackFont", "", "shouldUseBlackFont-impl", "(I)Z", "alpha", "alpha-impl$ui_release", "red", "red-impl$ui_release", "green", "green-impl$ui_release", "blue", "blue-impl$ui_release", "copy", "copy-ONg3jNY", "(IIIII)I", "", "(IFFFF)I", "brighten", "factor", "brighten-3BSO9UY", "(IF)I", "describeContents", "describeContents-impl", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "writeToParcel-impl", "(ILandroid/os/Parcel;I)V", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
@Serializable(with = ColorSerializer.class)
public final class Color implements Parcelable {
    private final int argb;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Color> CREATOR = new Creator();
    private static final List<Character> HEX_DIGITS = StringsKt.toList("0123456789ABCDEF");
    private static final int UNTINTED = m11372constructorimpl(-10289408);
    private static final int WHITE = m11372constructorimpl(-1);
    private static final int BLACK = m11372constructorimpl(-16777216);
    private static final int TRANSPARENT = m11372constructorimpl(0);

    /* JADX INFO: compiled from: Color.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\b\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u000e\u001a\u00020\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0010\u001a\u00020\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0012\u001a\u00020\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/vanniktech/ui/Color$Companion;", "", "<init>", "()V", "HEX_DIGITS", "", "", "getHEX_DIGITS$ui_release", "()Ljava/util/List;", "UNTINTED", "Lcom/vanniktech/ui/Color;", "getUNTINTED-oEAH0UE", "()I", "I", "WHITE", "getWHITE-oEAH0UE", "BLACK", "getBLACK-oEAH0UE", "TRANSPARENT", "getTRANSPARENT-oEAH0UE", "fromArgb", "alpha", "", "red", "green", "blue", "fromArgb-ONg3jNY", "(IIII)I", "fromHexOrNull", "hex", "", "fromHexOrNull-TUbRjns", "serializer", "Lkotlinx/serialization/KSerializer;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: fromArgb-ONg3jNY, reason: not valid java name */
        public final int m11389fromArgbONg3jNY(int alpha, int red, int green, int blue) {
            IntRange color_component_range = ColorKt.getCOLOR_COMPONENT_RANGE();
            int first = color_component_range.getFirst();
            if (alpha > color_component_range.getLast() || first > alpha) {
                throw new IllegalArgumentException(("alpha \"" + alpha + "\" is not in \"" + ColorKt.getCOLOR_COMPONENT_RANGE() + "\" range").toString());
            }
            IntRange color_component_range2 = ColorKt.getCOLOR_COMPONENT_RANGE();
            int first2 = color_component_range2.getFirst();
            if (red > color_component_range2.getLast() || first2 > red) {
                throw new IllegalArgumentException(("red \"" + red + "\" is not in \"" + ColorKt.getCOLOR_COMPONENT_RANGE() + "\" range").toString());
            }
            IntRange color_component_range3 = ColorKt.getCOLOR_COMPONENT_RANGE();
            int first3 = color_component_range3.getFirst();
            if (green > color_component_range3.getLast() || first3 > green) {
                throw new IllegalArgumentException(("green \"" + green + "\" is not in \"" + ColorKt.getCOLOR_COMPONENT_RANGE() + "\" range").toString());
            }
            IntRange color_component_range4 = ColorKt.getCOLOR_COMPONENT_RANGE();
            int first4 = color_component_range4.getFirst();
            if (blue <= color_component_range4.getLast() && first4 <= blue) {
                return Color.m11372constructorimpl((alpha << 24) | (red << 16) | (green << 8) | blue);
            }
            throw new IllegalArgumentException(("blue \"" + blue + "\" is not in \"" + ColorKt.getCOLOR_COMPONENT_RANGE() + "\" range").toString());
        }

        /* JADX INFO: renamed from: fromHexOrNull-TUbRjns, reason: not valid java name */
        public final Color m11390fromHexOrNullTUbRjns(String hex) {
            Intrinsics.checkNotNullParameter(hex, "hex");
            String strRemovePrefix = StringsKt.removePrefix(hex, (CharSequence) ColorKt.HEX_PREFIX);
            int length = strRemovePrefix.length();
            int i = 0;
            if (length == 3) {
                String str = strRemovePrefix;
                ArrayList arrayList = new ArrayList(str.length());
                while (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    arrayList.add(new StringBuilder().append(cCharAt).append(cCharAt).toString());
                    i++;
                }
                strRemovePrefix = "FF" + CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
            } else if (length == 4) {
                String str2 = strRemovePrefix;
                ArrayList arrayList2 = new ArrayList(str2.length());
                while (i < str2.length()) {
                    char cCharAt2 = str2.charAt(i);
                    arrayList2.add(new StringBuilder().append(cCharAt2).append(cCharAt2).toString());
                    i++;
                }
                strRemovePrefix = CollectionsKt.joinToString$default(arrayList2, "", null, null, 0, null, null, 62, null);
            } else if (length == 6) {
                strRemovePrefix = "FF" + strRemovePrefix;
            } else if (length != 8) {
                strRemovePrefix = null;
            }
            if (strRemovePrefix != null) {
                try {
                    return Color.m11370boximpl(Color.m11372constructorimpl((int) Long.parseLong(strRemovePrefix, CharsKt.checkRadix(16))));
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: getBLACK-oEAH0UE, reason: not valid java name */
        public final int m11391getBLACKoEAH0UE() {
            return Color.BLACK;
        }

        public final List<Character> getHEX_DIGITS$ui_release() {
            return Color.HEX_DIGITS;
        }

        /* JADX INFO: renamed from: getTRANSPARENT-oEAH0UE, reason: not valid java name */
        public final int m11392getTRANSPARENToEAH0UE() {
            return Color.TRANSPARENT;
        }

        /* JADX INFO: renamed from: getUNTINTED-oEAH0UE, reason: not valid java name */
        public final int m11393getUNTINTEDoEAH0UE() {
            return Color.UNTINTED;
        }

        /* JADX INFO: renamed from: getWHITE-oEAH0UE, reason: not valid java name */
        public final int m11394getWHITEoEAH0UE() {
            return Color.WHITE;
        }

        public final KSerializer<Color> serializer() {
            return ColorSerializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: Color.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Color> {
        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Color createFromParcel(Parcel parcel) {
            return Color.m11370boximpl(m11395createFromParcel3BSO9UY(parcel));
        }

        /* JADX INFO: renamed from: createFromParcel-3BSO9UY, reason: not valid java name */
        public final int m11395createFromParcel3BSO9UY(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return Color.m11372constructorimpl(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Color[] newArray(int i) {
            return new Color[i];
        }
    }

    private /* synthetic */ Color(int i) {
        this.argb = i;
    }

    /* JADX INFO: renamed from: alpha-impl$ui_release, reason: not valid java name */
    public static final int m11368alphaimpl$ui_release(int i) {
        return (i >> 24) & 255;
    }

    /* JADX INFO: renamed from: blue-impl$ui_release, reason: not valid java name */
    public static final int m11369blueimpl$ui_release(int i) {
        return i & 255;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m11370boximpl(int i) {
        return new Color(i);
    }

    /* JADX INFO: renamed from: brighten-3BSO9UY, reason: not valid java name */
    public static final int m11371brighten3BSO9UY(int i, float f) {
        return INSTANCE.m11389fromArgbONg3jNY(m11368alphaimpl$ui_release(i), RangesKt.coerceIn((int) (m11384redimpl$ui_release(i) * f), (ClosedRange<Integer>) ColorKt.getCOLOR_COMPONENT_RANGE()), RangesKt.coerceIn((int) (m11380greenimpl$ui_release(i) * f), (ClosedRange<Integer>) ColorKt.getCOLOR_COMPONENT_RANGE()), RangesKt.coerceIn((int) (m11369blueimpl$ui_release(i) * f), (ClosedRange<Integer>) ColorKt.getCOLOR_COMPONENT_RANGE()));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m11372constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: copy-ONg3jNY, reason: not valid java name */
    public static final int m11373copyONg3jNY(int i, float f, float f2, float f3, float f4) {
        return INSTANCE.m11389fromArgbONg3jNY((int) Math.ceil(f * ColorKt.getFLOAT_VALUE()), (int) Math.ceil(f2 * ColorKt.getFLOAT_VALUE()), (int) Math.ceil(f3 * ColorKt.getFLOAT_VALUE()), (int) Math.ceil(f4 * ColorKt.getFLOAT_VALUE()));
    }

    /* JADX INFO: renamed from: copy-ONg3jNY, reason: not valid java name */
    public static final int m11374copyONg3jNY(int i, int i2, int i3, int i4, int i5) {
        return INSTANCE.m11389fromArgbONg3jNY(i2, i3, i4, i5);
    }

    /* JADX INFO: renamed from: copy-ONg3jNY$default, reason: not valid java name */
    public static /* synthetic */ int m11375copyONg3jNY$default(int i, float f, float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = m11368alphaimpl$ui_release(i) / ColorKt.getFLOAT_VALUE();
        }
        if ((i2 & 2) != 0) {
            f2 = m11384redimpl$ui_release(i) / ColorKt.getFLOAT_VALUE();
        }
        if ((i2 & 4) != 0) {
            f3 = m11380greenimpl$ui_release(i) / ColorKt.getFLOAT_VALUE();
        }
        if ((i2 & 8) != 0) {
            f4 = m11369blueimpl$ui_release(i) / ColorKt.getFLOAT_VALUE();
        }
        return m11373copyONg3jNY(i, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: copy-ONg3jNY$default, reason: not valid java name */
    public static /* synthetic */ int m11376copyONg3jNY$default(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = m11368alphaimpl$ui_release(i);
        }
        if ((i6 & 2) != 0) {
            i3 = m11384redimpl$ui_release(i);
        }
        if ((i6 & 4) != 0) {
            i4 = m11380greenimpl$ui_release(i);
        }
        if ((i6 & 8) != 0) {
            i5 = m11369blueimpl$ui_release(i);
        }
        return m11374copyONg3jNY(i, i2, i3, i4, i5);
    }

    /* JADX INFO: renamed from: describeContents-impl, reason: not valid java name */
    public static final int m11377describeContentsimpl(int i) {
        return 0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m11378equalsimpl(int i, Object obj) {
        return (obj instanceof Color) && i == ((Color) obj).m11388unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m11379equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: green-impl$ui_release, reason: not valid java name */
    public static final int m11380greenimpl$ui_release(int i) {
        return (i >> 8) & 255;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m11381hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: htmlRgbaString-impl, reason: not valid java name */
    public static final String m11383htmlRgbaStringimpl(int i) {
        return "rgba(" + m11384redimpl$ui_release(i) + ", " + m11380greenimpl$ui_release(i) + ", " + m11369blueimpl$ui_release(i) + ", " + m11368alphaimpl$ui_release(i) + ")";
    }

    /* JADX INFO: renamed from: red-impl$ui_release, reason: not valid java name */
    public static final int m11384redimpl$ui_release(int i) {
        return (i >> 16) & 255;
    }

    /* JADX INFO: renamed from: shouldUseBlackFont-impl, reason: not valid java name */
    public static final boolean m11385shouldUseBlackFontimpl(int i) {
        return (((double) m11384redimpl$ui_release(i)) * 0.299d) + ((((double) m11380greenimpl$ui_release(i)) * 0.587d) + (((double) m11369blueimpl$ui_release(i)) * 0.114d)) > 186.0d;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m11386toStringimpl(int i) {
        int i2 = m11368alphaimpl$ui_release(i) == ColorKt.getCOLOR_COMPONENT_RANGE().getLast() ? 6 : 8;
        String string = "";
        for (int i3 = 0; i3 < i2; i3++) {
            string = new StringBuilder().append((Object) string).append(HEX_DIGITS.get(i & 15)).toString();
            i >>>= 4;
        }
        return ColorKt.HEX_PREFIX + StringsKt.reversed((CharSequence) string).toString();
    }

    /* JADX INFO: renamed from: writeToParcel-impl, reason: not valid java name */
    public static final void m11387writeToParcelimpl(int i, Parcel dest, int i2) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return m11377describeContentsimpl(this.argb);
    }

    public boolean equals(Object other) {
        return m11378equalsimpl(this.argb, other);
    }

    public final int getArgb() {
        return this.argb;
    }

    public int hashCode() {
        return m11381hashCodeimpl(this.argb);
    }

    public String toString() {
        return m11386toStringimpl(this.argb);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m11388unboximpl() {
        return this.argb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        m11387writeToParcelimpl(this.argb, dest, i);
    }
}
