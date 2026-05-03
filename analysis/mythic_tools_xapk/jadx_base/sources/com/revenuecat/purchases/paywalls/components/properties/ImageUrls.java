package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: compiled from: ImageUrls.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÁ\u0001¢\u0006\u0002\b\"R\u0019\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "", "seen1", "", "original", "Ljava/net/URL;", "webp", "webpLowRes", "width", "Lkotlin/UInt;", "height", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/net/URL;Ljava/net/URL;Ljava/net/URL;Lkotlin/UInt;Lkotlin/UInt;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/net/URL;Ljava/net/URL;Ljava/net/URL;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-pVg5ArA", "()I", "I", "getOriginal$annotations", "()V", "getOriginal", "()Ljava/net/URL;", "getWebp$annotations", "getWebp", "getWebpLowRes$annotations", "getWebpLowRes", "getWidth-pVg5ArA", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class ImageUrls {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int height;
    private final URL original;
    private final URL webp;
    private final URL webpLowRes;
    private final int width;

    /* JADX INFO: compiled from: ImageUrls.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ImageUrls> serializer() {
            return ImageUrls$$serializer.INSTANCE;
        }
    }

    private ImageUrls(int i, URL url, URL url2, URL url3, UInt uInt, UInt uInt2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, ImageUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.original = url;
        this.webp = url2;
        this.webpLowRes = url3;
        this.width = uInt.getData();
        this.height = uInt2.getData();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ImageUrls(int i, @Serializable(with = URLSerializer.class) URL url, @Serializable(with = URLSerializer.class) URL url2, @SerialName("webp_low_res") @Serializable(with = URLSerializer.class) URL url3, UInt uInt, UInt uInt2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, url, url2, url3, uInt, uInt2, serializationConstructorMarker);
    }

    private ImageUrls(URL original, URL webp, URL webpLowRes, int i, int i2) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(webp, "webp");
        Intrinsics.checkNotNullParameter(webpLowRes, "webpLowRes");
        this.original = original;
        this.webp = webp;
        this.webpLowRes = webpLowRes;
        this.width = i;
        this.height = i2;
    }

    public /* synthetic */ ImageUrls(URL url, URL url2, URL url3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, url2, url3, i, i2);
    }

    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getOriginal$annotations() {
    }

    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getWebp$annotations() {
    }

    @SerialName("webp_low_res")
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getWebpLowRes$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ImageUrls self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, URLSerializer.INSTANCE, self.original);
        output.encodeSerializableElement(serialDesc, 1, URLSerializer.INSTANCE, self.webp);
        output.encodeSerializableElement(serialDesc, 2, URLSerializer.INSTANCE, self.webpLowRes);
        output.encodeSerializableElement(serialDesc, 3, UIntSerializer.INSTANCE, UInt.m11534boximpl(self.width));
        output.encodeSerializableElement(serialDesc, 4, UIntSerializer.INSTANCE, UInt.m11534boximpl(self.height));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageUrls)) {
            return false;
        }
        ImageUrls imageUrls = (ImageUrls) obj;
        return Intrinsics.areEqual(this.original, imageUrls.original) && Intrinsics.areEqual(this.webp, imageUrls.webp) && Intrinsics.areEqual(this.webpLowRes, imageUrls.webpLowRes) && this.width == imageUrls.width && this.height == imageUrls.height;
    }

    /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name and from getter */
    public final /* synthetic */ int getHeight() {
        return this.height;
    }

    public final /* synthetic */ URL getOriginal() {
        return this.original;
    }

    public final /* synthetic */ URL getWebp() {
        return this.webp;
    }

    public final /* synthetic */ URL getWebpLowRes() {
        return this.webpLowRes;
    }

    /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name and from getter */
    public final /* synthetic */ int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.original.hashCode() * 31) + this.webp.hashCode()) * 31) + this.webpLowRes.hashCode()) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "ImageUrls(original=" + this.original + ", webp=" + this.webp + ", webpLowRes=" + this.webpLowRes + ", width=" + ((Object) UInt.m11586toStringimpl(this.width)) + ", height=" + ((Object) UInt.m11586toStringimpl(this.height)) + ')';
    }
}
