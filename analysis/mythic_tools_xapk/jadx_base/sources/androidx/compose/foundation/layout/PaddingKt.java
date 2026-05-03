package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"padding", "Landroidx/compose/ui/Modifier;", "start", "Landroidx/compose/ui/unit/Dp;", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "absolutePadding-qDBjuR0", "calculateStartPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PaddingKt {
    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m2030PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m2031PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2032PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        return m2031PaddingValuesYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m2033PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2034PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m9114constructorimpl(0.0f);
        }
        return m2033PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m2035absolutePaddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, false, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.absolutePadding_qDBjuR0$lambda$0(f, f2, f3, f4, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2036absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m9114constructorimpl(0.0f);
        }
        return m2035absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    static final Unit absolutePadding_qDBjuR0$lambda$0(float f, float f2, float f3, float f4, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set(ViewHierarchyConstants.DIMENSION_LEFT_KEY, Dp.m9112boximpl(f));
        inspectorInfo.getProperties().set(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.m9112boximpl(f2));
        inspectorInfo.getProperties().set("right", Dp.m9112boximpl(f3));
        inspectorInfo.getProperties().set("bottom", Dp.m9112boximpl(f4));
        return Unit.INSTANCE;
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo1988calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo1987calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo1987calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo1988calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding$lambda$0(paddingValues, (InspectorInfo) obj);
            }
        }));
    }

    static final Unit padding$lambda$0(PaddingValues paddingValues, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("paddingValues", paddingValues);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m2037padding3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new PaddingElement(f, f, f, f, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_3ABfNKs$lambda$0(f, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m2038paddingVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_VpY3zN4$lambda$0(f, f2, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2039paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        return m2038paddingVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m2040paddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_qDBjuR0$lambda$0(f, f2, f3, f4, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2041paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m9114constructorimpl(0.0f);
        }
        return m2040paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    static final Unit padding_3ABfNKs$lambda$0(float f, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.setValue(Dp.m9112boximpl(f));
        return Unit.INSTANCE;
    }

    static final Unit padding_VpY3zN4$lambda$0(float f, float f2, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("horizontal", Dp.m9112boximpl(f));
        inspectorInfo.getProperties().set("vertical", Dp.m9112boximpl(f2));
        return Unit.INSTANCE;
    }

    static final Unit padding_qDBjuR0$lambda$0(float f, float f2, float f3, float f4, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("start", Dp.m9112boximpl(f));
        inspectorInfo.getProperties().set(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.m9112boximpl(f2));
        inspectorInfo.getProperties().set("end", Dp.m9112boximpl(f3));
        inspectorInfo.getProperties().set("bottom", Dp.m9112boximpl(f4));
        return Unit.INSTANCE;
    }
}
