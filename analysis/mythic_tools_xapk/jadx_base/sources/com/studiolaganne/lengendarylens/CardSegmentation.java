package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedAnalyzer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\u008f\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010%R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010%R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010%R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010%¨\u0006>"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardSegmentation;", "", "confidence", "", "polygonPoints", "", "Landroid/graphics/PointF;", "corners", "cardBitmap", "Landroid/graphics/Bitmap;", "enhancedCardBitmap", "cardType", "", "setSymbolHash", "", "titleRegionBitmap", "bottomTextRegionBitmap", "setSymbolBitmap", "pListBitmap", "<init>", "(FLjava/util/List;Ljava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;JLandroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "getConfidence", "()F", "getPolygonPoints", "()Ljava/util/List;", "getCorners", "getCardBitmap", "()Landroid/graphics/Bitmap;", "getEnhancedCardBitmap", "getCardType", "()Ljava/lang/String;", "getSetSymbolHash", "()J", "setSetSymbolHash", "(J)V", "getTitleRegionBitmap", "setTitleRegionBitmap", "(Landroid/graphics/Bitmap;)V", "getBottomTextRegionBitmap", "setBottomTextRegionBitmap", "getSetSymbolBitmap", "setSetSymbolBitmap", "getPListBitmap", "setPListBitmap", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardSegmentation {
    public static final int $stable = 8;
    private Bitmap bottomTextRegionBitmap;
    private final Bitmap cardBitmap;
    private final String cardType;
    private final float confidence;
    private final List<PointF> corners;
    private final Bitmap enhancedCardBitmap;
    private Bitmap pListBitmap;
    private final List<PointF> polygonPoints;
    private Bitmap setSymbolBitmap;
    private long setSymbolHash;
    private Bitmap titleRegionBitmap;

    /* JADX WARN: Multi-variable type inference failed */
    public CardSegmentation(float f, List<? extends PointF> polygonPoints, List<? extends PointF> corners, Bitmap bitmap, Bitmap bitmap2, String cardType, long j, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        Intrinsics.checkNotNullParameter(polygonPoints, "polygonPoints");
        Intrinsics.checkNotNullParameter(corners, "corners");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.confidence = f;
        this.polygonPoints = polygonPoints;
        this.corners = corners;
        this.cardBitmap = bitmap;
        this.enhancedCardBitmap = bitmap2;
        this.cardType = cardType;
        this.setSymbolHash = j;
        this.titleRegionBitmap = bitmap3;
        this.bottomTextRegionBitmap = bitmap4;
        this.setSymbolBitmap = bitmap5;
        this.pListBitmap = bitmap6;
    }

    public /* synthetic */ CardSegmentation(float f, List list, List list2, Bitmap bitmap, Bitmap bitmap2, String str, long j, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, list, list2, bitmap, bitmap2, str, j, (i & 128) != 0 ? null : bitmap3, (i & 256) != 0 ? null : bitmap4, (i & 512) != 0 ? null : bitmap5, (i & 1024) != 0 ? null : bitmap6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardSegmentation copy$default(CardSegmentation cardSegmentation, float f, List list, List list2, Bitmap bitmap, Bitmap bitmap2, String str, long j, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = cardSegmentation.confidence;
        }
        if ((i & 2) != 0) {
            list = cardSegmentation.polygonPoints;
        }
        if ((i & 4) != 0) {
            list2 = cardSegmentation.corners;
        }
        if ((i & 8) != 0) {
            bitmap = cardSegmentation.cardBitmap;
        }
        if ((i & 16) != 0) {
            bitmap2 = cardSegmentation.enhancedCardBitmap;
        }
        if ((i & 32) != 0) {
            str = cardSegmentation.cardType;
        }
        if ((i & 64) != 0) {
            j = cardSegmentation.setSymbolHash;
        }
        if ((i & 128) != 0) {
            bitmap3 = cardSegmentation.titleRegionBitmap;
        }
        if ((i & 256) != 0) {
            bitmap4 = cardSegmentation.bottomTextRegionBitmap;
        }
        if ((i & 512) != 0) {
            bitmap5 = cardSegmentation.setSymbolBitmap;
        }
        if ((i & 1024) != 0) {
            bitmap6 = cardSegmentation.pListBitmap;
        }
        long j2 = j;
        Bitmap bitmap7 = bitmap2;
        String str2 = str;
        List list3 = list2;
        Bitmap bitmap8 = bitmap;
        return cardSegmentation.copy(f, list, list3, bitmap8, bitmap7, str2, j2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Bitmap getSetSymbolBitmap() {
        return this.setSymbolBitmap;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Bitmap getPListBitmap() {
        return this.pListBitmap;
    }

    public final List<PointF> component2() {
        return this.polygonPoints;
    }

    public final List<PointF> component3() {
        return this.corners;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Bitmap getCardBitmap() {
        return this.cardBitmap;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Bitmap getEnhancedCardBitmap() {
        return this.enhancedCardBitmap;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getSetSymbolHash() {
        return this.setSymbolHash;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Bitmap getTitleRegionBitmap() {
        return this.titleRegionBitmap;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Bitmap getBottomTextRegionBitmap() {
        return this.bottomTextRegionBitmap;
    }

    public final CardSegmentation copy(float confidence, List<? extends PointF> polygonPoints, List<? extends PointF> corners, Bitmap cardBitmap, Bitmap enhancedCardBitmap, String cardType, long setSymbolHash, Bitmap titleRegionBitmap, Bitmap bottomTextRegionBitmap, Bitmap setSymbolBitmap, Bitmap pListBitmap) {
        Intrinsics.checkNotNullParameter(polygonPoints, "polygonPoints");
        Intrinsics.checkNotNullParameter(corners, "corners");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        return new CardSegmentation(confidence, polygonPoints, corners, cardBitmap, enhancedCardBitmap, cardType, setSymbolHash, titleRegionBitmap, bottomTextRegionBitmap, setSymbolBitmap, pListBitmap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardSegmentation)) {
            return false;
        }
        CardSegmentation cardSegmentation = (CardSegmentation) other;
        return Float.compare(this.confidence, cardSegmentation.confidence) == 0 && Intrinsics.areEqual(this.polygonPoints, cardSegmentation.polygonPoints) && Intrinsics.areEqual(this.corners, cardSegmentation.corners) && Intrinsics.areEqual(this.cardBitmap, cardSegmentation.cardBitmap) && Intrinsics.areEqual(this.enhancedCardBitmap, cardSegmentation.enhancedCardBitmap) && Intrinsics.areEqual(this.cardType, cardSegmentation.cardType) && this.setSymbolHash == cardSegmentation.setSymbolHash && Intrinsics.areEqual(this.titleRegionBitmap, cardSegmentation.titleRegionBitmap) && Intrinsics.areEqual(this.bottomTextRegionBitmap, cardSegmentation.bottomTextRegionBitmap) && Intrinsics.areEqual(this.setSymbolBitmap, cardSegmentation.setSymbolBitmap) && Intrinsics.areEqual(this.pListBitmap, cardSegmentation.pListBitmap);
    }

    public final Bitmap getBottomTextRegionBitmap() {
        return this.bottomTextRegionBitmap;
    }

    public final Bitmap getCardBitmap() {
        return this.cardBitmap;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final List<PointF> getCorners() {
        return this.corners;
    }

    public final Bitmap getEnhancedCardBitmap() {
        return this.enhancedCardBitmap;
    }

    public final Bitmap getPListBitmap() {
        return this.pListBitmap;
    }

    public final List<PointF> getPolygonPoints() {
        return this.polygonPoints;
    }

    public final Bitmap getSetSymbolBitmap() {
        return this.setSymbolBitmap;
    }

    public final long getSetSymbolHash() {
        return this.setSymbolHash;
    }

    public final Bitmap getTitleRegionBitmap() {
        return this.titleRegionBitmap;
    }

    public int hashCode() {
        int iHashCode = ((((Float.hashCode(this.confidence) * 31) + this.polygonPoints.hashCode()) * 31) + this.corners.hashCode()) * 31;
        Bitmap bitmap = this.cardBitmap;
        int iHashCode2 = (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        Bitmap bitmap2 = this.enhancedCardBitmap;
        int iHashCode3 = (((((iHashCode2 + (bitmap2 == null ? 0 : bitmap2.hashCode())) * 31) + this.cardType.hashCode()) * 31) + Long.hashCode(this.setSymbolHash)) * 31;
        Bitmap bitmap3 = this.titleRegionBitmap;
        int iHashCode4 = (iHashCode3 + (bitmap3 == null ? 0 : bitmap3.hashCode())) * 31;
        Bitmap bitmap4 = this.bottomTextRegionBitmap;
        int iHashCode5 = (iHashCode4 + (bitmap4 == null ? 0 : bitmap4.hashCode())) * 31;
        Bitmap bitmap5 = this.setSymbolBitmap;
        int iHashCode6 = (iHashCode5 + (bitmap5 == null ? 0 : bitmap5.hashCode())) * 31;
        Bitmap bitmap6 = this.pListBitmap;
        return iHashCode6 + (bitmap6 != null ? bitmap6.hashCode() : 0);
    }

    public final void setBottomTextRegionBitmap(Bitmap bitmap) {
        this.bottomTextRegionBitmap = bitmap;
    }

    public final void setPListBitmap(Bitmap bitmap) {
        this.pListBitmap = bitmap;
    }

    public final void setSetSymbolBitmap(Bitmap bitmap) {
        this.setSymbolBitmap = bitmap;
    }

    public final void setSetSymbolHash(long j) {
        this.setSymbolHash = j;
    }

    public final void setTitleRegionBitmap(Bitmap bitmap) {
        this.titleRegionBitmap = bitmap;
    }

    public String toString() {
        return "CardSegmentation(confidence=" + this.confidence + ", polygonPoints=" + this.polygonPoints + ", corners=" + this.corners + ", cardBitmap=" + this.cardBitmap + ", enhancedCardBitmap=" + this.enhancedCardBitmap + ", cardType=" + this.cardType + ", setSymbolHash=" + this.setSymbolHash + ", titleRegionBitmap=" + this.titleRegionBitmap + ", bottomTextRegionBitmap=" + this.bottomTextRegionBitmap + ", setSymbolBitmap=" + this.setSymbolBitmap + ", pListBitmap=" + this.pListBitmap + ")";
    }
}
