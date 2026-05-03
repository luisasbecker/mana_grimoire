package com.revenuecat.purchases.paywalls.components.properties;

import androidx.camera.video.AudioStats;
import com.caverock.androidsvg.SVGParser;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: CornerRadiuses.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "", "Companion", "Dp", "Percentage", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Dp;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Percentage;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable(with = CornerRadiusesSerializer.class)
public interface CornerRadiuses {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: CornerRadiuses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<CornerRadiuses> serializer() {
            return CornerRadiusesSerializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: CornerRadiuses.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\b\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB%\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Dp;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "", "(D)V", "seen1", "", "topLeading", "topTrailing", "bottomLeading", "bottomTrailing", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(DDDD)V", "getBottomLeading$annotations", "()V", "getBottomLeading", "()D", "getBottomTrailing$annotations", "getBottomTrailing", "getTopLeading$annotations", "getTopLeading", "getTopTrailing$annotations", "getTopTrailing", "copy", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final class Dp implements CornerRadiuses {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: default, reason: not valid java name */
        private static final Dp f148default;
        private static final Dp zero;
        private final double bottomLeading;
        private final double bottomTrailing;
        private final double topLeading;
        private final double topTrailing;

        /* JADX INFO: compiled from: CornerRadiuses.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001R\u0013\u0010\u0003\u001a\u00020\u00048F¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u00020\u00048F¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Dp$Companion;", "", "()V", "default", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Dp;", "getDefault", "()Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Dp;", "zero", "getZero", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dp getDefault() {
                return Dp.f148default;
            }

            public final /* synthetic */ Dp getZero() {
                return Dp.zero;
            }

            public final KSerializer<Dp> serializer() {
                return CornerRadiuses$Dp$$serializer.INSTANCE;
            }
        }

        static {
            Dp dp = new Dp(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
            zero = dp;
            f148default = dp;
        }

        public Dp(double d) {
            this(d, d, d, d);
        }

        public Dp(double d, double d2, double d3, double d4) {
            this.topLeading = d;
            this.topTrailing = d2;
            this.bottomLeading = d3;
            this.bottomTrailing = d4;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Dp(int i, @SerialName("top_leading") double d, @SerialName("top_trailing") double d2, @SerialName("bottom_leading") double d3, @SerialName("bottom_trailing") double d4, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, CornerRadiuses$Dp$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = d;
            this.topTrailing = d2;
            this.bottomLeading = d3;
            this.bottomTrailing = d4;
        }

        public static /* synthetic */ Dp copy$default(Dp dp, double d, double d2, double d3, double d4, int i, Object obj) {
            if ((i & 1) != 0) {
                d = dp.topLeading;
            }
            double d5 = d;
            if ((i & 2) != 0) {
                d2 = dp.topTrailing;
            }
            double d6 = d2;
            if ((i & 4) != 0) {
                d3 = dp.bottomLeading;
            }
            return dp.copy(d5, d6, d3, (i & 8) != 0 ? dp.bottomTrailing : d4);
        }

        @SerialName("bottom_leading")
        public static /* synthetic */ void getBottomLeading$annotations() {
        }

        @SerialName("bottom_trailing")
        public static /* synthetic */ void getBottomTrailing$annotations() {
        }

        @SerialName("top_leading")
        public static /* synthetic */ void getTopLeading$annotations() {
        }

        @SerialName("top_trailing")
        public static /* synthetic */ void getTopTrailing$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Dp self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeDoubleElement(serialDesc, 0, self.topLeading);
            output.encodeDoubleElement(serialDesc, 1, self.topTrailing);
            output.encodeDoubleElement(serialDesc, 2, self.bottomLeading);
            output.encodeDoubleElement(serialDesc, 3, self.bottomTrailing);
        }

        public final Dp copy(double topLeading, double topTrailing, double bottomLeading, double bottomTrailing) {
            return new Dp(topLeading, topTrailing, bottomLeading, bottomTrailing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dp)) {
                return false;
            }
            Dp dp = (Dp) obj;
            return Double.compare(this.topLeading, dp.topLeading) == 0 && Double.compare(this.topTrailing, dp.topTrailing) == 0 && Double.compare(this.bottomLeading, dp.bottomLeading) == 0 && Double.compare(this.bottomTrailing, dp.bottomTrailing) == 0;
        }

