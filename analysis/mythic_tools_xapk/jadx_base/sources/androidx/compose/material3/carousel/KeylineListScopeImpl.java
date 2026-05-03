package androidx.compose.material3.carousel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: KeylineList.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007J%\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0005H\u0002JT\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J \u0010#\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "<init>", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createWithPivot", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "findLastFocalIndex", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "isCutoffLeft", TypedValues.CycleType.S_WAVE_OFFSET, "isCutoffRight", "TmpKeyline", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class KeylineListScopeImpl implements KeylineListScope {
    private float focalItemSize;
    private float pivotOffset;
    private int firstFocalIndex = -1;
    private int pivotIndex = -1;
    private final List<TmpKeyline> tmpKeylines = new ArrayList();

    /* JADX INFO: compiled from: KeylineList.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "<init>", "(FZ)V", "getSize", "()F", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final /* data */ class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public TmpKeyline(float f, boolean z) {
            this.size = f;
            this.isAnchor = z;
        }

        public static /* synthetic */ TmpKeyline copy$default(TmpKeyline tmpKeyline, float f, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = tmpKeyline.size;
            }
            if ((i & 2) != 0) {
                z = tmpKeyline.isAnchor;
            }
            return tmpKeyline.copy(f, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsAnchor() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float size, boolean isAnchor) {
            return new TmpKeyline(size, isAnchor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmpKeyline)) {
                return false;
            }
            TmpKeyline tmpKeyline = (TmpKeyline) other;
            return Float.compare(this.size, tmpKeyline.size) == 0 && this.isAnchor == tmpKeyline.isAnchor;
        }

        public final float getSize() {
            return this.size;
        }

        public int hashCode() {
            return (Float.hashCode(this.size) * 31) + Boolean.hashCode(this.isAnchor);
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }

        public String toString() {
            return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Keyline> createKeylinesWithPivot(int pivotIndex, float pivotOffset, int firstFocalIndex, int lastFocalIndex, float itemMainAxisSize, float carouselMainAxisSize, float itemSpacing, List<TmpKeyline> tmpKeylines) {
        TmpKeyline tmpKeyline;
        float f;
        float size;
        int i;
        Iterator<Integer> it;
        Iterator<Integer> it2;
        TmpKeyline tmpKeyline2 = tmpKeylines.get(pivotIndex);
        ArrayList arrayList = new ArrayList();
        if (isCutoffLeft(tmpKeyline2.getSize(), pivotOffset)) {
            size = pivotOffset - (tmpKeyline2.getSize() / 2.0f);
        } else {
            if (!isCutoffRight(tmpKeyline2.getSize(), pivotOffset, carouselMainAxisSize)) {
                tmpKeyline = tmpKeyline2;
                f = 0.0f;
                TmpKeyline tmpKeyline3 = tmpKeyline;
                float size2 = tmpKeyline3.getSize();
                boolean z = false;
                if (firstFocalIndex <= pivotIndex || pivotIndex > lastFocalIndex) {
                    i = 0;
                } else {
                    i = 0;
                    z = true;
                }
                int i2 = i;
                arrayList.add(new Keyline(size2, pivotOffset, pivotOffset, z, tmpKeyline3.isAnchor(), true, f));
                float f2 = itemMainAxisSize / 2.0f;
                float size3 = (pivotOffset - f2) - itemSpacing;
                it = RangesKt.downTo(pivotIndex - 1, i2).iterator();
                float f3 = size3;
                while (it.hasNext()) {
                    int iNextInt = ((IntIterator) it).nextInt();
                    TmpKeyline tmpKeyline4 = tmpKeylines.get(iNextInt);
                    float size4 = size3 - (tmpKeyline4.getSize() / 2.0f);
                    arrayList.add(i2, new Keyline(tmpKeyline4.getSize(), size4, f3 - f2, (firstFocalIndex > iNextInt || iNextInt > lastFocalIndex) ? i2 : 1, tmpKeyline4.isAnchor(), false, isCutoffLeft(tmpKeyline4.getSize(), size4) ? Math.abs(size4 - (tmpKeyline4.getSize() / 2.0f)) : 0.0f));
                    size3 -= tmpKeyline4.getSize() + itemSpacing;
                    f3 -= itemMainAxisSize + itemSpacing;
                }
                float size5 = pivotOffset + f2 + itemSpacing;
                it2 = RangesKt.until(pivotIndex + 1, tmpKeylines.size()).iterator();
                float f4 = size5;
                while (it2.hasNext()) {
                    int iNextInt2 = ((IntIterator) it2).nextInt();
                    TmpKeyline tmpKeyline5 = tmpKeylines.get(iNextInt2);
                    float size6 = (tmpKeyline5.getSize() / 2.0f) + size5;
                    arrayList.add(new Keyline(tmpKeyline5.getSize(), size6, f4 + f2, (firstFocalIndex > iNextInt2 || iNextInt2 > lastFocalIndex) ? i2 : 1, tmpKeyline5.isAnchor(), false, isCutoffRight(tmpKeyline5.getSize(), size6, carouselMainAxisSize) ? ((tmpKeyline5.getSize() / 2.0f) + size6) - carouselMainAxisSize : 0.0f));
                    size5 += tmpKeyline5.getSize() + itemSpacing;
                    f4 += itemMainAxisSize + itemSpacing;
                }
                return arrayList;
            }
            size = ((tmpKeyline2.getSize() / 2.0f) + pivotOffset) - carouselMainAxisSize;
        }
        f = size;
        tmpKeyline = tmpKeyline2;
        TmpKeyline tmpKeyline32 = tmpKeyline;
        float size22 = tmpKeyline32.getSize();
        boolean z2 = false;
        if (firstFocalIndex <= pivotIndex) {
            i = 0;
        }
        int i22 = i;
        arrayList.add(new Keyline(size22, pivotOffset, pivotOffset, z2, tmpKeyline32.isAnchor(), true, f));
        float f22 = itemMainAxisSize / 2.0f;
        float size32 = (pivotOffset - f22) - itemSpacing;
        it = RangesKt.downTo(pivotIndex - 1, i22).iterator();
        float f32 = size32;
        while (it.hasNext()) {
        }
        float size52 = pivotOffset + f22 + itemSpacing;
        it2 = RangesKt.until(pivotIndex + 1, tmpKeylines.size()).iterator();
        float f42 = size52;
        while (it2.hasNext()) {
        }
        return arrayList;
    }

    private final int findLastFocalIndex() {
        int i = this.firstFocalIndex;
        while (i < CollectionsKt.getLastIndex(this.tmpKeylines)) {
            int i2 = i + 1;
            if (this.tmpKeylines.get(i2).getSize() != this.focalItemSize) {
                break;
            }
            i = i2;
        }
        return i;
    }

    private final boolean isCutoffLeft(float size, float offset) {
        float f = size / 2.0f;
        return offset - f < 0.0f && offset + f > 0.0f;
    }

    private final boolean isCutoffRight(float size, float offset, float carouselMainAxisSize) {
        float f = size / 2.0f;
        return offset - f < carouselMainAxisSize && offset + f > carouselMainAxisSize;
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public void add(float size, boolean isAnchor) {
        this.tmpKeylines.add(new TmpKeyline(size, isAnchor));
        if (size > this.focalItemSize) {
            this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
            this.focalItemSize = size;
        }
    }

    /* JADX INFO: renamed from: createWithAlignment-waks0t8, reason: not valid java name */
    public final KeylineList m4569createWithAlignmentwaks0t8(float carouselMainAxisSize, float itemSpacing, int carouselAlignment) {
        float f;
        int iFindLastFocalIndex = findLastFocalIndex();
        int i = this.firstFocalIndex;
        int i2 = iFindLastFocalIndex - i;
        this.pivotIndex = i;
        if (CarouselAlignment.m4548equalsimpl0(carouselAlignment, CarouselAlignment.INSTANCE.m4552getCenterNUL3oTo())) {
            float f2 = 0.0f;
            if (itemSpacing != 0.0f) {
                int i3 = i2 % 2;
                if (i3 + ((((i3 ^ 2) & ((-i3) | i3)) >> 31) & 2) != 0) {
                    f2 = itemSpacing / 2.0f;
                }
            }
            f = ((carouselMainAxisSize / 2.0f) - ((this.focalItemSize / 2.0f) * i2)) - f2;
        } else {
            boolean zM4548equalsimpl0 = CarouselAlignment.m4548equalsimpl0(carouselAlignment, CarouselAlignment.INSTANCE.m4553getEndNUL3oTo());
            float f3 = this.focalItemSize;
            f = zM4548equalsimpl0 ? carouselMainAxisSize - (f3 / 2.0f) : f3 / 2.0f;
        }
        float f4 = f;
        this.pivotOffset = f4;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f4, this.firstFocalIndex, iFindLastFocalIndex, this.focalItemSize, carouselMainAxisSize, itemSpacing, this.tmpKeylines));
    }

    public final KeylineList createWithPivot(float carouselMainAxisSize, float itemSpacing, int pivotIndex, float pivotOffset) {
        return new KeylineList(createKeylinesWithPivot(pivotIndex, pivotOffset, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, carouselMainAxisSize, itemSpacing, this.tmpKeylines));
    }
}
