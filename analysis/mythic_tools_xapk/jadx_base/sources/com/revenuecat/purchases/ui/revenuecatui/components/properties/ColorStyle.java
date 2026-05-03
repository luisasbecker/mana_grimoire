package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.graphics.Color;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "", "Gradient", "Solid", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Gradient;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Solid;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ColorStyle {

    /* JADX INFO: compiled from: ColorStyle.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Gradient;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "brush", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "constructor-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "getBrush", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "equals", "", "other", "", "equals-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;)Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Gradient implements ColorStyle {
        private final /* synthetic */ GradientBrush brush;

        private /* synthetic */ Gradient(GradientBrush gradientBrush) {
            this.brush = gradientBrush;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Gradient m10524boximpl(GradientBrush gradientBrush) {
            return new Gradient(gradientBrush);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static GradientBrush m10525constructorimpl(GradientBrush brush) {
            Intrinsics.checkNotNullParameter(brush, "brush");
            return brush;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m10526equalsimpl(GradientBrush gradientBrush, Object obj) {
            return (obj instanceof Gradient) && Intrinsics.areEqual(gradientBrush, ((Gradient) obj).m10530unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m10527equalsimpl0(GradientBrush gradientBrush, GradientBrush gradientBrush2) {
            return Intrinsics.areEqual(gradientBrush, gradientBrush2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m10528hashCodeimpl(GradientBrush gradientBrush) {
            return gradientBrush.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m10529toStringimpl(GradientBrush gradientBrush) {
            return "Gradient(brush=" + gradientBrush + ')';
        }

        public boolean equals(Object obj) {
            return m10526equalsimpl(this.brush, obj);
        }

        public final GradientBrush getBrush() {
            return this.brush;
        }

        public int hashCode() {
            return m10528hashCodeimpl(this.brush);
        }

        public String toString() {
            return m10529toStringimpl(this.brush);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ GradientBrush m10530unboximpl() {
            return this.brush;
        }
    }

    /* JADX INFO: compiled from: ColorStyle.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Solid;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "constructor-impl", "(J)J", "getColor-0d7_KjU", "()J", "J", "equals", "", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Solid implements ColorStyle {
        private final /* synthetic */ long color;

        private /* synthetic */ Solid(long j) {
            this.color = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Solid m10531boximpl(long j) {
            return new Solid(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m10532constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m10533equalsimpl(long j, Object obj) {
            return (obj instanceof Solid) && Color.m6326equalsimpl0(j, ((Solid) obj).m10538unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m10534equalsimpl0(long j, long j2) {
            return Color.m6326equalsimpl0(j, j2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m10535hashCodeimpl(long j) {
            return Color.m6332hashCodeimpl(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m10536toStringimpl(long j) {
            return "Solid(color=" + ((Object) Color.m6333toStringimpl(j)) + ')';
        }

        public boolean equals(Object obj) {
            return m10533equalsimpl(this.color, obj);
        }

        /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
        public final long getColor() {
            return this.color;
        }

        public int hashCode() {
            return m10535hashCodeimpl(this.color);
        }

        public String toString() {
            return m10536toStringimpl(this.color);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m10538unboximpl() {
            return this.color;
        }
    }
}
