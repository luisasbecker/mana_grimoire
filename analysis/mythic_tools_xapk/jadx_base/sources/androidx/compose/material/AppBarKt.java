package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001as\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b!\u0010\"\u001ak\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0082\b\u001a\u0019\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0080\b\u001a,\u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0,2\u0006\u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\u0006\u0010.\u001a\u00020&H\u0000\u001ag\u0010/\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0003¢\u0006\u0004\b1\u00102\"\u0010\u00103\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00105\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u000e\u00106\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00109\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u000e\u0010:\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"TopAppBar", "", Constants.GP_IAP_TITLE, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", FirebaseAnalytics.Param.CONTENT, "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "Landroidx/compose/ui/graphics/Shape;", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "square", "", "x", "calculateCutoutCircleYIntercept", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "AppBar", "shape", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AppBarHeight", "F", "AppBarHorizontalPadding", "TitleInsetWithoutIcon", "TitleIconModifier", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarKt {
    private static final float AppBarHeight = Dp.m9114constructorimpl(56.0f);
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;
    private static final WindowInsets ZeroInsets;

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(4.0f);
        AppBarHorizontalPadding = fM9114constructorimpl;
        TitleInsetWithoutIcon = SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(Dp.m9114constructorimpl(16.0f) - fM9114constructorimpl));
        TitleIconModifier = SizeKt.m2088width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(Dp.m9114constructorimpl(72.0f) - fM9114constructorimpl));
        BottomAppBarCutoutOffset = Dp.m9114constructorimpl(8.0f);
        BottomAppBarRoundedEdgeRadius = Dp.m9114constructorimpl(4.0f);
        ZeroInsets = WindowInsetsKt.m2109WindowInsetsa9UjIt4$default(Dp.m9114constructorimpl(0.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AppBar-HkEspTQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m2907AppBarHkEspTQ(final long j, final long j2, final float f, final PaddingValues paddingValues, final Shape shape, final WindowInsets windowInsets, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        float f2;
        Shape shape2;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1222317265);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBar)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,contentPadding,shape,windowInsets,modifier,content)706@31596L472,700@31428L640:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            f2 = f;
            i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            shape2 = shape;
            i3 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        int i4 = i2 & 64;
        if (i4 == 0) {
            if ((i & 1572864) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
            }
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1222317265, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:699)");
                }
                int i5 = i3 << 6;
                composer2 = composerStartRestartGroup;
                Shape shape3 = shape2;
                SurfaceKt.m3172SurfaceFjzlyU(modifier4, shape3, j, j2, null, f2, ComposableLambdaKt.rememberComposableLambda(-1628734195, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.AppBar_HkEspTQ$lambda$0(windowInsets, paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i5 & 896) | (i5 & 7168) | ((i3 << 9) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.AppBar_HkEspTQ$lambda$1(j, j2, f, paddingValues, shape, windowInsets, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 1572864;
        modifier2 = modifier;
        if ((i & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit AppBar_HkEspTQ$lambda$0(final WindowInsets windowInsets, final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C707@31671L6,707@31679L383,707@31606L456:AppBar.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1628734195, i, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:707)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer, 6))), ComposableLambdaKt.rememberComposableLambda(597057613, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.AppBar_HkEspTQ$lambda$0$0(windowInsets, paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBar_HkEspTQ$lambda$0$0(WindowInsets windowInsets, PaddingValues paddingValues, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C708@31693L359:AppBar.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(597057613, i, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:708)");
            }
            Modifier modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), paddingValues), AppBarHeight);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2069height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit AppBar_HkEspTQ$lambda$1(long j, long j2, float f, PaddingValues paddingValues, Shape shape, WindowInsets windowInsets, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2907AppBarHkEspTQ(j, j2, f, paddingValues, shape, windowInsets, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX INFO: renamed from: BottomAppBar-DanWW-k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2908BottomAppBarDanWWk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long primarySurface;
        long jM3001contentColorForek8zF_U;
        int i4;
        Shape shape2;
        int i5;
        float fM2904getBottomAppBarElevationD9Ej5fM;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final Shape shape3;
        final float f2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaddingValues contentPadding;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1136595494);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomAppBar)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,cutoutShape,elevation:c#ui.unit.Dp,contentPadding,content)337@15398L7,344@15612L175:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    primarySurface = j;
                    int i8 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i3 |= i8;
                } else {
                    primarySurface = j;
                }
                i3 |= i8;
            } else {
                primarySurface = j;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    jM3001contentColorForek8zF_U = j2;
                    int i9 = composerStartRestartGroup.changed(jM3001contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    jM3001contentColorForek8zF_U = j2;
                }
                i3 |= i9;
            } else {
                jM3001contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    shape2 = shape;
                    i3 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        fM2904getBottomAppBarElevationD9Ej5fM = f;
                        i3 |= composerStartRestartGroup.changed(fM2904getBottomAppBarElevationD9Ej5fM) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = primarySurface;
                        j4 = jM3001contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM2904getBottomAppBarElevationD9Ej5fM;
                        paddingValues2 = paddingValues;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                shape2 = null;
                            }
                            if (i5 != 0) {
                                fM2904getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2904getBottomAppBarElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            }
                            Modifier modifier4 = modifier2;
                            Shape shape4 = shape2;
                            float f3 = fM2904getBottomAppBarElevationD9Ej5fM;
                            long j5 = primarySurface;
                            long j6 = jM3001contentColorForek8zF_U;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                            }
                            ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localFabPlacement);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            FabPlacement fabPlacement = (FabPlacement) objConsume;
                            Shape bottomAppBarCutoutShape = (shape4 == null && fabPlacement != null && fabPlacement.getIsDocked()) ? new BottomAppBarCutoutShape(shape4, fabPlacement) : RectangleShapeKt.getRectangleShape();
                            int i10 = i3 >> 9;
                            int i11 = ((i3 >> 6) & 126) | (i10 & 896) | (i10 & 7168);
                            int i12 = i3 << 15;
                            composer2 = composerStartRestartGroup;
                            m2907AppBarHkEspTQ(j5, j6, f3, contentPadding, bottomAppBarCutoutShape, windowInsets, modifier4, function3, composer2, i11 | (458752 & i12) | (i12 & 3670016) | (i3 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape4;
                            j3 = j5;
                            j4 = j6;
                            f2 = f3;
                            paddingValues2 = contentPadding;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        contentPadding = paddingValues;
                        Modifier modifier42 = modifier2;
                        Shape shape42 = shape2;
                        float f32 = fM2904getBottomAppBarElevationD9Ej5fM;
                        long j52 = primarySurface;
                        long j62 = jM3001contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localFabPlacement2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FabPlacement fabPlacement2 = (FabPlacement) objConsume2;
                        if (shape42 == null) {
                            Shape bottomAppBarCutoutShape2 = (shape42 == null && fabPlacement2 != null && fabPlacement2.getIsDocked()) ? new BottomAppBarCutoutShape(shape42, fabPlacement2) : RectangleShapeKt.getRectangleShape();
                            int i102 = i3 >> 9;
                            int i112 = ((i3 >> 6) & 126) | (i102 & 896) | (i102 & 7168);
                            int i122 = i3 << 15;
                            composer2 = composerStartRestartGroup;
                            m2907AppBarHkEspTQ(j52, j62, f32, contentPadding, bottomAppBarCutoutShape2, windowInsets, modifier42, function3, composer2, i112 | (458752 & i122) | (i122 & 3670016) | (i3 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape3 = shape42;
                            j3 = j52;
                            j4 = j62;
                            f2 = f32;
                            paddingValues2 = contentPadding;
                            modifier3 = modifier42;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM2904getBottomAppBarElevationD9Ej5fM = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            shape2 = shape;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            fM2904getBottomAppBarElevationD9Ej5fM = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        shape2 = shape;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        fM2904getBottomAppBarElevationD9Ej5fM = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2909BottomAppBarY1yfwus(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        long primarySurface;
        long jM3001contentColorForek8zF_U;
        Shape shape2;
        int i4;
        float fM2904getBottomAppBarElevationD9Ej5fM;
        int i5;
        int i6;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final Shape shape3;
        final float f2;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        PaddingValues contentPadding;
        Shape shape4;
        float f3;
        int i7;
        long j5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2058075642);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomAppBar)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,cutoutShape,elevation:c#ui.unit.Dp,contentPadding,content)406@18576L7,413@18790L173:AppBar.kt#jmzs0o");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                primarySurface = j;
                int i9 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i9;
            } else {
                primarySurface = j;
            }
            i3 |= i9;
        } else {
            primarySurface = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM3001contentColorForek8zF_U = j2;
                int i10 = composerStartRestartGroup.changed(jM3001contentColorForek8zF_U) ? 256 : 128;
                i3 |= i10;
            } else {
                jM3001contentColorForek8zF_U = j2;
            }
            i3 |= i10;
        } else {
            jM3001contentColorForek8zF_U = j2;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                shape2 = shape;
                i3 |= composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    fM2904getBottomAppBarElevationD9Ej5fM = f;
                    i3 |= composerStartRestartGroup.changed(fM2904getBottomAppBarElevationD9Ej5fM) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i6 = 196608;
                    paddingValues2 = paddingValues;
                } else {
                    i6 = 196608;
                    paddingValues2 = paddingValues;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= composerStartRestartGroup.changed(paddingValues2) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "399@18245L6,400@18294L32");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM2904getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2904getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i5 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            shape4 = shape2;
                            f3 = fM2904getBottomAppBarElevationD9Ej5fM;
                            i7 = -2058075642;
                            j5 = primarySurface;
                            long j6 = jM3001contentColorForek8zF_U;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
                            }
                            ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localFabPlacement);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            FabPlacement fabPlacement = (FabPlacement) objConsume;
                            BottomAppBarCutoutShape bottomAppBarCutoutShape = (shape4 == null && fabPlacement != null && fabPlacement.getIsDocked()) ? new BottomAppBarCutoutShape(shape4, fabPlacement) : RectangleShapeKt.getRectangleShape();
                            int i12 = i3 >> 3;
                            int i13 = i3 >> 6;
                            composer2 = composerStartRestartGroup;
                            m2907AppBarHkEspTQ(j5, j6, f3, contentPadding, bottomAppBarCutoutShape, ZeroInsets, modifier3, function3, composer2, (i12 & 112) | (i12 & 14) | i6 | (i13 & 896) | (i13 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape4;
                            j3 = j5;
                            j4 = j6;
                            f2 = f3;
                            paddingValues3 = contentPadding;
                            modifier2 = modifier3;
                        } else {
                            modifier3 = companion;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier3 = modifier;
                    }
                    shape4 = shape2;
                    contentPadding = paddingValues2;
                    i7 = -2058075642;
                    j5 = primarySurface;
                    f3 = fM2904getBottomAppBarElevationD9Ej5fM;
                    long j62 = jM3001contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localFabPlacement2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement2 = (FabPlacement) objConsume2;
                    if (shape4 == null) {
                        int i122 = i3 >> 3;
                        int i132 = i3 >> 6;
                        composer2 = composerStartRestartGroup;
                        m2907AppBarHkEspTQ(j5, j62, f3, contentPadding, bottomAppBarCutoutShape, ZeroInsets, modifier3, function3, composer2, (i122 & 112) | (i122 & 14) | i6 | (i132 & 896) | (i132 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape3 = shape4;
                        j3 = j5;
                        j4 = j62;
                        f2 = f3;
                        paddingValues3 = contentPadding;
                        modifier2 = modifier3;
                    }
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM3001contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM2904getBottomAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.BottomAppBar_Y1yfwus$lambda$0(modifier2, j3, j4, shape3, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            fM2904getBottomAppBarElevationD9Ej5fM = f;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        shape2 = shape;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        fM2904getBottomAppBarElevationD9Ej5fM = f;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit BottomAppBar_DanWW_k$lambda$0(WindowInsets windowInsets, Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2908BottomAppBarDanWWk(windowInsets, modifier, j, j2, shape, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit BottomAppBar_Y1yfwus$lambda$0(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2909BottomAppBarY1yfwus(modifier, j, j2, shape, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c6  */
    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2910TopAppBarHsRjFd4(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long primarySurface;
        long j3;
        float fM2905getTopAppBarElevationD9Ej5fM;
        int i4;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        final float f2;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long j6;
        float f3;
        PaddingValues contentPadding;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2030536439);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,contentPadding,content)270@12153L203:AppBar.kt#jmzs0o");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                primarySurface = j;
                int i6 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i6;
            } else {
                primarySurface = j;
            }
            i3 |= i6;
        } else {
            primarySurface = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j2;
                int i7 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                i3 |= i7;
            } else {
                j3 = j2;
            }
            i3 |= i7;
        } else {
            j3 = j2;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                fM2905getTopAppBarElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM2905getTopAppBarElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= composerStartRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                }
                if ((196608 & i) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "264@11894L6,265@11943L32");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM3001contentColorForek8zF_U;
                        }
                        if (i8 != 0) {
                            fM2905getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2905getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = companion;
                            j6 = j3;
                            f3 = fM2905getTopAppBarElevationD9Ej5fM;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j7 = primarySurface;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2030536439, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
                            }
                            int i9 = i3 >> 3;
                            composer2 = composerStartRestartGroup;
                            m2907AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i9 & 7168) | (i9 & 14) | 221184 | (i9 & 112) | (i9 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j7;
                            j5 = j6;
                            f2 = f3;
                            paddingValues3 = contentPadding;
                            modifier3 = modifier4;
                        } else {
                            modifier4 = companion;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier4 = modifier2;
                    }
                    f3 = fM2905getTopAppBarElevationD9Ej5fM;
                    j7 = primarySurface;
                    contentPadding = paddingValues2;
                    j6 = j3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i92 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    m2907AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i92 & 7168) | (i92 & 14) | 221184 | (i92 & 112) | (i92 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j4 = j7;
                    j5 = j6;
                    f2 = f3;
                    paddingValues3 = contentPadding;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = primarySurface;
                    j5 = j3;
                    f2 = fM2905getTopAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_HsRjFd4$lambda$0(modifier3, j4, j5, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            paddingValues2 = paddingValues;
            if ((196608 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM2905getTopAppBarElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        paddingValues2 = paddingValues;
        if ((196608 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX INFO: renamed from: TopAppBar-Rx1qByU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2911TopAppBarRx1qByU(final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        WindowInsets windowInsets2;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> lambda$269254275$material;
        long primarySurface;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        final long j3;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM3001contentColorForek8zF_U;
        Modifier modifier4;
        int i8;
        long j4;
        float fM2905getTopAppBarElevationD9Ej5fM;
        Composer composerStartRestartGroup = composer.startRestartGroup(138090236);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(title,windowInsets,modifier,navigationIcon,actions,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)101@4667L1063,93@4484L1246:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            windowInsets2 = windowInsets;
            i3 |= composerStartRestartGroup.changed(windowInsets2) ? 32 : 16;
        } else {
            windowInsets2 = windowInsets;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    function23 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        lambda$269254275$material = function3;
                        i3 |= composerStartRestartGroup.changedInstance(lambda$269254275$material) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            primarySurface = j;
                            int i10 = composerStartRestartGroup.changed(primarySurface) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            primarySurface = j;
                        }
                        i3 |= i10;
                    } else {
                        primarySurface = j;
                    }
                    if ((1572864 & i) == 0) {
                        i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j2)) ? 1048576 : 524288;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                    }
                    i7 = i3;
                    if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i7 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function24 = function23;
                        function32 = lambda$269254275$material;
                        j3 = j2;
                        f2 = f;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function23 = null;
                            }
                            if (i5 != 0) {
                                lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                            }
                            if ((i2 & 32) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i7 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i7 >> 15) & 14);
                                i7 &= -3670017;
                            } else {
                                jM3001contentColorForek8zF_U = j2;
                            }
                            if (i6 != 0) {
                                long j5 = jM3001contentColorForek8zF_U;
                                fM2905getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2905getTopAppBarElevationD9Ej5fM();
                                i8 = i7;
                                j4 = j5;
                                modifier4 = modifier2;
                            } else {
                                modifier4 = modifier2;
                                i8 = i7;
                                j4 = jM3001contentColorForek8zF_U;
                                fM2905getTopAppBarElevationD9Ej5fM = f;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i7 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i7 &= -3670017;
                            }
                            fM2905getTopAppBarElevationD9Ej5fM = f;
                            modifier4 = modifier2;
                            i8 = i7;
                            j4 = j2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(138090236, i8, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                        }
                        int i11 = i8 >> 15;
                        int i12 = i8 << 12;
                        composer2 = composerStartRestartGroup;
                        m2907AppBarHkEspTQ(primarySurface, j4, fM2905getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function23, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i11 & 896) | (i11 & 14) | 12610560 | (i11 & 112) | (458752 & i12) | (i12 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function24 = function23;
                        function32 = lambda$269254275$material;
                        j3 = j4;
                        f2 = fM2905getTopAppBarElevationD9Ej5fM;
                        modifier3 = modifier4;
                    }
                    final long j6 = primarySurface;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function24, function32, j6, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                lambda$269254275$material = function3;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) == 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i3;
                if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i7 & 1)) {
                }
                final long j62 = primarySurface;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function23 = function22;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            lambda$269254275$material = function3;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i3;
            if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i7 & 1)) {
            }
            final long j622 = primarySurface;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        lambda$269254275$material = function3;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i3;
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i7 & 1)) {
        }
        final long j6222 = primarySurface;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX INFO: renamed from: TopAppBar-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2912TopAppBarafqeVBk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long primarySurface;
        long jM3001contentColorForek8zF_U;
        int i4;
        float fM2905getTopAppBarElevationD9Ej5fM;
        int i5;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f2;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaddingValues contentPadding;
        Modifier modifier4;
        long j5;
        float f3;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(684777089);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,contentPadding,content)222@10051L205:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    primarySurface = j;
                    int i7 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i3 |= i7;
                } else {
                    primarySurface = j;
                }
                i3 |= i7;
            } else {
                primarySurface = j;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    jM3001contentColorForek8zF_U = j2;
                    int i8 = composerStartRestartGroup.changed(jM3001contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i8;
                } else {
                    jM3001contentColorForek8zF_U = j2;
                }
                i3 |= i8;
            } else {
                jM3001contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    fM2905getTopAppBarElevationD9Ej5fM = f;
                    i3 |= composerStartRestartGroup.changed(fM2905getTopAppBarElevationD9Ej5fM) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        paddingValues2 = paddingValues;
                        i3 |= composerStartRestartGroup.changed(paddingValues2) ? 131072 : 65536;
                    }
                    if ((1572864 & i) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = primarySurface;
                        j4 = jM3001contentColorForek8zF_U;
                        f2 = fM2905getTopAppBarElevationD9Ej5fM;
                        paddingValues3 = paddingValues2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                fM2905getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2905getTopAppBarElevationD9Ej5fM();
                            }
                            if (i5 != 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                modifier4 = modifier2;
                                j5 = jM3001contentColorForek8zF_U;
                                f3 = fM2905getTopAppBarElevationD9Ej5fM;
                                j6 = primarySurface;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                            }
                            int i9 = i3 >> 6;
                            int i10 = i3 << 15;
                            composer2 = composerStartRestartGroup;
                            m2907AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i9 & 7168) | (i9 & 14) | 24576 | (i9 & 112) | (i9 & 896) | (458752 & i10) | (i10 & 3670016) | ((i3 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j6;
                            j4 = j5;
                            f2 = f3;
                            paddingValues3 = contentPadding;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        modifier4 = modifier2;
                        f3 = fM2905getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM3001contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i3 >> 6;
                        int i102 = i3 << 15;
                        composer2 = composerStartRestartGroup;
                        m2907AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i92 & 7168) | (i92 & 14) | 24576 | (i92 & 112) | (i92 & 896) | (458752 & i102) | (i102 & 3670016) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j3 = j6;
                        j4 = j5;
                        f2 = f3;
                        paddingValues3 = contentPadding;
                        modifier3 = modifier4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                paddingValues2 = paddingValues;
                if ((1572864 & i) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM2905getTopAppBarElevationD9Ej5fM = f;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            paddingValues2 = paddingValues;
            if ((1572864 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        fM2905getTopAppBarElevationD9Ej5fM = f;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((1572864 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2913TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> lambda$1260131259$material;
        long primarySurface;
        long jM3001contentColorForek8zF_U;
        int i6;
        int i7;
        Composer composer2;
        final float f2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        float fM2905getTopAppBarElevationD9Ej5fM;
        Composer composerStartRestartGroup = composer.startRestartGroup(-350082398);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(title,modifier,navigationIcon,actions,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)169@7728L176:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function23 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        lambda$1260131259$material = function3;
                        i3 |= composerStartRestartGroup.changedInstance(lambda$1260131259$material) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        primarySurface = j;
                        i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(primarySurface)) ? 16384 : 8192;
                    } else {
                        primarySurface = j;
                    }
                    if ((196608 & i) != 0) {
                        jM3001contentColorForek8zF_U = j2;
                        i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(jM3001contentColorForek8zF_U)) ? 131072 : 65536;
                    } else {
                        jM3001contentColorForek8zF_U = j2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
                    }
                    i7 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i7 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f2 = f;
                        modifier3 = modifier2;
                        function24 = function23;
                        function32 = lambda$1260131259$material;
                        j3 = primarySurface;
                        j4 = jM3001contentColorForek8zF_U;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function23 = null;
                            }
                            if (i5 != 0) {
                                lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                            }
                            if ((i2 & 16) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i8 = i7 & (-57345);
                            } else {
                                i8 = i7;
                            }
                            if ((i2 & 32) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            }
                            if (i6 != 0) {
                                fM2905getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2905getTopAppBarElevationD9Ej5fM();
                            }
                            long j5 = primarySurface;
                            long j6 = jM3001contentColorForek8zF_U;
                            Modifier modifier4 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = lambda$1260131259$material;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350082398, i8, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                            }
                            int i10 = (i8 & 14) | 48;
                            int i11 = i8 << 3;
                            composer2 = composerStartRestartGroup;
                            m2911TopAppBarRx1qByU(function2, ZeroInsets, modifier4, function25, function33, j5, j6, fM2905getTopAppBarElevationD9Ej5fM, composer2, i10 | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (i11 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function24 = function25;
                            function32 = function33;
                            j3 = j5;
                            j4 = j6;
                            f2 = fM2905getTopAppBarElevationD9Ej5fM;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i8 = (i2 & 16) != 0 ? i7 & (-57345) : i7;
                            if ((i2 & 32) != 0) {
                                i8 &= -458753;
                            }
                        }
                        fM2905getTopAppBarElevationD9Ej5fM = f;
                        long j52 = primarySurface;
                        long j62 = jM3001contentColorForek8zF_U;
                        Modifier modifier42 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function332 = lambda$1260131259$material;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i102 = (i8 & 14) | 48;
                        int i112 = i8 << 3;
                        composer2 = composerStartRestartGroup;
                        m2911TopAppBarRx1qByU(function2, ZeroInsets, modifier42, function252, function332, j52, j62, fM2905getTopAppBarElevationD9Ej5fM, composer2, i102 | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        function24 = function252;
                        function32 = function332;
                        j3 = j52;
                        j4 = j62;
                        f2 = fM2905getTopAppBarElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function24, function32, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                lambda$1260131259$material = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function23 = function22;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            lambda$1260131259$material = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i7 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        lambda$1260131259$material = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit TopAppBar_HsRjFd4$lambda$0(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2910TopAppBarHsRjFd4(modifier, j, j2, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TopAppBar_Rx1qByU$lambda$0(Function2 function2, final Function2 function22, final Function3 function3, RowScope rowScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C113@5056L345,122@5476L6,122@5484L240,122@5411L313:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019867954, i2, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:102)");
            }
            if (function2 == null) {
                composer.startReplaceGroup(-1394361313);
                ComposerKt.sourceInformation(composer, "103@4719L29");
                SpacerKt.Spacer(TitleInsetWithoutIcon, composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1394295686);
                ComposerKt.sourceInformation(composer, "105@4778L258");
                Modifier modifier = TitleIconModifier;
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 2031468274, "C107@4953L4,106@4867L155:AppBar.kt#jmzs0o");
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6))), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -297206295, "C114@5198L10,114@5213L178,114@5159L232:AppBar.kt#jmzs0o");
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getH6(), ComposableLambdaKt.rememberComposableLambda(1206983395, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_Rx1qByU$lambda$0$1$0(function22, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer, 6))), ComposableLambdaKt.rememberComposableLambda(-1033635954, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_Rx1qByU$lambda$0$2(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_Rx1qByU$lambda$0$1$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C116@5317L4,115@5231L146:AppBar.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1206983395, i, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:115)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6))), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_Rx1qByU$lambda$0$2(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C123@5498L216:AppBar.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1033635954, i, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:123)");
            }
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxHeight$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TopAppBar_Rx1qByU$lambda$1(Function2 function2, WindowInsets windowInsets, Modifier modifier, Function2 function22, Function3 function3, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        m2911TopAppBarRx1qByU(function2, windowInsets, modifier, function22, function3, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TopAppBar_afqeVBk$lambda$0(WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2912TopAppBarafqeVBk(windowInsets, modifier, j, j2, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TopAppBar_xWeB9_s$lambda$0(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        m2913TopAppBarxWeB9s(function2, modifier, function22, function3, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f2) {
        return -((float) Math.sqrt((f * f) - (f2 * f2)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f, float f2, float f3) {
        Float fValueOf;
        Float fValueOf2;
        Pair pair;
        Float fValueOf3;
        Float fValueOf4;
        float f4 = f2 * f2;
        float f5 = f3 * f3;
        float f6 = (f * f) + f4;
        float f7 = f4 * f5 * (f6 - f5);
        float f8 = f * f5;
        double d = f7;
        float fSqrt = (f8 - ((float) Math.sqrt(d))) / f6;
        float fSqrt2 = (f8 + ((float) Math.sqrt(d))) / f6;
        float fSqrt3 = (float) Math.sqrt(f5 - (fSqrt * fSqrt));
        float fSqrt4 = (float) Math.sqrt(f5 - (fSqrt2 * fSqrt2));
        if (f2 > 0.0f) {
            if (fSqrt3 > fSqrt4) {
                fValueOf3 = Float.valueOf(fSqrt);
                fValueOf4 = Float.valueOf(fSqrt3);
            } else {
                fValueOf3 = Float.valueOf(fSqrt2);
                fValueOf4 = Float.valueOf(fSqrt4);
            }
            pair = TuplesKt.to(fValueOf3, fValueOf4);
        } else {
            if (fSqrt3 < fSqrt4) {
                fValueOf = Float.valueOf(fSqrt);
                fValueOf2 = Float.valueOf(fSqrt3);
            } else {
                fValueOf = Float.valueOf(fSqrt2);
                fValueOf2 = Float.valueOf(fSqrt4);
            }
            pair = TuplesKt.to(fValueOf, fValueOf2);
        }
        float fFloatValue = ((Number) pair.component1()).floatValue();
        float fFloatValue2 = ((Number) pair.component2()).floatValue();
        if (fFloatValue < f) {
            fFloatValue2 = -fFloatValue2;
        }
        return TuplesKt.to(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2));
    }

    private static final float square(float f) {
        return f * f;
    }
}