        public final /* synthetic */ double getBottomLeading() {
            return this.bottomLeading;
        }

        public final /* synthetic */ double getBottomTrailing() {
            return this.bottomTrailing;
        }

        public final /* synthetic */ double getTopLeading() {
            return this.topLeading;
        }

        public final /* synthetic */ double getTopTrailing() {
            return this.topTrailing;
        }

        public int hashCode() {
            return (((((Double.hashCode(this.topLeading) * 31) + Double.hashCode(this.topTrailing)) * 31) + Double.hashCode(this.bottomLeading)) * 31) + Double.hashCode(this.bottomTrailing);
        }

        public String toString() {
            return "Dp(topLeading=" + this.topLeading + ", topTrailing=" + this.topTrailing + ", bottomLeading=" + this.bottomLeading + ", bottomTrailing=" + this.bottomTrailing + ')';
        }
    }

    /* JADX INFO: compiled from: CornerRadiuses.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\b\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB-\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Percentage;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "", "(I)V", "seen1", "topLeading", "topTrailing", "bottomLeading", "bottomTrailing", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IIII)V", "getBottomLeading$annotations", "()V", "getBottomLeading", "()I", "getBottomTrailing$annotations", "getBottomTrailing", "getTopLeading$annotations", "getTopLeading", "getTopTrailing$annotations", "getTopTrailing", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final class Percentage implements CornerRadiuses {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int bottomLeading;
        private final int bottomTrailing;
        private final int topLeading;
        private final int topTrailing;

        /* JADX INFO: compiled from: CornerRadiuses.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Percentage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Percentage;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Percentage> serializer() {
                return CornerRadiuses$Percentage$$serializer.INSTANCE;
            }
        }

        public Percentage(int i) {
            this(i, i, i, i);
        }

        public Percentage(int i, int i2, int i3, int i4) {
            this.topLeading = i;
            this.topTrailing = i2;
            this.bottomLeading = i3;
            this.bottomTrailing = i4;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Percentage(int i, @SerialName("top_leading") int i2, @SerialName("top_trailing") int i3, @SerialName("bottom_leading") int i4, @SerialName("bottom_trailing") int i5, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, CornerRadiuses$Percentage$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = i2;
            this.topTrailing = i3;
            this.bottomLeading = i4;
            this.bottomTrailing = i5;
        }

        @SerialName("bottom_leading")
        public static /* synthetic */ void getBottomLeading$annotations() {
        }

        @SerialName("bottom_trailing")
        public static /* synthetic */ void getBottomTrailing$annotations() {
        }

        @SerialName("top_leading")
        public static /* synthetic */ void getTopLeading$annotations() {
        }

        @SerialName("top_trailing")
        public static /* synthetic */ void getTopTrailing$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Percentage self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.topLeading);
            output.encodeIntElement(serialDesc, 1, self.topTrailing);
            output.encodeIntElement(serialDesc, 2, self.bottomLeading);
            output.encodeIntElement(serialDesc, 3, self.bottomTrailing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Percentage)) {
                return false;
            }
            Percentage percentage = (Percentage) obj;
            return this.topLeading == percentage.topLeading && this.topTrailing == percentage.topTrailing && this.bottomLeading == percentage.bottomLeading && this.bottomTrailing == percentage.bottomTrailing;
        }

        public final /* synthetic */ int getBottomLeading() {
            return this.bottomLeading;
        }

        public final /* synthetic */ int getBottomTrailing() {
            return this.bottomTrailing;
        }

        public final /* synthetic */ int getTopLeading() {
            return this.topLeading;
        }

        public final /* synthetic */ int getTopTrailing() {
            return this.topTrailing;
        }

        public int hashCode() {
            return (((((this.topLeading * 31) + this.topTrailing) * 31) + this.bottomLeading) * 31) + this.bottomTrailing;
        }

        public String toString() {
            return "Percentage(topLeading=" + this.topLeading + ", topTrailing=" + this.topTrailing + ", bottomLeading=" + this.bottomLeading + ", bottomTrailing=" + this.bottomTrailing + ')';
        }
    }
}
