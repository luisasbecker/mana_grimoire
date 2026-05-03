package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuPosition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00128\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010&\u001a\u00020'2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b0\u0010\u0013J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J9\u00103\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0003Jh\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u000728\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0001¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RA\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "verticalMargin", "", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "", "<init>", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getVerticalMargin", "()I", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "component4", "copy", "copy-uVxBXkw", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;)Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long j, Density density, int i, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j;
        this.density = density;
        this.verticalMargin = i;
        this.onPositionCalculated = function2;
        int iMo1618roundToPx0680j_4 = density.mo1618roundToPx0680j_4(DpOffset.m9175getXD9Ej5fM(j));
        this.startToAnchorStart = MenuPosition.INSTANCE.startToAnchorStart(iMo1618roundToPx0680j_4);
        this.endToAnchorEnd = MenuPosition.INSTANCE.endToAnchorEnd(iMo1618roundToPx0680j_4);
        this.leftToWindowLeft = MenuPosition.INSTANCE.leftToWindowLeft(0);
        this.rightToWindowRight = MenuPosition.INSTANCE.rightToWindowRight(0);
        int iMo1618roundToPx0680j_42 = density.mo1618roundToPx0680j_4(DpOffset.m9177getYD9Ej5fM(j));
        this.topToAnchorBottom = MenuPosition.INSTANCE.topToAnchorBottom(iMo1618roundToPx0680j_42);
        this.bottomToAnchorTop = MenuPosition.INSTANCE.bottomToAnchorTop(iMo1618roundToPx0680j_42);
        this.centerToAnchorTop = MenuPosition.INSTANCE.centerToAnchorTop(iMo1618roundToPx0680j_42);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(i);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(i);
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, int i, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, (i2 & 4) != 0 ? density.mo1618roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i, (i2 & 8) != 0 ? new Function2() { // from class: androidx.compose.material3.internal.DropdownMenuPositionProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Unit.INSTANCE;
            }
        } : function2, null);
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, int i, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, i, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-uVxBXkw$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m4587copyuVxBXkw$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        Density density2 = density;
        if ((i2 & 4) != 0) {
            i = dropdownMenuPositionProvider.verticalMargin;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m4589copyuVxBXkw(j2, density2, i3, function2);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo1592calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        IntRect intRect;
        long j;
        char c;
        int iMo4570position95KtPRI;
        int iMo4571positionJVtK1S4;
        int i;
        char c2 = 3;
        MenuPosition.Horizontal[] horizontalArr = new MenuPosition.Horizontal[3];
        horizontalArr[0] = this.startToAnchorStart;
        horizontalArr[1] = this.endToAnchorEnd;
        int i2 = (int) (windowSize >> 32);
        horizontalArr[2] = IntOffset.m9242getXimpl(anchorBounds.m9266getCenternOccac()) < i2 / 2 ? this.leftToWindowLeft : this.rightToWindowRight;
        List listListOf = CollectionsKt.listOf((Object[]) horizontalArr);
        int size = listListOf.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                intRect = anchorBounds;
                j = windowSize;
                c = c2;
                iMo4570position95KtPRI = 0;
                break;
            }
            MenuPosition.Horizontal horizontal = (MenuPosition.Horizontal) listListOf.get(i3);
            int i4 = (int) (popupContentSize >> 32);
            int i5 = size;
            c = c2;
            j = windowSize;
            int i6 = i3;
            intRect = anchorBounds;
            iMo4570position95KtPRI = horizontal.mo4570position95KtPRI(intRect, j, i4, layoutDirection);
            if (i6 == CollectionsKt.getLastIndex(listListOf) || (iMo4570position95KtPRI >= 0 && i4 + iMo4570position95KtPRI <= i2)) {
                break;
            }
            i3 = i6 + 1;
            size = i5;
            c2 = c;
        }
        MenuPosition.Vertical[] verticalArr = new MenuPosition.Vertical[4];
        verticalArr[0] = this.topToAnchorBottom;
        verticalArr[1] = this.bottomToAnchorTop;
        verticalArr[2] = this.centerToAnchorTop;
        int iM9243getYimpl = IntOffset.m9243getYimpl(intRect.m9266getCenternOccac());
        int i7 = (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        verticalArr[c] = iM9243getYimpl < i7 / 2 ? this.topToWindowTop : this.bottomToWindowBottom;
        List listListOf2 = CollectionsKt.listOf((Object[]) verticalArr);
        int size2 = listListOf2.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size2) {
                iMo4571positionJVtK1S4 = 0;
                break;
            }
            MenuPosition.Vertical vertical = (MenuPosition.Vertical) listListOf2.get(i8);
            int i9 = i7;
            int i10 = (int) (popupContentSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            iMo4571positionJVtK1S4 = vertical.mo4571positionJVtK1S4(intRect, j, i10);
            if (i8 == CollectionsKt.getLastIndex(listListOf2) || (iMo4571positionJVtK1S4 >= (i = this.verticalMargin) && i10 + iMo4571positionJVtK1S4 <= i9 - i)) {
                break;
            }
            i8++;
            i7 = i9;
        }
        long jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) iMo4570position95KtPRI) << 32) | (((long) iMo4571positionJVtK1S4) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        this.onPositionCalculated.invoke(intRect, IntRectKt.m9275IntRectVbeCjmY(jM9236constructorimpl, popupContentSize));
        return jM9236constructorimpl;
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name and from getter */
    public final long getContentOffset() {
        return this.contentOffset;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> component4() {
        return this.onPositionCalculated;
    }

    /* JADX INFO: renamed from: copy-uVxBXkw, reason: not valid java name */
    public final DropdownMenuPositionProvider m4589copyuVxBXkw(long contentOffset, Density density, int verticalMargin, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        return new DropdownMenuPositionProvider(contentOffset, density, verticalMargin, onPositionCalculated, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m9174equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m4590getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public int hashCode() {
        return (((((DpOffset.m9179hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + Integer.hashCode(this.verticalMargin)) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m9182toStringimpl(this.contentOffset)) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }
}
