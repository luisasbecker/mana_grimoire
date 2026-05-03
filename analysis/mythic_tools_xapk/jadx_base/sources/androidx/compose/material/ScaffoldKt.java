package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a¤\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b)\u0010*\u001a\u009c\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b+\u0010,\u001a¥\u0001\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00162\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b0H\u0003¢\u0006\u0004\b3\u00104\"\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010706X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109\"\u0010\u0010:\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;¨\u0006<"}, d2 = {"rememberScaffoldState", "Landroidx/compose/material/ScaffoldState;", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "Scaffold", "", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "Landroidx/compose/ui/unit/Dp;", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "FabSpacing", "F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ScaffoldKt.LocalFabPlacement$lambda$0();
        }
    });
    private static final float FabSpacing = Dp.m9114constructorimpl(16.0f);

    static final FabPlacement LocalFabPlacement$lambda$0() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:290:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0111  */
    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3131Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i2, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        ScaffoldState scaffoldStateRememberScaffoldState;
        Function2<? super Composer, ? super Integer, Unit> lambda$566090785$material;
        int i6;
        int i7;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> lambda$939725476$material;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function2M3007getLambda$1341284559$material;
        int i9;
        int iM3052getEnd5ygKITE;
        int i10;
        boolean z3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        long j6;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final float f2;
        final long j7;
        final long j8;
        final long j9;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final Modifier modifier3;
        final ScaffoldState scaffoldState2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final int i19;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        final boolean z5;
        final Shape shape2;
        final long j10;
        final long j11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CornerBasedShape large;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        long jM2987getSurface0d7_KjU;
        long jM3001contentColorForek8zF_U;
        long j12;
        int i20;
        long scrimColor;
        long jM2976getBackground0d7_KjU;
        int i21;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37;
        ScaffoldState scaffoldState3;
        long jM3001contentColorForek8zF_U2;
        float f3;
        boolean z6;
        boolean z7;
        long j13;
        long j14;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38;
        long j15;
        int i22;
        Modifier modifier4;
        int i23;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1135600301);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scaffold)N(modifier,scaffoldState,topBar,bottomBar,snackbarHost,floatingActionButton,floatingActionButtonPosition:c#material.FabPosition,isFloatingActionButtonDocked,drawerContent,drawerGesturesEnabled,drawerShape,drawerElevation:c#ui.unit.Dp,drawerBackgroundColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerScrimColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)322@16008L496:Scaffold.kt#jmzs0o");
        int i24 = i4 & 1;
        if (i24 != 0) {
            i5 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i4 & 2) == 0) {
                scaffoldStateRememberScaffoldState = scaffoldState;
                int i25 = composerStartRestartGroup.changed(scaffoldStateRememberScaffoldState) ? 32 : 16;
                i5 |= i25;
            } else {
                scaffoldStateRememberScaffoldState = scaffoldState;
            }
            i5 |= i25;
        } else {
            scaffoldStateRememberScaffoldState = scaffoldState;
        }
        int i26 = i4 & 4;
        if (i26 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                lambda$566090785$material = function2;
                i5 |= composerStartRestartGroup.changedInstance(lambda$566090785$material) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    i5 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        lambda$939725476$material = function3;
                        i5 |= composerStartRestartGroup.changedInstance(lambda$939725476$material) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function2M3007getLambda$1341284559$material = function23;
                    } else {
                        function2M3007getLambda$1341284559$material = function23;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function2M3007getLambda$1341284559$material) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        iM3052getEnd5ygKITE = i;
                    } else {
                        iM3052getEnd5ygKITE = i;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(iM3052getEnd5ygKITE) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        z3 = z;
                    } else {
                        z3 = z;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changedInstance(function32) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                            }
                            if ((i3 & 6) != 0) {
                                i15 = i3 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(shape)) ? 4 : 2);
                            } else {
                                i15 = i3;
                            }
                            i16 = i4 & 2048;
                            if (i16 != 0) {
                                if ((i3 & 48) == 0) {
                                    i17 = i16;
                                    i15 |= composerStartRestartGroup.changed(f) ? 32 : 16;
                                }
                                if ((i3 & 384) == 0) {
                                    i18 = i24;
                                    i15 |= ((i4 & 4096) == 0 && composerStartRestartGroup.changed(j)) ? 256 : 128;
                                } else {
                                    i18 = i24;
                                }
                                if ((i3 & 3072) == 0) {
                                    j6 = j2;
                                    i15 |= ((i4 & 8192) == 0 && composerStartRestartGroup.changed(j6)) ? 2048 : 1024;
                                } else {
                                    j6 = j2;
                                }
                                if ((i3 & 24576) == 0) {
                                    i15 |= ((i4 & 16384) == 0 && composerStartRestartGroup.changed(j3)) ? 16384 : 8192;
                                }
                                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i15 |= ((i4 & 32768) == 0 && composerStartRestartGroup.changed(j4)) ? 131072 : 65536;
                                }
                                if ((i3 & 1572864) == 0) {
                                    i15 |= ((i4 & 65536) == 0 && composerStartRestartGroup.changed(j5)) ? 1048576 : 524288;
                                }
                                if ((i3 & 12582912) == 0) {
                                    i15 |= composerStartRestartGroup.changedInstance(function33) ? 8388608 : 4194304;
                                }
                                if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "304@15058L23,313@15568L6,315@15683L6,316@15731L38,317@15816L10,318@15871L6,319@15916L32");
                                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i18 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if ((i4 & 2) != 0) {
                                            i5 &= -113;
                                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                        }
                                        if (i26 != 0) {
                                            lambda$566090785$material = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$566090785$material();
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function2M3009getLambda$1624772335$material = i6 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m3009getLambda$1624772335$material() : function22;
                                        if (i7 != 0) {
                                            lambda$939725476$material = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$939725476$material();
                                        }
                                        if (i8 != 0) {
                                            function2M3007getLambda$1341284559$material = ComposableSingletons$ScaffoldKt.INSTANCE.m3007getLambda$1341284559$material();
                                        }
                                        if (i9 != 0) {
                                            iM3052getEnd5ygKITE = FabPosition.INSTANCE.m3052getEnd5ygKITE();
                                        }
                                        if (i10 != 0) {
                                            z3 = false;
                                        }
                                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function39 = i12 != 0 ? null : function32;
                                        boolean z8 = i14 == 0 ? z2 : true;
                                        if ((i4 & 1024) != 0) {
                                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                            i15 &= -15;
                                        } else {
                                            large = shape;
                                        }
                                        int i27 = i15;
                                        float fM3021getElevationD9Ej5fM = i17 != 0 ? DrawerDefaults.INSTANCE.m3021getElevationD9Ej5fM() : f;
                                        if ((i4 & 4096) != 0) {
                                            function27 = function2M3009getLambda$1624772335$material;
                                            i27 &= -897;
                                            function36 = function39;
                                            jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                                        } else {
                                            function27 = function2M3009getLambda$1624772335$material;
                                            function36 = function39;
                                            jM2987getSurface0d7_KjU = j;
                                        }
                                        if ((i4 & 8192) != 0) {
                                            jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i27 >> 6) & 14);
                                            i27 &= -7169;
                                        } else {
                                            jM3001contentColorForek8zF_U = j2;
                                        }
                                        if ((i4 & 16384) != 0) {
                                            j12 = jM2987getSurface0d7_KjU;
                                            i20 = 6;
                                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                            i27 &= -57345;
                                        } else {
                                            j12 = jM2987getSurface0d7_KjU;
                                            i20 = 6;
                                            scrimColor = j3;
                                        }
                                        if ((i4 & 32768) != 0) {
                                            jM2976getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i20).m2976getBackground0d7_KjU();
                                            i21 = (-458753) & i27;
                                        } else {
                                            jM2976getBackground0d7_KjU = j4;
                                            i21 = i27;
                                        }
                                        if ((i4 & 65536) != 0) {
                                            jM3001contentColorForek8zF_U2 = ColorsKt.m3001contentColorForek8zF_U(jM2976getBackground0d7_KjU, composerStartRestartGroup, (i21 >> 15) & 14);
                                            i21 &= -3670017;
                                            ScaffoldState scaffoldState4 = scaffoldStateRememberScaffoldState;
                                            function37 = lambda$939725476$material;
                                            scaffoldState3 = scaffoldState4;
                                        } else {
                                            ScaffoldState scaffoldState5 = scaffoldStateRememberScaffoldState;
                                            function37 = lambda$939725476$material;
                                            scaffoldState3 = scaffoldState5;
                                            jM3001contentColorForek8zF_U2 = j5;
                                        }
                                        f3 = fM3021getElevationD9Ej5fM;
                                        z6 = z3;
                                        z7 = z8;
                                        j13 = j12;
                                        j14 = scrimColor;
                                        function38 = function36;
                                        j15 = jM2976getBackground0d7_KjU;
                                        i22 = i21;
                                        modifier4 = modifier2;
                                        i23 = i5;
                                        function28 = lambda$566090785$material;
                                        function29 = function27;
                                        shape3 = large;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 2) != 0) {
                                            i5 &= -113;
                                        }
                                        if ((i4 & 1024) != 0) {
                                            i15 &= -15;
                                        }
                                        i22 = i15;
                                        if ((i4 & 4096) != 0) {
                                            i22 &= -897;
                                        }
                                        if ((i4 & 8192) != 0) {
                                            i22 &= -7169;
                                        }
                                        if ((i4 & 16384) != 0) {
                                            i22 &= -57345;
                                        }
                                        if ((i4 & 32768) != 0) {
                                            i22 &= -458753;
                                        }
                                        if ((i4 & 65536) != 0) {
                                            i22 &= -3670017;
                                        }
                                        ScaffoldState scaffoldState6 = scaffoldStateRememberScaffoldState;
                                        function37 = lambda$939725476$material;
                                        scaffoldState3 = scaffoldState6;
                                        function38 = function32;
                                        f3 = f;
                                        j13 = j;
                                        j14 = j3;
                                        j15 = j4;
                                        jM3001contentColorForek8zF_U2 = j5;
                                        jM3001contentColorForek8zF_U = j6;
                                        modifier4 = modifier2;
                                        i23 = i5;
                                        z6 = z3;
                                        function28 = lambda$566090785$material;
                                        function29 = function22;
                                        z7 = z2;
                                        shape3 = shape;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1135600301, i23, i22, "androidx.compose.material.Scaffold (Scaffold.kt:321)");
                                    }
                                    int i28 = i22 << 3;
                                    composer2 = composerStartRestartGroup;
                                    m3132Scaffoldu4IkXBM(WindowInsetsKt.m2109WindowInsetsa9UjIt4$default(Dp.m9114constructorimpl(0.0f), 0.0f, 0.0f, 0.0f, 14, null), modifier4, scaffoldState3, function28, function29, function37, function2M3007getLambda$1341284559$material, iM3052getEnd5ygKITE, z6, function38, z7, shape3, f3, j13, jM3001contentColorForek8zF_U, j14, j15, jM3001contentColorForek8zF_U2, function33, composer2, (i23 << 3) & 2147483632, ((i23 >> 27) & 14) | (i28 & 112) | (i28 & 896) | (i28 & 7168) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (i28 & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    scaffoldState2 = scaffoldState3;
                                    function26 = function28;
                                    function24 = function29;
                                    function34 = function37;
                                    function25 = function2M3007getLambda$1341284559$material;
                                    i19 = iM3052getEnd5ygKITE;
                                    z4 = z6;
                                    function35 = function38;
                                    z5 = z7;
                                    shape2 = shape3;
                                    f2 = f3;
                                    j10 = j13;
                                    j11 = jM3001contentColorForek8zF_U;
                                    j7 = j14;
                                    j8 = j15;
                                    j9 = jM3001contentColorForek8zF_U2;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    function24 = function22;
                                    f2 = f;
                                    j7 = j3;
                                    j8 = j4;
                                    j9 = j5;
                                    function34 = lambda$939725476$material;
                                    modifier3 = modifier2;
                                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                                    function25 = function2M3007getLambda$1341284559$material;
                                    i19 = iM3052getEnd5ygKITE;
                                    z4 = z3;
                                    function26 = lambda$566090785$material;
                                    function35 = function32;
                                    z5 = z2;
                                    shape2 = shape;
                                    j10 = j;
                                    j11 = j2;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ScaffoldKt.Scaffold_27mzLpw$lambda$0(modifier3, scaffoldState2, function26, function24, function34, function25, i19, z4, function35, z5, shape2, f2, j10, j11, j7, j8, j9, function33, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i15 |= 48;
                            i17 = i16;
                            if ((i3 & 384) == 0) {
                            }
                            if ((i3 & 3072) == 0) {
                            }
                            if ((i3 & 24576) == 0) {
                            }
                            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            }
                            if ((i3 & 1572864) == 0) {
                            }
                            if ((i3 & 12582912) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i14 = i13;
                        if ((i3 & 6) != 0) {
                        }
                        i16 = i4 & 2048;
                        if (i16 != 0) {
                        }
                        i17 = i16;
                        if ((i3 & 384) == 0) {
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        if ((i3 & 1572864) == 0) {
                        }
                        if ((i3 & 12582912) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    if ((i3 & 6) != 0) {
                    }
                    i16 = i4 & 2048;
                    if (i16 != 0) {
                    }
                    i17 = i16;
                    if ((i3 & 384) == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if ((i3 & 1572864) == 0) {
                    }
                    if ((i3 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                lambda$939725476$material = function3;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                if ((i3 & 6) != 0) {
                }
                i16 = i4 & 2048;
                if (i16 != 0) {
                }
                i17 = i16;
                if ((i3 & 384) == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i3 & 1572864) == 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            lambda$939725476$material = function3;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            if ((i3 & 6) != 0) {
            }
            i16 = i4 & 2048;
            if (i16 != 0) {
            }
            i17 = i16;
            if ((i3 & 384) == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i3 & 1572864) == 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        lambda$566090785$material = function2;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        lambda$939725476$material = function3;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        if ((i3 & 6) != 0) {
        }
        i16 = i4 & 2048;
        if (i16 != 0) {
        }
        i17 = i16;
        if ((i3 & 384) == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i3 & 1572864) == 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i15 & 4793491) == 4793490) ? false : true, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:313:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /* JADX INFO: renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3132Scaffoldu4IkXBM(final WindowInsets windowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        ScaffoldState scaffoldStateRememberScaffoldState;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> lambda$1714259275$material;
        int i8;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M3010getLambda$1836397928$material;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function2M3008getLambda$1406416085$material;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final int i21;
        final long j6;
        final long j7;
        final long j8;
        final long j9;
        final long j10;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final Modifier modifier3;
        final ScaffoldState scaffoldState2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final boolean z3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        final boolean z4;
        final Shape shape2;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        boolean z6;
        CornerBasedShape large;
        float fM3021getElevationD9Ej5fM;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i22;
        Shape shape3;
        long jM2987getSurface0d7_KjU;
        long jM3001contentColorForek8zF_U;
        int i23;
        long scrimColor;
        int i24;
        int i25;
        long jM2976getBackground0d7_KjU;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        long jM3001contentColorForek8zF_U2;
        int i26;
        long j11;
        int i27;
        Shape shape4;
        int i28;
        Shape shape5;
        Shape shape6;
        Composer composerStartRestartGroup = composer.startRestartGroup(50073903);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scaffold)N(contentWindowInsets,modifier,scaffoldState,topBar,bottomBar,snackbarHost,floatingActionButton,floatingActionButtonPosition:c#material.FabPosition,isFloatingActionButtonDocked,drawerContent,drawerGesturesEnabled,drawerShape,drawerElevation:c#ui.unit.Dp,drawerBackgroundColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerScrimColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)197@9490L74,199@9601L1024:Scaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i29 = i4 & 2;
        if (i29 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i4 & 4) == 0) {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                    int i30 = composerStartRestartGroup.changed(scaffoldStateRememberScaffoldState) ? 256 : 128;
                    i5 |= i30;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                i5 |= i30;
            } else {
                scaffoldStateRememberScaffoldState = scaffoldState;
            }
            i6 = i4 & 8;
            int i31 = 1024;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    i5 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        lambda$1714259275$material = function22;
                        i5 |= composerStartRestartGroup.changedInstance(lambda$1714259275$material) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function3M3010getLambda$1836397928$material = function3;
                    } else {
                        function3M3010getLambda$1836397928$material = function3;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function3M3010getLambda$1836397928$material) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function2M3008getLambda$1406416085$material = function23;
                    } else {
                        function2M3008getLambda$1406416085$material = function23;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function2M3008getLambda$1406416085$material) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(i) ? 8388608 : 4194304;
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
                            }
                            i15 = i4 & 1024;
                            if (i15 == 0) {
                                i17 = i3 | 6;
                                i16 = i15;
                            } else if ((i3 & 6) == 0) {
                                i16 = i15;
                                i17 = i3 | (composerStartRestartGroup.changed(z2) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i3;
                            }
                            if ((i3 & 48) == 0) {
                                i17 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                            }
                            int i32 = i17;
                            i18 = i4 & 4096;
                            if (i18 != 0) {
                                i19 = i32;
                                if ((i3 & 384) == 0) {
                                    i19 |= composerStartRestartGroup.changed(f) ? 256 : 128;
                                }
                                if ((i3 & 3072) == 0) {
                                    if ((i4 & 8192) == 0) {
                                        i20 = i18;
                                        if (composerStartRestartGroup.changed(j)) {
                                            i31 = 2048;
                                        }
                                    } else {
                                        i20 = i18;
                                    }
                                    i19 |= i31;
                                } else {
                                    i20 = i18;
                                }
                                int i33 = i20;
                                if ((i3 & 24576) == 0) {
                                    i19 |= ((i4 & 16384) == 0 && composerStartRestartGroup.changed(j2)) ? 16384 : 8192;
                                }
                                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i19 |= ((32768 & i4) == 0 && composerStartRestartGroup.changed(j3)) ? 131072 : 65536;
                                }
                                if ((i3 & 1572864) == 0) {
                                    i19 |= ((i4 & 65536) == 0 && composerStartRestartGroup.changed(j4)) ? 1048576 : 524288;
                                }
                                if ((12582912 & i3) == 0) {
                                    i19 |= ((i4 & 131072) == 0 && composerStartRestartGroup.changed(j5)) ? 8388608 : 4194304;
                                }
                                if ((100663296 & i3) == 0) {
                                    i19 |= composerStartRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "179@8523L23,188@9033L6,190@9148L6,191@9196L38,192@9281L10,193@9336L6,194@9381L32");
                                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i29 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if ((i4 & 4) != 0) {
                                            i5 &= -897;
                                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> lambda$866784315$material = i6 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$866784315$material() : function2;
                                        if (i7 != 0) {
                                            lambda$1714259275$material = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1714259275$material();
                                        }
                                        if (i8 != 0) {
                                            function3M3010getLambda$1836397928$material = ComposableSingletons$ScaffoldKt.INSTANCE.m3010getLambda$1836397928$material();
                                        }
                                        if (i9 != 0) {
                                            function2M3008getLambda$1406416085$material = ComposableSingletons$ScaffoldKt.INSTANCE.m3008getLambda$1406416085$material();
                                        }
                                        int iM3052getEnd5ygKITE = i10 != 0 ? FabPosition.INSTANCE.m3052getEnd5ygKITE() : i;
                                        z5 = i12 != 0 ? false : z;
                                        function36 = i14 != 0 ? null : function32;
                                        z6 = i16 != 0 ? true : z2;
                                        if ((i4 & 2048) != 0) {
                                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                            i19 &= -113;
                                        } else {
                                            large = shape;
                                        }
                                        int i34 = i19;
                                        fM3021getElevationD9Ej5fM = i33 != 0 ? DrawerDefaults.INSTANCE.m3021getElevationD9Ej5fM() : f;
                                        if ((i4 & 8192) != 0) {
                                            function27 = lambda$866784315$material;
                                            i22 = i5;
                                            shape3 = large;
                                            jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                                            i34 &= -7169;
                                        } else {
                                            function27 = lambda$866784315$material;
                                            i22 = i5;
                                            shape3 = large;
                                            jM2987getSurface0d7_KjU = j;
                                        }
                                        if ((i4 & 16384) != 0) {
                                            jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i34 >> 9) & 14);
                                            i34 &= -57345;
                                        } else {
                                            jM3001contentColorForek8zF_U = j2;
                                        }
                                        if ((32768 & i4) != 0) {
                                            i23 = 6;
                                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                            i34 &= -458753;
                                        } else {
                                            i23 = 6;
                                            scrimColor = j3;
                                        }
                                        if ((i4 & 65536) != 0) {
                                            i25 = i34 & (-3670017);
                                            i24 = iM3052getEnd5ygKITE;
                                            jM2976getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i23).m2976getBackground0d7_KjU();
                                        } else {
                                            i24 = iM3052getEnd5ygKITE;
                                            i25 = i34;
                                            jM2976getBackground0d7_KjU = j4;
                                        }
                                        if ((i4 & 131072) != 0) {
                                            function28 = function27;
                                            i26 = i25 & (-29360129);
                                            jM3001contentColorForek8zF_U2 = ColorsKt.m3001contentColorForek8zF_U(jM2976getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 18) & 14);
                                            i28 = i22;
                                            j11 = jM2976getBackground0d7_KjU;
                                            i27 = i24;
                                            shape4 = shape3;
                                        } else {
                                            function28 = function27;
                                            jM3001contentColorForek8zF_U2 = j5;
                                            i26 = i25;
                                            j11 = jM2976getBackground0d7_KjU;
                                            i27 = i24;
                                            shape4 = shape3;
                                            i28 = i22;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 4) != 0) {
                                            i5 &= -897;
                                        }
                                        if ((i4 & 2048) != 0) {
                                            i19 &= -113;
                                        }
                                        int i35 = i19;
                                        if ((i4 & 8192) != 0) {
                                            i35 &= -7169;
                                        }
                                        if ((i4 & 16384) != 0) {
                                            i35 &= -57345;
                                        }
                                        if ((32768 & i4) != 0) {
                                            i35 &= -458753;
                                        }
                                        if ((i4 & 65536) != 0) {
                                            i35 &= -3670017;
                                        }
                                        if ((i4 & 131072) != 0) {
                                            i35 &= -29360129;
                                        }
                                        i27 = i;
                                        z5 = z;
                                        function36 = function32;
                                        z6 = z2;
                                        shape4 = shape;
                                        fM3021getElevationD9Ej5fM = f;
                                        jM3001contentColorForek8zF_U = j2;
                                        scrimColor = j3;
                                        j11 = j4;
                                        jM3001contentColorForek8zF_U2 = j5;
                                        i26 = i35;
                                        i28 = i5;
                                        function28 = function2;
                                        jM2987getSurface0d7_KjU = j;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    final int i36 = i27;
                                    if (ComposerKt.isTraceInProgress()) {
                                        shape5 = shape4;
                                        ComposerKt.traceEventStart(50073903, i28, i26, "androidx.compose.material.Scaffold (Scaffold.kt:196)");
                                    } else {
                                        shape5 = shape4;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 876415481, "CC(remember):Scaffold.kt#9igjgp");
                                    boolean z7 = (i28 & 14) == 4;
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new MutableWindowInsets(windowInsets);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final boolean z8 = z5;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = lambda$1714259275$material;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37 = function3M3010getLambda$1836397928$material;
                                    final ScaffoldState scaffoldState3 = scaffoldStateRememberScaffoldState;
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function2M3008getLambda$1406416085$material;
                                    final long j12 = j11;
                                    final long j13 = jM3001contentColorForek8zF_U2;
                                    Function3 function38 = new Function3() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return ScaffoldKt.Scaffold_u4IkXBM$lambda$1(mutableWindowInsets, windowInsets, j12, j13, z8, i36, function28, function33, function210, function29, function37, scaffoldState3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    };
                                    Function2<? super Composer, ? super Integer, Unit> function211 = function28;
                                    int i37 = i28;
                                    final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1236753028, true, function38, composerStartRestartGroup, 54);
                                    if (function36 != null) {
                                        composerStartRestartGroup.startReplaceGroup(1400257547);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "234@11126L19,224@10668L488");
                                        int i38 = i26 << 9;
                                        Shape shape7 = shape5;
                                        DrawerKt.m3028ModalDrawerGs3lGvM(function36, modifier2, scaffoldStateRememberScaffoldState.getDrawerState(), z6, shape7, fM3021getElevationD9Ej5fM, jM2987getSurface0d7_KjU, jM3001contentColorForek8zF_U, scrimColor, ComposableLambdaKt.rememberComposableLambda(-1888468172, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return ScaffoldKt.Scaffold_u4IkXBM$lambda$2(composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i37 >> 27) & 14) | 805306368 | (i37 & 112) | (i38 & 7168) | (57344 & i38) | (458752 & i38) | (3670016 & i38) | (29360128 & i38) | (i38 & 234881024), 0);
                                        shape6 = shape7;
                                        composer2 = composerStartRestartGroup;
                                        composer2.endReplaceGroup();
                                    } else {
                                        shape6 = shape5;
                                        composer2 = composerStartRestartGroup;
                                        composer2.startReplaceGroup(1400739380);
                                        ComposerKt.sourceInformation(composer2, "237@11178L15");
                                        composableLambdaRememberComposableLambda.invoke(modifier2, composer2, Integer.valueOf(((i37 >> 3) & 14) | 48));
                                        composer2.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function24 = function211;
                                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                                    function26 = function2M3008getLambda$1406416085$material;
                                    f2 = fM3021getElevationD9Ej5fM;
                                    j7 = jM3001contentColorForek8zF_U;
                                    j8 = scrimColor;
                                    j9 = j11;
                                    j10 = jM3001contentColorForek8zF_U2;
                                    shape2 = shape6;
                                    modifier3 = modifier2;
                                    z4 = z6;
                                    boolean z9 = z5;
                                    i21 = i36;
                                    Function2<? super Composer, ? super Integer, Unit> function212 = lambda$1714259275$material;
                                    z3 = z9;
                                    long j14 = jM2987getSurface0d7_KjU;
                                    function25 = function212;
                                    function34 = function3M3010getLambda$1836397928$material;
                                    function35 = function36;
                                    j6 = j14;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    function24 = function2;
                                    i21 = i;
                                    j6 = j;
                                    j7 = j2;
                                    j8 = j3;
                                    j9 = j4;
                                    j10 = j5;
                                    function25 = lambda$1714259275$material;
                                    function34 = function3M3010getLambda$1836397928$material;
                                    modifier3 = modifier2;
                                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                                    function26 = function2M3008getLambda$1406416085$material;
                                    z3 = z;
                                    function35 = function32;
                                    z4 = z2;
                                    shape2 = shape;
                                    f2 = f;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ScaffoldKt.Scaffold_u4IkXBM$lambda$3(windowInsets, modifier3, scaffoldState2, function24, function25, function34, function26, i21, z3, function35, z4, shape2, f2, j6, j7, j8, j9, j10, function33, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i19 = i32 | 384;
                            if ((i3 & 3072) == 0) {
                            }
                            int i332 = i20;
                            if ((i3 & 24576) == 0) {
                            }
                            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            }
                            if ((i3 & 1572864) == 0) {
                            }
                            if ((12582912 & i3) == 0) {
                            }
                            if ((100663296 & i3) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i14 = i13;
                        i15 = i4 & 1024;
                        if (i15 == 0) {
                        }
                        if ((i3 & 48) == 0) {
                        }
                        int i322 = i17;
                        i18 = i4 & 4096;
                        if (i18 != 0) {
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        int i3322 = i20;
                        if ((i3 & 24576) == 0) {
                        }
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        if ((i3 & 1572864) == 0) {
                        }
                        if ((12582912 & i3) == 0) {
                        }
                        if ((100663296 & i3) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 == 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i3222 = i17;
                    i18 = i4 & 4096;
                    if (i18 != 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    int i33222 = i20;
                    if ((i3 & 24576) == 0) {
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if ((i3 & 1572864) == 0) {
                    }
                    if ((12582912 & i3) == 0) {
                    }
                    if ((100663296 & i3) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                lambda$1714259275$material = function22;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 == 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i32222 = i17;
                i18 = i4 & 4096;
                if (i18 != 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                int i332222 = i20;
                if ((i3 & 24576) == 0) {
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i3 & 1572864) == 0) {
                }
                if ((12582912 & i3) == 0) {
                }
                if ((100663296 & i3) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            lambda$1714259275$material = function22;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 == 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i322222 = i17;
            i18 = i4 & 4096;
            if (i18 != 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            int i3322222 = i20;
            if ((i3 & 24576) == 0) {
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i3 & 1572864) == 0) {
            }
            if ((12582912 & i3) == 0) {
            }
            if ((100663296 & i3) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i6 = i4 & 8;
        int i312 = 1024;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        lambda$1714259275$material = function22;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 == 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i3222222 = i17;
        i18 = i4 & 4096;
        if (i18 != 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        int i33222222 = i20;
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i3 & 1572864) == 0) {
        }
        if ((12582912 & i3) == 0) {
        }
        if ((100663296 & i3) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i19 & 38347923) == 38347922) ? false : true, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    private static final void m3133ScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(675142332);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayout)N(isFabDocked,fabPosition:c#material.FabPosition,topBar,content,snackbar,fab,contentWindowInsets,bottomBar)382@18230L626,398@18879L6945,398@18862L6962:Scaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            function32 = function3;
            i3 |= composerStartRestartGroup.changedInstance(function32) ? 2048 : 1024;
        } else {
            function32 = function3;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            function25 = function23;
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function23;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(675142332, i3, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:377)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 271741614, "CC(remember):Scaffold.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 271768701, "CC(remember):Scaffold.kt#9igjgp");
            boolean z2 = ((i3 & 7168) == 2048) | ((i3 & 896) == 256) | ((57344 & i3) == 16384) | ((3670016 & i3) == 1048576) | ((458752 & i3) == 131072) | ((i3 & 112) == 32) | ((i3 & 14) == 4) | ((29360128 & i3) == 8388608);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function32;
                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                i4 = 0;
                Function2 function27 = new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0(function2, function22, function26, i, z, windowInsets, scaffoldKt$ScaffoldLayout$contentPadding$1$1, function24, function33, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function27);
                objRememberedValue2 = function27;
            } else {
                i4 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue2, composerStartRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$2(z, i, function2, function3, function22, function23, windowInsets, function24, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03da A[LOOP:4: B:143:0x03d8->B:144:0x03da, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b7 A[LOOP:3: B:98:0x02b5->B:99:0x02b7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MeasureResult ScaffoldLayout_i1QSOvI$lambda$1$0(Function2 function2, Function2 function22, Function2 function23, int i, boolean z, WindowInsets windowInsets, final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1, final Function2 function24, final Function3 function3, SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        Object obj;
        Object obj2;
        ArrayList arrayList;
        final FabPlacement fabPlacement;
        int size;
        int i2;
        final ArrayList arrayList2;
        Object obj3;
        Integer numValueOf;
        int size2;
        int i3;
        int iIntValue;
        int height;
        Object obj4;
        Object obj5;
        int i4;
        int i5;
        int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(constraints.getValue());
        final int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(constraints.getValue());
        long jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 10, null);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2);
        ArrayList arrayList3 = new ArrayList(listSubcompose.size());
        int size3 = listSubcompose.size();
        for (int i6 = 0; i6 < size3; i6++) {
            arrayList3.add(listSubcompose.get(i6).mo7769measureBRTryo0(jM9057copyZbe2FdA$default));
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList4.get(0);
            int height2 = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex) {
                int i7 = 1;
                while (true) {
                    Object obj6 = arrayList4.get(i7);
                    int height3 = ((Placeable) obj6).getHeight();
                    if (height2 < height3) {
                        height2 = height3;
                        obj = obj6;
                    }
                    if (i7 == lastIndex) {
                        break;
                    }
                    i7++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        final int height4 = placeable != null ? placeable.getHeight() : 0;
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22);
        ArrayList arrayList5 = new ArrayList(listSubcompose2.size());
        int size4 = listSubcompose2.size();
        int i8 = 0;
        while (i8 < size4) {
            int i9 = iM9067getMaxWidthimpl;
            Measurable measurable = listSubcompose2.get(i8);
            List<Measurable> list = listSubcompose2;
            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
            arrayList5.add(measurable.mo7769measureBRTryo0(ConstraintsKt.m9086offsetNN6EwU(jM9057copyZbe2FdA$default, (-windowInsets.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(subcomposeMeasureScope2))));
            i8++;
            listSubcompose2 = list;
            arrayList5 = arrayList5;
            arrayList4 = arrayList4;
            iM9067getMaxWidthimpl = i9;
        }
        int i10 = iM9067getMaxWidthimpl;
        final ArrayList arrayList6 = arrayList4;
        ArrayList arrayList7 = arrayList5;
        if (arrayList7.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = arrayList7.get(0);
            int height5 = ((Placeable) obj2).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList7);
            if (1 <= lastIndex2) {
                Object obj7 = obj2;
                int i11 = height5;
                int i12 = 1;
                while (true) {
                    Object obj8 = arrayList7.get(i12);
                    int height6 = ((Placeable) obj8).getHeight();
                    if (i11 < height6) {
                        obj7 = obj8;
                        i11 = height6;
                    }
                    if (i12 == lastIndex2) {
                        break;
                    }
                    i12++;
                }
                obj2 = obj7;
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        int height7 = placeable2 != null ? placeable2.getHeight() : 0;
        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function23);
        ArrayList arrayList8 = new ArrayList(listSubcompose3.size());
        int i13 = 0;
        for (int size5 = listSubcompose3.size(); i13 < size5; size5 = size5) {
            Measurable measurable2 = listSubcompose3.get(i13);
            List<Measurable> list2 = listSubcompose3;
            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
            arrayList8.add(measurable2.mo7769measureBRTryo0(ConstraintsKt.m9086offsetNN6EwU(jM9057copyZbe2FdA$default, (-windowInsets.getLeft(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(subcomposeMeasureScope3))));
            i13++;
            height7 = height7;
            listSubcompose3 = list2;
            arrayList8 = arrayList8;
        }
        int i14 = height7;
        final ArrayList arrayList9 = arrayList8;
        if (!arrayList9.isEmpty()) {
            if (arrayList9.isEmpty()) {
                obj4 = null;
            } else {
                obj4 = arrayList9.get(0);
                int width = ((Placeable) obj4).getWidth();
                int lastIndex3 = CollectionsKt.getLastIndex(arrayList9);
                if (1 <= lastIndex3) {
                    Object obj9 = obj4;
                    int i15 = width;
                    int i16 = 1;
                    while (true) {
                        Object obj10 = arrayList9.get(i16);
                        Object obj11 = obj9;
                        int width2 = ((Placeable) obj10).getWidth();
                        if (i15 < width2) {
                            i15 = width2;
                            obj9 = obj10;
                        } else {
                            obj9 = obj11;
                        }
                        if (i16 == lastIndex3) {
                            break;
                        }
                        i16++;
                    }
                    obj4 = obj9;
                }
            }
            Placeable placeable3 = (Placeable) obj4;
            int width3 = placeable3 != null ? placeable3.getWidth() : 0;
            if (arrayList9.isEmpty()) {
                arrayList = arrayList7;
                obj5 = null;
            } else {
                obj5 = arrayList9.get(0);
                int height8 = ((Placeable) obj5).getHeight();
                int lastIndex4 = CollectionsKt.getLastIndex(arrayList9);
                if (1 <= lastIndex4) {
                    Object obj12 = obj5;
                    int i17 = height8;
                    int i18 = 1;
                    while (true) {
                        Object obj13 = arrayList9.get(i18);
                        arrayList = arrayList7;
                        int height9 = ((Placeable) obj13).getHeight();
                        if (i17 < height9) {
                            i17 = height9;
                            obj12 = obj13;
                        }
                        if (i18 == lastIndex4) {
                            break;
                        }
                        i18++;
                        arrayList7 = arrayList;
                    }
                    obj5 = obj12;
                } else {
                    arrayList = arrayList7;
                }
            }
            Placeable placeable4 = (Placeable) obj5;
            int height10 = placeable4 != null ? placeable4.getHeight() : 0;
            if (width3 != 0 && height10 != 0) {
                if (!FabPosition.m3047equalsimpl0(i, FabPosition.INSTANCE.m3053getStart5ygKITE())) {
                    if (!FabPosition.m3047equalsimpl0(i, FabPosition.INSTANCE.m3052getEnd5ygKITE())) {
                        i4 = (i10 - width3) / 2;
                    } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                        i5 = subcomposeMeasureScope.mo1618roundToPx0680j_4(FabSpacing);
                        i4 = (i10 - i5) - width3;
                    } else {
                        i4 = subcomposeMeasureScope.mo1618roundToPx0680j_4(FabSpacing);
                    }
                    fabPlacement = new FabPlacement(z, i4, width3, height10);
                } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                    i4 = subcomposeMeasureScope.mo1618roundToPx0680j_4(FabSpacing);
                    fabPlacement = new FabPlacement(z, i4, width3, height10);
                } else {
                    i5 = subcomposeMeasureScope.mo1618roundToPx0680j_4(FabSpacing);
                    i4 = (i10 - i5) - width3;
                    fabPlacement = new FabPlacement(z, i4, width3, height10);
                }
            }
            List<Measurable> listSubcompose4 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-502652347, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj14, Object obj15) {
                    return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0$7(fabPlacement, function24, (Composer) obj14, ((Integer) obj15).intValue());
                }
            }));
            ArrayList arrayList10 = new ArrayList(listSubcompose4.size());
            size = listSubcompose4.size();
            for (i2 = 0; i2 < size; i2++) {
                arrayList10.add(listSubcompose4.get(i2).mo7769measureBRTryo0(jM9057copyZbe2FdA$default));
            }
            arrayList2 = arrayList10;
            if (arrayList2.isEmpty()) {
                obj3 = arrayList2.get(0);
                int height11 = ((Placeable) obj3).getHeight();
                int lastIndex5 = CollectionsKt.getLastIndex(arrayList2);
                if (1 <= lastIndex5) {
                    int i19 = 1;
                    while (true) {
                        Object obj14 = arrayList2.get(i19);
                        int height12 = ((Placeable) obj14).getHeight();
                        if (height11 < height12) {
                            height11 = height12;
                            obj3 = obj14;
                        }
                        if (i19 == lastIndex5) {
                            break;
                        }
                        i19++;
                    }
                }
            } else {
                obj3 = null;
            }
            Placeable placeable5 = (Placeable) obj3;
            final Integer numValueOf2 = placeable5 == null ? Integer.valueOf(placeable5.getHeight()) : null;
            if (fabPlacement == null) {
                if (numValueOf2 == null) {
                    iIntValue = fabPlacement.getHeight() + subcomposeMeasureScope.mo1618roundToPx0680j_4(FabSpacing);
                    height = windowInsets.getBottom(subcomposeMeasureScope);
                } else if (z) {
                    iIntValue = numValueOf2.intValue();
                    height = fabPlacement.getHeight() / 2;
                } else {
                    iIntValue = numValueOf2.intValue() + fabPlacement.getHeight();
                    height = subcomposeMeasureScope.mo1618roundToPx0680j_4(FabSpacing);
                }
                numValueOf = Integer.valueOf(iIntValue + height);
            } else {
                numValueOf = null;
            }
            final int iIntValue2 = i14 == 0 ? i14 + (numValueOf != null ? numValueOf.intValue() : numValueOf2 != null ? numValueOf2.intValue() : windowInsets.getBottom(subcomposeMeasureScope)) : 0;
            PaddingValues paddingValuesAsPaddingValues = WindowInsetsKt.asPaddingValues(windowInsets, subcomposeMeasureScope);
            scaffoldKt$ScaffoldLayout$contentPadding$1$1.setPaddingHolder(PaddingKt.m2033PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), !arrayList6.isEmpty() ? paddingValuesAsPaddingValues.getTop() : Dp.m9114constructorimpl(0.0f), PaddingKt.calculateEndPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), (!arrayList2.isEmpty() || numValueOf2 == null) ? paddingValuesAsPaddingValues.getBottom() : subcomposeMeasureScope.mo1621toDpu2uoSUM(numValueOf2.intValue())));
            int i20 = iM9066getMaxHeightimpl - height4;
            List<Measurable> listSubcompose5 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-574531306, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj15, Object obj16) {
                    return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0$11(function3, scaffoldKt$ScaffoldLayout$contentPadding$1$1, (Composer) obj15, ((Integer) obj16).intValue());
                }
            }));
            ArrayList arrayList11 = new ArrayList(listSubcompose5.size());
            size2 = listSubcompose5.size();
            i3 = 0;
            while (i3 < size2) {
                long j = jM9057copyZbe2FdA$default;
                arrayList11.add(listSubcompose5.get(i3).mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, i20, 7, null)));
                i3++;
                jM9057copyZbe2FdA$default = j;
            }
            final ArrayList arrayList12 = arrayList11;
            final Integer num = numValueOf;
            final ArrayList arrayList13 = arrayList;
            final FabPlacement fabPlacement2 = fabPlacement;
            return MeasureScope.layout$default(subcomposeMeasureScope, i10, iM9066getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj15) {
                    return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0$13(arrayList12, arrayList6, arrayList13, arrayList2, arrayList9, height4, iM9066getMaxHeightimpl, iIntValue2, numValueOf2, fabPlacement2, num, (Placeable.PlacementScope) obj15);
                }
            }, 4, null);
        }
        arrayList = arrayList7;
        fabPlacement = null;
        List<Measurable> listSubcompose42 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-502652347, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj142, Object obj15) {
                return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0$7(fabPlacement, function24, (Composer) obj142, ((Integer) obj15).intValue());
            }
        }));
        ArrayList arrayList102 = new ArrayList(listSubcompose42.size());
        size = listSubcompose42.size();
        while (i2 < size) {
        }
        arrayList2 = arrayList102;
        if (arrayList2.isEmpty()) {
        }
        Placeable placeable52 = (Placeable) obj3;
        if (placeable52 == null) {
        }
        if (fabPlacement == null) {
        }
        if (i14 == 0) {
        }
        PaddingValues paddingValuesAsPaddingValues2 = WindowInsetsKt.asPaddingValues(windowInsets, subcomposeMeasureScope);
        scaffoldKt$ScaffoldLayout$contentPadding$1$1.setPaddingHolder(PaddingKt.m2033PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(paddingValuesAsPaddingValues2, subcomposeMeasureScope.getLayoutDirection()), !arrayList6.isEmpty() ? paddingValuesAsPaddingValues2.getTop() : Dp.m9114constructorimpl(0.0f), PaddingKt.calculateEndPadding(paddingValuesAsPaddingValues2, subcomposeMeasureScope.getLayoutDirection()), (!arrayList2.isEmpty() || numValueOf2 == null) ? paddingValuesAsPaddingValues2.getBottom() : subcomposeMeasureScope.mo1621toDpu2uoSUM(numValueOf2.intValue())));
        int i202 = iM9066getMaxHeightimpl - height4;
        List<Measurable> listSubcompose52 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-574531306, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj15, Object obj16) {
                return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0$11(function3, scaffoldKt$ScaffoldLayout$contentPadding$1$1, (Composer) obj15, ((Integer) obj16).intValue());
            }
        }));
        ArrayList arrayList112 = new ArrayList(listSubcompose52.size());
        size2 = listSubcompose52.size();
        i3 = 0;
        while (i3 < size2) {
        }
        final List arrayList122 = arrayList112;
        final Integer num2 = numValueOf;
        final List arrayList132 = arrayList;
        final FabPlacement fabPlacement22 = fabPlacement;
        return MeasureScope.layout$default(subcomposeMeasureScope, i10, iM9066getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj15) {
                return ScaffoldKt.ScaffoldLayout_i1QSOvI$lambda$1$0$13(arrayList122, arrayList6, arrayList132, arrayList2, arrayList9, height4, iM9066getMaxHeightimpl, iIntValue2, numValueOf2, fabPlacement22, num2, (Placeable.PlacementScope) obj15);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_i1QSOvI$lambda$1$0$11(Function3 function3, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C533@24904L23:Scaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-574531306, i, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:533)");
            }
            function3.invoke(scaffoldKt$ScaffoldLayout$contentPadding$1$1, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_i1QSOvI$lambda$1$0$13(List list, List list2, List list3, List list4, List list5, int i, int i2, int i3, Integer num, FabPlacement fabPlacement, Integer num2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i4), 0, i, 0.0f, 4, null);
        }
        int size2 = list2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list2.get(i5), 0, 0, 0.0f, 4, null);
        }
        int size3 = list3.size();
        for (int i6 = 0; i6 < size3; i6++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i6), 0, i2 - i3, 0.0f, 4, null);
        }
        int size4 = list4.size();
        for (int i7 = 0; i7 < size4; i7++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list4.get(i7), 0, i2 - (num != null ? num.intValue() : 0), 0.0f, 4, null);
        }
        int size5 = list5.size();
        for (int i8 = 0; i8 < size5; i8++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list5.get(i8), fabPlacement != null ? fabPlacement.getLeft() : 0, i2 - (num2 != null ? num2.intValue() : 0), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_i1QSOvI$lambda$1$0$7(FabPlacement fabPlacement, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C474@22460L157:Scaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-502652347, i, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:474)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalFabPlacement.provides(fabPlacement), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ScaffoldLayout_i1QSOvI$lambda$2(boolean z, int i, Function2 function2, Function3 function3, Function2 function22, Function2 function23, WindowInsets windowInsets, Function2 function24, int i2, Composer composer, int i3) {
        m3133ScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Scaffold_27mzLpw$lambda$0(Modifier modifier, ScaffoldState scaffoldState, Function2 function2, Function2 function22, Function3 function3, Function2 function23, int i, boolean z, Function3 function32, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, Function3 function33, int i2, int i3, int i4, Composer composer, int i5) {
        m3131Scaffold27mzLpw(modifier, scaffoldState, function2, function22, function3, function23, i, z, function32, z2, shape, f, j, j2, j3, j4, j5, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit Scaffold_u4IkXBM$lambda$1(final MutableWindowInsets mutableWindowInsets, final WindowInsets windowInsets, long j, long j2, final boolean z, final int i, final Function2 function2, final Function3 function3, final Function2 function22, final Function2 function23, final Function3 function32, final ScaffoldState scaffoldState, Modifier modifier, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "CN(childModifier)202@9742L275,209@10119L496,200@9642L973:Scaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(modifier) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1236753028, i3, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:200)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1186285871, "CC(remember):Scaffold.kt#9igjgp");
            boolean zChanged = composer.changed(mutableWindowInsets) | composer.changed(windowInsets);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScaffoldKt.Scaffold_u4IkXBM$lambda$1$0$0(mutableWindowInsets, windowInsets, (WindowInsets) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceKt.m3172SurfaceFjzlyU(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier, (Function1) objRememberedValue), null, j, j2, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1761194824, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.Scaffold_u4IkXBM$lambda$1$1(z, i, function2, function3, function22, mutableWindowInsets, function23, function32, scaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_u4IkXBM$lambda$1$0$0(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_u4IkXBM$lambda$1$1(boolean z, int i, Function2 function2, Function3 function3, Function2 function22, MutableWindowInsets mutableWindowInsets, Function2 function23, final Function3 function32, final ScaffoldState scaffoldState, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C216@10442L49,210@10137L464:Scaffold.kt#jmzs0o");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1761194824, i2, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:210)");
            }
            m3133ScaffoldLayouti1QSOvI(z, i, function2, function3, ComposableLambdaKt.rememberComposableLambda(545329543, true, new Function2() { // from class: androidx.compose.material.ScaffoldKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.Scaffold_u4IkXBM$lambda$1$1$0(function32, scaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), function22, mutableWindowInsets, function23, composer, 24576);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_u4IkXBM$lambda$1$1$0(Function3 function3, ScaffoldState scaffoldState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C216@10444L45:Scaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(545329543, i, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:216)");
            }
            function3.invoke(scaffoldState.getSnackbarHostState(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit Scaffold_u4IkXBM$lambda$2(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C234@11128L15:Scaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1888468172, i, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:234)");
            }
            function3.invoke(Modifier.INSTANCE, composer, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit Scaffold_u4IkXBM$lambda$3(WindowInsets windowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2 function2, Function2 function22, Function3 function3, Function2 function23, int i, boolean z, Function3 function32, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, Function3 function33, int i2, int i3, int i4, Composer composer, int i5) {
        m3132Scaffoldu4IkXBM(windowInsets, modifier, scaffoldState, function2, function22, function3, function23, i, z, function32, z2, shape, f, j, j2, j3, j4, j5, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1569641925, "C(rememberScaffoldState)N(drawerState,snackbarHostState)71@2876L39,72@2960L32,73@3013L58:Scaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 892373605, "CC(remember):Scaffold.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:73)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 892375327, "CC(remember):Scaffold.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return scaffoldState;
    }
}
