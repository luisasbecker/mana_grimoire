package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: IconComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u000256By\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016Bq\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017J&\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203HÁ\u0001¢\u0006\u0002\b4R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\"R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+¨\u00067"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "visible", "", "baseUrl", "", "iconName", "formats", "Lcom/revenuecat/purchases/paywalls/components/IconComponent$Formats;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "color", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "iconBackground", "Lcom/revenuecat/purchases/paywalls/components/IconComponent$IconBackground;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/IconComponent$Formats;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/IconComponent$IconBackground;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/IconComponent$Formats;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/IconComponent$IconBackground;)V", "getBaseUrl$annotations", "()V", "getBaseUrl", "()Ljava/lang/String;", "getColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getFormats", "()Lcom/revenuecat/purchases/paywalls/components/IconComponent$Formats;", "getIconBackground$annotations", "getIconBackground", "()Lcom/revenuecat/purchases/paywalls/components/IconComponent$IconBackground;", "getIconName$annotations", "getIconName", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getPadding", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PartialIconComponent implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String baseUrl;
    private final ColorScheme color;
    private final IconComponent.Formats formats;
    private final IconComponent.IconBackground iconBackground;
    private final String iconName;
    private final Padding margin;
    private final Padding padding;
    private final Size size;
    private final Boolean visible;

    /* JADX INFO: compiled from: IconComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialIconComponent> serializer() {
            return PartialIconComponent$$serializer.INSTANCE;
        }
    }

    public PartialIconComponent() {
        this((Boolean) null, (String) null, (String) null, (IconComponent.Formats) null, (Size) null, (ColorScheme) null, (Padding) null, (Padding) null, (IconComponent.IconBackground) null, 511, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PartialIconComponent(int i, Boolean bool, @SerialName("base_url") String str, @SerialName("icon_name") String str2, IconComponent.Formats formats, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, @SerialName("icon_background") IconComponent.IconBackground iconBackground, SerializationConstructorMarker serializationConstructorMarker) {
        this.visible = (i & 1) == 0 ? true : bool;
        if ((i & 2) == 0) {
            this.baseUrl = null;
        } else {
            this.baseUrl = str;
        }
        if ((i & 4) == 0) {
            this.iconName = null;
        } else {
            this.iconName = str2;
        }
        if ((i & 8) == 0) {
            this.formats = null;
        } else {
            this.formats = formats;
        }
        if ((i & 16) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i & 32) == 0) {
            this.color = null;
        } else {
            this.color = colorScheme;
        }
        if ((i & 64) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i & 128) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i & 256) == 0) {
            this.iconBackground = null;
        } else {
            this.iconBackground = iconBackground;
        }
    }

    public PartialIconComponent(Boolean bool, String str, String str2, IconComponent.Formats formats, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, IconComponent.IconBackground iconBackground) {
        this.visible = bool;
        this.baseUrl = str;
        this.iconName = str2;
        this.formats = formats;
        this.size = size;
        this.color = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.iconBackground = iconBackground;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PartialIconComponent(java.lang.Boolean r2, java.lang.String r3, java.lang.String r4, com.revenuecat.purchases.paywalls.components.IconComponent.Formats r5, com.revenuecat.purchases.paywalls.components.properties.Size r6, com.revenuecat.purchases.paywalls.components.properties.ColorScheme r7, com.revenuecat.purchases.paywalls.components.properties.Padding r8, com.revenuecat.purchases.paywalls.components.properties.Padding r9, com.revenuecat.purchases.paywalls.components.IconComponent.IconBackground r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L9
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
        L9:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto Lf
            r3 = r0
        Lf:
            r12 = r11 & 4
            if (r12 == 0) goto L14
            r4 = r0
        L14:
            r12 = r11 & 8
            if (r12 == 0) goto L19
            r5 = r0
        L19:
            r12 = r11 & 16
            if (r12 == 0) goto L1e
            r6 = r0
        L1e:
            r12 = r11 & 32
            if (r12 == 0) goto L23
            r7 = r0
        L23:
            r12 = r11 & 64
            if (r12 == 0) goto L28
            r8 = r0
        L28:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L2d
            r9 = r0
        L2d:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L3c
            r12 = r0
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L46
        L3c:
            r12 = r10
            r11 = r9
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L46:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.PartialIconComponent.<init>(java.lang.Boolean, java.lang.String, java.lang.String, com.revenuecat.purchases.paywalls.components.IconComponent$Formats, com.revenuecat.purchases.paywalls.components.properties.Size, com.revenuecat.purchases.paywalls.components.properties.ColorScheme, com.revenuecat.purchases.paywalls.components.properties.Padding, com.revenuecat.purchases.paywalls.components.properties.Padding, com.revenuecat.purchases.paywalls.components.IconComponent$IconBackground, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @SerialName("base_url")
    public static /* synthetic */ void getBaseUrl$annotations() {
    }

    @SerialName("icon_background")
    public static /* synthetic */ void getIconBackground$annotations() {
    }

    @SerialName("icon_name")
    public static /* synthetic */ void getIconName$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialIconComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual((Object) self.visible, (Object) true)) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.baseUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.baseUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.iconName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.iconName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.formats != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IconComponent$Formats$$serializer.INSTANCE, self.formats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ColorScheme$$serializer.INSTANCE, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.padding != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.margin != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, Padding$$serializer.INSTANCE, self.margin);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.iconBackground == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, IconComponent$IconBackground$$serializer.INSTANCE, self.iconBackground);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialIconComponent)) {
            return false;
        }
        PartialIconComponent partialIconComponent = (PartialIconComponent) obj;
        return Intrinsics.areEqual(this.visible, partialIconComponent.visible) && Intrinsics.areEqual(this.baseUrl, partialIconComponent.baseUrl) && Intrinsics.areEqual(this.iconName, partialIconComponent.iconName) && Intrinsics.areEqual(this.formats, partialIconComponent.formats) && Intrinsics.areEqual(this.size, partialIconComponent.size) && Intrinsics.areEqual(this.color, partialIconComponent.color) && Intrinsics.areEqual(this.padding, partialIconComponent.padding) && Intrinsics.areEqual(this.margin, partialIconComponent.margin) && Intrinsics.areEqual(this.iconBackground, partialIconComponent.iconBackground);
    }

    public final /* synthetic */ String getBaseUrl() {
        return this.baseUrl;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ IconComponent.Formats getFormats() {
        return this.formats;
    }

    public final /* synthetic */ IconComponent.IconBackground getIconBackground() {
        return this.iconBackground;
    }

    public final /* synthetic */ String getIconName() {
        return this.iconName;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.baseUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iconName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        IconComponent.Formats formats = this.formats;
        int iHashCode4 = (iHashCode3 + (formats == null ? 0 : formats.hashCode())) * 31;
        Size size = this.size;
        int iHashCode5 = (iHashCode4 + (size == null ? 0 : size.hashCode())) * 31;
        ColorScheme colorScheme = this.color;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        IconComponent.IconBackground iconBackground = this.iconBackground;
        return iHashCode8 + (iconBackground != null ? iconBackground.hashCode() : 0);
    }

    public String toString() {
        return "PartialIconComponent(visible=" + this.visible + ", baseUrl=" + this.baseUrl + ", iconName=" + this.iconName + ", formats=" + this.formats + ", size=" + this.size + ", color=" + this.color + ", padding=" + this.padding + ", margin=" + this.margin + ", iconBackground=" + this.iconBackground + ')';
    }
}
